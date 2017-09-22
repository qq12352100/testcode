package com.company.car.asset;

import com.company.car.model.FirstCompanyCar;
import com.company.car.service.FirstCompanyCarLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;

public class FirstCompanyCarAssetRenderFactory extends BaseAssetRendererFactory {
	public static final String CLASS_NAME = FirstCompanyCar.class.getName();   
    public static final String TYPE = "firstCompanyCar";   

	@Override
	public AssetRenderer getAssetRenderer(long classPK, int type)
			throws PortalException, SystemException {
		int status = WorkflowConstants.STATUS_ANY;   
        if (type == TYPE_LATEST_APPROVED) {   
            status = WorkflowConstants.STATUS_APPROVED;   
        }   
           
        FirstCompanyCar firstCompanyCar = FirstCompanyCarLocalServiceUtil.getFirstCompanyCar(classPK);   
        return new FirstCompanyCarAssetRender(firstCompanyCar);   
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
