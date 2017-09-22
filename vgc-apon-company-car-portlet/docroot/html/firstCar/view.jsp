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
	FirstCompanyCar firstCompanyCar = null;
	long firstCompanyCarId = ParamUtil.getLong(request, "firstCompanyCarId");
	String transitionName = ParamUtil.getString(renderRequest, "transitionName", "");
	String isClickAgent = ParamUtil.getString(renderRequest, "isClickAgent","");
	boolean isNew = true;
	boolean isPGMaxOf29 = false;

	long sCode = themeDisplay.getUser().getFacebookId();
	Date now = new Date();
	ApplicantDelegation applicantDelegation = ApplicantDelegationLocalServiceUtil.fetchByP_S(ApproverDelegationLocalServiceUtil.getProcessOfCompanyCarApplication(),String.valueOf(sCode));
	boolean isHasAppliantAgent = applicantDelegation!=null && now.after(applicantDelegation.getEffectiveStartDate()) && now.before(applicantDelegation.getEffectiveEndDate())?true:false;
	String agentName = applicantDelegation!=null?ApplicantDelegationLocalServiceUtil.getAgentName(applicantDelegation):"";
	
	String prefixUrl = "/web"+themeDisplay.getScopeGroup().getFriendlyURL();	 
	String myApplicationsPageUrl = prefixUrl+PropsUtil.get("vgc.apon.my.applications.page.friendly.url");
	long myApplicationsPlid = PortalUtil.getPlidFromFriendlyURL(
			themeDisplay.getCompanyId(),myApplicationsPageUrl);
	
	if (firstCompanyCarId > 0) {
		firstCompanyCar = FirstCompanyCarLocalServiceUtil.fetchFirstCompanyCar(firstCompanyCarId);
		if(firstCompanyCar!=null) {
			isNew = false;
		}
		firstCompanyCar = firstCompanyCar!=null?firstCompanyCar:FirstCompanyCarLocalServiceUtil.createFirstCompanyCar(firstCompanyCarId);
	}else {
		firstCompanyCarId = CounterLocalServiceUtil.increment(FirstCompanyCar.class.getName(),1);
		firstCompanyCar = FirstCompanyCarLocalServiceUtil.createFirstCompanyCar(firstCompanyCarId);
	}
	//Fetch the data from SAP
	if(isNew) {
		long staffCode = ParamUtil.getLong(renderRequest, "staffCode", 0);			
		staffCode=staffCode==0?themeDisplay.getUser().getFacebookId():staffCode;
		SAPUser sapUser = SAPUserLocalServiceUtil.getSapUserByStaffCode(String.valueOf(staffCode));
		boolean isApplicantAgent = ParamUtil.getBoolean(renderRequest, "isApplicantAgent",false);		
		if(sapUser!=null) {
			firstCompanyCar.setIsApplicantAgent(isApplicantAgent);
			firstCompanyCar.setChildrenNumber(sapUser.getChildrenNumber());
			firstCompanyCar.setCompanyName(sapUser.getSapCompanyName());
			firstCompanyCar.setStaffCode(Long.valueOf(sapUser.getStaffCode()));
			firstCompanyCar.setName(sapUser.getStaffName());
			firstCompanyCar.setDivision(sapUser.getDivisionName());
			firstCompanyCar.setDepartment(sapUser.getDepartmentName());
			firstCompanyCar.setPositionCostCenterId(sapUser.getCostCener());
			firstCompanyCar.setEmployeeGroupId(sapUser.getEmployeeGroupId());
			firstCompanyCar.setWorkingLocation(sapUser.getWorkLocation());
			firstCompanyCar.setEmail(sapUser.getEmail());
			firstCompanyCar.setOfficeSite(sapUser.getOfficeSite());
			firstCompanyCar.setMobilePhone(sapUser.getCellPhone());
			firstCompanyCar.setOfficePhone(sapUser.getContactNo());
			firstCompanyCar.setContractEndDate(sapUser.getContractEndDate());
			firstCompanyCar.setDrivingLicenseInformation(-1);	
			if(EmployeeSubGroupIDPersonalGradeEnum.getPgEnum(sapUser.getEmployeeSubgroupId()).compareTo(EmployeeSubGroupIDPersonalGradeEnum.PG3)>0) {
				isPGMaxOf29 = true;
			}
		}
	}else {
		boolean isApplicantAgent = ParamUtil.getBoolean(renderRequest, "isApplicantAgent",true);
		if(isApplicantAgent!=firstCompanyCar.getIsApplicantAgent()&& Validator.isNotNull(isClickAgent)) {		
			long staffCode = isApplicantAgent?ParamUtil.getLong(renderRequest, "staffCode", 0):themeDisplay.getUser().getFacebookId();
			staffCode = staffCode==0?firstCompanyCar.getStaffCode():staffCode;
			SAPUser sapUser = SAPUserLocalServiceUtil.getSapUserByStaffCode(String.valueOf(staffCode));
			if(sapUser!=null) {
				firstCompanyCar.setIsApplicantAgent(isApplicantAgent);
				firstCompanyCar.setChildrenNumber(sapUser.getChildrenNumber());
				firstCompanyCar.setCompanyName(sapUser.getSapCompanyName());
				firstCompanyCar.setStaffCode(Long.valueOf(sapUser.getStaffCode()));
				firstCompanyCar.setName(sapUser.getStaffName());
				firstCompanyCar.setDivision(sapUser.getDivisionName());
				firstCompanyCar.setDepartment(sapUser.getDepartmentName());
				firstCompanyCar.setPositionCostCenterId(sapUser.getCostCener());
				firstCompanyCar.setEmployeeGroupId(sapUser.getEmployeeGroupId());
				firstCompanyCar.setWorkingLocation(sapUser.getWorkLocation());
				firstCompanyCar.setEmail(sapUser.getEmail());
				firstCompanyCar.setOfficeSite(sapUser.getOfficeSite());
				firstCompanyCar.setMobilePhone(sapUser.getCellPhone());
				firstCompanyCar.setOfficePhone(sapUser.getContactNo());
				firstCompanyCar.setContractEndDate(sapUser.getContractEndDate());
				if(EmployeeSubGroupIDPersonalGradeEnum.getPgEnum(sapUser.getEmployeeSubgroupId()).compareTo(EmployeeSubGroupIDPersonalGradeEnum.PG3)>0) {
					isPGMaxOf29 = true;
				}
			}			
		}		
	}	
	
	PortletURL portletURL = renderResponse.createRenderURL();
	String employeeGroupId = firstCompanyCar!=null?firstCompanyCar.getEmployeeGroupId():"";
	String imageQueryPath = themeDisplay.getPathThemeImages()+"/diff/vgc_apon_my_applications_details.png";
	List<AuditTrailLog> auditTrailLogs = AuditTrailLogLocalServiceUtil.findAuditTrailByWF_O_O(firstCompanyCarId, FirstCompanyCar.class.getName());
	List<FileManagement> fileManagements = FileManagementLocalServiceUtil.getByAssetClassNameAndAssetPrimaryKey(FirstCompanyCar.class.getName(),firstCompanyCarId);
	String supportFileType = PropsUtil.get("vgc.apon.support.upload.file.type");
	String supportFileSize = PropsUtil.get("vgc.apon.support.upload.file.size");
