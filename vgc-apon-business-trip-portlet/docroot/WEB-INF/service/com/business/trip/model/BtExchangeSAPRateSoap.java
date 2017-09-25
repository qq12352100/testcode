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
public class BtExchangeSAPRateSoap implements Serializable {
	public static BtExchangeSAPRateSoap toSoapModel(BtExchangeSAPRate model) {
		BtExchangeSAPRateSoap soapModel = new BtExchangeSAPRateSoap();

		soapModel.setBtExchangeSAPRateId(model.getBtExchangeSAPRateId());
		soapModel.setFromCurrency(model.getFromCurrency());
		soapModel.setToCurrency(model.getToCurrency());
		soapModel.setCurrencyRate(model.getCurrencyRate());
		soapModel.setRateType(model.getRateType());
		soapModel.setSapDate(model.getSapDate());
		soapModel.setImportDate(model.getImportDate());

		return soapModel;
	}

	public static BtExchangeSAPRateSoap[] toSoapModels(
		BtExchangeSAPRate[] models) {
		BtExchangeSAPRateSoap[] soapModels = new BtExchangeSAPRateSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BtExchangeSAPRateSoap[][] toSoapModels(
		BtExchangeSAPRate[][] models) {
		BtExchangeSAPRateSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BtExchangeSAPRateSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BtExchangeSAPRateSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BtExchangeSAPRateSoap[] toSoapModels(
		List<BtExchangeSAPRate> models) {
		List<BtExchangeSAPRateSoap> soapModels = new ArrayList<BtExchangeSAPRateSoap>(models.size());

		for (BtExchangeSAPRate model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BtExchangeSAPRateSoap[soapModels.size()]);
	}

	public BtExchangeSAPRateSoap() {
	}

	public long getPrimaryKey() {
		return _btExchangeSAPRateId;
	}

	public void setPrimaryKey(long pk) {
		setBtExchangeSAPRateId(pk);
	}

	public long getBtExchangeSAPRateId() {
		return _btExchangeSAPRateId;
	}

	public void setBtExchangeSAPRateId(long btExchangeSAPRateId) {
		_btExchangeSAPRateId = btExchangeSAPRateId;
	}

	public String getFromCurrency() {
		return _fromCurrency;
	}

	public void setFromCurrency(String fromCurrency) {
		_fromCurrency = fromCurrency;
	}

	public String getToCurrency() {
		return _toCurrency;
	}

	public void setToCurrency(String toCurrency) {
		_toCurrency = toCurrency;
	}

	public double getCurrencyRate() {
		return _currencyRate;
	}

	public void setCurrencyRate(double currencyRate) {
		_currencyRate = currencyRate;
	}

	public String getRateType() {
		return _rateType;
	}

	public void setRateType(String rateType) {
		_rateType = rateType;
	}

	public Date getSapDate() {
		return _sapDate;
	}

	public void setSapDate(Date sapDate) {
		_sapDate = sapDate;
	}

	public Date getImportDate() {
		return _importDate;
	}

	public void setImportDate(Date importDate) {
		_importDate = importDate;
	}

	private long _btExchangeSAPRateId;
	private String _fromCurrency;
	private String _toCurrency;
	private double _currencyRate;
	private String _rateType;
	private Date _sapDate;
	private Date _importDate;
}