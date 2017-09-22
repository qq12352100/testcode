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

package com.seatoffice.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.seatoffice.service.http.SeatOfficeServiceSoap}.
 *
 * @author Alice.zou
 * @see com.seatoffice.service.http.SeatOfficeServiceSoap
 * @generated
 */
public class SeatOfficeSoap implements Serializable {
	public static SeatOfficeSoap toSoapModel(SeatOffice model) {
		SeatOfficeSoap soapModel = new SeatOfficeSoap();

		soapModel.setSeatId(model.getSeatId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setTicketNo(model.getTicketNo());
		soapModel.setStaffName(model.getStaffName());
		soapModel.setStaffCode(model.getStaffCode());
		soapModel.setCompanyName(model.getCompanyName());
		soapModel.setDivision(model.getDivision());
		soapModel.setDepartment(model.getDepartment());
		soapModel.setCostCenter(model.getCostCenter());
		soapModel.setOfficePhone(model.getOfficePhone());
		soapModel.setMobilePhone(model.getMobilePhone());
		soapModel.setOfficeSite(model.getOfficeSite());
		soapModel.setCurrentCategory(model.getCurrentCategory());
		soapModel.setCurrentSeatNo(model.getCurrentSeatNo());
		soapModel.setMovingDate(model.getMovingDate());
		soapModel.setExpectedSeatNo(model.getExpectedSeatNo());
		soapModel.setReasonForChange(model.getReasonForChange());
		soapModel.setOfficeKey(model.getOfficeKey());
		soapModel.setPlant(model.getPlant());
		soapModel.setTelephoneAndExtNo(model.getTelephoneAndExtNo());
		soapModel.setNamePlate(model.getNamePlate());
		soapModel.setCabinet(model.getCabinet());
		soapModel.setIsOnBehalfOf(model.getIsOnBehalfOf());
		soapModel.setNowCategory(model.getNowCategory());
		soapModel.setNewSeatNo(model.getNewSeatNo());
		soapModel.setWorkspaceId(model.getWorkspaceId());
		soapModel.setSeatStatus(model.getSeatStatus());
		soapModel.setSg(model.getSg());
		soapModel.setLeadingMark(model.getLeadingMark());
		soapModel.setPositionFlag(model.getPositionFlag());
		soapModel.setIsApplicantAgent(model.getIsApplicantAgent());
		soapModel.setIsApproverAgent(model.getIsApproverAgent());
		soapModel.setCandidateName(model.getCandidateName());
		soapModel.setDesiredStartingDate(model.getDesiredStartingDate());
		soapModel.setComments(model.getComments());
		soapModel.setContractType(model.getContractType());
		soapModel.setProcessType(model.getProcessType());
		soapModel.setSubProcessType(model.getSubProcessType());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());

		return soapModel;
	}

