<%@include file="/html/init.jsp"%>
<%
	String ticketNo = ParamUtil.getString(request, "ticketNo");
	int status = ParamUtil.getInteger(request, "status", -1);
	String periodStart = ParamUtil.getString(request, "periodStart");
	String periodEnd = ParamUtil.getString(request, "periodEnd");
	String travelType = ParamUtil.getString(request, "travelType","0");

	
	int pageindex = ParamUtil.getInteger(renderRequest, "cur", 1);
	int pageSize = ParamUtil.getInteger(renderRequest, "delta", 100000);
	
	PortletURL searchURL = renderResponse.createRenderURL();
	searchURL.setParameter("jspPage", "/html/reports/travelReport.jsp");
	
	PortletURL portletURL = renderResponse.createRenderURL();
	List<String> headerNames = new ArrayList<String>();
	headerNames.add("Print No.");   //增加列名
	headerNames.add("Ticket No.");   //增加列名
	headerNames.add("Staff Code"); //增加列名
	headerNames.add("Staff Name"); //增加列名
	headerNames.add("Approved Date"); //增加列名

	SearchContainer searchContainer = new SearchContainer(renderRequest,null, null,SearchContainer.DEFAULT_CUR_PARAM,SearchContainer.DEFAULT_DELTA,portletURL,headerNames, "");
	searchContainer.setRowChecker(new RowChecker(renderResponse));
	
	List<ResultRow> resultRows = searchContainer.getResultRows();
	List<Object[]> results = BusinessTripReimbursementLocalServiceUtil.reimbursementTravelForReport(travelType, ticketNo, 0,periodStart, periodEnd);
	searchContainer.setTotal(results.size());
	
	String url = portletURL.toString();
	
	int end = searchContainer.getEnd()<results.size()?searchContainer.getEnd():results.size();
	
	for (int i = searchContainer.getStart();i < end; i++) {  
		Object[] temp = (Object[])results.get(i);
		ResultRow row = new ResultRow("","", i);
		row.addText((i+1)+"");  //将数据加入
		row.addText(temp[0]+"");  //将数据加入
		row.addText(temp[1]+"");  //将数据加入
		row.addText(temp[2]+"");  //将数据加入
		row.addText(temp[temp.length-3]+"");  //将数据加入
		
		String businessTripApplicationPageUrl="";
		businessTripApplicationPageUrl=url.substring(0,url.indexOf("/web/"))+"/web/vcic/my-applications?p_p_id=mysubmissionslist_WAR_vgcaponmysubmissionsportlet"+
				"&_mysubmissionslist_WAR_vgcaponmysubmissionsportlet_tabs2=completed"+
				"&_mysubmissionslist_WAR_vgcaponmysubmissionsportlet_pkId="+ temp[temp.length-1] +
				"&_mysubmissionslist_WAR_vgcaponmysubmissionsportlet_operationType=ReimbursementToViewApplication"+
				"&_mysubmissionslist_WAR_vgcaponmysubmissionsportlet_mvcPath=/html/mysubmissionslist/details/business_trip_reimbursement_details.jsp";	
		String s = "<a href='"+businessTripApplicationPageUrl+"'><img src='"+renderRequest.getContextPath()+"/images/reimburse/details.png'></a>";
		row.addText(s);  //将数据加入
		
		resultRows.add(row);  //将显示的行加入
	}
	searchContainer.setResults(resultRows);
	
%>
<style type="text/css">

</style>

