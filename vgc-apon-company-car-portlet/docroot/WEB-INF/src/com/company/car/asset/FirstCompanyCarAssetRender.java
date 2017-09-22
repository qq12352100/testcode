package com.company.car.asset;

import java.util.Locale;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.company.car.model.FirstCompanyCar;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.asset.model.BaseAssetRenderer;

public class FirstCompanyCarAssetRender extends BaseAssetRenderer {
	private FirstCompanyCar _firstCompanyCar;   
	public static final String CLASS_NAME = FirstCompanyCar.class.getName();   
	public FirstCompanyCarAssetRender(FirstCompanyCar firstCompanyCar) {
		_firstCompanyCar = firstCompanyCar;
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

	@Override
	public long getClassPK() {
		return _firstCompanyCar.getFirstCompanyCarId();
	}

	@Override
	public long getGroupId() {
		return _firstCompanyCar.getGroupId();
	}

	@Override
	public String getSummary(Locale locale) {
		return _firstCompanyCar.getTicketNo();
	}

	@Override
	public String getTitle(Locale locale) {
		return _firstCompanyCar.getTicketNo();
	}

	@Override
	public long getUserId() {
		return _firstCompanyCar.getUserId();
	}

	@Override
	public String getUserName() {
		return _firstCompanyCar.getUserName();
	}

	@Override
	public String getUuid() {
		try {
			return String.valueOf(_firstCompanyCar.getUserUuid());
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
		return "/html/firstCar/view.jsp";
	}

}
