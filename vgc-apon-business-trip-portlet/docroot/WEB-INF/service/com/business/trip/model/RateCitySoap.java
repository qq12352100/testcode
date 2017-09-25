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
public class RateCitySoap implements Serializable {
	public static RateCitySoap toSoapModel(RateCity model) {
		RateCitySoap soapModel = new RateCitySoap();

		soapModel.setRatecityId(model.getRatecityId());
		soapModel.setAreaName(model.getAreaName());
		soapModel.setRateOfDma(model.getRateOfDma());
		soapModel.setCurrency(model.getCurrency());
		soapModel.setParentId(model.getParentId());

		return soapModel;
	}

	public static RateCitySoap[] toSoapModels(RateCity[] models) {
		RateCitySoap[] soapModels = new RateCitySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RateCitySoap[][] toSoapModels(RateCity[][] models) {
		RateCitySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RateCitySoap[models.length][models[0].length];
		}
		else {
			soapModels = new RateCitySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RateCitySoap[] toSoapModels(List<RateCity> models) {
		List<RateCitySoap> soapModels = new ArrayList<RateCitySoap>(models.size());

		for (RateCity model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RateCitySoap[soapModels.size()]);
	}

	public RateCitySoap() {
	}

	public long getPrimaryKey() {
		return _ratecityId;
	}

	public void setPrimaryKey(long pk) {
		setRatecityId(pk);
	}

	public long getRatecityId() {
		return _ratecityId;
	}

	public void setRatecityId(long ratecityId) {
		_ratecityId = ratecityId;
	}

	public String getAreaName() {
		return _areaName;
	}

	public void setAreaName(String areaName) {
		_areaName = areaName;
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

	public long getParentId() {
		return _parentId;
	}

	public void setParentId(long parentId) {
		_parentId = parentId;
	}

	private long _ratecityId;
	private String _areaName;
	private double _rateOfDma;
	private String _currency;
	private long _parentId;
}