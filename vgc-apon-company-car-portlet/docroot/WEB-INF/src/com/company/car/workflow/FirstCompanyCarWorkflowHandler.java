package com.company.car.workflow;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

import com.company.car.model.FirstCompanyCar;
import com.company.car.service.FirstCompanyCarLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.security.permission.ResourceActionsUtil;
import com.liferay.portal.service.ServiceContext;

public class FirstCompanyCarWorkflowHandler extends BaseWorkflowHandler {

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
		long firstCompanyCarId = GetterUtil.getLong((String) workflowContext
				.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

		ServiceContext serviceContext = (ServiceContext) workflowContext
				.get("serviceContext");

		return FirstCompanyCarLocalServiceUtil.updateStatus(userId,
				firstCompanyCarId, status, serviceContext);
	}

	public static final String CLASS_NAME = FirstCompanyCar.class.getName();
}
