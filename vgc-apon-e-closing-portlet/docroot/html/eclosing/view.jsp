<%@ include file="/html/init.jsp"%>

<!-- Parameter -->
<c:set var="namespace"><p:namespace/></c:set>

<!-- Liferay Url -->
<p:renderURL var="getEClosingInfoURL" />
<p:actionURL var="saveOrUpdateEClosingURL" name="saveOrUpdateEClosing" windowState="normal" />
<lp:renderURL var="backURL" portletName="${requestScope.backPortletId }" plid="${requestScope.backPlid }" windowState="normal" />

<aui:script>
var namespace = "${namespace }";
function <p:namespace/>saveOrUpdateEClosing(action){
	if(action == 1){
		if(!validatorStrIsNotNull("staffCode", 0) ||!validatorStrIsNotNull("lastWorkingDay",2) || !validatorStrIsNotNull("finishContractDate", 0)
		 || !validatorStrIsNotNull("seatOfficeNumber", 2)){
			return false;
		}
		if(!(validatorTime())){
			alert("Last Working Day should not be later than Finish Contract Date.");
			return false;
		}
	}
	$("#"+namespace+"action").val(action);
	$("#"+namespace+"fm1").submit();
}

$(document).ready(function(){
	$("#setEClosingInfo").click(function(){
		if(validatorStrIsNotNull("staffCode", 0)){
			var setEClosingInfoUrl = "${getEClosingInfoURL }" + "&" + namespace + "eClosingId=${requestScope.eClosing.eclosingId }" + "&" + namespace + "staffCode=" + $("#staffCode").val();
			<c:if test="${requestScope.isHasDelegation }">
				setEClosingInfoUrl = setEClosingInfoUrl + "&" + namespace + "eClosingDelegation=" + $("#eClosingDelegation").val();
			</c:if>
			window.location.href = setEClosingInfoUrl;
		}
	});

	<c:if test="${requestScope.isHasDelegation }">
		$("#eClosingDelegation").change(function(){
		$(this).val(this.checked);
			$("#"+namespace+"applicantAgent").val(this.checked);
		});
	</c:if>

	<c:if test="${requestScope.eClosing.applicantAgent }">
		$("#eClosingDelegation").attr("checked", "checked");
	</c:if>
});
</aui:script>

<!-- Page Info -->
<aui:form name="fm1" action="${saveOrUpdateEClosingURL }" method="POST" enctype="multipart/form-data">
<aui:fieldset>
	<aui:input type="hidden" name="action" />
	<aui:input type="hidden" name="eClosingId" value="${requestScope.eClosing.eclosingId }" />
	<aui:input type="hidden" name="employeeGroupId" value="${requestScope.eClosing.employeeGroupId }" />
	<aui:input type="hidden" name="applicantAgent" value="${requestScope.eClosing.applicantAgent }" />
</aui:fieldset>

