package com.e.closing.asset;

import com.e.closing.model.EClosing;
import com.e.closing.service.EClosingLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;

/**
 * EClosing
 * @author t.a.jiang
 *
 */
@SuppressWarnings("all")
public class EClosingAssetRenderFactory extends BaseAssetRendererFactory {
	
	public static final String CLASS_NAME = EClosing.class.getName();
	public static final String TYPE = "eClosing";

	@Override
	public AssetRenderer getAssetRenderer(long classPK, int type) throws PortalException, SystemException {
		int status = WorkflowConstants.STATUS_ANY;
		if (type == TYPE_LATEST_APPROVED) {
			status = WorkflowConstants.STATUS_APPROVED;
		}
		EClosing eClosing = EClosingLocalServiceUtil.getEClosing(classPK);
		return new EClosingAssetRender(eClosing);
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
