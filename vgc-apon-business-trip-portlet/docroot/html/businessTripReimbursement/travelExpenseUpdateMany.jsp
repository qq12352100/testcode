<%@include file="/html/init.jsp"%>
<%

	String selectedRateUrl = "/html/businessTripReimbursement/travelExpenseRateOfDmaSelectedForUpdateMany.jsp";
	PortletURL iteratorURL = renderResponse.createRenderURL();
	String eventName = ParamUtil.getString(request, "eventName", liferayPortletResponse.getNamespace() + "AddBusinessTripReimbursement");
	
	String tabs2 = ParamUtil.getString(request, "tabs2","travelExpense");
	int tripType_val = ParamUtil.getInteger(request, "tripType",0);
	Boolean isNew=true;
	long businessTripReimbursementId=ParamUtil.getInteger(request, "businessTripReimbursementId",0);
	String tripType = PropsUtil.get("vgc.apon.business.trip.reimbursement.type");
	iteratorURL.setParameter("mvcPath", "/html/businessTripReimbursement/travelExpenseUpdateMany.jsp");
	iteratorURL.setParameter("eventName", eventName);
	iteratorURL.setParameter("tabs2","travelExpense");
	iteratorURL.setParameter("businessTripReimbursementId",String.valueOf(businessTripReimbursementId));
	double totalTravelExpenseRmb= ParamUtil.getDouble(request,"totalTravelExpenseRmb",0d);
	double totalTravelExpenseEur= ParamUtil.getDouble(request,"totalTravelExpenseEur",0d);
%>
<portlet:actionURL var="updateMoreURL" windowState="normal">
	<portlet:param name="updateMore" value="Yes"/>
	<portlet:param name="tabs2" value="travelExpense"/>
