
<%@page import="com.business.trip.util.JspUtil"%>
<%
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
%>

<%@include file="/html/init.jsp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	long token=System.currentTimeMillis();  
	portletSession.setAttribute("token",token);

	BusinessTripReimbursement businessTripReimbursement = null;
	long businessTripReimbursementId = ParamUtil.getLong(request, "businessTripReimbursementId");
	String transitionName = ParamUtil.getString(renderRequest, "transitionName", "");
	String tabsTohereDiv= ParamUtil.get(request, "tabs2","");
	String tabs2 = ParamUtil.get(request, "tabs2", "flight");
	if(renderRequest.getAttribute("tabs2")!=null){
		tabs2 = (String)renderRequest.getAttribute("tabs2");
	}
	String tripType = PropsUtil.get("vgc.apon.business.trip.reimbursement.type");
	String tripType2 = PropsUtil.get("vgc.apon.business.trip.application.type");
	boolean isNew = true;

	long sCode = themeDisplay.getUser().getFacebookId();
	Date now = new Date();
	ApplicantDelegation applicantDelegation = ApplicantDelegationLocalServiceUtil.fetchByP_S(ApproverDelegationLocalServiceUtil.getProcessOfBusinessTripReimbursement(),String.valueOf(sCode));
	boolean isHasAppliantAgent = applicantDelegation!=null && now.after(applicantDelegation.getEffectiveStartDate()) && now.before(applicantDelegation.getEffectiveEndDate())?true:false;
	String agentName = applicantDelegation!=null?ApplicantDelegationLocalServiceUtil.getAgentName(applicantDelegation):"";
	
	String prefixUrl = "/web"+themeDisplay.getScopeGroup().getFriendlyURL();	 
	String myApplicationsPageUrl = prefixUrl+PropsUtil.get("vgc.apon.my.applications.page.friendly.url");
	long myApplicationsPlid = PortalUtil.getPlidFromFriendlyURL(
	themeDisplay.getCompanyId(),myApplicationsPageUrl);
	
	if (businessTripReimbursementId > 0) {
		businessTripReimbursement = BusinessTripReimbursementLocalServiceUtil.fetchBusinessTripReimbursement(businessTripReimbursementId);
		if(businessTripReimbursement!=null) {
			isNew = false;
		}
		businessTripReimbursement = businessTripReimbursement!=null?businessTripReimbursement:BusinessTripReimbursementLocalServiceUtil.createBusinessTripReimbursement(businessTripReimbursementId);
	}else {
		businessTripReimbursementId = CounterLocalServiceUtil.increment(BusinessTripApplication.class.getName(),1);
		businessTripReimbursement = BusinessTripReimbursementLocalServiceUtil.createBusinessTripReimbursement(businessTripReimbursementId);
	}
	
	String businessTripApplicationPageUrl="";
	
	String cmd2 = ParamUtil.get(request, "cmd2", "");
	double totalCostRmb = ParamUtil.getDouble(request, "totalCostRmb",0d);
	double totalCostEur = ParamUtil.getDouble(request, "totalCostEur",0d);
	double hotelTotalCostRmb = ParamUtil.getDouble(request, "hotelTotalCostRmb",0d);
	double hotelTotalCostEur = ParamUtil.getDouble(request, "hotelTotalCostEur",0d);
	double carRentalTotalCostRmb = ParamUtil.getDouble(request, "carRentalTotalCostRmb",0d);
	double carRentalTotalCostEur = ParamUtil.getDouble(request, "carRentalTotalCostEur",0d);
	//wang hai 
	double totalTravelExpenseRmb= ParamUtil.getDouble(request,"totalTravelExpenseRmb",0d);
	double totalTravelExpenseEur= ParamUtil.getDouble(request,"totalTravelExpenseEur",0d);
	//end 

	//test
	double costListInlandTotalRmb = ParamUtil.getDouble(request, "costListInlandTotalRmb",0d);
	double costListForeignTotalEur = ParamUtil.getDouble(request, "costListForeignTotalEur",0d);
	double costListForeignTotalRmb = ParamUtil.getDouble(request, "costListForeignTotalRmb",0d);
	
	String flightCurrency = ParamUtil.getString(request, "flightCurrency");
	double flightTotal = ParamUtil.getDouble(request, "flightTotal",0d);
	double flightTransactionFee = ParamUtil.getDouble(request, "flightTransactionFee",0d);
	double flightAirFare = ParamUtil.getDouble(request, "flightAirFare",0d);
	double flightTaxes = ParamUtil.getDouble(request, "flightTaxes",0d);
	String error=(String)request.getAttribute("errorMessage");
	if(error!=null&&!error.equals("")){
		String infoerror="<script>alert("+"\""+error+"\""+")</script>";
		out.print(infoerror);
	}
	BusinessTripApplication businessTripApplication=(BusinessTripApplication)renderRequest.getAttribute("businessTripApplication");
	if(businessTripApplication!=null&&businessTripReimbursement!=null){
		businessTripReimbursement=JspUtil.include(businessTripReimbursement, businessTripApplication,totalTravelExpenseRmb,totalTravelExpenseEur,costListInlandTotalRmb,costListForeignTotalEur,costListForeignTotalRmb);
		
		if(cmd2==null||cmd2.equals("")){
			BtFlightTrainInfoLocalServiceUtil.deleteBtFlightTrainInfoByB_T(businessTripReimbursementId, tripType);
			BtFlightTrainInfoLocalServiceUtil.copyBtFlightTrainInfoByB_T(businessTripApplication.getBusinessTripApplicationId(), businessTripReimbursementId, tripType2, tripType);
			
			BtTrainInfoLocalServiceUtil.deleteBtTrainInfoByB_T(businessTripReimbursementId, tripType);
			BtTrainInfoLocalServiceUtil.copyBtTrainInfoByB_T(businessTripApplication.getBusinessTripApplicationId(), businessTripReimbursementId, tripType2, tripType);
			
			BtHotelInfoLocalServiceUtil.deleteBtHotelInfoByB_T(businessTripReimbursementId, tripType);
			BtHotelInfoLocalServiceUtil.copyBtHotelInfoByB_T(businessTripApplication.getBusinessTripApplicationId(), businessTripReimbursementId, tripType2, tripType);
			
			BtCarRentalInfoLocalServiceUtil.deleteBtFlightTrainInfoByB_T(businessTripReimbursementId, tripType);
			BtCarRentalInfoLocalServiceUtil.copyBtCarRentalInfoByB_T(businessTripApplication.getBusinessTripApplicationId(), businessTripReimbursementId, tripType2, tripType);	
		}else{
			businessTripReimbursement.setTotalCostRmb(totalCostRmb);
			businessTripReimbursement.setTotalCostEur(totalCostEur);
			businessTripReimbursement.setHotelTotalCostRmb(hotelTotalCostRmb);
			businessTripReimbursement.setHotelTotalCostEur(hotelTotalCostEur);
			businessTripReimbursement.setCarRentalTotalCostRmb(carRentalTotalCostRmb);
			businessTripReimbursement.setCarRentalTotalCostEur(carRentalTotalCostEur);	
			
			businessTripReimbursement.setFlightTotal(flightTotal);
			businessTripReimbursement.setFlightAirFare(flightAirFare);
			businessTripReimbursement.setFlightCurrency(flightCurrency);
			businessTripReimbursement.setFlightTaxes(flightTaxes);
			businessTripReimbursement.setFlightTransactionFee(flightTransactionFee);
		}
	
		String url = themeDisplay.getURLPortal();
		url = url.indexOf("9080") != -1 || url.indexOf("8080") != -1 ? "" : url.substring(url.lastIndexOf('/'));
		
		businessTripApplicationPageUrl=url+"/web/vcic/my-applications?p_p_id=mysubmissionslist_WAR_vgcaponmysubmissionsportlet"+
	"&_mysubmissionslist_WAR_vgcaponmysubmissionsportlet_tabs2=completed"+
	"&_mysubmissionslist_WAR_vgcaponmysubmissionsportlet_pkId="+businessTripApplication.getBusinessTripApplicationId()+
	"&_mysubmissionslist_WAR_vgcaponmysubmissionsportlet_operationType=ReimbursementToViewApplication"+
	"&_mysubmissionslist_WAR_vgcaponmysubmissionsportlet_mvcPath=/html/mysubmissionslist/details/business_trip_application_details.jsp";
	}
	
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("businessTripReimbursementId", String.valueOf(businessTripReimbursementId));
	portletURL.setParameter("bussinessTirpTicketNo2", businessTripReimbursement.getBussinessTirpTicketNo()!=null?String.valueOf(businessTripReimbursement.getBussinessTirpTicketNo()):"");
	String imageQueryPath = themeDisplay.getPathThemeImages()+"/diff/vgc_apon_my_applications_details.png";
	List<AuditTrailLog> auditTrailLogs = AuditTrailLogLocalServiceUtil.findAuditTrailByWF_O_O(businessTripReimbursementId, BusinessTripReimbursement.class.getName());
	List<FileManagement> fileManagements = FileManagementLocalServiceUtil.getByAssetClassNameAndAssetPrimaryKey(BusinessTripReimbursement.class.getName(),businessTripReimbursementId);
	String supportFileType = PropsUtil.get("vgc.apon.support.upload.file.type");
	String supportFileSize = PropsUtil.get("vgc.apon.support.upload.file.size");
	String addPagePath = "/html/businessTripReimbursement/flightTrainInformationAdd.jsp";
	String selectedTabPage = "vgc-apon-business-trip-reimbursement-flight-information-final";
	if("train".equals(tabs2)) {
		addPagePath = "/html/businessTripReimbursement/trainInformationAdd.jsp";
		selectedTabPage = "vgc-apon-business-trip-reimbursement-train-information-final";
	}else if("hotelInformation".equals(tabs2)) {
		addPagePath = "/html/businessTripReimbursement/hotelInformationAdd.jsp";
		selectedTabPage = "vgc-apon-business-trip-reimbursement-hotel-information-final";
	}else if("carRental".equals(tabs2)) {
		addPagePath = "/html/businessTripReimbursement/carRentalAdd.jsp";
		selectedTabPage = "vgc-apon-business-trip-reimbursement-car-rental-final";
	}else if("travelExpense".equals(tabs2)) {
		addPagePath = "/html/businessTripReimbursement/travelExpenseAdd.jsp";
		selectedTabPage = "vgc-apon-business-trip-reimbursement-travel-expense";
	}else if("costList".equals(tabs2)) {
		addPagePath = "/html/businessTripReimbursement/costListAdd.jsp";
		selectedTabPage = "vgc-apon-business-trip-reimbursement-cost-list";
	}
	String trashImage=themeDisplay.getPathThemeImages()+"/common/trash.png";
	String checkImagePath = themeDisplay.getPathThemeImages()+"/common/check.png";
	String searchImagePath=themeDisplay.getPathThemeImages()+"/common/search.png";
	
	String importFileType = PropsUtil.get("vgc.apon.support.import.pdf.file.type");
	String importError = ParamUtil.getString(request, "importError","");	
	
	boolean tempIsAppliantAgent = ParamUtil.getBoolean(request, "isApplicantAgent",false);
	String tempApproverId = ParamUtil.getString(request, "tempApproverId","");
	String tempApproverName = ParamUtil.getString(request, "tempApproverName","");
	String tempIsGetRMBStr = ParamUtil.getString(request, "tempIsGetRMB");
	Boolean tempIsGetRMB = null;
	if(tempIsGetRMBStr==null || "".equals(tempIsGetRMBStr)){
		tempIsGetRMB = businessTripReimbursement.getIsPaybyRmb();
	}else{
		tempIsGetRMB = Boolean.valueOf(tempIsGetRMBStr);
	}
