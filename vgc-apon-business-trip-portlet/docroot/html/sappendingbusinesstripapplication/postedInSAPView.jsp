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
if (renderRequest.getAttribute("sapDocumentId") != null) {
	portletURL.setParameter("sapDocumentId",sapDocumentId);
}

int totalpostinsap=(int)BusinessTripApplicationLocalServiceUtil.findCountByS_U_SAP(0, ticketNo, applicant,1, startDate, endDate,sapDocumentId);
%>


<portlet:renderURL var="PostedInSAPviewUrl">
	<portlet:param name="tabs2" value="Posted In SAP" />
</portlet:renderURL>

<aui:form action="<%=queryBusinessTripApplicationURL%>" method="post"
	name="fm2" style="width:100%">
	<aui:fieldset>
		<div class="searchbox">
			<input type="hidden" name="<portlet:namespace/>tabs2"
				value="Posted In SAP" />
			<ul class="txt2">
				<li class="sd01" style="width:135px;"><liferay-ui:message
						key="vgc.apon.query.ticket.no"></liferay-ui:message></li>
				<li class="sd02" ><input type="text"
					name="<portlet:namespace/>ticketNo" style="width:223px;"
					value="<%=ticketNo != null ? ticketNo : ""%>" maxlength="75"></li>
				<li class="sd01"  style="width:135px;"><liferay-ui:message
						key="vgc-apon-business-trip-sap-applicant-search"></liferay-ui:message></li>
				<li class="sd02" ><input type="text" style="width:223px;"
					name="<portlet:namespace/>applicant"
					value="<%=applicant != null ? applicant : ""%>" maxlength="75"></li>
			</ul>
			<ul>
				<li class="sd01" style="width:135px;"><liferay-ui:message
						key="vgc.apon.query.period"></liferay-ui:message></li>

				<li class="sd03"><input id="d4311" class="Wdate" type="text" style="width:100px;"
					name="<portlet:namespace/>startDate"
					value="<%=startDate == null ? "" : startDate%>"
					onFocus="WdatePicker({lang:'en',dateFmt:'dd.MM.yyyy',maxDate:'#F{$dp.$D(\'d4312\')}'})" />
					~ <input id="d4312" class="Wdate" type="text"
					name="<portlet:namespace/>endDate" style="width:100px;"
					value="<%=endDate == null ? "" : endDate%>"
					onFocus="WdatePicker({lang:'en',dateFmt:'dd.MM.yyyy',minDate:'#F{$dp.$D(\'d4311\')}'})" />
				</li>
					<li class="sd01" style="width:135px;"><liferay-ui:message
						key="vgc-apon-business-trip-sap-document-id-form"></liferay-ui:message></li>
				<li class="sd02" ><input type="text" style="width:223px;"
					name="<portlet:namespace/>sapDocumentId"
					value="<%=sapDocumentId != null ? sapDocumentId : ""%>" maxlength="75"></li>
				
			</ul>
			<ul style="margin-top:10px;">
			<li class="sd01" style="width:135px;"></li>
			<li class="sd02"></li>
			<li style="width:115px;" >
			</li>
			<li  class="sd02" style="width:270px;">
			<liferay-ui:icon iconCssClass="icon-search"
						label="<%=true%>" linkCssClass="btn" message="vgc.apon.search"
						url='<%="javascript:" + renderResponse.getNamespace()
							+ "queryBusinessTripApplicationPostedSAP();"%>' />
			<liferay-ui:icon label="<%=true%>" linkCssClass="btn"
						message="vgc-apon-reimbursement-trip-sap-payment-completed"
						url='<%="javascript:" + renderResponse.getNamespace()
							+ "paymentCompletedSelectedIds();"%>' />
			</li>
			</ul>
		</div>
	</aui:fieldset>
</aui:form>
<div>
	<h5>
		Total result : <%=totalpostinsap %>
	</h5>
