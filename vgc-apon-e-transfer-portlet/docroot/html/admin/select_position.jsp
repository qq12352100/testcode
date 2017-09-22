<%@include file="/html/init.jsp"%>

<%
	String supervisorName = (String)renderRequest.getParameter("supervisorName");
	String searchType = (String)renderRequest.getParameter("searchType");
	String divisionName= (String)renderRequest.getParameter("divisionName");
	String departmentName = (String)renderRequest.getParameter("departmentName");
	
	if("CEO".equals(searchType)){
		divisionName="";
		departmentName="";
	}else if("Division".equals(searchType)){
		departmentName="";
	}else if("Department".equals(searchType)){
		divisionName="";
	}else{
		divisionName="";
		departmentName="";
	}

	String companyName = (String)renderRequest.getParameter("company");
	String division = (String)renderRequest.getParameter("division");
	String department= (String)renderRequest.getParameter("department");
	String functionName= (String)renderRequest.getParameter("functionName");
	String reportToSupervisorName=(String)renderRequest.getParameter("reportToSupervisorName");
	String positionCode=(String)renderRequest.getParameter("positionCode");
	
	boolean isHasRole=GlobalToolLocalServiceUtil.isHasRole(themeDisplay.getUserId(), "ET Organization Partner");
	
	//if(reportToSupervisorName==null||reportToSupervisorName.equals("")){
	//	if(!isHasRole){
	//		reportToSupervisorName=supervisorName;
	//	}
	//}
	
	String eventName = ParamUtil.getString(request, "eventName", liferayPortletResponse.getNamespace() + "selectPosition");
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("eventName", eventName);
	portletURL.setParameter("mvcPath", "/html/admin/select_position.jsp");
	if (Validator.isNotNull(supervisorName)) {
		portletURL.setParameter("supervisorName", supervisorName);
	}
	if (Validator.isNotNull(searchType)) {
		portletURL.setParameter("searchType", searchType);
	}
	if (Validator.isNotNull(divisionName)) {
		portletURL.setParameter("divisionName", divisionName);
	}
	if (Validator.isNotNull(departmentName)) {
		portletURL.setParameter("departmentName", departmentName);
	}
	if (Validator.isNotNull(division)) {
		portletURL.setParameter("division", division);
	}
	if (Validator.isNotNull(department)) {
		portletURL.setParameter("department", department);
	}
	if (Validator.isNotNull(functionName)) {
		portletURL.setParameter("functionName", functionName);
	}
	if (Validator.isNotNull(companyName)) {
		portletURL.setParameter("company", companyName);
	}
	if (Validator.isNotNull(reportToSupervisorName)) {
		portletURL.setParameter("reportToSupervisorName", reportToSupervisorName);
	}
	if (Validator.isNotNull(positionCode)) {
		portletURL.setParameter("positionCode", positionCode);
	}
%>

<aui:script>
	function <portlet:namespace/>query() {
		document.<portlet:namespace />queryFm.<portlet:namespace /><%= Constants.CMD %>.value = "query";
		document.<portlet:namespace />queryFm.<portlet:namespace />searchType.value ="<%=searchType%>";
		document.<portlet:namespace />queryFm.<portlet:namespace />divisionName.value ="<%=divisionName%>";
		document.<portlet:namespace />queryFm.<portlet:namespace />departmentName.value ="<%=departmentName%>";
		submitForm(document.<portlet:namespace />queryFm);	
	}
	
	//Close the popup window
	function <portlet:namespace/>cancel(){
		var Util = Liferay.Util;
		Util.getWindow().destroy();
	}
</aui:script>

<portlet:actionURL var="queryPositionURL" windowState="normal">
	<portlet:param name="mvcPath" value="/html/admin/select_position.jsp" />
</portlet:actionURL>

<aui:form name="selectPositionForm"> 
	<aui:button cssClass="selector-button" value="Confirm" />
	<aui:button value="Back" onClick='<%=renderResponse.getNamespace()+ "cancel();"%>'></aui:button>
</aui:form>

