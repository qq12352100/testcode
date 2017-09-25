<%@include file="/html/init.jsp"%>
<%
	BtExchangeRate btExchangeRate = BtExchangeRateLocalServiceUtil.fetchByF_S_S("RMB", "EUR", BusinessTripConstants.VALID_STATUS);
%>

<portlet:actionURL var="addBusinessTripExchangeRateURL" name="addBusinessTripExchangeRate" windowState="normal" />

<aui:form name="fm" method="POST" action="<%=addBusinessTripExchangeRateURL%>">
	<div class="mainbody">
		<div class="gernal employeeInfo">
			<div class="subtitle">
				<liferay-ui:message	key="vgc-apon-business-trip-exchange-rate-setting" />
			</div>
			<ul>
			<li>1 EUR = <input type="text" name="<portlet:namespace/>secToFirExchangeRate" 
					style="width: 100px" value="<%=btExchangeRate!=null?btExchangeRate.getSecToFirExchangeRate():0 %>" maxlength="75" readonly="readonly"/>&nbsp;RMB
				</li>
			</ul>
			<ul>
				<li>1 RMB = <input type="text" name="<portlet:namespace/>firToSecExchangeRate" 
					style="width: 100px" value="<%=btExchangeRate!=null?btExchangeRate.getFirToSecExchangeRate():0 %>" maxlength="75" readonly="readonly"/>&nbsp;EUR
				</li>
			
			</ul>
		</div>
	</div>
</aui:form>

