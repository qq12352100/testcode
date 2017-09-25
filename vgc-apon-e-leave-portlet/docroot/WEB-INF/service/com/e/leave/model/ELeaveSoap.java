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
 * This class is used by SOAP remote services, specifically {@link com.e.leave.service.http.ELeaveServiceSoap}.
 *
 * @author EZEYIFE
 * @see com.e.leave.service.http.ELeaveServiceSoap
 * @generated
 */
public class ELeaveSoap implements Serializable {
	public static ELeaveSoap toSoapModel(ELeave model) {
		ELeaveSoap soapModel = new ELeaveSoap();

		soapModel.setELeaveId(model.getELeaveId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setTicketNo(model.getTicketNo());
		soapModel.setStaffName(model.getStaffName());
		soapModel.setStaffCode(model.getStaffCode());
		soapModel.setCompany(model.getCompany());
		soapModel.setDivision(model.getDivision());
		soapModel.setDepartment(model.getDepartment());
		soapModel.setCostCenter(model.getCostCenter());
		soapModel.setOfficePhone(model.getOfficePhone());
		soapModel.setMobilePhone(model.getMobilePhone());
		soapModel.setEmail(model.getEmail());
		soapModel.setPositionType(model.getPositionType());
		soapModel.setIsApplicantAgent(model.getIsApplicantAgent());
		soapModel.setIsApproverAgent(model.getIsApproverAgent());
		soapModel.setProcessType(model.getProcessType());
		soapModel.setSubProcessType(model.getSubProcessType());
		soapModel.setSubmittedDate(model.getSubmittedDate());
		soapModel.setComments(model.getComments());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());
		soapModel.setTotalLeaveEntitlement(model.getTotalLeaveEntitlement());
		soapModel.setTotalDuration(model.getTotalDuration());
		soapModel.setRemainingLeaveDaysBefore(model.getRemainingLeaveDaysBefore());
		soapModel.setRemainingLeaveDaysAfter(model.getRemainingLeaveDaysAfter());

		return soapModel;
	}

	public static ELeaveSoap[] toSoapModels(ELeave[] models) {
		ELeaveSoap[] soapModels = new ELeaveSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ELeaveSoap[][] toSoapModels(ELeave[][] models) {
		ELeaveSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ELeaveSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ELeaveSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ELeaveSoap[] toSoapModels(List<ELeave> models) {
		List<ELeaveSoap> soapModels = new ArrayList<ELeaveSoap>(models.size());

		for (ELeave model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ELeaveSoap[soapModels.size()]);
	}

	public ELeaveSoap() {
	}

	public long getPrimaryKey() {
		return _eLeaveId;
	}

	public void setPrimaryKey(long pk) {
		setELeaveId(pk);
	}

	public long getELeaveId() {
		return _eLeaveId;
	}

	public void setELeaveId(long eLeaveId) {
		_eLeaveId = eLeaveId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
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

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public String getTicketNo() {
		return _ticketNo;
	}

	public void setTicketNo(String ticketNo) {
		_ticketNo = ticketNo;
	}

	public String getStaffName() {
		return _staffName;
	}

	public void setStaffName(String staffName) {
		_staffName = staffName;
	}

	public String getStaffCode() {
		return _staffCode;
	}

	public void setStaffCode(String staffCode) {
		_staffCode = staffCode;
	}

	public String getCompany() {
		return _company;
	}

	public void setCompany(String company) {
		_company = company;
	}

	public String getDivision() {
		return _division;
	}

	public void setDivision(String division) {
		_division = division;
	}

	public String getDepartment() {
		return _department;
	}

	public void setDepartment(String department) {
		_department = department;
	}

	public String getCostCenter() {
		return _costCenter;
	}

	public void setCostCenter(String costCenter) {
		_costCenter = costCenter;
	}

	public String getOfficePhone() {
		return _officePhone;
	}

	public void setOfficePhone(String officePhone) {
		_officePhone = officePhone;
	}

	public String getMobilePhone() {
		return _mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		_mobilePhone = mobilePhone;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getPositionType() {
		return _positionType;
	}

	public void setPositionType(String positionType) {
		_positionType = positionType;
	}

	public boolean getIsApplicantAgent() {
		return _isApplicantAgent;
	}

	public boolean isIsApplicantAgent() {
		return _isApplicantAgent;
	}

	public void setIsApplicantAgent(boolean isApplicantAgent) {
		_isApplicantAgent = isApplicantAgent;
	}

	public boolean getIsApproverAgent() {
		return _isApproverAgent;
	}

	public boolean isIsApproverAgent() {
		return _isApproverAgent;
	}

	public void setIsApproverAgent(boolean isApproverAgent) {
		_isApproverAgent = isApproverAgent;
	}

	public String getProcessType() {
		return _processType;
	}

	public void setProcessType(String processType) {
		_processType = processType;
	}

	public String getSubProcessType() {
		return _subProcessType;
	}

	public void setSubProcessType(String subProcessType) {
		_subProcessType = subProcessType;
	}

	public Date getSubmittedDate() {
		return _submittedDate;
	}

	public void setSubmittedDate(Date submittedDate) {
		_submittedDate = submittedDate;
	}

	public String getComments() {
		return _comments;
	}

	public void setComments(String comments) {
		_comments = comments;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserName() {
		return _statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	public String getTotalLeaveEntitlement() {
		return _totalLeaveEntitlement;
	}

	public void setTotalLeaveEntitlement(String totalLeaveEntitlement) {
		_totalLeaveEntitlement = totalLeaveEntitlement;
	}

	public String getTotalDuration() {
		return _totalDuration;
	}

	public void setTotalDuration(String totalDuration) {
		_totalDuration = totalDuration;
	}

	public String getRemainingLeaveDaysBefore() {
		return _remainingLeaveDaysBefore;
	}

	public void setRemainingLeaveDaysBefore(String remainingLeaveDaysBefore) {
		_remainingLeaveDaysBefore = remainingLeaveDaysBefore;
	}

	public String getRemainingLeaveDaysAfter() {
		return _remainingLeaveDaysAfter;
	}

	public void setRemainingLeaveDaysAfter(String remainingLeaveDaysAfter) {
		_remainingLeaveDaysAfter = remainingLeaveDaysAfter;
	}

	private long _eLeaveId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _companyId;
	private String _ticketNo;
	private String _staffName;
	private String _staffCode;
	private String _company;
	private String _division;
	private String _department;
	private String _costCenter;
	private String _officePhone;
	private String _mobilePhone;
	private String _email;
	private String _positionType;
	private boolean _isApplicantAgent;
	private boolean _isApproverAgent;
	private String _processType;
	private String _subProcessType;
	private Date _submittedDate;
	private String _comments;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private String _totalLeaveEntitlement;
	private String _totalDuration;
	private String _remainingLeaveDaysBefore;
	private String _remainingLeaveDaysAfter;
}