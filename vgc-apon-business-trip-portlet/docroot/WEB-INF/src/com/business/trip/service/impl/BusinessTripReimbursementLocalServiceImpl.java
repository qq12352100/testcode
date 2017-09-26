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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.audit.trail.model.AuditTrailLog;
import com.audit.trail.service.AuditTrailLogLocalServiceUtil;
import com.business.trip.model.BusinessTripReimbursement;
import com.business.trip.service.BtCostListLocalServiceUtil;
import com.business.trip.service.BtHotelInfoLocalServiceUtil;
import com.business.trip.service.BtTravelExpenseLocalServiceUtil;
import com.business.trip.service.BusinessTripReimbursementLocalServiceUtil;
import com.business.trip.service.base.BusinessTripReimbursementLocalServiceBaseImpl;
import com.business.trip.util.ActionConstants;
import com.business.trip.util.BusinessTripReimbursementLogEnum;
import com.business.trip.util.DateUtil;
import com.delegation.model.ApplicantDelegation;
import com.delegation.service.ApplicantDelegationLocalServiceUtil;
import com.delegation.service.ApproverDelegationLocalServiceUtil;
import com.global.management.service.GlobalEmailLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
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

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * The implementation of the business trip reimbursement local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.business.trip.service.BusinessTripReimbursementLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.business.trip.service.base.BusinessTripReimbursementLocalServiceBaseImpl
 * @see com.business.trip.service.BusinessTripReimbursementLocalServiceUtil
 */