	public static SeatOfficeSoap[] toSoapModels(SeatOffice[] models) {
		SeatOfficeSoap[] soapModels = new SeatOfficeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SeatOfficeSoap[][] toSoapModels(SeatOffice[][] models) {
		SeatOfficeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SeatOfficeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SeatOfficeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SeatOfficeSoap[] toSoapModels(List<SeatOffice> models) {
		List<SeatOfficeSoap> soapModels = new ArrayList<SeatOfficeSoap>(models.size());

		for (SeatOffice model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SeatOfficeSoap[soapModels.size()]);
	}

	public SeatOfficeSoap() {
	}

	public long getPrimaryKey() {
		return _seatId;
	}

	public void setPrimaryKey(long pk) {
		setSeatId(pk);
	}

	public long getSeatId() {
		return _seatId;
	}

	public void setSeatId(long seatId) {
		_seatId = seatId;
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

	public long getStaffCode() {
		return _staffCode;
	}

	public void setStaffCode(long staffCode) {
		_staffCode = staffCode;
	}

	public String getCompanyName() {
		return _companyName;
	}

	public void setCompanyName(String companyName) {
		_companyName = companyName;
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

	public String getOfficeSite() {
		return _officeSite;
	}

	public void setOfficeSite(String officeSite) {
		_officeSite = officeSite;
	}

	public long getCurrentCategory() {
		return _currentCategory;
	}

	public void setCurrentCategory(long currentCategory) {
		_currentCategory = currentCategory;
	}

	public String getCurrentSeatNo() {
		return _currentSeatNo;
	}

	public void setCurrentSeatNo(String currentSeatNo) {
		_currentSeatNo = currentSeatNo;
	}

	public Date getMovingDate() {
		return _movingDate;
	}

	public void setMovingDate(Date movingDate) {
		_movingDate = movingDate;
	}

	public String getExpectedSeatNo() {
		return _expectedSeatNo;
	}

	public void setExpectedSeatNo(String expectedSeatNo) {
		_expectedSeatNo = expectedSeatNo;
	}

	public String getReasonForChange() {
		return _reasonForChange;
	}

	public void setReasonForChange(String reasonForChange) {
		_reasonForChange = reasonForChange;
	}

	public boolean getOfficeKey() {
		return _officeKey;
	}

	public boolean isOfficeKey() {
		return _officeKey;
	}

	public void setOfficeKey(boolean officeKey) {
		_officeKey = officeKey;
	}

	public boolean getPlant() {
		return _plant;
	}

	public boolean isPlant() {
		return _plant;
	}

	public void setPlant(boolean plant) {
		_plant = plant;
	}

	public boolean getTelephoneAndExtNo() {
		return _telephoneAndExtNo;
	}

	public boolean isTelephoneAndExtNo() {
		return _telephoneAndExtNo;
	}

	public void setTelephoneAndExtNo(boolean telephoneAndExtNo) {
		_telephoneAndExtNo = telephoneAndExtNo;
	}

	public boolean getNamePlate() {
		return _namePlate;
	}

	public boolean isNamePlate() {
		return _namePlate;
	}

	public void setNamePlate(boolean namePlate) {
		_namePlate = namePlate;
	}

	public boolean getCabinet() {
		return _cabinet;
	}

	public boolean isCabinet() {
		return _cabinet;
	}

	public void setCabinet(boolean cabinet) {
		_cabinet = cabinet;
	}

	public boolean getIsOnBehalfOf() {
		return _isOnBehalfOf;
	}

	public boolean isIsOnBehalfOf() {
		return _isOnBehalfOf;
	}

	public void setIsOnBehalfOf(boolean isOnBehalfOf) {
		_isOnBehalfOf = isOnBehalfOf;
	}

	public long getNowCategory() {
		return _nowCategory;
	}

	public void setNowCategory(long nowCategory) {
		_nowCategory = nowCategory;
	}

	public String getNewSeatNo() {
		return _newSeatNo;
	}

	public void setNewSeatNo(String newSeatNo) {
		_newSeatNo = newSeatNo;
	}

	public long getWorkspaceId() {
		return _workspaceId;
	}

	public void setWorkspaceId(long workspaceId) {
		_workspaceId = workspaceId;
	}

	public String getSeatStatus() {
		return _seatStatus;
	}

	public void setSeatStatus(String seatStatus) {
		_seatStatus = seatStatus;
	}

	public String getSg() {
		return _sg;
	}

	public void setSg(String sg) {
		_sg = sg;
	}

	public String getLeadingMark() {
		return _leadingMark;
	}

	public void setLeadingMark(String leadingMark) {
		_leadingMark = leadingMark;
	}

	public String getPositionFlag() {
		return _positionFlag;
	}

	public void setPositionFlag(String positionFlag) {
		_positionFlag = positionFlag;
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

	public String getCandidateName() {
		return _candidateName;
	}

	public void setCandidateName(String candidateName) {
		_candidateName = candidateName;
	}

	public Date getDesiredStartingDate() {
		return _desiredStartingDate;
	}

	public void setDesiredStartingDate(Date desiredStartingDate) {
		_desiredStartingDate = desiredStartingDate;
	}

	public String getComments() {
		return _comments;
	}

	public void setComments(String comments) {
		_comments = comments;
	}

	public String getContractType() {
		return _contractType;
	}

	public void setContractType(String contractType) {
		_contractType = contractType;
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

	private long _seatId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _companyId;
	private String _ticketNo;
	private String _staffName;
	private long _staffCode;
	private String _companyName;
	private String _division;
	private String _department;
	private String _costCenter;
	private String _officePhone;
	private String _mobilePhone;
	private String _officeSite;
	private long _currentCategory;
	private String _currentSeatNo;
	private Date _movingDate;
	private String _expectedSeatNo;
	private String _reasonForChange;
	private boolean _officeKey;
	private boolean _plant;
	private boolean _telephoneAndExtNo;
	private boolean _namePlate;
	private boolean _cabinet;
	private boolean _isOnBehalfOf;
	private long _nowCategory;
	private String _newSeatNo;
	private long _workspaceId;
	private String _seatStatus;
	private String _sg;
	private String _leadingMark;
	private String _positionFlag;
	private boolean _isApplicantAgent;
	private boolean _isApproverAgent;
	private String _candidateName;
	private Date _desiredStartingDate;
	private String _comments;
	private String _contractType;
	private String _processType;
	private String _subProcessType;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
}