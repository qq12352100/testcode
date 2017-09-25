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
public class BtTrainInfoSoap implements Serializable {
	public static BtTrainInfoSoap toSoapModel(BtTrainInfo model) {
		BtTrainInfoSoap soapModel = new BtTrainInfoSoap();

		soapModel.setBtTrainInfoId(model.getBtTrainInfoId());
		soapModel.setBusinessTripPkId(model.getBusinessTripPkId());
		soapModel.setTicketNo(model.getTicketNo());
		soapModel.setFromCity(model.getFromCity());
		soapModel.setToCity(model.getToCity());
		soapModel.setDepartureDate(model.getDepartureDate());
		soapModel.setDepartureTrain(model.getDepartureTrain());
		soapModel.setClassInfo(model.getClassInfo());
		soapModel.setPrice(model.getPrice());
		soapModel.setCurrency(model.getCurrency());
		soapModel.setTripType(model.getTripType());

		return soapModel;
	}

	public static BtTrainInfoSoap[] toSoapModels(BtTrainInfo[] models) {
		BtTrainInfoSoap[] soapModels = new BtTrainInfoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BtTrainInfoSoap[][] toSoapModels(BtTrainInfo[][] models) {
		BtTrainInfoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BtTrainInfoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BtTrainInfoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BtTrainInfoSoap[] toSoapModels(List<BtTrainInfo> models) {
		List<BtTrainInfoSoap> soapModels = new ArrayList<BtTrainInfoSoap>(models.size());

		for (BtTrainInfo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BtTrainInfoSoap[soapModels.size()]);
	}

	public BtTrainInfoSoap() {
	}

	public long getPrimaryKey() {
		return _btTrainInfoId;
	}

	public void setPrimaryKey(long pk) {
		setBtTrainInfoId(pk);
	}

	public long getBtTrainInfoId() {
		return _btTrainInfoId;
	}

	public void setBtTrainInfoId(long btTrainInfoId) {
		_btTrainInfoId = btTrainInfoId;
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

	public String getDepartureTrain() {
		return _departureTrain;
	}

	public void setDepartureTrain(String departureTrain) {
		_departureTrain = departureTrain;
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

	private long _btTrainInfoId;
	private long _businessTripPkId;
	private String _ticketNo;
	private String _fromCity;
	private String _toCity;
	private Date _departureDate;
	private String _departureTrain;
	private String _classInfo;
	private double _price;
	private String _currency;
	private String _tripType;
}