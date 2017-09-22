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

package com.e.closing.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.audit.trail.model.AuditTrailLog;
import com.audit.trail.service.AuditTrailLogLocalServiceUtil;
import com.delegation.model.ApplicantDelegation;
import com.delegation.model.ApproverDelegation;
import com.delegation.service.ApplicantDelegationLocalServiceUtil;
import com.delegation.service.ApproverDelegationLocalServiceUtil;
import com.e.closing.common.ActionConstants;
import com.e.closing.common.EClosingEnum;
import com.e.closing.model.EClosing;
import com.e.closing.model.custom.KaleoInstanceObject;
import com.e.closing.service.EClosingLocalServiceUtil;
import com.e.closing.service.base.EClosingLocalServiceBaseImpl;
import com.e.onboarding.model.Distribution;
import com.e.onboarding.service.DistributionLocalServiceUtil;
import com.global.management.service.GlobalEmailLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
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
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLinkConstants;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetLinkLocalServiceUtil;
import com.vgc.apon.service.SAPUserLocalServiceUtil;

/**
 * The implementation of the e closing local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.e.closing.service.EClosingLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author t.a.jiang
 * @see com.e.closing.service.base.EClosingLocalServiceBaseImpl
 * @see com.e.closing.service.EClosingLocalServiceUtil
 */