</portlet:actionURL>
<div>Remark: Please tick mark if you need daily meal allowance.</div>
<aui:form method="post" name="fm" action="<%=updateMoreURL %>">
<liferay-ui:search-container delta='<%=Integer.valueOf(PropsUtil.get("vgc.apon.invalid.delta"))%>' iteratorURL="<%=iteratorURL %>">
	<liferay-ui:search-container-results results="<%=BtTravelExpenseLocalServiceUtil.findByB_T(businessTripReimbursementId, tripType,searchContainer.getStart(),searchContainer.getEnd())%>"
		total="<%=BtTravelExpenseLocalServiceUtil.findCountByB_T(
							businessTripReimbursementId, tripType)%>">
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="com.business.trip.model.BtTravelExpense" keyProperty="btTravelExpenseId" modelVar="btTravelExpense" escapedModel="<%=true%>">
	<% String id=String.valueOf(btTravelExpense.getBtTravelExpenseId()); %>
	<portlet:renderURL var="selectRateOfDma" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
		<portlet:param name="mvcPath" value="<%=selectedRateUrl%>" />
		<portlet:param name="country" value="<%=btTravelExpense.getCountry()%>" />
		<portlet:param name="city" value="<%=btTravelExpense.getCity()%>" />
		<portlet:param name="id" value="<%=id %>" />
		</portlet:renderURL>
	<% 
	String url="javascript:"+ renderResponse.getNamespace()+ "openSelectedRatePage('"+selectRateOfDma+"','"+id+"')"+ ";";
		
		%>
		<liferay-ui:search-container-column-text name="vgc-apon-business-trip-reimbursement-travel-expense-date">
		<%=btTravelExpense.getTravelDate() %>	
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="vgc-apon-business-trip-reimbursement-travel-expense-departure" property="departure"/>
		<liferay-ui:search-container-column-text name="vgc-apon-business-trip-reimbursement-travel-expense-arrival" property="arrival"/>
		<liferay-ui:search-container-column-text name="vgc-apon-business-trip-reimbursement-travel-expense-from" property="fromCity" />
		<liferay-ui:search-container-column-text name="vgc-apon-business-trip-reimbursement-travel-expense-to" property="toCity" />
		<liferay-ui:search-container-column-text name="vgc-apon-business-trip-reimbursement-travel-expense-breakfast">
			<input type="checkbox" onclick="checkForAllowance(this,'<%=id %>',1)"  <%=btTravelExpense.getIsHasBreakfast() == true ? "checked='checked'": ""%>  maxlength="75" />
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="vgc-apon-business-trip-reimbursement-travel-expense-lunch">
				<input type="checkbox" onclick="checkForAllowance(this,'<%=id %>',2)"  <%=btTravelExpense.getIsHasLunch() == true ? "checked='checked'": ""%>  maxlength="75" />
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="vgc-apon-business-trip-reimbursement-travel-expense-dinner">
				<input type="checkbox" onclick="checkForAllowance(this,'<%=id %>',3)"  <%=btTravelExpense.getIsHasDinner() == true ? "checked='checked'": ""%>  maxlength="75" />
		</liferay-ui:search-container-column-text>
	    <liferay-ui:search-container-column-text name="vgc-apon-business-trip-reimbursement-travel-expense-ratedma">
	    
	    <input type="hidden" name="<portlet:namespace/>isHasBreakfast" id="isHasBreakfast<%=id %>"  value="<%=btTravelExpense.getIsHasBreakfast()%>"/>
	    <input type="hidden" name="<portlet:namespace/>isHasLunch" id="isHasLunch<%=id %>"  value="<%=btTravelExpense.getIsHasLunch()%>"/>
	    <input type="hidden" name="<portlet:namespace/>isHasDinner" id="isHasDinner<%=id %>"  value="<%=btTravelExpense.getIsHasDinner()%>"/>
	    <input type="hidden" name="<portlet:namespace/>departure" id="departure<%=id %>"  value="<%=btTravelExpense.getDeparture()%>"/>
	    <input type="hidden" name="<portlet:namespace/>arrival" id="arrival<%=id %>"   value="<%=btTravelExpense.getArrival()%>"/>
	    <input type="hidden" name="<portlet:namespace/>rateOfDma" id="rateOfDma<%=id %>"  value="<%=btTravelExpense.getRateOfDma()%>"/>
	    <input type="hidden" name="<portlet:namespace/>currency" id="currency<%=id %>" value="<%=btTravelExpense.getCurrency()%>"/>
	    <input type="hidden" name="<portlet:namespace/>allowance" id="allowance<%=id %>" value="<%=btTravelExpense.getAllowance()%>"/>
	    <input type="hidden" name="<portlet:namespace/>city" id="city<%=id %>" value="<%=btTravelExpense.getCity()%>"/>
	    <input type="hidden" name="<portlet:namespace/>country" id="country<%=id %>" value="<%=btTravelExpense.getCountry()%>"/>
	    <input type="hidden" name="<portlet:namespace/>btTravelExpenseId"  value="<%=btTravelExpense.getBtTravelExpenseId()%>"/>
	   	<span id="showRateOfDma<%=id %>"> <%=String.format("%.2f",btTravelExpense.getRateOfDma())%></span>
	    <% if(tripType_val==1){ %>
	    <liferay-ui:icon
							 label="<%=true%>" message="" method="get"  
							url="<%=url %>"
							src='<%=themeDisplay.getPathThemeImages()+"/common/search.png"%>' />
		<%} %>
	    </liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="vgc-apon-business-trip-reimbursement-travel-expense-currency" >
		 	<span id="showCurrency<%=id %>"> <%=btTravelExpense.getCurrency()%></span>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="vgc-apon-business-trip-reimbursement-travel-expense-dally" >
		<span id="showAllowance<%=id %>"> <%=String.format("%.2f",btTravelExpense.getAllowance())%></span>
		
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="vgc-apon-business-trip-reimbursement-travel-expense-comments" property="comments" />
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator paginate="false"/>
</liferay-ui:search-container>
<div class="cetBtn">
			<aui:button-row>
				<aui:button style="margin-right:20px;" cssClass="selector-button"
					value="vgc-apon-button-update" />
				<aui:button type="cancel"
					onClick='<%=renderResponse.getNamespace()+ "cancel();"%>'
					name="vgc-apon-business-trip-application-flight-train-cancel" />
			</aui:button-row>
		</div>
		<input type="hidden" name='<portlet:namespace/>tripType' value="<%=tripType%>"/>
		<input type="hidden" name='<portlet:namespace/>businessTripReimbursementId' value="<%=businessTripReimbursementId%>"/>
		<input type="hidden" name='<portlet:namespace/>totalTravelExpenseRmb' value="<%=totalTravelExpenseRmb%>"/>
		<input type="hidden" name='<portlet:namespace/>totalTravelExpenseEur' value="<%=totalTravelExpenseEur%>"/>
		</aui:form>
