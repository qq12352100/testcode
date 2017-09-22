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

package com.seatoffice.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.audit.trail.model.AuditTrailLog;
import com.audit.trail.service.AuditTrailLogLocalServiceUtil;
import com.delegation.model.ApplicantDelegation;
import com.delegation.service.ApplicantDelegationLocalServiceUtil;
import com.delegation.service.ApproverDelegationLocalServiceUtil;
import com.global.management.service.GlobalEmailLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
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
import com.seatoffice.model.SeatOffice;
import com.seatoffice.service.SeatOfficeLocalServiceUtil;
import com.seatoffice.service.base.SeatOfficeLocalServiceBaseImpl;
import com.seatoffice.util.ActionConstants;
import com.seatoffice.util.OfficeSiteEnum;
import com.seatoffice.util.SeatOfficeLogEnum;
import com.seatoffice.util.SeatOfficePositionLevelEnum;
import com.vgc.apon.model.SAPUser;
import com.vgc.apon.service.SAPUserLocalServiceUtil;

/**
 * The implementation of the seat office local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.seatoffice.service.SeatOfficeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Alice.zou
 * @see com.seatoffice.service.base.SeatOfficeLocalServiceBaseImpl
 * @see com.seatoffice.service.SeatOfficeLocalServiceUtil
 */
