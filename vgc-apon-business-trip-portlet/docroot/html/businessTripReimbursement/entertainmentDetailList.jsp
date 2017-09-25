<%@page import="java.text.NumberFormat"%>
<%@include file="/html/init.jsp"%>
<%
		String eventName = ParamUtil.getString(request, "eventName", liferayPortletResponse.getNamespace() + "AddEntertainmentItem");
		String tabs2 = ParamUtil.getString(request, "tabs2");
		Boolean isNew=true;
		long pkId = ParamUtil.getLong(request, "pkId",0);
		BtCostList btCostList = null;
		Long btCostListId=null;
		String businessTripReimbursementId=ParamUtil.getString(request, "businessTripReimbursementId");
		//btDetails
		//BtEntertainmentDetail btEntertainmentDetail=null;
		String ticketNo=ParamUtil.getString(request, "ticketNo","");
		String maxDate ="";
		String minDate="";
		SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		BusinessTripApplication businessTripApplication=BusinessTripApplicationLocalServiceUtil.fetchBusinessTripApplicationByTicketNo(ticketNo);
		if(businessTripApplication!=null){
			maxDate=sdf_.format(businessTripApplication.getReturnDate());
			minDate=sdf_.format(businessTripApplication.getDepartureDate());
		}
		if (pkId != 0) {
			btCostList = BtCostListLocalServiceUtil.fetchBtCostList(pkId);
			businessTripReimbursementId=String.valueOf(btCostList.getBusinessTripPkId());
			isNew = btCostList!=null?false:true;
		}else {
			pkId = CounterLocalServiceUtil.increment(BtCostList.class.getName(), 1);
			btCostList = BtCostListLocalServiceUtil.createBtCostList(pkId);
		}
		btCostListId=btCostList.getBtCostListId();		
		//find EntertainmentDetails
		List<BtEntertainmentDetail> t=BtEntertainmentDetailLocalServiceUtil.findByBtCostListId(btCostListId);
		//indexId
		int t2=1;
		if(t!=null){			
		 t2=t.size();				
		}	
%>

<portlet:actionURL var="addEntertainmentURL" name="addEntertainment" windowState="normal" />

