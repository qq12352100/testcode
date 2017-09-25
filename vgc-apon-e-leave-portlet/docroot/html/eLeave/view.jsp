<%@include file="/html/init.jsp"%>

<%
long token=System.currentTimeMillis();  
portletSession.setAttribute("token",token);

ELeave eLeave = null;

long eLeaveId = ParamUtil.getLong(request, "eLeaveId");
if(eLeaveId==0) {
	eLeaveId = request.getAttribute("eLeaveId")!=null?(Long)request.getAttribute("eLeaveId"):0;
} 
boolean isNew=true;
if (eLeaveId > 0){
	eLeave = ELeaveLocalServiceUtil.fetchELeave(eLeaveId);
	if(eLeave!=null) {
		isNew = false;
	}
	eLeave = eLeave!=null?eLeave:ELeaveLocalServiceUtil.createELeave(eLeaveId);
}
else {
	eLeaveId = CounterLocalServiceUtil.increment(ELeave.class.getName(), 1);
	eLeave = ELeaveLocalServiceUtil.createELeave(eLeaveId);
}
String transitionName = ParamUtil.getString(renderRequest, "transitionName", "");
String isClickAgent = ParamUtil.getString(renderRequest, "isClickAgent","");
long sCode = themeDisplay.getUser().getFacebookId();
Date now = new Date();
System.out.println("----------------scode--------"+sCode);
ApplicantDelegation applicantDelegation = ApplicantDelegationLocalServiceUtil.fetchByP_S(ApproverDelegationLocalServiceUtil.getProcessOfELeave(), String.valueOf(sCode));
boolean isHasAppliantAgent = applicantDelegation!=null && now.after(applicantDelegation.getEffectiveStartDate()) && now.before(applicantDelegation.getEffectiveEndDate())?true:false;
String agentName = applicantDelegation!=null?ApplicantDelegationLocalServiceUtil.getAgentName(applicantDelegation):"";

System.out.println("----------------isHasAppliantAgent--------"+isHasAppliantAgent);
System.out.println("-----------isClickAgent------------"+isClickAgent);
String employeeGroupId="";
SAPUser sapUser=null;
AponSapData aponSapData=null;
long staffCode =0;
if(isNew) {
	staffCode = ParamUtil.getLong(renderRequest, "staffCode", 0);	
	staffCode=staffCode==0?themeDisplay.getUser().getFacebookId():staffCode;
	sapUser = SAPUserLocalServiceUtil.getSapUserByStaffCode(String.valueOf(staffCode));
	aponSapData=AponSapDataLocalServiceUtil.getAponSapUserByStaffCode(String.valueOf(staffCode));
	boolean isApplicantAgent = ParamUtil.getBoolean(renderRequest, "isApplicantAgent",false);
	eLeave.setIsApplicantAgent(isApplicantAgent);
}else{
	boolean isApplicantAgent = ParamUtil.getBoolean(renderRequest, "isApplicantAgent",true);
	System.out.println("-----------isApplicantAgent------------"+isApplicantAgent);
	if(isApplicantAgent!=eLeave.getIsApplicantAgent()&& Validator.isNotNull(isClickAgent)) {	
		staffCode = isApplicantAgent?ParamUtil.getLong(renderRequest, "staffCode", 0):themeDisplay.getUser().getFacebookId();	
		staffCode=staffCode==0?UserLocalServiceUtil.fetchUserById(eLeave.getUserId()).getFacebookId():staffCode;
		sapUser = SAPUserLocalServiceUtil.getSapUserByStaffCode(String.valueOf(staffCode));
		aponSapData=AponSapDataLocalServiceUtil.getAponSapUserByStaffCode(String.valueOf(staffCode));
		eLeave.setIsApplicantAgent(isApplicantAgent);
	}else{
		staffCode=applicantDelegation!=null?UserLocalServiceUtil.fetchUserById(applicantDelegation.getUserId()).getFacebookId():themeDisplay.getUser().getFacebookId();
		sapUser = SAPUserLocalServiceUtil.getSapUserByStaffCode(String.valueOf(staffCode));
		employeeGroupId=sapUser.getEmployeeGroupId();
		sapUser = null;
	}
}


System.out.println("-----------staffCode--1------------"+staffCode);

if(sapUser!=null){
	AponSapData data=AponSapDataLocalServiceUtil.getAponSapUserByStaffCode(sapUser.getStaffCode());
	eLeave.setStaffName(sapUser.getStaffName());
	eLeave.setStaffCode(sapUser.getStaffCode());
	eLeave.setCompany(sapUser.getSapCompanyName());
	eLeave.setDivision(sapUser.getDivisionName());
	eLeave.setDepartment(sapUser.getDepartmentName());
	eLeave.setCostCenter(sapUser.getCostCener());
	if(eLeave.getOfficePhone()==null||eLeave.getOfficePhone().equals("")){
		eLeave.setOfficePhone(sapUser.getContactNo());
	}
	if(eLeave.getMobilePhone()==null||eLeave.getMobilePhone().equals("")){
		eLeave.setMobilePhone(sapUser.getCellPhone());
	}
	if(eLeave.getEmail()==null||eLeave.getEmail().equals("")){
		eLeave.setEmail(sapUser.getEmail());
	}
	employeeGroupId=sapUser.getEmployeeGroupId();
	if(data!=null){
		eLeave.setPositionType(data.getPositionType());
	}
}

PortletURL portletURL = renderResponse.createRenderURL();
Calendar cal = Calendar.getInstance();

int year = cal.get(Calendar.YEAR);
int month = cal.get(Calendar.MONTH);
int day = cal.get(Calendar.DAY_OF_MONTH);

String checkImagePath = themeDisplay.getPathThemeImages()+"/common/check.png";

String prefixUrl = "/web"+themeDisplay.getScopeGroup().getFriendlyURL();	 
String myApplicationsPageUrl = prefixUrl+PropsUtil.get("vgc.apon.my.applications.page.friendly.url");
long myApplicationsPlid = PortalUtil.getPlidFromFriendlyURL(
		themeDisplay.getCompanyId(),myApplicationsPageUrl);

List<FileManagement> fileManagements = FileManagementLocalServiceUtil.getByAssetClassNameAndAssetPrimaryKey(ELeave.class.getName(),eLeaveId);
String supportFileType = PropsUtil.get("vgc.apon.epa.upload.file.type");
String supportFileSize = PropsUtil.get("vgc.apon.epa.upload.file.size");

String disabled="disabled='disabled'";

List<ELeaveInfo> leaveInfos=ELeaveInfoLocalServiceUtil.findLeaveListByELeaveId(eLeaveId);

boolean isUpdateFile=false;
if(leaveInfos!=null&&leaveInfos.size()>0){
	for(ELeaveInfo eLeaveInfo:leaveInfos){
		String typeOfLeaveId=eLeaveInfo.getTypeOfLeaveId();
		if((("0120".equals(typeOfLeaveId)||"0121".equals(typeOfLeaveId)) && Double.valueOf(eLeaveInfo.getAbsenceDays())>=2)||"0140".equals(typeOfLeaveId)||
			"0300".equals(typeOfLeaveId)||"0301".equals(typeOfLeaveId)||"0800".equals(typeOfLeaveId)){
			isUpdateFile=true;
			break;
		}
	}
}

boolean isCheckDateList=ParamUtil.getBoolean(request,"isCheckDateList",true);
%>

<aui:script>
window.onload=function(){
	var isCheckDateList="<%=isCheckDateList%>";
	if(isCheckDateList!=null&&isCheckDateList!=""){
		if("false"==isCheckDateList){
			alert("Error! There is date collision. Please make sure not to request multiple leaves on the same time.");
		}
	}
}

