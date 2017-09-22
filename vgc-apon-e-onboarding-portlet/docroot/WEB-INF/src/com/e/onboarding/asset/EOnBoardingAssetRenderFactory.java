package com.e.onboarding.asset;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;
import com.e.onboarding.model.EOnBoarding;
import com.e.onboarding.service.EOnBoardingLocalServiceUtil;

public class EOnBoardingAssetRenderFactory extends BaseAssetRendererFactory{

	public static final String CLASS_NAME=EOnBoarding.class.getName();
	public static final String TYPE="eOnBoarding";
	
	
	@Override
	public AssetRenderer getAssetRenderer(long classPK, int type)
			throws PortalException, SystemException {
		// TODO Auto-generated method stub
		int status=WorkflowConstants.STATUS_ANY;
		if(type==TYPE_LATEST_APPROVED)
			status=WorkflowConstants.STATUS_APPROVED;
		EOnBoarding eOnBoarding=EOnBoardingLocalServiceUtil.getEOnBoarding(classPK);
		return new EOnBoardingAssetRender(eOnBoarding);
	}

	@Override
	public String getClassName() {
		// TODO Auto-generated method stub
		return CLASS_NAME;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return TYPE;
	}

}
