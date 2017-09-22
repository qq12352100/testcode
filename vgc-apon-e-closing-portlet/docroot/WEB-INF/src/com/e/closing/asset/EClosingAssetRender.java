package com.e.closing.asset;

import java.util.Locale;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.e.closing.model.EClosing;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.asset.model.BaseAssetRenderer;

/**
 * EClosing
 * @author t.a.jiang
 *
 */
public class EClosingAssetRender extends BaseAssetRenderer {
	
	private EClosing _eClosing;
	
	public static final String CLASS_NAME = EClosing.class.getName();
	
	public EClosingAssetRender(EClosing eInvitation) {
		this._eClosing = eInvitation;
	}
	
	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

	@Override
	public long getClassPK() {
		return _eClosing.getEclosingId();
	}

	@Override
	public long getGroupId() {
		return _eClosing.getGroupId();
	}

	@Override
	public String getSummary(Locale locale) {
		return _eClosing.getTicketNo();
	}

	@Override
	public String getTitle(Locale locale) {
		return _eClosing.getTicketNo();
	}

	@Override
	public long getUserId() {
		return _eClosing.getUserId();
	}

	@Override
	public String getUserName() {
		return _eClosing.getUserName();
	}

	@Override
	public String getUuid() {
		String uuid = "";
		try {
			String.valueOf(_eClosing.getUserUuid());
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return uuid;
	}

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse, String template) throws Exception {
		return "/html/eclosing/view.jsp";
	}

}
