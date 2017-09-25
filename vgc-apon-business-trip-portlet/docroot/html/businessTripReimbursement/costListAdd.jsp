
<%@page import="java.text.NumberFormat"%>
<%@include file="/html/init.jsp"%>

<%
	String eventName = ParamUtil.getString(request, "eventName", liferayPortletResponse.getNamespace() + "AddBusinessTripReimbursement");
	String tabs2 = ParamUtil.getString(request, "tabs2");
	Boolean isNew=true;
	String businessTripReimbursementId=ParamUtil.getString(request, "businessTripReimbursementId");
	long pkId = ParamUtil.getLong(request, "pkId",0);
	String travelTypeVal = ParamUtil.getString(request, "travelTypeVal");
	BtCostList btCostList = null;
	if (pkId != 0) {
		btCostList = BtCostListLocalServiceUtil.fetchBtCostList(pkId);
		isNew = btCostList!=null?false:true;
	}else {
		pkId = CounterLocalServiceUtil.increment(BtCostList.class.getName(), 1);
		btCostList = BtCostListLocalServiceUtil.createBtCostList(pkId);
	}
	int tripType = ParamUtil.getInteger(request, "tripType",0);
	String ticketNo=ParamUtil.getString(request, "ticketNo","");
	//convert rmb to eur
	 String RMB = "RMB";
	 String EUR = "EUR";
	 double eurtoRmb=BTApplicationUtil.addCalculate(0, RMB, 1,EUR );
	 double rmbtoEur=BTApplicationUtil.addCalculate(0, EUR, 1,RMB );
%>

