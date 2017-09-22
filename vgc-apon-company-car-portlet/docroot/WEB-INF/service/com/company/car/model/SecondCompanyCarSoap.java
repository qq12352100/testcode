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

package com.company.car.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.company.car.service.http.SecondCompanyCarServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.company.car.service.http.SecondCompanyCarServiceSoap
 * @generated
 */
public class SecondCompanyCarSoap implements Serializable {
	public static SecondCompanyCarSoap toSoapModel(SecondCompanyCar model) {
		SecondCompanyCarSoap soapModel = new SecondCompanyCarSoap();

		soapModel.setSecondCompanyCarId(model.getSecondCompanyCarId());
		soapModel.setTicketNo(model.getTicketNo());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setSubmittedDate(model.getSubmittedDate());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setName(model.getName());
		soapModel.setStaffCode(model.getStaffCode());
		soapModel.setDivision(model.getDivision());
		soapModel.setDepartment(model.getDepartment());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setCompanyName(model.getCompanyName());
		soapModel.setStatusDate(model.getStatusDate());
		soapModel.setContactNo(model.getContactNo());
		soapModel.setWorkingLocation(model.getWorkingLocation());
		soapModel.setOfficeSite(model.getOfficeSite());
		soapModel.setCurrentCarModel(model.getCurrentCarModel());
		soapModel.setCurrentCarColor(model.getCurrentCarColor());
		soapModel.setCurrentPlateNumber(model.getCurrentPlateNumber());
		soapModel.setAcquiringDate(model.getAcquiringDate());
		soapModel.setExpectedCarModel(model.getExpectedCarModel());
		soapModel.setExpectedCarColor(model.getExpectedCarColor());
		soapModel.setExpectedLastPlateNumber(model.getExpectedLastPlateNumber());
		soapModel.setPositionCostCenterId(model.getPositionCostCenterId());
		soapModel.setEmployeeGroupId(model.getEmployeeGroupId());
		soapModel.setContractEndDate(model.getContractEndDate());
		soapModel.setMobilePhone(model.getMobilePhone());
		soapModel.setOfficePhone(model.getOfficePhone());
		soapModel.setEmail(model.getEmail());
		soapModel.setIsApplicantAgent(model.getIsApplicantAgent());
		soapModel.setIsApproverAgent(model.getIsApproverAgent());
		soapModel.setDrivingLicenseInformation(model.getDrivingLicenseInformation());
		soapModel.setEstimatedObtainingDate(model.getEstimatedObtainingDate());
		soapModel.setComments(model.getComments());
		soapModel.setProcessType(model.getProcessType());
		soapModel.setSubType(model.getSubType());

		return soapModel;
	}

