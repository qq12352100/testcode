
<%
	/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */
%>

<%@include file="/html/init.jsp"%>

<aui:script>
	function <portlet:namespace/>query() {
		var obj=document.getElementById("<portlet:namespace />carCategory1");
		var carCategory=obj.options[obj.selectedIndex].value;
		var carBrand = document.getElementById("<portlet:namespace />carBrand1").value;
		document.<portlet:namespace />selectCarFm1.<portlet:namespace />carCategory.value = carCategory;
		document.<portlet:namespace />selectCarFm1.<portlet:namespace />carBrand.value = carBrand;
		submitForm(document.<portlet:namespace />selectCarFm1);		
	}
	
	function <portlet:namespace/>confirm() {
		var arrs = document.getElementsByName("isChecked");
	    for(i=0;i<arrs.length;i++)
	    if(arrs[i].checked==true){
			alert(arrs[i].value);
	        break;
	    }
		var Util = Liferay.Util;
		Util.getWindow().destroy();
	}
	
	//Close the popup window
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

<%
	String carCategory = (String)renderRequest.getParameter("carCategory");
	String carType = (String)renderRequest.getParameter("carType");
	String carBrand = (String)renderRequest.getParameter("carBrand");
	String staffCode = (String)renderRequest.getParameter("staffCode");
	String childrenNumber = (String)renderRequest.getParameter("childrenNumber");
	childrenNumber = childrenNumber==null?"0":childrenNumber;
	String eventName = ParamUtil.getString(request, "eventName", liferayPortletResponse.getNamespace() + "selectCar");
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("eventName", eventName);
	portletURL.setParameter("mvcPath", "/html/admin/select_car.jsp");
	if (Validator.isNotNull(carCategory)) {
		portletURL.setParameter("carCategory", carCategory);
	}
	if (Validator.isNotNull(carType)) {
		portletURL.setParameter("carType", carType);
	}
	if (Validator.isNotNull(carBrand)) {
		portletURL.setParameter("carBrand", carBrand);
	}
	if (Validator.isNotNull(staffCode)) {
		portletURL.setParameter("staffCode", staffCode);
	}
	if (Validator.isNotNull(childrenNumber)) {
		portletURL.setParameter("childrenNumber", childrenNumber);
	}
	
%>

<portlet:actionURL var="addCarInfoURL" windowState="normal">
	<portlet:param name="mvcPath" value="/html/admin/select_car.jsp" />
	<portlet:param name="carType" value="<%=carType %>"/>
	<portlet:param name="staffCode" value="<%=staffCode %>"/>
	<portlet:param name="childrenNumber" value="<%=childrenNumber %>"/>
	<portlet:param name="eventName" value="<%=eventName %>"/>
</portlet:actionURL>

<aui:form action="<%=addCarInfoURL %>" method="post" name="selectCarFm1">
	<aui:fieldset>
		<aui:input name="carCategory" type="hidden" />
		<aui:input name="carBrand" type="hidden" />
	</aui:fieldset>
</aui:form>

<aui:form name="selectCarCategoryForm"> 
	<aui:button cssClass="selector-button"	value="Confirm" />
	<aui:button  value="Back" onClick='<%=renderResponse.getNamespace()+ "cancel();"%>'></aui:button>
</aui:form>
<!-- This form table used to query the users -->
<aui:form action="<%=addCarInfoURL.toString()%>" method="post"
	name="selectCarFm" width="100%">
	<aui:fieldset width="100%">
	<div class="searchbox">	
		<ul>
			<li class="sd01"><liferay-ui:message
							key="vgc.apon.query.field.car.category"></liferay-ui:message></li>
			<li class="sd02">
				<select name="<portlet:namespace/>carCategory" id="<portlet:namespace/>carCategory1">
					<option value=""></option>
					<%for(int i=1;i<7;i++) { 
						String select = "";
						if(carCategory!=null && carCategory.equals(String.valueOf(i))) {
							select = "selected='selected'";
						}
					%>					
						<option  value="<%=i %>" <%=select%>><%=i==0?"":i %></option>
					<%} %>
				</select>
				</li>
				<li class="sd01"><liferay-ui:message
							key="vgc.apon.query.field.car.brand"></liferay-ui:message></li>
				<li class="sd02"><input type="text"
					name="<portlet:namespace/>carBrand" maxlength="75"
					value="<%=carBrand==null?"":carBrand%>" id="<portlet:namespace/>carBrand1"></li>
				<li><liferay-ui:icon iconCssClass="icon-search"
						label="<%=true%>" linkCssClass="btn"
						message="vgc.apon.button.search"
						url='<%="javascript:" + renderResponse.getNamespace()+ "query();"%>' />
						
					<aui:input type="hidden" name="staffCode" value="<%= staffCode %>" />
					<aui:input type="hidden" name="carType" value="<%= carType %>" />
					<aui:input type="hidden" name="carCategory"/>
					<aui:input type="hidden" name="carBrand"/>
				</li>
			</ul>
		</div>
		<div style="padding-top:20px;font-size:13px;">
		  <p>You are entitled to choose a car from the list below.</p>
		  <p>A detailed equipment list for each car model can be found in the VGC intranet as an attachment to Policy No. 5 Company Car: <a href="http://portal.vcic.ap.vwg/policies4" target="_blank">http://portal.vcic.ap.vwg/policies4</a> 
		  </p>
		  <p>All car models with * are referred to as Import Car.</p>
		</div>

		<liferay-ui:search-container var="carSearchContainer"
			emptyResultsMessage="vgc.apon.there.is.no.car.information.to.display" iteratorURL="<%=portletURL %>"
			delta="10">
			<liferay-ui:search-container-results
				results='<%=CompanyCarManagementLocalServiceUtil.findByS_F_C_C_C(staffCode, Integer.valueOf(childrenNumber), carType,carCategory,carBrand,carSearchContainer.getStart(),carSearchContainer.getEnd())%>'
				total='<%=CompanyCarManagementLocalServiceUtil.findByS_F_C_C_C(staffCode, Integer.valueOf(childrenNumber), carType,carCategory,carBrand).size()%>'>
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row
				className="com.company.car.model.CompanyCarManagement"
				keyProperty="companyCarManagementId" modelVar="companyCarManagement"
				escapedModel="<%= true %>">

				<liferay-ui:search-container-column-text>
 					<input  type="radio" name="radio" value="<%=companyCarManagement.getCarModel()%>"/>					
				</liferay-ui:search-container-column-text>
				
				<liferay-ui:search-container-column-text name="vgc.apon.number"
					property="carNo" />
				<liferay-ui:search-container-column-text
					name="vgc.apon.car.category" property="carCategory" />
				<liferay-ui:search-container-column-text name="vgc.apon.car.brand"
					property="carBrand" />
				<liferay-ui:search-container-column-text name="vgc.apon.car.model"
					property="carModel" />
			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</aui:fieldset>
</aui:form>
<!-- Send the related data to the parent page -->

<aui:script use="aui-base">
	var Util = Liferay.Util;
	A.one('#<portlet:namespace />selectCarCategoryForm').delegate(
		'click',
		function(event) {
			var check=A.one("input[type=radio]:checked");
			if(check==null)
				{
				alert("Please Choose one carModel.");
				}else
					{
			var result={};
			result['carModel']=check.val();
			Util.getOpener().Liferay.fire('<%= HtmlUtil.escapeJS(eventName) %>',result);
			Util.getWindow().destroy();
					}
		},
		'.selector-button'
	);
</aui:script>