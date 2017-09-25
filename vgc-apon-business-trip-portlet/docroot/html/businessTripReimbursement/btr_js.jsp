<%@include file="/html/init.jsp"%>
<%
String businessTripReimbursementid  = request.getParameter("businessTripReimbursement");
String businessTripApplicationid  = request.getParameter("businessTripApplication");
System.out.println("businessTripReimbursementid:"+businessTripReimbursementid);
String supportFileType = request.getParameter("supportFileType");
System.out.println("supportFileType111:"+request.getParameter("supportFileType"));
String supportFileSize = request.getParameter("supportFileSize");
String importFileType = request.getParameter("importFileType");
String importError = request.getParameter("importError");
//String myApplicationsPlid = request.getParameter("myApplicationsPlid");
String prefixUrl = "/web"+themeDisplay.getScopeGroup().getFriendlyURL();	 
String myApplicationsPageUrl = prefixUrl+PropsUtil.get("vgc.apon.my.applications.page.friendly.url");
	long myApplicationsPlid = PortalUtil.getPlidFromFriendlyURL(
	themeDisplay.getCompanyId(),myApplicationsPageUrl);

if(Validator.isNotNull(businessTripReimbursementid)){
	BusinessTripReimbursement businessTripReimbursement = BusinessTripReimbursementLocalServiceUtil.getBusinessTripReimbursement(Long.parseLong(businessTripReimbursementid));
}

if(Validator.isNotNull(businessTripApplicationid)){
	BusinessTripApplication businessTripApplication = BusinessTripApplicationLocalServiceUtil.getBusinessTripApplication(Long.parseLong(businessTripApplicationid));
}
long sCode = themeDisplay.getUser().getFacebookId();
List<com.cardholder.model.CardHolder> cardHolderList=CardHolderLocalServiceUtil.findBystaffcode(Long.toString(sCode),-1,-1);
boolean isCardHolder=false;
if(cardHolderList.size()>0){
	isCardHolder=true;
	
}
System.out.println("isCardHolder"+isCardHolder);
%>
<portlet:resourceURL var="downloadURL"></portlet:resourceURL>
<liferay-portlet:renderURL var="openBusinessTripApplicationURL"
	windowState="normal" plid="<%=myApplicationsPlid%>"
	portletName="mysubmissionslist_WAR_vgcaponmysubmissionsportlet">
	<liferay-portlet:param name="mvcPath"
		value="/html/mysubmissionslist/details/business_trip_application_details.jsp" />
	<liferay-portlet:param name="pkId"
		value='<%=businessTripApplicationid!=null?String.valueOf(businessTripApplicationid):"0"%>' />
	<liferay-portlet:param name="tabs2" value="completed" />
</liferay-portlet:renderURL>

