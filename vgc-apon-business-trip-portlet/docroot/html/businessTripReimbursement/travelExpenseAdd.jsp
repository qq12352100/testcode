
<%@include file="/html/init.jsp"%>
<%

String selectedRateUrl = "/html/businessTripReimbursement/travelExpenseRateOfDmaSelected.jsp";

	String eventName = ParamUtil.getString(request, "eventName", liferayPortletResponse.getNamespace() + "AddBusinessTripReimbursement");
	String tabs2 = ParamUtil.getString(request, "tabs2","travelExpense");
	Boolean isNew=true;
	long pkId = ParamUtil.getLong(request, "pkId",0);
	int tripType = ParamUtil.getInteger(request, "tripType",0);
	System.out.println("tripType="+tripType);
	BtTravelExpense btTravelExpense=null;
	
	int tempRowNum = ParamUtil.getInteger(request,"tempRowNum");
	int tempRowCount = ParamUtil.getInteger(request,"tempRowCount");
	
	
	
	System.out.println("tempRowNum:"+tempRowNum);
	System.out.println("tempRowCount:"+tempRowCount);
	
	if (pkId != 0) {
		btTravelExpense = BtTravelExpenseLocalServiceUtil.fetchBtTravelExpense(pkId);		
		isNew = btTravelExpense!=null?false:true;
	}else {
		pkId = CounterLocalServiceUtil.increment(BtTravelExpense.class.getName(), 1);
		btTravelExpense = BtTravelExpenseLocalServiceUtil.createBtTravelExpense(pkId);
	}
	
	boolean isHasBreakfast=false;
	String from="";
	String to="";
	if(!isNew){
		from=btTravelExpense.getFromCity();
		to=btTravelExpense.getToCity();
		isHasBreakfast= btTravelExpense.getIsHasBreakfast();
	}
	String country="";
	String city="";
	String currency="";
	String rateDma="";
	if(tripType==0){
		if(isNew){
			country="China Mainland";
			city="N/A";
			currency="RMB";
			rateDma="250";
		}else{
			country=btTravelExpense.getCountry();
			city=btTravelExpense.getCity();
			currency=btTravelExpense.getCurrency();
			rateDma=String.valueOf(btTravelExpense.getRateOfDma());
		}
	}else{
		if(isNew){
			country="";
			city="";
			currency="";
			rateDma="";
		}else{
			country=btTravelExpense.getCountry();
			city=btTravelExpense.getCity();
			currency=btTravelExpense.getCurrency();
			rateDma=String.valueOf(btTravelExpense.getRateOfDma());
		}
	}
