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

import java.util.Date;

import com.business.trip.model.BtReimbursementSAPInfo;
import com.business.trip.model.BusinessTripReimbursement;
import com.business.trip.service.base.BtReimbursementSAPInfoLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the bt reimbursement s a p info local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.business.trip.service.BtReimbursementSAPInfoLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.business.trip.service.base.BtReimbursementSAPInfoLocalServiceBaseImpl
 * @see com.business.trip.service.BtReimbursementSAPInfoLocalServiceUtil
 */
public class BtReimbursementSAPInfoLocalServiceImpl
	extends BtReimbursementSAPInfoLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.business.trip.service.BtReimbursementSAPInfoLocalServiceUtil} to access the bt reimbursement s a p info local service.
	 */
	public BtReimbursementSAPInfo saveOrUpdateBtReimbursementSAPInfo(BtReimbursementSAPInfo btReimbursementSAPInfo) throws SystemException{
		btReimbursementSAPInfo=btReimbursementSAPInfoPersistence.update(btReimbursementSAPInfo);
		return btReimbursementSAPInfo;
	}
	
	public BtReimbursementSAPInfo fetchByB_C(String currency,long businessTripPkId) throws SystemException{
		return btReimbursementSAPInfoPersistence.fetchByB_C(currency, businessTripPkId);
	}
}