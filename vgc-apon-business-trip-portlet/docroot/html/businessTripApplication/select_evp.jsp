
<%@include file="/html/init.jsp"%>
<%


long staffCode = themeDisplay.getUser().getFacebookId();
SAPUser loginUser=SAPUserLocalServiceUtil.getSapUserByStaffCode(String.valueOf(staffCode));


	;
	PortletURL portletURL = renderResponse.createRenderURL();
	String eventName = ParamUtil.getString(request, "eventName", liferayPortletResponse.getNamespace() + "selectEvp");
	portletURL.setParameter("mvcPath", "/html/businessTripApplication/select_evp.jsp");
	portletURL.setParameter("eventName", eventName);
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

<aui:form name="selectEvpForm">
	<aui:button cssClass="selector-button" value="Confirm" />
	<aui:button value="Cancel"
		onClick='<%=renderResponse.getNamespace()+ "cancel();"%>'></aui:button>
</aui:form>

<portlet:actionURL var="searchApproverURL" name="searchApprover" windowState="normal">
	<portlet:param name="mvcPath" value="/html/businessTripApplication/select_evp.jsp" />
	<portlet:param name="eventName" value="<%=eventName%>" />
</portlet:actionURL>



<liferay-ui:search-container delta='<%=Integer.MAX_VALUE %>' >
	<liferay-ui:search-container-results results="<%=SAPUserLocalServiceUtil.findAllDivistionUsers() %>"
	 total="<%=SAPUserLocalServiceUtil.findAllDivistionUsersCount() %>" >
	</liferay-ui:search-container-results>		
	
	<liferay-ui:search-container-row className="com.vgc.apon.model.SAPUser" keyProperty="sapUserId" modelVar="sapUser" escapedModel="<%=true%>">
		<liferay-ui:search-container-column-text>
			<input type="radio" name="radio" value="<%=sapUser.getStaffCode()+"#"+sapUser.getStaffName()%>" />
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="vgc-apon-business-trip-application-select-approver-company" property="sapCompanyName"/>
		<liferay-ui:search-container-column-text name="vgc-apon-business-trip-application-select-approver-division" property="divisionName"/>
		<liferay-ui:search-container-column-text name="vgc-apon-business-trip-application-select-approver-department" property="departmentName"/>
		<liferay-ui:search-container-column-text name="vgc-apon-business-trip-application-select-approver-evp" property="staffName"/>
		<liferay-ui:search-container-column-text name="vgc-apon-business-trip-application-select-approver-function-name" property="positionName"/>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>

<aui:script use="aui-base">
	var Util = Liferay.Util;
	A.one('#<portlet:namespace />selectEvpForm').delegate(
		'click',
		function(event) {
			var check=A.one("input[type=radio]:checked");
			if(check==null){
				alert("Please Choose one EVP.");
			}else{
				var result={};
				var value=check.val();
				var array=value.split("#");
				result['evpId']=array[0];
				result['evpName']=array[1];
				Util.getOpener().Liferay.fire('<%= HtmlUtil.escapeJS(eventName) %>',result);
				Util.getWindow().destroy();
			}
		},
		'.selector-button'
	);
</aui:script>

