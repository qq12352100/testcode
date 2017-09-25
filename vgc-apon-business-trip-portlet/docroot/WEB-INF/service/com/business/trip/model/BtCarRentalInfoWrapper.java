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
 * This class is a wrapper for {@link BtCarRentalInfo}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BtCarRentalInfo
 * @generated
 */
public class BtCarRentalInfoWrapper implements BtCarRentalInfo,
	ModelWrapper<BtCarRentalInfo> {
	public BtCarRentalInfoWrapper(BtCarRentalInfo btCarRentalInfo) {
		_btCarRentalInfo = btCarRentalInfo;
	}

	@Override
	public Class<?> getModelClass() {
		return BtCarRentalInfo.class;
	}

	@Override
	public String getModelClassName() {
		return BtCarRentalInfo.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("btCarRentalInfoId", getBtCarRentalInfoId());
		attributes.put("businessTripPkId", getBusinessTripPkId());
		attributes.put("ticketNo", getTicketNo());
		attributes.put("pickupLocation", getPickupLocation());
		attributes.put("pickupDate", getPickupDate());
		attributes.put("dropoffLocation", getDropoffLocation());
		attributes.put("dropoffDate", getDropoffDate());
		attributes.put("carType", getCarType());
		attributes.put("typeOfRental", getTypeOfRental());
		attributes.put("price", getPrice());
		attributes.put("currency", getCurrency());
		attributes.put("tripType", getTripType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long btCarRentalInfoId = (Long)attributes.get("btCarRentalInfoId");

		if (btCarRentalInfoId != null) {
			setBtCarRentalInfoId(btCarRentalInfoId);
		}

		Long businessTripPkId = (Long)attributes.get("businessTripPkId");

		if (businessTripPkId != null) {
			setBusinessTripPkId(businessTripPkId);
		}

		String ticketNo = (String)attributes.get("ticketNo");

		if (ticketNo != null) {
			setTicketNo(ticketNo);
		}

		String pickupLocation = (String)attributes.get("pickupLocation");

		if (pickupLocation != null) {
			setPickupLocation(pickupLocation);
		}

		Date pickupDate = (Date)attributes.get("pickupDate");

		if (pickupDate != null) {
			setPickupDate(pickupDate);
		}

		String dropoffLocation = (String)attributes.get("dropoffLocation");

		if (dropoffLocation != null) {
			setDropoffLocation(dropoffLocation);
		}

		Date dropoffDate = (Date)attributes.get("dropoffDate");

		if (dropoffDate != null) {
			setDropoffDate(dropoffDate);
		}

		String carType = (String)attributes.get("carType");

		if (carType != null) {
			setCarType(carType);
		}

		String typeOfRental = (String)attributes.get("typeOfRental");

		if (typeOfRental != null) {
			setTypeOfRental(typeOfRental);
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
	* Returns the primary key of this bt car rental info.
	*
	* @return the primary key of this bt car rental info
	*/
	@Override
	public long getPrimaryKey() {
		return _btCarRentalInfo.getPrimaryKey();
	}

	/**
	* Sets the primary key of this bt car rental info.
	*
	* @param primaryKey the primary key of this bt car rental info
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_btCarRentalInfo.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the bt car rental info ID of this bt car rental info.
	*
	* @return the bt car rental info ID of this bt car rental info
	*/
	@Override
	public long getBtCarRentalInfoId() {
		return _btCarRentalInfo.getBtCarRentalInfoId();
	}

	/**
	* Sets the bt car rental info ID of this bt car rental info.
	*
	* @param btCarRentalInfoId the bt car rental info ID of this bt car rental info
	*/
	@Override
	public void setBtCarRentalInfoId(long btCarRentalInfoId) {
		_btCarRentalInfo.setBtCarRentalInfoId(btCarRentalInfoId);
	}

	/**
	* Returns the business trip pk ID of this bt car rental info.
	*
	* @return the business trip pk ID of this bt car rental info
	*/
	@Override
	public long getBusinessTripPkId() {
		return _btCarRentalInfo.getBusinessTripPkId();
	}

	/**
	* Sets the business trip pk ID of this bt car rental info.
	*
	* @param businessTripPkId the business trip pk ID of this bt car rental info
	*/
	@Override
	public void setBusinessTripPkId(long businessTripPkId) {
		_btCarRentalInfo.setBusinessTripPkId(businessTripPkId);
	}

	/**
	* Returns the ticket no of this bt car rental info.
	*
	* @return the ticket no of this bt car rental info
	*/
	@Override
	public java.lang.String getTicketNo() {
		return _btCarRentalInfo.getTicketNo();
	}

	/**
	* Sets the ticket no of this bt car rental info.
	*
	* @param ticketNo the ticket no of this bt car rental info
	*/
	@Override
	public void setTicketNo(java.lang.String ticketNo) {
		_btCarRentalInfo.setTicketNo(ticketNo);
	}

	/**
	* Returns the pickup location of this bt car rental info.
	*
	* @return the pickup location of this bt car rental info
	*/
	@Override
	public java.lang.String getPickupLocation() {
		return _btCarRentalInfo.getPickupLocation();
	}

	/**
	* Sets the pickup location of this bt car rental info.
	*
	* @param pickupLocation the pickup location of this bt car rental info
	*/
	@Override
	public void setPickupLocation(java.lang.String pickupLocation) {
		_btCarRentalInfo.setPickupLocation(pickupLocation);
	}

	/**
	* Returns the pickup date of this bt car rental info.
	*
	* @return the pickup date of this bt car rental info
	*/
	@Override
	public java.util.Date getPickupDate() {
		return _btCarRentalInfo.getPickupDate();
	}

	/**
	* Sets the pickup date of this bt car rental info.
	*
	* @param pickupDate the pickup date of this bt car rental info
	*/
	@Override
	public void setPickupDate(java.util.Date pickupDate) {
		_btCarRentalInfo.setPickupDate(pickupDate);
	}

	/**
	* Returns the dropoff location of this bt car rental info.
	*
	* @return the dropoff location of this bt car rental info
	*/
	@Override
	public java.lang.String getDropoffLocation() {
		return _btCarRentalInfo.getDropoffLocation();
	}

	/**
	* Sets the dropoff location of this bt car rental info.
	*
	* @param dropoffLocation the dropoff location of this bt car rental info
	*/
	@Override
	public void setDropoffLocation(java.lang.String dropoffLocation) {
		_btCarRentalInfo.setDropoffLocation(dropoffLocation);
	}

	/**
	* Returns the dropoff date of this bt car rental info.
	*
	* @return the dropoff date of this bt car rental info
	*/
	@Override
	public java.util.Date getDropoffDate() {
		return _btCarRentalInfo.getDropoffDate();
	}

	/**
	* Sets the dropoff date of this bt car rental info.
	*
	* @param dropoffDate the dropoff date of this bt car rental info
	*/
	@Override
	public void setDropoffDate(java.util.Date dropoffDate) {
		_btCarRentalInfo.setDropoffDate(dropoffDate);
	}

	/**
	* Returns the car type of this bt car rental info.
	*
	* @return the car type of this bt car rental info
	*/
	@Override
	public java.lang.String getCarType() {
		return _btCarRentalInfo.getCarType();
	}

	/**
	* Sets the car type of this bt car rental info.
	*
	* @param carType the car type of this bt car rental info
	*/
	@Override
	public void setCarType(java.lang.String carType) {
		_btCarRentalInfo.setCarType(carType);
	}

	/**
	* Returns the type of rental of this bt car rental info.
	*
	* @return the type of rental of this bt car rental info
	*/
	@Override
	public java.lang.String getTypeOfRental() {
		return _btCarRentalInfo.getTypeOfRental();
	}

	/**
	* Sets the type of rental of this bt car rental info.
	*
	* @param typeOfRental the type of rental of this bt car rental info
	*/
	@Override
	public void setTypeOfRental(java.lang.String typeOfRental) {
		_btCarRentalInfo.setTypeOfRental(typeOfRental);
	}

	/**
	* Returns the price of this bt car rental info.
	*
	* @return the price of this bt car rental info
	*/
	@Override
	public double getPrice() {
		return _btCarRentalInfo.getPrice();
	}

	/**
	* Sets the price of this bt car rental info.
	*
	* @param price the price of this bt car rental info
	*/
	@Override
	public void setPrice(double price) {
		_btCarRentalInfo.setPrice(price);
	}

	/**
	* Returns the currency of this bt car rental info.
	*
	* @return the currency of this bt car rental info
	*/
	@Override
	public java.lang.String getCurrency() {
		return _btCarRentalInfo.getCurrency();
	}

	/**
	* Sets the currency of this bt car rental info.
	*
	* @param currency the currency of this bt car rental info
	*/
	@Override
	public void setCurrency(java.lang.String currency) {
		_btCarRentalInfo.setCurrency(currency);
	}

	/**
	* Returns the trip type of this bt car rental info.
	*
	* @return the trip type of this bt car rental info
	*/
	@Override
	public java.lang.String getTripType() {
		return _btCarRentalInfo.getTripType();
	}

	/**
	* Sets the trip type of this bt car rental info.
	*
	* @param tripType the trip type of this bt car rental info
	*/
	@Override
	public void setTripType(java.lang.String tripType) {
		_btCarRentalInfo.setTripType(tripType);
	}

	@Override
	public boolean isNew() {
		return _btCarRentalInfo.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_btCarRentalInfo.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _btCarRentalInfo.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_btCarRentalInfo.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _btCarRentalInfo.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _btCarRentalInfo.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_btCarRentalInfo.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _btCarRentalInfo.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_btCarRentalInfo.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_btCarRentalInfo.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_btCarRentalInfo.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BtCarRentalInfoWrapper((BtCarRentalInfo)_btCarRentalInfo.clone());
	}

	@Override
	public int compareTo(
		com.business.trip.model.BtCarRentalInfo btCarRentalInfo) {
		return _btCarRentalInfo.compareTo(btCarRentalInfo);
	}

	@Override
	public int hashCode() {
		return _btCarRentalInfo.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.business.trip.model.BtCarRentalInfo> toCacheModel() {
		return _btCarRentalInfo.toCacheModel();
	}

	@Override
	public com.business.trip.model.BtCarRentalInfo toEscapedModel() {
		return new BtCarRentalInfoWrapper(_btCarRentalInfo.toEscapedModel());
	}

	@Override
	public com.business.trip.model.BtCarRentalInfo toUnescapedModel() {
		return new BtCarRentalInfoWrapper(_btCarRentalInfo.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _btCarRentalInfo.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _btCarRentalInfo.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_btCarRentalInfo.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BtCarRentalInfoWrapper)) {
			return false;
		}

		BtCarRentalInfoWrapper btCarRentalInfoWrapper = (BtCarRentalInfoWrapper)obj;

		if (Validator.equals(_btCarRentalInfo,
					btCarRentalInfoWrapper._btCarRentalInfo)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public BtCarRentalInfo getWrappedBtCarRentalInfo() {
		return _btCarRentalInfo;
	}

	@Override
	public BtCarRentalInfo getWrappedModel() {
		return _btCarRentalInfo;
	}

	@Override
	public void resetOriginalValues() {
		_btCarRentalInfo.resetOriginalValues();
	}

	private BtCarRentalInfo _btCarRentalInfo;
}