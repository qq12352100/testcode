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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BtHotelInfoSoap implements Serializable {
	public static BtHotelInfoSoap toSoapModel(BtHotelInfo model) {
		BtHotelInfoSoap soapModel = new BtHotelInfoSoap();

		soapModel.setBtHotelInfoId(model.getBtHotelInfoId());
		soapModel.setBusinessTripPkId(model.getBusinessTripPkId());
		soapModel.setTicketNo(model.getTicketNo());
		soapModel.setCity(model.getCity());
		soapModel.setCityType(model.getCityType());
		soapModel.setHotel(model.getHotel());
		soapModel.setCheckIn(model.getCheckIn());
		soapModel.setCheckOut(model.getCheckOut());
		soapModel.setRoomCategory(model.getRoomCategory());
		soapModel.setPrice(model.getPrice());
		soapModel.setCurrency(model.getCurrency());
		soapModel.setOtherReasonInfo(model.getOtherReasonInfo());
		soapModel.setIsNotBookedFromTA(model.getIsNotBookedFromTA());
		soapModel.setIsOverBudget(model.getIsOverBudget());
		soapModel.setOthersSpecify(model.getOthersSpecify());
		soapModel.setTripType(model.getTripType());

		return soapModel;
	}

	public static BtHotelInfoSoap[] toSoapModels(BtHotelInfo[] models) {
		BtHotelInfoSoap[] soapModels = new BtHotelInfoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BtHotelInfoSoap[][] toSoapModels(BtHotelInfo[][] models) {
		BtHotelInfoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BtHotelInfoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BtHotelInfoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BtHotelInfoSoap[] toSoapModels(List<BtHotelInfo> models) {
		List<BtHotelInfoSoap> soapModels = new ArrayList<BtHotelInfoSoap>(models.size());

		for (BtHotelInfo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BtHotelInfoSoap[soapModels.size()]);
	}

	public BtHotelInfoSoap() {
	}

	public long getPrimaryKey() {
		return _btHotelInfoId;
	}

	public void setPrimaryKey(long pk) {
		setBtHotelInfoId(pk);
	}

	public long getBtHotelInfoId() {
		return _btHotelInfoId;
	}

	public void setBtHotelInfoId(long btHotelInfoId) {
		_btHotelInfoId = btHotelInfoId;
	}

	public long getBusinessTripPkId() {
		return _businessTripPkId;
	}

	public void setBusinessTripPkId(long businessTripPkId) {
		_businessTripPkId = businessTripPkId;
	}

	public String getTicketNo() {
		return _ticketNo;
	}

	public void setTicketNo(String ticketNo) {
		_ticketNo = ticketNo;
	}

	public String getCity() {
		return _city;
	}

	public void setCity(String city) {
		_city = city;
	}

	public String getCityType() {
		return _cityType;
	}

	public void setCityType(String cityType) {
		_cityType = cityType;
	}

	public String getHotel() {
		return _hotel;
	}

	public void setHotel(String hotel) {
		_hotel = hotel;
	}

	public Date getCheckIn() {
		return _checkIn;
	}

	public void setCheckIn(Date checkIn) {
		_checkIn = checkIn;
	}

	public Date getCheckOut() {
		return _checkOut;
	}

	public void setCheckOut(Date checkOut) {
		_checkOut = checkOut;
	}

	public String getRoomCategory() {
		return _roomCategory;
	}

	public void setRoomCategory(String roomCategory) {
		_roomCategory = roomCategory;
	}

	public double getPrice() {
		return _price;
	}

	public void setPrice(double price) {
		_price = price;
	}

	public String getCurrency() {
		return _currency;
	}

	public void setCurrency(String currency) {
		_currency = currency;
	}

	public String getOtherReasonInfo() {
		return _otherReasonInfo;
	}

	public void setOtherReasonInfo(String otherReasonInfo) {
		_otherReasonInfo = otherReasonInfo;
	}

	public boolean getIsNotBookedFromTA() {
		return _isNotBookedFromTA;
	}

	public boolean isIsNotBookedFromTA() {
		return _isNotBookedFromTA;
	}

	public void setIsNotBookedFromTA(boolean isNotBookedFromTA) {
		_isNotBookedFromTA = isNotBookedFromTA;
	}

	public int getIsOverBudget() {
		return _isOverBudget;
	}

	public void setIsOverBudget(int isOverBudget) {
		_isOverBudget = isOverBudget;
	}

	public String getOthersSpecify() {
		return _othersSpecify;
	}

	public void setOthersSpecify(String othersSpecify) {
		_othersSpecify = othersSpecify;
	}

	public String getTripType() {
		return _tripType;
	}

	public void setTripType(String tripType) {
		_tripType = tripType;
	}

	private long _btHotelInfoId;
	private long _businessTripPkId;
	private String _ticketNo;
	private String _city;
	private String _cityType;
	private String _hotel;
	private Date _checkIn;
	private Date _checkOut;
	private String _roomCategory;
	private double _price;
	private String _currency;
	private String _otherReasonInfo;
	private boolean _isNotBookedFromTA;
	private int _isOverBudget;
	private String _othersSpecify;
	private String _tripType;
}