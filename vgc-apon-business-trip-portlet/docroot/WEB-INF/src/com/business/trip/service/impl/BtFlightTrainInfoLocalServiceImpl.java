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

import com.business.trip.model.BtFlightTrainInfo;
import com.business.trip.model.BtHotelInfo;
import com.business.trip.service.BtFlightTrainInfoLocalServiceUtil;
import com.business.trip.service.base.BtFlightTrainInfoLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the bt flight train info local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.business.trip.service.BtFlightTrainInfoLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.business.trip.service.base.BtFlightTrainInfoLocalServiceBaseImpl
 * @see com.business.trip.service.BtFlightTrainInfoLocalServiceUtil
 */
public class BtFlightTrainInfoLocalServiceImpl
	extends BtFlightTrainInfoLocalServiceBaseImpl {
	
	public int findCountByB_T(long businessTripPkId,String tripType) throws SystemException {
		return btFlightTrainInfoPersistence.countByB_T(businessTripPkId, tripType);
	}
	
	public List<BtFlightTrainInfo> findByB_T(long businessTripPkId,String tripType,int start,int end) throws SystemException {
		return btFlightTrainInfoPersistence.findByB_T(businessTripPkId, tripType, start, end);
	}
	
	public List<BtFlightTrainInfo> findAll() throws SystemException {
		return btFlightTrainInfoPersistence.findAll();
	}	
	
	public void copyBtFlightTrainInfoByB_T(long businessTripPkId,long targetBusinessTripPkId,String tripType,String targetTripType) throws SystemException {
		List<BtFlightTrainInfo> btFlightTrainInfoList=btFlightTrainInfoPersistence.findByB_T(businessTripPkId, tripType, -1, -1);
		if(btFlightTrainInfoList!=null&&btFlightTrainInfoList.size()>0){
			for(BtFlightTrainInfo btFlightTrainInfo:btFlightTrainInfoList){
				long btFlightTrainInfoId  = CounterLocalServiceUtil.increment(BtFlightTrainInfo.class.getName(), 1);
				btFlightTrainInfo.setBtFlightTrainInfoId(btFlightTrainInfoId);
				btFlightTrainInfo.setBusinessTripPkId(targetBusinessTripPkId);
				btFlightTrainInfo.setTripType(targetTripType);
				BtFlightTrainInfoLocalServiceUtil.addBtFlightTrainInfo(btFlightTrainInfo);
			}
		}
	}
	
	public void deleteBtFlightTrainInfoByB_T(long businessTripPkId,String tripType) throws SystemException {
		List<BtFlightTrainInfo> btFlightTrainInfoList=btFlightTrainInfoPersistence.findByB_T(businessTripPkId, tripType, -1, -1);
		if(btFlightTrainInfoList!=null&&btFlightTrainInfoList.size()>0){
			for(BtFlightTrainInfo btFlightTrainInfo:btFlightTrainInfoList){
				BtFlightTrainInfoLocalServiceUtil.deleteBtFlightTrainInfo(btFlightTrainInfo);
			}
		}
	}
	//是否需要evp
	public boolean isNeedEVPApprove(long businessTripPkId,String tripType) throws SystemException {
		List<BtFlightTrainInfo> btFlightTrainInfos = btFlightTrainInfoPersistence.findByB_T(businessTripPkId, tripType);
		boolean isNeedEVPApprove = false;
		for(BtFlightTrainInfo bInfo:btFlightTrainInfos) {
			if(!bInfo.getClassInfo().equalsIgnoreCase("economy")){
				isNeedEVPApprove=true;
				break;
			}
		}
		return isNeedEVPApprove;
	}
}