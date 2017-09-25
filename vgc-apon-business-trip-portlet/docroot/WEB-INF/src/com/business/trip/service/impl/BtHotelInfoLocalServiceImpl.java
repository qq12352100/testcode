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

import com.business.trip.model.BtHotelInfo;
import com.business.trip.service.BtHotelInfoLocalServiceUtil;
import com.business.trip.service.base.BtHotelInfoLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the bt hotel info local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.business.trip.service.BtHotelInfoLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.business.trip.service.base.BtHotelInfoLocalServiceBaseImpl
 * @see com.business.trip.service.BtHotelInfoLocalServiceUtil
 */
public class BtHotelInfoLocalServiceImpl extends BtHotelInfoLocalServiceBaseImpl {
	
	public int findCountByB_T(long businessTripPkId,String tripType) throws SystemException {
		return btHotelInfoPersistence.countByB_T(businessTripPkId, tripType);
	}
	
	public List<BtHotelInfo> findByB_T(long businessTripPkId,String tripType,int start,int end) throws SystemException {
		return btHotelInfoPersistence.findByB_T(businessTripPkId, tripType, start, end);
	}
	
	public List<BtHotelInfo> findAll() throws SystemException {
		return btHotelInfoPersistence.findAll();
	}
	
	public boolean isNeedEVPApprove(long businessTripPkId,String tripType) throws SystemException {
		List<BtHotelInfo> btHotelInfos = btHotelInfoPersistence.findByB_T(businessTripPkId, tripType);
		boolean isNeedEVPApprove = false;
		for(BtHotelInfo bInfo:btHotelInfos) {
			if(bInfo.getIsOverBudget()==1 || bInfo.getRoomCategory().equals("Non-Standard")) {//Nonstandard  replace  by wanghai  Over Budget as ui change
				isNeedEVPApprove = true;
				break;
			}
		}
		return isNeedEVPApprove;
	}
	
	public void copyBtHotelInfoByB_T(long businessTripPkId,long targetBusinessTripPkId,String tripType,String targetTripType) throws SystemException {
		List<BtHotelInfo> btHotelInfoList=btHotelInfoPersistence.findByB_T(businessTripPkId, tripType, -1, -1);
		if(btHotelInfoList!=null&&btHotelInfoList.size()>0){
			for(BtHotelInfo btHotelInfo:btHotelInfoList){
				long btHotelInfoId  = CounterLocalServiceUtil.increment(BtHotelInfo.class.getName(), 1);
				btHotelInfo.setBtHotelInfoId(btHotelInfoId);
				btHotelInfo.setBusinessTripPkId(targetBusinessTripPkId);
				btHotelInfo.setTripType(targetTripType);
				BtHotelInfoLocalServiceUtil.addBtHotelInfo(btHotelInfo);
			}
		}
	}
	
	public void deleteBtHotelInfoByB_T(long businessTripPkId,String tripType) throws SystemException {
		List<BtHotelInfo> btHotelInfoList=btHotelInfoPersistence.findByB_T(businessTripPkId, tripType, -1, -1);
		if(btHotelInfoList!=null&&btHotelInfoList.size()>0){
			for(BtHotelInfo btHotelInfo:btHotelInfoList){
				BtHotelInfoLocalServiceUtil.deleteBtHotelInfo(btHotelInfo);
			}
		}
	}
}