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
public class BtExchangeRateSoap implements Serializable {
	public static BtExchangeRateSoap toSoapModel(BtExchangeRate model) {
		BtExchangeRateSoap soapModel = new BtExchangeRateSoap();

		soapModel.setBtExchangeRateId(model.getBtExchangeRateId());
		soapModel.setFirstCurrency(model.getFirstCurrency());
		soapModel.setSecondCurrency(model.getSecondCurrency());
		soapModel.setFirToSecExchangeRate(model.getFirToSecExchangeRate());
		soapModel.setSecToFirExchangeRate(model.getSecToFirExchangeRate());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static BtExchangeRateSoap[] toSoapModels(BtExchangeRate[] models) {
		BtExchangeRateSoap[] soapModels = new BtExchangeRateSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BtExchangeRateSoap[][] toSoapModels(BtExchangeRate[][] models) {
		BtExchangeRateSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BtExchangeRateSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BtExchangeRateSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BtExchangeRateSoap[] toSoapModels(List<BtExchangeRate> models) {
		List<BtExchangeRateSoap> soapModels = new ArrayList<BtExchangeRateSoap>(models.size());

		for (BtExchangeRate model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BtExchangeRateSoap[soapModels.size()]);
	}

	public BtExchangeRateSoap() {
	}

	public long getPrimaryKey() {
		return _btExchangeRateId;
	}

	public void setPrimaryKey(long pk) {
		setBtExchangeRateId(pk);
	}

	public long getBtExchangeRateId() {
		return _btExchangeRateId;
	}

	public void setBtExchangeRateId(long btExchangeRateId) {
		_btExchangeRateId = btExchangeRateId;
	}

	public String getFirstCurrency() {
		return _firstCurrency;
	}

	public void setFirstCurrency(String firstCurrency) {
		_firstCurrency = firstCurrency;
	}

	public String getSecondCurrency() {
		return _secondCurrency;
	}

	public void setSecondCurrency(String secondCurrency) {
		_secondCurrency = secondCurrency;
	}

	public double getFirToSecExchangeRate() {
		return _firToSecExchangeRate;
	}

	public void setFirToSecExchangeRate(double firToSecExchangeRate) {
		_firToSecExchangeRate = firToSecExchangeRate;
	}

	public double getSecToFirExchangeRate() {
		return _secToFirExchangeRate;
	}

	public void setSecToFirExchangeRate(double secToFirExchangeRate) {
		_secToFirExchangeRate = secToFirExchangeRate;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _btExchangeRateId;
	private String _firstCurrency;
	private String _secondCurrency;
	private double _firToSecExchangeRate;
	private double _secToFirExchangeRate;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _status;
}