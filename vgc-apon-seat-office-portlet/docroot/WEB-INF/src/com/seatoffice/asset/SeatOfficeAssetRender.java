package com.seatoffice.asset;

import java.util.Locale;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.asset.model.BaseAssetRenderer;
import com.seatoffice.model.SeatOffice;

public class SeatOfficeAssetRender extends BaseAssetRenderer {
	private SeatOffice _SeatOffice;   
	public static final String CLASS_NAME = SeatOffice.class.getName();   
	public SeatOfficeAssetRender(SeatOffice SeatOffice) {
		_SeatOffice = SeatOffice;
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

	@Override
	public long getClassPK() {
		return _SeatOffice.getSeatId();
	}

	@Override
	public long getGroupId() {
		return _SeatOffice.getGroupId();
	}

	@Override
	public String getSummary(Locale locale) {
		return _SeatOffice.getTicketNo();
	}

	@Override
	public String getTitle(Locale locale) {
		return _SeatOffice.getTicketNo();
	}

	@Override
	public long getUserId() {
		return _SeatOffice.getUserId();
	}

	@Override
	public String getUserName() {
		return _SeatOffice.getUserName();
	}

	@Override
	public String getUuid() {
		try {
			return String.valueOf(_SeatOffice.getUserUuid());
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
		return "/html/seatoffice/view.jsp";
	}

}
