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
<%
	StringBuffer showSB = new StringBuffer();
	BusinessTripApplication businessTripApplication = null;
	long businessTripApplicationId = ParamUtil.getLong(request, "businessTripApplicationId");
	 showSB.append(" ##businessTripApplicationId===");
	 showSB.append(businessTripApplicationId);
	int sapStatus=0;
	String transitionName = ParamUtil.getString(renderRequest, "transitionName", "");
	//transitionName = "recall";
	String isClickAgent = ParamUtil.getString(renderRequest, "isClickAgent","");
	String tabs2 = ParamUtil.get(request, "tabs2", "flight");
	String tripType = PropsUtil.get("vgc.apon.business.trip.application.type");
	 showSB.append("  ##tripType ===");
	 showSB.append(tripType);
	boolean isNew = true;

	long sCode = themeDisplay.getUser().getFacebookId();
	Date now = new Date();
	ApplicantDelegation applicantDelegation = ApplicantDelegationLocalServiceUtil.fetchByP_S(ApproverDelegationLocalServiceUtil.getProcessOfBusinessTripApplication(),String.valueOf(sCode));
	boolean isHasAppliantAgent = applicantDelegation!=null && now.after(applicantDelegation.getEffectiveStartDate()) && now.before(applicantDelegation.getEffectiveEndDate())?true:false;
	String agentName = applicantDelegation!=null?ApplicantDelegationLocalServiceUtil.getAgentName(applicantDelegation):"";
	
	String prefixUrl = "/web"+themeDisplay.getScopeGroup().getFriendlyURL();	 
	String myApplicationsPageUrl = prefixUrl+PropsUtil.get("vgc.apon.my.applications.page.friendly.url");
	long myApplicationsPlid = PortalUtil.getPlidFromFriendlyURL(
			themeDisplay.getCompanyId(),myApplicationsPageUrl);
	
	if (businessTripApplicationId > 0) {
		businessTripApplication = BusinessTripApplicationLocalServiceUtil.fetchBusinessTripApplication(businessTripApplicationId);
		if(businessTripApplication!=null) {
			showSB.append("  ##isNew=== false");
			isNew = false;
		}
		businessTripApplication = businessTripApplication!=null?businessTripApplication:BusinessTripApplicationLocalServiceUtil.createBusinessTripApplication(businessTripApplicationId);
	}else {
		businessTripApplicationId = CounterLocalServiceUtil.increment(BusinessTripApplication.class.getName(),1);
		businessTripApplication = BusinessTripApplicationLocalServiceUtil.createBusinessTripApplication(businessTripApplicationId);
	}
	 showSB.append("  ##get BT OBJ===");
	 showSB.append(businessTripApplication.toString());
	String disabled="";
	String readonly="";
	if(!isNew&&businessTripApplication!=null){
		 sapStatus=businessTripApplication.getSapStatus();
		readonly=sapStatus==1 || businessTripApplication.getStatus()==104?"readonly='readonly'":"";
		disabled=sapStatus==1 || businessTripApplication.getStatus()==104?"disabled='disabled'":"";
	}

	double totalCostRmb = ParamUtil.getDouble(request, "totalCostRmb",businessTripApplication.getTotalCostRmb());
	double totalCostEur = ParamUtil.getDouble(request, "totalCostEur",businessTripApplication.getTotalCostEur());
	double hotelTotalCostRmb = ParamUtil.getDouble(request, "hotelTotalCostRmb",businessTripApplication.getHotelTotalCostRmb());
	double hotelTotalCostEur = ParamUtil.getDouble(request, "hotelTotalCostEur",businessTripApplication.getHotelTotalCostEur());
	double carRentalTotalCostRmb = ParamUtil.getDouble(request, "carRentalTotalCostRmb",businessTripApplication.getCarRentalTotalCostRmb());
	double carRentalTotalCostEur = ParamUtil.getDouble(request, "carRentalTotalCostEur",businessTripApplication.getCarRentalTotalCostEur());
	
	//Fetch the data from SAP
	if(isNew) {
		long staffCode = ParamUtil.getLong(renderRequest, "staffCode", 0);			
		staffCode=staffCode==0?themeDisplay.getUser().getFacebookId():staffCode;
		SAPUser sapUser = SAPUserLocalServiceUtil.getSapUserByStaffCode(String.valueOf(staffCode));
		boolean isApplicantAgent = ParamUtil.getBoolean(renderRequest, "isApplicantAgent",false);
		if(sapUser!=null) {
			businessTripApplication.setIsApplicantAgent(isApplicantAgent);
			businessTripApplication.setPrintName(sapUser.getStaffName());
			businessTripApplication.setStaffCode(Long.valueOf(sapUser.getStaffCode()));			
			businessTripApplication.setCompanyName(sapUser.getSapCompanyName());
			businessTripApplication.setDivision(sapUser.getDivisionName());
			businessTripApplication.setDepartment(sapUser.getDepartmentName());			
			businessTripApplication.setCostCenter(sapUser.getCostCener());			
			businessTripApplication.setPersonalID(sapUser.getPersonalId());
			businessTripApplication.setPassportNo(sapUser.getPassportNo());
			businessTripApplication.setOfficePhone(sapUser.getContactNo());
			businessTripApplication.setMobilePhone(sapUser.getCellPhone());
			businessTripApplication.setEmail(sapUser.getEmail());
			businessTripApplication.setOfficeSite(sapUser.getOfficeSite());
			businessTripApplication.setApproverId(Long.valueOf(Validator.isNotNull(sapUser.getSupervisorFgId())?sapUser.getSupervisorFgId():"0"));
			businessTripApplication.setApproverName(sapUser.getSupervisorFgName());
			businessTripApplication.setEvpId(Long.valueOf(Validator.isNotNull(sapUser.getDivisionManagerId())?sapUser.getDivisionManagerId():"0"));
			businessTripApplication.setEvpName(sapUser.getDivisionManagerName());
		}
	}else {
		boolean isApplicantAgent = ParamUtil.getBoolean(renderRequest, "isApplicantAgent",true);
		if(isApplicantAgent!=businessTripApplication.getIsApplicantAgent() && Validator.isNotNull(isClickAgent)) {		
			long staffCode = isApplicantAgent?ParamUtil.getLong(renderRequest, "staffCode", 0):themeDisplay.getUser().getFacebookId();
			staffCode = staffCode==0?businessTripApplication.getStaffCode():staffCode;
			SAPUser sapUser = SAPUserLocalServiceUtil.getSapUserByStaffCode(String.valueOf(staffCode));
			if(sapUser!=null) {
				businessTripApplication.setIsApplicantAgent(isApplicantAgent);
				businessTripApplication.setPrintName(sapUser.getStaffName());
				businessTripApplication.setStaffCode(Long.valueOf(sapUser.getStaffCode()));			
				businessTripApplication.setCompanyName(sapUser.getSapCompanyName());
				businessTripApplication.setDivision(sapUser.getDivisionName());
				businessTripApplication.setDepartment(sapUser.getDepartmentName());			
				businessTripApplication.setCostCenter(sapUser.getCostCener());			
				businessTripApplication.setPersonalID(sapUser.getPersonalId());
				businessTripApplication.setPassportNo(sapUser.getPassportNo());
				businessTripApplication.setOfficePhone(sapUser.getContactNo());
				businessTripApplication.setMobilePhone(sapUser.getCellPhone());
				businessTripApplication.setEmail(sapUser.getEmail());
				businessTripApplication.setOfficeSite(sapUser.getOfficeSite());
				businessTripApplication.setApproverId(Long.valueOf(Validator.isNotNull(sapUser.getSupervisorFgId())?sapUser.getSupervisorFgId():"0"));
				businessTripApplication.setApproverName(sapUser.getSupervisorFgName());
				
				businessTripApplication.setEvpId(Long.valueOf(Validator.isNotNull(sapUser.getDivisionManagerId())?sapUser.getDivisionManagerId():"0"));
				businessTripApplication.setEvpName(sapUser.getDivisionManagerName());
			}			
		}		
	}	

	long approverId = ParamUtil.getLong(request, "approverId",businessTripApplication.getApproverId());
	String approverName = ParamUtil.getString(request, "approverName",businessTripApplication.getApproverName());
	long evpId = ParamUtil.getLong(request, "evpId",businessTripApplication.getEvpId());
	String evpName = ParamUtil.getString(request, "evpName",businessTripApplication.getEvpName());
	String otherEmails= ParamUtil.getString(request, "otherEmails",businessTripApplication.getOtherEmails());
	boolean isCrossDepartment = ParamUtil.getBoolean(request, "isCrossDepartment",businessTripApplication.getIsCrossDepartment());
	long targetDepartmentId = ParamUtil.getLong(request, "targetDepartmentId",businessTripApplication.getTargetDepartmentId());
	String targetDepartmentName = ParamUtil.getString(request, "targetDepartmentName",businessTripApplication.getTargetDepartmentName());
	String targetCostCenter = ParamUtil.getString(request, "targetCostCenter",businessTripApplication.getTargetCostCenter());
	long targetDepartmentApproverId = ParamUtil.getLong(request, "targetDepartmentApproverId",businessTripApplication.getTargetDepartmentApproverId());
	String targetDepartmentApproverName = ParamUtil.getString(request, "targetDepartmentApproverName",businessTripApplication.getTargetDepartmentApproverName());
	int tt=0;
	if(isNew){
		tt= ParamUtil.getInteger(request, "tripTypeAsForm",99);
	}else{
		tt = ParamUtil.getInteger(request, "tripType",businessTripApplication.getTripType());
		 if(tt==99){
			 tt =businessTripApplication.getTripType();
		 }
	}
	showSB.append("  ##tt=== ");
	showSB.append(tt);
	boolean isPassValue = ParamUtil.getBoolean(request, "isPassValue",false);
	String departureDate = ParamUtil.getString(request, "departureDate",businessTripApplication.getDepartureDate()!=null?sdf_dmy.format(businessTripApplication.getDepartureDate()):"");
	String returnDate = ParamUtil.getString(request, "returnDate",businessTripApplication.getReturnDate()!=null?sdf_dmy.format(businessTripApplication.getReturnDate()):"");
	String purposeOfTheTrip = ParamUtil.getString(request, "purposeOfTheTrip",businessTripApplication.getPurposeOfTheTrip());
	String visitCountriesCities = ParamUtil.getString(request, "visitCountriesCities",businessTripApplication.getVisitCountriesCities());
	double advancePayment = ParamUtil.getDouble(request, "advancePayment",businessTripApplication.getAdvancePayment());
	String currency = ParamUtil.getString(request, "currency",businessTripApplication.getCurrency());
	
	String imageQueryPath = themeDisplay.getPathThemeImages()+"/diff/vgc_apon_my_applications_details.png";
	List<AuditTrailLog> auditTrailLogs = AuditTrailLogLocalServiceUtil.findAuditTrailByWF_O_O(businessTripApplicationId, BusinessTripApplication.class.getName());
	List<FileManagement> fileManagements = FileManagementLocalServiceUtil.getByAssetClassNameAndAssetPrimaryKey(BusinessTripApplication.class.getName(),businessTripApplicationId);
	String supportFileType = PropsUtil.get("vgc.apon.support.upload.file.type");
	String supportFileSize = PropsUtil.get("vgc.apon.support.upload.file.size");
	String addPagePath = "/html/businessTripApplication/flightTrainInformationAdd.jsp";
	String selectedTabPage = "vgc-apon-business-trip-application-flight-information";
	if("train".equals(tabs2)) {
		addPagePath = "/html/businessTripApplication/trainInformationAdd.jsp";
		selectedTabPage = "vgc-apon-business-trip-application-train-information";
	}else if("hotelInformation".equals(tabs2)) {
		addPagePath = "/html/businessTripApplication/hotelInformationAdd.jsp";
		selectedTabPage = "vgc-apon-business-trip-application-hotel-information";
	}else if("carRental".equals(tabs2)) {
		addPagePath = "/html/businessTripApplication/carRentalAdd.jsp";
		selectedTabPage = "vgc-apon-business-trip-application-car-rental";
	}
	String trashImage=themeDisplay.getPathThemeImages()+"/common/trash.png";
	String departureAndReturnDateReadOnly = BtHotelInfoLocalServiceUtil.findCountByB_T(businessTripApplicationId, tripType)>0?"readonly='readonly'":"";
