

<%@include file="/html/init.jsp"%>

<%
	String eventName = ParamUtil.getString(request, "eventName", liferayPortletResponse.getNamespace() + "AddBusinessTripApplication");
	String tabs2 = ParamUtil.getString(request, "tabs2");
	SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
	Date startDate1 = ParamUtil.getDate(request, "startDate", dateFormat);
	Date endDate1 = ParamUtil.getDate(request, "endDate",dateFormat);
	String startDate = sdf.format(startDate1);
	String endDate = sdf.format(endDate1);
	String travelTypeVal = ParamUtil.getString(request, "travelTypeVal");
	Boolean isNew=true;
	long pkId = ParamUtil.getLong(request, "pkId",0);
	BtHotelInfo btHotelInfo = null;
	if (pkId != 0) {
		btHotelInfo = BtHotelInfoLocalServiceUtil.fetchBtHotelInfo(pkId);
		isNew = btHotelInfo!=null?false:true;
	}else {
		pkId = CounterLocalServiceUtil.increment(BtHotelInfo.class.getName(), 1);
		btHotelInfo = BtHotelInfoLocalServiceUtil.createBtHotelInfo(pkId);
	}
	BtExchangeRate btExchangeRate = BtExchangeRateLocalServiceUtil.fetchByF_S_S("RMB", "EUR", BusinessTripConstants.VALID_STATUS);
%>

