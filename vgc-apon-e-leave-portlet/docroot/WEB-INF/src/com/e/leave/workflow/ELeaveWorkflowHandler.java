package com.e.leave.workflow;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

import com.e.leave.model.ELeave;
import com.e.leave.service.ELeaveLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.security.permission.ResourceActionsUtil;
import com.liferay.portal.service.ServiceContext;

public class ELeaveWorkflowHandler extends BaseWorkflowHandler {

	public String getClassName() {
		return CLASS_NAME;
	}

	public String getType(Locale locale) {
		return ResourceActionsUtil.getModelResource(locale, getClassName());
	}

	/**
	 * When the approver approved the workflow instance, updated the status
	 * @throws SystemException 
	 * @throws PortalException 
	 */
	public Object updateStatus(int status,
			Map<String, Serializable> workflowContext) throws PortalException, SystemException{

		long userId = GetterUtil.getLong((String) workflowContext
				.get(WorkflowConstants.CONTEXT_USER_ID));
		long eTransferId = GetterUtil.getLong((String) workflowContext
				.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

		ServiceContext serviceContext = (ServiceContext) workflowContext
				.get("serviceContext");

		return ELeaveLocalServiceUtil.updateStatus(userId,
				eTransferId, status, serviceContext);
	}

	public static final String CLASS_NAME = ELeave.class.getName();
}