%>
<style>
.yui3-aclist-list li{width: 270px;}
yui3-aclist-item{
{width: 270px;}
} 
yui3-aclist-item-active{
width: 270px;
}
</style>
<portlet:actionURL var="addBusinessTripApplicationURL" windowState="normal" >
	<portlet:param name="isRedirect" value="Yes"/>
</portlet:actionURL>

<portlet:actionURL name="deleteDetailInfo" var="deleteDetailInfoURL">
	<portlet:param name="businessTripApplicationId" value="<%=String.valueOf(businessTripApplicationId) %>"/>
</portlet:actionURL>

<!-- Delete One BtFlightTrainInfo -->
<aui:form method="post" name="deleteDetailInfoForm" action="<%=deleteDetailInfoURL%>">
	<aui:input type="hidden" name="pkId" />
	<aui:input type="hidden" name="tabs2" value="<%=tabs2 %>"/>
	<aui:input type="hidden" name="totalCostRmb" value='<%=totalCostRmb%>'/>
	<aui:input type="hidden" name="totalCostEur" value='<%=totalCostEur%>'/>
	<aui:input type="hidden" name="hotelTotalCostRmb" value='<%=hotelTotalCostRmb%>'/>
	<aui:input type="hidden" name="hotelTotalCostEur" value='<%=hotelTotalCostEur%>'/>
	<aui:input type="hidden" name="carRentalTotalCostRmb" value='<%=carRentalTotalCostRmb%>'/>
	<aui:input type="hidden" name="carRentalTotalCostEur" value='<%=carRentalTotalCostEur%>'/>
	
	<aui:input type="hidden" name="isApplicantAgent"/>
	<aui:input type="hidden" name="staffCode"/>
	<aui:input type="hidden" name="approverId" value='<%=approverId%>'/>
	<aui:input type="hidden" name="approverName" value='<%=approverName%>'/>
	<aui:input type="hidden" name="evpId" value='<%=evpId%>'/>
	<aui:input type="hidden" name="evpName" value='<%=evpName%>'/>
	<aui:input type="hidden" name="otherEmails" value='<%=otherEmails%>'/>
	<aui:input type="hidden" name="isCrossDepartment" value='<%=isCrossDepartment%>'/>
	<aui:input type="hidden" name="targetDepartmentId" value='<%=targetDepartmentId%>'/>
	<aui:input type="hidden" name="targetDepartmentName" value='<%=targetDepartmentName%>'/>
	<aui:input type="hidden" name="targetCostCenter" value='<%=targetCostCenter%>'/>
	<aui:input type="hidden" name="targetDepartmentApproverId" value='<%=targetDepartmentApproverId%>'/>
	<aui:input type="hidden" name="targetDepartmentApproverName" value='<%=targetDepartmentApproverName%>'/>
	<aui:input type="hidden" name="tripType" value='<%=tt%>'/>
	<aui:input type="hidden" name="departureDate" value='<%=departureDate%>'/>
	<aui:input type="hidden" name="returnDate" value='<%=returnDate%>'/>
	<aui:input type="hidden" name="purposeOfTheTrip" value='<%=purposeOfTheTrip%>'/>
	<aui:input type="hidden" name="visitCountriesCities" value='<%=visitCountriesCities%>'/>
	<aui:input type="hidden" name="advancePayment" value='<%=advancePayment%>'/>
	<aui:input type="hidden" name="currency" value='<%=currency%>'/>
	<aui:input type="hidden" name="tripTypeAsForm"  id="tripTypeAsForm" />
</aui:form>

<portlet:resourceURL var="downloadURL" ></portlet:resourceURL>
<portlet:resourceURL var="completeURL" >
<portlet:param name="cmd" value="autocomplete"/>
</portlet:resourceURL>
<liferay-portlet:renderURL var="myApplicationsURL"
	plid="<%=myApplicationsPlid%>"
	portletName='<%=PropsUtil.get("vgc.apon.my.applications.portletId") %>'
	windowState="normal">
</liferay-portlet:renderURL>

<aui:model-context bean="<%=businessTripApplication%>"
	model="<%=BusinessTripApplication.class%>" />


