<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%
if (renderRequest.getAttribute("startDate") != null&& !renderRequest.getAttribute("startDate").equals("")) {
	portletURL.setParameter("startDate",startDate);
}else{
	 startDate = sdf_dmy.format(ToSAPDateUtil.getCurrYearFirst());
	portletURL.setParameter("startDate",startDate);
}
if (renderRequest.getAttribute("endDate") != null&&!renderRequest.getAttribute("endDate").equals("")) {
	portletURL.setParameter("endDate",endDate);
}else{
	endDate = sdf_dmy.format(ToSAPDateUtil.getCurrYearLast());
	portletURL.setParameter("endDate",endDate);
}
if (renderRequest.getAttribute("applicant") != null) {
	portletURL.setParameter("applicant",applicant);
}
if (renderRequest.getAttribute("ticketNo") != null) {
	portletURL.setParameter("ticketNo",ticketNo);
}	
int totalpending=(int)BusinessTripReimbursementLocalServiceUtil.findCountByS_U_SAP(0, ticketNo,applicant, 0, startDate,endDate,sapDocumentId);

%>
<portlet:renderURL var="PendingToSAPviewUrl">
	<portlet:param name="tabs2" value="Posted In SAP" />
</portlet:renderURL>



<aui:form action="<%=queryBusinessTripReimbursementURL%>" method="post"
	name="fm" style="width:100%">
	<aui:fieldset>
		<div class="searchbox">
			<ul class="txt2">
				<input type="hidden" name="<portlet:namespace/>tabs2"
					value="Pending To SAP" />
				<li class="sd01"><liferay-ui:message
						key="vgc.apon.query.ticket.no"></liferay-ui:message></li>
				<li class="sd02"><input type="text"
					name="<portlet:namespace/>ticketNo" style="width:223px;"
					value="<%=ticketNo != null ? ticketNo : ""%>" maxlength="75">
				<li class="sd01"><liferay-ui:message
						key="vgc-apon-business-trip-sap-applicant-search"></liferay-ui:message></li>
				<li class="sd02"><input type="text"
					name="<portlet:namespace/>applicant" style="width:223px;"
					value="<%=applicant != null ? applicant : ""%>" maxlength="75"></li>
			</ul>
			<ul>
				<li class="sd01"><liferay-ui:message
						key="vgc.apon.query.period"></liferay-ui:message></li>
				<li class="sd03"><input id="d4311" class="Wdate" type="text"
					name="<portlet:namespace/>startDate" style="width:100px;"
					value="<%=startDate == null ? "" : startDate%>"
					onFocus="WdatePicker({lang:'en',dateFmt:'dd.MM.yyyy',maxDate:'#F{$dp.$D(\'d4312\')}'})" />
					~ <input id="d4312" class="Wdate" type="text"
					name="<portlet:namespace/>endDate" style="width:100px;"
					value="<%=endDate == null ? "" : endDate%>"
					onFocus="WdatePicker({lang:'en',dateFmt:'dd.MM.yyyy',minDate:'#F{$dp.$D(\'d4311\')}'})" />
				</li>
				<li style="width:250px;" class="sd01"></li>
				<li><liferay-ui:icon iconCssClass="icon-search"
						label="<%=true%>" linkCssClass="btn" message="vgc.apon.search"
						url='<%="javascript:" + renderResponse.getNamespace()
							+ "queryBusinessTripReimbursementPendingSAP();"%>' />

				</li>
			</ul>
		</div>
	</aui:fieldset>
</aui:form>
<div>
	<h5>
		Total result : <%=totalpending %>
	</h5>
</div>
<div>
	<aui:button-row>
		<aui:button style="margin-right:20px;" cssClass="selector-button"
			value="vgc-apon-business-trip-to-sap"
			onClick='<%= renderResponse.getNamespace() + "toSAP();" %>' />
	</aui:button-row>
