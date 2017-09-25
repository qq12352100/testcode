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
public class BtFlightTrainInfoSoap implements Serializable {
	public static BtFlightTrainInfoSoap toSoapModel(BtFlightTrainInfo model) {
		BtFlightTrainInfoSoap soapModel = new BtFlightTrainInfoSoap();

		soapModel.setBtFlightTrainInfoId(model.getBtFlightTrainInfoId());
		soapModel.setBusinessTripPkId(model.getBusinessTripPkId());
		soapModel.setTicketNo(model.getTicketNo());
		soapModel.setType(model.getType());
		soapModel.setFromCity(model.getFromCity());
		soapModel.setToCity(model.getToCity());
		soapModel.setDepartureDate(model.getDepartureDate());
		soapModel.setDepartureFlight(model.getDepartureFlight());
		soapModel.setDepartureTime(model.getDepartureTime());
		soapModel.setClassInfo(model.getClassInfo());
		soapModel.setPrice(model.getPrice());
		soapModel.setCurrency(model.getCurrency());
		soapModel.setTripType(model.getTripType());

		return soapModel;
	}

	public static BtFlightTrainInfoSoap[] toSoapModels(
		BtFlightTrainInfo[] models) {
		BtFlightTrainInfoSoap[] soapModels = new BtFlightTrainInfoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BtFlightTrainInfoSoap[][] toSoapModels(
		BtFlightTrainInfo[][] models) {
		BtFlightTrainInfoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BtFlightTrainInfoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BtFlightTrainInfoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BtFlightTrainInfoSoap[] toSoapModels(
		List<BtFlightTrainInfo> models) {
		List<BtFlightTrainInfoSoap> soapModels = new ArrayList<BtFlightTrainInfoSoap>(models.size());

		for (BtFlightTrainInfo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BtFlightTrainInfoSoap[soapModels.size()]);
	}

	public BtFlightTrainInfoSoap() {
	}

	public long getPrimaryKey() {
		return _btFlightTrainInfoId;
	}

	public void setPrimaryKey(long pk) {
		setBtFlightTrainInfoId(pk);
	}

	public long getBtFlightTrainInfoId() {
		return _btFlightTrainInfoId;
	}

	public void setBtFlightTrainInfoId(long btFlightTrainInfoId) {
		_btFlightTrainInfoId = btFlightTrainInfoId;
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

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public String getFromCity() {
		return _fromCity;
	}

	public void setFromCity(String fromCity) {
		_fromCity = fromCity;
	}

	public String getToCity() {
		return _toCity;
	}

	public void setToCity(String toCity) {
		_toCity = toCity;
	}

	public Date getDepartureDate() {
		return _departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		_departureDate = departureDate;
	}

	public String getDepartureFlight() {
		return _departureFlight;
	}

	public void setDepartureFlight(String departureFlight) {
		_departureFlight = departureFlight;
	}

	public Date getDepartureTime() {
		return _departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		_departureTime = departureTime;
	}

	public String getClassInfo() {
		return _classInfo;
	}

	public void setClassInfo(String classInfo) {
		_classInfo = classInfo;
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

	private long _btFlightTrainInfoId;
	private long _businessTripPkId;
	private String _ticketNo;
	private String _type;
	private String _fromCity;
	private String _toCity;
	private Date _departureDate;
	private String _departureFlight;
	private Date _departureTime;
	private String _classInfo;
	private double _price;
	private String _currency;
	private String _tripType;
}