%>
<!-- this is for hotelinformation start -->
<aui:form method="post" name="fm">
	<aui:fieldset>
		<input type="hidden" name="<portlet:namespace/>pkId" value="<%=pkId%>" />
		<input type="hidden" name="<portlet:namespace/>tabs2"
			value="<%=tabs2%>" />

		<div class="mainbody">
			<div id="tips" style="dispaly:block;color:red;font-style:italic;"><liferay-ui:message key="vgc.apon.business.trip.arrival.tips" /></div>
			<div class="newtb">
				<ul>
				<li class="nd02"><liferay-ui:message
							key="vgc-apon-business-trip-reimbursement-travel-expense-date" /></li>
					<li class="nd02"><liferay-ui:message
							key="vgc-apon-business-trip-reimbursement-travel-expense-departure" /></li>
					<li class="nd02"><liferay-ui:message
							key="vgc-apon-business-trip-reimbursement-travel-expense-arrival" /></li>
					<li class="nd02"><liferay-ui:message
							key="vgc-apon-business-trip-reimbursement-travel-expense-from" /></li>
					<li class="nd02"><liferay-ui:message
							key="vgc-apon-business-trip-reimbursement-travel-expense-to" /></li>

				</ul>
				<ul>
				<li class="nd02"><input type="text" class="Wdate"
						name="<portlet:namespace/>travelDate" id="travelDate"
						required="required" maxlength="75" 
						<%=isNew?"":"disabled"%>
						value="<%=isNew?"":btTravelExpense.getTravelDate()%>"
						onFocus="WdatePicker({lang:'en',dateFmt:'dd.MM.yyyy'})" /></li>
					<li class="nd02"><input type="text" class="Wdate"
						name="<portlet:namespace/>departure" id="departure"
						value="<%=isNew?"00:00":btTravelExpense.getDeparture()%>"
						required="required" maxlength="75" 
						<%=isNew||tempRowNum==0?"":"disabled"%>
						onFocus="WdatePicker({lang:'en',dateFmt:'HH:mm'})" /></li>
					<li class="nd02"><input class="Wdate" type="text" id="arrival"
						maxlength="75" value="<%=isNew?"23:59":btTravelExpense.getArrival()%>"
						name="<portlet:namespace/>arrival"
						<%=isNew||tempRowNum==tempRowCount-1?"":"disabled"%>
						onFocus="WdatePicker({lang:'en',dateFmt:'HH:mm'})" />
					</li>
					<li class="nd02"><input type="text"
						name="<portlet:namespace/>fromCity" id="fromCity"
						value="<%=from%>"
						<%=isNew||tempRowNum==0||tempRowNum==tempRowCount-1?"":"disabled"%>
						required="required" maxlength="75" /></li>
					<li class="nd02"><input type="text"
						name="<portlet:namespace/>toCity" id="toCity"
						value="<%=to%>"
						<%=isNew||tempRowNum==0||tempRowNum==tempRowCount-1?"":"disabled"%>
						required="required" maxlength="75" /></li>
				</ul>
			</div>
			<div class="newtb">
				<ul>
					<li class="nd02"></li>
					<li class="nd02"><liferay-ui:message
							key="vgc-apon-business-trip-reimbursement-travel-expense-breakfast" /></li>
					<li class="nd02"><liferay-ui:message
							key="vgc-apon-business-trip-reimbursement-travel-expense-lunch" /></li>
					<li class="nd02"><liferay-ui:message
							key="vgc-apon-business-trip-reimbursement-travel-expense-dinner" /></li>
		
				</ul>
				<ul>
					<li class="nd02"><span style="font-size:12px;">Remark: Please tick mark if you need daily meal allowance.</span></li>
					<li class="nd02"><input type="checkbox"
						name="<portlet:namespace/>isHasBreakfast"
						<%=isHasBreakfast == true ? "checked='checked'": ""%>
						id="isHasBreakfast" maxlength="75" /></li>
					<li class="nd02"><input type="checkbox"
						name="<portlet:namespace/>isHasLunch"
						<%=btTravelExpense.getIsHasLunch() == true ? "checked='checked'": ""%>
						id="isHasLunch" maxlength="75" /></li>
					<li class="nd02"><input type="checkbox"
						name="<portlet:namespace/>isHasDinner"
						<%=btTravelExpense.getIsHasDinner() == true ? "checked='checked'": ""%>
						id="isHasDinner" maxlength="75" /></li>
					
				</ul>
			</div>
			<div class="newtb">
				<ul>
			<li class="nd02"><liferay-ui:message
							key="vgc-apon-business-trip-reimbursement-travel-expense-country" /></li>
					<li class="nd02"><liferay-ui:message
							key="vgc-apon-business-trip-reimbursement-travel-expense-city" /></li>
					<li class="nd02"><liferay-ui:message
							key="vgc-apon-business-trip-reimbursement-travel-expense-ratedma" /></li>
					<li class="nd02"><liferay-ui:message
							key="vgc-apon-business-trip-reimbursement-travel-expense-currency" /></li>
					<li class="nd02"><liferay-ui:message
							key="vgc-apon-business-trip-reimbursement-travel-expense-comments" /></li>
				</ul>
				<ul>
