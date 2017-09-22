

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
	SeatOffice seatOffice = null;
	long seatOfficeId = ParamUtil.getLong(request, "seatOfficeId");
	String transitionName = ParamUtil.getString(renderRequest, "transitionName", "");
	String isClickAgent = ParamUtil.getString(renderRequest, "isClickAgent","");
	long sCode = themeDisplay.getUser().getFacebookId();
	Date now = new Date();
	boolean flag = true;
	ApplicantDelegation applicantDelegation = ApplicantDelegationLocalServiceUtil.fetchByP_S(ApproverDelegationLocalServiceUtil.getProcessOfSeatOffice(),String.valueOf(sCode));
	boolean isHasAppliantAgent = applicantDelegation!=null && now.after(applicantDelegation.getEffectiveStartDate()) && now.before(applicantDelegation.getEffectiveEndDate())?true:false;
	String agentName = applicantDelegation!=null?ApplicantDelegationLocalServiceUtil.getAgentName(applicantDelegation):"";
	String prefixUrl = "/web"+themeDisplay.getScopeGroup().getFriendlyURL();	 
	String myApplicationsPageUrl = prefixUrl+PropsUtil.get("vgc.apon.my.applications.page.friendly.url");
	long myApplicationsPlid = PortalUtil.getPlidFromFriendlyURL(
	themeDisplay.getCompanyId(),myApplicationsPageUrl);
	if (seatOfficeId > 0) {
		seatOffice = SeatOfficeLocalServiceUtil.fetchSeatOffice(seatOfficeId);
		if(seatOffice!=null) {
				flag = false;
		}
		seatOffice = seatOffice!=null?seatOffice:SeatOfficeLocalServiceUtil.createSeatOffice(seatOfficeId);
	}else {
		seatOfficeId = CounterLocalServiceUtil.increment(SeatOffice.class.getName(),1);
		seatOffice = SeatOfficeLocalServiceUtil.createSeatOffice(seatOfficeId);
	}
	//Fetch the data from SAP
  if(flag) {
	  long staffCode = ParamUtil.getLong(renderRequest, "staffCode", 0);			
		staffCode=staffCode==0?themeDisplay.getUser().getFacebookId():staffCode;
		SAPUser sapUser = SAPUserLocalServiceUtil.getSapUserByStaffCode(String.valueOf(staffCode));		
		boolean isApplicantAgent = ParamUtil.getBoolean(renderRequest, "isApplicantAgent",false);	
		if(sapUser!=null) {
		seatOffice.setStaffCode(Long.valueOf(sapUser.getStaffCode()));
		//System.out.println("------staffCode2---"+sapUser.getStaffCode());	
		seatOffice.setStaffName(sapUser.getStaffName());
		seatOffice.setDivision(sapUser.getDivisionName());
		seatOffice.setDepartment(sapUser.getDepartmentName());
		seatOffice.setCompanyName(sapUser.getSapCompanyName());
		//seatOffice.setOfficeSite(OfficeSiteEnum.getIndex(sapUser.getOfficeSite()));
		seatOffice.setCostCenter(sapUser.getCostCener());
		seatOffice.setMobilePhone(sapUser.getCellPhone());
		seatOffice.setOfficePhone(sapUser.getContactNo());
		seatOffice.setContractType(sapUser.getEmployeeGroupId());
		seatOffice.setIsApplicantAgent(isApplicantAgent);
		if(sapUser.getOfficeSite()==null){
		seatOffice.setOfficeSite(OfficeSiteEnum.EMPTY.getIndex());
			}
		else{
		seatOffice.setOfficeSite(OfficeSiteEnum.getIndex(sapUser.getOfficeSite()));
			}
		WorkSpaceManagement workspace=WorkSpaceManagementLocalServiceUtil.findByStaffCode(String.valueOf(staffCode));
	if(null!=workspace){
		seatOffice.setCurrentCategory(SeatOfficeCategoryEnum.getNumber(workspace.getCategory()));
		seatOffice.setCurrentSeatNo(workspace.getSeatNo());
			}
		}
		
   }
  else {
		boolean isApplicantAgent = ParamUtil.getBoolean(renderRequest, "isApplicantAgent",true);
		if(isApplicantAgent!=seatOffice.getIsApplicantAgent()&& Validator.isNotNull(isClickAgent)) {	
			long staffCode = isApplicantAgent?ParamUtil.getLong(renderRequest, "staffCode", 0):themeDisplay.getUser().getFacebookId();
			staffCode = staffCode==0?seatOffice.getStaffCode():staffCode;
			SAPUser sapUser = SAPUserLocalServiceUtil.getSapUserByStaffCode(String.valueOf(staffCode));			
			if(sapUser!=null) {
				seatOffice.setStaffCode(Long.valueOf(sapUser.getStaffCode()));
				//System.out.println("------staffCode2---"+sapUser.getStaffCode());	
				seatOffice.setStaffName(sapUser.getStaffName());
				seatOffice.setDivision(sapUser.getDivisionName());
				seatOffice.setDepartment(sapUser.getDepartmentName());
				seatOffice.setCompanyName(sapUser.getSapCompanyName());
				//seatOffice.setOfficeSite(OfficeSiteEnum.getIndex(sapUser.getOfficeSite()));
				seatOffice.setCostCenter(sapUser.getCostCener());
				seatOffice.setMobilePhone(sapUser.getCellPhone());
				seatOffice.setOfficePhone(sapUser.getContactNo());
				seatOffice.setContractType(sapUser.getEmployeeGroupId());
				seatOffice.setIsApplicantAgent(isApplicantAgent);
				if(sapUser.getOfficeSite()==null){
					seatOffice.setOfficeSite(OfficeSiteEnum.EMPTY.getIndex());
				}
				else{
				seatOffice.setOfficeSite(OfficeSiteEnum.getIndex(sapUser.getOfficeSite()));
				}
				WorkSpaceManagement workspace=WorkSpaceManagementLocalServiceUtil.findByStaffCode(String.valueOf(staffCode));
				if(null!=workspace){
					
					seatOffice.setCurrentCategory(SeatOfficeCategoryEnum.getNumber(workspace.getCategory()));
					seatOffice.setCurrentSeatNo(workspace.getSeatNo());
						}
					}			
		}	
	}	
	PortletURL portletURL = renderResponse.createRenderURL();
	List<AuditTrailLog> auditTrailLogs = AuditTrailLogLocalServiceUtil.findAuditTrailByWF_O_O(seatOfficeId,SeatOffice.class.getName());
	List<FileManagement> fileManagements = FileManagementLocalServiceUtil.getByAssetClassNameAndAssetPrimaryKey(SeatOffice.class.getName(),seatOfficeId);
