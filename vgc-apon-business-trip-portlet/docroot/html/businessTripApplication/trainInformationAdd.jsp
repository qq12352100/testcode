
<%@include file="/html/init.jsp"%>

<%
	String eventName = ParamUtil.getString(request, "eventName", liferayPortletResponse.getNamespace() + "AddBusinessTripApplication");
	String tabs2 = ParamUtil.getString(request, "tabs2","train");
	Boolean isNew=true;
	long pkId = ParamUtil.getLong(request, "pkId",0);
	BtTrainInfo btTrainInfo = null;
	if (pkId != 0) {
		btTrainInfo = BtTrainInfoLocalServiceUtil.fetchBtTrainInfo(pkId);		
		isNew = btTrainInfo!=null?false:true;
	}else {
		pkId = CounterLocalServiceUtil.increment(BtTrainInfo.class.getName(), 1);
		btTrainInfo = BtTrainInfoLocalServiceUtil.createBtTrainInfo(pkId);
	}
%>


<!-- this is for hotelinformation start -->
<aui:form method="post" name="fm">
	<aui:fieldset>	
	<input type="hidden" name="<portlet:namespace/>pkId" value="<%=pkId %>"/>
	<input type="hidden" name="<portlet:namespace/>tabs2" value="<%=tabs2%>"/>
	
		<div class="mainbody">
		    <div class="newtb">
		    	<ul>
		    	    <li class="nd02"><liferay-ui:message key="vgc-apon-business-trip-application-train-from"/></li>
		    	    <li class="nd02"><liferay-ui:message key="vgc-apon-business-trip-application-train-to"/></li>
		    	    <li class="nd02"><liferay-ui:message key="vgc-apon-business-trip-application-train-departure-date"/></li>	
		    	    <li class="nd02"><liferay-ui:message key="vgc-apon-business-trip-application-train-departure-train"/></li>
		    	    <li class="nd02"><liferay-ui:message key="vgc-apon-business-trip-application-train-class"/></li>		    	        	    
		    	</ul>
		    	
		    	<ul>
		    	    <li class="nd02">
		    	    	<input type="text" name="<portlet:namespace/>fromCity" id="fromCity" value="<%=isNew?"":btTrainInfo.getFromCity() %>" required="required" maxlength="75"/>
		    	    </li>
		    	    <li class="nd02">
		    	    	<input type="text" name="<portlet:namespace/>toCity" id="toCity" value="<%=isNew?"":btTrainInfo.getToCity() %>" required="required" maxlength="75"/>
		    	    </li>
		    	    <li class="nd02">
		    	    	<input class="Wdate" type="text" maxlength="75"
							value="<%=isNew?"":sdf.format(btTrainInfo.getDepartureDate())%>"
							name="<portlet:namespace/>departureDate"
							onFocus="WdatePicker({lang:'en',dateFmt:'dd.MM.yyyy HH:mm'})" />
		    	    </li>	
		    	    <li class="nd02">
		    	    	<input type="text" name="<portlet:namespace/>departureTrain" value="<%=isNew?"":btTrainInfo.getDepartureTrain() %>" id="departureTrain" maxlength="75"/>
		    	    </li>
		    	    <li class="nd02">
		    	    	<select name="<portlet:namespace/>classInfo"
							id="category">
								<%
				                String category=isNew?"Economy":btTrainInfo.getClassInfo();
						        for(String label:new String[]{"Business Class","First Class","Second Class","Others"}){					        		
						        %>
								<option value="<%=label%>"
									<%=category.equals(label)?"selected='selected'":""%>><%=label%></option>
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
			if(!validateByNameLabel('fromCity','<liferay-ui:message key="vgc-apon-business-trip-application-train-from"/>')
				|| !validateByNameLabel('toCity','<liferay-ui:message key="vgc-apon-business-trip-application-train-to"/>')
				|| !validateByNameLabel('departureDate','<liferay-ui:message key="vgc-apon-business-trip-application-train-departure-date"/>')) {
				return false;
			}	
			var result={};			
			result['pkId']=document.<portlet:namespace />fm.<portlet:namespace />pkId.value;
			result['tabs2']=document.<portlet:namespace />fm.<portlet:namespace />tabs2.value;
			result['fromCity']=document.<portlet:namespace />fm.<portlet:namespace />fromCity.value;
			result['toCity']=document.<portlet:namespace />fm.<portlet:namespace />toCity.value;
			result['departureDate']=document.<portlet:namespace />fm.<portlet:namespace />departureDate.value;
			result['departureTrain']=document.<portlet:namespace />fm.<portlet:namespace />departureTrain.value;
			result['classInfo']=document.<portlet:namespace />fm.<portlet:namespace />classInfo.value;				
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


