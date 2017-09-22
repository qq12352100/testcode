package com.e.transfer.asset;

import com.e.transfer.model.ETransfer;
import com.e.transfer.service.ETransferLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;

public class ETransferAssetRenderFactory extends BaseAssetRendererFactory {
	public static final String CLASS_NAME = ETransfer.class.getName();   
    public static final String TYPE = "eTransfer";   

	@SuppressWarnings("unused")
	@Override
	public AssetRenderer getAssetRenderer(long classPK, int type)
			throws PortalException, SystemException {

		int status = WorkflowConstants.STATUS_ANY;  

        if (type == TYPE_LATEST_APPROVED) {   
            status = WorkflowConstants.STATUS_APPROVED;   
        }

        ETransfer eTransfer = ETransferLocalServiceUtil.getETransfer(classPK);

        return new ETransferAssetRender(eTransfer);
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
