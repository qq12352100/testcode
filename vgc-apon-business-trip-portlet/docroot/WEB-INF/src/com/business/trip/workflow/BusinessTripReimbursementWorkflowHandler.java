package com.business.trip.workflow;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

import com.business.trip.model.BusinessTripReimbursement;
import com.business.trip.service.BusinessTripReimbursementLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.security.permission.ResourceActionsUtil;
import com.liferay.portal.service.ServiceContext;

public class BusinessTripReimbursementWorkflowHandler extends BaseWorkflowHandler {

	public String getClassName() {
		return CLASS_NAME;
	}

	public String getType(Locale locale) {
		return ResourceActionsUtil.getModelResource(locale, getClassName());
	}

	/**
	 * When the approver approved the workflow instance, updated the status
	 */
	public Object updateStatus(int status,
			Map<String, Serializable> workflowContext) throws PortalException,
			SystemException {
		long userId = GetterUtil.getLong((String) workflowContext
				.get(WorkflowConstants.CONTEXT_USER_ID));
		long businessTripReimbursementId = GetterUtil.getLong((String) workflowContext
				.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

		ServiceContext serviceContext = (ServiceContext) workflowContext
				.get("serviceContext");

		return BusinessTripReimbursementLocalServiceUtil.updateStatus(userId,
				businessTripReimbursementId, status, serviceContext);
	}

	public static final String CLASS_NAME = BusinessTripReimbursement.class.getName();
}