<aui:form  method="post" name="fm" action="<%=addEntertainmentURL%>" style="height:auto;width:auto;">
     <aui:fieldset>
        <input type="hidden" name="<portlet:namespace/>pkId" value="<%=pkId %>"/>
        <input type="hidden" name="<portlet:namespace/>tabs2" value="<%=tabs2%>"/>
        <input type="hidden" name="<portlet:namespace/>businessTripReimbursementId" value="<%=businessTripReimbursementId %>"/>
        <input type="hidden" name="<portlet:namespace/>btCostListId" value="<%=btCostListId %>"/>       
        <!-- indexId -->
        <input type="hidden" id="indexId" name="<portlet:namespace/>indexId" value="<%=t2%>"/>
		<div class="mainbody">						
			<div class="gernal">				  
				<ul>
				  <li class="md01"><liferay-ui:message key="vgc-apon-business-trip-reimbursement-cost-list-entertainment-date"></liferay-ui:message></li>
				  <li class="md02"><input class="Wdate" type="text" id="entertainmentDate" maxlength="75"
							value="<%=isNew?"":sdf.format(btCostList.getEntertainmentDate()) %>"
							name="<portlet:namespace/>entertainmentDate"
							onFocus="WdatePicker({lang:'en',dateFmt:'dd.MM.yyyy HH:mm',maxDate:'<%=maxDate %>',minDate:'<%=minDate %>'})" /></li>														
				  <li class="md01"><liferay-ui:message key="vgc-apon-business-trip-reimbursement-cost-list-entertainment-type"></liferay-ui:message></li>
				  <li class="md022">  
				        <select name="<portlet:namespace/>entertainmentType" id="entertainmentType" 
				        <%=businessTripApplication.getTripType()==0 ? "disabled='true'" : "" %>
				        onchange="selectEntertainmentType();">
						<%
						   String type =btCostList.getType()==null?"":btCostList.getType();					
							for (String curType : new String[]{"Domestic","International"}) {
						%>
							<option <%=type.equals(curType) ? "selected='selected'" : "" %> value="<%= LanguageUtil.get(Locale.ENGLISH, curType) %>">
								<%= LanguageUtil.get(pageContext, curType) %>
							</option>
						<%
							}
						%>
						</select>
                  </li>
			     </ul>
			     <ul>
			     <li class="md01"><liferay-ui:message key="vgc-apon-business-trip-reimbursement-cost-list-entertainment-meal-category"></liferay-ui:message></li>
				  <li class="md022">  
				        <select name="<portlet:namespace/>mealCategory">
						<%
						   String mealCategory =btCostList.getMealCategory()==null?"":btCostList.getMealCategory();					
							for (String curType : new String[]{"Lunch","Dinner"}) {
						%>
							<option <%=mealCategory.equals(curType) ? "selected='selected'" : "" %> value="<%=curType%>">
								<%=curType %>
							</option>
						<%
							}
						%>
						</select>
                  </li>
			     </ul>

				  <div class="subtitle">
						&nbsp;&nbsp;&nbsp;<liferay-ui:message key="vgc-apon-business-trip-reimbursement-cost-list-entertainment-fill-up-info" />		
			      </div>
				 
				   <ul>
					 <li class="md01"><liferay-ui:message key="vgc-apon-business-trip-reimbursement-cost-list-entertainment-place"></liferay-ui:message></li>
					 <li class="md02"><input id="entertainmentPlace" type="text" name="<portlet:namespace/>entertainmentPlace" value="<%=isNew?"":btCostList.getEntertainmentPlace() %>" required="required" maxlength="75"></li>
					 <li class="md01"><liferay-ui:message key="vgc-apon-business-trip-reimbursement-cost-list-entertainment-country-city"></liferay-ui:message></li>
					 <li class="md022"><input id="countryCity" type="text" name="<portlet:namespace/>countryCity" value="<%=isNew?"":btCostList.getCountryCity() %>" required="required" maxlength="75"></li>            
			       </ul>	  
		         <br/> 	
		         	  		  
				  <ul>
					  <li class="md01" style="width: 21%;">
					  	<liferay-ui:message key="vgc-apon-business-trip-reimbursement-cost-list-entertainment-guest-info" />
					  </li>
					  <li class="md03" style="width: 77%;">
					  	<aui:button value="vgc-apon-business-trip-reimbursement-cost-list-entertainment-add" style="float: right;" onClick='<%= renderResponse.getNamespace() + "addEntertainmentInfo()" %>'/>
					  </li>	
				  </ul>
				  <ul>
				  	<li class="md03" style="width: 100%; height: auto; overflow: hidden;">
				  		<table id="entertainmentTable" border='1' style='border-collapse:collapse'>
				  			<tr>
				  				<td style="text-align: center; font-size: 15px; font-weight: 600; background-color: rgb(242, 242, 242);">
				  					<liferay-ui:message key="vgc-apon-business-trip-reimbursement-cost-list-entertainment-full-name" />
				  				</td>
				  				<td style="text-align: center; font-size: 15px; font-weight: 600; background-color: rgb(242, 242, 242);">
				  					<liferay-ui:message key="vgc-apon-business-trip-reimbursement-cost-list-entertainment-position-title" />
				  				</td>
				  				<td style="text-align: center; font-size: 15px; font-weight: 600; background-color: rgb(242, 242, 242);">
				  					<liferay-ui:message key="vgc-apon-business-trip-reimbursement-cost-list-entertainment-company" />
				  				</td>
				  				<td style="text-align: center; font-size: 15px; font-weight: 600; background-color: rgb(242, 242, 242);">
				  					<liferay-ui:message key="vgc-apon-business-trip-reimbursement-cost-list-entertainment-action" />
				  				</td>
				  			</tr>
				  			<%
				  			List<BtEntertainmentDetail> t1=BtEntertainmentDetailLocalServiceUtil.findByBtCostListId(btCostListId);
				  			   for(BtEntertainmentDetail btEntertainmentDetail:t1) {	
				  			%>	
				  			<tr>						  				  			
				  				<td style="width: 250px;">
				  					<input type="hidden" id="btEntertainmentDetailId" name="<portlet:namespace/>btEntertainmentDetailId" value="<%=btEntertainmentDetail==null?"":btEntertainmentDetail.getBtEntertainmentDetailId()%>">
				  					<input  id="fullName" type="text" name="<portlet:namespace/>fullName" value="<%=btEntertainmentDetail==null?"":btEntertainmentDetail.getFullName() %>" style="width: 100%;"/>
				  				</td>
				  				<td style="width: 250px;">
				  					<input  id="positionTitle" type="text" name="<portlet:namespace/>positionTitle" value="<%=btEntertainmentDetail==null?"":btEntertainmentDetail.getPositionTitle() %>" style="width: 100%;"/>
				  				</td>
				  				<td>
				  					<input  id="company" type="text" name="<portlet:namespace/>company" value="<%=btEntertainmentDetail==null?"":btEntertainmentDetail.getCompany() %>" style="width: 100%;"/>
				  				</td>
				  				<td style="text-align: center;">
				  					<a href="#" onclick="<portlet:namespace/>removeTd(parentNode.parentNode)"><liferay-ui:message key="vgc-apon-business-trip-reimbursement-cost-list-entertainment-delete" /></a>
				  				</td>
				  			</tr>
				  			<% 
				  			}
				  			%>
				  		</table>
				  	</li>
				  </ul>			
				 <br/>
			
				 <ul class="txt3">
					<li class="md01">
						<liferay-ui:message key="vgc-apon-business-trip-reimbursement-cost-list-entertainment-reasons-for-entertainment" />
					</li>
					<li class="md03">
						<textarea style="height:100px;" id="reasonsInfo" name="<portlet:namespace/>reasonsInfo"  maxlength="200"><%=isNew?"":btCostList.getReasonesInfo() %></textarea>
					</li>				
				 </ul>

		  
		  	 
		  
		  		
		        <ul>
					<li class="md01"><liferay-ui:message key="vgc-apon-business-trip-reimbursement-cost-list-entertainment-amount-total"></liferay-ui:message></li>
					<li class="md02"><input id="amountTotal" type="text" name="<portlet:namespace/>amountTotal" value="<%=isNew?"":btCostList.getInvoiceAmount() %>" required="required" maxlength="75"></li>
					<li class="md01"><liferay-ui:message key="vgc-apon-business-trip-reimbursement-cost-list-entertainment-payment-currency"></liferay-ui:message></li>
					<li class="md022">
					    <select name="<portlet:namespace/>paymentCurrency" id="paymentCurrency" onchange="changeAverageSpend()">
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
		          </ul>	
        	<ul>
			<%--		<li class="md01"><liferay-ui:message key="vgc-apon-business-trip-reimbursement-cost-list-tax-rate"/></li>
		 			<li class="md01">
		    	        <select style="width:150px;" name="<portlet:namespace/>taxRate" id="taxRate" onchange="selectTaxRate()">
						<%
						//获取格式化对象
						NumberFormat nt = NumberFormat.getPercentInstance();
						//设置百分数精确度2即保留两位小数
						nt.setMinimumFractionDigits(0);
						double taxRate=btCostList.getTaxRate();
							for (double curType : new Double[]{0.00,0.03,0.06}) {
						%>
							<option <%=taxRate==curType ? "selected='selected'" : "" %> value="<%= curType %>">
								<%= nt.format(curType) %>
							</option>
						<%
							}
						%>
						</select>  </li> --%>
		    	    <li class="md01"><liferay-ui:message key="vgc-apon-business-trip-reimbursement-cost-list-net-amount"/></li>
		    	    <li class="md02">
		    	        <input type="text" name="<portlet:namespace/>netAmount" id="netAmount" value="<%=isNew?"":btCostList.getNetAmount() %>"  onblur="checkFloat(this)"  onkeyup="this.value=this.value.replace(/[^0-9.]/g,'')" required="required" maxlength="75"/>
		    	    </li>
		    	    <li class="md01"><liferay-ui:message key="vgc-apon-business-trip-reimbursement-cost-list-tax-amount"/></li>			
				 	<li class="md022">
		    	        <input type="text" name="<portlet:namespace/>taxAmount" id="taxAmount"  value="<%=isNew?"":btCostList.getTaxAmount() %>"  onblur="checkFloat(this)"  onkeyup="this.value=this.value.replace(/[^0-9.]/g,'')" required="required" maxlength="75"/>
		    	    </li>
				</ul>
		         <ul>
					<li class="md01"><liferay-ui:message key="vgc-apon-business-trip-reimbursement-cost-list-entertainment-average-spend"></liferay-ui:message></li>
					<li class="md02"><input id="averageSpend" type="text" name="<portlet:namespace/>averageSpend" value="<%=isNew?"":btCostList.getAverageSpend() %>" readOnly="readOnly" maxlength="75" style="border:none"></li>
					<li class="md01"><liferay-ui:message key="vgc-apon-business-trip-reimbursement-cost-list-entertainment-attendees-total"></liferay-ui:message></li>
					<li class="md022"><input id="attendeesTotal" type="text" name="<portlet:namespace/>attendeesTotal" value="<%=isNew?"":btCostList.getAttendeesTotal() %>" readOnly="readOnly" maxlength="75" style="border:none"></li>            
		         </ul>	
				 
			 <div class="cetBtn">
				<aui:button-row>
					<%if(!isNew){
					%>
					<aui:button style="margin-right:20px;" cssClass="selector-button"
						value="vgc-apon-button-update" />
					<%	
					}else {
					%>
					<aui:button style="margin-right:20px;" cssClass="selector-button"
						value="vgc.apon.button.confirm" />
					<%
					}// 
					%>				
				    <aui:button type="cancel"
					   onClick='<%=renderResponse.getNamespace()+ "cancel();"%>'
					name="vgc-apon-business-trip-application-hotel-cancel" />
				</aui:button-row>
			  </div>       
	      </div>
     </div>    	
 </aui:fieldset>  