function <portlet:namespace />submitELeave() {
	// Validate
	if(!validateLeaveInfoSize()||!validateFileTypeAndSize(1)){
		return false;
	}
	// Set File Info
	<portlet:namespace />setFileInfo();
	document.<portlet:namespace />fm1.<portlet:namespace /><%= Constants.CMD %>.value = "<%= Constants.PUBLISH %>";
	submitForm(document.<portlet:namespace />fm1);	
}

function <portlet:namespace />saveELeave() {
	// Validate 
	if(!validateLeaveInfoSize()||!validateFileTypeAndSize(1)){
		return false;
	}
	// Set File Info
	<portlet:namespace />setFileInfo();
	document.<portlet:namespace />fm1.<portlet:namespace /><%= Constants.CMD %>.value = "<%= (eLeave == null || eLeave.getELeaveId() == 0 ) ? Constants.ADD : Constants.UPDATE %>";
	submitForm(document.<portlet:namespace />fm1);		
}

function <portlet:namespace />saveELeaveInfo(){
	if(!validateDate()||!validateLeaveInfo()||!validateFileTypeAndSize(2)){
		return false;
	}
	var typeOfLeave=document.getElementById('typeOfLeave');
	var typeOfLeaveTxt=typeOfLeave.options[typeOfLeave.selectedIndex].text;
	if("Others"==typeOfLeaveTxt){
		var remark=document.getElementById("remark").value;
		if(remark==null||remark==''){
			alert("please fill in remark!");
			document.getElementById("remark").focus();
			return false;
		}
	}
	// Set File Info
	<portlet:namespace />setFileInfo();
	<portlet:namespace />setELeaveInfo();
	document.<portlet:namespace />fm1.<portlet:namespace /><%= Constants.CMD %>.value = "<%= Constants.ADD_TEMP %>";
	submitForm(document.<portlet:namespace />fm1);	
}

//validate the field is not null
function validateNotNull(inputId, tdIndex) {
	var portletNamespace = '<portlet:namespace/>';
	var inputElement = document.getElementsByName(portletNamespace + inputId)
			.item(0);
	var trNode = inputElement.parentNode.parentNode;
	var inputLabel = trNode.childNodes[tdIndex].innerHTML;
	inputLabel = inputLabel.substring(0, inputLabel.lastIndexOf('*'));
	var prefix = '<liferay-ui:message key="vgc.apon.please.fill.the" />';
	if (inputElement.value == null || inputElement.value == ''||inputElement.value.replace(/\n|\r|\t/g, '')=='') {
		alert(prefix +" "+ inputLabel.replace(/^\s+|\s+$/g, '')+"!");
		inputElement.focus();
		return false;
	} else {
		return true;
	}
}

//Past the attachmentNames and fileNames values to portlet 
function <portlet:namespace />setFileInfo() {
	var fileManagementFileNames = document.getElementsByName('<portlet:namespace/>fileManagementFileName');
	var fileManagementIds = document.getElementsByName('<portlet:namespace/>fileManagementId');
	var attachmentNames = document.getElementsByName('<portlet:namespace/>attachmentName');
	var existTitles = '';
	for(var i=0;i<fileManagementFileNames.length;i++) {
		var temp = fileManagementFileNames[i].value;
		if(temp==null || temp=='') {
			temp = 'XXX';
		}
		existTitles += temp+',';
	}
	document.<portlet:namespace />fm1.<portlet:namespace />existTitles.value = existTitles;			
	
	var newTitles = '';
	for(var i=0;i<attachmentNames.length;i++) {
		var temp = attachmentNames[i].value;
		if(temp==null || temp=='') {
			temp = 'XXX';
		}
		newTitles += temp+',';
	}
	document.<portlet:namespace />fm1.<portlet:namespace />newTitles.value = newTitles;		
	
	var existFileIds = '';
	for(var i=0;i<fileManagementIds.length;i++) {
		var temp = fileManagementIds[i].value;
		if(temp==null || temp=='') {
			temp = 'XXX';
		}
		existFileIds += temp+',';			
	}
	document.<portlet:namespace />fm1.<portlet:namespace />existFileIds.value = existFileIds;	
}

function <portlet:namespace />setELeaveInfo() {
	var startTime = document.getElementsByName('<portlet:namespace/>startTime');
	var startTimes = '';
	for(var i=0;i<startTime.length;i++) {
		var temp = startTime[i].value;
		if(i==startTime.length-1){
			startTimes += temp;
		}else{
			startTimes += temp+',';
		}
	}
	var endTime = document.getElementsByName('<portlet:namespace/>endTime');
	var endTimes = '';
	for(var i=0;i<endTime.length;i++) {
		var temp = endTime[i].value;
		if(i==endTime.length-1){
			endTimes += temp;
		}else{
			endTimes += temp+',';
		}
	}
	document.<portlet:namespace />fm1.<portlet:namespace />startTimes.value = startTimes;
	document.<portlet:namespace />fm1.<portlet:namespace />endTimes.value = endTimes;
}

//Download the attachments
function <portlet:namespace />download(fileName,filePath) {
	document.<portlet:namespace />downloadFm.<portlet:namespace />fileName.value = fileName;	
	document.<portlet:namespace />downloadFm.<portlet:namespace />filePath.value = filePath;	
	submitForm(document.<portlet:namespace />downloadFm);	
	setTimeout("window.location.reload()",1500); 
}

//Add the file nodes
function <portlet:namespace/>addFile() {    	  
	var fileDiv = document.getElementById('<portlet:namespace/>fileDiv');
	var o1 = document.createTextNode(' ');
	var o2= document.createTextNode(' ');
	var o3= document.createTextNode(' ');
	var o4 = document.createTextNode(' ');
	var o5 = document.createTextNode(' ');
	
	var ul = document.createElement("ul");
	ul.setAttribute("class", "std0");		 
	var li0 = document.createElement("li");
	li0.setAttribute("class", "od01");	
	var input0 = document.createElement("input");
	input0.setAttribute("type", "text");	
	input0.setAttribute("name", "<portlet:namespace/>attachmentName");	
	li0.appendChild(input0);		 
	var li1 = document.createElement("li");
	li1.setAttribute("class", "od02");	
	var input1 = document.createElement("input");
	input1.setAttribute("type", "file");	
	input1.setAttribute("name", "<portlet:namespace/>fileName");	
	 li1.appendChild(input1);		
	 var li2 = document.createElement("li");
	 li2.setAttribute("class", "od01");	
	 var li3 = document.createElement("li");
	 li3.setAttribute("class", "od01 lcol");		 
	 var a0 = document.createElement("a");
	 a0.setAttribute("href", "#");	
	 a0.setAttribute("onclick", "<portlet:namespace/>addFile()");
	 a0.appendChild(document.createTextNode("<liferay-ui:message key='vgc.apon.e.leave.upload' />"));
	 li3.appendChild(a0);
	 li3.appendChild(document.createTextNode("  "));
	 var a1 = document.createElement("a");
	 a1.setAttribute("href", "#");	
	 a1.setAttribute("onclick", "<portlet:namespace/>removeFile(parentNode.parentNode)");
	 a1.appendChild(document.createTextNode("<liferay-ui:message key='vgc.apon.e.leave.delete' />"));
	 li3.appendChild(a1);
	 ul.appendChild(o1);		 
	 ul.appendChild(li0);
	 ul.appendChild(o2);
	 ul.appendChild(li1);
	 ul.appendChild(o3);
	 ul.appendChild(li2);
	 ul.appendChild(o4);
	 ul.appendChild(li3);
	 ul.appendChild(o5);
	fileDiv.appendChild(ul);
	input0.focus();
}

