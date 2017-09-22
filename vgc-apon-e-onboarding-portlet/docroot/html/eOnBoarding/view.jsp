
<%@include file="/html/init.jsp"%>

<%
EOnBoarding eOnBoarding=null;
long eOnBoardingId=ParamUtil.getLong(renderRequest, "eOnBoardingId",0);
if(eOnBoardingId==0) {
	eOnBoardingId = request.getAttribute("eOnBoardingId")!=null?(Long)request.getAttribute("eOnBoardingId"):0;
} 
boolean isNew=true;
if(eOnBoardingId>0){
	eOnBoarding=EOnBoardingLocalServiceUtil.fetchEOnBoarding(eOnBoardingId);
	if(eOnBoarding!=null) {
		isNew=false;
	}else {	
		eOnBoarding=EOnBoardingLocalServiceUtil.createEOnBoarding(eOnBoardingId);	
		eOnBoarding.setItRelatedHardware(true);
	}
}else{
	eOnBoardingId = CounterLocalServiceUtil.increment(EOnBoarding.class.getName(),1);
	eOnBoarding=EOnBoardingLocalServiceUtil.createEOnBoarding(eOnBoardingId);
	eOnBoarding.setItRelatedHardware(true);
}
if(request.getAttribute("isApplicantAgent")!=null) {
	eOnBoarding.setIsApplicantAgent((Boolean)request.getAttribute("isApplicantAgent"));
}

long sCode = themeDisplay.getUser().getFacebookId();
Date now = new Date();
ApplicantDelegation applicantDelegation = ApplicantDelegationLocalServiceUtil.fetchByP_S(ApproverDelegationLocalServiceUtil.getProcessOfEOnboarding(),String.valueOf(sCode));
boolean isHasAppliantAgent = applicantDelegation!=null && now.after(applicantDelegation.getEffectiveStartDate()) && now.before(applicantDelegation.getEffectiveEndDate())?true:false;
String agentName = applicantDelegation!=null?ApplicantDelegationLocalServiceUtil.getAgentName(applicantDelegation):"";

SAPUser sapUser=renderRequest.getAttribute("sapUser")!=null?(SAPUser)renderRequest.getAttribute("sapUser"):null;
if(sapUser!=null&&eOnBoarding!=null && isNew){
	eOnBoarding.setStaffCode(sapUser.getStaffCode());
	eOnBoarding.setTitle(sapUser.getTitle());
	eOnBoarding.setLastName(sapUser.getLastName());
	eOnBoarding.setFirstName(sapUser.getFirstName());
	eOnBoarding.setName(sapUser.getChineseName());
	eOnBoarding.setBirthday(sapUser.getBirthday());	
	eOnBoarding.setContractType(sapUser.getEmployeeGroupId());
	eOnBoarding.setDivision(sapUser.getDivisionName());
	eOnBoarding.setDepartment(sapUser.getDepartmentName());
	eOnBoarding.setPositionCode(sapUser.getPositionId());
	eOnBoarding.setFunctionName(sapUser.getPositionName());
	eOnBoarding.setCostCenter(sapUser.getCostCener());
	eOnBoarding.setWorkLocation(sapUser.getWorkLocation());
	eOnBoarding.setOfficeSite(sapUser.getOfficeSite());
	eOnBoarding.setReportTo(sapUser.getReportToSupervisiorName());
	eOnBoarding.setGender(sapUser.getGender());
	eOnBoarding.setContractType(ContractTypeEnum.getName(sapUser.getEmployeeGroupId()));
	eOnBoarding.setStartingDate(sapUser.getHiringDate());
	eOnBoarding.setReportTo(sapUser.getReportToSupervisorId());
	eOnBoarding.setReportToStaffName(sapUser.getReportToSupervisiorName());
	eOnBoarding.setServiceLength(sapUser.getContractEndDate()!=null?sdf_dmy.format(sapUser.getContractEndDate()):"");
}
String readonly = "";
String disabled = "";
if(Validator.isNotNull(eOnBoarding.getStaffCode()) || true) {
	readonly = "readonly='readonly'";
	disabled = "disabled='disabled'";
}

