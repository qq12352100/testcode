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
 * This class is a wrapper for {@link BtFlightTrainInfo}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BtFlightTrainInfo
 * @generated
 */
public class BtFlightTrainInfoWrapper implements BtFlightTrainInfo,
	ModelWrapper<BtFlightTrainInfo> {
	public BtFlightTrainInfoWrapper(BtFlightTrainInfo btFlightTrainInfo) {
		_btFlightTrainInfo = btFlightTrainInfo;
	}

	@Override
	public Class<?> getModelClass() {
		return BtFlightTrainInfo.class;
	}

	@Override
	public String getModelClassName() {
		return BtFlightTrainInfo.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("btFlightTrainInfoId", getBtFlightTrainInfoId());
		attributes.put("businessTripPkId", getBusinessTripPkId());
		attributes.put("ticketNo", getTicketNo());
		attributes.put("type", getType());
		attributes.put("fromCity", getFromCity());
		attributes.put("toCity", getToCity());
		attributes.put("departureDate", getDepartureDate());
		attributes.put("departureFlight", getDepartureFlight());
		attributes.put("departureTime", getDepartureTime());
		attributes.put("classInfo", getClassInfo());
		attributes.put("price", getPrice());
		attributes.put("currency", getCurrency());
		attributes.put("tripType", getTripType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long btFlightTrainInfoId = (Long)attributes.get("btFlightTrainInfoId");

		if (btFlightTrainInfoId != null) {
			setBtFlightTrainInfoId(btFlightTrainInfoId);
		}

		Long businessTripPkId = (Long)attributes.get("businessTripPkId");

		if (businessTripPkId != null) {
			setBusinessTripPkId(businessTripPkId);
		}

		String ticketNo = (String)attributes.get("ticketNo");

		if (ticketNo != null) {
			setTicketNo(ticketNo);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
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

		String departureFlight = (String)attributes.get("departureFlight");

		if (departureFlight != null) {
			setDepartureFlight(departureFlight);
		}

		Date departureTime = (Date)attributes.get("departureTime");

		if (departureTime != null) {
			setDepartureTime(departureTime);
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
	* Returns the primary key of this bt flight train info.
	*
	* @return the primary key of this bt flight train info
	*/
	@Override
	public long getPrimaryKey() {
		return _btFlightTrainInfo.getPrimaryKey();
	}

	/**
	* Sets the primary key of this bt flight train info.
	*
	* @param primaryKey the primary key of this bt flight train info
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_btFlightTrainInfo.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the bt flight train info ID of this bt flight train info.
	*
	* @return the bt flight train info ID of this bt flight train info
	*/
	@Override
	public long getBtFlightTrainInfoId() {
		return _btFlightTrainInfo.getBtFlightTrainInfoId();
	}

	/**
	* Sets the bt flight train info ID of this bt flight train info.
	*
	* @param btFlightTrainInfoId the bt flight train info ID of this bt flight train info
	*/
	@Override
	public void setBtFlightTrainInfoId(long btFlightTrainInfoId) {
		_btFlightTrainInfo.setBtFlightTrainInfoId(btFlightTrainInfoId);
	}

	/**
	* Returns the business trip pk ID of this bt flight train info.
	*
	* @return the business trip pk ID of this bt flight train info
	*/
	@Override
	public long getBusinessTripPkId() {
		return _btFlightTrainInfo.getBusinessTripPkId();
	}

	/**
	* Sets the business trip pk ID of this bt flight train info.
	*
	* @param businessTripPkId the business trip pk ID of this bt flight train info
	*/
	@Override
	public void setBusinessTripPkId(long businessTripPkId) {
		_btFlightTrainInfo.setBusinessTripPkId(businessTripPkId);
	}

	/**
	* Returns the ticket no of this bt flight train info.
	*
	* @return the ticket no of this bt flight train info
	*/
	@Override
	public java.lang.String getTicketNo() {
		return _btFlightTrainInfo.getTicketNo();
	}

	/**
	* Sets the ticket no of this bt flight train info.
	*
	* @param ticketNo the ticket no of this bt flight train info
	*/
	@Override
	public void setTicketNo(java.lang.String ticketNo) {
		_btFlightTrainInfo.setTicketNo(ticketNo);
	}

	/**
	* Returns the type of this bt flight train info.
	*
	* @return the type of this bt flight train info
	*/
	@Override
	public java.lang.String getType() {
		return _btFlightTrainInfo.getType();
	}

	/**
	* Sets the type of this bt flight train info.
	*
	* @param type the type of this bt flight train info
	*/
	@Override
	public void setType(java.lang.String type) {
		_btFlightTrainInfo.setType(type);
	}

	/**
	* Returns the from city of this bt flight train info.
	*
	* @return the from city of this bt flight train info
	*/
	@Override
	public java.lang.String getFromCity() {
		return _btFlightTrainInfo.getFromCity();
	}

	/**
	* Sets the from city of this bt flight train info.
	*
	* @param fromCity the from city of this bt flight train info
	*/
	@Override
	public void setFromCity(java.lang.String fromCity) {
		_btFlightTrainInfo.setFromCity(fromCity);
	}

	/**
	* Returns the to city of this bt flight train info.
	*
	* @return the to city of this bt flight train info
	*/
	@Override
	public java.lang.String getToCity() {
		return _btFlightTrainInfo.getToCity();
	}

	/**
	* Sets the to city of this bt flight train info.
	*
	* @param toCity the to city of this bt flight train info
	*/
	@Override
	public void setToCity(java.lang.String toCity) {
		_btFlightTrainInfo.setToCity(toCity);
	}

	/**
	* Returns the departure date of this bt flight train info.
	*
	* @return the departure date of this bt flight train info
	*/
	@Override
	public java.util.Date getDepartureDate() {
		return _btFlightTrainInfo.getDepartureDate();
	}

	/**
	* Sets the departure date of this bt flight train info.
	*
	* @param departureDate the departure date of this bt flight train info
	*/
	@Override
	public void setDepartureDate(java.util.Date departureDate) {
		_btFlightTrainInfo.setDepartureDate(departureDate);
	}

	/**
	* Returns the departure flight of this bt flight train info.
	*
	* @return the departure flight of this bt flight train info
	*/
	@Override
	public java.lang.String getDepartureFlight() {
		return _btFlightTrainInfo.getDepartureFlight();
	}

	/**
	* Sets the departure flight of this bt flight train info.
	*
	* @param departureFlight the departure flight of this bt flight train info
	*/
	@Override
	public void setDepartureFlight(java.lang.String departureFlight) {
		_btFlightTrainInfo.setDepartureFlight(departureFlight);
	}

	/**
	* Returns the departure time of this bt flight train info.
	*
	* @return the departure time of this bt flight train info
	*/
	@Override
	public java.util.Date getDepartureTime() {
		return _btFlightTrainInfo.getDepartureTime();
	}

	/**
	* Sets the departure time of this bt flight train info.
	*
	* @param departureTime the departure time of this bt flight train info
	*/
	@Override
	public void setDepartureTime(java.util.Date departureTime) {
		_btFlightTrainInfo.setDepartureTime(departureTime);
	}

	/**
	* Returns the class info of this bt flight train info.
	*
	* @return the class info of this bt flight train info
	*/
	@Override
	public java.lang.String getClassInfo() {
		return _btFlightTrainInfo.getClassInfo();
	}

	/**
	* Sets the class info of this bt flight train info.
	*
	* @param classInfo the class info of this bt flight train info
	*/
	@Override
	public void setClassInfo(java.lang.String classInfo) {
		_btFlightTrainInfo.setClassInfo(classInfo);
	}

	/**
	* Returns the price of this bt flight train info.
	*
	* @return the price of this bt flight train info
	*/
	@Override
	public double getPrice() {
		return _btFlightTrainInfo.getPrice();
	}

	/**
	* Sets the price of this bt flight train info.
	*
	* @param price the price of this bt flight train info
	*/
	@Override
	public void setPrice(double price) {
		_btFlightTrainInfo.setPrice(price);
	}

	/**
	* Returns the currency of this bt flight train info.
	*
	* @return the currency of this bt flight train info
	*/
	@Override
	public java.lang.String getCurrency() {
		return _btFlightTrainInfo.getCurrency();
	}

	/**
	* Sets the currency of this bt flight train info.
	*
	* @param currency the currency of this bt flight train info
	*/
	@Override
	public void setCurrency(java.lang.String currency) {
		_btFlightTrainInfo.setCurrency(currency);
	}

	/**
	* Returns the trip type of this bt flight train info.
	*
	* @return the trip type of this bt flight train info
	*/
	@Override
	public java.lang.String getTripType() {
		return _btFlightTrainInfo.getTripType();
	}

	/**
	* Sets the trip type of this bt flight train info.
	*
	* @param tripType the trip type of this bt flight train info
	*/
	@Override
	public void setTripType(java.lang.String tripType) {
		_btFlightTrainInfo.setTripType(tripType);
	}

	@Override
	public boolean isNew() {
		return _btFlightTrainInfo.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_btFlightTrainInfo.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _btFlightTrainInfo.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_btFlightTrainInfo.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _btFlightTrainInfo.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _btFlightTrainInfo.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_btFlightTrainInfo.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _btFlightTrainInfo.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_btFlightTrainInfo.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_btFlightTrainInfo.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_btFlightTrainInfo.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BtFlightTrainInfoWrapper((BtFlightTrainInfo)_btFlightTrainInfo.clone());
	}

	@Override
	public int compareTo(
		com.business.trip.model.BtFlightTrainInfo btFlightTrainInfo) {
		return _btFlightTrainInfo.compareTo(btFlightTrainInfo);
	}

	@Override
	public int hashCode() {
		return _btFlightTrainInfo.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.business.trip.model.BtFlightTrainInfo> toCacheModel() {
		return _btFlightTrainInfo.toCacheModel();
	}

	@Override
	public com.business.trip.model.BtFlightTrainInfo toEscapedModel() {
		return new BtFlightTrainInfoWrapper(_btFlightTrainInfo.toEscapedModel());
	}

	@Override
	public com.business.trip.model.BtFlightTrainInfo toUnescapedModel() {
		return new BtFlightTrainInfoWrapper(_btFlightTrainInfo.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _btFlightTrainInfo.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _btFlightTrainInfo.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_btFlightTrainInfo.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BtFlightTrainInfoWrapper)) {
			return false;
		}

		BtFlightTrainInfoWrapper btFlightTrainInfoWrapper = (BtFlightTrainInfoWrapper)obj;

		if (Validator.equals(_btFlightTrainInfo,
					btFlightTrainInfoWrapper._btFlightTrainInfo)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public BtFlightTrainInfo getWrappedBtFlightTrainInfo() {
		return _btFlightTrainInfo;
	}

	@Override
	public BtFlightTrainInfo getWrappedModel() {
		return _btFlightTrainInfo;
	}

	@Override
	public void resetOriginalValues() {
		_btFlightTrainInfo.resetOriginalValues();
	}

	private BtFlightTrainInfo _btFlightTrainInfo;
}