%>

<portlet:actionURL var="addBusinessTripReimbursementURL" windowState="normal">
	<portlet:param name="isRedirect" value="Yes"/>
</portlet:actionURL>

<portlet:actionURL name="deleteDetailInfo" var="deleteDetailInfoURL">
	<portlet:param name="bussinessTirpTicketNo2"
		value="<%=businessTripReimbursement!=null&&businessTripReimbursement.getBussinessTirpTicketNo()!=null?String.valueOf(businessTripReimbursement.getBussinessTirpTicketNo()):\"\"%>" />
	<portlet:param name="businessTripReimbursementId"
		value="<%=String.valueOf(businessTripReimbursementId)%>" />
</portlet:actionURL>

<%-- <liferay-portlet:renderURL var="openBusinessTripApplicationURL"
	windowState="normal" plid="<%=myApplicationsPlid%>"
	portletName="mysubmissionslist_WAR_vgcaponmysubmissionsportlet">
	<liferay-portlet:param name="mvcPath"
		value="/html/mysubmissionslist/details/business_trip_application_details.jsp" />
	<liferay-portlet:param name="pkId"
		value='<%=businessTripApplication!=null?String.valueOf(businessTripApplication.getBusinessTripApplicationId()):"0"%>' />
	<liferay-portlet:param name="tabs2" value="completed" />
</liferay-portlet:renderURL> --%>

