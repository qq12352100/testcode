<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%
if (renderRequest.getAttribute("startDate") != null&& !renderRequest.getAttribute("startDate").equals("")) {
	portletURL.setParameter("startDate",startDate);
}else{
	 startDate = sdf_dmy.format(ToSAPDateUtil.getCurrYearFirst());
	portletURL.setParameter("startDate",startDate);
}
if (renderRequest.getAttribute("endDate") != null&&!renderRequest.getAttribute("endDate").equals("")) {
	portletURL.setParameter("endDate",endDate);
}else{
	endDate = sdf_dmy.format(ToSAPDateUtil.getCurrYearLast());
	portletURL.setParameter("endDate",endDate);
}
if (renderRequest.getAttribute("applicant") != null) {
	portletURL.setParameter("applicant",applicant);
}
if (renderRequest.getAttribute("ticketNo") != null) {
	portletURL.setParameter("ticketNo",ticketNo);
}	
int totalrejected=(int)BusinessTripReimbursementLocalServiceUtil.findRejectCountByS_U_SAP(ticketNo, applicant,-2, startDate, endDate,sapDocumentId);
%>

<aui:form action="<%=queryBusinessTripReimbursementURL%>" method="post"
	name="fm3" style="width:100%">
	<aui:fieldset>
		<div class="searchbox">
			<ul class="txt2">
				<input type="hidden" name="<portlet:namespace/>tabs2"
					value="Rejected" />
				<li class="sd01"><liferay-ui:message
						key="vgc.apon.query.ticket.no"></liferay-ui:message></li>
				<li class="sd02"><input type="text"
					name="<portlet:namespace/>ticketNo"  style="width:223px;"
					value="<%=ticketNo != null ? ticketNo : ""%>" maxlength="75">
				<li class="sd01"><liferay-ui:message
						key="vgc-apon-business-trip-sap-applicant-search"></liferay-ui:message></li>
				<li class="sd02"><input type="text"
					name="<portlet:namespace/>applicant"  style="width:223px;"
					value="<%=applicant != null ? applicant : ""%>" maxlength="75"></li>
					</ul><ul>
				<li class="sd01"><liferay-ui:message
						key="vgc.apon.query.period"></liferay-ui:message></li>
				<li class="sd03"><input id="d4311" class="Wdate" type="text"
					name="<portlet:namespace/>startDate"  style="width:100px;"
					value="<%=startDate == null ? "" : startDate%>"
					onFocus="WdatePicker({lang:'en',dateFmt:'dd.MM.yyyy',maxDate:'#F{$dp.$D(\'d4312\')}'})" />
					~ <input id="d4312" class="Wdate" type="text"
					name="<portlet:namespace/>endDate"  style="width:100px;"
					value="<%=endDate == null ? "" : endDate%>"
					onFocus="WdatePicker({lang:'en',dateFmt:'dd.MM.yyyy',minDate:'#F{$dp.$D(\'d4311\')}'})" />
				</li>
			<li style="width:250px;" class="sd01"></li>
				<li><liferay-ui:icon iconCssClass="icon-search"
						label="<%=true%>" linkCssClass="btn" message="vgc.apon.search"
						url='<%="javascript:" + renderResponse.getNamespace()
							+ "queryBusinessTripReimbursementRejected();"%>' />

				</li>
			</ul>
		</div>
	</aui:fieldset>
</aui:form>
<div>
	<h5>
		Total result : <%=totalrejected %>
	</h5>
</div>
<liferay-ui:search-container
	delta='<%=Integer.valueOf(PropsUtil.get("vgc.apon.delta"))%>' iteratorURL="<%=portletURL %>">

	<liferay-ui:search-container-results
		results="<%=BusinessTripReimbursementLocalServiceUtil
							.findRejectByS_U_SAP(ticketNo, applicant, -2,
									startDate, endDate,sapDocumentId,
									searchContainer.getStart(),
									searchContainer.getEnd())%>"
		total="<%=(int)BusinessTripReimbursementLocalServiceUtil
									.findRejectCountByS_U_SAP(ticketNo, applicant,
											-2, startDate, endDate,sapDocumentId)%>">
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row
		className="com.business.trip.model.BusinessTripReimbursement"
		keyProperty="businessTripReimbursementId"
		modelVar="businessTripReimbursement" escapedModel="<%=true%>">
		<liferay-ui:search-container-column-text
			name="vgc-apon-business-trip-application-ticket-no"
			property="ticketNo" />

		<liferay-ui:search-container-column-text
			name="vgc-apon-business-trip-sap-applicant-search"
			property="printName" />
		<liferay-ui:search-container-column-text
			name="vgc-apon-business-trip-sap-application-time"
			property="submittedDate" />
		<liferay-ui:search-container-column-text
			name="vgc-apon-business-trip-sap-action-time" property="modifiedDate" />
		<liferay-ui:search-container-column-text
			name="vgc-apon-business-trip-sap-current-status">
			<%=businessTripReimbursement.getSapStatus() == -2
								? "Rejected"
								: ""%>
		</liferay-ui:search-container-column-text>
		<liferay-portlet:renderURL var="openBusinessTripApplicationURL"  windowState="normal"  plid="<%=myApplicationsPlid%>" portletName="mysubmissionslist_WAR_vgcaponmysubmissionsportlet">
		    <liferay-portlet:param name="mvcPath" value="/html/mysubmissionslist/details/business_trip_reimbursement_details.jsp" />
		    <liferay-portlet:param name="pkId" value="<%=String.valueOf(businessTripReimbursement.getBusinessTripReimbursementId()) %>"/>			    
		    <liferay-portlet:param name="tabs2" value="Rejected"/>
		    <liferay-portlet:param name="operationType" value="PendingToSAP"/>
		</liferay-portlet:renderURL>			
		
		<liferay-ui:search-container-column-text
			name="vgc-apon-business-trip-sap-detail">
			<a href='<%=openBusinessTripApplicationURL%>'><img src='<%=themeDisplay.getPathThemeImages()+"/diff/vgc_apon_my_applications_details.png" %>'/></a>
		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>


	<liferay-ui:search-iterator />
</liferay-ui:search-container>

<aui:script>
	function <portlet:namespace/>queryBusinessTripReimbursementRejected() {
		var formId = "<portlet:namespace />fm3";
		document.getElementById(formId).submit();
	}
</aui:script>
	