var indexId=1;

function <portlet:namespace/>addELeaveInfo(){
	indexId++;
	var leaveTable = document.getElementById('leaveTable');
	var tr = document.createElement("tr");
	var td1 = document.createElement("td");
	td1.setAttribute("style", "width: 250px;");
	var input1 = document.createElement("input");
	input1.setAttribute("id", "startDate"+indexId);	
	input1.setAttribute("class", "Wdate");	
	input1.setAttribute("type", "text");
	input1.setAttribute("name", "<portlet:namespace/>startDate");
	input1.setAttribute("style", "width: 100%;");
	input1.setAttribute("onFocus", "WdatePicker({lang:'en',dateFmt:'dd.MM.yyyy',maxDate:'#F{$dp.$D(\\'endDate"+indexId+"\\')}',onpicking:function(dp){var startVal=dp.cal.getNewDateStr();var endVal=document.getElementById('endDate"+indexId+"').value;if(endVal!=null&&endVal!=''){if(startVal!=endVal){document.getElementById('startTime"+indexId+"').value='08:30';document.getElementById('endTime"+indexId+"').value='17:30';document.getElementById('startTime"+indexId+"').disabled=true;document.getElementById('endTime"+indexId+"').disabled=true;}else{var typeOfLeave=document.getElementById('typeOfLeave');var typeOfLeaveTxt=typeOfLeave.options[typeOfLeave.selectedIndex].text;if('Maternity Leave'!=typeOfLeaveTxt&&'Maternity Leave (GE)'!=typeOfLeaveTxt&&'Paternity Leave'!=typeOfLeaveTxt&&'Service Award Leave'!=typeOfLeaveTxt){document.getElementById('startTime"+indexId+"').disabled=false;document.getElementById('endTime"+indexId+"').disabled=false;}}}}})");
	var td2 = document.createElement("td");
	td2.setAttribute("style", "width: 250px;");
	var input2 = document.createElement("input");
	input2.setAttribute("id", "endDate"+indexId);
	input2.setAttribute("class", "Wdate");	
	input2.setAttribute("type", "text");
	input2.setAttribute("name", "<portlet:namespace/>endDate");
	input2.setAttribute("style", "width: 100%;");
	input2.setAttribute("onFocus", "WdatePicker({lang:'en',dateFmt:'dd.MM.yyyy',minDate:'#F{$dp.$D(\\'startDate"+indexId+"\\')}',onpicking:function(dp){var endVal=dp.cal.getNewDateStr();var startVal=document.getElementById('startDate"+indexId+"').value;if(startVal!=null&&startVal!=''){if(startVal!=endVal){document.getElementById('startTime"+indexId+"').value='08:30';document.getElementById('endTime"+indexId+"').value='17:30';document.getElementById('startTime"+indexId+"').disabled=true;document.getElementById('endTime"+indexId+"').disabled=true;}else{var typeOfLeave=document.getElementById('typeOfLeave');var typeOfLeaveTxt=typeOfLeave.options[typeOfLeave.selectedIndex].text;if('Maternity Leave'!=typeOfLeaveTxt&&'Maternity Leave (GE)'!=typeOfLeaveTxt&&'Paternity Leave'!=typeOfLeaveTxt&&'Service Award Leave'!=typeOfLeaveTxt){document.getElementById('startTime"+indexId+"').disabled=false;document.getElementById('endTime"+indexId+"').disabled=false;}}}}})");
	var input3 = document.createElement("input");
	input3.setAttribute("type", "hidden");
	input3.setAttribute("id", "leaveDays"+indexId);
	input3.setAttribute("name", "<portlet:namespace/>leaveDays");
	var td3 = document.createElement("td");
	var select1 = document.createElement("select");
	select1.setAttribute("style", "width: 100%;");
	select1.setAttribute("id", "startTime"+indexId);
	select1.setAttribute("name", "<portlet:namespace/>startTime");	
	select1.setAttribute("onchange", "changeTime(this.value,"+indexId+")");	
	var option1 = document.createElement("option");
	option1.setAttribute("value", "08:30");	
	option1.appendChild(document.createTextNode("08:30"));
	var option2 = document.createElement("option");
	option2.setAttribute("value", "13:30");	
	option2.appendChild(document.createTextNode("13:30"));
	select1.appendChild(option1);
	select1.appendChild(option2);
	var td4 = document.createElement("td");
	var select2 = document.createElement("select");
	select2.setAttribute("style", "width: 100%;");	
	select2.setAttribute("id", "endTime"+indexId);
	select2.setAttribute("name", "<portlet:namespace/>endTime");	
	var option3 = document.createElement("option");
	option3.setAttribute("value", "13:30");	
	option3.appendChild(document.createTextNode("13:30"));
	var option4 = document.createElement("option");
	option4.setAttribute("value", "17:30");	
	option4.appendChild(document.createTextNode("17:30"));
	select2.appendChild(option3);
	select2.appendChild(option4);
	var td5 = document.createElement("td");
	td5.setAttribute("style", "text-align: center;");
	var a1 = document.createElement("a");
	a1.setAttribute("href", "#");
	a1.setAttribute("onclick", "<portlet:namespace/>removeTd(parentNode.parentNode)");
	a1.appendChild(document.createTextNode("<liferay-ui:message key='vgc.apon.e.leave.delete'/>"));	
	td1.appendChild(input3);
	td1.appendChild(input1);
	td2.appendChild(input2);
	td3.appendChild(select1);
	td4.appendChild(select2);
	td5.appendChild(a1);
	tr.appendChild(td1);
	tr.appendChild(td2);
	tr.appendChild(td3);
	tr.appendChild(td4);
	tr.appendChild(td5);
	leaveTable.appendChild(tr);
	var typeOfLeave=document.getElementById('typeOfLeave');
	var typeOfLeaveTxt=typeOfLeave.options[typeOfLeave.selectedIndex].text;
	if("Marriage Leave"==typeOfLeaveTxt||"Maternity Leave"==typeOfLeaveTxt||"Maternity Leave (GE)"==typeOfLeaveTxt||"Paternity Leave"==typeOfLeaveTxt||"Service Award Leave"==typeOfLeaveTxt){
		var len=document.getElementsByTagName("table")[0].getElementsByTagName("select").length;
		for(var i=(indexId-1);i<len;i++){
			if(i==0){
				document.getElementsByTagName("table")[0].getElementsByTagName("select")[i].value="08:30";
			}else if(i==1){
				document.getElementsByTagName("table")[0].getElementsByTagName("select")[i].value="17:30";
			}
			document.getElementsByTagName("table")[0].getElementsByTagName("select")[i].disabled=true;
		}
		document.getElementById('addELeaveInfoButton').disabled=true;
	}else{
		document.getElementById('startTime'+indexId).disabled=false;
		document.getElementById('endTime'+indexId).disabled=false;
		document.getElementById('addELeaveInfoButton').disabled=false;
	}
}

function <portlet:namespace/>removeTd(obj) {
	  var leaveTable = obj.parentNode;  
	  var count = leaveTable.childElementCount;
	  var ps = '<portlet:namespace/>';
	  if(count==1 && leaveTable.id==ps+'leaveTable') {
		  alert("This node can't delete.If you want to delete this node,please click add first, then you can delete it !");
		  return false;
	  }
	  leaveTable.removeChild(obj);   
	  leaveTable.focus();
}