%>

<portlet:renderURL var="viewFirstCompanyCartURL" />
<portlet:actionURL var="addFirstCompanyCarURL" windowState="normal" />

<portlet:resourceURL var="downloadURL" ></portlet:resourceURL>

<liferay-portlet:renderURL var="myApplicationsURL"
	plid="<%=myApplicationsPlid%>"
	portletName='<%=PropsUtil.get("vgc.apon.my.applications.portletId") %>'
	windowState="normal">
</liferay-portlet:renderURL>

<aui:model-context bean="<%=firstCompanyCar%>"
	model="<%=FirstCompanyCar.class%>" />

<aui:script>
	//When submit the form, there will be a workflow to enabled
	function <portlet:namespace />submitFirstCompanyCar() {
		if(!validateNotNull('email',1)) {
			return false;
		}else if(!validateEmailFormat(document.getElementById("email").value)) {
			alert('<liferay-ui:message key="vgc.apon.email.format.is.not.right" />');
			return false;
		}
		if(!validateNotChooseOfDrivingLicenseInformation()||!validateNotNull('expectedCarModel',1)||!validateFileTypeAndSize()) {
			return false;
		} 	
		<portlet:namespace />setFileInfo();
		document.<portlet:namespace />fm1.<portlet:namespace />expectedCarModel2.value = document.getElementById('<portlet:namespace />'+'expectedCarModel').value;
		document.<portlet:namespace />fm1.<portlet:namespace /><%= Constants.CMD %>.value = "<%= Constants.PUBLISH %>";
		submitForm(document.<portlet:namespace />fm1);	
	}
	
	//Save the form data and not enable the workflow
	function <portlet:namespace />saveFirstCompanyCar() {
		if(!validateNotNull('email',1)) {
			return false;
		}else if(!validateEmailFormat(document.getElementById("email").value)) {
			alert('<liferay-ui:message key="vgc.apon.email.format.is.not.right" />');
			return false;
		}
		if(!validateNotChooseOfDrivingLicenseInformation()||!validateNotNull('expectedCarModel',1)||!validateFileTypeAndSize()) {
			return false;
		} 
		<portlet:namespace />setFileInfo();
		document.<portlet:namespace />fm1.<portlet:namespace />expectedCarModel2.value = document.getElementById('<portlet:namespace />'+'expectedCarModel').value;
		document.<portlet:namespace />fm1.<portlet:namespace /><%= Constants.CMD %>.value = "<%= (firstCompanyCar == null || firstCompanyCar.getFirstCompanyCarId()==0 ) ? Constants.ADD : Constants.UPDATE %>";
		submitForm(document.<portlet:namespace />fm1);
	}
	
	//When the childNumber changed,Refresh the page
	function <portlet:namespace />changeChildNumber(obj) {
		var staffCode2 = document.<portlet:namespace />fm1.<portlet:namespace />staffCode2.value;
		document.<portlet:namespace />fm3.<portlet:namespace />staffCode2.value = staffCode2;
		var staffCodeDiv2 = document.getElementById("staffCodeDiv2");
		var isApplicantAgent = '1';
		if(staffCodeDiv2.style.display=="none") {
			isApplicantAgent = '0';
		}		
		document.<portlet:namespace />fm3.<portlet:namespace />isApplicantAgent2.value = isApplicantAgent;	
		document.<portlet:namespace />fm3.<portlet:namespace />childrenNumber.value = obj.value;		
		submitForm(document.<portlet:namespace />fm3);		
	}
	
	//Show the warn window of upload attachment list
	function <portlet:namespace/>showUploadWarnWindow(obj) {
		if(obj.checked) {
			var warnInfo = '<liferay-ui:message key="vgc.apon.please.upload.your.chinese.driving.license.into.the.attachment.list" />';
			alert(warnInfo);
		}
	}
	
	//validate the DrivingLicenseInformation is not choose
	function validateNotChooseOfDrivingLicenseInformation() {
		var portletNamespace = '<portlet:namespace/>';
		var radios = document.getElementsByName(portletNamespace + 'drivingLicenseInformation');
		var isChoose = false;
		for(var i=0;i<radios.length;i++) {
			if(radios[i].checked) {
				isChoose = true;
				break;
			}			
		}
		if(!isChoose) {
			var prefix = '<liferay-ui:message key="vgc.apon.please.choose.the" />';
			var surfix = '<liferay-ui:message key="vgc.apon.first.company.car.driving.license.information" />';
			surfix = surfix.substring(0, surfix.lastIndexOf('*'));
			alert(prefix+" "+surfix);
			return false;
		}		
		return true;
	}
	
	//validate the field is not null
	function validateNotNull(inputId, tdIndex) {
		var portletNamespace = '<portlet:namespace/>';
		var inputElement = document.getElementsByName(portletNamespace + inputId)
				.item(0)
		var trNode = inputElement.parentNode.parentNode;
		var inputLabel = trNode.childNodes[tdIndex].innerHTML;
		inputLabel = inputLabel.substring(0, inputLabel.lastIndexOf('*'));
		var prefix = '<liferay-ui:message key="vgc.apon.please.fill.the" />';
		if (inputElement.value == null || inputElement.value == '') {
			alert(prefix +" "+ inputLabel+"!");
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
		var downloadUrl = '<%=downloadURL %>' + '&<portlet:namespace />cmd=download&<portlet:namespace />fileName='+fileName+'&<portlet:namespace />filePath='+filePath;		
		window.location.href = downloadUrl;
	}
	
	var now = new Date();
	var current_time = now.getDate()+"."+(now.getMonth()+1)+"."+now.getFullYear()+" "+now.getHours()+":"+now.getMinutes();
		
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
		 a0.appendChild(document.createTextNode("<liferay-ui:message key='vgc.apon.company.car.upload' />"));
		 li3.appendChild(a0);
		 li3.appendChild(document.createTextNode("  "));
		 var a1 = document.createElement("a");
		 a1.setAttribute("href", "#");	
		 a1.setAttribute("onclick", "<portlet:namespace/>removeFile(parentNode.parentNode)");
		 a1.appendChild(document.createTextNode("<liferay-ui:message key='vgc.apon.company.car.delete' />"));
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
	
	//Validate the file type and size is right
	function validateFileTypeAndSize() {
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
				var fileType = (fileName.substring(fileName.lastIndexOf(".")+1,fileName.length)).toLowerCase();
				if(supportFileType.indexOf(fileType, 0)==-1) {
					alert('Only support the '+supportFileType+' attachments!');
					flag = false;
					break;
				}
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
	
	//When the employee is on behalf of the applicant,display the query button
	function <portlet:namespace />applicantAgentClick(obj) {
		document.<portlet:namespace />applicantAgentForm.<portlet:namespace />isApplicantAgent.value = obj.checked;
		submitForm(document.<portlet:namespace />applicantAgentForm);
	}
</aui:script>

<!--  First company car applicant page -->
<aui:form name="fm1" method="POST" action="<%=addFirstCompanyCarURL%>"
	enctype="multipart/form-data">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="<%=redirect%>" />
		<aui:input name="<%=Constants.CMD%>" type="hidden" />
		<aui:input type="hidden" name="firstCompanyCarId"
			value='<%=firstCompanyCarId%>' id="firstCompanyCarId"/>
		<aui:input type="hidden" name="transitionName"
			value='<%=transitionName%>' />
		<aui:input type="hidden" name="expectedCarModel2"/>		
		<aui:input type="hidden" name="existTitles"/>	
		<aui:input type="hidden" name="newTitles"/>	
		<aui:input type="hidden" name="existFileIds"/>	
	</aui:fieldset>

	<div class="mainbody">
		<div class="topButton">
			<aui:button-row>
				<aui:button type="button" value="vgc.apon.button.company.car.save"
					onClick='<%= renderResponse.getNamespace() + "saveFirstCompanyCar()" %>' />
				<aui:button type="button" value="vgc.apon.button.submit"
					onClick='<%= renderResponse.getNamespace() + "submitFirstCompanyCar()" %>' />
				<aui:button type="cancel" value="vgc.apon.button.back"
					onClick='<%= myApplicationsURL %>' />
			</aui:button-row>
		</div>
		<div class="tabTitle">
			<h3>
				<liferay-ui:message
					key="vgc.apon.first.company.car.ordering.replacement.form"/>
			</h3>
			<div class="Ltext"></div>
			<div class="tickerNo">
				<liferay-ui:message key="vgc.apon.first.company.car.ticket.no" />
				<span class="num"><%=firstCompanyCar.getTicketNo()%></span>
			</div>
			<div class="clear"></div>
		</div>
		<div class="gernal employeeInfo">
			<div class="subtitle">
				<liferay-ui:message
					key="vgc.apon.first.company.car.employee.information" />
				<%if(isHasAppliantAgent) {
				%>
				<input type="checkbox" name="<portlet:namespace/>isApplicantAgent"
					value='<%=true %>' <%=firstCompanyCar.getIsApplicantAgent()?"checked='checked'":"" %>
					onclick='<%=renderResponse.getNamespace() + "applicantAgentClick(this)"%>'/>
				<liferay-ui:message key="vgc-apon-on-behalf-of-x" arguments="<%=agentName %>"/>
				<%	
				} 
				%>
			</div>
			<ul>
				<li class="md01"><liferay-ui:message
						key="vgc.apon.first.company.car.name" /></li>
				<li class="md02"><input type="text"
					name="<portlet:namespace/>name" disabled="disabled" maxlength="75"
					value="<%=firstCompanyCar.getName()%>"></li>
				<li class="md01"><liferay-ui:message
						key="vgc.apon.first.company.car.staff.code" /></li>
				<li class="md022">
					<input id="<portlet:namespace />staffCode" type="text" 
						name="<portlet:namespace/>staffCode" readonly="readonly" maxlength="75"
						value="<%=firstCompanyCar.getStaffCode()%>" />
				</li>
			</ul>
			<ul>
				<li class="md01"><liferay-ui:message
						key="vgc.apon.first.company.car.company" /></li>
				<li class="md02"><input type="text" name="<portlet:namespace/>companyName" maxlength="75"
							value='<%=firstCompanyCar.getCompanyName()%>' disabled="disabled">
				</li>
				<li class="md01"><liferay-ui:message
						key="vgc.apon.first.company.car.division" /></li>
				<li class="md022"><input type="text" name="<portlet:namespace/>division"
							disabled="disabled"  maxlength="75"
							value="<%=firstCompanyCar.getDivision()%>"></li>
			</ul>
			<ul>
				<li class="md01"><liferay-ui:message
						key="vgc.apon.first.company.car.department" /></li>
				<li class="md02"><input type="text" name="<portlet:namespace/>department"
							disabled="disabled"  maxlength="75"
							value="<%=firstCompanyCar.getDepartment()%>"></li>
				<li class="md01"><liferay-ui:message
						key="vgc.apon.first.company.car.cost.center" /></li>
				<li class="md022"><input type="text" maxlength="75"
							name="<portlet:namespace/>positionCostCenterId" disabled="disabled"
							value="<%=firstCompanyCar.getPositionCostCenterId()%>"></li>
			</ul>
			<ul>
				<li class="md01"><liferay-ui:message
						key="vgc.apon.first.company.car.contract.type" /></li>
				<li class="md02"><input type="text" maxlength="75"
								name="<portlet:namespace/>employeeGroupId" disabled="disabled"
								value="<%=ContractTypeEnum.getName(firstCompanyCar.getEmployeeGroupId())%>"/>
				</li>
				<li class="md01"><liferay-ui:message
						key="vgc.apon.first.company.car.working.contract.end.date" /></li>
				<li class="md022"><input type="text" name="<portlet:namespace/>contractEndDate"
							disabled="disabled"  maxlength="75"
							value="<%=firstCompanyCar.getContractEndDate()==null?"":sdf_dmy.format(firstCompanyCar.getContractEndDate())%>"></li>
			</ul>
			<ul>
				<li class="md01"><liferay-ui:message
						key="vgc.apon.first.company.car.work.location" /></li>
				<li class="md02"><select
					name="<portlet:namespace/>workingLocation">
						<%
									String workingLocation = firstCompanyCar.getWorkingLocation();
									for (WorkLocationEnum wk : WorkLocationEnum.values()) {
											String selected = "";	
											if (workingLocation!=null && workingLocation.equals(wk.getIndex())) {
												selected = "selected='selected'";
											}
								%>
						<option <%=selected%> value="<%=wk.getIndex()%>"><%=wk.getName()%></option>
						<%
									}
								%>
				</select></li>
				<li class="md01"><liferay-ui:message
						key="vgc.apon.first.company.car.office.site" /></li>
				<li class="md022"><select name="<portlet:namespace/>officeSite">
						<%
									String officeSite = firstCompanyCar.getOfficeSite();
									for (OfficeSiteEnum officeSiteEnum : OfficeSiteEnum.values()) {
										String selected = "";	
											if (officeSite!=null && officeSite.equals(officeSiteEnum.getIndex())) {
												selected = "selected='selected'";
											}
								%>
						<option <%=selected%> value="<%=officeSiteEnum.getIndex()%>"><%=officeSiteEnum.getName()%></option>
						<%
									}
								%>
				</select></li>
			</ul>
			<ul>
				<li class="md01"><liferay-ui:message
						key="vgc.apon.first.company.car.mobile.phone" /></li>
				<li class="md02"><input type="text"
					id="<portlet:namespace/>mobilePhone" maxlength="75"
					name="<portlet:namespace/>mobilePhone"
					value="<%=firstCompanyCar.getMobilePhone()%>" required="required"></li>
				<li class="md01"><liferay-ui:message
						key="vgc.apon.first.company.car.office.phone" /></li>
				<li class="md022"><input type="text" 
					name="<portlet:namespace/>officePhone" maxlength="75"
					value="<%=firstCompanyCar.getOfficePhone()%>" required="required" /></li>
			</ul>
			<ul>
				<li class="md01"><liferay-ui:message
						key="vgc.apon.first.company.car.email" /></li>
				<li class="md02"><input type="text" id="email"
					name="<portlet:namespace/>email" maxlength="75"
					value="<%=firstCompanyCar.getEmail()%>" required="required"></li>
				<li class="md01"><liferay-ui:message
						key="vgc.apon.first.company.car.children.number" /></li>
				<li class="md022"><input type="text" name="<portlet:namespace/>childrenNumber" maxlength="75"
							onChange='<%=renderResponse.getNamespace() + "changeChildNumber(this);"%>'
							value="<%=firstCompanyCar.getChildrenNumber()%>" disabled="disabled"></li>
			</ul>
			<ul>
				<li class="md01"><liferay-ui:message
						key="vgc.apon.first.company.car.driving.license.information" /></li>
				<li class="md02"><input type="radio"
					name="<portlet:namespace/>drivingLicenseInformation" value="0"
					<%=firstCompanyCar.getDrivingLicenseInformation()==0?"checked='checked'":"" %>
					onclick="<portlet:namespace/>showUploadWarnWindow(this)"> <liferay-ui:message
						key="vgc.apon.first.company.car.valid.chinese.drive.license" /></li>
				<li class="md01"></li>
				<li class="md022"></li>
			</ul>
			<ul>
				<li class="md01"></li>
				<li class="md02"><input type="radio"
					name="<portlet:namespace/>drivingLicenseInformation" value="1"
					<%=firstCompanyCar.getDrivingLicenseInformation()==1?"checked='checked'":"" %>>
					<liferay-ui:message key="vgc.apon.first.company.car.private.driver" /></li>
				<li class="md01"></li>
				<li class="md022"></li>
			</ul>
			<ul>
				<li class="md01"></li>
				<li class="md02"><input type="radio"
					name="<portlet:namespace/>drivingLicenseInformation" value="2"
					<%=firstCompanyCar.getDrivingLicenseInformation()==2?"checked='checked'":"" %>>
					<liferay-ui:message
						key="vgc.apon.first.company.car.chinese.driving.license.not.yet.obtained" />
				</li>
				<li class="md01"><liferay-ui:message
						key="vgc.apon.first.company.car.estimated.obtaining.date" /></li>
				<li class="md022"><input
					id="<portlet:namespace/>estimatedObtainingDate" class="Wdate"
					type="text" maxlength="75"
					value="<%=firstCompanyCar.getEstimatedObtainingDate()!=null?sdf_dmy.format(firstCompanyCar.getEstimatedObtainingDate()):"" %>"
					name="<portlet:namespace/>estimatedObtainingDate"
					onFocus="WdatePicker({lang:'en',dateFmt:'dd.MM.yyyy'})" /></li>
				</ul>
				<ul>
					<li class="md01"></li>
					<li class="md03 remark"><liferay-ui:message
							key="vgc.apon.first.company.car.car.rental.fee.info" /></li>
				</ul>
				<ul class="txt">
					<li class="md01 warning"><liferay-ui:message
							key="vgc.apon.first.company.car.if.apply.before.rehiring.please.add.comments" /></li>
					<li class="md03">
						<textarea rows="4"
						onblur="if (value ==''){value='If you plan to change the working location during your assignment, please list the different working locations including the working duration at each location.'}"
							onfocus="if(value=='If you plan to change the working location during your assignment, please list the different working locations including the working duration at each location.'){value=''}"
							name="<portlet:namespace/>comments" required="required" style="font-style: italic;"><%=Validator.isNull(firstCompanyCar.getComments())?"If you plan to change the working location during your assignment, please list the different working locations including the working duration at each location.":firstCompanyCar.getComments()%></textarea>
					</li>
				</ul>
		</div>
		<div class="gernal carInfo">
			<div class="subtitle">
				<liferay-ui:message
					key="vgc.apon.first.company.car.current.car.information" />
			</div>
			<ul>
				<li class="md01"><liferay-ui:message
						key="vgc.apon.first.company.car.current.car.car.model" /></li>
				<li class="md02"><input type="text"
					name="<portlet:namespace/>currentCarModel" maxlength="75"
					value="<%=firstCompanyCar.getCurrentCarModel()%>"></li>
				<li class="md01"><liferay-ui:message
						key="vgc.apon.first.company.car.current.car.color" /></li>
				<li class="md022"><input type="text"
					name="<portlet:namespace/>currentCarColor" maxlength="75"
					value="<%=firstCompanyCar.getCurrentCarColor()%>"></li>
			</ul>
			<ul>
				<li class="md01"><liferay-ui:message
						key="vgc.apon.first.company.car.current.car.plate.number" /></li>
				<li class="md02"><input type="text"
					name="<portlet:namespace/>currentPlateNumber" maxlength="75"
					value="<%=firstCompanyCar.getCurrentPlateNumber()%>"></li>
				<li class="md01"><liferay-ui:message
						key="vgc.apon.first.company.car.current.car.acquiring.date" /></li>
				<li class="md022"><input id="<portlet:namespace/>acquiringDate"
					class="Wdate" type="text" name="<portlet:namespace/>acquiringDate" 
					value="<%=firstCompanyCar.getAcquiringDate()!=null?sdf_dmy.format(firstCompanyCar.getAcquiringDate()):"" %>"
					onFocus="WdatePicker({lang:'en',dateFmt:'dd.MM.yyyy'})" /></li>
			</ul>
		</div>
		<div class="gernal expectedCompy">
			<div class="subtitle">
				<liferay-ui:message
					key="vgc.apon.first.company.car.expected.company.car.infomation" />
			</div>

			<ul>
				<li class="md01"><liferay-ui:message
						key="vgc.apon.first.company.car.expected.car.car.model" /></li>
				<li class="md02"><input type="text"
					id="<portlet:namespace/>expectedCarModel"
					name="<portlet:namespace/>expectedCarModel"
					value="<%=firstCompanyCar.getExpectedCarModel()%>" maxlength="75"
					required="required" disabled="disabled"/> <!-- onclick="validateNotNull('email',1)" -->
					<%if( "4".equals(employeeGroupId) || "6".equals(employeeGroupId) || (("1".equals(employeeGroupId) || "5".equals(employeeGroupId))&& isPGMaxOf29)) { %>							
								<liferay-ui:icon
									id="selectCarLink" label="<%=true%>" message="" method="get"
									url="javascript:;" src="<%=imageQueryPath%>"/>
							<%} %>
				</li>
				<li class="md01"><liferay-ui:message
						key="vgc.apon.first.company.car.expected.car.color" /></li>
				<li class="md022"><input
					id="<portlet:namespace/>expectedCarColor" type="text"
					name="<portlet:namespace/>expectedCarColor" maxlength="75"
					value="<%=firstCompanyCar.getExpectedCarColor()%>" />
					</li>
			</ul>
			<ul class="rmark">
				<li class="md01"><liferay-ui:message
						key="vgc.apon.first.company.car.preference.for.last.digit.of.plate.number" /></li>
				<li class="md02"><input type="text"
					name="<portlet:namespace/>expectedLastPlateNumber"  maxlength="75"
					value="<%=firstCompanyCar.getExpectedLastPlateNumber()%>" /></li>
				<li class="md04 remark"><liferay-ui:message
						key="vgc.apon.first.company.car.remark.info" /></li>
			</ul>
		</div>
		<!-- **************************************************************Upload the attachments start...******************************************************************************************* -->
		
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
					<%for(FileManagement fileManagement:fileManagements) {
						%>
						<ul class="std0">
							<li class="od01">
								<input type="text" name="<portlet:namespace/>fileManagementFileName" value="<%=fileManagement.getTitle()%>" maxlength="75" />
								<input type="hidden" name="<portlet:namespace/>fileManagementId" value="<%=fileManagement.getFileManagementId()%>"/>
							</li>
							<li class="od02"><a href="#" onclick='<portlet:namespace />download("<%=fileManagement.getFileName()%>","<%=fileManagement.getFilePath()%>")'><%=fileManagement.getFileName()%></a></li>
							<li class="od01"><%=sdf.format(fileManagement.getCreateDate())%></li>
							<li class="od01 lcol upd">
								<a href="#" onclick="<portlet:namespace/>addFile()"><liferay-ui:message key="vgc.apon.company.car.upload" /></a>&nbsp;
								<a href="#" onclick="<portlet:namespace/>removeFile(parentNode.parentNode)"><liferay-ui:message key="vgc.apon.company.car.delete" /></a>
							</li>
						</ul>
						<%
					} %>
				</div>						
				<div id="<portlet:namespace/>fileDiv">
					<ul class="std0">
						<li class="od01"><input type="text" name="<portlet:namespace/>attachmentName" maxlength="75"/></li>
						<li class="od02"><input type="file" name="<portlet:namespace/>fileName"/></li>
						<li class="od01"></li>
						<li class="od01 lcol upd" >
							<a href="#" onclick="<portlet:namespace/>addFile()"><liferay-ui:message key="vgc.apon.company.car.upload" /></a>
							<a href="#" onclick="<portlet:namespace/>removeFile(parentNode.parentNode)"><liferay-ui:message key="vgc.apon.company.car.delete" /></a>
						</li>
					</ul>
				</div>
			</div>
			 	<p style="padding-left:10px;padding-top: 30px;font-style:italic; color: red;"><liferay-ui:message key="vgc.apon.company.car.attachments.notes" /></p>
		</div>
		<!-- **************************************************************Upload the attachments end...******************************************************************************************* -->

		<div class="approvalStatusInfo"
			style='display: <%=auditTrailLogs.size()>0?"block":"none"%>'>
			<div class="subtitle">
				<liferay-ui:message
							key="vgc.apon.audit.trail.log.approval.status.information" />
			</div>
			<div class="gridtb">
				<ul>
					<li class="od03"><liferay-ui:message
							key="vgc.apon.audit.trail.log.no" /></li>
					<li class="od04"><liferay-ui:message
							key="vgc.apon.audit.trail.log.approver.applicant.role" /></li>
					<li class="od04"><liferay-ui:message
							key="vgc.apon.audit.trail.log.approver.applicant" /></li>
					<li class="od04"><liferay-ui:message
							key="vgc.apon.audit.trail.log.action.status" /></li>
					<li class="od04"><liferay-ui:message
							key="vgc.apon.audit.trail.log.time" /></li>
					<li class="od04 lcol"><liferay-ui:message
							key="vgc.apon.audit.trail.log.comment" /></li>
				</ul>
				<%
					for(int i=0;i<auditTrailLogs.size();i++) {
									AuditTrailLog auLog = auditTrailLogs.get(i);
				%>
				<ul class="std">
					<li class="od03"><%=i+1%></li>
					<li class="od04"><%=auLog.getOperationRole()%></li>
					<li class="od04"><%=auLog.getOperationUser()%></li>
					<li class="od04"><%=auLog.getOperationStatus()%></li>
					<li class="od04"><%=auLog.getOperationTime()==null?"":sdf.format(auLog.getOperationTime())%></li>
					<li class="od04 lcol"><%=auLog.getOperationComment()%></li>
				</ul>
				<%
					}
				%>
			</div>
		</div>
		<div class="nextbtn">
			<aui:button-row>
				<aui:button type="button" value="vgc.apon.button.company.car.save"
					onClick='<%= renderResponse.getNamespace() + "saveFirstCompanyCar()" %>' />
				<aui:button type="button" value="vgc.apon.button.submit"
					onClick='<%= renderResponse.getNamespace() + "submitFirstCompanyCar()" %>' />
				<aui:button type="cancel" value="vgc.apon.button.back"
					onClick='<%= myApplicationsURL %>' />
			</aui:button-row>
		</div>
	</div>
	
</aui:form>

<portlet:actionURL name="applicantAgent" var="applicantAgentURL" >
	<portlet:param name="mvcPath" value="/html/firstCar/view.jsp"/>
</portlet:actionURL>

<aui:form action="<%=applicantAgentURL%>" method="post" name="applicantAgentForm">
	<aui:fieldset>
		<aui:input name="firstCompanyCarId" type="hidden" value="<%=firstCompanyCarId %>"/>
		<aui:input name="isApplicantAgent" type="hidden" />
	</aui:fieldset>
</aui:form>

<aui:form action="<%=portletURL%>" method="post" name="fm3">
	<aui:fieldset>
		<aui:input name="staffCode2" type="hidden" />
		<aui:input name="isApplicantAgent2" type="hidden" />
		<aui:input name="childrenNumber" type="hidden" />
	</aui:fieldset>
</aui:form>

<!-- Open the Car select page -->
<aui:script use="liferay-search-container">
	var selectCarLink = A.one('#<portlet:namespace />selectCarLink');
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
						id: '<portlet:namespace />selectCar',
						title: '<liferay-ui:message arguments="vgc.apon.car" key="select-x" />',
						uri:'<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>"><portlet:param name="mvcPath" value="/html/admin/select_car.jsp" /><portlet:param name="childrenNumber" value="<%=String.valueOf(firstCompanyCar.getChildrenNumber())%>" /><portlet:param name="staffCode" value="<%=String.valueOf(firstCompanyCar.getStaffCode())%>" /><portlet:param name="carType" value="<%= CompanyCarConstants.FIRST_COMPANY_CAR%>" /></portlet:renderURL>'
					},
					function(event) {
						document.getElementById('<portlet:namespace />'+'expectedCarModel').value=event.carModel;
					}
				);
			}
		);
	}
</aui:script>