<!-- this is for costList start -->
<aui:form method="post" name="fm">
	<aui:fieldset>
		<input type="hidden" name="<portlet:namespace/>tripTypeCostlist" value="<%=tripType %>" id="tripTypeCostlist"/>	
		<input type="hidden" name="<portlet:namespace/>pkId" value="<%=pkId %>"/>
		<input type="hidden" name="<portlet:namespace/>tabs2" value="<%=tabs2%>"/>
	    <input type="hidden" name="<portlet:namespace/>btCostListId" value="<%=btCostList.getBtCostListId()%>"/>
	    <!-- this is for convert,rmb and eur -->
	    <input type="hidden" name="<portlet:namespace/>eurtoRmb" id="eurtoRmb" value="<%=eurtoRmb %>"/>
		<input type="hidden" name="<portlet:namespace/>rmbtoEur" id="rmbtoEur" value="<%=rmbtoEur%>"/>
		<div class="mainbody">
			<div class="newtb">
		    	<ul id="titleul">
		    	    <li class="nd02"><liferay-ui:message key="vgc-apon-business-trip-reimbursement-cost-list-item"/></li>
		    	    <li class="nd02" style="display: none"><liferay-ui:message key="vgc-apon-business-trip-reimbursement-cost-list-type"/></li>
		    	    <li class="nd02"><liferay-ui:message key="vgc-apon-business-trip-reimbursement-cost-list-gross-amount"/></li>
		    	    <%-- <li class="nd02 hideli"><liferay-ui:message key="vgc-apon-business-trip-reimbursement-cost-list-tax-rate"/></li> --%>
		    	    <li class="nd02 hideli"><liferay-ui:message key="vgc-apon-business-trip-reimbursement-cost-list-net-amount"/></li>
		    	    <li class="nd02 hideli"><liferay-ui:message key="vgc-apon-business-trip-reimbursement-cost-list-tax-amount"/></li>
		    	    
		    	</ul>
		    	<ul id="infoul">
		    	    <li class="nd02">
		    	    	<select name="<portlet:namespace/>item" id="costListItem" onchange="selectCostItem()">
						<%
							String item =btCostList.getItem()==null?"":btCostList.getItem();					
							for (String curItem : new String[]{"Air ticket(If not booked by HRG)","Accommodation-Domestic","Accommodation-International","Fuel/Oil/CarWash","Car Maintenance","Parking/Garage",
									"Railway/Ferry","Taxi/Bus/Subway","Rented Car","Telephone","Laundry","Gifts","Bank Fees","Currency Loss",
									"Others"}) {
						%>
							<option <%= item.equals(curItem) ? "selected='selected'" : "" %> value="<%= LanguageUtil.get(Locale.ENGLISH, curItem) %>">
								<%= LanguageUtil.get(pageContext, curItem) %>
							</option>
						<%
							}
						%>
						</select>
		    	    </li>
		    		<li class="nd02" style="display: none">
		    	    	<select name="<portlet:namespace/>type">
						<%
						   String type =btCostList.getType()==null?"":btCostList.getType();					
							for (String curType : new String[]{"Domestic Expense","International Expense"}) {
						%>
							<option <%=type.equals(curType) ? "selected='selected'" : "" %> value="<%= LanguageUtil.get(Locale.ENGLISH, curType) %>">
								<%= LanguageUtil.get(pageContext, curType) %>
							</option>
						<%
							}
						%>
						</select>
		    	    </li>
		    	    <li class="nd02">
		    	        <input type="text" name="<portlet:namespace/>invoiceAmount" id="invoiceAmount" value="<%=isNew?"":btCostList.getInvoiceAmount() %>"  onblur="checkFloat(this)"  onkeyup="this.value=this.value.replace(/[^0-9.]/g,'')" required="required" maxlength="75"/>
		    	    </li>
		    	      <li class="nd02 hideli">
		    	        <input type="text" name="<portlet:namespace/>netAmount" id="netAmount" value="<%=isNew?"":btCostList.getNetAmount() %>"  onblur="checkFloat(this)"  onkeyup="this.value=this.value.replace(/[^0-9.]/g,'')" required="required" maxlength="75"/>
		    	    </li>
		    	      <li class="nd02 hideli">
		    	        <input type="text" name="<portlet:namespace/>taxAmount" id="taxAmount"  value="<%=isNew?"":btCostList.getTaxAmount() %>"  onblur="checkFloat(this)"  onkeyup="this.value=this.value.replace(/[^0-9.]/g,'')" required="required" maxlength="75"/>
		    	    </li>
		    	</ul>
		    </div>
		   	<div class="newtb">
		    	<ul>
		    		<li class="nd02"><liferay-ui:message key="vgc-apon-business-trip-reimbursement-cost-list-invoice-currency"/></li>
		    	    <li class="nd02"><liferay-ui:message key="vgc-apon-business-trip-reimbursement-cost-list-country-city"/></li>
		    	    <li class="nd02"><liferay-ui:message key="vgc-apon-business-trip-reimbursement-cost-list-payment-currency"/></li>
		    	    <li class="nd02"><liferay-ui:message key="vgc-apon-business-trip-reimbursement-cost-list-payment-amount"/></li>		    	    
		    	</ul>
		    	<ul>
		    	  <li class="nd02">
		    	    	  <select  name="<portlet:namespace/>invoiceCurrency" id="invoiceCurrency" <%=isNew?"":"disabled='disabled'"%> onchange="selectCurrencyAsTripType()">
						<%
							String invoiceCurrency =btCostList.getInvoiceCurrency()==null?"":btCostList.getInvoiceCurrency();					
							for (String curInvoiceCurrency : new String[]{"RMB","EUR"}) {
						%>
							<option <%= invoiceCurrency.equals(curInvoiceCurrency) ? "selected='selected'" : "" %> value="<%= LanguageUtil.get(Locale.ENGLISH, curInvoiceCurrency) %>">
								<%= LanguageUtil.get(pageContext, curInvoiceCurrency) %>
							</option>
						<%
							}
						%>
						</select>
		    	    </li>
		    	    <li class="nd02">
		    	    	<input type="text" name="<portlet:namespace/>countryCity" id="countryCity" value="<%=isNew?"":btCostList.getCountryCity() %>" required="required" maxlength="75"/>					
		    	    </li>
		    	    <li class="nd02">
		    	        <select name="<portlet:namespace/>paymentCurrency" id="paymentCurrency" <%=tripType==1?"disabled=\"disabled\"":""%>>
						<%
							String paymentCurrency =btCostList.getPaymentCurrency()==null?"":btCostList.getPaymentCurrency();					
							for (String curPaymentCurrency : new String[]{"RMB","EUR"}) {
						%>
							<option <%= paymentCurrency.equals(curPaymentCurrency) ? "selected='selected'" : "" %> value="<%= LanguageUtil.get(Locale.ENGLISH, curPaymentCurrency) %>">
								<%= LanguageUtil.get(pageContext, curPaymentCurrency) %>
							</option>
						<%
							}
						%>
						</select>
		    	    </li>
		    	    <li class="nd02">
		    	    	<input type="text" name="<portlet:namespace/>paymentAmount" id="paymentAmount" value="<%=isNew?"":btCostList.getPaymentAmount() %>" required="required" maxlength="75" readonly="readonly"/>
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
		
		<%if(isNew){
				%>
			    <aui:button style="margin-right:20px;" 
				    value="vgc-apon-business-trip-reimbursement-cost-list-entertainment"
				    onClick='<%= "parent."+renderResponse.getNamespace() + "openAddPageEntertainmentInfo();" %>'/>
				<%
		}
		%>
		<div style="padding:4px;">Notes: If VAT special invoice, please input Tax Amount, if VAT general invoice, please input '0' as <b>VAT Tax Amount</b>. Gross Amount equals Net Amount plus Tax Amount.</div>
	</aui:fieldset>
