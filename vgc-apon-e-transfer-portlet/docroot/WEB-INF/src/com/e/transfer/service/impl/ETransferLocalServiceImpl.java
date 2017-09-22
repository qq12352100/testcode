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

package com.e.transfer.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.audit.trail.model.AuditTrailLog;
import com.audit.trail.service.AuditTrailLogLocalServiceUtil;
import com.delegation.service.ApproverDelegationLocalServiceUtil;
import com.e.transfer.model.ETransfer;
import com.e.transfer.service.ETransferLocalServiceUtil;
import com.e.transfer.service.base.ETransferLocalServiceBaseImpl;
import com.e.transfer.util.ActionConstants;
import com.e.transfer.util.ETransferLogEnum;
import com.global.management.service.GlobalEmailLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLinkConstants;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetLinkLocalServiceUtil;
import com.vgc.apon.model.SAPUser;
import com.vgc.apon.service.SAPUserLocalServiceUtil;
import com.vgc.apon.service.SapPositionLocalServiceUtil;

/**
 * The implementation of the e transfer local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.e.transfer.service.ETransferLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author EZEYIFE
 * @see com.e.transfer.service.base.ETransferLocalServiceBaseImpl
 * @see com.e.transfer.service.ETransferLocalServiceUtil
 */
public class ETransferLocalServiceImpl extends ETransferLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.e.transfer.service.ETransferLocalServiceUtil} to access the e transfer local service.
	 */
	public ETransfer saveOrUpdateETransfer(ETransfer eTransfer, ServiceContext serviceContext) throws SystemException {
		Date now = new Date();
		ThemeDisplay themeDisplay = serviceContext.getThemeDisplay();
		User user = themeDisplay.getUser();
		
		long groupId = serviceContext.getScopeGroupId();
		long companyId = serviceContext.getCompanyId();
		String userName = user.getFirstName() + " " + user.getLastName();
		
		eTransfer.setCompanyId(companyId);
		eTransfer.setGroupId(groupId);
		eTransfer.setUserId(serviceContext.getUserId());
		eTransfer.setUserName(userName);
		eTransfer.setModifiedDate(serviceContext.getCreateDate(now));
		
		eTransfer.setStatus(WorkflowConstants.STATUS_DRAFT);
		eTransfer.setStatusByUserId(serviceContext.getUserId());
		eTransfer.setStatusByUserName(userName);
		eTransfer.setStatusDate(serviceContext.getModifiedDate(now));
		
		eTransfer = eTransferPersistence.update(eTransfer);
		
		return eTransfer;
	}
	
	// Submit the ETransfer Process
	public ETransfer submitETransfer(ETransfer eTransfer, ServiceContext serviceContext) throws SystemException, PortalException{
		Date now = new Date();
		ThemeDisplay themeDisplay = serviceContext.getThemeDisplay();
		User user = themeDisplay.getUser();
		
		long groupId = serviceContext.getScopeGroupId();
		long companyId = serviceContext.getCompanyId();
		long eTransferId = eTransfer.getETransferId();
		long userId = serviceContext.getUserId();
		String userName = user.getFirstName() + " " + user.getLastName();
		
		eTransfer.setCompanyId(companyId);
		eTransfer.setGroupId(groupId);
		eTransfer.setUserId(userId);
		eTransfer.setUserName(userName);
		eTransfer.setModifiedDate(now);
		eTransfer.setStatus(WorkflowConstants.STATUS_DRAFT);
		eTransfer.setStatusByUserId(serviceContext.getUserId());
		eTransfer.setStatusByUserName(userName);
		eTransfer.setStatusDate(serviceContext.getModifiedDate(now));
		eTransfer.setSubmittedDate(now);
		
		eTransferPersistence.update(eTransfer);
		
		// Approver Delegation
		long currentSupervisorUserId = SAPUserLocalServiceUtil.getSupervisorUserIdByStaffCode(eTransfer.getCurrentStaffCode());
		Role currentSupervisorRole = ApproverDelegationLocalServiceUtil.findAgentRoleByP_U(ApproverDelegationLocalServiceUtil.getProcessOfETransfer(), currentSupervisorUserId);
		serviceContext.setAttribute("vgcapon_e_transfer_current_supervisor", currentSupervisorRole);
		
		long receivingSupervisorUserId = SapPositionLocalServiceUtil.getSupervisorUserIdByPositionId(eTransfer.getSapPositionCode());
		Role receivingSupervisorRole = ApproverDelegationLocalServiceUtil.findAgentRoleByP_U(ApproverDelegationLocalServiceUtil.getProcessOfETransfer(), receivingSupervisorUserId);
		serviceContext.setAttribute("vgcapon_e_transfer_receiving_supervisor", receivingSupervisorRole);
		
		List<Role> delegationRoles = new ArrayList<Role>();
		delegationRoles = ApproverDelegationLocalServiceUtil.findAgentRolesByP_R(ApproverDelegationLocalServiceUtil.getProcessOfETransfer(), ETransferLogEnum.ORGATEAM.getRole());
		serviceContext.setAttribute("vgcapon_e_transfer_et_organization_partner", delegationRoles.toArray());
		
		delegationRoles.clear();
		delegationRoles = ApproverDelegationLocalServiceUtil.findAgentRolesByP_R(ApproverDelegationLocalServiceUtil.getProcessOfETransfer(), ETransferLogEnum.CONSULTING_MANAGER.getRole());
		serviceContext.setAttribute("vgcapon_e_transfer_et_controlling_manager", delegationRoles.toArray());
		
		// assetentry
		AssetEntry assetEntry = AssetEntryLocalServiceUtil.updateEntry(userId,
				groupId, eTransfer.getCreateDate(),
				eTransfer.getModifiedDate(),
				ETransfer.class.getName(), eTransferId,
				String.valueOf(eTransferId), 0,
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(), true, null, null, null,
				ContentTypes.TEXT_HTML, eTransfer.getTicketNo(), null,
				null, null, null, 0, 0, null, false);

		AssetLinkLocalServiceUtil.updateLinks(userId, assetEntry.getEntryId(),
				serviceContext.getAssetLinkEntryIds(),
				AssetLinkConstants.TYPE_RELATED);

		// indexer

		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(ETransfer.class);
		indexer.reindex(eTransfer);
		
		// workflow

		WorkflowHandlerRegistryUtil.startWorkflowInstance(
				eTransfer.getCompanyId(), eTransfer.getGroupId(),
				serviceContext.getUserId(), ETransfer.class.getName(),
				eTransfer.getPrimaryKey(), eTransfer,
				serviceContext);
		
		//Send email
		this.submittedSendEmailtoApprover(eTransfer);
		return eTransfer;
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
	
	//Send email to approver
	private void submittedSendEmailtoApprover(ETransfer eTransfer) throws SystemException {
		String cssContent = this.getCssContent();
		User applicant=UserLocalServiceUtil.fetchUserByFacebookId(PortalUtil.getDefaultCompanyId(),Long.valueOf(eTransfer.getCurrentStaffCode()));
//		String currentStaffCode=eTransfer.getCurrentStaffCode();
//		long currentSupervisorUserId=SAPUserLocalServiceUtil.getSupervisorUserIdByStaffCode(currentStaffCode);
//		User supervisorUser=UserLocalServiceUtil.fetchUser(currentSupervisorUserId);
//		String[] toAddresses=new String[]{supervisorUser.getEmailAddress()};
		User supervisor = this.findSupervisorUser(eTransfer);		
		String[] supervisorAddresses = ApproverDelegationLocalServiceUtil.findEmailsByP_U(ApproverDelegationLocalServiceUtil.getProcessOfETransfer(), supervisor);	
		String applicantUserName=applicant.getFirstName()+" "+applicant.getLastName();
		String subject = "E-Transfer Notification-"+eTransfer.getTicketNo()+"-Waiting for your approval";
		StringBuffer mailbody = new StringBuffer();
		mailbody.append("<div class='emailTmp'>")
				.append("<p>Dear Approver, </p>")
				.append("<p>HR consultant submitted E-Transfer application for <span class='value'>").append(applicantUserName).append("</span>. Please kindly view the details and do approval in <a href='").append(PropsUtil.get("vgc.apon.system.href.url")).append("'>APON System</a></p>")
				.append("<p>Thank you very much for your kindly support!</p>")
				.append("<p>PLEASE DO NOT REPLY to this email, as it is system generated.</p>")
				.append("</div>");
		GlobalEmailLocalServiceUtil.sendEmail(supervisorAddresses, null, subject, cssContent, mailbody.toString(), null);	
	}
	
	//Get the supervisor user from ETransfer
	public User findSupervisorUser(ETransfer eTransfer) throws SystemException {
		long currentStaffCode = Long.valueOf(eTransfer.getCurrentStaffCode());
		SAPUser sAPUser =SAPUserLocalServiceUtil.getSapUserByStaffCode(String.valueOf(currentStaffCode));					
		User assignUser = UserLocalServiceUtil.fetchUserByFacebookId(eTransfer.getCompanyId(), Integer.valueOf(sAPUser.getSupervisorFgId()));
		return assignUser;
	}
	// workflow status
	public ETransfer updateStatus(long userId, long eTransferId,
			int status, ServiceContext serviceContext) throws PortalException,
			SystemException {
		User user = userLocalService.getUser(userId);
		ETransfer eTransfer = getETransfer(eTransferId);
		eTransfer.setStatus(status);
		eTransfer.setStatusByUserId(userId);
		eTransfer.setStatusByUserName(user.getFullName());
		eTransfer.setStatusDate(new Date());
		updateETransfer(eTransfer);
		return eTransfer;
	}
	
	public List<ETransfer> findByS_U(int status, long userId) throws SystemException {
		return eTransferPersistence.findByS_U(status, userId);
	}

	// Update ETransfer
	public ETransfer updateETransfer(
			ETransfer eTransfer, ServiceContext serviceContext)
		throws SystemException{
		return super.updateETransfer(eTransfer);
	}
	
	@SuppressWarnings("unchecked")
	public List<ETransfer> findViewList(long userId)
			throws SystemException {
		if(isHasRole(userId, "ET HR Consultant")) {
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(ETransfer.class);	
			query.add(PropertyFactoryUtil.forName("userId").eq(userId));
			query.add(PropertyFactoryUtil.forName("status").eq(0));
			return dynamicQuery(query);
		}
		return new ArrayList<ETransfer>();
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
	
	// Save or update the audit trail log for workflow
	public void saveOrUpdateAuditTrailLog(long companyId, long groupId,
			long eTransferId,long operationUserId,String operationUser, String action,
			String operationComment) throws SystemException, PortalException {
		ETransfer eTransfer=ETransferLocalServiceUtil.fetchETransfer(eTransferId);
		Date now = new Date();

		String currentStaffCode=eTransfer.getCurrentStaffCode();
		long currentSupervisorUserId=SAPUserLocalServiceUtil.getSupervisorUserIdByStaffCode(currentStaffCode);
		long receivingSupervisorUserId=SapPositionLocalServiceUtil.getSupervisorUserIdByPositionId(eTransfer.getSapPositionCode());
		User currentSupervisorUser=UserLocalServiceUtil.fetchUser(currentSupervisorUserId);
		User receivingSupervisorUser=UserLocalServiceUtil.fetchUser(receivingSupervisorUserId);
		String currentSupervisorName = currentSupervisorUser!=null?currentSupervisorUser.getFirstName()+" "+currentSupervisorUser.getLastName():"Guest";
		String receivingSupervisorName = receivingSupervisorUser!=null?receivingSupervisorUser.getFirstName()+" "+receivingSupervisorUser.getLastName():"Guest";
		List<AuditTrailLog> list = AuditTrailLogLocalServiceUtil
				.findAuditTrailByWF_O_O(eTransferId,
						ETransfer.class.getName());
		int operationNo = this.getOperationNo(list);
		int currentOperationNo = this.getCurrentOperationNo(list);
		
		if (ActionConstants.SUBMIT.equals(action)) {
			if (list == null || list.size() == 0) {
				for (ETransferLogEnum eLogEnum : ETransferLogEnum
						.values()) {
					if (eLogEnum.getNumber() == 1) {
						AuditTrailLogLocalServiceUtil.saveAuditTrailLog(
								companyId, groupId, eTransferId,
								ETransfer.class.getName(),
								eLogEnum.getNumber(),getRoleTrailLogName(eLogEnum.getRole()),
								operationUser,
								ActionConstants.STATUS_SUBMITTED, now, "");
					} else {
						String approverUser = "";
						if(eLogEnum.getNumber()==99){
							approverUser = currentSupervisorName;
							AuditTrailLogLocalServiceUtil.saveAuditTrailLog(
									companyId, groupId, eTransferId,
									ETransfer.class.getName(),
									eLogEnum.getNumber(),getRoleTrailLogName(eLogEnum.getRole()),
									approverUser,
									ActionConstants.STATUS_PENDING_TO_APPROVE, null,"");
						}else if(eLogEnum.getNumber()==100){
							approverUser = receivingSupervisorName;
							AuditTrailLogLocalServiceUtil.saveAuditTrailLog(
									companyId, groupId, eTransferId,
									ETransfer.class.getName(),
									eLogEnum.getNumber(),getRoleTrailLogName(eLogEnum.getRole()),
									approverUser,
									ActionConstants.STATUS_PENDING_TO_APPROVE, null,"");
						}else{
							approverUser = this.getOperationUserByRoleName(
									companyId, eLogEnum.getRole());
							AuditTrailLogLocalServiceUtil.saveAuditTrailLog(
									companyId, groupId, eTransferId,
									ETransfer.class.getName(),
									eLogEnum.getNumber(),getRoleTrailLogName(eLogEnum.getRole()),
									approverUser,
									ActionConstants.STATUS_PENDING_TO_APPROVE, null,"");
						}
					}
				}
			}else{
				AuditTrailLogLocalServiceUtil.saveAuditTrailLog(companyId,
						groupId, eTransferId,
						ETransfer.class.getName(), operationNo,getRoleTrailLogName(ETransferLogEnum.APPLICANT.getRole()),
						operationUser, ActionConstants.STATUS_SUBMITTED, now,
						"");
			}
		}else if (ActionConstants.RECALL.equals(action)) {
			AuditTrailLogLocalServiceUtil.saveAuditTrailLog(
					companyId, groupId, eTransferId,
					ETransfer.class.getName(),
					operationNo,getRoleTrailLogName(ETransferLogEnum.APPLICANT.getRole()),
					operationUser,
					ActionConstants.STATUS_RECALL, now,"");
				
				for (ETransferLogEnum eLogEnum : ETransferLogEnum
						.values()) {
					if (eLogEnum.getNumber() != 1&&eLogEnum.getNumber()>operationNo) {
						AuditTrailLog AuditTrailLog1= AuditTrailLogLocalServiceUtil.findAuditTrailByWF_C_O_O_O(companyId, eTransferId, ETransfer.class.getName(), eLogEnum.getNumber());
						if(AuditTrailLog1!=null){
							AuditTrailLogLocalServiceUtil.deleteAuditTrailLog(AuditTrailLog1);
						}
					}
				}
				for (ETransferLogEnum eLogEnum : ETransferLogEnum
						.values()) {
					if (eLogEnum.getNumber() != 1) {
						String approverUser = "";
						if(eLogEnum.getNumber()==99){
							approverUser = currentSupervisorName;
							AuditTrailLogLocalServiceUtil.saveAuditTrailLog(
									companyId, groupId, eTransferId,
									ETransfer.class.getName(),
									eLogEnum.getNumber(),getRoleTrailLogName(eLogEnum.getRole()),
									approverUser,
									ActionConstants.STATUS_PENDING_TO_APPROVE, null,"");
						}else if(eLogEnum.getNumber()==100){
							approverUser = receivingSupervisorName;
							AuditTrailLogLocalServiceUtil.saveAuditTrailLog(
									companyId, groupId, eTransferId,
									ETransfer.class.getName(),
									eLogEnum.getNumber(),getRoleTrailLogName(eLogEnum.getRole()),
									approverUser,
									ActionConstants.STATUS_PENDING_TO_APPROVE, null,"");
						}else{
							approverUser = this.getOperationUserByRoleName(
									companyId, eLogEnum.getRole());
							AuditTrailLogLocalServiceUtil.saveAuditTrailLog(
									companyId, groupId, eTransferId,
									ETransfer.class.getName(),
									eLogEnum.getNumber(),getRoleTrailLogName(eLogEnum.getRole()),
									approverUser,
									ActionConstants.STATUS_PENDING_TO_APPROVE, null,"");
						}
					}
				}
		}else{
			if (ActionConstants.APPROVE.equals(action)||ActionConstants.COMPLETE.equals(action)) {
				for (AuditTrailLog auditTrailLog : list) {
					boolean isBreak=false;
					for (ETransferLogEnum eLogEnum : ETransferLogEnum
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
				AuditTrailLog auditTrailLog = AuditTrailLogLocalServiceUtil.findAuditTrailByWF_C_O_O_O(companyId, eTransferId, ETransfer.class.getName(),currentOperationNo);
				if(auditTrailLog!=null&&auditTrailLog.getOperationStatus().equals(ActionConstants.STATUS_PENDING_TO_APPROVE)) {
					auditTrailLog.setOperationUser(operationUser);
					auditTrailLog.setOperationStatus(ActionConstants.STATUS_REJECTED);
					auditTrailLog.setOperationComment(operationComment);
					auditTrailLog.setOperationNo(operationNo);
					auditTrailLog.setOperationTime(now);
					AuditTrailLogLocalServiceUtil.updateAuditTrailLog(auditTrailLog);
					
					for (ETransferLogEnum eLogEnum : ETransferLogEnum
							.values()) {
						if (eLogEnum.getNumber() != 1&&eLogEnum.getNumber()>currentOperationNo) {
							AuditTrailLog AuditTrailLog1= AuditTrailLogLocalServiceUtil.findAuditTrailByWF_C_O_O_O(companyId, eTransferId, ETransfer.class.getName(), eLogEnum.getNumber());
							if(AuditTrailLog1!=null){
								AuditTrailLogLocalServiceUtil.deleteAuditTrailLog(AuditTrailLog1);
							}
						}
					}
					for (ETransferLogEnum eLogEnum : ETransferLogEnum
							.values()) {
						if (eLogEnum.getNumber() != 1) {
							String approverUser = "";
							if(eLogEnum.getNumber()==99){
								approverUser = currentSupervisorName;
								AuditTrailLogLocalServiceUtil.saveAuditTrailLog(
										companyId, groupId, eTransferId,
										ETransfer.class.getName(),
										eLogEnum.getNumber(),getRoleTrailLogName(eLogEnum.getRole()),
										approverUser,
										ActionConstants.STATUS_PENDING_TO_APPROVE, null,"");
							}else if(eLogEnum.getNumber()==100){
								approverUser = receivingSupervisorName;
								AuditTrailLogLocalServiceUtil.saveAuditTrailLog(
										companyId, groupId, eTransferId,
										ETransfer.class.getName(),
										eLogEnum.getNumber(),getRoleTrailLogName(eLogEnum.getRole()),
										approverUser,
										ActionConstants.STATUS_PENDING_TO_APPROVE, null,"");
							}else{
								approverUser = this.getOperationUserByRoleName(
										companyId, eLogEnum.getRole());
								AuditTrailLogLocalServiceUtil.saveAuditTrailLog(
										companyId, groupId, eTransferId,
										ETransfer.class.getName(),
										eLogEnum.getNumber(),getRoleTrailLogName(eLogEnum.getRole()),
										approverUser,
										ActionConstants.STATUS_PENDING_TO_APPROVE, null,"");
							}
						}
					}
				}
			}
		}
	}
	
	public String getRoleTrailLogName(String roleName){
		String roleTrailLogName="";
		if("ET HR Consultant".equals(roleName)){
			roleTrailLogName="HR Consultant";
		}else if("Current Dept. Supervisor".equals(roleName)){
			roleTrailLogName=roleName;
		}else if("Receiving Dept. Supervisor".equals(roleName)){
			roleTrailLogName=roleName;
		}else if("ET Organization Partner".equals(roleName)){
			roleTrailLogName="Organization Partner";
		}else if("ET Controlling Manager".equals(roleName)){
			roleTrailLogName="Controlling Manager";
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
	public String getOperationUserByRoleName(long companyId, String roleName)
			throws PortalException, SystemException {
		String operationUser = "";
		Role role = RoleLocalServiceUtil.getRole(companyId, roleName);
		List<User> users = UserLocalServiceUtil.getRoleUsers(role.getRoleId());
		for (User user : users) {
			operationUser = user.getFirstName() + " " + user.getLastName()
					+ ",";
		}
		if(operationUser.length()>0) {
			return operationUser.substring(0, operationUser.length() - 1);
		}else {
			return "";
		}		
	}
}