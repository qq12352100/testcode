package com.e.closing.workflow;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

import com.e.closing.model.EClosing;
import com.e.closing.service.EClosingLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.security.permission.ResourceActionsUtil;
import com.liferay.portal.service.ServiceContext;

/**
 * EClosing
 * @author t.a.jiang
 *
 */
public class EClosingWorkflowHandler extends BaseWorkflowHandler {
	
	public static final String CLASS_NAME = EClosing.class.getName();
	
	public static final boolean _VISIBLE = true;
	
	@Override
	public String getClassName() {
		return CLASS_NAME;
	}
	
	@Override
	public String getType(Locale locale) {
		return ResourceActionsUtil.getModelResource(locale, getClassName());
	}
	
	@Override
	public Object updateStatus(int status, Map<String, Serializable> workflowContext) throws PortalException, SystemException {
		long userId = GetterUtil.getLong((String)workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
		long eInvitationId = GetterUtil.getLong((String)workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));
		ServiceContext serviceContext = (ServiceContext)workflowContext.get("serviceContext");
		return EClosingLocalServiceUtil.updateStatus(userId,eInvitationId, status, serviceContext);
	}

}