function <portlet:namespace/>removeInfoTd(id,obj) {
	  var leaveInfoTable = obj.parentNode;  
	  var count = leaveInfoTable.childElementCount;
	  var ps = '<portlet:namespace/>';
	  if(count==1 && leaveInfoTable.id==ps+'leaveInfoTable') {
		  alert("This node can't delete.If you want to delete this node,please click add first, then you can delete it !");
		  return false;
	  }
	  leaveInfoTable.removeChild(obj);   
	  leaveInfoTable.focus();
	  <portlet:namespace />setFileInfo();
	  document.<portlet:namespace />fm1.<portlet:namespace /><%= Constants.CMD %>.value = "<%=Constants.DELETE_TEMP%>";
	  document.<portlet:namespace />fm1.<portlet:namespace />eLeaveInfoId.value =id;
	  submitForm(document.<portlet:namespace />fm1);
}

//Remove the file nodes
function <portlet:namespace/>removeFile(obj) {
	  var fileDiv = obj.parentNode;  
	  var count = fileDiv.childElementCount;
	  var ps = '<portlet:namespace/>';
	  if(count==1 && fileDiv.id==ps+'fileDiv') {
		  alert("This node can't delete.If you want to delete this node,please click add first, then you can delete it !");
		  return false;
	  }
	  fileDiv.removeChild(obj);   
}

//Validate the file type and size is right
function validateFileTypeAndSize(type) {
	var fileNames = document.getElementsByName('<portlet:namespace/>fileName');
	var supportFileType = '<%=supportFileType%>';
	var supportFileSize = '<%=supportFileSize%>';
	var flag = true;
	//get the browser type
	var  browserCfg = {};  
    var ua = window.navigator.userAgent;  
    if (ua.indexOf("MSIE")>=1){  
        browserCfg.ie = true;  
    }else if(ua.indexOf("Firefox")>=1){  
        browserCfg.firefox = true;  
    }else if(ua.indexOf("Chrome")>=1){  
        browserCfg.chrome = true;  
    }  
    
    var isFileNull=true;
	for(var i=0;i<fileNames.length;i++) {
		var obj_file = fileNames[i];
		var fileName = obj_file.value;
		if(fileName!=null && fileName !=""){
			var validateFileName;
			var index = fileName.lastIndexOf("\\");
			if(index>0){
				validateFileName = fileName.substring(index+1, fileName.lastIndexOf("."));
			}else{
			    validateFileName = fileName.substring(0, fileName.lastIndexOf("."));
			}
			if(!illegalChar(validateFileName)){
				return false;
			}
			//var fileType = (fileName.substring(fileName.lastIndexOf(".")+1,fileName.length)).toLowerCase();
			//if(supportFileType.indexOf(fileType, 0)==-1) {
			//	alert('Only support the '+supportFileType+' attachments!');
			//	flag = false;
			//	break;
			//}
			var filesize = 0;
			if(browserCfg.firefox || browserCfg.chrome ){  
                filesize = obj_file.files[0].size;  
            }else if(browserCfg.ie){  
            	//ie
            }
			if(filesize>1024*1024*supportFileSize) {
				alert('The Max attachments size is '+supportFileSize +'Mb!');
				flag = false;
				break;
			}
			isFileNull=false;
		}
	}
	
	var fileManagementIdlength=document.getElementsByName("<portlet:namespace/>fileManagementId").length;
	
	if(isFileNull&&fileManagementIdlength==0){
		var isUpdateFile="<%=isUpdateFile%>";
		if("true"==isUpdateFile&&type==1){
			alert("Please upload the necessary attachments!");
			flag = false;
		}else{
			var typeOfLeave=document.getElementById('typeOfLeave');
			var totalNum=0;
			var totalDuration=document.getElementById('totalDuration').value;
			if(totalDuration!=null&&totalDuration!=""){
				totalNum=parseFloat(totalDuration);
			}
			var typeOfLeaveTxt=typeOfLeave.options[typeOfLeave.selectedIndex].text;
			if(("Sick Leave"==typeOfLeaveTxt||"Sick Leave (GE)"==typeOfLeaveTxt)&&totalNum>=2){
				alert("Please upload your Medial Certificate for this application.");
				flag = false;
			}else if("Marriage Leave"==typeOfLeaveTxt){
				alert("Please upload your Marriage Certificate scan for this application.");
				flag = false;
			}else if("Maternity Leave"==typeOfLeaveTxt||"Maternity Leave (GE)"==typeOfLeaveTxt){
				alert("Please upload your Medical Certificate scan for this application.");
				flag = false;
			}else if("Medical Treatment Period"==typeOfLeaveTxt){
				alert("Please upload your Medical Certificate scan for this application.");
				flag = false;
			}
		}
	}
	return flag;
}