<!--  First company car applicant page -->
<aui:form name="fm" method="POST" action="<%=addBusinessTripApplicationURL%>"
	enctype="multipart/form-data">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="<%=redirect%>" />
		<aui:input name="<%=Constants.CMD%>" type="hidden" />
		<aui:input name="completeCmd" type="hidden" />
		<aui:input type="hidden" name="businessTripApplicationId" value='<%=businessTripApplicationId%>'/>
		<aui:input type="hidden" name="totalCostRmb" value='<%=totalCostRmb%>'/>
		<aui:input type="hidden" name="totalCostEur" value='<%=totalCostEur%>'/>
		<aui:input type="hidden" name="hotelTotalCostRmb" value='<%=hotelTotalCostRmb%>'/>
		<aui:input type="hidden" name="hotelTotalCostEur" value='<%=hotelTotalCostEur%>'/>
		<aui:input type="hidden" name="carRentalTotalCostRmb" value='<%=carRentalTotalCostRmb%>'/>
		<aui:input type="hidden" name="carRentalTotalCostEur" value='<%=carRentalTotalCostEur%>'/>
		<aui:input type="hidden" name="transitionName" value='<%=transitionName%>' />	
		<aui:input type="hidden" name="existTitles"/>	
		<aui:input type="hidden" name="newTitles"/>	
		<aui:input type="hidden" name="existFileIds"/>	
	</aui:fieldset>

	<div class="mainbody">
		<div class="topButton">
			<aui:button-row>
				<%if(businessTripApplication.getStatus()==104) {%>
					<aui:button type="button" value="vgc-apon-business-trip-button-apply-cash-advance"
						onClick='<%= renderResponse.getNamespace() + "updateBusinessTripApplication()" %>' />
					<aui:button type="button" value="vgc-apon-business-trip-button-complete-without-cash-advance"
						onClick='<%= renderResponse.getNamespace() + "closeBusinessTripApplication()" %>' />
				<%}else { %>
					<aui:button type="button" value="vgc.apon.button.save.as.draft"
						onClick='<%= renderResponse.getNamespace() + "saveBusinessTripApplication()" %>' />
					<aui:button type="button" value="vgc.apon.button.submit"
						onClick='<%= renderResponse.getNamespace() + "submitBusinessTripApplication()" %>' />
				<%} %>
				<aui:button type="cancel" value="vgc.apon.button.back"
					onClick='<%= myApplicationsURL %>' />
			</aui:button-row>
		</div>
		<div class="tabTitle">
			<h3>
				<liferay-ui:message
					key="vgc-apon-business-trip-application"/>
			</h3>
			<div class="Ltext"></div>
			<div class="tickerNo">
				<liferay-ui:message key="vgc-apon-business-trip-application-ticket-no" />
				<span class="num"><%=businessTripApplication.getTicketNo()%></span>
			</div>
			<div class="clear"></div>
		</div>
		<div class="gernal employeeInfo">
			<div class="subtitle">
				<liferay-ui:message
					key="vgc-apon-business-trip-application-personal-information" />
				<%if(isHasAppliantAgent) {
				%>
				<input type="checkbox" name="<portlet:namespace/>isApplicantAgent"
					value='<%=true %>' <%=businessTripApplication.getIsApplicantAgent()?"checked='checked'":"" %>
					onclick='<%=renderResponse.getNamespace() + "applicantAgentClick(this)"%>'/>
				<liferay-ui:message key="vgc-apon-on-behalf-of-x" arguments="<%=agentName %>"/>
				<%	
				} 
				%>
			</div>
			<ul>
				<li class="md01"><liferay-ui:message
						key="vgc-apon-business-trip-application-print-name" /></li>
				<li class="md02"><input type="text"
					name="<portlet:namespace/>printName" readonly="readonly" maxlength="75"
					value="<%=businessTripApplication.getPrintName()%>"></li>
				<li class="md01"><liferay-ui:message
						key="vgc-apon-business-trip-application-staff-code" /></li>
				<li class="md022">
					<input id="<portlet:namespace />staffCode" type="text" 
						name="<portlet:namespace/>staffCode" readonly="readonly" maxlength="75"
						value="<%=businessTripApplication.getStaffCode()%>" />
				</li>
			</ul>
			<ul>
				<li class="md01"><liferay-ui:message
						key="vgc-apon-business-trip-application-company" /></li>
				<li class="md02"><input type="text" name="<portlet:namespace/>companyName" maxlength="75"
							value='<%=businessTripApplication.getCompanyName()%>' readonly="readonly">
				</li>
				<li class="md01"><liferay-ui:message
						key="vgc-apon-business-trip-application-division" /></li>
				<li class="md022"><input type="text" name="<portlet:namespace/>division"
							readonly="readonly"  maxlength="75"
							value="<%=businessTripApplication.getDivision()%>"></li>
			</ul>
			<ul>
				<li class="md01"><liferay-ui:message
						key="vgc-apon-business-trip-application-department" /></li>
				<li class="md02"><input type="text" name="<portlet:namespace/>department"
							readonly="readonly"  maxlength="75"
							value="<%=businessTripApplication.getDepartment()%>"></li>
				<li class="md01"><liferay-ui:message
						key="vgc-apon-business-trip-application-cost-center" /></li>
				<li class="md022"><input type="text" maxlength="75"
							name="<portlet:namespace/>positionCostCenterId" readonly="readonly"
							value="<%=businessTripApplication.getCostCenter()%>"></li>
			</ul>
			<ul>
				<li class="md01"><liferay-ui:message
						key="vgc-apon-business-trip-application-personal-id" /></li>
				<li class="md02"><input type="text" maxlength="75"
								name="<portlet:namespace/>personalID" readonly="readonly"
								value="<%=businessTripApplication.getPersonalID()%>"/>
				</li>
				<li class="md01"><liferay-ui:message
						key="vgc-apon-business-trip-application-passport-no" /></li>
				<li class="md022"><input type="text" maxlength="75"
								name="<portlet:namespace/>passportNo" readonly="readonly"
								value="<%=businessTripApplication.getPassportNo()%>"/></li>
			</ul>
			<ul>
				<li class="md01"><liferay-ui:message
						key="vgc-apon-business-trip-application-office-phone" /></li>
				<li class="md02"><input type="text" maxlength="75"
								name="<portlet:namespace/>officePhone" readonly="readonly"
								value="<%=businessTripApplication.getOfficePhone()%>"/>
				</li>
				<li class="md01"><liferay-ui:message
						key="vgc-apon-business-trip-application-mobile-phone" /></li>
				<li class="md022"><input type="text" maxlength="75"
								name="<portlet:namespace/>mobilePhone" readonly="readonly"
								value="<%=businessTripApplication.getMobilePhone()%>"/></li>
			</ul>
			<ul>
				<li class="md01"><liferay-ui:message
						key="vgc-apon-business-trip-application-email" /></li>
				<li class="md02"><input type="text" maxlength="75"
								name="<portlet:namespace/>email" readonly="readonly"
								value="<%=businessTripApplication.getEmail()%>"/>
				</li>
				<li class="md01"><liferay-ui:message
						key="vgc-apon-business-trip-application-office-site" /></li>
				<li class="md022"><input type="text" maxlength="75"
								name="<portlet:namespace/>officeSite" readonly="readonly"
								value="<%=businessTripApplication.getOfficeSite()%>"/></li>
			</ul>
			
			<ul>
				<li class="md01"><liferay-ui:message
						key="vgc-apon-business-trip-application-approver" /></li>
				<li class="md02">
					<input type="text" maxlength="75"
							name="<portlet:namespace/>approverName" id="approverName"
							value="<%=approverName%>" readonly="readonly"/>
					<input type="hidden" maxlength="75"
							name="<portlet:namespace/>approverId" id="approverId"
							value="<%=approverId%>"/>
							
					<%if(!(businessTripApplication.getSapStatus()==1 || businessTripApplication.getStatus()==104)) {%>		
						<liferay-ui:icon
							id="selectApprover" label="<%=true%>" message="" method="get"
							url="javascript:;" src="<%=imageQueryPath%>"/>
					<%} %>
				</li>
				
				<li class="md01"><liferay-ui:message
						key="vgc-apon-business-trip-application-evp" /></li>
				<li class="md022">
					<input type="text" maxlength="75"
							name="<portlet:namespace/>evpName" id="evpName"
							value="<%=evpName%>" readonly="readonly"/>
					<input type="hidden" maxlength="75"
							name="<portlet:namespace/>evpId" id="evpId"
							value="<%=evpId%>"/>
					<%if(!(businessTripApplication.getSapStatus()==1 || businessTripApplication.getStatus()==104)) {%>		
						<liferay-ui:icon
							id="selectEvp" label="<%=true%>" message="" method="get"
							url="javascript:;" src="<%=imageQueryPath%>"/>
					<%} %>
				</li>
				
			</ul>
			<ul>
			<li class="md01"><liferay-ui:message
						key="vgc-apon-business-trip-application-cross-department" /></li>
				<li class="md022"><input type="checkbox" id="crossDepartment" name="<portlet:namespace/>isCrossDepartment"
					value='<%=true %>' <%=isCrossDepartment?"checked='checked'":"" %> 
					onclick='<%=renderResponse.getNamespace() + "crossDepartment(this)"%>' <%=readonly%> <%=disabled%>/></li>
			</ul>
			<ul id="targetU1" style='display: <%=isCrossDepartment?"block":"none" %>'>
				<li class="md01"><liferay-ui:message
						key="vgc-apon-business-trip-application-target-department" /></li>
				<li class="md02">
					<input type="text" maxlength="75"
							name="<portlet:namespace/>targetDepartmentName"  
							value="<%=targetDepartmentName%>" id="targetDepartmentName" readonly="readonly"/>
					<input type="hidden" maxlength="75"
							name="<portlet:namespace/>targetDepartmentId" 
							value="<%=targetDepartmentId%>" id="targetDepartmentId"/>
					<%if(!(businessTripApplication.getSapStatus()==1 || businessTripApplication.getStatus()==104)) {%>		
						<liferay-ui:icon
							id="selectTargetDepartment" label="<%=true%>" message="" method="get"
							url="javascript:;" src="<%=imageQueryPath%>" />
					<%} %>					
				</li>
				<li class="md01"><liferay-ui:message
						key="vgc-apon-business-trip-application-target-cost-center" /></li>
				<li class="md022"><input type="text" maxlength="75"
								name="<portlet:namespace/>targetCostCenter" id="targetCostCenter" readonly="readonly"
								value="<%=targetCostCenter%>"/></li>
			</ul>
			<ul id="targetU2" style='display: <%=isCrossDepartment?"block":"none" %>'>
				<li class="md01"><liferay-ui:message
						key="vgc-apon-business-trip-application-target-department-approver" /></li>
				<li class="md02">
					<input type="text" maxlength="75"
						name="<portlet:namespace/>targetDepartmentApproverName" id="targetDepartmentApproverName" readonly="readonly"
						value="<%=targetDepartmentApproverName%>"/>
					<input type="hidden" maxlength="75"
						name="<portlet:namespace/>targetDepartmentApproverId" id="targetDepartmentApproverId" readonly="readonly"
						value="<%=targetDepartmentApproverId%>"/>
				</li>
			</ul>			
		</div>
		
		<div class="gernal carInfo">
			<div class="subtitle">
				<liferay-ui:message
					key="vgc-apon-business-trip-application-travel-reservation" />
				<input type="radio" name="<portlet:namespace/>tripType"
					value='0' <%=tt==0?"checked='checked'":"" %> onclick='CheckTripType(0)' <%=disabled%>/>
				<font id="domf"><liferay-ui:message key="vgc-apon-business-trip-application-domestic-trip"/></font>
				<input type="radio" name="<portlet:namespace/>tripType"
					value='1' <%=tt==1?"checked='checked'":"" %> onclick='CheckTripType(1)' <%=disabled%>/>
				<font id="intf"><liferay-ui:message key="vgc-apon-business-trip-application-international-trip"/></font>
			</div>
			<ul >
				<li class="md01" ><liferay-ui:message
						key="vgc-apon-business-trip-application-departure-date" /></li>
				<li class="md02"><input id="d4311" class="Wdate" type="text" name="<portlet:namespace/>departureDate" value="<%=departureDate==null?"":departureDate%>"
							onFocus="WdatePicker({lang:'en',dateFmt:'dd.MM.yyyy',maxDate:'#F{$dp.$D(\'d4312\')}'})" /></li>
				<li class="md01"><liferay-ui:message
						key="vgc-apon-business-trip-application-return-date" /></li>
				<li class="md022"><input id="d4312" class="Wdate" type="text" name="<portlet:namespace/>returnDate" value="<%=returnDate==null?"":returnDate %>"
							onFocus="WdatePicker({lang:'en',dateFmt:'dd.MM.yyyy',minDate:'#F{$dp.$D(\'d4311\')}'})" /></li>
			</ul>			
			<ul>
				<li class="md01" ><liferay-ui:message key="vgc-apon-business-trip-application-purpose-of-the-trip"></liferay-ui:message></li>
				<li class="md03">
					<input type="text" name="<portlet:namespace/>purposeOfTheTrip" value="<%=purposeOfTheTrip%>" maxlength="75" <%=readonly%>/>			
				</li>
			</ul>
			<ul>
				<li class="md01" style="width:165px;margin-right:11px;"><liferay-ui:message
						key="vgc-apon-business-trip-application-visit-countries-cities" /></li>
				<li class="md02"><input type="text"
					name="<portlet:namespace/>visitCountriesCities" maxlength="75"
					value="<%=visitCountriesCities%>" <%=readonly%>></li>
			</ul>
		</div>
		
		<!-- Business Trip Application Three Tabs Pages Start............................................................................ -->
		
		<liferay-ui:tabs  names="vgc-apon-business-trip-application-flight-information,vgc-apon-business-trip-application-train-information,vgc-apon-business-trip-application-hotel-information,vgc-apon-business-trip-application-car-rental"
			 refresh='<%= false %>'
			value='<%= selectedTabPage %>' type="tabs">
			<liferay-ui:section>
				<%@ include file="/html/businessTripApplication/flightTrainInformationView.jsp"%>				
			</liferay-ui:section>
			<liferay-ui:section>
				<%@ include file="/html/businessTripApplication/trainInformationView.jsp"%>				
			</liferay-ui:section>
			<liferay-ui:section>
				<%@ include file="/html/businessTripApplication/hotelInformationView.jsp"%>		
			</liferay-ui:section>
			<liferay-ui:section >
				<%@ include file="/html/businessTripApplication/carRentalView.jsp"%>	
			</liferay-ui:section>
		</liferay-ui:tabs>
		<%-- <aui:button-row>
			<aui:button value="vgc.apon.button.add"
				 onClick='<%= renderResponse.getNamespace() + "openAddPage();" %>'/>
		</aui:button-row> --%>		
		<!-- **************************************************************Upload the attachments start...******************************************************************************************* -->
		
		<div class="gernal carInfo">
			<div class="subtitle">
				<liferay-ui:message
					key="vgc-apon-business-trip-application-cash-advance" />
			</div>
				<p style="padding-left:5px;padding-top: 10px;font-style:italic; color: red;">The advance payment can be edited only AFTER the business trip was fully approved.The field will then become editabe.Reimbursement currency should be consistent with cash advance you claimed.</p>
			<ul>
				<li class="md01"><liferay-ui:message
						key="vgc-apon-business-trip-application-advance-payment" /></li>
				<li class="md02">
					<input type="text" maxlength="75"
							name="<portlet:namespace/>advancePayment"
							value="<%=String.format("%.2f", advancePayment)%>" onblur="checkFloat(this)" <%=businessTripApplication.getStatus()==104?"":"readonly='readonly'" %>  onkeyup="this.value=this.value.replace(/[^0-9.]/g,'')"/>
				</li>
				<li class="md01"><liferay-ui:message 
						key="vgc-apon-business-trip-application-currency" /></li>
				<li class="md022">
					<select name="<portlet:namespace/>currency"  id="paymentCurrencyApp" <%=businessTripApplication.getStatus()==104?"":"disabled='disabled'" %> >
						<%
		                String cur=isNew?"RMB":currency;
				        for(String label:new String[]{"RMB","EUR"}){					        		
				        %>
						<option value="<%=label%>"
							<%=cur.equals(label)?"selected='selected'":""%>><%=label%></option>
						<% 
				        }
				        %>
					</select>
				</li>
			</ul>			
			<ul>
				<li class="md01"><liferay-ui:message key="vgc-apon-business-trip-application-payment-methods"></liferay-ui:message></li>
				<li class="md02">Bank Transfer</li>
				<li style="padding-left:42px;font-style:italic; color: red;width:400px;margin-left:54px;">Note:VGIC can not reimburse EUR,VGIC employees must NOT change this option or the application will be rejected.</p>
			</ul>
		
			<ul id="hotelandcar">
				<li class="md01"><liferay-ui:message key="vgc-apon-business-trip-application-hotel-and-car-rental-total-cost"></liferay-ui:message></li>
				<li class="md03"><%= String.format("%.2f", totalCostRmb) %>&nbsp;RMB&nbsp;<%= String.format("%.2f", totalCostEur)%>&nbsp;EUR</li>
			</ul>
			<ul>
				<li class="md01"><liferay-ui:message key="vgc-apon-business-trip-application-hotel-cost"></liferay-ui:message></li>
				<li class="md03"><%= String.format("%.2f", hotelTotalCostRmb)%>&nbsp;RMB&nbsp;<%= String.format("%.2f", hotelTotalCostEur)%>&nbsp;EUR</li>
			</ul>
			<ul id="car">
				<li class="md01"><liferay-ui:message key="vgc-apon-business-trip-application-car-rental-cost"></liferay-ui:message></li>
				<li class="md03"><%= String.format("%.2f", carRentalTotalCostRmb)%>&nbsp;RMB&nbsp;<%= String.format("%.2f", carRentalTotalCostEur)%>&nbsp;EUR</li>
			</ul>
		</div>
		
				<div class="attachmentList" id="emaillist">
				<input type="hidden" name="<portlet:namespace/>otherEmails" value='<%=otherEmails%>' id="<portlet:namespace/>otherEmails"/>
			<div class="subtitle">Email List for Additional Recipients</div>
			<div class="gridtb">
				<ul>
					<li class="od02">Email</li>
					<li class="od01 lcol">Action</li>
				</ul>	
				<div id="<portlet:namespace/>emailDiv0" >
					
				</div>	
				<%
					String emailfileDivStyle =businessTripApplication.getTicketNo()==null||businessTripApplication.getTicketNo().equals("") ? "" : "style='margin-top: 1px;'";
				%>
									
				<div id="<portlet:namespace/>emailfileDiv" <%=emailfileDivStyle %>>
					<ul>
						<li class="od02">
						<input type="text"  autocomplete="off"  id="<portlet:namespace/>emailSelect"/>
						</li>
						<li  class="od01 lcol">
							<input type="button" value="Add"
					onClick='<%= renderResponse.getNamespace() + "addEmail()" %>' />
							
						</li>
					</ul>
				</div>
			</div>
		</div>

		
		<div class="attachmentList" id="attachmentList">
			<div class="subtitle">Attachment list</div>
			<div class="gridtb">
				<ul>
					<li class="od01">Attachment Name</li>
					<li class="od02">File Name</li>
					<li class="od01">Upload Date</li>
					<li class="od01 lcol">Action</li>
				</ul>	
				<div id="<portlet:namespace/>fileDiv0">
					<%for(FileManagement fileManagement:fileManagements) {
						%>
						<ul class="std0">
							<li class="od01">
								<input type="text" name="<portlet:namespace/>fileManagementFileName" value="<%=fileManagement.getTitle()%>" maxlength="75" />
								<input type="hidden" name="<portlet:namespace/>fileManagementId" value="<%=fileManagement.getFileManagementId()%>"/>
							</li>
							<li class="od02"><a href="#" onclick='<portlet:namespace />download("<%=fileManagement.getFileName()%>","<%=fileManagement.getFilePath()%>")'><%=fileManagement.getFileName()%></a></li>
							<li class="od01"><%=sdf.format(fileManagement.getCreateDate())%></li>
							<li class="od01 lcol upd">
								<a href="#" onclick="<portlet:namespace/>addFile()"><liferay-ui:message key="vgc.apon.company.car.upload" /></a>&nbsp;
								<a href="#" onclick="<portlet:namespace/>removeFile(parentNode.parentNode)"><liferay-ui:message key="vgc.apon.company.car.delete" /></a>
							</li>
						</ul>
						<%
					} %>
				</div>		
				<%
					String fileDivStyle =businessTripApplication.getTicketNo()==null||businessTripApplication.getTicketNo().equals("") ? "" : "style='margin-top: 1px;'";
				%>					
				<div id="<portlet:namespace/>fileDiv" <%=fileDivStyle %>>
					<ul class="std0">
						<li class="od01"><input type="text" name="<portlet:namespace/>attachmentName" maxlength="75"/></li>
						<li class="od02"><input type="file" name="<portlet:namespace/>fileName"/></li>
						<li class="od01"></li>
						<li class="od01 lcol upd" >
							<a href="#" onclick="<portlet:namespace/>addFile()"><liferay-ui:message key="vgc.apon.company.car.upload" /></a>
							<a href="#" onclick="<portlet:namespace/>removeFile(parentNode.parentNode)"><liferay-ui:message key="vgc.apon.company.car.delete" /></a>
						</li>
					</ul>
				</div>
			</div>
				<p style="padding-left:10px;padding-top: 30px;font-style:italic; color: red;"><liferay-ui:message key="vgc.apon.business.trip.attachmentList.notes" /></p>
		</div>
		<!-- **************************************************************Upload the attachments end...******************************************************************************************* -->

		<div class="approvalStatusInfo"
			style='display: <%=auditTrailLogs.size()>0?"block":"none"%>'>
			<div class="subtitle">
				<liferay-ui:message
							key="vgc.apon.audit.trail.log.approval.status.information" />
			</div>
			<div class="gridtb">
				<ul>
					<li class="od03"><liferay-ui:message
							key="vgc.apon.audit.trail.log.no" /></li>
					<li class="od04"><liferay-ui:message
							key="vgc.apon.audit.trail.log.approver.applicant.role" /></li>
					<li class="od04"><liferay-ui:message
							key="vgc.apon.audit.trail.log.approver.applicant" /></li>
					<li class="od04"><liferay-ui:message
							key="vgc.apon.audit.trail.log.action.status" /></li>
					<li class="od04"><liferay-ui:message
							key="vgc.apon.audit.trail.log.time" /></li>
					<li class="od04 lcol"><liferay-ui:message
							key="vgc.apon.audit.trail.log.comment" /></li>
				</ul>
				<%
					for(int i=0;i<auditTrailLogs.size();i++) {
									AuditTrailLog auLog = auditTrailLogs.get(i);
				%>
				<ul class="std">
					<li class="od03"><%=i+1%></li>
					<li class="od04"><%=auLog.getOperationRole()%></li>
					<li class="od04"><%=auLog.getOperationUser()%></li>
					<li class="od04"><%=auLog.getOperationStatus()%></li>
					<li class="od04"><%=auLog.getOperationTime()==null?"":sdf.format(auLog.getOperationTime())%></li>
					<li class="od04 lcol"><%=auLog.getOperationComment()%></li>
				</ul>
				<%
					}
				%>
			</div>
		</div>
		
		<div class="comment">
			<p><liferay-ui:message key="vgc-apon-business-trip-application-remark" /></p>
			<textarea id="<portlet:namespace/>remark" col="6" name="<portlet:namespace/>remark"><%=businessTripApplication.getRemark()%></textarea>
		</div>
		
		<div class="nextbtn">
			<aui:button-row>
				<%if(businessTripApplication.getStatus()==104) {%>
					<aui:button type="button" value="vgc-apon-business-trip-button-apply-cash-advance"
						onClick='<%= renderResponse.getNamespace() + "updateBusinessTripApplication()" %>' />
					<aui:button type="button" value="vgc-apon-business-trip-button-complete-without-cash-advance"
						onClick='<%= renderResponse.getNamespace() + "closeBusinessTripApplication()" %>' />
				<%}else { %>
					<aui:button type="button" value="vgc.apon.button.save.as.draft"
						onClick='<%= renderResponse.getNamespace() + "saveBusinessTripApplication()" %>' />
					<aui:button type="button" value="vgc.apon.button.submit"
						onClick='<%= renderResponse.getNamespace() + "submitBusinessTripApplication()" %>' />
				<%} %>
				<aui:button type="cancel" value="vgc.apon.button.back"
					onClick='<%= myApplicationsURL %>' />
			</aui:button-row>
		</div>
	</div>	
