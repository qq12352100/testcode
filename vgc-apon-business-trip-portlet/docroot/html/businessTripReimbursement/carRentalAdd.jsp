
<%@include file="/html/init.jsp"%>

<%
	String eventName = ParamUtil.getString(request, "eventName", liferayPortletResponse.getNamespace() + "AddBusinessTripReimbursement");
	String tabs2 = ParamUtil.getString(request, "tabs2","carRental");
	Boolean isNew=true;
	long pkId = ParamUtil.getLong(request, "pkId",0);
	BtCarRentalInfo btCarRentalInfo = null;
	if (pkId != 0) {
		btCarRentalInfo = BtCarRentalInfoLocalServiceUtil.fetchBtCarRentalInfo(pkId);		
		isNew = btCarRentalInfo!=null?false:true;
	}else {
		pkId = CounterLocalServiceUtil.increment(BtCarRentalInfo.class.getName(), 1);
		btCarRentalInfo = BtCarRentalInfoLocalServiceUtil.createBtCarRentalInfo(pkId);
	}
%>

<!-- this is for carRental start -->
<aui:form method="post" name="fm">
	<aui:fieldset>	
	<input type="hidden" name="<portlet:namespace/>pkId" value="<%=pkId %>"/>
	<input type="hidden" name="<portlet:namespace/>tabs2" value="<%=tabs2%>"/>	
		<div class="mainbody">
		    <div class="newtb">
		    	<ul>
		    	    <li class="nd02"><liferay-ui:message key="vgc-apon-business-trip-application-car-rental-pickup-location"/></li>
		    	    <li class="nd02"><liferay-ui:message key="vgc-apon-business-trip-application-car-rental-pickup-date-time"/></li>
		    	    <li class="nd02"><liferay-ui:message key="vgc-apon-business-trip-application-car-rental-dropoff-location"/></li>
		    	    <li class="nd02"><liferay-ui:message key="vgc-apon-business-trip-application-car-rental-dropoff-data-time"/></li>
		    	</ul>
		    	<ul>
		    	    <li class="nd02">
		    	    	<input type="text" name="<portlet:namespace/>pickupLocation" id="pickupLocation"  value="<%=isNew?"":btCarRentalInfo.getPickupLocation() %>" required="required" maxlength="75"/>
		    	    </li>
		    	    <li class="nd02">
		    	        <input class="Wdate" type="text" maxlength="75"
							value="<%=isNew?"":sdf.format(btCarRentalInfo.getPickupDate()) %>"
							name="<portlet:namespace/>pickupDate"
							onFocus="WdatePicker({lang:'en',dateFmt:'dd.MM.yyyy HH:mm'})" />
		    	    </li>
		    	    <li class="nd02">
		    	    	<input type="text" name="<portlet:namespace/>dropoffLocation" id="dropoffLocation" value="<%=isNew?"":btCarRentalInfo.getDropoffLocation() %>" required="required" maxlength="75"/>
		    	    </li>
		    	    <li class="nd02">
		    	        <input class="Wdate" type="text" maxlength="75"
							value="<%=isNew?"":sdf.format(btCarRentalInfo.getDropoffDate()) %>"
							name="<portlet:namespace/>dropoffDate"
							onFocus="WdatePicker({lang:'en',dateFmt:'dd.MM.yyyy HH:mm'})" />
		    	    </li>
		    	</ul>
		    	<ul>
		    	    <li class="nd02"><liferay-ui:message key="vgc-apon-business-trip-application-car-rental-car-type"/></li>
		    	    <li class="nd02"><liferay-ui:message key="vgc-apon-business-trip-application-car-rental-type-of-rental"/></li>
		    	    <li class="nd02"><liferay-ui:message key="vgc-apon-business-trip-application-car-rental-price"/></li>
		    	    <li class="nd02"><liferay-ui:message key="vgc-apon-business-trip-application-car-rental-currency"/></li>
		    	</ul>
		    	<ul>
		    	 <li class="nd02">
		    	    	<input type="text" name="<portlet:namespace/>carType" id="carType" value="<%=isNew?"":btCarRentalInfo.getCarType() %>" maxlength="75"/>
		    	    </li>
		    	     <li class="nd02">
		    	    	<input type="text" name="<portlet:namespace/>typeOfRental" id="typeOfRental" value="<%=isNew?"":btCarRentalInfo.getTypeOfRental() %>" maxlength="75"/>
		    	    </li>
		    	    <li class="nd02">
		    	    	<input type="text" name="<portlet:namespace/>price" id="price" onblur="checkFloat(this)"  onkeyup="this.value=this.value.replace(/[^0-9.]/g,'')" value="<%=isNew?"":btCarRentalInfo.getPrice() %>" maxlength="75"/>
		    	    </li>
		    	    <li class="nd02">
		    	    	<select name="<portlet:namespace/>currency">
							<%
								String currency =btCarRentalInfo.getCurrency()==null?"":btCarRentalInfo.getCurrency();					
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
					name="vgc-apon-business-trip-application-car-rental-cancel" />
			</aui:button-row>
		</div>
	</aui:fieldset>
</aui:form>

<!-- this is for carRental end -->

<aui:script use="aui-base">
	var Util = Liferay.Util;
	A.one('#<portlet:namespace />fm').delegate(
		'click',
		function(event) {
			if(!validateByNameLabel('pickupLocation','<liferay-ui:message key="vgc-apon-business-trip-application-car-rental-pickup-location"/>')
				|| !validateByNameLabel('dropoffLocation','<liferay-ui:message key="vgc-apon-business-trip-application-car-rental-dropoff-location"/>')
				|| !validateByNameLabel('carType','<liferay-ui:message key="vgc-apon-business-trip-application-car-rental-car-type"/>')) {
				return false;
			}	
			var result={};	
			result['pkId']=document.<portlet:namespace />fm.<portlet:namespace />pkId.value;
			result['tabs2']=document.<portlet:namespace />fm.<portlet:namespace />tabs2.value;
			result['pickupLocation']=document.<portlet:namespace />fm.<portlet:namespace />pickupLocation.value;;
			result['pickupDate']=document.<portlet:namespace />fm.<portlet:namespace />pickupDate.value;
			result['dropoffLocation']=document.<portlet:namespace />fm.<portlet:namespace />dropoffLocation.value;
			result['dropoffDate']=document.<portlet:namespace />fm.<portlet:namespace />dropoffDate.value;
			result['carType']=document.<portlet:namespace />fm.<portlet:namespace />carType.value;
			result['typeOfRental']=document.<portlet:namespace />fm.<portlet:namespace />typeOfRental.value;
			result['price']=document.<portlet:namespace />fm.<portlet:namespace />price.value;
			result['currency']=document.<portlet:namespace />fm.<portlet:namespace />currency.value;	
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