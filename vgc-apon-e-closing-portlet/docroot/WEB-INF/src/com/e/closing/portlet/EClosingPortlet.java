package com.e.closing.portlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import com.delegation.model.ApplicantDelegation;
import com.delegation.service.ApplicantDelegationLocalServiceUtil;
import com.delegation.service.ApproverDelegationLocalServiceUtil;
import com.e.closing.common.EClosingConstants;
import com.e.closing.model.EClosing;
import com.e.closing.model.impl.EClosingImpl;
import com.e.closing.service.EClosingLocalServiceUtil;
import com.global.management.model.WorkSpaceManagement;
import com.global.management.service.WorkSpaceManagementLocalServiceUtil;
import com.it.equipment.service.IEClosingReturnLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.vgc.apon.model.SAPUser;
import com.vgc.apon.service.SAPUserLocalServiceUtil;

/**
 * E-Closing
 * @author t.a.jiang
 * @datetime Feb 19, 2016 11:08:39 AM
 */
public class EClosingPortlet extends MVCPortlet {
 
	private static Log log = LogFactoryUtil.getLog(EClosingPortlet.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		HttpServletRequest request = PortalUtil.getHttpServletRequest(renderRequest);
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		// Get Param
		long staffCode = ParamUtil.getLong(renderRequest, "staffCode", 0);
		long eClosingId = ParamUtil.getLong(renderRequest, "eClosingId", 0);
		String transitionName = ParamUtil.getString(renderRequest, "transitionName", "");
		boolean eClosingDelegation = ParamUtil.getBoolean(renderRequest, "eClosingDelegation", false);
		
		// Print Logger
		log.info("staffCode=" + staffCode);
		log.info("eClosingId=" + eClosingId);
		log.info("transitionName=" + transitionName);
		log.info("eClosingDelegation=" + eClosingDelegation);
		
		// EClosing All Info
		EClosing eClosing = new EClosingImpl();
		if (eClosingId > 0) {
			try {
				eClosing = EClosingLocalServiceUtil.getEClosing(eClosingId);
			} catch (PortalException e) {
				throw new RuntimeException(e.getMessage());
			} catch (SystemException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		boolean isHasDelegation = false;
		String applicantAgentName = "";
		ApplicantDelegation applicantDelegation = null;
		if (themeDisplay.getUser().getFacebookId() > 0) {
			Date date = new Date();
			applicantDelegation = ApplicantDelegationLocalServiceUtil.fetchByP_S(ApproverDelegationLocalServiceUtil.getProcessOfEClosing(), String.valueOf(themeDisplay.getUser().getFacebookId()));
			if (applicantDelegation != null && date.after(applicantDelegation.getEffectiveStartDate()) && date.before(applicantDelegation.getEffectiveEndDate())) {
				isHasDelegation = true;
				applicantAgentName = ApplicantDelegationLocalServiceUtil.getAgentName(applicantDelegation);
			}
		}
		
		// Get SAP User Info
		if (staffCode > 0) {
			SAPUser sapUser = null;
			WorkSpaceManagement workSpaceManagement = null;
			try {
				sapUser = SAPUserLocalServiceUtil.getSapUserByStaffCode(String.valueOf(staffCode));
				workSpaceManagement = WorkSpaceManagementLocalServiceUtil.findByStaffCode(staffCode+"");
			} catch (SystemException e) {
				throw new RuntimeException(e.getMessage());
			}
			if (sapUser != null) {
				eClosing.setStaffCode(Integer.parseInt(sapUser.getStaffCode()));
				eClosing.setStaffName(sapUser.getStaffName());
				eClosing.setCompany(sapUser.getSapCompanyName());
				eClosing.setDivision(sapUser.getDivisionName());
				eClosing.setDepartment(sapUser.getDepartmentName());
				eClosing.setCostCenter(sapUser.getCostCener());
				eClosing.setPositionCode(sapUser.getPositionId());
				eClosing.setFunctionName(sapUser.getPositionName());
				eClosing.setEmployeeGroupId(sapUser.getEmployeeGroupId());
				eClosing.setEmployeeGroupName(sapUser.getEmployeeGroupName());
				eClosing.setStartingDate(sapUser.getHiringDate());
				if (Validator.isNotNull(workSpaceManagement) && Validator.isNotNull(workSpaceManagement.getSeatNo())) {
					eClosing.setSeatOfficeNumber(workSpaceManagement.getSeatNo());
				}
			}
		}
		
		// Set ApplicantAgent
		eClosing.setApplicantAgent(eClosingDelegation);
		
		// Back
		String backPortletId = PropsUtil.get("vgc.apon.my.applications.portletId");
		String backPrefixUrl = PropsUtil.get("vgc.apon.site.prefix") + themeDisplay.getScopeGroup().getFriendlyURL();
		String backFriendlyUrl = backPrefixUrl + PropsUtil.get("vgc.apon.my.applications.page.friendly.url");
		long backPlid = PortalUtil.getPlidFromFriendlyURL(themeDisplay.getCompanyId(), backFriendlyUrl);
		
		// Request Attribute
		request.setAttribute("transitionName", transitionName);
		
		request.setAttribute("eClosing", eClosing);
		
		request.setAttribute("isHasDelegation", isHasDelegation);
		request.setAttribute("applicantAgentName", applicantAgentName);
		
		request.setAttribute("backPortletId", backPortletId);
		request.setAttribute("backPlid", backPlid);
		
		super.doView(renderRequest, renderResponse);
	}
	
	public void saveOrUpdateEClosing(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException, PortalException, SystemException {
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		ServiceContext serviceContext = ServiceContextFactory.getInstance(EClosing.class.getName(), uploadPortletRequest);
		ThemeDisplay themeDisplay = (ThemeDisplay)uploadPortletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		// Get Param
		String tabs2 = ParamUtil.getString(uploadPortletRequest, "tabs2", EClosingConstants.SUBMISSIONS_TAB_DRAFT);
		String action = ParamUtil.getString(uploadPortletRequest, "action", "0");// æ“�ä½œç±»åž‹ï¼Œé»˜è®¤ä¸ºä¿�å­˜ï¼ˆ1-ä¸ºæ��äº¤ï¼‰
		long eClosingId = ParamUtil.getLong(uploadPortletRequest, "eClosingId", 0);
		boolean applicantAgent = ParamUtil.getBoolean(uploadPortletRequest, "applicantAgent", false);
		boolean approverAgent = ParamUtil.getBoolean(uploadPortletRequest, "approverAgent", false);
		
		// Print Logger
		log.info("eClosingId=" + eClosingId);
		
		// EClosing
		EClosing eClosing = new EClosingImpl();
		if (eClosingId > 0) {
			eClosing = EClosingLocalServiceUtil.getEClosing(eClosingId);
		}else {
			eClosingId = CounterLocalServiceUtil.increment(EClosing.class.getName(), 1);
			eClosing = EClosingLocalServiceUtil.createEClosing(eClosingId);
		}
		
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		
		eClosing.setStaffCode(ParamUtil.getInteger(uploadPortletRequest, "staffCode"));
		eClosing.setStaffName(ParamUtil.getString(uploadPortletRequest, "staffName"));
		eClosing.setCompany(ParamUtil.getString(uploadPortletRequest, "company"));
		eClosing.setDivision(ParamUtil.getString(uploadPortletRequest, "division"));
		eClosing.setDepartment(ParamUtil.getString(uploadPortletRequest, "department"));
		eClosing.setCostCenter(ParamUtil.getString(uploadPortletRequest, "costCenter"));
		eClosing.setPositionCode(ParamUtil.getString(uploadPortletRequest, "positionCode"));
		eClosing.setFunctionName(ParamUtil.getString(uploadPortletRequest, "functionName"));
		eClosing.setEmployeeGroupId(ParamUtil.getString(uploadPortletRequest, "employeeGroupId"));
		eClosing.setEmployeeGroupName(ParamUtil.getString(uploadPortletRequest, "employeeGroupName"));
		eClosing.setPrivateEmailAddress(ParamUtil.getString(uploadPortletRequest, "privateEmailAddress"));
		eClosing.setStartingDate(ParamUtil.getDate(uploadPortletRequest, "startingDate", dateFormat));
		if (Validator.isNotNull(ParamUtil.getString(uploadPortletRequest, "lastWorkingDay", ""))) {
			eClosing.setLastWorkingDay(ParamUtil.getDate(uploadPortletRequest, "lastWorkingDay", dateFormat));
		}
		if (Validator.isNotNull(ParamUtil.getString(uploadPortletRequest, "finishContractDate", ""))) {
			eClosing.setFinishContractDate(ParamUtil.getDate(uploadPortletRequest, "finishContractDate", dateFormat));
		}
		eClosing.setSeatOfficeNumber(ParamUtil.getString(uploadPortletRequest, "seatOfficeNumber"));
		eClosing.setPermanentAddress(ParamUtil.getString(uploadPortletRequest, "permanentAddress"));
		
		// Set Ticket No.
		if (Validator.isNull(eClosing.getTicketNo())) {
			eClosing.setTicketNo(EClosingLocalServiceUtil.getTicketNo(PropsUtil.get("vgc.apon.e.closing.ticketno.prefix")));
		}
		
		// Set Constants
		eClosing.setProcessType(EClosingConstants.PROCESS_TYPE);
		eClosing.setSubProcessType(EClosingConstants.SUB_PROCESS_TYPE);
		
		// Set Delegation
		eClosing.setApplicantAgent(applicantAgent);
		eClosing.setApproverAgent(approverAgent);
		
		EClosingLocalServiceUtil.saveOrUpdateEClosing(action, themeDisplay.getUserId(), eClosing, serviceContext);
		
		//Start the workflow for IT Equipment Closing Return 
		if(action.equals("1") || action.equals("2")) {
			IEClosingReturnLocalServiceUtil.submitIEClosingReturn(String.valueOf(eClosing.getStaffCode()), eClosing.getTicketNo(), uploadPortletRequest);
		}		
				
		// Redirect
		String redirectPortletId = PropsUtil.get("vgc.apon.my.applications.portletId");
		String redirectPrefixUrl = PropsUtil.get("vgc.apon.site.prefix") + themeDisplay.getScopeGroup().getFriendlyURL();
		String redirectFriendlyUrl = redirectPrefixUrl + PropsUtil.get("vgc.apon.my.applications.page.friendly.url");
		long redirectPlid = PortalUtil.getPlidFromFriendlyURL(themeDisplay.getCompanyId(), redirectFriendlyUrl);
		
		// Redirect URL
		PortletURL redirectUrl = PortletURLFactoryUtil.create(actionRequest, redirectPortletId, redirectPlid, PortletRequest.RENDER_PHASE);
		if (action.equals("0")) {
			tabs2 = EClosingConstants.SUBMISSIONS_TAB_DRAFT;
		}else if (action.equals("1")) {
			tabs2 = EClosingConstants.SUBMISSIONS_TAB_IN_PROCESS;
		}else if (action.equals("2")) {
			tabs2 = EClosingConstants.SUBMISSIONS_TAB_IN_PROCESS;
		}
		redirectUrl.setParameter("tabs2", tabs2);
		redirectUrl.setWindowState(LiferayWindowState.NORMAL);
		
		actionResponse.sendRedirect(redirectUrl.toString());
	}
	
}