if(isNew){
	boolean companyCar = false; 
	if("FSE".equals(eOnBoarding.getContractType())) {
		companyCar = true;
	}else {
		if(sapUser!=null && ("LOCAL".equals(eOnBoarding.getContractType()) || "LE".equals(eOnBoarding.getContractType())) && EmployeeSubGroupIDPersonalGradeEnum.getPgEnum(sapUser.getEmployeeSubgroupId()).compareTo(EmployeeSubGroupIDPersonalGradeEnum.PG3)>0) {
			companyCar = true;
		}
	}
	eOnBoarding.setCompanyCar(companyCar);
}

PortletURL portletURL=renderResponse.createRenderURL();
String checkImagePath = themeDisplay.getPathThemeImages()+"/common/check.png";
String searchImagePath=themeDisplay.getPathThemeImages()+"/common/search.png";

String photoPath = eOnBoarding.getPhotoPath();

String prefixUrl = "/web"+themeDisplay.getScopeGroup().getFriendlyURL();	 
String myApplicationsPageUrl = prefixUrl+PropsUtil.get("vgc.apon.my.applications.page.friendly.url");
long myApplicationsPlid = PortalUtil.getPlidFromFriendlyURL(themeDisplay.getCompanyId(),myApplicationsPageUrl);
String transitionName = ParamUtil.getString(renderRequest, "transitionName", "");
List<AuditTrailLog> auditTrailLogs = AuditTrailLogLocalServiceUtil.findAuditTrailByWF_O_O(eOnBoardingId, EOnBoarding.class.getName());
%>

