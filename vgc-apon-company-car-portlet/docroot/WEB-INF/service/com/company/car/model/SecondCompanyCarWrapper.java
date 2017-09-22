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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SecondCompanyCar}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SecondCompanyCar
 * @generated
 */
public class SecondCompanyCarWrapper implements SecondCompanyCar,
	ModelWrapper<SecondCompanyCar> {
	public SecondCompanyCarWrapper(SecondCompanyCar secondCompanyCar) {
		_secondCompanyCar = secondCompanyCar;
	}

	@Override
	public Class<?> getModelClass() {
		return SecondCompanyCar.class;
	}

	@Override
	public String getModelClassName() {
		return SecondCompanyCar.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("secondCompanyCarId", getSecondCompanyCarId());
		attributes.put("ticketNo", getTicketNo());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("submittedDate", getSubmittedDate());
		attributes.put("companyId", getCompanyId());
		attributes.put("name", getName());
		attributes.put("staffCode", getStaffCode());
		attributes.put("division", getDivision());
		attributes.put("department", getDepartment());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("companyName", getCompanyName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("contactNo", getContactNo());
		attributes.put("workingLocation", getWorkingLocation());
		attributes.put("officeSite", getOfficeSite());
		attributes.put("currentCarModel", getCurrentCarModel());
		attributes.put("currentCarColor", getCurrentCarColor());
		attributes.put("currentPlateNumber", getCurrentPlateNumber());
		attributes.put("acquiringDate", getAcquiringDate());
		attributes.put("expectedCarModel", getExpectedCarModel());
		attributes.put("expectedCarColor", getExpectedCarColor());
		attributes.put("expectedLastPlateNumber", getExpectedLastPlateNumber());
		attributes.put("positionCostCenterId", getPositionCostCenterId());
		attributes.put("employeeGroupId", getEmployeeGroupId());
		attributes.put("contractEndDate", getContractEndDate());
		attributes.put("mobilePhone", getMobilePhone());
		attributes.put("officePhone", getOfficePhone());
		attributes.put("email", getEmail());
		attributes.put("isApplicantAgent", getIsApplicantAgent());
		attributes.put("isApproverAgent", getIsApproverAgent());
		attributes.put("drivingLicenseInformation",
			getDrivingLicenseInformation());
		attributes.put("estimatedObtainingDate", getEstimatedObtainingDate());
		attributes.put("comments", getComments());
		attributes.put("processType", getProcessType());
		attributes.put("subType", getSubType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long secondCompanyCarId = (Long)attributes.get("secondCompanyCarId");

		if (secondCompanyCarId != null) {
			setSecondCompanyCarId(secondCompanyCarId);
		}

		String ticketNo = (String)attributes.get("ticketNo");

		if (ticketNo != null) {
			setTicketNo(ticketNo);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Date submittedDate = (Date)attributes.get("submittedDate");

		if (submittedDate != null) {
			setSubmittedDate(submittedDate);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long staffCode = (Long)attributes.get("staffCode");

		if (staffCode != null) {
			setStaffCode(staffCode);
		}

		String division = (String)attributes.get("division");

		if (division != null) {
			setDivision(division);
		}

		String department = (String)attributes.get("department");

		if (department != null) {
			setDepartment(department);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		String companyName = (String)attributes.get("companyName");

		if (companyName != null) {
			setCompanyName(companyName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		String contactNo = (String)attributes.get("contactNo");

		if (contactNo != null) {
			setContactNo(contactNo);
		}

		String workingLocation = (String)attributes.get("workingLocation");

		if (workingLocation != null) {
			setWorkingLocation(workingLocation);
		}

		String officeSite = (String)attributes.get("officeSite");

		if (officeSite != null) {
			setOfficeSite(officeSite);
		}

		String currentCarModel = (String)attributes.get("currentCarModel");

		if (currentCarModel != null) {
			setCurrentCarModel(currentCarModel);
		}

		String currentCarColor = (String)attributes.get("currentCarColor");

		if (currentCarColor != null) {
			setCurrentCarColor(currentCarColor);
		}

		String currentPlateNumber = (String)attributes.get("currentPlateNumber");

		if (currentPlateNumber != null) {
			setCurrentPlateNumber(currentPlateNumber);
		}

		Date acquiringDate = (Date)attributes.get("acquiringDate");

		if (acquiringDate != null) {
			setAcquiringDate(acquiringDate);
		}

		String expectedCarModel = (String)attributes.get("expectedCarModel");

		if (expectedCarModel != null) {
			setExpectedCarModel(expectedCarModel);
		}

		String expectedCarColor = (String)attributes.get("expectedCarColor");

		if (expectedCarColor != null) {
			setExpectedCarColor(expectedCarColor);
		}

		String expectedLastPlateNumber = (String)attributes.get(
				"expectedLastPlateNumber");

		if (expectedLastPlateNumber != null) {
			setExpectedLastPlateNumber(expectedLastPlateNumber);
		}

		String positionCostCenterId = (String)attributes.get(
				"positionCostCenterId");

		if (positionCostCenterId != null) {
			setPositionCostCenterId(positionCostCenterId);
		}

		String employeeGroupId = (String)attributes.get("employeeGroupId");

		if (employeeGroupId != null) {
			setEmployeeGroupId(employeeGroupId);
		}

		Date contractEndDate = (Date)attributes.get("contractEndDate");

		if (contractEndDate != null) {
			setContractEndDate(contractEndDate);
		}

		String mobilePhone = (String)attributes.get("mobilePhone");

		if (mobilePhone != null) {
			setMobilePhone(mobilePhone);
		}

		String officePhone = (String)attributes.get("officePhone");

		if (officePhone != null) {
			setOfficePhone(officePhone);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		Boolean isApplicantAgent = (Boolean)attributes.get("isApplicantAgent");

		if (isApplicantAgent != null) {
			setIsApplicantAgent(isApplicantAgent);
		}

		Boolean isApproverAgent = (Boolean)attributes.get("isApproverAgent");

		if (isApproverAgent != null) {
			setIsApproverAgent(isApproverAgent);
		}

		Integer drivingLicenseInformation = (Integer)attributes.get(
				"drivingLicenseInformation");

		if (drivingLicenseInformation != null) {
			setDrivingLicenseInformation(drivingLicenseInformation);
		}

		Date estimatedObtainingDate = (Date)attributes.get(
				"estimatedObtainingDate");

		if (estimatedObtainingDate != null) {
			setEstimatedObtainingDate(estimatedObtainingDate);
		}

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
		}

		String processType = (String)attributes.get("processType");

		if (processType != null) {
			setProcessType(processType);
		}

		String subType = (String)attributes.get("subType");

		if (subType != null) {
			setSubType(subType);
		}
	}

	/**
	* Returns the primary key of this second company car.
	*
	* @return the primary key of this second company car
	*/
	@Override
	public long getPrimaryKey() {
		return _secondCompanyCar.getPrimaryKey();
	}

	/**
	* Sets the primary key of this second company car.
	*
	* @param primaryKey the primary key of this second company car
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_secondCompanyCar.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the second company car ID of this second company car.
	*
	* @return the second company car ID of this second company car
	*/
	@Override
	public long getSecondCompanyCarId() {
		return _secondCompanyCar.getSecondCompanyCarId();
	}

	/**
	* Sets the second company car ID of this second company car.
	*
	* @param secondCompanyCarId the second company car ID of this second company car
	*/
	@Override
	public void setSecondCompanyCarId(long secondCompanyCarId) {
		_secondCompanyCar.setSecondCompanyCarId(secondCompanyCarId);
	}

	/**
	* Returns the ticket no of this second company car.
	*
	* @return the ticket no of this second company car
	*/
	@Override
	public java.lang.String getTicketNo() {
		return _secondCompanyCar.getTicketNo();
	}

	/**
	* Sets the ticket no of this second company car.
	*
	* @param ticketNo the ticket no of this second company car
	*/
	@Override
	public void setTicketNo(java.lang.String ticketNo) {
		_secondCompanyCar.setTicketNo(ticketNo);
	}

	/**
	* Returns the group ID of this second company car.
	*
	* @return the group ID of this second company car
	*/
	@Override
	public long getGroupId() {
		return _secondCompanyCar.getGroupId();
	}

	/**
	* Sets the group ID of this second company car.
	*
	* @param groupId the group ID of this second company car
	*/
	@Override
	public void setGroupId(long groupId) {
		_secondCompanyCar.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this second company car.
	*
	* @return the user ID of this second company car
	*/
	@Override
	public long getUserId() {
		return _secondCompanyCar.getUserId();
	}

	/**
	* Sets the user ID of this second company car.
	*
	* @param userId the user ID of this second company car
	*/
	@Override
	public void setUserId(long userId) {
		_secondCompanyCar.setUserId(userId);
	}

	/**
	* Returns the user uuid of this second company car.
	*
	* @return the user uuid of this second company car
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _secondCompanyCar.getUserUuid();
	}

	/**
	* Sets the user uuid of this second company car.
	*
	* @param userUuid the user uuid of this second company car
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_secondCompanyCar.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this second company car.
	*
	* @return the user name of this second company car
	*/
	@Override
	public java.lang.String getUserName() {
		return _secondCompanyCar.getUserName();
	}

	/**
	* Sets the user name of this second company car.
	*
	* @param userName the user name of this second company car
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_secondCompanyCar.setUserName(userName);
	}

	/**
	* Returns the create date of this second company car.
	*
	* @return the create date of this second company car
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _secondCompanyCar.getCreateDate();
	}

	/**
	* Sets the create date of this second company car.
	*
	* @param createDate the create date of this second company car
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_secondCompanyCar.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this second company car.
	*
	* @return the modified date of this second company car
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _secondCompanyCar.getModifiedDate();
	}

	/**
	* Sets the modified date of this second company car.
	*
	* @param modifiedDate the modified date of this second company car
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_secondCompanyCar.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the submitted date of this second company car.
	*
	* @return the submitted date of this second company car
	*/
	@Override
	public java.util.Date getSubmittedDate() {
		return _secondCompanyCar.getSubmittedDate();
	}

	/**
	* Sets the submitted date of this second company car.
	*
	* @param submittedDate the submitted date of this second company car
	*/
	@Override
	public void setSubmittedDate(java.util.Date submittedDate) {
		_secondCompanyCar.setSubmittedDate(submittedDate);
	}

	/**
	* Returns the company ID of this second company car.
	*
	* @return the company ID of this second company car
	*/
	@Override
	public long getCompanyId() {
		return _secondCompanyCar.getCompanyId();
	}

	/**
	* Sets the company ID of this second company car.
	*
	* @param companyId the company ID of this second company car
	*/
	@Override
	public void setCompanyId(long companyId) {
		_secondCompanyCar.setCompanyId(companyId);
	}

	/**
	* Returns the name of this second company car.
	*
	* @return the name of this second company car
	*/
	@Override
	public java.lang.String getName() {
		return _secondCompanyCar.getName();
	}

	/**
	* Sets the name of this second company car.
	*
	* @param name the name of this second company car
	*/
	@Override
	public void setName(java.lang.String name) {
		_secondCompanyCar.setName(name);
	}

	/**
	* Returns the staff code of this second company car.
	*
	* @return the staff code of this second company car
	*/
	@Override
	public long getStaffCode() {
		return _secondCompanyCar.getStaffCode();
	}

	/**
	* Sets the staff code of this second company car.
	*
	* @param staffCode the staff code of this second company car
	*/
	@Override
	public void setStaffCode(long staffCode) {
		_secondCompanyCar.setStaffCode(staffCode);
	}

	/**
	* Returns the division of this second company car.
	*
	* @return the division of this second company car
	*/
	@Override
	public java.lang.String getDivision() {
		return _secondCompanyCar.getDivision();
	}

	/**
	* Sets the division of this second company car.
	*
	* @param division the division of this second company car
	*/
	@Override
	public void setDivision(java.lang.String division) {
		_secondCompanyCar.setDivision(division);
	}

	/**
	* Returns the department of this second company car.
	*
	* @return the department of this second company car
	*/
	@Override
	public java.lang.String getDepartment() {
		return _secondCompanyCar.getDepartment();
	}

	/**
	* Sets the department of this second company car.
	*
	* @param department the department of this second company car
	*/
	@Override
	public void setDepartment(java.lang.String department) {
		_secondCompanyCar.setDepartment(department);
	}

	/**
	* Returns the status of this second company car.
	*
	* @return the status of this second company car
	*/
	@Override
	public int getStatus() {
		return _secondCompanyCar.getStatus();
	}

	/**
	* Sets the status of this second company car.
	*
	* @param status the status of this second company car
	*/
	@Override
	public void setStatus(int status) {
		_secondCompanyCar.setStatus(status);
	}

	/**
	* Returns the status by user ID of this second company car.
	*
	* @return the status by user ID of this second company car
	*/
	@Override
	public long getStatusByUserId() {
		return _secondCompanyCar.getStatusByUserId();
	}

	/**
	* Sets the status by user ID of this second company car.
	*
	* @param statusByUserId the status by user ID of this second company car
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_secondCompanyCar.setStatusByUserId(statusByUserId);
	}

	/**
	* Returns the status by user uuid of this second company car.
	*
	* @return the status by user uuid of this second company car
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getStatusByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _secondCompanyCar.getStatusByUserUuid();
	}

	/**
	* Sets the status by user uuid of this second company car.
	*
	* @param statusByUserUuid the status by user uuid of this second company car
	*/
	@Override
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_secondCompanyCar.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Returns the status by user name of this second company car.
	*
	* @return the status by user name of this second company car
	*/
	@Override
	public java.lang.String getStatusByUserName() {
		return _secondCompanyCar.getStatusByUserName();
	}

	/**
	* Sets the status by user name of this second company car.
	*
	* @param statusByUserName the status by user name of this second company car
	*/
	@Override
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_secondCompanyCar.setStatusByUserName(statusByUserName);
	}

	/**
	* Returns the company name of this second company car.
	*
	* @return the company name of this second company car
	*/
	@Override
	public java.lang.String getCompanyName() {
		return _secondCompanyCar.getCompanyName();
	}

	/**
	* Sets the company name of this second company car.
	*
	* @param companyName the company name of this second company car
	*/
	@Override
	public void setCompanyName(java.lang.String companyName) {
		_secondCompanyCar.setCompanyName(companyName);
	}

	/**
	* Returns the status date of this second company car.
	*
	* @return the status date of this second company car
	*/
	@Override
	public java.util.Date getStatusDate() {
		return _secondCompanyCar.getStatusDate();
	}

	/**
	* Sets the status date of this second company car.
	*
	* @param statusDate the status date of this second company car
	*/
	@Override
	public void setStatusDate(java.util.Date statusDate) {
		_secondCompanyCar.setStatusDate(statusDate);
	}

	/**
	* Returns the contact no of this second company car.
	*
	* @return the contact no of this second company car
	*/
	@Override
	public java.lang.String getContactNo() {
		return _secondCompanyCar.getContactNo();
	}

	/**
	* Sets the contact no of this second company car.
	*
	* @param contactNo the contact no of this second company car
	*/
	@Override
	public void setContactNo(java.lang.String contactNo) {
		_secondCompanyCar.setContactNo(contactNo);
	}

	/**
	* Returns the working location of this second company car.
	*
	* @return the working location of this second company car
	*/
	@Override
	public java.lang.String getWorkingLocation() {
		return _secondCompanyCar.getWorkingLocation();
	}

	/**
	* Sets the working location of this second company car.
	*
	* @param workingLocation the working location of this second company car
	*/
	@Override
	public void setWorkingLocation(java.lang.String workingLocation) {
		_secondCompanyCar.setWorkingLocation(workingLocation);
	}

	/**
	* Returns the office site of this second company car.
	*
	* @return the office site of this second company car
	*/
	@Override
	public java.lang.String getOfficeSite() {
		return _secondCompanyCar.getOfficeSite();
	}

	/**
	* Sets the office site of this second company car.
	*
	* @param officeSite the office site of this second company car
	*/
	@Override
	public void setOfficeSite(java.lang.String officeSite) {
		_secondCompanyCar.setOfficeSite(officeSite);
	}

	/**
	* Returns the current car model of this second company car.
	*
	* @return the current car model of this second company car
	*/
	@Override
	public java.lang.String getCurrentCarModel() {
		return _secondCompanyCar.getCurrentCarModel();
	}

	/**
	* Sets the current car model of this second company car.
	*
	* @param currentCarModel the current car model of this second company car
	*/
	@Override
	public void setCurrentCarModel(java.lang.String currentCarModel) {
		_secondCompanyCar.setCurrentCarModel(currentCarModel);
	}

	/**
	* Returns the current car color of this second company car.
	*
	* @return the current car color of this second company car
	*/
	@Override
	public java.lang.String getCurrentCarColor() {
		return _secondCompanyCar.getCurrentCarColor();
	}

	/**
	* Sets the current car color of this second company car.
	*
	* @param currentCarColor the current car color of this second company car
	*/
	@Override
	public void setCurrentCarColor(java.lang.String currentCarColor) {
		_secondCompanyCar.setCurrentCarColor(currentCarColor);
	}

	/**
	* Returns the current plate number of this second company car.
	*
	* @return the current plate number of this second company car
	*/
	@Override
	public java.lang.String getCurrentPlateNumber() {
		return _secondCompanyCar.getCurrentPlateNumber();
	}

	/**
	* Sets the current plate number of this second company car.
	*
	* @param currentPlateNumber the current plate number of this second company car
	*/
	@Override
	public void setCurrentPlateNumber(java.lang.String currentPlateNumber) {
		_secondCompanyCar.setCurrentPlateNumber(currentPlateNumber);
	}

	/**
	* Returns the acquiring date of this second company car.
	*
	* @return the acquiring date of this second company car
	*/
	@Override
	public java.util.Date getAcquiringDate() {
		return _secondCompanyCar.getAcquiringDate();
	}

	/**
	* Sets the acquiring date of this second company car.
	*
	* @param acquiringDate the acquiring date of this second company car
	*/
	@Override
	public void setAcquiringDate(java.util.Date acquiringDate) {
		_secondCompanyCar.setAcquiringDate(acquiringDate);
	}

	/**
	* Returns the expected car model of this second company car.
	*
	* @return the expected car model of this second company car
	*/
	@Override
	public java.lang.String getExpectedCarModel() {
		return _secondCompanyCar.getExpectedCarModel();
	}

	/**
	* Sets the expected car model of this second company car.
	*
	* @param expectedCarModel the expected car model of this second company car
	*/
	@Override
	public void setExpectedCarModel(java.lang.String expectedCarModel) {
		_secondCompanyCar.setExpectedCarModel(expectedCarModel);
	}

	/**
	* Returns the expected car color of this second company car.
	*
	* @return the expected car color of this second company car
	*/
	@Override
	public java.lang.String getExpectedCarColor() {
		return _secondCompanyCar.getExpectedCarColor();
	}

	/**
	* Sets the expected car color of this second company car.
	*
	* @param expectedCarColor the expected car color of this second company car
	*/
	@Override
	public void setExpectedCarColor(java.lang.String expectedCarColor) {
		_secondCompanyCar.setExpectedCarColor(expectedCarColor);
	}

	/**
	* Returns the expected last plate number of this second company car.
	*
	* @return the expected last plate number of this second company car
	*/
	@Override
	public java.lang.String getExpectedLastPlateNumber() {
		return _secondCompanyCar.getExpectedLastPlateNumber();
	}

	/**
	* Sets the expected last plate number of this second company car.
	*
	* @param expectedLastPlateNumber the expected last plate number of this second company car
	*/
	@Override
	public void setExpectedLastPlateNumber(
		java.lang.String expectedLastPlateNumber) {
		_secondCompanyCar.setExpectedLastPlateNumber(expectedLastPlateNumber);
	}

	/**
	* Returns the position cost center ID of this second company car.
	*
	* @return the position cost center ID of this second company car
	*/
	@Override
	public java.lang.String getPositionCostCenterId() {
		return _secondCompanyCar.getPositionCostCenterId();
	}

	/**
	* Sets the position cost center ID of this second company car.
	*
	* @param positionCostCenterId the position cost center ID of this second company car
	*/
	@Override
	public void setPositionCostCenterId(java.lang.String positionCostCenterId) {
		_secondCompanyCar.setPositionCostCenterId(positionCostCenterId);
	}

	/**
	* Returns the employee group ID of this second company car.
	*
	* @return the employee group ID of this second company car
	*/
	@Override
	public java.lang.String getEmployeeGroupId() {
		return _secondCompanyCar.getEmployeeGroupId();
	}

	/**
	* Sets the employee group ID of this second company car.
	*
	* @param employeeGroupId the employee group ID of this second company car
	*/
	@Override
	public void setEmployeeGroupId(java.lang.String employeeGroupId) {
		_secondCompanyCar.setEmployeeGroupId(employeeGroupId);
	}

	/**
	* Returns the contract end date of this second company car.
	*
	* @return the contract end date of this second company car
	*/
	@Override
	public java.util.Date getContractEndDate() {
		return _secondCompanyCar.getContractEndDate();
	}

	/**
	* Sets the contract end date of this second company car.
	*
	* @param contractEndDate the contract end date of this second company car
	*/
	@Override
	public void setContractEndDate(java.util.Date contractEndDate) {
		_secondCompanyCar.setContractEndDate(contractEndDate);
	}

	/**
	* Returns the mobile phone of this second company car.
	*
	* @return the mobile phone of this second company car
	*/
	@Override
	public java.lang.String getMobilePhone() {
		return _secondCompanyCar.getMobilePhone();
	}

	/**
	* Sets the mobile phone of this second company car.
	*
	* @param mobilePhone the mobile phone of this second company car
	*/
	@Override
	public void setMobilePhone(java.lang.String mobilePhone) {
		_secondCompanyCar.setMobilePhone(mobilePhone);
	}

	/**
	* Returns the office phone of this second company car.
	*
	* @return the office phone of this second company car
	*/
	@Override
	public java.lang.String getOfficePhone() {
		return _secondCompanyCar.getOfficePhone();
	}

	/**
	* Sets the office phone of this second company car.
	*
	* @param officePhone the office phone of this second company car
	*/
	@Override
	public void setOfficePhone(java.lang.String officePhone) {
		_secondCompanyCar.setOfficePhone(officePhone);
	}

	/**
	* Returns the email of this second company car.
	*
	* @return the email of this second company car
	*/
	@Override
	public java.lang.String getEmail() {
		return _secondCompanyCar.getEmail();
	}

	/**
	* Sets the email of this second company car.
	*
	* @param email the email of this second company car
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_secondCompanyCar.setEmail(email);
	}

	/**
	* Returns the is applicant agent of this second company car.
	*
	* @return the is applicant agent of this second company car
	*/
	@Override
	public boolean getIsApplicantAgent() {
		return _secondCompanyCar.getIsApplicantAgent();
	}

	/**
	* Returns <code>true</code> if this second company car is is applicant agent.
	*
	* @return <code>true</code> if this second company car is is applicant agent; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsApplicantAgent() {
		return _secondCompanyCar.isIsApplicantAgent();
	}

	/**
	* Sets whether this second company car is is applicant agent.
	*
	* @param isApplicantAgent the is applicant agent of this second company car
	*/
	@Override
	public void setIsApplicantAgent(boolean isApplicantAgent) {
		_secondCompanyCar.setIsApplicantAgent(isApplicantAgent);
	}

	/**
	* Returns the is approver agent of this second company car.
	*
	* @return the is approver agent of this second company car
	*/
	@Override
	public boolean getIsApproverAgent() {
		return _secondCompanyCar.getIsApproverAgent();
	}

	/**
	* Returns <code>true</code> if this second company car is is approver agent.
	*
	* @return <code>true</code> if this second company car is is approver agent; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsApproverAgent() {
		return _secondCompanyCar.isIsApproverAgent();
	}

	/**
	* Sets whether this second company car is is approver agent.
	*
	* @param isApproverAgent the is approver agent of this second company car
	*/
	@Override
	public void setIsApproverAgent(boolean isApproverAgent) {
		_secondCompanyCar.setIsApproverAgent(isApproverAgent);
	}

	/**
	* Returns the driving license information of this second company car.
	*
	* @return the driving license information of this second company car
	*/
	@Override
	public int getDrivingLicenseInformation() {
		return _secondCompanyCar.getDrivingLicenseInformation();
	}

	/**
	* Sets the driving license information of this second company car.
	*
	* @param drivingLicenseInformation the driving license information of this second company car
	*/
	@Override
	public void setDrivingLicenseInformation(int drivingLicenseInformation) {
		_secondCompanyCar.setDrivingLicenseInformation(drivingLicenseInformation);
	}

	/**
	* Returns the estimated obtaining date of this second company car.
	*
	* @return the estimated obtaining date of this second company car
	*/
	@Override
	public java.util.Date getEstimatedObtainingDate() {
		return _secondCompanyCar.getEstimatedObtainingDate();
	}

	/**
	* Sets the estimated obtaining date of this second company car.
	*
	* @param estimatedObtainingDate the estimated obtaining date of this second company car
	*/
	@Override
	public void setEstimatedObtainingDate(java.util.Date estimatedObtainingDate) {
		_secondCompanyCar.setEstimatedObtainingDate(estimatedObtainingDate);
	}

	/**
	* Returns the comments of this second company car.
	*
	* @return the comments of this second company car
	*/
	@Override
	public java.lang.String getComments() {
		return _secondCompanyCar.getComments();
	}

	/**
	* Sets the comments of this second company car.
	*
	* @param comments the comments of this second company car
	*/
	@Override
	public void setComments(java.lang.String comments) {
		_secondCompanyCar.setComments(comments);
	}

	/**
	* Returns the process type of this second company car.
	*
	* @return the process type of this second company car
	*/
	@Override
	public java.lang.String getProcessType() {
		return _secondCompanyCar.getProcessType();
	}

	/**
	* Sets the process type of this second company car.
	*
	* @param processType the process type of this second company car
	*/
	@Override
	public void setProcessType(java.lang.String processType) {
		_secondCompanyCar.setProcessType(processType);
	}

	/**
	* Returns the sub type of this second company car.
	*
	* @return the sub type of this second company car
	*/
	@Override
	public java.lang.String getSubType() {
		return _secondCompanyCar.getSubType();
	}

	/**
	* Sets the sub type of this second company car.
	*
	* @param subType the sub type of this second company car
	*/
	@Override
	public void setSubType(java.lang.String subType) {
		_secondCompanyCar.setSubType(subType);
	}

	/**
	* @deprecated As of 6.1.0, replaced by {@link #isApproved()}
	*/
	@Override
	public boolean getApproved() {
		return _secondCompanyCar.getApproved();
	}

	/**
	* Returns <code>true</code> if this second company car is approved.
	*
	* @return <code>true</code> if this second company car is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _secondCompanyCar.isApproved();
	}

	/**
	* Returns <code>true</code> if this second company car is denied.
	*
	* @return <code>true</code> if this second company car is denied; <code>false</code> otherwise
	*/
	@Override
	public boolean isDenied() {
		return _secondCompanyCar.isDenied();
	}

	/**
	* Returns <code>true</code> if this second company car is a draft.
	*
	* @return <code>true</code> if this second company car is a draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _secondCompanyCar.isDraft();
	}

	/**
	* Returns <code>true</code> if this second company car is expired.
	*
	* @return <code>true</code> if this second company car is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _secondCompanyCar.isExpired();
	}

	/**
	* Returns <code>true</code> if this second company car is inactive.
	*
	* @return <code>true</code> if this second company car is inactive; <code>false</code> otherwise
	*/
	@Override
	public boolean isInactive() {
		return _secondCompanyCar.isInactive();
	}

	/**
	* Returns <code>true</code> if this second company car is incomplete.
	*
	* @return <code>true</code> if this second company car is incomplete; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncomplete() {
		return _secondCompanyCar.isIncomplete();
	}

	/**
	* Returns <code>true</code> if this second company car is pending.
	*
	* @return <code>true</code> if this second company car is pending; <code>false</code> otherwise
	*/
	@Override
	public boolean isPending() {
		return _secondCompanyCar.isPending();
	}

	/**
	* Returns <code>true</code> if this second company car is scheduled.
	*
	* @return <code>true</code> if this second company car is scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isScheduled() {
		return _secondCompanyCar.isScheduled();
	}

	@Override
	public boolean isNew() {
		return _secondCompanyCar.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_secondCompanyCar.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _secondCompanyCar.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_secondCompanyCar.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _secondCompanyCar.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _secondCompanyCar.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_secondCompanyCar.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _secondCompanyCar.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_secondCompanyCar.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_secondCompanyCar.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_secondCompanyCar.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SecondCompanyCarWrapper((SecondCompanyCar)_secondCompanyCar.clone());
	}

	@Override
	public int compareTo(
		com.company.car.model.SecondCompanyCar secondCompanyCar) {
		return _secondCompanyCar.compareTo(secondCompanyCar);
	}

	@Override
	public int hashCode() {
		return _secondCompanyCar.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.company.car.model.SecondCompanyCar> toCacheModel() {
		return _secondCompanyCar.toCacheModel();
	}

	@Override
	public com.company.car.model.SecondCompanyCar toEscapedModel() {
		return new SecondCompanyCarWrapper(_secondCompanyCar.toEscapedModel());
	}

	@Override
	public com.company.car.model.SecondCompanyCar toUnescapedModel() {
		return new SecondCompanyCarWrapper(_secondCompanyCar.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _secondCompanyCar.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _secondCompanyCar.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_secondCompanyCar.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SecondCompanyCarWrapper)) {
			return false;
		}

		SecondCompanyCarWrapper secondCompanyCarWrapper = (SecondCompanyCarWrapper)obj;

		if (Validator.equals(_secondCompanyCar,
					secondCompanyCarWrapper._secondCompanyCar)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SecondCompanyCar getWrappedSecondCompanyCar() {
		return _secondCompanyCar;
	}

	@Override
	public SecondCompanyCar getWrappedModel() {
		return _secondCompanyCar;
	}

	@Override
	public void resetOriginalValues() {
		_secondCompanyCar.resetOriginalValues();
	}

	private SecondCompanyCar _secondCompanyCar;
}