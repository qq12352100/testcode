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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ELeave}.
 * </p>
 *
 * @author EZEYIFE
 * @see ELeave
 * @generated
 */
public class ELeaveWrapper implements ELeave, ModelWrapper<ELeave> {
	public ELeaveWrapper(ELeave eLeave) {
		_eLeave = eLeave;
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

	/**
	* Returns the primary key of this e leave.
	*
	* @return the primary key of this e leave
	*/
	@Override
	public long getPrimaryKey() {
		return _eLeave.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e leave.
	*
	* @param primaryKey the primary key of this e leave
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_eLeave.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the e leave ID of this e leave.
	*
	* @return the e leave ID of this e leave
	*/
	@Override
	public long getELeaveId() {
		return _eLeave.getELeaveId();
	}

	/**
	* Sets the e leave ID of this e leave.
	*
	* @param eLeaveId the e leave ID of this e leave
	*/
	@Override
	public void setELeaveId(long eLeaveId) {
		_eLeave.setELeaveId(eLeaveId);
	}

	/**
	* Returns the group ID of this e leave.
	*
	* @return the group ID of this e leave
	*/
	@Override
	public long getGroupId() {
		return _eLeave.getGroupId();
	}

	/**
	* Sets the group ID of this e leave.
	*
	* @param groupId the group ID of this e leave
	*/
	@Override
	public void setGroupId(long groupId) {
		_eLeave.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this e leave.
	*
	* @return the user ID of this e leave
	*/
	@Override
	public long getUserId() {
		return _eLeave.getUserId();
	}

	/**
	* Sets the user ID of this e leave.
	*
	* @param userId the user ID of this e leave
	*/
	@Override
	public void setUserId(long userId) {
		_eLeave.setUserId(userId);
	}

	/**
	* Returns the user uuid of this e leave.
	*
	* @return the user uuid of this e leave
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eLeave.getUserUuid();
	}

	/**
	* Sets the user uuid of this e leave.
	*
	* @param userUuid the user uuid of this e leave
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_eLeave.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this e leave.
	*
	* @return the user name of this e leave
	*/
	@Override
	public java.lang.String getUserName() {
		return _eLeave.getUserName();
	}

	/**
	* Sets the user name of this e leave.
	*
	* @param userName the user name of this e leave
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_eLeave.setUserName(userName);
	}

	/**
	* Returns the create date of this e leave.
	*
	* @return the create date of this e leave
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _eLeave.getCreateDate();
	}

	/**
	* Sets the create date of this e leave.
	*
	* @param createDate the create date of this e leave
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_eLeave.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this e leave.
	*
	* @return the modified date of this e leave
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _eLeave.getModifiedDate();
	}

	/**
	* Sets the modified date of this e leave.
	*
	* @param modifiedDate the modified date of this e leave
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_eLeave.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the company ID of this e leave.
	*
	* @return the company ID of this e leave
	*/
	@Override
	public long getCompanyId() {
		return _eLeave.getCompanyId();
	}

	/**
	* Sets the company ID of this e leave.
	*
	* @param companyId the company ID of this e leave
	*/
	@Override
	public void setCompanyId(long companyId) {
		_eLeave.setCompanyId(companyId);
	}

	/**
	* Returns the ticket no of this e leave.
	*
	* @return the ticket no of this e leave
	*/
	@Override
	public java.lang.String getTicketNo() {
		return _eLeave.getTicketNo();
	}

	/**
	* Sets the ticket no of this e leave.
	*
	* @param ticketNo the ticket no of this e leave
	*/
	@Override
	public void setTicketNo(java.lang.String ticketNo) {
		_eLeave.setTicketNo(ticketNo);
	}

	/**
	* Returns the staff name of this e leave.
	*
	* @return the staff name of this e leave
	*/
	@Override
	public java.lang.String getStaffName() {
		return _eLeave.getStaffName();
	}

	/**
	* Sets the staff name of this e leave.
	*
	* @param staffName the staff name of this e leave
	*/
	@Override
	public void setStaffName(java.lang.String staffName) {
		_eLeave.setStaffName(staffName);
	}

	/**
	* Returns the staff code of this e leave.
	*
	* @return the staff code of this e leave
	*/
	@Override
	public java.lang.String getStaffCode() {
		return _eLeave.getStaffCode();
	}

	/**
	* Sets the staff code of this e leave.
	*
	* @param staffCode the staff code of this e leave
	*/
	@Override
	public void setStaffCode(java.lang.String staffCode) {
		_eLeave.setStaffCode(staffCode);
	}

	/**
	* Returns the company of this e leave.
	*
	* @return the company of this e leave
	*/
	@Override
	public java.lang.String getCompany() {
		return _eLeave.getCompany();
	}

	/**
	* Sets the company of this e leave.
	*
	* @param company the company of this e leave
	*/
	@Override
	public void setCompany(java.lang.String company) {
		_eLeave.setCompany(company);
	}

	/**
	* Returns the division of this e leave.
	*
	* @return the division of this e leave
	*/
	@Override
	public java.lang.String getDivision() {
		return _eLeave.getDivision();
	}

	/**
	* Sets the division of this e leave.
	*
	* @param division the division of this e leave
	*/
	@Override
	public void setDivision(java.lang.String division) {
		_eLeave.setDivision(division);
	}

	/**
	* Returns the department of this e leave.
	*
	* @return the department of this e leave
	*/
	@Override
	public java.lang.String getDepartment() {
		return _eLeave.getDepartment();
	}

	/**
	* Sets the department of this e leave.
	*
	* @param department the department of this e leave
	*/
	@Override
	public void setDepartment(java.lang.String department) {
		_eLeave.setDepartment(department);
	}

	/**
	* Returns the cost center of this e leave.
	*
	* @return the cost center of this e leave
	*/
	@Override
	public java.lang.String getCostCenter() {
		return _eLeave.getCostCenter();
	}

	/**
	* Sets the cost center of this e leave.
	*
	* @param costCenter the cost center of this e leave
	*/
	@Override
	public void setCostCenter(java.lang.String costCenter) {
		_eLeave.setCostCenter(costCenter);
	}

	/**
	* Returns the office phone of this e leave.
	*
	* @return the office phone of this e leave
	*/
	@Override
	public java.lang.String getOfficePhone() {
		return _eLeave.getOfficePhone();
	}

	/**
	* Sets the office phone of this e leave.
	*
	* @param officePhone the office phone of this e leave
	*/
	@Override
	public void setOfficePhone(java.lang.String officePhone) {
		_eLeave.setOfficePhone(officePhone);
	}

	/**
	* Returns the mobile phone of this e leave.
	*
	* @return the mobile phone of this e leave
	*/
	@Override
	public java.lang.String getMobilePhone() {
		return _eLeave.getMobilePhone();
	}

	/**
	* Sets the mobile phone of this e leave.
	*
	* @param mobilePhone the mobile phone of this e leave
	*/
	@Override
	public void setMobilePhone(java.lang.String mobilePhone) {
		_eLeave.setMobilePhone(mobilePhone);
	}

	/**
	* Returns the email of this e leave.
	*
	* @return the email of this e leave
	*/
	@Override
	public java.lang.String getEmail() {
		return _eLeave.getEmail();
	}

	/**
	* Sets the email of this e leave.
	*
	* @param email the email of this e leave
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_eLeave.setEmail(email);
	}

	/**
	* Returns the position type of this e leave.
	*
	* @return the position type of this e leave
	*/
	@Override
	public java.lang.String getPositionType() {
		return _eLeave.getPositionType();
	}

	/**
	* Sets the position type of this e leave.
	*
	* @param positionType the position type of this e leave
	*/
	@Override
	public void setPositionType(java.lang.String positionType) {
		_eLeave.setPositionType(positionType);
	}

	/**
	* Returns the is applicant agent of this e leave.
	*
	* @return the is applicant agent of this e leave
	*/
	@Override
	public boolean getIsApplicantAgent() {
		return _eLeave.getIsApplicantAgent();
	}

	/**
	* Returns <code>true</code> if this e leave is is applicant agent.
	*
	* @return <code>true</code> if this e leave is is applicant agent; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsApplicantAgent() {
		return _eLeave.isIsApplicantAgent();
	}

	/**
	* Sets whether this e leave is is applicant agent.
	*
	* @param isApplicantAgent the is applicant agent of this e leave
	*/
	@Override
	public void setIsApplicantAgent(boolean isApplicantAgent) {
		_eLeave.setIsApplicantAgent(isApplicantAgent);
	}

	/**
	* Returns the is approver agent of this e leave.
	*
	* @return the is approver agent of this e leave
	*/
	@Override
	public boolean getIsApproverAgent() {
		return _eLeave.getIsApproverAgent();
	}

	/**
	* Returns <code>true</code> if this e leave is is approver agent.
	*
	* @return <code>true</code> if this e leave is is approver agent; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsApproverAgent() {
		return _eLeave.isIsApproverAgent();
	}

	/**
	* Sets whether this e leave is is approver agent.
	*
	* @param isApproverAgent the is approver agent of this e leave
	*/
	@Override
	public void setIsApproverAgent(boolean isApproverAgent) {
		_eLeave.setIsApproverAgent(isApproverAgent);
	}

	/**
	* Returns the process type of this e leave.
	*
	* @return the process type of this e leave
	*/
	@Override
	public java.lang.String getProcessType() {
		return _eLeave.getProcessType();
	}

	/**
	* Sets the process type of this e leave.
	*
	* @param processType the process type of this e leave
	*/
	@Override
	public void setProcessType(java.lang.String processType) {
		_eLeave.setProcessType(processType);
	}

	/**
	* Returns the sub process type of this e leave.
	*
	* @return the sub process type of this e leave
	*/
	@Override
	public java.lang.String getSubProcessType() {
		return _eLeave.getSubProcessType();
	}

	/**
	* Sets the sub process type of this e leave.
	*
	* @param subProcessType the sub process type of this e leave
	*/
	@Override
	public void setSubProcessType(java.lang.String subProcessType) {
		_eLeave.setSubProcessType(subProcessType);
	}

	/**
	* Returns the submitted date of this e leave.
	*
	* @return the submitted date of this e leave
	*/
	@Override
	public java.util.Date getSubmittedDate() {
		return _eLeave.getSubmittedDate();
	}

	/**
	* Sets the submitted date of this e leave.
	*
	* @param submittedDate the submitted date of this e leave
	*/
	@Override
	public void setSubmittedDate(java.util.Date submittedDate) {
		_eLeave.setSubmittedDate(submittedDate);
	}

	/**
	* Returns the comments of this e leave.
	*
	* @return the comments of this e leave
	*/
	@Override
	public java.lang.String getComments() {
		return _eLeave.getComments();
	}

	/**
	* Sets the comments of this e leave.
	*
	* @param comments the comments of this e leave
	*/
	@Override
	public void setComments(java.lang.String comments) {
		_eLeave.setComments(comments);
	}

	/**
	* Returns the status of this e leave.
	*
	* @return the status of this e leave
	*/
	@Override
	public int getStatus() {
		return _eLeave.getStatus();
	}

	/**
	* Sets the status of this e leave.
	*
	* @param status the status of this e leave
	*/
	@Override
	public void setStatus(int status) {
		_eLeave.setStatus(status);
	}

	/**
	* Returns the status by user ID of this e leave.
	*
	* @return the status by user ID of this e leave
	*/
	@Override
	public long getStatusByUserId() {
		return _eLeave.getStatusByUserId();
	}

	/**
	* Sets the status by user ID of this e leave.
	*
	* @param statusByUserId the status by user ID of this e leave
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_eLeave.setStatusByUserId(statusByUserId);
	}

	/**
	* Returns the status by user uuid of this e leave.
	*
	* @return the status by user uuid of this e leave
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getStatusByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eLeave.getStatusByUserUuid();
	}

	/**
	* Sets the status by user uuid of this e leave.
	*
	* @param statusByUserUuid the status by user uuid of this e leave
	*/
	@Override
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_eLeave.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Returns the status by user name of this e leave.
	*
	* @return the status by user name of this e leave
	*/
	@Override
	public java.lang.String getStatusByUserName() {
		return _eLeave.getStatusByUserName();
	}

	/**
	* Sets the status by user name of this e leave.
	*
	* @param statusByUserName the status by user name of this e leave
	*/
	@Override
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_eLeave.setStatusByUserName(statusByUserName);
	}

	/**
	* Returns the status date of this e leave.
	*
	* @return the status date of this e leave
	*/
	@Override
	public java.util.Date getStatusDate() {
		return _eLeave.getStatusDate();
	}

	/**
	* Sets the status date of this e leave.
	*
	* @param statusDate the status date of this e leave
	*/
	@Override
	public void setStatusDate(java.util.Date statusDate) {
		_eLeave.setStatusDate(statusDate);
	}

	/**
	* Returns the total leave entitlement of this e leave.
	*
	* @return the total leave entitlement of this e leave
	*/
	@Override
	public java.lang.String getTotalLeaveEntitlement() {
		return _eLeave.getTotalLeaveEntitlement();
	}

	/**
	* Sets the total leave entitlement of this e leave.
	*
	* @param totalLeaveEntitlement the total leave entitlement of this e leave
	*/
	@Override
	public void setTotalLeaveEntitlement(java.lang.String totalLeaveEntitlement) {
		_eLeave.setTotalLeaveEntitlement(totalLeaveEntitlement);
	}

	/**
	* Returns the total duration of this e leave.
	*
	* @return the total duration of this e leave
	*/
	@Override
	public java.lang.String getTotalDuration() {
		return _eLeave.getTotalDuration();
	}

	/**
	* Sets the total duration of this e leave.
	*
	* @param totalDuration the total duration of this e leave
	*/
	@Override
	public void setTotalDuration(java.lang.String totalDuration) {
		_eLeave.setTotalDuration(totalDuration);
	}

	/**
	* Returns the remaining leave days before of this e leave.
	*
	* @return the remaining leave days before of this e leave
	*/
	@Override
	public java.lang.String getRemainingLeaveDaysBefore() {
		return _eLeave.getRemainingLeaveDaysBefore();
	}

	/**
	* Sets the remaining leave days before of this e leave.
	*
	* @param remainingLeaveDaysBefore the remaining leave days before of this e leave
	*/
	@Override
	public void setRemainingLeaveDaysBefore(
		java.lang.String remainingLeaveDaysBefore) {
		_eLeave.setRemainingLeaveDaysBefore(remainingLeaveDaysBefore);
	}

	/**
	* Returns the remaining leave days after of this e leave.
	*
	* @return the remaining leave days after of this e leave
	*/
	@Override
	public java.lang.String getRemainingLeaveDaysAfter() {
		return _eLeave.getRemainingLeaveDaysAfter();
	}

	/**
	* Sets the remaining leave days after of this e leave.
	*
	* @param remainingLeaveDaysAfter the remaining leave days after of this e leave
	*/
	@Override
	public void setRemainingLeaveDaysAfter(
		java.lang.String remainingLeaveDaysAfter) {
		_eLeave.setRemainingLeaveDaysAfter(remainingLeaveDaysAfter);
	}

	/**
	* @deprecated As of 6.1.0, replaced by {@link #isApproved()}
	*/
	@Override
	public boolean getApproved() {
		return _eLeave.getApproved();
	}

	/**
	* Returns <code>true</code> if this e leave is approved.
	*
	* @return <code>true</code> if this e leave is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _eLeave.isApproved();
	}

	/**
	* Returns <code>true</code> if this e leave is denied.
	*
	* @return <code>true</code> if this e leave is denied; <code>false</code> otherwise
	*/
	@Override
	public boolean isDenied() {
		return _eLeave.isDenied();
	}

	/**
	* Returns <code>true</code> if this e leave is a draft.
	*
	* @return <code>true</code> if this e leave is a draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _eLeave.isDraft();
	}

	/**
	* Returns <code>true</code> if this e leave is expired.
	*
	* @return <code>true</code> if this e leave is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _eLeave.isExpired();
	}

	/**
	* Returns <code>true</code> if this e leave is inactive.
	*
	* @return <code>true</code> if this e leave is inactive; <code>false</code> otherwise
	*/
	@Override
	public boolean isInactive() {
		return _eLeave.isInactive();
	}

	/**
	* Returns <code>true</code> if this e leave is incomplete.
	*
	* @return <code>true</code> if this e leave is incomplete; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncomplete() {
		return _eLeave.isIncomplete();
	}

	/**
	* Returns <code>true</code> if this e leave is pending.
	*
	* @return <code>true</code> if this e leave is pending; <code>false</code> otherwise
	*/
	@Override
	public boolean isPending() {
		return _eLeave.isPending();
	}

	/**
	* Returns <code>true</code> if this e leave is scheduled.
	*
	* @return <code>true</code> if this e leave is scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isScheduled() {
		return _eLeave.isScheduled();
	}

	@Override
	public boolean isNew() {
		return _eLeave.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_eLeave.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _eLeave.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_eLeave.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _eLeave.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _eLeave.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_eLeave.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _eLeave.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_eLeave.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_eLeave.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_eLeave.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ELeaveWrapper((ELeave)_eLeave.clone());
	}

	@Override
	public int compareTo(com.e.leave.model.ELeave eLeave) {
		return _eLeave.compareTo(eLeave);
	}

	@Override
	public int hashCode() {
		return _eLeave.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.e.leave.model.ELeave> toCacheModel() {
		return _eLeave.toCacheModel();
	}

	@Override
	public com.e.leave.model.ELeave toEscapedModel() {
		return new ELeaveWrapper(_eLeave.toEscapedModel());
	}

	@Override
	public com.e.leave.model.ELeave toUnescapedModel() {
		return new ELeaveWrapper(_eLeave.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _eLeave.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _eLeave.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_eLeave.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ELeaveWrapper)) {
			return false;
		}

		ELeaveWrapper eLeaveWrapper = (ELeaveWrapper)obj;

		if (Validator.equals(_eLeave, eLeaveWrapper._eLeave)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ELeave getWrappedELeave() {
		return _eLeave;
	}

	@Override
	public ELeave getWrappedModel() {
		return _eLeave;
	}

	@Override
	public void resetOriginalValues() {
		_eLeave.resetOriginalValues();
	}

	private ELeave _eLeave;
}