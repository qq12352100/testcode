<%--
/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 */
--%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="p" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="lp" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="lt" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="lui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="lut" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!-- Liferay Portal -->
<%@ page import="com.liferay.portal.kernel.dao.orm.QueryUtil" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.dao.search.RowChecker"%>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.util.FastDateFormatFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.StringBundler" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.StringUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.kernel.workflow.WorkflowConstants" %>
<%@ page import="com.liferay.portal.model.Group" %>
<%@ page import="com.liferay.portal.model.ResourceConstants" %>
<%@ page import="com.liferay.portal.model.Role" %>
<%@ page import="com.liferay.portal.model.RoleConstants" %>
<%@ page import="com.liferay.portal.model.User" %>
<%@ page import="com.liferay.counter.service.CounterLocalServiceUtil"%>
<%@ page import="com.liferay.portal.security.auth.PrincipalException" %>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchContainer" %>
<%@ page import="com.liferay.portal.security.permission.PermissionChecker" %>
<%@ page import="com.liferay.portal.security.permission.PermissionCheckerFactoryUtil" %>
<%@ page import="com.liferay.portal.security.permission.ResourceActionsUtil" %>
<%@ page import="com.liferay.portal.service.GroupLocalServiceUtil" %>
<%@ page import="com.liferay.portal.service.PortletPreferencesLocalServiceUtil" %>
<%@ page import="com.liferay.portal.service.RoleLocalServiceUtil" %>
<%@ page import="com.liferay.portal.service.UserLocalServiceUtil" %>
<%@ page import="com.liferay.portal.service.WorkflowDefinitionLinkLocalServiceUtil" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@ page import="com.liferay.portal.webserver.WebServerServletTokenUtil" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.Format" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="javax.portlet.PortletSession" %>

<%@ page import="com.vgc.apon.model.SAPUser" %>
<%@ page import="com.vgc.apon.service.SAPUserLocalServiceUtil" %>
<%@ page import="com.vgc.apon.model.AponSapData" %>
<%@ page import="com.vgc.apon.model.AbsenceQuotaData" %>
<%@ page import="com.vgc.apon.service.AponSapDataLocalServiceUtil" %>
<%@ page import="com.vgc.apon.service.AbsenceQuotaDataLocalServiceUtil"%>

<!-- Related Portlets -->
<%@ page import="com.audit.trail.model.AuditTrailLog" %>
<%@ page import="com.audit.trail.service.AuditTrailLogLocalServiceUtil" %>

<%@ page import="com.file.management.service.FileManagementLocalServiceUtil"%>
<%@ page import="com.file.management.model.FileManagement"%>
<%@ page import="com.global.management.service.GlobalToolLocalServiceUtil"%>  
<%@ page import="com.liferay.portal.kernel.util.PropsUtil"%>

<lt:defineObjects/>
<p:defineObjects/>

<%-- Theme JavaScript --%>
<link class="lfr-css-file" href="<%= HtmlUtil.escapeAttribute(PortalUtil.getStaticResourceURL(request, themeDisplay.getPathThemeCss() + "/vgcapon_main.css")) %>" rel="stylesheet" type="text/css" />
<link class="lfr-css-file" href="<%= HtmlUtil.escapeAttribute(PortalUtil.getStaticResourceURL(request, themeDisplay.getPathThemeCss() + "/vgcapon_reset.css")) %>" rel="stylesheet" type="text/css" />
<script src="<%= HtmlUtil.escape(PortalUtil.getStaticResourceURL(request, themeDisplay.getPathThemeJavaScript() + "/My97DatePicker/WdatePicker.js")) %>" type="text/javascript"></script>
<script src="<%= HtmlUtil.escape(PortalUtil.getStaticResourceURL(request, themeDisplay.getPathThemeJavaScript() + "/vgcapon-validation.js")) %>" type="text/javascript"></script>
<script src="<%= HtmlUtil.escape(PortalUtil.getStaticResourceURL(request, themeDisplay.getPathThemeJavaScript() + "/jquery-2.1.4.min.js")) %>" type="text/javascript"></script>