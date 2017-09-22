package com.e.onboarding.search.distribution;

import javax.portlet.PortletResponse;

import com.liferay.portal.kernel.dao.search.RowChecker;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class DistributionChecker extends RowChecker {
	public DistributionChecker(PortletResponse portletResponse) {
		super(portletResponse);
	}

	@Override
	public boolean isDisabled(Object obj) {
		return false;
	}

	private static Log _log = LogFactoryUtil.getLog(DistributionChecker.class);
}
