package com.e.leave.asset;

import com.e.leave.model.ELeave;
import com.e.leave.service.ELeaveLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;

public class ELeaveAssetRenderFactory extends BaseAssetRendererFactory {
	public static final String CLASS_NAME = ELeave.class.getName();   
    public static final String TYPE = "eTransfer";   

	@SuppressWarnings("unused")
	@Override
	public AssetRenderer getAssetRenderer(long classPK, int type)
			throws PortalException, SystemException {

		int status = WorkflowConstants.STATUS_ANY;  

        if (type == TYPE_LATEST_APPROVED) {   
            status = WorkflowConstants.STATUS_APPROVED;   
        }

        ELeave eLeave = ELeaveLocalServiceUtil.getELeave(classPK);

        return new ELeaveAssetRender(eLeave);
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
