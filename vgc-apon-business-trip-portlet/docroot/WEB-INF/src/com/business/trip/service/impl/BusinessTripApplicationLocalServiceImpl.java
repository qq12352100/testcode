/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.business.trip.service.impl;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.audit.trail.model.AuditTrailLog;
import com.audit.trail.service.AuditTrailLogLocalServiceUtil;
import com.business.trip.model.BtExchangeRate;
import com.business.trip.model.BusinessTripApplication;
import com.business.trip.model.BusinessTripReimbursement;
import com.business.trip.service.BtExchangeRateLocalServiceUtil;
import com.business.trip.service.BusinessTripApplicationLocalServiceUtil;
import com.business.trip.service.base.BusinessTripApplicationLocalServiceBaseImpl;
import com.business.trip.util.ActionConstants;
import com.business.trip.util.BusinessTripApplicationLogEnum;
import com.business.trip.util.BusinessTripConstants;
import com.delegation.model.ApplicantDelegation;
import com.delegation.service.ApplicantDelegationLocalServiceUtil;
import com.delegation.service.ApproverDelegationLocalServiceUtil;
import com.global.management.service.GlobalEmailLocalServiceUtil;
import com.global.management.service.GlobalToolLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.kernel.workflow.WorkflowTask;
import com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.model.WorkflowInstanceLink;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.WorkflowInstanceLinkLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLinkConstants;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetLinkLocalServiceUtil;
import com.vgc.apon.model.SAPUser;
import com.vgc.apon.service.SAPUserLocalServiceUtil;

/**
 * The implementation of the business trip application local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.business.trip.service.BusinessTripApplicationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.business.trip.service.base.BusinessTripApplicationLocalServiceBaseImpl
 * @see com.business.trip.service.BusinessTripApplicationLocalServiceUtil
 */
