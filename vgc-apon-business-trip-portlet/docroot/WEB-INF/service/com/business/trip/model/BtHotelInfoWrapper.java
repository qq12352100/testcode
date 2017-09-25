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
 * This class is a wrapper for {@link BtHotelInfo}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BtHotelInfo
 * @generated
 */
public class BtHotelInfoWrapper implements BtHotelInfo,
	ModelWrapper<BtHotelInfo> {
	public BtHotelInfoWrapper(BtHotelInfo btHotelInfo) {
		_btHotelInfo = btHotelInfo;
	}

	@Override
	public Class<?> getModelClass() {
		return BtHotelInfo.class;
	}

	@Override
	public String getModelClassName() {
		return BtHotelInfo.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("btHotelInfoId", getBtHotelInfoId());
		attributes.put("businessTripPkId", getBusinessTripPkId());
		attributes.put("ticketNo", getTicketNo());
		attributes.put("city", getCity());
		attributes.put("cityType", getCityType());
		attributes.put("hotel", getHotel());
		attributes.put("checkIn", getCheckIn());
		attributes.put("checkOut", getCheckOut());
		attributes.put("roomCategory", getRoomCategory());
		attributes.put("price", getPrice());
		attributes.put("currency", getCurrency());
		attributes.put("otherReasonInfo", getOtherReasonInfo());
		attributes.put("isNotBookedFromTA", getIsNotBookedFromTA());
		attributes.put("isOverBudget", getIsOverBudget());
		attributes.put("othersSpecify", getOthersSpecify());
		attributes.put("tripType", getTripType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long btHotelInfoId = (Long)attributes.get("btHotelInfoId");

		if (btHotelInfoId != null) {
			setBtHotelInfoId(btHotelInfoId);
		}

		Long businessTripPkId = (Long)attributes.get("businessTripPkId");

		if (businessTripPkId != null) {
			setBusinessTripPkId(businessTripPkId);
		}

		String ticketNo = (String)attributes.get("ticketNo");

		if (ticketNo != null) {
			setTicketNo(ticketNo);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String cityType = (String)attributes.get("cityType");

		if (cityType != null) {
			setCityType(cityType);
		}

		String hotel = (String)attributes.get("hotel");

		if (hotel != null) {
			setHotel(hotel);
		}

		Date checkIn = (Date)attributes.get("checkIn");

		if (checkIn != null) {
			setCheckIn(checkIn);
		}

		Date checkOut = (Date)attributes.get("checkOut");

		if (checkOut != null) {
			setCheckOut(checkOut);
		}

		String roomCategory = (String)attributes.get("roomCategory");

		if (roomCategory != null) {
			setRoomCategory(roomCategory);
		}

		Double price = (Double)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}

		String currency = (String)attributes.get("currency");

		if (currency != null) {
			setCurrency(currency);
		}

		String otherReasonInfo = (String)attributes.get("otherReasonInfo");

		if (otherReasonInfo != null) {
			setOtherReasonInfo(otherReasonInfo);
		}

		Boolean isNotBookedFromTA = (Boolean)attributes.get("isNotBookedFromTA");

		if (isNotBookedFromTA != null) {
			setIsNotBookedFromTA(isNotBookedFromTA);
		}

		Integer isOverBudget = (Integer)attributes.get("isOverBudget");

		if (isOverBudget != null) {
			setIsOverBudget(isOverBudget);
		}

		String othersSpecify = (String)attributes.get("othersSpecify");

		if (othersSpecify != null) {
			setOthersSpecify(othersSpecify);
		}

		String tripType = (String)attributes.get("tripType");

		if (tripType != null) {
			setTripType(tripType);
		}
	}

	/**
	* Returns the primary key of this bt hotel info.
	*
	* @return the primary key of this bt hotel info
	*/
	@Override
	public long getPrimaryKey() {
		return _btHotelInfo.getPrimaryKey();
	}

	/**
	* Sets the primary key of this bt hotel info.
	*
	* @param primaryKey the primary key of this bt hotel info
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_btHotelInfo.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the bt hotel info ID of this bt hotel info.
	*
	* @return the bt hotel info ID of this bt hotel info
	*/
	@Override
	public long getBtHotelInfoId() {
		return _btHotelInfo.getBtHotelInfoId();
	}

	/**
	* Sets the bt hotel info ID of this bt hotel info.
	*
	* @param btHotelInfoId the bt hotel info ID of this bt hotel info
	*/
	@Override
	public void setBtHotelInfoId(long btHotelInfoId) {
		_btHotelInfo.setBtHotelInfoId(btHotelInfoId);
	}

	/**
	* Returns the business trip pk ID of this bt hotel info.
	*
	* @return the business trip pk ID of this bt hotel info
	*/
	@Override
	public long getBusinessTripPkId() {
		return _btHotelInfo.getBusinessTripPkId();
	}

	/**
	* Sets the business trip pk ID of this bt hotel info.
	*
	* @param businessTripPkId the business trip pk ID of this bt hotel info
	*/
	@Override
	public void setBusinessTripPkId(long businessTripPkId) {
		_btHotelInfo.setBusinessTripPkId(businessTripPkId);
	}

	/**
	* Returns the ticket no of this bt hotel info.
	*
	* @return the ticket no of this bt hotel info
	*/
	@Override
	public java.lang.String getTicketNo() {
		return _btHotelInfo.getTicketNo();
	}

	/**
	* Sets the ticket no of this bt hotel info.
	*
	* @param ticketNo the ticket no of this bt hotel info
	*/
	@Override
	public void setTicketNo(java.lang.String ticketNo) {
		_btHotelInfo.setTicketNo(ticketNo);
	}

	/**
	* Returns the city of this bt hotel info.
	*
	* @return the city of this bt hotel info
	*/
	@Override
	public java.lang.String getCity() {
		return _btHotelInfo.getCity();
	}

	/**
	* Sets the city of this bt hotel info.
	*
	* @param city the city of this bt hotel info
	*/
	@Override
	public void setCity(java.lang.String city) {
		_btHotelInfo.setCity(city);
	}

	/**
	* Returns the city type of this bt hotel info.
	*
	* @return the city type of this bt hotel info
	*/
	@Override
	public java.lang.String getCityType() {
		return _btHotelInfo.getCityType();
	}

	/**
	* Sets the city type of this bt hotel info.
	*
	* @param cityType the city type of this bt hotel info
	*/
	@Override
	public void setCityType(java.lang.String cityType) {
		_btHotelInfo.setCityType(cityType);
	}

	/**
	* Returns the hotel of this bt hotel info.
	*
	* @return the hotel of this bt hotel info
	*/
	@Override
	public java.lang.String getHotel() {
		return _btHotelInfo.getHotel();
	}

	/**
	* Sets the hotel of this bt hotel info.
	*
	* @param hotel the hotel of this bt hotel info
	*/
	@Override
	public void setHotel(java.lang.String hotel) {
		_btHotelInfo.setHotel(hotel);
	}

	/**
	* Returns the check in of this bt hotel info.
	*
	* @return the check in of this bt hotel info
	*/
	@Override
	public java.util.Date getCheckIn() {
		return _btHotelInfo.getCheckIn();
	}

	/**
	* Sets the check in of this bt hotel info.
	*
	* @param checkIn the check in of this bt hotel info
	*/
	@Override
	public void setCheckIn(java.util.Date checkIn) {
		_btHotelInfo.setCheckIn(checkIn);
	}

	/**
	* Returns the check out of this bt hotel info.
	*
	* @return the check out of this bt hotel info
	*/
	@Override
	public java.util.Date getCheckOut() {
		return _btHotelInfo.getCheckOut();
	}

	/**
	* Sets the check out of this bt hotel info.
	*
	* @param checkOut the check out of this bt hotel info
	*/
	@Override
	public void setCheckOut(java.util.Date checkOut) {
		_btHotelInfo.setCheckOut(checkOut);
	}

	/**
	* Returns the room category of this bt hotel info.
	*
	* @return the room category of this bt hotel info
	*/
	@Override
	public java.lang.String getRoomCategory() {
		return _btHotelInfo.getRoomCategory();
	}

	/**
	* Sets the room category of this bt hotel info.
	*
	* @param roomCategory the room category of this bt hotel info
	*/
	@Override
	public void setRoomCategory(java.lang.String roomCategory) {
		_btHotelInfo.setRoomCategory(roomCategory);
	}

	/**
	* Returns the price of this bt hotel info.
	*
	* @return the price of this bt hotel info
	*/
	@Override
	public double getPrice() {
		return _btHotelInfo.getPrice();
	}

	/**
	* Sets the price of this bt hotel info.
	*
	* @param price the price of this bt hotel info
	*/
	@Override
	public void setPrice(double price) {
		_btHotelInfo.setPrice(price);
	}

	/**
	* Returns the currency of this bt hotel info.
	*
	* @return the currency of this bt hotel info
	*/
	@Override
	public java.lang.String getCurrency() {
		return _btHotelInfo.getCurrency();
	}

	/**
	* Sets the currency of this bt hotel info.
	*
	* @param currency the currency of this bt hotel info
	*/
	@Override
	public void setCurrency(java.lang.String currency) {
		_btHotelInfo.setCurrency(currency);
	}

	/**
	* Returns the other reason info of this bt hotel info.
	*
	* @return the other reason info of this bt hotel info
	*/
	@Override
	public java.lang.String getOtherReasonInfo() {
		return _btHotelInfo.getOtherReasonInfo();
	}

	/**
	* Sets the other reason info of this bt hotel info.
	*
	* @param otherReasonInfo the other reason info of this bt hotel info
	*/
	@Override
	public void setOtherReasonInfo(java.lang.String otherReasonInfo) {
		_btHotelInfo.setOtherReasonInfo(otherReasonInfo);
	}

	/**
	* Returns the is not booked from t a of this bt hotel info.
	*
	* @return the is not booked from t a of this bt hotel info
	*/
	@Override
	public boolean getIsNotBookedFromTA() {
		return _btHotelInfo.getIsNotBookedFromTA();
	}

	/**
	* Returns <code>true</code> if this bt hotel info is is not booked from t a.
	*
	* @return <code>true</code> if this bt hotel info is is not booked from t a; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsNotBookedFromTA() {
		return _btHotelInfo.isIsNotBookedFromTA();
	}

	/**
	* Sets whether this bt hotel info is is not booked from t a.
	*
	* @param isNotBookedFromTA the is not booked from t a of this bt hotel info
	*/
	@Override
	public void setIsNotBookedFromTA(boolean isNotBookedFromTA) {
		_btHotelInfo.setIsNotBookedFromTA(isNotBookedFromTA);
	}

	/**
	* Returns the is over budget of this bt hotel info.
	*
	* @return the is over budget of this bt hotel info
	*/
	@Override
	public int getIsOverBudget() {
		return _btHotelInfo.getIsOverBudget();
	}

	/**
	* Sets the is over budget of this bt hotel info.
	*
	* @param isOverBudget the is over budget of this bt hotel info
	*/
	@Override
	public void setIsOverBudget(int isOverBudget) {
		_btHotelInfo.setIsOverBudget(isOverBudget);
	}

	/**
	* Returns the others specify of this bt hotel info.
	*
	* @return the others specify of this bt hotel info
	*/
	@Override
	public java.lang.String getOthersSpecify() {
		return _btHotelInfo.getOthersSpecify();
	}

	/**
	* Sets the others specify of this bt hotel info.
	*
	* @param othersSpecify the others specify of this bt hotel info
	*/
	@Override
	public void setOthersSpecify(java.lang.String othersSpecify) {
		_btHotelInfo.setOthersSpecify(othersSpecify);
	}

	/**
	* Returns the trip type of this bt hotel info.
	*
	* @return the trip type of this bt hotel info
	*/
	@Override
	public java.lang.String getTripType() {
		return _btHotelInfo.getTripType();
	}

	/**
	* Sets the trip type of this bt hotel info.
	*
	* @param tripType the trip type of this bt hotel info
	*/
	@Override
	public void setTripType(java.lang.String tripType) {
		_btHotelInfo.setTripType(tripType);
	}

	@Override
	public boolean isNew() {
		return _btHotelInfo.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_btHotelInfo.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _btHotelInfo.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_btHotelInfo.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _btHotelInfo.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _btHotelInfo.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_btHotelInfo.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _btHotelInfo.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_btHotelInfo.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_btHotelInfo.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_btHotelInfo.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BtHotelInfoWrapper((BtHotelInfo)_btHotelInfo.clone());
	}

	@Override
	public int compareTo(com.business.trip.model.BtHotelInfo btHotelInfo) {
		return _btHotelInfo.compareTo(btHotelInfo);
	}

	@Override
	public int hashCode() {
		return _btHotelInfo.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.business.trip.model.BtHotelInfo> toCacheModel() {
		return _btHotelInfo.toCacheModel();
	}

	@Override
	public com.business.trip.model.BtHotelInfo toEscapedModel() {
		return new BtHotelInfoWrapper(_btHotelInfo.toEscapedModel());
	}

	@Override
	public com.business.trip.model.BtHotelInfo toUnescapedModel() {
		return new BtHotelInfoWrapper(_btHotelInfo.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _btHotelInfo.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _btHotelInfo.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_btHotelInfo.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BtHotelInfoWrapper)) {
			return false;
		}

		BtHotelInfoWrapper btHotelInfoWrapper = (BtHotelInfoWrapper)obj;

		if (Validator.equals(_btHotelInfo, btHotelInfoWrapper._btHotelInfo)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public BtHotelInfo getWrappedBtHotelInfo() {
		return _btHotelInfo;
	}

	@Override
	public BtHotelInfo getWrappedModel() {
		return _btHotelInfo;
	}

	@Override
	public void resetOriginalValues() {
		_btHotelInfo.resetOriginalValues();
	}

	private BtHotelInfo _btHotelInfo;
}