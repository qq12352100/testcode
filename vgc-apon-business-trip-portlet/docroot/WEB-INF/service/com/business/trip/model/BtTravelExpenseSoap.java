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
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BtTravelExpenseSoap implements Serializable {
	public static BtTravelExpenseSoap toSoapModel(BtTravelExpense model) {
		BtTravelExpenseSoap soapModel = new BtTravelExpenseSoap();

		soapModel.setBtTravelExpenseId(model.getBtTravelExpenseId());
		soapModel.setBusinessTripPkId(model.getBusinessTripPkId());
		soapModel.setTicketNo(model.getTicketNo());
		soapModel.setTravelDate(model.getTravelDate());
		soapModel.setDeparture(model.getDeparture());
		soapModel.setArrival(model.getArrival());
		soapModel.setFromCity(model.getFromCity());
		soapModel.setToCity(model.getToCity());
		soapModel.setIsHasBreakfast(model.getIsHasBreakfast());
		soapModel.setIsHasLunch(model.getIsHasLunch());
		soapModel.setIsHasDinner(model.getIsHasDinner());
		soapModel.setCountry(model.getCountry());
		soapModel.setCity(model.getCity());
		soapModel.setRateOfDma(model.getRateOfDma());
		soapModel.setCurrency(model.getCurrency());
		soapModel.setAllowance(model.getAllowance());
		soapModel.setComments(model.getComments());
		soapModel.setTripType(model.getTripType());
		soapModel.setAllowanceRmb(model.getAllowanceRmb());

		return soapModel;
	}

	public static BtTravelExpenseSoap[] toSoapModels(BtTravelExpense[] models) {
		BtTravelExpenseSoap[] soapModels = new BtTravelExpenseSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BtTravelExpenseSoap[][] toSoapModels(
		BtTravelExpense[][] models) {
		BtTravelExpenseSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BtTravelExpenseSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BtTravelExpenseSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BtTravelExpenseSoap[] toSoapModels(
		List<BtTravelExpense> models) {
		List<BtTravelExpenseSoap> soapModels = new ArrayList<BtTravelExpenseSoap>(models.size());

		for (BtTravelExpense model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BtTravelExpenseSoap[soapModels.size()]);
	}

	public BtTravelExpenseSoap() {
	}

	public long getPrimaryKey() {
		return _btTravelExpenseId;
	}

	public void setPrimaryKey(long pk) {
		setBtTravelExpenseId(pk);
	}

	public long getBtTravelExpenseId() {
		return _btTravelExpenseId;
	}

	public void setBtTravelExpenseId(long btTravelExpenseId) {
		_btTravelExpenseId = btTravelExpenseId;
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

	public String getTravelDate() {
		return _travelDate;
	}

	public void setTravelDate(String travelDate) {
		_travelDate = travelDate;
	}

	public String getDeparture() {
		return _departure;
	}

	public void setDeparture(String departure) {
		_departure = departure;
	}

	public String getArrival() {
		return _arrival;
	}

	public void setArrival(String arrival) {
		_arrival = arrival;
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

	public boolean getIsHasBreakfast() {
		return _isHasBreakfast;
	}

	public boolean isIsHasBreakfast() {
		return _isHasBreakfast;
	}

	public void setIsHasBreakfast(boolean isHasBreakfast) {
		_isHasBreakfast = isHasBreakfast;
	}

	public boolean getIsHasLunch() {
		return _isHasLunch;
	}

	public boolean isIsHasLunch() {
		return _isHasLunch;
	}

	public void setIsHasLunch(boolean isHasLunch) {
		_isHasLunch = isHasLunch;
	}

	public boolean getIsHasDinner() {
		return _isHasDinner;
	}

	public boolean isIsHasDinner() {
		return _isHasDinner;
	}

	public void setIsHasDinner(boolean isHasDinner) {
		_isHasDinner = isHasDinner;
	}

	public String getCountry() {
		return _country;
	}

	public void setCountry(String country) {
		_country = country;
	}

	public String getCity() {
		return _city;
	}

	public void setCity(String city) {
		_city = city;
	}

	public double getRateOfDma() {
		return _rateOfDma;
	}

	public void setRateOfDma(double rateOfDma) {
		_rateOfDma = rateOfDma;
	}

	public String getCurrency() {
		return _currency;
	}

	public void setCurrency(String currency) {
		_currency = currency;
	}

	public double getAllowance() {
		return _allowance;
	}

	public void setAllowance(double allowance) {
		_allowance = allowance;
	}

	public String getComments() {
		return _comments;
	}

	public void setComments(String comments) {
		_comments = comments;
	}

	public String getTripType() {
		return _tripType;
	}

	public void setTripType(String tripType) {
		_tripType = tripType;
	}

	public double getAllowanceRmb() {
		return _allowanceRmb;
	}

	public void setAllowanceRmb(double allowanceRmb) {
		_allowanceRmb = allowanceRmb;
	}

	private long _btTravelExpenseId;
	private long _businessTripPkId;
	private String _ticketNo;
	private String _travelDate;
	private String _departure;
	private String _arrival;
	private String _fromCity;
	private String _toCity;
	private boolean _isHasBreakfast;
	private boolean _isHasLunch;
	private boolean _isHasDinner;
	private String _country;
	private String _city;
	private double _rateOfDma;
	private String _currency;
	private double _allowance;
	private String _comments;
	private String _tripType;
	private double _allowanceRmb;
}