public class BusinessTripApplicationLocalServiceImpl
	extends BusinessTripApplicationLocalServiceBaseImpl {
	private static Log _log = LogFactoryUtil
			.getLog(BusinessTripApplicationLocalServiceImpl.class);

	// Save or Update the BusinessTripApplication
	public BusinessTripApplication saveOrUpdateBusinessTripApplication(
			BusinessTripApplication businessTripApplication, ServiceContext serviceContext)
			throws PortalException, SystemException {
		Date now = new Date();
		long groupId = serviceContext.getScopeGroupId();
		long companyId = serviceContext.getCompanyId();
		ThemeDisplay themeDisplay = serviceContext.getThemeDisplay();
		String userName = themeDisplay.getUser().getFirstName()+" "+ themeDisplay.getUser().getLastName();
		businessTripApplication.setCompanyId(companyId);
		businessTripApplication.setGroupId(groupId);
		businessTripApplication.setUserId(serviceContext.getUserId());
		businessTripApplication.setUserName(userName);
		businessTripApplication.setModifiedDate(serviceContext.getCreateDate(now));
		// workflow field
		businessTripApplication.setStatus(WorkflowConstants.STATUS_DRAFT);
		businessTripApplication.setStatusByUserId(serviceContext.getUserId());
		businessTripApplication.setStatusByUserName(userName);
		businessTripApplication.setStatusDate(serviceContext.getModifiedDate(now));
		businessTripApplication = businessTripApplicationPersistence.update(businessTripApplication);
		return businessTripApplication;
	}

	// Submit the BusinessTripApplication to start the workflow
	public BusinessTripApplication submitBusinessTripApplication(
			BusinessTripApplication businessTripApplication, ServiceContext serviceContext)
			throws PortalException, SystemException {
		long groupId = serviceContext.getScopeGroupId();
		long companyId = serviceContext.getCompanyId();
		long businessTripApplicationId = businessTripApplication.getBusinessTripApplicationId();
		long userId = serviceContext.getUserId();
		ThemeDisplay themeDisplay = serviceContext.getThemeDisplay();
		String userName = themeDisplay.getUser().getFirstName()+" "+ themeDisplay.getUser().getLastName();
		Date now = new Date();
		businessTripApplication.setCompanyId(companyId);
		businessTripApplication.setGroupId(groupId);
		businessTripApplication.setUserId(serviceContext.getUserId());
		businessTripApplication.setUserName(userName);
		businessTripApplication.setModifiedDate(serviceContext.getCreateDate(now));
		// workflow field

		//For special workflow
		String isNormalSubmit = businessTripApplication.getSapStatus()==1 || businessTripApplication.getStatus()==104?"No":"Yes";
		String isNeedCashAdvance = businessTripApplication.getAdvancePayment()!=0?"Yes":"No";
		String isOverCashAdvance = (businessTripApplication.getCurrency().equals("EUR") && businessTripApplication.getAdvancePayment()>10000)
				|| (businessTripApplication.getCurrency().equals("RMB") && businessTripApplication.getAdvancePayment()>80000)?"Yes":"No";		
		
		businessTripApplication.setStatusByUserId(serviceContext.getUserId());
		businessTripApplication.setStatusByUserName(userName);
		businessTripApplication.setStatusDate(serviceContext.getModifiedDate(now));
		businessTripApplication.setSubmittedDate(now);
		
		businessTripApplication.setSapStatus(0);
		businessTripApplicationPersistence.update(businessTripApplication);
		
		String isCrossDepartment = businessTripApplication.getIsCrossDepartment()?"Yes":"No";
		String isNeedEVPApprove = businessTripApplication.getTripType()==1 || btFlightTrainInfoLocalService.isNeedEVPApprove(businessTripApplicationId, PropsUtil.get("vgc.apon.business.trip.application.type"))||
				btHotelInfoLocalService.isNeedEVPApprove(businessTripApplicationId, PropsUtil.get("vgc.apon.business.trip.application.type"))?"Yes":"No";
		
		BtExchangeRate btExchangeRate = BtExchangeRateLocalServiceUtil.fetchByF_S_S("RMB", "EUR", BusinessTripConstants.VALID_STATUS);

		serviceContext.setAttribute("vgcapon_btApplication_isNormalSubmit", isNormalSubmit);
		serviceContext.setAttribute("vgcapon_btApplication_isCrossDepartment", isCrossDepartment);
		serviceContext.setAttribute("vgcapon_btApplication_isNeedEVPApprove", isNeedEVPApprove);
		serviceContext.setAttribute("vgcapon_btApplication_isNeedCashAdvance", isNeedCashAdvance);
		serviceContext.setAttribute("vgcapon_btApplication_isOverCashAdvance", isOverCashAdvance);
		
		long staffCode = businessTripApplication.getStaffCode();		
		long assigneSupervisorUserId = UserLocalServiceUtil.fetchUserByFacebookId(companyId, businessTripApplication.getApproverId()).getUserId();
		Role supervisorRole = ApproverDelegationLocalServiceUtil.findAgentRoleByP_U(ApproverDelegationLocalServiceUtil.getProcessOfBusinessTripApplication(), assigneSupervisorUserId);
		SAPUser sapUser = SAPUserLocalServiceUtil.getSapUserByStaffCode(String.valueOf(staffCode));
		User departmentLeadUser = UserLocalServiceUtil.fetchUserByFacebookId(PortalUtil.getDefaultCompanyId(), Long.valueOf(businessTripApplication.getTargetDepartmentApproverId()));
		long departmentLeadUserId = departmentLeadUser!=null?departmentLeadUser.getUserId():0;
		Role departmentLeadRole = ApproverDelegationLocalServiceUtil.findAgentRoleByP_U(ApproverDelegationLocalServiceUtil.getProcessOfBusinessTripApplication(), departmentLeadUserId);
		//	long evpUserId = UserLocalServiceUtil.fetchUserByFacebookId(PortalUtil.getDefaultCompanyId(), Long.valueOf(sapUser.getDivisionManagerId())).getUserId();
		// approver  & evp 
		long evpUserId=UserLocalServiceUtil.fetchUserByFacebookId(companyId,businessTripApplication.getEvpId()).getUserId();
		Role evpRole = ApproverDelegationLocalServiceUtil.findAgentRoleByP_U(ApproverDelegationLocalServiceUtil.getProcessOfBusinessTripApplication(), evpUserId);
		List<Role> headControllingRoles = ApproverDelegationLocalServiceUtil.findAgentRolesByP_R(ApproverDelegationLocalServiceUtil.getProcessOfBusinessTripApplication(), "BT_Head of Controlling");
		List<Role> accountingRoles = ApproverDelegationLocalServiceUtil.findAgentRolesByP_R(ApproverDelegationLocalServiceUtil.getProcessOfBusinessTripApplication(), "BT_Accounting");
		serviceContext.setAttribute("vgcapon_btApplication_supervisor", supervisorRole);
		serviceContext.setAttribute("vgcapon_btApplication_departmentLead", departmentLeadRole);
		serviceContext.setAttribute("vgcapon_btApplication_evp", evpRole);
		serviceContext.setAttribute("vgcapon_btApplication_headControlling", headControllingRoles.toArray());
		serviceContext.setAttribute("vgcapon_btApplication_accounting", accountingRoles.toArray());
		
		// Add businessTripApplication to assetentry
		AssetEntry assetEntry = AssetEntryLocalServiceUtil.updateEntry(userId,
				groupId, businessTripApplication.getCreateDate(),
				businessTripApplication.getModifiedDate(),
				BusinessTripApplication.class.getName(), businessTripApplicationId,
				String.valueOf(businessTripApplicationId), 0,
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(), true, null, null, null,
				ContentTypes.TEXT_HTML, businessTripApplication.getTicketNo(), null,
				null, null, null, 0, 0, null, false);
		AssetLinkLocalServiceUtil.updateLinks(userId, assetEntry.getEntryId(),
				serviceContext.getAssetLinkEntryIds(),
				AssetLinkConstants.TYPE_RELATED);

		Indexer indexer = IndexerRegistryUtil
				.nullSafeGetIndexer(BusinessTripApplication.class);

		indexer.reindex(businessTripApplication);

		// workflow
		WorkflowInstanceLink w = WorkflowInstanceLinkLocalServiceUtil.fetchWorkflowInstanceLink(companyId, businessTripApplication.getGroupId(), BusinessTripApplication.class.getName(), businessTripApplicationId);
		if("No".equals(isNormalSubmit) && "No".equals(isNeedCashAdvance)) {		
			System.out.println("***************serviceContext.getAttribute(vgcapon_btApplication_isNeedCashAdvance)"+serviceContext.getAttribute("vgcapon_btApplication_isNeedCashAdvance"));
			int end = WorkflowTaskManagerUtil.getWorkflowTaskCount(companyId, false);				
			List<WorkflowTask> list = WorkflowTaskManagerUtil.getWorkflowTasks(companyId, false, 0, end, null);
			for(WorkflowTask wt:list) {
				if(w.getWorkflowInstanceId()==wt.getWorkflowInstanceId()) {
					Map<String, Serializable>	workflowContext = new HashMap<String, Serializable>();
					workflowContext.put(WorkflowConstants.CONTEXT_SERVICE_CONTEXT, serviceContext);
					WorkflowTaskManagerUtil.completeWorkflowTask(
							companyId, themeDisplay.getUserId(),
							wt.getWorkflowTaskId(), "approve", "", workflowContext);
					break;
				}
			}
		}else {			
			if (w != null) {
				WorkflowInstanceLinkLocalServiceUtil.deleteWorkflowInstanceLink(w);
			}
			WorkflowHandlerRegistryUtil.startWorkflowInstance(
					businessTripApplication.getCompanyId(), businessTripApplication.getGroupId(),
					serviceContext.getUserId(), BusinessTripApplication.class.getName(),
					businessTripApplication.getPrimaryKey(), businessTripApplication,
					serviceContext);
		}			
		if("No".equals(isNormalSubmit) && "No".equals(isNeedCashAdvance)) {	
			businessTripApplication.setStatus(WorkflowConstants.STATUS_APPROVED);
		}else if("No".equals(isNormalSubmit) && "Yes".equals(isNeedCashAdvance) && "Yes".equals(isOverCashAdvance)) {			
			businessTripApplication.setStatus(105);
		}else if("No".equals(isNormalSubmit) && "Yes".equals(isNeedCashAdvance) && "No".equals(isOverCashAdvance)) {
			businessTripApplication.setStatus(106);
		}else {
			businessTripApplication.setStatus(101);
		}
		businessTripApplicationPersistence.update(businessTripApplication,serviceContext);
		System.out.println("bussiness trip send email begain ");
		//Send email
		if(isNormalSubmit.equalsIgnoreCase("YES")&&businessTripApplication.getOtherEmails()!=null&&!businessTripApplication.getOtherEmails().equals("")){
			sendEmailToOhters(businessTripApplication);
		}
//		if(!"Yes".equals(completeCmd)){
//			System.out.println("bussiness trip in complete before");
//			sendEmailtoApprover(businessTripApplication);
//			System.out.println("bussiness trip in complete after ");
//		}
		System.out.println("bussiness trip send email end ");
		return businessTripApplication;
	}
	private void sendEmailToOhters(BusinessTripApplication businessTripApplication){
		String otherEmails=businessTripApplication.getOtherEmails();
		String ddName = this.getDDNames(businessTripApplication);
		String subject = "Business Trip Application-"+ddName+"-"+businessTripApplication.getTicketNo()+"-For Your Information";
		String cssContent = this.getCssContent();	
		String[] toAddresses =otherEmails.split(",");
		StringBuffer mailbody = new StringBuffer();
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
		String tripString=businessTripApplication.getTripType()==0?"Domestic Trip":"International Trip";
		mailbody.append("<div class='emailTmp'>")
				.append("<p>Dear Colleague, </p>")
				.append("<p><span class='value'>").append(businessTripApplication.getPrintName()).append("</span> submitted a Business Trip Application on <span class='value'>").append(sdf.format(businessTripApplication.getSubmittedDate())).append("</span>. Please be kindly informed:")
				.append("</p>")
				.append("<p>Travel Type: "+tripString+"</p>")
				.append("<p>Departure Date: "+sdf.format(businessTripApplication.getDepartureDate())+"</p>")
				.append("<p>Return Date: "+sdf.format(businessTripApplication.getReturnDate())+"</p>")
				.append("<p>Purpose of the Trip: "+businessTripApplication.getPurposeOfTheTrip()+"</p>")
				.append("<p>Visit Countries/Cities: "+businessTripApplication.getVisitCountriesCities()+"</p>")
				.append("<p>PLEASE DO NOT REPLY to this email, as it is system generated.</p>")
				.append("</div>");
		
		GlobalEmailLocalServiceUtil.sendEmail(toAddresses, null, subject, cssContent, mailbody.toString(), null);	
	}
	//Send email to approver
	public void sendEmailtoApprover(BusinessTripApplication businessTripApplication) throws SystemException {
		String ddName = this.getDDNames(businessTripApplication);
		String subject = "Business Trip Application-"+ddName+"-"+businessTripApplication.getTicketNo()+"-Waiting for your Approval";
		String cssContent = this.getCssContent();		
		
	    //long supervisorUserId = SAPUserLocalServiceUtil.getSupervisorUserIdByStaffCode(String.valueOf(businessTripApplication.getStaffCode()));	
		//long supervisorUserId=UserLocalServiceUtil.fetchUserByFacebookId(PortalUtil.getDefaultCompanyId(),businessTripApplication.getEvpId()).getUserId();
		
//		long supervisorUserId=UserLocalServiceUtil.fetchUserByFacebookId(PortalUtil.getDefaultCompanyId(),businessTripApplication.getApproverId()).getUserId();
//	
//		User user = UserLocalServiceUtil.fetchUserById(supervisorUserId);
//		String[] toAddresses = ApproverDelegationLocalServiceUtil.findEmailsByP_U(ApproverDelegationLocalServiceUtil.getProcessOfBusinessTripApplication(), user);	
		
		String[] toAddresses = this.findEmailsOfPendingApprover(businessTripApplication);
		
		StringBuffer mailbody = new StringBuffer();
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");		
		mailbody.append("<div class='emailTmp'>")
				.append("<p>Dear Approver, </p>")
				.append("<p><span class='value'>").append(businessTripApplication.getPrintName()).append("</span> submitted a Business Trip Application on<span class='value'>").append(sdf.format(businessTripApplication.getSubmittedDate())).append("</span>. Please kindly approve or reject it in <a href='")
				.append(PropsUtil.get("vgc.apon.system.href.url")).append("'>APON System</a>.</p>")
				.append("<p>PLEASE DO NOT REPLY to this email, as it is system generated.</p>")
				.append("</div>");
		
		if(null!=toAddresses){
			for(String tempAdd : toAddresses){
				System.out.println("In sendEmailtoApprover toAddress: "+tempAdd);
			}
		}
		System.out.println("In sendEmailtoApprover subject: "+subject);
		System.out.println("In sendEmailtoApprover mailBody: "+mailbody);
		
		GlobalEmailLocalServiceUtil.sendEmail(toAddresses, null, subject, cssContent, mailbody.toString(), null);	
		
	}
	
	public String[] findEmailsOfPendingApprover(BusinessTripApplication businessTripApplication) throws SystemException {
		long businessTripApplicationId = businessTripApplication.getBusinessTripApplicationId();
		List<AuditTrailLog> list = AuditTrailLogLocalServiceUtil.findAuditTrailByWF_O_O(businessTripApplicationId,
						BusinessTripApplication.class.getName());
		String pendRole = "";
		for(AuditTrailLog auditTrailLog:list) {
			if(ActionConstants.STATUS_PENDING_TO_APPROVE.equals(auditTrailLog.getOperationStatus())) {
				pendRole = auditTrailLog.getOperationRole();
				break;
			}
		}
		System.out.println("pendRole:"+pendRole);
		String[] toAddresses = null;
		if(BusinessTripApplicationLogEnum.SUPERVISOR.getRole().equals(pendRole)) {
		//	long userId = SAPUserLocalServiceUtil.getSupervisorUserIdByStaffCode(String.valueOf(businessTripApplication.getStaffCode()));	
			long userId = UserLocalServiceUtil.fetchUserByFacebookId(PortalUtil.getDefaultCompanyId(),businessTripApplication.getApproverId()).getUserId();
			User user = UserLocalServiceUtil.fetchUserById(userId);
			toAddresses = ApproverDelegationLocalServiceUtil.findEmailsByP_U(ApproverDelegationLocalServiceUtil.getProcessOfBusinessTripApplication(), user);
		}else if(BusinessTripApplicationLogEnum.DEPARTMENT_LEAD.getRole().equals(pendRole)) {
			long staffCode = businessTripApplication.getTargetDepartmentApproverId();
			User user = UserLocalServiceUtil.fetchUserByFacebookId(PortalUtil.getDefaultCompanyId(), staffCode);
			toAddresses = ApproverDelegationLocalServiceUtil.findEmailsByP_U(ApproverDelegationLocalServiceUtil.getProcessOfBusinessTripApplication(), user);			
		}else if(BusinessTripApplicationLogEnum.EVP.getRole().equals(pendRole)) {
			SAPUser sapUser = SAPUserLocalServiceUtil.getSapUserByStaffCode(String.valueOf(businessTripApplication.getStaffCode()));
			//Long.valueOf(sapUser.getDivisionManagerId())
			long vepId=businessTripApplication.getEvpId();
			User user = UserLocalServiceUtil.fetchUserByFacebookId(PortalUtil.getDefaultCompanyId(),vepId);
			toAddresses = ApproverDelegationLocalServiceUtil.findEmailsByP_U(ApproverDelegationLocalServiceUtil.getProcessOfBusinessTripApplication(), user);	
		}else if(BusinessTripApplicationLogEnum.HEAD_OF_CONTROLLING.getRole().equals(pendRole)) {
			toAddresses = ApproverDelegationLocalServiceUtil.findEmailsByP_R(ApproverDelegationLocalServiceUtil.getProcessOfBusinessTripApplication(), "BT_Head of Controlling");
		}else if(BusinessTripApplicationLogEnum.ACCOUNTING.getRole().equals(pendRole)) {
			toAddresses = ApproverDelegationLocalServiceUtil.findEmailsByP_R(ApproverDelegationLocalServiceUtil.getProcessOfBusinessTripApplication(), "BT_Accounting");			
		}
		
		if(null!=toAddresses){
			for(String tempAdd : toAddresses){
				System.out.println("in findEmailsOfPendingApprover toAddresses: "+tempAdd);
			}
		}
		
		return toAddresses;
	}
	
	// workflow status
	public BusinessTripApplication updateStatus(long userId, long businessTripApplicationId,
			int status, ServiceContext serviceContext) throws PortalException,
			SystemException {
		User user = userLocalService.getUser(userId);
		BusinessTripApplication businessTripApplication = getBusinessTripApplication(businessTripApplicationId);
		businessTripApplication.setStatus(status);
		businessTripApplication.setStatusByUserId(userId);
		businessTripApplication.setStatusByUserName(user.getFullName());
		businessTripApplication.setStatusDate(new Date());
		businessTripApplicationPersistence.update(businessTripApplication, serviceContext);
		return businessTripApplication;
	}

	// Get the first company car list according status and userid
	public List<BusinessTripApplication> findByS_U(int status, long userId)
			throws SystemException {
		return businessTripApplicationPersistence.findByS_U(status, userId);
	}
	
	// Get the first company car list according status and userid
	public List<BusinessTripApplication> findByStatus(int status)
			throws SystemException {
		return businessTripApplicationPersistence.findByStatus(status);
	}

	// Save or update the audit trail log for workflow
	public void saveOrUpdateAuditTrailLog(long companyId, long groupId,
			long businessTripApplicationId,long userId,String operationUser, String action,
			String operationComment) throws SystemException, PortalException {
		Date now = new Date();
		BusinessTripApplication businessTripApplication = BusinessTripApplicationLocalServiceUtil.fetchBusinessTripApplication(businessTripApplicationId);
		long staffCode = businessTripApplication.getStaffCode();
		SAPUser sAPUser =SAPUserLocalServiceUtil.getSapUserByStaffCode(String.valueOf(staffCode));	
		List<AuditTrailLog> list = AuditTrailLogLocalServiceUtil.findAuditTrailByWF_O_O(businessTripApplicationId,
						BusinessTripApplication.class.getName());		
		int operationNo = this.getOperationNo(list);		
		String currentOperationRole = BusinessTripApplicationLogEnum.APPLICANT.getRole();
		String submitComment = "";
		if(businessTripApplication.getIsApplicantAgent()) {
			ApplicantDelegation applicantDelegation = ApplicantDelegationLocalServiceUtil.fetchByP_S(ApproverDelegationLocalServiceUtil.getProcessOfBusinessTripApplication(), String.valueOf(UserLocalServiceUtil.fetchUserById(businessTripApplication.getUserId()).getFacebookId()));
			submitComment = "On behalf of "+ApplicantDelegationLocalServiceUtil.getAgentName(applicantDelegation);
		}
		if (ActionConstants.SUBMIT.equals(action)) {
			AuditTrailLogLocalServiceUtil.saveAuditTrailLog(
					companyId, groupId, businessTripApplicationId,BusinessTripApplication.class.getName(),
					operationNo, BusinessTripApplicationLogEnum.APPLICANT.getRole(),userId,
					operationUser,ActionConstants.STATUS_SUBMITTED, now, submitComment);		
		} else if (ActionConstants.COMPLETE.equals(action)) {
			AuditTrailLogLocalServiceUtil.saveAuditTrailLog(
					companyId, groupId, businessTripApplicationId,BusinessTripApplication.class.getName(),
					operationNo, BusinessTripApplicationLogEnum.APPLICANT.getRole(),userId,
					operationUser,ActionConstants.STATUS_COMPLETED, now, operationComment);		
		} else if (ActionConstants.RECALL.equals(action)) {
			AuditTrailLogLocalServiceUtil.saveAuditTrailLog(companyId, groupId,
					businessTripApplicationId, BusinessTripApplication.class.getName(),
					operationNo, BusinessTripApplicationLogEnum.APPLICANT.getRole(),userId,
					operationUser, ActionConstants.STATUS_RECALL, now,operationComment);		
			currentOperationRole = this.getOperationRole(list);
		} else if (ActionConstants.APPROVE.equals(action)) {				
			AuditTrailLogLocalServiceUtil.saveAuditTrailLog(companyId, groupId,
					businessTripApplicationId, BusinessTripApplication.class.getName(),
					operationNo, this.getOperationRole(list),userId,
					operationUser, ActionConstants.STATUS_APPROVED, now,operationComment);		
			currentOperationRole = this.getOperationRole(list);
		} else if (ActionConstants.REJECT.equals(action)) {
			AuditTrailLogLocalServiceUtil.saveAuditTrailLog(companyId, groupId,
					businessTripApplicationId, BusinessTripApplication.class.getName(),
					operationNo, this.getOperationRole(list),userId,
					operationUser, ActionConstants.STATUS_REJECTED, now,operationComment);		
			currentOperationRole = this.getOperationRole(list);
		}else if (ActionConstants.CANCEL.equals(action)) {
			AuditTrailLogLocalServiceUtil.saveAuditTrailLog(companyId, groupId,
					businessTripApplicationId, BusinessTripApplication.class.getName(),
					operationNo, this.getOperationRole(list),userId,
					operationUser, ActionConstants.STATUS_REFUSE, now,operationComment);		
			currentOperationRole = BusinessTripApplicationLogEnum.ACCOUNTING.getRole();
		}else if (ActionConstants.SUBMIT_TO_CASH_ADVANCE.equals(action)){
			AuditTrailLogLocalServiceUtil.saveAuditTrailLog(
					companyId, groupId, businessTripApplicationId,BusinessTripApplication.class.getName(),
					operationNo, BusinessTripApplicationLogEnum.APPLICANT.getRole(),userId,
					operationUser,ActionConstants.STATUS_SUBMITTED, now, submitComment);	
			currentOperationRole = BusinessTripApplicationLogEnum.EVP.getRole();
		}
		this.savePendingAuditTrailLog(list, businessTripApplication, companyId, groupId,businessTripApplication.getStatus(),action);
	}

	public int getOperationNo(List<AuditTrailLog> list) {
		int operationNo = 0;
		for (AuditTrailLog auditTrailLog : list) {
			if (!auditTrailLog.getOperationStatus().equals(
					ActionConstants.STATUS_PENDING_TO_APPROVE)) {
				operationNo = auditTrailLog.getOperationNo();
			} else {
				break;
			}
		}
		return operationNo+1;
	}
	
	private String getOperationRole(List<AuditTrailLog> list) {
		String operationRole = BusinessTripApplicationLogEnum.APPLICANT.getRole();
		for (AuditTrailLog auditTrailLog : list) {
			if (auditTrailLog.getOperationStatus().equals(ActionConstants.STATUS_PENDING_TO_APPROVE)) {
				operationRole = auditTrailLog.getOperationRole();
				break;
			}
		}
		return operationRole;
	}
	private String getOperationNameForPending(BusinessTripApplication businessTripApplication,String pendRole) throws PortalException, SystemException{
		if(BusinessTripApplicationLogEnum.SUPERVISOR.getRole().equals(pendRole)) {
			long userId = UserLocalServiceUtil.fetchUserByFacebookId(PortalUtil.getDefaultCompanyId(),businessTripApplication.getApproverId()).getUserId();
			User user = UserLocalServiceUtil.fetchUserById(userId);
			return user.getFirstName() + " " + user.getLastName();
		}else if(BusinessTripApplicationLogEnum.DEPARTMENT_LEAD.getRole().equals(pendRole)) {
			long staffCode = businessTripApplication.getTargetDepartmentApproverId();
			User user = UserLocalServiceUtil.fetchUserByFacebookId(PortalUtil.getDefaultCompanyId(), staffCode);
			return user.getFirstName() + " " + user.getLastName();		
		}else if(BusinessTripApplicationLogEnum.EVP.getRole().equals(pendRole)) {
			SAPUser sapUser = SAPUserLocalServiceUtil.getSapUserByStaffCode(String.valueOf(businessTripApplication.getStaffCode()));
			long vepId=businessTripApplication.getEvpId();
			User user = UserLocalServiceUtil.fetchUserByFacebookId(PortalUtil.getDefaultCompanyId(),vepId);
			return user.getFirstName() + " " + user.getLastName();	
		}else if(BusinessTripApplicationLogEnum.APP.getRole().equals(pendRole)) {
			User user = UserLocalServiceUtil.fetchUserById(businessTripApplication.getUserId());
			return user.getFirstName() + " " + user.getLastName();
		}else if(BusinessTripApplicationLogEnum.HEAD_OF_CONTROLLING.getRole().equals(pendRole)) {
			return GlobalToolLocalServiceUtil.getOperationUserByRoleName("BT_Head of Controlling");
		}else if(BusinessTripApplicationLogEnum.ACCOUNTING.getRole().equals(pendRole)) {
			return GlobalToolLocalServiceUtil.getOperationUserByRoleName("BT_Accounting");
		}
		return "";
	}
	//Save the pending logs 
	private void savePendingAuditTrailLog(List<AuditTrailLog> list,BusinessTripApplication businessTripApplication,long companyId, long groupId,int status,String action) throws SystemException, PortalException {
		for (AuditTrailLog auditTrailLog : list) {
			if (auditTrailLog.getOperationStatus().equals(ActionConstants.STATUS_PENDING_TO_APPROVE)) {
				AuditTrailLogLocalServiceUtil.deleteAuditTrailLog(auditTrailLog);
			}
		}
		if (!ActionConstants.COMPLETE.equals(action)) {
			List<BusinessTripApplicationLogEnum> pendEnums = this.getPendingLogList(businessTripApplication,status);
			for(BusinessTripApplicationLogEnum logEnum:pendEnums) {
				String operationUser=getOperationNameForPending(businessTripApplication, logEnum.getRole());
				AuditTrailLogLocalServiceUtil.saveAuditTrailLog(companyId, groupId, businessTripApplication.getBusinessTripApplicationId(),
						BusinessTripApplication.class.getName(),
						logEnum.getNumber(), logEnum.getRole(),operationUser,ActionConstants.STATUS_PENDING_TO_APPROVE, null,"");
			}
		}		
	}		
	
	//Get the Pending to approval role list
	private List<BusinessTripApplicationLogEnum> getPendingLogList(BusinessTripApplication businessTripApplication,int status) throws SystemException {
		List<BusinessTripApplicationLogEnum> list = new ArrayList<BusinessTripApplicationLogEnum>();
		List<BusinessTripApplicationLogEnum> result = new ArrayList<BusinessTripApplicationLogEnum>();
		String isCrossDepartment = businessTripApplication.getIsCrossDepartment()?"Yes":"No";
		String isNeedEVPApprove = businessTripApplication.getTripType()==1 || btFlightTrainInfoLocalService.isNeedEVPApprove(businessTripApplication.getBusinessTripApplicationId(), PropsUtil.get("vgc.apon.business.trip.application.type"))||
				btHotelInfoLocalService.isNeedEVPApprove(businessTripApplication.getBusinessTripApplicationId(), PropsUtil.get("vgc.apon.business.trip.application.type"))?"Yes":"No";
		String isNeedCashAdvance = businessTripApplication.getAdvancePayment()!=0?"Yes":"No";
		BtExchangeRate btExchangeRate = BtExchangeRateLocalServiceUtil.fetchByF_S_S("RMB", "EUR", BusinessTripConstants.VALID_STATUS);
		String isOverCashAdvance = (businessTripApplication.getCurrency().equals("EUR") && businessTripApplication.getAdvancePayment()>10000)
				|| (businessTripApplication.getCurrency().equals("RMB") && businessTripApplication.getAdvancePayment()>80000)?"Yes":"No";
		if(status<=104) {			
			list.add(BusinessTripApplicationLogEnum.SUPERVISOR);
			
			if("Yes".equals(isCrossDepartment)) {			
				list.add(BusinessTripApplicationLogEnum.DEPARTMENT_LEAD);
			}
			if("Yes".equals(isNeedEVPApprove)) {
				list.add(BusinessTripApplicationLogEnum.EVP);
			}	
			list.add(BusinessTripApplicationLogEnum.APP);
		}else {
			if("Yes".equals(isNeedCashAdvance)&&"Yes".equals(isOverCashAdvance)) {
				list.add(BusinessTripApplicationLogEnum.HEAD_OF_CONTROLLING);	
			}
			if("Yes".equals(isNeedCashAdvance)) {
				list.add(BusinessTripApplicationLogEnum.ACCOUNTING);			
			}
		}		
		for(int i=0;i<list.size()&& status!=0 ;i++) {
			BusinessTripApplicationLogEnum logEnum = list.get(i);
			if(logEnum.getNumber()>=status && status!=0) {		
				result.add(logEnum);
			}
		}
		return result;
	}

	// Get the OperationUser from the role name
	public String getOperationUserByRoleName(long companyId, String roleName)
			throws PortalException, SystemException {
		String operationUser = "";
		Role role = RoleLocalServiceUtil.getRole(companyId, roleName);
		List<User> users = UserLocalServiceUtil.getRoleUsers(role.getRoleId());
		for (User user : users) {
			operationUser = operationUser + user.getFirstName() + " " + user.getLastName()+ ",";
		}
		if(operationUser.length()>0) {
			return operationUser.substring(0, operationUser.length() - 1);
		}else {
			return "";
		}		
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> searchBusinessTripApplicationByTicketNo(String TicketNo) 
			throws PortalException, SystemException{
		Map<String, Object>  map = new HashMap<String, Object>();
		//BusinessTripApplication
		DynamicQuery query_validata = DynamicQueryFactoryUtil.forClass(BusinessTripReimbursement.class);		
		Criterion criterion_validata = null;
		criterion_validata = RestrictionsFactoryUtil.eq("bussinessTirpTicketNo", TicketNo);
		criterion_validata = RestrictionsFactoryUtil.and(criterion_validata, 
				RestrictionsFactoryUtil.ne("status",-1));
		criterion_validata = RestrictionsFactoryUtil.and(criterion_validata, 
				RestrictionsFactoryUtil.ne("status",-2));
		criterion_validata = RestrictionsFactoryUtil.and(criterion_validata, 
				RestrictionsFactoryUtil.isNotNull("ticketNo"));
				//isNotEmpty("ticketNo"));
				
		query_validata.add(criterion_validata);
		List<BusinessTripReimbursement> list_validata=dynamicQuery(query_validata);
		if(list_validata.size()>0){
			map.put("message", " The reimbursement has been generated yet");
			map.put("status", "error");
			return map;
		}
		
		DynamicQuery query_cancell = DynamicQueryFactoryUtil.forClass(BusinessTripApplication.class);		
		query_cancell.add(PropertyFactoryUtil.forName("ticketNo").eq(TicketNo));
		//  update by 2016-4-1 wanghai
		Criterion criterion_cancell = null;
		criterion_cancell = RestrictionsFactoryUtil.eq("status",-2);
		query_cancell.add(criterion_cancell);
		List<BusinessTripApplication> list_cancell=dynamicQuery(query_cancell);
		if(list_cancell.size()>0){
			map.put("message", " The trip application has been cancelled");
			map.put("status", "error");
			return map;
		}
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(BusinessTripApplication.class);		
		query.add(PropertyFactoryUtil.forName("ticketNo").eq(TicketNo));
		//  update by 2016-4-1 wanghai
		Criterion criterion = null;
		criterion = RestrictionsFactoryUtil.eq("status", 0);
		criterion = RestrictionsFactoryUtil.or(criterion,
				PropertyFactoryUtil.forName("status").eq(WorkflowConstants.STATUS_ANY));
		query.add(criterion);
		//end
	//	query.add(PropertyFactoryUtil.forName("status").eq(WorkflowConstants.STATUS_APPROVED));
		List<BusinessTripApplication> list=dynamicQuery(query);
		if(list==null||list.size()==0){
			map.put("message", "This application's approval is not finished");
			map.put("status", "error");
			return map;
		}
		map.put("message", "search success");
		map.put("status", "success");
		map.put("businessTripApplication", list.get(0));
		return map;
	}
	@SuppressWarnings("unchecked")
	public BusinessTripApplication getBusinessTripApplicationByTicketNo(String TicketNo) 
			throws PortalException, SystemException{
		
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(BusinessTripApplication.class);		
		query.add(PropertyFactoryUtil.forName("ticketNo").eq(TicketNo));
		//  update by 2016-4-1 wanghai
		Criterion criterion = null;
		criterion = RestrictionsFactoryUtil.eq("status", 0);
		criterion = RestrictionsFactoryUtil.or(criterion,
				PropertyFactoryUtil.forName("status").eq(WorkflowConstants.STATUS_ANY));
		query.add(criterion);
		//end
	//	query.add(PropertyFactoryUtil.forName("status").eq(WorkflowConstants.STATUS_APPROVED));
		List<BusinessTripApplication> list=dynamicQuery(query);
		return list!=null&&list.size()>0?list.get(0):null;	
	}

	//Set the email css content
	public String getCssContent() {
		StringBuffer sb = new StringBuffer();
		sb.append(".emailTmp{padding:10px 5px;line-height:2;margin-bottom:30px;}")
		  .append(".emailTmp .value{background-color:#E4E4E5;}")
		  .append(".emailTmp p a{color:blue;text-decoration:underline;}")
		  .append(".emailTmp p .warning02{text-transform:uppercase;}");
		return sb.toString();
	}	
	
	//Get the ddname for email title
	public String getDDNames(BusinessTripApplication businessTripApplication) {
		String division = businessTripApplication.getDivision();
		String department = businessTripApplication.getDepartment();
		String ddName = Validator.isNotNull(division)&&Validator.isNotNull(department)?division+"/"+department:division;
		if(Validator.isNull(division)) {
			ddName = department;
		}
		return ddName;
	}
	public void updateSAPStatusAsSAPInfo(List<Map<String, Object>> params,
			int sapStatus, ServiceContext serviceContext)
			throws PortalException, SystemException {
		boolean flag = false;
		for (Map<String, Object> param : params) {
			String sapComments = (String) param.get("sapComments");
			String sapDucumentId = (String) param.get("sapDocumentId");
			String businessTripApplicationId = String.valueOf(param
					.get("businessTripApplicationId"));
			String sapCertificateNo= (String)(param.get("sapCertificateNo"));
			String sapCompany = (String) param.get("sapCompany");
			String sapYear = (String) param.get("sapYear");
			System.out.println("********BusinessTripApplicationLocalServiceImpl**************sapCertificateNo : "+sapCertificateNo +",sapYear:"+sapYear);
			BusinessTripApplication businessTripApplication = updateSAPStatus(
					Long.parseLong(businessTripApplicationId), sapStatus,
					serviceContext, sapComments, sapDucumentId,sapCertificateNo,sapCompany,sapYear);
		}
	}

	// sap status
	public BusinessTripApplication updateSAPStatus(
			long businessTripApplicationId, int sapStatus,
			ServiceContext serviceContext, String SAPcomments,
			String SAPducumentId,String sapCertificateNo,String sapCompany,String sapYear) throws PortalException, SystemException {
		BusinessTripApplication businessTripApplication = getBusinessTripApplication(businessTripApplicationId);
		businessTripApplication.setSapStatus(sapStatus);
		if (sapStatus > 0) {
			if(SAPducumentId!=null&&!"".equals(SAPducumentId)){
			businessTripApplication.setSapDocumentId(SAPducumentId);
			}
			if(sapCertificateNo!=null&&!"".equals(sapCertificateNo.trim())){
				businessTripApplication.setSapCertificateNo(sapCertificateNo);
			}
			if(sapCompany!=null&&!"".equals(sapCompany)){
				businessTripApplication.setSapCompany(sapCompany);
			}
			if(sapYear!=null&&!"".equals(sapYear.trim())){
				businessTripApplication.setSapYear(sapYear);
			}
		} else {
			if(SAPcomments!=null&&!"".equals(SAPcomments)){
			businessTripApplication.setSapComments(SAPcomments);
			}
		}
		businessTripApplicationPersistence.update(businessTripApplication,
				serviceContext);
		return businessTripApplication;
	}

	public long findCountByS_U_SAP(int status, String ticketNo,
			String printName, int sapStatus,String startDate, String endDate,String sapDocumentId)
			throws SystemException, ParseException {
		//
		SimpleDateFormat sdf_dmy = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

		DynamicQuery query = DynamicQueryFactoryUtil
				.forClass(BusinessTripApplication.class);

		if (Validator.isNotNull(printName)) {
			query.add(RestrictionsFactoryUtil.ilike("printName", "%"
					+ printName + "%"));
		}
		if (Validator.isNotNull(sapDocumentId)) {
			query.add(RestrictionsFactoryUtil.ilike("sapDocumentId", "%"
					+ sapDocumentId + "%"));
		}
		if (Validator.isNotNull(ticketNo)) {
			query.add(RestrictionsFactoryUtil.ilike("ticketNo", "%" + ticketNo
					+ "%"));
		}
		if (Validator.isNotNull(startDate) && (Validator.isNotNull(endDate))) {
			query.add(RestrictionsFactoryUtil.ge("submittedDate",
					sdf_dmy.parse(startDate+" 00:00:00")));
			query.add(RestrictionsFactoryUtil.le("submittedDate",
					sdf_dmy.parse(endDate+" 23:59:59")));
		}
		query.add(RestrictionsFactoryUtil.eq("status", status));
		if (sapStatus ==1) {
			Criterion criterion = null;
			criterion = RestrictionsFactoryUtil.eq("sapStatus", 1);
			query.add(criterion);
		}else if(sapStatus ==2) {
			Criterion criterion = null;
			criterion = RestrictionsFactoryUtil.eq("sapStatus", 2);
			query.add(criterion);
		}else {
			Criterion criterion = null;
			criterion = RestrictionsFactoryUtil.eq("sapStatus", 0);
			criterion = RestrictionsFactoryUtil.or(criterion,
					RestrictionsFactoryUtil.eq("sapStatus", -1));
			query.add(criterion);
		}
		query.add(RestrictionsFactoryUtil.gt("advancePayment", 0d));
		return dynamicQueryCount(query);
	}

	public List<BusinessTripApplication> findByS_U_SAP(int status,
			String ticketNo, String printName, int sapStatus, String startDate,
			String endDate,String sapDocumentId, int start, int end) throws SystemException,
			ParseException {
		//
		SimpleDateFormat sdf_dmy = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
		DynamicQuery query = DynamicQueryFactoryUtil
				.forClass(BusinessTripApplication.class);

		if (Validator.isNotNull(printName)) {
			query.add(RestrictionsFactoryUtil.ilike("printName", "%"
					+ printName + "%"));
		}
		if (Validator.isNotNull(sapDocumentId)) {
			query.add(RestrictionsFactoryUtil.ilike("sapDocumentId", "%"
					+ sapDocumentId + "%"));
		}
		if (Validator.isNotNull(ticketNo)) {
			query.add(RestrictionsFactoryUtil.ilike("ticketNo", "%" + ticketNo
					+ "%"));
		}
		if (Validator.isNotNull(startDate) && (Validator.isNotNull(endDate))) {
			query.add(RestrictionsFactoryUtil.ge("submittedDate",
					sdf_dmy.parse(startDate+" 00:00:00")));
			query.add(RestrictionsFactoryUtil.le("submittedDate",
					sdf_dmy.parse(endDate+" 23:59:59")));
		}
		query.add(RestrictionsFactoryUtil.eq("status", status));
		if (sapStatus ==1) {
			Criterion criterion = null;
			criterion = RestrictionsFactoryUtil.eq("sapStatus", 1);
			query.add(criterion);
		}else if(sapStatus ==2) {
			Criterion criterion = null;
			criterion = RestrictionsFactoryUtil.eq("sapStatus", 2);
			query.add(criterion);
		}else {
			Criterion criterion = null;
			criterion = RestrictionsFactoryUtil.eq("sapStatus", 0);
			criterion = RestrictionsFactoryUtil.or(criterion,
					RestrictionsFactoryUtil.eq("sapStatus", -1));
			query.add(criterion);
		}
		query.add(RestrictionsFactoryUtil.gt("advancePayment", 0d));
		if (sapStatus < 1) {
			query.addOrder(OrderFactoryUtil.asc("sapStatus"));
		} else {
			query.addOrder(OrderFactoryUtil.desc("sapStatus"));
		}
		query.addOrder(OrderFactoryUtil.desc("submittedDate"));
		query.setLimit(start, end);
		return dynamicQuery(query);
	}
	
	public List<BusinessTripApplication> findByT_P_S_P(String ticketNo,String printName,String staffCode,String personalID,long userId,int start,int end) throws SystemException {
		DynamicQuery query = DynamicQueryFactoryUtil
				.forClass(BusinessTripApplication.class);
		User user = UserLocalServiceUtil.fetchUserById(userId);
		ApplicantDelegation applicantDelegation = ApplicantDelegationLocalServiceUtil.fetchByP_S(ApproverDelegationLocalServiceUtil.getProcessOfBusinessTripReimbursement(), String.valueOf(user.getFacebookId()));
		Date now = new Date();
		boolean isHasAppliantAgent = applicantDelegation!=null && now.after(applicantDelegation.getEffectiveStartDate()) && now.before(applicantDelegation.getEffectiveEndDate())?true:false;
		Junction junction = RestrictionsFactoryUtil.disjunction();
		junction.add(PropertyFactoryUtil.forName("userId").eq(userId));
		if(isHasAppliantAgent) {
			junction.add(PropertyFactoryUtil.forName("userId").eq(applicantDelegation.getUserId()));		
		}		
		query.add(junction);
		if (Validator.isNotNull(ticketNo)) {
			query.add(PropertyFactoryUtil.forName("ticketNo").like(
					"%" + ticketNo + "%"));
		}			
		if (Validator.isNotNull(printName)) {
			query.add(PropertyFactoryUtil.forName("printName").like(
					"%" + printName + "%"));
		}			
		if (Validator.isNotNull(staffCode)) {
			query.add(PropertyFactoryUtil.forName("staffCode").like(
					"%" + staffCode + "%"));
		}			
		if (Validator.isNotNull(personalID)) {
			query.add(PropertyFactoryUtil.forName("personalID").like(
					"%" + personalID + "%"));
		}			
		query.add(PropertyFactoryUtil.forName("status").eq(0));
		query.setLimit(start, end);
		query.addOrder(OrderFactoryUtil.desc("businessTripApplicationId"));
		return dynamicQuery(query);
	}

	public int findCountByT_P_S_P(String ticketNo,String printName,String staffCode,String personalID,long userId) throws SystemException {
		DynamicQuery query = DynamicQueryFactoryUtil
				.forClass(BusinessTripApplication.class);		
		User user = UserLocalServiceUtil.fetchUserById(userId);
		ApplicantDelegation applicantDelegation = ApplicantDelegationLocalServiceUtil.fetchByP_S(ApproverDelegationLocalServiceUtil.getProcessOfBusinessTripReimbursement(), String.valueOf(user.getFacebookId()));
		Date now = new Date();
		boolean isHasAppliantAgent = applicantDelegation!=null && now.after(applicantDelegation.getEffectiveStartDate()) && now.before(applicantDelegation.getEffectiveEndDate())?true:false;
		Junction junction = RestrictionsFactoryUtil.disjunction();
		junction.add(PropertyFactoryUtil.forName("userId").eq(userId));
		if(isHasAppliantAgent) {
			junction.add(PropertyFactoryUtil.forName("userId").eq(applicantDelegation.getUserId()));		
		}		
		query.add(junction);
		if (Validator.isNotNull(ticketNo)) {
			query.add(PropertyFactoryUtil.forName("ticketNo").like(
					"%" + ticketNo + "%"));
		}			
		if (Validator.isNotNull(printName)) {
			query.add(PropertyFactoryUtil.forName("printName").like(
					"%" + printName + "%"));
		}			
		if (Validator.isNotNull(staffCode)) {
			query.add(PropertyFactoryUtil.forName("staffCode").like(
					"%" + staffCode + "%"));
		}			
		if (Validator.isNotNull(personalID)) {
			query.add(PropertyFactoryUtil.forName("personalID").like(
					"%" + personalID + "%"));
		}			
		query.add(PropertyFactoryUtil.forName("status").eq(0));		
		return (int) dynamicQueryCount(query);
	}
	
	public BusinessTripApplication fetchBusinessTripApplicationByTicketNo(String ticketNo) throws SystemException{
		return businessTripApplicationPersistence.fetchByTicketNo(ticketNo);
	}
}