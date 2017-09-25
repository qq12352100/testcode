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

package com.business.trip.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link BtCostList}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BtCostList
 * @generated
 */
public class BtCostListWrapper implements BtCostList, ModelWrapper<BtCostList> {
	public BtCostListWrapper(BtCostList btCostList) {
		_btCostList = btCostList;
	}

	@Override
	public Class<?> getModelClass() {
		return BtCostList.class;
	}

	@Override
	public String getModelClassName() {
		return BtCostList.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("btCostListId", getBtCostListId());
		attributes.put("businessTripPkId", getBusinessTripPkId());
		attributes.put("ticketNo", getTicketNo());
		attributes.put("item", getItem());
		attributes.put("invoiceCurrency", getInvoiceCurrency());
		attributes.put("paymentAmount", getPaymentAmount());
		attributes.put("paymentCurrency", getPaymentCurrency());
		attributes.put("countryCity", getCountryCity());
		attributes.put("type", getType());
		attributes.put("invoiceAmount", getInvoiceAmount());
		attributes.put("taxRate", getTaxRate());
		attributes.put("netAmount", getNetAmount());
		attributes.put("taxAmount", getTaxAmount());
		attributes.put("netAmountRmb", getNetAmountRmb());
		attributes.put("entertainmentDate", getEntertainmentDate());
		attributes.put("entertainmentPlace", getEntertainmentPlace());
		attributes.put("reasonesInfo", getReasonesInfo());
		attributes.put("attendeesTotal", getAttendeesTotal());
		attributes.put("averageSpend", getAverageSpend());
		attributes.put("mealCategory", getMealCategory());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long btCostListId = (Long)attributes.get("btCostListId");

		if (btCostListId != null) {
			setBtCostListId(btCostListId);
		}

		Long businessTripPkId = (Long)attributes.get("businessTripPkId");

		if (businessTripPkId != null) {
			setBusinessTripPkId(businessTripPkId);
		}

		String ticketNo = (String)attributes.get("ticketNo");

		if (ticketNo != null) {
			setTicketNo(ticketNo);
		}

		String item = (String)attributes.get("item");

		if (item != null) {
			setItem(item);
		}

		String invoiceCurrency = (String)attributes.get("invoiceCurrency");

		if (invoiceCurrency != null) {
			setInvoiceCurrency(invoiceCurrency);
		}

		Double paymentAmount = (Double)attributes.get("paymentAmount");

		if (paymentAmount != null) {
			setPaymentAmount(paymentAmount);
		}

		String paymentCurrency = (String)attributes.get("paymentCurrency");

		if (paymentCurrency != null) {
			setPaymentCurrency(paymentCurrency);
		}

		String countryCity = (String)attributes.get("countryCity");

		if (countryCity != null) {
			setCountryCity(countryCity);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		Double invoiceAmount = (Double)attributes.get("invoiceAmount");

		if (invoiceAmount != null) {
			setInvoiceAmount(invoiceAmount);
		}

		Double taxRate = (Double)attributes.get("taxRate");

		if (taxRate != null) {
			setTaxRate(taxRate);
		}

		Double netAmount = (Double)attributes.get("netAmount");

		if (netAmount != null) {
			setNetAmount(netAmount);
		}

		Double taxAmount = (Double)attributes.get("taxAmount");

		if (taxAmount != null) {
			setTaxAmount(taxAmount);
		}

		Double netAmountRmb = (Double)attributes.get("netAmountRmb");

		if (netAmountRmb != null) {
			setNetAmountRmb(netAmountRmb);
		}

		Date entertainmentDate = (Date)attributes.get("entertainmentDate");

		if (entertainmentDate != null) {
			setEntertainmentDate(entertainmentDate);
		}

		String entertainmentPlace = (String)attributes.get("entertainmentPlace");

		if (entertainmentPlace != null) {
			setEntertainmentPlace(entertainmentPlace);
		}

		String reasonesInfo = (String)attributes.get("reasonesInfo");

		if (reasonesInfo != null) {
			setReasonesInfo(reasonesInfo);
		}

		Integer attendeesTotal = (Integer)attributes.get("attendeesTotal");

		if (attendeesTotal != null) {
			setAttendeesTotal(attendeesTotal);
		}

		Double averageSpend = (Double)attributes.get("averageSpend");

		if (averageSpend != null) {
			setAverageSpend(averageSpend);
		}

		String mealCategory = (String)attributes.get("mealCategory");

		if (mealCategory != null) {
			setMealCategory(mealCategory);
		}
	}

	/**
	* Returns the primary key of this bt cost list.
	*
	* @return the primary key of this bt cost list
	*/
	@Override
	public long getPrimaryKey() {
		return _btCostList.getPrimaryKey();
	}

	/**
	* Sets the primary key of this bt cost list.
	*
	* @param primaryKey the primary key of this bt cost list
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_btCostList.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the bt cost list ID of this bt cost list.
	*
	* @return the bt cost list ID of this bt cost list
	*/
	@Override
	public long getBtCostListId() {
		return _btCostList.getBtCostListId();
	}

	/**
	* Sets the bt cost list ID of this bt cost list.
	*
	* @param btCostListId the bt cost list ID of this bt cost list
	*/
	@Override
	public void setBtCostListId(long btCostListId) {
		_btCostList.setBtCostListId(btCostListId);
	}

	/**
	* Returns the business trip pk ID of this bt cost list.
	*
	* @return the business trip pk ID of this bt cost list
	*/
	@Override
	public long getBusinessTripPkId() {
		return _btCostList.getBusinessTripPkId();
	}

	/**
	* Sets the business trip pk ID of this bt cost list.
	*
	* @param businessTripPkId the business trip pk ID of this bt cost list
	*/
	@Override
	public void setBusinessTripPkId(long businessTripPkId) {
		_btCostList.setBusinessTripPkId(businessTripPkId);
	}

	/**
	* Returns the ticket no of this bt cost list.
	*
	* @return the ticket no of this bt cost list
	*/
	@Override
	public java.lang.String getTicketNo() {
		return _btCostList.getTicketNo();
	}

	/**
	* Sets the ticket no of this bt cost list.
	*
	* @param ticketNo the ticket no of this bt cost list
	*/
	@Override
	public void setTicketNo(java.lang.String ticketNo) {
		_btCostList.setTicketNo(ticketNo);
	}

	/**
	* Returns the item of this bt cost list.
	*
	* @return the item of this bt cost list
	*/
	@Override
	public java.lang.String getItem() {
		return _btCostList.getItem();
	}

	/**
	* Sets the item of this bt cost list.
	*
	* @param item the item of this bt cost list
	*/
	@Override
	public void setItem(java.lang.String item) {
		_btCostList.setItem(item);
	}

	/**
	* Returns the invoice currency of this bt cost list.
	*
	* @return the invoice currency of this bt cost list
	*/
	@Override
	public java.lang.String getInvoiceCurrency() {
		return _btCostList.getInvoiceCurrency();
	}

	/**
	* Sets the invoice currency of this bt cost list.
	*
	* @param invoiceCurrency the invoice currency of this bt cost list
	*/
	@Override
	public void setInvoiceCurrency(java.lang.String invoiceCurrency) {
		_btCostList.setInvoiceCurrency(invoiceCurrency);
	}

	/**
	* Returns the payment amount of this bt cost list.
	*
	* @return the payment amount of this bt cost list
	*/
	@Override
	public double getPaymentAmount() {
		return _btCostList.getPaymentAmount();
	}

	/**
	* Sets the payment amount of this bt cost list.
	*
	* @param paymentAmount the payment amount of this bt cost list
	*/
	@Override
	public void setPaymentAmount(double paymentAmount) {
		_btCostList.setPaymentAmount(paymentAmount);
	}

	/**
	* Returns the payment currency of this bt cost list.
	*
	* @return the payment currency of this bt cost list
	*/
	@Override
	public java.lang.String getPaymentCurrency() {
		return _btCostList.getPaymentCurrency();
	}

	/**
	* Sets the payment currency of this bt cost list.
	*
	* @param paymentCurrency the payment currency of this bt cost list
	*/
	@Override
	public void setPaymentCurrency(java.lang.String paymentCurrency) {
		_btCostList.setPaymentCurrency(paymentCurrency);
	}

	/**
	* Returns the country city of this bt cost list.
	*
	* @return the country city of this bt cost list
	*/
	@Override
	public java.lang.String getCountryCity() {
		return _btCostList.getCountryCity();
	}

	/**
	* Sets the country city of this bt cost list.
	*
	* @param countryCity the country city of this bt cost list
	*/
	@Override
	public void setCountryCity(java.lang.String countryCity) {
		_btCostList.setCountryCity(countryCity);
	}

	/**
	* Returns the type of this bt cost list.
	*
	* @return the type of this bt cost list
	*/
	@Override
	public java.lang.String getType() {
		return _btCostList.getType();
	}

	/**
	* Sets the type of this bt cost list.
	*
	* @param type the type of this bt cost list
	*/
	@Override
	public void setType(java.lang.String type) {
		_btCostList.setType(type);
	}

	/**
	* Returns the invoice amount of this bt cost list.
	*
	* @return the invoice amount of this bt cost list
	*/
	@Override
	public double getInvoiceAmount() {
		return _btCostList.getInvoiceAmount();
	}

	/**
	* Sets the invoice amount of this bt cost list.
	*
	* @param invoiceAmount the invoice amount of this bt cost list
	*/
	@Override
	public void setInvoiceAmount(double invoiceAmount) {
		_btCostList.setInvoiceAmount(invoiceAmount);
	}

	/**
	* Returns the tax rate of this bt cost list.
	*
	* @return the tax rate of this bt cost list
	*/
	@Override
	public double getTaxRate() {
		return _btCostList.getTaxRate();
	}

	/**
	* Sets the tax rate of this bt cost list.
	*
	* @param taxRate the tax rate of this bt cost list
	*/
	@Override
	public void setTaxRate(double taxRate) {
		_btCostList.setTaxRate(taxRate);
	}

	/**
	* Returns the net amount of this bt cost list.
	*
	* @return the net amount of this bt cost list
	*/
	@Override
	public double getNetAmount() {
		return _btCostList.getNetAmount();
	}

	/**
	* Sets the net amount of this bt cost list.
	*
	* @param netAmount the net amount of this bt cost list
	*/
	@Override
	public void setNetAmount(double netAmount) {
		_btCostList.setNetAmount(netAmount);
	}

	/**
	* Returns the tax amount of this bt cost list.
	*
	* @return the tax amount of this bt cost list
	*/
	@Override
	public double getTaxAmount() {
		return _btCostList.getTaxAmount();
	}

	/**
	* Sets the tax amount of this bt cost list.
	*
	* @param taxAmount the tax amount of this bt cost list
	*/
	@Override
	public void setTaxAmount(double taxAmount) {
		_btCostList.setTaxAmount(taxAmount);
	}

	/**
	* Returns the net amount rmb of this bt cost list.
	*
	* @return the net amount rmb of this bt cost list
	*/
	@Override
	public double getNetAmountRmb() {
		return _btCostList.getNetAmountRmb();
	}

	/**
	* Sets the net amount rmb of this bt cost list.
	*
	* @param netAmountRmb the net amount rmb of this bt cost list
	*/
	@Override
	public void setNetAmountRmb(double netAmountRmb) {
		_btCostList.setNetAmountRmb(netAmountRmb);
	}

	/**
	* Returns the entertainment date of this bt cost list.
	*
	* @return the entertainment date of this bt cost list
	*/
	@Override
	public java.util.Date getEntertainmentDate() {
		return _btCostList.getEntertainmentDate();
	}

	/**
	* Sets the entertainment date of this bt cost list.
	*
	* @param entertainmentDate the entertainment date of this bt cost list
	*/
	@Override
	public void setEntertainmentDate(java.util.Date entertainmentDate) {
		_btCostList.setEntertainmentDate(entertainmentDate);
	}

	/**
	* Returns the entertainment place of this bt cost list.
	*
	* @return the entertainment place of this bt cost list
	*/
	@Override
	public java.lang.String getEntertainmentPlace() {
		return _btCostList.getEntertainmentPlace();
	}

	/**
	* Sets the entertainment place of this bt cost list.
	*
	* @param entertainmentPlace the entertainment place of this bt cost list
	*/
	@Override
	public void setEntertainmentPlace(java.lang.String entertainmentPlace) {
		_btCostList.setEntertainmentPlace(entertainmentPlace);
	}

	/**
	* Returns the reasones info of this bt cost list.
	*
	* @return the reasones info of this bt cost list
	*/
	@Override
	public java.lang.String getReasonesInfo() {
		return _btCostList.getReasonesInfo();
	}

	/**
	* Sets the reasones info of this bt cost list.
	*
	* @param reasonesInfo the reasones info of this bt cost list
	*/
	@Override
	public void setReasonesInfo(java.lang.String reasonesInfo) {
		_btCostList.setReasonesInfo(reasonesInfo);
	}

	/**
	* Returns the attendees total of this bt cost list.
	*
	* @return the attendees total of this bt cost list
	*/
	@Override
	public int getAttendeesTotal() {
		return _btCostList.getAttendeesTotal();
	}

	/**
	* Sets the attendees total of this bt cost list.
	*
	* @param attendeesTotal the attendees total of this bt cost list
	*/
	@Override
	public void setAttendeesTotal(int attendeesTotal) {
		_btCostList.setAttendeesTotal(attendeesTotal);
	}

	/**
	* Returns the average spend of this bt cost list.
	*
	* @return the average spend of this bt cost list
	*/
	@Override
	public double getAverageSpend() {
		return _btCostList.getAverageSpend();
	}

	/**
	* Sets the average spend of this bt cost list.
	*
	* @param averageSpend the average spend of this bt cost list
	*/
	@Override
	public void setAverageSpend(double averageSpend) {
		_btCostList.setAverageSpend(averageSpend);
	}

	/**
	* Returns the meal category of this bt cost list.
	*
	* @return the meal category of this bt cost list
	*/
	@Override
	public java.lang.String getMealCategory() {
		return _btCostList.getMealCategory();
	}

	/**
	* Sets the meal category of this bt cost list.
	*
	* @param mealCategory the meal category of this bt cost list
	*/
	@Override
	public void setMealCategory(java.lang.String mealCategory) {
		_btCostList.setMealCategory(mealCategory);
	}

	@Override
	public boolean isNew() {
		return _btCostList.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_btCostList.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _btCostList.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_btCostList.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _btCostList.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _btCostList.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_btCostList.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _btCostList.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_btCostList.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_btCostList.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_btCostList.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BtCostListWrapper((BtCostList)_btCostList.clone());
	}

	@Override
	public int compareTo(com.business.trip.model.BtCostList btCostList) {
		return _btCostList.compareTo(btCostList);
	}

	@Override
	public int hashCode() {
		return _btCostList.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.business.trip.model.BtCostList> toCacheModel() {
		return _btCostList.toCacheModel();
	}

	@Override
	public com.business.trip.model.BtCostList toEscapedModel() {
		return new BtCostListWrapper(_btCostList.toEscapedModel());
	}

	@Override
	public com.business.trip.model.BtCostList toUnescapedModel() {
		return new BtCostListWrapper(_btCostList.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _btCostList.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _btCostList.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_btCostList.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BtCostListWrapper)) {
			return false;
		}

		BtCostListWrapper btCostListWrapper = (BtCostListWrapper)obj;

		if (Validator.equals(_btCostList, btCostListWrapper._btCostList)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public BtCostList getWrappedBtCostList() {
		return _btCostList;
	}

	@Override
	public BtCostList getWrappedModel() {
		return _btCostList;
	}

	@Override
	public void resetOriginalValues() {
		_btCostList.resetOriginalValues();
	}

	private BtCostList _btCostList;
}