<!-- this is for hotelinformation start -->
<aui:form method="post" name="fm">
	<aui:fieldset>	
		<input type="hidden" name="<portlet:namespace/>pkId" value="<%=pkId %>"/>
		<input type="hidden" name="<portlet:namespace/>tabs2" value="<%=tabs2%>"/>
		<input type="hidden" name="<portlet:namespace/>firToSecExchangeRate" value="<%=btExchangeRate.getFirToSecExchangeRate()%>"/>
		<input type="hidden" name="<portlet:namespace/>secToFirExchangeRate" value="<%=btExchangeRate.getSecToFirExchangeRate()%>"/>
	
		<div class="mainbody">
			<div class="newtb">
		    	<ul>
		    	    <li class="nd02"><liferay-ui:message key="vgc-apon-business-trip-application-hotel-city"/></li>
		    	    <li class="nd02"><liferay-ui:message key="vgc-apon-business-trip-application-hotel-city-type"/></li>
		    	    <li class="nd02"><liferay-ui:message key="vgc-apon-business-trip-application-hotel-hotel"/></li>
		    	    <li class="nd02"><liferay-ui:message key="vgc-apon-business-trip-application-hotel-check-in"/></li>
		    	</ul>
		    	<ul>
		    		<li class="nd02">
		    	    	<input type="text" name="<portlet:namespace/>city" id="city" value="<%=btHotelInfo.getCity()==null?"":btHotelInfo.getCity() %>" required="required" maxlength="75"/>
		    	    </li>
		    	    <li class="nd02">
		    	    	<select name="<portlet:namespace/>cityType">
						<%
							String cityType =btHotelInfo.getCityType()==null?"":btHotelInfo.getCityType();					
							for (String curCityType : PortletPropsValues.CITY_TYPE) {
						%>
							<option <%= cityType.equals(LanguageUtil.get(Locale.ENGLISH, curCityType)) ? "selected='selected'" : "" %> value="<%= LanguageUtil.get(Locale.ENGLISH, curCityType) %>">
								<%= LanguageUtil.get(pageContext, curCityType) %>
							</option>
						<%
							}
						%>
						</select>
		    	    </li>
		    	    <li class="nd02">
		    	    	<input type="text" name="<portlet:namespace/>hotel" id="hotel" value="<%=btHotelInfo.getHotel()==null?"":btHotelInfo.getHotel() %>" required="required" maxlength="75"/>
		    	    </li>
		    	    <li class="nd02">
		    	    	<input id="d4311" class="Wdate" type="text" name="<portlet:namespace/>checkIn" value="<%=isNew?startDate:sdf.format(btHotelInfo.getCheckIn())%>"
						onFocus="WdatePicker({lang:'en',dateFmt:'dd.MM.yyyy HH:mm',maxDate:'#F{$dp.$D(\'d4312\')}'})"/>					
		    	    </li>
		    	</ul>
		    </div>
		   	<div class="newtb">
		    	<ul>
		    		<li class="nd02"><liferay-ui:message key="vgc-apon-business-trip-application-hotel-check-out"/></li>
		    	    <li class="nd02"><liferay-ui:message key="vgc-apon-business-trip-application-hotel-room-category"/></li>
		    	    <li class="nd02"><liferay-ui:message key="vgc-apon-business-trip-application-hotel-price"/></li>
		    	    <li class="nd02"><liferay-ui:message key="vgc-apon-business-trip-application-hotel-currency"/></li>
		    	</ul>
		    	<ul>
		    		<li class="nd02">
		    			<input id="d4312" class="Wdate" type="text" name="<portlet:namespace/>checkOut" value="<%=isNew?endDate:sdf.format(btHotelInfo.getCheckOut())%>"
							onFocus="WdatePicker({lang:'en',dateFmt:'dd.MM.yyyy HH:mm',minDate:'#F{$dp.$D(\'d4311\')}'})"/>	
		    	    </li>
		    	    <li class="nd02">
		    	    	<select name="<portlet:namespace/>roomCategory" onchange='<%=renderResponse.getNamespace()+ "selectNonStandard();"%>'>
							<%
								String roomCategory =btHotelInfo.getRoomCategory()==null?"":btHotelInfo.getRoomCategory();					
								for (String curRoomCategory : PortletPropsValues.ROOM_CATEGORY) {
							%>
								<option <%= roomCategory.equals(LanguageUtil.get(Locale.ENGLISH, curRoomCategory)) ? "selected='selected'" : "" %> value="<%= LanguageUtil.get(Locale.ENGLISH, curRoomCategory) %>">
									<%= LanguageUtil.get(pageContext, curRoomCategory) %>
								</option>
							<%
								}
							%>
						</select>
		    	    </li>
		    	    <li class="nd02">
		    	    	<input type="text" name="<portlet:namespace/>price" id="price" value="<%= String.format("%.2f", btHotelInfo.getPrice())%>" onblur="checkFloat(this)"  onkeyup="this.value=this.value.replace(/[^0-9.]/g,'')" maxlength="75" required="required"/>
		    	    </li>
		    	    <li class="nd02">
		    	    	<select id="curreencyID" name="<portlet:namespace/>currency" disabled="disabled">
						<%
								String currency =btHotelInfo.getCurrency()==null?"":btHotelInfo.getCurrency();					
								for (String curCurrency : PortletPropsValues.CURRENCY) {
						%>
								<option <%= currency.equals(LanguageUtil.get(Locale.ENGLISH, curCurrency)) ? "selected='selected'" : "" %> value="<%= LanguageUtil.get(Locale.ENGLISH, curCurrency) %>">
									<%= LanguageUtil.get(pageContext, curCurrency) %>
								</option>
						<%
								}
						%>
						</select>
		    	    </li>
		    	</ul>
		    </div>
		    <div class="newtb">
		    	<ul>
		    	    <li class="nd02"><liferay-ui:message key="vgc-apon-business-trip-application-hotel-over-budget"/></li>
		    	    <li class="nd02"><liferay-ui:message key="vgc-apon-business-trip-application-hotel-other-reason-of-additional-hotel-cost"/></li>
		    	    <li class="nd02"><liferay-ui:message key="vgc-apon-business-trip-application-hotel-not-booked-from-travel-agency"/></li>
		    	    <li class="nd02"><liferay-ui:message key="vgc-apon-business-trip-application-hotel-others-please-specify"/></li>
		    	</ul>
		    	<ul>
		    	    <li class="nd02">
		    	    	<input type="checkbox" value='1' <%= btHotelInfo.getIsOverBudget() == 1 ? "checked='checked'": "" %> name="<portlet:namespace/>isOverBudget" />
		    	    </li>
		    	      <li class="nd02">
		    	      	<textarea name="<portlet:namespace/>otherReasonInfo" maxlength="75" ><%=btHotelInfo.getOtherReasonInfo()==null?"":btHotelInfo.getOtherReasonInfo()%></textarea>
		    	    </li>
		    	    <li class="nd02">
		    	    	<input type="checkbox" value='<%=true %>' <%= btHotelInfo.getIsNotBookedFromTA() == true ? "checked='checked'": "" %> name="<portlet:namespace/>isNotBookedFromTA" />
		    	    </li>
		    	    <li class="nd02">
		    	    	<textarea name="<portlet:namespace/>othersSpecify" maxlength="75" ><%=btHotelInfo.getOthersSpecify()==null?"":btHotelInfo.getOthersSpecify()%></textarea>
		    	    </li>
		    	</ul>
		    </div>
		</div>	
		
		<div class="cetBtn">
			<aui:button-row>
				<%if(!isNew){
				%>
				<aui:button style="margin-right:20px;" cssClass="selector-button"
					value="vgc-apon-button-update"/>
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
					name="vgc-apon-business-trip-application-hotel-cancel" />
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
			if(!validateByNameLabel('city','<liferay-ui:message key="vgc-apon-business-trip-application-hotel-city"/>')
				|| !validateByNameLabel('checkIn','<liferay-ui:message key="vgc-apon-business-trip-application-hotel-check-in"/>')
				|| !validateByNameLabel('checkOut','<liferay-ui:message key="vgc-apon-business-trip-application-hotel-check-out"/>')) {
				return false;
			}	
			var result={};			
			result['pkId']=document.<portlet:namespace />fm.<portlet:namespace />pkId.value;
			result['tabs2']=document.<portlet:namespace />fm.<portlet:namespace />tabs2.value;
			result['city']=document.<portlet:namespace />fm.<portlet:namespace />city.value;
			result['cityType']=document.<portlet:namespace />fm.<portlet:namespace />cityType.value;
			result['hotel']=document.<portlet:namespace />fm.<portlet:namespace />hotel.value;
			result['checkIn']=document.<portlet:namespace />fm.<portlet:namespace />checkIn.value;
			result['checkOut']=document.<portlet:namespace />fm.<portlet:namespace />checkOut.value;
			result['roomCategory']=document.<portlet:namespace />fm.<portlet:namespace />roomCategory.value;
			result['price']=document.<portlet:namespace />fm.<portlet:namespace />price.value;
			result['currency']=document.<portlet:namespace />fm.<portlet:namespace />currency.value;
			//validate the hotel price
			if(!<portlet:namespace/>validateIsOverBudget(result['cityType'],result['price'],result['currency'],document.<portlet:namespace />fm.<portlet:namespace />otherReasonInfo.value)){
				return false;
			}
			
			if(document.<portlet:namespace />fm.<portlet:namespace />isOverBudget.checked){
				result['isOverBudget'] = '1';
			}else {
				result['isOverBudget'] = '0';
			}
			result['otherReasonInfo']=document.<portlet:namespace />fm.<portlet:namespace />otherReasonInfo.value;
			if(document.<portlet:namespace />fm.<portlet:namespace />isNotBookedFromTA.checked){
				result['isNotBookedFromTA'] = 'true';
			}else {
				result['isNotBookedFromTA'] = 'false';
			}
			result['othersSpecify']=document.<portlet:namespace />fm.<portlet:namespace />othersSpecify.value;			
			Util.getOpener().Liferay.fire('<%= HtmlUtil.escapeJS(eventName) %>',result);
			Util.getWindow().destroy();
		},
		'.selector-button'
	);
