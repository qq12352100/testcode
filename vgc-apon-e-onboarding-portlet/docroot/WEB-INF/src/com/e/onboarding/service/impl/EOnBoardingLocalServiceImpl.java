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

package com.e.onboarding.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;

import com.audit.trail.model.AuditTrailLog;
import com.audit.trail.service.AuditTrailLogLocalServiceUtil;
import com.delegation.model.ApplicantDelegation;
import com.delegation.service.ApplicantDelegationLocalServiceUtil;
import com.delegation.service.ApproverDelegationLocalServiceUtil;
import com.e.onboarding.constant.ApplicantConstrant;
import com.e.onboarding.model.EOnBoarding;
import com.e.onboarding.service.DistributionLocalServiceUtil;
import com.e.onboarding.service.EOnBoardingLocalServiceUtil;
import com.e.onboarding.service.base.EOnBoardingLocalServiceBaseImpl;
import com.e.onboarding.util.ActionConstants;
import com.e.onboarding.util.EOnboardingEmailUtil;
import com.e.onboarding.util.EOnboardingLogEnum;
import com.global.management.service.GlobalEmailLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.PropsUtil;
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

/**
 * The implementation of the e on boarding local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.vw.onboarding.service.EOnBoardingLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author sanguine
 * @see com.vw.onboarding.service.base.EOnBoardingLocalServiceBaseImpl
 * @see com.vw.onboarding.service.EOnBoardingLocalServiceUtil
 */
