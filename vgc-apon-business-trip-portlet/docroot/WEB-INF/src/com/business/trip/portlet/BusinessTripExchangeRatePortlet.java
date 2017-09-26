package com.business.trip.portlet;

import java.io.IOException;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.business.trip.model.BtExchangeRate;
import com.business.trip.service.BtExchangeRateLocalServiceUtil;
import com.business.trip.util.BusinessTripConstants;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class BusinessTripExchangeRatePortlet
 */
public class BusinessTripExchangeRatePortlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void processAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		super.processAction(actionRequest, actionResponse);
	}
 
	public void addBusinessTripExchangeRate(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException, SystemException {
		Date now = new Date();
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		BtExchangeRate btExchangeRate = BtExchangeRateLocalServiceUtil.fetchByF_S_S("RMB", "EUR", BusinessTripConstants.VALID_STATUS);
		if(btExchangeRate!=null) {
			btExchangeRate.setStatus(BusinessTripConstants.INVALID_STATUS);
			btExchangeRate.setModifiedDate(now);
			BtExchangeRateLocalServiceUtil.updateBtExchangeRate(btExchangeRate);
		}
		long btExchangeRateId = CounterLocalServiceUtil.increment(BtExchangeRate.class.getName(), 1);
		BtExchangeRate newBtRate = BtExchangeRateLocalServiceUtil.createBtExchangeRate(btExchangeRateId);
		double firToSecExchangeRate = ParamUtil.getDouble(actionRequest, "firToSecExchangeRate");
		newBtRate.setFirstCurrency("RMB");
		newBtRate.setSecondCurrency("EUR");
		newBtRate.setFirToSecExchangeRate(firToSecExchangeRate);
		newBtRate.setSecToFirExchangeRate(1/firToSecExchangeRate);
		newBtRate.setUserId(themeDisplay.getUserId());
		newBtRate.setUserName(themeDisplay.getUser().getFullName());
		newBtRate.setCreateDate(now);
		newBtRate.setStatus(BusinessTripConstants.VALID_STATUS);
		BtExchangeRateLocalServiceUtil.updateBtExchangeRate(newBtRate);
	}
}