</aui:form>

<!-- this is for costListAdd end -->

<aui:script use="aui-base">
	var Util = Liferay.Util;
	A.one('#<portlet:namespace />fm').delegate(
		'click',
		function(event) {
			var result={};	
			//validate
			if(!validateInvoiceAmount()||!validateCountryCity()){
				return false;
			}
			//count the paymentAmount
			var eurtoRmb=document.getElementById("eurtoRmb").value;
			var rmbtoEur=document.getElementById("rmbtoEur").value;
			var invoiceCurrency=document.getElementById("invoiceCurrency").value;
			var paymentCurrency=document.getElementById("paymentCurrency").value;	
			var invoiceAmount=document.getElementById("invoiceAmount").value;	
			if(invoiceCurrency==paymentCurrency){				
				document.getElementById("paymentAmount").value=invoiceAmount;				
			}else if(invoiceCurrency!=paymentCurrency&&invoiceCurrency=="RMB"){
				document.getElementById("paymentAmount").value=invoiceAmount*rmbtoEur;
				
			}else if(invoiceCurrency=="EUR"){
				document.getElementById("paymentAmount").value=invoiceAmount*eurtoRmb;				
			}				
			//
			result['pkId']=document.<portlet:namespace />fm.<portlet:namespace />pkId.value;
			result['tabs2']=document.<portlet:namespace />fm.<portlet:namespace />tabs2.value;
			result['btCostListId']=document.<portlet:namespace />fm.<portlet:namespace />btCostListId.value;
			result['item']=document.<portlet:namespace />fm.<portlet:namespace />item.value;
			result['type']=document.<portlet:namespace />fm.<portlet:namespace />type.value;
			result['invoiceAmount']=document.<portlet:namespace />fm.<portlet:namespace />invoiceAmount.value;
			result['netAmount']=document.<portlet:namespace />fm.<portlet:namespace />netAmount.value;
			result['taxAmount']=document.<portlet:namespace />fm.<portlet:namespace />taxAmount.value;
			/* result['taxRate']=document.<portlet:namespace />fm.<portlet:namespace />taxRate.value;	 */		
			result['invoiceCurrency']=document.<portlet:namespace />fm.<portlet:namespace />invoiceCurrency.value;
			result['countryCity']=document.<portlet:namespace />fm.<portlet:namespace />countryCity.value;
			result['paymentCurrency']=document.<portlet:namespace />fm.<portlet:namespace />paymentCurrency.value;
			result['paymentAmount']=document.<portlet:namespace />fm.<portlet:namespace />paymentAmount.value;
			Util.getOpener().Liferay.fire('<%= HtmlUtil.escapeJS(eventName) %>',result);
			Util.getWindow().destroy();
		},
		'.selector-button'
	);
</aui:script>