<!-- Delete One BtFlightTrainInfo -->
<aui:form method="post" name="deleteDetailInfoForm"
	action="<%=deleteDetailInfoURL%>">
	<aui:input type="hidden" name="pkId" />
	<aui:input type="hidden" name="tabs2" value="<%=tabs2%>" />

	<aui:input type="hidden" name="cmd2" value="delete" />
	<aui:input type="hidden" name="totalCostRmb"
		value='<%=businessTripReimbursement.getTotalCostRmb()%>' />
	<aui:input type="hidden" name="totalCostEur"
		value='<%=businessTripReimbursement.getTotalCostEur()%>' />
	<aui:input type="hidden" name="hotelTotalCostRmb"
		value='<%=businessTripReimbursement.getHotelTotalCostRmb()%>' />
	<aui:input type="hidden" name="hotelTotalCostEur"
		value='<%=businessTripReimbursement.getHotelTotalCostEur()%>' />
	<aui:input type="hidden" name="carRentalTotalCostRmb"
		value='<%=businessTripReimbursement.getCarRentalTotalCostRmb()%>' />
	<aui:input type="hidden" name="carRentalTotalCostEur"
		value='<%=businessTripReimbursement.getCarRentalTotalCostEur()%>' />

	<aui:input type="hidden" name="totalTravelExpenseRmb"
		value='<%=businessTripReimbursement.getTotalTravelExpenseRmb()%>' />
	<aui:input type="hidden" name="totalTravelExpenseEur"
		value='<%=businessTripReimbursement.getTotalTravelExpenseEur()%>' />

	<aui:input type="hidden" name="costListInlandTotalRmb"
		value='<%=businessTripReimbursement.getCostListInlandTotalRmb()%>' />
	<aui:input type="hidden" name="costListForeignTotalEur"
		value='<%=businessTripReimbursement.getCostListForeignTotalEur()%>' />
	<aui:input type="hidden" name="costListForeignTotalRmb"
		value='<%=businessTripReimbursement.getCostListForeignTotalRmb()%>' />

	<aui:input type="hidden" name="flightTotal"
		value='<%=businessTripReimbursement.getFlightTotal()%>' />
	<aui:input type="hidden" name="flightAirFare"
		value='<%=businessTripReimbursement.getFlightAirFare()%>' />
	<aui:input type="hidden" name="flightCurrency"
		value='<%=businessTripReimbursement.getFlightCurrency()%>' />
	<aui:input type="hidden" name="flightTaxes"
		value='<%=businessTripReimbursement.getFlightTaxes()%>' />
	<aui:input type="hidden" name="flightTransactionFee"
		value='<%=businessTripReimbursement.getFlightTransactionFee()%>' />
	<aui:input type="hidden" name="token" value='<%=token%>' />	
	
	<input type="hidden" name="<portlet:namespace/>isApplicantAgent"
		value='<%=businessTripReimbursement.getIsApplicantAgent()||tempIsAppliantAgent?"true":"false"%>' />
		
	<input type="hidden" name="<portlet:namespace/>tempApproverId"
		value='<%="".equals(tempApproverId)?businessTripReimbursement.getApproverId():tempApproverId%>' />
	<input type="hidden" name="<portlet:namespace/>tempApproverName"
		value='<%="".equals(tempApproverName)?businessTripReimbursement.getApproverName():tempApproverName%>' />
	<input type="hidden" name="<portlet:namespace/>tempIsGetRMB"
		value='<%=tempIsGetRMB %>' />
		
</aui:form>

<portlet:actionURL var="importFlightURL" 
	windowState="normal" >
	<portlet:param name="isImport" value="Yes"/>
	</portlet:actionURL>

<aui:form action="<%=importFlightURL%>" method="post"
	enctype="multipart/form-data" name="importFm">
	<aui:input type="hidden" name="bussinessTirpTicketNo2"
		value="<%=businessTripReimbursement!=null&&businessTripReimbursement.getBussinessTirpTicketNo()!=null?String.valueOf(businessTripReimbursement.getBussinessTirpTicketNo()):\"\"%>" />
	<aui:input type="hidden" name="businessTripReimbursementId"
		value="<%=String.valueOf(businessTripReimbursementId)%>" />
	<aui:input type="hidden" name="tabs2" value="<%=tabs2%>" />
	<aui:input type="hidden" name="cmd2" value="upload" />
	<aui:input type="hidden" name="tripCategory" value="<%=businessTripApplication==null?0:businessTripApplication.getTripType() %>" />
	<aui:input type="hidden" name="totalCostRmb"
		value='<%=businessTripReimbursement.getTotalCostRmb()%>' />
	<aui:input type="hidden" name="totalCostEur"
		value='<%=businessTripReimbursement.getTotalCostEur()%>' />
	<aui:input type="hidden" name="hotelTotalCostRmb"
		value='<%=businessTripReimbursement.getHotelTotalCostRmb()%>' />
	<aui:input type="hidden" name="hotelTotalCostEur"
		value='<%=businessTripReimbursement.getHotelTotalCostEur()%>' />
	<aui:input type="hidden" name="carRentalTotalCostRmb"
		value='<%=businessTripReimbursement.getCarRentalTotalCostRmb()%>' />
	<aui:input type="hidden" name="carRentalTotalCostEur"
		value='<%=businessTripReimbursement.getCarRentalTotalCostEur()%>' />

	<aui:input type="hidden" name="totalTravelExpenseRmb"
		value='<%=businessTripReimbursement.getTotalTravelExpenseRmb()%>' />
	<aui:input type="hidden" name="totalTravelExpenseEur"
		value='<%=businessTripReimbursement.getTotalTravelExpenseEur()%>' />

	<aui:input type="hidden" name="costListInlandTotalRmb"
		value='<%=businessTripReimbursement.getCostListInlandTotalRmb()%>' />
	<aui:input type="hidden" name="costListForeignTotalEur"
		value='<%=businessTripReimbursement.getCostListForeignTotalEur()%>' />
	<aui:input type="hidden" name="costListForeignTotalRmb"
		value='<%=businessTripReimbursement.getCostListForeignTotalRmb()%>' />
	<aui:input type="hidden" name="token" value='<%=token%>' />	
	<input type="file" style="display: none" id="pdfImport"
		name="<portlet:namespace/>pdfImport" onchange="importPdf();" />
		
		<input type="hidden" name="<portlet:namespace/>isApplicantAgent"
		value='<%=businessTripReimbursement.getIsApplicantAgent()||tempIsAppliantAgent?"true":"false"%>' />
		
	<input type="hidden" name="<portlet:namespace/>tempApproverId"
		value='<%="".equals(tempApproverId)?businessTripReimbursement.getApproverId():tempApproverId%>' />
	<input type="hidden" name="<portlet:namespace/>tempApproverName"
		value='<%="".equals(tempApproverName)?businessTripReimbursement.getApproverName():tempApproverName%>' />
	<input type="hidden" name="<portlet:namespace/>tempIsGetRMB"
		value='<%=tempIsGetRMB%>' />	
</aui:form>

<%-- <portlet:resourceURL var="downloadURL"></portlet:resourceURL> --%>

<liferay-portlet:renderURL var="myApplicationsURL"
	plid="<%=myApplicationsPlid%>"
	portletName='<%=PropsUtil.get("vgc.apon.my.applications.portletId")%>'
	windowState="normal">
</liferay-portlet:renderURL>

<aui:model-context bean="<%=businessTripReimbursement%>"
	model="<%=BusinessTripReimbursement.class%>" />

