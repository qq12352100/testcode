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

import com.business.trip.model.BtTrainInfo;
import com.business.trip.service.BtTrainInfoLocalServiceUtil;
import com.business.trip.service.base.BtTrainInfoLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the bt train info local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.business.trip.service.BtTrainInfoLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.business.trip.service.base.BtTrainInfoLocalServiceBaseImpl
 * @see com.business.trip.service.BtTrainInfoLocalServiceUtil
 */
public class BtTrainInfoLocalServiceImpl extends BtTrainInfoLocalServiceBaseImpl {

	public int findCountByB_T(long businessTripPkId,String tripType) throws SystemException {
		return btTrainInfoPersistence.countByB_T(businessTripPkId, tripType);
	}
	
	public List<BtTrainInfo> findByB_T(long businessTripPkId,String tripType,int start,int end) throws SystemException {
		return btTrainInfoPersistence.findByB_T(businessTripPkId, tripType, start, end);
	}
	
	public List<BtTrainInfo> findAll() throws SystemException {
		return btTrainInfoPersistence.findAll();
	}
	
	public void copyBtTrainInfoByB_T(long businessTripPkId,long targetBusinessTripPkId,String tripType,String targetTripType) throws SystemException {
		List<BtTrainInfo> btTrainInfoList=btTrainInfoPersistence.findByB_T(businessTripPkId, tripType, -1, -1);
		if(btTrainInfoList!=null&&btTrainInfoList.size()>0){
			for(BtTrainInfo btTrainInfo:btTrainInfoList){
				long btTrainInfoId  = CounterLocalServiceUtil.increment(BtTrainInfo.class.getName(), 1);
				btTrainInfo.setBtTrainInfoId(btTrainInfoId);
				btTrainInfo.setBusinessTripPkId(targetBusinessTripPkId);
				btTrainInfo.setTripType(targetTripType);
				BtTrainInfoLocalServiceUtil.addBtTrainInfo(btTrainInfo);
			}
		}
	}
	
	public void deleteBtTrainInfoByB_T(long businessTripPkId,String tripType) throws SystemException {
		List<BtTrainInfo> btTrainInfoList=btTrainInfoPersistence.findByB_T(businessTripPkId, tripType, -1, -1);
		if(btTrainInfoList!=null&&btTrainInfoList.size()>0){
			for(BtTrainInfo btTrainInfo:btTrainInfoList){
				BtTrainInfoLocalServiceUtil.deleteBtTrainInfo(btTrainInfo);
			}
		}
	}
}