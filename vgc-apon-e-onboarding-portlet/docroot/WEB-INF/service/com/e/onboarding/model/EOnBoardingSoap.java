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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.e.onboarding.service.http.EOnBoardingServiceSoap}.
 *
 * @author sanguine
 * @see com.e.onboarding.service.http.EOnBoardingServiceSoap
 * @generated
 */
public class EOnBoardingSoap implements Serializable {
	public static EOnBoardingSoap toSoapModel(EOnBoarding model) {
		EOnBoardingSoap soapModel = new EOnBoardingSoap();

		soapModel.setEOnBoardingId(model.getEOnBoardingId());
		soapModel.setTicketNo(model.getTicketNo());
		soapModel.setProcessType(model.getProcessType());
		soapModel.setSubType(model.getSubType());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setSubmittedDate(model.getSubmittedDate());
		soapModel.setModifiedUserId(model.getModifiedUserId());
		soapModel.setModifiedUserName(model.getModifiedUserName());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());
		soapModel.setStaffCode(model.getStaffCode());
		soapModel.setLastName(model.getLastName());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setName(model.getName());
		soapModel.setGender(model.getGender());
		soapModel.setBirthday(model.getBirthday());
		soapModel.setPhotoPath(model.getPhotoPath());
		soapModel.setContractType(model.getContractType());
		soapModel.setWorkLocation(model.getWorkLocation());
		soapModel.setDivision(model.getDivision());
		soapModel.setOfficeSite(model.getOfficeSite());
		soapModel.setDepartment(model.getDepartment());
		soapModel.setStartingDate(model.getStartingDate());
		soapModel.setPositionCode(model.getPositionCode());
		soapModel.setServiceLength(model.getServiceLength());
		soapModel.setFunctionName(model.getFunctionName());
		soapModel.setReportTo(model.getReportTo());
		soapModel.setReportToStaffName(model.getReportToStaffName());
		soapModel.setTitle(model.getTitle());
		soapModel.setCostCenter(model.getCostCenter());
		soapModel.setItRelatedHardware(model.getItRelatedHardware());
		soapModel.setCompanyCar(model.getCompanyCar());
		soapModel.setReplacement(model.getReplacement());
		soapModel.setNameOfReplacedPerson(model.getNameOfReplacedPerson());
		soapModel.setContactInfo(model.getContactInfo());
		soapModel.setComments(model.getComments());
		soapModel.setIsApplicantAgent(model.getIsApplicantAgent());
		soapModel.setIsApproverAgent(model.getIsApproverAgent());
		soapModel.setAdminEntitlement(model.getAdminEntitlement());
		soapModel.setAdminSeatNo(model.getAdminSeatNo());
		soapModel.setAdminTasks(model.getAdminTasks());
		soapModel.setAdminStatus(model.getAdminStatus());
		soapModel.setAdminComments(model.getAdminComments());
		soapModel.setSecurityTasks(model.getSecurityTasks());
		soapModel.setSecurityStatus(model.getSecurityStatus());
		soapModel.setSecurityComments(model.getSecurityComments());
		soapModel.setItpTasks(model.getItpTasks());
		soapModel.setItpStatus(model.getItpStatus());
		soapModel.setIptComments(model.getIptComments());
		soapModel.setFinanceTasks(model.getFinanceTasks());
		soapModel.setFinanceStatus(model.getFinanceStatus());
		soapModel.setFinanceComments(model.getFinanceComments());