<aui:script>
	function <portlet:namespace />submitEOnBoarding() {
		if(!validateNotNull('staffCode',1)||!validateNotNull('lastName',1)||!validateNotNull('firstName',1)
				||!validateNotNull('gender',1)||!validateNotNull('birthday',1)
				||!validateNotNull('contractType',1)||!validateNotNull('workLocation',5)||!validateNotNull('division',1)
				||!validateNotNull('officeSite',5)||!validateNotNull('startingDate',5)
				||!validateNotNull('functionName',1)
				||!validateNotNull('title',1)||!validateNotNull('costCenter',5)) {
			return false;
		}
		document.<portlet:namespace />fm.<portlet:namespace />contractType2.value = document.<portlet:namespace />fm.<portlet:namespace />contractType.value;
		document.<portlet:namespace />fm.<portlet:namespace />workLocation2.value = document.<portlet:namespace />fm.<portlet:namespace />workLocation.value;
		document.<portlet:namespace />fm.<portlet:namespace />officeSite2.value = document.<portlet:namespace />fm.<portlet:namespace />officeSite.value;
		if(document.<portlet:namespace />fm.<portlet:namespace />companyCar0.checked){
			document.<portlet:namespace />fm.<portlet:namespace />companyCar2.value = true;
		}else {
			document.<portlet:namespace />fm.<portlet:namespace />companyCar2.value = false;
		}
		document.<portlet:namespace />fm.<portlet:namespace />reportToStaffName2.value = document.<portlet:namespace />fm.<portlet:namespace />reportToStaffName.value;
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= Constants.PUBLISH %>";
		submitForm(document.<portlet:namespace />fm);	
	}
	
	function <portlet:namespace />saveEOnBoarding() {
		if(!validateNotNull('staffCode',1)||!validateNotNull('lastName',1)||!validateNotNull('firstName',1)
				||!validateNotNull('gender',1)||!validateNotNull('birthday',1)
				||!validateNotNull('contractType',1)||!validateNotNull('workLocation',5)||!validateNotNull('division',1)
				||!validateNotNull('officeSite',5)||!validateNotNull('startingDate',5)
				||!validateNotNull('functionName',1)
				||!validateNotNull('title',1)||!validateNotNull('costCenter',5)) {
			return false;
		}
		document.<portlet:namespace />fm.<portlet:namespace />contractType2.value = document.<portlet:namespace />fm.<portlet:namespace />contractType.value;
		document.<portlet:namespace />fm.<portlet:namespace />workLocation2.value = document.<portlet:namespace />fm.<portlet:namespace />workLocation.value;
		document.<portlet:namespace />fm.<portlet:namespace />officeSite2.value = document.<portlet:namespace />fm.<portlet:namespace />officeSite.value;
		if(document.<portlet:namespace />fm.<portlet:namespace />companyCar0.checked){
			document.<portlet:namespace />fm.<portlet:namespace />companyCar2.value = true;
		}else {
			document.<portlet:namespace />fm.<portlet:namespace />companyCar2.value = false;
		}
		//alert("companyCar2="+document.<portlet:namespace />fm.<portlet:namespace />companyCar2.value);
		document.<portlet:namespace />fm.<portlet:namespace />reportToStaffName2.value = document.<portlet:namespace />fm.<portlet:namespace />reportToStaffName.value;
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= (eOnBoarding == null || eOnBoarding.getEOnBoardingId()==0 ) ? Constants.ADD : Constants.UPDATE %>";
		submitForm(document.<portlet:namespace />fm);		
	}
	
	//validate the field is not null
	function validateNotNull(inputId, tdIndex) {
		var portletNamespace = '<portlet:namespace/>';
		var inputElement = document.getElementsByName(portletNamespace + inputId).item(0);
		var trNode = inputElement.parentNode.parentNode;
		var inputLabel = trNode.childNodes[tdIndex].innerHTML;
		inputLabel = inputLabel.substring(0, inputLabel.lastIndexOf('*'));
		var prefix = '<liferay-ui:message key="vgc.apon.please.fill.the" />';
		if (inputElement.value == null || inputElement.value == '') {
			alert(prefix +" "+ inputLabel+"!");
			inputElement.focus();
			return false;
		} else {
			return true;
		}
	}	
	
	function <portlet:namespace/>searchSAPUser(){
		var staffCode=document.<portlet:namespace/>fm.<portlet:namespace/>staffCode.value;
		document.<portlet:namespace/>searchSapUser.<portlet:namespace/>staffCode2.value=staffCode;
		var eOnBoardingId = document.getElementById('<portlet:namespace />eOnBoardingId');
		document.<portlet:namespace />searchSapUser.<portlet:namespace />eOnBoardingId2.value = eOnBoardingId.value;
		if(document.<portlet:namespace />fm.<portlet:namespace />isApplicantAgent!=null && Boolean(document.<portlet:namespace />fm.<portlet:namespace />isApplicantAgent.checked)) {
			document.<portlet:namespace />searchSapUser.<portlet:namespace />isApplicantAgent.value = document.<portlet:namespace />fm.<portlet:namespace />isApplicantAgent.value;
		}	
		submitForm(document.<portlet:namespace/>searchSapUser);
	}
</aui:script>

<portlet:resourceURL var="downloadURL" >
	<portlet:param name="photoPath" value="<%=photoPath %>"/>
</portlet:resourceURL>
<portlet:actionURL var="addEOnBoardingURL" windowState="normal" />

<liferay-portlet:renderURL var="myApplicationsURL"
	plid="<%=myApplicationsPlid%>"
	portletName='<%=PropsUtil.get("vgc.apon.my.applications.portletId") %>'
	windowState="normal">
</liferay-portlet:renderURL>

