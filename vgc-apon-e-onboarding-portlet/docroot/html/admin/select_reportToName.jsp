
<%@include file="/html/init.jsp"%>

<%
 String staffCode=(String)renderRequest.getParameter("staffCode");
 String staffName=(String)renderRequest.getParameter("staffName");
 PortletURL portletURL = renderResponse.createRenderURL();
 String eventName = ParamUtil.getString(request, "eventName", liferayPortletResponse.getNamespace() + "selectReport");
 portletURL.setParameter("mvcPath", "/html/admin/select_reportToName.jsp");
 portletURL.setParameter("eventName", eventName);
 if(Validator.isNotNull(staffCode))
	portletURL.setParameter("staffCode", staffCode);

 if(Validator.isNotNull(staffName))
	portletURL.setParameter("staffName", staffName);
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


<aui:form name="selectReportForm"> 
	<aui:button cssClass="selector-button" value="Confirm" />
	<aui:button  value="Cancel" onClick='<%=renderResponse.getNamespace()+ "cancel();"%>'></aui:button>
</aui:form>

<portlet:actionURL var="searchSapUserURL" windowState="normal">
	<portlet:param name="mvcPath" value="/html/admin/select_reportToName.jsp" />
	<portlet:param name="eventName" value="<%=eventName %>"/>
</portlet:actionURL>

<aui:form action="<%=searchSapUserURL%>" method="post" name="fm" >
	<aui:fieldset>
		<div class="searchbox">	
			<ul>
				<li class="sd01"><liferay-ui:message key="vgc.apon.e.onboarding.select.report.to.query.staff.code"></liferay-ui:message></li>
				<li class="sd02">
					<input type="text" name="<portlet:namespace/>staffCode"  value="<%=staffCode==null?"":staffCode %>" maxlength="75"/>
				</li>
				<li class="sd01"><liferay-ui:message key="vgc.apon.e.onboarding.select.report.to.query.staff.name"></liferay-ui:message></li>
				<li class="sd02"><input type="text" name="<portlet:namespace/>staffName"  value="<%=staffName==null?"":staffName %>" maxlength="75"/></li>
				<li>
					<liferay-ui:icon iconCssClass="icon-search"
						label="<%=true%>" linkCssClass="btn" message="vgc.apon.button.search"
						url='<%="javascript:" + renderResponse.getNamespace()+ "query();"%>' />
				</li>
			</ul>
		</div>
	</aui:fieldset>
</aui:form>

<liferay-ui:search-container emptyResultsMessage="vgc.apon.there.are.no.user.to.be.display" iteratorURL="<%=portletURL %>" var="reportSearchContainer" delta="10">
	<liferay-ui:search-container-results >
		<%
		List<SAPUser> result=SAPUserLocalServiceUtil.findSapUserByC_S_S(PortalUtil.getDefaultCompanyId(), staffCode, staffName, reportSearchContainer.getStart(), reportSearchContainer.getEnd());
		pageContext.setAttribute("results", result);
		pageContext.setAttribute("total", SAPUserLocalServiceUtil.findSapUserByC_S_S(PortalUtil.getDefaultCompanyId(), staffCode, staffName).size());
		%>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="com.vgc.apon.model.SAPUser" keyProperty="sapUserId" modelVar="sapUser" escapedModel="<%= true %>">
		<liferay-ui:search-container-column-text >
			<input  type="radio" name="radio" value="<%=sapUser.getStaffName()+","+sapUser.getStaffCode()%>"/>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="vgc.apon.e.onboarding.select.report.to.division" value="<%=sapUser.getDivisionName() %>"/>
		<liferay-ui:search-container-column-text name="vgc.apon.e.onboarding.select.report.to.department" value="<%=sapUser.getDepartmentName() %>"/>
		<liferay-ui:search-container-column-text name="vgc.apon.e.onboarding.select.report.to.staff.code" value="<%=sapUser.getStaffCode()%>"/>
		<liferay-ui:search-container-column-text name="vgc.apon.e.onboarding.select.report.to.staff.name" value="<%=sapUser.getStaffName() %>"/>
		<liferay-ui:search-container-column-text name="vgc.apon.e.onboarding.select.report.to.email" value="<%=sapUser.getEmail() %>"/>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>


<aui:script use="aui-base">
	var Util = Liferay.Util;
	A.one('#<portlet:namespace />selectReportForm').delegate(
		'click',
		function(event) {
			var check=A.one("input[type=radio]:checked");
			if(check==null)
				{
				alert("Please Choose one ReportTo.");
				}else
					{
			var result={};
			var str = check.val();
			var arr = str.split(',');			
			result['reportTo']=arr[1];
			result['reportToStaffName']=arr[0];
			Util.getOpener().Liferay.fire('<%= HtmlUtil.escapeJS(eventName) %>',result);
			Util.getWindow().destroy();
					}
		},
		'.selector-button'
	);
</aui:script>