</div>
<form name="<portlet:namespace />searchFm2" style="width: 100%">
	<liferay-ui:search-container
		delta='<%=Integer.valueOf(PropsUtil
						.get("vgc.apon.delta"))%>'
		rowChecker="<%=new RowChecker(renderResponse)%>"
		iteratorURL="<%=portletURL%>">

		<liferay-ui:search-container-results
			results="<%=BusinessTripApplicationLocalServiceUtil
							.findByS_U_SAP(0, ticketNo, applicant, 1,
									startDate, endDate,sapDocumentId,
									searchContainer.getStart(),
									searchContainer.getEnd())%>"
			total="<%=(int)BusinessTripApplicationLocalServiceUtil
									.findCountByS_U_SAP(0, ticketNo, applicant,
											1, startDate, endDate,sapDocumentId)%>">
		</liferay-ui:search-container-results>
		<liferay-ui:search-container-row
			className="com.business.trip.model.BusinessTripApplication"
			keyProperty="businessTripApplicationId"
			modelVar="businessTripApplication" escapedModel="<%=true%>">
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
				name="vgc-apon-business-trip-sap-action-time"
				property="modifiedDate" />
			<liferay-ui:search-container-column-text
				name="vgc-apon-business-trip-sap-current-status">
				<%=businessTripApplication.getSapStatus() == 2
								? "Payment Completed"
								: "To Be Paid"%>
			</liferay-ui:search-container-column-text>

			<liferay-ui:search-container-column-text
				name="vgc-apon-business-trip-sap-document-id"
				property="sapDocumentId" />

			<liferay-portlet:renderURL var="openBusinessTripApplicationURL"
				windowState="normal" plid="<%=myApplicationsPlid%>"
				portletName="mysubmissionslist_WAR_vgcaponmysubmissionsportlet">
				<liferay-portlet:param name="mvcPath"
					value="/html/mysubmissionslist/details/business_trip_application_details.jsp" />
				<liferay-portlet:param name="pkId"
					value="<%=String.valueOf(businessTripApplication
								.getBusinessTripApplicationId())%>" />
				<liferay-portlet:param name="tabs2" value="Posted In SAP" />
				<liferay-portlet:param name="operationType" value="PendingToSAP" />
			</liferay-portlet:renderURL>

			<liferay-ui:search-container-column-text
				name="vgc-apon-business-trip-sap-detail">
				<a href='<%=openBusinessTripApplicationURL%>'><img
					src='<%=themeDisplay.getPathThemeImages()
								+ "/diff/vgc_apon_my_applications_details.png"%>' /></a>
			</liferay-ui:search-container-column-text>

		</liferay-ui:search-container-row>


		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</form>

<aui:script>
	function <portlet:namespace/>queryBusinessTripApplicationPostedSAP() {
		var formId = "<portlet:namespace />fm2";
		document.getElementById(formId).submit();
	}

	Liferay.provide(window, '<portlet:namespace />paymentCompletedSelectedIds',
			function() {
				var ids = Liferay.Util.listCheckedExcept(
						document.<portlet:namespace />searchFm2,
						'<portlet:namespace />allRowIds');
				if (ids.length > 0) {
					if (confirm('Are you sure to Payment Completed them?')) {
						paymentCompletedUpdateSAPStatus(ids)
					}
				} else {
					alert("There is no one to choose.");
					return false;
				}
			}, [ 'liferay-util-list-fields' ]);
	function paymentCompletedUpdateSAPStatus(businessTripApplicationIds) {
		AUI()
				.use(
						'aui-io-request',
						function(A) {
							var ajaxRequest = A.io
									.request(
											'<%=ajaxURL %>'
													+ '&<portlet:namespace/>cmd=postedinsap'
													+ '&<portlet:namespace/>businessTripApplicationIds='
													+ businessTripApplicationIds,
											{
												autoLoad : false,
												dataType : 'json',
												on : {
													success : function() {
														var data = this
																.get('responseData');
														if (data == true) {
															alert("Payment Completed Success!");
														} else {
															alert("Payment Completed Failure!");
														}
														window.location = "<%=PostedInSAPviewUrl%>";
													}
												}
											});
							ajaxRequest.start();
						});
	}
</aui:script>