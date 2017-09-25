
	<liferay-ui:search-container delta='<%=Integer.valueOf(PropsUtil.get("vgc.apon.invalid.delta")) %>'>
		
		<liferay-ui:search-container-results results="<%=BtFlightTrainInfoLocalServiceUtil.findByB_T(businessTripReimbursementId, tripType, searchContainer.getStart(),searchContainer.getEnd()) %>"
		 total="<%=BtFlightTrainInfoLocalServiceUtil.findCountByB_T(businessTripReimbursementId, tripType) %>" >
		</liferay-ui:search-container-results>
	
		<liferay-ui:search-container-row className="com.business.trip.model.BtFlightTrainInfo" keyProperty="btFlightTrainInfoId" modelVar="btFlightTrainInfo" escapedModel="<%= true %>">
	
			<liferay-ui:search-container-column-text name="vgc-apon-business-trip-application-flight-train-from"
				property="fromCity" />					
			<liferay-ui:search-container-column-text name="vgc-apon-business-trip-application-flight-train-to"
				property="toCity" />
			<liferay-ui:search-container-column-text name="vgc-apon-business-trip-application-flight-train-departure-date">
				<%=sdf.format(btFlightTrainInfo.getDepartureDate()) %>
			</liferay-ui:search-container-column-text>

			<liferay-ui:search-container-column-text name="vgc-apon-business-trip-application-flight-train-departure-flight">					
				<%=btFlightTrainInfo.getDepartureFlight() %>	
			</liferay-ui:search-container-column-text>	
			
			<liferay-ui:search-container-column-text name="vgc-apon-business-trip-application-flight-train-class"
				property="classInfo" />				
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator paginate="false" />
	</liferay-ui:search-container>
	
	<aui:button-row>
		<aui:button type="button" value="vgc-apon-business-trip-reimbursement-import-itinerary" 
			onClick='<%= renderResponse.getNamespace() + "importItinerary()" %>' />
	</aui:button-row>

	 <!-- this is for flightTrainInformation-->
    <div class="pos">
       <ul>
          <li><h5><liferay-ui:message key="vgc-apon-business-trip-application-flight-train-fare-details" /></h5></li>
          <li><h5><liferay-ui:message key="vgc-apon-business-trip-application-flight-train-currency" /><%=businessTripReimbursement.getFlightCurrency()%></h5></li>
          <li><h5><liferay-ui:message key="vgc-apon-business-trip-application-flight-train-air-fare" /><%=String.format("%.2f", businessTripReimbursement.getFlightAirFare())%></h5></li>
          <li><h5><liferay-ui:message key="vgc-apon-business-trip-application-flight-train-taxes" /><%=String.format("%.2f", businessTripReimbursement.getFlightTaxes())%></h5></li>
          <li><h5><liferay-ui:message key="vgc-apon-business-trip-application-flight-train-transaction-fee" /><%=String.format("%.2f", businessTripReimbursement.getFlightTransactionFee())%></h5></li>
          <li><h5><liferay-ui:message key="vgc-apon-business-trip-application-flight-train-total" /><%=String.format("%.2f", businessTripReimbursement.getFlightTotal())%></h5></li>
       </ul>   
    </div>