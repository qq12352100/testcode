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

import java.math.BigDecimal;
import java.util.List;

import com.business.trip.model.BtCostList;
import com.business.trip.model.BtExchangeRate;
import com.business.trip.service.BtExchangeRateLocalServiceUtil;
import com.business.trip.service.base.BtCostListLocalServiceBaseImpl;
import com.business.trip.util.BTApplicationUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the bt cost list local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.business.trip.service.BtCostListLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.business.trip.service.base.BtCostListLocalServiceBaseImpl
 * @see com.business.trip.service.BtCostListLocalServiceUtil
 */
public class BtCostListLocalServiceImpl extends BtCostListLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.business.trip.service.BtCostListLocalServiceUtil} to access the bt cost list local service.
	 */	
	public int findCountByBusinessTripPkId(long businessTripPkId) throws SystemException {
		return  btCostListPersistence.countByBusinessTripPkId(businessTripPkId);
	}
	
	public List<BtCostList> findByBusinessTripPkId(long businessTripPkId,int start,int end) throws SystemException {
		return btCostListPersistence.findByBusinessTripPkId(businessTripPkId, start, end);
	}
	public List<BtCostList> findByB_C(long businessTripPkId,String paymentCurrency) throws SystemException {
		return btCostListPersistence.findByB_C(businessTripPkId, paymentCurrency);
	}
	
	public Double findSumByCurrency(long businessTripPkId,String paymentCurrency,List<String> items) throws SystemException{
		DynamicQuery query = DynamicQueryFactoryUtil
				.forClass(BtCostList.class);
		query.setProjection(ProjectionFactoryUtil.sum("netAmount"));
		query.add(RestrictionsFactoryUtil.eq("paymentCurrency", paymentCurrency));
		query.add(RestrictionsFactoryUtil.eq("businessTripPkId", businessTripPkId));
		Criterion criterion = null;
		for(String item:items){
			if(criterion==null){
				criterion = RestrictionsFactoryUtil.eq("item", item);
			}else{
				criterion=RestrictionsFactoryUtil.or(criterion,RestrictionsFactoryUtil.eq("item", item));
			}
		}
		query.add(criterion);
		List<Double>  sumlist=dynamicQuery(query);
		if(null!=sumlist&&sumlist.size()>0&&criterion!=null){
			return sumlist.get(0)==null?0:sumlist.get(0);
		}else{
			return 0d;
		}
	}
	
	public Double findSumEntertainmentByCurrency(long businessTripPkId,String paymentCurrency,List<String> items) throws SystemException{
		DynamicQuery query = DynamicQueryFactoryUtil
				.forClass(BtCostList.class);
		query.setProjection(ProjectionFactoryUtil.sum("invoiceAmount"));
		query.add(RestrictionsFactoryUtil.eq("paymentCurrency", paymentCurrency));
		query.add(RestrictionsFactoryUtil.eq("businessTripPkId", businessTripPkId));
		Criterion criterion = null;
		for(String item:items){
			if(criterion==null){
				criterion = RestrictionsFactoryUtil.eq("item", item);
			}else{
				criterion=RestrictionsFactoryUtil.or(criterion,RestrictionsFactoryUtil.eq("item", item));
			}
		}
		query.add(criterion);
		List<Double>  sumlist=dynamicQuery(query);
		if(null!=sumlist&&sumlist.size()>0&&criterion!=null){
			return sumlist.get(0)==null?0:sumlist.get(0);
		}else{
			return 0d;
		}
	}
	
	
	public Double findSumNetAmountRmbByCurrency(long businessTripPkId,String paymentCurrency,List<String> items) throws SystemException{
		DynamicQuery query = DynamicQueryFactoryUtil
				.forClass(BtCostList.class);
		query.setProjection(ProjectionFactoryUtil.sum("netAmountRmb"));
		query.add(RestrictionsFactoryUtil.eq("paymentCurrency", paymentCurrency));
		query.add(RestrictionsFactoryUtil.eq("businessTripPkId", businessTripPkId));
		Criterion criterion = null;
		for(String item:items){
			if(criterion==null){
				criterion = RestrictionsFactoryUtil.eq("item", item);
			}else{
				criterion=RestrictionsFactoryUtil.or(criterion,RestrictionsFactoryUtil.eq("item", item));
			}
		}
		query.add(criterion);
		List<Double>  sumlist=dynamicQuery(query);
		if(null!=sumlist&&sumlist.size()>0&&criterion!=null){
			return sumlist.get(0)==null?0:sumlist.get(0);
		}else{
			return 0d;
		}
	}
	
	
	public Double findSumTaxByCurrency(long businessTripPkId,String paymentCurrency,List<String> items) throws SystemException{
		DynamicQuery query = DynamicQueryFactoryUtil
				.forClass(BtCostList.class);
		query.setProjection(ProjectionFactoryUtil.sum("taxAmount"));
		query.add(RestrictionsFactoryUtil.eq("paymentCurrency", paymentCurrency));
		query.add(RestrictionsFactoryUtil.eq("businessTripPkId", businessTripPkId));
		Criterion criterion = null;
		for(String item:items){
			if(criterion==null){
				criterion = RestrictionsFactoryUtil.eq("item", item);
			}else{
				criterion=RestrictionsFactoryUtil.or(criterion,RestrictionsFactoryUtil.eq("item", item));
			}
		}
		query.add(criterion);
		List<Double>  sumlist=dynamicQuery(query);
		if(null!=sumlist&&sumlist.size()>0&&criterion!=null){
			return sumlist.get(0)==null?0:sumlist.get(0);
		}else{
			return 0d;
		}
	}
	
	@SuppressWarnings("unchecked")
	public boolean isEntertainmentCondition(long businessTripPkId,int type) throws SystemException {
		boolean isEntertainment=false;
		double d=0d;
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(BtCostList.class);
		query.add(PropertyFactoryUtil.forName("businessTripPkId").eq(
				businessTripPkId));
		query.add(PropertyFactoryUtil.forName("item").eq("Entertainment"));
		List<BtCostList> list=dynamicQuery(query);
		if(list!=null&&list.size()>0){
			for(BtCostList btCostList:list){
				if(btCostList.getPaymentCurrency().equals("RMB")){
					d=400d;
				}else{
					d=BTApplicationUtil.addCalculate(0d, "EUR", 400d, "RMB");
				}
				if(type==0&&btCostList.getAverageSpend()>0d){
					isEntertainment=true;
					break;
				}else if(type==1&&btCostList.getAverageSpend()>0d&&btCostList.getAverageSpend()<d){
					isEntertainment=true;
					break;
				}
			}
		}
		return isEntertainment;
	}
	
	public double addCalculate(double oldTotal,String totalCurrency,double amount,String currency) throws SystemException {
		double newTotal = oldTotal;
		if(currency.equals(totalCurrency)) {
			newTotal = oldTotal + amount;
		}else {
			BtExchangeRate btExchangeRate = BtExchangeRateLocalServiceUtil.fetchByF_S_S(currency, totalCurrency, 0);
			if(btExchangeRate!=null) {
				newTotal = oldTotal + amount*btExchangeRate.getFirToSecExchangeRate();
			}else {
				btExchangeRate = BtExchangeRateLocalServiceUtil.fetchByF_S_S(totalCurrency, currency, 0);
				newTotal = btExchangeRate!=null?oldTotal + amount*btExchangeRate.getSecToFirExchangeRate():newTotal;				
			}
		}
		return newTotal;
	}
	
	/**
	 * To corrected the history data  cost list netAmountRMB value
	 * @param businessTripReimbursementId
	 * @throws SystemException 
	 */
	public void  correctAmountRmbCostListOfHistoryData(long businessTripReimbursementId) throws SystemException{
		List<BtCostList> costList =	btCostListPersistence.findByBusinessTripPkId(businessTripReimbursementId);
		if(costList != null){
			BigDecimal bd2 = null;
			for(BtCostList cost : costList){
				if(cost.getNetAmount()==0.0){
					bd2 = new BigDecimal(cost.getPaymentAmount()-cost.getTaxAmount());
					cost.setNetAmount( bd2.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());
				}else if("RMB".equals(cost.getPaymentCurrency())&&cost.getTaxAmount()==0.0){
					bd2 = new BigDecimal(cost.getPaymentAmount()-cost.getNetAmount());
					cost.setTaxAmount( bd2.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());
				}
				if("RMB".equals(cost.getPaymentCurrency())){
					cost.setNetAmountRmb(cost.getPaymentAmount());
				}else{
					if(cost.getNetAmountRmb() == 0 || cost.getNetAmountRmb()== cost.getPaymentAmount()){
						cost.setNetAmountRmb(BtExchangeRateLocalServiceUtil.changeEURToRMB(cost.getPaymentAmount()));
					}
				}
				this.updateBtCostList(cost);
			}
		}
		
	}
}