<div class="manage-search-box">
  <portlet:resourceURL var="searchToExportURL" >
	<portlet:param name="reportName" value="exportExcel"></portlet:param>
  </portlet:resourceURL>
  <form action="<%=searchToExportURL %>" method="post" name="<portlet:namespace />fm" id="formid" enctype="multipart/form-data">
  <div style="display: none;">
  	<input name="<portlet:namespace />status" value=0 />
  </div>
  <table width="100%" border="0" cellspacing="0" cellpadding="0" >
  	<tr>
  		<td><liferay-ui:message key="Travel Type" /> </td>
  		<td>
		  	<select id="travelType" name="<portlet:namespace />travelType"  style="margin-top:5px;width:220px;">
	  			<option value="0" >Domestic</option>
	  			<option value="2" <% if(travelType.equals("2")){ %>selected="selected"<%} %>>International</option>
	  			<option value="3" <% if(travelType.equals("3")){ %>selected="selected"<%} %>>International-Get RBM</option>
			</select><span style="margin-left: 10px;color: red;">*</span>
  		</td>
  	</tr>
  	
  	<!-- xiaonan add -->
  	<tr>
  		<td><liferay-ui:message key="Ticket No" /> </td>
  		<td>
 			<textarea name="<portlet:namespace />ticketNo" id="textarea_ticketNo" class="search-condition" rows="1" wrap="on"></textarea>
			<div style="display:none;" class="descDivs">
				<textArea id="textarea_ticketNo_show" name="<portlet:namespace />textarea_ticketNo_show" rows="5" class="hideTextAreaScrolls"></textArea>
			</div>
  		</td>
  	</tr>
  	<!-- xiaonan add -->
  	
  	<tr>
  		<td><liferay-ui:message key="Approved Date" /> </td>
  		<td>
 			<span class="fl">
				<liferay-ui:message key="from" />&nbsp;
				<input id="beginDate" name="<portlet:namespace />periodStart" type="text" readonly="readonly" value="<%=periodStart%>" class="searchCondition" style="width:100px;" />
			</span>
			<span onclick="WdatePicker({el:'beginDate',dateFmt:'yyyy-MM-dd',isShowWeek:true,firstDayOfWeek:1,lang:'en',maxDate:'#F{$dp.$D(\'endDate\')}'});" class="date">&nbsp;</span>
			<span class="fl">
				<liferay-ui:message key="to" />&nbsp;
				<input id="endDate" name="<portlet:namespace />periodEnd" type="text" readonly="readonly" value="<%=periodEnd%>" class="searchCondition" style="width:100px;" />
			</span>
			<span onclick="WdatePicker({el:'endDate',dateFmt:'yyyy-MM-dd',isShowWeek:true,firstDayOfWeek:1,lang:'en',minDate:'#F{$dp.$D(\'beginDate\')}'});" class="date">&nbsp;</span>
  		</td>
  	</tr>
  	<tr>
  		<td colspan="2">
  			<input type="button" onclick="searchResult();" value="" class="searchFront" style="background:url(<%=renderRequest.getContextPath()%>/images/reimburse/search.jpg) no-repeat;">
  			&nbsp;&nbsp;&nbsp;&nbsp;
  		<input type="button" value="" class="searchFront" onclick="exportExcel();"
  			 style="background:url(<%=renderRequest.getContextPath()%>/images/reimburse/Export.jpg) no-repeat;">
  		</td>
  	</tr>
  </table>
  </form>
<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
</div>
<div>
</div>
<style>
.col-1{
	width: 3%;
	text-align: center !important;
}
.col-2{ width: 11%;} 
.col-3{	width: 9%;} 
.col-4{	width: 9%;} 
.col-5{	
	width:15%;
	word-break: break-all; 
	word-wrap: break-word;
}
.col-6{	
	width:9%;
	word-break: break-all; 
	word-wrap: break-word;
}
.col-7{	width:8%;}
.col-8{	width:7%;}
.col-9{	width:7%;}
.col-10{width:12%;}
.col-11{ width:10%;}
</style>
<script type="text/javascript">
$(function(){
	$('#textarea_ticketNo').val("");
});
// search
function searchResult(){
	var url = "<%=searchURL %>";
	url += "&_travelReport_WAR_vgcaponbusinesstripportlet_travelType="+$('#travelType').val();
	url += "&_travelReport_WAR_vgcaponbusinesstripportlet_ticketNo="+$('#textarea_ticketNo').val();
	url += "&_travelReport_WAR_vgcaponbusinesstripportlet_periodStart="+$('#beginDate').val();
	url += "&_travelReport_WAR_vgcaponbusinesstripportlet_periodEnd="+$('#endDate').val();
	window.location.href = url;
}
// export
function exportExcel(){
	$('#textarea_ticketNo').val();
	var selects_expot = $('[name="_travelReport_WAR_vgcaponbusinesstripportlet_rowIds"]:checked');
	var ticketNos="";
	jQuery.each(selects_expot, function(i,val) {
		 var tick = $(val).parent("td").next().next();
		 ticketNos+=$(tick).html().trim()+",";
	});
	$('#textarea_ticketNo').html(ticketNos);
	$('#textarea_ticketNo').val(ticketNos);
	document.getElementById("formid").submit();
}
</script>