<!--  First company car applicant page -->
<aui:form name="fm" method="POST"
	action="<%=addBusinessTripReimbursementURL%>"
	enctype="multipart/form-data">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="<%=redirect%>" />
		<aui:input name="<%=Constants.CMD%>" type="hidden" />
		<aui:input type="hidden" name="businessTripReimbursementId"
			value='<%=businessTripReimbursementId%>' />
		<aui:input type="hidden" name="transitionName"
			value='<%=transitionName%>' />
		<aui:input type="hidden" name="existTitles" />
		<aui:input type="hidden" name="newTitles" />
		<aui:input type="hidden" name="existFileIds" />

		<aui:input type="hidden" name="totalCostRmb"
			value='<%=businessTripReimbursement.getTotalCostRmb()%>' />
		<aui:input type="hidden" name="totalCostEur"
			value='<%=businessTripReimbursement.getTotalCostEur()%>' />
		<aui:input type="hidden" name="hotelTotalCostRmb"
			value='<%=businessTripReimbursement.getHotelTotalCostRmb()%>' />
		<aui:input type="hidden" name="hotelTotalCostEur"
			value='<%=businessTripReimbursement.getHotelTotalCostEur()%>' />
		<aui:input type="hidden" name="carRentalTotalCostRmb"
			value='<%=businessTripReimbursement.getCarRentalTotalCostRmb()%>' />
		<aui:input type="hidden" name="carRentalTotalCostEur"
			value='<%=businessTripReimbursement.getCarRentalTotalCostEur()%>' />
		<aui:input type="hidden" name="totalTravelExpenseRmb"
			value='<%=businessTripReimbursement.getTotalTravelExpenseRmb()%>' />
		<aui:input type="hidden" name="totalTravelExpenseEur"
			value='<%=businessTripReimbursement.getTotalTravelExpenseEur()%>' />

		<aui:input type="hidden" name="costListInlandTotalRmb"
			value='<%=businessTripReimbursement.getCostListInlandTotalRmb()%>' />
		<aui:input type="hidden" name="costListForeignTotalEur"
			value='<%=businessTripReimbursement.getCostListForeignTotalEur()%>' />
		<aui:input type="hidden" name="costListForeignTotalRmb"
			value='<%=businessTripReimbursement.getCostListForeignTotalRmb()%>' />

		<aui:input type="hidden" name="flightTotal"
			value='<%=businessTripReimbursement.getFlightTotal()%>' />
		<aui:input type="hidden" name="flightAirFare"
			value='<%=businessTripReimbursement.getFlightAirFare()%>' />
		<aui:input type="hidden" name="flightCurrency"
			value='<%=businessTripReimbursement.getFlightCurrency()%>' />
		<aui:input type="hidden" name="flightTaxes"
			value='<%=businessTripReimbursement.getFlightTaxes()%>' />
		<aui:input type="hidden" name="flightTransactionFee"
			value='<%=businessTripReimbursement.getFlightTransactionFee()%>' />
			<aui:input type="hidden" name="token" value='<%=token%>' />	
	</aui:fieldset>

	<div class="mainbody">
		<div class="topButton">
			<aui:button-row>
				<aui:button type="button" value="vgc.apon.button.save.as.draft"
					onClick='<%= renderResponse.getNamespace() + "saveBusinessTripReimbursement()" %>' />
				<aui:button type="button" value="vgc.apon.button.submit"
					onClick='<%= renderResponse.getNamespace() + "submitBusinessTripReimbursement()" %>' />
				<aui:button type="cancel" value="vgc.apon.button.back"
					onClick='<%= myApplicationsURL %>' />
			</aui:button-row>
		</div>
		<div class="tabTitle">
			<h3>
				<liferay-ui:message key="vgc-apon-business-trip-reimbursement" />
			</h3>
			<div class="Ltext"></div>
			<div class="tickerNo">
				<liferay-ui:message
					key="vgc-apon-business-trip-application-ticket-no" />
				<span class="num"><%=businessTripReimbursement.getTicketNo()%></span>
			</div>
			<div class="clear"></div>
		</div>
		<div style="height: 40px; padding-bottom: 2%;">
			<div class="subtitle"
				style="height: 100%; top: 10px; padding-bottom: 0.1%; padding-top: 0.5%;">
				<liferay-ui:message
					key="vgc-apon-business-trip-reimbursement-bussiness-tirp-ticket-no" />
				<input type="text" id="bussinessTirpTicketNo"
					name="<portlet:namespace/>bussinessTirpTicketNo" readonly="readonly"
					value="<%=businessTripReimbursement.getBussinessTirpTicketNo()%>"
					style="height: 60%; width: 20%;" required="required" maxlength="75">
					<liferay-ui:icon
					id="searchBussinessTirpTicketNo"
					label="<%= true %>"
					message=""
					method="get"
					url="javascript:;"
					src="<%= searchImagePath%>"
				/>
			</div>
		</div>
		<div class="gernal employeeInfo">
			<div class="subtitle">
				<liferay-ui:message
					key="vgc-apon-business-trip-application-personal-information" />
				<%
					if(isHasAppliantAgent) {
				%>
				<input type="checkbox" name="<portlet:namespace/>isApplicantAgent"
					value='<%=true%>' onclick="changeApplicantAgent(this);"
					<%=businessTripReimbursement.getIsApplicantAgent()||tempIsAppliantAgent?"checked='checked'":""%> />
				<liferay-ui:message key="vgc-apon-on-behalf-of-x"
					arguments="<%=agentName%>" />
				<%
					}
				%>
			</div>
			<ul>
				<li class="md01"><liferay-ui:message
						key="vgc-apon-business-trip-application-print-name" /></li>
				<li class="md02"><input type="text"
					name="<portlet:namespace/>printName" readonly="readonly"
					maxlength="75"
					value="<%=businessTripReimbursement.getPrintName()%>"></li>
				<li class="md01"><liferay-ui:message
						key="vgc-apon-business-trip-application-staff-code" /></li>
				<li class="md022"><input id="<portlet:namespace />staffCode"
					type="text" name="<portlet:namespace/>staffCode"
					readonly="readonly" maxlength="75"
					value="<%=businessTripReimbursement.getStaffCode()%>" /></li>
			</ul>
			<ul>
				<li class="md01"><liferay-ui:message
						key="vgc-apon-business-trip-application-company" /></li>
				<li class="md02"><input type="text"
					name="<portlet:namespace/>companyName" maxlength="75"
					value='<%=businessTripReimbursement.getCompanyName()%>'
					readonly="readonly"></li>
				<li class="md01"><liferay-ui:message
						key="vgc-apon-business-trip-application-division" /></li>
				<li class="md022"><input type="text"
					name="<portlet:namespace/>division" readonly="readonly"
					maxlength="75" value="<%=businessTripReimbursement.getDivision()%>"></li>
			</ul>
			<ul>
				<li class="md01"><liferay-ui:message
						key="vgc-apon-business-trip-application-department" /></li>
				<li class="md02"><input type="text"
					name="<portlet:namespace/>department" readonly="readonly"
					maxlength="75"
					value="<%=businessTripReimbursement.getDepartment()%>"></li>
				<li class="md01"><liferay-ui:message
						key="vgc-apon-business-trip-application-cost-center" /></li>
				<li class="md022"><input type="text" maxlength="75"
					name="<portlet:namespace/>positionCostCenterId" readonly="readonly"
					value="<%=businessTripReimbursement.getCostCenter()%>"></li>
			</ul>
			<ul>
				<li class="md01"><liferay-ui:message
						key="vgc-apon-business-trip-application-personal-id" /></li>
				<li class="md02"><input type="text" maxlength="75"
					name="<portlet:namespace/>personalID" readonly="readonly"
					value="<%=businessTripReimbursement.getPersonalID()%>" /></li>
				<li class="md01"><liferay-ui:message
						key="vgc-apon-business-trip-application-passport-no" /></li>
				<li class="md022"><input type="text" maxlength="75"
					name="<portlet:namespace/>passportNo" readonly="readonly"
					value="<%=businessTripReimbursement.getPassportNo()%>" /></li>
			</ul>
			<ul>
				<li class="md01"><liferay-ui:message
						key="vgc-apon-business-trip-application-office-phone" /></li>
				<li class="md02"><input type="text" maxlength="75"
					name="<portlet:namespace/>officePhone" readonly="readonly"
					value="<%=businessTripReimbursement.getOfficePhone()%>" /></li>
				<li class="md01"><liferay-ui:message
						key="vgc-apon-business-trip-application-mobile-phone" /></li>
				<li class="md022"><input type="text" maxlength="75"
					name="<portlet:namespace/>mobilePhone" readonly="readonly"
					value="<%=businessTripReimbursement.getMobilePhone()%>" /></li>
			</ul>
			<ul>
				<li class="md01"><liferay-ui:message
						key="vgc-apon-business-trip-application-email" /></li>
				<li class="md02"><input type="text" maxlength="75"
					name="<portlet:namespace/>email" readonly="readonly"
					value="<%=businessTripReimbursement.getEmail()%>" /></li>
				<li class="md01"><liferay-ui:message
						key="vgc-apon-business-trip-application-office-site" /></li>
				<li class="md022"><input type="text" maxlength="75"
					name="<portlet:namespace/>officeSite" readonly="readonly"
					value="<%=businessTripReimbursement.getOfficeSite()%>" /></li>
			</ul>
			<ul>
				<li class="md01"><liferay-ui:message
						key="vgc-apon-business-trip-application-approver" /></li>
				<li class="md02"><input type="text" maxlength="75"
					name="<portlet:namespace/>approverName" readonly="readonly"
					 id="approverName"
					value="<%="".equals(tempApproverName)?businessTripReimbursement.getApproverName():tempApproverName%>" />
					
						<input type="hidden" maxlength="75"
							name="<portlet:namespace/>approverId" id="approverId"
							value="<%="".equals(tempApproverId)?businessTripReimbursement.getApproverId():tempApproverId%>"/>
					</li>
				<li class="md01"><liferay-ui:message
						key="vgc-apon-business-trip-application-cross-department" /></li>
				<li class="md022"><input type="checkbox" id="crossDepartment"
					name="<portlet:namespace/>isCrossDepartment" value='<%=true%>'
					<%=businessTripReimbursement.getIsCrossDepartment()?"checked='checked'":""%>
					disabled="disabled" /></li>
			</ul>
			<ul style='display: <%=businessTripReimbursement.getIsCrossDepartment()?"block":"none" %>'>
				<li class="md01"><liferay-ui:message
						key="vgc-apon-business-trip-application-target-department" /></li>
				<li class="md02"><input type="text" maxlength="75"
					name="<portlet:namespace/>targetDepartmentName"
					value="<%=businessTripReimbursement.getTargetDepartmentName()%>"
					readonly="readonly" /></li>
				<li class="md01"><liferay-ui:message
						key="vgc-apon-business-trip-application-target-cost-center" /></li>
				<li class="md022"><input type="text" maxlength="75"
					name="<portlet:namespace/>targetCostCenter" readonly="readonly"
					value="<%=businessTripReimbursement.getTargetCostCenter()%>" /></li>
			</ul>
			<ul style='display: <%=businessTripReimbursement.getIsCrossDepartment()?"block":"none" %>'>
				<li class="md01"><liferay-ui:message
						key="vgc-apon-business-trip-application-target-department-approver" /></li>
				<li class="md02"><input type="text" maxlength="75"
					name="<portlet:namespace/>targetDepartmentApproverName"
					readonly="readonly"
					value="<%=businessTripReimbursement.getTargetDepartmentApproverName()%>" />
				</li>
			</ul>
		</div>
		<div class="gernal carInfo">
			<div class="subtitle">
				<liferay-ui:message
					key="vgc-apon-business-trip-application-travel-reservation" />
				<input type="radio" name="<portlet:namespace/>tripType" value='0'
					<%=businessTripReimbursement.getTripType()==0?"checked='checked'":""%>
					disabled="disabled" />
				<liferay-ui:message
					key="vgc-apon-business-trip-application-domestic-trip" />
				<input type="radio" name="<portlet:namespace/>tripType" value='1'
					<%=businessTripReimbursement.getTripType()==1?"checked='checked'":""%>
					disabled="disabled" />
				<liferay-ui:message
					key="vgc-apon-business-trip-application-international-trip" />
			</div>
				<%
				   if(businessTripReimbursement.getTripType()==1 && "RMB".equals(businessTripReimbursement.getCurrency())){
				%>	
						<p style="padding-left:10px;padding-top: 30px;font-style:italic; color: red;"><liferay-ui:message key="vgc-apon-business-trip-reimbursement-is-paiedbyRmb-notes" /></p>
				 <%
				   }
				 %>
			<ul>
				<li class="md01"><liferay-ui:message
						key="vgc-apon-business-trip-application-departure-date" /></li>
				<li class="md02"><input id="d4311" type="text"
					name="<portlet:namespace/>departureDate"
					value="<%=businessTripReimbursement.getDepartureDate()==null?"":sdf_dmy.format(businessTripReimbursement.getDepartureDate())%>"
					readonly="readonly" /></li>
				<li class="md01"><liferay-ui:message
						key="vgc-apon-business-trip-application-return-date" /></li>
				<li class="md022"><input id="d4312" type="text"
					name="<portlet:namespace/>returnDate"
					value="<%=businessTripReimbursement.getReturnDate()==null?"":sdf_dmy.format(businessTripReimbursement.getReturnDate())%>"
					readonly="readonly" /></li>
			</ul>
			<ul>
				<li class="md01"><liferay-ui:message
						key="vgc-apon-business-trip-application-purpose-of-the-trip"></liferay-ui:message></li>
				<li class="md03"><input type="text"
					name="<portlet:namespace/>purposeOfTheTrip"
					value="<%=businessTripReimbursement.getPurposeOfTheTrip()%>"
					maxlength="75" readonly="readonly" /></li>
			</ul>
			<ul>
				<li class="md01" style="width:165px;margin-right:11px;"><liferay-ui:message
						key="vgc-apon-business-trip-application-visit-countries-cities" /></li>
				<li class="md02"><input type="text"
					name="<portlet:namespace/>visitCountriesCities" maxlength="75"
					value="<%=businessTripReimbursement.getVisitCountriesCities()%>"
					readonly="readonly"></li>
				<%
				   if(businessTripReimbursement.getTripType()==1 && ("RMB".equals(businessTripReimbursement.getCurrency())||businessTripReimbursement.getAdvancePayment()==0)){
				%>	
					<li class="md01"><liferay-ui:message key="vgc-apon-business-trip-application-is-payed-byRMB" /></li>
					<li class="md022"><input type="checkbox" id="isPaybyRmb" name="<portlet:namespace/>isPaybyRmb" value='<%=true%>' onclick="changeGetRMB(this);"
						<%--  <%=tempIsGetRMB?"checked='checked'":""%> --%>  checked='checked'
					 />
					 <li style="padding-left:42px;font-style:italic;color: red;width:400px;margin-left: 660px;margin-top: -20px;">Note:VGIC can not reimburse EUR,VGIC employees must NOT change this option or the application will be rejected.<p></p></li>
					 </li>
				 <%
				   }
				 %>
					
			</ul>
		</div>
		<p style="padding-left:10px;"><liferay-ui:message key="vgc-apon-business-trip-reimbursement-remark"/></p>
		<%
			if(businessTripApplication!=null&&businessTripApplication.getStatus()==0){
		%>
		<a href="<%=businessTripApplicationPageUrl%>" target="_blank"> <liferay-ui:message
				key="vgc-apon-business-trip-reimbursement-view-business-trip-application" /></a><br />
		<br />
		<%
			}
		%>
		<input type="hidden" id="tohere" value="<%=tabsTohereDiv%>"/>
		<div id="toherediv"></div>
		<liferay-ui:tabs
			names="vgc-apon-business-trip-reimbursement-flight-information-final,vgc-apon-business-trip-reimbursement-train-information-final,vgc-apon-business-trip-reimbursement-hotel-information-final,vgc-apon-business-trip-reimbursement-car-rental-final,vgc-apon-business-trip-reimbursement-travel-expense,vgc-apon-business-trip-reimbursement-cost-list"
			refresh='<%=false%>' value='<%=selectedTabPage%>' type="tabs">
			<liferay-ui:section>
				<%@ include file="/html/businessTripReimbursement/flightTrainInformationView.jsp"%>
			</liferay-ui:section>
			<liferay-ui:section>
				<%@ include	file="/html/businessTripReimbursement/trainInformationView.jsp"%> 
			</liferay-ui:section>
			<liferay-ui:section>
				<%@ include file="/html/businessTripReimbursement/hotelInformationView.jsp"%>
			</liferay-ui:section>
			<liferay-ui:section>
				<%@ include file="/html/businessTripReimbursement/carRentalView.jsp"%>
			</liferay-ui:section>
			<liferay-ui:section>
				<%@ include file="/html/businessTripReimbursement/travelExpenseView.jsp"%>
			</liferay-ui:section>
			<liferay-ui:section>
				<%@ include file="/html/businessTripReimbursement/costListView.jsp"%>
			</liferay-ui:section>
		</liferay-ui:tabs>
		<p style="padding-left:10px;font-style:italic; color: red;"><liferay-ui:message key="vgc-apon-business-trip-reimbursement-hotel-remark"/></p>
		<%
		String advanceStyle="";
		if(businessTripApplication!=null){
			advanceStyle=businessTripApplication.getStatus()==-1||businessTripApplication.getAdvancePayment()<=0d ?"none":"block";
		}
		%>
		<div class="gernal carInfo" style="display:<%=advanceStyle%>">
			<div class="subtitle">
				<liferay-ui:message
					key="vgc-apon-business-trip-application-cash-advance" />
			</div>
			<ul>
				<li class="md01"><liferay-ui:message
						key="vgc-apon-business-trip-application-advance-payment" /></li>
				<li class="md02"><input type="text" maxlength="75"
					name="<portlet:namespace/>advancePayment"
					value="<%=String.format("%.2f",businessTripReimbursement.getAdvancePayment())%>"
					readonly="readonly" /></li>
				<li class="md01"><liferay-ui:message
						key="vgc-apon-business-trip-application-currency" /></li>
				<li class="md022"><select name="<portlet:namespace/>currency"
					disabled="disabled">
						<%
							String cur=businessTripReimbursement.getCurrency();
								        for(String label:new String[]{"RMB","EUR"}){
						%>
						<option value="<%=label%>"
							<%=cur.equals(label)?"selected='selected'":""%>><%=label%></option>
						<%
							}
						%>
				</select></li>
			</ul>
			<ul>
				<li class="md01"><liferay-ui:message
						key="vgc-apon-business-trip-application-payment-methods"></liferay-ui:message></li>
				<li class="md03">Bank Transfer</li>
			</ul>
			<ul id="hotelandcar">
				<li class="md01"><liferay-ui:message
						key="vgc-apon-business-trip-application-hotel-and-car-rental-total-cost"></liferay-ui:message></li>
				<li class="md03"><%=String.format("%.2f", businessTripReimbursement.getTotalCostRmb())%>&nbsp;RMB&nbsp;
					<%=String.format("%.2f",businessTripReimbursement.getTotalCostEur())%>&nbsp;EUR</li>
			</ul>
			<ul>
				<li class="md01"><liferay-ui:message
						key="vgc-apon-business-trip-application-hotel-cost"></liferay-ui:message></li>
				<li class="md03"><%=String.format("%.2f",businessTripReimbursement.getHotelTotalCostRmb())%>&nbsp;RMB&nbsp;
					<%=String.format("%.2f",businessTripReimbursement.getHotelTotalCostEur())%>&nbsp;EUR</li>
			</ul>
			<ul id="car">
				<li class="md01"><liferay-ui:message
						key="vgc-apon-business-trip-application-car-rental-cost"></liferay-ui:message></li>
				<li class="md03"><%=String.format("%.2f",businessTripReimbursement.getCarRentalTotalCostRmb())%>&nbsp;RMB&nbsp;
					<%=String.format("%.2f",businessTripReimbursement.getCarRentalTotalCostEur())%>&nbsp;EUR</li>
			</ul>
		</div>
		<!-- **************************************************************Upload the attachments start...******************************************************************************************* -->
		<div class="attachmentList">
			<div class="subtitle">Attachment list</div>
			<div class="gridtb">
				<ul>
					<li class="od01">Attachment Name</li>
					<li class="od02">File Name<font color="red">* (Attachment is mandatory)</font></li>
					<li class="od01">Upload Date</li>
					<li class="od01 lcol">Action</li>
				</ul>
				<div id="<portlet:namespace/>fileDiv0">
					<%
						for(FileManagement fileManagement:fileManagements) {
					%>
					<ul class="std0">
						<li class="od01"><input type="text"
							name="<portlet:namespace/>fileManagementFileName"
							value="<%=fileManagement.getTitle()%>" maxlength="75" /> <input
							type="hidden" name="<portlet:namespace/>fileManagementId"
							value="<%=fileManagement.getFileManagementId()%>" /></li>
						<li class="od02"><a href="#"
							onclick='<portlet:namespace />download("<%=fileManagement.getFileName()%>","<%=fileManagement.getFilePath()%>")'><%=fileManagement.getFileName()%></a></li>
						<li class="od01"><%=sdf.format(fileManagement.getCreateDate())%></li>
						<li class="od01 lcol upd"><a href="#"
							onclick="<portlet:namespace/>addFile()"><liferay-ui:message
									key="vgc.apon.company.car.upload" /></a>&nbsp; <a href="#"
							onclick="<portlet:namespace/>removeFile(parentNode.parentNode)"><liferay-ui:message
									key="vgc.apon.company.car.delete" /></a></li>
					</ul>
					<%
						}
					%>
				</div>
				<%
					String fileDivStyle =businessTripReimbursement.getTicketNo()==null||businessTripReimbursement.getTicketNo().equals("") ? "" : "style='margin-top: 1px;'";
				%>
				<div id="<portlet:namespace/>fileDiv" <%=fileDivStyle%>>
					<ul class="std0">
						<li class="od01"><input type="text"
							name="<portlet:namespace/>attachmentName" maxlength="75" /></li>
						<li class="od02"><input type="file"
							name="<portlet:namespace/>fileName" /></li>
						<li class="od01"></li>
						<li class="od01 lcol upd"><a href="#"
							onclick="<portlet:namespace/>addFile()"><liferay-ui:message
									key="vgc.apon.company.car.upload" /></a> <a href="#"
							onclick="<portlet:namespace/>removeFile(parentNode.parentNode)"><liferay-ui:message
									key="vgc.apon.company.car.delete" /></a></li>
					</ul>
				</div>
				<p style="padding-left:10px;padding-top: 30px;font-style:italic; color: red;"><liferay-ui:message key="vgc.apon.business.trip.attachmentList.notes" /></p>
			</div>
		</div>
		<!-- **************************************************************Upload the attachments end...******************************************************************************************* -->

		<div class="comment">
			<p>
				<liferay-ui:message key="vgc-apon-business-trip-application-remark" />
			</p>
			<textarea id="<portlet:namespace/>remark" col="6"
				name="<portlet:namespace/>remark"><%=businessTripReimbursement.getRemark()%></textarea>
		</div>

		<div class="nextbtn">
			<aui:button-row>
				<aui:button type="button" value="vgc.apon.button.save.as.draft"
					onClick='<%= renderResponse.getNamespace() + "saveBusinessTripReimbursement()" %>' />
				<aui:button type="button" value="vgc.apon.button.submit"
					onClick='<%= renderResponse.getNamespace() + "submitBusinessTripReimbursement()" %>' />
				<aui:button type="cancel" value="vgc.apon.button.back"
					onClick='<%= myApplicationsURL %>' />
			</aui:button-row>
		</div>
	</div>