<aui:script>
	//When submit the form, there will be a workflow to enabled
	function <portlet:namespace />submitBusinessTripReimbursement() {
		if(!validateFileTypeAndSize()) {
			return false;
		} 
		var bussinessTirpTicketNo=document.getElementById('bussinessTirpTicketNo').value;
		if(bussinessTirpTicketNo==null||bussinessTirpTicketNo==""){
			alert("Please select bussiness trip ticket");
			return false;
		}
		 var fileNames = document.getElementsByName('<portlet:namespace/>fileName');
		var fileFlag = true;
		for(var i=0;i<fileNames.length;i++) {
			var obj_file = fileNames[i];
			var fileName = obj_file.value;
			if(fileName!=null && fileName !=""){
				fileFlag = false;
				break;
			}
		}	
		var isCardHolder = "<%=isCardHolder%>"
		if(isCardHolder=="true"){
			if(fileFlag){
				alert("Please upload your bank attachment.");
				return false;
			}
			
		}	 
		<portlet:namespace />setFileInfo();
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= Constants.PUBLISH %>";
		submitForm(document.<portlet:namespace />fm);	
	}
	function <portlet:namespace />openBtApplicationDetail() {
		var downloadUrl = '<%=openBusinessTripApplicationURL %>';		
		window.location.href = downloadUrl; 
	}
	//Save the form data and not enable the workflow
	function <portlet:namespace />saveBusinessTripReimbursement() {
		if(!validateFileTypeAndSize()) {
			return false;
		} 
		<portlet:namespace />setFileInfo();
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= (Validator.isNotNull(businessTripReimbursementid)) ? Constants.ADD : Constants.UPDATE %>";
		submitForm(document.<portlet:namespace />fm);
	}
	function <portlet:namespace />importItinerary(){
		var fileInput = document.getElementById("pdfImport");
		fileInput.click();
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
		document.<portlet:namespace />fm.<portlet:namespace />existTitles.value = existTitles;			
		
		var newTitles = '';
		for(var i=0;i<attachmentNames.length;i++) {
			var temp = attachmentNames[i].value;
			if(temp==null || temp=='') {
				temp = 'XXX';
			}
			newTitles += temp+',';
		}
		document.<portlet:namespace />fm.<portlet:namespace />newTitles.value = newTitles;		
		
		var existFileIds = '';
		for(var i=0;i<fileManagementIds.length;i++) {
			var temp = fileManagementIds[i].value;
			if(temp==null || temp=='') {
				temp = 'XXX';
			}
			existFileIds += temp+',';			
		}
		document.<portlet:namespace />fm.<portlet:namespace />existFileIds.value = existFileIds;	
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
		 a0.appendChild(document.createTextNode("<liferay-ui:message key='vgc.apon.button.add' />"));
		 li3.appendChild(a0);
		 li3.appendChild(document.createTextNode("  "));
		 var a1 = document.createElement("a");
		 a1.setAttribute("href", "#");	
		 a1.setAttribute("onclick", "<portlet:namespace/>removeFile(parentNode.parentNode)");
		 a1.appendChild(document.createTextNode("<liferay-ui:message key='vgc.apon.button.delete' />"));
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
	
	//Update the detail info
	function <portlet:namespace/>update(updateUrl,tabs2) {
		var w = 1200;
		var h = 300;
		if(tabs2=='hotelInformation'||tabs2=='travelExpense') {
			w = 1200;
			h = 550;
		}else if(tabs2=='carRental'){
			w = 1200;
			h = 400;
		}else if(tabs2=='costList'){
			w = 1200;
			h = 450;			
		}else if(tabs2=='entertainment'){
			Liferay.Util.selectEntity(
					{
						dialog: {
							constrain: true,
							modal: true,
							width:1400,
							height:690
						},
						id: '<portlet:namespace />AddEntertainmentItem',
						title: '<liferay-ui:message  key="vgc-apon-update"/>',
						uri:updateUrl
					},
					function(event) {	
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />pkId.value = event.pkId;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />tabs2.value = event.tabs2;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />businessTripReimbursementId.value = event.businessTripReimbursementId;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />btCostListId.value = event.btCostListId;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />entertainmentDate.value = event.entertainmentDate;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />entertainmentType.value = event.entertainmentType;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />entertainmentPlace.value = event.entertainmentPlace;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />countryCity.value = event.countryCity;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />btEntertainmentDetailId.value = event.btEntertainmentDetailId;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />fullName.value = event.fullName;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />positionTitle.value = event.positionTitle;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />company.value = event.company;						
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />reasonsInfo.value = event.reasonsInfo;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />paymentCurrency.value = event.paymentCurrency;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />amountTotal.value = event.amountTotal;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />averageSpend.value = event.averageSpend;					
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />attendeesTotal.value = event.attendeesTotal;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />mealCategory.value = event.mealCategory;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />isEntertainment.value ='true';
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />netAmount.value = event.netAmount;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />taxAmount.value = event.taxAmount;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />taxRate.value = event.taxRate;
						
						submitForm(document.<portlet:namespace/>addDetailInfoFm);						
					}
					
			);
			return false;
		}
		Liferay.Util.selectEntity(
				{
					dialog: {
						constrain: true,
						modal: true,
						width:w,
						height:h
					},
					id: '<portlet:namespace />AddBusinessTripReimbursement',
					title: '<liferay-ui:message  key="vgc-apon-update"/>',
					uri:updateUrl
				},
				function(event) {
					document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />pkId.value = event.pkId;
					document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />tabs2.value = event.tabs2;
					if(event.tabs2=='flight') {
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />fromCity.value = event.fromCity;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />toCity.value = event.toCity;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />departureDate.value = event.departureDate;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />departureFlight.value = event.departureFlight;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />classInfo.value = event.classInfo;
					}else if(event.tabs2=='train') {
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />fromCity.value = event.fromCity;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />toCity.value = event.toCity;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />departureDate.value = event.departureDate;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />departureTrain.value = event.departureTrain;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />classInfo.value = event.classInfo;
					}else if(event.tabs2=='hotelInformation') {					
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />city.value = event.city;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />cityType.value = event.cityType;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />hotel.value = event.hotel;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />checkIn.value = event.checkIn;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />checkOut.value = event.checkOut;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />roomCategory.value = event.roomCategory;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />price.value = event.price;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />currency.value = event.currency;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />isOverBudget.value = event.isOverBudget;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />otherReasonInfo.value = event.otherReasonInfo;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />isNotBookedFromTA.value = event.isNotBookedFromTA;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />othersSpecify.value = event.othersSpecify;
					}else if(event.tabs2=='carRental'){
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />pickupLocation.value = event.pickupLocation;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />pickupDate.value = event.pickupDate;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />dropoffLocation.value = event.dropoffLocation;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />dropoffDate.value = event.dropoffDate;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />carType.value = event.carType;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />typeOfRental.value = event.typeOfRental;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />carPrice.value = event.price;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />carCurrency.value = event.currency;		
					}else if(event.tabs2=='travelExpense'){// by wanghai
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />travelDate.value = event.travelDate;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />departure.value = event.departure;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />arrival.value = event.arrival;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />fromCity.value = event.fromCity;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />toCity.value = event.toCity;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />isHasBreakfast.value = event.isHasBreakfast;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />isHasLunch.value = event.isHasLunch;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />isHasDinner.value = event.isHasDinner;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />country.value = event.country;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />city.value = event.city;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />rateOfDma.value = event.rateOfDma;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />currency.value = event.currency;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />comments.value = event.comments;
					}else if(event.tabs2=='costList'){
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />item.value = event.item;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />btCostListId.value = event.btCostListId;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />costType.value = event.type;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />invoiceAmount.value = event.invoiceAmount;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />invoiceCurrency.value = event.invoiceCurrency;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />countryCity.value = event.countryCity;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />paymentCurrency.value = event.paymentCurrency;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />paymentAmount.value = event.paymentAmount;	
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />netAmount.value = event.netAmount;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />taxAmount.value = event.taxAmount;
						document.<portlet:namespace />addDetailInfoFm.<portlet:namespace />taxRate.value = event.taxRate;
					}
					submitForm(document.<portlet:namespace/>addDetailInfoFm);
				}
			);
	}
	

	
	window.onload=function(){
		var tohere=document.getElementById("tohere").value;
		if(tohere!=""){
			 location.hash="#toherediv";
		}
		var importError="<%=importError%>";
		if(importError!="null"&&importError!=""){
			if("true"==importError){
				alert("import flight PDF Success!");
			}else if("No"==importError){
				alert("Please  click  Checkmark button to check your Business Trip Application at first!");
			}else{
				alert("import flight PDF Error!");
			}	
		}
	}
</aui:script>

<aui:script use="liferay-search-container">
var searchBussinessTirpTicketNoLink = A.one('#<portlet:namespace />searchBussinessTirpTicketNo');
if (searchBussinessTirpTicketNoLink) {
	searchBussinessTirpTicketNoLink.on(
		'click',
		function(event) {
			Liferay.Util.selectEntity(
				{
					dialog: {
						constrain: true,
						modal: true
					},
					id: '<portlet:namespace />selectBusinessTripApplication',
					title: '<liferay-ui:message arguments="Business Trip Application" key="select-x" />',
					uri:'<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>"><portlet:param name="mvcPath" value="/html/businessTripReimbursement/select_businessTripApplication.jsp" /></portlet:renderURL>'
				},
				function(event) {
					document.<portlet:namespace/>searchBussinessTirpTicketNo.<portlet:namespace/>bussinessTirpTicketNo2.value=event.ticketNo;					
					var tripReimbursementId = document.getElementById('<portlet:namespace />businessTripReimbursementId');
					document.<portlet:namespace />searchBussinessTirpTicketNo.<portlet:namespace />businessTripReimbursementId2.value = tripReimbursementId.value;
					submitForm(document.<portlet:namespace/>searchBussinessTirpTicketNo);
				}
			);
		}
	);
}
</aui:script>

<aui:script>
$(function() {
	var radios = document.getElementsByName("<portlet:namespace/>tripType");
	var val;
	for (var i = 0; i < radios.length; i++) {
		if (radios[i].checked) {
			val = radios[i].value;
			CheckTripType(val);
		}
	}
});

function getElementsClass(classnames) {
	var classobj = new Array();
	var classint = 0;
	var tags = document.getElementsByTagName("li");
	for ( var i in tags) {
		if (tags[i].nodeType == 1) {
			if (tags[i].getAttribute("class") == classnames) {
				classobj[classint] = tags[i];
				classint++;
			}
		}
	}
	return classobj;
}
function getElementsUlClass(classnames) {
	var classobj = new Array();// 定义数组
	var classint = 0;// 定义数组的下标
	var tags = document.getElementsByTagName("ul");// 获取HTML的所有标签
	for ( var i in tags) {// 对标签进行遍历
		if (tags[i].nodeType == 1) {// 判断节点类型
			if (tags[i].getAttribute("class") == classnames)// 判断和需要CLASS名字相同的，并组成一个数组
			{
				classobj[classint] = tags[i];
				classint++;
			}
		}
	}
	return classobj;// 返回组成的数组
}

function CheckTripType(val) {
	var navs = getElementsUlClass("nav nav-tabs")[0].getElementsByTagName('li');
	var hotelandcar = document.getElementById("hotelandcar");
	var car = document.getElementById("car");
	if (navs.length > 0) {
		var ali = navs[navs.length - 3];
		if (val == 0) {
			if (ali.className == "tab active") {
				navs[0].getElementsByTagName('a')[0].click();
			}
			ali.style.display = "none";
			hotelandcar.style.display = "none";
			car.style.display = "none";
		} else {
			ali.style.display = "block";
			hotelandcar.style.display = "block";
			car.style.display = "block";
		}
	}
}
</aui:script>