</aui:script>

<aui:script>  
	function <portlet:namespace/>cancel(){
		var Util = Liferay.Util;
		Util.getWindow().destroy();
	}
	
	function <portlet:namespace/>validateIsOverBudget(cityType,price,currency,otherReasonInfo) {
		var roomCategory=document.<portlet:namespace/>fm.<portlet:namespace />roomCategory.value;
		var sDate=document.getElementById("d4311").value;
		var eDate=document.getElementById("d4312").value;
		var days=DateDiff(sDate,eDate);
		var  rmbVal=convertToRMB(price,currency)/parseFloat(days);
		var  eurVal=convertToEUR(price,currency)/parseFloat(days);
		if((cityType=='BJ/SH/SZ/GZ' && rmbVal>1000) 
				|| (cityType=='Other Chinese city' && rmbVal>700) 
				|| (cityType=='International Hotel' && eurVal>150)||roomCategory=="Non-Standard") {
			document.<portlet:namespace />fm.<portlet:namespace />isOverBudget.checked = true;
			if(otherReasonInfo==null || otherReasonInfo=='') {
				alert("Please fill in the other reason of additional hotel cost!");
				return false;
			}
		}else{
			document.<portlet:namespace />fm.<portlet:namespace />isOverBudget.checked = false;
		}
		return true;
	}
	
	function convertToRMB(price,currency) {
		if(currency=='RMB') {
			return parseFloat(price);
		}else if(currency=='EUR') {
			var secToFirExchangeRate =document.<portlet:namespace />fm.<portlet:namespace />secToFirExchangeRate.value;
			return parseFloat(price*secToFirExchangeRate);
		}
	}
	
	function convertToEUR(price,currency) {
		if(currency=='EUR') {
			return price;
		}else if(currency=='RMB') {
			var firToSecExchangeRate =document.<portlet:namespace />fm.<portlet:namespace />firToSecExchangeRate.value;
			return price*firToSecExchangeRate;
		}
	}
	function  DateDiff(sDate1,  sDate2){    //sDate1和sDate2是2006-12-18格式    
        var  aDate,  oDate1,  oDate2,  iDays    
        aDate  =  sDate1.split(".")    
        oDate1  =  new  Date(aDate[2].substr(0,4)  +  '-'  +  aDate[1]  +  '-'  +  aDate[0])    //转换为12-18-2006格式    
        aDate  =  sDate2.split(".")    
        oDate2  =  new  Date(aDate[2].substr(0,4)  +  '-'  +  aDate[1]  +  '-'  +  aDate[0])    
        iDays  =  parseInt(Math.abs(oDate1  -  oDate2)  /  1000  /  60  /  60  /24)    //把相差的毫秒数转换为天数   
        return  iDays   
    }

	window.onload=function(){
		var ttv = "<%=travelTypeVal%>";
		if(ttv!=0){
			document.getElementById("curreencyID").disabled = false;
		}
		
		
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
	function <portlet:namespace />selectNonStandard(){
		var roomCategory=document.<portlet:namespace/>fm.<portlet:namespace />roomCategory.value;
		if(roomCategory=="Non-Standard"){
			document.<portlet:namespace />fm.<portlet:namespace />isOverBudget.checked = true;
		}else{
			commonValidataOverBudget();
		}
	}
	function  commonValidataOverBudget(){
		var cityType=document.<portlet:namespace />fm.<portlet:namespace />cityType.value;
		var price=document.<portlet:namespace />fm.<portlet:namespace />price.value;
		var currency=document.<portlet:namespace />fm.<portlet:namespace />currency.value;	
	var sDate=document.getElementById("d4311").value;
	var eDate=document.getElementById("d4312").value;
	  var re = /^\d+(?=\.{0,1}\d+$|$)/
		    if (price != "") {
		        if (!re.test(price)) {
		        	document.<portlet:namespace />fm.<portlet:namespace />isOverBudget.checked = false;
		           return;
		        }
		    }
	if(sDate!=""&&eDate!=""){
	var days=DateDiff(sDate,eDate);
	var  rmbVal=convertToRMB(price,currency)/parseFloat(days);
	var  eurVal=convertToEUR(price,currency)/parseFloat(days);
	if((cityType=='BJ/SH/SZ/GZ' && rmbVal>1000) 
			|| (cityType=='Other Chinese city' && rmbVal>700) 
			|| (cityType=='International Hotel' && eurVal>150)) {
		document.<portlet:namespace />fm.<portlet:namespace />isOverBudget.checked = true;
	}else{
		document.<portlet:namespace />fm.<portlet:namespace />isOverBudget.checked = false;
	}
	}else{
		document.<portlet:namespace />fm.<portlet:namespace />isOverBudget.checked = false;
	}
	}
	$('#price').bind('input propertychange', function() {
		
		
		var roomCategory=document.<portlet:namespace/>fm.<portlet:namespace />roomCategory.value;
		if(roomCategory=="Non-Standard"){
			document.<portlet:namespace />fm.<portlet:namespace />isOverBudget.checked = true;
		}else{
			commonValidataOverBudget();
		}
		});
</aui:script> 
