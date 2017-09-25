  <% 
String tripTypeCostList="0";
String ticketNo="";
double inlandTotalRmb = 0.0;
double foreignTotalEur = 0.0;
double foreignTotalRmb = 0.0;

boolean updateBTRFlag = false;

if(businessTripReimbursement!=null){
	tripTypeCostList=String.valueOf(businessTripReimbursement.getTripType());
	ticketNo=businessTripReimbursement.getBussinessTirpTicketNo();
	
	String RMB = "RMB";
	String EUR = "EUR";
	List<BtCostList> tempBtCostListRMB = BtCostListLocalServiceUtil.findByB_C(businessTripReimbursementId,RMB);
	if(tempBtCostListRMB!=null){
		for(BtCostList btCost:tempBtCostListRMB){
			inlandTotalRmb += btCost.getPaymentAmount();
		}
		if(inlandTotalRmb!=businessTripReimbursement.getCostListInlandTotalRmb()){
				businessTripReimbursement.setCostListInlandTotalRmb(inlandTotalRmb);
				updateBTRFlag = true;
		}
	}
	List<BtCostList> tempBtCostListEUR = BtCostListLocalServiceUtil.findByB_C(businessTripReimbursementId,EUR);
	if(tempBtCostListEUR!=null){
		for(BtCostList btCost:tempBtCostListEUR){
			foreignTotalEur += btCost.getPaymentAmount();
		}
		double eurtoRmb=BtCostListLocalServiceUtil.addCalculate(0, RMB, 1,EUR );
		foreignTotalRmb = foreignTotalEur*eurtoRmb;
		if(foreignTotalEur!=businessTripReimbursement.getCostListForeignTotalEur() ||
				foreignTotalRmb!=businessTripReimbursement.getCostListForeignTotalRmb()){
				businessTripReimbursement.setCostListForeignTotalEur(foreignTotalEur);
				businessTripReimbursement.setCostListForeignTotalRmb(foreignTotalRmb);
				updateBTRFlag = true;
		}
	}
	if(updateBTRFlag&&!isNew){
			BusinessTripReimbursementLocalServiceUtil.updateBusinessTripReimbursement(businessTripReimbursement);
	}
}
 %>
    
     <liferay-ui:search-container delta='<%=Integer.valueOf(PropsUtil.get("vgc.apon.invalid.delta")) %>'>
		<liferay-ui:search-container-results results="<%=BtCostListLocalServiceUtil.findByBusinessTripPkId(businessTripReimbursementId,searchContainer.getStart(),searchContainer.getEnd()) %>"
		 total="<%=BtCostListLocalServiceUtil.findCountByBusinessTripPkId(businessTripReimbursementId) %>" >
		</liferay-ui:search-container-results>
	
		<liferay-ui:search-container-row className="com.business.trip.model.BtCostList" keyProperty="btCostListId" modelVar="btCostList" escapedModel="<%= true %>">
			<portlet:renderURL var="updateURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
				<portlet:param name="tabs2" value="costList" />
				<portlet:param name="tripType" value="<%=tripTypeCostList%>" />
				<portlet:param name="businessTripApplicationId" value="<%=String.valueOf(btCostList.getBusinessTripPkId())%>" />					
				<portlet:param name="mvcPath" value="/html/businessTripReimbursement/costListAdd.jsp" />
				<portlet:param name="pkId" value="<%=String.valueOf(btCostList.getBtCostListId())%>" />
			</portlet:renderURL>
			
			<portlet:renderURL var="updateEntertainmentURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
				<portlet:param name="tabs2" value="costList" />
				<portlet:param name="ticketNo" value="<%=ticketNo%>" />
				<portlet:param name="businessTripApplicationId" value="<%=String.valueOf(btCostList.getBusinessTripPkId())%>" />					
				<portlet:param name="mvcPath" value="/html/businessTripReimbursement/entertainmentDetailList.jsp" />
				<portlet:param name="pkId" value="<%=String.valueOf(btCostList.getBtCostListId())%>" />
			</portlet:renderURL>
			<liferay-ui:search-container-column-text name="vgc-apon-business-trip-reimbursement-cost-list-item">					
				<a href='#' onclick="<portlet:namespace/>update('<%=(btCostList.getItem()).equals("Entertainment")?updateEntertainmentURL:updateURL%>','<%=(btCostList.getItem()).equals("Entertainment")?"entertainment":"costList"%>')"><%=btCostList.getItem() %></a>		
			</liferay-ui:search-container-column-text>												
			<liferay-ui:search-container-column-text name="vgc-apon-business-trip-reimbursement-cost-list-invoice-amount">
			<%=String.format("%.2f",btCostList.getInvoiceAmount())%>
			</liferay-ui:search-container-column-text>				
			<liferay-ui:search-container-column-text name="vgc-apon-business-trip-reimbursement-cost-list-invoice-currency"
				property="invoiceCurrency" />				
			<liferay-ui:search-container-column-text name="vgc-apon-business-trip-reimbursement-cost-list-country-city"
				property="countryCity" />				
			<liferay-ui:search-container-column-text name="vgc-apon-business-trip-reimbursement-cost-list-payment-currency"
				property="paymentCurrency" />		
			<liferay-ui:search-container-column-text name="vgc-apon-business-trip-reimbursement-cost-list-payment-amount"
				property="paymentAmount" >
				<%=String.format("%.2f",btCostList.getPaymentAmount())%>
			</liferay-ui:search-container-column-text>	
			<liferay-ui:search-container-column-text name="vgc-apon-business-trip-reimbursement-cost-list-rmb-amount"
				property="netAmountRmb" >			
				<%=String.format("%.2f",btCostList.getNetAmountRmb())%>
			</liferay-ui:search-container-column-text>	
			<liferay-ui:search-container-column-text name="vgc-apon-delete">
				<liferay-ui:icon label="<%= true %>" message="" method="get" id="<%=String.valueOf(btCostList.getBtCostListId()) %>"					
					url='<%="javascript:" + renderResponse.getNamespace()+ "deleteBtCostList("+btCostList.getBtCostListId()+");"%>' src="<%=trashImage%>" />
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>	
		<liferay-ui:search-iterator paginate="false" />
	</liferay-ui:search-container>
	
	<aui:button-row>
	<aui:button value="vgc.apon.button.add"
		 onClick='<%= renderResponse.getNamespace() + "openAddPageCost();" %>'/>
    </aui:button-row>	    
    <!-- this is for total information -->
    <div class="pos">
       <ul>
         <li><h5><liferay-ui:message key="vgc-apon-business-trip-reimbursement-cost-list-inland-total-rmb"/><%=String.format("%.2f",businessTripReimbursement.getCostListInlandTotalRmb())%><liferay-ui:message key="vgc-apon-business-trip-application-hotel-rmb"/></h5></li>
         <li><h5><liferay-ui:message key="vgc-apon-business-trip-reimbursement-cost-list-foreign-total"/><%=String.format("%.2f",businessTripReimbursement.getCostListForeignTotalEur())%><liferay-ui:message key="vgc-apon-business-trip-application-hotel-eur"/>&nbsp;<%=String.format("%.2f",businessTripReimbursement.getCostListForeignTotalRmb())%><liferay-ui:message key="vgc-apon-business-trip-application-hotel-rmb"/></h5></li>
      	 <li><h5><liferay-ui:message key="vgc-apon-business-trip-reimbursement-cost-list-total-inrmb"/><%=String.format("%.2f",businessTripReimbursement.getCostListInlandTotalRmb()+businessTripReimbursement.getCostListForeignTotalRmb())%><liferay-ui:message key="vgc-apon-business-trip-application-hotel-rmb"/></h5>
       </ul>   
    </div>
  
