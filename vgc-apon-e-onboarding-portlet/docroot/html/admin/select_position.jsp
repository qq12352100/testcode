
<%@include file="/html/init.jsp"%>

<%
	String divisionName=(String)renderRequest.getParameter("divisionName");
	String departmentName=(String)renderRequest.getParameter("departmentName");
	String vacancyStatus=(String)renderRequest.getParameter("vacancyStatus");
	String position=(String)renderRequest.getParameter("position");
	 
	PortletURL portletURL = renderResponse.createRenderURL();
	String eventName = ParamUtil.getString(request, "eventName", liferayPortletResponse.getNamespace() + "selectPosition");
	portletURL.setParameter("mvcPath", "/html/admin/select_position.jsp");
	portletURL.setParameter("eventName", eventName);
	if(Validator.isNotNull(divisionName)) {
		portletURL.setParameter("divisionName", divisionName);
	}
	if(Validator.isNotNull(departmentName)) {
		portletURL.setParameter("departmentName", departmentName);
	}
	if(Validator.isNotNull(vacancyStatus)) {
		portletURL.setParameter("vacancyStatus", vacancyStatus);
	}
	if(Validator.isNotNull(position)) {
		portletURL.setParameter("position", position);
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

<aui:form name="selectPositionForm">
	<aui:button cssClass="selector-button" value="Confirm" />
	<aui:button value="Cancel"
		onClick='<%=renderResponse.getNamespace()+ "cancel();"%>'></aui:button>
</aui:form>

<portlet:actionURL var="searchSapPositionURL" windowState="normal">
	<portlet:param name="mvcPath" value="/html/admin/select_position.jsp" />
	<portlet:param name="eventName" value="<%=eventName%>" />
</portlet:actionURL>

<aui:form action="<%=searchSapPositionURL%>" method="post" name="fm">
	<aui:fieldset>
		<div class="searchbox">	
			<ul>
				<li class="sd01"><liferay-ui:message key="vgc.apon.search.divisionName"></liferay-ui:message></li>
				<li class="sd02">
					<input  type="text" name="<portlet:namespace/>divisionName" value="<%=divisionName==null?"":divisionName%>" maxlength="75"/>
				</li>
				<li class="sd01"><liferay-ui:message key="vgc.apon.search.departmentName"></liferay-ui:message></li>
				<li class="sd02"><input  type="text" name="<portlet:namespace/>departmentName" value="<%=departmentName==null?"":departmentName%>" maxlength="75"/></li>
			</ul>
			<ul>
				<li class="sd01"><liferay-ui:message key="vgc.apon.search.vacancyStatus"></liferay-ui:message></li>
				<li class="sd02">					
					<select name="<portlet:namespace/>vacancyStatus">
						<%
							String selected="";
							for(String status:ApplicantConstrant.VACANCYSTATUSLIST){
								if(status.equals(vacancyStatus)){
									selected="selected='selected'";
								}								
						%>
						<option value="<%=status%>"><%=status%></option>
						<%
							}
						%>
					</select>
				</li>
				<li class="sd01"><liferay-ui:message
							key="vgc.apon.search.positionName"></liferay-ui:message></li>
				<li class="sd02">					
					<input  type="text" name="<portlet:namespace/>position" value="<%=position==null?"":position%>" maxlength="75"/>
				</li>
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

<liferay-ui:search-container
	emptyResultsMessage="vgc.apon.there.are.no.position.to.be.display"
	iteratorURL="<%=portletURL%>" var="positionSearchContainer">
	<liferay-ui:search-container-results>
		<%
		List<SapPosition> result=SapPositionLocalServiceUtil.findByD_D_V_P(divisionName, departmentName, vacancyStatus, position,positionSearchContainer.getStart(),positionSearchContainer.getEnd());
		pageContext.setAttribute("results", result);
		pageContext.setAttribute("total", SapPositionLocalServiceUtil.findByD_D_V_P(divisionName, departmentName, vacancyStatus,position).size());
		%>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row
		className="com.vgc.apon.model.SapPosition" keyProperty="sapPositionId"
		modelVar="sapPosition" escapedModel="<%=true%>">
		<liferay-ui:search-container-column-text>
			<input type="radio" name="radio"
				value="<%=sapPosition.getPositionId()+"/"+sapPosition.getPositionName()%>" />
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Division"
			value="<%=sapPosition.getDivisionName()%>" />
		<liferay-ui:search-container-column-text name="Department"
			value="<%=sapPosition.getDepartmentName()%>" />
		<liferay-ui:search-container-column-text name="Position"
			value="<%=sapPosition.getPositionName()%>" />
		<liferay-ui:search-container-column-text name="Position Code"
			value="<%=sapPosition.getPositionId()%>" />
		<liferay-ui:search-container-column-text name="Vacancy Status"
			value="<%=sapPosition.getVacancyStatus()%>" />
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>

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
			var array=value.split("/");
			result['positionCode']=array[0];
			result['positionName']=array[1];
			Util.getOpener().Liferay.fire('<%= HtmlUtil.escapeJS(eventName) %>',result);
			Util.getWindow().destroy();
					}
		},
		'.selector-button'
	);
</aui:script>