<!-- Root -->
<div class="mainbody">
	<!-- Top Button  -->
	<div class="topButton">
		<aui:button-row>
			<aui:button value="vgc.apon.e.closing.button.save.as.draft" onClick="${namespace }saveOrUpdateEClosing(0)"/>
			<aui:button value="vgc.apon.e.closing.button.submit"  onClick="${namespace }saveOrUpdateEClosing(1)"/>
			<aui:button value="vgc.apon.e.closing.button.back" onClick="${backURL }" type="cancel"/>
		</aui:button-row>
	</div>
	<!-- E-Closing -->
	<div class="tabTitle">
		<h3><lui:message key="vgc.apon.e.closing" /></h3>
		<div class="Ltext"></div>
		<div class="tickerNo">
			<c:if test="${requestScope.eClosing.ticketNo != '' }">
				<lui:message key="vgc.apon.e.closing.ticket.no" />
				<span class="num">${requestScope.eClosing.ticketNo }</span>
			</c:if>
		</div>
		<div class="clear"></div>
	</div>
	<!-- Employee Information -->
	<div class="gernal">
		<div class="subtitle">
			<lui:message key="vgc.apon.e.closing.employee.information" />
			<c:if test="${requestScope.isHasDelegation }">
				<span style="color: gray; font-size: 12px; padding-left: 122px;">
					<input type="checkbox" id="eClosingDelegation" name="<p:namespace/>eClosingDelegation" value="${requestScope.eClosing.applicantAgent }" />
					<lui:message key="vgc.apon.e.closing.on.behalf.of" />
					<span style="text-decoration: underline;">${requestScope.applicantAgentName }</span>
				</span>
			</c:if>
		</div>
		<ul>
			<li class="md01"><lui:message key="vgc.apon.e.closing.staff.code" /></li>
			<li class="md02">
				<input type="text" id="staffCode" name="<p:namespace/>staffCode" value="${requestScope.eClosing.staffCode == 0 ? '' : requestScope.eClosing.staffCode }" required="required" maxlength="75">
				<a href="javascript:" id="setEClosingInfo"><img src="${themeDisplay.getPathThemeImages()}/common/check.png"></a>
				</li>
			<li class="md01"><lui:message key="vgc.apon.e.closing.staff.name" /></li>
			<li class="md022"><input type="text" id="staffName" name="<p:namespace/>staffName" value="${requestScope.eClosing.staffName }" maxlength="75" readonly="readonly"></li>
		</ul>
		<ul>
			<li class="md01"><lui:message key="vgc.apon.e.closing.company" /></li>
			<li class="md02"><input type="text" id="company" name="<p:namespace/>company" value="${requestScope.eClosing.company }" maxlength="75" readonly="readonly"></li>
			<li class="md01"><lui:message key="vgc.apon.e.closing.division" /></li>
			<li class="md022"><input type="text" id="division" name="<p:namespace/>division" value="${requestScope.eClosing.division }" maxlength="75" readonly="readonly"></li>
		</ul>
		<ul>
			<li class="md01"><lui:message key="vgc.apon.e.closing.department" /></li>
			<li class="md02"><input type="text" id="department" name="<p:namespace/>department" value="${requestScope.eClosing.department }" maxlength="75" readonly="readonly"></li>
			<li class="md01"><lui:message key="vgc.apon.e.closing.cost.center" /></li>
			<li class="md022"><input type="text" id="costCenter" name="<p:namespace/>costCenter" value="${requestScope.eClosing.costCenter }" maxlength="75" readonly="readonly"></li>
		</ul>
		<ul>
			<li class="md01"><lui:message key="vgc.apon.e.closing.position.code" /></li>
			<li class="md02"><input type="text" id="positionCode" name="<p:namespace/>positionCode" value="${requestScope.eClosing.positionCode }" maxlength="75" readonly="readonly"></li>
			<li class="md01"><lui:message key="vgc.apon.e.closing.function.name" /></li>
			<li class="md022"><input type="text" id="functionName" name="<p:namespace/>functionName" value="${requestScope.eClosing.functionName }" maxlength="75" readonly="readonly"></li>
		</ul>
		<ul>
			<li class="md01"><lui:message key="vgc.apon.e.closing.employee.group" /></li>
			<li class="md02" style="width: 330px;"><input type="text" id="employeeGroupName" name="<p:namespace/>employeeGroupName" value="${requestScope.eClosing.employeeGroupName }" maxlength="75" readonly="readonly"></li>
			<li class="md01" style="width: 170px;"><lui:message key="vgc.apon.e.closing.private.email.address" /></li>
			<li class="md022" style="width: 340px;"><input type="text" id="privateEmailAddress" name="<p:namespace/>privateEmailAddress" value="${requestScope.eClosing.privateEmailAddress }" maxlength="75"></li>
		</ul>
		<ul>
			<li class="md01"><lui:message key="vgc.apon.e.closing.starting.date" /></li>
			<li class="md02"><input type="text" id="startingDate" name="<p:namespace/>startingDate" value="<fmt:formatDate value="${requestScope.eClosing.startingDate }" pattern="dd.MM.yyyy"/>" maxlength="75" readonly="readonly"></li>
			<li class="md01"><lui:message key="vgc.apon.e.closing.last.working.day" /></li>
			<li class="md022"><input class="Wdate" type="text" id="lastWorkingDay" name="<p:namespace/>lastWorkingDay" value="<fmt:formatDate value='${requestScope.eClosing.lastWorkingDay }' pattern='dd.MM.yyyy'/>" onFocus="WdatePicker({lang:'en',dateFmt:'dd.MM.yyyy'})" maxlength="75"></li>
		</ul>
		<ul>
			<li class="md01"><lui:message key="vgc.apon.e.closing.finish.contract.date" /></li>
			<li class="md02"><input class="Wdate" type="text" id="finishContractDate" name="<p:namespace/>finishContractDate" value="<fmt:formatDate value='${requestScope.eClosing.finishContractDate }' pattern='dd.MM.yyyy'/>" onFocus="WdatePicker({lang:'en',dateFmt:'dd.MM.yyyy'})" maxlength="75"></li>
			<li class="md01"><lui:message key="vgc.apon.e.closing.seat.office.number" /></li>
			<li class="md022"><input type="text" id="seatOfficeNumber" name="<p:namespace/>seatOfficeNumber" value="${requestScope.eClosing.seatOfficeNumber }" required="required" maxlength="75"></li>
		</ul>
		<ul>
			<li class="md01"><lui:message key="vgc.apon.e.closing.permanent.address" /></li>
			<li class="md02"><input type="text" id="permanentAddress" name="<p:namespace/>permanentAddress" value="${requestScope.eClosing.permanentAddress }" maxlength="75"></li>
		</ul>
	</div>
	<div class="topButton">
		<aui:button-row>
			<aui:button value="vgc.apon.e.closing.button.save.as.draft" onClick="${namespace }saveOrUpdateEClosing(0)"/>
			<aui:button value="vgc.apon.e.closing.button.submit"  onClick="${namespace }saveOrUpdateEClosing(1)"/>
			<aui:button value="vgc.apon.e.closing.button.back" onClick="${backURL }" type="cancel"/>
		</aui:button-row>
	</div>
</div>
</aui:form>

<aui:script>
// Validator
function validatorStrIsNotNull(inputId, labelIndex){
	var inputElement = $("#"+inputId);
	var inputElementValue = $(inputElement).val();
	var parentElement = $(inputElement).closest("ul");
	var labelElement = $(parentElement).children("li").get(labelIndex);
	var labelElementText = $(labelElement).text();
	var showMessages = "<lui:message key='vgc.apon.please.fill.the' />" + " " + labelElementText.substr(0, labelElementText.indexOf('*')) + "!";
	if(inputElementValue == null || inputElementValue == '' || inputElementValue.replace(/\n|\r|\t/g, '') == ''){
		alert(showMessages);
		inputElement.focus();
		return false;
	}else{
		return true;
	}
}
function validatorTime(){
	var startTime=$("#lastWorkingDay").val();
	var tmpStart=startTime.split(".");
	var day = tmpStart[0];
	var year =tmpStart[2];
	var month = tmpStart[1];
	var start=new Date(month+"/"+day+"/"+year);
    var endTime=$("#finishContractDate").val(); 
    var tmpEnd=endTime.split(".");
	var day1 = tmpEnd[0];
	var year1 =tmpEnd[2];
	var month1 =tmpEnd[1];
    var end=new Date(month1+"/"+day1+"/"+year1);
    if(end<start){  
        return false;  
    }else{
		return true;
	}
}
</aui:script>