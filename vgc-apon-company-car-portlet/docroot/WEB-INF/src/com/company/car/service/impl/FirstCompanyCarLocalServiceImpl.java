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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.audit.trail.model.AuditTrailLog;
import com.audit.trail.service.AuditTrailLogLocalServiceUtil;
import com.company.car.model.FirstCompanyCar;
import com.company.car.service.FirstCompanyCarLocalServiceUtil;
import com.company.car.service.base.FirstCompanyCarLocalServiceBaseImpl;
import com.company.car.util.ActionConstants;
import com.company.car.util.FirstCompanyCarLogEnum;
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
 * The implementation of the first company car local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.vgc.apon.service.FirstCompanyCarLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Simon Zhang
 * @see com.vgc.apon.service.base.FirstCompanyCarLocalServiceBaseImpl
 * @see com.vgc.apon.service.FirstCompanyCarLocalServiceUtil
 */
public class FirstCompanyCarLocalServiceImpl extends
		FirstCompanyCarLocalServiceBaseImpl {

	private static Log _log = LogFactoryUtil
			.getLog(FirstCompanyCarLocalServiceImpl.class);

	// Save or Update the FirstCompanyCar
	public FirstCompanyCar saveOrUpdateFirstCompanyCar(
			FirstCompanyCar firstCompanyCar, ServiceContext serviceContext)
			throws PortalException, SystemException {
		Date now = new Date();
		long groupId = serviceContext.getScopeGroupId();
		long companyId = serviceContext.getCompanyId();
		ThemeDisplay themeDisplay = serviceContext.getThemeDisplay();
		String userName = themeDisplay.getUser().getFirstName()+" "+ themeDisplay.getUser().getLastName();
		firstCompanyCar.setCompanyId(companyId);
		firstCompanyCar.setGroupId(groupId);
		firstCompanyCar.setUserId(serviceContext.getUserId());
		firstCompanyCar.setUserName(userName);
		firstCompanyCar.setModifiedDate(serviceContext.getCreateDate(now));
		// workflow field
		firstCompanyCar.setStatus(WorkflowConstants.STATUS_DRAFT);
		firstCompanyCar.setStatusByUserId(serviceContext.getUserId());
		firstCompanyCar.setStatusByUserName(userName);
		firstCompanyCar.setStatusDate(serviceContext.getModifiedDate(now));
		firstCompanyCar = firstCompanyCarPersistence.update(firstCompanyCar);
		return firstCompanyCar;
	}

	// Submit the FirstCompanyCar to start the workflow
	public FirstCompanyCar submitFirstCompanyCar(
			FirstCompanyCar firstCompanyCar, ServiceContext serviceContext)
			throws PortalException, SystemException {
		long groupId = serviceContext.getScopeGroupId();
		long companyId = serviceContext.getCompanyId();
		long firstCompanyCarId = firstCompanyCar.getFirstCompanyCarId();
		long userId = serviceContext.getUserId();
		ThemeDisplay themeDisplay = serviceContext.getThemeDisplay();
		String userName = themeDisplay.getUser().getFirstName()+" "+ themeDisplay.getUser().getLastName();
		Date now = new Date();
		firstCompanyCar.setCompanyId(companyId);
		firstCompanyCar.setGroupId(groupId);
		firstCompanyCar.setUserId(serviceContext.getUserId());
		firstCompanyCar.setUserName(userName);
		firstCompanyCar.setModifiedDate(serviceContext.getCreateDate(now));
		// workflow field
		firstCompanyCar.setStatus(WorkflowConstants.STATUS_DRAFT);
		firstCompanyCar.setStatusByUserId(serviceContext.getUserId());
		firstCompanyCar.setStatusByUserName(userName);
		firstCompanyCar.setStatusDate(serviceContext.getModifiedDate(now));
		firstCompanyCar.setSubmittedDate(now);
		firstCompanyCarPersistence.update(firstCompanyCar);
		
		long staffCode = firstCompanyCar.getStaffCode();
		SAPUser sAPUser =SAPUserLocalServiceUtil.getSapUserByStaffCode(String.valueOf(staffCode));
		long assigneSupervisorUserId = SAPUserLocalServiceUtil.getSupervisorUserIdByStaffCode(String.valueOf(staffCode));
		String roleName = "CC_Admin Reviewer";
		if("6".equals(sAPUser.getEmployeeGroupId())) {
			roleName = "CC_FSE Coordination Within China Reviewer";
		}
		Role supervisorRole = ApproverDelegationLocalServiceUtil.findAgentRoleByP_U(ApproverDelegationLocalServiceUtil.getProcessOfCompanyCarApplication(), assigneSupervisorUserId);
		serviceContext.setAttribute("vgcapon_firstCompanyCar_supervisor", supervisorRole);
		List<Role> adminRoles = ApproverDelegationLocalServiceUtil.findAgentRolesByP_R(ApproverDelegationLocalServiceUtil.getProcessOfCompanyCarApplication(), roleName);
		serviceContext.setAttribute("vgcapon_firstCompanyCar_admin", adminRoles.toArray());
		// Add firstCompanyCar to assetentry
		AssetEntry assetEntry = AssetEntryLocalServiceUtil.updateEntry(userId,
				groupId, firstCompanyCar.getCreateDate(),
				firstCompanyCar.getModifiedDate(),
				FirstCompanyCar.class.getName(), firstCompanyCarId,
				String.valueOf(firstCompanyCarId), 0,
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(), true, null, null, null,
				ContentTypes.TEXT_HTML, firstCompanyCar.getTicketNo(), null,
				null, null, null, 0, 0, null, false);
		AssetLinkLocalServiceUtil.updateLinks(userId, assetEntry.getEntryId(),
				serviceContext.getAssetLinkEntryIds(),
				AssetLinkConstants.TYPE_RELATED);

		Indexer indexer = IndexerRegistryUtil
				.nullSafeGetIndexer(FirstCompanyCar.class);

		indexer.reindex(firstCompanyCar);

		// workflow
		WorkflowHandlerRegistryUtil.startWorkflowInstance(
				firstCompanyCar.getCompanyId(), firstCompanyCar.getGroupId(),
				serviceContext.getUserId(), FirstCompanyCar.class.getName(),
				firstCompanyCar.getPrimaryKey(), firstCompanyCar,
				serviceContext);	
		//Send email
		this.submittedSendEmailtoApprover(firstCompanyCar);
		return firstCompanyCar;
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
	private void submittedSendEmailtoApprover(FirstCompanyCar firstCompanyCar) throws SystemException {
		String subject = "Company Car Application- "+firstCompanyCar.getTicketNo()+"-Waiting for your Approval";
		String cssContent = this.getCssContent();		
		User supervisor = this.findSupervisorUser(firstCompanyCar);		
		String[] supervisorAddresses = ApproverDelegationLocalServiceUtil.findEmailsByP_U(ApproverDelegationLocalServiceUtil.getProcessOfCompanyCarApplication(), supervisor);		
		StringBuffer mailbody = new StringBuffer();
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		mailbody.append("<div class='emailTmp'>")
				.append("<p>Dear Approver, </p>")
				.append("<p> <span class='value'>").append(firstCompanyCar.getUserName()).append("</span> submitted a company car application. Please kindly approve, reject or complete it in <a href='")
				.append(PropsUtil.get("vgc.apon.system.href.url")).append("'>APON System</a>.</p>")
				.append("PLEASE DO NOT REPLY to this email, as it is system generated.</p>")
				.append("</div>");
		GlobalEmailLocalServiceUtil.sendEmail(supervisorAddresses, null, subject, cssContent, mailbody.toString(), null);		
	}
	
	//Get the supervisor user from firstCompanyCar
	public User findSupervisorUser(FirstCompanyCar firstCompanyCar) throws SystemException {
		long staffCode = firstCompanyCar.getStaffCode();
		SAPUser sAPUser =SAPUserLocalServiceUtil.getSapUserByStaffCode(String.valueOf(staffCode));					
		User assignUser = UserLocalServiceUtil.fetchUserByFacebookId(firstCompanyCar.getCompanyId(), Integer.valueOf(sAPUser.getSupervisorFgId()));
		return assignUser;
	}

	// workflow status
	public FirstCompanyCar updateStatus(long userId, long firstCompanyCarId,
			int status, ServiceContext serviceContext) throws PortalException,
			SystemException {
		User user = userLocalService.getUser(userId);
		FirstCompanyCar firstCompanyCar = getFirstCompanyCar(firstCompanyCarId);
		firstCompanyCar.setStatus(status);
		firstCompanyCar.setStatusByUserId(userId);
		firstCompanyCar.setStatusByUserName(user.getFullName());
		firstCompanyCar.setStatusDate(new Date());
		updateFirstCompanyCar(firstCompanyCar, serviceContext);
		return firstCompanyCar;
	}

	// Get the first company car list according status and userid
	public List<FirstCompanyCar> findByS_U(int status, long userId)
			throws SystemException {
		return firstCompanyCarPersistence.findByS_U(status, userId);
	}

	// Save or update the audit trail log for workflow
	public void saveOrUpdateAuditTrailLog(long companyId, long groupId,
			long firstCompanyCarId, String operationUser, String action,
			String operationComment) throws SystemException, PortalException {
		Date now = new Date();
		FirstCompanyCar firstCompanyCar = FirstCompanyCarLocalServiceUtil.fetchFirstCompanyCar(firstCompanyCarId);
		long staffCode = firstCompanyCar.getStaffCode();
		SAPUser sAPUser =SAPUserLocalServiceUtil.getSapUserByStaffCode(String.valueOf(staffCode));	
		String comment = "";
		if(firstCompanyCar.getIsApplicantAgent()) {
			comment = operationUser+" "+LanguageUtil.get(LocaleUtil.getDefault(), "vgc.apon.on.behalf.of")+" "+sAPUser.getFirstName()+" "+sAPUser.getLastName();
		}
		User supervisorUser = UserLocalServiceUtil.fetchUserByFacebookId(companyId, Integer.valueOf(sAPUser.getSupervisorFgId()));		
		String supervisorName = supervisorUser!=null?supervisorUser.getFirstName()+" "+supervisorUser.getLastName():"Guest";
		List<AuditTrailLog> list = AuditTrailLogLocalServiceUtil
				.findAuditTrailByWF_O_O(firstCompanyCarId,
						FirstCompanyCar.class.getName());
		int operationNo = this.getOperationNo(list);
		if (ActionConstants.SUBMIT.equals(action)) {
			String submitComment = "";
			if(firstCompanyCar.getIsApplicantAgent()) {
				ApplicantDelegation applicantDelegation = ApplicantDelegationLocalServiceUtil.fetchByP_S(ApproverDelegationLocalServiceUtil.getProcessOfCompanyCarApplication(), String.valueOf(UserLocalServiceUtil.fetchUserById(firstCompanyCar.getUserId()).getFacebookId()));
				submitComment = "On behalf of "+ApplicantDelegationLocalServiceUtil.getAgentName(applicantDelegation);
			}
			if (list == null || list.size() == 0) {
				for (FirstCompanyCarLogEnum fLogEnum : FirstCompanyCarLogEnum
						.values()) {
					if (fLogEnum.getNumber() == 1) {
						AuditTrailLogLocalServiceUtil.saveAuditTrailLog(
								companyId, groupId, firstCompanyCarId,
								FirstCompanyCar.class.getName(),
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
								companyId, groupId, firstCompanyCarId,
								FirstCompanyCar.class.getName(),
								fLogEnum.getNumber(), roleName,
								approverUser,
								ActionConstants.STATUS_PENDING_TO_APPROVE, null,
								"");
					}
				}
			} else {
				AuditTrailLogLocalServiceUtil.saveAuditTrailLog(companyId,
						groupId, firstCompanyCarId,
						FirstCompanyCar.class.getName(), operationNo,
						FirstCompanyCarLogEnum.APPLICANT.getRole(),
						operationUser, ActionConstants.STATUS_SUBMITTED, now,
						submitComment);
			}
		} else if (ActionConstants.RECALL.equals(action)) {
			AuditTrailLogLocalServiceUtil.saveAuditTrailLog(companyId, groupId,
					firstCompanyCarId, FirstCompanyCar.class.getName(),
					operationNo, FirstCompanyCarLogEnum.APPLICANT.getRole(),
					operationUser, ActionConstants.STATUS_RECALL, now,
					operationComment);
			AuditTrailLog auditTrailLog = AuditTrailLogLocalServiceUtil.findAuditTrailByWF_C_O_O_O(companyId, firstCompanyCarId, FirstCompanyCar.class.getName(), FirstCompanyCarLogEnum.SUPERVISOR.getNumber());
			if(auditTrailLog==null || (auditTrailLog!=null && !auditTrailLog.getOperationStatus().equals(ActionConstants.STATUS_PENDING_TO_APPROVE))) {
				AuditTrailLogLocalServiceUtil.saveAuditTrailLog(
						companyId, groupId, firstCompanyCarId,
						FirstCompanyCar.class.getName(),
						FirstCompanyCarLogEnum.SUPERVISOR.getNumber(), FirstCompanyCarLogEnum.SUPERVISOR.getRole(),
						supervisorName,
						ActionConstants.STATUS_PENDING_TO_APPROVE, null,
						"");	
			}			
		} else {
			if (ActionConstants.APPROVE.equals(action)) {
				for (AuditTrailLog auditTrailLog : list) {
					if (auditTrailLog.getOperationNo() == FirstCompanyCarLogEnum.SUPERVISOR
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
						groupId, firstCompanyCarId,
						FirstCompanyCar.class.getName(), operationNo,
						FirstCompanyCarLogEnum.SUPERVISOR.getRole(),
						operationUser, ActionConstants.STATUS_REJECTED, now,
						operationComment);
			} else if (ActionConstants.COMPLETE.equals(action)
					|| ActionConstants.CANCEL.equals(action)) {
				for (AuditTrailLog auditTrailLog : list) {
					if (auditTrailLog.getOperationNo() == FirstCompanyCarLogEnum.ADMIN
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
	public FirstCompanyCar updateFirstCompanyCar(
			FirstCompanyCar firstCompanyCar, ServiceContext serviceContext)
			throws SystemException, PortalException {
		return super.updateFirstCompanyCar(firstCompanyCar);
	}

	//Add a method,return First DrivingLicenseInformation.
	public String findDrivingLicenseInformation(FirstCompanyCar firstCompanyCar,Locale loc) {
		if(firstCompanyCar.getDrivingLicenseInformation()==0){
			return LanguageUtil.get(loc, "vgc.apon.first.company.car.valid.chinese.drive.license");
		}else if(firstCompanyCar.getDrivingLicenseInformation()==1){
			return LanguageUtil.get(loc, "vgc.apon.first.company.car.private.driver");
		}else if(firstCompanyCar.getDrivingLicenseInformation()==2){
			return LanguageUtil.get(loc, "vgc.apon.first.company.car.chinese.driving.license.not.yet.obtained");
		}else {
			return "";
		}
	}
}