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

package com.e.leave.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.e.leave.service.http.ELeaveInfoServiceSoap}.
 *
 * @author EZEYIFE
 * @see com.e.leave.service.http.ELeaveInfoServiceSoap
 * @generated
 */
public class ELeaveInfoSoap implements Serializable {
	public static ELeaveInfoSoap toSoapModel(ELeaveInfo model) {
		ELeaveInfoSoap soapModel = new ELeaveInfoSoap();

		soapModel.setELeaveInfoId(model.getELeaveInfoId());
		soapModel.setELeaveId(model.getELeaveId());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setStartTime(model.getStartTime());
		soapModel.setEndTime(model.getEndTime());
		soapModel.setTypeOfLeave(model.getTypeOfLeave());
		soapModel.setTypeOfLeaveId(model.getTypeOfLeaveId());
		soapModel.setAbsenceDays(model.getAbsenceDays());
		soapModel.setRemark(model.getRemark());

		return soapModel;
	}

	public static ELeaveInfoSoap[] toSoapModels(ELeaveInfo[] models) {
		ELeaveInfoSoap[] soapModels = new ELeaveInfoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ELeaveInfoSoap[][] toSoapModels(ELeaveInfo[][] models) {
		ELeaveInfoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ELeaveInfoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ELeaveInfoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ELeaveInfoSoap[] toSoapModels(List<ELeaveInfo> models) {
		List<ELeaveInfoSoap> soapModels = new ArrayList<ELeaveInfoSoap>(models.size());

		for (ELeaveInfo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ELeaveInfoSoap[soapModels.size()]);
	}

	public ELeaveInfoSoap() {
	}

	public long getPrimaryKey() {
		return _eLeaveInfoId;
	}

	public void setPrimaryKey(long pk) {
		setELeaveInfoId(pk);
	}

	public long getELeaveInfoId() {
		return _eLeaveInfoId;
	}

	public void setELeaveInfoId(long eLeaveInfoId) {
		_eLeaveInfoId = eLeaveInfoId;
	}

	public long getELeaveId() {
		return _eLeaveId;
	}

	public void setELeaveId(long eLeaveId) {
		_eLeaveId = eLeaveId;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public String getStartTime() {
		return _startTime;
	}

	public void setStartTime(String startTime) {
		_startTime = startTime;
	}

	public String getEndTime() {
		return _endTime;
	}

	public void setEndTime(String endTime) {
		_endTime = endTime;
	}

	public String getTypeOfLeave() {
		return _typeOfLeave;
	}

	public void setTypeOfLeave(String typeOfLeave) {
		_typeOfLeave = typeOfLeave;
	}

	public String getTypeOfLeaveId() {
		return _typeOfLeaveId;
	}

	public void setTypeOfLeaveId(String typeOfLeaveId) {
		_typeOfLeaveId = typeOfLeaveId;
	}

	public String getAbsenceDays() {
		return _absenceDays;
	}

	public void setAbsenceDays(String absenceDays) {
		_absenceDays = absenceDays;
	}

	public String getRemark() {
		return _remark;
	}

	public void setRemark(String remark) {
		_remark = remark;
	}

	private long _eLeaveInfoId;
	private long _eLeaveId;
	private Date _startDate;
	private Date _endDate;
	private String _startTime;
	private String _endTime;
	private String _typeOfLeave;
	private String _typeOfLeaveId;
	private String _absenceDays;
	private String _remark;
}