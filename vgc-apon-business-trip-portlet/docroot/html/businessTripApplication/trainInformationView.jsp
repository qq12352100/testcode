
<liferay-ui:search-container delta='<%=Integer.valueOf(PropsUtil.get("vgc.apon.invalid.delta")) %>'>
	
	<liferay-ui:search-container-results results="<%=BtTrainInfoLocalServiceUtil.findByB_T(businessTripApplicationId, tripType, searchContainer.getStart(),searchContainer.getEnd()) %>"
	 total="<%=BtTrainInfoLocalServiceUtil.findCountByB_T(businessTripApplicationId, tripType) %>" >
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row className="com.business.trip.model.BtTrainInfo" keyProperty="btTrainInfoId" modelVar="btTrainInfo" escapedModel="<%= true %>">

		<liferay-ui:search-container-column-text name="vgc-apon-business-trip-application-train-from"
			property="fromCity" />					
		<liferay-ui:search-container-column-text name="vgc-apon-business-trip-application-train-to"
			property="toCity" />
		<liferay-ui:search-container-column-text name="vgc-apon-business-trip-application-train-departure-date">
			<%=sdf.format(btTrainInfo.getDepartureDate()) %>
		</liferay-ui:search-container-column-text>
			
		<portlet:renderURL var="updateURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
			<portlet:param name="tabs2" value="train" />
			<portlet:param name="businessTripApplicationId" value="<%=String.valueOf(btTrainInfo.getBusinessTripPkId())%>" />					
			<portlet:param name="mvcPath" value="/html/businessTripApplication/trainInformationAdd.jsp" />
			<portlet:param name="pkId" value="<%=String.valueOf(btTrainInfo.getBtTrainInfoId())%>" />
		</portlet:renderURL>
		<liferay-ui:search-container-column-text name="vgc-apon-business-trip-application-train-departure-train">
			<a href='#' onclick="<portlet:namespace/>update('<%=updateURL%>','train')"><%=btTrainInfo.getDepartureTrain() %></a>	
		</liferay-ui:search-container-column-text>	
		
		<liferay-ui:search-container-column-text name="vgc-apon-business-trip-application-train-class"
			property="classInfo" />				
		
		<liferay-ui:search-container-column-text name="vgc-apon-delete">
			<liferay-ui:icon label="<%= true %>" message="" method="get" id="<%=String.valueOf(btTrainInfo.getBtTrainInfoId()) %>"					
				url='<%="javascript:" + renderResponse.getNamespace()+ "deleteBtTrainInfo("+btTrainInfo.getBtTrainInfoId()+");"%>' src="<%=trashImage%>" />
		</liferay-ui:search-container-column-text>
		
	</liferay-ui:search-container-row>
		
		<liferay-ui:search-iterator paginate="false" />
</liferay-ui:search-container>

<aui:button-row>
	<aui:button value="vgc.apon.button.add" name="addTrainInfoButton"/>
</aui:button-row>	

<aui:script>
//Delete the BtTrainInfo
function <portlet:namespace/>deleteBtTrainInfo(pkId){
	if(confirm('Are you sure to delete it?')) {
		document.<portlet:namespace/>deleteDetailInfoForm.<portlet:namespace/>pkId.value=pkId;
		document.<portlet:namespace />deleteDetailInfoForm.<portlet:namespace />tabs2.value = 'train';
		
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
	
	A.one('#<portlet:namespace />addTrainInfoButton').on(
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
					uri:'<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>"><portlet:param name="mvcPath" value="/html/businessTripApplication/trainInformationAdd.jsp" /><portlet:param name="tabs2" value="train" /><portlet:param name="businessTripApplicationId" value="<%=String.valueOf(businessTripApplicationId)%>" /></portlet:renderURL>'
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
					document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />departureTrain.value = event.departureTrain;
					document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />classInfo.value = event.classInfo;
					if(event.fromCity!=""){
						submitForm(document.<portlet:namespace/>addDetailInfoFm);
					}
				}
			);
		}
	);
</aui:script>