<aui:form  method="post" name="fm" action="<%=addEOnBoardingURL %>" style="height:auto;width:auto;" enctype="multipart/form-data">
	<aui:fieldset>
		<aui:input name="<%= Constants.CMD %>" type="hidden" />
		<aui:input type="hidden" name="eOnBoardingId" value="<%=eOnBoardingId%>"/>	
		<aui:input type="hidden" name="eOnBoardingId"
			value='<%=eOnBoardingId%>' id="eOnBoardingId"/>
		<aui:input type="hidden" name="reportTo" value="<%=eOnBoarding.getReportTo()%>"/>
		<aui:input type="hidden" name="reportToStaffName2"/>
		<aui:input type="hidden" name="contractType2"/>
		<aui:input type="hidden" name="workLocation2"/>
		<aui:input type="hidden" name="officeSite2"/>
		<aui:input type="hidden" name="companyCar2"/>
	</aui:fieldset>
	
	<div class="mainbody">
		<div class="topButton">
			<aui:button-row>
				<aui:button value="vgc.apon.button.save.as.draft" onClick='<%= renderResponse.getNamespace() + "saveEOnBoarding()" %>'/>
				<aui:button value="vgc.apon.button.submit"  onClick='<%= renderResponse.getNamespace() + "submitEOnBoarding()" %>'/>
				<aui:button type="cancel" value="vgc.apon.button.back" onClick='<%= myApplicationsURL %>' />
			</aui:button-row>
		</div>
		<div class="tabTitle">
			<h3>
				<liferay-ui:message
					key="vgc.apon.e.onboarding" />
			</h3>
			<div class="Ltext"></div>
			<div class="tickerNo">
				<liferay-ui:message key="vgc.apon.e.onboarding.ticket.no" />
				<span class="num"><%=eOnBoarding.getTicketNo()%></span>
			</div>
			<div class="clear"></div>
		</div>
	
		<div class="gernal">
	      <div class="subtitle">
			<liferay-ui:message key="vgc.apon.e.onboarding.employee.information" />		
			<%if(isHasAppliantAgent) {
			%>
			<input type="checkbox" name="<portlet:namespace/>isApplicantAgent"
				value='<%=true %>' <%=eOnBoarding.getIsApplicantAgent()?"checked='checked'":"" %>/>
			<liferay-ui:message key="vgc-apon-on-behalf-of-x" arguments="<%=agentName %>"/>
			<%	
			} 
			%>	
		  </div>
	                
		  <ul>
			<li class="md01"><liferay-ui:message key="vgc.apon.e.onboarding.staffCode"></liferay-ui:message></li>
			<li class="md02"><input type="text" id="staffCode" value="<%=eOnBoarding.getStaffCode() %>" name="<portlet:namespace/>staffCode" required="required" maxlength="50">
			  <a href='javascript:<%= renderResponse.getNamespace() + "searchSAPUser()" %>' onclick="">
			    <img src='<%=checkImagePath%>'/></a>
			</li>
			<li class="po">
				<div class="photo">			
					  <img  src='<%=downloadURL %>' style="height: 180px;width: 129px;"/>			  
				</div>
					<input type="file" name="<portlet:namespace/>photo"/>
			</li>
		  </ul>
		  <ul>
			<li class="md01"><liferay-ui:message key="vgc.apon.e.onboarding.lastName"></liferay-ui:message></li>
			<li class="md02"><input type="text" id="lastName" name="<portlet:namespace/>lastName" value="<%=eOnBoarding.getLastName()%>" <%=readonly %> required="required" maxlength="75"></li>
		  </ul>
		  <ul>
			<li class="md01"><liferay-ui:message key="vgc.apon.e.onboarding.firstName"></liferay-ui:message></li>
			<li class="md02"><input type="text" id="firstName" name="<portlet:namespace/>firstName" value="<%=eOnBoarding.getFirstName()%>" <%=readonly %> required="required" maxlength="75"></li>
		  </ul>
		  <ul>
			<li class="md01"><liferay-ui:message key="vgc.apon.e.onboarding.name"></liferay-ui:message></li>
			<li class="md02"><input type="text" id="name" name="<portlet:namespace/>name" value="<%=eOnBoarding.getName()%>" <%=readonly %> maxlength="75"></li>
		  </ul>
		  <ul>
			<li class="md01"><liferay-ui:message key="vgc.apon.e.onboarding.gender"></liferay-ui:message></li>
			<li class="md02"><input id="gender"  type="text" name="<portlet:namespace/>gender" value="<%=eOnBoarding.getGender()%>" <%=readonly %> required="required" maxlength="75"></li>
		  </ul>
		  <ul>
			<li class="md01"><liferay-ui:message key="vgc.apon.e.onboarding.birthday"></liferay-ui:message></li>
			<li class="md02"><input id="<portlet:namespace/>birthday" class="Wdate" required="required"
				type="text"
				value="<%=eOnBoarding.getBirthday()!=null?sdf_dmy.format(eOnBoarding.getBirthday()):"" %>"
				name="<portlet:namespace/>birthday"
				onFocus="WdatePicker({lang:'en',dateFmt:'dd.MM.yyyy'})"  <%=readonly %>/></li>
		  </ul>
		  <ul>
			<li class="md01"><liferay-ui:message key="vgc.apon.e.onboarding.contractType"></liferay-ui:message></li>
			<li class="md02">
				<select id="contractType" name="<portlet:namespace/>contractType" required="required" <%=disabled %>>
		          	<option value=""></option>
		                  <%
				        for(String str:PropsUtil.getArray("vgc.apon.contract.type.list.value"))
				        {
				        	String selected="";
				        	String contractType=eOnBoarding.getContractType();
				        	if(contractType!=null&&contractType.equals(str))
				        		selected="selected='selected'";
				        %>
				        <option <%=selected %> value="<%=str%>"><%=str %></option>
				        <% 
				        }
				        %>
	            </select>		
	        </li>
	        <li class="md01"><liferay-ui:message key="vgc.apon.e.onboarding.workLocation"></liferay-ui:message></li>
			<li class="md022">
				<select id="workLocation"  name="<portlet:namespace/>workLocation" required="required" <%=disabled %>>
					<option value=""></option>
			        <% //
			        for(String workLocation:ApplicantConstrant.getWorkLocation())
			        {
			        	String selected="";
			        	String workLocations=eOnBoarding.getWorkLocation();
			        	if(workLocations!=null&&workLocation.equals(workLocations))
			        		selected="selected='selected'";
			        %>
			        			<option <%=selected%> value="<%=workLocation%>"><%= workLocation%></option>
			        	<%
			        }
			        	%>
	      		</select>
	      		</li>
		  </ul>
		  <ul>
			<li class="md01"><liferay-ui:message key="vgc.apon.e.onboarding.division"></liferay-ui:message></li>
			<li class="md02"><input id="division" type="text" name="<portlet:namespace/>division" value="<%=eOnBoarding.getDivision()%>" <%=readonly %> required="required" maxlength="75"></li>
			<li class="md01"><liferay-ui:message key="vgc.apon.e.onboarding.officeSite"></liferay-ui:message></li>
			<li class="md022">
				<select id="officeSite"  name="<portlet:namespace/>officeSite" required="required" <%=disabled %>>
	               <option value=""></option>
					<% 
					for(String officeSite:ApplicantConstrant.getOfficeSite())
					{
						String selected="";
						String officeSites=eOnBoarding.getOfficeSite();
						if(officeSites!=null&&officeSites.equals(officeSite))
							selected="selected='selected'";
					%>
						<option <%=selected %> value="<%=officeSite%>"><%=officeSite%></option>
					<% 
					}
					%>
	           </select>
			</li>
		  </ul>
		  <ul>
			<li class="md01"><liferay-ui:message key="vgc.apon.e.onboarding.department"></liferay-ui:message></li>
			<li class="md02"><input id="department" type="text" name="<portlet:namespace/>department" <%=readonly %> value="<%=eOnBoarding.getDepartment()%>" required="required" maxlength="75"></li>
			<li class="md01"><liferay-ui:message key="vgc.apon.e.onboarding.startDate"></liferay-ui:message></li>
			<li class="md022"><input id="<portlet:namespace/>startingDate" class="Wdate"  required="required"
				type="text"
				value="<%=eOnBoarding.getStartingDate()!=null?sdf_dmy.format(eOnBoarding.getStartingDate()):"" %>"
				name="<portlet:namespace/>startingDate"
				onFocus="WdatePicker({lang:'en',dateFmt:'dd.MM.yyyy'})" <%=readonly %> />  </li>
		  </ul>
		  <ul>
			<li class="md01"><liferay-ui:message key="vgc.apon.e.onboarding.positionCode"></liferay-ui:message></li>
			<li class="md02"><input  type="text" id="expectPositionCode" name="<portlet:namespace/>positionCode" <%=readonly %> value="<%=eOnBoarding.getPositionCode()%>" maxlength="75">
				<%-- <liferay-ui:icon
					id="selectPositionTo"
					label="<%= true %>"
					message=""
					method="get"
					url="javascript:;"
					src="<%= searchImagePath%>"
				/> --%>
	        </li>
			<li class="md01"><liferay-ui:message key="vgc.apon.e.onboarding.serviceLength"></liferay-ui:message></li>
			<li class="md022"><input type="text" name="<portlet:namespace/>serviceLength" value="<%=eOnBoarding.getServiceLength()%>" maxlength="75"></li>
		  </ul>
		  <ul>
			<li class="md01"><liferay-ui:message key="vgc.apon.e.onboarding.functionName"></liferay-ui:message></li>
			<li class="md02"><input  type="text" id="expectPositionName" name="<portlet:namespace/>functionName" <%=readonly %> value="<%=eOnBoarding.getFunctionName()%>" required="required" maxlength="75"></li>
			<li class="md01"><liferay-ui:message key="vgc.apon.e.onboarding.reportTo"></liferay-ui:message></li>
			<li class="md022"><input type="text" id="expectReport" name="<portlet:namespace/>reportToStaffName" <%=readonly %> value="<%=eOnBoarding.getReportToStaffName()%>"  maxlength="75">
	        	<%-- <liferay-ui:icon
					id="selectReportTo"
					label="<%= true %>"
					message=""
					method="get"
					url="javascript:;"
					src="<%= searchImagePath%>"
				/> --%>
	        </li>
		  </ul>			  
		  <ul>
			<li class="md01"><liferay-ui:message key="vgc.apon.e.onboarding.title"></liferay-ui:message></li>
			<li class="md02">
			   <input  type="text" id="title" name="<portlet:namespace/>title" value="<%=eOnBoarding.getTitle()%>" <%=readonly %> required="required" maxlength="75"/>			
			</li>
			<li class="md01"><liferay-ui:message key="vgc.apon.e.onboarding.costCenter"></liferay-ui:message></li>
			<li class="md022"><input type="text" id="costCenter"  name="<portlet:namespace/>costCenter" <%=readonly %> value="<%=eOnBoarding.getCostCenter()%>" required="required" maxlength="75"></li>			
		  </ul>
		  <ul>
			<li class="md01" style="height: 50px;"><liferay-ui:message key="vgc.apon.e.onboarding.itRelatedHardware"></liferay-ui:message></li>
			<li class="md02">
				<%
					String checkedYes="";
					String checkedNo="";
				//	System.out.println("eOnBoarding.getItRelatedHardware()==============="+eOnBoarding.getItRelatedHardware());
					if(eOnBoarding.getItRelatedHardware()) {
						checkedYes="checked='checked'";
					}else {
						checkedNo="checked='checked'";
					}			
						
					%>
				<input  <%=checkedYes %> name="<portlet:namespace/>itRelatedHardware" type="radio" value="<%= true %>"/>Yes&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input  <%=checkedNo %>   name="<portlet:namespace/>itRelatedHardware" type="radio" value="<%= false %>"/>No</li>
			<li class="md01"><liferay-ui:message key="vgc.apon.e.onboarding.companyCar"></liferay-ui:message></li>
			<li class="md022">
			  <%
				checkedYes="";
				checkedNo="";
				if(eOnBoarding.getCompanyCar())
					checkedYes="checked='checked'";
				else
					checkedNo="checked='checked'";
				%>
				
				<input  <%=checkedYes %>  name="<portlet:namespace/>companyCar0" type="radio" value="<%= true %>" <%=disabled %>/>Yes&nbsp;&nbsp;&nbsp;
				<input   <%=checkedNo %>   name="<portlet:namespace/>companyCar1" type="radio" value="<%= false %>" <%=disabled %>/>No</li>
		  </ul>  
		  <ul>
			<li class="md01"><liferay-ui:message key="vgc.apon.e.onboarding.replacement"></liferay-ui:message></li>
			<li class="md02">
			  <%
				checkedYes="";
				checkedNo="";
				if(eOnBoarding.getReplacement())
					checkedYes="checked='checked'";
				else
					checkedNo="checked='checked'";
				%>
			    <input  <%=checkedYes %> name="<portlet:namespace/>replacement" type="radio" value="<%= true %>" />Yes&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input   <%=checkedNo %>  name="<portlet:namespace/>replacement" type="radio" value="<%= false %>" />No</li>
			<li class="md01"><liferay-ui:message key="vgc.apon.e.onboarding.nameOfReplacePerson"></liferay-ui:message></li>
			<li class="md022"><input type="text" name="<portlet:namespace/>nameOfReplacePerson" value="<%=eOnBoarding.getNameOfReplacedPerson()%>" maxlength="75"></li>
		  </ul>
		  
		  
		  <ul>
			<li class="md01"><liferay-ui:message key="vgc.apon.e.onboarding.contactInfo"></liferay-ui:message></li>
			<li class="md03">
				<input type="text" name="<portlet:namespace/>contactInfo" value="<%=eOnBoarding.getContactInfo()%>" maxlength="75" />			
			</li>
		  </ul>
		  <ul>
			<li class="md01"><liferay-ui:message key="vgc.apon.e.onboarding.comments"></liferay-ui:message></li>
			<li class="md03"><input type="text" name="<portlet:namespace/>comments" style="font-style:italic;" 
			onblur="if(value==''){value='Please input email or phone info of BU contact person if needed.'}"
			onfocus="if(value=='Please input email or phone info of BU contact person if needed.'){value=''}" maxlength="75"
			value='<%=Validator.isNull(eOnBoarding.getComments())?"Please input email or phone info of BU contact person if needed.":eOnBoarding.getComments()%>'></li>
	  	  </ul>
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
		<div class="nextbtn">
			<aui:button-row>
				<aui:button value="vgc.apon.button.save.as.draft" onClick='<%= renderResponse.getNamespace() + "saveEOnBoarding()" %>'/>
				<aui:button value="vgc.apon.button.submit"  onClick='<%= renderResponse.getNamespace() + "submitEOnBoarding()" %>'/>
				<aui:button type="cancel" value="vgc.apon.button.back" onClick='<%= myApplicationsURL %>' />
			</aui:button-row>
		</div>	
	</div>

