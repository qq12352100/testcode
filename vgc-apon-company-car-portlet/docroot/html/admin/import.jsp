<%@include file="/html/init.jsp"%>

<%
	String eventName = ParamUtil.getString(request, "eventName", liferayPortletResponse.getNamespace() + "ImportCompanyCarManagement");
	String supportFileType = PropsUtil.get("vgc.apon.support.import.excel.file.type");
%>

<aui:script>
	function <portlet:namespace/>cancel(){
		var Util = Liferay.Util;
		Util.getWindow().destroy();
	}
	
	window.onload=function(){
		var buttons=parent.document.getElementsByTagName("button");
		for(var i=0;i<buttons.length;i++){		
			if(buttons[i].className!=null&&buttons[i].className.indexOf("btn close")!=-1){		
				buttons[i].onclick = function(){			
					var Util = Liferay.Util;				
					Util.getWindow().destroy();
				} 
			}
		}
	}
</aui:script>

<portlet:actionURL var="importCarCategoryURL" name="upload" windowState="normal" />

<aui:form action="<%=importCarCategoryURL%>" method="post" enctype="multipart/form-data" name="importFm">
	<aui:fieldset>
		<aui:input name="cars"
			label="vgc.apon.please.choose.you.want.to.upload.form" type="file"></aui:input>
		
		<div class="cetBtn">
			<aui:button-row>
				<aui:button style="margin-right:20px;" cssClass="selector-button"
					value="vgc.apon.button.confirm" />
 				<aui:button type="cancel"
					onClick='<%=renderResponse.getNamespace()+ "cancel();"%>'
					name="vgc.apon.button.back" />
			</aui:button-row>
		</div>
	</aui:fieldset>
</aui:form>


<aui:script use="aui-base">
	var Util = Liferay.Util;
	A.one('#<portlet:namespace />importFm').delegate(
		'click',
		function(event) {			
			var supportFileType = '<%=supportFileType%>';
			var importFile = document.<portlet:namespace />importFm.<portlet:namespace />cars;
			var fileName = importFile.value;
			if(fileName!=null && fileName !=""){
				var fileType = (fileName.substring(fileName.lastIndexOf(".")+1,fileName.length)).toLowerCase();
				if(supportFileType.indexOf(fileType, 0)==-1) {
					alert('Only support the '+supportFileType+' attachments!');
					return false;
				}
			}else {
				alert('Please choose one file at least!');
				return false;
			}			
			var result={};
			submitForm(document.<portlet:namespace/>importFm);
			Util.getOpener().Liferay.fire('<%= HtmlUtil.escapeJS(eventName) %>',result);
			Util.getWindow().destroy();
		},
		'.selector-button'
	);
</aui:script>
