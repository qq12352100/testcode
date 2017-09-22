package com.e.transfer.asset;

import java.util.Locale;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import com.e.transfer.model.ETransfer;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.asset.model.BaseAssetRenderer;

public class ETransferAssetRender extends BaseAssetRenderer {

	private ETransfer _eTransfer;

	public static final String CLASS_NAME = ETransfer.class.getName();

	public ETransferAssetRender(ETransfer eTransfer) {
		_eTransfer = eTransfer;
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

	@Override
	public long getClassPK() {
		return _eTransfer.getETransferId();
	}

	@Override
	public long getGroupId() {
		return _eTransfer.getGroupId();
	}

	@Override
	public String getSummary(Locale locale) {
		return _eTransfer.getTicketNo();
	}

	@Override
	public String getTitle(Locale locale) {
		return _eTransfer.getTicketNo();
	}

	@Override
	public long getUserId() {
		return _eTransfer.getUserId();
	}

	@Override
	public String getUserName() {
		return _eTransfer.getUserName();
	}

	@Override
	public String getUuid() {
		try {
			return String.valueOf(_eTransfer.getUserUuid());
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	@Override
	public String render(RenderRequest renderRequest,
			RenderResponse renderResponse, String template) throws Exception {
		// TODO Auto-generated method stub
		return "/html/eTransfer/view.jsp";
	}

}
