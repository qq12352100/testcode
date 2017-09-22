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

import com.company.car.service.ClpSerializer;
import com.company.car.service.SecondCompanyCarLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class SecondCompanyCarClp extends BaseModelImpl<SecondCompanyCar>
	implements SecondCompanyCar {
	public SecondCompanyCarClp() {
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
	public long getPrimaryKey() {
		return _secondCompanyCarId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSecondCompanyCarId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _secondCompanyCarId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getSecondCompanyCarId() {
		return _secondCompanyCarId;
	}

	@Override
	public void setSecondCompanyCarId(long secondCompanyCarId) {
		_secondCompanyCarId = secondCompanyCarId;

		if (_secondCompanyCarRemoteModel != null) {
			try {
				Class<?> clazz = _secondCompanyCarRemoteModel.getClass();

				Method method = clazz.getMethod("setSecondCompanyCarId",
						long.class);

				method.invoke(_secondCompanyCarRemoteModel, secondCompanyCarId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTicketNo() {
		return _ticketNo;
	}

	@Override
	public void setTicketNo(String ticketNo) {
		_ticketNo = ticketNo;

		if (_secondCompanyCarRemoteModel != null) {
			try {
				Class<?> clazz = _secondCompanyCarRemoteModel.getClass();

				Method method = clazz.getMethod("setTicketNo", String.class);

				method.invoke(_secondCompanyCarRemoteModel, ticketNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_secondCompanyCarRemoteModel != null) {
			try {
				Class<?> clazz = _secondCompanyCarRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_secondCompanyCarRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_secondCompanyCarRemoteModel != null) {
			try {
				Class<?> clazz = _secondCompanyCarRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_secondCompanyCarRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_secondCompanyCarRemoteModel != null) {
			try {
				Class<?> clazz = _secondCompanyCarRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_secondCompanyCarRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_secondCompanyCarRemoteModel != null) {
			try {
				Class<?> clazz = _secondCompanyCarRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_secondCompanyCarRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_secondCompanyCarRemoteModel != null) {
			try {
				Class<?> clazz = _secondCompanyCarRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_secondCompanyCarRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getSubmittedDate() {
		return _submittedDate;
	}

	@Override
	public void setSubmittedDate(Date submittedDate) {
		_submittedDate = submittedDate;

		if (_secondCompanyCarRemoteModel != null) {
			try {
				Class<?> clazz = _secondCompanyCarRemoteModel.getClass();

				Method method = clazz.getMethod("setSubmittedDate", Date.class);

				method.invoke(_secondCompanyCarRemoteModel, submittedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_secondCompanyCarRemoteModel != null) {
			try {
				Class<?> clazz = _secondCompanyCarRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_secondCompanyCarRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_secondCompanyCarRemoteModel != null) {
			try {
				Class<?> clazz = _secondCompanyCarRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_secondCompanyCarRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getStaffCode() {
		return _staffCode;
	}

	@Override
	public void setStaffCode(long staffCode) {
		_staffCode = staffCode;

		if (_secondCompanyCarRemoteModel != null) {
			try {
				Class<?> clazz = _secondCompanyCarRemoteModel.getClass();

				Method method = clazz.getMethod("setStaffCode", long.class);

				method.invoke(_secondCompanyCarRemoteModel, staffCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDivision() {
		return _division;
	}

	@Override
	public void setDivision(String division) {
		_division = division;

		if (_secondCompanyCarRemoteModel != null) {
			try {
				Class<?> clazz = _secondCompanyCarRemoteModel.getClass();

				Method method = clazz.getMethod("setDivision", String.class);

				method.invoke(_secondCompanyCarRemoteModel, division);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDepartment() {
		return _department;
	}

	@Override
	public void setDepartment(String department) {
		_department = department;

		if (_secondCompanyCarRemoteModel != null) {
			try {
				Class<?> clazz = _secondCompanyCarRemoteModel.getClass();

				Method method = clazz.getMethod("setDepartment", String.class);

				method.invoke(_secondCompanyCarRemoteModel, department);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;

		if (_secondCompanyCarRemoteModel != null) {
			try {
				Class<?> clazz = _secondCompanyCarRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_secondCompanyCarRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getStatusByUserId() {
		return _statusByUserId;
	}

	@Override
	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;

		if (_secondCompanyCarRemoteModel != null) {
			try {
				Class<?> clazz = _secondCompanyCarRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusByUserId", long.class);

				method.invoke(_secondCompanyCarRemoteModel, statusByUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStatusByUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getStatusByUserId(), "uuid",
			_statusByUserUuid);
	}

	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		_statusByUserUuid = statusByUserUuid;
	}

	@Override
	public String getStatusByUserName() {
		return _statusByUserName;
	}

	@Override
	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;

		if (_secondCompanyCarRemoteModel != null) {
			try {
				Class<?> clazz = _secondCompanyCarRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusByUserName",
						String.class);

				method.invoke(_secondCompanyCarRemoteModel, statusByUserName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCompanyName() {
		return _companyName;
	}

	@Override
	public void setCompanyName(String companyName) {
		_companyName = companyName;

		if (_secondCompanyCarRemoteModel != null) {
			try {
				Class<?> clazz = _secondCompanyCarRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyName", String.class);

				method.invoke(_secondCompanyCarRemoteModel, companyName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getStatusDate() {
		return _statusDate;
	}

	@Override
	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;

		if (_secondCompanyCarRemoteModel != null) {
			try {
				Class<?> clazz = _secondCompanyCarRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusDate", Date.class);

				method.invoke(_secondCompanyCarRemoteModel, statusDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContactNo() {
		return _contactNo;
	}

	@Override
	public void setContactNo(String contactNo) {
		_contactNo = contactNo;

		if (_secondCompanyCarRemoteModel != null) {
			try {
				Class<?> clazz = _secondCompanyCarRemoteModel.getClass();

				Method method = clazz.getMethod("setContactNo", String.class);

				method.invoke(_secondCompanyCarRemoteModel, contactNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getWorkingLocation() {
		return _workingLocation;
	}

	@Override
	public void setWorkingLocation(String workingLocation) {
		_workingLocation = workingLocation;

		if (_secondCompanyCarRemoteModel != null) {
			try {
				Class<?> clazz = _secondCompanyCarRemoteModel.getClass();

				Method method = clazz.getMethod("setWorkingLocation",
						String.class);

				method.invoke(_secondCompanyCarRemoteModel, workingLocation);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOfficeSite() {
		return _officeSite;
	}

	@Override
	public void setOfficeSite(String officeSite) {
		_officeSite = officeSite;

		if (_secondCompanyCarRemoteModel != null) {
			try {
				Class<?> clazz = _secondCompanyCarRemoteModel.getClass();

				Method method = clazz.getMethod("setOfficeSite", String.class);

				method.invoke(_secondCompanyCarRemoteModel, officeSite);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCurrentCarModel() {
		return _currentCarModel;
	}

	@Override
	public void setCurrentCarModel(String currentCarModel) {
		_currentCarModel = currentCarModel;

		if (_secondCompanyCarRemoteModel != null) {
			try {
				Class<?> clazz = _secondCompanyCarRemoteModel.getClass();

				Method method = clazz.getMethod("setCurrentCarModel",
						String.class);

				method.invoke(_secondCompanyCarRemoteModel, currentCarModel);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCurrentCarColor() {
		return _currentCarColor;
	}

	@Override
	public void setCurrentCarColor(String currentCarColor) {
		_currentCarColor = currentCarColor;

		if (_secondCompanyCarRemoteModel != null) {
			try {
				Class<?> clazz = _secondCompanyCarRemoteModel.getClass();

				Method method = clazz.getMethod("setCurrentCarColor",
						String.class);

				method.invoke(_secondCompanyCarRemoteModel, currentCarColor);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCurrentPlateNumber() {
		return _currentPlateNumber;
	}

	@Override
	public void setCurrentPlateNumber(String currentPlateNumber) {
		_currentPlateNumber = currentPlateNumber;

		if (_secondCompanyCarRemoteModel != null) {
			try {
				Class<?> clazz = _secondCompanyCarRemoteModel.getClass();

				Method method = clazz.getMethod("setCurrentPlateNumber",
						String.class);

				method.invoke(_secondCompanyCarRemoteModel, currentPlateNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getAcquiringDate() {
		return _acquiringDate;
	}

	@Override
	public void setAcquiringDate(Date acquiringDate) {
		_acquiringDate = acquiringDate;

		if (_secondCompanyCarRemoteModel != null) {
			try {
				Class<?> clazz = _secondCompanyCarRemoteModel.getClass();

				Method method = clazz.getMethod("setAcquiringDate", Date.class);

				method.invoke(_secondCompanyCarRemoteModel, acquiringDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExpectedCarModel() {
		return _expectedCarModel;
	}

	@Override
	public void setExpectedCarModel(String expectedCarModel) {
		_expectedCarModel = expectedCarModel;

		if (_secondCompanyCarRemoteModel != null) {
			try {
				Class<?> clazz = _secondCompanyCarRemoteModel.getClass();

				Method method = clazz.getMethod("setExpectedCarModel",
						String.class);

				method.invoke(_secondCompanyCarRemoteModel, expectedCarModel);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExpectedCarColor() {
		return _expectedCarColor;
	}

	@Override
	public void setExpectedCarColor(String expectedCarColor) {
		_expectedCarColor = expectedCarColor;

		if (_secondCompanyCarRemoteModel != null) {
			try {
				Class<?> clazz = _secondCompanyCarRemoteModel.getClass();

				Method method = clazz.getMethod("setExpectedCarColor",
						String.class);

				method.invoke(_secondCompanyCarRemoteModel, expectedCarColor);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExpectedLastPlateNumber() {
		return _expectedLastPlateNumber;
	}

	@Override
	public void setExpectedLastPlateNumber(String expectedLastPlateNumber) {
		_expectedLastPlateNumber = expectedLastPlateNumber;

		if (_secondCompanyCarRemoteModel != null) {
			try {
				Class<?> clazz = _secondCompanyCarRemoteModel.getClass();

				Method method = clazz.getMethod("setExpectedLastPlateNumber",
						String.class);

				method.invoke(_secondCompanyCarRemoteModel,
					expectedLastPlateNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPositionCostCenterId() {
		return _positionCostCenterId;
	}

	@Override
	public void setPositionCostCenterId(String positionCostCenterId) {
		_positionCostCenterId = positionCostCenterId;

		if (_secondCompanyCarRemoteModel != null) {
			try {
				Class<?> clazz = _secondCompanyCarRemoteModel.getClass();

				Method method = clazz.getMethod("setPositionCostCenterId",
						String.class);

				method.invoke(_secondCompanyCarRemoteModel, positionCostCenterId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmployeeGroupId() {
		return _employeeGroupId;
	}

	@Override
	public void setEmployeeGroupId(String employeeGroupId) {
		_employeeGroupId = employeeGroupId;

		if (_secondCompanyCarRemoteModel != null) {
			try {
				Class<?> clazz = _secondCompanyCarRemoteModel.getClass();

				Method method = clazz.getMethod("setEmployeeGroupId",
						String.class);

				method.invoke(_secondCompanyCarRemoteModel, employeeGroupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getContractEndDate() {
		return _contractEndDate;
	}

	@Override
	public void setContractEndDate(Date contractEndDate) {
		_contractEndDate = contractEndDate;

		if (_secondCompanyCarRemoteModel != null) {
			try {
				Class<?> clazz = _secondCompanyCarRemoteModel.getClass();

				Method method = clazz.getMethod("setContractEndDate", Date.class);

				method.invoke(_secondCompanyCarRemoteModel, contractEndDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMobilePhone() {
		return _mobilePhone;
	}

	@Override
	public void setMobilePhone(String mobilePhone) {
		_mobilePhone = mobilePhone;

		if (_secondCompanyCarRemoteModel != null) {
			try {
				Class<?> clazz = _secondCompanyCarRemoteModel.getClass();

				Method method = clazz.getMethod("setMobilePhone", String.class);

				method.invoke(_secondCompanyCarRemoteModel, mobilePhone);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOfficePhone() {
		return _officePhone;
	}

	@Override
	public void setOfficePhone(String officePhone) {
		_officePhone = officePhone;

		if (_secondCompanyCarRemoteModel != null) {
			try {
				Class<?> clazz = _secondCompanyCarRemoteModel.getClass();

				Method method = clazz.getMethod("setOfficePhone", String.class);

				method.invoke(_secondCompanyCarRemoteModel, officePhone);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmail() {
		return _email;
	}

	@Override
	public void setEmail(String email) {
		_email = email;

		if (_secondCompanyCarRemoteModel != null) {
			try {
				Class<?> clazz = _secondCompanyCarRemoteModel.getClass();

				Method method = clazz.getMethod("setEmail", String.class);

				method.invoke(_secondCompanyCarRemoteModel, email);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsApplicantAgent() {
		return _isApplicantAgent;
	}

	@Override
	public boolean isIsApplicantAgent() {
		return _isApplicantAgent;
	}

	@Override
	public void setIsApplicantAgent(boolean isApplicantAgent) {
		_isApplicantAgent = isApplicantAgent;

		if (_secondCompanyCarRemoteModel != null) {
			try {
				Class<?> clazz = _secondCompanyCarRemoteModel.getClass();

				Method method = clazz.getMethod("setIsApplicantAgent",
						boolean.class);

				method.invoke(_secondCompanyCarRemoteModel, isApplicantAgent);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsApproverAgent() {
		return _isApproverAgent;
	}

	@Override
	public boolean isIsApproverAgent() {
		return _isApproverAgent;
	}

	@Override
	public void setIsApproverAgent(boolean isApproverAgent) {
		_isApproverAgent = isApproverAgent;

		if (_secondCompanyCarRemoteModel != null) {
			try {
				Class<?> clazz = _secondCompanyCarRemoteModel.getClass();

				Method method = clazz.getMethod("setIsApproverAgent",
						boolean.class);

				method.invoke(_secondCompanyCarRemoteModel, isApproverAgent);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getDrivingLicenseInformation() {
		return _drivingLicenseInformation;
	}

	@Override
	public void setDrivingLicenseInformation(int drivingLicenseInformation) {
		_drivingLicenseInformation = drivingLicenseInformation;

		if (_secondCompanyCarRemoteModel != null) {
			try {
				Class<?> clazz = _secondCompanyCarRemoteModel.getClass();

				Method method = clazz.getMethod("setDrivingLicenseInformation",
						int.class);

				method.invoke(_secondCompanyCarRemoteModel,
					drivingLicenseInformation);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEstimatedObtainingDate() {
		return _estimatedObtainingDate;
	}

	@Override
	public void setEstimatedObtainingDate(Date estimatedObtainingDate) {
		_estimatedObtainingDate = estimatedObtainingDate;

		if (_secondCompanyCarRemoteModel != null) {
			try {
				Class<?> clazz = _secondCompanyCarRemoteModel.getClass();

				Method method = clazz.getMethod("setEstimatedObtainingDate",
						Date.class);

				method.invoke(_secondCompanyCarRemoteModel,
					estimatedObtainingDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getComments() {
		return _comments;
	}

	@Override
	public void setComments(String comments) {
		_comments = comments;

		if (_secondCompanyCarRemoteModel != null) {
			try {
				Class<?> clazz = _secondCompanyCarRemoteModel.getClass();

				Method method = clazz.getMethod("setComments", String.class);

				method.invoke(_secondCompanyCarRemoteModel, comments);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getProcessType() {
		return _processType;
	}

	@Override
	public void setProcessType(String processType) {
		_processType = processType;

		if (_secondCompanyCarRemoteModel != null) {
			try {
				Class<?> clazz = _secondCompanyCarRemoteModel.getClass();

				Method method = clazz.getMethod("setProcessType", String.class);

				method.invoke(_secondCompanyCarRemoteModel, processType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSubType() {
		return _subType;
	}

	@Override
	public void setSubType(String subType) {
		_subType = subType;

		if (_secondCompanyCarRemoteModel != null) {
			try {
				Class<?> clazz = _secondCompanyCarRemoteModel.getClass();

				Method method = clazz.getMethod("setSubType", String.class);

				method.invoke(_secondCompanyCarRemoteModel, subType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #isApproved}
	 */
	@Override
	public boolean getApproved() {
		return isApproved();
	}

	@Override
	public boolean isApproved() {
		if (getStatus() == WorkflowConstants.STATUS_APPROVED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDenied() {
		if (getStatus() == WorkflowConstants.STATUS_DENIED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDraft() {
		if (getStatus() == WorkflowConstants.STATUS_DRAFT) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isExpired() {
		if (getStatus() == WorkflowConstants.STATUS_EXPIRED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isInactive() {
		if (getStatus() == WorkflowConstants.STATUS_INACTIVE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isIncomplete() {
		if (getStatus() == WorkflowConstants.STATUS_INCOMPLETE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isPending() {
		if (getStatus() == WorkflowConstants.STATUS_PENDING) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isScheduled() {
		if (getStatus() == WorkflowConstants.STATUS_SCHEDULED) {
			return true;
		}
		else {
			return false;
		}
	}

	public BaseModel<?> getSecondCompanyCarRemoteModel() {
		return _secondCompanyCarRemoteModel;
	}

	public void setSecondCompanyCarRemoteModel(
		BaseModel<?> secondCompanyCarRemoteModel) {
		_secondCompanyCarRemoteModel = secondCompanyCarRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _secondCompanyCarRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_secondCompanyCarRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SecondCompanyCarLocalServiceUtil.addSecondCompanyCar(this);
		}
		else {
			SecondCompanyCarLocalServiceUtil.updateSecondCompanyCar(this);
		}
	}

	@Override
	public SecondCompanyCar toEscapedModel() {
		return (SecondCompanyCar)ProxyUtil.newProxyInstance(SecondCompanyCar.class.getClassLoader(),
			new Class[] { SecondCompanyCar.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SecondCompanyCarClp clone = new SecondCompanyCarClp();

		clone.setSecondCompanyCarId(getSecondCompanyCarId());
		clone.setTicketNo(getTicketNo());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setSubmittedDate(getSubmittedDate());
		clone.setCompanyId(getCompanyId());
		clone.setName(getName());
		clone.setStaffCode(getStaffCode());
		clone.setDivision(getDivision());
		clone.setDepartment(getDepartment());
		clone.setStatus(getStatus());
		clone.setStatusByUserId(getStatusByUserId());
		clone.setStatusByUserName(getStatusByUserName());
		clone.setCompanyName(getCompanyName());
		clone.setStatusDate(getStatusDate());
		clone.setContactNo(getContactNo());
		clone.setWorkingLocation(getWorkingLocation());
		clone.setOfficeSite(getOfficeSite());
		clone.setCurrentCarModel(getCurrentCarModel());
		clone.setCurrentCarColor(getCurrentCarColor());
		clone.setCurrentPlateNumber(getCurrentPlateNumber());
		clone.setAcquiringDate(getAcquiringDate());
		clone.setExpectedCarModel(getExpectedCarModel());
		clone.setExpectedCarColor(getExpectedCarColor());
		clone.setExpectedLastPlateNumber(getExpectedLastPlateNumber());
		clone.setPositionCostCenterId(getPositionCostCenterId());
		clone.setEmployeeGroupId(getEmployeeGroupId());
		clone.setContractEndDate(getContractEndDate());
		clone.setMobilePhone(getMobilePhone());
		clone.setOfficePhone(getOfficePhone());
		clone.setEmail(getEmail());
		clone.setIsApplicantAgent(getIsApplicantAgent());
		clone.setIsApproverAgent(getIsApproverAgent());
		clone.setDrivingLicenseInformation(getDrivingLicenseInformation());
		clone.setEstimatedObtainingDate(getEstimatedObtainingDate());
		clone.setComments(getComments());
		clone.setProcessType(getProcessType());
		clone.setSubType(getSubType());

		return clone;
	}

	@Override
	public int compareTo(SecondCompanyCar secondCompanyCar) {
		long primaryKey = secondCompanyCar.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SecondCompanyCarClp)) {
			return false;
		}

		SecondCompanyCarClp secondCompanyCar = (SecondCompanyCarClp)obj;

		long primaryKey = secondCompanyCar.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(83);

		sb.append("{secondCompanyCarId=");
		sb.append(getSecondCompanyCarId());
		sb.append(", ticketNo=");
		sb.append(getTicketNo());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", submittedDate=");
		sb.append(getSubmittedDate());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", staffCode=");
		sb.append(getStaffCode());
		sb.append(", division=");
		sb.append(getDivision());
		sb.append(", department=");
		sb.append(getDepartment());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", statusByUserId=");
		sb.append(getStatusByUserId());
		sb.append(", statusByUserName=");
		sb.append(getStatusByUserName());
		sb.append(", companyName=");
		sb.append(getCompanyName());
		sb.append(", statusDate=");
		sb.append(getStatusDate());
		sb.append(", contactNo=");
		sb.append(getContactNo());
		sb.append(", workingLocation=");
		sb.append(getWorkingLocation());
		sb.append(", officeSite=");
		sb.append(getOfficeSite());
		sb.append(", currentCarModel=");
		sb.append(getCurrentCarModel());
		sb.append(", currentCarColor=");
		sb.append(getCurrentCarColor());
		sb.append(", currentPlateNumber=");
		sb.append(getCurrentPlateNumber());
		sb.append(", acquiringDate=");
		sb.append(getAcquiringDate());
		sb.append(", expectedCarModel=");
		sb.append(getExpectedCarModel());
		sb.append(", expectedCarColor=");
		sb.append(getExpectedCarColor());
		sb.append(", expectedLastPlateNumber=");
		sb.append(getExpectedLastPlateNumber());
		sb.append(", positionCostCenterId=");
		sb.append(getPositionCostCenterId());
		sb.append(", employeeGroupId=");
		sb.append(getEmployeeGroupId());
		sb.append(", contractEndDate=");
		sb.append(getContractEndDate());
		sb.append(", mobilePhone=");
		sb.append(getMobilePhone());
		sb.append(", officePhone=");
		sb.append(getOfficePhone());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", isApplicantAgent=");
		sb.append(getIsApplicantAgent());
		sb.append(", isApproverAgent=");
		sb.append(getIsApproverAgent());
		sb.append(", drivingLicenseInformation=");
		sb.append(getDrivingLicenseInformation());
		sb.append(", estimatedObtainingDate=");
		sb.append(getEstimatedObtainingDate());
		sb.append(", comments=");
		sb.append(getComments());
		sb.append(", processType=");
		sb.append(getProcessType());
		sb.append(", subType=");
		sb.append(getSubType());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(127);

		sb.append("<model><model-name>");
		sb.append("com.company.car.model.SecondCompanyCar");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>secondCompanyCarId</column-name><column-value><![CDATA[");
		sb.append(getSecondCompanyCarId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ticketNo</column-name><column-value><![CDATA[");
		sb.append(getTicketNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>submittedDate</column-name><column-value><![CDATA[");
		sb.append(getSubmittedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>staffCode</column-name><column-value><![CDATA[");
		sb.append(getStaffCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>division</column-name><column-value><![CDATA[");
		sb.append(getDivision());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>department</column-name><column-value><![CDATA[");
		sb.append(getDepartment());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserId</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserName</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyName</column-name><column-value><![CDATA[");
		sb.append(getCompanyName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusDate</column-name><column-value><![CDATA[");
		sb.append(getStatusDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactNo</column-name><column-value><![CDATA[");
		sb.append(getContactNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>workingLocation</column-name><column-value><![CDATA[");
		sb.append(getWorkingLocation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>officeSite</column-name><column-value><![CDATA[");
		sb.append(getOfficeSite());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currentCarModel</column-name><column-value><![CDATA[");
		sb.append(getCurrentCarModel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currentCarColor</column-name><column-value><![CDATA[");
		sb.append(getCurrentCarColor());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currentPlateNumber</column-name><column-value><![CDATA[");
		sb.append(getCurrentPlateNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>acquiringDate</column-name><column-value><![CDATA[");
		sb.append(getAcquiringDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expectedCarModel</column-name><column-value><![CDATA[");
		sb.append(getExpectedCarModel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expectedCarColor</column-name><column-value><![CDATA[");
		sb.append(getExpectedCarColor());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expectedLastPlateNumber</column-name><column-value><![CDATA[");
		sb.append(getExpectedLastPlateNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>positionCostCenterId</column-name><column-value><![CDATA[");
		sb.append(getPositionCostCenterId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>employeeGroupId</column-name><column-value><![CDATA[");
		sb.append(getEmployeeGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contractEndDate</column-name><column-value><![CDATA[");
		sb.append(getContractEndDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mobilePhone</column-name><column-value><![CDATA[");
		sb.append(getMobilePhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>officePhone</column-name><column-value><![CDATA[");
		sb.append(getOfficePhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isApplicantAgent</column-name><column-value><![CDATA[");
		sb.append(getIsApplicantAgent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isApproverAgent</column-name><column-value><![CDATA[");
		sb.append(getIsApproverAgent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>drivingLicenseInformation</column-name><column-value><![CDATA[");
		sb.append(getDrivingLicenseInformation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>estimatedObtainingDate</column-name><column-value><![CDATA[");
		sb.append(getEstimatedObtainingDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>comments</column-name><column-value><![CDATA[");
		sb.append(getComments());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>processType</column-name><column-value><![CDATA[");
		sb.append(getProcessType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subType</column-name><column-value><![CDATA[");
		sb.append(getSubType());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _secondCompanyCarId;
	private String _ticketNo;
	private long _groupId;
	private long _userId;
	private String _userUuid;
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
	private String _statusByUserUuid;
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
	private BaseModel<?> _secondCompanyCarRemoteModel;
	private Class<?> _clpSerializerClass = com.company.car.service.ClpSerializer.class;
}