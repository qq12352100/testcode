<%@include file="/html/init.jsp"%>

<%
	String eventName = ParamUtil.getString(request, "eventName", liferayPortletResponse.getNamespace() + "AddDistribution");
%>
<aui:script>
	//Back to the list page
	function <portlet:namespace/>cancel(){
		var Util = Liferay.Util;
		Util.getWindow().destroy();
	}
	
	//Add the distribution
	function <portlet:namespace/>submitFm(){
		cancel();
		submitForm(document.<portlet:namespace/>fm);	
	}
	
	//validate the field is not null
	function validateNotNull(inputId, tdIndex) {
		var portletNamespace = '<portlet:namespace/>';
		var inputElement = document.getElementsByName(portletNamespace + inputId)
				.item(0)
		var trNode = inputElement.parentNode.parentNode;
		var inputLabel = '<liferay-ui:message key="vgc.apon.show.emailAddress" />';
		var prefix = '<liferay-ui:message key="vgc.apon.please.fill.the" />';
		if (inputElement.value == null || inputElement.value == '') {
			alert(prefix +" "+ inputLabel+"!");
			inputElement.focus();
			return false;
		} else {
			return true;
		}
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
	
<portlet:renderURL var="viewDistributionURL" />

<aui:form method="post" name="fm">
	<aui:fieldset>
		<div class="mainbody">
		    <div class="newtb">
		    	<ul>
		    	    <li class="nd02"><liferay-ui:message
								key="vgc.apon.show.emailAddress"></liferay-ui:message></li>
		    	    <li class="nd01"><liferay-ui:message
								key="vgc.apon.show.name"></liferay-ui:message></li>
		    	    <li class="nd03"><liferay-ui:message
								key="vgc.apon.show.comments"></liferay-ui:message></li>
		    	</ul>
		    	<ul>
		    	    <li class="nd02"><input type="text" name="<portlet:namespace/>emailAddress"
						id="emailAddress" value="" required="required" maxlength="75"/></li>
					<li class="nd01"><input type="text" name="<portlet:namespace/>name"
						id="name" value="" maxlength="75"/></li>
					<li class="nd03"><input type="text" name="<portlet:namespace/>comments"
						id="comments" value="" maxlength="75"/></li>
		    	</ul>
		    </div>
		</div>
		
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
	A.one('#<portlet:namespace />fm').delegate(
		'click',
		function(event) {
			var name=document.getElementById("name").value;
			var emailAddress=document.getElementById("emailAddress");
			if(!validateEmailFormat(emailAddress.value)) {
				alert("The emailAddress format is not right!");
				emailAddress.focus();
				return false;
			}
			var comments=document.getElementById("comments").value;
			var result={};
			result['name']=name;
			result['emailAddress']=emailAddress.value;
			result['comments']=comments;
			Util.getOpener().Liferay.fire('<%= HtmlUtil.escapeJS(eventName) %>',result);
			Util.getWindow().destroy();
		},
		'.selector-button'
	);
</aui:script>

