package com.e.leave.asset;

import java.util.Locale;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.e.leave.model.ELeave;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.asset.model.BaseAssetRenderer;

public class ELeaveAssetRender extends BaseAssetRenderer {

	private ELeave _eLeave;

	public static final String CLASS_NAME = ELeave.class.getName();

	public ELeaveAssetRender(ELeave eLeave) {
		_eLeave = eLeave;
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

	@Override
	public long getClassPK() {
		return _eLeave.getELeaveId();
	}

	@Override
	public long getGroupId() {
		return _eLeave.getGroupId();
	}

	@Override
	public String getSummary(Locale locale) {
		return _eLeave.getTicketNo();
	}

	@Override
	public String getTitle(Locale locale) {
		return _eLeave.getTicketNo();
	}

	@Override
	public long getUserId() {
		return _eLeave.getUserId();
	}

	@Override
	public String getUserName() {
		return _eLeave.getUserName();
	}

	@Override
	public String getUuid() {
		try {
			return String.valueOf(_eLeave.getUserUuid());
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
		return "/html/eLeave/view.jsp";
	}

}
