<%@page import="com.business.trip.util.ToSAPDateUtil"%>
<%@include file="/html/init.jsp"%>
<%
	
	String prefixUrl = "/web"+themeDisplay.getScopeGroup().getFriendlyURL();
	String tabs2 = ParamUtil.getString(request, "tabs2", "Pending To SAP");
	
	String ticketNo = ParamUtil.getString(request, "ticketNo");
	String startDate = ParamUtil.getString(request, "startDate");
	String 	endDate = ParamUtil.getString(request, "endDate");
	String applicant = ParamUtil.getString(request, "applicant");
	String sapDocumentId = ParamUtil.getString(request, "sapDocumentId");
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("oldTab1", tabs2);
	portletURL.setParameter("tabs2", tabs2);
	
	String myApplicationsPageUrl = prefixUrl+PropsUtil.get("vgc.apon.my.applications.page.friendly.url");
	long myApplicationsPlid = PortalUtil.getPlidFromFriendlyURL(
			themeDisplay.getCompanyId(),myApplicationsPageUrl);
%>
<portlet:resourceURL var="ajaxURL"></portlet:resourceURL>

<portlet:actionURL var="queryBusinessTripApplicationURL"
	name="queryBusinessTripApplication" windowState="normal">
</portlet:actionURL>
<div class="mainbody">
<h3><%=themeDisplay.getPortletDisplay().getTitle()%></h3>
<liferay-ui:tabs names="vgc-apon-business-trip-sap-pending-to,vgc-apon-business-trip-sap-posted-in,vgc-apon-business-trip-sap-completed-payment"
	param="tabs2" portletURL="<%=portletURL%>"
	tabsValues="Pending To SAP,Posted In SAP,Payment Completed" ></liferay-ui:tabs>
<% if(tabs2.equals("Pending To SAP")){
	 %>
	 <%@ include file="/html/sappendingbusinesstripapplication/pendingToSAPView.jsp"%>
<% } %>
<% if(tabs2.equals("Posted In SAP")){
	 %>
	 <%@ include file="/html/sappendingbusinesstripapplication/postedInSAPView.jsp"%>
<% } %>
<% if(tabs2.equals("Payment Completed")){
	 %>
	 <%@ include file="/html/sappendingbusinesstripapplication/paymentAsSAPView.jsp"%>
<% } %>
</div>


