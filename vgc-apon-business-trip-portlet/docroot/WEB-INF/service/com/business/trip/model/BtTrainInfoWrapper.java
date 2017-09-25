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
 * This class is a wrapper for {@link BtTrainInfo}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BtTrainInfo
 * @generated
 */
public class BtTrainInfoWrapper implements BtTrainInfo,
	ModelWrapper<BtTrainInfo> {
	public BtTrainInfoWrapper(BtTrainInfo btTrainInfo) {
		_btTrainInfo = btTrainInfo;
	}

	@Override
	public Class<?> getModelClass() {
		return BtTrainInfo.class;
	}

	@Override
	public String getModelClassName() {
		return BtTrainInfo.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("btTrainInfoId", getBtTrainInfoId());
		attributes.put("businessTripPkId", getBusinessTripPkId());
		attributes.put("ticketNo", getTicketNo());
		attributes.put("fromCity", getFromCity());
		attributes.put("toCity", getToCity());
		attributes.put("departureDate", getDepartureDate());
		attributes.put("departureTrain", getDepartureTrain());
		attributes.put("classInfo", getClassInfo());
		attributes.put("price", getPrice());
		attributes.put("currency", getCurrency());
		attributes.put("tripType", getTripType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long btTrainInfoId = (Long)attributes.get("btTrainInfoId");

		if (btTrainInfoId != null) {
			setBtTrainInfoId(btTrainInfoId);
		}

		Long businessTripPkId = (Long)attributes.get("businessTripPkId");

		if (businessTripPkId != null) {
			setBusinessTripPkId(businessTripPkId);
		}

		String ticketNo = (String)attributes.get("ticketNo");

		if (ticketNo != null) {
			setTicketNo(ticketNo);
		}

		String fromCity = (String)attributes.get("fromCity");

		if (fromCity != null) {
			setFromCity(fromCity);
		}

		String toCity = (String)attributes.get("toCity");

		if (toCity != null) {
			setToCity(toCity);
		}

		Date departureDate = (Date)attributes.get("departureDate");

		if (departureDate != null) {
			setDepartureDate(departureDate);
		}

		String departureTrain = (String)attributes.get("departureTrain");

		if (departureTrain != null) {
			setDepartureTrain(departureTrain);
		}

		String classInfo = (String)attributes.get("classInfo");

		if (classInfo != null) {
			setClassInfo(classInfo);
		}

		Double price = (Double)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}

		String currency = (String)attributes.get("currency");

		if (currency != null) {
			setCurrency(currency);
		}

		String tripType = (String)attributes.get("tripType");

		if (tripType != null) {
			setTripType(tripType);
		}
	}

	/**
	* Returns the primary key of this bt train info.
	*
	* @return the primary key of this bt train info
	*/
	@Override
	public long getPrimaryKey() {
		return _btTrainInfo.getPrimaryKey();
	}

	/**
	* Sets the primary key of this bt train info.
	*
	* @param primaryKey the primary key of this bt train info
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_btTrainInfo.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the bt train info ID of this bt train info.
	*
	* @return the bt train info ID of this bt train info
	*/
	@Override
	public long getBtTrainInfoId() {
		return _btTrainInfo.getBtTrainInfoId();
	}

	/**
	* Sets the bt train info ID of this bt train info.
	*
	* @param btTrainInfoId the bt train info ID of this bt train info
	*/
	@Override
	public void setBtTrainInfoId(long btTrainInfoId) {
		_btTrainInfo.setBtTrainInfoId(btTrainInfoId);
	}

	/**
	* Returns the business trip pk ID of this bt train info.
	*
	* @return the business trip pk ID of this bt train info
	*/
	@Override
	public long getBusinessTripPkId() {
		return _btTrainInfo.getBusinessTripPkId();
	}

	/**
	* Sets the business trip pk ID of this bt train info.
	*
	* @param businessTripPkId the business trip pk ID of this bt train info
	*/
	@Override
	public void setBusinessTripPkId(long businessTripPkId) {
		_btTrainInfo.setBusinessTripPkId(businessTripPkId);
	}

	/**
	* Returns the ticket no of this bt train info.
	*
	* @return the ticket no of this bt train info
	*/
	@Override
	public java.lang.String getTicketNo() {
		return _btTrainInfo.getTicketNo();
	}

	/**
	* Sets the ticket no of this bt train info.
	*
	* @param ticketNo the ticket no of this bt train info
	*/
	@Override
	public void setTicketNo(java.lang.String ticketNo) {
		_btTrainInfo.setTicketNo(ticketNo);
	}

	/**
	* Returns the from city of this bt train info.
	*
	* @return the from city of this bt train info
	*/
	@Override
	public java.lang.String getFromCity() {
		return _btTrainInfo.getFromCity();
	}

	/**
	* Sets the from city of this bt train info.
	*
	* @param fromCity the from city of this bt train info
	*/
	@Override
	public void setFromCity(java.lang.String fromCity) {
		_btTrainInfo.setFromCity(fromCity);
	}

	/**
	* Returns the to city of this bt train info.
	*
	* @return the to city of this bt train info
	*/
	@Override
	public java.lang.String getToCity() {
		return _btTrainInfo.getToCity();
	}

	/**
	* Sets the to city of this bt train info.
	*
	* @param toCity the to city of this bt train info
	*/
	@Override
	public void setToCity(java.lang.String toCity) {
		_btTrainInfo.setToCity(toCity);
	}

	/**
	* Returns the departure date of this bt train info.
	*
	* @return the departure date of this bt train info
	*/
	@Override
	public java.util.Date getDepartureDate() {
		return _btTrainInfo.getDepartureDate();
	}

	/**
	* Sets the departure date of this bt train info.
	*
	* @param departureDate the departure date of this bt train info
	*/
	@Override
	public void setDepartureDate(java.util.Date departureDate) {
		_btTrainInfo.setDepartureDate(departureDate);
	}

	/**
	* Returns the departure train of this bt train info.
	*
	* @return the departure train of this bt train info
	*/
	@Override
	public java.lang.String getDepartureTrain() {
		return _btTrainInfo.getDepartureTrain();
	}

	/**
	* Sets the departure train of this bt train info.
	*
	* @param departureTrain the departure train of this bt train info
	*/
	@Override
	public void setDepartureTrain(java.lang.String departureTrain) {
		_btTrainInfo.setDepartureTrain(departureTrain);
	}

	/**
	* Returns the class info of this bt train info.
	*
	* @return the class info of this bt train info
	*/
	@Override
	public java.lang.String getClassInfo() {
		return _btTrainInfo.getClassInfo();
	}

	/**
	* Sets the class info of this bt train info.
	*
	* @param classInfo the class info of this bt train info
	*/
	@Override
	public void setClassInfo(java.lang.String classInfo) {
		_btTrainInfo.setClassInfo(classInfo);
	}

	/**
	* Returns the price of this bt train info.
	*
	* @return the price of this bt train info
	*/
	@Override
	public double getPrice() {
		return _btTrainInfo.getPrice();
	}

	/**
	* Sets the price of this bt train info.
	*
	* @param price the price of this bt train info
	*/
	@Override
	public void setPrice(double price) {
		_btTrainInfo.setPrice(price);
	}

	/**
	* Returns the currency of this bt train info.
	*
	* @return the currency of this bt train info
	*/
	@Override
	public java.lang.String getCurrency() {
		return _btTrainInfo.getCurrency();
	}

	/**
	* Sets the currency of this bt train info.
	*
	* @param currency the currency of this bt train info
	*/
	@Override
	public void setCurrency(java.lang.String currency) {
		_btTrainInfo.setCurrency(currency);
	}

	/**
	* Returns the trip type of this bt train info.
	*
	* @return the trip type of this bt train info
	*/
	@Override
	public java.lang.String getTripType() {
		return _btTrainInfo.getTripType();
	}

	/**
	* Sets the trip type of this bt train info.
	*
	* @param tripType the trip type of this bt train info
	*/
	@Override
	public void setTripType(java.lang.String tripType) {
		_btTrainInfo.setTripType(tripType);
	}

	@Override
	public boolean isNew() {
		return _btTrainInfo.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_btTrainInfo.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _btTrainInfo.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_btTrainInfo.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _btTrainInfo.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _btTrainInfo.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_btTrainInfo.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _btTrainInfo.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_btTrainInfo.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_btTrainInfo.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_btTrainInfo.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BtTrainInfoWrapper((BtTrainInfo)_btTrainInfo.clone());
	}

	@Override
	public int compareTo(com.business.trip.model.BtTrainInfo btTrainInfo) {
		return _btTrainInfo.compareTo(btTrainInfo);
	}

	@Override
	public int hashCode() {
		return _btTrainInfo.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.business.trip.model.BtTrainInfo> toCacheModel() {
		return _btTrainInfo.toCacheModel();
	}

	@Override
	public com.business.trip.model.BtTrainInfo toEscapedModel() {
		return new BtTrainInfoWrapper(_btTrainInfo.toEscapedModel());
	}

	@Override
	public com.business.trip.model.BtTrainInfo toUnescapedModel() {
		return new BtTrainInfoWrapper(_btTrainInfo.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _btTrainInfo.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _btTrainInfo.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_btTrainInfo.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BtTrainInfoWrapper)) {
			return false;
		}

		BtTrainInfoWrapper btTrainInfoWrapper = (BtTrainInfoWrapper)obj;

		if (Validator.equals(_btTrainInfo, btTrainInfoWrapper._btTrainInfo)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public BtTrainInfo getWrappedBtTrainInfo() {
		return _btTrainInfo;
	}

	@Override
	public BtTrainInfo getWrappedModel() {
		return _btTrainInfo;
	}

	@Override
	public void resetOriginalValues() {
		_btTrainInfo.resetOriginalValues();
	}

	private BtTrainInfo _btTrainInfo;
}