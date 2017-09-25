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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link BtTravelExpense}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BtTravelExpense
 * @generated
 */
public class BtTravelExpenseWrapper implements BtTravelExpense,
	ModelWrapper<BtTravelExpense> {
	public BtTravelExpenseWrapper(BtTravelExpense btTravelExpense) {
		_btTravelExpense = btTravelExpense;
	}

	@Override
	public Class<?> getModelClass() {
		return BtTravelExpense.class;
	}

	@Override
	public String getModelClassName() {
		return BtTravelExpense.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("btTravelExpenseId", getBtTravelExpenseId());
		attributes.put("businessTripPkId", getBusinessTripPkId());
		attributes.put("ticketNo", getTicketNo());
		attributes.put("travelDate", getTravelDate());
		attributes.put("departure", getDeparture());
		attributes.put("arrival", getArrival());
		attributes.put("fromCity", getFromCity());
		attributes.put("toCity", getToCity());
		attributes.put("isHasBreakfast", getIsHasBreakfast());
		attributes.put("isHasLunch", getIsHasLunch());
		attributes.put("isHasDinner", getIsHasDinner());
		attributes.put("country", getCountry());
		attributes.put("city", getCity());
		attributes.put("rateOfDma", getRateOfDma());
		attributes.put("currency", getCurrency());
		attributes.put("allowance", getAllowance());
		attributes.put("comments", getComments());
		attributes.put("tripType", getTripType());
		attributes.put("allowanceRmb", getAllowanceRmb());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long btTravelExpenseId = (Long)attributes.get("btTravelExpenseId");

		if (btTravelExpenseId != null) {
			setBtTravelExpenseId(btTravelExpenseId);
		}

		Long businessTripPkId = (Long)attributes.get("businessTripPkId");

		if (businessTripPkId != null) {
			setBusinessTripPkId(businessTripPkId);
		}

		String ticketNo = (String)attributes.get("ticketNo");

		if (ticketNo != null) {
			setTicketNo(ticketNo);
		}

		String travelDate = (String)attributes.get("travelDate");

		if (travelDate != null) {
			setTravelDate(travelDate);
		}

		String departure = (String)attributes.get("departure");

		if (departure != null) {
			setDeparture(departure);
		}

		String arrival = (String)attributes.get("arrival");

		if (arrival != null) {
			setArrival(arrival);
		}

		String fromCity = (String)attributes.get("fromCity");

		if (fromCity != null) {
			setFromCity(fromCity);
		}

		String toCity = (String)attributes.get("toCity");

		if (toCity != null) {
			setToCity(toCity);
		}

		Boolean isHasBreakfast = (Boolean)attributes.get("isHasBreakfast");

		if (isHasBreakfast != null) {
			setIsHasBreakfast(isHasBreakfast);
		}

		Boolean isHasLunch = (Boolean)attributes.get("isHasLunch");

		if (isHasLunch != null) {
			setIsHasLunch(isHasLunch);
		}

		Boolean isHasDinner = (Boolean)attributes.get("isHasDinner");

		if (isHasDinner != null) {
			setIsHasDinner(isHasDinner);
		}

		String country = (String)attributes.get("country");

		if (country != null) {
			setCountry(country);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		Double rateOfDma = (Double)attributes.get("rateOfDma");

		if (rateOfDma != null) {
			setRateOfDma(rateOfDma);
		}

		String currency = (String)attributes.get("currency");

		if (currency != null) {
			setCurrency(currency);
		}

		Double allowance = (Double)attributes.get("allowance");

		if (allowance != null) {
			setAllowance(allowance);
		}

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
		}

		String tripType = (String)attributes.get("tripType");

		if (tripType != null) {
			setTripType(tripType);
		}

		Double allowanceRmb = (Double)attributes.get("allowanceRmb");

		if (allowanceRmb != null) {
			setAllowanceRmb(allowanceRmb);
		}
	}

	/**
	* Returns the primary key of this bt travel expense.
	*
	* @return the primary key of this bt travel expense
	*/
	@Override
	public long getPrimaryKey() {
		return _btTravelExpense.getPrimaryKey();
	}

	/**
	* Sets the primary key of this bt travel expense.
	*
	* @param primaryKey the primary key of this bt travel expense
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_btTravelExpense.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the bt travel expense ID of this bt travel expense.
	*
	* @return the bt travel expense ID of this bt travel expense
	*/
	@Override
	public long getBtTravelExpenseId() {
		return _btTravelExpense.getBtTravelExpenseId();
	}

	/**
	* Sets the bt travel expense ID of this bt travel expense.
	*
	* @param btTravelExpenseId the bt travel expense ID of this bt travel expense
	*/
	@Override
	public void setBtTravelExpenseId(long btTravelExpenseId) {
		_btTravelExpense.setBtTravelExpenseId(btTravelExpenseId);
	}

	/**
	* Returns the business trip pk ID of this bt travel expense.
	*
	* @return the business trip pk ID of this bt travel expense
	*/
	@Override
	public long getBusinessTripPkId() {
		return _btTravelExpense.getBusinessTripPkId();
	}

	/**
	* Sets the business trip pk ID of this bt travel expense.
	*
	* @param businessTripPkId the business trip pk ID of this bt travel expense
	*/
	@Override
	public void setBusinessTripPkId(long businessTripPkId) {
		_btTravelExpense.setBusinessTripPkId(businessTripPkId);
	}

	/**
	* Returns the ticket no of this bt travel expense.
	*
	* @return the ticket no of this bt travel expense
	*/
	@Override
	public java.lang.String getTicketNo() {
		return _btTravelExpense.getTicketNo();
	}

	/**
	* Sets the ticket no of this bt travel expense.
	*
	* @param ticketNo the ticket no of this bt travel expense
	*/
	@Override
	public void setTicketNo(java.lang.String ticketNo) {
		_btTravelExpense.setTicketNo(ticketNo);
	}

	/**
	* Returns the travel date of this bt travel expense.
	*
	* @return the travel date of this bt travel expense
	*/
	@Override
	public java.lang.String getTravelDate() {
		return _btTravelExpense.getTravelDate();
	}

	/**
	* Sets the travel date of this bt travel expense.
	*
	* @param travelDate the travel date of this bt travel expense
	*/
	@Override
	public void setTravelDate(java.lang.String travelDate) {
		_btTravelExpense.setTravelDate(travelDate);
	}

	/**
	* Returns the departure of this bt travel expense.
	*
	* @return the departure of this bt travel expense
	*/
	@Override
	public java.lang.String getDeparture() {
		return _btTravelExpense.getDeparture();
	}

	/**
	* Sets the departure of this bt travel expense.
	*
	* @param departure the departure of this bt travel expense
	*/
	@Override
	public void setDeparture(java.lang.String departure) {
		_btTravelExpense.setDeparture(departure);
	}

	/**
	* Returns the arrival of this bt travel expense.
	*
	* @return the arrival of this bt travel expense
	*/
	@Override
	public java.lang.String getArrival() {
		return _btTravelExpense.getArrival();
	}

	/**
	* Sets the arrival of this bt travel expense.
	*
	* @param arrival the arrival of this bt travel expense
	*/
	@Override
	public void setArrival(java.lang.String arrival) {
		_btTravelExpense.setArrival(arrival);
	}

	/**
	* Returns the from city of this bt travel expense.
	*
	* @return the from city of this bt travel expense
	*/
	@Override
	public java.lang.String getFromCity() {
		return _btTravelExpense.getFromCity();
	}

	/**
	* Sets the from city of this bt travel expense.
	*
	* @param fromCity the from city of this bt travel expense
	*/
	@Override
	public void setFromCity(java.lang.String fromCity) {
		_btTravelExpense.setFromCity(fromCity);
	}

	/**
	* Returns the to city of this bt travel expense.
	*
	* @return the to city of this bt travel expense
	*/
	@Override
	public java.lang.String getToCity() {
		return _btTravelExpense.getToCity();
	}

	/**
	* Sets the to city of this bt travel expense.
	*
	* @param toCity the to city of this bt travel expense
	*/
	@Override
	public void setToCity(java.lang.String toCity) {
		_btTravelExpense.setToCity(toCity);
	}

	/**
	* Returns the is has breakfast of this bt travel expense.
	*
	* @return the is has breakfast of this bt travel expense
	*/
	@Override
	public boolean getIsHasBreakfast() {
		return _btTravelExpense.getIsHasBreakfast();
	}

	/**
	* Returns <code>true</code> if this bt travel expense is is has breakfast.
	*
	* @return <code>true</code> if this bt travel expense is is has breakfast; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsHasBreakfast() {
		return _btTravelExpense.isIsHasBreakfast();
	}

	/**
	* Sets whether this bt travel expense is is has breakfast.
	*
	* @param isHasBreakfast the is has breakfast of this bt travel expense
	*/
	@Override
	public void setIsHasBreakfast(boolean isHasBreakfast) {
		_btTravelExpense.setIsHasBreakfast(isHasBreakfast);
	}

	/**
	* Returns the is has lunch of this bt travel expense.
	*
	* @return the is has lunch of this bt travel expense
	*/
	@Override
	public boolean getIsHasLunch() {
		return _btTravelExpense.getIsHasLunch();
	}

	/**
	* Returns <code>true</code> if this bt travel expense is is has lunch.
	*
	* @return <code>true</code> if this bt travel expense is is has lunch; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsHasLunch() {
		return _btTravelExpense.isIsHasLunch();
	}

	/**
	* Sets whether this bt travel expense is is has lunch.
	*
	* @param isHasLunch the is has lunch of this bt travel expense
	*/
	@Override
	public void setIsHasLunch(boolean isHasLunch) {
		_btTravelExpense.setIsHasLunch(isHasLunch);
	}

	/**
	* Returns the is has dinner of this bt travel expense.
	*
	* @return the is has dinner of this bt travel expense
	*/
	@Override
	public boolean getIsHasDinner() {
		return _btTravelExpense.getIsHasDinner();
	}

	/**
	* Returns <code>true</code> if this bt travel expense is is has dinner.
	*
	* @return <code>true</code> if this bt travel expense is is has dinner; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsHasDinner() {
		return _btTravelExpense.isIsHasDinner();
	}

	/**
	* Sets whether this bt travel expense is is has dinner.
	*
	* @param isHasDinner the is has dinner of this bt travel expense
	*/
	@Override
	public void setIsHasDinner(boolean isHasDinner) {
		_btTravelExpense.setIsHasDinner(isHasDinner);
	}

	/**
	* Returns the country of this bt travel expense.
	*
	* @return the country of this bt travel expense
	*/
	@Override
	public java.lang.String getCountry() {
		return _btTravelExpense.getCountry();
	}

	/**
	* Sets the country of this bt travel expense.
	*
	* @param country the country of this bt travel expense
	*/
	@Override
	public void setCountry(java.lang.String country) {
		_btTravelExpense.setCountry(country);
	}

	/**
	* Returns the city of this bt travel expense.
	*
	* @return the city of this bt travel expense
	*/
	@Override
	public java.lang.String getCity() {
		return _btTravelExpense.getCity();
	}

	/**
	* Sets the city of this bt travel expense.
	*
	* @param city the city of this bt travel expense
	*/
	@Override
	public void setCity(java.lang.String city) {
		_btTravelExpense.setCity(city);
	}

	/**
	* Returns the rate of dma of this bt travel expense.
	*
	* @return the rate of dma of this bt travel expense
	*/
	@Override
	public double getRateOfDma() {
		return _btTravelExpense.getRateOfDma();
	}

	/**
	* Sets the rate of dma of this bt travel expense.
	*
	* @param rateOfDma the rate of dma of this bt travel expense
	*/
	@Override
	public void setRateOfDma(double rateOfDma) {
		_btTravelExpense.setRateOfDma(rateOfDma);
	}

	/**
	* Returns the currency of this bt travel expense.
	*
	* @return the currency of this bt travel expense
	*/
	@Override
	public java.lang.String getCurrency() {
		return _btTravelExpense.getCurrency();
	}

	/**
	* Sets the currency of this bt travel expense.
	*
	* @param currency the currency of this bt travel expense
	*/
	@Override
	public void setCurrency(java.lang.String currency) {
		_btTravelExpense.setCurrency(currency);
	}

	/**
	* Returns the allowance of this bt travel expense.
	*
	* @return the allowance of this bt travel expense
	*/
	@Override
	public double getAllowance() {
		return _btTravelExpense.getAllowance();
	}

	/**
	* Sets the allowance of this bt travel expense.
	*
	* @param allowance the allowance of this bt travel expense
	*/
	@Override
	public void setAllowance(double allowance) {
		_btTravelExpense.setAllowance(allowance);
	}

	/**
	* Returns the comments of this bt travel expense.
	*
	* @return the comments of this bt travel expense
	*/
	@Override
	public java.lang.String getComments() {
		return _btTravelExpense.getComments();
	}

	/**
	* Sets the comments of this bt travel expense.
	*
	* @param comments the comments of this bt travel expense
	*/
	@Override
	public void setComments(java.lang.String comments) {
		_btTravelExpense.setComments(comments);
	}

	/**
	* Returns the trip type of this bt travel expense.
	*
	* @return the trip type of this bt travel expense
	*/
	@Override
	public java.lang.String getTripType() {
		return _btTravelExpense.getTripType();
	}

	/**
	* Sets the trip type of this bt travel expense.
	*
	* @param tripType the trip type of this bt travel expense
	*/
	@Override
	public void setTripType(java.lang.String tripType) {
		_btTravelExpense.setTripType(tripType);
	}

	/**
	* Returns the allowance rmb of this bt travel expense.
	*
	* @return the allowance rmb of this bt travel expense
	*/
	@Override
	public double getAllowanceRmb() {
		return _btTravelExpense.getAllowanceRmb();
	}

	/**
	* Sets the allowance rmb of this bt travel expense.
	*
	* @param allowanceRmb the allowance rmb of this bt travel expense
	*/
	@Override
	public void setAllowanceRmb(double allowanceRmb) {
		_btTravelExpense.setAllowanceRmb(allowanceRmb);
	}

	@Override
	public boolean isNew() {
		return _btTravelExpense.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_btTravelExpense.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _btTravelExpense.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_btTravelExpense.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _btTravelExpense.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _btTravelExpense.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_btTravelExpense.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _btTravelExpense.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_btTravelExpense.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_btTravelExpense.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_btTravelExpense.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BtTravelExpenseWrapper((BtTravelExpense)_btTravelExpense.clone());
	}

	@Override
	public int compareTo(
		com.business.trip.model.BtTravelExpense btTravelExpense) {
		return _btTravelExpense.compareTo(btTravelExpense);
	}

	@Override
	public int hashCode() {
		return _btTravelExpense.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.business.trip.model.BtTravelExpense> toCacheModel() {
		return _btTravelExpense.toCacheModel();
	}

	@Override
	public com.business.trip.model.BtTravelExpense toEscapedModel() {
		return new BtTravelExpenseWrapper(_btTravelExpense.toEscapedModel());
	}

	@Override
	public com.business.trip.model.BtTravelExpense toUnescapedModel() {
		return new BtTravelExpenseWrapper(_btTravelExpense.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _btTravelExpense.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _btTravelExpense.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_btTravelExpense.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BtTravelExpenseWrapper)) {
			return false;
		}

		BtTravelExpenseWrapper btTravelExpenseWrapper = (BtTravelExpenseWrapper)obj;

		if (Validator.equals(_btTravelExpense,
					btTravelExpenseWrapper._btTravelExpense)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public BtTravelExpense getWrappedBtTravelExpense() {
		return _btTravelExpense;
	}

	@Override
	public BtTravelExpense getWrappedModel() {
		return _btTravelExpense;
	}

	@Override
	public void resetOriginalValues() {
		_btTravelExpense.resetOriginalValues();
	}

	private BtTravelExpense _btTravelExpense;
}