<aui:script use="aui-base">
	var Util = Liferay.Util;
	A.one('#<portlet:namespace />fm').delegate(
		'click',
		function(event) {
			var result={};			
			$('#<portlet:namespace />fm').ajaxSubmit({
		        success: function (html,status) {
		        var Util = Liferay.Util;
		        result['tabs2']="travelExpense";
				result['isAdd']="updateMore";
		        Util.getOpener().Liferay.fire('<%= HtmlUtil.escapeJS(eventName) %>',result);
		        Util.getWindow().destroy();
		              }
		          });
		},
		'.selector-button'
	);
</aui:script>
<aui:script>
//Open the add page to add info
function <portlet:namespace />openSelectedRatePage(url,id) {
	var w = 1200;
	var h = 300;
	Liferay.Util.selectEntity(
			{
				dialog: {
					constrain: true,
					modal: true,
					width:w,
					height:h
				},
				id: '<portlet:namespace />SelectedCityRate'+id,
				title: '<liferay-ui:message  key="vgc-apon-business-trip-reimbursement-travel-expense-dally"/>',
				uri:url
			},
			function(event) {
				document.getElementById("showRateOfDma"+id).innerHTML=parseFloat(event.rateOfDma).toFixed(2);
				document.getElementById("showCurrency"+id).innerHTML=event.currency;
				document.getElementById("rateOfDma"+id).value=parseFloat(event.rateOfDma).toFixed(2);
				document.getElementById("currency"+id).value=event.currency;
				document.getElementById("country"+id).value = event.country;
				document.getElementById("city"+id).value = event.city;
				//alert(event.rateOfDma)
				//mathAllowance(id);
			});
		}	
		function checkForAllowance(obj,id,n){
			if(obj.checked){
				if(n==1){
					document.getElementById("isHasBreakfast"+id).value="true";
				}else if(n==2){
					document.getElementById("isHasLunch"+id).value="true";
				}else if(n==3){
					document.getElementById("isHasDinner"+id).value="true";
				}
			}else{
				if(n==1){
					document.getElementById("isHasBreakfast"+id).value="false";
				}else if(n==2){
					document.getElementById("isHasLunch"+id).value="false";
				}else if(n==3){
					document.getElementById("isHasDinner"+id).value="false";
				}
			}
			//mathAllowance(id);
		}
		function mathAllowance(id){
			var allowance =0;
			var departure=document.getElementById("departure"+id).value;
			var	arrival=document.getElementById("arrival"+id).value;
			var rateOfDma=document.getElementById("rateOfDma"+id).value;
			var isHasBreakfast=document.getElementById("isHasBreakfast"+id).value;
			var isHasLunch=document.getElementById("isHasLunch"+id).value;
			var isHasDinner=document.getElementById("isHasDinner"+id).value;
			if (departure=="00:00" && arrival=="23:59") {
				allowance = rateOfDma;
			} else {
				var timesub=subTime(departure,arrival);
				if (timesub > 12) {
					allowance = rateOfDma;
				} else if (timesub > 10 && timesub <= 12) {
					allowance = rateOfDma * 0.8;
				} else if (timesub > 7 && timesub <= 10) {
					allowance = rateOfDma * 0.5;
				} else if (timesub >= 5 && timesub <= 7) {
					allowance = rateOfDma * 0.3;
				} else {
					allowance = 0;
				}
			}
			if (isHasBreakfast!="true") {
				allowance -= rateOfDma * 0.2;
			}
			if (isHasLunch!="true") {
				allowance -= rateOfDma * 0.3;
			}
			if (isHasDinner!="true") {
				allowance -= rateOfDma * 0.3;
			}
			if (allowance < 0) {
				allowance = 0;
			}
			allowance=parseFloat(allowance).toFixed(2);
			document.getElementById("allowance"+id).value=allowance;
			document.getElementById("showAllowance"+id).innerHTML=allowance;
		}
		function subTime(dep,arr){
			var dep_all=parseFloat(dep.split(":")[0])*60+parseFloat(dep.split(":")[1]);
			var arr_all=parseFloat(arr.split(":")[0])*60+parseFloat(arr.split(":")[1]);
			return (arr_all-dep_all)/parseFloat("60");
		}
		function <portlet:namespace/>cancel(){
			var Util = Liferay.Util;
			Util.getWindow().destroy();
		}

		window.onload=function(){
		var buttons=parent.document.getElementsByTagName("button");
		for(var i=0;i<buttons.length;i++){		
			if(buttons[i].className!=null&&buttons[i].className.indexOf("btn close")!=-1){		
				buttons[i].onclick = function(){			
				var Util = Liferay.Util;				
				Util.getWindow().destroy();
			} 
		}
	}
}
</aui:script>