<aui:script>
    //Delete the BtCostList
	function <portlet:namespace/>deleteBtCostList(pkId){
		if(confirm('Are you sure to delete it?')) {
			document.<portlet:namespace/>deleteDetailInfoForm.<portlet:namespace/>pkId.value=pkId;
			document.<portlet:namespace />deleteDetailInfoForm.<portlet:namespace />tabs2.value = 'costList';
			submitForm(document.<portlet:namespace/>deleteDetailInfoForm);
		}
	}
	function <portlet:namespace/>openAddPageCost() {
		 var radionum = document.getElementsByName("<portlet:namespace />tripType");
		 var  travelTypeVal=-1;
		 for(var i=0;i<radionum.length;i++){
			 if(radionum[i].checked){
				 travelTypeVal = radionum[i].value
			 } }
		
		Liferay.Util.selectEntity(
			{
				dialog: {
					constrain: true,
					modal: true,
					width:1200,
					height:550
				},
				id: '<portlet:namespace />AddBusinessTripReimbursement',
				title: '<liferay-ui:message  key="vgc-apon-add"/>',
				uri:'<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>"><portlet:param name="tripType" value="<%=tripTypeCostList%>" /><portlet:param name="mvcPath" value="/html/businessTripReimbursement/costListAdd.jsp" /><portlet:param name="ticketNo" value="<%=ticketNo%>" /><portlet:param name="tabs2" value="costList" /><portlet:param name="businessTripReimbursementId" value="<%=String.valueOf(businessTripReimbursementId)%>" /></portlet:renderURL>'+'&<portlet:namespace />travelTypeVal='+travelTypeVal
			},
			function(event) {				
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />pkId.value = event.pkId;
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />tabs2.value = event.tabs2;
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />btCostListId.value = event.btCostListId;
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />item.value = event.item;
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />costType.value = event.type;
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />invoiceAmount.value = event.invoiceAmount;
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />invoiceCurrency.value = event.invoiceCurrency;
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />countryCity.value = event.countryCity;
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />paymentCurrency.value = event.paymentCurrency;
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />paymentAmount.value = event.paymentAmount;
				
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />netAmount.value = event.netAmount;
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />taxAmount.value = event.taxAmount;
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />taxRate.value = event.taxRate;
				
				submitForm(document.<portlet:namespace/>addDetailInfoFm);
			}
		);
	}
	
	//------------------------------------------------------------
	function <portlet:namespace/>openAddPageEntertainmentInfo() {
		Liferay.Util.selectEntity(
				{
					dialog: {
						constrain: true,
						modal: true,
						width:1400,
						height:690
					},
					id: '<portlet:namespace />AddEntertainmentItem',
					title: '<liferay-ui:message  key="vgc-apon-business-trip-reimbursement-cost-list-entertainment-detail-list"/>',
					uri:'<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>"><portlet:param name="mvcPath" value="/html/businessTripReimbursement/entertainmentDetailList.jsp" /><portlet:param name="tabs2" value="costList" /><portlet:param name="ticketNo" value="<%=ticketNo%>"/><portlet:param name="businessTripReimbursementId" value="<%=String.valueOf(businessTripReimbursementId)%>" /></portlet:renderURL>'
				},
				function(event){
					document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />pkId.value = event.pkId;
					document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />tabs2.value = event.tabs2;
					document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />businessTripReimbursementId.value = event.businessTripReimbursementId;
					document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />btCostListId.value = event.btCostListId;
					document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />entertainmentDate.value = event.entertainmentDate;
					document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />entertainmentType.value = event.entertainmentType;
					document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />entertainmentPlace.value = event.entertainmentPlace;
					document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />countryCity.value = event.countryCity;
					document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />btEntertainmentDetailId.value = event.btEntertainmentDetailId;
					document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />fullName.value = event.fullName;
					document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />positionTitle.value = event.positionTitle;
					document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />company.value = event.company;						
					document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />reasonsInfo.value = event.reasonsInfo;
					document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />paymentCurrency.value = event.paymentCurrency;
					document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />amountTotal.value = event.amountTotal;
					document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />averageSpend.value = event.averageSpend;					
					document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />attendeesTotal.value = event.attendeesTotal;
					document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />mealCategory.value = event.mealCategory;
					document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />isEntertainment.value ='true';
					document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />netAmount.value = event.netAmount;
					document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />taxAmount.value = event.taxAmount;
					document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />taxRate.value = event.taxRate;
					
					submitForm(document.<portlet:namespace/>addDetailInfoFm);
				}
			);
		//close the entertainmentDetail
		//Util.getWindow().destroy();
	}
</aui:script>