@SuppressWarnings("all")
public class EClosingLocalServiceImpl extends EClosingLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.e.closing.service.EClosingLocalServiceUtil} to access the e closing local service.
	 */
	
	private static Log log = LogFactoryUtil.getLog(EClosingLocalServiceImpl.class);
	
	public List<EClosing> findByS_U(int status, long userId) throws SystemException {
		return eClosingPersistence.findByS_U(status, userId);
	}
	public boolean isHasRole(long userId,String roleName) {
		boolean flag = false;
		try {
			List<Role> roles = RoleLocalServiceUtil.getUserRoles(userId);
			for(Role role:roles) {
				if(roleName.trim().equals(role.getName())) {
					flag = true;
					break;
				}
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}		
		return flag;
	}
	public List<EClosing> findViewList(long userId) throws SystemException, PortalException {
//		List<EClosing> resultList = new ArrayList<EClosing>();
//		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(EClosing.class);
//		int[] status = new int[]{0, 1};
//		dynamicQuery.add(PropertyFactoryUtil.forName("status").in(status));
//		resultList = dynamicQuery(dynamicQuery);
//		return resultList;
		List<EClosing> resultList = new ArrayList<EClosing>();
		if(isHasRole(userId, "EC_Organization Department")) {
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(EClosing.class);		
			int[] status = new int[]{0, 1};
			query.add(PropertyFactoryUtil.forName("status").in(status));
			resultList = dynamicQuery(query);
		}
		return resultList;
	}
	
	public EClosing updateStatus(long userId, long eClosingId, int status, ServiceContext serviceContext) throws PortalException, SystemException {
		User user = userLocalService.getUser(userId);
		
		Date date = new Date();
		String userName = user.getFirstName() + " " + user.getLastName();
		
		EClosing eClosing = this.getEClosing(eClosingId);
		eClosing.setStatus(status);
		eClosing.setStatusByUserId(userId);
		eClosing.setStatusByUserName(userName);
		eClosing.setStatusDate(date);
		this.updateEClosing(eClosing);
		return eClosing;
	}
	
	public EClosing saveOrUpdateEClosing(String action, long userId, EClosing eClosing, ServiceContext serviceContext) throws PortalException, SystemException {
		// Delegation
		User user = userLocalService.getUser(userId);
		long operationUserId = user.getUserId();
		String operationUser = user.getFirstName() + " " + user.getLastName();
		if (eClosing.isApplicantAgent()) {
			ApplicantDelegation applicantDelegation = ApplicantDelegationLocalServiceUtil.fetchByP_S(ApproverDelegationLocalServiceUtil.getProcessOfEClosing(), String.valueOf(user.getFacebookId()));
			if (applicantDelegation != null) {
				user = userLocalService.getUser(applicantDelegation.getUserId());
			}
		}
		
		Date date = new Date();
		long createUserId = user.getUserId();
		String createUserName = user.getFirstName() + " " + user.getLastName();
		
		eClosing.setCompanyId(serviceContext.getCompanyId());
		eClosing.setGroupId(serviceContext.getScopeGroupId());
		eClosing.setUserId(createUserId);
		eClosing.setUserName(createUserName);
		if (Validator.isNull(eClosing.getCreateDate())) {
			eClosing.setCreateDate(serviceContext.getCreateDate(date));
		}
		eClosing.setModifiedDate(serviceContext.getModifiedDate(date));
		
		eClosing.setStatus(WorkflowConstants.STATUS_DRAFT);
		eClosing.setStatusByUserId(createUserId);
		eClosing.setStatusByUserName(createUserName);
		eClosing.setStatusDate(serviceContext.getModifiedDate(date));
		
		eClosing = eClosingPersistence.update(eClosing);
		
		// Employee Group Id
		serviceContext.setAttribute("vgcapon_eclosing_employeegroupid", eClosing.getEmployeeGroupId());
		
		// Approver Delegation
		long supervisorUserId = SAPUserLocalServiceUtil.getSupervisorUserIdByStaffCode(String.valueOf(eClosing.getStaffCode()));
		Role supervisorRole = ApproverDelegationLocalServiceUtil.findAgentRoleByP_U(ApproverDelegationLocalServiceUtil.getProcessOfEClosing(), supervisorUserId);
		serviceContext.setAttribute("vgcapon_eclosing_ec_supervisor", supervisorRole);
		
		List<Role> delegationRoles = new ArrayList<Role>();
		delegationRoles = ApproverDelegationLocalServiceUtil.findAgentRolesByP_R(ApproverDelegationLocalServiceUtil.getProcessOfEClosing(), EClosingEnum.ADMINISTRATIONDEPARTMENT.getRole());
		serviceContext.setAttribute("vgcapon_eclosing_ec_administration_department", delegationRoles.toArray());
		
		delegationRoles.clear();
		delegationRoles = ApproverDelegationLocalServiceUtil.findAgentRolesByP_R(ApproverDelegationLocalServiceUtil.getProcessOfEClosing(), EClosingEnum.FLEETSERVICES.getRole() + "-Admin");
		serviceContext.setAttribute("vgcapon_eclosing_ec_fleet_services_admin", delegationRoles.toArray());
		
		delegationRoles.clear();
		delegationRoles = ApproverDelegationLocalServiceUtil.findAgentRolesByP_R(ApproverDelegationLocalServiceUtil.getProcessOfEClosing(), EClosingEnum.FLEETSERVICES.getRole() + "-FSE Coordination");
		serviceContext.setAttribute("vgcapon_eclosing_ec_fleet_services_fse_coordination", delegationRoles.toArray());
		
		delegationRoles.clear();
		delegationRoles = ApproverDelegationLocalServiceUtil.findAgentRolesByP_R(ApproverDelegationLocalServiceUtil.getProcessOfEClosing(), EClosingEnum.FSELECONSULTANT.getRole());
		serviceContext.setAttribute("vgcapon_eclosing_ec_fse_le_consultant", delegationRoles.toArray());
		
		delegationRoles.clear();
		delegationRoles = ApproverDelegationLocalServiceUtil.findAgentRolesByP_R(ApproverDelegationLocalServiceUtil.getProcessOfEClosing(), EClosingEnum.SECURITY.getRole());
		serviceContext.setAttribute("vgcapon_eclosing_ec_security", delegationRoles.toArray());
		
		delegationRoles.clear();
		delegationRoles = ApproverDelegationLocalServiceUtil.findAgentRolesByP_R(ApproverDelegationLocalServiceUtil.getProcessOfEClosing(), EClosingEnum.ITDEPARTMENT.getRole());
		serviceContext.setAttribute("vgcapon_eclosing_ec_it_department", delegationRoles.toArray());
		
		delegationRoles.clear();
		delegationRoles = ApproverDelegationLocalServiceUtil.findAgentRolesByP_R(ApproverDelegationLocalServiceUtil.getProcessOfEClosing(), EClosingEnum.HRTRAININGDEPARTMENT.getRole());
		serviceContext.setAttribute("vgcapon_eclosing_ec_hr_training_department", delegationRoles.toArray());
		
		delegationRoles.clear();
		delegationRoles = ApproverDelegationLocalServiceUtil.findAgentRolesByP_R(ApproverDelegationLocalServiceUtil.getProcessOfEClosing(), EClosingEnum.HRDEPARTMENT.getRole());
		serviceContext.setAttribute("vgcapon_eclosing_ec_hr_department", delegationRoles.toArray());
		
		delegationRoles.clear();
		delegationRoles = ApproverDelegationLocalServiceUtil.findAgentRolesByP_R(ApproverDelegationLocalServiceUtil.getProcessOfEClosing(), EClosingEnum.FINANCEDEPARTMENT.getRole());
		serviceContext.setAttribute("vgcapon_eclosing_ec_finance_department", delegationRoles.toArray());
		
		if (action.equals("1")) {
			AssetEntry assetEntry = AssetEntryLocalServiceUtil.updateEntry(eClosing.getUserId(), eClosing.getGroupId(), eClosing.getCreateDate(), eClosing.getModifiedDate(), EClosing.class.getName(), eClosing.getEclosingId(), String.valueOf(eClosing.getCompanyId()), 0, serviceContext.getAssetCategoryIds(), serviceContext.getAssetTagNames(), true, null, null, null, ContentTypes.TEXT_HTML, eClosing.getTicketNo(), null, null, null, null, 0, 0, null, false);
			AssetLinkLocalServiceUtil.updateLinks(eClosing.getUserId(), assetEntry.getEntryId(), serviceContext.getAssetLinkEntryIds(), AssetLinkConstants.TYPE_RELATED);
			WorkflowHandlerRegistryUtil.startWorkflowInstance(eClosing.getCompanyId(), eClosing.getUserId(), EClosing.class.getName(), eClosing.getEclosingId(), eClosing, serviceContext);
			this.saveOrUpdateAuditTrailLog(serviceContext.getCompanyId(), serviceContext.getScopeGroupId(), eClosing.getEclosingId(), operationUserId, operationUser, ActionConstants.SUBMIT, "", eClosing.getApplicantAgent());
		}else if (action.equals("2")) {
			WorkflowInstanceLink workflowInstanceLink = WorkflowInstanceLinkLocalServiceUtil.fetchWorkflowInstanceLink(eClosing.getCompanyId(), 0, EClosing.class.getName(), eClosing.getEclosingId());
			int workflowTaskCount = WorkflowTaskManagerUtil.getWorkflowTaskCount(eClosing.getCompanyId(), false);
			List<WorkflowTask> workflowTaskList = WorkflowTaskManagerUtil.getWorkflowTasks(eClosing.getCompanyId(), false, 0, workflowTaskCount, null);
			for (WorkflowTask workflowTask : workflowTaskList) {
				if (workflowInstanceLink.getWorkflowInstanceId() == workflowTask.getWorkflowInstanceId()) {
					WorkflowTaskManagerUtil.completeWorkflowTask(eClosing.getCompanyId(), createUserId, workflowTask.getWorkflowTaskId(), "resubmit", "", null);
					this.updateStatus(createUserId, eClosing.getEclosingId(), WorkflowConstants.STATUS_PENDING, serviceContext);
				}
			}
			this.saveOrUpdateAuditTrailLog(serviceContext.getCompanyId(), serviceContext.getScopeGroupId(), eClosing.getEclosingId(), operationUserId, operationUser, ActionConstants.SUBMIT, "", eClosing.getApplicantAgent());
		}
		return eClosing;
	}
	
	public void saveOrUpdateAuditTrailLog(long companyId, long groupId, long eClosingId, long operationUserId, String operationUser, String action, String operationComment, boolean isDelegation) throws SystemException, PortalException {
		Date date = new Date();
		List<String> toAddressesList = new ArrayList<String>();
		List<String> ccAddressesList = new ArrayList<String>();
		User user = userLocalService.getUser(operationUserId);
		List<Role> roleList = user.getRoles();
		List<String> roleNameList = new ArrayList<String>();
		EClosing eClosing = eClosingLocalService.getEClosing(eClosingId);
		long supervisorUserId = SAPUserLocalServiceUtil.getSupervisorUserIdByStaffCode(String.valueOf(eClosing.getStaffCode()));
		boolean isSupervisor = false;
		if (operationUserId == supervisorUserId) {
			isSupervisor = true;
		}
		if (isDelegation) {
			String applicantAgentName = "";
			String approverAgentName = "";
			ApplicantDelegation applicantDelegation = ApplicantDelegationLocalServiceUtil.fetchByP_S(ApproverDelegationLocalServiceUtil.getProcessOfEClosing(), String.valueOf(user.getFacebookId()));
			ApproverDelegation approverDelegation = ApproverDelegationLocalServiceUtil.fetchByP_S(ApproverDelegationLocalServiceUtil.getProcessOfEClosing(), String.valueOf(user.getFacebookId()));
			if (applicantDelegation != null && date.after(applicantDelegation.getEffectiveStartDate()) && date.before(applicantDelegation.getEffectiveEndDate())) {
				applicantAgentName = ApplicantDelegationLocalServiceUtil.getAgentName(applicantDelegation);
				User applicantDelegationUser = userLocalService.fetchUserByFacebookId(companyId, Long.parseLong(applicantDelegation.getStaffCode()));
				ccAddressesList.add(applicantDelegationUser.getEmailAddress());
			}
			if (approverDelegation != null && date.after(approverDelegation.getEffectiveStartDate()) && date.before(approverDelegation.getEffectiveEndDate())) {
				approverAgentName = ApproverDelegationLocalServiceUtil.getAgentName(approverDelegation);
				User approverDelegationUser = userLocalService.fetchUserByFacebookId(companyId, Long.parseLong(approverDelegation.getStaffCode()));
				ccAddressesList.add(approverDelegationUser.getEmailAddress());
				// Supervisor
				User tempUser = UserLocalServiceUtil.fetchUser(approverDelegation.getUserId());
				if(tempUser.getUserId() == supervisorUserId){
					isSupervisor = true;
				}
				// Role
				List<Role> tempRoleList = tempUser.getRoles();
				for (Role role : tempRoleList) {
					roleNameList.add(role.getName());
				}
			}
			if (action.equals(ActionConstants.SUBMIT)) {
				if (!applicantAgentName.equals("")) {
					operationUser = operationUser + "<br/>(" + PropsUtil.get("vgc.apon.e.closing.on.behalf.of") + " " + applicantAgentName + ")";
				}
			}else if (action.equals(ActionConstants.APPROVE) || action.equals(ActionConstants.COMPLETE)) {
				if (!approverAgentName.equals("")) {
					operationUser = operationUser + "<br/>(" + PropsUtil.get("vgc.apon.e.closing.approve.deputy.of") + " " + approverAgentName + ")";
				}
			}
		}
		List<AuditTrailLog> auditTrailLogList = AuditTrailLogLocalServiceUtil.findAuditTrailByWF_O_O(eClosingId, EClosing.class.getName());
		if (auditTrailLogList != null && auditTrailLogList.size() > 0) {
			if (action.equals(ActionConstants.APPROVE) || action.equals(ActionConstants.COMPLETE)) {
				for (int i = 0, n = auditTrailLogList.size(); i < n; i++) {
					AuditTrailLog auditTrailLog = auditTrailLogList.get(i);
					for (Role role : roleList) {
						roleNameList.add(role.getName());
					}
					String roleName = auditTrailLog.getOperationRole();
					if (roleName.equals(EClosingEnum.FLEETSERVICES.getRole())) {
						roleName = auditTrailLog.getOperationRole() + "-Admin";
						if (eClosing.getEmployeeGroupId().equals("6")) {
							roleName = auditTrailLog.getOperationRole() + "-FSE Coordination";
						}
					}
					if ((isSupervisor || roleNameList.contains(roleName)) && auditTrailLog.getOperationStatus().equals(ActionConstants.STATUS_PENDING_TO_APPROVE)) {
						auditTrailLog.setOperationStatus(ActionConstants.STATUS_COMPLETED);
						auditTrailLog.setOperationUserId(operationUserId);
						auditTrailLog.setOperationUser(operationUser);
						auditTrailLog.setOperationTime(date);
						auditTrailLog.setOperationComment(operationComment);
						AuditTrailLogLocalServiceUtil.updateAuditTrailLog(auditTrailLog);
						break;
					}
				}
				for (int i = 0, n = auditTrailLogList.size(); i < n; i++) {
					AuditTrailLog auditTrailLog = auditTrailLogList.get(i);
					if (auditTrailLog.getOperationStatus().equals(ActionConstants.STATUS_SUBMITTED)) {
						toAddressesList.addAll(this.getEmailAddress(auditTrailLog.getOperationUserId(), 0, ""));
					}
				}
				// Send Completed  Email
				if (eClosing.getStatus() == WorkflowConstants.STATUS_APPROVED) {
					this.sendMail(eClosingId, "3", toAddressesList, ccAddressesList);
				}
			}else if (action.equals(ActionConstants.RECALL) || action.equals(ActionConstants.REJECT)) {
				int operationNo = auditTrailLogList.size() + 1;
				String operationRole = "";
				String operationStatus = "";
				for (int i = 0, n = auditTrailLogList.size(); i < n; i++) {
					AuditTrailLog auditTrailLog = auditTrailLogList.get(i);
					if (action.equals(ActionConstants.REJECT)) {
						if (auditTrailLog.getOperationStatus().equals(ActionConstants.STATUS_SUBMITTED)) {
							toAddressesList.addAll(this.getEmailAddress(auditTrailLog.getOperationUserId(), 0, ""));
						}
						if (auditTrailLog.getOperationStatus().equals(ActionConstants.STATUS_COMPLETED)) {
							ccAddressesList.addAll(this.getEmailAddress(auditTrailLog.getOperationUserId(), 0, ""));
						}
					}
					if (auditTrailLog.getOperationStatus().equals(ActionConstants.STATUS_PENDING_TO_APPROVE)) {
						AuditTrailLogLocalServiceUtil.deleteAuditTrailLog(auditTrailLog);
						operationNo = operationNo - 1;
					}
				}
				if (action.equals(ActionConstants.RECALL)) {
					operationStatus = ActionConstants.STATUS_RECALL;
					operationRole = EClosingEnum.HRCONSULTANT.getRole();
					AuditTrailLogLocalServiceUtil.saveAuditTrailLog(companyId, groupId, eClosingId, EClosing.class.getName(), operationNo, operationRole, operationUserId, operationUser, operationStatus, date, operationComment);
				}
			}else if (action.equals(ActionConstants.SUBMIT)) {
				int operationNo = auditTrailLogList.size() + 1;
				for (EClosingEnum eClosingEnum : EClosingEnum.values()) {
					if (eClosingEnum.getNumber() == EClosingEnum.HRCONSULTANT.getNumber()) {
						AuditTrailLogLocalServiceUtil.saveAuditTrailLog(companyId, groupId, eClosingId, EClosing.class.getName(), operationNo, eClosingEnum.getRole(), operationUserId, operationUser, ActionConstants.STATUS_SUBMITTED, date, operationComment);
					}else {
						String roleName = eClosingEnum.getRole();
						if (roleName.equals(EClosingEnum.FLEETSERVICES.getRole())) {
							roleName = eClosingEnum.getRole() + "-Admin";
							if (eClosing.getEmployeeGroupId().equals("6")) {
								roleName = eClosingEnum.getRole() + "-FSE Coordination";
							}
						}
						if (roleName.equals(EClosingEnum.FSELECONSULTANT.getRole())) {
							if (!(eClosing.getEmployeeGroupId().equals("4") || eClosing.getEmployeeGroupId().equals("5")|| eClosing.getEmployeeGroupId().equals("6"))) {
								continue;
							}
						}
						if (roleName.equals(EClosingEnum.SUPERVISOR.getRole())) {
							String operationUserName = this.getOperationUserName(supervisorUserId, 0, "");
							toAddressesList.addAll(this.getEmailAddress(supervisorUserId, 0, ""));
							AuditTrailLogLocalServiceUtil.saveAuditTrailLog(companyId, groupId, eClosingId, EClosing.class.getName(), operationNo, eClosingEnum.getRole(), supervisorUserId, operationUserName, ActionConstants.STATUS_PENDING_TO_APPROVE, null, operationComment);
						}else {
							String operationUserName = this.getOperationUserName(0, companyId, roleName);
							toAddressesList.addAll(this.getEmailAddress(0, companyId, roleName));
							AuditTrailLogLocalServiceUtil.saveAuditTrailLog(companyId, groupId, eClosingId, EClosing.class.getName(), operationNo, eClosingEnum.getRole(), operationUserName, ActionConstants.STATUS_PENDING_TO_APPROVE, null, operationComment);
						}
					}
					operationNo = operationNo + 1;
				}
				// Send Submitted Email
				this.sendMail(eClosingId, "1", toAddressesList, ccAddressesList);
				toAddressesList.clear();
				ccAddressesList.clear();
				String[] toAddresses = DistributionLocalServiceUtil.findAllEmailAddresses(PropsUtil.get("vgc.apon.distribution.type.hr"));
				for (int i = 0, n = toAddresses.length; i < n; i++) {
					if (Validator.isNotNull(toAddresses[i])) {
						toAddressesList.add(toAddresses[i]);
					}
				}
				this.sendMail(eClosingId, "2", toAddressesList, ccAddressesList);
				//send closing guide email to closer and cc to applicant
				List<String> closingAddressList = new ArrayList<String>();
				List<String> cclosingAddressList = new ArrayList<String>();
				User closer = UserLocalServiceUtil.fetchUserByFacebookId(eClosing.getCompanyId(), eClosing.getStaffCode());
				if (Validator.isEmailAddress(eClosing.getPrivateEmailAddress())) {
					closingAddressList.add(eClosing.getPrivateEmailAddress());
				}
				if (Validator.isEmailAddress(closer.getEmailAddress())) {
					closingAddressList.add(closer.getEmailAddress());
				}
				cclosingAddressList.add(user.getEmailAddress());
				this.sendMail(eClosingId, "8", closingAddressList, cclosingAddressList);
			}
		}else {
			if (action.equals(ActionConstants.SUBMIT)) {
				
				int operationNo = 1;
				for (EClosingEnum eClosingEnum : EClosingEnum.values()) {
					if (eClosingEnum.getNumber() == EClosingEnum.HRCONSULTANT.getNumber()) {
						AuditTrailLogLocalServiceUtil.saveAuditTrailLog(companyId, groupId, eClosingId, EClosing.class.getName(), operationNo, eClosingEnum.getRole(), operationUserId, operationUser, ActionConstants.STATUS_SUBMITTED, date, operationComment);
					}else {
						String roleName = eClosingEnum.getRole();
						if (roleName.equals(EClosingEnum.FLEETSERVICES.getRole())) {
							roleName = eClosingEnum.getRole() + "-Admin";
							if (eClosing.getEmployeeGroupId().equals("6")) {
								roleName = eClosingEnum.getRole() + "-FSE Coordination";
							}
						}
						if (roleName.equals(EClosingEnum.FSELECONSULTANT.getRole())) {
							if (!(eClosing.getEmployeeGroupId().equals("4") || eClosing.getEmployeeGroupId().equals("5")|| eClosing.getEmployeeGroupId().equals("6"))) {
								continue;
							}
						}
						if (roleName.equals(EClosingEnum.SUPERVISOR.getRole())) {
							String operationUserName = this.getOperationUserName(supervisorUserId, 0, "");
							toAddressesList.addAll(this.getEmailAddress(supervisorUserId, 0, ""));
							AuditTrailLogLocalServiceUtil.saveAuditTrailLog(companyId, groupId, eClosingId, EClosing.class.getName(), operationNo, eClosingEnum.getRole(), supervisorUserId, operationUserName, ActionConstants.STATUS_PENDING_TO_APPROVE, null, operationComment);
						}else {
							String operationUserName = this.getOperationUserName(0, companyId, roleName);
							toAddressesList.addAll(this.getEmailAddress(0, companyId, roleName));
							AuditTrailLogLocalServiceUtil.saveAuditTrailLog(companyId, groupId, eClosingId, EClosing.class.getName(), operationNo, eClosingEnum.getRole(), operationUserName, ActionConstants.STATUS_PENDING_TO_APPROVE, null, operationComment);
						}
					}
					operationNo = operationNo + 1;
				}
				// Send Submitted Email
				this.sendMail(eClosingId, "1", toAddressesList, ccAddressesList);
				toAddressesList.clear();
				ccAddressesList.clear();
//				List<Distribution> distributionList = DistributionLocalServiceUtil.findAll();
//				for (int i = 0, n = distributionList.size(); i < n; i++) {
//					Distribution distribution = distributionList.get(i);
//					if (Validator.isNotNull(distribution.getEmailAddress())) {
//						toAddressesList.add(distribution.getEmailAddress());
//					}
//				}
				String[] toAddresses = DistributionLocalServiceUtil.findAllEmailAddresses(PropsUtil.get("vgc.apon.distribution.type.hr"));
				for (int i = 0, n = toAddresses.length; i < n; i++) {
					if (Validator.isNotNull(toAddresses[i])) {
						toAddressesList.add(toAddresses[i]);
					}
				}
				this.sendMail(eClosingId, "2", toAddressesList, ccAddressesList);
				//send closing guide email to closer and cc to applicant
				List<String> closingAddressList = new ArrayList<String>();
				List<String> cclosingAddressList = new ArrayList<String>();
				User closer = UserLocalServiceUtil.fetchUserByFacebookId(eClosing.getCompanyId(), eClosing.getStaffCode());
				if (Validator.isEmailAddress(eClosing.getPrivateEmailAddress())) {
					closingAddressList.add(eClosing.getPrivateEmailAddress());
				}
				if (Validator.isEmailAddress(closer.getEmailAddress())) {
					closingAddressList.add(closer.getEmailAddress());
				}
				cclosingAddressList.add(user.getEmailAddress());
				this.sendMail(eClosingId, "8", closingAddressList, cclosingAddressList);
			}
		}
	}
	public void sendMail(long eClosingId, String emailId, List<String> toAddressesList, List<String> ccAddressesList) throws SystemException, PortalException {
		String isEnable = PropsUtil.get("vgc.apon.e.closing.send.email.enable");
		log.info("Email isEnable=" + isEnable);
		toAddressesList = this.removeDuplicate(toAddressesList);
		ccAddressesList = this.removeDuplicate(ccAddressesList);
		String cssContent = this.getCssContent(emailId);
		String[] toAddresses = null, ccAddresses = null, attachFileNames = null;
		if (toAddressesList.size() > 0) {
			toAddresses = new String[toAddressesList.size()];
			for (int i = 0, n = toAddressesList.size(); i < n; i++) {
				log.info("Email toAddresses=" + toAddressesList.get(i));
				System.out.println("Email toAddresses=" + toAddressesList.get(i));
				toAddresses[i] = toAddressesList.get(i);
			}
		}
		if (ccAddressesList.size() > 0) {
			ccAddresses = new String[ccAddressesList.size()];
			for (int i = 0, n = ccAddressesList.size(); i < n; i++) {
				log.info("Email ccAddresses=" + ccAddressesList.get(i));
				System.out.println("Email ccAddresses=" + ccAddressesList.get(i));
				ccAddresses[i] = ccAddressesList.get(i);
			}
		}
		EClosing eClosing = eClosingLocalService.getEClosing(eClosingId);
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		Map<String, String> allParametersMap = new HashMap<String, String>();
		allParametersMap.put("href", PropsUtil.get("vgc.apon.e.closing.send.email.content.href"));
		if (eClosing != null) {
			allParametersMap.put("ticketNo", Validator.isNotNull(eClosing.getTicketNo()) ? eClosing.getTicketNo() : "");
			allParametersMap.put("staffCode", Validator.isNotNull(eClosing.getStaffCode()) ? eClosing.getStaffCode() + "" : "");
			allParametersMap.put("staffName", Validator.isNotNull(eClosing.getStaffName()) ? eClosing.getStaffName() : "");
			allParametersMap.put("company", Validator.isNotNull(eClosing.getCompany()) ? eClosing.getCompany() : "");
			allParametersMap.put("division", Validator.isNotNull(eClosing.getDivision()) ? eClosing.getDivision() : "");
			allParametersMap.put("department", Validator.isNotNull(eClosing.getDepartment()) ? eClosing.getDepartment() : "");
			allParametersMap.put("functionName", Validator.isNotNull(eClosing.getFunctionName()) ?eClosing.getFunctionName() : "");
			allParametersMap.put("positionCode", Validator.isNotNull(eClosing.getPositionCode()) ? eClosing.getPositionCode() : "");
			allParametersMap.put("privateEmailAddress", Validator.isNotNull(eClosing.getPrivateEmailAddress()) ? eClosing.getPrivateEmailAddress() : "");
			allParametersMap.put("finishContractDate", Validator.isNotNull(eClosing.getFinishContractDate()) ? dateFormat.format(eClosing.getFinishContractDate()) : "");
			allParametersMap.put("lastWorkingDay", Validator.isNotNull(eClosing.getLastWorkingDay()) ?dateFormat.format(eClosing.getLastWorkingDay()) : "");
			allParametersMap.put("userName", Validator.isNotNull(eClosing.getUserName()) ? eClosing.getUserName() : "");
			allParametersMap.put("costCenter", Validator.isNotNull(eClosing.getCostCenter()) ? eClosing.getCostCenter() : "");
			allParametersMap.put("idHrFee", Validator.isNotNull(eClosing.getIdHrFee()) ? eClosing.getIdHrFee() + "" : "");
			allParametersMap.put("idFinanceFee", Validator.isNotNull(eClosing.getIdFinanceFee()) ? eClosing.getIdFinanceFee() + "" : "");
			allParametersMap.put("idComments", Validator.isNotNull(eClosing.getIdComments()) ? eClosing.getIdComments() : "");
			allParametersMap.put("htdHrFee", Validator.isNotNull(eClosing.getHtdHrFee()) ? eClosing.getHtdHrFee() + "" : "");
			allParametersMap.put("htdFinanceFee", Validator.isNotNull(eClosing.getHtdFinanceFee()) ? eClosing.getHtdFinanceFee() + "" : "");
			allParametersMap.put("htdComments", Validator.isNotNull(eClosing.getHtdComments()) ? eClosing.getHtdComments() : "");
			allParametersMap.put("securityFinanceFee", Validator.isNotNull(eClosing.getSecurityFinanceFee()) ? eClosing.getSecurityFinanceFee() + "" : "");
			allParametersMap.put("securityComments", Validator.isNotNull(eClosing.getSecurityComments()) ? eClosing.getSecurityComments() : "");
			allParametersMap.put("adFinanceFee", Validator.isNotNull(eClosing.getAdFinanceFee()) ? eClosing.getAdFinanceFee() + "" : "");
			allParametersMap.put("adComments", Validator.isNotNull(eClosing.getAdComments()) ? eClosing.getAdComments() : "");
		}
		String subject = this.replaceAll(this.getSubject(emailId), allParametersMap);
		String mailbody = this.replaceAll(this.getMailbody(emailId), allParametersMap);
		log.info("Email subject=" + subject);
		log.info("Email mailbody=" + mailbody);
		System.out.println("Email subject=" + subject);
		System.out.println("Email mailbody=" + mailbody);
		if (Boolean.valueOf(isEnable)) {
			if (Boolean.valueOf(PropsUtil.get("vgc.apon.e.closing.send.email.test"))) {
				toAddresses = new String[]{PropsUtil.get("vgc.apon.e.closing.send.email.test.address")};
				ccAddresses = new String[]{PropsUtil.get("vgc.apon.e.closing.send.email.test.address")};
			}
			GlobalEmailLocalServiceUtil.sendEmail(toAddresses, ccAddresses, subject, cssContent, mailbody, attachFileNames);
		}
	}
	
	public String getOperationUserName(long userId, long companyId, String roleName) throws SystemException, PortalException {
		String operationUserName = "";
		if (userId > 0) {
			User user = userLocalService.getUser(userId);
			operationUserName = user.getFirstName() + " " + user.getLastName();
		}else {
			Role role = RoleLocalServiceUtil.fetchRole(companyId, roleName);
			List<User> userList = userLocalService.getRoleUsers(role.getRoleId());
			if (userList != null && userList.size() > 0) {
				for (int i = 0, n = userList.size() - 1; i < n; i++) {
					User user = userList.get(i);
					operationUserName += user.getFirstName() + " " + user.getLastName() + ",";
				}
				User user = userList.get(userList.size() - 1);
				operationUserName += user.getFirstName() + " " + user.getLastName();
			}
		}
		return operationUserName;
	}
	
	public List<String> getEmailAddress(long userId, long companyId, String roleName) throws PortalException, SystemException {
		List<String> emailAddress = new ArrayList<String>();
		if (userId > 0) {
			User user = userLocalService.getUser(userId);
			emailAddress.add(user.getEmailAddress());
		}else {
			Role role = RoleLocalServiceUtil.fetchRole(companyId, roleName);
			List<User> userList = userLocalService.getRoleUsers(role.getRoleId());
			if (userList != null && userList.size() > 0) {
				for (int i = 0, n = userList.size(); i < n; i++) {
					User user = userList.get(i);
					emailAddress.add(user.getEmailAddress());
				}
			}
		}
		return emailAddress;
	}
	
	public String getTicketNo(String prefix) {
		String ticketNo = "";
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
		String name = prefix + dateFormat.format(date);
		long suffix;
		try {
			suffix = CounterLocalServiceUtil.increment(name, 1);
			ticketNo = name + String.format("%07d", suffix, 1);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return ticketNo;
	}
	
	public String replaceAll(String content, Map<String, String> allParametersMap) {
		Iterator<Entry<String, String>> entries = allParametersMap.entrySet().iterator();
		while (entries.hasNext()) {
			Entry<String, String> entry = entries.next();
			content = content.replaceAll("#"+entry.getKey()+"#", entry.getValue());
		}
		return content;
	}
	
	public String getCssContent(String emailId) {
		StringBuffer cssBuffer = new StringBuffer("");
		if (emailId.equals("2")) {
			cssBuffer.append("table{ width: 40%; border-collapse: collapse; border-spacing: 0; border-left: 1px solid black; border-top: 1px solid black;}");
			cssBuffer.append("td{border-right: 1px solid black; border-bottom: 1px solid black;}");
			cssBuffer.append("font{text-decoration: underline;}");
		}
		return cssBuffer.toString();
	}
	
	public String getSubject(String emailId) {
		String subject = "";
		if (emailId.equals("1")) {
			subject = "E-Closing Notification-#staffName#-#ticketNo#-Submitted";
		}else if (emailId.equals("2")) {
			subject = "E-Closing Notification-#staffName#-#ticketNo#-Submitted";
		}else if (emailId.equals("3")) {
			subject = "E-Closing Application-#staffName#-#ticketNo#-Completed";
		}else if (emailId.equals("4")) {
			subject = "E-Closing Application-#staffName#-#ticketNo#-IT Equipment Fee";
		}else if (emailId.equals("5")) {
			subject = "E-Closing Application-#staffName#-#ticketNo#-Training Fee";
		}else if (emailId.equals("6")) {
			subject = "E-Closing Application-#staffName#-#ticketNo#-Card Missing Fee";
		}else if (emailId.equals("7")) {
			subject = "E-Closing Application-#staffName#-#ticketNo#- Cabinet Key & Office Key Copy Fee";
		}
		else if (emailId.equals("8")) {
			subject = "VGC Closing Guide";
		}
		return subject;
	}
	
	public String getMailbody(String emailId) {
		StringBuffer mailbodyBuffer = new StringBuffer("");
		if (emailId.equals("1")) {
			mailbodyBuffer.append("<p>Dear Colleagues,</p>");
			mailbodyBuffer.append("<p>Please kindly help to finish the closing document for #staffName#, view the details in <a href='#href#'>APON System</a> and finish all related preparation on time according to our closing process.</p>");
			mailbodyBuffer.append("<p>After having finished preparation, please mark your task as completed in <a href='#href#'>APON System</a>.</p>");
			mailbodyBuffer.append("<p>Thank you very much for your kindly support!</p>");
			mailbodyBuffer.append("<p>PLEASE DO NOT REPLY to this email, as it is system generated.</p>");
		}else if (emailId.equals("2")) {
			mailbodyBuffer.append("<p>Dear Colleagues,</p>");
			mailbodyBuffer.append("<p>Please help to finish the closing document for #staffName# according to below information:</p>");
			mailbodyBuffer.append("<table>");
			mailbodyBuffer.append("<tr><td>Staff Code</td><td>#staffCode#</td></tr>");
			mailbodyBuffer.append("<tr><td>Staff Name</td><td>#staffName#</td></tr>");
			mailbodyBuffer.append("<tr><td>Company</td><td>#company#</td></tr>");
			mailbodyBuffer.append("<tr><td>Division</td><td>#division#</td></tr>");
			mailbodyBuffer.append("<tr><td>Department</td><td>#department#</td></tr>");
			mailbodyBuffer.append("<tr><td>Function Name</td><td>#functionName#</td></tr>");
			mailbodyBuffer.append("<tr><td>Position Code</td><td>#positionCode#</td></tr>");
			mailbodyBuffer.append("<tr><td>Email</td><td>#privateEmailAddress#</td></tr>");
			mailbodyBuffer.append("<tr><td>Finish Contract Date</td><td>#finishContractDate#</td></tr>");
			mailbodyBuffer.append("<tr><td>Last Working Day</td><td>#lastWorkingDay#</td></tr>");
			mailbodyBuffer.append("</table>");
			mailbodyBuffer.append("<p>If you have any question, please contact HR #userName#.</p>");
			mailbodyBuffer.append("<p>Thank you very much for your kindly cooperation!</p>");
			mailbodyBuffer.append("<p>PLEASE DO NOT REPLY to this email, as it is system generated.</p>");
			mailbodyBuffer.append("<p>Note: Please close this employee's role validations in all systems, such as SAP/K-SRM.</p>");
		}else if (emailId.equals("3")) {
			mailbodyBuffer.append("<p>Dear Applicant,</p>");
			mailbodyBuffer.append("<p>Your E-Closing application preparations for #staffName# have been completed. Please view them in <a href='#href#'>APON System</a>.</p>");
			mailbodyBuffer.append("<p>PLEASE DO NOT REPLY to this email, as it is system generated.</p>");
		}else if (emailId.equals("4")) {
			mailbodyBuffer.append("<p>Dear Colleague,</p>");
			mailbodyBuffer.append("<p>E-Closing application for the following person is in process:</p>");
			mailbodyBuffer.append("<p>Staff Code:&nbsp;#staffCode#</p>");
			mailbodyBuffer.append("<p>Staff Name:&nbsp;#staffName#</p>");
			mailbodyBuffer.append("<p>Division:&nbsp;#division#</p>");
			mailbodyBuffer.append("<p>Department:&nbsp;#department#</p>");
			mailbodyBuffer.append("<p>Cost Center:&nbsp;#costCenter#</p>");
			mailbodyBuffer.append("<p>IT Equipment Fee (HR C&amp;B Related):&nbsp;<font>#idHrFee#</font>&nbsp;RMB.</p>");
			mailbodyBuffer.append("<p>IT Equipment Fee (Finance Related):&nbsp;<font>#idFinanceFee#</font>&nbsp;RMB.</p>");
			mailbodyBuffer.append("<p>Please kindly review the comments left by IT Department: #idComments# and help to deal with the business.</p>");
			mailbodyBuffer.append("<p>PLEASE DO NOT REPLY to this email, as it is system generated.</p>");
		}else if (emailId.equals("5")) {
			mailbodyBuffer.append("<p>Dear Colleague,</p>");
			mailbodyBuffer.append("<p>E-Closing application for the following person is in process:</p>");
			mailbodyBuffer.append("<p>Staff Code:&nbsp;#staffCode#</p>");
			mailbodyBuffer.append("<p>Staff Name:&nbsp;#staffName#</p>");
			mailbodyBuffer.append("<p>Division:&nbsp;#division#</p>");
			mailbodyBuffer.append("<p>Department:&nbsp;#department#</p>");
			mailbodyBuffer.append("<p>Cost Center:&nbsp;#costCenter#</p>");
			mailbodyBuffer.append("<p>HR Training Fee:&nbsp;<font>#htdHrFee#</font>&nbsp;RMB.</p>");
			mailbodyBuffer.append("<p>Please kindly review the comments left by HR Training Department: #htdComments# and help to deal with the business.</p>");
			mailbodyBuffer.append("<p>PLEASE DO NOT REPLY to this email, as it is system generated.</p>");
		}else if (emailId.equals("6")) {
			mailbodyBuffer.append("<p>Dear Colleague,</p>");
			mailbodyBuffer.append("<p>E-Closing application for the following person is in process:</p>");
			mailbodyBuffer.append("<p>Staff Code:&nbsp;#staffCode#</p>");
			mailbodyBuffer.append("<p>Staff Name:&nbsp;#staffName#</p>");
			mailbodyBuffer.append("<p>Division:&nbsp;#division#</p>");
			mailbodyBuffer.append("<p>Department:&nbsp;#department#</p>");
			mailbodyBuffer.append("<p>Cost Center:&nbsp;#costCenter#</p>");
			mailbodyBuffer.append("<p>Card Missing Fee (Finance Related):&nbsp;<font>#securityFinanceFee#</font>&nbsp;RMB.</p>");
			mailbodyBuffer.append("<p>Please kindly review the comments left by Security Department: #securityComments# and help to deal with the business.</p>");
			mailbodyBuffer.append("<p>PLEASE DO NOT REPLY to this email, as it is system generated.</p>");
		}else if (emailId.equals("7")) {
			mailbodyBuffer.append("<p>Dear Colleague,</p>");
			mailbodyBuffer.append("<p>E-Closing application for the following person is in process:</p>");
			mailbodyBuffer.append("<p>Staff Code:&nbsp;#staffCode#</p>");
			mailbodyBuffer.append("<p>Staff Name:&nbsp;#staffName#</p>");
			mailbodyBuffer.append("<p>Division:&nbsp;#division#</p>");
			mailbodyBuffer.append("<p>Department:&nbsp;#department#</p>");
			mailbodyBuffer.append("<p>Cost Center:&nbsp;#costCenter#</p>");
			mailbodyBuffer.append("<p>Cabinet Key & Office Key Copy Fee: (Finance Related):&nbsp;<font>#adFinanceFee#</font>&nbsp;RMB.</p>");
			mailbodyBuffer.append("<p>Please kindly review the comments left by Administration Department: #adComments# and help to deal with the business.</p>");
			mailbodyBuffer.append("<p>PLEASE DO NOT REPLY to this email, as it is system generated.</p>");
		}
		else if(emailId.equals("8")){
			mailbodyBuffer.append("<p>Dear Colleague,</p>");
			mailbodyBuffer.append("<p>In order to help you complete your closing process more efficiently, we would like to suggest you to conduct handover by the following steps:</p>");
			mailbodyBuffer.append("<p>1. Handover of Company Property - Administration Department</p>");
			mailbodyBuffer.append("<p>&nbsp;&nbsp;&nbsp;&nbsp;• Return lunch card</p>");
			mailbodyBuffer.append("<p>&nbsp;&nbsp;&nbsp;&nbsp;• Return key of locker/cabinet</p>");
			mailbodyBuffer.append("<p>&nbsp;&nbsp;&nbsp;&nbsp;• Return office key (if any)</p>");
			mailbodyBuffer.append("<p>&nbsp;&nbsp;&nbsp;&nbsp;• Return name plate of mailbox and work station</p>");
			mailbodyBuffer.append("<p>2. Handover of Company Property - Fleet Services</p>");
			mailbodyBuffer.append("<p>&nbsp;&nbsp;&nbsp;&nbsp;• Return company car (if any)</p>");
			mailbodyBuffer.append("<p>3. Return work permit booklet to FSE/LE Consultant and settlement of home leave budget account (only applicable to FSE/LE)</p>");
			mailbodyBuffer.append("<p>4. Payment Clearance - HR Training Department</p>");
			mailbodyBuffer.append("<p>&nbsp;&nbsp;&nbsp;&nbsp;• Settle training fee account (applicable to LE/LC)</p>");
			mailbodyBuffer.append("<p>5. Payment Clearance - HR C&B</p>");
			mailbodyBuffer.append("<p>&nbsp;&nbsp;&nbsp;&nbsp;• Unused annual leave</p>");
			mailbodyBuffer.append("<p>&nbsp;&nbsp;&nbsp;&nbsp;• Social insurance</p>");
			mailbodyBuffer.append("<p>&nbsp;&nbsp;&nbsp;&nbsp;• Payment of private calls (fix)</p>");
			mailbodyBuffer.append("<p>&nbsp;&nbsp;&nbsp;&nbsp;• Payment of private calls (mobile)</p>");
			mailbodyBuffer.append("<p>6. Payment Clearance - Finance Department</p>");
			mailbodyBuffer.append("<p>&nbsp;&nbsp;&nbsp;&nbsp;• Settlement of business travel cash advance(s)</p>");
			mailbodyBuffer.append("<p>&nbsp;&nbsp;&nbsp;&nbsp;• Settlement of company credit card account</p>");
			mailbodyBuffer.append("<p>&nbsp;&nbsp;&nbsp;&nbsp;• Others (if any)</p>");
			mailbodyBuffer.append("<p>7. Handover of Company Property - IT Department</p>");
			mailbodyBuffer.append("<p>&nbsp;&nbsp;&nbsp;&nbsp;• IT workplace equipment (laptop/monitor/docking station etc.)</p>");
			mailbodyBuffer.append("<p>&nbsp;&nbsp;&nbsp;&nbsp;• Close email and intranet account</p>");
			mailbodyBuffer.append("<p>&nbsp;&nbsp;&nbsp;&nbsp;• Close SAP account (if any)</p>");
			mailbodyBuffer.append("<p>&nbsp;&nbsp;&nbsp;&nbsp;• Close other system accounts (if any)</p>");
			mailbodyBuffer.append("<p>&nbsp;&nbsp;&nbsp;&nbsp;• Archive and delete shared folder</p>");
			mailbodyBuffer.append("<p>&nbsp;&nbsp;&nbsp;&nbsp;• Change name display and voice mail on telephone</p>");
			mailbodyBuffer.append("<p>&nbsp;&nbsp;&nbsp;&nbsp;• Return company SIM card (if any)</p>");
			mailbodyBuffer.append("<p>&nbsp;&nbsp;&nbsp;&nbsp;• Return mobile phone (if any)</p>");
			mailbodyBuffer.append("<p>8. Handover of Company Property - Security Department</p>");
			mailbodyBuffer.append("<p>&nbsp;&nbsp;&nbsp;&nbsp;• Return door card</p>"); 
			mailbodyBuffer.append("<p>9. Work Handover with Department</p>");
			mailbodyBuffer.append("<p>&nbsp;&nbsp;&nbsp;&nbsp;• Work handover to successor (if applicable)</p>");
			mailbodyBuffer.append("<p>&nbsp;&nbsp;&nbsp;&nbsp;• Handover / Finalize K-SRM tasks (if applicable)</p>");
		    mailbodyBuffer.append("<p>&nbsp;&nbsp;</p>");
		    mailbodyBuffer.append("<p>Attention please:</p>"); 
		    mailbodyBuffer.append("<p>After HR Consultant submits E-Closing application for you, all relevant "
		    		+ "departments can finish their tasks accordingly. "
		    		+ "You can logon APON II system to track the processing steps any time with your NT Account and laptop."
		    		+ " So we suggest you to handover company property of IT Department and Security Department after completing all other steps. "
		    		+ "Otherwise, you will not be able to logon APON II system to track your closing process without "
		    		+ "laptop and come in the company without door card.</p>");
		}
		return mailbodyBuffer.toString();
	}
	
	public List<String> removeDuplicate(List<String> addressesList) {
		List<String> resultList = new ArrayList<String>();
		for (int i = 0, n = addressesList.size(); i < n; i++) {
			if (!resultList.contains(addressesList.get(i))) {
				resultList.add(addressesList.get(i));
			}
		}
		return resultList;
	}
	
	
	
	public List<EClosing> getEclosingByStaffcode(String staffcode) throws SystemException, PortalException {
		List<EClosing> resultList = new ArrayList<EClosing>();
		String eclString = "E-Closing";
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(EClosing.class);		
		query.add(PropertyFactoryUtil.forName("staffCode").eq(Integer.parseInt(staffcode)));
		query.add(PropertyFactoryUtil.forName("subProcessType").eq(eclString));
		resultList = dynamicQuery(query);
			
		return resultList;
		
		//return eClosingFinder.getEclosingByStaffcode(staffcode);
	}
	
	public int findEclosingAllByKaleoInstanceId(long pk,String tabs2) throws SystemException, PortalException {
		return eClosingFinder.findEclosingAllByKaleoInstanceId(pk,tabs2);
	}
	
}