</aui:form>

<portlet:actionURL name="applicantAgent" var="applicantAgentURL" >
	<portlet:param name="mvcPath" value="/html/businessTripApplication/view.jsp"/>
</portlet:actionURL>

<aui:form action="<%=applicantAgentURL%>" method="post" name="applicantAgentForm">
	<aui:fieldset>
		<aui:input name="businessTripApplicationId" type="hidden" value="<%=businessTripApplicationId %>"/>
		<aui:input name="isApplicantAgent" type="hidden" />
		<aui:input type="hidden" name="transitionName" value='<%=transitionName%>' />	
	</aui:fieldset>
</aui:form>

<!-- add one detail info -->
<portlet:actionURL name="addDetailInfo" var="addDetailInfoURL" windowState="normal"></portlet:actionURL>

<aui:form name="addDetailInfoFm" action="<%=addDetailInfoURL %>" method="post">
	<input type="hidden" name="<portlet:namespace/>businessTripApplicationId"  value="<%=businessTripApplicationId %>"/>
	<input type="hidden" name="<portlet:namespace/>pkId" />
	<input type="hidden" name="<portlet:namespace/>tabs2" />
	<input type="hidden" name="<portlet:namespace/>fromCity"/>
	<input type="hidden" name="<portlet:namespace/>toCity"/>
	<input type="hidden" name="<portlet:namespace/>departureDate_"/>		
	<input type="hidden" name="<portlet:namespace/>departureFlight"/>		
	<input type="hidden" name="<portlet:namespace/>classInfo"/>		
	<input type="hidden" name="<portlet:namespace/>departureTrain"/>	
	<input type="hidden" name="<portlet:namespace/>city"/>
	<input type="hidden" name="<portlet:namespace/>cityType"/>
	<input type="hidden" name="<portlet:namespace/>hotel"/>
	<input type="hidden" name="<portlet:namespace/>checkIn"/>
	<input type="hidden" name="<portlet:namespace/>checkOut"/>
	<input type="hidden" name="<portlet:namespace/>roomCategory"/>
	<input type="hidden" name="<portlet:namespace/>price"/>
	<input type="hidden" name="<portlet:namespace/>currency_"/>
	<input type="hidden" name="<portlet:namespace/>isOverBudget"/>
	<input type="hidden" name="<portlet:namespace/>otherReasonInfo"/>
	<input type="hidden" name="<portlet:namespace/>isNotBookedFromTA"/>
	<input type="hidden" name="<portlet:namespace/>othersSpecify"/>	
	<input type="hidden" name="<portlet:namespace/>pickupLocation"/>
	<input type="hidden" name="<portlet:namespace/>pickupDate"/>
	<input type="hidden" name="<portlet:namespace/>dropoffLocation"/>
	<input type="hidden" name="<portlet:namespace/>dropoffDate"/>
	<input type="hidden" name="<portlet:namespace/>carType"/>
	<input type="hidden" name="<portlet:namespace/>typeOfRental"/>
	<input type="hidden" name="<portlet:namespace/>carPrice"/>
	<input type="hidden" name="<portlet:namespace/>carCurrency"/>		
	<aui:input type="hidden" name="totalCostRmb" value='<%=totalCostRmb%>'/>
	<aui:input type="hidden" name="totalCostEur" value='<%=totalCostEur%>'/>
	<aui:input type="hidden" name="hotelTotalCostRmb" value='<%=hotelTotalCostRmb%>'/>
	<aui:input type="hidden" name="hotelTotalCostEur" value='<%=hotelTotalCostEur%>'/>
	<aui:input type="hidden" name="carRentalTotalCostRmb" value='<%=carRentalTotalCostRmb%>'/>
	<aui:input type="hidden" name="carRentalTotalCostEur" value='<%=carRentalTotalCostEur%>'/>
	
	<aui:input type="hidden" name="isApplicantAgent"/>
	<aui:input type="hidden" name="staffCode"/>
	<aui:input type="hidden" name="approverId" value='<%=approverId%>'/>
	<aui:input type="hidden" name="approverName" value='<%=approverName%>'/>
	<aui:input type="hidden" name="evpId" value='<%=evpId%>'/>
	<aui:input type="hidden" name="evpName" value='<%=evpName%>'/>
	<aui:input type="hidden" name="otherEmails" value='<%=otherEmails%>'/>
	<aui:input type="hidden" name="isCrossDepartment" value='<%=isCrossDepartment%>'/>
	<aui:input type="hidden" name="targetDepartmentId" value='<%=targetDepartmentId%>'/>
	<aui:input type="hidden" name="targetDepartmentName" value='<%=targetDepartmentName%>'/>
	<aui:input type="hidden" name="targetCostCenter" value='<%=targetCostCenter%>'/>
	<aui:input type="hidden" name="targetDepartmentApproverId" value='<%=targetDepartmentApproverId%>'/>
	<aui:input type="hidden" name="targetDepartmentApproverName" value='<%=targetDepartmentApproverName%>'/>
	<aui:input type="hidden" name="tripType" value='<%=tt%>'/>
	<aui:input type="hidden" name="departureDate" value='<%=departureDate%>'/>
	<aui:input type="hidden" name="returnDate" value='<%=returnDate%>'/>
	<aui:input type="hidden" name="purposeOfTheTrip" value='<%=purposeOfTheTrip%>'/>
	<aui:input type="hidden" name="visitCountriesCities" value='<%=visitCountriesCities%>'/>
	<aui:input type="hidden" name="advancePayment" value='<%=advancePayment%>'/>
	<aui:input type="hidden" name="currency" value='<%=currency%>'/>
	<aui:input type="hidden" name="tripTypeAsForm"  id="tripTypeAsForm" />