<aui:script>

   //validate countryCity not null
   function validateCountryCity(){
	   var flag=true;
	   var countryCity=document.getElementById("countryCity");
	   if(countryCity.value==null||countryCity.value==""){
		 flag=false;
		 alert("Please fill in the countryCity!");
		 countryCity.focus();		   
	   }
	   return flag;
   }
   //validate invoiceAmount is pure digital
   function validateInvoiceAmount(){
	   var flag=true;
	   var invoiceAmount=document.getElementById("invoiceAmount");
	   if(invoiceAmount.value==null||invoiceAmount.value==""){
		   flag =false;
		   alert("Please fill in the invoiceAmount!");
		   invoiceAmount.focus();	   
	   }else if(isNaN(invoiceAmount.value)||parseFloat(invoiceAmount.value)<0){
		   flag=false;
		   alert("Please fill in the pure digital invoiceAmount!");
		   invoiceAmount.focus();		   
	   }
	   return flag;
   }
	function selectCurrencyAsTripType(){
		var tripType=document.getElementById("tripTypeCostlist").value;
		var invoiceCurrency=document.getElementById("invoiceCurrency");
		var paymentCurrency=document.getElementById("paymentCurrency");
		paymentCurrency.disabled=false;
		paymentCurrency.value=invoiceCurrency.value;
		paymentCurrency.disabled=true;
		var taxAmount=document.getElementById("taxAmount");
		if("EUR"==invoiceCurrency.value){
			taxAmount.disabled=true;
			taxAmount.value="";
			calculateCost();
		}else{
			taxAmount.disabled=false;
		}
	}
	function selectCostItem(){
		var ttv = "<%=travelTypeVal%>";
		var costListItem=document.getElementById("costListItem").value;
		var invoiceCurrency=document.getElementById("invoiceCurrency");
		var paymentCurrency=document.getElementById("paymentCurrency");
		var netAmount=document.getElementById("netAmount");
		var taxAmount=document.getElementById("taxAmount");
		var grossAmount=document.getElementById("invoiceAmount");
		/* var taxRate=document.getElementById("taxRate"); */
		if(costListItem=="Accommodation-Domestic"){
			$("#titleul li:gt(2)").show();
			$("#infoul li:gt(2)").show();
			/* taxRate.disabled=false; */
			netAmount.disabled=false;
			taxAmount.disabled=false;
			paymentCurrency.disabled=false;
			paymentCurrency.value="RMB";
			paymentCurrency.options[0].selected = true; 
			paymentCurrency.disabled=true;
			invoiceCurrency.disabled=false;
			invoiceCurrency.value="RMB";
			invoiceCurrency.options[0].selected = true; 
			invoiceCurrency.disabled=true;
			grossAmount.disabled=true;
		}else if(costListItem=="Accommodation-International"){
			$("#titleul li:gt(2)").show();
			$("#infoul li:gt(2)").show();
			netAmount.disabled=false;
			taxAmount.disabled=false;
			paymentCurrency.disabled=false;
			if(ttv==0){
				invoiceCurrency.disabled=true;
			}else{
				invoiceCurrency.disabled=false;
			}
			/* taxRate.disabled=false;
			taxRate.value="0.00";
			taxRate.options[0].selected = true; 
			taxRate.disabled=true; */
			grossAmount.disabled=true;
		}else{
			$("#titleul li:gt(2)").hide();
			$("#infoul li:gt(2)").hide();
			paymentCurrency.disabled=false;
			if(ttv==0){
				invoiceCurrency.disabled=true;
			}else{
				invoiceCurrency.disabled=false;
			}
			/* taxRate.disabled=true; */
			netAmount.disabled=true;
			taxAmount.disabled=true;
			grossAmount.disabled=false;
		}
		/* selectTaxRate(); */
		paymentCurrency.disabled=true;
	}
	function selectTaxRate(){
		var grossAmount=document.getElementById("invoiceAmount").value;
		var taxRate=document.getElementById("taxRate").value;
		if(grossAmount!=""){
			var netAmount=(parseFloat(grossAmount)/(1+parseFloat(taxRate))).toFixed(2);
			var taxAmount=(parseFloat(netAmount)*parseFloat(taxRate)).toFixed(2);
			document.getElementById("netAmount").value=netAmount;
			document.getElementById("taxAmount").value=taxAmount;
		}else{
			document.getElementById("netAmount").value="0.00";
			document.getElementById("taxAmount").value="0.00";
		}
		
	}
	$('#invoiceAmount').bind('input propertychange', function() {
		/* selectTaxRate(); */
		calculateNetAmount();
	});
	$('#netAmount').bind('input propertychange', function() {
		/* selectTaxRate(); */
		calculateCost();
	});
	$('#taxAmount').bind('input propertychange', function() {
		/* selectTaxRate(); */
		calculateCost();
	});
	function calculateCost(){
		var netAmount=document.getElementById("netAmount").value;
		var taxAmount=document.getElementById("taxAmount").value;
		if(""==netAmount){
			netAmount=0;
		}
		if(""==taxAmount){
			taxAmount=0;
		}
		document.getElementById("invoiceAmount").value=(parseFloat(netAmount)+parseFloat(taxAmount)).toFixed(2);
	}
	function calculateNetAmount(){
		var invoiceAmount=document.getElementById("invoiceAmount").value;
		var costListItem=document.getElementById("costListItem").value;
		
		if(!(costListItem=="Accommodation-Domestic"||costListItem=="Accommodation-International")){
			document.getElementById("netAmount").value=invoiceAmount;
		}
	}
    //cancel
	function <portlet:namespace/>cancel(){
		var Util = Liferay.Util;
		Util.getWindow().destroy();
	}
	
	window.onload=function(){
		selectCostItem();
		selectCurrencyAsTripType();
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

