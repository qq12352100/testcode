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

<%
	PortletURL portletURL = renderResponse.createRenderURL();			 
	portletURL.setParameter("mvcPath", "/html/admin/view.jsp");
	String carCategory = (String)renderRequest.getParameter("carCategory");
	String carType = (String)renderRequest.getParameter("carType");
	String carBrand = (String)renderRequest.getParameter("carBrand");
	String contractType = (String)renderRequest.getParameter("contractType");
	if (Validator.isNotNull(carType)) {
		portletURL.setParameter("carType", carType);		
	}
	if (Validator.isNotNull(contractType)) {
		portletURL.setParameter("contractType", contractType);		
	}
	if (Validator.isNotNull(carBrand)) {
		portletURL.setParameter("carBrand", carBrand);		
	}
	if (Validator.isNotNull(carCategory)) {
		portletURL.setParameter("carCategory", carCategory);		
	}
%>

<liferay-ui:error key="importFileError"
	message="vag.apon.uploaded.the.file.format.is.not.correct"></liferay-ui:error>	
	
<portlet:resourceURL var="exportExcelREURL"></portlet:resourceURL>

<portlet:actionURL var="queryURL" windowState="normal">
	<portlet:param name="cmd" value="<%=Constants.SEARCH %>"/>
</portlet:actionURL>

<aui:form action="<%=queryURL %>" method="post" name="fm">
	<aui:fieldset>
		<div class="mainbody">
			<h3><%=themeDisplay.getPortletDisplay().getTitle() %></h3>
			<div class="sbox">	
				<ul>
					<li class="sd01"><liferay-ui:message
									key="vgc.apon.company.car.query.car.type"></liferay-ui:message></li>
					<li class="sd022">						
						<select name="<portlet:namespace/>carType" >
				          	<option value=""></option>
				                <%
						        for(String label:new String[]{"First Company Car","Second Company Car"}){
						        	String selected="";
						        	if(carType!=null&&carType.equals(label)) {
						        		selected="selected='selected'";
						        	}						        		
						        %>
						        	<option <%=selected %> value="<%=label%>"><%=label%></option>
						        <% 
						        }
						        %>
		               </select>	
					</li>
					<li class="sd01"><liferay-ui:message
								key="vgc.apon.company.car.query.contract.type"></liferay-ui:message></li>
					<li class="sd022">
						<select name="<portlet:namespace/>contractType">						        
						   <option value=""></option>
				          		 <%
						        for(String label:new String[]{"LOCAL","LE","FSE","Contractor","Intern"}){
						        	String selected="";
						        	if(contractType!=null&&contractType.equals(label)) {
						        		selected="selected='selected'";
						        	}						        		
						        %>
						        	<option <%=selected %> value="<%=label%>"><%=label%></option>
						        <% 
						        }
						        %>
		               </select>				
					</li>
				</ul>
				<ul>					
					<li class="sd01"><liferay-ui:message
								key="vgc.apon.company.car.query.car.brand"></liferay-ui:message></li>
					<li class="sd022">
						<input type="text"
						name="<portlet:namespace/>carBrand" maxlength="75"
						value="<%=carBrand==null?"":carBrand%>">
					</li>
					<li class="sd01"><liferay-ui:message
									key="vgc.apon.company.car.query.car.category"></liferay-ui:message></li>
					<li class="sd022">						
						<select name="<portlet:namespace/>carCategory" id="<portlet:namespace/>carCategory">
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
					<li style="text-align:center">
						<liferay-ui:icon iconCssClass="icon-search"
							label="<%=true%>" linkCssClass="btn"
							message="vgc.apon.button.search"
							url='<%="javascript:" + renderResponse.getNamespace()+ "query();"%>' />		
					</li>
				</ul>		
			</div>
		</div>		
	</aui:fieldset>
	
	<aui:button-row>
		<aui:button value="vgc.apon.button.upload"
		 onClick='<%= renderResponse.getNamespace() + "openImportPage();" %>'/>
		<aui:button onClick='<%= renderResponse.getNamespace() + "export();" %>'  value="vgc.apon.button.download"/>
	</aui:button-row>
</aui:form>

<liferay-ui:search-container emptyResultsMessage="vgc.apon.there.is.no.car.information.to.display" delta='<%=Integer.valueOf(PropsUtil.get("vgc.apon.delta")) %>' iteratorURL="<%=portletURL %>">
	<liferay-ui:search-container-results results="<%=CompanyCarManagementLocalServiceUtil.findByC_C_C_C(carType, contractType, carBrand, carCategory, searchContainer.getStart(), searchContainer.getEnd()) %>" 
		total="<%=(int)CompanyCarManagementLocalServiceUtil.findCountByC_C_C_C(carType, contractType, carBrand, carCategory) %>">
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row className="com.company.car.model.CompanyCarManagement" keyProperty="companyCarManagementId" modelVar="companyCarManagement" escapedModel="<%= true %>">

		<liferay-ui:search-container-column-text name="vgc.apon.number"
			property="carNo" />
		<liferay-ui:search-container-column-text name="vgc.apon.car.type"
			property="carType" />
		<liferay-ui:search-container-column-text name="vgc.apon.contract.type"
			property="contractType" />
		<liferay-ui:search-container-column-text name="vgc.apon.grade.type"
			property="gradeType" />
		<liferay-ui:search-container-column-text name="vgc.apon.grade"
			property="grade" />
		<liferay-ui:search-container-column-text name="vgc.apon.car.brand"
			property="carBrand" />
		<liferay-ui:search-container-column-text name="vgc.apon.car.model"
			property="carModel" />
		<liferay-ui:search-container-column-text name="vgc.apon.car.category"
			property="carCategory" />
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>

<aui:script>
	function <portlet:namespace/>query() {
		submitForm(document.<portlet:namespace />fm);		
	}
	
	//Export the excel
	function <portlet:namespace/>export() {
		var downloadUrl = '<%=exportExcelREURL %>';		
		window.location.href = downloadUrl;
	}

	function <portlet:namespace/>openImportPage() {
		Liferay.Util.selectEntity(
				{
					dialog: {
						constrain: true,
						modal: true,
						width:700,
						height:300
					},
					id: '<portlet:namespace />ImportCompanyCarManagement',
					title: '<liferay-ui:message  key="vgc.apon.company.car.upload.the.company.car"/>',
					uri:'<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>"><portlet:param name="mvcPath" value="/html/admin/import.jsp" /></portlet:renderURL>'
				},
				function(event) {	
					submitForm(document.<portlet:namespace/>fm);
				}
			);	
	}
</aui:script>
