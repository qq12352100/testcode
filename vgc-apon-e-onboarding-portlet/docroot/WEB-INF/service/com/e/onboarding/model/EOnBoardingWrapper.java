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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link EOnBoarding}.
 * </p>
 *
 * @author sanguine
 * @see EOnBoarding
 * @generated
 */
public class EOnBoardingWrapper implements EOnBoarding,
	ModelWrapper<EOnBoarding> {
	public EOnBoardingWrapper(EOnBoarding eOnBoarding) {
		_eOnBoarding = eOnBoarding;
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

	/**
	* Returns the primary key of this e on boarding.
	*
	* @return the primary key of this e on boarding
	*/
	@Override
	public long getPrimaryKey() {
		return _eOnBoarding.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e on boarding.
	*
	* @param primaryKey the primary key of this e on boarding
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_eOnBoarding.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the e on boarding ID of this e on boarding.
	*
	* @return the e on boarding ID of this e on boarding
	*/
	@Override
	public long getEOnBoardingId() {
		return _eOnBoarding.getEOnBoardingId();
	}

	/**
	* Sets the e on boarding ID of this e on boarding.
	*
	* @param eOnBoardingId the e on boarding ID of this e on boarding
	*/
	@Override
	public void setEOnBoardingId(long eOnBoardingId) {
		_eOnBoarding.setEOnBoardingId(eOnBoardingId);
	}

	/**
	* Returns the ticket no of this e on boarding.
	*
	* @return the ticket no of this e on boarding
	*/
	@Override
	public java.lang.String getTicketNo() {
		return _eOnBoarding.getTicketNo();
	}

	/**
	* Sets the ticket no of this e on boarding.
	*
	* @param ticketNo the ticket no of this e on boarding
	*/
	@Override
	public void setTicketNo(java.lang.String ticketNo) {
		_eOnBoarding.setTicketNo(ticketNo);
	}

	/**
	* Returns the process type of this e on boarding.
	*
	* @return the process type of this e on boarding
	*/
	@Override
	public java.lang.String getProcessType() {
		return _eOnBoarding.getProcessType();
	}

	/**
	* Sets the process type of this e on boarding.
	*
	* @param processType the process type of this e on boarding
	*/
	@Override
	public void setProcessType(java.lang.String processType) {
		_eOnBoarding.setProcessType(processType);
	}

	/**
	* Returns the sub type of this e on boarding.
	*
	* @return the sub type of this e on boarding
	*/
	@Override
	public java.lang.String getSubType() {
		return _eOnBoarding.getSubType();
	}

	/**
	* Sets the sub type of this e on boarding.
	*
	* @param subType the sub type of this e on boarding
	*/
	@Override
	public void setSubType(java.lang.String subType) {
		_eOnBoarding.setSubType(subType);
	}

	/**
	* Returns the group ID of this e on boarding.
	*
	* @return the group ID of this e on boarding
	*/
	@Override
	public long getGroupId() {
		return _eOnBoarding.getGroupId();
	}

	/**
	* Sets the group ID of this e on boarding.
	*
	* @param groupId the group ID of this e on boarding
	*/
	@Override
	public void setGroupId(long groupId) {
		_eOnBoarding.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this e on boarding.
	*
	* @return the company ID of this e on boarding
	*/
	@Override
	public long getCompanyId() {
		return _eOnBoarding.getCompanyId();
	}

	/**
	* Sets the company ID of this e on boarding.
	*
	* @param companyId the company ID of this e on boarding
	*/
	@Override
	public void setCompanyId(long companyId) {
		_eOnBoarding.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this e on boarding.
	*
	* @return the user ID of this e on boarding
	*/
	@Override
	public long getUserId() {
		return _eOnBoarding.getUserId();
	}

	/**
	* Sets the user ID of this e on boarding.
	*
	* @param userId the user ID of this e on boarding
	*/
	@Override
	public void setUserId(long userId) {
		_eOnBoarding.setUserId(userId);
	}

	/**
	* Returns the user uuid of this e on boarding.
	*
	* @return the user uuid of this e on boarding
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eOnBoarding.getUserUuid();
	}

	/**
	* Sets the user uuid of this e on boarding.
	*
	* @param userUuid the user uuid of this e on boarding
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_eOnBoarding.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this e on boarding.
	*
	* @return the user name of this e on boarding
	*/
	@Override
	public java.lang.String getUserName() {
		return _eOnBoarding.getUserName();
	}

	/**
	* Sets the user name of this e on boarding.
	*
	* @param userName the user name of this e on boarding
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_eOnBoarding.setUserName(userName);
	}

	/**
	* Returns the create date of this e on boarding.
	*
	* @return the create date of this e on boarding
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _eOnBoarding.getCreateDate();
	}

	/**
	* Sets the create date of this e on boarding.
	*
	* @param createDate the create date of this e on boarding
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_eOnBoarding.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this e on boarding.
	*
	* @return the modified date of this e on boarding
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _eOnBoarding.getModifiedDate();
	}

	/**
	* Sets the modified date of this e on boarding.
	*
	* @param modifiedDate the modified date of this e on boarding
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_eOnBoarding.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the submitted date of this e on boarding.
	*
	* @return the submitted date of this e on boarding
	*/
	@Override
	public java.util.Date getSubmittedDate() {
		return _eOnBoarding.getSubmittedDate();
	}

	/**
	* Sets the submitted date of this e on boarding.
	*
	* @param submittedDate the submitted date of this e on boarding
	*/
	@Override
	public void setSubmittedDate(java.util.Date submittedDate) {
		_eOnBoarding.setSubmittedDate(submittedDate);
	}

	/**
	* Returns the modified user ID of this e on boarding.
	*
	* @return the modified user ID of this e on boarding
	*/
	@Override
	public long getModifiedUserId() {
		return _eOnBoarding.getModifiedUserId();
	}

	/**
	* Sets the modified user ID of this e on boarding.
	*
	* @param modifiedUserId the modified user ID of this e on boarding
	*/
	@Override
	public void setModifiedUserId(long modifiedUserId) {
		_eOnBoarding.setModifiedUserId(modifiedUserId);
	}

	/**
	* Returns the modified user uuid of this e on boarding.
	*
	* @return the modified user uuid of this e on boarding
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getModifiedUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eOnBoarding.getModifiedUserUuid();
	}

	/**
	* Sets the modified user uuid of this e on boarding.
	*
	* @param modifiedUserUuid the modified user uuid of this e on boarding
	*/
	@Override
	public void setModifiedUserUuid(java.lang.String modifiedUserUuid) {
		_eOnBoarding.setModifiedUserUuid(modifiedUserUuid);
	}

	/**
	* Returns the modified user name of this e on boarding.
	*
	* @return the modified user name of this e on boarding
	*/
	@Override
	public java.lang.String getModifiedUserName() {
		return _eOnBoarding.getModifiedUserName();
	}

	/**
	* Sets the modified user name of this e on boarding.
	*
	* @param modifiedUserName the modified user name of this e on boarding
	*/
	@Override
	public void setModifiedUserName(java.lang.String modifiedUserName) {
		_eOnBoarding.setModifiedUserName(modifiedUserName);
	}

	/**
	* Returns the status of this e on boarding.
	*
	* @return the status of this e on boarding
	*/
	@Override
	public int getStatus() {
		return _eOnBoarding.getStatus();
	}

	/**
	* Sets the status of this e on boarding.
	*
	* @param status the status of this e on boarding
	*/
	@Override
	public void setStatus(int status) {
		_eOnBoarding.setStatus(status);
	}

	/**
	* Returns the status by user ID of this e on boarding.
	*
	* @return the status by user ID of this e on boarding
	*/
	@Override
	public long getStatusByUserId() {
		return _eOnBoarding.getStatusByUserId();
	}

	/**
	* Sets the status by user ID of this e on boarding.
	*
	* @param statusByUserId the status by user ID of this e on boarding
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_eOnBoarding.setStatusByUserId(statusByUserId);
	}

	/**
	* Returns the status by user uuid of this e on boarding.
	*
	* @return the status by user uuid of this e on boarding
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getStatusByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eOnBoarding.getStatusByUserUuid();
	}

	/**
	* Sets the status by user uuid of this e on boarding.
	*
	* @param statusByUserUuid the status by user uuid of this e on boarding
	*/
	@Override
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_eOnBoarding.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Returns the status by user name of this e on boarding.
	*
	* @return the status by user name of this e on boarding
	*/
	@Override
	public java.lang.String getStatusByUserName() {
		return _eOnBoarding.getStatusByUserName();
	}

	/**
	* Sets the status by user name of this e on boarding.
	*
	* @param statusByUserName the status by user name of this e on boarding
	*/
	@Override
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_eOnBoarding.setStatusByUserName(statusByUserName);
	}

	/**
	* Returns the status date of this e on boarding.
	*
	* @return the status date of this e on boarding
	*/
	@Override
	public java.util.Date getStatusDate() {
		return _eOnBoarding.getStatusDate();
	}

	/**
	* Sets the status date of this e on boarding.
	*
	* @param statusDate the status date of this e on boarding
	*/
	@Override
	public void setStatusDate(java.util.Date statusDate) {
		_eOnBoarding.setStatusDate(statusDate);
	}

	/**
	* Returns the staff code of this e on boarding.
	*
	* @return the staff code of this e on boarding
	*/
	@Override
	public java.lang.String getStaffCode() {
		return _eOnBoarding.getStaffCode();
	}

	/**
	* Sets the staff code of this e on boarding.
	*
	* @param staffCode the staff code of this e on boarding
	*/
	@Override
	public void setStaffCode(java.lang.String staffCode) {
		_eOnBoarding.setStaffCode(staffCode);
	}

	/**
	* Returns the last name of this e on boarding.
	*
	* @return the last name of this e on boarding
	*/
	@Override
	public java.lang.String getLastName() {
		return _eOnBoarding.getLastName();
	}

	/**
	* Sets the last name of this e on boarding.
	*
	* @param lastName the last name of this e on boarding
	*/
	@Override
	public void setLastName(java.lang.String lastName) {
		_eOnBoarding.setLastName(lastName);
	}

	/**
	* Returns the first name of this e on boarding.
	*
	* @return the first name of this e on boarding
	*/
	@Override
	public java.lang.String getFirstName() {
		return _eOnBoarding.getFirstName();
	}

	/**
	* Sets the first name of this e on boarding.
	*
	* @param firstName the first name of this e on boarding
	*/
	@Override
	public void setFirstName(java.lang.String firstName) {
		_eOnBoarding.setFirstName(firstName);
	}

	/**
	* Returns the name of this e on boarding.
	*
	* @return the name of this e on boarding
	*/
	@Override
	public java.lang.String getName() {
		return _eOnBoarding.getName();
	}

	/**
	* Sets the name of this e on boarding.
	*
	* @param name the name of this e on boarding
	*/
	@Override
	public void setName(java.lang.String name) {
		_eOnBoarding.setName(name);
	}

	/**
	* Returns the gender of this e on boarding.
	*
	* @return the gender of this e on boarding
	*/
	@Override
	public java.lang.String getGender() {
		return _eOnBoarding.getGender();
	}

	/**
	* Sets the gender of this e on boarding.
	*
	* @param gender the gender of this e on boarding
	*/
	@Override
	public void setGender(java.lang.String gender) {
		_eOnBoarding.setGender(gender);
	}

	/**
	* Returns the birthday of this e on boarding.
	*
	* @return the birthday of this e on boarding
	*/
	@Override
	public java.util.Date getBirthday() {
		return _eOnBoarding.getBirthday();
	}

	/**
	* Sets the birthday of this e on boarding.
	*
	* @param birthday the birthday of this e on boarding
	*/
	@Override
	public void setBirthday(java.util.Date birthday) {
		_eOnBoarding.setBirthday(birthday);
	}

	/**
	* Returns the photo path of this e on boarding.
	*
	* @return the photo path of this e on boarding
	*/
	@Override
	public java.lang.String getPhotoPath() {
		return _eOnBoarding.getPhotoPath();
	}

	/**
	* Sets the photo path of this e on boarding.
	*
	* @param photoPath the photo path of this e on boarding
	*/
	@Override
	public void setPhotoPath(java.lang.String photoPath) {
		_eOnBoarding.setPhotoPath(photoPath);
	}

	/**
	* Returns the contract type of this e on boarding.
	*
	* @return the contract type of this e on boarding
	*/
	@Override
	public java.lang.String getContractType() {
		return _eOnBoarding.getContractType();
	}

	/**
	* Sets the contract type of this e on boarding.
	*
	* @param contractType the contract type of this e on boarding
	*/
	@Override
	public void setContractType(java.lang.String contractType) {
		_eOnBoarding.setContractType(contractType);
	}

	/**
	* Returns the work location of this e on boarding.
	*
	* @return the work location of this e on boarding
	*/
	@Override
	public java.lang.String getWorkLocation() {
		return _eOnBoarding.getWorkLocation();
	}

	/**
	* Sets the work location of this e on boarding.
	*
	* @param workLocation the work location of this e on boarding
	*/
	@Override
	public void setWorkLocation(java.lang.String workLocation) {
		_eOnBoarding.setWorkLocation(workLocation);
	}

	/**
	* Returns the division of this e on boarding.
	*
	* @return the division of this e on boarding
	*/
	@Override
	public java.lang.String getDivision() {
		return _eOnBoarding.getDivision();
	}

	/**
	* Sets the division of this e on boarding.
	*
	* @param division the division of this e on boarding
	*/
	@Override
	public void setDivision(java.lang.String division) {
		_eOnBoarding.setDivision(division);
	}

	/**
	* Returns the office site of this e on boarding.
	*
	* @return the office site of this e on boarding
	*/
	@Override
	public java.lang.String getOfficeSite() {
		return _eOnBoarding.getOfficeSite();
	}

	/**
	* Sets the office site of this e on boarding.
	*
	* @param officeSite the office site of this e on boarding
	*/
	@Override
	public void setOfficeSite(java.lang.String officeSite) {
		_eOnBoarding.setOfficeSite(officeSite);
	}

	/**
	* Returns the department of this e on boarding.
	*
	* @return the department of this e on boarding
	*/
	@Override
	public java.lang.String getDepartment() {
		return _eOnBoarding.getDepartment();
	}

	/**
	* Sets the department of this e on boarding.
	*
	* @param department the department of this e on boarding
	*/
	@Override
	public void setDepartment(java.lang.String department) {
		_eOnBoarding.setDepartment(department);
	}

	/**
	* Returns the starting date of this e on boarding.
	*
	* @return the starting date of this e on boarding
	*/
	@Override
	public java.util.Date getStartingDate() {
		return _eOnBoarding.getStartingDate();
	}

	/**
	* Sets the starting date of this e on boarding.
	*
	* @param startingDate the starting date of this e on boarding
	*/
	@Override
	public void setStartingDate(java.util.Date startingDate) {
		_eOnBoarding.setStartingDate(startingDate);
	}

	/**
	* Returns the position code of this e on boarding.
	*
	* @return the position code of this e on boarding
	*/
	@Override
	public java.lang.String getPositionCode() {
		return _eOnBoarding.getPositionCode();
	}

	/**
	* Sets the position code of this e on boarding.
	*
	* @param positionCode the position code of this e on boarding
	*/
	@Override
	public void setPositionCode(java.lang.String positionCode) {
		_eOnBoarding.setPositionCode(positionCode);
	}

	/**
	* Returns the service length of this e on boarding.
	*
	* @return the service length of this e on boarding
	*/
	@Override
	public java.lang.String getServiceLength() {
		return _eOnBoarding.getServiceLength();
	}

	/**
	* Sets the service length of this e on boarding.
	*
	* @param serviceLength the service length of this e on boarding
	*/
	@Override
	public void setServiceLength(java.lang.String serviceLength) {
		_eOnBoarding.setServiceLength(serviceLength);
	}

	/**
	* Returns the function name of this e on boarding.
	*
	* @return the function name of this e on boarding
	*/
	@Override
	public java.lang.String getFunctionName() {
		return _eOnBoarding.getFunctionName();
	}

	/**
	* Sets the function name of this e on boarding.
	*
	* @param functionName the function name of this e on boarding
	*/
	@Override
	public void setFunctionName(java.lang.String functionName) {
		_eOnBoarding.setFunctionName(functionName);
	}

	/**
	* Returns the report to of this e on boarding.
	*
	* @return the report to of this e on boarding
	*/
	@Override
	public java.lang.String getReportTo() {
		return _eOnBoarding.getReportTo();
	}

	/**
	* Sets the report to of this e on boarding.
	*
	* @param reportTo the report to of this e on boarding
	*/
	@Override
	public void setReportTo(java.lang.String reportTo) {
		_eOnBoarding.setReportTo(reportTo);
	}

	/**
	* Returns the report to staff name of this e on boarding.
	*
	* @return the report to staff name of this e on boarding
	*/
	@Override
	public java.lang.String getReportToStaffName() {
		return _eOnBoarding.getReportToStaffName();
	}

	/**
	* Sets the report to staff name of this e on boarding.
	*
	* @param reportToStaffName the report to staff name of this e on boarding
	*/
	@Override
	public void setReportToStaffName(java.lang.String reportToStaffName) {
		_eOnBoarding.setReportToStaffName(reportToStaffName);
	}

	/**
	* Returns the title of this e on boarding.
	*
	* @return the title of this e on boarding
	*/
	@Override
	public java.lang.String getTitle() {
		return _eOnBoarding.getTitle();
	}

	/**
	* Sets the title of this e on boarding.
	*
	* @param title the title of this e on boarding
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_eOnBoarding.setTitle(title);
	}

	/**
	* Returns the cost center of this e on boarding.
	*
	* @return the cost center of this e on boarding
	*/
	@Override
	public java.lang.String getCostCenter() {
		return _eOnBoarding.getCostCenter();
	}

	/**
	* Sets the cost center of this e on boarding.
	*
	* @param costCenter the cost center of this e on boarding
	*/
	@Override
	public void setCostCenter(java.lang.String costCenter) {
		_eOnBoarding.setCostCenter(costCenter);
	}

	/**
	* Returns the it related hardware of this e on boarding.
	*
	* @return the it related hardware of this e on boarding
	*/
	@Override
	public boolean getItRelatedHardware() {
		return _eOnBoarding.getItRelatedHardware();
	}

	/**
	* Returns <code>true</code> if this e on boarding is it related hardware.
	*
	* @return <code>true</code> if this e on boarding is it related hardware; <code>false</code> otherwise
	*/
	@Override
	public boolean isItRelatedHardware() {
		return _eOnBoarding.isItRelatedHardware();
	}

	/**
	* Sets whether this e on boarding is it related hardware.
	*
	* @param itRelatedHardware the it related hardware of this e on boarding
	*/
	@Override
	public void setItRelatedHardware(boolean itRelatedHardware) {
		_eOnBoarding.setItRelatedHardware(itRelatedHardware);
	}

	/**
	* Returns the company car of this e on boarding.
	*
	* @return the company car of this e on boarding
	*/
	@Override
	public boolean getCompanyCar() {
		return _eOnBoarding.getCompanyCar();
	}

	/**
	* Returns <code>true</code> if this e on boarding is company car.
	*
	* @return <code>true</code> if this e on boarding is company car; <code>false</code> otherwise
	*/
	@Override
	public boolean isCompanyCar() {
		return _eOnBoarding.isCompanyCar();
	}

	/**
	* Sets whether this e on boarding is company car.
	*
	* @param companyCar the company car of this e on boarding
	*/
	@Override
	public void setCompanyCar(boolean companyCar) {
		_eOnBoarding.setCompanyCar(companyCar);
	}

	/**
	* Returns the replacement of this e on boarding.
	*
	* @return the replacement of this e on boarding
	*/
	@Override
	public boolean getReplacement() {
		return _eOnBoarding.getReplacement();
	}

	/**
	* Returns <code>true</code> if this e on boarding is replacement.
	*
	* @return <code>true</code> if this e on boarding is replacement; <code>false</code> otherwise
	*/
	@Override
	public boolean isReplacement() {
		return _eOnBoarding.isReplacement();
	}

	/**
	* Sets whether this e on boarding is replacement.
	*
	* @param replacement the replacement of this e on boarding
	*/
	@Override
	public void setReplacement(boolean replacement) {
		_eOnBoarding.setReplacement(replacement);
	}

	/**
	* Returns the name of replaced person of this e on boarding.
	*
	* @return the name of replaced person of this e on boarding
	*/
	@Override
	public java.lang.String getNameOfReplacedPerson() {
		return _eOnBoarding.getNameOfReplacedPerson();
	}

	/**
	* Sets the name of replaced person of this e on boarding.
	*
	* @param nameOfReplacedPerson the name of replaced person of this e on boarding
	*/
	@Override
	public void setNameOfReplacedPerson(java.lang.String nameOfReplacedPerson) {
		_eOnBoarding.setNameOfReplacedPerson(nameOfReplacedPerson);
	}

	/**
	* Returns the contact info of this e on boarding.
	*
	* @return the contact info of this e on boarding
	*/
	@Override
	public java.lang.String getContactInfo() {
		return _eOnBoarding.getContactInfo();
	}

	/**
	* Sets the contact info of this e on boarding.
	*
	* @param contactInfo the contact info of this e on boarding
	*/
	@Override
	public void setContactInfo(java.lang.String contactInfo) {
		_eOnBoarding.setContactInfo(contactInfo);
	}

	/**
	* Returns the comments of this e on boarding.
	*
	* @return the comments of this e on boarding
	*/
	@Override
	public java.lang.String getComments() {
		return _eOnBoarding.getComments();
	}

	/**
	* Sets the comments of this e on boarding.
	*
	* @param comments the comments of this e on boarding
	*/
	@Override
	public void setComments(java.lang.String comments) {
		_eOnBoarding.setComments(comments);
	}

	/**
	* Returns the is applicant agent of this e on boarding.
	*
	* @return the is applicant agent of this e on boarding
	*/
	@Override
	public boolean getIsApplicantAgent() {
		return _eOnBoarding.getIsApplicantAgent();
	}

	/**
	* Returns <code>true</code> if this e on boarding is is applicant agent.
	*
	* @return <code>true</code> if this e on boarding is is applicant agent; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsApplicantAgent() {
		return _eOnBoarding.isIsApplicantAgent();
	}

	/**
	* Sets whether this e on boarding is is applicant agent.
	*
	* @param isApplicantAgent the is applicant agent of this e on boarding
	*/
	@Override
	public void setIsApplicantAgent(boolean isApplicantAgent) {
		_eOnBoarding.setIsApplicantAgent(isApplicantAgent);
	}

	/**
	* Returns the is approver agent of this e on boarding.
	*
	* @return the is approver agent of this e on boarding
	*/
	@Override
	public boolean getIsApproverAgent() {
		return _eOnBoarding.getIsApproverAgent();
	}

	/**
	* Returns <code>true</code> if this e on boarding is is approver agent.
	*
	* @return <code>true</code> if this e on boarding is is approver agent; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsApproverAgent() {
		return _eOnBoarding.isIsApproverAgent();
	}

	/**
	* Sets whether this e on boarding is is approver agent.
	*
	* @param isApproverAgent the is approver agent of this e on boarding
	*/
	@Override
	public void setIsApproverAgent(boolean isApproverAgent) {
		_eOnBoarding.setIsApproverAgent(isApproverAgent);
	}

	/**
	* Returns the admin entitlement of this e on boarding.
	*
	* @return the admin entitlement of this e on boarding
	*/
	@Override
	public java.lang.String getAdminEntitlement() {
		return _eOnBoarding.getAdminEntitlement();
	}

	/**
	* Sets the admin entitlement of this e on boarding.
	*
	* @param adminEntitlement the admin entitlement of this e on boarding
	*/
	@Override
	public void setAdminEntitlement(java.lang.String adminEntitlement) {
		_eOnBoarding.setAdminEntitlement(adminEntitlement);
	}

	/**
	* Returns the admin seat no of this e on boarding.
	*
	* @return the admin seat no of this e on boarding
	*/
	@Override
	public java.lang.String getAdminSeatNo() {
		return _eOnBoarding.getAdminSeatNo();
	}

	/**
	* Sets the admin seat no of this e on boarding.
	*
	* @param adminSeatNo the admin seat no of this e on boarding
	*/
	@Override
	public void setAdminSeatNo(java.lang.String adminSeatNo) {
		_eOnBoarding.setAdminSeatNo(adminSeatNo);
	}

	/**
	* Returns the admin tasks of this e on boarding.
	*
	* @return the admin tasks of this e on boarding
	*/
	@Override
	public java.lang.String getAdminTasks() {
		return _eOnBoarding.getAdminTasks();
	}

	/**
	* Sets the admin tasks of this e on boarding.
	*
	* @param adminTasks the admin tasks of this e on boarding
	*/
	@Override
	public void setAdminTasks(java.lang.String adminTasks) {
		_eOnBoarding.setAdminTasks(adminTasks);
	}

	/**
	* Returns the admin status of this e on boarding.
	*
	* @return the admin status of this e on boarding
	*/
	@Override
	public java.lang.String getAdminStatus() {
		return _eOnBoarding.getAdminStatus();
	}

	/**
	* Sets the admin status of this e on boarding.
	*
	* @param adminStatus the admin status of this e on boarding
	*/
	@Override
	public void setAdminStatus(java.lang.String adminStatus) {
		_eOnBoarding.setAdminStatus(adminStatus);
	}

	/**
	* Returns the admin comments of this e on boarding.
	*
	* @return the admin comments of this e on boarding
	*/
	@Override
	public java.lang.String getAdminComments() {
		return _eOnBoarding.getAdminComments();
	}

	/**
	* Sets the admin comments of this e on boarding.
	*
	* @param adminComments the admin comments of this e on boarding
	*/
	@Override
	public void setAdminComments(java.lang.String adminComments) {
		_eOnBoarding.setAdminComments(adminComments);
	}

	/**
	* Returns the security tasks of this e on boarding.
	*
	* @return the security tasks of this e on boarding
	*/
	@Override
	public java.lang.String getSecurityTasks() {
		return _eOnBoarding.getSecurityTasks();
	}

	/**
	* Sets the security tasks of this e on boarding.
	*
	* @param securityTasks the security tasks of this e on boarding
	*/
	@Override
	public void setSecurityTasks(java.lang.String securityTasks) {
		_eOnBoarding.setSecurityTasks(securityTasks);
	}

	/**
	* Returns the security status of this e on boarding.
	*
	* @return the security status of this e on boarding
	*/
	@Override
	public java.lang.String getSecurityStatus() {
		return _eOnBoarding.getSecurityStatus();
	}

	/**
	* Sets the security status of this e on boarding.
	*
	* @param securityStatus the security status of this e on boarding
	*/
	@Override
	public void setSecurityStatus(java.lang.String securityStatus) {
		_eOnBoarding.setSecurityStatus(securityStatus);
	}

	/**
	* Returns the security comments of this e on boarding.
	*
	* @return the security comments of this e on boarding
	*/
	@Override
	public java.lang.String getSecurityComments() {
		return _eOnBoarding.getSecurityComments();
	}

	/**
	* Sets the security comments of this e on boarding.
	*
	* @param securityComments the security comments of this e on boarding
	*/
	@Override
	public void setSecurityComments(java.lang.String securityComments) {
		_eOnBoarding.setSecurityComments(securityComments);
	}

	/**
	* Returns the itp tasks of this e on boarding.
	*
	* @return the itp tasks of this e on boarding
	*/
	@Override
	public java.lang.String getItpTasks() {
		return _eOnBoarding.getItpTasks();
	}

	/**
	* Sets the itp tasks of this e on boarding.
	*
	* @param itpTasks the itp tasks of this e on boarding
	*/
	@Override
	public void setItpTasks(java.lang.String itpTasks) {
		_eOnBoarding.setItpTasks(itpTasks);
	}

	/**
	* Returns the itp status of this e on boarding.
	*
	* @return the itp status of this e on boarding
	*/
	@Override
	public java.lang.String getItpStatus() {
		return _eOnBoarding.getItpStatus();
	}

	/**
	* Sets the itp status of this e on boarding.
	*
	* @param itpStatus the itp status of this e on boarding
	*/
	@Override
	public void setItpStatus(java.lang.String itpStatus) {
		_eOnBoarding.setItpStatus(itpStatus);
	}

	/**
	* Returns the ipt comments of this e on boarding.
	*
	* @return the ipt comments of this e on boarding
	*/
	@Override
	public java.lang.String getIptComments() {
		return _eOnBoarding.getIptComments();
	}

	/**
	* Sets the ipt comments of this e on boarding.
	*
	* @param iptComments the ipt comments of this e on boarding
	*/
	@Override
	public void setIptComments(java.lang.String iptComments) {
		_eOnBoarding.setIptComments(iptComments);
	}

	/**
	* Returns the finance tasks of this e on boarding.
	*
	* @return the finance tasks of this e on boarding
	*/
	@Override
	public java.lang.String getFinanceTasks() {
		return _eOnBoarding.getFinanceTasks();
	}

	/**
	* Sets the finance tasks of this e on boarding.
	*
	* @param financeTasks the finance tasks of this e on boarding
	*/
	@Override
	public void setFinanceTasks(java.lang.String financeTasks) {
		_eOnBoarding.setFinanceTasks(financeTasks);
	}

	/**
	* Returns the finance status of this e on boarding.
	*
	* @return the finance status of this e on boarding
	*/
	@Override
	public java.lang.String getFinanceStatus() {
		return _eOnBoarding.getFinanceStatus();
	}

	/**
	* Sets the finance status of this e on boarding.
	*
	* @param financeStatus the finance status of this e on boarding
	*/
	@Override
	public void setFinanceStatus(java.lang.String financeStatus) {
		_eOnBoarding.setFinanceStatus(financeStatus);
	}

	/**
	* Returns the finance comments of this e on boarding.
	*
	* @return the finance comments of this e on boarding
	*/
	@Override
	public java.lang.String getFinanceComments() {
		return _eOnBoarding.getFinanceComments();
	}

	/**
	* Sets the finance comments of this e on boarding.
	*
	* @param financeComments the finance comments of this e on boarding
	*/
	@Override
	public void setFinanceComments(java.lang.String financeComments) {
		_eOnBoarding.setFinanceComments(financeComments);
	}

	/**
	* @deprecated As of 6.1.0, replaced by {@link #isApproved()}
	*/
	@Override
	public boolean getApproved() {
		return _eOnBoarding.getApproved();
	}

	/**
	* Returns <code>true</code> if this e on boarding is approved.
	*
	* @return <code>true</code> if this e on boarding is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _eOnBoarding.isApproved();
	}

	/**
	* Returns <code>true</code> if this e on boarding is denied.
	*
	* @return <code>true</code> if this e on boarding is denied; <code>false</code> otherwise
	*/
	@Override
	public boolean isDenied() {
		return _eOnBoarding.isDenied();
	}

	/**
	* Returns <code>true</code> if this e on boarding is a draft.
	*
	* @return <code>true</code> if this e on boarding is a draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _eOnBoarding.isDraft();
	}

	/**
	* Returns <code>true</code> if this e on boarding is expired.
	*
	* @return <code>true</code> if this e on boarding is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _eOnBoarding.isExpired();
	}

	/**
	* Returns <code>true</code> if this e on boarding is inactive.
	*
	* @return <code>true</code> if this e on boarding is inactive; <code>false</code> otherwise
	*/
	@Override
	public boolean isInactive() {
		return _eOnBoarding.isInactive();
	}

	/**
	* Returns <code>true</code> if this e on boarding is incomplete.
	*
	* @return <code>true</code> if this e on boarding is incomplete; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncomplete() {
		return _eOnBoarding.isIncomplete();
	}

	/**
	* Returns <code>true</code> if this e on boarding is pending.
	*
	* @return <code>true</code> if this e on boarding is pending; <code>false</code> otherwise
	*/
	@Override
	public boolean isPending() {
		return _eOnBoarding.isPending();
	}

	/**
	* Returns <code>true</code> if this e on boarding is scheduled.
	*
	* @return <code>true</code> if this e on boarding is scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isScheduled() {
		return _eOnBoarding.isScheduled();
	}

	@Override
	public boolean isNew() {
		return _eOnBoarding.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_eOnBoarding.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _eOnBoarding.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_eOnBoarding.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _eOnBoarding.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _eOnBoarding.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_eOnBoarding.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _eOnBoarding.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_eOnBoarding.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_eOnBoarding.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_eOnBoarding.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EOnBoardingWrapper((EOnBoarding)_eOnBoarding.clone());
	}

	@Override
	public int compareTo(com.e.onboarding.model.EOnBoarding eOnBoarding) {
		return _eOnBoarding.compareTo(eOnBoarding);
	}

	@Override
	public int hashCode() {
		return _eOnBoarding.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.e.onboarding.model.EOnBoarding> toCacheModel() {
		return _eOnBoarding.toCacheModel();
	}

	@Override
	public com.e.onboarding.model.EOnBoarding toEscapedModel() {
		return new EOnBoardingWrapper(_eOnBoarding.toEscapedModel());
	}

	@Override
	public com.e.onboarding.model.EOnBoarding toUnescapedModel() {
		return new EOnBoardingWrapper(_eOnBoarding.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _eOnBoarding.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _eOnBoarding.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_eOnBoarding.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EOnBoardingWrapper)) {
			return false;
		}

		EOnBoardingWrapper eOnBoardingWrapper = (EOnBoardingWrapper)obj;

		if (Validator.equals(_eOnBoarding, eOnBoardingWrapper._eOnBoarding)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EOnBoarding getWrappedEOnBoarding() {
		return _eOnBoarding;
	}

	@Override
	public EOnBoarding getWrappedModel() {
		return _eOnBoarding;
	}

	@Override
	public void resetOriginalValues() {
		_eOnBoarding.resetOriginalValues();
	}

	private EOnBoarding _eOnBoarding;
}