<li class="nd02"><input type="text"
						name="<portlet:namespace/>country" id="country"
						value="<%=country%>"
						required="required" maxlength="75" disabled /></li>
					<li class="nd02"><input type="text" style="width: 80px;"
						name="<portlet:namespace/>city" id="city"
						value="<%=city%>"
						required="required" maxlength="75" disabled /> 
						<% if(tripType!=0){ %>
						<liferay-ui:icon
							id="selectPositionTo" label="<%=true%>" message="" method="get"  
							url='<%="javascript:"
									+ renderResponse.getNamespace()
									+ "openSelectedRatePage()"
									+ ";"%>'
							src='<%=themeDisplay.getPathThemeImages()+"/common/search.png"%>' />
							<%} %>
					</li>
					<li class="nd02"><input type="text"
						name="<portlet:namespace/>rateOfDma" id="rateOfDma"
						value="<%=rateDma%>"
						required="required" maxlength="75" disabled /></li>
					<li class="nd02"><input type="text"
						name="<portlet:namespace/>currency" id="currency"
						value="<%=currency%>"
						required="required" maxlength="75" disabled />
				</li>
					<li class="nd02"><input type="text"
						name="<portlet:namespace/>comments" id="comments"
						value="<%=isNew?"":btTravelExpense.getComments()%>"
						required="required" maxlength="75" /></li>
				</ul>




			</div>
		</div>

		<div class="cetBtn">
			<aui:button-row>
				<%
					if(!isNew){
				%>
				<aui:button style="margin-right:20px;" cssClass="selector-button"
					value="vgc-apon-button-update" />
				<%
					}else {
				%>
				<aui:button style="margin-right:20px;" cssClass="selector-button"
					value="vgc.apon.button.confirm" />
				<%
					}
				%>
				<aui:button type="cancel"
					onClick='<%=renderResponse.getNamespace()+ "cancel();"%>'
					name="vgc-apon-business-trip-application-flight-train-cancel" />
			</aui:button-row>
		</div>
	</aui:fieldset>
</aui:form>

<!-- this is for hotelinformation end -->

