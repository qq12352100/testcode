package com.e.onboarding.asset;

import java.util.Locale;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.asset.model.BaseAssetRenderer;
import com.e.onboarding.model.EOnBoarding;

public class EOnBoardingAssetRender extends BaseAssetRenderer {

	private EOnBoarding _eOnBoarding;

	public static final String CLASS_NAME = EOnBoarding.class.getName();

	public EOnBoardingAssetRender(EOnBoarding eOnBoarding) {
		_eOnBoarding = eOnBoarding;
	}

	@Override
	public String getClassName() {
		// TODO Auto-generated method stub
		return CLASS_NAME;
	}

	@Override
	public long getClassPK() {
		// TODO Auto-generated method stub
		return _eOnBoarding.getEOnBoardingId();
	}

	@Override
	public long getGroupId() {
		// TODO Auto-generated method stub
		return _eOnBoarding.getGroupId();
	}

	@Override
	public String getSummary(Locale locale) {
		// TODO Auto-generated method stub
		return _eOnBoarding.getTicketNo();
	}

	@Override
	public String getTitle(Locale locale) {
		// TODO Auto-generated method stub
		return _eOnBoarding.getTicketNo();
	}

	@Override
	public long getUserId() {
		// TODO Auto-generated method stub
		return _eOnBoarding.getUserId();
	}

	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		return _eOnBoarding.getUserName();
	}

	@Override
	public String getUuid() {
		// TODO Auto-generated method stub
		try {
			return String.valueOf(_eOnBoarding.getUserUuid());
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	@Override
	public String render(RenderRequest renderrequest,
			RenderResponse renderresponse, String s) throws Exception {
		// TODO Auto-generated method stub
		return "/html/eOnBoarding/view.jsp";
	}

}
