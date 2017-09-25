/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.business.trip.service.messaging;

import com.business.trip.service.BtCarRentalInfoLocalServiceUtil;
import com.business.trip.service.BtCostListLocalServiceUtil;
import com.business.trip.service.BtEntertainmentDetailLocalServiceUtil;
import com.business.trip.service.BtExchangeRateLocalServiceUtil;
import com.business.trip.service.BtExchangeSAPRateLocalServiceUtil;
import com.business.trip.service.BtFlightTrainInfoLocalServiceUtil;
import com.business.trip.service.BtHotelInfoLocalServiceUtil;
import com.business.trip.service.BtReimbursementSAPInfoLocalServiceUtil;
import com.business.trip.service.BtTrainInfoLocalServiceUtil;
import com.business.trip.service.BtTravelExpenseLocalServiceUtil;
import com.business.trip.service.BusinessTripApplicationLocalServiceUtil;
import com.business.trip.service.BusinessTripReimbursementLocalServiceUtil;
import com.business.trip.service.ClpSerializer;
import com.business.trip.service.RateCityLocalServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			BtCarRentalInfoLocalServiceUtil.clearService();

			BtCostListLocalServiceUtil.clearService();

			BtEntertainmentDetailLocalServiceUtil.clearService();

			BtExchangeRateLocalServiceUtil.clearService();

			BtExchangeSAPRateLocalServiceUtil.clearService();

			BtFlightTrainInfoLocalServiceUtil.clearService();

			BtHotelInfoLocalServiceUtil.clearService();

			BtReimbursementSAPInfoLocalServiceUtil.clearService();

			BtTrainInfoLocalServiceUtil.clearService();

			BtTravelExpenseLocalServiceUtil.clearService();

			BusinessTripApplicationLocalServiceUtil.clearService();

			BusinessTripReimbursementLocalServiceUtil.clearService();

			RateCityLocalServiceUtil.clearService();
		}
	}
}