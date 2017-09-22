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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SeatOffice}.
 * </p>
 *
 * @author Alice.zou
 * @see SeatOffice
 * @generated
 */
public class SeatOfficeWrapper implements SeatOffice, ModelWrapper<SeatOffice> {
	public SeatOfficeWrapper(SeatOffice seatOffice) {
		_seatOffice = seatOffice;
	}

	@Override
	public Class<?> getModelClass() {
		return SeatOffice.class;
	}

	@Override
	public String getModelClassName() {
		return SeatOffice.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("seatId", getSeatId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("companyId", getCompanyId());
		attributes.put("ticketNo", getTicketNo());
		attributes.put("staffName", getStaffName());
		attributes.put("staffCode", getStaffCode());
		attributes.put("companyName", getCompanyName());
		attributes.put("division", getDivision());
		attributes.put("department", getDepartment());
		attributes.put("costCenter", getCostCenter());
		attributes.put("officePhone", getOfficePhone());
		attributes.put("mobilePhone", getMobilePhone());
		attributes.put("officeSite", getOfficeSite());
		attributes.put("currentCategory", getCurrentCategory());
		attributes.put("currentSeatNo", getCurrentSeatNo());
		attributes.put("movingDate", getMovingDate());
		attributes.put("expectedSeatNo", getExpectedSeatNo());
		attributes.put("reasonForChange", getReasonForChange());
		attributes.put("officeKey", getOfficeKey());
		attributes.put("plant", getPlant());
		attributes.put("telephoneAndExtNo", getTelephoneAndExtNo());
		attributes.put("namePlate", getNamePlate());
		attributes.put("cabinet", getCabinet());
		attributes.put("isOnBehalfOf", getIsOnBehalfOf());
		attributes.put("nowCategory", getNowCategory());
		attributes.put("newSeatNo", getNewSeatNo());
		attributes.put("workspaceId", getWorkspaceId());
		attributes.put("seatStatus", getSeatStatus());
		attributes.put("sg", getSg());
		attributes.put("leadingMark", getLeadingMark());
		attributes.put("positionFlag", getPositionFlag());
		attributes.put("isApplicantAgent", getIsApplicantAgent());
		attributes.put("isApproverAgent", getIsApproverAgent());
		attributes.put("candidateName", getCandidateName());
		attributes.put("desiredStartingDate", getDesiredStartingDate());
		attributes.put("comments", getComments());
		attributes.put("contractType", getContractType());
		attributes.put("processType", getProcessType());
		attributes.put("subProcessType", getSubProcessType());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long seatId = (Long)attributes.get("seatId");

		if (seatId != null) {
			setSeatId(seatId);
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

		Long staffCode = (Long)attributes.get("staffCode");

		if (staffCode != null) {
			setStaffCode(staffCode);
		}

		String companyName = (String)attributes.get("companyName");

		if (companyName != null) {
			setCompanyName(companyName);
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

		String officeSite = (String)attributes.get("officeSite");

		if (officeSite != null) {
			setOfficeSite(officeSite);
		}

		Long currentCategory = (Long)attributes.get("currentCategory");

		if (currentCategory != null) {
			setCurrentCategory(currentCategory);
		}

		String currentSeatNo = (String)attributes.get("currentSeatNo");

		if (currentSeatNo != null) {
			setCurrentSeatNo(currentSeatNo);
		}

		Date movingDate = (Date)attributes.get("movingDate");

		if (movingDate != null) {
			setMovingDate(movingDate);
		}

		String expectedSeatNo = (String)attributes.get("expectedSeatNo");

		if (expectedSeatNo != null) {
			setExpectedSeatNo(expectedSeatNo);
		}

		String reasonForChange = (String)attributes.get("reasonForChange");

		if (reasonForChange != null) {
			setReasonForChange(reasonForChange);
		}

		Boolean officeKey = (Boolean)attributes.get("officeKey");

		if (officeKey != null) {
			setOfficeKey(officeKey);
		}

		Boolean plant = (Boolean)attributes.get("plant");

		if (plant != null) {
			setPlant(plant);
		}

		Boolean telephoneAndExtNo = (Boolean)attributes.get("telephoneAndExtNo");

		if (telephoneAndExtNo != null) {
			setTelephoneAndExtNo(telephoneAndExtNo);
		}

		Boolean namePlate = (Boolean)attributes.get("namePlate");

		if (namePlate != null) {
			setNamePlate(namePlate);
		}

		Boolean cabinet = (Boolean)attributes.get("cabinet");

		if (cabinet != null) {
			setCabinet(cabinet);
		}

		Boolean isOnBehalfOf = (Boolean)attributes.get("isOnBehalfOf");

		if (isOnBehalfOf != null) {
			setIsOnBehalfOf(isOnBehalfOf);
		}

		Long nowCategory = (Long)attributes.get("nowCategory");

		if (nowCategory != null) {
			setNowCategory(nowCategory);
		}

		String newSeatNo = (String)attributes.get("newSeatNo");

		if (newSeatNo != null) {
			setNewSeatNo(newSeatNo);
		}

		Long workspaceId = (Long)attributes.get("workspaceId");

		if (workspaceId != null) {
			setWorkspaceId(workspaceId);
		}

		String seatStatus = (String)attributes.get("seatStatus");

		if (seatStatus != null) {
			setSeatStatus(seatStatus);
		}

		String sg = (String)attributes.get("sg");

		if (sg != null) {
			setSg(sg);
		}

		String leadingMark = (String)attributes.get("leadingMark");

		if (leadingMark != null) {
			setLeadingMark(leadingMark);
		}

		String positionFlag = (String)attributes.get("positionFlag");

		if (positionFlag != null) {
			setPositionFlag(positionFlag);
		}

		Boolean isApplicantAgent = (Boolean)attributes.get("isApplicantAgent");

		if (isApplicantAgent != null) {
			setIsApplicantAgent(isApplicantAgent);
		}

		Boolean isApproverAgent = (Boolean)attributes.get("isApproverAgent");

		if (isApproverAgent != null) {
			setIsApproverAgent(isApproverAgent);
		}

		String candidateName = (String)attributes.get("candidateName");

		if (candidateName != null) {
			setCandidateName(candidateName);
		}

		Date desiredStartingDate = (Date)attributes.get("desiredStartingDate");

		if (desiredStartingDate != null) {
			setDesiredStartingDate(desiredStartingDate);
		}

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
		}

		String contractType = (String)attributes.get("contractType");

		if (contractType != null) {
			setContractType(contractType);
		}

		String processType = (String)attributes.get("processType");

		if (processType != null) {
			setProcessType(processType);
		}

		String subProcessType = (String)attributes.get("subProcessType");

		if (subProcessType != null) {
			setSubProcessType(subProcessType);
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
	}

	/**
	* Returns the primary key of this seat office.
	*
	* @return the primary key of this seat office
	*/
	@Override
	public long getPrimaryKey() {
		return _seatOffice.getPrimaryKey();
	}

	/**
	* Sets the primary key of this seat office.
	*
	* @param primaryKey the primary key of this seat office
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_seatOffice.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the seat ID of this seat office.
	*
	* @return the seat ID of this seat office
	*/
	@Override
	public long getSeatId() {
		return _seatOffice.getSeatId();
	}

	/**
	* Sets the seat ID of this seat office.
	*
	* @param seatId the seat ID of this seat office
	*/
	@Override
	public void setSeatId(long seatId) {
		_seatOffice.setSeatId(seatId);
	}

	/**
	* Returns the group ID of this seat office.
	*
	* @return the group ID of this seat office
	*/
	@Override
	public long getGroupId() {
		return _seatOffice.getGroupId();
	}

	/**
	* Sets the group ID of this seat office.
	*
	* @param groupId the group ID of this seat office
	*/
	@Override
	public void setGroupId(long groupId) {
		_seatOffice.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this seat office.
	*
	* @return the user ID of this seat office
	*/
	@Override
	public long getUserId() {
		return _seatOffice.getUserId();
	}

	/**
	* Sets the user ID of this seat office.
	*
	* @param userId the user ID of this seat office
	*/
	@Override
	public void setUserId(long userId) {
		_seatOffice.setUserId(userId);
	}

	/**
	* Returns the user uuid of this seat office.
	*
	* @return the user uuid of this seat office
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _seatOffice.getUserUuid();
	}

	/**
	* Sets the user uuid of this seat office.
	*
	* @param userUuid the user uuid of this seat office
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_seatOffice.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this seat office.
	*
	* @return the user name of this seat office
	*/
	@Override
	public java.lang.String getUserName() {
		return _seatOffice.getUserName();
	}

	/**
	* Sets the user name of this seat office.
	*
	* @param userName the user name of this seat office
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_seatOffice.setUserName(userName);
	}

	/**
	* Returns the create date of this seat office.
	*
	* @return the create date of this seat office
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _seatOffice.getCreateDate();
	}

	/**
	* Sets the create date of this seat office.
	*
	* @param createDate the create date of this seat office
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_seatOffice.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this seat office.
	*
	* @return the modified date of this seat office
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _seatOffice.getModifiedDate();
	}

	/**
	* Sets the modified date of this seat office.
	*
	* @param modifiedDate the modified date of this seat office
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_seatOffice.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the company ID of this seat office.
	*
	* @return the company ID of this seat office
	*/
	@Override
	public long getCompanyId() {
		return _seatOffice.getCompanyId();
	}

	/**
	* Sets the company ID of this seat office.
	*
	* @param companyId the company ID of this seat office
	*/
	@Override
	public void setCompanyId(long companyId) {
		_seatOffice.setCompanyId(companyId);
	}

	/**
	* Returns the ticket no of this seat office.
	*
	* @return the ticket no of this seat office
	*/
	@Override
	public java.lang.String getTicketNo() {
		return _seatOffice.getTicketNo();
	}

	/**
	* Sets the ticket no of this seat office.
	*
	* @param ticketNo the ticket no of this seat office
	*/
	@Override
	public void setTicketNo(java.lang.String ticketNo) {
		_seatOffice.setTicketNo(ticketNo);
	}

	/**
	* Returns the staff name of this seat office.
	*
	* @return the staff name of this seat office
	*/
	@Override
	public java.lang.String getStaffName() {
		return _seatOffice.getStaffName();
	}

	/**
	* Sets the staff name of this seat office.
	*
	* @param staffName the staff name of this seat office
	*/
	@Override
	public void setStaffName(java.lang.String staffName) {
		_seatOffice.setStaffName(staffName);
	}

	/**
	* Returns the staff code of this seat office.
	*
	* @return the staff code of this seat office
	*/
	@Override
	public long getStaffCode() {
		return _seatOffice.getStaffCode();
	}

	/**
	* Sets the staff code of this seat office.
	*
	* @param staffCode the staff code of this seat office
	*/
	@Override
	public void setStaffCode(long staffCode) {
		_seatOffice.setStaffCode(staffCode);
	}

	/**
	* Returns the company name of this seat office.
	*
	* @return the company name of this seat office
	*/
	@Override
	public java.lang.String getCompanyName() {
		return _seatOffice.getCompanyName();
	}

	/**
	* Sets the company name of this seat office.
	*
	* @param companyName the company name of this seat office
	*/
	@Override
	public void setCompanyName(java.lang.String companyName) {
		_seatOffice.setCompanyName(companyName);
	}

	/**
	* Returns the division of this seat office.
	*
	* @return the division of this seat office
	*/
	@Override
	public java.lang.String getDivision() {
		return _seatOffice.getDivision();
	}

	/**
	* Sets the division of this seat office.
	*
	* @param division the division of this seat office
	*/
	@Override
	public void setDivision(java.lang.String division) {
		_seatOffice.setDivision(division);
	}

	/**
	* Returns the department of this seat office.
	*
	* @return the department of this seat office
	*/
	@Override
	public java.lang.String getDepartment() {
		return _seatOffice.getDepartment();
	}

	/**
	* Sets the department of this seat office.
	*
	* @param department the department of this seat office
	*/
	@Override
	public void setDepartment(java.lang.String department) {
		_seatOffice.setDepartment(department);
	}

	/**
	* Returns the cost center of this seat office.
	*
	* @return the cost center of this seat office
	*/
	@Override
	public java.lang.String getCostCenter() {
		return _seatOffice.getCostCenter();
	}

	/**
	* Sets the cost center of this seat office.
	*
	* @param costCenter the cost center of this seat office
	*/
	@Override
	public void setCostCenter(java.lang.String costCenter) {
		_seatOffice.setCostCenter(costCenter);
	}

	/**
	* Returns the office phone of this seat office.
	*
	* @return the office phone of this seat office
	*/
	@Override
	public java.lang.String getOfficePhone() {
		return _seatOffice.getOfficePhone();
	}

	/**
	* Sets the office phone of this seat office.
	*
	* @param officePhone the office phone of this seat office
	*/
	@Override
	public void setOfficePhone(java.lang.String officePhone) {
		_seatOffice.setOfficePhone(officePhone);
	}

	/**
	* Returns the mobile phone of this seat office.
	*
	* @return the mobile phone of this seat office
	*/
	@Override
	public java.lang.String getMobilePhone() {
		return _seatOffice.getMobilePhone();
	}

	/**
	* Sets the mobile phone of this seat office.
	*
	* @param mobilePhone the mobile phone of this seat office
	*/
	@Override
	public void setMobilePhone(java.lang.String mobilePhone) {
		_seatOffice.setMobilePhone(mobilePhone);
	}

	/**
	* Returns the office site of this seat office.
	*
	* @return the office site of this seat office
	*/
	@Override
	public java.lang.String getOfficeSite() {
		return _seatOffice.getOfficeSite();
	}

	/**
	* Sets the office site of this seat office.
	*
	* @param officeSite the office site of this seat office
	*/
	@Override
	public void setOfficeSite(java.lang.String officeSite) {
		_seatOffice.setOfficeSite(officeSite);
	}

	/**
	* Returns the current category of this seat office.
	*
	* @return the current category of this seat office
	*/
	@Override
	public long getCurrentCategory() {
		return _seatOffice.getCurrentCategory();
	}

	/**
	* Sets the current category of this seat office.
	*
	* @param currentCategory the current category of this seat office
	*/
	@Override
	public void setCurrentCategory(long currentCategory) {
		_seatOffice.setCurrentCategory(currentCategory);
	}

	/**
	* Returns the current seat no of this seat office.
	*
	* @return the current seat no of this seat office
	*/
	@Override
	public java.lang.String getCurrentSeatNo() {
		return _seatOffice.getCurrentSeatNo();
	}

	/**
	* Sets the current seat no of this seat office.
	*
	* @param currentSeatNo the current seat no of this seat office
	*/
	@Override
	public void setCurrentSeatNo(java.lang.String currentSeatNo) {
		_seatOffice.setCurrentSeatNo(currentSeatNo);
	}

	/**
	* Returns the moving date of this seat office.
	*
	* @return the moving date of this seat office
	*/
	@Override
	public java.util.Date getMovingDate() {
		return _seatOffice.getMovingDate();
	}

	/**
	* Sets the moving date of this seat office.
	*
	* @param movingDate the moving date of this seat office
	*/
	@Override
	public void setMovingDate(java.util.Date movingDate) {
		_seatOffice.setMovingDate(movingDate);
	}

	/**
	* Returns the expected seat no of this seat office.
	*
	* @return the expected seat no of this seat office
	*/
	@Override
	public java.lang.String getExpectedSeatNo() {
		return _seatOffice.getExpectedSeatNo();
	}

	/**
	* Sets the expected seat no of this seat office.
	*
	* @param expectedSeatNo the expected seat no of this seat office
	*/
	@Override
	public void setExpectedSeatNo(java.lang.String expectedSeatNo) {
		_seatOffice.setExpectedSeatNo(expectedSeatNo);
	}

	/**
	* Returns the reason for change of this seat office.
	*
	* @return the reason for change of this seat office
	*/
	@Override
	public java.lang.String getReasonForChange() {
		return _seatOffice.getReasonForChange();
	}

	/**
	* Sets the reason for change of this seat office.
	*
	* @param reasonForChange the reason for change of this seat office
	*/
	@Override
	public void setReasonForChange(java.lang.String reasonForChange) {
		_seatOffice.setReasonForChange(reasonForChange);
	}

	/**
	* Returns the office key of this seat office.
	*
	* @return the office key of this seat office
	*/
	@Override
	public boolean getOfficeKey() {
		return _seatOffice.getOfficeKey();
	}

	/**
	* Returns <code>true</code> if this seat office is office key.
	*
	* @return <code>true</code> if this seat office is office key; <code>false</code> otherwise
	*/
	@Override
	public boolean isOfficeKey() {
		return _seatOffice.isOfficeKey();
	}

	/**
	* Sets whether this seat office is office key.
	*
	* @param officeKey the office key of this seat office
	*/
	@Override
	public void setOfficeKey(boolean officeKey) {
		_seatOffice.setOfficeKey(officeKey);
	}

	/**
	* Returns the plant of this seat office.
	*
	* @return the plant of this seat office
	*/
	@Override
	public boolean getPlant() {
		return _seatOffice.getPlant();
	}

	/**
	* Returns <code>true</code> if this seat office is plant.
	*
	* @return <code>true</code> if this seat office is plant; <code>false</code> otherwise
	*/
	@Override
	public boolean isPlant() {
		return _seatOffice.isPlant();
	}

	/**
	* Sets whether this seat office is plant.
	*
	* @param plant the plant of this seat office
	*/
	@Override
	public void setPlant(boolean plant) {
		_seatOffice.setPlant(plant);
	}

	/**
	* Returns the telephone and ext no of this seat office.
	*
	* @return the telephone and ext no of this seat office
	*/
	@Override
	public boolean getTelephoneAndExtNo() {
		return _seatOffice.getTelephoneAndExtNo();
	}

	/**
	* Returns <code>true</code> if this seat office is telephone and ext no.
	*
	* @return <code>true</code> if this seat office is telephone and ext no; <code>false</code> otherwise
	*/
	@Override
	public boolean isTelephoneAndExtNo() {
		return _seatOffice.isTelephoneAndExtNo();
	}

	/**
	* Sets whether this seat office is telephone and ext no.
	*
	* @param telephoneAndExtNo the telephone and ext no of this seat office
	*/
	@Override
	public void setTelephoneAndExtNo(boolean telephoneAndExtNo) {
		_seatOffice.setTelephoneAndExtNo(telephoneAndExtNo);
	}

	/**
	* Returns the name plate of this seat office.
	*
	* @return the name plate of this seat office
	*/
	@Override
	public boolean getNamePlate() {
		return _seatOffice.getNamePlate();
	}

	/**
	* Returns <code>true</code> if this seat office is name plate.
	*
	* @return <code>true</code> if this seat office is name plate; <code>false</code> otherwise
	*/
	@Override
	public boolean isNamePlate() {
		return _seatOffice.isNamePlate();
	}

	/**
	* Sets whether this seat office is name plate.
	*
	* @param namePlate the name plate of this seat office
	*/
	@Override
	public void setNamePlate(boolean namePlate) {
		_seatOffice.setNamePlate(namePlate);
	}

	/**
	* Returns the cabinet of this seat office.
	*
	* @return the cabinet of this seat office
	*/
	@Override
	public boolean getCabinet() {
		return _seatOffice.getCabinet();
	}

	/**
	* Returns <code>true</code> if this seat office is cabinet.
	*
	* @return <code>true</code> if this seat office is cabinet; <code>false</code> otherwise
	*/
	@Override
	public boolean isCabinet() {
		return _seatOffice.isCabinet();
	}

	/**
	* Sets whether this seat office is cabinet.
	*
	* @param cabinet the cabinet of this seat office
	*/
	@Override
	public void setCabinet(boolean cabinet) {
		_seatOffice.setCabinet(cabinet);
	}

	/**
	* Returns the is on behalf of of this seat office.
	*
	* @return the is on behalf of of this seat office
	*/
	@Override
	public boolean getIsOnBehalfOf() {
		return _seatOffice.getIsOnBehalfOf();
	}

	/**
	* Returns <code>true</code> if this seat office is is on behalf of.
	*
	* @return <code>true</code> if this seat office is is on behalf of; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsOnBehalfOf() {
		return _seatOffice.isIsOnBehalfOf();
	}

	/**
	* Sets whether this seat office is is on behalf of.
	*
	* @param isOnBehalfOf the is on behalf of of this seat office
	*/
	@Override
	public void setIsOnBehalfOf(boolean isOnBehalfOf) {
		_seatOffice.setIsOnBehalfOf(isOnBehalfOf);
	}

	/**
	* Returns the now category of this seat office.
	*
	* @return the now category of this seat office
	*/
	@Override
	public long getNowCategory() {
		return _seatOffice.getNowCategory();
	}

	/**
	* Sets the now category of this seat office.
	*
	* @param nowCategory the now category of this seat office
	*/
	@Override
	public void setNowCategory(long nowCategory) {
		_seatOffice.setNowCategory(nowCategory);
	}

	/**
	* Returns the new seat no of this seat office.
	*
	* @return the new seat no of this seat office
	*/
	@Override
	public java.lang.String getNewSeatNo() {
		return _seatOffice.getNewSeatNo();
	}

	/**
	* Sets the new seat no of this seat office.
	*
	* @param newSeatNo the new seat no of this seat office
	*/
	@Override
	public void setNewSeatNo(java.lang.String newSeatNo) {
		_seatOffice.setNewSeatNo(newSeatNo);
	}

	/**
	* Returns the workspace ID of this seat office.
	*
	* @return the workspace ID of this seat office
	*/
	@Override
	public long getWorkspaceId() {
		return _seatOffice.getWorkspaceId();
	}

	/**
	* Sets the workspace ID of this seat office.
	*
	* @param workspaceId the workspace ID of this seat office
	*/
	@Override
	public void setWorkspaceId(long workspaceId) {
		_seatOffice.setWorkspaceId(workspaceId);
	}

	/**
	* Returns the seat status of this seat office.
	*
	* @return the seat status of this seat office
	*/
	@Override
	public java.lang.String getSeatStatus() {
		return _seatOffice.getSeatStatus();
	}

	/**
	* Sets the seat status of this seat office.
	*
	* @param seatStatus the seat status of this seat office
	*/
	@Override
	public void setSeatStatus(java.lang.String seatStatus) {
		_seatOffice.setSeatStatus(seatStatus);
	}

	/**
	* Returns the sg of this seat office.
	*
	* @return the sg of this seat office
	*/
	@Override
	public java.lang.String getSg() {
		return _seatOffice.getSg();
	}

	/**
	* Sets the sg of this seat office.
	*
	* @param sg the sg of this seat office
	*/
	@Override
	public void setSg(java.lang.String sg) {
		_seatOffice.setSg(sg);
	}

	/**
	* Returns the leading mark of this seat office.
	*
	* @return the leading mark of this seat office
	*/
	@Override
	public java.lang.String getLeadingMark() {
		return _seatOffice.getLeadingMark();
	}

	/**
	* Sets the leading mark of this seat office.
	*
	* @param leadingMark the leading mark of this seat office
	*/
	@Override
	public void setLeadingMark(java.lang.String leadingMark) {
		_seatOffice.setLeadingMark(leadingMark);
	}

	/**
	* Returns the position flag of this seat office.
	*
	* @return the position flag of this seat office
	*/
	@Override
	public java.lang.String getPositionFlag() {
		return _seatOffice.getPositionFlag();
	}

	/**
	* Sets the position flag of this seat office.
	*
	* @param positionFlag the position flag of this seat office
	*/
	@Override
	public void setPositionFlag(java.lang.String positionFlag) {
		_seatOffice.setPositionFlag(positionFlag);
	}

	/**
	* Returns the is applicant agent of this seat office.
	*
	* @return the is applicant agent of this seat office
	*/
	@Override
	public boolean getIsApplicantAgent() {
		return _seatOffice.getIsApplicantAgent();
	}

	/**
	* Returns <code>true</code> if this seat office is is applicant agent.
	*
	* @return <code>true</code> if this seat office is is applicant agent; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsApplicantAgent() {
		return _seatOffice.isIsApplicantAgent();
	}

	/**
	* Sets whether this seat office is is applicant agent.
	*
	* @param isApplicantAgent the is applicant agent of this seat office
	*/
	@Override
	public void setIsApplicantAgent(boolean isApplicantAgent) {
		_seatOffice.setIsApplicantAgent(isApplicantAgent);
	}

	/**
	* Returns the is approver agent of this seat office.
	*
	* @return the is approver agent of this seat office
	*/
	@Override
	public boolean getIsApproverAgent() {
		return _seatOffice.getIsApproverAgent();
	}

	/**
	* Returns <code>true</code> if this seat office is is approver agent.
	*
	* @return <code>true</code> if this seat office is is approver agent; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsApproverAgent() {
		return _seatOffice.isIsApproverAgent();
	}

	/**
	* Sets whether this seat office is is approver agent.
	*
	* @param isApproverAgent the is approver agent of this seat office
	*/
	@Override
	public void setIsApproverAgent(boolean isApproverAgent) {
		_seatOffice.setIsApproverAgent(isApproverAgent);
	}

	/**
	* Returns the candidate name of this seat office.
	*
	* @return the candidate name of this seat office
	*/
	@Override
	public java.lang.String getCandidateName() {
		return _seatOffice.getCandidateName();
	}

	/**
	* Sets the candidate name of this seat office.
	*
	* @param candidateName the candidate name of this seat office
	*/
	@Override
	public void setCandidateName(java.lang.String candidateName) {
		_seatOffice.setCandidateName(candidateName);
	}

	/**
	* Returns the desired starting date of this seat office.
	*
	* @return the desired starting date of this seat office
	*/
	@Override
	public java.util.Date getDesiredStartingDate() {
		return _seatOffice.getDesiredStartingDate();
	}

	/**
	* Sets the desired starting date of this seat office.
	*
	* @param desiredStartingDate the desired starting date of this seat office
	*/
	@Override
	public void setDesiredStartingDate(java.util.Date desiredStartingDate) {
		_seatOffice.setDesiredStartingDate(desiredStartingDate);
	}

	/**
	* Returns the comments of this seat office.
	*
	* @return the comments of this seat office
	*/
	@Override
	public java.lang.String getComments() {
		return _seatOffice.getComments();
	}

	/**
	* Sets the comments of this seat office.
	*
	* @param comments the comments of this seat office
	*/
	@Override
	public void setComments(java.lang.String comments) {
		_seatOffice.setComments(comments);
	}

	/**
	* Returns the contract type of this seat office.
	*
	* @return the contract type of this seat office
	*/
	@Override
	public java.lang.String getContractType() {
		return _seatOffice.getContractType();
	}

	/**
	* Sets the contract type of this seat office.
	*
	* @param contractType the contract type of this seat office
	*/
	@Override
	public void setContractType(java.lang.String contractType) {
		_seatOffice.setContractType(contractType);
	}

	/**
	* Returns the process type of this seat office.
	*
	* @return the process type of this seat office
	*/
	@Override
	public java.lang.String getProcessType() {
		return _seatOffice.getProcessType();
	}

	/**
	* Sets the process type of this seat office.
	*
	* @param processType the process type of this seat office
	*/
	@Override
	public void setProcessType(java.lang.String processType) {
		_seatOffice.setProcessType(processType);
	}

	/**
	* Returns the sub process type of this seat office.
	*
	* @return the sub process type of this seat office
	*/
	@Override
	public java.lang.String getSubProcessType() {
		return _seatOffice.getSubProcessType();
	}

	/**
	* Sets the sub process type of this seat office.
	*
	* @param subProcessType the sub process type of this seat office
	*/
	@Override
	public void setSubProcessType(java.lang.String subProcessType) {
		_seatOffice.setSubProcessType(subProcessType);
	}

	/**
	* Returns the status of this seat office.
	*
	* @return the status of this seat office
	*/
	@Override
	public int getStatus() {
		return _seatOffice.getStatus();
	}

	/**
	* Sets the status of this seat office.
	*
	* @param status the status of this seat office
	*/
	@Override
	public void setStatus(int status) {
		_seatOffice.setStatus(status);
	}

	/**
	* Returns the status by user ID of this seat office.
	*
	* @return the status by user ID of this seat office
	*/
	@Override
	public long getStatusByUserId() {
		return _seatOffice.getStatusByUserId();
	}

	/**
	* Sets the status by user ID of this seat office.
	*
	* @param statusByUserId the status by user ID of this seat office
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_seatOffice.setStatusByUserId(statusByUserId);
	}

	/**
	* Returns the status by user uuid of this seat office.
	*
	* @return the status by user uuid of this seat office
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getStatusByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _seatOffice.getStatusByUserUuid();
	}

	/**
	* Sets the status by user uuid of this seat office.
	*
	* @param statusByUserUuid the status by user uuid of this seat office
	*/
	@Override
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_seatOffice.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Returns the status by user name of this seat office.
	*
	* @return the status by user name of this seat office
	*/
	@Override
	public java.lang.String getStatusByUserName() {
		return _seatOffice.getStatusByUserName();
	}

	/**
	* Sets the status by user name of this seat office.
	*
	* @param statusByUserName the status by user name of this seat office
	*/
	@Override
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_seatOffice.setStatusByUserName(statusByUserName);
	}

	/**
	* Returns the status date of this seat office.
	*
	* @return the status date of this seat office
	*/
	@Override
	public java.util.Date getStatusDate() {
		return _seatOffice.getStatusDate();
	}

	/**
	* Sets the status date of this seat office.
	*
	* @param statusDate the status date of this seat office
	*/
	@Override
	public void setStatusDate(java.util.Date statusDate) {
		_seatOffice.setStatusDate(statusDate);
	}

	/**
	* @deprecated As of 6.1.0, replaced by {@link #isApproved()}
	*/
	@Override
	public boolean getApproved() {
		return _seatOffice.getApproved();
	}

	/**
	* Returns <code>true</code> if this seat office is approved.
	*
	* @return <code>true</code> if this seat office is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _seatOffice.isApproved();
	}

	/**
	* Returns <code>true</code> if this seat office is denied.
	*
	* @return <code>true</code> if this seat office is denied; <code>false</code> otherwise
	*/
	@Override
	public boolean isDenied() {
		return _seatOffice.isDenied();
	}

	/**
	* Returns <code>true</code> if this seat office is a draft.
	*
	* @return <code>true</code> if this seat office is a draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _seatOffice.isDraft();
	}

	/**
	* Returns <code>true</code> if this seat office is expired.
	*
	* @return <code>true</code> if this seat office is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _seatOffice.isExpired();
	}

	/**
	* Returns <code>true</code> if this seat office is inactive.
	*
	* @return <code>true</code> if this seat office is inactive; <code>false</code> otherwise
	*/
	@Override
	public boolean isInactive() {
		return _seatOffice.isInactive();
	}

	/**
	* Returns <code>true</code> if this seat office is incomplete.
	*
	* @return <code>true</code> if this seat office is incomplete; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncomplete() {
		return _seatOffice.isIncomplete();
	}

	/**
	* Returns <code>true</code> if this seat office is pending.
	*
	* @return <code>true</code> if this seat office is pending; <code>false</code> otherwise
	*/
	@Override
	public boolean isPending() {
		return _seatOffice.isPending();
	}

	/**
	* Returns <code>true</code> if this seat office is scheduled.
	*
	* @return <code>true</code> if this seat office is scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isScheduled() {
		return _seatOffice.isScheduled();
	}

	@Override
	public boolean isNew() {
		return _seatOffice.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_seatOffice.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _seatOffice.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_seatOffice.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _seatOffice.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _seatOffice.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_seatOffice.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _seatOffice.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_seatOffice.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_seatOffice.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_seatOffice.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SeatOfficeWrapper((SeatOffice)_seatOffice.clone());
	}

	@Override
	public int compareTo(com.seatoffice.model.SeatOffice seatOffice) {
		return _seatOffice.compareTo(seatOffice);
	}

	@Override
	public int hashCode() {
		return _seatOffice.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.seatoffice.model.SeatOffice> toCacheModel() {
		return _seatOffice.toCacheModel();
	}

	@Override
	public com.seatoffice.model.SeatOffice toEscapedModel() {
		return new SeatOfficeWrapper(_seatOffice.toEscapedModel());
	}

	@Override
	public com.seatoffice.model.SeatOffice toUnescapedModel() {
		return new SeatOfficeWrapper(_seatOffice.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _seatOffice.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _seatOffice.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_seatOffice.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SeatOfficeWrapper)) {
			return false;
		}

		SeatOfficeWrapper seatOfficeWrapper = (SeatOfficeWrapper)obj;

		if (Validator.equals(_seatOffice, seatOfficeWrapper._seatOffice)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SeatOffice getWrappedSeatOffice() {
		return _seatOffice;
	}

	@Override
	public SeatOffice getWrappedModel() {
		return _seatOffice;
	}

	@Override
	public void resetOriginalValues() {
		_seatOffice.resetOriginalValues();
	}

	private SeatOffice _seatOffice;
}