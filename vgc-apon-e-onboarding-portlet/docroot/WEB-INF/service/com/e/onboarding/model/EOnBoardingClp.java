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

package com.e.onboarding.model;

import com.e.onboarding.service.ClpSerializer;
import com.e.onboarding.service.EOnBoardingLocalServiceUtil;

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
 * @author sanguine
 */
public class EOnBoardingClp extends BaseModelImpl<EOnBoarding>
	implements EOnBoarding {
	public EOnBoardingClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return EOnBoarding.class;
	}

	@Override
	public String getModelClassName() {
		return EOnBoarding.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _eOnBoardingId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEOnBoardingId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _eOnBoardingId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("eOnBoardingId", getEOnBoardingId());
		attributes.put("ticketNo", getTicketNo());
		attributes.put("processType", getProcessType());
		attributes.put("subType", getSubType());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("submittedDate", getSubmittedDate());
		attributes.put("modifiedUserId", getModifiedUserId());
		attributes.put("modifiedUserName", getModifiedUserName());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("staffCode", getStaffCode());
		attributes.put("lastName", getLastName());
		attributes.put("firstName", getFirstName());
		attributes.put("name", getName());
		attributes.put("gender", getGender());
		attributes.put("birthday", getBirthday());
		attributes.put("photoPath", getPhotoPath());
		attributes.put("contractType", getContractType());
		attributes.put("workLocation", getWorkLocation());
		attributes.put("division", getDivision());
		attributes.put("officeSite", getOfficeSite());
		attributes.put("department", getDepartment());
		attributes.put("startingDate", getStartingDate());
		attributes.put("positionCode", getPositionCode());
		attributes.put("serviceLength", getServiceLength());
		attributes.put("functionName", getFunctionName());
		attributes.put("reportTo", getReportTo());
		attributes.put("reportToStaffName", getReportToStaffName());
		attributes.put("title", getTitle());
		attributes.put("costCenter", getCostCenter());
		attributes.put("itRelatedHardware", getItRelatedHardware());
		attributes.put("companyCar", getCompanyCar());
		attributes.put("replacement", getReplacement());
		attributes.put("nameOfReplacedPerson", getNameOfReplacedPerson());
		attributes.put("contactInfo", getContactInfo());
		attributes.put("comments", getComments());
		attributes.put("isApplicantAgent", getIsApplicantAgent());
		attributes.put("isApproverAgent", getIsApproverAgent());
		attributes.put("adminEntitlement", getAdminEntitlement());
		attributes.put("adminSeatNo", getAdminSeatNo());
		attributes.put("adminTasks", getAdminTasks());
		attributes.put("adminStatus", getAdminStatus());
		attributes.put("adminComments", getAdminComments());
		attributes.put("securityTasks", getSecurityTasks());
		attributes.put("securityStatus", getSecurityStatus());
		attributes.put("securityComments", getSecurityComments());
		attributes.put("itpTasks", getItpTasks());
		attributes.put("itpStatus", getItpStatus());
		attributes.put("iptComments", getIptComments());
		attributes.put("financeTasks", getFinanceTasks());
		attributes.put("financeStatus", getFinanceStatus());
		attributes.put("financeComments", getFinanceComments());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long eOnBoardingId = (Long)attributes.get("eOnBoardingId");

		if (eOnBoardingId != null) {
			setEOnBoardingId(eOnBoardingId);
		}

		String ticketNo = (String)attributes.get("ticketNo");

		if (ticketNo != null) {
			setTicketNo(ticketNo);
		}

		String processType = (String)attributes.get("processType");

		if (processType != null) {
			setProcessType(processType);
		}

		String subType = (String)attributes.get("subType");

		if (subType != null) {
			setSubType(subType);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
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

		Long modifiedUserId = (Long)attributes.get("modifiedUserId");

		if (modifiedUserId != null) {
			setModifiedUserId(modifiedUserId);
		}

		String modifiedUserName = (String)attributes.get("modifiedUserName");

		if (modifiedUserName != null) {
			setModifiedUserName(modifiedUserName);
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

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		String staffCode = (String)attributes.get("staffCode");

		if (staffCode != null) {
			setStaffCode(staffCode);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String gender = (String)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		Date birthday = (Date)attributes.get("birthday");

		if (birthday != null) {
			setBirthday(birthday);
		}

		String photoPath = (String)attributes.get("photoPath");

		if (photoPath != null) {
			setPhotoPath(photoPath);
		}

		String contractType = (String)attributes.get("contractType");

		if (contractType != null) {
			setContractType(contractType);
		}

		String workLocation = (String)attributes.get("workLocation");

		if (workLocation != null) {
			setWorkLocation(workLocation);
		}

		String division = (String)attributes.get("division");

		if (division != null) {
			setDivision(division);
		}

		String officeSite = (String)attributes.get("officeSite");

		if (officeSite != null) {
			setOfficeSite(officeSite);
		}

		String department = (String)attributes.get("department");

		if (department != null) {
			setDepartment(department);
		}

		Date startingDate = (Date)attributes.get("startingDate");

		if (startingDate != null) {
			setStartingDate(startingDate);
		}

		String positionCode = (String)attributes.get("positionCode");

		if (positionCode != null) {
			setPositionCode(positionCode);
		}

		String serviceLength = (String)attributes.get("serviceLength");

		if (serviceLength != null) {
			setServiceLength(serviceLength);
		}

		String functionName = (String)attributes.get("functionName");

		if (functionName != null) {
			setFunctionName(functionName);
		}

		String reportTo = (String)attributes.get("reportTo");

		if (reportTo != null) {
			setReportTo(reportTo);
		}

		String reportToStaffName = (String)attributes.get("reportToStaffName");

		if (reportToStaffName != null) {
			setReportToStaffName(reportToStaffName);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String costCenter = (String)attributes.get("costCenter");

		if (costCenter != null) {
			setCostCenter(costCenter);
		}

		Boolean itRelatedHardware = (Boolean)attributes.get("itRelatedHardware");

		if (itRelatedHardware != null) {
			setItRelatedHardware(itRelatedHardware);
		}

		Boolean companyCar = (Boolean)attributes.get("companyCar");

		if (companyCar != null) {
			setCompanyCar(companyCar);
		}

		Boolean replacement = (Boolean)attributes.get("replacement");

		if (replacement != null) {
			setReplacement(replacement);
		}

		String nameOfReplacedPerson = (String)attributes.get(
				"nameOfReplacedPerson");

		if (nameOfReplacedPerson != null) {
			setNameOfReplacedPerson(nameOfReplacedPerson);
		}

		String contactInfo = (String)attributes.get("contactInfo");

		if (contactInfo != null) {
			setContactInfo(contactInfo);
		}

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
		}

		Boolean isApplicantAgent = (Boolean)attributes.get("isApplicantAgent");

		if (isApplicantAgent != null) {
			setIsApplicantAgent(isApplicantAgent);
		}

		Boolean isApproverAgent = (Boolean)attributes.get("isApproverAgent");

		if (isApproverAgent != null) {
			setIsApproverAgent(isApproverAgent);
		}

		String adminEntitlement = (String)attributes.get("adminEntitlement");

		if (adminEntitlement != null) {
			setAdminEntitlement(adminEntitlement);
		}

		String adminSeatNo = (String)attributes.get("adminSeatNo");

		if (adminSeatNo != null) {
			setAdminSeatNo(adminSeatNo);
		}

		String adminTasks = (String)attributes.get("adminTasks");

		if (adminTasks != null) {
			setAdminTasks(adminTasks);
		}

		String adminStatus = (String)attributes.get("adminStatus");

		if (adminStatus != null) {
			setAdminStatus(adminStatus);
		}

		String adminComments = (String)attributes.get("adminComments");

		if (adminComments != null) {
			setAdminComments(adminComments);
		}

		String securityTasks = (String)attributes.get("securityTasks");

		if (securityTasks != null) {
			setSecurityTasks(securityTasks);
		}

		String securityStatus = (String)attributes.get("securityStatus");

		if (securityStatus != null) {
			setSecurityStatus(securityStatus);
		}

		String securityComments = (String)attributes.get("securityComments");

		if (securityComments != null) {
			setSecurityComments(securityComments);
		}

		String itpTasks = (String)attributes.get("itpTasks");

		if (itpTasks != null) {
			setItpTasks(itpTasks);
		}

		String itpStatus = (String)attributes.get("itpStatus");

		if (itpStatus != null) {
			setItpStatus(itpStatus);
		}

		String iptComments = (String)attributes.get("iptComments");

		if (iptComments != null) {
			setIptComments(iptComments);
		}

		String financeTasks = (String)attributes.get("financeTasks");

		if (financeTasks != null) {
			setFinanceTasks(financeTasks);
		}

		String financeStatus = (String)attributes.get("financeStatus");

		if (financeStatus != null) {
			setFinanceStatus(financeStatus);
		}

		String financeComments = (String)attributes.get("financeComments");

		if (financeComments != null) {
			setFinanceComments(financeComments);
		}
	}

	@Override
	public long getEOnBoardingId() {
		return _eOnBoardingId;
	}

	@Override
	public void setEOnBoardingId(long eOnBoardingId) {
		_eOnBoardingId = eOnBoardingId;

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setEOnBoardingId", long.class);

				method.invoke(_eOnBoardingRemoteModel, eOnBoardingId);
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

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setTicketNo", String.class);

				method.invoke(_eOnBoardingRemoteModel, ticketNo);
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

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setProcessType", String.class);

				method.invoke(_eOnBoardingRemoteModel, processType);
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

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setSubType", String.class);

				method.invoke(_eOnBoardingRemoteModel, subType);
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

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_eOnBoardingRemoteModel, groupId);
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

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_eOnBoardingRemoteModel, companyId);
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

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_eOnBoardingRemoteModel, userId);
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

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_eOnBoardingRemoteModel, userName);
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

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_eOnBoardingRemoteModel, createDate);
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

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_eOnBoardingRemoteModel, modifiedDate);
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

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setSubmittedDate", Date.class);

				method.invoke(_eOnBoardingRemoteModel, submittedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getModifiedUserId() {
		return _modifiedUserId;
	}

	@Override
	public void setModifiedUserId(long modifiedUserId) {
		_modifiedUserId = modifiedUserId;

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedUserId", long.class);

				method.invoke(_eOnBoardingRemoteModel, modifiedUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getModifiedUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getModifiedUserId(), "uuid",
			_modifiedUserUuid);
	}

	@Override
	public void setModifiedUserUuid(String modifiedUserUuid) {
		_modifiedUserUuid = modifiedUserUuid;
	}

	@Override
	public String getModifiedUserName() {
		return _modifiedUserName;
	}

	@Override
	public void setModifiedUserName(String modifiedUserName) {
		_modifiedUserName = modifiedUserName;

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedUserName",
						String.class);

				method.invoke(_eOnBoardingRemoteModel, modifiedUserName);
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

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_eOnBoardingRemoteModel, status);
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

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusByUserId", long.class);

				method.invoke(_eOnBoardingRemoteModel, statusByUserId);
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

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusByUserName",
						String.class);

				method.invoke(_eOnBoardingRemoteModel, statusByUserName);
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

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusDate", Date.class);

				method.invoke(_eOnBoardingRemoteModel, statusDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStaffCode() {
		return _staffCode;
	}

	@Override
	public void setStaffCode(String staffCode) {
		_staffCode = staffCode;

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setStaffCode", String.class);

				method.invoke(_eOnBoardingRemoteModel, staffCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLastName() {
		return _lastName;
	}

	@Override
	public void setLastName(String lastName) {
		_lastName = lastName;

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setLastName", String.class);

				method.invoke(_eOnBoardingRemoteModel, lastName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFirstName() {
		return _firstName;
	}

	@Override
	public void setFirstName(String firstName) {
		_firstName = firstName;

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setFirstName", String.class);

				method.invoke(_eOnBoardingRemoteModel, firstName);
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

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_eOnBoardingRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGender() {
		return _gender;
	}

	@Override
	public void setGender(String gender) {
		_gender = gender;

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setGender", String.class);

				method.invoke(_eOnBoardingRemoteModel, gender);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getBirthday() {
		return _birthday;
	}

	@Override
	public void setBirthday(Date birthday) {
		_birthday = birthday;

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setBirthday", Date.class);

				method.invoke(_eOnBoardingRemoteModel, birthday);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPhotoPath() {
		return _photoPath;
	}

	@Override
	public void setPhotoPath(String photoPath) {
		_photoPath = photoPath;

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setPhotoPath", String.class);

				method.invoke(_eOnBoardingRemoteModel, photoPath);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContractType() {
		return _contractType;
	}

	@Override
	public void setContractType(String contractType) {
		_contractType = contractType;

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setContractType", String.class);

				method.invoke(_eOnBoardingRemoteModel, contractType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getWorkLocation() {
		return _workLocation;
	}

	@Override
	public void setWorkLocation(String workLocation) {
		_workLocation = workLocation;

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setWorkLocation", String.class);

				method.invoke(_eOnBoardingRemoteModel, workLocation);
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

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setDivision", String.class);

				method.invoke(_eOnBoardingRemoteModel, division);
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

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setOfficeSite", String.class);

				method.invoke(_eOnBoardingRemoteModel, officeSite);
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

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setDepartment", String.class);

				method.invoke(_eOnBoardingRemoteModel, department);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getStartingDate() {
		return _startingDate;
	}

	@Override
	public void setStartingDate(Date startingDate) {
		_startingDate = startingDate;

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setStartingDate", Date.class);

				method.invoke(_eOnBoardingRemoteModel, startingDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPositionCode() {
		return _positionCode;
	}

	@Override
	public void setPositionCode(String positionCode) {
		_positionCode = positionCode;

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setPositionCode", String.class);

				method.invoke(_eOnBoardingRemoteModel, positionCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getServiceLength() {
		return _serviceLength;
	}

	@Override
	public void setServiceLength(String serviceLength) {
		_serviceLength = serviceLength;

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setServiceLength", String.class);

				method.invoke(_eOnBoardingRemoteModel, serviceLength);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFunctionName() {
		return _functionName;
	}

	@Override
	public void setFunctionName(String functionName) {
		_functionName = functionName;

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setFunctionName", String.class);

				method.invoke(_eOnBoardingRemoteModel, functionName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getReportTo() {
		return _reportTo;
	}

	@Override
	public void setReportTo(String reportTo) {
		_reportTo = reportTo;

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setReportTo", String.class);

				method.invoke(_eOnBoardingRemoteModel, reportTo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getReportToStaffName() {
		return _reportToStaffName;
	}

	@Override
	public void setReportToStaffName(String reportToStaffName) {
		_reportToStaffName = reportToStaffName;

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setReportToStaffName",
						String.class);

				method.invoke(_eOnBoardingRemoteModel, reportToStaffName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTitle() {
		return _title;
	}

	@Override
	public void setTitle(String title) {
		_title = title;

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_eOnBoardingRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCostCenter() {
		return _costCenter;
	}

	@Override
	public void setCostCenter(String costCenter) {
		_costCenter = costCenter;

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setCostCenter", String.class);

				method.invoke(_eOnBoardingRemoteModel, costCenter);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getItRelatedHardware() {
		return _itRelatedHardware;
	}

	@Override
	public boolean isItRelatedHardware() {
		return _itRelatedHardware;
	}

	@Override
	public void setItRelatedHardware(boolean itRelatedHardware) {
		_itRelatedHardware = itRelatedHardware;

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setItRelatedHardware",
						boolean.class);

				method.invoke(_eOnBoardingRemoteModel, itRelatedHardware);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getCompanyCar() {
		return _companyCar;
	}

	@Override
	public boolean isCompanyCar() {
		return _companyCar;
	}

	@Override
	public void setCompanyCar(boolean companyCar) {
		_companyCar = companyCar;

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyCar", boolean.class);

				method.invoke(_eOnBoardingRemoteModel, companyCar);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getReplacement() {
		return _replacement;
	}

	@Override
	public boolean isReplacement() {
		return _replacement;
	}

	@Override
	public void setReplacement(boolean replacement) {
		_replacement = replacement;

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setReplacement", boolean.class);

				method.invoke(_eOnBoardingRemoteModel, replacement);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNameOfReplacedPerson() {
		return _nameOfReplacedPerson;
	}

	@Override
	public void setNameOfReplacedPerson(String nameOfReplacedPerson) {
		_nameOfReplacedPerson = nameOfReplacedPerson;

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setNameOfReplacedPerson",
						String.class);

				method.invoke(_eOnBoardingRemoteModel, nameOfReplacedPerson);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContactInfo() {
		return _contactInfo;
	}

	@Override
	public void setContactInfo(String contactInfo) {
		_contactInfo = contactInfo;

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setContactInfo", String.class);

				method.invoke(_eOnBoardingRemoteModel, contactInfo);
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

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setComments", String.class);

				method.invoke(_eOnBoardingRemoteModel, comments);
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

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setIsApplicantAgent",
						boolean.class);

				method.invoke(_eOnBoardingRemoteModel, isApplicantAgent);
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

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setIsApproverAgent",
						boolean.class);

				method.invoke(_eOnBoardingRemoteModel, isApproverAgent);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAdminEntitlement() {
		return _adminEntitlement;
	}

	@Override
	public void setAdminEntitlement(String adminEntitlement) {
		_adminEntitlement = adminEntitlement;

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setAdminEntitlement",
						String.class);

				method.invoke(_eOnBoardingRemoteModel, adminEntitlement);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAdminSeatNo() {
		return _adminSeatNo;
	}

	@Override
	public void setAdminSeatNo(String adminSeatNo) {
		_adminSeatNo = adminSeatNo;

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setAdminSeatNo", String.class);

				method.invoke(_eOnBoardingRemoteModel, adminSeatNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAdminTasks() {
		return _adminTasks;
	}

	@Override
	public void setAdminTasks(String adminTasks) {
		_adminTasks = adminTasks;

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setAdminTasks", String.class);

				method.invoke(_eOnBoardingRemoteModel, adminTasks);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAdminStatus() {
		return _adminStatus;
	}

	@Override
	public void setAdminStatus(String adminStatus) {
		_adminStatus = adminStatus;

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setAdminStatus", String.class);

				method.invoke(_eOnBoardingRemoteModel, adminStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAdminComments() {
		return _adminComments;
	}

	@Override
	public void setAdminComments(String adminComments) {
		_adminComments = adminComments;

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setAdminComments", String.class);

				method.invoke(_eOnBoardingRemoteModel, adminComments);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSecurityTasks() {
		return _securityTasks;
	}

	@Override
	public void setSecurityTasks(String securityTasks) {
		_securityTasks = securityTasks;

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setSecurityTasks", String.class);

				method.invoke(_eOnBoardingRemoteModel, securityTasks);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSecurityStatus() {
		return _securityStatus;
	}

	@Override
	public void setSecurityStatus(String securityStatus) {
		_securityStatus = securityStatus;

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setSecurityStatus",
						String.class);

				method.invoke(_eOnBoardingRemoteModel, securityStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSecurityComments() {
		return _securityComments;
	}

	@Override
	public void setSecurityComments(String securityComments) {
		_securityComments = securityComments;

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setSecurityComments",
						String.class);

				method.invoke(_eOnBoardingRemoteModel, securityComments);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getItpTasks() {
		return _itpTasks;
	}

	@Override
	public void setItpTasks(String itpTasks) {
		_itpTasks = itpTasks;

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setItpTasks", String.class);

				method.invoke(_eOnBoardingRemoteModel, itpTasks);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getItpStatus() {
		return _itpStatus;
	}

	@Override
	public void setItpStatus(String itpStatus) {
		_itpStatus = itpStatus;

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setItpStatus", String.class);

				method.invoke(_eOnBoardingRemoteModel, itpStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIptComments() {
		return _iptComments;
	}

	@Override
	public void setIptComments(String iptComments) {
		_iptComments = iptComments;

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setIptComments", String.class);

				method.invoke(_eOnBoardingRemoteModel, iptComments);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFinanceTasks() {
		return _financeTasks;
	}

	@Override
	public void setFinanceTasks(String financeTasks) {
		_financeTasks = financeTasks;

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setFinanceTasks", String.class);

				method.invoke(_eOnBoardingRemoteModel, financeTasks);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFinanceStatus() {
		return _financeStatus;
	}

	@Override
	public void setFinanceStatus(String financeStatus) {
		_financeStatus = financeStatus;

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setFinanceStatus", String.class);

				method.invoke(_eOnBoardingRemoteModel, financeStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFinanceComments() {
		return _financeComments;
	}

	@Override
	public void setFinanceComments(String financeComments) {
		_financeComments = financeComments;

		if (_eOnBoardingRemoteModel != null) {
			try {
				Class<?> clazz = _eOnBoardingRemoteModel.getClass();

				Method method = clazz.getMethod("setFinanceComments",
						String.class);

				method.invoke(_eOnBoardingRemoteModel, financeComments);
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

	public BaseModel<?> getEOnBoardingRemoteModel() {
		return _eOnBoardingRemoteModel;
	}

	public void setEOnBoardingRemoteModel(BaseModel<?> eOnBoardingRemoteModel) {
		_eOnBoardingRemoteModel = eOnBoardingRemoteModel;
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

		Class<?> remoteModelClass = _eOnBoardingRemoteModel.getClass();

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

		Object returnValue = method.invoke(_eOnBoardingRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EOnBoardingLocalServiceUtil.addEOnBoarding(this);
		}
		else {
			EOnBoardingLocalServiceUtil.updateEOnBoarding(this);
		}
	}

	@Override
	public EOnBoarding toEscapedModel() {
		return (EOnBoarding)ProxyUtil.newProxyInstance(EOnBoarding.class.getClassLoader(),
			new Class[] { EOnBoarding.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EOnBoardingClp clone = new EOnBoardingClp();

		clone.setEOnBoardingId(getEOnBoardingId());
		clone.setTicketNo(getTicketNo());
		clone.setProcessType(getProcessType());
		clone.setSubType(getSubType());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setSubmittedDate(getSubmittedDate());
		clone.setModifiedUserId(getModifiedUserId());
		clone.setModifiedUserName(getModifiedUserName());
		clone.setStatus(getStatus());
		clone.setStatusByUserId(getStatusByUserId());
		clone.setStatusByUserName(getStatusByUserName());
		clone.setStatusDate(getStatusDate());
		clone.setStaffCode(getStaffCode());
		clone.setLastName(getLastName());
		clone.setFirstName(getFirstName());
		clone.setName(getName());
		clone.setGender(getGender());
		clone.setBirthday(getBirthday());
		clone.setPhotoPath(getPhotoPath());
		clone.setContractType(getContractType());
		clone.setWorkLocation(getWorkLocation());
		clone.setDivision(getDivision());
		clone.setOfficeSite(getOfficeSite());
		clone.setDepartment(getDepartment());
		clone.setStartingDate(getStartingDate());
		clone.setPositionCode(getPositionCode());
		clone.setServiceLength(getServiceLength());
		clone.setFunctionName(getFunctionName());
		clone.setReportTo(getReportTo());
		clone.setReportToStaffName(getReportToStaffName());
		clone.setTitle(getTitle());
		clone.setCostCenter(getCostCenter());
		clone.setItRelatedHardware(getItRelatedHardware());
		clone.setCompanyCar(getCompanyCar());
		clone.setReplacement(getReplacement());
		clone.setNameOfReplacedPerson(getNameOfReplacedPerson());
		clone.setContactInfo(getContactInfo());
		clone.setComments(getComments());
		clone.setIsApplicantAgent(getIsApplicantAgent());
		clone.setIsApproverAgent(getIsApproverAgent());
		clone.setAdminEntitlement(getAdminEntitlement());
		clone.setAdminSeatNo(getAdminSeatNo());
		clone.setAdminTasks(getAdminTasks());
		clone.setAdminStatus(getAdminStatus());
		clone.setAdminComments(getAdminComments());
		clone.setSecurityTasks(getSecurityTasks());
		clone.setSecurityStatus(getSecurityStatus());
		clone.setSecurityComments(getSecurityComments());
		clone.setItpTasks(getItpTasks());
		clone.setItpStatus(getItpStatus());
		clone.setIptComments(getIptComments());
		clone.setFinanceTasks(getFinanceTasks());
		clone.setFinanceStatus(getFinanceStatus());
		clone.setFinanceComments(getFinanceComments());

		return clone;
	}

	@Override
	public int compareTo(EOnBoarding eOnBoarding) {
		long primaryKey = eOnBoarding.getPrimaryKey();

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

		if (!(obj instanceof EOnBoardingClp)) {
			return false;
		}

		EOnBoardingClp eOnBoarding = (EOnBoardingClp)obj;

		long primaryKey = eOnBoarding.getPrimaryKey();

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
		StringBundler sb = new StringBundler(119);

		sb.append("{eOnBoardingId=");
		sb.append(getEOnBoardingId());
		sb.append(", ticketNo=");
		sb.append(getTicketNo());
		sb.append(", processType=");
		sb.append(getProcessType());
		sb.append(", subType=");
		sb.append(getSubType());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
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
		sb.append(", modifiedUserId=");
		sb.append(getModifiedUserId());
		sb.append(", modifiedUserName=");
		sb.append(getModifiedUserName());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", statusByUserId=");
		sb.append(getStatusByUserId());
		sb.append(", statusByUserName=");
		sb.append(getStatusByUserName());
		sb.append(", statusDate=");
		sb.append(getStatusDate());
		sb.append(", staffCode=");
		sb.append(getStaffCode());
		sb.append(", lastName=");
		sb.append(getLastName());
		sb.append(", firstName=");
		sb.append(getFirstName());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", gender=");
		sb.append(getGender());
		sb.append(", birthday=");
		sb.append(getBirthday());
		sb.append(", photoPath=");
		sb.append(getPhotoPath());
		sb.append(", contractType=");
		sb.append(getContractType());
		sb.append(", workLocation=");
		sb.append(getWorkLocation());
		sb.append(", division=");
		sb.append(getDivision());
		sb.append(", officeSite=");
		sb.append(getOfficeSite());
		sb.append(", department=");
		sb.append(getDepartment());
		sb.append(", startingDate=");
		sb.append(getStartingDate());
		sb.append(", positionCode=");
		sb.append(getPositionCode());
		sb.append(", serviceLength=");
		sb.append(getServiceLength());
		sb.append(", functionName=");
		sb.append(getFunctionName());
		sb.append(", reportTo=");
		sb.append(getReportTo());
		sb.append(", reportToStaffName=");
		sb.append(getReportToStaffName());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", costCenter=");
		sb.append(getCostCenter());
		sb.append(", itRelatedHardware=");
		sb.append(getItRelatedHardware());
		sb.append(", companyCar=");
		sb.append(getCompanyCar());
		sb.append(", replacement=");
		sb.append(getReplacement());
		sb.append(", nameOfReplacedPerson=");
		sb.append(getNameOfReplacedPerson());
		sb.append(", contactInfo=");
		sb.append(getContactInfo());
		sb.append(", comments=");
		sb.append(getComments());
		sb.append(", isApplicantAgent=");
		sb.append(getIsApplicantAgent());
		sb.append(", isApproverAgent=");
		sb.append(getIsApproverAgent());
		sb.append(", adminEntitlement=");
		sb.append(getAdminEntitlement());
		sb.append(", adminSeatNo=");
		sb.append(getAdminSeatNo());
		sb.append(", adminTasks=");
		sb.append(getAdminTasks());
		sb.append(", adminStatus=");
		sb.append(getAdminStatus());
		sb.append(", adminComments=");
		sb.append(getAdminComments());
		sb.append(", securityTasks=");
		sb.append(getSecurityTasks());
		sb.append(", securityStatus=");
		sb.append(getSecurityStatus());
		sb.append(", securityComments=");
		sb.append(getSecurityComments());
		sb.append(", itpTasks=");
		sb.append(getItpTasks());
		sb.append(", itpStatus=");
		sb.append(getItpStatus());
		sb.append(", iptComments=");
		sb.append(getIptComments());
		sb.append(", financeTasks=");
		sb.append(getFinanceTasks());
		sb.append(", financeStatus=");
		sb.append(getFinanceStatus());
		sb.append(", financeComments=");
		sb.append(getFinanceComments());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(181);

		sb.append("<model><model-name>");
		sb.append("com.e.onboarding.model.EOnBoarding");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>eOnBoardingId</column-name><column-value><![CDATA[");
		sb.append(getEOnBoardingId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ticketNo</column-name><column-value><![CDATA[");
		sb.append(getTicketNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>processType</column-name><column-value><![CDATA[");
		sb.append(getProcessType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subType</column-name><column-value><![CDATA[");
		sb.append(getSubType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
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
			"<column><column-name>modifiedUserId</column-name><column-value><![CDATA[");
		sb.append(getModifiedUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedUserName</column-name><column-value><![CDATA[");
		sb.append(getModifiedUserName());
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
			"<column><column-name>statusDate</column-name><column-value><![CDATA[");
		sb.append(getStatusDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>staffCode</column-name><column-value><![CDATA[");
		sb.append(getStaffCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastName</column-name><column-value><![CDATA[");
		sb.append(getLastName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firstName</column-name><column-value><![CDATA[");
		sb.append(getFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gender</column-name><column-value><![CDATA[");
		sb.append(getGender());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>birthday</column-name><column-value><![CDATA[");
		sb.append(getBirthday());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>photoPath</column-name><column-value><![CDATA[");
		sb.append(getPhotoPath());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contractType</column-name><column-value><![CDATA[");
		sb.append(getContractType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>workLocation</column-name><column-value><![CDATA[");
		sb.append(getWorkLocation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>division</column-name><column-value><![CDATA[");
		sb.append(getDivision());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>officeSite</column-name><column-value><![CDATA[");
		sb.append(getOfficeSite());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>department</column-name><column-value><![CDATA[");
		sb.append(getDepartment());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startingDate</column-name><column-value><![CDATA[");
		sb.append(getStartingDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>positionCode</column-name><column-value><![CDATA[");
		sb.append(getPositionCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceLength</column-name><column-value><![CDATA[");
		sb.append(getServiceLength());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>functionName</column-name><column-value><![CDATA[");
		sb.append(getFunctionName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reportTo</column-name><column-value><![CDATA[");
		sb.append(getReportTo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reportToStaffName</column-name><column-value><![CDATA[");
		sb.append(getReportToStaffName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>costCenter</column-name><column-value><![CDATA[");
		sb.append(getCostCenter());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itRelatedHardware</column-name><column-value><![CDATA[");
		sb.append(getItRelatedHardware());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyCar</column-name><column-value><![CDATA[");
		sb.append(getCompanyCar());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>replacement</column-name><column-value><![CDATA[");
		sb.append(getReplacement());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nameOfReplacedPerson</column-name><column-value><![CDATA[");
		sb.append(getNameOfReplacedPerson());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactInfo</column-name><column-value><![CDATA[");
		sb.append(getContactInfo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>comments</column-name><column-value><![CDATA[");
		sb.append(getComments());
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
			"<column><column-name>adminEntitlement</column-name><column-value><![CDATA[");
		sb.append(getAdminEntitlement());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>adminSeatNo</column-name><column-value><![CDATA[");
		sb.append(getAdminSeatNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>adminTasks</column-name><column-value><![CDATA[");
		sb.append(getAdminTasks());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>adminStatus</column-name><column-value><![CDATA[");
		sb.append(getAdminStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>adminComments</column-name><column-value><![CDATA[");
		sb.append(getAdminComments());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>securityTasks</column-name><column-value><![CDATA[");
		sb.append(getSecurityTasks());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>securityStatus</column-name><column-value><![CDATA[");
		sb.append(getSecurityStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>securityComments</column-name><column-value><![CDATA[");
		sb.append(getSecurityComments());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itpTasks</column-name><column-value><![CDATA[");
		sb.append(getItpTasks());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itpStatus</column-name><column-value><![CDATA[");
		sb.append(getItpStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>iptComments</column-name><column-value><![CDATA[");
		sb.append(getIptComments());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>financeTasks</column-name><column-value><![CDATA[");
		sb.append(getFinanceTasks());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>financeStatus</column-name><column-value><![CDATA[");
		sb.append(getFinanceStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>financeComments</column-name><column-value><![CDATA[");
		sb.append(getFinanceComments());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _eOnBoardingId;
	private String _ticketNo;
	private String _processType;
	private String _subType;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _submittedDate;
	private long _modifiedUserId;
	private String _modifiedUserUuid;
	private String _modifiedUserName;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserUuid;
	private String _statusByUserName;
	private Date _statusDate;
	private String _staffCode;
	private String _lastName;
	private String _firstName;
	private String _name;
	private String _gender;
	private Date _birthday;
	private String _photoPath;
	private String _contractType;
	private String _workLocation;
	private String _division;
	private String _officeSite;
	private String _department;
	private Date _startingDate;
	private String _positionCode;
	private String _serviceLength;
	private String _functionName;
	private String _reportTo;
	private String _reportToStaffName;
	private String _title;
	private String _costCenter;
	private boolean _itRelatedHardware;
	private boolean _companyCar;
	private boolean _replacement;
	private String _nameOfReplacedPerson;
	private String _contactInfo;
	private String _comments;
	private boolean _isApplicantAgent;
	private boolean _isApproverAgent;
	private String _adminEntitlement;
	private String _adminSeatNo;
	private String _adminTasks;
	private String _adminStatus;
	private String _adminComments;
	private String _securityTasks;
	private String _securityStatus;
	private String _securityComments;
	private String _itpTasks;
	private String _itpStatus;
	private String _iptComments;
	private String _financeTasks;
	private String _financeStatus;
	private String _financeComments;
	private BaseModel<?> _eOnBoardingRemoteModel;
	private Class<?> _clpSerializerClass = com.e.onboarding.service.ClpSerializer.class;
}