public class EOnBoardingLocalServiceImpl extends
		EOnBoardingLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.vw.onboarding.service.EOnBoardingLocalServiceUtil} to access the
	 * application form local service.
	 */
	public EOnBoarding addEOnBoarding(EOnBoarding newEOnBoarding,
			ServiceContext serviceContext) throws SystemException {
		EOnBoarding eOnBoarding = eOnBoardingPersistence
				.create(CounterLocalServiceUtil.increment(EOnBoarding.class
						.getName()));
		eOnBoarding.setCompanyId(PortalUtil.getDefaultCompanyId());
		eOnBoarding.setCreateDate(new Date());
		// eOnBoarding.setStatus(ApplicantConstrant.DRAFT);
		eOnBoarding.setStaffCode(newEOnBoarding.getStaffCode());
		eOnBoarding.setTitle(newEOnBoarding.getTitle());
		eOnBoarding.setLastName(newEOnBoarding.getLastName());
		eOnBoarding.setFirstName(newEOnBoarding.getFirstName());
		eOnBoarding.setName(newEOnBoarding.getName());
		eOnBoarding.setBirthday(newEOnBoarding.getBirthday());
		eOnBoarding.setContractType(newEOnBoarding.getContractType());
		eOnBoarding.setDivision(newEOnBoarding.getDivision());
		eOnBoarding.setDepartment(newEOnBoarding.getDepartment());
		eOnBoarding.setPositionCode(newEOnBoarding.getPositionCode());
		eOnBoarding.setFunctionName(newEOnBoarding.getFunctionName());
		eOnBoarding.setCostCenter(newEOnBoarding.getCostCenter());
		eOnBoarding.setPhotoPath(newEOnBoarding.getPhotoPath());
		eOnBoarding.setWorkLocation(newEOnBoarding.getWorkLocation());
		eOnBoarding.setOfficeSite(newEOnBoarding.getOfficeSite());
		eOnBoarding.setStartingDate(newEOnBoarding.getStartingDate());
		eOnBoarding.setServiceLength(newEOnBoarding.getServiceLength());
		eOnBoarding.setReportTo(newEOnBoarding.getReportTo());
		eOnBoarding.setGender(newEOnBoarding.getGender());
		eOnBoarding.setCompanyCar(newEOnBoarding.getCompanyCar());
		eOnBoarding.setNameOfReplacedPerson(newEOnBoarding.getNameOfReplacedPerson());
		eOnBoarding.setIsApplicantAgent(newEOnBoarding.getIsApplicantAgent());
		eOnBoarding.setItRelatedHardware(newEOnBoarding.getItRelatedHardware());
		eOnBoarding.setReplacement(newEOnBoarding.getReplacement());
		eOnBoarding.setContactInfo(newEOnBoarding.getContactInfo());
		eOnBoarding.setComments(newEOnBoarding.getComments());
		User user = UserLocalServiceUtil.fetchUser(serviceContext.getUserId());
		eOnBoarding.setUserId(serviceContext.getUserId());
		eOnBoarding.setUserName(user.getFullName());
		eOnBoarding.setTicketNo(generateTicketNo(ApplicantConstrant.EO));
		eOnBoardingPersistence.update(eOnBoarding);
		return eOnBoarding;
	}

	public EOnBoarding saveAsDraft(EOnBoarding eOnBoarding,
			ServiceContext serviceContext) throws PortalException,
			SystemException {
		Date now = new Date();
		long groupId = serviceContext.getScopeGroupId();
		long companyId = serviceContext.getCompanyId();
		ThemeDisplay themeDisplay = serviceContext.getThemeDisplay();
		String userName = themeDisplay.getUser().getFullName();
		eOnBoarding.setGroupId(groupId);
		eOnBoarding.setCompanyId(companyId);
		eOnBoarding.setUserId(serviceContext.getUserId());
		eOnBoarding.setUserName(userName);
		eOnBoarding.setModifiedDate(serviceContext.getCreateDate(now));
		// workflow field
		eOnBoarding.setStatus(WorkflowConstants.STATUS_DRAFT);
		eOnBoarding.setStatusByUserId(serviceContext.getUserId());
		eOnBoarding.setStatusByUserName(userName);
		eOnBoarding.setStatusDate(serviceContext.getCreateDate(now));
		eOnBoarding = eOnBoardingPersistence.update(eOnBoarding);
		return eOnBoarding;
	}

	public EOnBoarding submitEOnBoarding(EOnBoarding eOnBoarding,
			ServiceContext serviceContext) throws PortalException,
			SystemException {
		long groupId = serviceContext.getScopeGroupId();
		long companyId = serviceContext.getCompanyId();
		long eOnBoardingId = eOnBoarding.getEOnBoardingId();
		long userId = serviceContext.getUserId();
		ThemeDisplay themeDisplay = serviceContext.getThemeDisplay();
		String username = themeDisplay.getUser().getFullName();
		Date now = new Date();
		eOnBoarding.setCompanyId(companyId);
		eOnBoarding.setGroupId(groupId);
		eOnBoarding.setUserId(serviceContext.getUserId());
		eOnBoarding.setUserName(username);
		eOnBoarding.setModifiedDate(serviceContext.getCreateDate(now));

		// workflow field
		eOnBoarding.setStatus(WorkflowConstants.STATUS_DRAFT);
		eOnBoarding.setStatusByUserId(serviceContext.getUserId());
		eOnBoarding.setStatusByUserName(username);
		eOnBoarding.setStatusDate(serviceContext.getCreateDate(now));
		eOnBoarding.setSubmittedDate(now);
		eOnBoarding.setAdminStatus(String.valueOf(WorkflowConstants.STATUS_DRAFT));
		eOnBoarding.setSecurityStatus(String.valueOf(WorkflowConstants.STATUS_DRAFT));
		eOnBoarding.setItpStatus(String.valueOf(WorkflowConstants.STATUS_DRAFT));
		eOnBoarding.setFinanceStatus(String.valueOf(WorkflowConstants.STATUS_DRAFT));
		eOnBoardingPersistence.update(eOnBoarding);
		
		List<Role> adminRoles = ApproverDelegationLocalServiceUtil.findAgentRolesByP_R(ApproverDelegationLocalServiceUtil.getProcessOfEOnboarding(), "EO_Admin");
		serviceContext.setAttribute("vgcapon_eOnboarding_admin", adminRoles.toArray());
		List<Role> securityRoles = ApproverDelegationLocalServiceUtil.findAgentRolesByP_R(ApproverDelegationLocalServiceUtil.getProcessOfEOnboarding(), "EO_Security");
		serviceContext.setAttribute("vgcapon_eOnboarding_security", securityRoles.toArray());
		List<Role> itpRoles = ApproverDelegationLocalServiceUtil.findAgentRolesByP_R(ApproverDelegationLocalServiceUtil.getProcessOfEOnboarding(), "EO_ITP");
		serviceContext.setAttribute("vgcapon_eOnboarding_itp", itpRoles.toArray());
		List<Role> controllingFinanceRoles = ApproverDelegationLocalServiceUtil.findAgentRolesByP_R(ApproverDelegationLocalServiceUtil.getProcessOfEOnboarding(), "EO_Controlling/Finance");
		serviceContext.setAttribute("vgcapon_eOnboarding_controlling_finance", controllingFinanceRoles.toArray());

		// Add eOnBoarding to assetentry
		AssetEntry assetEntry = AssetEntryLocalServiceUtil.updateEntry(userId,
				groupId, eOnBoarding.getCreateDate(),
				eOnBoarding.getModifiedDate(), EOnBoarding.class.getName(),
				eOnBoardingId, String.valueOf(eOnBoardingId), 0,
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(), true, null, null, null,
				ContentTypes.TEXT_HTML, eOnBoarding.getTicketNo(), null, null,
				null, null, 0, 0, null, false);
		AssetLinkLocalServiceUtil.updateLinks(userId, assetEntry.getEntryId(),
				serviceContext.getAssetLinkEntryIds(),
				AssetLinkConstants.TYPE_RELATED);

		Indexer indexer = IndexerRegistryUtil
				.nullSafeGetIndexer(EOnBoarding.class);

		indexer.reindex(eOnBoarding);

		// workflow
		WorkflowHandlerRegistryUtil.startWorkflowInstance(
				eOnBoarding.getCompanyId(), groupId, userId,
				EOnBoarding.class.getName(), eOnBoarding.getEOnBoardingId(),
				eOnBoarding, serviceContext);
		//When submitted,send email to the four roles assigned users
		this.submittedSendEmail(eOnBoarding);
		//this.submittedSendEmailToBuManager(eOnBoarding);
		this.submittedSendEmailToITP(eOnBoarding);
		try {
			this.submittedSendEmailToHrDistributionList(eOnBoarding);
		} catch (MessagingException e) {
			e.printStackTrace();
		}		
		return eOnBoarding;
	}
	
	//When the applicant submitted the form, it send the email to related users
	private void submittedSendEmail(EOnBoarding eOnBoarding) throws SystemException {
		String subject = "E-Onboarding Notification-"+eOnBoarding.getTicketNo()+"-Submitted";
		String cssContent = EOnboardingEmailUtil.getCssContent();
//		String[] toAddresses = GlobalEmailLocalServiceUtil.getRolesOfUsersEmailAddresses(EOnboardingEmailUtil.FOUR_ROLES);
		String[] toAddresses = ApproverDelegationLocalServiceUtil.findEmailsByP_R(ApproverDelegationLocalServiceUtil.getProcessOfEOnboarding(), EOnboardingEmailUtil.FOUR_ROLES);
		StringBuffer mailbody = new StringBuffer();
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		mailbody.append("<div class='emailTmp'>")
				.append("<p>Dear Colleagues,</p>")
				.append("<p>Please kindly note that one new colleague <span class='name'>"+eOnBoarding.getLastName()).append(" ").append(eOnBoarding.getFirstName())
				.append("</span> will join us on <span class='name'>").append(sdf.format(eOnBoarding.getStartingDate())).append("</span>. Please kindly view the details in <a href='")
				.append(PropsUtil.get("vgc.apon.system.href.url")).append("'>APON System</a> and finish all related preparation on time according to our new onboarding process. After having finished preparation, please mark your task as completed in <a href='")
				.append(PropsUtil.get("vgc.apon.system.href.url")).append("'>APON System</a>.</p>")
				.append("<p>Thank you very much for your kindly support!</p>")
				.append("<p><span class='warning02'>please do not reply</span> to this email, as it is system generated.</p>")
				.append("</div>");
		GlobalEmailLocalServiceUtil.sendEmail(toAddresses, null, subject, cssContent, mailbody.toString(), null);
	}
	
	//When the applicant submitted the form,it send the email to the HR Distribution list
	private void submittedSendEmailToHrDistributionList(EOnBoarding eOnBoarding) throws SystemException, MessagingException {
		User applicant = UserLocalServiceUtil.fetchUser(eOnBoarding.getUserId());
		SAPUser	sapUser2 = SAPUserLocalServiceUtil.getSapUserByStaffCode(String.valueOf(eOnBoarding.getStaffCode()));
		String subject = "E-Onboarding Notification-"+sapUser2.getStaffName() +"-"+eOnBoarding.getTicketNo();
		String cssContent = EOnboardingEmailUtil.getCssContent();
		String[] toAddresses = DistributionLocalServiceUtil.findAllEmailAddresses(PropsUtil.get("vgc.apon.distribution.type.hr"));
		SAPUser sapUser = SAPUserLocalServiceUtil.getSapUserByStaffCode(eOnBoarding.getReportTo());
		String[] ccAddresses = Validator.isNotNull(sapUser)?new String[]{sapUser.getEmail()}:null;
		StringBuffer mailbody = new StringBuffer();
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        // Second part (the image)
        String photoPath = null;
        String photoSrc = "";
        if(Validator.isNotNull(eOnBoarding.getPhotoPath())) {
        	photoSrc = "<img style='margin-left:10px; height: 180px;width: 129px;' src=\"cid:image\">";
//        	photoPath = eOnBoarding.getPhotoPath().replace('/', '\\');
        	photoPath = eOnBoarding.getPhotoPath();
        }		
		mailbody.append("<div class='emailTmp'>")
				.append("<p>Dear Colleagues, </p>")
				.append("<p>Please kindly note that one new colleague <span class='name'>").append(eOnBoarding.getLastName()).append(" ").append(eOnBoarding.getFirstName())
				.append("</span> will join us on <span class='name'>").append(sdf.format(eOnBoarding.getStartingDate())).append("</span>. Please kindly view below detail information. </p>")
				.append(photoSrc)
				.append("<table class='grid'>")
				.append("<tr>").append("<td>Comments</td>").append("<td><span class='value'>").append(eOnBoarding.getComments()).append("</td>").append("</tr>")
				.append("<tr>").append("<td>Staff Code</td>").append("<td><span class='value'>").append(eOnBoarding.getStaffCode()).append("</td>").append("</tr>")
				.append("<tr>").append("<td>Last Name</td>").append("<td><span class='value'>").append(eOnBoarding.getLastName()).append("</td>").append("</tr>")
				.append("<tr>").append("<td>First Name</td>").append("<td><span class='value'>").append(eOnBoarding.getFirstName()).append("</td>").append("</tr>")
				.append("<tr>").append("<td>Name(CN)</td>").append("<td><span class='value'>").append(eOnBoarding.getName()).append("</td>").append("</tr>")
				.append("<tr>").append("<td>Gender</td>").append("<td><span class='value'>").append(eOnBoarding.getGender()).append("</td>").append("</tr>")
				.append("<tr>").append("<td>Birthday</td>").append("<td><span class='value'>").append(sdf.format(eOnBoarding.getBirthday())).append("</td>").append("</tr>")
				.append("<tr>").append("<td>Contract Type</td>").append("<td><span class='value'>").append(eOnBoarding.getContractType()).append("</td>").append("</tr>")
				.append("<tr>").append("<td>Division</td>").append("<td><span class='value'>").append(eOnBoarding.getDivision()).append("</td>").append("</tr>")
				.append("<tr>").append("<td>Department</td>").append("<td><span class='value'>").append(eOnBoarding.getDepartment()).append("</td>").append("</tr>")
				.append("<tr>").append("<td>Position Code</td>").append("<td><span class='value'>").append(eOnBoarding.getPositionCode()).append("</td>").append("</tr>")
				.append("<tr>").append("<td>Function Name</td>").append("<td><span class='value'>").append(eOnBoarding.getFunctionName()).append("</td>").append("</tr>")
				.append("<tr>").append("<td>Title</td>").append("<td><span class='value'>").append(eOnBoarding.getTitle()).append("</td>").append("</tr>")
				.append("<tr>").append("<td>Cost Center</td>").append("<td><span class='value'>").append(eOnBoarding.getCostCenter()).append("</td>").append("</tr>")
				.append("<tr>").append("<td>Work Location</td>").append("<td><span class='value'>").append(eOnBoarding.getWorkLocation()).append("</td>").append("</tr>")
				.append("<tr>").append("<td>Office Site</td>").append("<td><span class='value'>").append(eOnBoarding.getOfficeSite()).append("</td>").append("</tr>")
				.append("<tr>").append("<td>Starting Date</td>").append("<td><span class='value'>").append(sdf.format(eOnBoarding.getStartingDate())).append("</td>").append("</tr>")
				.append("<tr>").append("<td>Service Length</td>").append("<td><span class='value'>").append(eOnBoarding.getServiceLength()).append("</td>").append("</tr>")
				.append("<tr>").append("<td>Reporting to</td>").append("<td><span class='value'>").append(eOnBoarding.getReportToStaffName()).append("</td>").append("</tr>")
				.append("<tr>").append("<td>IT Related Hardware (Laptop etc.)</td>").append("<td><span class='value'>").append(eOnBoarding.getItRelatedHardware()?"Y":"N").append("</td>").append("</tr>")
				.append("<tr>").append("<td>Company Car:</td>").append("<td><span class='value'>").append(eOnBoarding.getCompanyCar()?"Y":"N").append("</td>").append("</tr>")
				.append("<tr>").append("<td>Replacement:</td>").append("<td><span class='value'>").append(eOnBoarding.getReplacement()?"Y":"N").append("</td>").append("</tr>")
				.append("<tr>").append("<td>Name of the Replaced Person:</td>").append("<td><span class='value'>").append(eOnBoarding.getNameOfReplacedPerson()).append("</td>").append("</tr>")
				.append("<tr>").append("<td>Contact Info</td>").append("<td><span class='value'>").append(eOnBoarding.getContactInfo()).append("</td>").append("</tr>")
				.append("</table>")
				.append("<p>If you have any question, please contact HR ")
				.append(applicant.getFirstName()+" "+applicant.getLastName()).append("</p>")
				.append("<p>Thank you very much for your kindly support!</p>")
				.append("<p><span class='warning02'>Please do not reply</span> to this email, as it is system generated.</p>")
				.append("</div>");
		GlobalEmailLocalServiceUtil.sendEmail(toAddresses, ccAddresses, subject, cssContent, mailbody.toString(), null,photoPath);
	}
	
	//When the applicant submitted the form, it send the email to ITP of (servicecenter@volkswagen.de)
	private void submittedSendEmailToITP(EOnBoarding eOnBoarding) {
		String subject = "E-Onboarding Notification-"+eOnBoarding.getTicketNo()+"-Submitted";
		String cssContent = EOnboardingEmailUtil.getCssContent();
		String[] toAddresses = new String[]{"psczwei@volkswagen.de","Extern.Yonghong.Shan@volkswagen.com.cn"};
		String environment = PropsUtil.get("vgc.apon.environment");
		if("p".equals(environment)) {
			toAddresses = new String[]{"servicecenter@volkswagen.de"};
		}
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        StringBuffer mailbody = new StringBuffer();

		mailbody.append("SC_type: mailpmo \r\n")
		        .append("SC_title: [").append(eOnBoarding.getOfficeSite()).append("] create a NT account for ").append(eOnBoarding.getLastName())
		        .append(" ").append(eOnBoarding.getFirstName()).append(",staff code: ").append(eOnBoarding.getStaffCode()).append(" on board day: ")
		        .append(sdf.format(eOnBoarding.getStartingDate())).append("\r\n")
		        .append("SC_assignment: OPS UHD-3333 Service Desk VGC China \r\n")
		        .append("SC_category: Service Request \r\n")
		        .append("SC_subcategory: Information \r\n")
		        .append("SC_system_impact: 4 - Low \r\n")
		        .append("SC_operator: EGUOJIM \r\n")
		        .append("SC_vw_ci_identification: AP.VWG AD-EXCHANGE \r\n");
        if("q".equals(environment)) {
        	mailbody.append("SC_vw_ci_env: 2. Prelive \r\n");
		}else if("p".equals(environment)) {
	        mailbody.append("SC_vw_ci_env: 1. Prod \r\n");
		}
        mailbody.append("SC_description: \r\n")
		        .append("\r\n").append("\r\n")
		        .append("Comments: ").append(eOnBoarding.getComments()).append("\r\n")
		        .append("Staff Code: ").append(eOnBoarding.getStaffCode()).append("\r\n")
		        .append("Last Name: ").append(eOnBoarding.getLastName()).append("\r\n")
		        .append("First Name: ").append(eOnBoarding.getFirstName()).append("\r\n")
		        .append("Name(CN): ").append(eOnBoarding.getName()).append("\r\n")
		        .append("Gender: ").append(eOnBoarding.getGender()).append("\r\n")
		       .append("Birthday: ").append(sdf.format(eOnBoarding.getBirthday())).append("\r\n")
		        .append("Contract Type: ").append(eOnBoarding.getContractType()).append("\r\n")
		        .append("Division: ").append(eOnBoarding.getDivision()).append("\r\n")
		        .append("Department: ").append(eOnBoarding.getDepartment()).append("\r\n")
		        .append("Position Code: ").append(eOnBoarding.getPositionCode()).append("\r\n")
		        .append("Function Name: ").append(eOnBoarding.getFunctionName()).append("\r\n")
		        .append("Title: ").append(eOnBoarding.getTitle()).append("\r\n")
		        .append("Cost Center: ").append(eOnBoarding.getCostCenter()).append("\r\n")
		        .append("Work Location: ").append(eOnBoarding.getWorkLocation()).append("\r\n")
		        .append("Office Site: ").append(eOnBoarding.getOfficeSite()).append("\r\n")
		        .append("Starting Date: ").append(sdf.format(eOnBoarding.getStartingDate())).append("\r\n")
		        .append("Service Length: ").append(eOnBoarding.getServiceLength()).append("\r\n")
		        .append("Reporting to: ").append(eOnBoarding.getReportToStaffName()).append("\r\n")
		        .append("IT Related Hardware (Laptop etc.): ").append(eOnBoarding.getItRelatedHardware()?"Y":"N").append("\r\n")
		        .append("Contact Info: ").append(eOnBoarding.getContactInfo()).append("\r\n");
		GlobalEmailLocalServiceUtil.sendTxtEmail(toAddresses, null, subject, cssContent, mailbody.toString(), null);
	}
	
	//When the applicant submitted the form, it send the email to related users
	private void submittedSendEmailToBuManager(EOnBoarding eOnBoarding) throws SystemException {
		String subject = "E-Onboarding-"+eOnBoarding.getTicketNo()+".-IT Equipment Related Notification";
		String cssContent = EOnboardingEmailUtil.getCssContent();
		SAPUser sapUser = SAPUserLocalServiceUtil.getSapUserByStaffCode(eOnBoarding.getReportTo());
		User user = UserLocalServiceUtil.fetchUserByFacebookId(PortalUtil.getDefaultCompanyId(), Long.valueOf(eOnBoarding.getReportTo()));
		if(user!=null && Validator.isNotNull(user.getEmailAddress())) {
			String[] toAddresses = new String[]{user.getEmailAddress()};
			StringBuffer mailbody = new StringBuffer();
			SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
			mailbody.append("<div class='emailTmp'>")
					.append("<p>Dear <span class='name'>"+eOnBoarding.getReportToStaffName()+"</span>,</p>")
					.append("<p>Please kindly note that your new colleague <span class='name'>").append(eOnBoarding.getLastName()).append(" ").append(eOnBoarding.getFirstName())
					.append("</span> will join us on <span class='name'>").append(sdf.format(eOnBoarding.getStartingDate()))
					.append("</span>")
					.append(" Please kindly view his/her onboarding preparation status in <a href='")
					.append(PropsUtil.get("vgc.apon.system.href.url")).append("'>APON System</a>.</p>")
					.append("<p><a class='warning'>IT Related Hardware (Laptop etc.) need to be separate requested (On Demand): </a></p>")
					.append("<p>Please fill out the <a href='#' class='href'>equipment application form</a> and deliver the approved form to Controlling <span class='warning'>7 working days before</span> your new colleague on-boarding date, then UHD will follow up with this asset application, so that your new colleague can get the IT equipment at his\\her first working day.</p>")
					.append("<p style='display:none;'>Please fill out the IT equipment application form in <a href='")
					.append(PropsUtil.get("vgc.apon.system.href.url")).append("' class='href'>APON system</a>, IT requires 3-5 working days to prepare the equipment after the application are fully approved in APON. </p>")
					.append("<p>Please assure you have read through below policies/processes and get the latest version of Application Form before making the application via policy No.13 of <a href='http://portal.vcic.ap.vwg/regulations' class='href'>http://portal.vcic.ap.vwg/regulations.</a></p>")
					.append("<p>Any question, please contact <a href='#' class='href'>uhd@volkswagen.com.cn</a> or call <span class='href'>3333</span>.</p>")
					.append("<p><span class='warning02'>please do not reply</span> to this email, as it is system generated.</p>")
					.append("</div>");
			GlobalEmailLocalServiceUtil.sendEmail(toAddresses, null, subject, cssContent, mailbody.toString(), null);
		}		
	}

	// workflow status
	public EOnBoarding updateStatus(long userId, long eOnBoardingId,
			int status, ServiceContext serviceContext) throws PortalException,
			SystemException {
		User user = userLocalService.getUser(userId);
		EOnBoarding eOnBoarding = getEOnBoarding(eOnBoardingId);
		eOnBoarding.setStatus(status);
		eOnBoarding.setStatusByUserId(userId);
		eOnBoarding.setStatusByUserName(user.getFullName());
		eOnBoarding.setStatusDate(new Date());
		updateEOnBoarding(eOnBoarding);
		return eOnBoarding;
	}
	
	// Get the onboarding list according status and userid
	public List<EOnBoarding> findByS_U(int status, long userId)
			throws SystemException {
		return eOnBoardingPersistence.findByS_U(status, userId);
	}

	// Get the e onboarding list according status and userid
	public List<EOnBoarding> findDraftListByUserId(long userId)
			throws SystemException {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(EOnBoarding.class);
		query.add(PropertyFactoryUtil.forName("status").eq(2));
		query.add(PropertyFactoryUtil.forName("userId").eq(userId));
		return dynamicQuery(query);
	}
	
	// Get the e onboarding list according status and userid
	public List<EOnBoarding> findViewList(long userId)
			throws SystemException {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(EOnBoarding.class);	
		if(isHasRole(userId, "EO_Organization")) {		
			query.add(PropertyFactoryUtil.forName("status").ne(2));	
			return dynamicQuery(query);
		}else {	
			query.add(PropertyFactoryUtil.forName("status").ne(2));	
			List<EOnBoarding> list = dynamicQuery(query);
			List<EOnBoarding> result = new ArrayList<EOnBoarding>();			
			for(EOnBoarding eOnBoarding:list) {
				SAPUser sapUser = SAPUserLocalServiceUtil.getSapUserByStaffCode(eOnBoarding.getStaffCode());
				User user = UserLocalServiceUtil.fetchUser(userId);				
				if(sapUser!=null && user!=null && Long.valueOf(sapUser.getReportToSupervisorId())==user.getFacebookId()) {
					result.add(eOnBoarding);
				}
			}
			return result;
		}		
	}

	// Save or update the audit trail log for workflow
	public void saveOrUpdateAuditTrailLog(long companyId, long groupId,
			long eOnBoardingId, String operationUser, String action,
			String operationComment,String OperationRole) throws SystemException, PortalException {
		Date now = new Date();
		EOnBoarding eOnBoarding = EOnBoardingLocalServiceUtil.fetchEOnBoarding(eOnBoardingId);
		List<AuditTrailLog> list = AuditTrailLogLocalServiceUtil
				.findAuditTrailByWF_O_O(eOnBoardingId,
						EOnBoarding.class.getName());
		int operationNo = this.getOperationNo(list);
		if (ActionConstants.SUBMIT.equals(action)) {
			String submitComment = "";
			if(eOnBoarding.getIsApplicantAgent()) {
				ApplicantDelegation applicantDelegation = ApplicantDelegationLocalServiceUtil.fetchByP_S(ApproverDelegationLocalServiceUtil.getProcessOfEOnboarding(), String.valueOf(UserLocalServiceUtil.fetchUserById(eOnBoarding.getUserId()).getFacebookId()));
				submitComment = "On behalf of "+ApplicantDelegationLocalServiceUtil.getAgentName(applicantDelegation);
			}
			if (list == null || list.size() == 0) {
				for (EOnboardingLogEnum eLogEnum : EOnboardingLogEnum
						.values()) {
					if (eLogEnum.getNumber() == 1) {
						AuditTrailLogLocalServiceUtil.saveAuditTrailLog(
								companyId, groupId, eOnBoardingId,
								EOnBoarding.class.getName(),
								eLogEnum.getNumber(), eLogEnum.getRole(),
								operationUser,
								ActionConstants.STATUS_SUBMITTED, now, submitComment);
					} else {
						String approverUser = "";					
						switch (eLogEnum.getNumber()) {
						case 97:
							approverUser = this.getOperationUserByRoleName(companyId, "EO_Admin");
							break;
						case 98:
							approverUser = this.getOperationUserByRoleName(companyId, "EO_Security");
							break;
						case 99:
							approverUser = this.getOperationUserByRoleName(companyId, "EO_ITP");
							break;
						case 100:
							approverUser = this.getOperationUserByRoleName(companyId, "EO_Controlling/Finance");
							break;
						}	
						AuditTrailLogLocalServiceUtil.saveAuditTrailLog(
								companyId, groupId, eOnBoardingId,
								EOnBoarding.class.getName(),
								eLogEnum.getNumber(), eLogEnum.getRole(),
								approverUser,
								ActionConstants.STATUS_PENDING_TO_APPROVE, null,
								"");
					}
				}
			} else {
				AuditTrailLogLocalServiceUtil.saveAuditTrailLog(companyId,
						groupId, eOnBoardingId,
						EOnBoarding.class.getName(), operationNo,
						EOnboardingLogEnum.APPLICANT.getRole(),
						operationUser, ActionConstants.STATUS_SUBMITTED, now,
						submitComment);
			}
		} else if (ActionConstants.RECALL.equals(action)) {
			AuditTrailLogLocalServiceUtil.saveAuditTrailLog(companyId, groupId,
					eOnBoardingId, EOnBoarding.class.getName(),
					operationNo, EOnboardingLogEnum.APPLICANT.getRole(),
					operationUser, ActionConstants.STATUS_RECALL, now,
					operationComment);
			int j = 0;
			for(int i=0;i<list.size();i++) {
				AuditTrailLog auditTrailLog = list.get(i);
				if(auditTrailLog==null || (auditTrailLog!=null && auditTrailLog.getOperationStatus().equals(ActionConstants.STATUS_COMPLETED))) {
					j++;
					auditTrailLog.setOperationNo(j+operationNo);
					AuditTrailLogLocalServiceUtil.updateAuditTrailLog(auditTrailLog);	
				}				
			}
			for (EOnboardingLogEnum eLogEnum : EOnboardingLogEnum
					.values()) {
				if(eLogEnum.getNumber()!=1) {
					String approverUser = "";					
					switch (eLogEnum.getNumber()) {
					case 97:
						approverUser = this.getOperationUserByRoleName(companyId, "EO_Admin");
						break;
					case 98:
						approverUser = this.getOperationUserByRoleName(companyId, "EO_Security");
						break;
					case 99:
						approverUser = this.getOperationUserByRoleName(companyId, "EO_ITP");
						break;
					case 100:
						approverUser = this.getOperationUserByRoleName(companyId, "EO_Controlling/Finance");
						break;
					}	
					AuditTrailLog auditTrailLog = AuditTrailLogLocalServiceUtil.findAuditTrailByWF_C_O_O_O(companyId, eOnBoardingId, EOnBoarding.class.getName(), eLogEnum.getNumber());
					if(auditTrailLog==null) {
						AuditTrailLogLocalServiceUtil.saveAuditTrailLog(
								companyId, groupId, eOnBoardingId,
								EOnBoarding.class.getName(),
								eLogEnum.getNumber(), eLogEnum.getRole(),
								approverUser,
								ActionConstants.STATUS_PENDING_TO_APPROVE, null,
								"");
					}					
				}					
			}
		} else {
			if (ActionConstants.APPROVE.equals(action)) {
				for (AuditTrailLog auditTrailLog : list) {
					if (auditTrailLog.getOperationRole().equals(OperationRole)) {
						String approverUser = "";
						switch (auditTrailLog.getOperationNo()) {
						case 97:
							approverUser = this.getOperationUserByRoleName(companyId, "EO_Admin");
							break;
						case 98:
							approverUser = this.getOperationUserByRoleName(companyId, "EO_Security");
							break;
						case 99:
							approverUser = this.getOperationUserByRoleName(companyId, "EO_ITP");
							break;
						case 100:
							approverUser = this.getOperationUserByRoleName(companyId, "EO_Controlling/Finance");
							break;
						}							
						auditTrailLog.setOperationUser(approverUser);
						auditTrailLog
								.setOperationStatus(ActionConstants.STATUS_COMPLETED);
						auditTrailLog.setOperationComment(operationComment);
						auditTrailLog.setOperationTime(now);
						AuditTrailLogLocalServiceUtil
								.updateAuditTrailLog(auditTrailLog);
						break;
					}
				}
			}else if (ActionConstants.CANCEL.equals(action)) {
				AuditTrailLogLocalServiceUtil.saveAuditTrailLog(companyId, groupId, eOnBoardingId, EOnBoarding.class.getName(),
						operationNo, EOnboardingLogEnum.APPLICANT.getRole(), operationUser, ActionConstants.STATUS_CANCELLED, now, operationComment);
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
		if (operationUser.length() > 0) {
			return operationUser.substring(0, operationUser.length() - 1);
		} else {
			return "";
		}
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
	
	/**
	 * Generate the ticket no for the workflow for example:EO20150300000001
	 */
	public String generateTicketNo(String prefix) {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyyMM");
		String name = prefix + dateFormat.format(date);
		long number;
		try {
			number = CounterLocalServiceUtil.increment(name, 1);
			return name + String.format("%07d", number, 1);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}
}