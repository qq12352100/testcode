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
public class BtCarRentalInfoSoap implements Serializable {
	public static BtCarRentalInfoSoap toSoapModel(BtCarRentalInfo model) {
		BtCarRentalInfoSoap soapModel = new BtCarRentalInfoSoap();

		soapModel.setBtCarRentalInfoId(model.getBtCarRentalInfoId());
		soapModel.setBusinessTripPkId(model.getBusinessTripPkId());
		soapModel.setTicketNo(model.getTicketNo());
		soapModel.setPickupLocation(model.getPickupLocation());
		soapModel.setPickupDate(model.getPickupDate());
		soapModel.setDropoffLocation(model.getDropoffLocation());
		soapModel.setDropoffDate(model.getDropoffDate());
		soapModel.setCarType(model.getCarType());
		soapModel.setTypeOfRental(model.getTypeOfRental());
		soapModel.setPrice(model.getPrice());
		soapModel.setCurrency(model.getCurrency());
		soapModel.setTripType(model.getTripType());

		return soapModel;
	}

	public static BtCarRentalInfoSoap[] toSoapModels(BtCarRentalInfo[] models) {
		BtCarRentalInfoSoap[] soapModels = new BtCarRentalInfoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BtCarRentalInfoSoap[][] toSoapModels(
		BtCarRentalInfo[][] models) {
		BtCarRentalInfoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BtCarRentalInfoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BtCarRentalInfoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BtCarRentalInfoSoap[] toSoapModels(
		List<BtCarRentalInfo> models) {
		List<BtCarRentalInfoSoap> soapModels = new ArrayList<BtCarRentalInfoSoap>(models.size());

		for (BtCarRentalInfo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BtCarRentalInfoSoap[soapModels.size()]);
	}

	public BtCarRentalInfoSoap() {
	}

	public long getPrimaryKey() {
		return _btCarRentalInfoId;
	}

	public void setPrimaryKey(long pk) {
		setBtCarRentalInfoId(pk);
	}

	public long getBtCarRentalInfoId() {
		return _btCarRentalInfoId;
	}

	public void setBtCarRentalInfoId(long btCarRentalInfoId) {
		_btCarRentalInfoId = btCarRentalInfoId;
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

	public String getPickupLocation() {
		return _pickupLocation;
	}

	public void setPickupLocation(String pickupLocation) {
		_pickupLocation = pickupLocation;
	}

	public Date getPickupDate() {
		return _pickupDate;
	}

	public void setPickupDate(Date pickupDate) {
		_pickupDate = pickupDate;
	}

	public String getDropoffLocation() {
		return _dropoffLocation;
	}

	public void setDropoffLocation(String dropoffLocation) {
		_dropoffLocation = dropoffLocation;
	}

	public Date getDropoffDate() {
		return _dropoffDate;
	}

	public void setDropoffDate(Date dropoffDate) {
		_dropoffDate = dropoffDate;
	}

	public String getCarType() {
		return _carType;
	}

	public void setCarType(String carType) {
		_carType = carType;
	}

	public String getTypeOfRental() {
		return _typeOfRental;
	}

	public void setTypeOfRental(String typeOfRental) {
		_typeOfRental = typeOfRental;
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

	public String getTripType() {
		return _tripType;
	}

	public void setTripType(String tripType) {
		_tripType = tripType;
	}

	private long _btCarRentalInfoId;
	private long _businessTripPkId;
	private String _ticketNo;
	private String _pickupLocation;
	private Date _pickupDate;
	private String _dropoffLocation;
	private Date _dropoffDate;
	private String _carType;
	private String _typeOfRental;
	private double _price;
	private String _currency;
	private String _tripType;
}