</aui:form>

<portlet:actionURL name="applicantAgent" var="applicantAgentURL">
	<portlet:param name="mvcPath"
		value="/html/businessTripReimbursement/view.jsp" />
</portlet:actionURL>

<aui:form action="<%=applicantAgentURL%>" method="post"
	name="applicantAgentForm">
	<aui:fieldset>
		<aui:input name="bussinessTirpTicketNo2" type="hidden"
			value="<%=businessTripReimbursement!=null&&businessTripReimbursement.getBussinessTirpTicketNo()!=null?String.valueOf(businessTripReimbursement.getBussinessTirpTicketNo()):\"\"%>" />
		<aui:input name="businessTripReimbursementId" type="hidden"
			value="<%=businessTripReimbursementId%>" />
		<aui:input name="isApplicantAgent" type="hidden" />
		
	<input type="hidden" name="<portlet:namespace/>tempApproverId"
		value='<%="".equals(tempApproverId)?businessTripReimbursement.getApproverId():tempApproverId%>' />
	<input type="hidden" name="<portlet:namespace/>tempApproverName"
		value='<%="".equals(tempApproverName)?businessTripReimbursement.getApproverName():tempApproverName%>' />
	<input type="hidden" name="<portlet:namespace/>tempIsGetRMB"
		value='<%=tempIsGetRMB%>' />
	</aui:fieldset>
