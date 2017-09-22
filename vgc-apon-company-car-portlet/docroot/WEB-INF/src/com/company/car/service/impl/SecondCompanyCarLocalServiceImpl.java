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

package com.company.car.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.audit.trail.model.AuditTrailLog;
import com.audit.trail.service.AuditTrailLogLocalServiceUtil;
import com.company.car.model.SecondCompanyCar;
import com.company.car.service.SecondCompanyCarLocalServiceUtil;
import com.company.car.service.base.SecondCompanyCarLocalServiceBaseImpl;
import com.company.car.util.ActionConstants;
import com.company.car.util.SecondCompanyCarLogEnum;
import com.delegation.model.ApplicantDelegation;
import com.delegation.service.ApplicantDelegationLocalServiceUtil;
import com.delegation.service.ApproverDelegationLocalServiceUtil;
import com.global.management.service.GlobalEmailLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLinkConstants;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetLinkLocalServiceUtil;
import com.vgc.apon.model.SAPUser;
import com.vgc.apon.service.SAPUserLocalServiceUtil;

/**
 * The implementation of the second company car local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.vgc.apon.service.SecondCompanyCarLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Simon Zhang
 * @see com.vgc.apon.service.base.SecondCompanyCarLocalServiceBaseImpl
 * @see com.vgc.apon.service.SecondCompanyCarLocalServiceUtil
 */