public class SeatOfficeLocalServiceImpl extends SeatOfficeLocalServiceBaseImpl {
	private static Log _log = LogFactoryUtil
			.getLog(SeatOfficeLocalServiceImpl.class);
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.seatoffice.service.SeatOfficeLocalServiceUtil} to access the seat office local service.
	 */
	
	// workflow status
		public SeatOffice updateStatus(long userId, long seatOfficeId,
				int status, ServiceContext serviceContext) throws PortalException,
				SystemException {
			User user = userLocalService.getUser(userId);
			SeatOffice seatOffice = getSeatOffice(seatOfficeId);
			seatOffice.setStatus(status);
			seatOffice.setStatusByUserId(userId);
			seatOffice.setStatusByUserName(user.getFullName());
			seatOffice.setStatusDate(new Date());
			updateSeatOffice(seatOffice, serviceContext);
			return seatOffice;
		}
		public SeatOffice updateSeatOffice(
				SeatOffice seatOffice, ServiceContext serviceContext)
				throws SystemException, PortalException {
			return super.updateSeatOffice(seatOffice);
		}
		@Indexable(type = IndexableType.REINDEX)
		@Override
		public SeatOffice updateSeatOffice(
				SeatOffice seatOffice) throws SystemException {
			return seatOfficePersistence.update(seatOffice);
		}
		// Save or Update the SeatOffice
		public SeatOffice saveOrUpdateSeatOffice(
				SeatOffice SeatOffice, ServiceContext serviceContext)
				throws PortalException, SystemException {
			Date now = new Date();
			long groupId = serviceContext.getScopeGroupId();
			long companyId = serviceContext.getCompanyId();
			ThemeDisplay themeDisplay = serviceContext.getThemeDisplay();
			String userName = themeDisplay.getUser().getFirstName()+" "+ themeDisplay.getUser().getLastName();
			SeatOffice.setCompanyId(companyId);
			SeatOffice.setGroupId(groupId);
			SeatOffice.setUserId(serviceContext.getUserId());
			SeatOffice.setUserName(userName);
			SeatOffice.setModifiedDate(serviceContext.getCreateDate(now));
			// workflow field
			SeatOffice.setStatus(WorkflowConstants.STATUS_DRAFT);
			SeatOffice.setStatusByUserId(serviceContext.getUserId());
			SeatOffice.setStatusByUserName(userName);
			SeatOffice.setStatusDate(serviceContext.getModifiedDate(now));
			SeatOffice = seatOfficePersistence.update(SeatOffice);
			long staffCode=SeatOffice.getStaffCode();
//			long assigneSupervisorUserId = SAPUserLocalServiceUtil.getSupervisorUserIdByStaffCode(String.valueOf(staffCode));
//			serviceContext.setAttribute("vgcapon_seatOffice_supervisor", assigneSupervisorUserId);
			long supervisorUserId=SAPUserLocalServiceUtil.getSupervisorUserIdByStaffCode(String.valueOf(staffCode));
			Role supervisorRole = ApproverDelegationLocalServiceUtil.findAgentRoleByP_U(ApproverDelegationLocalServiceUtil.getProcessOfSeatOffice(), supervisorUserId);
			serviceContext.setAttribute("vgcapon_seatOffice_supervisor", supervisorRole);
			List<Role> adminRoles = ApproverDelegationLocalServiceUtil.findAgentRolesByP_R(ApproverDelegationLocalServiceUtil.getProcessOfSeatOffice(),"SO_Admin Seat Management");
			serviceContext.setAttribute("vgcapon_SO_Admin_Seat_Management", adminRoles.toArray());
			List<Role> headAdminRoles = ApproverDelegationLocalServiceUtil.findAgentRolesByP_R(ApproverDelegationLocalServiceUtil.getProcessOfSeatOffice(),"SO_Head of Admin");
			serviceContext.setAttribute("vgcapon_SO_Head_of_Admin", headAdminRoles.toArray());
			 String positionFg=SeatOffice.getPositionFlag();
			serviceContext.setAttribute("vgcapon_seatOffice_positionFg",positionFg);
			
			return SeatOffice;
		}

		// Submit the SeatOffice to start the workflow
		public SeatOffice submitSeatOffice(
				SeatOffice seatOffice, ServiceContext serviceContext)
				throws PortalException, SystemException {
			long groupId = serviceContext.getScopeGroupId();
			long companyId = serviceContext.getCompanyId();
			long seatOfficeId = seatOffice.getSeatId();
			long userId = serviceContext.getUserId();
			ThemeDisplay themeDisplay = serviceContext.getThemeDisplay();
			String userName = themeDisplay.getUser().getFirstName()+" "+ themeDisplay.getUser().getLastName();
			Date now = new Date();
			seatOffice.setCompanyId(companyId);
			seatOffice.setGroupId(groupId);
			seatOffice.setUserId(serviceContext.getUserId());
			seatOffice.setUserName(userName);
			seatOffice.setModifiedDate(serviceContext.getCreateDate(now));
			// workflow field
			seatOffice.setStatus(WorkflowConstants.STATUS_DRAFT);
			seatOffice.setStatusByUserId(serviceContext.getUserId());
			seatOffice.setStatusByUserName(userName);
			seatOffice.setStatusDate(serviceContext.getModifiedDate(now));
			seatOffice.setModifiedDate(now);
			seatOfficePersistence.update(seatOffice);
			long staffCode=seatOffice.getStaffCode();
		//	long assigneSupervisorUserId = SAPUserLocalServiceUtil.getSupervisorUserIdByStaffCode(String.valueOf(staffCode));
		
			long supervisorUserId=SAPUserLocalServiceUtil.getSupervisorUserIdByStaffCode(String.valueOf(staffCode));
			Role supervisorRole = ApproverDelegationLocalServiceUtil.findAgentRoleByP_U(ApproverDelegationLocalServiceUtil.getProcessOfSeatOffice(), supervisorUserId);
			serviceContext.setAttribute("vgcapon_seatOffice_supervisor", supervisorRole);
			List<Role> adminRoles = ApproverDelegationLocalServiceUtil.findAgentRolesByP_R(ApproverDelegationLocalServiceUtil.getProcessOfSeatOffice(),"SO_Admin Seat Management");
			serviceContext.setAttribute("vgcapon_SO_Admin_Seat_Management", adminRoles.toArray());
			List<Role> headAdminRoles = ApproverDelegationLocalServiceUtil.findAgentRolesByP_R(ApproverDelegationLocalServiceUtil.getProcessOfSeatOffice(),"SO_Head of Admin");
			serviceContext.setAttribute("vgcapon_SO_Head_of_Admin", headAdminRoles.toArray());
			String positionFg=seatOffice.getPositionFlag();
			//System.out.println("positionFg======1==============="+positionFg);
//			long currentCategory=seatOffice.getCurrentCategory();
//			long newCategory=0;
//			 String sg=seatOffice.getSg();
//			 String leadingMark=seatOffice.getLeadingMark();
//			 String officeSite=seatOffice.getOfficeSite();
//			 String empty="";
//			 if(SeatOfficePositionLevelEnum.getLevel(sg)>=SeatOfficePositionLevelEnum.N.getLevel()){
//				 newCategory=SeatOfficeCategoryEnum.SingleOffice.getNumber();//sigle office
//			 }
//			 else{
//				 if(SeatOfficePositionLevelEnum.getLevel(sg)>=SeatOfficePositionLevelEnum.L.getLevel()&&(!(empty.equalsIgnoreCase(leadingMark))))
//				 {
//					 if((OfficeSiteEnum.ACB.getIndex()).equalsIgnoreCase(officeSite)){
//						 newCategory=SeatOfficeCategoryEnum.TeamLeaderSeat.getNumber();//sigle office
//						 
//					 }
//					 else{
//						 newCategory=SeatOfficeCategoryEnum.TwinOffice.getNumber();//sigle office
//					 }
//				 }
//				 else{
//					 newCategory=SeatOfficeCategoryEnum.Workstation.getNumber();//sigle office 
//				 }
//			 }
//			for (SeatOfficeCategoryEnum eEnum : SeatOfficeCategoryEnum.values()) {
//			 if(currentCategory==eEnum.Workstation.getNumber()&&newCategory==eEnum.SingleOffice.getNumber()){
//				 positionFg="Yes";
//			 }
//			 else if(currentCategory==eEnum.Workstation.getNumber()&&newCategory==eEnum.TwinOffice.getNumber()){
//				 positionFg="Yes";
//			 }
//			 else if(currentCategory==eEnum.TwinOffice.getNumber()&&newCategory==eEnum.SingleOffice.getNumber()){
//				 positionFg="Yes";
//			 }
//			 else if(currentCategory==eEnum.TeamLeaderSeat.getNumber()&&newCategory==eEnum.SingleOffice.getNumber()){
//				 positionFg="Yes";
//			 }
//			 else {
//				 positionFg="No";
//			 }
//			}
		//	seatOffice.setPositionFlag(positionFg);
			serviceContext.setAttribute("vgcapon_seatOffice_positionFg",positionFg);
			
			
			// Add SeatOffice to assetentry
			AssetEntry assetEntry = AssetEntryLocalServiceUtil.updateEntry(userId,
					groupId, seatOffice.getCreateDate(),
					seatOffice.getModifiedDate(),
					SeatOffice.class.getName(), seatOfficeId,
					String.valueOf(seatOfficeId), 0,
					serviceContext.getAssetCategoryIds(),
					serviceContext.getAssetTagNames(), true, null, null, null,
					ContentTypes.TEXT_HTML, seatOffice.getTicketNo(), null,
					null, null, null, 0, 0, null, false);
			AssetLinkLocalServiceUtil.updateLinks(userId, assetEntry.getEntryId(),
					serviceContext.getAssetLinkEntryIds(),
					AssetLinkConstants.TYPE_RELATED);

			Indexer indexer = IndexerRegistryUtil
					.nullSafeGetIndexer(SeatOffice.class);

			indexer.reindex(seatOffice);

			// workflow
			WorkflowHandlerRegistryUtil.startWorkflowInstance(
					seatOffice.getCompanyId(), seatOffice.getGroupId(),
					serviceContext.getUserId(), SeatOffice.class.getName(),
					seatOffice.getPrimaryKey(), seatOffice,
					serviceContext);	
			//Send email
			this.submittedSendEmailtoApprover(seatOffice);
			return seatOffice;
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
		private void submittedSendEmailtoApprover(SeatOffice SeatOffice) throws SystemException {
			String subject = "Seat & Office Moving Application- "+OfficeSiteEnum.getName(SeatOffice.getOfficeSite())+"-"+SeatOffice.getTicketNo()+".-Waiting for your Approval";
			String cssContent = this.getCssContent();
			//String[] toAddresses = GlobalEmailLocalServiceUtil.getRolesOfUsersEmailAddresses(new String[]{SeatOfficeLogEnum.ADMINSEAT.getRole()});		
			String[] toAddresses =ApproverDelegationLocalServiceUtil.findEmailsByP_R(ApproverDelegationLocalServiceUtil.getProcessOfSeatOffice(),SeatOfficeLogEnum.ADMINSEAT.getRole());
			StringBuffer mailbody = new StringBuffer();
			mailbody.append("<div class='emailTmp'>")
					.append("<p>Dear Approver, </p>")
					.append("<p><span class='value'>").append(SeatOffice.getStaffName()).append("</span> submitted seat & office moving application.")
					.append("Please kindly approve, reject or complete it in <a href='").append(PropsUtil.get("vgc.apon.system.href.url")).append("'>APON System</a>")
					.append("<p><span class='warning02'>PLEASE DO NOT REPLY</span> to this email, as it is system generated.</p>")
					.append("</div>");
			GlobalEmailLocalServiceUtil.sendEmail(toAddresses, null, subject, cssContent, mailbody.toString(), null);		
		}
		
		
		//Get the supervisor user from SeatOffice
		public User findSupervisorUser(SeatOffice seatOffice) throws SystemException {
			long staffCode = seatOffice.getStaffCode();
			SAPUser sAPUser =SAPUserLocalServiceUtil.getSapUserByStaffCode(String.valueOf(staffCode));					
			User assignUser = UserLocalServiceUtil.fetchUserByFacebookId(seatOffice.getCompanyId(), Integer.valueOf(sAPUser.getSupervisorFgId()));
			return assignUser;
		}

		

		// Get the first company car list according status and userid
		public List<SeatOffice> findByS_U(int status, long userId)
				throws SystemException {
			return seatOfficePersistence.findByS_U(status, userId);
		}

		// Save or update the audit trail log for workflow
		public void saveOrUpdateAuditTrailLog(long companyId, long groupId,
				long seatOfficeId, long userId,String operationUser, String action,
				String operationComment) throws SystemException, PortalException {
			Date now = new Date();
			SeatOffice seatOffice = SeatOfficeLocalServiceUtil.fetchSeatOffice(seatOfficeId);
			long staffCode = seatOffice.getStaffCode();
			SAPUser sAPUser =SAPUserLocalServiceUtil.getSapUserByStaffCode(String.valueOf(staffCode));	
//			String comment = "";
//			String sg=sAPUser!=null?sAPUser.getSg():"";
//			int level=SeatOfficePositionLevelEnum.getLevel(sg);
//			if(seatOffice.getIsApplicantAgent()) {
//				comment = operationUser+" "+LanguageUtil.get(LocaleUtil.getDefault(), "vgc.apon.on.behalf.of")+" "+sAPUser.getFirstName()+" "+sAPUser.getLastName();
//			}
			User supervisorUser = UserLocalServiceUtil.fetchUserByFacebookId(companyId, Integer.valueOf(sAPUser.getSupervisorFgId()));		
			String supervisorName = supervisorUser!=null?supervisorUser.getFirstName()+" "+supervisorUser.getLastName():"Guest";
			List<AuditTrailLog> list = AuditTrailLogLocalServiceUtil
					.findAuditTrailByWF_O_O(seatOfficeId,
							SeatOffice.class.getName());
			int operationNo = this.getOperationNo(list);
			int currentOperationNo = this.getCurrentOperationNo(list);
			String headAdiminFlag="Yes";
			String positionFg=seatOffice.getPositionFlag();	
			if (ActionConstants.SUBMIT.equals(action)) {
				String submitComment = "";
				if(seatOffice.getIsApplicantAgent()) {
					ApplicantDelegation applicantDelegation = ApplicantDelegationLocalServiceUtil.fetchByP_S(
							ApproverDelegationLocalServiceUtil.getProcessOfSeatOffice(), String.valueOf(UserLocalServiceUtil.fetchUserById(seatOffice.getUserId()).getFacebookId()));
					submitComment = LanguageUtil.get(LocaleUtil.getDefault(), "vgc.apon.on.behalf.of")+ApplicantDelegationLocalServiceUtil.getAgentName(applicantDelegation);
				}
				if (list == null || list.size() == 0) {
					for (SeatOfficeLogEnum eLogEnum : SeatOfficeLogEnum
							.values()) {
						if (eLogEnum.getNumber() == 1) {
							AuditTrailLogLocalServiceUtil.saveAuditTrailLog(
									companyId, groupId, seatOfficeId,
									SeatOffice.class.getName(),
									eLogEnum.getNumber(),getRoleTrailLogName(eLogEnum.getRole()),
									operationUser,
									ActionConstants.STATUS_SUBMITTED, now, submitComment);
						} else {
							String approverUser = "";
							if(eLogEnum.getNumber()==101){
									approverUser = supervisorName;
									AuditTrailLogLocalServiceUtil.saveAuditTrailLog(
											companyId, groupId, seatOfficeId,
											SeatOffice.class.getName(),
											eLogEnum.getNumber(),getRoleTrailLogName(eLogEnum.getRole()),
											approverUser,
											ActionConstants.STATUS_PENDING_TO_APPROVE, null,"");
								
							}else{
								if(eLogEnum.getNumber()==102){
								
								if(headAdiminFlag.equalsIgnoreCase(positionFg)){
									approverUser = this.getOperationUserByRoleName(
											companyId, eLogEnum.getRole());
									
									AuditTrailLogLocalServiceUtil.saveAuditTrailLog(
											companyId, groupId, seatOfficeId,
											SeatOffice.class.getName(),
											eLogEnum.getNumber(),getRoleTrailLogName(eLogEnum.getRole()),
											approverUser,
											ActionConstants.STATUS_PENDING_TO_APPROVE, null,"");
									
								}
								}
								else{
									approverUser = this.getOperationUserByRoleName(
											companyId, eLogEnum.getRole());
									
									AuditTrailLogLocalServiceUtil.saveAuditTrailLog(
											companyId, groupId, seatOfficeId,
											SeatOffice.class.getName(),
											eLogEnum.getNumber(),getRoleTrailLogName(eLogEnum.getRole()),
											approverUser,
											ActionConstants.STATUS_PENDING_TO_APPROVE, null,"");
								}
								
							}
						}
					}
				}else{
					
					AuditTrailLogLocalServiceUtil.saveAuditTrailLog(companyId,
							groupId, seatOfficeId,
							SeatOffice.class.getName(), operationNo,
							getRoleTrailLogName(SeatOfficeLogEnum.APPLICANT.getRole()),
							operationUser, ActionConstants.STATUS_SUBMITTED, now,
							submitComment);
						for (SeatOfficeLogEnum eLogEnum : SeatOfficeLogEnum
								.values()) {
							if (eLogEnum.getNumber() != 1&&eLogEnum.getNumber()>operationNo) {
								AuditTrailLog AuditTrailLog1= AuditTrailLogLocalServiceUtil.findAuditTrailByWF_C_O_O_O(companyId, seatOfficeId, SeatOffice.class.getName(), eLogEnum.getNumber());
								if(AuditTrailLog1!=null){
									AuditTrailLogLocalServiceUtil.deleteAuditTrailLog(AuditTrailLog1);
								}
							}
						}
						for (SeatOfficeLogEnum eLogEnum : SeatOfficeLogEnum
								.values()) {
							if (eLogEnum.getNumber() != 1) {
								String approverUser = "";
								if(eLogEnum.getNumber()==101){
										approverUser = supervisorName;
										AuditTrailLogLocalServiceUtil.saveAuditTrailLog(
												companyId, groupId, seatOfficeId,
												SeatOffice.class.getName(),
												eLogEnum.getNumber(),getRoleTrailLogName(eLogEnum.getRole()),
												approverUser,
												ActionConstants.STATUS_PENDING_TO_APPROVE, null,"");
								}
								else if(eLogEnum.getNumber()==102){
									
									if(headAdiminFlag.equalsIgnoreCase(positionFg)){
										approverUser = this.getOperationUserByRoleName(
												companyId, eLogEnum.getRole());
										AuditTrailLogLocalServiceUtil.saveAuditTrailLog(
												companyId, groupId, seatOfficeId,
												SeatOffice.class.getName(),
												eLogEnum.getNumber(),getRoleTrailLogName(eLogEnum.getRole()),
												approverUser,
												ActionConstants.STATUS_PENDING_TO_APPROVE, null,"");
										
									}
									}
	                       else{
								
								approverUser = this.getOperationUserByRoleName(
										companyId, eLogEnum.getRole());
								AuditTrailLogLocalServiceUtil.saveAuditTrailLog(
										companyId, groupId, seatOfficeId,
										SeatOffice.class.getName(),
										eLogEnum.getNumber(),getRoleTrailLogName(eLogEnum.getRole()),
										approverUser,
										ActionConstants.STATUS_PENDING_TO_APPROVE, null,"");
							}
								
							}
						}
					
				}
			     
				
			} else if (ActionConstants.RECALL.equals(action)) {
				AuditTrailLogLocalServiceUtil.saveAuditTrailLog(
						companyId, groupId, seatOfficeId,
						SeatOffice.class.getName(),
						operationNo,getRoleTrailLogName(SeatOfficeLogEnum.APPLICANT.getRole()),
						operationUser,
						ActionConstants.STATUS_RECALL, now,"");
			} else {
				if (ActionConstants.APPROVE.equals(action)) {
					for (AuditTrailLog auditTrailLog : list) {
						boolean isBreak=false;
						for (SeatOfficeLogEnum eLogEnum : SeatOfficeLogEnum
								.values()) {
							if (eLogEnum.getNumber()!=1&&auditTrailLog.getOperationNo()==eLogEnum.getNumber()) {
								auditTrailLog.setOperationUserId(userId);
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
				
				} else if (ActionConstants.REJECT.equals(action)) {

					AuditTrailLog auditTrailLog = AuditTrailLogLocalServiceUtil.findAuditTrailByWF_C_O_O_O(companyId, seatOfficeId, SeatOffice.class.getName(),currentOperationNo);
					if(auditTrailLog!=null&&auditTrailLog.getOperationStatus().equals(ActionConstants.STATUS_PENDING_TO_APPROVE)) {
						auditTrailLog.setOperationUser(operationUser);
						auditTrailLog.setOperationStatus(ActionConstants.STATUS_REJECTED);
						auditTrailLog.setOperationComment(operationComment);
						auditTrailLog.setOperationNo(operationNo);
						auditTrailLog.setOperationTime(now);
						AuditTrailLogLocalServiceUtil.updateAuditTrailLog(auditTrailLog);
					}
				
					
				} else if (ActionConstants.COMPLETE.equals(action)
						|| ActionConstants.CANCEL.equals(action)) {
					for (AuditTrailLog auditTrailLog : list) {
						boolean isBreak=false;
						for (SeatOfficeLogEnum eLogEnum : SeatOfficeLogEnum
								.values()) {
							//System.out.println("-----eLogEnum.getNumber()-1--------"+eLogEnum.getNumber());
							if (eLogEnum.getNumber()!=1&&auditTrailLog.getOperationNo()==eLogEnum.getNumber()) {
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
							isBreak=true;
							}
						}
						if(isBreak){
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
			}else if("SO_Admin Seat Management".equals(roleName)){
				roleTrailLogName="Admin Seat Management";
			}else if("SO_Head of Admin".equals(roleName)){
				roleTrailLogName="Head of Admin";
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
		//	System.out.println("---------roleName-1-----"+roleName);
			Role role = RoleLocalServiceUtil.getRole(companyId, roleName);
		//	System.out.println("---------roleName-2-----"+role.getName()+"-----"+role.getUserId());
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
		
		public String generateTicketNo(String prefix) {
			Date date = new Date();
			DateFormat dateFormat = new SimpleDateFormat("yyyyMM");
			String name = prefix + dateFormat.format(date);
			long number;
			try {
				number = counterLocalService.increment(name, 1);
				return name + String.format("%07d",number,1);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return name;
		}
}