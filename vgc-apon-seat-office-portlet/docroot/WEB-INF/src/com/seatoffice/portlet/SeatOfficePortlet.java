package com.seatoffice.portlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.delegation.model.ApplicantDelegation;
import com.delegation.service.ApplicantDelegationLocalServiceUtil;
import com.delegation.service.ApproverDelegationLocalServiceUtil;
import com.global.management.model.WorkSpaceManagement;
import com.global.management.service.WorkSpaceManagementLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.model.WorkflowInstanceLink;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.WorkflowInstanceLinkLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.seatoffice.model.SeatOffice;
import com.seatoffice.service.SeatOfficeLocalServiceUtil;
import com.seatoffice.util.ActionConstants;
import com.seatoffice.util.OfficeSiteEnum;
import com.seatoffice.util.SeatOfficeCategoryEnum;
import com.seatoffice.util.SeatOfficePositionLevelEnum;
import com.seatoffice.util.WorkSpaceConstants;
import com.vgc.apon.model.SAPUser;
import com.vgc.apon.service.SAPUserLocalServiceUtil;

public class SeatOfficePortlet extends MVCPortlet {
	private static Log log = LogFactoryUtil
			.getLog(SeatOfficePortlet.class);

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {	
		try {
			//Get the SAPUser from database
			long staffCode = ParamUtil.getLong(renderRequest, "staffCode",0);
			long seatOfficeId = ParamUtil.getLong(renderRequest, "seatOfficeId",0);
			seatOfficeId=SeatOfficeLocalServiceUtil.fetchSeatOffice(seatOfficeId)==null?0:seatOfficeId;
			SAPUser sapUser = staffCode==0?null:SAPUserLocalServiceUtil.getSapUserByStaffCode(String.valueOf(staffCode));
			renderRequest.setAttribute("sapUser", sapUser);		
			renderRequest.setAttribute("staffCode", staffCode);	
			renderRequest.setAttribute("seatOfficeId", seatOfficeId);
			log.info("The SapUser info is :"+sapUser);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		super.doView(renderRequest, renderResponse);
	}

	/**
	 * Save,Update,Submit the seat & office
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void addSeatOffice(ActionRequest request,
			ActionResponse response) throws Exception {
		UploadPortletRequest uploadPortletRequest =  PortalUtil.getUploadPortletRequest(request);		
		ThemeDisplay themeDisplay = (ThemeDisplay) uploadPortletRequest
				.getAttribute(WebKeys.THEME_DISPLAY);	
		String cmd = ParamUtil.getString(uploadPortletRequest, Constants.CMD);
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		Boolean isApplicantAgent = ParamUtil.getBoolean(uploadPortletRequest, "isApplicantAgent",false);
		long seatOfficeId = ParamUtil
				.getLong(uploadPortletRequest, "seatOfficeId");
		long userid=0l;
		String positionFg="No";
		long staffCode = ParamUtil.getLong(uploadPortletRequest, "staffCode");	
	//	System.out.println("------staffCode----"+staffCode);	 
		if(staffCode==0) {
			staffCode = 190002l;
		}		
		SAPUser sapUser = SAPUserLocalServiceUtil.getSapUserByStaffCode(String.valueOf(staffCode));	
	//	Boolean isOnBehalfOf = ParamUtil.getBoolean(uploadPortletRequest, "isOnBehalfOf");		
		WorkSpaceManagement workspace=WorkSpaceManagementLocalServiceUtil.findByStaffCode(String.valueOf(staffCode));
		String mobilePhone = ParamUtil.getString(uploadPortletRequest, "mobilePhone");
		String officePhone = ParamUtil.getString(uploadPortletRequest, "officePhone");		
	    String expectedSeatNo=ParamUtil.getString(uploadPortletRequest, "expectedSeatNo");
	    String newSeatNo=ParamUtil.getString(uploadPortletRequest, "newSeatNo");	
	    String reason=ParamUtil.getString(uploadPortletRequest, "reason");	
	    //type of Requirement
	    Boolean officeKey=ParamUtil.getBoolean(uploadPortletRequest, "officeKey");
	   // System.out.println("------officeKey----"+officeKey);
	    Boolean plane=ParamUtil.getBoolean(uploadPortletRequest, "plant");	
	  //  System.out.println("------plane----"+plane);
	    Boolean Tel=ParamUtil.getBoolean(uploadPortletRequest, "tel");	
	    Boolean namePlate=ParamUtil.getBoolean(uploadPortletRequest, "namePlate");	
	    Boolean cabinet=ParamUtil.getBoolean(uploadPortletRequest, "cabinet");
		String comments = ParamUtil.getString(uploadPortletRequest, "comments");
		if(comments.indexOf("If you plan to change the working location during your assignment, please list the different working locations")!=-1) {
			comments = "";
		}
		
		String movingDateStr = ParamUtil.getString(uploadPortletRequest, "movingDate");
		Date movingDate = ParamUtil.getDate(uploadPortletRequest, "movingDate",
				dateFormat);
		if(movingDateStr==null || "".equals(movingDateStr)) {
			movingDate = null;
		}		
		
		SeatOffice seatOffice = SeatOfficeLocalServiceUtil.fetchSeatOffice(seatOfficeId);
		if(seatOffice==null) {
			if(seatOfficeId==0) {
				seatOfficeId  = CounterLocalServiceUtil.increment(SeatOffice.class.getName(), 1);
			}
			seatOffice = SeatOfficeLocalServiceUtil.createSeatOffice(seatOfficeId);
			String ticketNo = SeatOfficeLocalServiceUtil.generateTicketNo("SO");
			seatOffice.setTicketNo(ticketNo);
			Date now = new Date();
			seatOffice.setCreateDate(now);	
		}
		seatOffice.setIsApplicantAgent(isApplicantAgent);
		seatOffice.setSeatId(seatOfficeId);
		seatOffice.setStaffName(sapUser.getStaffName());
		seatOffice.setStaffCode(staffCode);
		seatOffice.setCompanyName(sapUser.getSapCompanyName());
		seatOffice.setDivision(sapUser.getDivisionName());
		seatOffice.setDepartment(sapUser.getDepartmentName());
		seatOffice.setCostCenter(sapUser.getCostCener());
		seatOffice.setContractType(sapUser.getEmployeeGroupId());
	    seatOffice.setSg(sapUser.getSg());
	    seatOffice.setLeadingMark(sapUser.getLeadingMark());
		seatOffice.setMobilePhone(mobilePhone);
		seatOffice.setOfficePhone(officePhone);
		seatOffice.setExpectedSeatNo(expectedSeatNo);
		seatOffice.setMovingDate(movingDate);
	//	seatOffice.setNowCategory(Long.valueOf(newCategory));
		seatOffice.setNewSeatNo(newSeatNo);
		seatOffice.setReasonForChange(reason);
		seatOffice.setOfficeKey(officeKey);
		seatOffice.setPlant(plane);
		seatOffice.setTelephoneAndExtNo(Tel);
		seatOffice.setNamePlate(namePlate);
		seatOffice.setCabinet(cabinet);
	    seatOffice.setComments(comments);
	    if(sapUser.getOfficeSite()==null){
    		seatOffice.setOfficeSite(OfficeSiteEnum.EMPTY.getIndex());
    	}
    	else{
		seatOffice.setOfficeSite(OfficeSiteEnum.getIndex(sapUser.getOfficeSite()));
    	}
	    if(null!=workspace){
	    	
	    	long currentCategory=SeatOfficeCategoryEnum.getNumber(workspace.getCategory());
			seatOffice.setCurrentCategory(currentCategory);
			seatOffice.setCurrentSeatNo(workspace.getSeatNo());
			seatOffice.setWorkspaceId(workspace.getWorkSpaceManagementId());
			if(workspace.getSeatStatus()==null){
				seatOffice.setSeatStatus("");
	    	}
	    	else{
	    		seatOffice.setSeatStatus(workspace.getSeatStatus());
	    	}
			
			long newCategory1=0;
			 String sg=sapUser.getSg();
			 String leadingMark=sapUser.getLeadingMark();
			 String officeSite=OfficeSiteEnum.getIndex(sapUser.getOfficeSite());
			 String empty="";
			 if(SeatOfficePositionLevelEnum.getLevel(sg)>=SeatOfficePositionLevelEnum.N.getLevel()){
				 newCategory1=SeatOfficeCategoryEnum.SingleOffice.getNumber();//sigle office
			 }
			 else{
				 if((SeatOfficePositionLevelEnum.getLevel(sg)==SeatOfficePositionLevelEnum.L.getLevel()||SeatOfficePositionLevelEnum.getLevel(sg)==SeatOfficePositionLevelEnum.M.getLevel())
						 &&(!(empty.equalsIgnoreCase(leadingMark))))
				 {
					 if((OfficeSiteEnum.ACB.getIndex()).equalsIgnoreCase(officeSite)){
						 newCategory1=SeatOfficeCategoryEnum.TeamLeaderSeat.getNumber();//sigle office
						 
					 }
					 else{
						 newCategory1=SeatOfficeCategoryEnum.TwinOffice.getNumber();//sigle office
					 }
				 }
				 else{
					 newCategory1=SeatOfficeCategoryEnum.Workstation.getNumber();//sigle office 
				 }
			 }
			for (SeatOfficeCategoryEnum eEnum : SeatOfficeCategoryEnum.values()) {
			 if(currentCategory==eEnum.Workstation.getNumber()&&newCategory1==eEnum.SingleOffice.getNumber()){
				 positionFg="Yes";
			 }
			 else if(currentCategory==eEnum.Workstation.getNumber()&&newCategory1==eEnum.TwinOffice.getNumber()){
				 positionFg="Yes";
			 }
			 else if(currentCategory==eEnum.TwinOffice.getNumber()&&newCategory1==eEnum.SingleOffice.getNumber()){
				 positionFg="Yes";
			 }
			 else if(currentCategory==eEnum.TeamLeaderSeat.getNumber()&&newCategory1==eEnum.SingleOffice.getNumber()){
				 positionFg="Yes";
			 }
			 else {
				 positionFg="No";
			 }
			}
			
		}
	    seatOffice.setPositionFlag(positionFg);
	  // Common

	    seatOffice.setProcessType(WorkSpaceConstants.PROCESS_TYPE);
	    seatOffice.setSubProcessType(WorkSpaceConstants.SUB_TYPE_SEATOFFICE_FOR_CONTRACTOR_INTERN);
	 		
		seatOffice.setUserName(themeDisplay.getUser().getFullName());
      
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				SeatOffice.class.getName(), uploadPortletRequest);
		log.info("The seatOffice info is :"+seatOffice);	
	
		//Get the URL to redirect
		String url = themeDisplay.getURLPortal();
		url = url.indexOf("9080")!=-1?"":url.substring(url.lastIndexOf('/'));
		StringBuffer sb = new StringBuffer(url);
		String friendlyUrl = PropsUtil.get("vgc.apon.my.applications.page.friendly.url");
		sb.append("/web").append(themeDisplay.getScopeGroup().getFriendlyURL()).append(friendlyUrl);
		//Get the portlet Id of which need to forward
		String redirectPortletId = PropsUtil.get("vgc.apon.my.applications.portletId");
		sb.append("?p_p_id=").append(redirectPortletId).append("&_").append(redirectPortletId).append("_tabs2=");
//		if(cmd.equals(Constants.PUBLISH)) {
//			String transitionName = ParamUtil.getString(uploadPortletRequest, "transitionName");
//			if("resubmit".equals(transitionName)) {
//				long companyId = serviceContext.getCompanyId();
//				WorkflowInstanceLink w = WorkflowInstanceLinkLocalServiceUtil.fetchWorkflowInstanceLink(companyId, seatOffice.getGroupId(), SeatOffice.class.getName(), seatOfficeId);
//				int end = WorkflowTaskManagerUtil.getWorkflowTaskCount(companyId, false);				
//				List<WorkflowTask> list = WorkflowTaskManagerUtil.getWorkflowTasks(companyId, false, 0, end, null);
//				for(WorkflowTask wt:list) {
//					if(w.getWorkflowInstanceId()==wt.getWorkflowInstanceId()) {
//						seatOffice =SeatOfficeLocalServiceUtil.saveOrUpdateSeatOffice(seatOffice, serviceContext);
//						WorkflowTaskManagerUtil.completeWorkflowTask(
//								companyId, themeDisplay.getUserId(),
//								wt.getWorkflowTaskId(), transitionName, "", null);
//						break;
//					}
//				}
//			}else {
//				seatOffice = SeatOfficeLocalServiceUtil.submitSeatOffice(seatOffice, serviceContext);		
//			}				
//			String operationUser = themeDisplay.getUser().getFirstName()+" "+themeDisplay.getUser().getLastName();
//			SeatOfficeLocalServiceUtil.saveOrUpdateAuditTrailLog(serviceContext.getCompanyId(), serviceContext.getScopeGroupId(),  seatOfficeId,userid, operationUser, ActionConstants.SUBMIT, "");
//			sb.append("pending");
//			log.info("The redirect url is :"+sb.toString());
//		}else {
//			seatOffice = SeatOfficeLocalServiceUtil.saveOrUpdateSeatOffice(seatOffice, serviceContext);
//			sb.append("draft");
//			log.info("The redirect url is :"+sb.toString());
//		}
		if(cmd.equals(Constants.PUBLISH)) {
			String transitionName = "resubmit";
			long companyId = serviceContext.getCompanyId();
			WorkflowInstanceLink w = WorkflowInstanceLinkLocalServiceUtil.fetchWorkflowInstanceLink(companyId, seatOffice.getGroupId(), SeatOffice.class.getName(), seatOfficeId);
			if(w!=null) {
				WorkflowInstanceLinkLocalServiceUtil.deleteWorkflowInstanceLink(w);									
			}	
			seatOffice = SeatOfficeLocalServiceUtil.submitSeatOffice(seatOffice, serviceContext);
			String operationUser = themeDisplay.getUser().getFirstName()+" "+themeDisplay.getUser().getLastName();
			SeatOfficeLocalServiceUtil.saveOrUpdateAuditTrailLog(serviceContext.getCompanyId(), serviceContext.getScopeGroupId(),  seatOfficeId,userid, operationUser, ActionConstants.SUBMIT, "");
			sb.append("pending");
		//	log.info("The redirect url is :"+sb.toString());
		}else {
			seatOffice = SeatOfficeLocalServiceUtil.saveOrUpdateSeatOffice(seatOffice, serviceContext);
			sb.append("draft");
		//	log.info("The redirect url is :"+sb.toString());
		}
		response.sendRedirect(sb.toString());
	}
	
	
	@Override
	public void processAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		try {			
			String cmd= ParamUtil.getString(actionRequest,Constants.CMD);
		 if(!"applicantAgent".equals(cmd)){
			String mvcPath = ParamUtil.getString(actionRequest, "mvcPath");
			if(WorkSpaceConstants.SELECT_WORKSPACE_PATH.equals(mvcPath)) {
				String eventName = ParamUtil.getString(actionRequest, "eventName");
				String floor =ParamUtil.getString(actionRequest,"floor");
				String officeSite =ParamUtil.getString(actionRequest,"officeSite");
				String seatStatus =ParamUtil.getString(actionRequest,"seatStatus");
				String seatNo =ParamUtil.getString(actionRequest,"seatNo"); 
				actionResponse.setRenderParameter("floor", floor);
				actionResponse.setRenderParameter("officeSite", officeSite);
				actionResponse.setRenderParameter("seatStatus", seatStatus);
				actionResponse.setRenderParameter("seatNo", seatNo);
				actionResponse.setRenderParameter("eventName", eventName);
				actionResponse.setRenderParameter("mvcPath", WorkSpaceConstants.SELECT_WORKSPACE_PATH);
				log.info("Forward to :"+WorkSpaceConstants.SELECT_WORKSPACE_PATH);
			}
			
			else {
			//	System.out.println("------2------");
				this.addSeatOffice(actionRequest, actionResponse);				
			}
		 }
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.processAction(actionRequest, actionResponse);
	}
	//Get the applicant agent staffcode
		public void applicantAgent(ActionRequest actionRequest,
				ActionResponse actionResponse) throws IOException, PortletException, SystemException {
			boolean isApplicantAgent = ParamUtil.getBoolean(actionRequest, "isApplicantAgent",false);
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			User user  = themeDisplay.getUser();
			long staffCode = user.getFacebookId();
			if(isApplicantAgent) {
				ApplicantDelegation applicantDelegation = ApplicantDelegationLocalServiceUtil.fetchByP_S(ApproverDelegationLocalServiceUtil.getProcessOfSeatOffice(), String.valueOf(staffCode));
				staffCode = UserLocalServiceUtil.fetchUserById(applicantDelegation.getUserId()).getFacebookId();
			}		
			long seatOfficeId = ParamUtil.getLong(actionRequest, "seatOfficeId");
			actionResponse.setRenderParameter("staffCode", String.valueOf(staffCode));
			actionResponse.setRenderParameter("isApplicantAgent", String.valueOf(isApplicantAgent));
			actionResponse.setRenderParameter("seatOfficeId", String.valueOf(seatOfficeId));
			actionResponse.setRenderParameter("isClickAgent", "Yes");
		}
}
