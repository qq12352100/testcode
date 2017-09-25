
<%@include file="/html/init.jsp"%>

<%
	String ticketNo=(String)renderRequest.getParameter("ticketNo");
	String printName=(String)renderRequest.getParameter("printName");
	String staffCode=(String)renderRequest.getParameter("staffCode");
	String personalID=(String)renderRequest.getParameter("personalID");
	 
	PortletURL portletURL = renderResponse.createRenderURL();
	String eventName = ParamUtil.getString(request, "eventName", liferayPortletResponse.getNamespace() + "selectBusinessTripApplication");
	portletURL.setParameter("mvcPath", "/html/businessTripReimbursement/select_businessTripApplication.jsp");
	portletURL.setParameter("eventName", eventName);
	if(Validator.isNotNull(ticketNo)) {
		portletURL.setParameter("ticketNo", ticketNo);
	}
	if(Validator.isNotNull(printName)) {
		portletURL.setParameter("printName", printName);
	}
	if(Validator.isNotNull(staffCode)) {
		portletURL.setParameter("staffCode", staffCode);
	}
	if(Validator.isNotNull(personalID)) {
		portletURL.setParameter("personalID", personalID);
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

<aui:form name="selectBusinessTripApplicationForm">
	<aui:button cssClass="selector-button" value="Confirm" />
	<aui:button value="Cancel"
		onClick='<%=renderResponse.getNamespace()+ "cancel();"%>'></aui:button>
</aui:form>

<portlet:actionURL var="searchBusinessTripApplicationURL" name="searchBusinessTripApplication" windowState="normal">
	<portlet:param name="mvcPath" value="/html/businessTripReimbursement/select_businessTripApplication.jsp" />
	<portlet:param name="eventName" value="<%=eventName%>" />
</portlet:actionURL>

<aui:form action="<%=searchBusinessTripApplicationURL%>" method="post" name="fm">
	<aui:fieldset>
		<div class="searchbox">	
			<ul>
				<li class="sd01"><liferay-ui:message key="Ticket No"></liferay-ui:message></li>
				<li class="sd02">
					<input  type="text" name="<portlet:namespace/>ticketNo" value="<%=ticketNo==null?"":ticketNo%>" maxlength="75"/>
				</li>
				<li class="sd01"><liferay-ui:message key="Print Name"></liferay-ui:message></li>
				<li class="sd02"><input  type="text" name="<portlet:namespace/>printName" value="<%=printName==null?"":printName%>" maxlength="75"/></li>
			</ul>
			<ul>
				<li class="sd01"><liferay-ui:message key="Staff Code"></liferay-ui:message></li>
				<li class="sd02">					
					<input  type="text" name="<portlet:namespace/>staffCode" value="<%=staffCode==null?"":staffCode%>" maxlength="75"/>
				</li>
				<li class="sd01"><liferay-ui:message
							key="Personal ID"></liferay-ui:message></li>
				<li class="sd02">					
					<input  type="text" name="<portlet:namespace/>personalID" value="<%=personalID==null?"":personalID%>" maxlength="75"/>
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
	emptyResultsMessage=""
	iteratorURL="<%=portletURL%>" var="personalIDSearchContainer">
	<liferay-ui:search-container-results>
		<%
		List<BusinessTripApplication> result=BusinessTripApplicationLocalServiceUtil.findByT_P_S_P(ticketNo, printName, staffCode, personalID,themeDisplay.getUserId(),personalIDSearchContainer.getStart(),personalIDSearchContainer.getEnd());
		pageContext.setAttribute("results", result);
		pageContext.setAttribute("total", BusinessTripApplicationLocalServiceUtil.findCountByT_P_S_P(ticketNo, printName, staffCode,personalID,themeDisplay.getUserId()));
		%>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row
		className="com.business.trip.model.BusinessTripApplication" keyProperty="businessTripApplicationId"
		modelVar="businessTripApplication" escapedModel="<%=true%>">
		<liferay-ui:search-container-column-text>
			<input type="radio" name="radio"
				value="<%=businessTripApplication.getTicketNo()%>" />
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Ticket No"
			value="<%=businessTripApplication.getTicketNo()%>" />
		<liferay-ui:search-container-column-text name="Print Name"
			value="<%=businessTripApplication.getPrintName()%>" />
		<liferay-ui:search-container-column-text name="Staff Code"
			value="<%=String.valueOf(businessTripApplication.getStaffCode())%>" />
		<liferay-ui:search-container-column-text name="Personal ID"
			value="<%=businessTripApplication.getPersonalID()%>" />
		<liferay-ui:search-container-column-text name="Departure Date"
			value='<%=businessTripApplication.getDepartureDate()!=null?sdf_dmy.format(businessTripApplication.getDepartureDate()):""%>' />
		<liferay-ui:search-container-column-text name="Return Date"
			value='<%=businessTripApplication.getReturnDate()!=null?sdf_dmy.format(businessTripApplication.getReturnDate()):""%>' />
		<liferay-ui:search-container-column-text name="Purpose of the Trip"
			value="<%=businessTripApplication.getPurposeOfTheTrip()%>" />
		<liferay-ui:search-container-column-text name="Visit Countries/Cities"
			value="<%=businessTripApplication.getVisitCountriesCities()%>" />
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>

<aui:script use="aui-base">
	var Util = Liferay.Util;
	A.one('#<portlet:namespace />selectBusinessTripApplicationForm').delegate(
		'click',
		function(event) {
			var check=A.one("input[type=radio]:checked");
			if(check==null)
				{
				alert("Please Choose one BusinessTripApplication.");
				}else
					{
			var result={};
			var value=check.val();
			result['ticketNo']=value;
			Util.getOpener().Liferay.fire('<%= HtmlUtil.escapeJS(eventName) %>',result);
			Util.getWindow().destroy();
					}
		},
		'.selector-button'
	);
</aui:script>

