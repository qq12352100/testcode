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

package com.e.leave.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.e.leave.model.ELeaveInfo;
import com.e.leave.service.ELeaveInfoLocalServiceUtil;
import com.e.leave.service.base.ELeaveInfoLocalServiceBaseImpl;
import com.e.leave.util.ELConstants;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.LocaleUtil;

/**
 * The implementation of the e leave info local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.e.leave.service.ELeaveInfoLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author EZEYIFE
 * @see com.e.leave.service.base.ELeaveInfoLocalServiceBaseImpl
 * @see com.e.leave.service.ELeaveInfoLocalServiceUtil
 */
public class ELeaveInfoLocalServiceImpl extends ELeaveInfoLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.e.leave.service.ELeaveInfoLocalServiceUtil} to access the e leave info local service.
	 */
	@SuppressWarnings("unchecked")
	public List<ELeaveInfo> findLeaveListByELeaveId(long eLeaveId) throws SystemException{
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(ELeaveInfo.class);		
		query.add(PropertyFactoryUtil.forName("eLeaveId").eq(eLeaveId));
		query.addOrder(OrderFactoryUtil.asc("startDate"));
		return dynamicQuery(query);	
	}
	
	public boolean saveOrUpdateELeaveInfo(
			long eLeaveId,String typeOfLeave, Date[] startDates,Date[] endDates,String[] startTimes,String[] endTimes,String[] leaveDays,String remark)
		throws SystemException {
		boolean isCheckDateList=true;
		String typeOfLeaveTxt=LanguageUtil.get(LocaleUtil.getDefault(), typeOfLeave);
		String typeOfLeaveId=ELConstants.getTypeOfLeaveCode(typeOfLeaveTxt);
		List<ELeaveInfo> eLeaveInfoList=ELeaveInfoLocalServiceUtil.findLeaveListByELeaveId(eLeaveId);
		
		if(startDates!=null&&startDates.length>0){
			for(int i=0;i<startDates.length;i++){
				long eLeaveInfoId = CounterLocalServiceUtil.increment(ELeaveInfo.class.getName(), 1);
				ELeaveInfo eLeaveInfo = ELeaveInfoLocalServiceUtil.createELeaveInfo(eLeaveInfoId);
				eLeaveInfo.setELeaveId(eLeaveId);
				eLeaveInfo.setTypeOfLeave(typeOfLeave);
				eLeaveInfo.setTypeOfLeaveId(typeOfLeaveId);
				eLeaveInfo.setStartDate(startDates[i]);
				eLeaveInfo.setEndDate(endDates[i]);
				eLeaveInfo.setStartTime(startTimes[i]);
				eLeaveInfo.setEndTime(endTimes[i]);
				eLeaveInfo.setAbsenceDays(leaveDays[i]);
				eLeaveInfo.setRemark(remark);
				if(("9001".equals(typeOfLeaveId)||"9002".equals(typeOfLeaveId)||"9003".equals(typeOfLeaveId)||"9004".equals(typeOfLeaveId))||
					(leaveDays[i]!=null&&!leaveDays[i].equals("")&&Double.valueOf(leaveDays[i])!=0d)){
					if(this.checkDateList(typeOfLeaveId,startDates[i],endDates[i],startTimes[i],endTimes[i],eLeaveInfoList)){
						eLeaveInfoPersistence.update(eLeaveInfo);
					}else{
						isCheckDateList=false;
					}
				}
			}
		}
		return isCheckDateList;
	}
	
	public boolean isLeaveInfoExist(long eleaveId,String typeOfLeave) throws SystemException{
		boolean isLeaveInfoExist=false;
		List<ELeaveInfo> leaveInfos=ELeaveInfoLocalServiceUtil.findLeaveListByELeaveId(eleaveId);
		if(leaveInfos!=null&&leaveInfos.size()>0){
			for(ELeaveInfo eLeaveInfo:leaveInfos){
				if(typeOfLeave.equals(eLeaveInfo.getTypeOfLeave())){
					isLeaveInfoExist=true;
					break;
				}
			}
		}
		return isLeaveInfoExist;
	}

	public boolean checkDateList(String typeOfLeaveId,Date startDates,Date endDates,String startTimes,String endTimes,List<ELeaveInfo> eLeaveInfoList){
		boolean isCheck=true;
		DateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String startDateStr=sdf1.format(startDates)+" "+startTimes;
		String endDateStr=sdf1.format(endDates)+" "+endTimes;
		try {
			Date startDate=sdf2.parse(startDateStr);
			Date endDate=sdf2.parse(endDateStr);
			if(eLeaveInfoList!=null&&eLeaveInfoList.size()>0){
				for(ELeaveInfo eLeaveInfo:eLeaveInfoList){
					String startDateStr2=sdf1.format(eLeaveInfo.getStartDate())+" "+eLeaveInfo.getStartTime();
					String endDateStr2=sdf1.format(eLeaveInfo.getEndDate())+" "+eLeaveInfo.getEndTime();
					Date startDate2=sdf2.parse(startDateStr2);
					Date endDate2=sdf2.parse(endDateStr2);
					if((startDate2.before(startDate)&&endDate2.after(startDate))||(startDate2.before(endDate)&&endDate2.after(endDate))||
						(startDate.before(startDate2)&&endDate.after(startDate2))||(startDate.before(endDate2)&&endDate.after(endDate2))){
						isCheck=false;
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isCheck;
	}
}