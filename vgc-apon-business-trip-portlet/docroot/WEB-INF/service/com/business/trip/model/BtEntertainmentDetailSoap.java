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
public class BtEntertainmentDetailSoap implements Serializable {
	public static BtEntertainmentDetailSoap toSoapModel(
		BtEntertainmentDetail model) {
		BtEntertainmentDetailSoap soapModel = new BtEntertainmentDetailSoap();

		soapModel.setBtEntertainmentDetailId(model.getBtEntertainmentDetailId());
		soapModel.setBtCostListId(model.getBtCostListId());
		soapModel.setBusinessTripPkId(model.getBusinessTripPkId());
		soapModel.setFullName(model.getFullName());
		soapModel.setPositionTitle(model.getPositionTitle());
		soapModel.setCompany(model.getCompany());

		return soapModel;
	}

	public static BtEntertainmentDetailSoap[] toSoapModels(
		BtEntertainmentDetail[] models) {
		BtEntertainmentDetailSoap[] soapModels = new BtEntertainmentDetailSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BtEntertainmentDetailSoap[][] toSoapModels(
		BtEntertainmentDetail[][] models) {
		BtEntertainmentDetailSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BtEntertainmentDetailSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BtEntertainmentDetailSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BtEntertainmentDetailSoap[] toSoapModels(
		List<BtEntertainmentDetail> models) {
		List<BtEntertainmentDetailSoap> soapModels = new ArrayList<BtEntertainmentDetailSoap>(models.size());

		for (BtEntertainmentDetail model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BtEntertainmentDetailSoap[soapModels.size()]);
	}

	public BtEntertainmentDetailSoap() {
	}

	public long getPrimaryKey() {
		return _btEntertainmentDetailId;
	}

	public void setPrimaryKey(long pk) {
		setBtEntertainmentDetailId(pk);
	}

	public long getBtEntertainmentDetailId() {
		return _btEntertainmentDetailId;
	}

	public void setBtEntertainmentDetailId(long btEntertainmentDetailId) {
		_btEntertainmentDetailId = btEntertainmentDetailId;
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

	public String getFullName() {
		return _fullName;
	}

	public void setFullName(String fullName) {
		_fullName = fullName;
	}

	public String getPositionTitle() {
		return _positionTitle;
	}

	public void setPositionTitle(String positionTitle) {
		_positionTitle = positionTitle;
	}

	public String getCompany() {
		return _company;
	}

	public void setCompany(String company) {
		_company = company;
	}

	private long _btEntertainmentDetailId;
	private long _btCostListId;
	private long _businessTripPkId;
	private String _fullName;
	private String _positionTitle;
	private String _company;
}