package com.business.trip.asset;

import java.util.Locale;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.business.trip.model.BusinessTripApplication;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.asset.model.BaseAssetRenderer;

public class BusinessTripApplicationAssetRender extends BaseAssetRenderer {
	private BusinessTripApplication _businessTripApplication;   
	public static final String CLASS_NAME = BusinessTripApplication.class.getName();   
	public BusinessTripApplicationAssetRender(BusinessTripApplication businessTripApplication) {
		_businessTripApplication = businessTripApplication;
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

	@Override
	public long getClassPK() {
		return _businessTripApplication.getBusinessTripApplicationId();
	}

	@Override
	public long getGroupId() {
		return _businessTripApplication.getGroupId();
	}

	@Override
	public String getSummary(Locale locale) {
		return _businessTripApplication.getTicketNo();
	}

	@Override
	public String getTitle(Locale locale) {
		return _businessTripApplication.getTicketNo();
	}

	@Override
	public long getUserId() {
		return _businessTripApplication.getUserId();
	}

	@Override
	public String getUserName() {
		return _businessTripApplication.getUserName();
	}

	@Override
	public String getUuid() {
		try {
			return String.valueOf(_businessTripApplication.getUserUuid());
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
		return "/html/businessTripApplication/view.jsp";
	}

}