		return soapModel;
	}

	public static EOnBoardingSoap[] toSoapModels(EOnBoarding[] models) {
		EOnBoardingSoap[] soapModels = new EOnBoardingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EOnBoardingSoap[][] toSoapModels(EOnBoarding[][] models) {
		EOnBoardingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EOnBoardingSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EOnBoardingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EOnBoardingSoap[] toSoapModels(List<EOnBoarding> models) {
		List<EOnBoardingSoap> soapModels = new ArrayList<EOnBoardingSoap>(models.size());

		for (EOnBoarding model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EOnBoardingSoap[soapModels.size()]);
	}

	public EOnBoardingSoap() {
	}

	public long getPrimaryKey() {
		return _eOnBoardingId;
	}

	public void setPrimaryKey(long pk) {
		setEOnBoardingId(pk);
	}

	public long getEOnBoardingId() {
		return _eOnBoardingId;
	}

	public void setEOnBoardingId(long eOnBoardingId) {
		_eOnBoardingId = eOnBoardingId;
	}

	public String getTicketNo() {
		return _ticketNo;
	}

	public void setTicketNo(String ticketNo) {
		_ticketNo = ticketNo;
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

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
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

	public long getModifiedUserId() {
		return _modifiedUserId;
	}

	public void setModifiedUserId(long modifiedUserId) {
		_modifiedUserId = modifiedUserId;
	}

	public String getModifiedUserName() {
		return _modifiedUserName;
	}

	public void setModifiedUserName(String modifiedUserName) {
		_modifiedUserName = modifiedUserName;
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

	public String getStaffCode() {
		return _staffCode;
	}

	public void setStaffCode(String staffCode) {
		_staffCode = staffCode;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getGender() {
		return _gender;
	}

	public void setGender(String gender) {
		_gender = gender;
	}

	public Date getBirthday() {
		return _birthday;
	}

	public void setBirthday(Date birthday) {
		_birthday = birthday;
	}

	public String getPhotoPath() {
		return _photoPath;
	}

	public void setPhotoPath(String photoPath) {
		_photoPath = photoPath;
	}

	public String getContractType() {
		return _contractType;
	}

	public void setContractType(String contractType) {
		_contractType = contractType;
	}

	public String getWorkLocation() {
		return _workLocation;
	}

	public void setWorkLocation(String workLocation) {
		_workLocation = workLocation;
	}

	public String getDivision() {
		return _division;
	}

	public void setDivision(String division) {
		_division = division;
	}

	public String getOfficeSite() {
		return _officeSite;
	}

	public void setOfficeSite(String officeSite) {
		_officeSite = officeSite;
	}

	public String getDepartment() {
		return _department;
	}

	public void setDepartment(String department) {
		_department = department;
	}

	public Date getStartingDate() {
		return _startingDate;
	}

	public void setStartingDate(Date startingDate) {
		_startingDate = startingDate;
	}

	public String getPositionCode() {
		return _positionCode;
	}

	public void setPositionCode(String positionCode) {
		_positionCode = positionCode;
	}

	public String getServiceLength() {
		return _serviceLength;
	}

	public void setServiceLength(String serviceLength) {
		_serviceLength = serviceLength;
	}

	public String getFunctionName() {
		return _functionName;
	}

	public void setFunctionName(String functionName) {
		_functionName = functionName;
	}

	public String getReportTo() {
		return _reportTo;
	}

	public void setReportTo(String reportTo) {
		_reportTo = reportTo;
	}

	public String getReportToStaffName() {
		return _reportToStaffName;
	}

	public void setReportToStaffName(String reportToStaffName) {
		_reportToStaffName = reportToStaffName;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getCostCenter() {
		return _costCenter;
	}

	public void setCostCenter(String costCenter) {
		_costCenter = costCenter;
	}

	public boolean getItRelatedHardware() {
		return _itRelatedHardware;
	}

	public boolean isItRelatedHardware() {
		return _itRelatedHardware;
	}

	public void setItRelatedHardware(boolean itRelatedHardware) {
		_itRelatedHardware = itRelatedHardware;
	}

	public boolean getCompanyCar() {
		return _companyCar;
	}

	public boolean isCompanyCar() {
		return _companyCar;
	}

	public void setCompanyCar(boolean companyCar) {
		_companyCar = companyCar;
	}

	public boolean getReplacement() {
		return _replacement;
	}

	public boolean isReplacement() {
		return _replacement;
	}

	public void setReplacement(boolean replacement) {
		_replacement = replacement;
	}

	public String getNameOfReplacedPerson() {
		return _nameOfReplacedPerson;
	}

	public void setNameOfReplacedPerson(String nameOfReplacedPerson) {
		_nameOfReplacedPerson = nameOfReplacedPerson;
	}

	public String getContactInfo() {
		return _contactInfo;
	}

	public void setContactInfo(String contactInfo) {
		_contactInfo = contactInfo;
	}

	public String getComments() {
		return _comments;
	}

	public void setComments(String comments) {
		_comments = comments;
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

	public String getAdminEntitlement() {
		return _adminEntitlement;
	}

	public void setAdminEntitlement(String adminEntitlement) {
		_adminEntitlement = adminEntitlement;
	}

	public String getAdminSeatNo() {
		return _adminSeatNo;
	}

	public void setAdminSeatNo(String adminSeatNo) {
		_adminSeatNo = adminSeatNo;
	}

	public String getAdminTasks() {
		return _adminTasks;
	}

	public void setAdminTasks(String adminTasks) {
		_adminTasks = adminTasks;
	}

	public String getAdminStatus() {
		return _adminStatus;
	}

	public void setAdminStatus(String adminStatus) {
		_adminStatus = adminStatus;
	}

	public String getAdminComments() {
		return _adminComments;
	}

	public void setAdminComments(String adminComments) {
		_adminComments = adminComments;
	}

	public String getSecurityTasks() {
		return _securityTasks;
	}

	public void setSecurityTasks(String securityTasks) {
		_securityTasks = securityTasks;
	}

	public String getSecurityStatus() {
		return _securityStatus;
	}

	public void setSecurityStatus(String securityStatus) {
		_securityStatus = securityStatus;
	}

	public String getSecurityComments() {
		return _securityComments;
	}

	public void setSecurityComments(String securityComments) {
		_securityComments = securityComments;
	}

	public String getItpTasks() {
		return _itpTasks;
	}

	public void setItpTasks(String itpTasks) {
		_itpTasks = itpTasks;
	}

	public String getItpStatus() {
		return _itpStatus;
	}

	public void setItpStatus(String itpStatus) {
		_itpStatus = itpStatus;
	}

	public String getIptComments() {
		return _iptComments;
	}

	public void setIptComments(String iptComments) {
		_iptComments = iptComments;
	}

	public String getFinanceTasks() {
		return _financeTasks;
	}

	public void setFinanceTasks(String financeTasks) {
		_financeTasks = financeTasks;
	}

	public String getFinanceStatus() {
		return _financeStatus;
	}

	public void setFinanceStatus(String financeStatus) {
		_financeStatus = financeStatus;
	}

	public String getFinanceComments() {
		return _financeComments;
	}

	public void setFinanceComments(String financeComments) {
		_financeComments = financeComments;
	}

	private long _eOnBoardingId;
	private String _ticketNo;
	private String _processType;
	private String _subType;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _submittedDate;
	private long _modifiedUserId;
	private String _modifiedUserName;
	private int _status;
	private long _statusByUserId;
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
}