%>

<portlet:actionURL var="addSeatOfficeURL" windowState="normal" />

<liferay-portlet:renderURL var="myApplicationsURL"
	plid="<%=myApplicationsPlid%>"
	portletName='<%=PropsUtil.get("vgc.apon.my.applications.portletId")%>'
	windowState="normal">
</liferay-portlet:renderURL>

<aui:model-context bean="<%=seatOffice%>" model="<%=SeatOffice.class%>" />

<aui:script>
//validate the field is not null
function validateNotNull(inputId, tdIndex) {
	
	var portletNamespace = '<portlet:namespace/>';
	var inputElement = document.getElementsByName(portletNamespace + inputId)
			.item(0);
	var trNode = inputElement.parentNode.parentNode;
	var inputLabel = trNode.childNodes[tdIndex].innerHTML;
	inputLabel = inputLabel.substring(0, inputLabel.lastIndexOf(':'));
	var prefix = '<liferay-ui:message key="vgc.apon.please.fill.the" />';
	if (inputElement.value == null || inputElement.value == ''||inputElement.value.replace(/\n|\r|\t/g, '')=='') {
		alert(prefix +" "+ inputLabel.replace(/^\s+|\s+$/g, '')+"!");
		inputElement.focus();
		return false;
	} else {
		return true;
	}
}
function validateCurrentNotNull(inputId, tdIndex) {
	//alert(inputId);
	//alert(tdIndex);
	var portletNamespace = '<portlet:namespace/>';
	var inputElement = document.getElementsByName(portletNamespace + inputId)
			.item(0);
	var trNode = inputElement.parentNode.parentNode;
	var inputLabel = trNode.childNodes[tdIndex].innerHTML;
	//alert(inputLabel);
	//alert(inputElement.value);
	if (inputElement.value == null || inputElement.value == ''||inputElement.value.replace(/\n|\r|\t/g, '')=='') {
		alert("Your seat information is not well maintained in APON system. Please contact Admin Seat Management Team for question and support.");
		//inputElement.focus();
		return false;
	} else {
		return true;
	}
}
	//When submit the form, there will be a workflow to enabled
	function <portlet:namespace />submitSeatOffice() {
		if(!validateNotNull('movingDate',1)){
			return false;
		}
		if(!validateCurrentNotNull('currentCategory',1)){
			return false;
		}
		if(!validateCurrentNotNull('currentSeatNo',5)){
			return false;
		}
		document.<portlet:namespace />fm1.<portlet:namespace /><%= Constants.CMD %>.value = "<%= Constants.PUBLISH %>";
		submitForm(document.<portlet:namespace />fm1);	
	}
	
	//Save the form data and not enable the workflow
	function <portlet:namespace />saveSeatOffice() {
		document.<portlet:namespace />fm1.<portlet:namespace /><%= Constants.CMD %>.value = "<%= (seatOffice == null || seatOffice.getSeatId()==0 ) ? Constants.ADD : Constants.UPDATE %>";
		submitForm(document.<portlet:namespace />fm1);
	}
	
	//When the employee is on behalf of the applicant,display the query button
	function <portlet:namespace />applicantAgentClick(obj) {
		document.<portlet:namespace />applicantAgentForm.<portlet:namespace />isApplicantAgent.value = obj.checked;
		submitForm(document.<portlet:namespace />applicantAgentForm);
	}
