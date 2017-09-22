
<%@include file="/html/init.jsp"%>

<%
	PortletURL portletURL = renderResponse.createRenderURL();
	String name=(String)renderRequest.getParameter("name");
	String emailAddress=(String)renderRequest.getParameter("emailAddress");
	String trashImage=themeDisplay.getPathThemeImages()+"/common/trash.png";
	if (Validator.isNotNull(name)) {
		portletURL.setParameter("name", name);		
	}
	if (Validator.isNotNull(emailAddress)) {
		portletURL.setParameter("emailAddress", emailAddress);		
	}
	
	String distributionType = request.getAttribute("distributionType")!=null?(String)request.getAttribute("distributionType"):(String)renderRequest.getParameter("distributionType");
	String hrType=PropsUtil.get("vgc.apon.distribution.type.hr");
	String itpType=PropsUtil.get("vgc.apon.distribution.type.itp");
	String type=itpType.equals(distributionType)?itpType:hrType;
%>

<portlet:renderURL var="addUrl">
	<portlet:param name="mvcPath" value="/html/distribution/add.jsp" />
</portlet:renderURL>
<portlet:actionURL name="addDistribution" var="addDistribution"
	windowState="normal">
	<portlet:param name="type" value='<%=type%>'/>
</portlet:actionURL>

<!-- Delete One Distribution -->
<portlet:actionURL name="deleteDistribution" var="deleteDistribution"></portlet:actionURL>

<aui:form method="post" name="deleteDistributionForm" action="<%=deleteDistribution%>">
	<aui:input type="hidden" name="distributionId" />
	<aui:input type="hidden" name="distributionIds" />
</aui:form>

<aui:form name="addDistributionForm" action="<%=addDistribution %>"
	method="post">
	<input type="hidden" name="<portlet:namespace/>addName" id="addName" />
	<input type="hidden" name="<portlet:namespace/>addEmailAddress"
		id="addEmailAddress" />
	<input type="hidden" name="<portlet:namespace/>addComments"
		id="addComments" />
</aui:form>

<portlet:actionURL var="queryURL" windowState="normal">
	<portlet:param name="cmd" value="<%=Constants.SEARCH %>"/>
</portlet:actionURL>

<aui:form action="<%=queryURL%>" method="post" name="fm">
	<aui:fieldset>
		<div class="mainbody">
			<h3><%=themeDisplay.getPortletDisplay().getTitle() %></h3>
			<div class="searchbox">	
				<ul>
					<li class="sd01"><liferay-ui:message key="vgc.apon.query.name"></liferay-ui:message></li>
					<li class="sd02">
						<input type="text"
						name="<portlet:namespace/>name" value="<%=name==null?"":name%>" maxlength="75"/>
					</li>
					<li class="sd01"><liferay-ui:message key="vgc.apon.query.emailAddress"></liferay-ui:message></li>
					<li class="sd02"><input type="text" name="<portlet:namespace/>emailAddress" value="<%=emailAddress==null?"":emailAddress%>" maxlength="75"/></li>
					<li>
						<liferay-ui:icon iconCssClass="icon-search"
							label="<%=true%>" linkCssClass="btn" message="vgc.apon.button.search"
							url='<%="javascript:" + renderResponse.getNamespace()+ "query();"%>' />
					</li>
				</ul>
			</div>
		</div>
	</aui:fieldset>
	<aui:button-row>
		<aui:button value="vgc.apon.button.add"
			 onClick='<%= renderResponse.getNamespace() + "openAddPage();" %>'/>
		<aui:button onClick='<%= renderResponse.getNamespace() + "delete();" %>'
			value="vgc.apon.button.delete" />
	</aui:button-row>
</aui:form>

<aui:form name="searchFm">
	<liferay-ui:search-container
		emptyResultsMessage="vgc.apon.there.are.no.distribution.to.be.display"
		delta='<%=Integer.valueOf(PropsUtil.get("vgc.apon.delta")) %>' iteratorURL="<%=portletURL %>"  rowChecker="<%=new RowChecker(renderResponse) %>">
		
		<liferay-ui:search-container-results  results='<%=DistributionLocalServiceUtil.findByC_N_E_T(PortalUtil.getDefaultCompanyId(), name, emailAddress,type, searchContainer.getStart(), searchContainer.getEnd()) %>' 
			total='<%= DistributionLocalServiceUtil.findCountByC_N_E_T(PortalUtil.getDefaultCompanyId(), name, emailAddress, type)%>'>
		</liferay-ui:search-container-results>

		<liferay-ui:search-container-row
			className="com.e.onboarding.model.Distribution"
			keyProperty="distributionId" modelVar="distribution">
			<liferay-ui:search-container-column-text name="vgc.apon.distribution.list.email.address"
				value="<%= distribution.getEmailAddress()%>" />
			<liferay-ui:search-container-column-text name="vgc.apon.distribution.list.name"
				value="<%=distribution.getName() %>" />
			<liferay-ui:search-container-column-text name="vgc.apon.distribution.list.comments"
				value="<%=distribution.getComments() %>" />
			<liferay-ui:search-container-column-text name="Action">
				<liferay-ui:icon label="<%= true %>" message="" method="get" id="<%=String.valueOf(distribution.getDistributionId()) %>"					
					url='<%="javascript:" + renderResponse.getNamespace()+ "deleteDistribution("+distribution.getDistributionId()+");"%>' src="<%=trashImage%>" />
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator />

	</liferay-ui:search-container>
</aui:form>

<aui:script>      
	Liferay.provide(  
        window,  
        '<portlet:namespace />delete',  
        	function() { 
        		var ids= Liferay.Util.listCheckedExcept(document.<portlet:namespace />searchFm, '<portlet:namespace />allRowIds');  
        	  	if(ids.length>0) {
            		if (confirm('Are you sure to delete them?'))  {              
               			document.<portlet:namespace />deleteDistributionForm.<portlet:namespace />distributionIds.value = ids;  
                		submitForm(document.<portlet:namespace />deleteDistributionForm);  
            		}  
       			}else{
       				alert("There is no one to choose.");
       				return false;
       			}
        },  
        ['liferay-util-list-fields']  
    );  

	function <portlet:namespace/>query() {
		var formId = "<portlet:namespace />fm";
		document.getElementById(formId).submit();
	}
	
	function <portlet:namespace/>deleteDistribution(distributionId){
		document.<portlet:namespace/>deleteDistributionForm.<portlet:namespace/>distributionId.value=distributionId;
		if(confirm('Are you sure to delete it?')) {
			submitForm(document.<portlet:namespace/>deleteDistributionForm);
		}
	}	
	
	function submitAddDistributionForm(){
		submitForm(document.<portlet:namespace/>addDistributionForm);
	}
	
	function <portlet:namespace/>openAddPage() {
		Liferay.Util.selectEntity(
				{
					dialog: {
						constrain: true,
						modal: true,
						width:800,
						height:300
					},
					id: '<portlet:namespace />AddDistribution',
					title: '<liferay-ui:message  key="vgc.apon.new.distribution"/>',
					uri:'<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>"><portlet:param name="mvcPath" value="/html/distribution/add.jsp" /><portlet:param name="vacancyStatus" value="Open" /></portlet:renderURL>'
				},
				function(event) {
					document.getElementById("addName").value=event.name;
					document.getElementById("addEmailAddress").value=event.emailAddress;
					document.getElementById("addComments").value=event.comments;
					submitAddDistributionForm();
				}
			);
	}	
</aui:script>