public class SecondCompanyCarLocalServiceImpl extends
		SecondCompanyCarLocalServiceBaseImpl {
	private static Log _log = LogFactoryUtil
			.getLog(SecondCompanyCarLocalServiceImpl.class);

	// Save or Update the SecondCompanyCar
	public SecondCompanyCar saveOrUpdateSecondCompanyCar(
			SecondCompanyCar secondCompanyCar, ServiceContext serviceContext)
			throws PortalException, SystemException {
		Date now = new Date();
		long groupId = serviceContext.getScopeGroupId();
		long companyId = serviceContext.getCompanyId();
		ThemeDisplay themeDisplay = serviceContext.getThemeDisplay();
		String userName = themeDisplay.getUser().getFirstName()+" "+ themeDisplay.getUser().getLastName();
		secondCompanyCar.setCompanyId(companyId);
		secondCompanyCar.setGroupId(groupId);
		secondCompanyCar.setUserId(serviceContext.getUserId());
		secondCompanyCar.setUserName(userName);
		secondCompanyCar.setModifiedDate(serviceContext.getCreateDate(now));
		// workflow field
		secondCompanyCar.setStatus(WorkflowConstants.STATUS_DRAFT);
		secondCompanyCar.setStatusByUserId(serviceContext.getUserId());
		secondCompanyCar.setStatusByUserName(userName);
		secondCompanyCar.setStatusDate(serviceContext.getModifiedDate(now));
		secondCompanyCar = secondCompanyCarPersistence.update(secondCompanyCar);
		return secondCompanyCar;
	}

	// Submit the SecondCompanyCar to start the workflow
	public SecondCompanyCar submitSecondCompanyCar(
			SecondCompanyCar secondCompanyCar, ServiceContext serviceContext)
			throws PortalException, SystemException {
		long groupId = serviceContext.getScopeGroupId();
		long companyId = serviceContext.getCompanyId();
		long secondCompanyCarId = secondCompanyCar.getSecondCompanyCarId();
		long userId = serviceContext.getUserId();
		ThemeDisplay themeDisplay = serviceContext.getThemeDisplay();
		String userName = themeDisplay.getUser().getFirstName()+" "+ themeDisplay.getUser().getLastName();
		Date now = new Date();
		secondCompanyCar.setCompanyId(companyId);
		secondCompanyCar.setGroupId(groupId);
		secondCompanyCar.setUserId(serviceContext.getUserId());
		secondCompanyCar.setUserName(userName);
		secondCompanyCar.setModifiedDate(serviceContext.getCreateDate(now));
		// workflow field
		secondCompanyCar.setStatus(WorkflowConstants.STATUS_DRAFT);
		secondCompanyCar.setStatusByUserId(serviceContext.getUserId());
		secondCompanyCar.setStatusByUserName(userName);
		secondCompanyCar.setStatusDate(serviceContext.getModifiedDate(now));
		secondCompanyCar.setSubmittedDate(now);
		secondCompanyCarPersistence.update(secondCompanyCar);

		long staffCode = secondCompanyCar.getStaffCode();
		SAPUser sAPUser =SAPUserLocalServiceUtil.getSapUserByStaffCode(String.valueOf(staffCode));
		long assigneSupervisorUserId = SAPUserLocalServiceUtil.getSupervisorUserIdByStaffCode(String.valueOf(staffCode));
		String roleName = "CC_Admin Reviewer";
		if("6".equals(sAPUser.getEmployeeGroupId())) {
			roleName = "CC_FSE Coordination Within China Reviewer";
		}
		Role supervisorRole = ApproverDelegationLocalServiceUtil.findAgentRoleByP_U(ApproverDelegationLocalServiceUtil.getProcessOfCompanyCarApplication(), assigneSupervisorUserId);
		serviceContext.setAttribute("vgcapon_secondCompanyCar_supervisor", supervisorRole);
		List<Role> adminRoles = ApproverDelegationLocalServiceUtil.findAgentRolesByP_R(ApproverDelegationLocalServiceUtil.getProcessOfCompanyCarApplication(), roleName);
		serviceContext.setAttribute("vgcapon_secondCompanyCar_admin", adminRoles.toArray());
		// Add secondCompanyCar to assetentry
		AssetEntry assetEntry = AssetEntryLocalServiceUtil.updateEntry(userId,
				groupId, secondCompanyCar.getCreateDate(),
				secondCompanyCar.getModifiedDate(),
				SecondCompanyCar.class.getName(), secondCompanyCarId,
				String.valueOf(secondCompanyCarId), 0,
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(), true, null, null, null,
				ContentTypes.TEXT_HTML, secondCompanyCar.getTicketNo(), null,
				null, null, null, 0, 0, null, false);
		AssetLinkLocalServiceUtil.updateLinks(userId, assetEntry.getEntryId(),
				serviceContext.getAssetLinkEntryIds(),
				AssetLinkConstants.TYPE_RELATED);

		Indexer indexer = IndexerRegistryUtil
				.nullSafeGetIndexer(SecondCompanyCar.class);

		indexer.reindex(secondCompanyCar);

		// workflow
		WorkflowHandlerRegistryUtil.startWorkflowInstance(
				secondCompanyCar.getCompanyId(), secondCompanyCar.getGroupId(),
				serviceContext.getUserId(), SecondCompanyCar.class.getName(),
				secondCompanyCar.getPrimaryKey(), secondCompanyCar,
				serviceContext);
		//Send email
		this.submittedSendEmailtoApprover(secondCompanyCar);
		return secondCompanyCar;
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
	
	//Get the related role name according the staffcode
	public String[] getRoleName(long staffCode) {
		String roleName = "CC_Admin Reviewer";
		try {
			SAPUser sAPUser = SAPUserLocalServiceUtil.getSapUserByStaffCode(String.valueOf(staffCode));			
			if("6".equals(sAPUser.getEmployeeGroupId())) {
				roleName = "CC_FSE Coordination Within China Reviewer";
			}			
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return new String[]{roleName};
	}
	
	//Send email to approver
	private void submittedSendEmailtoApprover(SecondCompanyCar secondCompanyCar) throws SystemException {
		String subject = "Company Car Application- "+secondCompanyCar.getTicketNo()+"-Waiting for your Approval";
		String cssContent = this.getCssContent();		
		User supervisor = this.findSupervisorUser(secondCompanyCar);
		String[] supervisorAddresses = ApproverDelegationLocalServiceUtil.findEmailsByP_U(ApproverDelegationLocalServiceUtil.getProcessOfCompanyCarApplication(), supervisor);
		StringBuffer mailbody = new StringBuffer();
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		mailbody.append("<div class='emailTmp'>")
				.append("<p>Dear Approver, </p>")
				.append("<p> <span class='value'>").append(secondCompanyCar.getUserName()).append("</span> submitted a company car application. Please kindly approve, reject or complete it in <a href='")
				.append(PropsUtil.get("vgc.apon.system.href.url")).append("'>APON System</a>.</p>")
				.append("<p>PLEASE DO NOT REPLY to this email, as it is system generated.</p>")
				.append("</div>");
		GlobalEmailLocalServiceUtil.sendEmail(supervisorAddresses, null, subject, cssContent, mailbody.toString(), null);		
	}
	
	//Get the supervisor user from secondCompanyCar
	public User findSupervisorUser(SecondCompanyCar secondCompanyCar) throws SystemException {
		long staffCode = secondCompanyCar.getStaffCode();
		SAPUser sAPUser =SAPUserLocalServiceUtil.getSapUserByStaffCode(String.valueOf(staffCode));					
		User assignUser = UserLocalServiceUtil.fetchUserByFacebookId(secondCompanyCar.getCompanyId(), Integer.valueOf(sAPUser.getSupervisorFgId()));
		return assignUser;
	}
	
	// workflow status
	public SecondCompanyCar updateStatus(long userId, long secondCompanyCarId,
			int status, ServiceContext serviceContext) throws PortalException,
			SystemException {
		User user = userLocalService.getUser(userId);
		SecondCompanyCar secondCompanyCar = getSecondCompanyCar(secondCompanyCarId);
		secondCompanyCar.setStatus(status);
		secondCompanyCar.setStatusByUserId(userId);
		secondCompanyCar.setStatusByUserName(user.getFullName());
		secondCompanyCar.setStatusDate(new Date());
		updateSecondCompanyCar(secondCompanyCar, serviceContext);
		return secondCompanyCar;
	}

	// Get the second company car list according status and userid
	public List<SecondCompanyCar> findByS_U(int status, long userId)
			throws SystemException {
		return secondCompanyCarPersistence.findByS_U(status, userId);
	}
	
	// Save or update the audit trail log for workflow
	public void saveOrUpdateAuditTrailLog(long companyId, long groupId,
			long secondCompanyCarId, String operationUser, String action,
			String operationComment) throws SystemException, PortalException {
		Date now = new Date();
		SecondCompanyCar secondCompanyCar = SecondCompanyCarLocalServiceUtil.fetchSecondCompanyCar(secondCompanyCarId);
		long staffCode = secondCompanyCar.getStaffCode();
		SAPUser sAPUser =SAPUserLocalServiceUtil.getSapUserByStaffCode(String.valueOf(staffCode));			
		String comment = "";
		if(secondCompanyCar.getIsApplicantAgent()) {
			comment = operationUser+" "+LanguageUtil.get(LocaleUtil.getDefault(), "vgc.apon.on.behalf.of")+" "+sAPUser.getFirstName()+" "+sAPUser.getLastName();
		}
		User supervisorUser = UserLocalServiceUtil.fetchUserByFacebookId(companyId, Integer.valueOf(sAPUser.getSupervisorFgId()));	
		String supervisorName = supervisorUser!=null?supervisorUser.getFirstName()+" "+supervisorUser.getLastName():"Guest";
		List<AuditTrailLog> list = AuditTrailLogLocalServiceUtil
				.findAuditTrailByWF_O_O(secondCompanyCarId,
						SecondCompanyCar.class.getName());
		int operationNo = this.getOperationNo(list);
		if (ActionConstants.SUBMIT.equals(action)) {
			String submitComment = "";
			if(secondCompanyCar.getIsApplicantAgent()) {
				ApplicantDelegation applicantDelegation = ApplicantDelegationLocalServiceUtil.fetchByP_S(ApproverDelegationLocalServiceUtil.getProcessOfCompanyCarApplication(), String.valueOf(UserLocalServiceUtil.fetchUserById(secondCompanyCar.getUserId()).getFacebookId()));
				submitComment = "On behalf of "+ApplicantDelegationLocalServiceUtil.getAgentName(applicantDelegation);
			}
			if (list == null || list.size() == 0) {
				for (SecondCompanyCarLogEnum fLogEnum : SecondCompanyCarLogEnum
						.values()) {
					if (fLogEnum.getNumber() == 1) {
						AuditTrailLogLocalServiceUtil.saveAuditTrailLog(
								companyId, groupId, secondCompanyCarId,
								SecondCompanyCar.class.getName(),
								fLogEnum.getNumber(), fLogEnum.getRole(),
								operationUser,
								ActionConstants.STATUS_SUBMITTED, now, submitComment);
					} else {
						String approverUser = "";
						String roleName = "Supervisor";
						String fullRoleName = "CC_Admin Reviewer";
						if (fLogEnum.getNumber() == 99) {
							approverUser = supervisorName;
						} else {
							roleName = "Admin";							
							if("6".equals(sAPUser.getEmployeeGroupId())) {
								roleName = "FSE Coordination Region China";
								fullRoleName = "CC_FSE Coordination Within China Reviewer";
							}
							approverUser = this.getOperationUserByRoleName(
									companyId, fullRoleName);
						}
						AuditTrailLogLocalServiceUtil.saveAuditTrailLog(
								companyId, groupId, secondCompanyCarId,
								SecondCompanyCar.class.getName(),
								fLogEnum.getNumber(), roleName,
								approverUser,
								ActionConstants.STATUS_PENDING_TO_APPROVE,
								null, "");
					}
				}
			} else {
				AuditTrailLogLocalServiceUtil.saveAuditTrailLog(companyId,
						groupId, secondCompanyCarId,
						SecondCompanyCar.class.getName(), operationNo,
						SecondCompanyCarLogEnum.APPLICANT.getRole(),
						operationUser, ActionConstants.STATUS_SUBMITTED, now,
						submitComment);
			}
		} else if (ActionConstants.RECALL.equals(action)) {
			AuditTrailLogLocalServiceUtil.saveAuditTrailLog(companyId, groupId,
					secondCompanyCarId, SecondCompanyCar.class.getName(),
					operationNo, SecondCompanyCarLogEnum.APPLICANT.getRole(),
					operationUser, ActionConstants.STATUS_RECALL, now,
					operationComment);
			AuditTrailLog auditTrailLog = AuditTrailLogLocalServiceUtil.findAuditTrailByWF_C_O_O_O(companyId, secondCompanyCarId, SecondCompanyCar.class.getName(), SecondCompanyCarLogEnum.SUPERVISOR.getNumber());
			if(auditTrailLog==null || (auditTrailLog!=null && !auditTrailLog.getOperationStatus().equals(ActionConstants.STATUS_PENDING_TO_APPROVE))) {
				AuditTrailLogLocalServiceUtil.saveAuditTrailLog(
						companyId, groupId, secondCompanyCarId,
						SecondCompanyCar.class.getName(),
						SecondCompanyCarLogEnum.SUPERVISOR.getNumber(), SecondCompanyCarLogEnum.SUPERVISOR.getRole(),
						supervisorName,
						ActionConstants.STATUS_PENDING_TO_APPROVE, null,
						"");	
			}	
		} else {
			if (ActionConstants.APPROVE.equals(action)) {
				for (AuditTrailLog auditTrailLog : list) {
					if (auditTrailLog.getOperationNo() == SecondCompanyCarLogEnum.SUPERVISOR
							.getNumber()) {
						auditTrailLog.setOperationUser(operationUser);
						auditTrailLog
								.setOperationStatus(ActionConstants.STATUS_APPROVED);
						auditTrailLog.setOperationComment(operationComment);
						auditTrailLog.setOperationNo(operationNo);
						auditTrailLog.setOperationTime(now);
						AuditTrailLogLocalServiceUtil
								.updateAuditTrailLog(auditTrailLog);
						break;
					}
				}
			} else if (ActionConstants.REJECT.equals(action)) {
				AuditTrailLogLocalServiceUtil.saveAuditTrailLog(companyId,
						groupId, secondCompanyCarId,
						SecondCompanyCar.class.getName(), operationNo,
						SecondCompanyCarLogEnum.SUPERVISOR.getRole(),
						operationUser, ActionConstants.STATUS_REJECTED, now,
						operationComment);
			} else if (ActionConstants.COMPLETE.equals(action)
					|| ActionConstants.CANCEL.equals(action)) {
				for (AuditTrailLog auditTrailLog : list) {
					if (auditTrailLog.getOperationNo() == SecondCompanyCarLogEnum.ADMIN
							.getNumber()) {
						auditTrailLog.setOperationUser(operationUser);
						String operationStatus = action
								.equals(ActionConstants.COMPLETE) ? ActionConstants.STATUS_COMPLETED
								: ActionConstants.STATUS_CANCELLED;
						auditTrailLog.setOperationStatus(operationStatus);
						auditTrailLog.setOperationComment(operationComment);
						auditTrailLog.setOperationNo(operationNo);
						auditTrailLog.setOperationTime(now);
						AuditTrailLogLocalServiceUtil
								.updateAuditTrailLog(auditTrailLog);
						break;
					}
				}
			}
		}
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

	// Get the OperationUser from the role name
	public String getOperationUserByRoleName(long companyId, String roleName)
			throws PortalException, SystemException {
		String operationUser = "";
		Role role = RoleLocalServiceUtil.getRole(companyId, roleName);
		List<User> users = UserLocalServiceUtil.getRoleUsers(role.getRoleId());
		for (User user : users) {
			operationUser = operationUser + user.getFirstName() + " " + user.getLastName()
					+ ",";
		}
		if(operationUser.length()>0) {
			return operationUser.substring(0, operationUser.length() - 1);
		}else {
			return "";
		}		
	}
	
	//
	public SecondCompanyCar updateSecondCompanyCar(
			SecondCompanyCar secondCompanyCar, ServiceContext serviceContext)
			throws SystemException, PortalException {
		return super.updateSecondCompanyCar(secondCompanyCar);
	}
	
	//Add a method,return Second DrivingLicenseInformation.
	public String findDrivingLicenseInformation(SecondCompanyCar secondCompanyCar,Locale loc) {
		if(secondCompanyCar.getDrivingLicenseInformation()==0){
			return LanguageUtil.get(loc, "vgc.apon.second.company.car.valid.chinese.drive.license");
		}else if(secondCompanyCar.getDrivingLicenseInformation()==1){
			return LanguageUtil.get(loc, "vgc.apon.second.company.car.private.driver");
		}else if(secondCompanyCar.getDrivingLicenseInformation()==2){
			return LanguageUtil.get(loc, "vgc.apon.second.company.car.chinese.driving.license.not.yet.obtained");
		}else {
			return "";
		}
	}
}