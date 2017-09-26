<% 
String tripTypeString="0";
double travelExpenseTotalRmb = 0.0;
double travelExpenseTotalEur = 0.0;
if(businessTripReimbursement!=null){
	tripTypeString=String.valueOf(businessTripReimbursement.getTripType());
	
	travelExpenseTotalRmb = BtTravelExpenseLocalServiceUtil.findSumByCurrency(businessTripReimbursement.getBusinessTripReimbursementId(), "RMB");
	travelExpenseTotalEur = BtTravelExpenseLocalServiceUtil.findSumByCurrency(businessTripReimbursement.getBusinessTripReimbursementId(), "EUR");
	
	if(businessTripReimbursement.getTotalTravelExpenseRmb()!=travelExpenseTotalRmb||
			businessTripReimbursement.getTotalTravelExpenseEur()!=travelExpenseTotalEur){
		businessTripReimbursement.setTotalTravelExpenseRmb(travelExpenseTotalRmb);
		businessTripReimbursement.setTotalTravelExpenseEur(travelExpenseTotalEur);
		if(!isNew){
			BusinessTripReimbursementLocalServiceUtil.updateBusinessTripReimbursement(businessTripReimbursement);
		}
	}
}
com.business.trip.model.BtTravelExpense btTravelExpense_=BtTravelExpenseLocalServiceUtil.getTravelExpense(businessTripReimbursementId);
 %>
<liferay-ui:search-container delta='<%=Integer.valueOf(PropsUtil.get("vgc.apon.invalid.delta"))%>'>
<% int i = 0;
   int totalCount=BtTravelExpenseLocalServiceUtil.findCountByB_T(businessTripReimbursementId, tripType); 
%> 
	<liferay-ui:search-container-results results="<%=BtTravelExpenseLocalServiceUtil.findByB_T(businessTripReimbursementId, tripType,searchContainer.getStart(),searchContainer.getEnd())%>"
		total="<%=totalCount %>">
							
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="com.business.trip.model.BtTravelExpense" keyProperty="btTravelExpenseId" modelVar="btTravelExpense" escapedModel="<%=true%>">
		<portlet:renderURL var="updateURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
			<portlet:param name="tabs2" value="travelExpense" />
			<portlet:param name="tripType" value="<%=tripTypeString%>" />
			<portlet:param name="businessTripReimbursementId" value="<%=String.valueOf(btTravelExpense.getBusinessTripPkId())%>" />
			<portlet:param name="mvcPath" value="/html/businessTripReimbursement/travelExpenseAdd.jsp" />
			<portlet:param name="pkId" value="<%=String.valueOf(btTravelExpense.getBtTravelExpenseId())%>" />
			
			<portlet:param name="tempRowNum" value="<%=String.valueOf(i) %>" />
			<portlet:param name="tempRowCount" value="<%=String.valueOf(totalCount) %>" />   
		<%  i++;	%>
		
		</portlet:renderURL>
		<liferay-ui:search-container-column-text name="vgc-apon-business-trip-reimbursement-travel-expense-date">
		<a href='#' onclick="<portlet:namespace/>update('<%=updateURL%>','travelExpense')"><%=btTravelExpense.getTravelDate() %></a>	
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="vgc-apon-business-trip-reimbursement-travel-expense-departure" property="departure"/>
		<liferay-ui:search-container-column-text name="vgc-apon-business-trip-reimbursement-travel-expense-arrival" property="arrival"/>
		<liferay-ui:search-container-column-text name="vgc-apon-business-trip-reimbursement-travel-expense-from" property="fromCity" />
		<liferay-ui:search-container-column-text name="vgc-apon-business-trip-reimbursement-travel-expense-to" property="toCity" />
		<liferay-ui:search-container-column-text name="vgc-apon-business-trip-reimbursement-travel-expense-breakfast">
		<%=btTravelExpense.getIsHasBreakfast() == true ? "&radic;": "-"%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="vgc-apon-business-trip-reimbursement-travel-expense-lunch">
		<%=btTravelExpense.getIsHasLunch() == true ?"&radic;": "-"%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="vgc-apon-business-trip-reimbursement-travel-expense-dinner">
		<%=btTravelExpense.getIsHasDinner() == true ?"&radic;": "-"%> 
		</liferay-ui:search-container-column-text>
	    <liferay-ui:search-container-column-text name="vgc-apon-business-trip-reimbursement-travel-expense-ratedma">
	    <%=String.format("%.2f",btTravelExpense.getRateOfDma())%>
	    </liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="vgc-apon-business-trip-reimbursement-travel-expense-currency" property="currency" />
		<liferay-ui:search-container-column-text name="vgc-apon-business-trip-reimbursement-travel-expense-dally" >
		<%=String.format("%.2f",btTravelExpense.getAllowance())%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="vgc-apon-business-trip-reimbursement-travel-expense-dally-rmb" >
		<%=String.format("%.2f",btTravelExpense.getAllowanceRmb())%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="vgc-apon-business-trip-reimbursement-travel-expense-comments" property="comments" />
		<liferay-ui:search-container-column-text name="vgc-apon-delete">
		<liferay-ui:icon label="<%=true%>" message="" method="get" id="<%=String.valueOf(btTravelExpense.getBtTravelExpenseId())%>" url='<%="javascript:"+ renderResponse.getNamespace()+ "deleteBtTravelExpense("+ btTravelExpense.getBtTravelExpenseId()+ ");"%>' src="<%=trashImage%>" />
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator paginate="false" />
</liferay-ui:search-container>
<aui:button-row>
	<aui:button value="vgc-apon-business-trip-reimbursement-travel-expense-addMore"
		onClick='<%= renderResponse.getNamespace() + "openAddPageTravelExpense();" %>' />
		<% if(btTravelExpense_!=null){ %>
			<aui:button value="vgc-apon-business-trip-reimbursement-travel-expense-updateMore"
		onClick='<%= renderResponse.getNamespace() + "openUpdatePageTravelExpense();" %>' />
		<%} %>
