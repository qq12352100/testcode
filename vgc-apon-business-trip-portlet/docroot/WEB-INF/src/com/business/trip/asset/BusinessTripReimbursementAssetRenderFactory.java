package com.business.trip.asset;

import com.business.trip.model.BusinessTripReimbursement;
import com.business.trip.service.BusinessTripReimbursementLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;

public class BusinessTripReimbursementAssetRenderFactory extends BaseAssetRendererFactory {
	public static final String CLASS_NAME = BusinessTripReimbursement.class.getName();   
    public static final String TYPE = "businessTripReimbursement";

	@Override
	public AssetRenderer getAssetRenderer(long classPK, int type)
			throws PortalException, SystemException {
		int status = WorkflowConstants.STATUS_ANY;   
        if (type == TYPE_LATEST_APPROVED) {   
            status = WorkflowConstants.STATUS_APPROVED;   
        }   
           
        BusinessTripReimbursement businessTripReimbursement = BusinessTripReimbursementLocalServiceUtil.fetchBusinessTripReimbursement(classPK);
        return new BusinessTripReimbursementAssetRender(businessTripReimbursement);   
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