	public static SecondCompanyCarSoap[] toSoapModels(SecondCompanyCar[] models) {
		SecondCompanyCarSoap[] soapModels = new SecondCompanyCarSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SecondCompanyCarSoap[][] toSoapModels(
		SecondCompanyCar[][] models) {
		SecondCompanyCarSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SecondCompanyCarSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SecondCompanyCarSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SecondCompanyCarSoap[] toSoapModels(
		List<SecondCompanyCar> models) {
		List<SecondCompanyCarSoap> soapModels = new ArrayList<SecondCompanyCarSoap>(models.size());

		for (SecondCompanyCar model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SecondCompanyCarSoap[soapModels.size()]);
	}

	public SecondCompanyCarSoap() {
	}

	public long getPrimaryKey() {
		return _secondCompanyCarId;
	}

	public void setPrimaryKey(long pk) {
		setSecondCompanyCarId(pk);
	}

	public long getSecondCompanyCarId() {
		return _secondCompanyCarId;
	}

	public void setSecondCompanyCarId(long secondCompanyCarId) {
		_secondCompanyCarId = secondCompanyCarId;
	}

	public String getTicketNo() {
		return _ticketNo;
	}

	public void setTicketNo(String ticketNo) {
		_ticketNo = ticketNo;
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

	public Date getSubmittedDate() {
		return _submittedDate;
	}

	public void setSubmittedDate(Date submittedDate) {
		_submittedDate = submittedDate;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public long getStaffCode() {
		return _staffCode;
	}

	public void setStaffCode(long staffCode) {
		_staffCode = staffCode;
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

	public String getCompanyName() {
		return _companyName;
	}

	public void setCompanyName(String companyName) {
		_companyName = companyName;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	public String getContactNo() {
		return _contactNo;
	}

	public void setContactNo(String contactNo) {
		_contactNo = contactNo;
	}

	public String getWorkingLocation() {
		return _workingLocation;
	}

	public void setWorkingLocation(String workingLocation) {
		_workingLocation = workingLocation;
	}

	public String getOfficeSite() {
		return _officeSite;
	}

	public void setOfficeSite(String officeSite) {
		_officeSite = officeSite;
	}

	public String getCurrentCarModel() {
		return _currentCarModel;
	}

	public void setCurrentCarModel(String currentCarModel) {
		_currentCarModel = currentCarModel;
	}

	public String getCurrentCarColor() {
		return _currentCarColor;
	}

	public void setCurrentCarColor(String currentCarColor) {
		_currentCarColor = currentCarColor;
	}

	public String getCurrentPlateNumber() {
		return _currentPlateNumber;
	}

	public void setCurrentPlateNumber(String currentPlateNumber) {
		_currentPlateNumber = currentPlateNumber;
	}

	public Date getAcquiringDate() {
		return _acquiringDate;
	}

	public void setAcquiringDate(Date acquiringDate) {
		_acquiringDate = acquiringDate;
	}

	public String getExpectedCarModel() {
		return _expectedCarModel;
	}

	public void setExpectedCarModel(String expectedCarModel) {
		_expectedCarModel = expectedCarModel;
	}

	public String getExpectedCarColor() {
		return _expectedCarColor;
	}

	public void setExpectedCarColor(String expectedCarColor) {
		_expectedCarColor = expectedCarColor;
	}

	public String getExpectedLastPlateNumber() {
		return _expectedLastPlateNumber;
	}

	public void setExpectedLastPlateNumber(String expectedLastPlateNumber) {
		_expectedLastPlateNumber = expectedLastPlateNumber;
	}

	public String getPositionCostCenterId() {
		return _positionCostCenterId;
	}

	public void setPositionCostCenterId(String positionCostCenterId) {
		_positionCostCenterId = positionCostCenterId;
	}

	public String getEmployeeGroupId() {
		return _employeeGroupId;
	}

	public void setEmployeeGroupId(String employeeGroupId) {
		_employeeGroupId = employeeGroupId;
	}

	public Date getContractEndDate() {
		return _contractEndDate;
	}

	public void setContractEndDate(Date contractEndDate) {
		_contractEndDate = contractEndDate;
	}

	public String getMobilePhone() {
		return _mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		_mobilePhone = mobilePhone;
	}

	public String getOfficePhone() {
		return _officePhone;
	}

	public void setOfficePhone(String officePhone) {
		_officePhone = officePhone;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
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

	public int getDrivingLicenseInformation() {
		return _drivingLicenseInformation;
	}

	public void setDrivingLicenseInformation(int drivingLicenseInformation) {
		_drivingLicenseInformation = drivingLicenseInformation;
	}

	public Date getEstimatedObtainingDate() {
		return _estimatedObtainingDate;
	}

	public void setEstimatedObtainingDate(Date estimatedObtainingDate) {
		_estimatedObtainingDate = estimatedObtainingDate;
	}

	public String getComments() {
		return _comments;
	}

	public void setComments(String comments) {
		_comments = comments;
	}

	public String getProcessType() {
		return _processType;
	}

	public void setProcessType(String processType) {
		_processType = processType;
	}

	public String getSubType() {
		return _subType;
	}

	public void setSubType(String subType) {
		_subType = subType;
	}

	private long _secondCompanyCarId;
	private String _ticketNo;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _submittedDate;
	private long _companyId;
	private String _name;
	private long _staffCode;
	private String _division;
	private String _department;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private String _companyName;
	private Date _statusDate;
	private String _contactNo;
	private String _workingLocation;
	private String _officeSite;
	private String _currentCarModel;
	private String _currentCarColor;
	private String _currentPlateNumber;
	private Date _acquiringDate;
	private String _expectedCarModel;
	private String _expectedCarColor;
	private String _expectedLastPlateNumber;
	private String _positionCostCenterId;
	private String _employeeGroupId;
	private Date _contractEndDate;
	private String _mobilePhone;
	private String _officePhone;
	private String _email;
	private boolean _isApplicantAgent;
	private boolean _isApproverAgent;
	private int _drivingLicenseInformation;
	private Date _estimatedObtainingDate;
	private String _comments;
	private String _processType;
	private String _subType;
}