<aui:script use="aui-base">
	var Util = Liferay.Util;
	A.one('#<portlet:namespace />fm').delegate(
		'click',
		function(event) {
			if(!validataDate()||!validataDeparture()||!validataArrival()||!validataFromCity()||!validataToCity()||!validataCountry()){
				return false;
			}
			var result={};			
			result['pkId']=document.<portlet:namespace />fm.<portlet:namespace />pkId.value;
			result['tabs2']=document.<portlet:namespace />fm.<portlet:namespace />tabs2.value;
			result['travelDate']=document.<portlet:namespace />fm.<portlet:namespace />travelDate.value;
			result['departure']=document.<portlet:namespace />fm.<portlet:namespace />departure.value;
			result['arrival']=document.<portlet:namespace />fm.<portlet:namespace />arrival.value;
			result['fromCity']=document.<portlet:namespace />fm.<portlet:namespace />fromCity.value;
			result['toCity']=document.<portlet:namespace />fm.<portlet:namespace />toCity.value;
			if(document.<portlet:namespace />fm.<portlet:namespace />isHasBreakfast.checked){
				result['isHasBreakfast']=true;
			}else{
				result['isHasBreakfast']=false;
			}
			
			if(document.<portlet:namespace />fm.<portlet:namespace />isHasLunch.checked){
				result['isHasLunch']=true;
			}else{
				result['isHasLunch']=false;
			}
			
			if(document.<portlet:namespace />fm.<portlet:namespace />isHasDinner.checked){
				result['isHasDinner']=true;
			}else{
				result['isHasDinner']=false;
			}
			
			result['country']=document.<portlet:namespace />fm.<portlet:namespace />country.value;
			result['city']=document.<portlet:namespace />fm.<portlet:namespace />city.value;
			result['rateOfDma']=document.<portlet:namespace />fm.<portlet:namespace />rateOfDma.value;
			result['currency']=document.<portlet:namespace />fm.<portlet:namespace />currency.value;	
			result['comments']=document.<portlet:namespace />fm.<portlet:namespace />comments.value;
			//alert(obj2string(result))
			Util.getOpener().Liferay.fire('<%= HtmlUtil.escapeJS(eventName) %>',result);
			Util.getWindow().destroy();
		},
		'.selector-button'
	);
	//校验
	//validate date not null
   function validataDate(){
	   var flag=true;
	   var date=document.getElementById("travelDate");
	   if(date.value==null||date.value==""){
		 flag=false;
		 alert("Please fill in the date!");
		 date.focus();		   
	   }
	   return flag;
   }
	//校验
	//validate departure not null
   function validataDeparture(){
	   var flag=true;
	   var departure=document.getElementById("departure");
	   if(departure.value==null||departure.value==""){
		 flag=false;
		 alert("Please fill in the departure!");
		 departure.focus();		   
	   }
	   return flag;
   }
	
 //validate Arrival not null
   function validataArrival(){
	   var flag=true;
	   var arrival=document.getElementById("arrival");
	   if(arrival.value==null||arrival.value==""){
		 flag=false;
		 alert("Please fill in the arrival!");
		 arrival.focus();		   
	   }
	   return flag;
   }
	
   //validate fromCity not null
   function validataFromCity(){
	   var flag=true;
	   var fromCity=document.getElementById("fromCity");
	   if(fromCity.value==null||fromCity.value==""){
		 flag=false;
		 alert("Please fill in the fromCity!");
		 fromCity.focus();		   
	   }
	   return flag;
   }
   //validate fromCity not null
   function validataToCity(){
	   var flag=true;
	   var toCity=document.getElementById("toCity");
	   if(toCity.value==null||toCity.value==""){
		 flag=false;
		 alert("Please fill in the toCity!");
		 toCity.focus();		   
	   }
	   return flag;
   }
 
   function validataCountry(){
	   var flag=true;
	   var country=document.getElementById("country");
	   if(country.value==null||country.value==""){
		 flag=false;
		 alert("Please select  the country or city!");
	   }
	   return flag;
	   
   }
	
	//   测试查看js obj的 字符串
	function obj2string(o){ 
		 var r=[]; 
		 if(typeof o=="string"){ 
		  return "\""+o.replace(/([\'\"\\])/g,"\\$1").replace(/(\n)/g,"\\n").replace(/(\r)/g,"\\r").replace(/(\t)/g,"\\t")+"\""; 
		 } 
		 if(typeof o=="object"){ 
		  if(!o.sort){ 
		   for(var i in o){ 
		    r.push(i+":"+obj2string(o[i])); 
		   } 
		   if(!!document.all&&!/^\n?function\s*toString\(\)\s*\{\n?\s*\[native code\]\n?\s*\}\n?\s*$/.test(o.toString)){ 
		    r.push("toString:"+o.toString.toString()); 
		   } 
		   r="{"+r.join()+"}"; 
		  }else{ 
		   for(var i=0;i<o.length;i++){ 
		    r.push(obj2string(o[i])) 
		   } 
		   r="["+r.join()+"]"; 
		  } 
		  return r; 
		 } 
		 return o.toString(); 
		}
	
	</aui:script>
	<aui:script>
	//Open the add page to add info
	function <portlet:namespace />openSelectedRatePage() {
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
					id: '<portlet:namespace />SelectedCityRate',
					title: '<liferay-ui:message  key="vgc-apon-business-trip-reimbursement-travel-expense-dally"/>',
					uri:'<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>"><portlet:param name="mvcPath" value="<%=selectedRateUrl%>" /><portlet:param name="country" value="<%=btTravelExpense.getCountry()%>" /><portlet:param name="city" value="<%=btTravelExpense.getCity()%>" /></portlet:renderURL>'
				},
				function(event) {
					document.<portlet:namespace />fm.<portlet:namespace />currency.value = event.currency;
					document.<portlet:namespace />fm.<portlet:namespace />country.value = event.country;
					document.<portlet:namespace />fm.<portlet:namespace />city.value = event.city;
					document.<portlet:namespace />fm.<portlet:namespace />rateOfDma.value = event.rateOfDma;
				});
	}	
	function deleteOptions(obj)  
    {  
        var selectOptions = obj.options;  
        var optionLength = selectOptions.length;  
        for(var i=0;i <optionLength;i++)  
        {  
            obj.removeChild(selectOptions[0]);  
        }  
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
	









