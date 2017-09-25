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
public class BtReimbursementSAPInfoSoap implements Serializable {
	public static BtReimbursementSAPInfoSoap toSoapModel(
		BtReimbursementSAPInfo model) {
		BtReimbursementSAPInfoSoap soapModel = new BtReimbursementSAPInfoSoap();

		soapModel.setBtReimbursementSAPInfoId(model.getBtReimbursementSAPInfoId());
		soapModel.setBusinessTripPkId(model.getBusinessTripPkId());
		soapModel.setTicketNo(model.getTicketNo());
		soapModel.setCurrency(model.getCurrency());
		soapModel.setStep(model.getStep());
		soapModel.setMessageType(model.getMessageType());
		soapModel.setMessage(model.getMessage());
		soapModel.setCertificateNo(model.getCertificateNo());
		soapModel.setCompany(model.getCompany());
		soapModel.setYear(model.getYear());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static BtReimbursementSAPInfoSoap[] toSoapModels(
		BtReimbursementSAPInfo[] models) {
		BtReimbursementSAPInfoSoap[] soapModels = new BtReimbursementSAPInfoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BtReimbursementSAPInfoSoap[][] toSoapModels(
		BtReimbursementSAPInfo[][] models) {
		BtReimbursementSAPInfoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BtReimbursementSAPInfoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BtReimbursementSAPInfoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BtReimbursementSAPInfoSoap[] toSoapModels(
		List<BtReimbursementSAPInfo> models) {
		List<BtReimbursementSAPInfoSoap> soapModels = new ArrayList<BtReimbursementSAPInfoSoap>(models.size());

		for (BtReimbursementSAPInfo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BtReimbursementSAPInfoSoap[soapModels.size()]);
	}

	public BtReimbursementSAPInfoSoap() {
	}

	public long getPrimaryKey() {
		return _btReimbursementSAPInfoId;
	}

	public void setPrimaryKey(long pk) {
		setBtReimbursementSAPInfoId(pk);
	}

	public long getBtReimbursementSAPInfoId() {
		return _btReimbursementSAPInfoId;
	}

	public void setBtReimbursementSAPInfoId(long btReimbursementSAPInfoId) {
		_btReimbursementSAPInfoId = btReimbursementSAPInfoId;
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

	public String getCurrency() {
		return _currency;
	}

	public void setCurrency(String currency) {
		_currency = currency;
	}

	public int getStep() {
		return _step;
	}

	public void setStep(int step) {
		_step = step;
	}

	public String getMessageType() {
		return _messageType;
	}

	public void setMessageType(String messageType) {
		_messageType = messageType;
	}

	public String getMessage() {
		return _message;
	}

	public void setMessage(String message) {
		_message = message;
	}

	public String getCertificateNo() {
		return _certificateNo;
	}

	public void setCertificateNo(String certificateNo) {
		_certificateNo = certificateNo;
	}

	public String getCompany() {
		return _company;
	}

	public void setCompany(String company) {
		_company = company;
	}

	public String getYear() {
		return _year;
	}

	public void setYear(String year) {
		_year = year;
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

	private long _btReimbursementSAPInfoId;
	private long _businessTripPkId;
	private String _ticketNo;
	private String _currency;
	private int _step;
	private String _messageType;
	private String _message;
	private String _certificateNo;
	private String _company;
	private String _year;
	private Date _createDate;
	private Date _modifiedDate;
}