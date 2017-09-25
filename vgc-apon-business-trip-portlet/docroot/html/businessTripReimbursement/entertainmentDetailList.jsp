<%@include file="/html/init.jsp"%>
<!-- this is for costList start -->
<aui:form method="post" name="fm">
		<div class="mainbody">
			<div>
			    <ul>
			     <li>
		    	 Please apply through the General Reimbursement Module,Items Entertainment (external/internal)! <br /> <br />
		    	 </li>
		    	 </ul>
		     <ul>
			     <li>
		    	 <a href="#" onClick='<%=renderResponse.getNamespace()+ "toGR();"%>'>Go to GR, without closing this application</a>
		    	 </li>
		    	 </ul>
		    	 <br/>
		    </div>
		</div>	
		<div class="cetBtn">
			<aui:button-row>		        					
 			    <aui:button type="cancel"
 				   onClick='<%=renderResponse.getNamespace()+ "cancel();"%>'
					value="Ok" />
			</aui:button-row>
		</div>
</aui:form>
<aui:script>
function <portlet:namespace/>toGR(){
	 window.open("/aponv2/web/vcic/general-reimbursement?p_p_id=reimburseManager_WAR_vgcaponportlet&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&_reimburseManager_WAR_vgcaponportlet_jspPage=/page/reimburse/iWant/approvalWorkflow.jsp&_reimburseManager_WAR_vgcaponportlet_applyType=self");
		var Util = Liferay.Util;
		Util.getWindow().destroy();
}
//cancel
function <portlet:namespace/>cancel(){
	var Util = Liferay.Util;
	Util.getWindow().destroy();
}


</aui:script>