</div>
<aui:form name="searchFm" style="width:100%">
	<liferay-ui:search-container
		delta='<%=Integer.valueOf(PropsUtil.get("vgc.apon.delta"))%>'
		rowChecker="<%=new RowChecker(renderResponse)%>" iteratorURL="<%=portletURL %>">

		<liferay-ui:search-container-results
			results="<%=BusinessTripReimbursementLocalServiceUtil
								.findByS_U_SAP(0, ticketNo, applicant, 0,
										startDate, endDate,sapDocumentId,
										searchContainer.getStart(),
										searchContainer.getEnd())%>"
			total="<%=(int)BusinessTripReimbursementLocalServiceUtil
										.findCountByS_U_SAP(0, ticketNo,
												applicant, 0, startDate,
												endDate,sapDocumentId)%>">
		</liferay-ui:search-container-results>
		<liferay-ui:search-container-row
			className="com.business.trip.model.BusinessTripReimbursement"
			keyProperty="businessTripReimbursementId"
			modelVar="businessTripReimbursement" escapedModel="<%=true%>">
			<liferay-ui:search-container-column-text
				name="vgc-apon-business-trip-application-ticket-no"
				property="ticketNo" />

			<liferay-ui:search-container-column-text
				name="vgc-apon-business-trip-sap-applicant-search"
				property="printName" />
			<liferay-ui:search-container-column-text
				name="vgc-apon-business-trip-sap-application-time"
				property="submittedDate" />
			<liferay-ui:search-container-column-text
				name="vgc-apon-business-trip-sap-action-time"
				property="modifiedDate" />
			<liferay-ui:search-container-column-text
				name="vgc-apon-business-trip-sap-current-status">
				<%=(businessTripReimbursement.getSapStatus() == 0 || businessTripReimbursement
									.getSapStatus() == -1) ? "To Be Paid" : ""%>
			</liferay-ui:search-container-column-text>

			<liferay-ui:search-container-column-text
				name="vgc-apon-business-trip-sap-comments" property="sapComments" />

			<liferay-portlet:renderURL var="openBusinessTripApplicationURL"
				windowState="normal" plid="<%=myApplicationsPlid%>"
				portletName="mysubmissionslist_WAR_vgcaponmysubmissionsportlet">
				<liferay-portlet:param name="mvcPath"
					value="/html/mysubmissionslist/details/business_trip_reimbursement_details.jsp" />
				<liferay-portlet:param name="pkId"
					value="<%=String.valueOf(businessTripReimbursement
									.getBusinessTripReimbursementId())%>" />
				<liferay-portlet:param name="tabs2" value="Pending To SAP" />
				<liferay-portlet:param name="operationType" value="PendingToSAP" />
			</liferay-portlet:renderURL>

			<liferay-ui:search-container-column-text
				name="vgc-apon-business-trip-sap-detail">
				<a href='<%=openBusinessTripApplicationURL%>'><img
					src='<%=themeDisplay.getPathThemeImages()
									+ "/diff/vgc_apon_my_applications_details.png"%>' /></a>
			</liferay-ui:search-container-column-text>

		</liferay-ui:search-container-row>


		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</aui:form>
<div class="bottomBtn">
	<aui:button-row>

		<aui:button style="margin-right:20px;" cssClass="selector-button"
			value="vgc-apon-business-trip-to-sap"
			onClick='<%= renderResponse.getNamespace() + "toSAP();" %>' />
	</aui:button-row>
</div>

<aui:script>    		
					
					Liferay.provide(  
        window,  
        '<portlet:namespace />toSAP',  
        	function() { 
        		var ids= Liferay.Util.listCheckedExcept(document.<portlet:namespace />searchFm, '<portlet:namespace />allRowIds');  
        	  	if(ids.length>0) {
            		if (confirm('Are you sure to toSAP them?'))  {              
               			PendingToSap(ids)
            		}  
       			}else{
       				alert("There is no one to choose.");
       				return false;
       			}
        },  
        ['liferay-util-list-fields']  
    );  
					function <portlet:namespace/>queryBusinessTripReimbursementPendingSAP() {
						var formId = "<portlet:namespace />fm";
						document.getElementById(formId).submit();
					}
					function PendingToSap(businessTripReimbursementIds){
					AUI().use('aui-io-request',function(A){
						var ajaxRequest=A.io.request('<%=ajaxURL %>'+'&<portlet:namespace/>cmd=pendingtosap'+'&<portlet:namespace/>businessTripReimbursementIds='+businessTripReimbursementIds,{
							autoLoad:false,
							 dataType: 'json',
							on:{
								success:function(){
									//var data=this.get('responseData');
									//if(data==true){
									//	alert("Pending To SAP Success!");
									//}else{
									//	alert("Pending To SAP Failure!");
								//	}
									window.location="<%=PendingToSAPviewUrl%>";
								},
								error:function(){
									window.location="<%=PendingToSAPviewUrl%>"
								}
						}
						});
						ajaxRequest.start();
					});
					}
    </aui:script>
					

				