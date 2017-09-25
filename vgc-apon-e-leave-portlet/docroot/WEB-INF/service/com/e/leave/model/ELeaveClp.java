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

import com.e.leave.service.ClpSerializer;
import com.e.leave.service.ELeaveLocalServiceUtil;

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
 * @author EZEYIFE
 */
public class ELeaveClp extends BaseModelImpl<ELeave> implements ELeave {
	public ELeaveClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ELeave.class;
	}

	@Override
	public String getModelClassName() {
		return ELeave.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _eLeaveId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setELeaveId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _eLeaveId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("eLeaveId", getELeaveId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("companyId", getCompanyId());
		attributes.put("ticketNo", getTicketNo());
		attributes.put("staffName", getStaffName());
		attributes.put("staffCode", getStaffCode());
		attributes.put("company", getCompany());
		attributes.put("division", getDivision());
		attributes.put("department", getDepartment());
		attributes.put("costCenter", getCostCenter());
		attributes.put("officePhone", getOfficePhone());
		attributes.put("mobilePhone", getMobilePhone());
		attributes.put("email", getEmail());
		attributes.put("positionType", getPositionType());
		attributes.put("isApplicantAgent", getIsApplicantAgent());
		attributes.put("isApproverAgent", getIsApproverAgent());
		attributes.put("processType", getProcessType());
		attributes.put("subProcessType", getSubProcessType());
		attributes.put("submittedDate", getSubmittedDate());
		attributes.put("comments", getComments());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("totalLeaveEntitlement", getTotalLeaveEntitlement());
		attributes.put("totalDuration", getTotalDuration());
		attributes.put("remainingLeaveDaysBefore", getRemainingLeaveDaysBefore());
		attributes.put("remainingLeaveDaysAfter", getRemainingLeaveDaysAfter());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long eLeaveId = (Long)attributes.get("eLeaveId");

		if (eLeaveId != null) {
			setELeaveId(eLeaveId);
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

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String ticketNo = (String)attributes.get("ticketNo");

		if (ticketNo != null) {
			setTicketNo(ticketNo);
		}

		String staffName = (String)attributes.get("staffName");

		if (staffName != null) {
			setStaffName(staffName);
		}

		String staffCode = (String)attributes.get("staffCode");

		if (staffCode != null) {
			setStaffCode(staffCode);
		}

		String company = (String)attributes.get("company");

		if (company != null) {
			setCompany(company);
		}

		String division = (String)attributes.get("division");

		if (division != null) {
			setDivision(division);
		}

		String department = (String)attributes.get("department");

		if (department != null) {
			setDepartment(department);
		}

		String costCenter = (String)attributes.get("costCenter");

		if (costCenter != null) {
			setCostCenter(costCenter);
		}

		String officePhone = (String)attributes.get("officePhone");

		if (officePhone != null) {
			setOfficePhone(officePhone);
		}

		String mobilePhone = (String)attributes.get("mobilePhone");

		if (mobilePhone != null) {
			setMobilePhone(mobilePhone);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String positionType = (String)attributes.get("positionType");

		if (positionType != null) {
			setPositionType(positionType);
		}

		Boolean isApplicantAgent = (Boolean)attributes.get("isApplicantAgent");

		if (isApplicantAgent != null) {
			setIsApplicantAgent(isApplicantAgent);
		}

		Boolean isApproverAgent = (Boolean)attributes.get("isApproverAgent");

		if (isApproverAgent != null) {
			setIsApproverAgent(isApproverAgent);
		}

		String processType = (String)attributes.get("processType");

		if (processType != null) {
			setProcessType(processType);
		}

		String subProcessType = (String)attributes.get("subProcessType");

		if (subProcessType != null) {
			setSubProcessType(subProcessType);
		}

		Date submittedDate = (Date)attributes.get("submittedDate");

		if (submittedDate != null) {
			setSubmittedDate(submittedDate);
		}

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
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

		String totalLeaveEntitlement = (String)attributes.get(
				"totalLeaveEntitlement");

		if (totalLeaveEntitlement != null) {
			setTotalLeaveEntitlement(totalLeaveEntitlement);
		}

		String totalDuration = (String)attributes.get("totalDuration");

		if (totalDuration != null) {
			setTotalDuration(totalDuration);
		}

		String remainingLeaveDaysBefore = (String)attributes.get(
				"remainingLeaveDaysBefore");

		if (remainingLeaveDaysBefore != null) {
			setRemainingLeaveDaysBefore(remainingLeaveDaysBefore);
		}

		String remainingLeaveDaysAfter = (String)attributes.get(
				"remainingLeaveDaysAfter");

		if (remainingLeaveDaysAfter != null) {
			setRemainingLeaveDaysAfter(remainingLeaveDaysAfter);
		}
	}

	@Override
	public long getELeaveId() {
		return _eLeaveId;
	}

	@Override
	public void setELeaveId(long eLeaveId) {
		_eLeaveId = eLeaveId;

		if (_eLeaveRemoteModel != null) {
			try {
				Class<?> clazz = _eLeaveRemoteModel.getClass();

				Method method = clazz.getMethod("setELeaveId", long.class);

				method.invoke(_eLeaveRemoteModel, eLeaveId);
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

		if (_eLeaveRemoteModel != null) {
			try {
				Class<?> clazz = _eLeaveRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_eLeaveRemoteModel, groupId);
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

		if (_eLeaveRemoteModel != null) {
			try {
				Class<?> clazz = _eLeaveRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_eLeaveRemoteModel, userId);
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

		if (_eLeaveRemoteModel != null) {
			try {
				Class<?> clazz = _eLeaveRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_eLeaveRemoteModel, userName);
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

		if (_eLeaveRemoteModel != null) {
			try {
				Class<?> clazz = _eLeaveRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_eLeaveRemoteModel, createDate);
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

		if (_eLeaveRemoteModel != null) {
			try {
				Class<?> clazz = _eLeaveRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_eLeaveRemoteModel, modifiedDate);
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

		if (_eLeaveRemoteModel != null) {
			try {
				Class<?> clazz = _eLeaveRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_eLeaveRemoteModel, companyId);
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

		if (_eLeaveRemoteModel != null) {
			try {
				Class<?> clazz = _eLeaveRemoteModel.getClass();

				Method method = clazz.getMethod("setTicketNo", String.class);

				method.invoke(_eLeaveRemoteModel, ticketNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStaffName() {
		return _staffName;
	}

	@Override
	public void setStaffName(String staffName) {
		_staffName = staffName;

		if (_eLeaveRemoteModel != null) {
			try {
				Class<?> clazz = _eLeaveRemoteModel.getClass();

				Method method = clazz.getMethod("setStaffName", String.class);

				method.invoke(_eLeaveRemoteModel, staffName);
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

		if (_eLeaveRemoteModel != null) {
			try {
				Class<?> clazz = _eLeaveRemoteModel.getClass();

				Method method = clazz.getMethod("setStaffCode", String.class);

				method.invoke(_eLeaveRemoteModel, staffCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCompany() {
		return _company;
	}

	@Override
	public void setCompany(String company) {
		_company = company;

		if (_eLeaveRemoteModel != null) {
			try {
				Class<?> clazz = _eLeaveRemoteModel.getClass();

				Method method = clazz.getMethod("setCompany", String.class);

				method.invoke(_eLeaveRemoteModel, company);
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

		if (_eLeaveRemoteModel != null) {
			try {
				Class<?> clazz = _eLeaveRemoteModel.getClass();

				Method method = clazz.getMethod("setDivision", String.class);

				method.invoke(_eLeaveRemoteModel, division);
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

		if (_eLeaveRemoteModel != null) {
			try {
				Class<?> clazz = _eLeaveRemoteModel.getClass();

				Method method = clazz.getMethod("setDepartment", String.class);

				method.invoke(_eLeaveRemoteModel, department);
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

		if (_eLeaveRemoteModel != null) {
			try {
				Class<?> clazz = _eLeaveRemoteModel.getClass();

				Method method = clazz.getMethod("setCostCenter", String.class);

				method.invoke(_eLeaveRemoteModel, costCenter);
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

		if (_eLeaveRemoteModel != null) {
			try {
				Class<?> clazz = _eLeaveRemoteModel.getClass();

				Method method = clazz.getMethod("setOfficePhone", String.class);

				method.invoke(_eLeaveRemoteModel, officePhone);
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

		if (_eLeaveRemoteModel != null) {
			try {
				Class<?> clazz = _eLeaveRemoteModel.getClass();

				Method method = clazz.getMethod("setMobilePhone", String.class);

				method.invoke(_eLeaveRemoteModel, mobilePhone);
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

		if (_eLeaveRemoteModel != null) {
			try {
				Class<?> clazz = _eLeaveRemoteModel.getClass();

				Method method = clazz.getMethod("setEmail", String.class);

				method.invoke(_eLeaveRemoteModel, email);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPositionType() {
		return _positionType;
	}

	@Override
	public void setPositionType(String positionType) {
		_positionType = positionType;

		if (_eLeaveRemoteModel != null) {
			try {
				Class<?> clazz = _eLeaveRemoteModel.getClass();

				Method method = clazz.getMethod("setPositionType", String.class);

				method.invoke(_eLeaveRemoteModel, positionType);
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

		if (_eLeaveRemoteModel != null) {
			try {
				Class<?> clazz = _eLeaveRemoteModel.getClass();

				Method method = clazz.getMethod("setIsApplicantAgent",
						boolean.class);

				method.invoke(_eLeaveRemoteModel, isApplicantAgent);
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

		if (_eLeaveRemoteModel != null) {
			try {
				Class<?> clazz = _eLeaveRemoteModel.getClass();

				Method method = clazz.getMethod("setIsApproverAgent",
						boolean.class);

				method.invoke(_eLeaveRemoteModel, isApproverAgent);
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

		if (_eLeaveRemoteModel != null) {
			try {
				Class<?> clazz = _eLeaveRemoteModel.getClass();

				Method method = clazz.getMethod("setProcessType", String.class);

				method.invoke(_eLeaveRemoteModel, processType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSubProcessType() {
		return _subProcessType;
	}

	@Override
	public void setSubProcessType(String subProcessType) {
		_subProcessType = subProcessType;

		if (_eLeaveRemoteModel != null) {
			try {
				Class<?> clazz = _eLeaveRemoteModel.getClass();

				Method method = clazz.getMethod("setSubProcessType",
						String.class);

				method.invoke(_eLeaveRemoteModel, subProcessType);
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

		if (_eLeaveRemoteModel != null) {
			try {
				Class<?> clazz = _eLeaveRemoteModel.getClass();

				Method method = clazz.getMethod("setSubmittedDate", Date.class);

				method.invoke(_eLeaveRemoteModel, submittedDate);
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

		if (_eLeaveRemoteModel != null) {
			try {
				Class<?> clazz = _eLeaveRemoteModel.getClass();

				Method method = clazz.getMethod("setComments", String.class);

				method.invoke(_eLeaveRemoteModel, comments);
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

		if (_eLeaveRemoteModel != null) {
			try {
				Class<?> clazz = _eLeaveRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_eLeaveRemoteModel, status);
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

		if (_eLeaveRemoteModel != null) {
			try {
				Class<?> clazz = _eLeaveRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusByUserId", long.class);

				method.invoke(_eLeaveRemoteModel, statusByUserId);
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

		if (_eLeaveRemoteModel != null) {
			try {
				Class<?> clazz = _eLeaveRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusByUserName",
						String.class);

				method.invoke(_eLeaveRemoteModel, statusByUserName);
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

		if (_eLeaveRemoteModel != null) {
			try {
				Class<?> clazz = _eLeaveRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusDate", Date.class);

				method.invoke(_eLeaveRemoteModel, statusDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTotalLeaveEntitlement() {
		return _totalLeaveEntitlement;
	}

	@Override
	public void setTotalLeaveEntitlement(String totalLeaveEntitlement) {
		_totalLeaveEntitlement = totalLeaveEntitlement;

		if (_eLeaveRemoteModel != null) {
			try {
				Class<?> clazz = _eLeaveRemoteModel.getClass();

				Method method = clazz.getMethod("setTotalLeaveEntitlement",
						String.class);

				method.invoke(_eLeaveRemoteModel, totalLeaveEntitlement);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTotalDuration() {
		return _totalDuration;
	}

	@Override
	public void setTotalDuration(String totalDuration) {
		_totalDuration = totalDuration;

		if (_eLeaveRemoteModel != null) {
			try {
				Class<?> clazz = _eLeaveRemoteModel.getClass();

				Method method = clazz.getMethod("setTotalDuration", String.class);

				method.invoke(_eLeaveRemoteModel, totalDuration);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRemainingLeaveDaysBefore() {
		return _remainingLeaveDaysBefore;
	}

	@Override
	public void setRemainingLeaveDaysBefore(String remainingLeaveDaysBefore) {
		_remainingLeaveDaysBefore = remainingLeaveDaysBefore;

		if (_eLeaveRemoteModel != null) {
			try {
				Class<?> clazz = _eLeaveRemoteModel.getClass();

				Method method = clazz.getMethod("setRemainingLeaveDaysBefore",
						String.class);

				method.invoke(_eLeaveRemoteModel, remainingLeaveDaysBefore);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRemainingLeaveDaysAfter() {
		return _remainingLeaveDaysAfter;
	}

	@Override
	public void setRemainingLeaveDaysAfter(String remainingLeaveDaysAfter) {
		_remainingLeaveDaysAfter = remainingLeaveDaysAfter;

		if (_eLeaveRemoteModel != null) {
			try {
				Class<?> clazz = _eLeaveRemoteModel.getClass();

				Method method = clazz.getMethod("setRemainingLeaveDaysAfter",
						String.class);

				method.invoke(_eLeaveRemoteModel, remainingLeaveDaysAfter);
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

	public BaseModel<?> getELeaveRemoteModel() {
		return _eLeaveRemoteModel;
	}

	public void setELeaveRemoteModel(BaseModel<?> eLeaveRemoteModel) {
		_eLeaveRemoteModel = eLeaveRemoteModel;
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

		Class<?> remoteModelClass = _eLeaveRemoteModel.getClass();

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

		Object returnValue = method.invoke(_eLeaveRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ELeaveLocalServiceUtil.addELeave(this);
		}
		else {
			ELeaveLocalServiceUtil.updateELeave(this);
		}
	}

	@Override
	public ELeave toEscapedModel() {
		return (ELeave)ProxyUtil.newProxyInstance(ELeave.class.getClassLoader(),
			new Class[] { ELeave.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ELeaveClp clone = new ELeaveClp();

		clone.setELeaveId(getELeaveId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setCompanyId(getCompanyId());
		clone.setTicketNo(getTicketNo());
		clone.setStaffName(getStaffName());
		clone.setStaffCode(getStaffCode());
		clone.setCompany(getCompany());
		clone.setDivision(getDivision());
		clone.setDepartment(getDepartment());
		clone.setCostCenter(getCostCenter());
		clone.setOfficePhone(getOfficePhone());
		clone.setMobilePhone(getMobilePhone());
		clone.setEmail(getEmail());
		clone.setPositionType(getPositionType());
		clone.setIsApplicantAgent(getIsApplicantAgent());
		clone.setIsApproverAgent(getIsApproverAgent());
		clone.setProcessType(getProcessType());
		clone.setSubProcessType(getSubProcessType());
		clone.setSubmittedDate(getSubmittedDate());
		clone.setComments(getComments());
		clone.setStatus(getStatus());
		clone.setStatusByUserId(getStatusByUserId());
		clone.setStatusByUserName(getStatusByUserName());
		clone.setStatusDate(getStatusDate());
		clone.setTotalLeaveEntitlement(getTotalLeaveEntitlement());
		clone.setTotalDuration(getTotalDuration());
		clone.setRemainingLeaveDaysBefore(getRemainingLeaveDaysBefore());
		clone.setRemainingLeaveDaysAfter(getRemainingLeaveDaysAfter());

		return clone;
	}

	@Override
	public int compareTo(ELeave eLeave) {
		int value = 0;

		if (getELeaveId() < eLeave.getELeaveId()) {
			value = -1;
		}
		else if (getELeaveId() > eLeave.getELeaveId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ELeaveClp)) {
			return false;
		}

		ELeaveClp eLeave = (ELeaveClp)obj;

		long primaryKey = eLeave.getPrimaryKey();

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
		StringBundler sb = new StringBundler(65);

		sb.append("{eLeaveId=");
		sb.append(getELeaveId());
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
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", ticketNo=");
		sb.append(getTicketNo());
		sb.append(", staffName=");
		sb.append(getStaffName());
		sb.append(", staffCode=");
		sb.append(getStaffCode());
		sb.append(", company=");
		sb.append(getCompany());
		sb.append(", division=");
		sb.append(getDivision());
		sb.append(", department=");
		sb.append(getDepartment());
		sb.append(", costCenter=");
		sb.append(getCostCenter());
		sb.append(", officePhone=");
		sb.append(getOfficePhone());
		sb.append(", mobilePhone=");
		sb.append(getMobilePhone());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", positionType=");
		sb.append(getPositionType());
		sb.append(", isApplicantAgent=");
		sb.append(getIsApplicantAgent());
		sb.append(", isApproverAgent=");
		sb.append(getIsApproverAgent());
		sb.append(", processType=");
		sb.append(getProcessType());
		sb.append(", subProcessType=");
		sb.append(getSubProcessType());
		sb.append(", submittedDate=");
		sb.append(getSubmittedDate());
		sb.append(", comments=");
		sb.append(getComments());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", statusByUserId=");
		sb.append(getStatusByUserId());
		sb.append(", statusByUserName=");
		sb.append(getStatusByUserName());
		sb.append(", statusDate=");
		sb.append(getStatusDate());
		sb.append(", totalLeaveEntitlement=");
		sb.append(getTotalLeaveEntitlement());
		sb.append(", totalDuration=");
		sb.append(getTotalDuration());
		sb.append(", remainingLeaveDaysBefore=");
		sb.append(getRemainingLeaveDaysBefore());
		sb.append(", remainingLeaveDaysAfter=");
		sb.append(getRemainingLeaveDaysAfter());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(100);

		sb.append("<model><model-name>");
		sb.append("com.e.leave.model.ELeave");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>eLeaveId</column-name><column-value><![CDATA[");
		sb.append(getELeaveId());
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
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ticketNo</column-name><column-value><![CDATA[");
		sb.append(getTicketNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>staffName</column-name><column-value><![CDATA[");
		sb.append(getStaffName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>staffCode</column-name><column-value><![CDATA[");
		sb.append(getStaffCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>company</column-name><column-value><![CDATA[");
		sb.append(getCompany());
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
			"<column><column-name>costCenter</column-name><column-value><![CDATA[");
		sb.append(getCostCenter());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>officePhone</column-name><column-value><![CDATA[");
		sb.append(getOfficePhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mobilePhone</column-name><column-value><![CDATA[");
		sb.append(getMobilePhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>positionType</column-name><column-value><![CDATA[");
		sb.append(getPositionType());
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
			"<column><column-name>processType</column-name><column-value><![CDATA[");
		sb.append(getProcessType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subProcessType</column-name><column-value><![CDATA[");
		sb.append(getSubProcessType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>submittedDate</column-name><column-value><![CDATA[");
		sb.append(getSubmittedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>comments</column-name><column-value><![CDATA[");
		sb.append(getComments());
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
			"<column><column-name>totalLeaveEntitlement</column-name><column-value><![CDATA[");
		sb.append(getTotalLeaveEntitlement());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalDuration</column-name><column-value><![CDATA[");
		sb.append(getTotalDuration());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>remainingLeaveDaysBefore</column-name><column-value><![CDATA[");
		sb.append(getRemainingLeaveDaysBefore());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>remainingLeaveDaysAfter</column-name><column-value><![CDATA[");
		sb.append(getRemainingLeaveDaysAfter());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _eLeaveId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
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
	private String _statusByUserUuid;
	private String _statusByUserName;
	private Date _statusDate;
	private String _totalLeaveEntitlement;
	private String _totalDuration;
	private String _remainingLeaveDaysBefore;
	private String _remainingLeaveDaysAfter;
	private BaseModel<?> _eLeaveRemoteModel;
	private Class<?> _clpSerializerClass = com.e.leave.service.ClpSerializer.class;
}