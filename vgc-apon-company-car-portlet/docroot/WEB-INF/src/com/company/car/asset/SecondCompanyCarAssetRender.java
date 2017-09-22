package com.company.car.asset;

import java.util.Locale;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.company.car.model.SecondCompanyCar;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.asset.model.BaseAssetRenderer;

public class SecondCompanyCarAssetRender extends BaseAssetRenderer {
	private SecondCompanyCar _secondCompanyCar;   
	public static final String CLASS_NAME = SecondCompanyCar.class.getName();   
	public SecondCompanyCarAssetRender(SecondCompanyCar secondCompanyCar) {
		_secondCompanyCar = secondCompanyCar;
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

	@Override
	public long getClassPK() {
		return _secondCompanyCar.getSecondCompanyCarId();
	}

	@Override
	public long getGroupId() {
		return _secondCompanyCar.getGroupId();
	}

	@Override
	public String getSummary(Locale locale) {
		return _secondCompanyCar.getTicketNo();
	}

	@Override
	public String getTitle(Locale locale) {
		return _secondCompanyCar.getTicketNo();
	}

	@Override
	public long getUserId() {
		return _secondCompanyCar.getUserId();
	}

	@Override
	public String getUserName() {
		return _secondCompanyCar.getUserName();
	}

	@Override
	public String getUuid() {
		try {
			return String.valueOf(_secondCompanyCar.getUserUuid());
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
		return "/html/secondCar/view.jsp";
	}

}
