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
public class BtCostListSoap implements Serializable {
	public static BtCostListSoap toSoapModel(BtCostList model) {
		BtCostListSoap soapModel = new BtCostListSoap();

		soapModel.setBtCostListId(model.getBtCostListId());
		soapModel.setBusinessTripPkId(model.getBusinessTripPkId());
		soapModel.setTicketNo(model.getTicketNo());
		soapModel.setItem(model.getItem());
		soapModel.setInvoiceCurrency(model.getInvoiceCurrency());
		soapModel.setPaymentAmount(model.getPaymentAmount());
		soapModel.setPaymentCurrency(model.getPaymentCurrency());
		soapModel.setCountryCity(model.getCountryCity());
		soapModel.setType(model.getType());
		soapModel.setInvoiceAmount(model.getInvoiceAmount());
		soapModel.setTaxRate(model.getTaxRate());
		soapModel.setNetAmount(model.getNetAmount());
		soapModel.setTaxAmount(model.getTaxAmount());
		soapModel.setNetAmountRmb(model.getNetAmountRmb());
		soapModel.setEntertainmentDate(model.getEntertainmentDate());
		soapModel.setEntertainmentPlace(model.getEntertainmentPlace());
		soapModel.setReasonesInfo(model.getReasonesInfo());
		soapModel.setAttendeesTotal(model.getAttendeesTotal());
		soapModel.setAverageSpend(model.getAverageSpend());
		soapModel.setMealCategory(model.getMealCategory());

		return soapModel;
	}

	public static BtCostListSoap[] toSoapModels(BtCostList[] models) {
		BtCostListSoap[] soapModels = new BtCostListSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BtCostListSoap[][] toSoapModels(BtCostList[][] models) {
		BtCostListSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BtCostListSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BtCostListSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BtCostListSoap[] toSoapModels(List<BtCostList> models) {
		List<BtCostListSoap> soapModels = new ArrayList<BtCostListSoap>(models.size());

		for (BtCostList model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BtCostListSoap[soapModels.size()]);
	}

	public BtCostListSoap() {
	}

	public long getPrimaryKey() {
		return _btCostListId;
	}

	public void setPrimaryKey(long pk) {
		setBtCostListId(pk);
	}

	public long getBtCostListId() {
		return _btCostListId;
	}

	public void setBtCostListId(long btCostListId) {
		_btCostListId = btCostListId;
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

	public String getItem() {
		return _item;
	}

	public void setItem(String item) {
		_item = item;
	}

	public String getInvoiceCurrency() {
		return _invoiceCurrency;
	}

	public void setInvoiceCurrency(String invoiceCurrency) {
		_invoiceCurrency = invoiceCurrency;
	}

	public double getPaymentAmount() {
		return _paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		_paymentAmount = paymentAmount;
	}

	public String getPaymentCurrency() {
		return _paymentCurrency;
	}

	public void setPaymentCurrency(String paymentCurrency) {
		_paymentCurrency = paymentCurrency;
	}

	public String getCountryCity() {
		return _countryCity;
	}

	public void setCountryCity(String countryCity) {
		_countryCity = countryCity;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public double getInvoiceAmount() {
		return _invoiceAmount;
	}

	public void setInvoiceAmount(double invoiceAmount) {
		_invoiceAmount = invoiceAmount;
	}

	public double getTaxRate() {
		return _taxRate;
	}

	public void setTaxRate(double taxRate) {
		_taxRate = taxRate;
	}

	public double getNetAmount() {
		return _netAmount;
	}

	public void setNetAmount(double netAmount) {
		_netAmount = netAmount;
	}

	public double getTaxAmount() {
		return _taxAmount;
	}

	public void setTaxAmount(double taxAmount) {
		_taxAmount = taxAmount;
	}

	public double getNetAmountRmb() {
		return _netAmountRmb;
	}

	public void setNetAmountRmb(double netAmountRmb) {
		_netAmountRmb = netAmountRmb;
	}

	public Date getEntertainmentDate() {
		return _entertainmentDate;
	}

	public void setEntertainmentDate(Date entertainmentDate) {
		_entertainmentDate = entertainmentDate;
	}

	public String getEntertainmentPlace() {
		return _entertainmentPlace;
	}

	public void setEntertainmentPlace(String entertainmentPlace) {
		_entertainmentPlace = entertainmentPlace;
	}

	public String getReasonesInfo() {
		return _reasonesInfo;
	}

	public void setReasonesInfo(String reasonesInfo) {
		_reasonesInfo = reasonesInfo;
	}

	public int getAttendeesTotal() {
		return _attendeesTotal;
	}

	public void setAttendeesTotal(int attendeesTotal) {
		_attendeesTotal = attendeesTotal;
	}

	public double getAverageSpend() {
		return _averageSpend;
	}

	public void setAverageSpend(double averageSpend) {
		_averageSpend = averageSpend;
	}

	public String getMealCategory() {
		return _mealCategory;
	}

	public void setMealCategory(String mealCategory) {
		_mealCategory = mealCategory;
	}

	private long _btCostListId;
	private long _businessTripPkId;
	private String _ticketNo;
	private String _item;
	private String _invoiceCurrency;
	private double _paymentAmount;
	private String _paymentCurrency;
	private String _countryCity;
	private String _type;
	private double _invoiceAmount;
	private double _taxRate;
	private double _netAmount;
	private double _taxAmount;
	private double _netAmountRmb;
	private Date _entertainmentDate;
	private String _entertainmentPlace;
	private String _reasonesInfo;
	private int _attendeesTotal;
	private double _averageSpend;
	private String _mealCategory;
}