</aui:script>
	


<!--  seat&office moving applicant page -->
<portlet:actionURL name="applicantAgent" var="applicantAgentURL" >
	<portlet:param name="mvcPath" value="/html/seatoffice/view.jsp"/>
	<portlet:param name="<%=Constants.CMD%>" value="applicantAgent"/>
</portlet:actionURL>

<aui:form action="<%=applicantAgentURL%>" method="post" name="applicantAgentForm">
	<aui:fieldset>
		<aui:input name="seatOfficeId" type="hidden" value="<%=seatOfficeId %>"/>
		<aui:input name="isApplicantAgent" type="hidden" />
	</aui:fieldset>
</aui:form>
<aui:form name="fm1" method="POST" action="<%=addSeatOfficeURL%>">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="<%=redirect%>" />
		<aui:input name="<%=Constants.CMD%>" type="hidden" />
		<aui:input type="hidden" name="seatOfficeId" value='<%=seatOfficeId%>'
			id="seatOfficeId" />
		<aui:input type="hidden" name="transitionName"
			value='<%=transitionName%>' />
		<aui:input type="hidden" name="existTitles" />
		<aui:input type="hidden" name="newTitles" />

	</aui:fieldset>

	<div class="mainbody">
		<div class="topButton">
			<aui:button-row>
				<aui:button type="button" value="vgc.apon.seatOffice.draft"
					onClick='<%= renderResponse.getNamespace() + "saveSeatOffice()" %>' />
				<aui:button type="button" value="vgc.apon.seatOffice.submit"
					onClick='<%= renderResponse.getNamespace() + "submitSeatOffice()" %>' />
				<aui:button type="cancel" value="vgc.apon.seatOffice.back"
					onClick='<%= myApplicationsURL %>' />
			</aui:button-row>
		</div>
		<div class="tabTitle">
			<h3>
				<liferay-ui:message key="vgc.apon.seatOffice.title" />
			</h3>
			<div class="Ltext"></div>
			<div class="tickerNo">
				<liferay-ui:message key="vgc.apon.seatOffice.ticketno" />
				<span class="num"><%=seatOffice.getTicketNo()%></span>
			</div>
			<div class="clear"></div>
		</div>
		<div class="gernal employeeInfo">
			<div class="subtitle">
				<liferay-ui:message key="vgc.apon.seatOffice.subtitle" />			
			<%if(isHasAppliantAgent){%>
			<input type="checkbox" name="<portlet:namespace/>isApplicantAgent" value='<%=true %>' 
			<%=seatOffice.getIsApplicantAgent()?"checked='checked'":"" %>
			onclick='<%=renderResponse.getNamespace() + "applicantAgentClick(this)"%>'/>
			<liferay-ui:message key="vgc-apon-on-behalf-of-x" arguments="<%=agentName %>"/>
			<%}%>
			</div>

			<ul>
				<li class="md01"><liferay-ui:message
						key="vgc.apon.seatOffice.staffName" /></li>
				<li class="md02"><input type="text"
					name="<portlet:namespace/>staffName" disabled="disabled"
					maxlength="75" value="<%=seatOffice.getStaffName()%>"></li>
				<li class="md01"><liferay-ui:message
						key="vgc.apon.seatOffice.staffCode" /></li>
				<li class="md022"><input type="text"
					name="<portlet:namespace/>staffCode" readOnly="readOnly"
					maxlength="75" id="<portlet:namespace/>staffCode"
					value="<%=seatOffice.getStaffCode()%>"></li>
			</ul>
			<ul>
				<li class="md01"><liferay-ui:message
						key="vgc.apon.seatOffice.company" /></li>
				<li class="md02"><input type="text"
					name="<portlet:namespace/>companyName" maxlength="75"
					value='<%=seatOffice.getCompanyName()%>' disabled="disabled">
				</li>
				<li class="md01"><liferay-ui:message
						key="vgc.apon.seatOffice.division" /></li>
				<li class="md022"><input type="text"
					name="<portlet:namespace/>division" disabled="disabled"
					maxlength="75" value="<%=seatOffice.getDivision()%>"></li>
			</ul>
			<ul>
				<li class="md01"><liferay-ui:message
						key="vgc.apon.seatOffice.department" /></li>
				<li class="md02"><input type="text"
					name="<portlet:namespace/>department" disabled="disabled"
					maxlength="75" value="<%=seatOffice.getDepartment()%>"></li>
				<li class="md01"><liferay-ui:message
						key="vgc.apon.seatOffice.costCenter" /></li>
				<li class="md022"><input type="text"
					name="<portlet:namespace/>costCenter" disabled="disabled"
					maxlength="75" value="<%=seatOffice.getCostCenter()%>"></li>
			</ul>

			<ul>
				<li class="md01"><liferay-ui:message
						key="vgc.apon.seatOffice.contractType" /></li>
				<li class="md02"><input type="text" maxlength="75"
					name="<portlet:namespace/>contractType" disabled="disabled"
					value="<%=ContractTypeEnum.getName(seatOffice.getContractType())%>" /></li>

				<li class="md01"><liferay-ui:message
						key="vgc.apon.seatOffice.officeSite" /></li>
				<li class="md022"><input type="text"
					name="<portlet:namespace/>officeSite" disabled="disabled"
					maxlength="75" value="<%=OfficeSiteEnum.getName(seatOffice.getOfficeSite())%>"></li>
			</ul>
			<ul>
				<li class="md01"><liferay-ui:message
						key="vgc.apon.seatOffice.mobilePhone" /></li>
				<li class="md02"><input type="text"
					id="<portlet:namespace/>mobilePhone" maxlength="75"
					name="<portlet:namespace/>mobilePhone"
					value="<%=seatOffice.getMobilePhone()%>" required="required"></li>
				<li class="md01"><liferay-ui:message
						key="vgc.apon.seatOffice.officePhone" /></li>
				<li class="md022"><input type="text"
					name="<portlet:namespace/>officePhone" maxlength="75"
					value="<%=seatOffice.getOfficePhone()%>" required="required" /></li>
			</ul>
			<ul>
				<li class="md01"><liferay-ui:message
						key="vgc.apon.seatOffice.currentCategory" /></li>
				<li class="md02"><input type="text"
					id="<portlet:namespace/>currentCategory" maxlength="75"
					name="<portlet:namespace/>currentCategory" disabled="disabled"
					value="<%=SeatOfficeCategoryEnum.getCategory((seatOffice.getCurrentCategory()))%>" required="required"></li>
				<li class="md01"><liferay-ui:message
						key="vgc.apon.seatOffice.currentSeatNo" /></li>
				<li class="md022"><input type="text"
					name="<portlet:namespace/>currentSeatNo" maxlength="75"
					disabled="disabled" value="<%=seatOffice.getCurrentSeatNo()%>"
					required="required" /></li>
			</ul>
			<ul>
				<li class="md01"><liferay-ui:message
						key="vgc.apon.seatOffice.movingDate" /></li>
				<li class="md02"><input id="<portlet:namespace/>movingDate"
					class="Wdate" type="text" name="<portlet:namespace/>movingDate"
					value="<%=seatOffice.getMovingDate()!=null?sdf_dmy.format(seatOffice.getMovingDate()) : ""%>"
					onFocus="WdatePicker({lang:'en',dateFmt:'dd.MM.yyyy'})"
					required="required" />
				<li class="md01"><liferay-ui:message
						key="vgc.apon.seatOffice.expectedSeatNo" /></li>
				<li class="md022"><input type="text"
					name="<portlet:namespace/>expectedSeatNo" maxlength="75"
					value="<%=seatOffice.getExpectedSeatNo()%>" required="required" /></li>
			</ul>
			<!-- <ul>
				<li class="md01"><liferay-ui:message
						key="vgc.apon.seatOffice.newCategory" /></li>
				<li class="md02"><input type="text" id="SetNewCategory"
					name="<portlet:namespace/>newCategory" maxlength="75" readOnly="readOnly"
					value="<%=seatOffice.getNowCategory()%>" required="required" /></li>
				<li class="md01"><liferay-ui:message
						key="vgc.apon.seatOffice.newSeatNo" /></li>
				<li class="md022"><input type="text" id="SetNewSeatNo"
					name="<portlet:namespace/>newSeatNo"
					value="<%=seatOffice.getNewSeatNo()%>" readonly="readonly">
					<liferay-ui:icon id="selectNewSeatNoTo" label="<%=true%>"
						message="" method="get" url="javascript:;"
						src='<%=themeDisplay.getPathThemeImages()+"/common/search.png"%>' />
				</li>
			</ul> 
			<ul>
				<li class="md01"></li>
				<li class="md03 "  style="font-style: italic;"><liferay-ui:message
						key="vgc.apon.seatOffice.remarksDesc" /></li>
			</ul>-->
			<ul>
				<li class="md01"><liferay-ui:message
						key="vgc.apon.seatOffice.reason" /></li>
			</ul>

			<ul class="txt">
				<li><textarea rows="4" maxlength="250" style="width:1078px;"
						name="<portlet:namespace/>reason" required="required"
						style="font-style: italic;"><%=seatOffice.getReasonForChange()%></textarea>
				</li>
			</ul>
		</div>
		<div class="gernal employeeInfo" style="padding-bottom:0;">
			<div class="subtitle" style="margin-bottom:0;">
				<liferay-ui:message key="vgc.apon.seatOffice.specificRequirement" />
			</div>
			<ul>
				<li class="mdd01" style="font-weight: 500; border-right: 1px solid rgb(228, 228, 229); height: 100px; line-height: 100px; padding-right: 20px; margin-right: 10px;"><liferay-ui:message
						key="vgc.apon.seatOffice.requirementType" /></li>
				<li style="width: 900px;height:100px;">
				<ul style="vertical-align: bottom; display: inline-block; padding: 0px 0px 0px 10px;">
				    <li style="display: inline-block; padding-top: 10px; height: 34px; line-height: 34px; overflow: hidden; vertical-align: top; width: 200px;"><input type="checkbox"
					<%=seatOffice.getOfficeKey()== true ? "checked='checked'": ""%>
					name="<portlet:namespace/>officeKey" /> <liferay-ui:message
						key="vgc.apon.seatOffice.officeKey" /> </li>
					<li style="display: inline-block; padding-top: 10px; height: 34px; line-height: 34px; overflow: hidden; vertical-align: top; width: 200px;"><input type="checkbox"
					<%=seatOffice.getPlant()== true ? "checked='checked'": ""%>
					name="<portlet:namespace/>plant" /> <liferay-ui:message
						key="vgc.apon.seatOffice.plant" /> </li>
					<li style="display: inline-block; padding-top: 10px; height: 34px; line-height: 34px; overflow: hidden; vertical-align: top; width: 200px;"><input type="checkbox"
					<%=seatOffice.getTelephoneAndExtNo()== true ? "checked='checked'": ""%>
					name="<portlet:namespace/>tel" /> <liferay-ui:message
						key="vgc.apon.seatOffice.tel" /></li>
				</ul>
				<ul style="vertical-align: bottom; display: inline-block; padding: 0px 0px 0px 10px;">
				
				<li style="display: inline-block; padding-top: 10px; height: 34px; line-height: 34px; overflow: hidden; vertical-align: top; width: 200px;"><input type="checkbox"
					<%=seatOffice.getNamePlate()== true ? "checked='checked'": ""%>
					name="<portlet:namespace/>namePlate" /> <liferay-ui:message
						key="vgc.apon.seatOffice.namePlate" /> </li>
				<li style="display: inline-block; padding-top: 10px; height: 34px; line-height: 34px; overflow: hidden; vertical-align: top; width: 200px;"><input type="checkbox"
					<%=seatOffice.getCabinet()== true ? "checked='checked'": ""%>
					name="<portlet:namespace/>cabinet" /> <liferay-ui:message
						key="vgc.apon.seatOffice.cabinet" /></li>
				</ul>
				</li>
			</ul>

		</div>
 <div>
     
			<p style="font-style: italic;"><liferay-ui:message key="vgc.apon.seatOffice.remarks" /></p>
			<p style="font-style: italic;"><liferay-ui:message key="vgc.apon.seatOffice.desc1" /></p>
			<p style="font-style: italic;"><liferay-ui:message key="vgc.apon.seatOffice.desc2" />
			</p>
			<p style="font-style: italic;"><liferay-ui:message key="vgc.apon.seatOffice.desc3" />
				<a style="font-weight:bold;color:#0000cd; font-style: italic; text-decoration:underline" target="_blank" href="http://portal.vcic.ap.vwg/office-service">
				   <liferay-ui:message key="vgc.apon.seatOffice.desc4" /></a>
			</p>
		    <p style="font-style: italic;"><liferay-ui:message key="vgc.apon.seatOffice.desc5" />
		      
		</div>
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
		<div class="topButton">
			<aui:button-row>
				<aui:button type="button" value="vgc.apon.seatOffice.draft"
					onClick='<%= renderResponse.getNamespace() + "saveSeatOffice()" %>' />
				<aui:button type="button" value="vgc.apon.seatOffice.submit"
					onClick='<%= renderResponse.getNamespace() + "submitSeatOffice()" %>' />
				<aui:button type="cancel" value="vgc.apon.seatOffice.back"
					onClick='<%= myApplicationsURL %>' />
			</aui:button-row>
		</div>
	</div>



</aui:form>
<aui:script use="liferay-search-container">
var selectSeatNOLink = A.one('#<portlet:namespace />selectNewSeatNoTo');
if (selectSeatNOLink) {
	selectSeatNOLink.on(
		'click',
		function(event) {
			Liferay.Util.selectEntity(
				{
					dialog: {
						constrain: true,
						modal: true
					},
					id: '<portlet:namespace />selectNewSeatNo',
					title: '<liferay-ui:message arguments="vgc.apon.seatOffice.seletWorkspace" key="select-x" />',
					uri:'<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>"><portlet:param name="mvcPath" value="/html/admin/Select_SeatOffice.jsp" /></portlet:renderURL>'
					
				},
				function(event) {
					document.getElementById("SetNewCategory").value=event.category;
					document.getElementById("SetNewSeatNo").value=event.seatNo;
					
				}
			);
		}
	);
}
</aui:script>