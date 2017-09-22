package com.seatoffice.asset;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;
import com.seatoffice.model.SeatOffice;
import com.seatoffice.service.SeatOfficeLocalServiceUtil;

public class SeatOfficeAssetRenderFactory extends BaseAssetRendererFactory {
	public static final String CLASS_NAME = SeatOffice.class.getName();   
    public static final String TYPE = "SeatOffice";   

	@Override
	public AssetRenderer getAssetRenderer(long classPK, int type)
			throws PortalException, SystemException {
		int status = WorkflowConstants.STATUS_ANY;   
        if (type == TYPE_LATEST_APPROVED) {   
            status = WorkflowConstants.STATUS_APPROVED;   
        }   
           
        SeatOffice SeatOffice = SeatOfficeLocalServiceUtil.getSeatOffice(classPK);   
        return new SeatOfficeAssetRender(SeatOffice);   
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