</aui:form>

<div  id="showSB"  style="display:none">
		<%=showSB.toString() %>
</div>


<aui:script>

	//validata the cross department
	function validataCrossDepartment(){
		 var checkbox = document.getElementById('crossDepartment');//
		 var targetDepartmentApproverName=document.getElementById('targetDepartmentApproverName');//
		  if(checkbox.checked){
		    //éä¸­äº
		    if(targetDepartmentApproverName.value!=""){
		    	 return true;
		    }else{
		    	alert("please select Target Department");
		    	return false;
		    }
		  }
		 return true;
	}
	//validate the Advance Payment
	function validateAdvancePayment() {				
		if(document.<portlet:namespace />fm.<portlet:namespace />currency.value=='RMB') {
			if(parseFloat(document.<portlet:namespace />fm.<portlet:namespace />advancePayment.value)>parseFloat(document.<portlet:namespace />fm.<portlet:namespace />totalCostRmb.value)) {
				alert('Advance Payment cannot be larger than the total amount!');
				document.<portlet:namespace />fm.<portlet:namespace />advancePayment.focus();
				return false;
			}
		}else {
			if(parseFloat(document.<portlet:namespace />fm.<portlet:namespace />advancePayment.value)>parseFloat(document.<portlet:namespace />fm.<portlet:namespace />totalCostEur.value)) {
				alert('Advance Payment cannot be larger than the total amount!');
				document.<portlet:namespace />fm.<portlet:namespace />advancePayment.focus();
				return false;
			}
		}		
		return true;
	}
	
	function validateDepartureDate() {
		if(document.<portlet:namespace />fm.<portlet:namespace />departureDate.value=='') {
			alert("Please fill in departure date.");
			document.<portlet:namespace />fm.<portlet:namespace />departureDate.focus();
			return false;
		}
		var departureDate = document.getElementById('d4311').value;
		var arrys = departureDate.split('.');
		var depDate = new Date(arrys[2]+'-'+arrys[1]+'-'+arrys[0]).getTime();
		var now = new Date().getTime();
		var days = parseInt((depDate - now) / 1000 / 60 / 60 / 24);
		var paymentCurrencyApp=document.getElementById("paymentCurrencyApp").value;
		if(paymentCurrencyApp=='RMB' && days<3 && parseFloat(document.<portlet:namespace />fm.<portlet:namespace />advancePayment.value)>0) {
			alert("Based on travel expense advance payment policy control, the traveler can only apply cash advance 3 days in advance for RMB. You don't meet the requirement now. Please click 'Complete without Cash Advance'.");
			document.<portlet:namespace />fm.<portlet:namespace />advancePayment.value = 0;
			return false;
		}	
		if(paymentCurrencyApp=='EUR' && days<7 && parseFloat(document.<portlet:namespace />fm.<portlet:namespace />advancePayment.value)>0) {
			alert("Based on travel expense advance payment policy control, the traveler can only apply cash advance 7 days in advance for EUR. You don't meet the requirement now. Please click 'Complete without Cash Advance'.");
			document.<portlet:namespace />fm.<portlet:namespace />advancePayment.value = 0;
			return false;
		}	
		return true;
	}
	
	function validataTrip(){
		if(document.<portlet:namespace />fm.<portlet:namespace />departureDate.value=='') {
			alert("Please fill in departure date.");
			document.<portlet:namespace />fm.<portlet:namespace />departureDate.focus();
			return false;
		}
		if(document.<portlet:namespace />fm.<portlet:namespace />returnDate.value=='') {
			alert("Please fill in return date.");
			document.<portlet:namespace />fm.<portlet:namespace />returnDate.focus();
			return false;
		}
		 var radionum = document.getElementsByName("<portlet:namespace />tripType");
		 var  travelTypeVal=-1;
		 for(var i=0;i<radionum.length;i++){
			 if(radionum[i].checked){
				 travelTypeVal = radionum[i].value
			 } }
		if(travelTypeVal==-1){
			alert('Please select Travel Reservation');
			return false;
		}
		
		if(document.<portlet:namespace />fm.<portlet:namespace />purposeOfTheTrip.value=='') {
			alert("Please fill in purpose of the trip.");
			document.<portlet:namespace />fm.<portlet:namespace />purposeOfTheTrip.focus();
			return false;
		}
		if(document.<portlet:namespace />fm.<portlet:namespace />visitCountriesCities.value=='') {
			alert("Please fill in visit countries or cities.");
			document.<portlet:namespace />fm.<portlet:namespace />visitCountriesCities.focus();
			return false;
		}
		return true;
	}
	//When submit the form, there will be a workflow to enabled
	function <portlet:namespace />submitBusinessTripApplication() {
		if(!validataCrossDepartment()||!validateFileTypeAndSize() || !validateAdvancePayment()||!validataTrip()) {
			return false;
		} 	
		var paymentCurrencyApp=document.getElementById("paymentCurrencyApp");
		paymentCurrencyApp.disabled=false;
		document.<portlet:namespace />fm.<portlet:namespace />otherEmails.value=document.getElementById("<portlet:namespace />otherEmails").value;
		<portlet:namespace />setFileInfo();
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= Constants.PUBLISH %>";
		submitForm(document.<portlet:namespace />fm);	
	}
	
	//When submit the form, there will be a workflow to enabled
	function <portlet:namespace />updateBusinessTripApplication() {
		if(!validateDepartureDate()||!validataCrossDepartment()||!validateFileTypeAndSize() || !validateAdvancePayment()||!validataTrip()) {
			return false;
		} 	
		if(!parseFloat(document.<portlet:namespace />fm.<portlet:namespace />advancePayment.value)>0) {
			alert("When clicking 'Apply Cash Advance', the amount must be filled and can't be zero.");
			return false;
		}
		var fileNames = document.getElementsByName('<portlet:namespace/>fileName');
		var fileFlag = true;
		for(var i=0;i<fileNames.length;i++) {
			var obj_file = fileNames[i];
			var fileName = obj_file.value;
			if(fileName!=null && fileName !=""){
				fileFlag = false;
				break;
			}
		}	
		if(fileFlag) {
			alert("Please upload your itinerary attachment.");
			return false;
		}	
		var paymentCurrencyApp=document.getElementById("paymentCurrencyApp");
		paymentCurrencyApp.disabled=false;		
		document.<portlet:namespace />fm.<portlet:namespace />otherEmails.value=document.getElementById("<portlet:namespace />otherEmails").value;
		<portlet:namespace />setFileInfo();
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= Constants.PUBLISH %>";
		submitForm(document.<portlet:namespace />fm);	
	}
	
	//When submit the form, there will be a workflow to enabled
	function <portlet:namespace />closeBusinessTripApplication() {
		if(!validateDepartureDate()||!validataCrossDepartment()||!validateFileTypeAndSize() || !validateAdvancePayment()||!validataTrip()) {
			return false;
		} 	
		if(parseFloat(document.<portlet:namespace />fm.<portlet:namespace />advancePayment.value)>0) {
			alert("When clicking 'Complete without Cash Advance', the amount can't be filled.");
			return false;
		}
		var paymentCurrencyApp=document.getElementById("paymentCurrencyApp");
		paymentCurrencyApp.disabled=false;
		document.<portlet:namespace />fm.<portlet:namespace />otherEmails.value=document.getElementById("<portlet:namespace />otherEmails").value;
		<portlet:namespace />setFileInfo();
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= Constants.PUBLISH %>";
		document.<portlet:namespace />fm.<portlet:namespace />completeCmd.value = "Yes";
		submitForm(document.<portlet:namespace />fm);	
	}
	
	//Save the form data and not enable the workflow
	function <portlet:namespace />saveBusinessTripApplication() {
		if(!validataCrossDepartment()||!validateFileTypeAndSize() || !validateAdvancePayment()||!validataTrip()) {
			return false;
		} 
		var paymentCurrencyApp=document.getElementById("paymentCurrencyApp");
		paymentCurrencyApp.disabled=false;
		<portlet:namespace />setFileInfo();
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= isNew ? Constants.ADD : Constants.UPDATE %>";
		submitForm(document.<portlet:namespace />fm);
	}
	
	//Past the attachmentNames and fileNames values to portlet 
	function <portlet:namespace />setFileInfo() {
		var fileManagementFileNames = document.getElementsByName('<portlet:namespace/>fileManagementFileName');
		var fileManagementIds = document.getElementsByName('<portlet:namespace/>fileManagementId');
		var attachmentNames = document.getElementsByName('<portlet:namespace/>attachmentName');
		var existTitles = '';
		for(var i=0;i<fileManagementFileNames.length;i++) {
			var temp = fileManagementFileNames[i].value;
			if(temp==null || temp=='') {
				temp = 'XXX';
			}
			existTitles += temp+',';
		}
		document.<portlet:namespace />fm.<portlet:namespace />existTitles.value = existTitles;			
		
		var newTitles = '';
		for(var i=0;i<attachmentNames.length;i++) {
			var temp = attachmentNames[i].value;
			if(temp==null || temp=='') {
				temp = 'XXX';
			}
			newTitles += temp+',';
		}
		document.<portlet:namespace />fm.<portlet:namespace />newTitles.value = newTitles;		
		
		var existFileIds = '';
		for(var i=0;i<fileManagementIds.length;i++) {
			var temp = fileManagementIds[i].value;
			if(temp==null || temp=='') {
				temp = 'XXX';
			}
			existFileIds += temp+',';			
		}
		document.<portlet:namespace />fm.<portlet:namespace />existFileIds.value = existFileIds;	
	}
	
	//Download the attachments
	function <portlet:namespace />download(fileName,filePath) {
		var downloadUrl = '<%=downloadURL %>' + '&<portlet:namespace />cmd=download&<portlet:namespace />fileName='+fileName+'&<portlet:namespace />filePath='+filePath;		
		window.location.href = downloadUrl;
	}
	function <portlet:namespace/>deleteEmail(email){
		var otherEmails=document.getElementById("<portlet:namespace/>otherEmails").value;
		var arrEmails=otherEmails.split(",");
		for(var i in arrEmails){
			if(arrEmails[i]==email){
				arrEmails.splice(i,1)
			}
			}
			var otherEmails_=arrEmails.join(',');
			document.getElementById("<portlet:namespace/>otherEmails").value=otherEmails_;
			<portlet:namespace/>loopEmail();
	}
	//add Emails
	function <portlet:namespace/>addEmail(){
		var otherEmails=document.getElementById("<portlet:namespace/>otherEmails").value;
		var email=document.getElementById("<portlet:namespace/>emailSelect").value;
		if(email!=""){
			if(otherEmails.indexOf(email)!=-1){
				alert("Email address can not be repeated.");
				document.getElementById("<portlet:namespace/>emailSelect").focus();
				return;
			}
			if(otherEmails!=""){
				document.getElementById("<portlet:namespace/>otherEmails").value=otherEmails+","+email;
			}else{
				document.getElementById("<portlet:namespace/>otherEmails").value=email;
			}
			document.getElementById("<portlet:namespace/>emailSelect").value="";
			document.getElementById("<portlet:namespace/>emailSelect").focus();
		}else{
			alert("Please  fill in email address");
			document.getElementById("<portlet:namespace/>emailSelect").focus();
			return;
		}
		<portlet:namespace/>loopEmail();
	}
	
	function <portlet:namespace/>loopEmail(){
		var otherEmails=document.getElementById("<portlet:namespace/>otherEmails").value;
		var emailDiv = document.getElementById('<portlet:namespace/>emailDiv0');
		emailDiv.innerHTML="";
		if(otherEmails==","||otherEmails==""){
			otherEmails="";
			document.getElementById("<portlet:namespace/>otherEmails").value="";
			return;
		}
		var arrEmails=otherEmails.split(",");
		for(var i=0;i<arrEmails.length;i++){
			 var ul = document.createElement("ul");
			 ul.setAttribute("class", "std0");	
			 var li0 = document.createElement("li");
			 li0.setAttribute("class", "od02");	
			 li0.innerHTML=arrEmails[i];
		//	 var li1 = document.createElement("li");
		//	 li1.setAttribute("class", "od02");	
		//	 li1.innerHTML="vgcapon";
			 var li2 = document.createElement("li");
			 li2.setAttribute("class", "od01 lcol");	
			 var a2 = document.createElement("a");
			 a2.setAttribute("href", "#emaillist");	
			 a2.setAttribute("onclick", "<portlet:namespace/>deleteEmail('"+arrEmails[i]+"')");
			 a2.appendChild(document.createTextNode("<liferay-ui:message key='vgc.apon.button.delete' />"));
			 li2.appendChild(a2);
			 ul.appendChild(li0);
			 ul.appendChild(li2);
			 emailDiv.appendChild(ul);
		}
		
	}
	var now = new Date();
	var current_time = now.getDate()+"."+(now.getMonth()+1)+"."+now.getFullYear()+" "+now.getHours()+":"+now.getMinutes();
		
	//Add the file nodes
	function <portlet:namespace/>addFile() {    	  
		var fileDiv = document.getElementById('<portlet:namespace/>fileDiv');
		var o1 = document.createTextNode(' ');
		var o2= document.createTextNode(' ');
		var o3= document.createTextNode(' ');
		var o4 = document.createTextNode(' ');
		var o5 = document.createTextNode(' ');
		
		 var ul = document.createElement("ul");
		 ul.setAttribute("class", "std0");		 
		 var li0 = document.createElement("li");
		 li0.setAttribute("class", "od01");	
		 var input0 = document.createElement("input");
		 input0.setAttribute("type", "text");	
		 input0.setAttribute("name", "<portlet:namespace/>attachmentName");	
		 li0.appendChild(input0);		 
		 var li1 = document.createElement("li");
		 li1.setAttribute("class", "od02");	
		 var input1 = document.createElement("input");
		 input1.setAttribute("type", "file");	
		 input1.setAttribute("name", "<portlet:namespace/>fileName");	
		 li1.appendChild(input1);		
		 var li2 = document.createElement("li");
		 li2.setAttribute("class", "od01");	
		 var li3 = document.createElement("li");
		 li3.setAttribute("class", "od01 lcol");		 
		 var a0 = document.createElement("a");
		 a0.setAttribute("href", "#attachmentList");	
		 a0.setAttribute("onclick", "<portlet:namespace/>addFile()");
		 a0.appendChild(document.createTextNode("<liferay-ui:message key='vgc.apon.button.add' />"));
		 li3.appendChild(a0);
		 li3.appendChild(document.createTextNode("  "));
		 var a1 = document.createElement("a");
		 a1.setAttribute("href", "#attachmentList");	
		 a1.setAttribute("onclick", "<portlet:namespace/>removeFile(parentNode.parentNode)");
		 a1.appendChild(document.createTextNode("<liferay-ui:message key='vgc.apon.button.delete' />"));
		 li3.appendChild(a1);
		 ul.appendChild(o1);		 
		 ul.appendChild(li0);
		 ul.appendChild(o2);
		 ul.appendChild(li1);
		 ul.appendChild(o3);
		 ul.appendChild(li2);
		 ul.appendChild(o4);
		 ul.appendChild(li3);
		 ul.appendChild(o5);
		fileDiv.appendChild(ul);
		input0.focus();
	}
	
	//Remove the file nodes
	function <portlet:namespace/>removeFile(obj) {
		  var fileDiv = obj.parentNode;  
		  var count = fileDiv.childElementCount;
		  var ps = '<portlet:namespace/>';
		  if(count==1 && fileDiv.id==ps+'fileDiv') {
			  alert("This node can't delete.If you want to delete this node,please click add first, then you can delete it !");
			  return false;
		  }
		  fileDiv.removeChild(obj);   
	}
	
	//Validate the file type and size is right
	function validateFileTypeAndSize() {
		var fileNames = document.getElementsByName('<portlet:namespace/>fileName');
		var supportFileType = '<%=supportFileType%>';
		var supportFileSize = '<%=supportFileSize%>';
		var flag = true;
		//get the browser type
		var  browserCfg = {};  
        var ua = window.navigator.userAgent;  
        if (ua.indexOf("MSIE")>=1){  
            browserCfg.ie = true;  
        }else if(ua.indexOf("Firefox")>=1){  
            browserCfg.firefox = true;  
        }else if(ua.indexOf("Chrome")>=1){  
            browserCfg.chrome = true;  
        }  
		for(var i=0;i<fileNames.length;i++) {
			var obj_file = fileNames[i];
			var fileName = obj_file.value;
			if(fileName!=null && fileName !=""){
				var validateFileName;
				var index = fileName.lastIndexOf("\\");
				if(index>0){
					validateFileName = fileName.substring(index+1, fileName.lastIndexOf("."));
				}else{
				    validateFileName = fileName.substring(0, fileName.lastIndexOf("."));
				}
				if(!illegalChar(validateFileName)){
					return false;
				}
				var fileType = (fileName.substring(fileName.lastIndexOf(".")+1,fileName.length)).toLowerCase();
				if(supportFileType.indexOf(fileType, 0)==-1) {
					alert('Only support the '+supportFileType+' attachments!');
					flag = false;
					break;
				}
				var filesize = 0;
				if(browserCfg.firefox || browserCfg.chrome ){  
                    filesize = obj_file.files[0].size;  
                }else if(browserCfg.ie){  
                	//ie
                }
				if(filesize>1024*1024*supportFileSize) {
					alert('The Max attachments size is '+supportFileSize +'Mb!');
					flag = false;
					break;
				}
			}
		}
		return flag;
	}
	
	//format validation	
	function illegalChar(validateFileName){
			 var flag=true;
			 var reg=/[`~!@#\$%\^\&\*\(\)\+=<>,\?:"\{\}\\\|\/;'\[\]]/im;
			 var chineseCRT=/[\u4E00-\u9FA5\uF900-\uFA2D]/;
			 if(reg.test(validateFileName)||chineseCRT.test(validateFileName)){
				 flag=false;
				 alert("Please check your file name: "+validateFileName+", only include number, character,'.','space','-' and '_' ");
			 }
			 return flag;
		   }
	
	//When the employee is on behalf of the applicant,display the query button
	function <portlet:namespace />applicantAgentClick(obj) {
		document.<portlet:namespace />applicantAgentForm.<portlet:namespace />isApplicantAgent.value = obj.checked;
		submitForm(document.<portlet:namespace />applicantAgentForm);
	}
	
	//When cross the department,hidden the img of query
	function <portlet:namespace/>crossDepartment(obj) {
		if(obj.checked) {
			document.getElementById('targetU1').style.display='block';
			document.getElementById('targetU2').style.display='block';
		}else {
			document.getElementById('targetU1').style.display='none';
			document.getElementById('targetU2').style.display='none';
		}
	}
	
	//Parse the value to the Portlet method
	function <portlet:namespace/>passValueToPortlet() {
		if(document.<portlet:namespace />fm.<portlet:namespace />isApplicantAgent!=null && document.<portlet:namespace />fm.<portlet:namespace />isApplicantAgent.checked){
			document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />isApplicantAgent.value = 'true';
			document.<portlet:namespace />deleteDetailInfoForm.<portlet:namespace />isApplicantAgent.value = 'true';
		}else {
			document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />isApplicantAgent.value = 'false';
			document.<portlet:namespace />deleteDetailInfoForm.<portlet:namespace />isApplicantAgent.value = 'false';
		}
		var paymentCurrencyApp=document.getElementById("paymentCurrencyApp");
		paymentCurrencyApp.disabled=false;
		document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />staffCode.value = document.<portlet:namespace />fm.<portlet:namespace />staffCode.value;
		document.<portlet:namespace />deleteDetailInfoForm.<portlet:namespace />staffCode.value = document.<portlet:namespace />fm.<portlet:namespace />staffCode.value;
		document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />approverId.value = document.<portlet:namespace />fm.<portlet:namespace />approverId.value;
		document.<portlet:namespace />deleteDetailInfoForm.<portlet:namespace />approverId.value = document.<portlet:namespace />fm.<portlet:namespace />approverId.value;
		document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />approverName.value = document.<portlet:namespace />fm.<portlet:namespace />approverName.value;
		document.<portlet:namespace />deleteDetailInfoForm.<portlet:namespace />approverName.value = document.<portlet:namespace />fm.<portlet:namespace />approverName.value;
		
		document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />evpId.value = document.<portlet:namespace />fm.<portlet:namespace />evpId.value;
		document.<portlet:namespace />deleteDetailInfoForm.<portlet:namespace />evpId.value = document.<portlet:namespace />fm.<portlet:namespace />evpId.value;
		document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />evpName.value = document.<portlet:namespace />fm.<portlet:namespace />evpName.value;
		document.<portlet:namespace />deleteDetailInfoForm.<portlet:namespace />evpName.value = document.<portlet:namespace />fm.<portlet:namespace />evpName.value;
		document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />otherEmails.value = document.getElementById("<portlet:namespace />otherEmails").value;
		document.<portlet:namespace />deleteDetailInfoForm.<portlet:namespace />otherEmails.value = document.getElementById("<portlet:namespace />otherEmails").value;
		if(document.<portlet:namespace />fm.<portlet:namespace />isCrossDepartment.checked){
			document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />isCrossDepartment.value = 'true';
			document.<portlet:namespace />deleteDetailInfoForm.<portlet:namespace />isCrossDepartment.value = 'true';
		}else {
			document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />isCrossDepartment.value = 'false';
			document.<portlet:namespace />deleteDetailInfoForm.<portlet:namespace />isCrossDepartment.value = 'false';
		}
		document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />targetDepartmentId.value = document.<portlet:namespace />fm.<portlet:namespace />targetDepartmentId.value;
		document.<portlet:namespace />deleteDetailInfoForm.<portlet:namespace />targetDepartmentId.value = document.<portlet:namespace />fm.<portlet:namespace />targetDepartmentId.value;
		document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />targetDepartmentName.value = document.<portlet:namespace />fm.<portlet:namespace />targetDepartmentName.value;
		document.<portlet:namespace />deleteDetailInfoForm.<portlet:namespace />targetDepartmentName.value = document.<portlet:namespace />fm.<portlet:namespace />targetDepartmentName.value;
		document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />targetCostCenter.value = document.<portlet:namespace />fm.<portlet:namespace />targetCostCenter.value;
		document.<portlet:namespace />deleteDetailInfoForm.<portlet:namespace />targetCostCenter.value = document.<portlet:namespace />fm.<portlet:namespace />targetCostCenter.value;
		document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />targetDepartmentApproverId.value = document.<portlet:namespace />fm.<portlet:namespace />targetDepartmentApproverId.value;
		document.<portlet:namespace />deleteDetailInfoForm.<portlet:namespace />targetDepartmentApproverId.value = document.<portlet:namespace />fm.<portlet:namespace />targetDepartmentApproverId.value;
		document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />targetDepartmentApproverName.value = document.<portlet:namespace />fm.<portlet:namespace />targetDepartmentApproverName.value;
		document.<portlet:namespace />deleteDetailInfoForm.<portlet:namespace />targetDepartmentApproverName.value = document.<portlet:namespace />fm.<portlet:namespace />targetDepartmentApproverName.value;
		document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />tripType.value = document.<portlet:namespace />fm.<portlet:namespace />tripType.value;
		document.<portlet:namespace />deleteDetailInfoForm.<portlet:namespace />tripType.value = document.<portlet:namespace />fm.<portlet:namespace />tripType.value;
		 var radionum = document.getElementsByName("<portlet:namespace />tripType");
		 for(var i=0;i<radionum.length;i++){
			 if(radionum[i].checked){
				 document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />tripType.value =document.<portlet:namespace />fm.<portlet:namespace />tripType.value= radionum[i].value;
				 document.<portlet:namespace />deleteDetailInfoForm.<portlet:namespace />tripType.value =document.<portlet:namespace />fm.<portlet:namespace />tripType.value= radionum[i].value;
			 } }
		document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />departureDate.value = document.<portlet:namespace />fm.<portlet:namespace />departureDate.value;
		document.<portlet:namespace />deleteDetailInfoForm.<portlet:namespace />departureDate.value = document.<portlet:namespace />fm.<portlet:namespace />departureDate.value;
		document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />returnDate.value = document.<portlet:namespace />fm.<portlet:namespace />returnDate.value;
		document.<portlet:namespace />deleteDetailInfoForm.<portlet:namespace />returnDate.value = document.<portlet:namespace />fm.<portlet:namespace />returnDate.value;
		document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />purposeOfTheTrip.value = document.<portlet:namespace />fm.<portlet:namespace />purposeOfTheTrip.value;
		document.<portlet:namespace />deleteDetailInfoForm.<portlet:namespace />purposeOfTheTrip.value = document.<portlet:namespace />fm.<portlet:namespace />purposeOfTheTrip.value;
		document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />visitCountriesCities.value = document.<portlet:namespace />fm.<portlet:namespace />visitCountriesCities.value;
		document.<portlet:namespace />deleteDetailInfoForm.<portlet:namespace />visitCountriesCities.value = document.<portlet:namespace />fm.<portlet:namespace />visitCountriesCities.value;
		document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />advancePayment.value = document.<portlet:namespace />fm.<portlet:namespace />advancePayment.value;
		document.<portlet:namespace />deleteDetailInfoForm.<portlet:namespace />advancePayment.value = document.<portlet:namespace />fm.<portlet:namespace />advancePayment.value;
		document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />currency.value = document.<portlet:namespace />fm.<portlet:namespace />currency.value;
		document.<portlet:namespace />deleteDetailInfoForm.<portlet:namespace />currency.value = document.<portlet:namespace />fm.<portlet:namespace />currency.value;
	}
	
	//Update the detail info
	function <portlet:namespace/>update(updateUrl,tabs2) {
		var w = 1200;
		var h = 300;
		if(tabs2=='hotelInformation') {
			w = 1200;
			h = 550;
		}else if(tabs2=='carRental'){
			w = 1200;
			h = 400;			
		}
		Liferay.Util.selectEntity(
				{
					dialog: {
						constrain: true,
						modal: true,
						width:w,
						height:h
					},
					id: '<portlet:namespace />AddBusinessTripApplication',
					title: '<liferay-ui:message  key="vgc-apon-update"/>',
					uri:updateUrl
				},
				function(event) {
					document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />pkId.value = event.pkId;
					document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />tabs2.value = event.tabs2;
					
					 var radionum = document.getElementsByName("<portlet:namespace />tripType");
					 var  val=0;
					 for(var i=0;i<radionum.length;i++){
						 if(radionum[i].checked){
							 val = radionum[i].value
						 }
						 }
					document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />tripTypeAsForm.value =val ;
					
					var flag="0";
					if(event.tabs2=='flight') {
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />fromCity.value = event.fromCity;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />toCity.value = event.toCity;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />departureDate_.value = event.departureDate;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />departureFlight.value = event.departureFlight;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />classInfo.value = event.classInfo;
						if(event.fromCity==""){
							flag="1";
						}
					}else if(event.tabs2=='train') {
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />fromCity.value = event.fromCity;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />toCity.value = event.toCity;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />departureDate_.value = event.departureDate;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />departureTrain.value = event.departureTrain;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />classInfo.value = event.classInfo;
						if(event.fromCity==""){
							flag="1";
						}
					}else if(event.tabs2=='hotelInformation') {					
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />city.value = event.city;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />cityType.value = event.cityType;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />hotel.value = event.hotel;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />checkIn.value = event.checkIn;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />checkOut.value = event.checkOut;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />roomCategory.value = event.roomCategory;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />price.value = event.price;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />currency_.value = event.currency;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />isOverBudget.value = event.isOverBudget;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />otherReasonInfo.value = event.otherReasonInfo;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />isNotBookedFromTA.value = event.isNotBookedFromTA;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />othersSpecify.value = event.othersSpecify;
						if(event.city==""){
							flag="1";
						}
					}else if(event.tabs2=='carRental'){
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />pickupLocation.value = event.pickupLocation;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />pickupDate.value = event.pickupDate;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />dropoffLocation.value = event.dropoffLocation;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />dropoffDate.value = event.dropoffDate;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />carType.value = event.carType;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />typeOfRental.value = event.typeOfRental;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />carPrice.value = event.price;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />carCurrency.value = event.currency;
						if(event.pickupLocation==""){
							flag="1";
						}
					}
					<portlet:namespace/>passValueToPortlet();
					if(flag=="0"){
						submitForm(document.<portlet:namespace/>addDetailInfoFm);
					}
				}
			);
	}
</aui:script>

<aui:script use="liferay-search-container">
	var selectApproverLink = A.one('#selectApprover');
	if (selectApproverLink) {
		selectApproverLink.on(
			'click',
			function(event) {
				Liferay.Util.selectEntity(
					{
						dialog: {
							constrain: true,
							modal: true
						},
						id: '<portlet:namespace />selectApprover',
						title: '<liferay-ui:message key="vgc-apon-business-trip-application-select-approver-title" />',
						uri:'<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>"><portlet:param name="mvcPath" value="/html/businessTripApplication/select_approver.jsp" /></portlet:renderURL>'
					},
					function(event) {
						document.getElementById("approverId").value=event.approverId;
						document.getElementById("approverName").value=event.approverName;
					}
				);
			}
		);
	}
	
	var selectEvpLink = A.one('#selectEvp');
	if (selectEvpLink) {
		selectEvpLink.on(
			'click',
			function(event) {
				Liferay.Util.selectEntity(
					{
						dialog: {
							constrain: true,
							modal: true
						},
						id: '<portlet:namespace />selectEvp',
						title: '<liferay-ui:message key="vgc-apon-business-trip-application-select-evp-title" />',
						uri:'<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>"><portlet:param name="mvcPath" value="/html/businessTripApplication/select_evp.jsp" /></portlet:renderURL>'
					},
					function(event) {
						document.getElementById("evpId").value=event.evpId;
						document.getElementById("evpName").value=event.evpName;
					}
				);
			}
		);
	}
	
	
	
	var selectTargetDepartmentLink = A.one('#selectTargetDepartment');
	if (selectTargetDepartmentLink) {
		selectTargetDepartmentLink.on(
			'click',
			function(event) {
				Liferay.Util.selectEntity(
					{
						dialog: {
							constrain: true,
							modal: true
						},
						id: '<portlet:namespace />selectTargetDepartment',
						title: '<liferay-ui:message key="vgc-apon-business-trip-application-select-target-department-title" />',
						uri:'<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>"><portlet:param name="mvcPath" value="/html/businessTripApplication/select_target_department.jsp" /></portlet:renderURL>'
					},
					function(event) {
						document.getElementById("targetDepartmentId").value=event.targetDepartmentId;
						document.getElementById("targetDepartmentName").value=event.targetDepartmentName;
						document.getElementById("targetCostCenter").value=event.targetCostCenter;
						document.getElementById("targetDepartmentApproverId").value=event.targetDepartmentApproverId;
						document.getElementById("targetDepartmentApproverName").value=event.targetDepartmentApproverName;
					}
				);
			}
		);
	}
	
</aui:script>
<aui:script>

$(function(){
	var radios = document.getElementsByName("<portlet:namespace/>tripType");
	var val;
	for(var i=0;i<radios.length;i++){
		 if(radios[i].checked) {
			 val=radios[i].value;
			 CheckTripType(val);
		 }
	}
	<portlet:namespace/>loopEmail();
});

function getElementsClass(classnames) {
	var classobj = new Array();// å®ä¹æ°ç»

	var classint = 0;// å®ä¹æ°ç»çä¸æ 

	var tags = document.getElementsByTagName("li");// è·åHTMLçæææ ç­¾

	for ( var i in tags) {// å¯¹æ ç­¾è¿è¡éå

		if (tags[i].nodeType == 1) {// å¤æ­èç¹ç±»å

			if (tags[i].getAttribute("class") == classnames)// å¤æ­åéè¦CLASSåå­ç¸åçï¼å¹¶ç»æä¸ä¸ªæ°ç»

			{

				classobj[classint] = tags[i];

				classint++;

			}

		}

	}

	return classobj;// è¿åç»æçæ°ç»

}

function getElementsUlClass(classnames) {
	var classobj = new Array();// å®ä¹æ°ç»

	var classint = 0;// å®ä¹æ°ç»çä¸æ 

	var tags = document.getElementsByTagName("ul");// è·åHTMLçæææ ç­¾

	for ( var i in tags) {// å¯¹æ ç­¾è¿è¡éå

		if (tags[i].nodeType == 1) {// å¤æ­èç¹ç±»å

			if (tags[i].getAttribute("class") == classnames)// å¤æ­åéè¦CLASSåå­ç¸åçï¼å¹¶ç»æä¸ä¸ªæ°ç»

			{

				classobj[classint] = tags[i];

				classint++;

			}

		}

	}

	return classobj;// è¿åç»æçæ°ç»

}

function CheckTripType(val) {
	var navs = getElementsUlClass("nav nav-tabs")[0].getElementsByTagName('li');
	var paymentCurrencyApp = document.getElementById("paymentCurrencyApp");
	var hotelandcar = document.getElementById("hotelandcar");
	var car = document.getElementById("car");
	if (navs.length > 0) {
		var ali = navs[navs.length - 1];
		if (val == 0) {
			paymentCurrencyApp.value = "RMB";
			paymentCurrencyApp.disabled = true;
			if (ali.className == "tab active") {
				navs[0].getElementsByTagName('a')[0].click();
				// Liferay.Portal.Tabs.show('_businesstripapplication_WAR_vgcaponbusinesstripportlet_tabs111810399459711211111045981171151051101011151154511611410511245971121121081059997116105111110451021081051031041164510511010211111410997116105111110TabsId');
			}
			ali.style.display = "none";
			hotelandcar.style.display = "none";
			car.style.display = "none";
			document.getElementById("domf").color = "#FF0000"
			document.getElementById("intf").color = "#000000"
		} else if (val == 1) {
			paymentCurrencyApp.disabled = false;
			ali.style.display = "block";
			hotelandcar.style.display = "block";
			car.style.display = "block";
			 document.getElementById("intf").color = "#FF0000"
			 document.getElementById("domf").color = "#000000"
		}
	}

}
function loadPage() {

}
</aui:script>
<aui:script use="autocomplete-list,aui-base,aui-io-request-deprecated,autocomplete-filters,autocomplete-highlighters,datasource,datasource-get,datatable-datasource">

//Please note that this contact portlet service is a service builder generated JSON web service.
//We pass the groupId as a query param because our service expects it. Liferay has a nice javascript method for finding the group id.
var contactSearchDS = new A.DataSource.IO({source: '<%=completeURL%>'});

var contactSearchQueryTemplate = function(query) {
     // Here's an example on how to pass additional parameters to the query for you service
     // In our case we are fetching only the first 20 items and specify the ordering by name
	//var output = '&name='+query.trim()+'&sort=name&dir=asc&start=0&end=20';
     var output = '&<portlet:namespace/>emailSelect='+query.trim();
	return output;
}

var contactSearchLocator = function (response) {
	var responseData = A.JSON.parse(response[0].responseText);
//For debugging you can do: console.debug(responseData);
 	return responseData;
};

var contactSearchFormatter = function (query, results) {
	return A.Array.map(results, function (result) {
//For debugging: console.debug(result.raw);
		console.debug(result.raw);
		return '<strong>'+result.raw.value+'</strong><br/>'+result.raw.data.split("@")[0];
	});
};

var contactSearchTextLocator = function (result) {
//This is what we place in the input once the user selects an item from the autocomplete list.
//In our case we want to put contact full name in there.
	console.debug(result.data);
	return result.data;
};

var contactSearchInput = new A.AutoCompleteList({
	allowBrowserAutocomplete: 'false',
	resultHighlighter: 'phraseMatch',
	activateFirstItem: 'false',
	inputNode: '#<portlet:namespace/>emailSelect',
	render: 'true',
	source: contactSearchDS,
	requestTemplate: contactSearchQueryTemplate,
	resultListLocator: contactSearchLocator,
     resultFormatter: contactSearchFormatter,
	resultTextLocator: contactSearchTextLocator		
});

</aui:script>		
