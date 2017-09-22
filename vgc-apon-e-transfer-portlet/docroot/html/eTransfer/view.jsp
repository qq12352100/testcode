
<%@include file="/html/init.jsp"%>

<%
ETransfer eTransfer = null;

long eTransferId = ParamUtil.getLong(request, "eTransferId");
if(eTransferId==0) {
	eTransferId = request.getAttribute("eTransferId")!=null?(Long)request.getAttribute("eTransferId"):0;
} 
boolean flag=true;
if (eTransferId > 0){
	eTransfer = ETransferLocalServiceUtil.getETransfer(eTransferId);
	flag=false;
}
else {
	eTransferId = CounterLocalServiceUtil.increment(ETransfer.class.getName(), 1);
	eTransfer = ETransferLocalServiceUtil.createETransfer(eTransferId);
}
String transitionName = ParamUtil.getString(renderRequest, "transitionName", "");

SAPUser sapUser=(SAPUser)renderRequest.getAttribute("sapUser");
if(sapUser!=null&&eTransfer!=null && flag){
	eTransfer.setStaffName(sapUser.getStaffName());
	eTransfer.setCurrentStaffCode(sapUser.getStaffCode());
	String contractType="";
	if(sapUser.getEmployeeGroupName()!=null){
		if("active local".equals(sapUser.getEmployeeGroupName().toLowerCase())){
			contractType="LOCAL";
		}else if("active ex.-le".equals(sapUser.getEmployeeGroupName().toLowerCase())){
			contractType="LE";
		}else if("active ex.-inbound".equals(sapUser.getEmployeeGroupName().toLowerCase())||"n/a(active ex.- fss)".equals(sapUser.getEmployeeGroupName().toLowerCase())){
			contractType="FSE";
		}else if("contractor".equals(sapUser.getEmployeeGroupName().toLowerCase())){
			contractType="Contractor";
		}else if("temp".equals(sapUser.getEmployeeGroupName().toLowerCase())){
			contractType="Intern";
		}	
	}
	eTransfer.setContractType(contractType);
	eTransfer.setCurrentCompany(sapUser.getSapCompanyName());
	eTransfer.setCurrentDivision(sapUser.getDivisionName());
	eTransfer.setCurrentDepartment(sapUser.getDepartmentName());
	eTransfer.setCurrentFunctionName(sapUser.getPositionName());
	eTransfer.setCurrentCostCenter(sapUser.getCostCener());
	eTransfer.setCurrentReportingTo(sapUser.getReportToSupervisiorName());
	String officeSite="";
	if("Beijing-SLT".equals(sapUser.getOfficeSite())){
		officeSite="vgc.apon.e.transfer.beijing.slt";
	}else if("Beijing-ACB".equals(sapUser.getOfficeSite())){
		officeSite="vgc.apon.e.transfer.beijing.acb";
	}else if("Bejiing-Indigo".equals(sapUser.getOfficeSite())){
		officeSite="vgc.apon.e.transfer.beijing.indigo";
	}else if("Beijing-VTA".equals(sapUser.getOfficeSite())){
		officeSite="vgc.apon.e.transfer.beijing.vta";
	}else if("Beijing-HLP".equals(sapUser.getOfficeSite())){
		officeSite="vgc.apon.e.transfer.beijing.hlp";
	}else if("Beijing-Audi City".equals(sapUser.getOfficeSite())){
		officeSite="vgc.apon.e.transfer.beijing.audi.city";
	}else if("Beijing-Audi TCB".equals(sapUser.getOfficeSite())){
		officeSite="vgc.apon.e.transfer.beijing.audi.tcb";
	}else if("Beijing-Audi ATA".equals(sapUser.getOfficeSite())){
		officeSite="vgc.apon.e.transfer.beijing.audi.ata";
	}else if("Beijing-Audi Dealer No.1".equals(sapUser.getOfficeSite())){
		officeSite="vgc.apon.e.transfer.beijing.audi.dealer";
	}else if("N/A".equals(sapUser.getOfficeSite()) || sapUser.getOfficeSite() == null){
		officeSite="vgc.apon.e.transfer.na";
	}
	
	eTransfer.setCurrentOfficeSite(officeSite);
	int leadershiplicense=0;
	if("X".equals(sapUser.getLeadershiplicense())){
		leadershiplicense=1;
	}else{
		leadershiplicense=2;
	}
	eTransfer.setPassedLL(leadershiplicense);
	int leadershiptraining=0;
	if("X".equals(sapUser.getLeadershiptraining())){
		leadershiptraining=1;
	}else{
		leadershiptraining=2;
	}
	eTransfer.setAttendedSLT(leadershiptraining);
	eTransfer.setCurrentPositionCode(sapUser.getPositionId());
}

