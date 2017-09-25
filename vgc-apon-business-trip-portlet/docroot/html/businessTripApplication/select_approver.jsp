
<%@include file="/html/init.jsp"%>
<%


long staffCode = themeDisplay.getUser().getFacebookId();
SAPUser loginUser=SAPUserLocalServiceUtil.getSapUserByStaffCode(String.valueOf(staffCode));


	String sapCompanyName=(String)renderRequest.getParameter("sapCompanyName");
	String divisionName=(String)renderRequest.getParameter("divisionName");
	if(divisionName==null||divisionName.equals("")){
		divisionName=loginUser.getDivisionName();
	}
	String myStaffCode=loginUser.getStaffCode();
	String departmentName=(String)renderRequest.getParameter("departmentName");
	String staffName=(String)renderRequest.getParameter("staffName");
	String myIndex=loginUser.getSg();
	PortletURL portletURL = renderResponse.createRenderURL();
	String eventName = ParamUtil.getString(request, "eventName", liferayPortletResponse.getNamespace() + "selectApprover");
	portletURL.setParameter("mvcPath", "/html/businessTripApplication/select_approver.jsp");
	portletURL.setParameter("eventName", eventName);
	if(Validator.isNotNull(sapCompanyName)) {
		portletURL.setParameter("sapCompanyName", sapCompanyName);
	}
	if(Validator.isNotNull(divisionName)) {
		portletURL.setParameter("divisionName", divisionName);
	}
	if(Validator.isNotNull(departmentName)) {
		portletURL.setParameter("departmentName", departmentName);
	}
	if(Validator.isNotNull(staffName)) {
		portletURL.setParameter("staffName", staffName);
	}
%>

<aui:script>
	function <portlet:namespace/>query() {
		var formId = "<portlet:namespace />fm";
		document.getElementById(formId).submit();
	}
	
	function <portlet:namespace/>cancel(){
		var Util = Liferay.Util;
		Util.getWindow().destroy();
	}
	
	window.onload=function(){
		var buttons=parent.document.getElementsByTagName("button");
		for(var i=0;i<buttons.length;i++){		
			if(buttons[i].className!=null&&buttons[i].className.indexOf("btn close")!=-1){		
				buttons[i].onclick = function(){			
					var Util = Liferay.Util;				
					Util.getWindow().destroy();
				} 
			}
		}
	}
</aui:script>

<aui:form name="selectApproverForm">
	<aui:button cssClass="selector-button" value="Confirm" />
	<aui:button value="Cancel"
		onClick='<%=renderResponse.getNamespace()+ "cancel();"%>'></aui:button>
</aui:form>

<portlet:actionURL var="searchApproverURL" name="searchApprover" windowState="normal">
	<portlet:param name="mvcPath" value="/html/businessTripApplication/select_approver.jsp" />
	<portlet:param name="eventName" value="<%=eventName%>" />
</portlet:actionURL>

<aui:form action="<%=searchApproverURL%>" method="post" name="fm">
	<aui:fieldset>
		<div class="searchbox">	
			<ul>
				<li class="sd01"><liferay-ui:message key="vgc-apon-business-trip-application-select-approver-query-company"></liferay-ui:message></li>
				<li class="sd02"><input type="text" name="<portlet:namespace/>sapCompanyName" value="<%=sapCompanyName==null?"":sapCompanyName%>" maxlength="75"/></li>
				<li class="sd01"><liferay-ui:message key="vgc-apon-business-trip-application-select-approver-query-division"></liferay-ui:message></li>
				<li class="sd02"><input type="text" name="<portlet:namespace/>divisionName" value="<%=divisionName==null?"":divisionName%>" maxlength="75"/></li>
			</ul>
			<ul>
				<li class="sd01"><liferay-ui:message key="vgc-apon-business-trip-application-select-approver-query-department"></liferay-ui:message></li>
				<li class="sd02"><input type="text" name="<portlet:namespace/>departmentName" value="<%=departmentName==null?"":departmentName%>" maxlength="75"/></li>
				<li class="sd01"><liferay-ui:message key="vgc-apon-business-trip-application-select-approver-query-approver"></liferay-ui:message></li>
				<li class="sd02"><input type="text" name="<portlet:namespace/>staffName" value="<%=staffName==null?"":staffName%>" maxlength="75"/></li>
				<li>
					<liferay-ui:icon iconCssClass="icon-search"
						label="<%=true%>" linkCssClass="btn"
						message="vgc.apon.button.search"
						url='<%="javascript:" + renderResponse.getNamespace()+ "query();"%>' />
				</li>
			</ul>
		</div>
	</aui:fieldset>
</aui:form>

<liferay-ui:search-container delta='<%=Integer.valueOf(PropsUtil.get("vgc.apon.delta")) %>' iteratorURL="<%=portletURL%>">
	<liferay-ui:search-container-results results="<%=SAPUserLocalServiceUtil.findSupervisorApproverUsers(sapCompanyName, divisionName, departmentName, staffName,myIndex,myStaffCode, searchContainer.getStart(),searchContainer.getEnd()) %>"
	 total="<%=SAPUserLocalServiceUtil.findCountSupervisorApproverUsers(sapCompanyName, divisionName, departmentName, staffName,myIndex,myStaffCode) %>" >
	</liferay-ui:search-container-results>		
	
	<liferay-ui:search-container-row className="com.vgc.apon.model.SAPUser" keyProperty="sapUserId" modelVar="sapUser" escapedModel="<%=true%>">
		<liferay-ui:search-container-column-text>
			<input type="radio" name="radio" value="<%=sapUser.getStaffCode()+"#"+sapUser.getStaffName()%>" />
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="vgc-apon-business-trip-application-select-approver-company" property="sapCompanyName"/>
		<liferay-ui:search-container-column-text name="vgc-apon-business-trip-application-select-approver-division" property="divisionName"/>
		<liferay-ui:search-container-column-text name="vgc-apon-business-trip-application-select-approver-department" property="departmentName"/>
		<liferay-ui:search-container-column-text name="vgc-apon-business-trip-application-select-approver-approver" property="staffName"/>
		<liferay-ui:search-container-column-text name="vgc-apon-business-trip-application-select-approver-function-name" property="positionName"/>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>

<aui:script use="aui-base">
	var Util = Liferay.Util;
	A.one('#<portlet:namespace />selectApproverForm').delegate(
		'click',
		function(event) {
			var check=A.one("input[type=radio]:checked");
			if(check==null){
				alert("Please Choose one Approver.");
			}else{
				var result={};
				var value=check.val();
				var array=value.split("#");
				result['approverId']=array[0];
				result['approverName']=array[1];
				Util.getOpener().Liferay.fire('<%= HtmlUtil.escapeJS(eventName) %>',result);
				Util.getWindow().destroy();
			}
		},
		'.selector-button'
	);
</aui:script>