</aui:button-row>
<div>
	<h5>
		<liferay-ui:message key="vgc-apon-business-trip-reimbursement-travel-expense-total-rmb"></liferay-ui:message>
		<%=String.format("%.2f",travelExpenseTotalRmb)%>
		<liferay-ui:message key="vgc-apon-business-trip-application-hotel-rmb"></liferay-ui:message>
	</h5>
</div>
<div>
	<h5>
		<liferay-ui:message key="vgc-apon-business-trip-reimbursement-travel-expense-total-eur"></liferay-ui:message>
		<%=String.format("%.2f",travelExpenseTotalEur)%>
		<liferay-ui:message key="vgc-apon-business-trip-application-hotel-eur"></liferay-ui:message>
	</h5>
</div>
<div style="display:none;">
	<h5>
		<liferay-ui:message key="vgc-apon-business-trip-reimbursement-travel-expense-total"></liferay-ui:message>
		<%=String.format("%.2f",businessTripReimbursement.getTotalTravelExpenseRmb())%>
		<liferay-ui:message key="vgc-apon-business-trip-application-hotel-rmb"></liferay-ui:message>
		<%=String.format("%.2f",businessTripReimbursement.getTotalTravelExpenseEur())%>
		<liferay-ui:message key="vgc-apon-business-trip-application-hotel-eur"></liferay-ui:message>
	</h5>
</div>
<div>Remark: Please tick mark if you need daily meal allowance.</div>
<aui:script>
	//Delete the BtTravelExpense
	function <portlet:namespace/>deleteBtTravelExpense(pkId){
		if(confirm('Are you sure to delete it?')) {
			document.<portlet:namespace/>deleteDetailInfoForm.<portlet:namespace/>pkId.value=pkId;
			document.<portlet:namespace />deleteDetailInfoForm.<portlet:namespace />tabs2.value = 'travelExpense';
			submitForm(document.<portlet:namespace/>deleteDetailInfoForm);
		}
	}
	
	function <portlet:namespace/>openAddPageTravelExpense() {
		Liferay.Util.selectEntity(
			{
				dialog: {
					constrain: true,
					modal: true,
					width:1200,
					height:530
				},
				id: '<portlet:namespace />AddBusinessTripReimbursement',
				title: '<liferay-ui:message  key="vgc-apon-add"/>',
				uri:'<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>"><portlet:param name="tripType" value="<%=tripTypeString%>"/><portlet:param name="mvcPath" value="/html/businessTripReimbursement/travelExpenseAddMany.jsp" /><portlet:param name="tabs2" value="travelExpense" /><portlet:param name="businessTripReimbursementId" value="<%=String.valueOf(businessTripReimbursementId)%>" /></portlet:renderURL>'
			},
			function(event) {
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />pkId.value = event.pkId;
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />tabs2.value = event.tabs2;
				
				// by wanghai 
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />isAdd.value = event.isAdd;
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />fromTravelDate.value = event.fromTravelDate;
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />toTravelDate.value = event.toTravelDate;
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />departure.value = event.departure;
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />arrival.value = event.arrival;
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />fromCity.value = event.fromCity;
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />toCity.value = event.toCity;
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />isHasBreakfast.value = event.isHasBreakfast;
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />isHasLunch.value = event.isHasLunch;
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />isHasDinner.value = event.isHasDinner;
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />country.value = event.country;
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />city.value = event.city;
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />rateOfDma.value = event.rateOfDma;
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />currency.value = event.currency;
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />comments.value = event.comments;
				
				submitForm(document.<portlet:namespace/>addDetailInfoFm);
			}
		);
	}
	
	function <portlet:namespace/>openUpdatePageTravelExpense() {
		Liferay.Util.selectEntity(
			{
				dialog: {
					constrain: true,
					modal: true,
					width:1200,
					height:530
				},
				id: '<portlet:namespace />AddBusinessTripReimbursement',
				title: '<liferay-ui:message  key="vgc-apon-update"/>',
				uri:'<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>"><portlet:param name="totalTravelExpenseRmb" value="<%=String.valueOf(totalTravelExpenseRmb)%>"/><portlet:param name="totalTravelExpenseEur" value="<%=String.valueOf(totalTravelExpenseEur)%>"/><portlet:param name="tripType" value="<%=tripTypeString%>"/><portlet:param name="mvcPath" value="/html/businessTripReimbursement/travelExpenseUpdateMany.jsp" /><portlet:param name="tabs2" value="travelExpense" /><portlet:param name="businessTripReimbursementId" value="<%=String.valueOf(businessTripReimbursementId)%>" /></portlet:renderURL>'
			},
			function(event) {
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />pkId.value = event.pkId;
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />tabs2.value = event.tabs2;
				
				// by wanghai 
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />isAdd.value = event.isAdd;
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />fromTravelDate.value = event.fromTravelDate;
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />toTravelDate.value = event.toTravelDate;
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />departure.value = event.departure;
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />arrival.value = event.arrival;
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />fromCity.value = event.fromCity;
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />toCity.value = event.toCity;
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />isHasBreakfast.value = event.isHasBreakfast;
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />isHasLunch.value = event.isHasLunch;
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />isHasDinner.value = event.isHasDinner;
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />country.value = event.country;
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />city.value = event.city;
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />rateOfDma.value = event.rateOfDma;
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />currency.value = event.currency;
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />comments.value = event.comments;
				
				submitForm(document.<portlet:namespace/>addDetailInfoFm);
			}
		);
	}
	
	
</aui:script>