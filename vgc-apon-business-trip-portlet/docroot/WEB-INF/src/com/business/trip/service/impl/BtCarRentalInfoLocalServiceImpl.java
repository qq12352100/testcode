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

import java.util.List;

import com.business.trip.model.BtCarRentalInfo;
import com.business.trip.service.BtCarRentalInfoLocalServiceUtil;
import com.business.trip.service.base.BtCarRentalInfoLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the bt car rental info local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.business.trip.service.BtCarRentalInfoLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.business.trip.service.base.BtCarRentalInfoLocalServiceBaseImpl
 * @see com.business.trip.service.BtCarRentalInfoLocalServiceUtil
 */
public class BtCarRentalInfoLocalServiceImpl
	extends BtCarRentalInfoLocalServiceBaseImpl {
	
	public int findCountByB_T(long businessTripPkId,String tripType) throws SystemException {
		return btCarRentalInfoPersistence.countByB_T(businessTripPkId, tripType);
	}
	
	public List<BtCarRentalInfo> findByB_T(long businessTripPkId,String tripType,int start,int end) throws SystemException {
		return btCarRentalInfoPersistence.findByB_T(businessTripPkId, tripType, start, end);
	}
	
	public List<BtCarRentalInfo> findAll() throws SystemException {
		return btCarRentalInfoPersistence.findAll();
	}
	
	public void copyBtCarRentalInfoByB_T(long businessTripPkId,long targetBusinessTripPkId,String tripType,String targetTripType) throws SystemException {
		List<BtCarRentalInfo> btCarRentalInfoList=btCarRentalInfoPersistence.findByB_T(businessTripPkId, tripType, -1, -1);
		if(btCarRentalInfoList!=null&&btCarRentalInfoList.size()>0){
			for(BtCarRentalInfo btCarRentalInfo:btCarRentalInfoList){
				long btCarRentalInfoId  = CounterLocalServiceUtil.increment(BtCarRentalInfo.class.getName(), 1);
				btCarRentalInfo.setBtCarRentalInfoId(btCarRentalInfoId);
				btCarRentalInfo.setBusinessTripPkId(targetBusinessTripPkId);
				btCarRentalInfo.setTripType(targetTripType);
				BtCarRentalInfoLocalServiceUtil.addBtCarRentalInfo(btCarRentalInfo);
			}
		}
	}
	
	public void deleteBtFlightTrainInfoByB_T(long businessTripPkId,String tripType) throws SystemException {
		List<BtCarRentalInfo> btCarRentalInfoList=btCarRentalInfoPersistence.findByB_T(businessTripPkId, tripType, -1, -1);
		if(btCarRentalInfoList!=null&&btCarRentalInfoList.size()>0){
			for(BtCarRentalInfo btCarRentalInfo:btCarRentalInfoList){
				BtCarRentalInfoLocalServiceUtil.deleteBtCarRentalInfo(btCarRentalInfo);
			}
		}
	}
}