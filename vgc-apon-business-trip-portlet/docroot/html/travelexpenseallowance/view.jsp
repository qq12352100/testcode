<%@include file="/html/init.jsp"%>
<%
	String startDate = ParamUtil.getString(renderRequest, "startDate");
	String 	endDate = ParamUtil.getString(renderRequest, "endDate");
	 Calendar cal = Calendar.getInstance();
	    int day = cal.get(Calendar.DATE);
	    int month = cal.get(Calendar.MONTH) + 1;
	    int year = cal.get(Calendar.YEAR);
	if((startDate==null||startDate.equals(""))&&(endDate==null||endDate.equals(""))){
		startDate="20."+month+"."+year;
			cal.setTime(sdf_dmy.parse(startDate));
			cal.add(Calendar.MONTH, 1);
			endDate=sdf_dmy.format(cal.getTime());
	}
	
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("startDate", startDate);
	portletURL.setParameter("endDate", endDate);
%>

<portlet:resourceURL var="exportExcelREURL"></portlet:resourceURL>
<portlet:actionURL var="queryBusinessTripReimbursementAsTravelAllowance" windowState="normal">
</portlet:actionURL>
<aui:form action="<%=queryBusinessTripReimbursementAsTravelAllowance %>" method="post" name="fm">
	<aui:fieldset>
		<table>
			<tr>
				<td colspan="6"><strong><%=themeDisplay.getPortletDisplay().getTitle()%></strong></td>
			</tr>
			<tr>
				<td colspan="6">	<aui:button-row>
		<aui:button onClick='<%= renderResponse.getNamespace() + "export();" %>'  value="vgc.apon.button.download"/>
	</aui:button-row></td>
			</tr>
			<tr>
				<td width="6%"><Strong><liferay-ui:message
							key="vgc.apon.timeFrom"></liferay-ui:message></Strong></td>
				<td width="8%">
					<input class="Wdate" type="text" id="timeFromId" name="<portlet:namespace/>startDate" value="<%=startDate%>" onFocus="WdatePicker({lang:'en',dateFmt:'dd.MM.yyyy',maxDate:'#F{$dp.$D(\'timeToId\')}'})"/>
				</td>
				<td width="6%"><Strong><liferay-ui:message
							key="vgc.apon.timeTo"></liferay-ui:message></Strong></td>
				<td width="8%">
					<input class="Wdate" type="text" id="timeToId" name="<portlet:namespace/>endDate" value="<%=endDate %>" onFocus="WdatePicker({lang:'en',dateFmt:'dd.MM.yyyy',minDate:'#F{$dp.$D(\'timeFromId\')}'})"/>
				</td>
				<td width="10%"><liferay-ui:icon iconCssClass="icon-search"
						label="<%=true%>" linkCssClass="btn"
						message="vgc.apon.button.search"
						url='<%="javascript:" + renderResponse.getNamespace()
							+ "query();"%>' />
				</td>
			</tr>

		</table>
	</aui:fieldset>
</aui:form>

<liferay-ui:search-container
	delta='<%=Integer.valueOf(PropsUtil.get("vgc.apon.delta"))%>' iteratorURL="<%=portletURL %>">

	<liferay-ui:search-container-results
		results="<%=BtTravelExpenseLocalServiceUtil
							.getDomesticBusinessTripReimbursementTravelExpenses(startDate,endDate,
									searchContainer.getStart(),
									searchContainer.getEnd())%>"
		total="<%=(int) BtTravelExpenseLocalServiceUtil
							.getDomesticBusinessTripReimbursementTravelExpensesCount(startDate,endDate)%>">
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row
		className="com.business.trip.model.BusinessTripReimbursement"
		keyProperty="businessTripReimbursementId"
		modelVar="businessTripReimbursement" escapedModel="<%=true%>">
		<liferay-ui:search-container-column-text
			name="vgc-apon-business-trip-application-ticket-no">
			<%=businessTripReimbursement
								.getBussinessTirpTicketNo()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text
			name="vgc-apon-business-trip-application-personal-number">
			<%=businessTripReimbursement.getStaffCode()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text
			name="vgc-apon-business-trip-application-print-name">
			<%=businessTripReimbursement.getPrintName()%>
		</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text
			name="vgc-apon-business-trip-reimbursement-travel-expense-date">
			<%=businessTripReimbursement.getStatusDate()%>
		</liferay-ui:search-container-column-text>
		<%
		String lgart = "";
		String lgart_test="";
		%>
			<liferay-ui:search-container-column-text
			name="vgc-apon-business-trip-reimbursement-payroll-wage-type">
			<%
				SAPUser sapUser = SAPUserLocalServiceUtil
									.getSapUserByStaffCode(String
											.valueOf(businessTripReimbursement
													.getStaffCode()));
							
							if (sapUser != null
									&& (sapUser.getEmployeeGroupId().equals("1") || sapUser
											.getEmployeeGroupId().equals("9"))) {
								lgart = "1691";
								lgart_test="Travel Allowance";
							} else if (sapUser != null
									&& sapUser.getEmployeeGroupId().equals("3")) {
								if(sapUser.getPayrollArea()!=null&&sapUser.getPayrollArea().equalsIgnoreCase("F2")){
									lgart = "8091";
									lgart_test="Travel Allowance-Domestic";
								}else if(sapUser.getPayrollArea()!=null&&(sapUser.getPayrollArea().equalsIgnoreCase("V1")||sapUser.getPayrollArea().equalsIgnoreCase("V4"))){
									lgart = "1691";
									lgart_test="Travel Allowance";
								}
							}else if (sapUser != null
									&& (sapUser.getEmployeeGroupId().equals("5"))){
								lgart = "8091";
								lgart_test="Travel Allowance-Domestic";
							} else if (sapUser != null
									&& (sapUser.getEmployeeGroupId().equals("4") || sapUser
											.getEmployeeGroupId().equals("6"))) {
								lgart = "2009";
								lgart_test="Gross Amount";
							} else if (sapUser != null
									&& (sapUser.getEmployeeGroupId().equals("7") || sapUser
											.getEmployeeGroupId().equals("8"))) {
								lgart = "N/A";
								lgart_test= "N/A";
							} else {
								lgart = "N/A";
								lgart_test= "N/A";
							}
			%>
			<%=lgart %>
		</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text
			name="vgc-apon-business-trip-reimbursement-payroll-wage-type-test">
			<%=lgart_test %>
		</liferay-ui:search-container-column-text>
		<% 
		double amount=0d;
		if(businessTripReimbursement.getTripType()==0){
			amount=businessTripReimbursement.getTotalTravelExpenseRmb();
		}else{
			amount=BtTravelExpenseLocalServiceUtil.findSumByCurrency(businessTripReimbursement.getBusinessTripReimbursementId(), "RMB");
		} 
		%>
			<liferay-ui:search-container-column-text
			name="vgc-apon-business-trip-reimbursement-payroll-amount">
			<%=String.valueOf(amount)%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text
			name="vgc-apon-business-trip-reimbursement-payroll-currency">
			<%="RMB"%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text
			name="vgc-apon-business-trip-reimbursement-payroll-number">
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>
<aui:script>
	function <portlet:namespace/>query() {
		var formId = "<portlet:namespace />fm";
		document.getElementById(formId).submit();
	}
	

//Export the excel
function <portlet:namespace/>export() {
	var downloadUrl = '<%=exportExcelREURL %>';		
	window.location.href = downloadUrl;
}
</aui:script>