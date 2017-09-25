
	<liferay-ui:search-container var="searchContainer1" delta='<%=Integer.valueOf(PropsUtil.get("vgc.apon.invalid.delta")) %>'>
		
		<liferay-ui:search-container-results results="<%=BtTrainInfoLocalServiceUtil.findByB_T(businessTripReimbursementId, tripType, searchContainer1.getStart(),searchContainer1.getEnd()) %>"
		 total="<%=BtTrainInfoLocalServiceUtil.findCountByB_T(businessTripReimbursementId, tripType) %>" >
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
				<portlet:param name="bussinessTirpTicketNo2" value="<%=businessTripReimbursement!=null&&businessTripReimbursement.getBussinessTirpTicketNo()!=null?String.valueOf(businessTripReimbursement.getBussinessTirpTicketNo()):\"\" %>"/>
				<portlet:param name="tabs2" value="train" />
				<portlet:param name="cmd2" value="update" />
				<portlet:param name="businessTripApplicationId" value="<%=String.valueOf(btTrainInfo.getBusinessTripPkId())%>" />					
				<portlet:param name="mvcPath" value="/html/businessTripReimbursement/trainInformationAdd.jsp" />
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
	<aui:button value="vgc.apon.button.add"
		 onClick='<%= renderResponse.getNamespace() + "openAddPageTrain();" %>'/>
</aui:button-row>	
	
<aui:script>
	//Delete the BtTrainInfo
	function <portlet:namespace/>deleteBtTrainInfo(pkId){
		if(confirm('Are you sure to delete it?')) {
			document.<portlet:namespace/>deleteDetailInfoForm.<portlet:namespace/>pkId.value=pkId;
			document.<portlet:namespace />deleteDetailInfoForm.<portlet:namespace />tabs2.value = 'train';
			submitForm(document.<portlet:namespace/>deleteDetailInfoForm);
		}
	}
	
	function <portlet:namespace/>openAddPageTrain() {
		Liferay.Util.selectEntity(
			{
				dialog: {
					constrain: true,
					modal: true,
					width:1200,
					height:300
				},
				id: '<portlet:namespace />AddBusinessTripReimbursement',
				title: '<liferay-ui:message  key="vgc-apon-add"/>',
				uri:'<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>"><portlet:param name="mvcPath" value="/html/businessTripReimbursement/trainInformationAdd.jsp" /><portlet:param name="tabs2" value="train" /><portlet:param name="businessTripReimbursementId" value="<%=String.valueOf(businessTripReimbursementId)%>" /></portlet:renderURL>'
			},
			function(event) {
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />pkId.value = event.pkId;
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />tabs2.value = event.tabs2;
				
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />fromCity.value = event.fromCity;
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />toCity.value = event.toCity;
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />departureDate.value = event.departureDate;
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />departureTrain.value = event.departureTrain;
				document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />classInfo.value = event.classInfo;
				
				submitForm(document.<portlet:namespace/>addDetailInfoFm);
			}
		);
	}
</aui:script>