//format validation	
function illegalChar(validateFileName){
		 var flag=true;
		 var reg=/[`~!@#\$%\^\&\*\(\)\+=<>,\?:"\{\}\\\|\/;'\[\]]/im;
		 var chineseCRT=/[\u4E00-\u9FA5\uF900-\uFA2D]/;
		 if(reg.test(validateFileName)||chineseCRT.test(validateFileName)){
			 flag=false;
			 alert("Please check your file name: "+validateFileName+", only include number, character,'.','space','-' and '_' ");
		 }
		 return flag;
	   }
	   
function validateLeaveInfoSize() {
	var flag = true;
	var size="<%=leaveInfos.size()%>";
	if("0"==size){
		alert("Please fill in leave info!");
		flag = false;
	}
	return flag;
}

function validateLeaveInfo() {
	var flag = true;
	var typeOfLeave=document.getElementById('typeOfLeave');
	var typeOfLeaveTxt=typeOfLeave.options[typeOfLeave.selectedIndex].text;
	if("Home office-Case group1"!=typeOfLeaveTxt&&"Home office-Case group2"!=typeOfLeaveTxt&&
		"Home office-Case group3"!=typeOfLeaveTxt&&"Home office-Case group4"!=typeOfLeaveTxt){
		var isCheckELeaveInfo=document.getElementById('isCheckELeaveInfo').value;
		var checkELeaveInfoMsg=document.getElementById('checkELeaveInfoMsg').value;
		if("false"==isCheckELeaveInfo){
			if(checkELeaveInfoMsg!=null&&checkELeaveInfoMsg!=""){
				alert(checkELeaveInfoMsg);
			}else{
				alert("Check the leave information failed, Please check the input information for leave is correct!");
			}
			flag = false;
		}	
	}
	return flag;
}

function validateDate(){
	var flag = true;
	var startDate=document.getElementsByName("<portlet:namespace/>startDate");
	for(var i=0;i<startDate.length;i++){
		var startDateVal=startDate.item(i).value;
		if(startDateVal==null||startDateVal==""){
			flag=false;
			alert("Please fill in the start date!");
			startDate.item(i).focus();
			break;
		}
	}
	if(flag){
		var endDate=document.getElementsByName("<portlet:namespace/>endDate");
		for(var i=0;i<endDate.length;i++){
			var endDateVal=endDate.item(i).value;
			if(endDateVal==null||endDateVal==""){
				flag=false;
				alert("Please fill in the end date!");
				endDate.item(i).focus();
				break;
			}
		}
	}
	return flag;
}

function initTable(text){
	if("Marriage Leave"==text||"Maternity Leave"==text||"Maternity Leave (GE)"==text||"Paternity Leave"==text||"Service Award Leave"==text){
		var len=document.getElementsByTagName("table")[0].getElementsByTagName("select").length;
		for(var i=0;i<len;i++){
			if(i==0){
				document.getElementsByTagName("table")[0].getElementsByTagName("select")[i].value="08:30";
			}else if(1==1){
				document.getElementsByTagName("table")[0].getElementsByTagName("select")[i].value="17:30";
			}
			document.getElementsByTagName("table")[0].getElementsByTagName("select")[i].disabled=true;
		}	
		document.getElementById('addELeaveInfoButton').disabled=true;
	}else{
		if("Others"==text){
			alert("Others, please specify the reason in remark box.");
			document.getElementById('remark').focus();
		}
		var len=document.getElementsByTagName("table")[0].getElementsByTagName("select").length;
		for(var i=0;i<len;i++){
			var startDateElement=document.getElementById('startDate'+(i+1));
			var startDate=startDateElement!=null?startDateElement.value:"";
			var endDateElement=document.getElementById('endDate'+(i+1));
			var endDate=endDateElement!=null?endDateElement.value:"";
			var startTimeElement=document.getElementById('startTime'+(i+1));
			var startTime=startTimeElement!=null?startTimeElement.value:"";
			if(startDate==endDate&&startDate!=""&&endDate!=""&&startTime!=""){
				document.getElementById('startTime'+(i+1)).disabled=false;
				if("13:30"!=startTime){
					document.getElementById('endTime'+(i+1)).disabled=false;
				}
			}
		}
		document.getElementById('addELeaveInfoButton').disabled=false;
	}
	if("Annual Leave"!=text&&"Sick Leave"!=text&&"Sick Leave (GE)"!=text&&"Service Award Leave"!=text){
		document.getElementById('remainingLeaveDaysBefore').value="";
		document.getElementById('remainingLeaveDaysAfter').value="";
	}
	document.getElementById('isCheckELeaveInfo').value="false";
	document.getElementById('checkELeaveInfoMsg').value="";

	if("Home office-Case group1"==text||"Home office-Case group2"==text||
			"Home office-Case group3"==text||"Home office-Case group4"==text){
		document.getElementById('totalLeaveEntitlement').value="";	
		document.getElementById('totalDuration').value="";
		document.getElementById('remainingLeaveDaysBefore').value="";
		document.getElementById('remainingLeaveDaysAfter').value="";
		document.getElementById("remark").value="";
		var leaveDays=document.getElementsByName("<portlet:namespace/>leaveDays");
		for(i=0;i<leaveDays.length;i++){
			leaveDays[i].value="";
		}		
	}
}

function changeTime(val,indexId){
	if("13:30"==val){
		document.getElementById('endTime'+indexId).value="17:30";
		document.getElementById('endTime'+indexId).disabled=true;
	}else{
		document.getElementById('endTime'+indexId).disabled=false;
	}
}
//When the employee is on behalf of the applicant,display the query button
function <portlet:namespace />applicantAgentClick(obj) {
	document.<portlet:namespace />applicantAgentForm.<portlet:namespace />isApplicantAgent.value = obj.checked;
	submitForm(document.<portlet:namespace />applicantAgentForm);
}
</aui:script>
	
<portlet:actionURL name="applicantAgent" var="applicantAgentURL" >
<portlet:param name="<%=Constants.CMD%>" value="applicantAgent"/>
</portlet:actionURL>

<aui:form action="<%=applicantAgentURL%>" method="post" name="applicantAgentForm">
<aui:fieldset>
	<aui:input type="hidden" name="eLeaveId" value="<%=eLeaveId%>" />
	<aui:input name="isApplicantAgent" type="hidden" />
</aui:fieldset>
</aui:form>

<portlet:resourceURL var="ajaxURL"></portlet:resourceURL>

<portlet:actionURL var="addELeaveURL" windowState="normal" />

<liferay-portlet:renderURL var="myApplicationsURL"
	plid="<%=myApplicationsPlid%>"
	portletName='<%=PropsUtil.get("vgc.apon.my.applications.portletId")%>'
	windowState="normal">
</liferay-portlet:renderURL>

<aui:form method="post" name="fm1" action="<%=addELeaveURL%>"
	style="height:auto;width:auto;" enctype="multipart/form-data">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="<%=redirect%>" />
		<aui:input type="hidden" name="<%=Constants.CMD%>" />
		<aui:input type="hidden" name="eLeaveId" value="<%=eLeaveId%>" />
		<aui:input type="hidden" name="transitionName"
			value='<%=transitionName%>' />
		<aui:input type="hidden" name="token" value='<%=token%>' />
		<aui:input type="hidden" name="existTitles" />
		<aui:input type="hidden" name="newTitles" />
		<aui:input type="hidden" name="existFileIds" />
		<aui:input type="hidden" name="startTimes" />
		<aui:input type="hidden" name="endTimes" />
		<aui:input type="hidden" name="eLeaveInfoId" />
	</aui:fieldset>

	<div class="mainbody">
		<div class="topButton">
			<aui:button-row>
				<aui:button value="vgc.apon.button.save.as.draft"
					onClick='<%= renderResponse.getNamespace() + "saveELeave()" %>' />
				<aui:button value="vgc.apon.button.submit"
					onClick='<%= renderResponse.getNamespace() + "submitELeave()" %>' />
				<aui:button type="cancel" value="vgc.apon.button.back"
					onClick='<%= myApplicationsURL %>' />
			</aui:button-row>
		</div>
		<div class="tabTitle">
			<h3>
				<liferay-ui:message key="vgc.apon.e.leave" />
			</h3>
			<div class="Ltext"></div>
			<div class="tickerNo">
				<liferay-ui:message key="vgc.apon.e.leave.ticket.no" />
				<span class="num"><%=eLeave.getTicketNo()%></span>
			</div>
			<div class="clear"></div>
		</div>
		<div class="gernal">
			<div class="subtitle">
				<liferay-ui:message key="vgc.apon.e.leave.employee.information" />
				<%if(isHasAppliantAgent){%>
					<input type="checkbox" name="<portlet:namespace/>isApplicantAgent" value='<%=true %>' 
					<%=eLeave.getIsApplicantAgent()?"checked='checked'":"" %> 
					onclick='<%=renderResponse.getNamespace() + "applicantAgentClick(this)"%>'/>
					<liferay-ui:message key="vgc-apon-on-behalf-of-x" arguments="<%=agentName %>"/>
				<%}%>
			</div>
			<ul>
				<li class="md01"><liferay-ui:message
						key="vgc.apon.e.leave.staff.name"></liferay-ui:message></li>
				<li class="md02"><input type="text" id="staffName"
					name="<portlet:namespace/>staffName"
					value="<%=eLeave.getStaffName()%>" maxlength="75"
					readonly="readonly"></li>
				<li class="md01"><liferay-ui:message
						key="vgc.apon.e.leave.staff.code"></liferay-ui:message></li>
				<li class="md022"><input type="text" id="staffCode"
					name="<portlet:namespace/>staffCode"
					value="<%=eLeave.getStaffCode()%>" maxlength="75"
					readonly="readonly"></li>
			</ul>
			<ul>
				<li class="md01"><liferay-ui:message
						key="vgc.apon.e.leave.company"></liferay-ui:message></li>
				<li class="md02"><input type="text" id="company"
					name="<portlet:namespace/>company" value="<%=eLeave.getCompany()%>"
					maxlength="75" readonly="readonly"></li>
				<li class="md01"><liferay-ui:message
						key="vgc.apon.e.leave.division"></liferay-ui:message></li>
				<li class="md022"><input type="text" id="division"
					name="<portlet:namespace/>division"
					value="<%=eLeave.getDivision()%>" maxlength="75"
					readonly="readonly"></li>
			</ul>
			<ul>
				<li class="md01"><liferay-ui:message
						key="vgc.apon.e.leave.department"></liferay-ui:message></li>
				<li class="md02"><input type="text" id="department"
					name="<portlet:namespace/>department"
					value="<%=eLeave.getDepartment()%>" maxlength="75"
					readonly="readonly"></li>
				<li class="md01"><liferay-ui:message
						key="vgc.apon.e.leave.cost.center"></liferay-ui:message></li>
				<li class="md022"><input type="text" id="costCenter"
					name="<portlet:namespace/>costCenter"
					value="<%=eLeave.getCostCenter()%>" maxlength="75"
					readonly="readonly"></li>
			</ul>
			<ul>
				<li class="md01"><liferay-ui:message
						key="vgc.apon.e.leave.office.phone"></liferay-ui:message></li>
				<li class="md02"><input type="text" id="officePhone"
					name="<portlet:namespace/>officePhone"
					value="<%=eLeave.getOfficePhone()%>" maxlength="75"></li>
				<li class="md01"><liferay-ui:message
						key="vgc.apon.e.leave.mobile.phone"></liferay-ui:message></li>
				<li class="md022"><input type="text" id="mobilePhone"
					name="<portlet:namespace/>mobilePhone"
					value="<%=eLeave.getMobilePhone()%>" maxlength="75"></li>
			</ul>
			<ul>
				<li class="md01"><liferay-ui:message
						key="vgc.apon.e.leave.email"></liferay-ui:message></li>
				<li class="md02"><input type="text" id="email"
					name="<portlet:namespace/>email" value="<%=eLeave.getEmail()%>"
					maxlength="75"></li>
				<!--<li class="md01"><liferay-ui:message key="vgc.apon.e.leave.position.type"></liferay-ui:message></li>
			<li class="md022">
				<input type="text" id="positionType" name="<portlet:namespace/>positionType" value="<%=eLeave.getPositionType()%>" maxlength="75" readonly="readonly">
			</li>-->
			</ul>
		</div>
		<div class="gernal">
			<div class="subtitle">
				<liferay-ui:message key="vgc.apon.e.leave.leave.information" />
				<input type="hidden" id="isCheckELeaveInfo"
					name="<portlet:namespace/>isCheckELeaveInfo" value="false">
				<input type="hidden" id="checkELeaveInfoMsg"
					name="<portlet:namespace/>checkELeaveInfoMsg" value="">
				<aui:button value="vgc.apon.e.leave.save" style="float: right;"
					onClick='<%= renderResponse.getNamespace() + "saveELeaveInfo()" %>' />
				&nbsp;
				<aui:button value="vgc.apon.e.leave.check.leave.data"
					style="float: right;margin-right: 10px;" id="checkELeaveInfo" />
			</div>
			<ul>
				<li class="md01"><liferay-ui:message
						key="vgc.apon.e.leave.type.of.leave" /></li>
				<li class="md02"><select id="typeOfLeave"
					name="<portlet:namespace/>typeOfLeave"
					onchange="initTable(this.options[this.selectedIndex].text)">
						<%
							for (String typeOfLeave : PortletPropsValues.TYPE_OF_LEAVE) {
								String typeOfLeaveTxt=LanguageUtil.get(pageContext, typeOfLeave);
								if("7".equals(employeeGroupId)){
									if(!"Study Leave".equals(typeOfLeaveTxt)){
										continue;
									}
								}
								if("4".equals(employeeGroupId)||"6".equals(employeeGroupId)){
									if("Sick Leave".equals(typeOfLeaveTxt)||"Maternity Leave".equals(typeOfLeaveTxt)){
										continue;
									}
								}else if(!"4".equals(employeeGroupId)&&!"6".equals(employeeGroupId)){
									if("Sick Leave (GE)".equals(typeOfLeaveTxt)||"Maternity Leave (GE)".equals(typeOfLeaveTxt)){
										continue;
									}
								}
						%>
						<option value="<%=typeOfLeave%>">
							<%=typeOfLeaveTxt%>
						</option>
						<%
							}
						%>
				</select></li>
				<li class="md01"></li>
				<li class="md022"></li>
			</ul>
			<ul>
				<li class="md01" style="width: 21%;"><liferay-ui:message
						key="vgc.apon.e.leave.please.input.the.leave.duration" /></li>
				<li class="md03" style="width: 77%;"><aui:button id="addELeaveInfoButton" 
						value="vgc.apon.e.leave.upload" style="float: right;"
						onClick='<%= renderResponse.getNamespace() + "addELeaveInfo()" %>' />
				</li>
			</ul>
			<ul>
				<li class="md03"
					style="width: 100%; height: auto; overflow: hidden;">
					<table id="leaveTable" border='1' style='border-collapse: collapse'>
						<tr>
							<td
								style="text-align: center; font-size: 15px; font-weight: 600; background-color: rgb(242, 242, 242);">
								<liferay-ui:message key="vgc.apon.e.leave.start.date" />
							</td>
							<td
								style="text-align: center; font-size: 15px; font-weight: 600; background-color: rgb(242, 242, 242);">
								<liferay-ui:message key="vgc.apon.e.leave.end.date" />
							</td>
							<td
								style="text-align: center; font-size: 15px; font-weight: 600; background-color: rgb(242, 242, 242);">
								<liferay-ui:message key="vgc.apon.e.leave.start.time" />
							</td>
							<td
								style="text-align: center; font-size: 15px; font-weight: 600; background-color: rgb(242, 242, 242);">
								<liferay-ui:message key="vgc.apon.e.leave.end.time" />
							</td>
							<td
								style="text-align: center; font-size: 15px; font-weight: 600; background-color: rgb(242, 242, 242);">
								<liferay-ui:message key="vgc.apon.e.leave.action" />
							</td>
						</tr>
						<tr>
							<td style="width: 250px;"><input type="hidden"
								id="leaveDays1" name="<portlet:namespace/>leaveDays" value="">
								<input class="Wdate" id="startDate1" type="text"
								name="<portlet:namespace/>startDate" value=""
								style="width: 100%;"
								onFocus="WdatePicker({lang:'en',dateFmt:'dd.MM.yyyy',maxDate:'#F{$dp.$D(\'endDate1\')}',onpicking:function(dp){var startVal=dp.cal.getNewDateStr();var endVal=document.getElementById('endDate1').value;if(endVal!=null&&endVal!=''){if(startVal!=endVal){document.getElementById('startTime1').value='08:30';document.getElementById('endTime1').value='17:30';document.getElementById('startTime1').disabled=true;document.getElementById('endTime1').disabled=true;}else{var typeOfLeave=document.getElementById('typeOfLeave');var typeOfLeaveTxt=typeOfLeave.options[typeOfLeave.selectedIndex].text;if('Maternity Leave'!=typeOfLeaveTxt&&'Maternity Leave (GE)'!=typeOfLeaveTxt&&'Paternity Leave'!=typeOfLeaveTxt&&'Service Award Leave'!=typeOfLeaveTxt){document.getElementById('startTime1').disabled=false;document.getElementById('endTime1').disabled=false;}}}}})" />
							</td>
							<td style="width: 250px;"><input class="Wdate" id="endDate1"
								type="text" name="<portlet:namespace/>endDate" value=""
								style="width: 100%;"
								onFocus="WdatePicker({lang:'en',dateFmt:'dd.MM.yyyy',minDate:'#F{$dp.$D(\'startDate1\')}',onpicking:function(dp){var endVal=dp.cal.getNewDateStr();var startVal=document.getElementById('startDate1').value;if(startVal!=null&&startVal!=''){if(startVal!=endVal){document.getElementById('startTime1').value='08:30';document.getElementById('endTime1').value='17:30';document.getElementById('startTime1').disabled=true;document.getElementById('endTime1').disabled=true;}else{var typeOfLeave=document.getElementById('typeOfLeave');var typeOfLeaveTxt=typeOfLeave.options[typeOfLeave.selectedIndex].text;if('Maternity Leave'!=typeOfLeaveTxt&&'Maternity Leave (GE)'!=typeOfLeaveTxt&&'Paternity Leave'!=typeOfLeaveTxt&&'Service Award Leave'!=typeOfLeaveTxt){document.getElementById('startTime1').disabled=false;document.getElementById('endTime1').disabled=false;}}}}})" />
							</td>
							<td><select id="startTime1"
								name="<portlet:namespace/>startTime" style="width: 100%;"
								onchange="changeTime(this.value,1)">
									<option value="08:30">08:30</option>
									<option value="13:30">13:30</option>
							</select></td>
							<td><select id="endTime1" name="<portlet:namespace/>endTime"
								style="width: 100%;">
									<option value="13:30">13:30</option>
									<option value="17:30">17:30</option>
							</select></td>
							<td style="text-align: center;"><a href="#"
								onclick="<portlet:namespace/>removeTd(parentNode.parentNode)"><liferay-ui:message
										key="vgc.apon.e.leave.delete" /></a></td>
						</tr>
					</table>
				</li>
			</ul>
			<ul>
				<li class="md01">&nbsp;</li>
				<li class="md02">&nbsp;</li>
				<li class="md01">&nbsp;</li>
				<li class="md022">&nbsp;</li>
			</ul>
			<ul>
				<li class="md01"><liferay-ui:message
						key="vgc.apon.e.leave.total.leave.entitlement"></liferay-ui:message></li>
				<li class="md02"><input type="text" id="totalLeaveEntitlement"
					name="<portlet:namespace/>totalLeaveEntitlement" value=""
					maxlength="75" readonly="readonly">&nbsp;<liferay-ui:message
						key="vgc.apon.e.leave.days"></liferay-ui:message></li>
				<li class="md01"><liferay-ui:message
						key="vgc.apon.e.leave.total.duration"></liferay-ui:message></li>
				<li class="md022"><input type="text" id="totalDuration"
					name="<portlet:namespace/>totalDuration" value="" maxlength="75"
					readonly="readonly">&nbsp;<liferay-ui:message
						key="vgc.apon.e.leave.days"></liferay-ui:message></li>
			</ul>
			<ul>
				<li class="md01"><liferay-ui:message
						key="vgc.apon.e.leave.remaining.leave.days.before"></liferay-ui:message></li>
				<li class="md02"><input type="text"
					id="remainingLeaveDaysBefore"
					name="<portlet:namespace/>remainingLeaveDaysBefore" value=""
					maxlength="75" readonly="readonly">&nbsp;<liferay-ui:message
						key="vgc.apon.e.leave.days"></liferay-ui:message></li>
				<li class="md01"><liferay-ui:message
						key="vgc.apon.e.leave.remaining.leave.days.after"></liferay-ui:message></li>
				<li class="md022"><input type="text"
					id="remainingLeaveDaysAfter"
					name="<portlet:namespace/>remainingLeaveDaysAfter" value=""
					maxlength="75" readonly="readonly">&nbsp;<liferay-ui:message
						key="vgc.apon.e.leave.days"></liferay-ui:message></li>
			</ul>
			<ul class="txt3">
				<li class="md01"><liferay-ui:message
						key="vgc.apon.e.leave.remark" /></li>
				<li class="md03"><textarea style="height: 100px;" id="remark"
						name="<portlet:namespace/>remark" maxlength="200"></textarea></li>
			</ul>
		</div>
		<%
			if(leaveInfos!=null&&leaveInfos.size()>0){
		%>
		<table id="leaveInfoTable" border='1'
			style='border-collapse: collapse; table-layout: fixed; width: 100%;'>
			<tr>
				<td
					style="text-align: center; font-size: 15px; font-weight: 600; background-color: rgb(242, 242, 242); width: 15%;">
					<liferay-ui:message key="vgc.apon.e.leave.type.of.leave2" />
				</td>
				<td
					style="text-align: center; font-size: 15px; font-weight: 600; background-color: rgb(242, 242, 242); width: 10%;">
					<liferay-ui:message key="vgc.apon.e.leave.start.date" />
				</td>
				<td
					style="text-align: center; font-size: 15px; font-weight: 600; background-color: rgb(242, 242, 242); width: 10%;">
					<liferay-ui:message key="vgc.apon.e.leave.end.date" />
				</td>
				<td
					style="text-align: center; font-size: 15px; font-weight: 600; background-color: rgb(242, 242, 242); width: 10%;">
					<liferay-ui:message key="vgc.apon.e.leave.start.time" />
				</td>
				<td
					style="text-align: center; font-size: 15px; font-weight: 600; background-color: rgb(242, 242, 242); width: 10%;">
					<liferay-ui:message key="vgc.apon.e.leave.end.time" />
				</td>
				<td
					style="text-align: center; font-size: 15px; font-weight: 600; background-color: rgb(242, 242, 242); width: 10%;">
					<liferay-ui:message key="vgc.apon.e.leave.absence.days" />
				</td>
				<td
					style="text-align: center; font-size: 15px; font-weight: 600; background-color: rgb(242, 242, 242); width: 30%;">
					<liferay-ui:message key="vgc.apon.e.leave.remark2" />
				</td>
				<td
					style="text-align: center; font-size: 15px; font-weight: 600; background-color: rgb(242, 242, 242); width: 5%;">
					<liferay-ui:message key="vgc.apon.e.leave.action" />
				</td>
			</tr>
			<%
				for(ELeaveInfo leaveInfo:leaveInfos){
			%>
			<tr>
				<td><%=LanguageUtil.get(pageContext, leaveInfo.getTypeOfLeave())%>
				</td>
				<td><%=sdf_dmy.format(leaveInfo.getStartDate())%></td>
				<td><%=sdf_dmy.format(leaveInfo.getEndDate())%></td>
				<td><%=leaveInfo.getStartTime()%></td>
				<td><%=leaveInfo.getEndTime()%></td>
				<td><%=leaveInfo.getAbsenceDays()%></td>
				<td style="word-wrap: break-word;"><%=leaveInfo.getRemark()%></td>
				<td style="text-align: center;"><a href="#"
					onclick="<portlet:namespace/>removeInfoTd(<%=leaveInfo.getELeaveInfoId()%>,parentNode.parentNode)"><liferay-ui:message
							key="vgc.apon.e.leave.delete" /></a></td>
			</tr>
			<%
				}
			%>
		</table>
		<%
			}
		%>
		<br />
		<div class="attachmentList">
			<div class="subtitle">Attachment list</div>
			<div class="gridtb">
				<ul>
					<li class="od01">Attachment Name</li>
					<li class="od02">File Name</li>
					<li class="od01">Upload Date</li>
					<li class="od01 lcol">Action</li>
				</ul>
				<div id="<portlet:namespace/>fileDiv0">
					<%
						for(FileManagement fileManagement:fileManagements) {
					%>
					<ul class="std0">
						<li class="od01"><input type="text"
							name="<portlet:namespace/>fileManagementFileName"
							value="<%=fileManagement.getTitle()%>" maxlength="75" /> <input
							type="hidden" name="<portlet:namespace/>fileManagementId"
							value="<%=fileManagement.getFileManagementId()%>" /></li>
						<li class="od02"><a href="#"
							onclick='<portlet:namespace />download("<%=fileManagement.getFileName()%>","<%=fileManagement.getFilePath()%>")'><%=fileManagement.getFileName()%></a></li>
						<li class="od01"><%=sdf.format(fileManagement.getCreateDate())%></li>
						<li class="od01 lcol upd"><a href="#"
							onclick="<portlet:namespace/>addFile()"><liferay-ui:message
									key="vgc.apon.e.leave.upload" /></a>&nbsp; <a href="#"
							onclick="<portlet:namespace/>removeFile(parentNode.parentNode)"><liferay-ui:message
									key="vgc.apon.e.leave.delete" /></a></li>
					</ul>
					<%
						}
					%>
				</div>
				<%
					String fileDivStyle =eLeave.getTicketNo()==null||eLeave.getTicketNo().equals("") ? "" : "style='margin-top: 1px;'";
				%>
				<div id="<portlet:namespace/>fileDiv" <%=fileDivStyle%>>
					<ul class="std0">
						<li class="od01"><input type="text"
							name="<portlet:namespace/>attachmentName" maxlength="75" /></li>
						<li class="od02"><input type="file"
							name="<portlet:namespace/>fileName" /></li>
						<li class="od01"></li>
						<li class="od01 lcol upd"><a href="#"
							onclick="<portlet:namespace/>addFile()"><liferay-ui:message
									key="vgc.apon.e.leave.upload" /></a> <a href="#"
							onclick="<portlet:namespace/>removeFile(parentNode.parentNode)"><liferay-ui:message
									key="vgc.apon.e.leave.delete" /></a></li>
					</ul>
				</div>
			</div>
			    <p style="padding-left:10px;padding-top: 30px;font-style:italic; color: red;"><liferay-ui:message key="vgc.apon.it.e.leave.attachmentList.notes" /></p>
		</div>
		<div class="topButton">
			<aui:button-row>
				<aui:button value="vgc.apon.button.save.as.draft"
					onClick='<%= renderResponse.getNamespace() + "saveELeave()" %>' />
				<aui:button value="vgc.apon.button.submit"
					onClick='<%= renderResponse.getNamespace() + "submitELeave()" %>' />
				<aui:button type="cancel" value="vgc.apon.button.back"
					onClick='<%= myApplicationsURL %>' />
			</aui:button-row>
		</div>
	</div>
</aui:form>

<aui:script use="liferay-search-container">	
AUI().use('aui-io-request', function(A){
	document.getElementById("checkELeaveInfo").onclick = function(){
		var myselect=document.getElementById('typeOfLeave');
		var index=myselect.selectedIndex ;  
		var selectedText=myselect.options[index].text;
		if(selectedText.indexOf("Home office-Case group")<=-1){
			if(!validateDate()){
				return false;
			}
		}
	
		
		setParam();
	}
	
	var myRequest = A.io.request('<%=ajaxURL %>' + '&<portlet:namespace />cmd=ajax', {
		autoLoad: false, 
		on: {
			success: function() {
				var responseData=JSON.parse(this.get('responseData'));
				if(responseData.isLeaveInfoExist){
					var msg="The same leave type can not be submitted several times!";
					alert(msg);
					document.getElementById('isCheckELeaveInfo').value="false";
					document.getElementById('checkELeaveInfoMsg').value=msg;
				}else{
					if(!responseData.isCheck){
						var msg=responseData.msg;
						alert("Data validation failure,Error Reason:"+msg);
						document.getElementById('isCheckELeaveInfo').value="false";
						document.getElementById('checkELeaveInfoMsg').value=msg;
					}else{
						var typeOfLeaveId=responseData.typeOfLeaveId;
						
						if("9001"==typeOfLeaveId||"9002"==typeOfLeaveId||"9003"==typeOfLeaveId||"9004"==typeOfLeaveId){
							document.getElementById('isCheckELeaveInfo').value="true";
							document.getElementById('checkELeaveInfoMsg').value="";
							document.getElementById('totalLeaveEntitlement').value="";	
							document.getElementById('totalDuration').value="";
							document.getElementById('remainingLeaveDaysBefore').value="";
							document.getElementById('remainingLeaveDaysAfter').value="";
						}else{							
							document.getElementById('isCheckELeaveInfo').value="true";
							document.getElementById('checkELeaveInfoMsg').value="";							
							document.getElementById('totalLeaveEntitlement').value=responseData.totalLeaveEntitlement;								
							document.getElementById('totalDuration').value=responseData.duration;
							
							if("0100"==responseData.typeOfLeaveId||"0120"==responseData.typeOfLeaveId||"0121"==responseData.typeOfLeaveId||"0124"==responseData.typeOfLeaveId||"0130"==responseData.typeOfLeaveId){
								document.getElementById('remainingLeaveDaysBefore').value=responseData.leaveDaysBefor;
								document.getElementById('remainingLeaveDaysAfter').value=responseData.leaveDaysAfter;
								
								if(responseData.isLeaveDaysAfter){
									document.getElementById('isCheckELeaveInfo').value="false";
									document.getElementById('checkELeaveInfoMsg').value="You don't have enough leave quota now!";
								}
							}else{
								document.getElementById('remainingLeaveDaysBefore').value="";
								document.getElementById('remainingLeaveDaysAfter').value="";
							}
							if("vgc.apon.e.leave.sick.leave.ge"==responseData.typeOfLeave) {
								document.getElementById('totalLeaveEntitlement').value= "";
								document.getElementById('remainingLeaveDaysBefore').value="";
								document.getElementById('remainingLeaveDaysAfter').value="";
							}	
							if(typeOfLeaveId=='0122' || typeOfLeaveId=='0140' || typeOfLeaveId=='0300' || typeOfLeaveId=='0301'
									|| typeOfLeaveId=='0400' || typeOfLeaveId=='0200' 
									|| typeOfLeaveId=='0800' || typeOfLeaveId=='0900' || typeOfLeaveId=='0123') {
								document.getElementById('totalLeaveEntitlement').value= "";
							}							
							if(responseData.durationList!=null&&responseData.durationList.length>0){
								for(var i=0; i<responseData.durationList.length; i++){
									document.getElementById('leaveDays'+(i+1)).value=responseData.durationList[i];
				                }
							}
							
							if("0900"==responseData.typeOfLeaveId){
								if(!responseData.isUnpaidLeave){
									document.getElementById('isCheckELeaveInfo').value="false";
									document.getElementById('checkELeaveInfoMsg').value="You still have annual leave entitlement. Please don't apply unpaid leave.";
								}
							}
						}
					}
				}
			}   
		} 
	});
	
	function setParam(){
		var eLeaveId="<%=eLeaveId%>";
		var staffCode="<%=staffCode%>";
		var typeOfLeave=document.getElementById("typeOfLeave").value;
		var startDate=document.getElementsByName("<portlet:namespace/>startDate");
		var endDate=document.getElementsByName("<portlet:namespace/>endDate");
		var startTime=document.getElementsByName("<portlet:namespace/>startTime");
		var endTime=document.getElementsByName("<portlet:namespace/>endTime");
		var startDates = '';
		var endDates = '';
		var startTimes = '';
		var endTimes = '';
		for(var i=0;i<startDate.length;i++){
			var val1=startDate.item(i).value;
			var val2=endDate.item(i).value;
			var val3=startTime.item(i).value;
			var val4=endTime.item(i).value;
			startDates+=val1+',';
			endDates+=val2+',';
			startTimes+=val3+',';
			endTimes+=val4+',';
		}
		var dataObj = {<portlet:namespace />eLeaveId:eLeaveId,<portlet:namespace />staffCode:staffCode,
			<portlet:namespace />typeOfLeave:typeOfLeave,<portlet:namespace />startDates:startDates,
			<portlet:namespace />endDates:endDates,<portlet:namespace />startTimes:startTimes,
			<portlet:namespace />endTimes:endTimes};
		myRequest.set('data', dataObj);
		myRequest.start();
	}
});
</aui:script>