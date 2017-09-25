<%@include file="/html/init.jsp"%>
<%@page import="com.business.trip.service.RateCityLocalServiceUtil"%>
<%@page import=" com.business.trip.model.RateCity"%>
<%
String id=ParamUtil.getString(request, "id");
	String eventName = ParamUtil.getString(request, "eventName", liferayPortletResponse.getNamespace() + "SelectedCityRate"+id);
List<RateCity> ratecitys=RateCityLocalServiceUtil.getRateCities(0, Integer.MAX_VALUE);
String country= ParamUtil.getString(request, "country");
String city= ParamUtil.getString(request, "city");

%>
<!-- this is for hotelinformation start -->
<portlet:resourceURL var="ajaxURL"></portlet:resourceURL>
<aui:form method="post" name="fm">
	<aui:fieldset>
		<div class="mainbody">
			<div class="newtb">
				<ul>
				<input type="hidden" id="rateCountry" value="<%=country %>"/>
				<input type="hidden" id="rateCity" value="<%=city %>"/>
					<li class="nd02"><liferay-ui:message
							key="vgc-apon-business-trip-reimbursement-travel-expense-country" /></li>
					<li class="nd02"><liferay-ui:message
							key="vgc-apon-business-trip-reimbursement-travel-expense-city" /></li>
					<li class="nd02"><liferay-ui:message
							key="vgc-apon-business-trip-reimbursement-travel-expense-currency" /></li>
					<li class="nd02"><liferay-ui:message
							key="vgc-apon-business-trip-reimbursement-travel-expense-rate" /></li>

				</ul>
				<ul>
					<li class="nd02">
						<%
							String selected="";
						%>
					<select name="<portlet:namespace/>country" id="country"
						onchange="">
						<% for(RateCity rateCity:ratecitys){
							if(rateCity.getAreaName()!=null&&rateCity.getAreaName().equals(country)&&rateCity.getParentId()==0){
								selected="selected='selected'";
							}else{
								selected="";
							}
							if(rateCity.getAreaName()!=null&&rateCity.getParentId()==0){
							%>
							<option value="<%=rateCity.getRatecityId()%>" <%=selected%>><%=rateCity.getAreaName()%></option>
							<% }
						} %>	
					</select></li>
					
					<li class="nd02">
						<%
							String selectedCity="";
							RateCity parentRateCity=null;
							for(RateCity rateCity:ratecitys){
								if(rateCity.getAreaName()!=null&&rateCity.getAreaName().equals(country)){
									parentRateCity=rateCity;
									break;
								}
								}
						%>
					<select name="<portlet:namespace/>city" id="city">
					<option value="-1">N/A</option>
					<% for(RateCity rateCity:ratecitys){
							
							if(rateCity.getAreaName()!=null&&rateCity.getAreaName().equals(city)&&rateCity.getParentId()==parentRateCity.getRatecityId()){
								selectedCity="selected='selected'";
							}else{
								selectedCity="";
							}
							if(rateCity!=null&&parentRateCity!=null&&rateCity.getParentId()==parentRateCity.getRatecityId()){
							%>
							<option value="<%=rateCity.getRatecityId()%>" <%=selectedCity%>><%=rateCity.getAreaName()%></option>
							<% }
						} %>	
					</select></li>
					<li class="nd02"><input type="text"
						name="<portlet:namespace/>currency" id="currency"
						 disabled/></li>
					<li class="nd02"><input type="text"
						name="<portlet:namespace/>rateOfDma" id="rateOfDma"
						 disabled/></li>
				</ul>
			</div>
		</div>

		<div class="cetBtn">
			<aui:button-row>
				<aui:button style="margin-right:20px;" cssClass="selector-button"
					value="vgc.apon.button.confirm" />
				<aui:button type="cancel"
					onClick='<%=renderResponse.getNamespace()+ "cancel();"%>'
					name="vgc-apon-business-trip-application-flight-train-cancel" />
			</aui:button-row>
		</div>
	</aui:fieldset>
</aui:form>

<aui:script> 
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

<aui:script use="aui-base">
var Util = Liferay.Util;
A.one('#<portlet:namespace />fm').delegate(
		'click',
		function(event) {
			var result={};
			var country=document.getElementById("country");
			var city=document.getElementById("city");
			var countryText=country.options[country.options.selectedIndex].text;
			var cityText=city.options[city.options.selectedIndex].text;
			result['country']=countryText;
			result['city']=cityText;
			result['rateOfDma']=document.<portlet:namespace />fm.<portlet:namespace />rateOfDma.value;
			result['currency']=document.<portlet:namespace />fm.<portlet:namespace />currency.value;	
			Util.getOpener().Liferay.fire('<%= HtmlUtil.escapeJS(eventName) %>',result);
			Util.getWindow().destroy();
		},
		'.selector-button'
	);

AUI().use('aui-io-request',function(A){
	var ajaxRequest=A.io.request('<%=ajaxURL %>'+'&<portlet:namespace/>cmd=ratecity',{
		autoLoad:false,
		 dataType: 'json',
		on:{
			success:function(){
				var country=document.getElementById("country");
				var city=document.getElementById("city");
				var currency=document.getElementById("currency");
				var rateOfDma=document.getElementById("rateOfDma");
				var arr=this.get('responseData');
				var countryVal=country.options[country.options.selectedIndex].value;
				var rateCity=document.getElementById("rateCity").value;
				
		
				
				country.onchange=function(){
					var val=this.value;
					city.options.length=0;
					city.options.add(new Option("N/A",-1));
					for(var i=0;i<arr.length;i++){
						if(val==arr[i].parentId){
							city.options.add(new Option(arr[i].areaName,arr[i].ratecityId));
						}
						if(val==arr[i].ratecityId){
							currency.value=arr[i].currency;
							rateOfDma.value=arr[i].rateOfDma;
						}
						}
				}
				city.onchange=function(){
					var val=this.value;
					for(var i=0;i<arr.length;i++){
						if(val==-1){
							country.onchange();
						}
						else if(val==arr[i].ratecityId){
							currency.value=arr[i].currency;
							rateOfDma.value=arr[i].rateOfDma;
						}
						}
				}
				city.onchange();
				//country.onchange();
				}
		}
	});
	ajaxRequest .start();
});
</aui:script>
	