</aui:form>

<portlet:actionURL 
	var="searchBussinessTirpTicketNoURL">
	<portlet:param name="search" value="Yes"/>
</portlet:actionURL>

<aui:form action="<%=searchBussinessTirpTicketNoURL%>" method="post"
	name="searchBussinessTirpTicketNo">
	<aui:fieldset>
		<aui:input type="hidden" name="bussinessTirpTicketNo2" />
		<aui:input name="businessTripReimbursementId2" type="hidden" />
	</aui:fieldset>
	
		<input type="hidden" name="<portlet:namespace/>isApplicantAgent"
		value='<%=businessTripReimbursement.getIsApplicantAgent()||tempIsAppliantAgent?"true":"false"%>' />
		
</aui:form>

<!-- add one detail info -->
<portlet:actionURL name="addDetailInfo" var="addDetailInfoURL"
	windowState="normal">
	<portlet:param name="bussinessTirpTicketNo2"
		value="<%=businessTripReimbursement!=null&&businessTripReimbursement.getBussinessTirpTicketNo()!=null?String.valueOf(businessTripReimbursement.getBussinessTirpTicketNo()):\"\"%>" />
</portlet:actionURL>

<aui:form name="addDetailInfoFm" action="<%=addDetailInfoURL%>"
	method="post">
	<input type="hidden"
		name="<portlet:namespace/>businessTripReimbursementId"
		value="<%=businessTripReimbursementId%>" />
	<input type="hidden" name="<portlet:namespace/>pkId" />
	<input type="hidden" name="<portlet:namespace/>tabs2" />
	<input type="hidden" name="<portlet:namespace/>fromCity" />
	<input type="hidden" name="<portlet:namespace/>toCity" />
	<input type="hidden" name="<portlet:namespace/>departureDate" />
	<input type="hidden" name="<portlet:namespace/>departureFlight" />
	<input type="hidden" name="<portlet:namespace/>classInfo" />
	<input type="hidden" name="<portlet:namespace/>departureTrain" />
	<input type="hidden" name="<portlet:namespace/>city" />
	<input type="hidden" name="<portlet:namespace/>cityType" />
	<input type="hidden" name="<portlet:namespace/>hotel" />
	<input type="hidden" name="<portlet:namespace/>checkIn" />
	<input type="hidden" name="<portlet:namespace/>checkOut" />
	<input type="hidden" name="<portlet:namespace/>roomCategory" />
	<input type="hidden" name="<portlet:namespace/>price" />
	<input type="hidden" name="<portlet:namespace/>currency" />
	<input type="hidden" name="<portlet:namespace/>isOverBudget" />
	<input type="hidden" name="<portlet:namespace/>otherReasonInfo" />
	<input type="hidden" name="<portlet:namespace/>isNotBookedFromTA" />
	<input type="hidden" name="<portlet:namespace/>othersSpecify" />
	<input type="hidden" name="<portlet:namespace/>pickupLocation" />
	<input type="hidden" name="<portlet:namespace/>pickupDate" />
	<input type="hidden" name="<portlet:namespace/>dropoffLocation" />
	<input type="hidden" name="<portlet:namespace/>dropoffDate" />
	<input type="hidden" name="<portlet:namespace/>carType" />
	<input type="hidden" name="<portlet:namespace/>typeOfRental" />
	<input type="hidden" name="<portlet:namespace/>carPrice" />
	<input type="hidden" name="<portlet:namespace/>carCurrency" />

	<!-- by wanghai start -->
	<input type="hidden" name="<portlet:namespace/>fromTravelDate" />
	<input type="hidden" name="<portlet:namespace/>toTravelDate" />
	<input type="hidden" name="<portlet:namespace/>travelDate" />
	<input type="hidden" name="<portlet:namespace/>country" />
	<input type="hidden" name="<portlet:namespace/>isAdd" />
	<input type="hidden" name="<portlet:namespace/>rateOfDma" />
	<input type="hidden" name="<portlet:namespace/>comments" />
	<input type="hidden" name="<portlet:namespace/>departure" />
	<input type="hidden" name="<portlet:namespace/>arrival" />
	<input type="hidden" name="<portlet:namespace/>isHasBreakfast" />
	<input type="hidden" name="<portlet:namespace/>isHasLunch" />
	<input type="hidden" name="<portlet:namespace/>isHasDinner" />

	<!-- costList -->
	<input type="hidden" name="<portlet:namespace/>item" />
	<input type="hidden" name="<portlet:namespace/>btCostListId" />
	<input type="hidden" name="<portlet:namespace/>costType" />
	<input type="hidden" name="<portlet:namespace/>invoiceAmount" />
	<input type="hidden" name="<portlet:namespace/>invoiceCurrency" />
	
	<input type="hidden" name="<portlet:namespace/>netAmount" />
	<input type="hidden" name="<portlet:namespace/>taxAmount" />
	<input type="hidden" name="<portlet:namespace/>taxRate" />
	
	<input type="hidden" name="<portlet:namespace/>countryCity" />
	<input type="hidden" name="<portlet:namespace/>paymentCurrency" />
	<input type="hidden" name="<portlet:namespace/>paymentAmount" />

	<input type="hidden" name="<portlet:namespace/>btEntertainmentDetailId" />
	<input type="hidden" name="<portlet:namespace/>entertainmentDate" />
	<input type="hidden" name="<portlet:namespace/>entertainmentType" />
	<input type="hidden" name="<portlet:namespace/>entertainmentPlace" />
	<input type="hidden" name="<portlet:namespace/>fullName" />
	<input type="hidden" name="<portlet:namespace/>positionTitle" />
	<input type="hidden" name="<portlet:namespace/>company" />
	<input type="hidden" name="<portlet:namespace/>reasonsInfo" />
	<input type="hidden" name="<portlet:namespace/>amountTotal" />
	<input type="hidden" name="<portlet:namespace/>averageSpend" />
	<input type="hidden" name="<portlet:namespace/>attendeesTotal" />
	<input type="hidden" name="<portlet:namespace/>isEntertainment" />
	<input type="hidden" name="<portlet:namespace/>mealCategory" />
	
	<input type="hidden" name="<portlet:namespace/>cmd2" value="add" />
	<input type="hidden" name="<portlet:namespace/>totalCostRmb"
		value='<%=businessTripReimbursement.getTotalCostRmb()%>' />
	<input type="hidden" name="<portlet:namespace/>totalCostEur"
		value='<%=businessTripReimbursement.getTotalCostEur()%>' />
	<input type="hidden" name="<portlet:namespace/>hotelTotalCostRmb"
		value='<%=businessTripReimbursement.getHotelTotalCostRmb()%>' />
	<input type="hidden" name="<portlet:namespace/>hotelTotalCostEur"
		value='<%=businessTripReimbursement.getHotelTotalCostEur()%>' />
	<input type="hidden" name="<portlet:namespace/>carRentalTotalCostRmb"
		value='<%=businessTripReimbursement.getCarRentalTotalCostRmb()%>' />
	<input type="hidden" name="<portlet:namespace/>carRentalTotalCostEur"
		value='<%=businessTripReimbursement.getCarRentalTotalCostEur()%>' />

	<input type="hidden" name="<portlet:namespace/>totalTravelExpenseRmb"
		value='<%=businessTripReimbursement.getTotalTravelExpenseRmb()%>' />
	<input type="hidden" name="<portlet:namespace/>totalTravelExpenseEur"
		value='<%=businessTripReimbursement.getTotalTravelExpenseEur()%>' />

	<input type="hidden" name="<portlet:namespace/>costListInlandTotalRmb"
		value='<%=businessTripReimbursement.getCostListInlandTotalRmb()%>' />
	<input type="hidden" name="<portlet:namespace/>costListForeignTotalEur"
		value='<%=businessTripReimbursement.getCostListForeignTotalEur()%>' />
	<input type="hidden" name="<portlet:namespace/>costListForeignTotalRmb"
		value='<%=businessTripReimbursement.getCostListForeignTotalRmb()%>' />

	<input type="hidden" name="<portlet:namespace/>flightTotal"
		value='<%=businessTripReimbursement.getFlightTotal()%>' />
	<input type="hidden" name="<portlet:namespace/>flightAirFare"
		value='<%=businessTripReimbursement.getFlightAirFare()%>' />
	<input type="hidden" name="<portlet:namespace/>flightCurrency"
		value='<%=businessTripReimbursement.getFlightCurrency()%>' />
	<input type="hidden" name="<portlet:namespace/>flightTaxes"
		value='<%=businessTripReimbursement.getFlightTaxes()%>' />
	<input type="hidden" name="<portlet:namespace/>flightTransactionFee"
		value='<%=businessTripReimbursement.getFlightTransactionFee()%>' />
		
		<aui:input type="hidden" name="token" value='<%=token%>' />	
		
	<input type="hidden" name="<portlet:namespace/>isApplicantAgent"
		value='<%=businessTripReimbursement.getIsApplicantAgent()||tempIsAppliantAgent?"true":"false"%>' />

	<input type="hidden" name="<portlet:namespace/>tempApproverId"
		value='<%="".equals(tempApproverId)?businessTripReimbursement.getApproverId():tempApproverId%>' />
	<input type="hidden" name="<portlet:namespace/>tempApproverName"
		value='<%="".equals(tempApproverName)?businessTripReimbursement.getApproverName():tempApproverName%>' />
	<input type="hidden" name="<portlet:namespace/>tempIsGetRMB"
		value='<%=tempIsGetRMB%>' />	
</aui:form>
<liferay-util:include page="/html/businessTripReimbursement/view_js.jsp"  servletContext="<%= this.getServletContext() %>">
	<liferay-util:param name="businessTripReimbursement" value="<%=String.valueOf(businessTripReimbursementId) %>"/>
	<liferay-util:param name="supportFileType" value="<%=supportFileType %>"/>
	<liferay-util:param name="supportFileSize" value="<%=supportFileSize %>"/>
	<liferay-util:param name="importFileType" value="<%=importFileType %>"/>
	<liferay-util:param name="importError" value="<%=importError %>"/>
	<liferay-util:param name="tempIsGetRMB" value="<%=String.valueOf(tempIsGetRMB) %>"/>
	<liferay-util:param name="myApplicationsPlid" value="<%=String.valueOf(myApplicationsPlid) %>"/>
	<liferay-util:param name="businessTripApplication" value="<%=Validator.isNotNull(businessTripApplication)?String.valueOf(businessTripApplication.getBusinessTripApplicationId()):StringPool.BLANK %>"/>
</liferay-util:include>