<!-- This form table used to query the users -->
<aui:form action="<%=queryPositionURL %>" method="post" name="queryFm" width="100%">
	<aui:input type="hidden" name="<%= Constants.CMD %>" />
	<aui:input type="hidden" name="searchType" />
	<aui:input type="hidden" name="divisionName" />
	<aui:input type="hidden" name="departmentName" />
	<aui:fieldset width="100%">
	<div class="mainbody">
	<div class="searchbox">	
		<ul class="txt2">
			<li class="sd01"><liferay-ui:message key="vgc.apon.e.transfer.query.field.companyName"></liferay-ui:message></li>
			<li class="sd02">
				<input type="text"
					name="<portlet:namespace/>company" maxlength="75"
					value="<%=companyName==null?"":companyName%>" id="<portlet:namespace/>company">	
			</li>
			<li class="sd01"><liferay-ui:message key="vgc.apon.e.transfer.query.field.division"></liferay-ui:message></li>
			<li class="sd02">
				<input type="text"
					name="<portlet:namespace/>division" maxlength="75"
					value="<%=division==null?"":division%>" id="<portlet:namespace/>division">	
			</li>
			<li class="sd01"><liferay-ui:message key="vgc.apon.e.transfer.query.field.department"></liferay-ui:message></li>
			<li class="sd02">
				<input type="text"
					name="<portlet:namespace/>department" maxlength="75"
					value="<%=department==null?"":department%>" id="<portlet:namespace/>department">	
			</li>
		</ul>
		<ul>	
			<li class="sd01"><liferay-ui:message key="vgc.apon.e.transfer.query.field.positionCode"></liferay-ui:message></li>
			<li class="sd02">
				<input type="text"
					name="<portlet:namespace/>positionCode" maxlength="75"
					value="<%=positionCode==null?"":positionCode%>" id="<portlet:namespace/>positionCode">	
			</li>
			<li class="sd01"><liferay-ui:message key="vgc.apon.e.transfer.query.field.functionName"></liferay-ui:message></li>
			<li class="sd02">
				<input type="text"
					name="<portlet:namespace/>functionName" maxlength="75"
					value="<%=functionName==null?"":functionName%>" id="<portlet:namespace/>functionName">	
			</li>
			<li class="sd01"><liferay-ui:message key="vgc.apon.e.transfer.query.field.reportToSupervisorName"></liferay-ui:message>
			<span style="font-size:7pt;">(Supervisor Name)</span></li>
			<li class="sd02">
				<input type="text"
					name="<portlet:namespace/>reportToSupervisorName"
					value="<%=reportToSupervisorName==null?"":reportToSupervisorName%>" id="<portlet:namespace/>reportToSupervisorName" maxlength="75">	
			</li>
			<li><liferay-ui:icon iconCssClass="icon-search"
					label="<%=true%>" linkCssClass="btn"
					message="vgc.apon.e.transfer.search"
					url='<%="javascript:" + renderResponse.getNamespace()+ "query();"%>' />
				</li>
			</ul>
		</div>
		<p style="padding-left:10px;"><liferay-ui:message key="vgc.apon.e.transfer.query.field.table.notes"/></p>
		</div>
		<liferay-ui:search-container var="positionSearchContainer3"
			emptyResultsMessage="vgc.apon.e.transfer.signature.are.no.view.info.by.me" iteratorURL="<%=portletURL%>"
			delta="10">
			<liferay-ui:search-container-results>
				<%
					List<AponSapData> result=AponSapDataLocalServiceUtil.findByS_P_C(division,department,divisionName,departmentName,functionName,"",reportToSupervisorName,positionCode,true,"",companyName,positionSearchContainer3.getStart(),positionSearchContainer3.getEnd());
					pageContext.setAttribute("results", result);
					pageContext.setAttribute("total", AponSapDataLocalServiceUtil.findByS_P_C(division,department,divisionName,departmentName,functionName,"",reportToSupervisorName,positionCode,true,"",companyName).size());
				%>
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row className="com.vgc.apon.model.AponSapData" keyProperty="aponSapDataId" modelVar="aponSapData" escapedModel="<%=true%>">
				<liferay-ui:search-container-column-text>
 					<input type="radio" name="radio" value="<%=(aponSapData.getCompanyName()!=null?aponSapData.getCompanyName().trim():"")+"#"+(aponSapData.getDivisionName()!=null?aponSapData.getDivisionName().trim():"")+"#"+(aponSapData.getDepartmentName()!=null?aponSapData.getDepartmentName().trim():"")+"#"+(aponSapData.getPositionName()!=null?aponSapData.getPositionName().trim():"")+"#"+(aponSapData.getPositionCostCenterId()!=null?aponSapData.getPositionCostCenterId().trim():"")+"#"+(aponSapData.getReportToSupervisorName()!=null?aponSapData.getReportToSupervisorName().trim():"")+"#"+(aponSapData.getOfficeSite()!=null?aponSapData.getOfficeSite().trim():"")+"#"+(aponSapData.getPositionId()!=null?aponSapData.getPositionId().trim():"")+"#"+(aponSapData.getSg()!=null?aponSapData.getSg().trim():"")+"#"+(aponSapData.getPositionType()!=null?aponSapData.getPositionType().trim():"")+"#"+(aponSapData.getChina60()!=null?aponSapData.getChina60().trim():"")+"#"+(aponSapData.getTotNumOfRep()!=null?aponSapData.getTotNumOfRep().trim():"")+"#"+(aponSapData.getStaffCode()!=null?aponSapData.getStaffCode().trim():"")%>"/>					
				</liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="vgc.apon.e.transfer.table.companyName"
					value="<%=aponSapData.getCompanyName()%>" />
				<liferay-ui:search-container-column-text name="vgc.apon.e.transfer.table.divisionName"
					value="<%=aponSapData.getDivisionName()%>" />
				<liferay-ui:search-container-column-text name="vgc.apon.e.transfer.table.departmentName" 
					value="<%=aponSapData.getDepartmentName()%>" />
				<liferay-ui:search-container-column-text name="vgc.apon.e.transfer.table.reportToPositionName"
					value="<%=aponSapData.getReportToPositionName()%>" />
				<liferay-ui:search-container-column-text name="vgc.apon.e.transfer.table.reportToSupervisorName"
					value="<%=aponSapData.getReportToSupervisorName()%>" />
				<liferay-ui:search-container-column-text name="vgc.apon.e.transfer.table.functionName"
					value="<%=aponSapData.getPositionName()%>" />
				<liferay-ui:search-container-column-text name="vgc.apon.e.transfer.table.positionCode"
					value="<%=aponSapData.getPositionId()%>" />
				<liferay-ui:search-container-column-text name="vgc.apon.e.transfer.table.validTo" 
					value='<%=aponSapData.getPositionEndDate()==null?"":sdf_dmy.format(aponSapData.getPositionEndDate())%>'/>
				<liferay-ui:search-container-column-text name="vgc.apon.e.transfer.table.vacancyStatus" 
					value="<%=aponSapData.getVacancyStatus()%>" />
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</aui:fieldset>
</aui:form>
<!-- Send the related data to the parent page -->

<aui:script use="aui-base">
	var Util = Liferay.Util;
	A.one('#<portlet:namespace />selectPositionForm').delegate(
		'click',
		function(event) {
			var check=A.one("input[type=radio]:checked");
			if(check==null)
				{
				alert("Please Choose one Position.");
				}else
					{
			var result={};
			var value=check.val();
			var array=value.split("#");
			result['companyName']=array[0];
			result['divisionName']=array[1];
			result['departmentName']=array[2];
			result['functionName']=array[3];
			result['costCenter']=array[4];
			result['reportToSupervisorName']=array[5];
			result['officeSite']=array[6];
			result['positionCode']=array[7];
			result['sg']=array[8];
			result['positionType']=array[9];
			result['china60']=array[10];
			result['totNumOfRep']=array[11];
			result['staffCode']=array[12];
			Util.getOpener().Liferay.fire('<%= HtmlUtil.escapeJS(eventName) %>',result);
			Util.getWindow().destroy();
					}
		},
		'.selector-button'
	);
</aui:script>