</aui:form>

<!-- this is for entertainmentInfo -->
<aui:script use="aui-base">
	var Util = Liferay.Util;
	A.one('#<portlet:namespace />fm').delegate(
		'click',
		function(event) {
			var result={};
			//validate for entertainment
			if(!validateOthers()||!validateEntertainmentInfo()||!validateReasonsInfo()||!validateAmountTotal()){				
				return false;
			}
			  var indexId=document.getElementById("indexId").value;
			//count the averageSpend value
			var indexId=document.getElementById("indexId").value;
			var t=document.getElementById("amountTotal").value;	
		 	document.getElementById("attendeesTotal").value=indexId;
		 	document.getElementById("averageSpend").value=t/indexId;
		 	if(indexId==0){
				alert('Please click Add Button to Add data')
				return false;
			}
			//Parameters[]			
			var val="#";
			//btEntertainmentDetailId
			var btEntertainmentDetailIds=document.getElementsByName("<portlet:namespace/>btEntertainmentDetailId");
			var btEntertainmentDetailId="";
			for(var i=0;i<btEntertainmentDetailIds.length;i++){
				btEntertainmentDetailId+=btEntertainmentDetailIds.item(i).value+val;
			   }
			//fullName
			var fullNames=document.getElementsByName("<portlet:namespace/>fullName");
			var  fullName="";
			for(var i=0;i<fullNames.length;i++){				
				fullName+=fullNames.item(i).value+val;
			   }
			//positionTitle
			var positionTitles=document.getElementsByName("<portlet:namespace/>positionTitle");
			var positionTitle="";
			for(var i=0;i<positionTitles.length;i++){
				positionTitle+=positionTitles.item(i).value+val;
			   }
			//company
			var companys=document.getElementsByName("<portlet:namespace/>company");
			var company="";
			for(var i=0;i<companys.length;i++){
				company+=companys.item(i).value+val;
			   }
			result['btEntertainmentDetailId']=btEntertainmentDetailId;
			result['fullName']=fullName;
			result['positionTitle']=positionTitle;
			result['company']=company;			
			//Parameters
			result['pkId']=document.<portlet:namespace />fm.<portlet:namespace />pkId.value;
			result['tabs2']=document.<portlet:namespace />fm.<portlet:namespace />tabs2.value;
			result['businessTripReimbursementId']=document.<portlet:namespace />fm.<portlet:namespace />businessTripReimbursementId.value;
			result['btCostListId']=document.<portlet:namespace />fm.<portlet:namespace />btCostListId.value;			
			result['entertainmentDate']=document.<portlet:namespace />fm.<portlet:namespace />entertainmentDate.value;
			result['entertainmentType']=document.<portlet:namespace />fm.<portlet:namespace />entertainmentType.value;
			result['entertainmentPlace']=document.<portlet:namespace />fm.<portlet:namespace />entertainmentPlace.value;
			result['countryCity']=document.<portlet:namespace />fm.<portlet:namespace />countryCity.value;
			result['reasonsInfo']=document.<portlet:namespace />fm.<portlet:namespace />reasonsInfo.value;	
			result['paymentCurrency']=document.<portlet:namespace />fm.<portlet:namespace />paymentCurrency.value;	
			result['amountTotal']=document.<portlet:namespace />fm.<portlet:namespace />amountTotal.value;				
			result['averageSpend']=document.<portlet:namespace />fm.<portlet:namespace />averageSpend.value;
			result['attendeesTotal']=document.<portlet:namespace />fm.<portlet:namespace />attendeesTotal.value;
			result['mealCategory']=document.<portlet:namespace />fm.<portlet:namespace />mealCategory.value;
			
			result['netAmount']=document.<portlet:namespace />fm.<portlet:namespace />netAmount.value;
			result['taxAmount']=document.<portlet:namespace />fm.<portlet:namespace />taxAmount.value;
			/* result['taxRate']=document.<portlet:namespace />fm.<portlet:namespace />taxRate.value; */
			
			Util.getOpener().Liferay.fire('<%= HtmlUtil.escapeJS(eventName) %>',result);
			Util.getWindow().destroy();
		},
		'.selector-button'
	);
