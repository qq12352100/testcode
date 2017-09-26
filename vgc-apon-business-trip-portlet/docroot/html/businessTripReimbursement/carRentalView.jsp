
	<liferay-ui:search-container delta='<%=Integer.valueOf(PropsUtil.get("vgc.apon.invalid.delta")) %>'>
		
		<liferay-ui:search-container-results results="<%=BtCarRentalInfoLocalServiceUtil.findByB_T(businessTripReimbursementId, tripType, searchContainer.getStart(),searchContainer.getEnd()) %>"
		 total="<%=BtCarRentalInfoLocalServiceUtil.findCountByB_T(businessTripReimbursementId, tripType) %>" >
		</liferay-ui:search-container-results>
	
		<liferay-ui:search-container-row className="com.business.trip.model.BtCarRentalInfo" keyProperty="btCarRentalInfoId" modelVar="btCarRentalInfo" escapedModel="<%= true %>">
	
			<liferay-ui:search-container-column-text name="vgc-apon-business-trip-application-car-rental-pickup-location"
				property="pickupLocation" />
									
			<liferay-ui:search-container-column-text name="vgc-apon-business-trip-application-car-rental-pickup-date-time">
				<%=sdf.format(btCarRentalInfo.getPickupDate()) %>
			</liferay-ui:search-container-column-text>
			
			<liferay-ui:search-container-column-text name="vgc-apon-business-trip-application-car-rental-dropoff-location"
				property="dropoffLocation" />
			
			<liferay-ui:search-container-column-text name="vgc-apon-business-trip-application-car-rental-dropoff-data-time">
				<%=sdf.format(btCarRentalInfo.getDropoffDate()) %>
			</liferay-ui:search-container-column-text>
				
			<portlet:renderURL var="updateURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
				<portlet:param name="bussinessTirpTicketNo2" value="<%=businessTripReimbursement!=null&&businessTripReimbursement.getBussinessTirpTicketNo()!=null?String.valueOf(businessTripReimbursement.getBussinessTirpTicketNo()):\"\" %>"/>
				<portlet:param name="tabs2" value="carRental" />
				<portlet:param name="cmd2" value="update" />
				<portlet:param name="businessTripApplicationId" value="<%=String.valueOf(btCarRentalInfo.getBusinessTripPkId())%>" />					
				<portlet:param name="mvcPath" value="/html/businessTripReimbursement/carRentalAdd.jsp" />
				<portlet:param name="pkId" value="<%=String.valueOf(btCarRentalInfo.getBtCarRentalInfoId())%>" />
			</portlet:renderURL>
			<liferay-ui:search-container-column-text name="vgc-apon-business-trip-application-car-rental-car-type">					
				<a href='#' onclick="<portlet:namespace/>update('<%=updateURL%>','carRental')"><%=btCarRentalInfo.getCarType() %></a>	
			</liferay-ui:search-container-column-text>	
						
			<liferay-ui:search-container-column-text name="vgc-apon-business-trip-application-car-rental-type-of-rental"
				property="typeOfRental" />		
			<liferay-ui:search-container-column-text name="vgc-apon-business-trip-application-car-rental-price">
				<%=String.format("%.2f",btCarRentalInfo.getPrice())%>
			</liferay-ui:search-container-column-text>		
				
			<liferay-ui:search-container-column-text name="vgc-apon-business-trip-application-car-rental-currency"
				property="currency" />	
			
			<liferay-ui:search-container-column-text name="vgc-apon-delete">
				<liferay-ui:icon label="<%= true %>" message="" method="get" id="<%=String.valueOf(btCarRentalInfo.getBtCarRentalInfoId()) %>"					
					url='<%="javascript:" + renderResponse.getNamespace()+ "deleteBtCarRentalInfo("+btCarRentalInfo.getBtCarRentalInfoId()+");"%>' src="<%=trashImage%>" />
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>
			
		<liferay-ui:search-iterator paginate="false" />
	</liferay-ui:search-container>
	
<aui:button-row>
	<aui:button value="vgc.apon.button.add"
		 onClick='<%= renderResponse.getNamespace() + "openAddPageCar();" %>'/>
</aui:button-row>		
	
<aui:script>
	//Delete the BtCarRentalInfo
	function <portlet:namespace/>deleteBtCarRentalInfo(pkId){
		if(confirm('Are you sure to delete it?')) {
			document.<portlet:namespace/>deleteDetailInfoForm.<portlet:namespace/>pkId.value=pkId;
			document.<portlet:namespace />deleteDetailInfoForm.<portlet:namespace />tabs2.value = 'carRental';
			submitForm(document.<portlet:namespace/>deleteDetailInfoForm);
		}
	}
	
	function <portlet:namespace/>openAddPageCar() {
		Liferay.Util.selectEntity(
			{
				dialog: {
					constrain: true,
					modal: true,
					width:1200,
					height:400
				},
				id: '<portlet:namespace />AddBusinessTripReimbursement',
				title: '<liferay-ui:message  key="vgc-apon-add"/>',
				uri:'<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>"><portlet:param name="mvcPath" value="/html/businessTripReimbursement/carRentalAdd.jsp" /><portlet:param name="tabs2" value="carRental" /><portlet:param name="businessTripReimbursementId" value="<%=String.valueOf(businessTripReimbursementId)%>" /></portlet:renderURL>'
			},
			function(event) {
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />pkId.value = event.pkId;
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />tabs2.value = event.tabs2;
				
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />pickupLocation.value = event.pickupLocation;
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />pickupDate.value = event.pickupDate;
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />dropoffLocation.value = event.dropoffLocation;
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />dropoffDate.value = event.dropoffDate;
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />carType.value = event.carType;
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />typeOfRental.value = event.typeOfRental;
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />carPrice.value = event.price;
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />carCurrency.value = event.currency;		
				
				submitForm(document.<portlet:namespace/>addDetailInfoFm);
			}
		);
	}
</aui:script>