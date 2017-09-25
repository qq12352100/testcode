package com.business.trip.asset;

import com.business.trip.model.BusinessTripApplication;
import com.business.trip.service.BusinessTripApplicationLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;

public class BusinessTripApplicationAssetRenderFactory extends BaseAssetRendererFactory {
	public static final String CLASS_NAME = BusinessTripApplication.class.getName();   
    public static final String TYPE = "businessTripApplication";

	@Override
	public AssetRenderer getAssetRenderer(long classPK, int type)
			throws PortalException, SystemException {
		int status = WorkflowConstants.STATUS_ANY;   
        if (type == TYPE_LATEST_APPROVED) {   
            status = WorkflowConstants.STATUS_APPROVED;   
        }   
           
        BusinessTripApplication businessTripApplication = BusinessTripApplicationLocalServiceUtil.fetchBusinessTripApplication(classPK);   
        return new BusinessTripApplicationAssetRender(businessTripApplication);   
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;   
	}

	@Override
	public String getType() {
		return TYPE;   
	}

}
