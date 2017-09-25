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

package com.e.leave.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.audit.trail.model.AuditTrailLog;
import com.audit.trail.service.AuditTrailLogLocalServiceUtil;
import com.delegation.model.ApplicantDelegation;
import com.delegation.service.ApplicantDelegationLocalServiceUtil;
import com.delegation.service.ApproverDelegationLocalServiceUtil;
import com.e.leave.model.ELeave;
import com.e.leave.model.ELeaveInfo;
import com.e.leave.service.ELeaveInfoLocalServiceUtil;
import com.e.leave.service.ELeaveLocalServiceUtil;
import com.e.leave.service.base.ELeaveLocalServiceBaseImpl;
import com.e.leave.util.ActionConstants;
import com.e.leave.util.ELeaveLogEnum;
import com.global.management.service.GlobalEmailLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
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
 * The implementation of the e leave local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.e.leave.service.ELeaveLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author EZEYIFE
 * @see com.e.leave.service.base.ELeaveLocalServiceBaseImpl
 * @see com.e.leave.service.ELeaveLocalServiceUtil
 */
public class ELeaveLocalServiceImpl extends ELeaveLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.e.transfer.service.ETransferLocalServiceUtil} to access the e transfer local service.
	 */
	public ELeave saveOrUpdateELeave(
			ELeave eLeave, ServiceContext serviceContext)
		throws SystemException {

		Date now = new Date();
		ThemeDisplay themeDisplay = serviceContext.getThemeDisplay();
		
		long groupId = serviceContext.getScopeGroupId();
		long companyId = serviceContext.getCompanyId();
		String userName = themeDisplay.getUser().getFullName();
		eLeave.setCompanyId(companyId);
		eLeave.setGroupId(groupId);
		eLeave.setUserId(serviceContext.getUserId());
		eLeave.setUserName(userName);
		eLeave.setModifiedDate(serviceContext.getCreateDate(now));
		
		// workflow

		eLeave.setStatus(WorkflowConstants.STATUS_DRAFT);
		eLeave.setStatusByUserId(serviceContext.getUserId());
		eLeave.setStatusByUserName(userName);
		eLeave.setStatusDate(serviceContext.getModifiedDate(now));

		eLeave = eLeavePersistence.update(eLeave);
		
		long staffCode=Long.valueOf(eLeave.getStaffCode());
		SAPUser sapUser=SAPUserLocalServiceUtil.getSapUserByStaffCode(String.valueOf(staffCode));
		long supervisorUserId=sapUser!=null?Long.valueOf(sapUser.getReportToSupervisorId()!=null&&!sapUser.getReportToSupervisorId().equals("")?sapUser.getReportToSupervisorId():"0"):0;
		User supervisorUser = UserLocalServiceUtil.fetchUserByFacebookId(companyId, supervisorUserId);
		Role supervisorRole = ApproverDelegationLocalServiceUtil.findAgentRoleByP_U(ApproverDelegationLocalServiceUtil.getProcessOfELeave(), supervisorUser.getUserId());
		serviceContext.setAttribute("vgcapon_e_leave_supervisor", supervisorRole);
		List<Role> adminRoles = ApproverDelegationLocalServiceUtil.findAgentRolesByP_R(ApproverDelegationLocalServiceUtil.getProcessOfELeave(),"EL Leave Coordinator");
		serviceContext.setAttribute("vgcapon_EL_Leave_Coordinator", adminRoles.toArray());
		return eLeave;
	}
	
	// Submit the ETransfer Process
	public ELeave submitELeave(
			ELeave eLeave, ServiceContext serviceContext)
		throws SystemException, PortalException{

		ThemeDisplay themeDisplay = serviceContext.getThemeDisplay();
		String userName = themeDisplay.getUser().getFullName();

		long groupId = serviceContext.getScopeGroupId();
		long companyId = serviceContext.getCompanyId();
		long eLeaveId = eLeave.getELeaveId();
		long userId = serviceContext.getUserId();
		
		Date now = new Date();

		eLeave.setCompanyId(companyId);
		eLeave.setGroupId(groupId);
		eLeave.setUserId(userId);
		eLeave.setUserName(userName);
		eLeave.setModifiedDate(now);
		eLeave.setStatus(WorkflowConstants.STATUS_DRAFT);
		eLeave.setStatusByUserId(serviceContext.getUserId());
		eLeave.setStatusByUserName(userName);
		eLeave.setStatusDate(serviceContext.getModifiedDate(now));
		eLeave.setSubmittedDate(now);

		eLeavePersistence.update(eLeave);
		
		long staffCode=Long.valueOf(eLeave.getStaffCode());
		SAPUser sapUser=SAPUserLocalServiceUtil.getSapUserByStaffCode(String.valueOf(staffCode));
		long supervisorUserId=sapUser!=null?Long.valueOf(sapUser.getReportToSupervisorId()!=null&&!sapUser.getReportToSupervisorId().equals("")?sapUser.getReportToSupervisorId():"0"):0;
		User supervisorUser = UserLocalServiceUtil.fetchUserByFacebookId(companyId, supervisorUserId);
		Role supervisorRole = ApproverDelegationLocalServiceUtil.findAgentRoleByP_U(ApproverDelegationLocalServiceUtil.getProcessOfELeave(), supervisorUser.getUserId());
		serviceContext.setAttribute("vgcapon_e_leave_supervisor", supervisorRole);
		List<Role> adminRoles = ApproverDelegationLocalServiceUtil.findAgentRolesByP_R(ApproverDelegationLocalServiceUtil.getProcessOfELeave(),"EL Leave Coordinator");
		serviceContext.setAttribute("vgcapon_EL_Leave_Coordinator", adminRoles.toArray());
		// assetentry
		AssetEntry assetEntry = AssetEntryLocalServiceUtil.updateEntry(userId,
				groupId, eLeave.getCreateDate(),
				eLeave.getModifiedDate(),
				ELeave.class.getName(), eLeaveId,
				String.valueOf(eLeaveId), 0,
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(), true, null, null, null,
				ContentTypes.TEXT_HTML, eLeave.getTicketNo(), null,
				null, null, null, 0, 0, null, false);

		AssetLinkLocalServiceUtil.updateLinks(userId, assetEntry.getEntryId(),
				serviceContext.getAssetLinkEntryIds(),
				AssetLinkConstants.TYPE_RELATED);

		// indexer

		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(ELeave.class);
		indexer.reindex(eLeave);
		
		// workflow

		WorkflowHandlerRegistryUtil.startWorkflowInstance(
				eLeave.getCompanyId(), eLeave.getGroupId(),
				serviceContext.getUserId(), ELeave.class.getName(),
				eLeave.getPrimaryKey(), eLeave,
				serviceContext);
		
		//Send email
		this.submittedSendEmailtoApprover(eLeave);
		return eLeave;
	}
	
	//Send email to approver
	private void submittedSendEmailtoApprover(ELeave eLeave) throws SystemException {
		String cssContent = this.getCssContent();
		List<ELeaveInfo> leaveInfos=ELeaveInfoLocalServiceUtil.findLeaveListByELeaveId(eLeave.getELeaveId());
		String typeOfLeaves=getTypeOfLeaveStrs(leaveInfos);
		String subject = "E-Leave Application for "+typeOfLeaves+"-"+eLeave.getDivision()+"-"+eLeave.getDepartment()+"-"+eLeave.getStaffName()+"-"+eLeave.getTicketNo()+"-Waiting for your Approval";
//		long staffCode=Long.valueOf(eLeave.getStaffCode());
//		long supervisorUserId=SAPUserLocalServiceUtil.getSupervisorUserIdByStaffCode(String.valueOf(staffCode));
//		User supervisorUser=UserLocalServiceUtil.fetchUser(supervisorUserId);
//		String[] toAddresses=new String[]{supervisorUser.getEmailAddress()};
		User supervisor = this.findSupervisorUser(eLeave);		
		String[] supervisorAddresses = ApproverDelegationLocalServiceUtil.findEmailsByP_U(ApproverDelegationLocalServiceUtil.getProcessOfELeave(), supervisor);	
		
		StringBuffer mailbody = new StringBuffer();
		mailbody.append("<div class='emailTmp'>")
				.append("<p>Dear Approver, </p>")
				.append("<p><span class='value'>").append(eLeave.getStaffName()).append("</span> submitted E-Leave application."
						+ " Please kindly approve, reject or complete it in <a href='").append(PropsUtil.get("vgc.apon.system.href.url")).append("'>APON System</a></p>")
				.append("<p>PLEASE DO NOT REPLY to this email, as it is system generated.</p>")
				.append("</div>");
		GlobalEmailLocalServiceUtil.sendEmail(supervisorAddresses, null, subject, cssContent, mailbody.toString(), null);	
	}
	public User findSupervisorUser(ELeave eLeave) throws SystemException {
		long staffCode = Long.valueOf(eLeave.getStaffCode());
		SAPUser sapUser =SAPUserLocalServiceUtil.getSapUserByStaffCode(String.valueOf(staffCode));	
		long supervisorUserId=sapUser!=null?Long.valueOf(sapUser.getReportToSupervisorId()!=null&&!sapUser.getReportToSupervisorId().equals("")?sapUser.getReportToSupervisorId():"0"):0;
		User assignUser = UserLocalServiceUtil.fetchUserByFacebookId(eLeave.getCompanyId(), supervisorUserId);
		return assignUser;
	}

	private String getTypeOfLeaveStrs(List<ELeaveInfo> leaveInfos){
		String typeOfLeaveStrs="";
		StringBuffer sb=new StringBuffer();
		if(leaveInfos!=null&&leaveInfos.size()>0){
			for(ELeaveInfo eLeaveInfo:leaveInfos){
				String typeOfLeaveStr=LanguageUtil.get(LocaleUtil.getDefault(), eLeaveInfo.getTypeOfLeave());
				sb.append(typeOfLeaveStr).append("/");
			}
			typeOfLeaveStrs=sb.toString();
			typeOfLeaveStrs=typeOfLeaveStrs.substring(0,typeOfLeaveStrs.lastIndexOf("/"));
		}
		return typeOfLeaveStrs;
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
	
	public List<ELeave> findByS_U(int status, long userId) throws SystemException {
		return eLeavePersistence.findByS_U(status, userId);
	}

	// Update ELeave
	public ELeave updateELeave(
			ELeave eLeave, ServiceContext serviceContext)
		throws SystemException{
		return super.updateELeave(eLeave);
	}
	
	//Check the user id is has the role
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
	
	public boolean isHasPartRoleName(long userId,String partRoleName) {
		boolean flag = false;
		try {
			List<Role> roles = RoleLocalServiceUtil.getUserRoles(userId);
			String rname = "";
			for(Role role:roles) {
				rname = role.getName();
				if(rname != null && rname.contains(partRoleName)) {
					flag = true;
					break;
				}
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}		
		return flag;
	}
	
	// workflow status
	public ELeave updateStatus(long userId, long eLeaveId,
			int status, ServiceContext serviceContext) throws PortalException,
			SystemException {
		User user = userLocalService.getUser(userId);
		ELeave eLeave = getELeave(eLeaveId);
		eLeave.setStatus(status);
		eLeave.setStatusByUserId(userId);
		eLeave.setStatusByUserName(user.getFullName());
		eLeave.setStatusDate(new Date());
		updateELeave(eLeave);
		return eLeave;
	}
	
	// Save or update the audit trail log for workflow
	public void saveOrUpdateAuditTrailLog(long companyId, long groupId,
			long eLeaveId,long operationUserId,String operationUser, String action,
			String operationComment) throws SystemException, PortalException {
		ELeave eLeave=ELeaveLocalServiceUtil.fetchELeave(eLeaveId);
		Date now = new Date();
		long staffCode=Long.valueOf(eLeave.getStaffCode());
		SAPUser sapUser=SAPUserLocalServiceUtil.getSapUserByStaffCode(String.valueOf(staffCode));
		String divisionName=sapUser.getDivisionName()==null?"":sapUser.getDivisionName();
		long supervisorUserId=sapUser!=null?Long.valueOf(sapUser.getReportToSupervisorId()!=null&&!sapUser.getReportToSupervisorId().equals("")?sapUser.getReportToSupervisorId():"0"):0;
		User supervisorUser=UserLocalServiceUtil.fetchUserByFacebookId(companyId, supervisorUserId);
		String supervisorName = supervisorUser!=null?supervisorUser.getFirstName()+" "+supervisorUser.getLastName():"Guest";
		List<AuditTrailLog> list = AuditTrailLogLocalServiceUtil
				.findAuditTrailByWF_O_O(eLeaveId,
						ELeave.class.getName());
		int operationNo = this.getOperationNo(list);
		int currentOperationNo = this.getCurrentOperationNo(list);
		
		if (ActionConstants.SUBMIT.equals(action)) {
			String submitComment = "";
			if(eLeave.getIsApplicantAgent()) {
				ApplicantDelegation applicantDelegation = ApplicantDelegationLocalServiceUtil.fetchByP_S(
						ApproverDelegationLocalServiceUtil.getProcessOfELeave(), String.valueOf(UserLocalServiceUtil.fetchUserById(eLeave.getUserId()).getFacebookId()));
				submitComment = LanguageUtil.get(LocaleUtil.getDefault(), "vgc.apon.on.behalf.of")+ApplicantDelegationLocalServiceUtil.getAgentName(applicantDelegation);
			}
			if (list == null || list.size() == 0) {
				for (ELeaveLogEnum eLogEnum : ELeaveLogEnum
						.values()) {
					if (eLogEnum.getNumber() == 1) {
						AuditTrailLogLocalServiceUtil.saveAuditTrailLog(
								companyId, groupId, eLeaveId,
								ELeave.class.getName(),
								eLogEnum.getNumber(),getRoleTrailLogName(eLogEnum.getRole()),
								operationUser,
								ActionConstants.STATUS_SUBMITTED, now, submitComment);
					} else {
						String approverUser = "";
						if(eLogEnum.getNumber()==99){
							approverUser = supervisorName;
							AuditTrailLogLocalServiceUtil.saveAuditTrailLog(
									companyId, groupId, eLeaveId,
									ELeave.class.getName(),
									eLogEnum.getNumber(),getRoleTrailLogName(eLogEnum.getRole()),
									approverUser,
									ActionConstants.STATUS_PENDING_TO_APPROVE, null,"");
						}else{
							approverUser = this.getOperationUserByRoleNameAsDiv(
									companyId, eLogEnum.getRole(),divisionName);
							AuditTrailLogLocalServiceUtil.saveAuditTrailLog(
									companyId, groupId, eLeaveId,
									ELeave.class.getName(),
									eLogEnum.getNumber(),getRoleTrailLogName(eLogEnum.getRole()),
									approverUser,
									ActionConstants.STATUS_PENDING_TO_APPROVE, null,"");
						}
					}
				}
			}else{
				AuditTrailLogLocalServiceUtil.saveAuditTrailLog(companyId,
						groupId, eLeaveId,
						ELeave.class.getName(), operationNo,getRoleTrailLogName(ELeaveLogEnum.APPLICANT.getRole()),
						operationUser, ActionConstants.STATUS_SUBMITTED, now,
						submitComment);
			}
		}else if (ActionConstants.RECALL.equals(action)) {
			AuditTrailLogLocalServiceUtil.saveAuditTrailLog(
					companyId, groupId, eLeaveId,
					ELeave.class.getName(),
					operationNo,getRoleTrailLogName(ELeaveLogEnum.APPLICANT.getRole()),
					operationUser,
					ActionConstants.STATUS_RECALL, now,"");
				
				for (ELeaveLogEnum eLogEnum : ELeaveLogEnum
						.values()) {
					if (eLogEnum.getNumber() != 1&&eLogEnum.getNumber()>operationNo) {
						AuditTrailLog AuditTrailLog1= AuditTrailLogLocalServiceUtil.findAuditTrailByWF_C_O_O_O(companyId, eLeaveId, ELeave.class.getName(), eLogEnum.getNumber());
						if(AuditTrailLog1!=null){
							AuditTrailLogLocalServiceUtil.deleteAuditTrailLog(AuditTrailLog1);
						}
					}
				}
				for (ELeaveLogEnum eLogEnum : ELeaveLogEnum
						.values()) {
					if (eLogEnum.getNumber() != 1) {
						String approverUser = "";
						if(eLogEnum.getNumber()==99){
							approverUser = supervisorName;
							AuditTrailLogLocalServiceUtil.saveAuditTrailLog(
									companyId, groupId, eLeaveId,
									ELeave.class.getName(),
									eLogEnum.getNumber(),getRoleTrailLogName(eLogEnum.getRole()),
									approverUser,
									ActionConstants.STATUS_PENDING_TO_APPROVE, null,"");
						}else{
							approverUser = this.getOperationUserByRoleNameAsDiv(
									companyId, eLogEnum.getRole(),divisionName);
							AuditTrailLogLocalServiceUtil.saveAuditTrailLog(
									companyId, groupId, eLeaveId,
									ELeave.class.getName(),
									eLogEnum.getNumber(),getRoleTrailLogName(eLogEnum.getRole()),
									approverUser,
									ActionConstants.STATUS_PENDING_TO_APPROVE, null,"");
						}
					}
				}
		}else{
			if (ActionConstants.APPROVE.equals(action)) {
				for (AuditTrailLog auditTrailLog : list) {
					boolean isBreak=false;
					for (ELeaveLogEnum eLogEnum : ELeaveLogEnum
							.values()) {
						if (eLogEnum.getNumber()!=1&&auditTrailLog.getOperationNo()==eLogEnum.getNumber()) {
							auditTrailLog.setOperationUserId(operationUserId);
							auditTrailLog.setOperationUser(operationUser);
							auditTrailLog.setOperationStatus(ActionConstants.STATUS_APPROVED);
							auditTrailLog.setOperationComment(operationComment);
							auditTrailLog.setOperationNo(operationNo);
							auditTrailLog.setOperationTime(now);
							AuditTrailLogLocalServiceUtil
									.updateAuditTrailLog(auditTrailLog);
							isBreak=true;
						}
					}
					if(isBreak){
						break;
					}
				}
			}else if (ActionConstants.REJECT.equals(action)) {
				AuditTrailLog auditTrailLog = AuditTrailLogLocalServiceUtil.findAuditTrailByWF_C_O_O_O(companyId, eLeaveId, ELeave.class.getName(),currentOperationNo);
				if(auditTrailLog!=null&&auditTrailLog.getOperationStatus().equals(ActionConstants.STATUS_PENDING_TO_APPROVE)) {
					auditTrailLog.setOperationUser(operationUser);
					auditTrailLog.setOperationStatus(ActionConstants.STATUS_REJECTED);
					auditTrailLog.setOperationComment(operationComment);
					auditTrailLog.setOperationNo(operationNo);
					auditTrailLog.setOperationTime(now);
					AuditTrailLogLocalServiceUtil.updateAuditTrailLog(auditTrailLog);
					
					for (ELeaveLogEnum eLogEnum : ELeaveLogEnum
							.values()) {
						if (eLogEnum.getNumber() != 1&&eLogEnum.getNumber()>currentOperationNo) {
							AuditTrailLog AuditTrailLog1= AuditTrailLogLocalServiceUtil.findAuditTrailByWF_C_O_O_O(companyId, eLeaveId, ELeave.class.getName(), eLogEnum.getNumber());
							if(AuditTrailLog1!=null){
								AuditTrailLogLocalServiceUtil.deleteAuditTrailLog(AuditTrailLog1);
							}
						}
					}
					for (ELeaveLogEnum eLogEnum : ELeaveLogEnum
							.values()) {
						if (eLogEnum.getNumber() != 1) {
							String approverUser = "";
							if(eLogEnum.getNumber()==99){
								approverUser = supervisorName;
								AuditTrailLogLocalServiceUtil.saveAuditTrailLog(
										companyId, groupId, eLeaveId,
										ELeave.class.getName(),
										eLogEnum.getNumber(),getRoleTrailLogName(eLogEnum.getRole()),
										approverUser,
										ActionConstants.STATUS_PENDING_TO_APPROVE, null,"");
							}else{
								approverUser = this.getOperationUserByRoleNameAsDiv(
										companyId, eLogEnum.getRole(),divisionName);
								AuditTrailLogLocalServiceUtil.saveAuditTrailLog(
										companyId, groupId, eLeaveId,
										ELeave.class.getName(),
										eLogEnum.getNumber(),getRoleTrailLogName(eLogEnum.getRole()),
										approverUser,
										ActionConstants.STATUS_PENDING_TO_APPROVE, null,"");
							}
						}
					}
				}
			}else if (ActionConstants.COMPLETE.equals(action)
					|| ActionConstants.CANCEL.equals(action)) {
				System.out.println("****************ELeaveLocalServiceImpl**************ActionConstants.COMPLETE");
				for (AuditTrailLog auditTrailLog : list) {
					if (auditTrailLog.getOperationNo() == ELeaveLogEnum.LEAVE_COORDINATOR
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
	
	public String getRoleTrailLogName(String roleName){
		String roleTrailLogName="";
		if("Applicant".equals(roleName)){
			roleTrailLogName=roleName;
		}else if("Supervisor".equals(roleName)){
			roleTrailLogName=roleName;
		}else if("EL Leave Coordinator".equals(roleName)){
			roleTrailLogName="Leave Coordinator";
		}
		return roleTrailLogName;
	}
	
	public int getCurrentOperationNo(List<AuditTrailLog> list){
		int operationNo = 0;
		for (AuditTrailLog auditTrailLog : list) {
			if (auditTrailLog.getOperationStatus().equals(
					ActionConstants.STATUS_PENDING_TO_APPROVE)) {
				operationNo = auditTrailLog.getOperationNo();
				break;
			}
		}
		return operationNo;
	}
	
	public int getOperationNo(List<AuditTrailLog> list) {
		int operationNo = 0;
		for (AuditTrailLog auditTrailLog : list) {
			if (!auditTrailLog.getOperationStatus().equals(
					ActionConstants.STATUS_PENDING_TO_APPROVE)) {
				operationNo = auditTrailLog.getOperationNo();
			} else {
				operationNo = operationNo + 1;
				break;
			}
		}
		return operationNo;
	}
	
	// Get the OperationUser from the role name
	public String getOperationUserByRoleName(long companyId, String roleName,String divisionName)
			throws PortalException, SystemException {
		String operationUser = "";
		Role role = RoleLocalServiceUtil.getRole(companyId, roleName);
		List<User> users = UserLocalServiceUtil.getRoleUsers(role.getRoleId());
		for (User user : users) {
			SAPUser sapUser=SAPUserLocalServiceUtil.getSapUserByStaffCode(String.valueOf(user.getFacebookId()));
			String division=sapUser.getDivisionName()==null?"":sapUser.getDivisionName();
			if(divisionName.equals(division)){
				operationUser = user.getFirstName() + " " + user.getLastName()
						+ ",";
			}
		}
		if(operationUser.length()>0) {
			return operationUser.substring(0, operationUser.length() - 1);
		}else {
			return "";
		}		
	}
	
	// Get the OperationUser from the role name
		public String getOperationUserByRoleNameAsDiv(long companyId, String roleName,String divisionName)
				throws PortalException, SystemException {
			String operationUser = "";
			Role role = RoleLocalServiceUtil.getRole(companyId, roleName);
			List<User> users = UserLocalServiceUtil.getRoleUsers(role.getRoleId());
			for (User user : users) {
				SAPUser sapUser=SAPUserLocalServiceUtil.getSapUserByStaffCode(String.valueOf(user.getFacebookId()));
				String division=sapUser.getDivisionName()==null?"":sapUser.getDivisionName();
				if(divisionName.equals(division)){
					operationUser += " "+user.getFirstName() + " " + user.getLastName()
							+ ",";
				}
			}
			if(operationUser.length()>0) {
				return operationUser.substring(0, operationUser.length() - 1);
			}else {
				return "";
			}		
		}
	
	@SuppressWarnings("unchecked")
	public double getSubmittedOrApprovedAbsenceDays(String staffCode, String typeOfLeaveId)
			throws PortalException, SystemException {
		double absenceDays = 0d;	
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(ELeave.class);		
		query.add(PropertyFactoryUtil.forName("staffCode").eq(staffCode));
		Criterion cr1=PropertyFactoryUtil.forName("status").eq(WorkflowConstants.STATUS_PENDING);
		Criterion cr2=PropertyFactoryUtil.forName("status").eq(101);
		query.add(RestrictionsFactoryUtil.or(cr1,cr2));
		List<ELeave> eLeaves=dynamicQuery(query);
		if(eLeaves!=null&&eLeaves.size()>0){
			for(ELeave eLeave:eLeaves){
				DynamicQuery query1 = DynamicQueryFactoryUtil.forClass(ELeaveInfo.class);
				query1.add(PropertyFactoryUtil.forName("eLeaveId").eq(eLeave.getELeaveId()));
				query1.add(PropertyFactoryUtil.forName("typeOfLeaveId").eq(typeOfLeaveId));
				List<ELeaveInfo> eLeaveInfos=dynamicQuery(query1);
				if(eLeaveInfos!=null&&eLeaveInfos.size()>0){
					for(ELeaveInfo eLeaveInfo:eLeaveInfos){
						double day=Double.valueOf(eLeaveInfo.getAbsenceDays());
						absenceDays+=day;
					}
				}
			}
		}
		return absenceDays;
	}
	
	@SuppressWarnings("unchecked")
	public double getCompletedOfCurrentDayAbsenceDays(String staffCode, String typeOfLeaveId)
			throws PortalException, SystemException, ParseException {
		double absenceDays = 0d;	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(ELeave.class);		
		query.add(PropertyFactoryUtil.forName("staffCode").eq(staffCode));
		query.add(PropertyFactoryUtil.forName("statusDate").ge(sdf1.parse(sdf.format(new Date())+" 00:00:00")));
		query.add(PropertyFactoryUtil.forName("statusDate").le(sdf1.parse(sdf.format(new Date())+" 23:59:59")));
		query.add(PropertyFactoryUtil.forName("status").eq(WorkflowConstants.STATUS_APPROVED));
		List<ELeave> eLeaves=dynamicQuery(query);
		if(eLeaves!=null&&eLeaves.size()>0){
			for(ELeave eLeave:eLeaves){
				DynamicQuery query1 = DynamicQueryFactoryUtil.forClass(ELeaveInfo.class);
				query1.add(PropertyFactoryUtil.forName("eLeaveId").eq(eLeave.getELeaveId()));
				query1.add(PropertyFactoryUtil.forName("typeOfLeaveId").eq(typeOfLeaveId));
				List<ELeaveInfo> eLeaveInfos=dynamicQuery(query1);
				if(eLeaveInfos!=null&&eLeaveInfos.size()>0){
					for(ELeaveInfo eLeaveInfo:eLeaveInfos){
						double day=Double.valueOf(eLeaveInfo.getAbsenceDays());
						absenceDays+=day;
					}
				}
			}
		}
		return absenceDays;
	}
	
	@SuppressWarnings("unchecked")
	public List<ELeave> findViewList(long userId)
			throws SystemException {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(ELeave.class);	
		int[] status = new int[]{101, 1};
		query.add(PropertyFactoryUtil.forName("status").in(status));
		if(isHasRole(userId, "EL Leave Coordinator")) {
			return dynamicQuery(query);	
		}else{
			List<ELeave> list = dynamicQuery(query);
			List<ELeave> result = new ArrayList<ELeave>();			
			for(ELeave eleave:list) {
				SAPUser sapUser = SAPUserLocalServiceUtil.getSapUserByStaffCode(eleave.getStaffCode());
				User user = UserLocalServiceUtil.fetchUser(userId);				
				if(sapUser!=null && user!=null && Long.valueOf(sapUser.getReportToSupervisorId())==user.getFacebookId()) {
					result.add(eleave);
				}
			}
			return result;
		}
	}
}