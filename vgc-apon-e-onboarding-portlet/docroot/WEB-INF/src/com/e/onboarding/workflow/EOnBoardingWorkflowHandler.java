package com.e.onboarding.workflow;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

import com.e.onboarding.model.EOnBoarding;
import com.e.onboarding.service.EOnBoardingLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.security.permission.ResourceActionsUtil;
import com.liferay.portal.service.ServiceContext;

public class EOnBoardingWorkflowHandler extends BaseWorkflowHandler{

	@Override
	public String getClassName() {
		// TODO Auto-generated method stub
		return CLASS_NAME;
	}

	@Override
	public String getType(Locale locale) {
		// TODO Auto-generated method stub
		return ResourceActionsUtil.getModelResource(locale, getClassName());
	}

	@Override
	public Object updateStatus(int status, Map<String, Serializable> workflowContext)
			throws PortalException, SystemException {
		// TODO Auto-generated method stub
		long userId = GetterUtil.getLong((String) workflowContext
				.get(WorkflowConstants.CONTEXT_USER_ID));
		long eOnBoardingId=GetterUtil.getLong((String) workflowContext
				.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));
		ServiceContext serviceContext = (ServiceContext) workflowContext
				.get("serviceContext");

		return EOnBoardingLocalServiceUtil.updateStatus(userId, eOnBoardingId, status, serviceContext);
	}

	
	public static final String CLASS_NAME=EOnBoarding.class.getName();
}