String supervisorName="";
String divisionName="";
String departmentName="";
String searchType="";
long staffCode=themeDisplay.getUser().getFacebookId();
SAPUser sapUser2=null;
if(staffCode!=0){
	sapUser2=SAPUserLocalServiceUtil.getSapUserByStaffCode(String.valueOf(staffCode));
}
if(sapUser2!=null){
	AponSapData aponSapData2=AponSapDataLocalServiceUtil.getAponSapUserByStaffCode(sapUser2.getStaffCode());
	divisionName=sapUser2.getDivisionName();
	departmentName=sapUser2.getDepartmentName();
	if(sapUser2.getStaffName()!=null&&!sapUser2.getStaffName().equals("")){
		supervisorName=sapUser2.getStaffName();
	}
	String companyName="";
	if(aponSapData2!=null){
		companyName=aponSapData2.getCompanyName();
	}
	if(companyName!=null&&!companyName.equals("")&&(divisionName==null||divisionName.equals(""))&&(departmentName==null||departmentName.equals(""))){
		searchType="CEO";
	}
	if(companyName!=null&&!companyName.equals("")&&divisionName!=null&&!divisionName.equals("")&&(departmentName==null||departmentName.equals(""))){
		searchType="Division";
	}
	if(companyName!=null&&!companyName.equals("")&&divisionName!=null&&!divisionName.equals("")&&departmentName!=null&&!departmentName.equals("")){
		searchType="Department";
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

List<FileManagement> fileManagements = FileManagementLocalServiceUtil.getByAssetClassNameAndAssetPrimaryKey(ETransfer.class.getName(),eTransferId);
String supportFileType = PropsUtil.get("vgc.apon.epa.upload.file.type");
String supportFileSize = PropsUtil.get("vgc.apon.epa.upload.file.size");

String disabled="disabled='disabled'";
%>
<style type="text/css" >
.gernalDiv{width: 100%;border: #E4E4E5 1px solid;text-align: left;line-height: normal;}
.gernalDiv ul{width: 1130px;margin: 0 auto;vertical-align: bottom;}
.gernalDiv li{display: inline-block;padding-top:10px;height: 34px;line-height:normal;overflow: hidden;vertical-align: top;}
.gernalDiv ul li ul{vertical-align: bottom;display:inline-block;padding: 0 0 0 10px;}
.gernalDiv ul li ul li{display: inline-block;padding-top:10px;height: 34px;line-height:34px;overflow: hidden;vertical-align: top;width: 200px;}
.gernalDiv ul li.md01{width:160px;margin-right: 16px;text-align: right;font-weight: 600;word-spacing: 0pt;letter-spacing: 0pt;}
.gernalDiv ul li.md02{width:340px;margin-right: 80px;}
.gernalDiv ul li.md022{width:340px;}
.gernalDiv ul li.md022 input[type="radio"]{margin-left:40px;}
.gernalDiv input[type="text"] {
	padding: 0;
	margin: 0;
	height: 25px;
	width: 295px;
}
.contentbody{width: 100%;border: #E4E4E5 1px solid;text-align: left;margin-bottom: 20px;line-height: normal;padding-bottom:20px;}
.subContentbody{width: 100%;border-bottomt: #E4E4E5 1px solid;border-top: #E4E4E5 1px solid;text-align: left;margin-top: 20px;line-height: normal;}
.contentbody .content{width: 1130px;margin: 0px auto;height: 100%;overflow: hidden;}
.contentbody .content .leftDiv{float: left;
display: inline;
overflow: hidden;
margin-right: 9px;
height: 100%;
margin-left: 3px;}
.contentbody .content .rightDiv{
width: 518px;
float: right;
display: inline;
margin: auto;}
.contentbody .content .centerDiv{width: 1px;float: left;display: inline;border:1px solid black;over-flow:hidden;}
.leftDiv ul{width: 550px;margin: 0 auto;vertical-align: bottom; }
.leftDiv li{display: inline-block;padding-top:10px;height: 34px;line-height:normal;overflow: hidden;vertical-align: top;}
.leftDiv ul li.md01{width:160px;margin-right: 10px;text-align: right;font-weight: 600;word-spacing: 0pt;letter-spacing: 0pt;}
.leftDiv ul li.md02{width:320px;margin-right: 10px;}

.rightDiv ul{width: 550px;margin: 0 auto;vertical-align: bottom; }
.rightDiv li{display: inline-block;padding-top:10px;height: 34px;line-height:normal;overflow: hidden;vertical-align: top;}
.rightDiv ul li.md01{width:160px;margin-right: 10px;text-align: right;font-weight: 600;word-spacing: 0pt;letter-spacing: 0pt;}
.rightDiv ul li.md02{width:320px;margin-right: 10px;}
.contentbody .content input[type="text"] {
	padding: 0;
	margin: 0;
	height: 25px;
	width: 295px;
}

.subtitle{background-color:#E4E4E5;height:30px;font-weight: 600;margin-bottom: 10px;line-height: 30px;}
.subtitle .rightBt {display:inline-block;float:right;vertical-align:top;}
.subtitle .rightBt button{vertical-align:top;}
</style>
<aui:script>
function <portlet:namespace />submitETransfer() {
	// Validate
	if(!validateNotNull('currentStaffCode',5)||!validateNotNull('currentCompany',1)||
			!validateNotNull('currentFunctionName',1)||
			!validateNotNull('currentCostCenter',1)||!validateNotNull('currentReportingTo',1)||
			!validateNotNull('receivingCompany',1)||!validateNotNull('receivingDivision',1)||
			!validateNotNull('newFunctionName',1)||!validateNotNull('newCostCenter',1)||
			!validateNotNull('newReportingTo',1)||!validateNotNull('effectiveDate',1)||
			!validateFileTypeAndSize()){
		return false;
	}
	hiddenDataProcess();
	// Set File Info
	<portlet:namespace />setFileInfo();
	document.<portlet:namespace />fm1.<portlet:namespace /><%= Constants.CMD %>.value = "<%= Constants.PUBLISH %>";
	submitForm(document.<portlet:namespace />fm1);	
}

function <portlet:namespace />saveETransfer() {
	// Validate 
	if(!validateNotNull('currentStaffCode',5)||!validateNotNull('currentCompany',1)||
			!validateNotNull('currentFunctionName',1)||
			!validateNotNull('currentCostCenter',1)||!validateNotNull('currentReportingTo',1)||
			!validateNotNull('receivingCompany',1)||!validateNotNull('receivingDivision',1)||
			!validateNotNull('newFunctionName',1)||!validateNotNull('newCostCenter',1)||
			!validateNotNull('newReportingTo',1)||!validateNotNull('effectiveDate',1)||
			!validateFileTypeAndSize()){
		return false;
	}
	hiddenDataProcess();
	// Set File Info
	<portlet:namespace />setFileInfo();
	document.<portlet:namespace />fm1.<portlet:namespace /><%= Constants.CMD %>.value = "<%= (eTransfer == null || eTransfer.getETransferId() == 0 ) ? Constants.ADD : Constants.UPDATE %>";
	submitForm(document.<portlet:namespace />fm1);		
}

function hiddenDataProcess(){
	var currentOfficeSite=document.getElementById('currentOfficeSite').value;
	document.<portlet:namespace />fm1.<portlet:namespace />currentOfficeSite.value=currentOfficeSite;
	var budgetTypeOfPosition1=document.getElementsByName("<portlet:namespace/>budgetTypeOfPosition1");
	for(var i=0;i<budgetTypeOfPosition1.length;i++){
		if(budgetTypeOfPosition1.item(i).checked){
			document.<portlet:namespace />fm1.<portlet:namespace />budgetTypeOfPosition.value=budgetTypeOfPosition1.item(i).value;
			break;
		}
	}
	var chinaSixty1=document.getElementsByName("<portlet:namespace/>chinaSixty1");
	for(var i=0;i<chinaSixty1.length;i++){
		if(chinaSixty1.item(i).checked){
			document.<portlet:namespace />fm1.<portlet:namespace />chinaSixty.value=chinaSixty1.item(i).value;
			break;
		}
	}
	var targetPDSupervisor1=document.getElementsByName("<portlet:namespace/>targetPDSupervisor1");
	for(var i=0;i<targetPDSupervisor1.length;i++){
		if(targetPDSupervisor1.item(i).checked){
			document.<portlet:namespace />fm1.<portlet:namespace />targetPDSupervisor.value=targetPDSupervisor1.item(i).value;
			break;
		}
	}
	var passedLL1=document.getElementsByName("<portlet:namespace/>passedLL1");
	for(var i=0;i<passedLL1.length;i++){
		if(passedLL1.item(i).checked){
			document.<portlet:namespace />fm1.<portlet:namespace />passedLL.value=passedLL1.item(i).value;
			break;
		}
	}
	var attendedSLT1=document.getElementsByName("<portlet:namespace/>attendedSLT1");
	for(var i=0;i<attendedSLT1.length;i++){
		if(attendedSLT1.item(i).checked){
			document.<portlet:namespace />fm1.<portlet:namespace />attendedSLT.value=attendedSLT1.item(i).value;
			break;
		}
	}
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
	 a0.appendChild(document.createTextNode("<liferay-ui:message key='vgc.apon.e.transfer.upload' />"));
	 li3.appendChild(a0);
	 li3.appendChild(document.createTextNode("  "));
	 var a1 = document.createElement("a");
	 a1.setAttribute("href", "#");	
	 a1.setAttribute("onclick", "<portlet:namespace/>removeFile(parentNode.parentNode)");
	 a1.appendChild(document.createTextNode("<liferay-ui:message key='vgc.apon.e.transfer.delete' />"));
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

function <portlet:namespace/>isTitleExist(obj,title) {
	var isExist=false;
	for(var i=0;i<obj.length;i++){
		var titleName=obj[i];
		if(titleName==title){
			isExist=true;
			break;
		}
	}
	return isExist;
}

var arrayObj = new Array();

function <portlet:namespace/>clearFile(obj,title,index) {
	arrayObj.push(title);
	var titleIndex=0;
	var fileDiv = obj.parentNode;  
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
	input0.setAttribute("value", title);
	input0.setAttribute("readonly", "readonly");
	li0.appendChild(input0);		 
	var li1 = document.createElement("li");
	li1.setAttribute("class", "od02");	
	var input1 = document.createElement("input");
	input1.setAttribute("type", "file");	
	input1.setAttribute("id", "fileattAchmentName"+index);
	input1.setAttribute("name", "<portlet:namespace/>fileName");	
	li1.appendChild(input1);		
	var li2 = document.createElement("li");
	li2.setAttribute("class", "od01");	
	var li3 = document.createElement("li");
	li3.setAttribute("class", "od01 lcol");		 
	var a1 = document.createElement("a");
	a1.setAttribute("href", "#");	
	a1.setAttribute("onclick", "<portlet:namespace/>clearFile(parentNode.parentNode,'"+title+"',"+index+")");
    a1.appendChild(document.createTextNode("<liferay-ui:message key='vgc.apon.e.transfer.delete' />"));
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
	fileDiv.replaceChild(ul,obj);
	input1.focus();
}

//Validate the file type and size is right
function validateFileTypeAndSize() {
	var fileNames = document.getElementsByName('<portlet:namespace/>fileName');
	var supportFileType = '<%=supportFileType%>';
	var supportFileSize = '<%=supportFileSize%>';
	var dlag='<%=eTransfer.getTicketNo()==null||eTransfer.getTicketNo().equals("")%>';
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
		}else{
			if(dlag=='true'){
				var fileId1 = document.getElementById('fileattAchmentName1');
				var fileName1 = fileId1.value;
				if(fileName1==null || fileName1 ==""){
					alert("Please upload JD!");
					flag = false;
					break;
				}
			}else{
				var fileId1;
				if(<portlet:namespace/>isTitleExist(arrayObj,"JD* (Signed)")){
					fileId1 = document.getElementById('fileattAchmentName1');
				}
				if(fileId1){
					var fileName1 = fileId1.value;
					if(fileName1==null || fileName1 ==""){
						alert("Please upload JD!");
						flag = false;
						break;
					}
				}
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
	   
	function <portlet:namespace/>searchSAPUser(){
		var staffCode=document.<portlet:namespace/>fm1.<portlet:namespace/>currentStaffCode.value;
		document.<portlet:namespace/>searchSapUser.<portlet:namespace/>staffCode2.value=staffCode;
		var eTransferId = document.getElementById('<portlet:namespace />eTransferId');
		document.<portlet:namespace />searchSapUser.<portlet:namespace />eTransferId2.value = eTransferId.value;
		submitForm(document.<portlet:namespace/>searchSapUser);
	}
</aui:script>

<portlet:actionURL var="addETransferURL" windowState="normal" />

<liferay-portlet:renderURL var="myApplicationsURL"
	plid="<%=myApplicationsPlid%>"
	portletName='<%=PropsUtil.get("vgc.apon.my.applications.portletId") %>'
	windowState="normal">
</liferay-portlet:renderURL>

<aui:form  method="post" name="fm1" action="<%=addETransferURL %>" style="height:auto;width:auto;" enctype="multipart/form-data">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />
		<aui:input type="hidden" name="<%= Constants.CMD %>" />
		<aui:input type="hidden" name="eTransferId" value="<%= eTransferId %>" />
		<aui:input type="hidden" name="transitionName" value='<%=transitionName%>' />
		<aui:input type="hidden" name="existTitles"/>	
		<aui:input type="hidden" name="newTitles"/>	
		<aui:input type="hidden" name="existFileIds"/>
		<aui:input type="hidden" name="currentOfficeSite"/>
		<aui:input type="hidden" name="budgetTypeOfPosition"/>
		<aui:input type="hidden" name="chinaSixty"/>
		<aui:input type="hidden" name="targetPDSupervisor"/>
		<aui:input type="hidden" name="passedLL"/>
		<aui:input type="hidden" name="attendedSLT"/>
	</aui:fieldset>
	
	<div >
		<div class="topButton">
			<aui:button-row>
				<aui:button value="vgc.apon.button.save.as.draft" onClick='<%= renderResponse.getNamespace() + "saveETransfer()" %>'/>
				<aui:button value="vgc.apon.button.submit"  onClick='<%= renderResponse.getNamespace() + "submitETransfer()" %>'/>
				<aui:button type="cancel" value="vgc.apon.button.back" onClick='<%= myApplicationsURL %>' />
			</aui:button-row>
		</div>
		<div class="tabTitle">
			<h3>
				<liferay-ui:message
					key="vgc.apon.e.transfer" />
			</h3>
			<div class="Ltext"></div>
			<div class="tickerNo">
				<liferay-ui:message key="vgc.apon.e.transfer.ticket.no" />
				<span class="num"><%=eTransfer.getTicketNo()%></span>
			</div>
			<div class="clear"></div>
		</div>
		<div class="gernalDiv">
	      <div class="subtitle">
			<liferay-ui:message key="vgc.apon.e.transfer.personal.information" />			
		  </div>
		  <ul>
			<li class="md01"><liferay-ui:message key="vgc.apon.e.transfer.staff.name"></liferay-ui:message></li>
			<li class="md02">
				<input type="text" id="staffName" name="<portlet:namespace/>staffName" value="<%=eTransfer.getStaffName()%>" maxlength="75" readonly="readonly">
			</li>
			<li class="md01"><liferay-ui:message key="vgc.apon.e.transfer.current.staff.code"></liferay-ui:message></li>
			<li class="md022">
				<input type="text" id="currentStaffCode" name="<portlet:namespace/>currentStaffCode" value="<%=eTransfer.getCurrentStaffCode()%>" required="required" maxlength="75">
				<a href='javascript:<%= renderResponse.getNamespace() + "searchSAPUser()" %>' onclick="">
			    <img src='<%=checkImagePath%>'/></a>
			</li>
		  </ul>
		  <ul>
			<li class="md01"><liferay-ui:message key="vgc.apon.e.transfer.contract.type"></liferay-ui:message></li>
			<li class="md02">
				<input type="text" id="contractType" name="<portlet:namespace/>contractType" value="<%=eTransfer.getContractType()%>" maxlength="75" readonly="readonly">
			</li>
			<li class="md01"><liferay-ui:message key="vgc.apon.e.transfer.new.staff.code"></liferay-ui:message></li>
			<li class="md022">
				<input type="text" id="newStaffCode" name="<portlet:namespace/>newStaffCode" value="<%=eTransfer.getNewStaffCode()%>" maxlength="75" readonly="readonly">
			</li>
		  </ul>
		  <div class="subContentbody">
		  <ul style="width:100%;">
		  	<li  style="width: 16%; height: 100px; text-align: center; line-height: 100px; overflow: auto;border-right: 1px solid #E4E4E5;font-weight: 600;word-spacing: 0pt;letter-spacing: 0pt;margin-left:150px;">
		  		<liferay-ui:message key="vgc.apon.e.transfer.for.leadership.status"></liferay-ui:message>
		  	</li>
		  	<li  style="width: 73%; height: 100%;font-weight: 600;word-spacing: 0pt;letter-spacing: 0pt;">
		  		<ul>
		  			<li  style="width: 360px;font-weight: 600;word-spacing: 0pt;letter-spacing: 0pt;"><liferay-ui:message key="vgc.apon.e.transfer.passed.leadership.license"></liferay-ui:message></li>
					<li  style="text-align: center;">
						<input type="radio" <%=disabled %> name="<portlet:namespace/>passedLL1" value="1" <%=eTransfer.getPassedLL() == 1 ? "checked='checked'":"" %>>Yes
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" <%=disabled %> name="<portlet:namespace/>passedLL1" value="2" <%=eTransfer.getPassedLL() == 2 ? "checked='checked'":"" %>>No
					</li>
				</ul>
				<ul style="border-top: 1px solid #E4E4E5;">
					<li style="width: 360px;font-weight: 600;word-spacing: 0pt;letter-spacing: 0pt;"><liferay-ui:message key="vgc.apon.e.transfer.attended.situational.leadership.training"></liferay-ui:message></li>
					<li style="text-align: center;">
						<input type="radio" <%=disabled %> name="<portlet:namespace/>attendedSLT1" value="1" <%=eTransfer.getAttendedSLT()== 1 ? "checked='checked'":"" %>>Yes
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" <%=disabled %> name="<portlet:namespace/>attendedSLT1" value="2" <%=eTransfer.getAttendedSLT() == 2 ? "checked='checked'":"" %>>No
					</li>
		  		</ul>
		  	</li>
		  </ul>
		  </div>
		  
	  </div>
	  
	  <div style="height:20px;"></div>
		 
	  <div class="contentbody">
	  <div>                                                                                                                                                              
	  		<div  style="float: left;display: inline;overflow: hidden;width:50%;
	  		background-color:#E4E4E5;height:30px;font-weight: 600;margin-bottom: 10px;line-height: 30px;">
				<liferay-ui:message key="vgc.apon.e.transfer.current.status" />	
				<input type="hidden" id="currentPositionCode" name="<portlet:namespace/>currentPositionCode" value="<%= eTransfer.getCurrentPositionCode()%>">		
			</div>
			<div style="display: inline;background-color: rgb(228, 228, 229); font-weight: 600; 
			margin-bottom: 10px; line-height: 30px; overflow: hidden; height: 30px; width: 50%; float: right; margin-left: -10px;">
				<liferay-ui:message key="vgc.apon.e.transfer.new.status" />	
				<input type="hidden" id="receivingStaffCode" name="<portlet:namespace/>receivingStaffCode" value="<%= eTransfer.getReceivingStaffCode()%>">					
			</div>
	  	</div>
	  	<div class="content " >
	  	
	  	<div class="leftDiv" >
	  	<ul>
			<li class="md01"><liferay-ui:message key="vgc.apon.e.transfer.current.company"></liferay-ui:message></li>
			<li class="md02">
				<input type="text" id="currentCompany" name="<portlet:namespace/>currentCompany" value="<%=eTransfer.getCurrentCompany()%>" maxlength="75" readonly="readonly">
			</li>
		</ul>
		<ul>
			<li class="md01"><liferay-ui:message key="vgc.apon.e.transfer.current.division"></liferay-ui:message></li>
			<li class="md02">
				<input type="text" id="currentDivision" name="<portlet:namespace/>currentDivision" value="<%=eTransfer.getCurrentDivision()%>" maxlength="75" readonly="readonly">
			</li>
		</ul>
		<ul>
			<li class="md01"><liferay-ui:message key="vgc.apon.e.transfer.current.department"></liferay-ui:message></li>
			<li class="md02">
				<input type="text" id="currentDepartment" name="<portlet:namespace/>currentDepartment" value="<%=eTransfer.getCurrentDepartment()%>" maxlength="75" readonly="readonly">
			</li>
		</ul>
		<ul>
			<li class="md01"><liferay-ui:message key="vgc.apon.e.transfer.function.name"></liferay-ui:message></li>
			<li class="md02">
				<input type="text" id="currentFunctionName" name="<portlet:namespace/>currentFunctionName" value="<%=eTransfer.getCurrentFunctionName()%>" maxlength="75" readonly="readonly">
			</li>
		</ul>
		<ul>
			<li class="md01"><liferay-ui:message key="vgc.apon.e.transfer.cost.center"></liferay-ui:message></li>
			<li class="md02">
				<input type="text" id="currentCostCenter" name="<portlet:namespace/>currentCostCenter" value="<%=eTransfer.getCurrentCostCenter()%>" maxlength="75" readonly="readonly">
			</li>
		</ul>
		<ul>
			<li class="md01"><liferay-ui:message key="vgc.apon.e.transfer.reporting.to"></liferay-ui:message></li>
			<li class="md02">
				<input type="text" id="currentReportingTo" name="<portlet:namespace/>currentReportingTo" value="<%=eTransfer.getCurrentReportingTo()%>" maxlength="75" readonly="readonly">
			</li>
		</ul>
		<ul>
			<li class="md01"><liferay-ui:message key="vgc.apon.e.transfer.other.agreement.if.any"></liferay-ui:message></li>
			<li class="md02">
				<input type="text" id="otherAgreementIfAny" name="<portlet:namespace/>otherAgreementIfAny" value="<%=eTransfer.getOtherAgreementIfAny()%>" maxlength="75">
			</li>
		</ul>
		<ul>
			<li class="md01">
				<liferay-ui:message key="vgc.apon.e.transfer.office.site" />
			</li>
			<li style="height: 28px;">
				<select id="currentOfficeSite" name="<portlet:namespace/>currentOfficeSite1" <%=disabled %> style="width: 295px; height: 28px;">
				<%
					String currentOfficeSite = eTransfer.getCurrentOfficeSite();						

					for (String officeSite : PortletPropsValues.OFFICE_SITE) {
				%>
					<option <%= currentOfficeSite.equals(officeSite) ? "selected='selected'" : "" %> value="<%= officeSite %>">
							<%= LanguageUtil.get(pageContext, officeSite) %>
					</option>
					<%
						}
					%>
				</select>
			</li>
		</ul>
		
	  </div>	
	 <!--   <div class="centerDiv " ></div>-->
	  	<div class="rightDiv " >
	  	<ul>
			<li class="md01"><liferay-ui:message key="vgc.apon.e.transfer.receiving.company"></liferay-ui:message></li>
			<li class="md02">
				<input type="text" id="receivingCompany" name="<portlet:namespace/>receivingCompany" value="<%=eTransfer.getReceivingCompany()%>" maxlength="75" readonly="readonly">
			</li>
		</ul>
		<ul>
			<li class="md01"><liferay-ui:message key="vgc.apon.e.transfer.receiving.division"></liferay-ui:message></li>
			<li class="md02">
				<input type="text" id="receivingDivision" name="<portlet:namespace/>receivingDivision" value="<%=eTransfer.getReceivingDivision()%>" maxlength="75" readonly="readonly">
			</li>
		</ul>
		<ul>
			<li class="md01"><liferay-ui:message key="vgc.apon.e.transfer.receiving.department"></liferay-ui:message></li>
			<li class="md02">
				<input type="text" id="receivingDepartment" name="<portlet:namespace/>receivingDepartment" value="<%=eTransfer.getReceivingDepartment()%>" maxlength="75" readonly="readonly">
			</li>
		</ul>
		<ul>
			<li class="md01"><liferay-ui:message key="vgc.apon.e.transfer.function.name"></liferay-ui:message></li>
			<li class="md22">
				<input type="text" id="newFunctionName" name="<portlet:namespace/>newFunctionName" value="<%=eTransfer.getNewFunctionName()%>" maxlength="75">
				<liferay-ui:icon
					id="selectPositionTo"
					label="<%= true %>"
					message=""
					method="get"
					url="javascript:;"
					src='<%= themeDisplay.getPathThemeImages()+"/common/search.png" %>'
				/>
			</li>
		</ul>
		<ul>
			<li class="md01"><liferay-ui:message key="vgc.apon.e.transfer.cost.center"></liferay-ui:message></li>
			<li class="md02">
				<input type="text" id="newCostCenter" name="<portlet:namespace/>newCostCenter" value="<%=eTransfer.getNewCostCenter()%>" maxlength="75" readonly="readonly">
			</li>
		</ul>
		<ul>
			<li class="md01"><liferay-ui:message key="vgc.apon.e.transfer.reporting.to"></liferay-ui:message></li>
			<li class="md02">
				<input type="text" id="newReportingTo" name="<portlet:namespace/>newReportingTo" value="<%=eTransfer.getNewReportingTo()%>" maxlength="75" readonly="readonly">
			</li>
		</ul>
		<ul>
			<li class="md01"><liferay-ui:message key="vgc.apon.e.transfer.effective.date"></liferay-ui:message></li>
			<li class="md02">
				<input id="<portlet:namespace/>effectiveDate" class="Wdate" type="text" name="<portlet:namespace/>effectiveDate" value="<%= eTransfer.getEffectiveDate()!=null?sdf_dmy.format(eTransfer.getEffectiveDate()) : "" %>" onFocus="WdatePicker({lang:'en',dateFmt:'dd.MM.yyyy'})" required="required" maxlength="75"/>
			</li>
		</ul>
		<ul>
			<li class="md01">
				<liferay-ui:message key="vgc.apon.e.transfer.office.site" />
			</li>
			<li  style=" height: 28px;">
				<select id="newOfficeSite" name="<portlet:namespace/>newOfficeSite" style="width: 295px; height: 28px;">
				<%
					String newOfficeSite = eTransfer.getNewOfficeSite();						

					for (String officeSite : PortletPropsValues.OFFICE_SITE) {
				%>
					<option <%= newOfficeSite.equals(officeSite) ? "selected='selected'" : "" %> value="<%= officeSite %>">
							<%= LanguageUtil.get(pageContext, officeSite) %>
					</option>
					<%
						}
					%>
				</select>
			</li>
		</ul>
		</div>
	  </div>
	  </div>
	  <div class="gernal">
	  	<div class="subtitle">
			<liferay-ui:message key="vgc.apon.e.transfer.confirmed.by.orga" />
		</div>
		<ul>
			<li class="md01"><liferay-ui:message key="vgc.apon.e.transfer.sap.position.code"></liferay-ui:message></li>
			<li class="md02">
				<input type="text" id="sapPositionCode" name="<portlet:namespace/>sapPositionCode" value="<%=eTransfer.getSapPositionCode()%>" maxlength="75" readonly="readonly">
			</li>
			<li class="md01"><liferay-ui:message key="vgc.apon.e.transfer.replacement"></liferay-ui:message></li>
			<li class="md022">
				<input type="text" id="replacement" name="<portlet:namespace/>replacement" value="<%=eTransfer.getReplacement()%>" required="required" maxlength="75">
			</li>
		</ul>
		<ul>
			<li class="md01"><liferay-ui:message key="vgc.apon.e.transfer.function.grade"></liferay-ui:message></li>
			<li class="md02">
				<input type="text" id="expectFunctionGrade" name="<portlet:namespace/>functionGrade" value="<%= eTransfer.getFunctionGrade() %>" readonly="readonly" maxlength="75">
			</li>
			<li class="md01"></li>
			<li class="md022"></li>
		</ul>
		<ul>
			<li class="md01">
				<liferay-ui:message key="vgc.apon.e.transfer.budget.type.of.position" />
			</li>
			<li class="md10">
				<input type="radio" <%=disabled %> name="<portlet:namespace/>budgetTypeOfPosition1" value="1" <%= eTransfer.getBudgetTypeOfPosition() == 1 ? "checked='checked'":"" %>><liferay-ui:message key="vgc.apon.e.transfer.budget.type.local" />
				</li>
			<li class="md10">
				<input type="radio" <%=disabled %> name="<portlet:namespace/>budgetTypeOfPosition1" value="2" <%= eTransfer.getBudgetTypeOfPosition() == 2  ? "checked='checked'":"" %>><liferay-ui:message key="vgc.apon.e.transfer.budget.type.le" />
				</li>
			<li class="md10">
				<input type="radio" <%=disabled %> name="<portlet:namespace/>budgetTypeOfPosition1" value="3" <%= eTransfer.getBudgetTypeOfPosition() == 3  ? "checked='checked'":"" %>><liferay-ui:message key="vgc.apon.e.transfer.budget.type.fse" />
				</li>
			<li class="md10">
				<input type="radio" <%=disabled %> name="<portlet:namespace/>chinaSixty1" value="1" <%= eTransfer.getChinaSixty() == 1  ? "checked='checked'":"" %>><liferay-ui:message key="vgc.apon.e.transfer.budget.type.chinaSixty" />
				</li>
			<li class="md10">
				<input type="radio" <%=disabled %> name="<portlet:namespace/>budgetTypeOfPosition1" value="4" <%= eTransfer.getBudgetTypeOfPosition() == 4  ? "checked='checked'":"" %>><liferay-ui:message key="vgc.apon.e.transfer.budget.type.wanderjahr" />
				</li>
			<li class="md10">
				<input type="radio" <%=disabled %> name="<portlet:namespace/>budgetTypeOfPosition1" value="5" <%= eTransfer.getBudgetTypeOfPosition() == 5  ? "checked='checked'":"" %>><liferay-ui:message key="vgc.apon.e.transfer.budget.type.ipd" />
				</li>
		</ul>
		<ul>
			<li class="md01" style="height:50px;">
				<liferay-ui:message key="vgc.apon.e.transfer.target.position.ds" />
			</li>
			<li class="md10">
				<input type="radio" <%=disabled %> name="<portlet:namespace/>targetPDSupervisor1" value="1" <%= eTransfer.getTargetPDSupervisor() == 1 ? "checked='checked'":"" %>><liferay-ui:message key="vgc.apon.e.transfer.disciplinary.rs.3.subordinates" />
				</li>
			<li class="md10">
				<input type="radio" <%=disabled %> name="<portlet:namespace/>targetPDSupervisor1" value="2" <%= eTransfer.getTargetPDSupervisor() == 2  ? "checked='checked'":"" %>><liferay-ui:message key="vgc.apon.e.transfer.disciplinary.rs.12.subordinates" />
				</li>
			<li class="md10">
				<input type="radio" <%=disabled %> name="<portlet:namespace/>targetPDSupervisor1" value="3" <%= eTransfer.getTargetPDSupervisor() == 3  ? "checked='checked'":"" %>><liferay-ui:message key="vgc.apon.e.transfer.disciplinary.rs.no.subordinates" />
			</li>
		</ul>
	  </div>
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
								<li class="od01">
									<%if(eTransfer.getTicketNo()!=null&&!eTransfer.getTicketNo().equals("")&&"JD* (Signed)".equals(fileManagement.getTitle())){ %>
										<input type="text" name="<portlet:namespace/>fileManagementFileName" value="<%=fileManagement.getTitle()%>" readonly="readonly" maxlength="75"/>
									<%}else{%>
										<input type="text" name="<portlet:namespace/>fileManagementFileName" value="<%=fileManagement.getTitle()%>" maxlength="75"/>
									<%}%>
									<input type="hidden" name="<portlet:namespace/>fileManagementId" value="<%=fileManagement.getFileManagementId()%>"/>
								</li>
								<li class="od02"><a href="#" onclick='<portlet:namespace />download("<%=fileManagement.getFileName()%>","<%=fileManagement.getFilePath()%>")'><%=fileManagement.getFileName()%></a></li>
								<li class="od01"><%=sdf.format(fileManagement.getCreateDate())%></li>
								<li class="od01 lcol upd">
									<%if(eTransfer.getTicketNo()!=null&&!eTransfer.getTicketNo().equals("")&&"JD* (Signed)".equals(fileManagement.getTitle())){%>
										<a href="#" onclick="<portlet:namespace/>clearFile(parentNode.parentNode,'<%=fileManagement.getTitle()%>',1)"><liferay-ui:message key="vgc.apon.e.transfer.delete" /></a>
									<%}else{%>
										<a href="#" onclick="<portlet:namespace/>addFile()"><liferay-ui:message key="vgc.apon.e.transfer.upload" /></a>&nbsp;
										<a href="#" onclick="<portlet:namespace/>removeFile(parentNode.parentNode)"><liferay-ui:message key="vgc.apon.e.transfer.delete" /></a>
									<%} %>
								</li>
							</ul>
							<%
							} %>
						</div>			
						<%
							String fileDivStyle =eTransfer.getTicketNo()==null||eTransfer.getTicketNo().equals("") ? "" : "style='margin-top: 1px;'";
						%>			
						<div id="<portlet:namespace/>fileDiv" <%=fileDivStyle %>>
							<%if(eTransfer.getTicketNo()==null||eTransfer.getTicketNo().equals("")){%>	
							<ul class="std0">
								<li class="od01"><input type="text" name="<portlet:namespace/>attachmentName" value="JD* (Signed)" readonly="readonly" maxlength="75"/></li>
								<li class="od02"><input type="file" id="fileattAchmentName1" name="<portlet:namespace/>fileName"/></li>
								<li class="od01">&nbsp;&nbsp;</li>
								<li class="od01 lcol upd">
								</li>
							</ul>	
							<%} %>
							<ul class="std0">
								<li class="od01"><input type="text" name="<portlet:namespace/>attachmentName" maxlength="75"/></li>
								<li class="od02"><input type="file" name="<portlet:namespace/>fileName"/></li>
								<li class="od01">&nbsp;&nbsp;</li>
								<li class="od01 lcol upd">
									<a href="#" onclick="<portlet:namespace/>addFile()"><liferay-ui:message key="vgc.apon.e.transfer.upload" /></a>
									<a href="#" onclick="<portlet:namespace/>removeFile(parentNode.parentNode)"><liferay-ui:message key="vgc.apon.e.transfer.delete" /></a>
								</li>
							</ul>
						</div>
					</div>
					 <p style="padding-left:10px;padding-top: 30px;font-style:italic; color: red;"><liferay-ui:message key="vgc.apon.e.transfer.attachments.notes" /></p>
				</div>
				<div class="topButton">
			<aui:button-row>
				<aui:button value="vgc.apon.button.save.as.draft" onClick='<%= renderResponse.getNamespace() + "saveETransfer()" %>'/>
				<aui:button value="vgc.apon.button.submit"  onClick='<%= renderResponse.getNamespace() + "submitETransfer()" %>'/>
				<aui:button type="cancel" value="vgc.apon.button.back" onClick='<%= myApplicationsURL %>' />
			</aui:button-row>
		</div>	
	</div>
</aui:form>

<aui:form  action="<%=portletURL %>" method="post" name="searchSapUser">
	<aui:fieldset>
	   <aui:input type="hidden" name="staffCode2"/>
		<aui:input name="eTransferId2" type="hidden" />
	</aui:fieldset>
</aui:form>

<aui:script use="liferay-search-container">
var selectCarLink = A.one('#<portlet:namespace />selectPositionTo');
if (selectCarLink) {
	selectCarLink.on(
		'click',
		function(event) {
			Liferay.Util.selectEntity(
				{
					dialog: {
						constrain: true,
						modal: true
					},
					id: '<portlet:namespace />selectPosition',
					title: '<liferay-ui:message arguments="vgc.apon.e.transfer.position.code" key="select-x" />',
					uri:'<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>"><portlet:param name="mvcPath" value="/html/admin/select_position.jsp" /><portlet:param name="supervisorName" value="<%=supervisorName%>" /><portlet:param name="divisionName" value="<%=divisionName%>" /><portlet:param name="departmentName" value="<%=departmentName%>" /><portlet:param name="searchType" value="<%=searchType%>" /></portlet:renderURL>'
				},
				function(event) {
					document.getElementById("receivingCompany").value=event.companyName;
					document.getElementById("receivingDivision").value=event.divisionName;
					document.getElementById("receivingDepartment").value=event.departmentName;
					document.getElementById("newFunctionName").value=event.functionName;
					document.getElementById("newCostCenter").value=event.costCenter;
					document.getElementById("newReportingTo").value=event.reportToSupervisorName;
					var officeSite="";
					if("Beijing-SLT"==event.officeSite){
						officeSite="vgc.apon.e.transfer.beijing.slt";
					}else if("Beijing-ACB"==event.officeSite){
						officeSite="vgc.apon.e.transfer.beijing.acb";
					}else if("Bejiing-Indigo"==event.officeSite){
						officeSite="vgc.apon.e.transfer.beijing.indigo";
					}else if("Beijing-VTA"==event.officeSite){
						officeSite="vgc.apon.e.transfer.beijing.vta";
					}else if("Beijing-HLP"==event.officeSite){
						officeSite="vgc.apon.e.transfer.beijing.hlp";
					}else if("Beijing-Audi City"==event.officeSite){
						officeSite="vgc.apon.e.transfer.beijing.audi.city";
					}else if("Beijing-Audi TCB"==event.officeSite){
						officeSite="vgc.apon.e.transfer.beijing.audi.tcb";
					}else if("Beijing-Audi ATA"==event.officeSite){
						officeSite="vgc.apon.e.transfer.beijing.audi.ata";
					}else if("Beijing-Audi Dealer No.1"==event.officeSite){
						officeSite="vgc.apon.e.transfer.beijing.audi.dealer";
					}else if("N/A"==event.officeSite){
						officeSite="vgc.apon.e.transfer.na";
					}
					document.getElementById("newOfficeSite").value=officeSite;
					document.getElementById("sapPositionCode").value=event.positionCode;
					document.getElementById("expectFunctionGrade").value=event.sg;
					var positionType=event.positionType;
					if('Local'==positionType){
						positionType=1;
					}else if('LE'==positionType){
						positionType=2;
					}else if('FSE'==positionType){
						positionType=3;
					}else if('Wanderjahr'==positionType){
						positionType=4;
					}else if('IPD'==positionType){
						positionType=5;
					}
					var budgetTypeOfPosition=document.getElementsByName("<portlet:namespace/>budgetTypeOfPosition1");
					for(var i=0;i<budgetTypeOfPosition.length;i++){
						if(budgetTypeOfPosition.item(i).value==positionType){
							budgetTypeOfPosition.item(i).checked=true;
						}else{
							budgetTypeOfPosition.item(i).checked=false;
						}
					}
					var china60=event.china60;
					if('x'==china60||'X'==china60){
						china60=1;
					}
					var chinaSixty=document.getElementsByName("<portlet:namespace/>chinaSixty1");
					for(var i=0;i<chinaSixty.length;i++){
						if(chinaSixty.item(i).value==china60){
							chinaSixty.item(i).checked=true;
						}else{
							chinaSixty.item(i).checked=false;
						}
					}
					var totNumOfRep=event.totNumOfRep;
					if(totNumOfRep!=null&&totNumOfRep!=''&&totNumOfRep>=3){
						totNumOfRep=1;
					}else if(totNumOfRep!=null&&totNumOfRep!=''&&(totNumOfRep==1||totNumOfRep==2)){
						totNumOfRep=2;
					}else if(totNumOfRep==null||totNumOfRep==''||totNumOfRep==0){
						totNumOfRep=3;
					}
					var targetPDSupervisor=document.getElementsByName("<portlet:namespace/>targetPDSupervisor1");
					for(var i=0;i<targetPDSupervisor.length;i++){
						if(targetPDSupervisor.item(i).value==totNumOfRep){
							targetPDSupervisor.item(i).checked=true;
						}else{
							targetPDSupervisor.item(i).checked=false;
						}
					}
					document.getElementById("receivingStaffCode").value=event.staffCode;
				}
			);
		}
	);
}
</aui:script>