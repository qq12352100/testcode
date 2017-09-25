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

import com.business.trip.model.BtTravelExpense;
import com.business.trip.model.BusinessTripReimbursement;
import com.business.trip.service.BtExchangeRateLocalServiceUtil;
import com.business.trip.service.BtTravelExpenseLocalServiceUtil;
import com.business.trip.service.base.BtTravelExpenseLocalServiceBaseImpl;
import com.business.trip.util.TravelExpenseUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The implementation of the bt travel expense local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.business.trip.service.BtTravelExpenseLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.business.trip.service.base.BtTravelExpenseLocalServiceBaseImpl
 * @see com.business.trip.service.BtTravelExpenseLocalServiceUtil
 */
public class BtTravelExpenseLocalServiceImpl extends
		BtTravelExpenseLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.business.trip.service.BtTravelExpenseLocalServiceUtil} to access the
	 * bt travel expense local service.
	 */
	public int findCountByB_T(long businessTripPkId, String tripType)
			throws SystemException {
		return btTravelExpensePersistence
				.countByB_T(businessTripPkId, tripType);
	}

	public List<BtTravelExpense> findByB_T(long businessTripPkId,
			String tripType, int start, int end) throws SystemException {
		return btTravelExpensePersistence.findByB_T(businessTripPkId, tripType,
				start, end);
	}

	public List<BtTravelExpense> findByB_C(long businessTripPkId,
			String currency) throws SystemException {
		return btTravelExpensePersistence.findByB_C(businessTripPkId, currency);
	}

	public List<BtTravelExpense> findAll() throws SystemException {
		return btTravelExpensePersistence.findAll();
	}

	public Double findSumByCurrency(long businessTripPkId, String currency)
			throws SystemException {
		DynamicQuery query = DynamicQueryFactoryUtil
				.forClass(BtTravelExpense.class);
		query.setProjection(ProjectionFactoryUtil.sum("allowance"));
		query.add(RestrictionsFactoryUtil.eq("currency", currency));
		query.add(RestrictionsFactoryUtil.eq("businessTripPkId",
				businessTripPkId));
		List<Double> sumlist = dynamicQuery(query);
		if (null != sumlist && sumlist.size() > 0) {
			return sumlist.get(0) == null ? 0 : sumlist.get(0);
		} else {
			return 0d;
		}
	}
	
	public Double findSumInRMBByCurrency(long businessTripPkId, String currency)
			throws SystemException {
		DynamicQuery query = DynamicQueryFactoryUtil
				.forClass(BtTravelExpense.class);
		query.setProjection(ProjectionFactoryUtil.sum("allowanceRmb"));
		query.add(RestrictionsFactoryUtil.eq("currency", currency));
		query.add(RestrictionsFactoryUtil.eq("businessTripPkId",
				businessTripPkId));
		List<Double> sumlist = dynamicQuery(query);
		if (null != sumlist && sumlist.size() > 0) {
			return sumlist.get(0) == null ? 0 : sumlist.get(0);
		} else {
			return 0d;
		}
	}

	public void copyBtTravelExpenseByB_T(long businessTripPkId,
			long targetBusinessTripPkId, String tripType, String targetTripType)
			throws SystemException {
		List<BtTravelExpense> btTravelExpenseList = btTravelExpensePersistence
				.findByB_T(businessTripPkId, tripType, -1, -1);
		if (btTravelExpenseList != null && btTravelExpenseList.size() > 0) {
			for (BtTravelExpense btTravelExpense : btTravelExpenseList) {
				long btFlightTrainInfoId = CounterLocalServiceUtil.increment(
						BtTravelExpense.class.getName(), 1);
				btTravelExpense.setBtTravelExpenseId(btFlightTrainInfoId);
				btTravelExpense.setBusinessTripPkId(targetBusinessTripPkId);
				btTravelExpense.setTripType(targetTripType);
				BtTravelExpenseLocalServiceUtil
						.addBtTravelExpense(btTravelExpense);
			}
		}
	}

	public void deleteBtTravelExpenseByB_T(long businessTripPkId,
			String tripType) throws SystemException {
		List<BtTravelExpense> btTravelExpenseList = btTravelExpensePersistence
				.findByB_T(businessTripPkId, tripType, -1, -1);
		if (btTravelExpenseList != null && btTravelExpenseList.size() > 0) {
			for (BtTravelExpense btTravelExpense : btTravelExpenseList) {
				BtTravelExpenseLocalServiceUtil
						.deleteBtTravelExpense(btTravelExpense);
			}
		}
	}

	/**
	 * String startDate,String endDate,
	 * 
	 * @throws ParseException
	 **/
	public List<BusinessTripReimbursement> getDomesticBusinessTripReimbursementTravelExpenses(
			String startDate, String endDate, int start, int end)
			throws SystemException, ParseException {
		SimpleDateFormat sdf_dmy = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
		DynamicQuery query = new DynamicQueryFactoryUtil()
				.forClass(BusinessTripReimbursement.class);
		// query.add(RestrictionsFactoryUtil.eq("tripType", 0));
		query.add(RestrictionsFactoryUtil.eq("status", 0));
		query.add(RestrictionsFactoryUtil.eq("sapStatus", 1));
		query.add(RestrictionsFactoryUtil.gt("totalTravelExpenseRmb", 0d));
		query.add(RestrictionsFactoryUtil.gt("totalTravelExpenseEur", 0d));
		if (Validator.isNotNull(startDate) && (Validator.isNotNull(endDate))) {
			query.add(RestrictionsFactoryUtil.ge("statusDate",
					sdf_dmy.parse(startDate + " 00:00:00")));
			query.add(RestrictionsFactoryUtil.le("statusDate",
					sdf_dmy.parse(endDate + " 23:59:59")));
		}
		query.addOrder(OrderFactoryUtil.desc("ticketNo"));
		String tripType = PropsUtil
				.get("vgc.apon.business.trip.reimbursement.type");
		List<BusinessTripReimbursement> result = new ArrayList<BusinessTripReimbursement>();
		List<BusinessTripReimbursement> resultPages = new ArrayList<BusinessTripReimbursement>();
		List<BusinessTripReimbursement> reimbursements = dynamicQuery(query);
		for (int i = 0; i < reimbursements.size(); i++) {
			BusinessTripReimbursement businessTripReimbursement = reimbursements
					.get(i);
			List<BtTravelExpense> travelExpenses = BtTravelExpenseLocalServiceUtil
					.findByB_T(businessTripReimbursement
							.getBusinessTripReimbursementId(), tripType, 0,
							Integer.MAX_VALUE);
			for (BtTravelExpense btTravelExpense : travelExpenses) {
				if (btTravelExpense.getAllowance() > 0d
						&& btTravelExpense.getCurrency()
								.equalsIgnoreCase("RMB")) {
					result.add(businessTripReimbursement);
					break;
				}
			}
		}
		if (result.size() > 0) {
			for (int i = start; i < end; i++) {
				resultPages.add(result.get(i));
				if (result.size() - 1 == i) {
					break;
				}
			}
		}
		return resultPages;
		// query.setLimit(start, end);
		// return dynamicQuery(query);
	}

	public long getDomesticBusinessTripReimbursementTravelExpensesCount(
			String startDate, String endDate) throws SystemException,
			ParseException {
		SimpleDateFormat sdf_dmy = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
		DynamicQuery query = new DynamicQueryFactoryUtil()
				.forClass(BusinessTripReimbursement.class);
		query.add(RestrictionsFactoryUtil.eq("tripType", 0));
		query.add(RestrictionsFactoryUtil.eq("status", 0));
		query.add(RestrictionsFactoryUtil.eq("sapStatus", 1));
		query.add(RestrictionsFactoryUtil.gt("totalTravelExpenseRmb", 0d));
		query.add(RestrictionsFactoryUtil.gt("totalTravelExpenseEur", 0d));
		if (Validator.isNotNull(startDate) && (Validator.isNotNull(endDate))) {
			query.add(RestrictionsFactoryUtil.ge("statusDate",
					sdf_dmy.parse(startDate + " 00:00:00")));
			query.add(RestrictionsFactoryUtil.le("statusDate",
					sdf_dmy.parse(endDate + " 23:59:59")));
		}
		String tripType = PropsUtil
				.get("vgc.apon.business.trip.reimbursement.type");
		List<BusinessTripReimbursement> result = new ArrayList<BusinessTripReimbursement>();
		List<BusinessTripReimbursement> reimbursements = dynamicQuery(query);
		for (int i = 0; i < reimbursements.size(); i++) {
			BusinessTripReimbursement businessTripReimbursement = reimbursements
					.get(i);
			List<BtTravelExpense> travelExpenses = BtTravelExpenseLocalServiceUtil
					.findByB_T(businessTripReimbursement
							.getBusinessTripReimbursementId(), tripType, 0,
							Integer.MAX_VALUE);
			for (BtTravelExpense btTravelExpense : travelExpenses) {
				if (btTravelExpense.getAllowance() > 0d
						&& btTravelExpense.getCurrency()
								.equalsIgnoreCase("RMB")) {
					result.add(businessTripReimbursement);
					break;
				}
			}
		}
		return result.size();
		// return dynamicQueryCount(query);
	}

	public String getTravelExpenseStartOrEndDate(
			long businessTripReimbursementId, int flag) throws SystemException {
		String tripType = PropsUtil
				.get("vgc.apon.business.trip.reimbursement.type");
		List<BtTravelExpense> btTravelExpenseList = btTravelExpensePersistence
				.findByB_T(businessTripReimbursementId, tripType, -1, -1);
		if (btTravelExpenseList != null && btTravelExpenseList.size() > 0) {
			if (flag == 0) {// get Start Date
				return btTravelExpenseList.get(0).getTravelDate();
			} else {
				return btTravelExpenseList.get(btTravelExpenseList.size() - 1)
						.getTravelDate();
			}
		}
		return null;
	}

	public BtTravelExpense getTravelExpense(
			long businessTripReimbursementId) throws SystemException {
		String tripType = PropsUtil
				.get("vgc.apon.business.trip.reimbursement.type");
		List<BtTravelExpense> btTravelExpenseList = btTravelExpensePersistence
				.findByB_T(businessTripReimbursementId, tripType, -1, -1);
		if (btTravelExpenseList != null && btTravelExpenseList.size() > 0) {
			return btTravelExpenseList.get(0);
		}
		return null;
	}
	
	public double getAllowance(String today,Date fromTravelDate,Date toTravelDate,String departure,String arrival,double rateOfDma,boolean isHasBreakfast,boolean isHasLunch,boolean isHasDinner) throws ParseException{
		double allowance = 0;
//		int days = TravelExpenseUtil.daysBetween(fromTravelDate, toTravelDate);
		
		System.out.println("today:"+today + "fromTravelDate:"+fromTravelDate+"departure:"+toTravelDate);
		
		Date todayDate = TravelExpenseUtil.StringToDate(today, "dd.MM.yyyy");
		
//		long todayFromBetween = todayDate.getTime()-fromTravelDate.getTime();
//		long todayToBetween = todayDate.getTime() - toTravelDate.getTime();
		
		if(TravelExpenseUtil.eqTravelExpenseDate(fromTravelDate, toTravelDate)){
			allowance=getAllowanceWithinOneDay(departure, arrival, rateOfDma,isHasBreakfast, isHasLunch, isHasDinner);
		}else{
			if(TravelExpenseUtil.eqTravelExpenseDate(todayDate, fromTravelDate)){
				allowance=getAllowanceTwoDaysDeparture(departure, arrival, rateOfDma,isHasBreakfast, isHasLunch, isHasDinner);
			}else if(TravelExpenseUtil.eqTravelExpenseDate(todayDate, toTravelDate)){
				allowance=getAllowanceTwoDaysArrival(departure, arrival, rateOfDma,isHasBreakfast, isHasLunch, isHasDinner);
			}else{
				allowance=getAllowanceWithinOneDay("00:00", "23:59", rateOfDma,isHasBreakfast, isHasLunch, isHasDinner);
			}
		}
//		if(days==1){
//			allowance=getAllowanceOneDay(departure, arrival, rateOfDma);
//		}else if(days==2){
//			if(todayFromBetween==0){
//				allowance=getAllowanceTwoDaysFirst(departure, arrival, rateOfDma);
//			}else{
//				allowance=getAllowanceTwoDaysSecond(departure, arrival, rateOfDma);
//			}
//		}else{
//			if(todayFromBetween==0){
//				allowance=getAllowanceTwoDaysFirst(departure, arrival, rateOfDma);
//			}else if(todayToBetween==0){
//				allowance=getAllowanceTwoDaysSecond(departure, arrival, rateOfDma);
//			}else{
//				allowance=getAllowanceOneDay("00:00", "23:59", rateOfDma);
//			}
//		}
		

		
		return allowance;
	}
   private double getAllowanceWithinOneDay(String departure,String arrival,double rateOfDma,boolean isHasBreakfast,boolean isHasLunch,boolean isHasDinner){
		double allowance = 0;
		if (departure.equals("00:00") && arrival.equals("23:59")) {
			allowance = rateOfDma;
		} else {
			float timesub = TravelExpenseUtil.timeBetween(departure,arrival);
			if (timesub > 12) {
				allowance = rateOfDma;
			} else if (timesub > 10 && timesub <= 12) {
				allowance = rateOfDma * 0.8;
			} else if (timesub > 7 && timesub <= 10) {
				allowance = rateOfDma * 0.5;
			} else if (timesub >= 5 && timesub <= 7) {
				allowance = rateOfDma * 0.3;
			} else {
				allowance = 0d;
			}
		}
		
		if (!isHasBreakfast) {
			allowance -= rateOfDma * 0.2;
		}
		if (!isHasLunch) {
			allowance -= rateOfDma * 0.3;
		}
		if (!isHasDinner) {
			allowance -= rateOfDma * 0.3;
		}
		if (allowance < rateOfDma * 0.2) {
			allowance = rateOfDma * 0.2;
		}
		
		System.out.println("getAllowanceOneDay" + departure+arrival);
		
		return allowance;
	}
   
   
   /**
    * Departure before 12:00 100%
    *                  14:00  80%
    *                  17:00  50%
    *                  19:00  30%
    *         after    19:00    0%
    * @param departure
    * @param arrival
    * @param rateOfDma
    * @param isHasBreakfast
    * @param isHasLunch
    * @param isHasDinner
    * @return
    */
   private double getAllowanceTwoDaysDeparture(String departure,String arrival,double rateOfDma,boolean isHasBreakfast,boolean isHasLunch,boolean isHasDinner){
		double allowance = 0;
		
		int departureDate = Integer.parseInt(departure.replaceAll(":",""));
		System.out.println("departureDate" + departureDate);
		if(departureDate<=1200){
			    allowance = rateOfDma;
				if(!isHasBreakfast){
					allowance -= rateOfDma * 0.2;
				}
				if(!isHasLunch){
					allowance -= rateOfDma * 0.3;
				}
				if(!isHasDinner){
					allowance -= rateOfDma * 0.3;
				}
		}else if(departureDate > 1200 && departureDate <= 1400){
				allowance = rateOfDma*0.8;
				if(!isHasLunch){
					allowance -= rateOfDma * 0.3;
				}
				if(!isHasDinner){
					allowance -= rateOfDma * 0.3;
				}
		}else if(departureDate > 1400 && departureDate <= 1700){
				allowance = rateOfDma*0.5;
				if(!isHasDinner){
					allowance -= rateOfDma * 0.3;
				}
		}else if(departureDate > 1700 && departureDate <= 1900){
				if (!isHasDinner) {
					allowance = rateOfDma*0.2;
				}else{
					allowance = rateOfDma*0.3;
				}
		}else{
			 allowance = rateOfDma*0.2;
		}
		System.out.println("***getAllowanceTwoDaysFirst ****allowance" +allowance);
		System.out.println("getAllowanceTwoDaysFirst" + departure+arrival);
		
		return allowance;
	}
   
   
   /**
    * Arrival before  5:00    0%
    *                 5:00   30%
    *                 7:00   50%
    *                 10:00   80%
    *          after  12:00 100%
    * @param departure
    * @param arrival
    * @param rateOfDma
    * @param isHasBreakfast
    * @param isHasLunch
    * @param isHasDinner
    * @return
    */
 private double getAllowanceTwoDaysArrival(String departure,String arrival,double rateOfDma,boolean isHasBreakfast,boolean isHasLunch,boolean isHasDinner){
	   double allowance = 0;
	   int arrivalDate = Integer.parseInt(arrival.replaceAll(":",""));
	   System.out.println("arrivalDate" + arrivalDate);
	   
		if (arrivalDate >= 1200) {
			allowance = rateOfDma;
			if (!isHasBreakfast) {
				allowance -= rateOfDma * 0.2;
			}
			if (!isHasLunch) {
				allowance -= rateOfDma * 0.3;
			}
			if (!isHasDinner) {
				allowance -= rateOfDma * 0.3;
			}
		} else {
			if (arrivalDate < 500) {
				allowance = rateOfDma * 0.2;
			} else if (arrivalDate >= 500 && arrivalDate < 700) {
				if (isHasBreakfast) {
					allowance = rateOfDma * 0.3;
				} else {
					allowance = rateOfDma * 0.2;
				}
			} else if (arrivalDate >= 700 && arrivalDate < 1000) {
				allowance = rateOfDma * 0.3;
				if (isHasBreakfast) {
					allowance += rateOfDma * 0.2;
				}
			} else if (arrivalDate >= 1000 && arrivalDate < 1200) {
				allowance = rateOfDma * 0.3;
				if (isHasBreakfast) {
					allowance += rateOfDma * 0.2;
				}
				if (isHasLunch) {
					allowance += rateOfDma * 0.3;
				}
			}
		}
	   
	    System.out.println("***getAllowanceTwoDaysSecond ****allowance" +allowance); 
		System.out.println("getAllowanceTwoDaysSecond" + departure+arrival);
	   return allowance;
   }
   
	/**
	 * To corrected the history data  cost list netAmountRMB value
	 * @param businessTripReimbursementId
	 * @throws SystemException 
	 */
	public void  correctAmountRmbDAOfHistoryData(long businessTripReimbursementId) throws SystemException{
		List<BtTravelExpense>  allowanceList =	btTravelExpensePersistence.findByBusinessTripPkId(businessTripReimbursementId);
		if(allowanceList != null){
			for(BtTravelExpense allowance : allowanceList){
				if("RMB".equals(allowance.getCurrency())){
					allowance.setAllowanceRmb(allowance.getAllowance());
				}else{
					if(allowance.getAllowanceRmb() == 0 || allowance.getAllowanceRmb()== allowance.getAllowance()){
						allowance.setAllowanceRmb(BtExchangeRateLocalServiceUtil.changeEURToRMB(allowance.getAllowance()));
					}
				}
				this.updateBtTravelExpense(allowance);
			}
		}
		
	}
}