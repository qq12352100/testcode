
<%@page import="com.business.trip.model.BtHotelInfo"%>
<liferay-ui:search-container delta='<%=Integer.valueOf(PropsUtil.get("vgc.apon.invalid.delta")) %>'>
	
	<liferay-ui:search-container-results results="<%=BtHotelInfoLocalServiceUtil.findByB_T(businessTripApplicationId, tripType, searchContainer.getStart(),searchContainer.getEnd()) %>"
	 total="<%=BtHotelInfoLocalServiceUtil.findCountByB_T(businessTripApplicationId, tripType) %>" >
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row className="com.business.trip.model.BtHotelInfo" keyProperty="btHotelInfoId" modelVar="btHotelInfo" escapedModel="<%=true%>">
		<liferay-ui:search-container-column-text name="vgc-apon-business-trip-application-hotel-city"
			property="city"/>
		<liferay-ui:search-container-column-text name="vgc-apon-business-trip-application-hotel-city-type" 
			property="cityType"/>
			
		<portlet:renderURL var="updateURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
			<portlet:param name="tabs2" value="hotelInformation" />
			<portlet:param name="businessTripApplicationId" value="<%=String.valueOf(btHotelInfo.getBusinessTripPkId())%>" />					
			<portlet:param name="mvcPath" value="/html/businessTripApplication/hotelInformationAdd.jsp" />
			<portlet:param name="pkId" value="<%=String.valueOf(btHotelInfo.getBtHotelInfoId())%>" />
		</portlet:renderURL>
		<liferay-ui:search-container-column-text name="vgc-apon-business-trip-application-hotel-hotel">	
			<a href='#' onclick="<portlet:namespace/>update('<%=updateURL%>','hotelInformation')"><%=btHotelInfo.getHotel() %></a>	
		</liferay-ui:search-container-column-text>	
		
		<liferay-ui:search-container-column-text name="vgc-apon-business-trip-application-hotel-check-in">
			<%=sdf.format(btHotelInfo.getCheckIn()) %>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="vgc-apon-business-trip-application-hotel-check-out">
			<%=sdf.format(btHotelInfo.getCheckOut()) %>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="vgc-apon-business-trip-application-hotel-room-category"
			property="roomCategory"/>
		<liferay-ui:search-container-column-text name="vgc-apon-business-trip-application-hotel-price" >
			<%=String.format("%.2f", btHotelInfo.getPrice()) %>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="vgc-apon-business-trip-application-hotel-currency" 
			property="currency"/>
		<liferay-ui:search-container-column-text name="vgc-apon-business-trip-application-hotel-over-budget">
			<%=btHotelInfo.getIsOverBudget()==1?"YES":"NO" %>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="vgc-apon-business-trip-application-hotel-other-reason-of-additional-hotel-cost" 
			property="otherReasonInfo"/>
		<liferay-ui:search-container-column-text name="vgc-apon-business-trip-application-hotel-not-booked-from-travel-agency" >
			<%=btHotelInfo.getIsNotBookedFromTA()?"YES":"NO" %>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="vgc-apon-business-trip-application-hotel-others-please-specify" 
			property="othersSpecify"/>
		<liferay-ui:search-container-column-text name="vgc-apon-delete">
			<liferay-ui:icon label="<%= true %>" message="" method="get" id="<%=String.valueOf(btHotelInfo.getBtHotelInfoId()) %>"					
				url='<%="javascript:" + renderResponse.getNamespace()+ "deleteBtHotelInfo("+btHotelInfo.getBtHotelInfoId()+");"%>' src="<%=trashImage%>" />
		</liferay-ui:search-container-column-text>	
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator paginate="false" />
</liferay-ui:search-container>	

<aui:button-row>
	<aui:button value="vgc.apon.button.add" name="addHotelInfoButton"/>
</aui:button-row>	

	
<aui:script>
//Delete the BtHotelInfo
function <portlet:namespace/>deleteBtHotelInfo(pkId){
	if(confirm('Are you sure to delete it?')) {
		document.<portlet:namespace/>deleteDetailInfoForm.<portlet:namespace/>pkId.value=pkId;
		document.<portlet:namespace />deleteDetailInfoForm.<portlet:namespace />tabs2.value = 'hotelInformation';
		
		 var radionum = document.getElementsByName("<portlet:namespace />tripType");
		 var  val=0;
		 for(var i=0;i<radionum.length;i++){
			 if(radionum[i].checked){
				 val = radionum[i].value
			 } }
		document.<portlet:namespace />deleteDetailInfoForm.<portlet:namespace />tripTypeAsForm.value =val ;
		
		
		<portlet:namespace/>passValueToPortlet();
		submitForm(document.<portlet:namespace/>deleteDetailInfoForm);
	}
}			
</aui:script>	

<aui:script use="aui-base">
	
	A.one('#<portlet:namespace />addHotelInfoButton').on(
		'click',
		function(event) {
			<portlet:namespace/>passValueToPortlet();
			var startDate = document.<portlet:namespace />fm.<portlet:namespace/>departureDate.value;
			if(startDate.trim()=='') {
				alert('Please fill the Departure Date');
				Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace/>departureDate);
				return false;
			}
			var endDate = document.<portlet:namespace />fm.<portlet:namespace/>returnDate.value;
			if(endDate.trim()=='') {
				alert('Please fill the Return Date');
				Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace/>returnDate);
				return false;
			}
			 var radionum = document.getElementsByName("<portlet:namespace />tripType");
			 var  travelTypeVal=-1;
			 for(var i=0;i<radionum.length;i++){
				 if(radionum[i].checked){
					 travelTypeVal = radionum[i].value
				 } }
			if(travelTypeVal==-1){
				alert('Please select Travel Reservation');
				return false;
			}
			
			Liferay.Util.selectEntity(
				{
					dialog: {
						constrain: true,
						modal: true,
						width:1200,
						height:550
					},
					id: '<portlet:namespace />AddBusinessTripApplication',
					title: '<liferay-ui:message  key="vgc-apon-add"/>',
					uri:'<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>"><portlet:param name="mvcPath" value="/html/businessTripApplication/hotelInformationAdd.jsp" /><portlet:param name="tabs2" value="hotelInformation" /><portlet:param name="businessTripApplicationId" value="<%=String.valueOf(businessTripApplicationId)%>" /></portlet:renderURL>'+'&<portlet:namespace />startDate='+startDate+'&<portlet:namespace />endDate='+endDate+'&<portlet:namespace />travelTypeVal='+travelTypeVal
				},
				function(event) {
					document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />pkId.value = event.pkId;
					document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />tabs2.value = event.tabs2;
					
					 var radionum = document.getElementsByName("<portlet:namespace />tripType");
					 var  val=0;
					 for(var i=0;i<radionum.length;i++){
						 if(radionum[i].checked){
							 val = radionum[i].value
						 } }
					document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />tripTypeAsForm.value =val ;
					
					document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />city.value = event.city;
					document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />cityType.value = event.cityType;
					document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />hotel.value = event.hotel;
					document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />checkIn.value = event.checkIn;
					document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />checkOut.value = event.checkOut;
					document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />roomCategory.value = event.roomCategory;
					document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />price.value = event.price;
					document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />currency_.value = event.currency;
					document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />isOverBudget.value = event.isOverBudget;
					document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />otherReasonInfo.value = event.otherReasonInfo;
					document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />isNotBookedFromTA.value = event.isNotBookedFromTA;
					document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />othersSpecify.value = event.othersSpecify;
					if(event.city!=""){
						submitForm(document.<portlet:namespace/>addDetailInfoFm);
					}
					
				}
			);
		}
	);
</aui:script>