public class BusinessTripReimbursementLocalServiceImpl
	extends BusinessTripReimbursementLocalServiceBaseImpl {
	
	public List<Object[]> reimbursementTravelForReport(String travelType, String ticketNo, int status, String periodStart,String periodEnd){
		Session session = null;
		try {
			session = businessTripReimbursementPersistence.openSession();
			StringBuilder query = new StringBuilder();
			query.append("SELECT br.TICKETNO,br.COSTCENTER,br.DEPARTMENT,br.STAFFCODE,br.PRINTNAME,br.VISITCOUNTRIESCITIES,br.DEPARTUREDATE,br.RETURNDATE");//前7个一样
			if(travelType.equals("0")){//0-国内单子
				//8,9
				query.append(" ,'RMB',br.TOTALTRAVELEXPENSERMB");
				//10
				query.append(" ,(SELECT sum(CO.PAYMENTAMOUNT) from VGCAPON_BTCOSTLIST co where CO.BUSINESSTRIPPKID = BR.BUSINESSTRIPREIMBURSEMENTID and (CO.ITEM like 'Accommodation-International' or CO.ITEM like 'Accommodation-Domestic'))");
				//11=10-12
				query.append(" ,trunc((SELECT sum(CO.PAYMENTAMOUNT) from VGCAPON_BTCOSTLIST co where CO.BUSINESSTRIPPKID = BR.BUSINESSTRIPREIMBURSEMENTID and (CO.ITEM like 'Accommodation-International' or CO.ITEM like 'Accommodation-Domestic'))*(1-1/1.06),2)");
				//12=10/1.06
				query.append(" ,trunc((SELECT sum(CO.PAYMENTAMOUNT) from VGCAPON_BTCOSTLIST co where CO.BUSINESSTRIPPKID = BR.BUSINESSTRIPREIMBURSEMENTID and (CO.ITEM like 'Accommodation-International' or CO.ITEM like 'Accommodation-Domestic'))/1.06,2)");
				//13=14-10
				query.append(" ,br.COSTLISTFOREIGNTOTALRMB-(SELECT sum(CO.PAYMENTAMOUNT) from VGCAPON_BTCOSTLIST co where CO.BUSINESSTRIPPKID = BR.BUSINESSTRIPREIMBURSEMENTID and (CO.ITEM like 'Accommodation-International' or CO.ITEM like 'Accommodation-Domestic'))");
				//14
				query.append(" ,br.COSTLISTFOREIGNTOTALRMB");
				//15,???
				query.append(" ,bt.ADVANCEPAYMENT");
				//16=14-15
				query.append(" ,br.COSTLISTFOREIGNTOTALRMB-bt.ADVANCEPAYMENT");
				//17=16+9
				query.append(" ,br.COSTLISTFOREIGNTOTALRMB-bt.ADVANCEPAYMENT+br.TOTALTRAVELEXPENSERMB");
			}else{//1-国际单子
				//8如员工勾选了get RMB,把国际sheet 里J列的币种改为RMB即可
				query.append(" ,DECODE(br.ISPAYBYRMB,1,'RMB','EUR')");
				//9如员工勾选了get RMB,VGCAPON_BTTRAVELEXPENSE查rmb总和
				query.append(" ,DECODE(br.ISPAYBYRMB,1,(SELECT sum(TR.ALLOWANCERMB) from VGCAPON_BTTRAVELEXPENSE tr where TR.BUSINESSTRIPPKID=BR.BUSINESSTRIPREIMBURSEMENTID and TR.CURRENCY_='EUR'),br.TOTALTRAVELEXPENSEEUR)");
				//10如员工勾选了get RMB,列出COSTLISTFOREIGNTOTALRMB
				query.append(" ,DECODE(br.ISPAYBYRMB,1,br.COSTLISTFOREIGNTOTALRMB,br.COSTLISTFOREIGNTOTALEUR)");
				//11,如果cash advance选的是EUR，是点不了get RMB的，所以8-12都是EUR，如果cash advance选得是RMB，不管点不点get RMB都放后面20
				query.append(" ,DECODE(bt.CURRENCY_,'EUR',bt.ADVANCEPAYMENT,0)");
				//12=10-11+9
				query.append(" ,(DECODE(br.ISPAYBYRMB,1,br.COSTLISTFOREIGNTOTALRMB,br.COSTLISTFOREIGNTOTALEUR)-DECODE(bt.CURRENCY_,'EUR',bt.ADVANCEPAYMENT,0)+DECODE(br.ISPAYBYRMB,1,(SELECT sum(TR.ALLOWANCERMB) from VGCAPON_BTTRAVELEXPENSE tr where TR.BUSINESSTRIPPKID=BR.BUSINESSTRIPREIMBURSEMENTID and TR.CURRENCY_='EUR'),br.TOTALTRAVELEXPENSEEUR))");
				//13,14
				query.append(" ,'RMB',br.TOTALTRAVELEXPENSERMB");
				//15
				query.append(" ,(SELECT sum(CO.PAYMENTAMOUNT) from VGCAPON_BTCOSTLIST co where CO.BUSINESSTRIPPKID = BR.BUSINESSTRIPREIMBURSEMENTID and (CO.ITEM like 'Accommodation-International' or CO.ITEM like 'Accommodation-Domestic'))");
				//16=15-17
				query.append(" ,trunc((SELECT sum(CO.PAYMENTAMOUNT) from VGCAPON_BTCOSTLIST co where CO.BUSINESSTRIPPKID = BR.BUSINESSTRIPREIMBURSEMENTID and (CO.ITEM like 'Accommodation-International' or CO.ITEM like 'Accommodation-Domestic'))*(1-1/1.06),2)");
				//17=15/1.06
				query.append(" ,trunc((SELECT sum(CO.PAYMENTAMOUNT) from VGCAPON_BTCOSTLIST co where CO.BUSINESSTRIPPKID = BR.BUSINESSTRIPREIMBURSEMENTID and (CO.ITEM like 'Accommodation-International' or CO.ITEM like 'Accommodation-Domestic'))/1.06,2)");
				//18=19-15
				query.append(" ,br.COSTLISTFOREIGNTOTALRMB-(SELECT sum(CO.PAYMENTAMOUNT) from VGCAPON_BTCOSTLIST co where CO.BUSINESSTRIPPKID = BR.BUSINESSTRIPREIMBURSEMENTID and (CO.ITEM like 'Accommodation-International' or CO.ITEM like 'Accommodation-Domestic'))");
				//19
				query.append(" ,br.COSTLISTFOREIGNTOTALRMB");
				//20，
				query.append(" ,DECODE(bt.CURRENCY_,'RMB',bt.ADVANCEPAYMENT,0)");
				//21=19-20
				query.append(" ,br.COSTLISTFOREIGNTOTALRMB-DECODE(bt.CURRENCY_,'RMB',bt.ADVANCEPAYMENT,0)");
			}
			//HRG comfirm date
			query.append(" ,(SELECT ka.COMPLETIONDATE from KALEOINSTANCE ka where ka.classpk = br.BUSINESSTRIPREIMBURSEMENTID and ka.CLASSNAME like 'com.business.trip.model.BusinessTripReimbursement')");
			query.append(" FROM VGCAPON_BTREIMBURSEMENT br,VGCAPON_BTAPPLICATION bt WHERE br.BUSSINESSTIRPTICKETNO = bt.TICKETNO and br.TRIPTYPE =? ");
			if (Validator.isNotNull(periodStart)) {
				query.append("  AND br.CREATEDATE >=? ");
			}
			if (Validator.isNotNull(periodEnd)) {
				query.append(" AND br.CREATEDATE <=? ");
			}
			String[] ticketNos =ticketNo.split(",");
			if (Validator.isNotNull(ticketNo)) {
				query.append(" AND (");
				for(int i=0;i<ticketNos.length;i++){
					query.append(" br.TICKETNO LIKE ? OR ");
				}
				query.append(" 1=2 ) ");
			}
			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			QueryPos qPos = QueryPos.getInstance(q); 
			
			qPos.add(travelType);
			if (Validator.isNotNull(periodStart)) {
				qPos.add(DateUtil.parseYMDHMS(periodStart + " 00:00:00"));
			}
			if (Validator.isNotNull(periodEnd)) {
				qPos.add(DateUtil.parseYMDHMS(periodEnd + " 23:59:59"));
			}
			if (Validator.isNotNull(ticketNo)) {
				for(int i2=0;i2<ticketNos.length;i2++){
					qPos.add(StringPool.PERCENT + ticketNos[i2] + StringPool.PERCENT);
				}
			}
			
			List<Object[]> list = q.list();
			
			return list;
		} catch (Exception e) {
				e.printStackTrace();
		} finally {
			businessTripReimbursementPersistence.closeSession(session);
		}
		return Collections.emptyList();
	}

	

	// Save or Update the BusinessTripApplication
	public BusinessTripReimbursement saveOrUpdateBusinessTripReimbursement(
			BusinessTripReimbursement businessTripReimbursement, ServiceContext serviceContext)
			throws PortalException, SystemException {
		Date now = new Date();
		long groupId = serviceContext.getScopeGroupId();
		long companyId = serviceContext.getCompanyId();
		ThemeDisplay themeDisplay = serviceContext.getThemeDisplay();
		String userName = themeDisplay.getUser().getFirstName()+" "+ themeDisplay.getUser().getLastName();
		businessTripReimbursement.setCompanyId(companyId);
		businessTripReimbursement.setGroupId(groupId);
		businessTripReimbursement.setUserId(serviceContext.getUserId());
		businessTripReimbursement.setUserName(userName);
		businessTripReimbursement.setModifiedDate(serviceContext.getCreateDate(now));
		// workflow field
		businessTripReimbursement.setStatus(WorkflowConstants.STATUS_DRAFT);
		businessTripReimbursement.setStatusByUserId(serviceContext.getUserId());
		businessTripReimbursement.setStatusByUserName(userName);
		businessTripReimbursement.setStatusDate(serviceContext.getModifiedDate(now));
		businessTripReimbursement = businessTripReimbursementPersistence.update(businessTripReimbursement);
		return businessTripReimbursement;
	}

	/**
	 * Submit the BusinessTripApplication to start the workflow
	 * @param businessTripReimbursement
	 * @param serviceContext
	 * @param autoNewAterAccountReject    if is true, means account reject,the system will to create a new one.
	 * 
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public BusinessTripReimbursement submitBusinessTripReimbursement(
			BusinessTripReimbursement businessTripReimbursement, ServiceContext serviceContext,boolean autoNewAterAccountReject)
			throws PortalException, SystemException {
		long groupId = serviceContext.getScopeGroupId();
		long companyId = serviceContext.getCompanyId();
		long businessTripReimbursementId = businessTripReimbursement.getBusinessTripReimbursementId();
		long userId = serviceContext.getUserId();
		ThemeDisplay themeDisplay = serviceContext.getThemeDisplay();
		String userName = themeDisplay.getUser().getFirstName()+" "+ themeDisplay.getUser().getLastName();
		businessTripReimbursement.setOrgTotalCostEur(businessTripReimbursement.getCostListForeignTotalEur());
		businessTripReimbursement.setOrgTotalCostRmb(businessTripReimbursement.getCostListInlandTotalRmb());
		Date now = new Date();
		if(businessTripReimbursement.getSapStatus()!=1) {
			businessTripReimbursement.setCompanyId(companyId);
			businessTripReimbursement.setGroupId(groupId);
			businessTripReimbursement.setUserId(serviceContext.getUserId());
			businessTripReimbursement.setUserName(userName);
			businessTripReimbursement.setModifiedDate(serviceContext.getCreateDate(now));
			// workflow field
			businessTripReimbursement.setStatus(WorkflowConstants.STATUS_DRAFT);
			businessTripReimbursement.setStatusByUserId(serviceContext.getUserId());
			businessTripReimbursement.setStatusByUserName(userName);
			businessTripReimbursement.setStatusDate(serviceContext.getModifiedDate(now));
			businessTripReimbursement.setSubmittedDate(now);
		}
		//For special workflow
		String isNormalSubmit = businessTripReimbursement.getSapStatus()==1?"No":"Yes";
		
/*		System.out.println("***********businessTripReimbursement.getSapStatus()**********="+businessTripReimbursement.getSapStatus());
		if(businessTripReimbursement.getSapStatus()!=1) {
			System.out.println("***********businessTripReimbursement.getSapStatus()**********="+businessTripReimbursement.getSapStatus());
			this.submittedSendEmailtoApprover(businessTripReimbursement);
		}*/
		businessTripReimbursement.setSapStatus(0);
		businessTripReimbursementPersistence.update(businessTripReimbursement);
		
		String tripType = PropsUtil.get("vgc.apon.business.trip.reimbursement.type");
		String IsInternationalTrip=businessTripReimbursement.getTripType()==1||BtHotelInfoLocalServiceUtil.isNeedEVPApprove(businessTripReimbursementId, tripType)?"Yes":"No";
		String IsEnterDuringTrip=BtCostListLocalServiceUtil.isEntertainmentCondition(businessTripReimbursementId,0)?"Yes":"No";
		String IsEnterFee=BtCostListLocalServiceUtil.isEntertainmentCondition(businessTripReimbursementId,1)?"Yes":"No";
		
		serviceContext.setAttribute("vgcapon_btReimbursement_isNormalSubmitUserId", businessTripReimbursement.getUserId());
		serviceContext.setAttribute("vgcapon_btReimbursement_isNormalSubmit", isNormalSubmit);
		serviceContext.setAttribute("vgcapon_btReimbursement_IsInternationalTrip", IsInternationalTrip);
		serviceContext.setAttribute("vgcapon_btReimbursement_IsEnterDuringTrip", IsEnterDuringTrip);
		serviceContext.setAttribute("vgcapon_btReimbursement_IsEnterFee", IsEnterFee);
		
		long staffCode=themeDisplay.getUser().getFacebookId();
		/**
		 * ticket rejected by Accounting ,then the themeDisplay.getuser is Account, here should be applicant.
		 */
		if(autoNewAterAccountReject){
			staffCode=businessTripReimbursement.getStaffCode();
			serviceContext.setUserId(businessTripReimbursement.getUserId());
		}
		if(businessTripReimbursement.getIsApplicantAgent()) {
			ApplicantDelegation applicantDelegation = ApplicantDelegationLocalServiceUtil.fetchByP_S(ApproverDelegationLocalServiceUtil.getProcessOfBusinessTripReimbursement(), String.valueOf(UserLocalServiceUtil.fetchUserById(businessTripReimbursement.getUserId()).getFacebookId()));
			staffCode=UserLocalServiceUtil.fetchUserById(applicantDelegation.getUserId()).getFacebookId();
		}
//		long supervisorUserId=SAPUserLocalServiceUtil.getSupervisorUserIdByStaffCode(String.valueOf(staffCode));
      User supervisorUser =UserLocalServiceUtil.fetchUserByFacebookId(PortalUtil.getDefaultCompanyId(),businessTripReimbursement.getApproverId());
     long  supervisorUserId = supervisorUser.getUserId();
		/**
		 * if is crossDepartment of business trip 
		 */
		if(businessTripReimbursement.getIsCrossDepartment()){
			System.out.println("**************businessTripReimbursement.getTargetDepartmentApproverId()*****="+businessTripReimbursement.getTargetDepartmentApproverId());
			User user = UserLocalServiceUtil.fetchUserByFacebookId(PortalUtil.getDefaultCompanyId(),businessTripReimbursement.getTargetDepartmentApproverId());
			System.out.println("**************user*****="+user.getLastName()+user.getFirstName());
			if(user != null){
				supervisorUserId = user.getUserId();
			}
		}
		
		Role supervisorRole = ApproverDelegationLocalServiceUtil.findAgentRoleByP_U(ApproverDelegationLocalServiceUtil.getProcessOfBusinessTripReimbursement(), supervisorUserId);
		long evpUserId = SAPUserLocalServiceUtil.getDivisionManagerUserIdByStaffCode(String.valueOf(staffCode));
		Role evpRole = ApproverDelegationLocalServiceUtil.findAgentRoleByP_U(ApproverDelegationLocalServiceUtil.getProcessOfBusinessTripReimbursement(), evpUserId);
		List<Role> headControllingRoles = ApproverDelegationLocalServiceUtil.findAgentRolesByP_R(ApproverDelegationLocalServiceUtil.getProcessOfBusinessTripReimbursement(), "BR_Head of Controlling");
		List<Role> hrgRoles = ApproverDelegationLocalServiceUtil.findAgentRolesByP_R(ApproverDelegationLocalServiceUtil.getProcessOfBusinessTripReimbursement(), "BR_HRG");
		serviceContext.setAttribute("vgcapon_btReimbursement_supervisor",supervisorRole);
		serviceContext.setAttribute("vgcapon_btReimbursement_evp",evpRole);
		serviceContext.setAttribute("vgcapon_btReimbursement_headOfControlling", headControllingRoles.toArray());
		serviceContext.setAttribute("vgcapon_btReimbursement_hrg", hrgRoles.toArray());
		
		// Add businessTripApplication to assetentry
		AssetEntry assetEntry = AssetEntryLocalServiceUtil.updateEntry(userId,
				groupId, businessTripReimbursement.getCreateDate(),
				businessTripReimbursement.getModifiedDate(),
				BusinessTripReimbursement.class.getName(), businessTripReimbursementId,
				String.valueOf(businessTripReimbursementId), 0,
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(), true, null, null, null,
				ContentTypes.TEXT_HTML, businessTripReimbursement.getTicketNo(), null,
				null, null, null, 0, 0, null, false);
		AssetLinkLocalServiceUtil.updateLinks(userId, assetEntry.getEntryId(),
				serviceContext.getAssetLinkEntryIds(),
				AssetLinkConstants.TYPE_RELATED);

		Indexer indexer = IndexerRegistryUtil
				.nullSafeGetIndexer(BusinessTripReimbursement.class);

		indexer.reindex(businessTripReimbursement);

		// workflow
		WorkflowHandlerRegistryUtil.startWorkflowInstance(
				businessTripReimbursement.getCompanyId(), businessTripReimbursement.getGroupId(),
				serviceContext.getUserId(), BusinessTripReimbursement.class.getName(),
				businessTripReimbursement.getPrimaryKey(), businessTripReimbursement,
				serviceContext);	
		submittedSendEmailtoApprover(businessTripReimbursement);
		return businessTripReimbursement;
	}
	
	//Send email to approver
	private void submittedSendEmailtoApprover(BusinessTripReimbursement businessTripReimbursement) throws SystemException {
		String ddName = this.getDDNames(businessTripReimbursement);
		User applicant=UserLocalServiceUtil.fetchUser(businessTripReimbursement.getUserId());
		String subject = "Business Trip Reimbursement-"+ddName+"-"+businessTripReimbursement.getTicketNo()+"-Waiting for your Approval";
		String cssContent = this.getCssContent();		
		long staffCode=applicant.getFacebookId();
		if(businessTripReimbursement.getIsApplicantAgent()) {
			ApplicantDelegation applicantDelegation = ApplicantDelegationLocalServiceUtil.fetchByP_S(ApproverDelegationLocalServiceUtil.getProcessOfBusinessTripReimbursement(), String.valueOf(UserLocalServiceUtil.fetchUserById(businessTripReimbursement.getUserId()).getFacebookId()));
			staffCode=Long.valueOf(applicantDelegation.getStaffCode());
		}
		SAPUser sAPUser=SAPUserLocalServiceUtil.getSapUserByStaffCode(String.valueOf(staffCode));
	//  long supervisorUserId = SAPUserLocalServiceUtil.getSupervisorUserIdByStaffCode(String.valueOf(staffCode));	
	//	User user = UserLocalServiceUtil.fetchUserById(supervisorUserId);
		User user =UserLocalServiceUtil.fetchUserByFacebookId(PortalUtil.getDefaultCompanyId(),businessTripReimbursement.getApproverId());
		
		/**
		 * if is cross department
		 */
		if(businessTripReimbursement.getIsCrossDepartment()){
			user = UserLocalServiceUtil.fetchUserByFacebookId(PortalUtil.getDefaultCompanyId(), businessTripReimbursement.getTargetDepartmentApproverId());
		}
				
		String[] toAddresses = ApproverDelegationLocalServiceUtil.findEmailsByP_U(ApproverDelegationLocalServiceUtil.getProcessOfBusinessTripReimbursement(), user);	
		
		StringBuffer mailbody = new StringBuffer();
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");		
		mailbody.append("<div class='emailTmp'>")
				.append("<p>Dear Approver, </p>")
				.append("<p><span class='value'>").append(sAPUser.getStaffName()).append("</span> submitted a Business Trip Reimbursement on <span class='value'>").append(sdf.format(businessTripReimbursement.getSubmittedDate())).append("</span>. Please kindly approve or reject it in <a href='")
				.append(PropsUtil.get("vgc.apon.system.href.url")).append("'>APON System</a>.</p>")
				.append("<p>PLEASE DO NOT REPLY to this email, as it is system generated.</p>")
				.append("</div>");
		if(toAddresses != null){
			for(String to :toAddresses ){
				System.out.println("submittedSendEmailtoApprover toAddresses:"+to);
			}
		}
		GlobalEmailLocalServiceUtil.sendEmail(toAddresses, null, subject, cssContent, mailbody.toString(), null);		
	}
	
	
	//After payment completed Send email to applicant
	public void paymentCompletedSendEmailtoApplicant(BusinessTripReimbursement businessTripReimbursement) throws SystemException {
		String ddName = this.getDDNames(businessTripReimbursement);
		User applicant=UserLocalServiceUtil.fetchUser(businessTripReimbursement.getUserId());
		String subject = "Business Trip Reimbursement-"+ddName+"-"+businessTripReimbursement.getTicketNo()+"-Paid";
		String cssContent = this.getCssContent();		
		String[] toAddresses = new String[]{applicant.getEmailAddress()};
		if(businessTripReimbursement.getIsApplicantAgent()){
			toAddresses = ApplicantDelegationLocalServiceUtil.findEmailsByP_U(ApproverDelegationLocalServiceUtil.getProcessOfBusinessTripReimbursement(), applicant);
		}
		StringBuffer mailbody = new StringBuffer();
		mailbody.append("<div class='emailTmp'>")
		.append("<p>Dear Applicant, </p>")
		.append("<p>APON kindly notifies you that the business Trip Reimbursement").append("-"+businessTripReimbursement.getTicketNo())
		.append(" has been paid. Please view it in <a href='").append(PropsUtil.get("vgc.apon.system.href.url")).append("'>APON System</a>.</p>")
		.append("<p>PLEASE DO NOT REPLY to this email, as it is system generated.</p>")
		.append("</div>");

		if(toAddresses != null){
			for(String to :toAddresses ){
				System.out.println("paymentCompletedSendEmailtoApplicant toAddresses:"+to);
			}
		}
		GlobalEmailLocalServiceUtil.sendEmail(toAddresses, null, subject, cssContent, mailbody.toString(), null);		
	}
	
	
	// workflow status
	public BusinessTripReimbursement updateStatus(long userId, long businessTripReimbursementId,
			int status, ServiceContext serviceContext) throws PortalException,
			SystemException {
		User user = userLocalService.getUser(userId);
		BusinessTripReimbursement businessTripReimbursement = getBusinessTripReimbursement(businessTripReimbursementId);
		businessTripReimbursement.setStatus(status);
		businessTripReimbursement.setStatusByUserId(userId);
		businessTripReimbursement.setStatusByUserName(user.getFullName());
		businessTripReimbursement.setStatusDate(new Date());
		businessTripReimbursementPersistence.update(businessTripReimbursement, serviceContext);
		return businessTripReimbursement;
	}
	
	// Get the first company car list according status and userid
	public List<BusinessTripReimbursement> findByS_U(int status, long userId)
			throws SystemException {
		return businessTripReimbursementPersistence.findByS_U(status, userId);
	}
	//
	// Get the first company car list according status and userid
	public List<BusinessTripReimbursement> findByBussinessTirpTicketNo(String bussinessTirpTicketNo)
			throws SystemException {
		return businessTripReimbursementPersistence.findByBussinessTirpTicketNo(bussinessTirpTicketNo);
	}
	//
	public void saveOrUpdateAuditTrailLog(long companyId, long groupId,
			long businessTripReimbursementId,long operationUserId,String operationUser,
			String action,String operationComment) throws SystemException, PortalException {
		BusinessTripReimbursement businessTripReimbursement=BusinessTripReimbursementLocalServiceUtil.fetchBusinessTripReimbursement(businessTripReimbursementId);
		User users=UserLocalServiceUtil.fetchUser(businessTripReimbursement.getUserId());
		long staffCode=users.getFacebookId();
		if(businessTripReimbursement.getIsApplicantAgent()) {
			ApplicantDelegation applicantDelegation = ApplicantDelegationLocalServiceUtil.fetchByP_S(ApproverDelegationLocalServiceUtil.getProcessOfBusinessTripReimbursement(), String.valueOf(UserLocalServiceUtil.fetchUserById(businessTripReimbursement.getUserId()).getFacebookId()));
			staffCode=UserLocalServiceUtil.fetchUserById(applicantDelegation.getUserId()).getFacebookId();
		}
		String tripType = PropsUtil.get("vgc.apon.business.trip.reimbursement.type");
		boolean IsInternationalTrip=businessTripReimbursement.getTripType()==1||BtHotelInfoLocalServiceUtil.isNeedEVPApprove(businessTripReimbursementId, tripType)?true:false;
		boolean IsEnterDuringTrip=BtCostListLocalServiceUtil.isEntertainmentCondition(businessTripReimbursementId,0)?true:false;
		boolean IsEnterFee=BtCostListLocalServiceUtil.isEntertainmentCondition(businessTripReimbursementId,1)?true:false;
		long evpUserId=SAPUserLocalServiceUtil.getDivisionManagerUserIdByStaffCode(String.valueOf(staffCode));
		User supervisorUser=null;
		System.out.println("**************businessTripReimbursement.getTargetDepartmentApproverId()*********="+businessTripReimbursement.getTargetDepartmentApproverId());
		if(businessTripReimbursement.getIsCrossDepartment()){
			supervisorUser =UserLocalServiceUtil.fetchUserByFacebookId(companyId, businessTripReimbursement.getTargetDepartmentApproverId());
		}else{
		//	long supervisorUserId=SAPUserLocalServiceUtil.getSupervisorUserIdByStaffCode(String.valueOf(staffCode));
			  supervisorUser =UserLocalServiceUtil.fetchUserByFacebookId(PortalUtil.getDefaultCompanyId(),businessTripReimbursement.getApproverId());
			  //supervisorUser=UserLocalServiceUtil.fetchUser(supervisorUserId);
		}
		
		User evpUser=UserLocalServiceUtil.fetchUser(evpUserId);
		Date now = new Date();
		String supervisorName = supervisorUser!=null?supervisorUser.getFirstName()+" "+supervisorUser.getLastName():"Guest";
		System.out.println("*****************supervisorName="+supervisorName);
		String evpName = evpUser!=null?evpUser.getFirstName()+" "+evpUser.getLastName():"Guest";

		List<AuditTrailLog> list = AuditTrailLogLocalServiceUtil
				.findAuditTrailByWF_O_O(businessTripReimbursementId,
						BusinessTripReimbursement.class.getName());
		int operationNo = this.getOperationNo(list);
		int currentOperationNo = this.getCurrentOperationNo(list);
		if (ActionConstants.SUBMIT.equals(action)) {
			String submitComment = "";
			if(businessTripReimbursement.getIsApplicantAgent()) {
				ApplicantDelegation applicantDelegation = ApplicantDelegationLocalServiceUtil.fetchByP_S(ApproverDelegationLocalServiceUtil.getProcessOfBusinessTripReimbursement(), String.valueOf(UserLocalServiceUtil.fetchUserById(businessTripReimbursement.getUserId()).getFacebookId()));
				submitComment = "On behalf of "+ApplicantDelegationLocalServiceUtil.getAgentName(applicantDelegation);
			}
			if (list == null || list.size() == 0) {
				for (BusinessTripReimbursementLogEnum eLogEnum : BusinessTripReimbursementLogEnum
						.values()) {
					if (eLogEnum.getNumber() == 1) {
						AuditTrailLogLocalServiceUtil.saveAuditTrailLog(
								companyId, groupId, businessTripReimbursementId,
								BusinessTripReimbursement.class.getName(),
								eLogEnum.getNumber(), getRoleTrailLogName(eLogEnum.getRole()),
								operationUser,
								ActionConstants.STATUS_SUBMITTED, now, submitComment);
					} else {
						String approverUser = "";
						if(eLogEnum.getNumber()==99){
							approverUser = supervisorName;
							AuditTrailLogLocalServiceUtil.saveAuditTrailLog(
									companyId, groupId, businessTripReimbursementId,
									BusinessTripReimbursement.class.getName(),
									eLogEnum.getNumber(), getRoleTrailLogName(eLogEnum.getRole()),
									approverUser,
									ActionConstants.STATUS_PENDING_TO_APPROVE, null,"");
						}else if(eLogEnum.getNumber()==100){
							if(IsInternationalTrip){
								approverUser = evpName;
								AuditTrailLogLocalServiceUtil.saveAuditTrailLog(
										companyId, groupId, businessTripReimbursementId,
										BusinessTripReimbursement.class.getName(),
										eLogEnum.getNumber(), getRoleTrailLogName(eLogEnum.getRole()),
										approverUser,
										ActionConstants.STATUS_PENDING_TO_APPROVE, null,"");
							}
						}else if(eLogEnum.getNumber()==101){
							if(IsEnterDuringTrip&&!IsEnterFee){
								approverUser = this.getOperationUserByRoleName(
										companyId, eLogEnum.getRole());
								AuditTrailLogLocalServiceUtil.saveAuditTrailLog(
										companyId, groupId, businessTripReimbursementId,
										BusinessTripReimbursement.class.getName(),
										eLogEnum.getNumber(), getRoleTrailLogName(eLogEnum.getRole()),
										approverUser,
										ActionConstants.STATUS_PENDING_TO_APPROVE, null,"");
							}
						}else{
							approverUser = this.getOperationUserByRoleName(
									companyId, eLogEnum.getRole());
							AuditTrailLogLocalServiceUtil.saveAuditTrailLog(
									companyId, groupId, businessTripReimbursementId,
									BusinessTripReimbursement.class.getName(),
									eLogEnum.getNumber(), getRoleTrailLogName(eLogEnum.getRole()),
									approverUser,
									ActionConstants.STATUS_PENDING_TO_APPROVE, null,"");
						}
					}
				}
			} else {
				AuditTrailLogLocalServiceUtil.saveAuditTrailLog(companyId,
						groupId, businessTripReimbursementId,
						BusinessTripReimbursement.class.getName(), operationNo,
						getRoleTrailLogName(BusinessTripReimbursementLogEnum.APPLICANT.getRole()),
						operationUser, ActionConstants.STATUS_SUBMITTED, now,
						submitComment);
				
				for (BusinessTripReimbursementLogEnum eLogEnum : BusinessTripReimbursementLogEnum
						.values()) {
					if (eLogEnum.getNumber() != 1&&eLogEnum.getNumber()>operationNo) {
						AuditTrailLog AuditTrailLog1= AuditTrailLogLocalServiceUtil.findAuditTrailByWF_C_O_O_O(companyId, businessTripReimbursementId, BusinessTripReimbursement.class.getName(), eLogEnum.getNumber());
						if(AuditTrailLog1!=null){
							AuditTrailLogLocalServiceUtil.deleteAuditTrailLog(AuditTrailLog1);
						}
					}
				}
				for (BusinessTripReimbursementLogEnum eLogEnum : BusinessTripReimbursementLogEnum
						.values()) {
					if (eLogEnum.getNumber() != 1) {
						String approverUser = "";
						if(eLogEnum.getNumber()==99){
							approverUser = supervisorName;
							AuditTrailLogLocalServiceUtil.saveAuditTrailLog(
									companyId, groupId, businessTripReimbursementId,
									BusinessTripReimbursement.class.getName(),
									eLogEnum.getNumber(), getRoleTrailLogName(eLogEnum.getRole()),
									approverUser,
									ActionConstants.STATUS_PENDING_TO_APPROVE, null,"");
						}else if(eLogEnum.getNumber()==100){
							if(IsInternationalTrip){
								approverUser = evpName;
								AuditTrailLogLocalServiceUtil.saveAuditTrailLog(
										companyId, groupId, businessTripReimbursementId,
										BusinessTripReimbursement.class.getName(),
										eLogEnum.getNumber(), getRoleTrailLogName(eLogEnum.getRole()),
										approverUser,
										ActionConstants.STATUS_PENDING_TO_APPROVE, null,"");
							}
						}else if(eLogEnum.getNumber()==101){
							if(IsEnterDuringTrip&&!IsEnterFee){
								approverUser = this.getOperationUserByRoleName(
										companyId, eLogEnum.getRole());
								AuditTrailLogLocalServiceUtil.saveAuditTrailLog(
										companyId, groupId, businessTripReimbursementId,
										BusinessTripReimbursement.class.getName(),
										eLogEnum.getNumber(), getRoleTrailLogName(eLogEnum.getRole()),
										approverUser,
										ActionConstants.STATUS_PENDING_TO_APPROVE, null,"");
							}
						}else{
							approverUser = this.getOperationUserByRoleName(
									companyId, eLogEnum.getRole());
							AuditTrailLogLocalServiceUtil.saveAuditTrailLog(
									companyId, groupId, businessTripReimbursementId,
									BusinessTripReimbursement.class.getName(),
									eLogEnum.getNumber(), getRoleTrailLogName(eLogEnum.getRole()),
									approverUser,
									ActionConstants.STATUS_PENDING_TO_APPROVE, null,"");
						}
					}
				}
			}
		}else if(ActionConstants.SUBMIT_TO_HRG.equals(action)){
			String submitComment = "";
			if(businessTripReimbursement.getIsApplicantAgent()) {
				ApplicantDelegation applicantDelegation = ApplicantDelegationLocalServiceUtil.fetchByP_S(ApproverDelegationLocalServiceUtil.getProcessOfBusinessTripReimbursement(), String.valueOf(UserLocalServiceUtil.fetchUserById(businessTripReimbursement.getUserId()).getFacebookId()));
				submitComment = "On behalf of "+ApplicantDelegationLocalServiceUtil.getAgentName(applicantDelegation);
			}
			
			AuditTrailLogLocalServiceUtil.saveAuditTrailLog(companyId,
					groupId, businessTripReimbursementId,
					BusinessTripReimbursement.class.getName(), operationNo+1,
					getRoleTrailLogName(BusinessTripReimbursementLogEnum.APPLICANT.getRole()),
					operationUser, ActionConstants.STATUS_SUBMITTED, now,
					submitComment);
			
			AuditTrailLogLocalServiceUtil.saveAuditTrailLog(
					companyId, groupId, businessTripReimbursementId,
					BusinessTripReimbursement.class.getName(),
					BusinessTripReimbursementLogEnum.HRG.getNumber(), 
					getRoleTrailLogName(BusinessTripReimbursementLogEnum.HRG.getRole()),"",
					ActionConstants.STATUS_PENDING_TO_APPROVE, null, "");
		}else if (ActionConstants.RECALL.equals(action)) {
			AuditTrailLogLocalServiceUtil.saveAuditTrailLog(
					companyId, groupId, businessTripReimbursementId,
					BusinessTripReimbursement.class.getName(),
					operationNo, getRoleTrailLogName(BusinessTripReimbursementLogEnum.APPLICANT.getRole()),
					operationUser,
					ActionConstants.STATUS_RECALL, now,"");
		}else{
			if (ActionConstants.APPROVE.equals(action)) {
				for (AuditTrailLog auditTrailLog : list) {
					boolean isBreak=false;
					for (BusinessTripReimbursementLogEnum eLogEnum : BusinessTripReimbursementLogEnum
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
				AuditTrailLog auditTrailLog = AuditTrailLogLocalServiceUtil.findAuditTrailByWF_C_O_O_O(companyId, businessTripReimbursementId, BusinessTripReimbursement.class.getName(),currentOperationNo);
				if(auditTrailLog!=null&&auditTrailLog.getOperationStatus().equals(ActionConstants.STATUS_PENDING_TO_APPROVE)) {
					auditTrailLog.setOperationUser(operationUser);
					auditTrailLog.setOperationStatus(ActionConstants.STATUS_REJECTED);
					auditTrailLog.setOperationComment(operationComment);
					auditTrailLog.setOperationNo(operationNo);
					auditTrailLog.setOperationTime(now);
					AuditTrailLogLocalServiceUtil.updateAuditTrailLog(auditTrailLog);
				}
			}else if (ActionConstants.COMPLETE.equals(action)
					|| ActionConstants.CANCEL.equals(action)) {
				for (AuditTrailLog auditTrailLog : list) {
					if (auditTrailLog.getOperationNo() == BusinessTripReimbursementLogEnum.HRG
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
	
	public String[] findEmailsOfPendingApprover(BusinessTripReimbursement businessTripReimbursement) throws SystemException {
		List<AuditTrailLog> list = AuditTrailLogLocalServiceUtil.findAuditTrailByWF_O_O(businessTripReimbursement.getBusinessTripReimbursementId(),BusinessTripReimbursement.class.getName());

		String pendRole = "";
		for(AuditTrailLog auditTrailLog:list) {
			if(ActionConstants.STATUS_PENDING_TO_APPROVE.equals(auditTrailLog.getOperationStatus())) {
				pendRole = auditTrailLog.getOperationRole();
				break;
			}
		}
		User users=UserLocalServiceUtil.fetchUser(businessTripReimbursement.getUserId());
		long staffCode=users.getFacebookId();
		SAPUser sAPUser=SAPUserLocalServiceUtil.getSapUserByStaffCode(String.valueOf(staffCode));
		User supervisorUser=null;
		User divisionManageUser=null;
		if(sAPUser!=null&&sAPUser.getSupervisorFgId()!=null&&!sAPUser.getSupervisorFgId().equals("")){
			long supervisorUserId=SAPUserLocalServiceUtil.getSupervisorUserIdByStaffCode(String.valueOf(sAPUser.getSupervisorFgId()));
			supervisorUser = UserLocalServiceUtil.fetchUserById(supervisorUserId);
		}
		if(sAPUser!=null&&sAPUser.getDivisionManagerId()!=null&&!sAPUser.getDivisionManagerId().equals("")){
			long divisionManagerUserId=SAPUserLocalServiceUtil.getSupervisorUserIdByStaffCode(String.valueOf(sAPUser.getDivisionManagerId()));
			divisionManageUser = UserLocalServiceUtil.fetchUserById(divisionManagerUserId);
		}
		
		System.out.println("pendRole:"+pendRole);
		String[] toAddresses= new String[]{};
		if("Supervisor".equals(pendRole)){
			String supervisorEmail[] = supervisorUser!=null?ApproverDelegationLocalServiceUtil.findEmailsByP_U(ApproverDelegationLocalServiceUtil.getProcessOfBusinessTripReimbursement(),supervisorUser):new String[]{};
			toAddresses = supervisorEmail;
		}else if("EVP".equals(pendRole)){
			String divisionManageEmail[] = divisionManageUser!=null?ApproverDelegationLocalServiceUtil.findEmailsByP_U(ApproverDelegationLocalServiceUtil.getProcessOfBusinessTripReimbursement(),divisionManageUser):new String[]{};
			toAddresses = divisionManageEmail;
		}else{
			toAddresses =ApproverDelegationLocalServiceUtil.findEmailsByP_R(ApproverDelegationLocalServiceUtil.getProcessOfBusinessTripReimbursement(),getRoleNameByTrailLogName(pendRole));
		}
	
		return toAddresses;
	}
	
	private  String getRoleNameByTrailLogName(String roleName){
		String roleTrailLogName="";
		if("Head of Controlling".equals(roleName)){
			roleTrailLogName="BR_Head of Controlling";
		}else if("HRG".equals(roleName)){
			roleTrailLogName="BR_HRG";
		}
		return roleTrailLogName;
	}
	
	public String getRoleTrailLogName(String roleName){
		String roleTrailLogName="";
		if("Applicant".equals(roleName)){
			roleTrailLogName=roleName;
		}else if("Supervisor".equals(roleName)){
			roleTrailLogName=roleName;
		}else if("EVP".equals(roleName)){
			roleTrailLogName=roleName;
		}else if("BR_Head of Controlling".equals(roleName)){
			roleTrailLogName="Head of Controlling";
		}else if("BR_HRG".equals(roleName)){
			roleTrailLogName="HRG";
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
			operationUser = operationUser + user.getFirstName() + " " + user.getLastName()
					+ ",";
		}
		if(operationUser.length()>0) {
			return operationUser.substring(0, operationUser.length() - 1);
		}else {
			return "";
		}		
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
	public String getDDNames(BusinessTripReimbursement businessTripReimbursement) {
		String division = businessTripReimbursement.getDivision();
		String department = businessTripReimbursement.getDepartment();
		String ddName = Validator.isNotNull(division)&&Validator.isNotNull(department)?division+"/"+department:division;
		if(Validator.isNull(division)) {
			ddName = department;
		}
		return ddName;
	}
	
	//SAP For Reimbursement
	
			public long findCountByS_U_SAP(int status,
					String ticketNo, String printName, int sapStatus, String startDate,
					String endDate, String sapDocumentId) throws SystemException, ParseException{
				//
				SimpleDateFormat sdf_dmy = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
				
				DynamicQuery query = DynamicQueryFactoryUtil
						.forClass(BusinessTripReimbursement.class);

				if (Validator.isNotNull(printName)) {
					query.add(RestrictionsFactoryUtil.ilike("printName", "%"
							+ printName + "%"));
				}
				if (Validator.isNotNull(ticketNo)) {
					query.add(RestrictionsFactoryUtil.ilike("ticketNo", "%" + ticketNo
							+ "%"));
				}
				if (Validator.isNotNull(sapDocumentId)) {
					query.add(RestrictionsFactoryUtil.ilike("sapDocumentId", "%" + sapDocumentId
							+ "%"));
				}
				if (Validator.isNotNull(startDate) && (Validator.isNotNull(endDate))) {
					query.add(RestrictionsFactoryUtil.ge("submittedDate", sdf_dmy.parse(startDate+" 00:00:00")));
					query.add(RestrictionsFactoryUtil.le("submittedDate", sdf_dmy.parse(endDate+" 23:59:59")));
//					query.add(RestrictionsFactoryUtil.between("SUBMITTEDDATE",
//							sdf_dmy.parse(startDate), sdf_dmy.parse(endDate)));
				}
				query.add(RestrictionsFactoryUtil.eq("status", status));
				if (sapStatus==1) {
					Criterion criterion = null;
					criterion = RestrictionsFactoryUtil.eq("sapStatus", 1);
					query.add(criterion);
				}else if (sapStatus==2) {
					Criterion criterion = null;
					criterion = RestrictionsFactoryUtil.eq("sapStatus", 2);
					query.add(criterion);
				}else if(sapStatus==-2){
					Criterion criterion = RestrictionsFactoryUtil.eq("sapStatus",-2);
					query.add(criterion);
				}else {
					Criterion criterion = null;
					criterion = RestrictionsFactoryUtil.eq("sapStatus", 0);
					criterion = RestrictionsFactoryUtil.or(criterion,
							RestrictionsFactoryUtil.eq("sapStatus", -1));
					query.add(criterion);
				}
				return dynamicQueryCount(query);
			}
			
			/**
			 * select reject ticket by account For Reimbursement
			 */
			public long findRejectCountByS_U_SAP(String ticketNo, String printName, int sapStatus, String startDate,
					String endDate, String sapDocumentId) throws SystemException, ParseException{
				//
				SimpleDateFormat sdf_dmy = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
				
				DynamicQuery query = DynamicQueryFactoryUtil
						.forClass(BusinessTripReimbursement.class);

				if (Validator.isNotNull(printName)) {
					query.add(RestrictionsFactoryUtil.ilike("printName", "%"
							+ printName + "%"));
				}
				if (Validator.isNotNull(ticketNo)) {
					query.add(RestrictionsFactoryUtil.ilike("ticketNo", "%" + ticketNo
							+ "%"));
				}
				if (Validator.isNotNull(sapDocumentId)) {
					query.add(RestrictionsFactoryUtil.ilike("sapDocumentId", "%" + sapDocumentId
							+ "%"));
				}
				if (Validator.isNotNull(startDate) && (Validator.isNotNull(endDate))) {
					query.add(RestrictionsFactoryUtil.ge("submittedDate", sdf_dmy.parse(startDate+" 00:00:00")));
					query.add(RestrictionsFactoryUtil.le("submittedDate", sdf_dmy.parse(endDate+" 23:59:59")));
//					query.add(RestrictionsFactoryUtil.between("SUBMITTEDDATE",
//							sdf_dmy.parse(startDate), sdf_dmy.parse(endDate)));
				}
				if (sapStatus==1) {
					Criterion criterion = null;
					criterion = RestrictionsFactoryUtil.eq("sapStatus", 1);
					query.add(criterion);
				}else if (sapStatus==2) {
					Criterion criterion = null;
					criterion = RestrictionsFactoryUtil.eq("sapStatus", 2);
					query.add(criterion);
				}else if(sapStatus==-2){
					Criterion criterion = RestrictionsFactoryUtil.eq("sapStatus",-2);
					query.add(criterion);
				}else {
					Criterion criterion = null;
					criterion = RestrictionsFactoryUtil.eq("sapStatus", 0);
					criterion = RestrictionsFactoryUtil.or(criterion,
							RestrictionsFactoryUtil.eq("sapStatus", -1));
					query.add(criterion);
				}
				return dynamicQueryCount(query);
			}
			
			
			
			public List<BusinessTripReimbursement> findByS_U_SAP(int status,
					String ticketNo, String printName, int sapStatus, String startDate,
					String endDate,String sapDocumentId,int start, int end) throws SystemException, ParseException {
				//
				SimpleDateFormat sdf_dmy = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
				DynamicQuery query = DynamicQueryFactoryUtil
						.forClass(BusinessTripReimbursement.class);

				if (Validator.isNotNull(printName)) {
					query.add(RestrictionsFactoryUtil.ilike("printName", "%"
							+ printName + "%"));
				}
				if (Validator.isNotNull(ticketNo)) {
					query.add(RestrictionsFactoryUtil.ilike("ticketNo", "%" + ticketNo
							+ "%"));
				}
				if (Validator.isNotNull(sapDocumentId)) {
					query.add(RestrictionsFactoryUtil.ilike("sapDocumentId", "%" + sapDocumentId
							+ "%"));
				}
				if (Validator.isNotNull(startDate) && (Validator.isNotNull(endDate))) {
					query.add(RestrictionsFactoryUtil.ge("submittedDate", sdf_dmy.parse(startDate+" 00:00:00")));
					query.add(RestrictionsFactoryUtil.le("submittedDate", sdf_dmy.parse(endDate+" 23:59:59")));
//					query.add(RestrictionsFactoryUtil.between("SUBMITTEDDATE",
//							sdf_dmy.parse(startDate), sdf_dmy.parse(endDate)));
				}
				query.add(RestrictionsFactoryUtil.eq("status", status));
				if (sapStatus==1) {
					Criterion criterion = null;
					criterion = RestrictionsFactoryUtil.eq("sapStatus", 1);
					query.add(criterion);
				}else if (sapStatus==2) {
					Criterion criterion = null;
					criterion = RestrictionsFactoryUtil.eq("sapStatus", 2);
					query.add(criterion);
				}else if(sapStatus==-2){
					Criterion criterion = RestrictionsFactoryUtil.eq("sapStatus",-2);
					query.add(criterion);
				}else {
					Criterion criterion = null;
					criterion = RestrictionsFactoryUtil.eq("sapStatus", 0);
					criterion = RestrictionsFactoryUtil.or(criterion,
							RestrictionsFactoryUtil.eq("sapStatus", -1));
					query.add(criterion);
				}
				if(sapStatus<1){
				query.addOrder(OrderFactoryUtil.asc("sapStatus"));
				}else{
				query.addOrder(OrderFactoryUtil.desc("sapStatus"));
				}
				query.addOrder(OrderFactoryUtil.desc("submittedDate"));
				query.setLimit(start, end);
				
				return dynamicQuery(query);
			}
		
			/**
			 * select reject ticket by account For Reimbursement
			 * 
			 * @param ticketNo
			 * @param printName
			 * @param sapStatus
			 * @param startDate
			 * @param endDate
			 * @param sapDocumentId
			 * @param start
			 * @param end
			 * @return
			 * @throws SystemException
			 * @throws ParseException
			 */
			public List<BusinessTripReimbursement> findRejectByS_U_SAP(String ticketNo, String printName, int sapStatus, String startDate,
					String endDate,String sapDocumentId,int start, int end) throws SystemException, ParseException {
				//
				SimpleDateFormat sdf_dmy = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
				DynamicQuery query = DynamicQueryFactoryUtil
						.forClass(BusinessTripReimbursement.class);

				if (Validator.isNotNull(printName)) {
					query.add(RestrictionsFactoryUtil.ilike("printName", "%"
							+ printName + "%"));
				}
				if (Validator.isNotNull(ticketNo)) {
					query.add(RestrictionsFactoryUtil.ilike("ticketNo", "%" + ticketNo
							+ "%"));
				}
				if (Validator.isNotNull(sapDocumentId)) {
					query.add(RestrictionsFactoryUtil.ilike("sapDocumentId", "%" + sapDocumentId
							+ "%"));
				}
				if (Validator.isNotNull(startDate) && (Validator.isNotNull(endDate))) {
					query.add(RestrictionsFactoryUtil.ge("submittedDate", sdf_dmy.parse(startDate+" 00:00:00")));
					query.add(RestrictionsFactoryUtil.le("submittedDate", sdf_dmy.parse(endDate+" 23:59:59")));
//					query.add(RestrictionsFactoryUtil.between("SUBMITTEDDATE",
//							sdf_dmy.parse(startDate), sdf_dmy.parse(endDate)));
				}
				if (sapStatus==1) {
					Criterion criterion = null;
					criterion = RestrictionsFactoryUtil.eq("sapStatus", 1);
					query.add(criterion);
				}else if (sapStatus==2) {
					Criterion criterion = null;
					criterion = RestrictionsFactoryUtil.eq("sapStatus", 2);
					query.add(criterion);
				}else if(sapStatus==-2){
					Criterion criterion = RestrictionsFactoryUtil.eq("sapStatus",-2);
					query.add(criterion);
				}else {
					Criterion criterion = null;
					criterion = RestrictionsFactoryUtil.eq("sapStatus", 0);
					criterion = RestrictionsFactoryUtil.or(criterion,
							RestrictionsFactoryUtil.eq("sapStatus", -1));
					query.add(criterion);
				}
				if(sapStatus<1){
				query.addOrder(OrderFactoryUtil.asc("sapStatus"));
				}else{
				query.addOrder(OrderFactoryUtil.desc("sapStatus"));
				}
				query.addOrder(OrderFactoryUtil.desc("submittedDate"));
				query.setLimit(start, end);
				
				return dynamicQuery(query);
			}
			
			
			public void updateSAPStatusAsSAPInfo(List<Map<String, Object>> params,
					ServiceContext serviceContext) throws PortalException,
					SystemException {
			//	boolean flag=false;
				for (Map<String, Object> param : params) {
					String sapComments=(String) param.get("sapComments");
					String sapDucumentId=(String) param.get("sapDocumentId");
					String businessTripReimbursementId=String.valueOf(param.get("businessTripReimbursementId"));
					int sapStatus=(Integer) param.get("sapStatus");
					updateSAPStatus(Long.parseLong(businessTripReimbursementId), sapStatus,
							serviceContext,sapComments,sapDucumentId);
					}
				}


				// sap status
				public BusinessTripReimbursement updateSAPStatus(
					long businessTripReimbursementId, int sapStatus,
					ServiceContext serviceContext,String SAPcomments,String SAPducumentId) throws PortalException,
					SystemException {
					BusinessTripReimbursement businessTripReimbursement = getBusinessTripReimbursement(businessTripReimbursementId);
					businessTripReimbursement.setSapStatus(sapStatus);
				if(sapStatus>0){
					if(null!=SAPducumentId&&!SAPducumentId.equals("")){
					businessTripReimbursement.setSapDocumentId(SAPducumentId);
					}
					if(sapStatus ==2){
						System.out.println("After payment complete , then send eamil to applicant");
						 BusinessTripReimbursementLocalServiceUtil.paymentCompletedSendEmailtoApplicant(businessTripReimbursement);
					}
				}else if(sapStatus==-2){
					
				}
				else{
					if(null!=SAPcomments&&!SAPcomments.equals("")){
					businessTripReimbursement.setSapComments(SAPcomments);
					}
				}
				//businessTripApplication.setStatusDate(new Date());
				businessTripReimbursementPersistence.update(businessTripReimbursement,
						serviceContext);
				return businessTripReimbursement;
				}
				
}