</aui:script>


<aui:script>
	 //validate entertainmentInfo not null
	 function validateEntertainmentInfo(){
			var flag = true;
			var fullNames=document.getElementsByName("<portlet:namespace/>fullName");
			for(var i=0;i<fullNames.length;i++){
				var fullName=fullNames.item(i).value;
				if(fullName==null||fullName==""){
					flag=false;
					alert("Please fill in the fullName!");
					fullNames.item(i).focus();
					break;
				}
			}
			if(flag){
				var positionTitles=document.getElementsByName("<portlet:namespace/>positionTitle");
				for(var i=0;i<positionTitles.length;i++){
					var positionTitle=positionTitles.item(i).value;
					if(positionTitle==null||positionTitle==""){
						flag=false;
						alert("Please fill in the positionTitle!");
						positionTitles.item(i).focus();
						break;
					}
				}
			}
			
			if(flag){
				var companys=document.getElementsByName("<portlet:namespace/>company");
				for(var i=0;i<companys.length;i++){
					var company=companys.item(i).value;
					if(company==null||company==""){
						flag=false;
						alert("Please fill in the company!");
						companys.item(i).focus();
						break;
					}
				}
			}			
			return flag; 		  
	 }
	 //validate others not null
	 function validateOthers(){
		 var flag=true;
		 var entertainmentDate=document.getElementById("entertainmentDate");
		 var entertainmentPlace=document.getElementById("entertainmentPlace");
		 var countryCity=document.getElementById("countryCity");
		 if(entertainmentDate.value==null||entertainmentDate.value==""){
			 flag=false;
			 alert("Please fill in the entertainmentDate!");	
			 entertainmentDate.focus();
		 }
		 if(flag){
			 if(entertainmentPlace.value==null||entertainmentPlace.value==""){
				 flag=false;
				 alert("Please fill in the entertainmentPlace!");
				 entertainmentPlace.focus();
			 }			 
		 }
		 if(flag){
			 if(countryCity.value==null||countryCity.value==""){
				 flag=false;
				 alert("Please fill in the countryCity!");
				 countryCity.focus();
			 }			 
		 }	 
		 return flag;		 
	 }
	 //validate reasonsInfo not null
	 function validateReasonsInfo(){
		 var flag=true;
		 var reasonsInfo=document.getElementById("reasonsInfo");
		 if(reasonsInfo.value==null||reasonsInfo.value==""){
			 flag=false;
			 alert("Please fill in the reasonsInfo!");
			 reasonsInfo.focus();
		 }
		return flag; 
	 }	 
	 //validate the amountTotal is pure number
	 function validateAmountTotal(){
		 var flag=true;
		 var amountTotal=document.getElementById("amountTotal");
		 var reg=/^-?[1-9]*(\.\d*)?$|^-?d^(\.\d*)?$/;
		 if(amountTotal.value==null||amountTotal.value==""){
			 flag=false;
			 alert("Please fill in the amountTotal!");
			 amountTotal.focus();
		 }else if(!reg.test(amountTotal.value)&&isNaN(amountTotal.value)){
			 flag=false;
			 alert("Pleas fill in the pure digital amountTotal!");
			 amountTotal.focus();
		 }
		 return flag;
	 }

   //cancel
	function <portlet:namespace />cancel() {
		var Util = Liferay.Util;
		Util.getWindow().destroy();
	}
		
    //clear Cache
	window.onload=function(){
		selectEntertainmentType();
		changeAverageSpend();
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
    
   //Add one EntertainmentDetail
   var indexId=document.getElementById("indexId").value;
   function <portlet:namespace/>addEntertainmentInfo(){
	 	indexId++;
	 	var entertainmentTable = document.getElementById('entertainmentTable');
	 	var tr = document.createElement("tr");
	 	var td1 = document.createElement("td");
	 	td1.setAttribute("style", "width: 250px;");
	 	var input1 = document.createElement("input");
	 	input1.setAttribute("id", "fullName"+indexId);		
	 	input1.setAttribute("type", "text");
	 	input1.setAttribute("name", "<portlet:namespace/>fullName");
	 	input1.setAttribute("style", "width: 100%;");
	 	
	 	
	 	var td2 = document.createElement("td");
	 	td2.setAttribute("style", "width: 250px;");
	 	var input2 = document.createElement("input");
	 	input2.setAttribute("id", "positionTitle"+indexId);	
	 	input2.setAttribute("type", "text");
	 	input2.setAttribute("name", "<portlet:namespace/>positionTitle");
	 	input2.setAttribute("style", "width: 100%;");
	 	
	 	var input3 = document.createElement("input");
	 	input3.setAttribute("type", "hidden");
	 	input3.setAttribute("id", "btEntertainmentDetailId"+indexId);
	 	input3.setAttribute("name", "<portlet:namespace/>btEntertainmentDetailId");
	 		
	 	var td3 = document.createElement("td");
	 	var input4 = document.createElement("input");
	 	input4.setAttribute("type", "text");
	 	input4.setAttribute("id", "company"+indexId);
	 	input4.setAttribute("name", "<portlet:namespace/>company");	
	 	input4.setAttribute("style", "width: 100%;");
	 
	 	var td4 = document.createElement("td");
	 	td4.setAttribute("style", "text-align: center;");
	 	var a1 = document.createElement("a");
	 	a1.setAttribute("href", "#");
	 	a1.setAttribute("onclick", "<portlet:namespace/>removeTd(parentNode.parentNode)");
	 	a1.appendChild(document.createTextNode("<liferay-ui:message key='vgc.apon.e.leave.delete'/>"));	
	 	td1.appendChild(input3);
	 	td1.appendChild(input1);
	 	td2.appendChild(input2);
	 	
	 	td3.appendChild(input4);
	 	td4.appendChild(a1);
	 	tr.appendChild(td1);
	 	tr.appendChild(td2);
	 	tr.appendChild(td3);
	 	tr.appendChild(td4);
	 	entertainmentTable.appendChild(tr);	
	 	var t=document.getElementById("amountTotal").value;	
	 	document.getElementById("attendeesTotal").value=indexId;
	 	document.getElementById("averageSpend").value=t/indexId;
	 	document.getElementById("indexId").value=indexId;
   }
   
 
   //remove one EntertainmentDetail
   function <portlet:namespace/>removeTd(obj) {
 	  var entertainmentTable = obj.parentNode;  
 	  var count = entertainmentTable.childElementCount;
 	  var ps = '<portlet:namespace/>';
 	  if(count==1 && entertainmentTable.id==ps+'entertainmentTable') {
 		  alert("This node can't delete.If you want to delete this node,please click add first, then you can delete it !");
 		  return false;
 	  }
 	 indexId--;
 	 var t=document.getElementById("amountTotal").value;	
 	 document.getElementById("attendeesTotal").value=indexId;
 	 document.getElementById("averageSpend").value=t/indexId;
 	 document.getElementById("indexId").value=indexId;
 	 entertainmentTable.removeChild(obj);   
 	 entertainmentTable.focus(); 	
 }
   function changeAverageSpend(){
		var t=document.getElementById("amountTotal").value;	
	 	document.getElementById("attendeesTotal").value=indexId;
	 	document.getElementById("averageSpend").value=t/indexId;
	 	document.getElementById("indexId").value=indexId;
	 	var paymentCurrency=document.getElementById("paymentCurrency").value;
		var taxAmount=document.getElementById("taxAmount");
	 	if(paymentCurrency=="EUR"){
			taxAmount.value="";
			taxAmount.disabled=true;
			calculateCost();
	 	}else{
			taxAmount.disabled=false;
		}
   }
   
   function selectEntertainmentType(){
		var entertainmentType=document.getElementById("entertainmentType").value;
		var paymentCurrency=document.getElementById("paymentCurrency");
		var netAmount=document.getElementById("netAmount");
		var taxAmount=document.getElementById("taxAmount");
		var grossAmount=document.getElementById("amountTotal")
		/* var taxRate=document.getElementById("taxRate"); */
		if(entertainmentType=="Domestic"){
			/* taxRate.disabled=false; */
			netAmount.disabled=false;
			taxAmount.disabled=false;
			paymentCurrency.disabled=false;
			paymentCurrency.value="RMB";
			paymentCurrency.options[0].selected = true; 
			paymentCurrency.disabled=true;
		}else if(entertainmentType=="International"){
			netAmount.disabled=false;
			taxAmount.disabled=false;
			paymentCurrency.disabled=false;
			/* taxRate.disabled=false;
			taxRate.value="0.00";
			taxRate.options[0].selected = true; 
			taxRate.disabled=true; */
		}
		grossAmount.readOnly=true;
		/* selectTaxRate(); */
	}
   
   $('#netAmount').bind('input propertychange', function() {
		/* selectTaxRate(); */
		calculateCost();
		changeAverageSpend();
	});
	$('#taxAmount').bind('input propertychange', function() {
		/* selectTaxRate(); */
		calculateCost();
		changeAverageSpend();
	});
   function selectTaxRate(){
		var grossAmount=document.getElementById("amountTotal").value;
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
	function calculateCost(){
		var netAmount=document.getElementById("netAmount").value;
		var taxAmount=document.getElementById("taxAmount").value;
		if(""==netAmount){
			netAmount=0;
		}
		if(""==taxAmount){
			taxAmount=0;
		}
		document.getElementById("amountTotal").value=(parseFloat(netAmount)+parseFloat(taxAmount)).toFixed(2);
	}
   
</aui:script>