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

package com.business.trip.service.impl;

import com.business.trip.model.BtExchangeRate;
import com.business.trip.service.BtExchangeRateLocalServiceUtil;
import com.business.trip.service.base.BtExchangeRateLocalServiceBaseImpl;
import com.business.trip.util.BusinessTripConstants;
import com.liferay.portal.kernel.exception.SystemException;

import java.math.BigDecimal;

/**
 * The implementation of the bt exchange rate local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.business.trip.service.BtExchangeRateLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.business.trip.service.base.BtExchangeRateLocalServiceBaseImpl
 * @see com.business.trip.service.BtExchangeRateLocalServiceUtil
 */
public class BtExchangeRateLocalServiceImpl
	extends BtExchangeRateLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.business.trip.service.BtExchangeRateLocalServiceUtil} to access the bt exchange rate local service.
	 */
	public BtExchangeRate fetchByF_S_S(String firstCurrency,String secondCurrency,int status) throws SystemException {
		return btExchangeRatePersistence.fetchByF_S_S(firstCurrency, secondCurrency, status);
	}
	public BtExchangeRate fetchByS(int status) throws SystemException {
		return btExchangeRatePersistence.fetchByS(status);
	}
	
	
	/**
	 * change the EUR to RMB
	 * 
	 * @param amountEUR
	 * @return
	 * @throws SystemException
	 */
	public double changeEURToRMB(double amountEUR) throws SystemException{
		double amountRMB =amountEUR;
		BtExchangeRate btExchangeRate = BtExchangeRateLocalServiceUtil.fetchByF_S_S("RMB", "EUR", BusinessTripConstants.VALID_STATUS);
		if( btExchangeRate!=null){
			System.out.println("changeEURToRMB btExchangeRate="+btExchangeRate.getSecToFirExchangeRate());
			System.out.println("changeEURToRMB amountEUR="+amountEUR);
			amountRMB= amountEUR*btExchangeRate.getSecToFirExchangeRate();
			System.out.println("changeEURToRMB amountRMB="+amountRMB);
		}
		BigDecimal bd2 = new BigDecimal(amountRMB);
		amountRMB = bd2.setScale(2,
				BigDecimal.ROUND_HALF_UP).doubleValue();
		return amountRMB;
	}
	
}