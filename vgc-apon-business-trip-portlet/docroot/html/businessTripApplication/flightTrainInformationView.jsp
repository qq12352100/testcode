
<liferay-ui:search-container delta='<%=Integer.valueOf(PropsUtil.get("vgc.apon.invalid.delta")) %>'>
	
	<liferay-ui:search-container-results results="<%=BtFlightTrainInfoLocalServiceUtil.findByB_T(businessTripApplicationId, tripType, searchContainer.getStart(),searchContainer.getEnd()) %>"
	 total="<%=BtFlightTrainInfoLocalServiceUtil.findCountByB_T(businessTripApplicationId, tripType) %>" >
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row className="com.business.trip.model.BtFlightTrainInfo" keyProperty="btFlightTrainInfoId" modelVar="btFlightTrainInfo" escapedModel="<%= true %>">

		<liferay-ui:search-container-column-text name="vgc-apon-business-trip-application-flight-train-from"
			property="fromCity" />					
		<liferay-ui:search-container-column-text name="vgc-apon-business-trip-application-flight-train-to"
			property="toCity" />
		<liferay-ui:search-container-column-text name="vgc-apon-business-trip-application-flight-train-departure-date">
			<%=sdf.format(btFlightTrainInfo.getDepartureDate()) %>
		</liferay-ui:search-container-column-text>
			
		<portlet:renderURL var="updateURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
			<portlet:param name="tabs2" value="flight" />
			<portlet:param name="businessTripApplicationId" value="<%=String.valueOf(btFlightTrainInfo.getBusinessTripPkId())%>" />					
			<portlet:param name="mvcPath" value="/html/businessTripApplication/flightTrainInformationAdd.jsp" />
			<portlet:param name="pkId" value="<%=String.valueOf(btFlightTrainInfo.getBtFlightTrainInfoId())%>" />
		</portlet:renderURL>
		<liferay-ui:search-container-column-text name="vgc-apon-business-trip-application-flight-train-departure-flight">						
			<a href='#' onclick="<portlet:namespace/>update('<%=updateURL%>','flight')"><%=btFlightTrainInfo.getDepartureFlight() %></a>		
		</liferay-ui:search-container-column-text>	
		
		<liferay-ui:search-container-column-text name="vgc-apon-business-trip-application-flight-train-class"
			property="classInfo" />				
		
		<liferay-ui:search-container-column-text name="vgc-apon-delete">
			<liferay-ui:icon label="<%= true %>" message="" method="get" id="<%=String.valueOf(btFlightTrainInfo.getBtFlightTrainInfoId()) %>"					
				url='<%="javascript:" + renderResponse.getNamespace()+ "deleteBtFlightInfo("+btFlightTrainInfo.getBtFlightTrainInfoId()+");"%>' src="<%=trashImage%>" />
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator paginate="false" />
</liferay-ui:search-container>
<div>Remark: Please be aware that your selected flight can not be booked if it is "not best price".</div>

<aui:button-row>
	<aui:button value="vgc.apon.button.add" name="addFilghtInfoButton"/>
</aui:button-row>	

<aui:script>
//Delete the BtFilghtTrainInfo
function <portlet:namespace/>deleteBtFlightInfo(pkId){
	if(confirm('Are you sure to delete it?')) {
		document.<portlet:namespace/>deleteDetailInfoForm.<portlet:namespace/>pkId.value=pkId;
		document.<portlet:namespace />deleteDetailInfoForm.<portlet:namespace />tabs2.value = 'flight';
		
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
	A.one('#<portlet:namespace />addFilghtInfoButton').on(
		'click',
		function(event) {
			<portlet:namespace/>passValueToPortlet();
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
						height:300
					},
					id: '<portlet:namespace />AddBusinessTripApplication',
					title: '<liferay-ui:message  key="vgc-apon-add"/>',
					uri:'<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>"><portlet:param name="mvcPath" value="/html/businessTripApplication/flightTrainInformationAdd.jsp" /><portlet:param name="tabs2" value="flight" /><portlet:param name="businessTripApplicationId" value="<%=String.valueOf(businessTripApplicationId)%>" /></portlet:renderURL>'
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
					
					document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />fromCity.value = event.fromCity;
					document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />toCity.value = event.toCity;
					document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />departureDate_.value = event.departureDate;
					document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />departureFlight.value = event.departureFlight;
					document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />classInfo.value = event.classInfo;
					if(event.fromCity!=""){
						submitForm(document.<portlet:namespace/>addDetailInfoFm);
					}
					
				}
			);
		}
	);
</aui:script>