</aui:form>

<aui:form  action="<%=portletURL %>" method="post" name="searchSapUser">
	<aui:fieldset>
	    <aui:input type="hidden" name="staffCode2"/>
		<aui:input name="eOnBoardingId2" type="hidden" />
		<aui:input name="isApplicantAgent" type="hidden"></aui:input>
	</aui:fieldset>
</aui:form>

<!-- Open the  select page -->
<aui:script use="liferay-search-container">
	var selectCarLink = A.one('#<portlet:namespace />selectReportTo');
	if (selectCarLink) {
		selectCarLink.on(
			'click',
			function(event) {
				Liferay.Util.selectEntity(
					{
						dialog: {
							constrain: true,
							modal: true
						},
						id: '<portlet:namespace />selectReport',
						title: '<liferay-ui:message arguments="vgc.apon.report" key="select-x" />',
						uri:'<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>"><portlet:param name="mvcPath" value="/html/admin/select_reportToName.jsp" /></portlet:renderURL>'
					},
					function(event) {
						document.<portlet:namespace />fm.<portlet:namespace />reportToStaffName.value = event.reportToStaffName;
						document.<portlet:namespace />fm.<portlet:namespace />reportTo.value = event.reportTo;
					}
				);
			}
		);
	}
</aui:script>

<aui:script use="liferay-search-container">
var selectCarLink = A.one('#<portlet:namespace />selectPositionTo');
if (selectCarLink) {
	selectCarLink.on(
		'click',
		function(event) {
			Liferay.Util.selectEntity(
				{
					dialog: {
						constrain: true,
						modal: true
					},
					id: '<portlet:namespace />selectPosition',
					title: '<liferay-ui:message arguments="vgc.apon.position" key="select-x" />',
					uri:'<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>"><portlet:param name="mvcPath" value="/html/admin/select_position.jsp" /><portlet:param name="vacancyStatus" value="Open" /></portlet:renderURL>'
				},
				function(event) {
					document.getElementById("expectPositionCode").value=event.positionCode;
					document.getElementById("expectPositionName").value=event.positionName;
				}
			);
		}
	);
}
</aui:script>