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

package com.e.closing.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link EClosing}.
 * </p>
 *
 * @author t.a.jiang
 * @see EClosing
 * @generated
 */
public class EClosingWrapper implements EClosing, ModelWrapper<EClosing> {
	public EClosingWrapper(EClosing eClosing) {
		_eClosing = eClosing;
	}

	@Override
	public Class<?> getModelClass() {
		return EClosing.class;
	}

	@Override
	public String getModelClassName() {
		return EClosing.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("eclosingId", getEclosingId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("ticketNo", getTicketNo());
		attributes.put("staffCode", getStaffCode());
		attributes.put("staffName", getStaffName());
		attributes.put("company", getCompany());
		attributes.put("division", getDivision());
		attributes.put("department", getDepartment());
		attributes.put("costCenter", getCostCenter());
		attributes.put("functionName", getFunctionName());
		attributes.put("positionCode", getPositionCode());
		attributes.put("employeeGroupId", getEmployeeGroupId());
		attributes.put("employeeGroupName", getEmployeeGroupName());
		attributes.put("privateEmailAddress", getPrivateEmailAddress());
		attributes.put("startingDate", getStartingDate());
		attributes.put("lastWorkingDay", getLastWorkingDay());
		attributes.put("finishContractDate", getFinishContractDate());
		attributes.put("seatOfficeNumber", getSeatOfficeNumber());
		attributes.put("permanentAddress", getPermanentAddress());
		attributes.put("dmOption1", getDmOption1());
		attributes.put("dmOption2", getDmOption2());
		attributes.put("dmStatus", getDmStatus());
		attributes.put("dmComments", getDmComments());
		attributes.put("adOption1", getAdOption1());
		attributes.put("adOption2", getAdOption2());
		attributes.put("adOption3", getAdOption3());
		attributes.put("adOption4", getAdOption4());
		attributes.put("adFinanceFee", getAdFinanceFee());
		attributes.put("adStatus", getAdStatus());
		attributes.put("adComments", getAdComments());
		attributes.put("fsOption1", getFsOption1());
		attributes.put("fsStatus", getFsStatus());
		attributes.put("fsComments", getFsComments());
		attributes.put("flcOption1", getFlcOption1());
		attributes.put("flcOption2", getFlcOption2());
		attributes.put("flcStatus", getFlcStatus());
		attributes.put("flcComments", getFlcComments());
		attributes.put("securityOption1", getSecurityOption1());
		attributes.put("securityFinanceFee", getSecurityFinanceFee());
		attributes.put("securityStatus", getSecurityStatus());
		attributes.put("securityComments", getSecurityComments());
		attributes.put("idOption1", getIdOption1());
		attributes.put("idOption2", getIdOption2());
		attributes.put("idOption3", getIdOption3());
		attributes.put("idOption4", getIdOption4());
		attributes.put("idOption5", getIdOption5());
		attributes.put("idOption6", getIdOption6());
		attributes.put("idOption7", getIdOption7());
		attributes.put("idOption8", getIdOption8());
		attributes.put("idOption9", getIdOption9());
		attributes.put("idHrFee", getIdHrFee());
		attributes.put("idFinanceFee", getIdFinanceFee());
		attributes.put("idStatus", getIdStatus());
		attributes.put("idComments", getIdComments());
		attributes.put("htdOption1", getHtdOption1());
		attributes.put("htdHrFee", getHtdHrFee());
		attributes.put("htdFinanceFee", getHtdFinanceFee());
		attributes.put("htdStatus", getHtdStatus());
		attributes.put("htdComments", getHtdComments());
		attributes.put("hdOption1", getHdOption1());
		attributes.put("hdOption2", getHdOption2());
		attributes.put("hdOption2Text", getHdOption2Text());
		attributes.put("hdOption3", getHdOption3());
		attributes.put("hdOption3Money", getHdOption3Money());
		attributes.put("hdOption4", getHdOption4());
		attributes.put("hdOption4Money", getHdOption4Money());
		attributes.put("hdStatus", getHdStatus());
		attributes.put("hdComments", getHdComments());
		attributes.put("hdleaveText", getHdleaveText());
		attributes.put("fdOption1", getFdOption1());
		attributes.put("fdOption2", getFdOption2());
		attributes.put("fdOption3", getFdOption3());
		attributes.put("fdOption4", getFdOption4());
		attributes.put("fdOption4Text", getFdOption4Text());
		attributes.put("fdStatus", getFdStatus());
		attributes.put("fdComments", getFdComments());
		attributes.put("applicantAgent", getApplicantAgent());
		attributes.put("approverAgent", getApproverAgent());
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
		Long eclosingId = (Long)attributes.get("eclosingId");

		if (eclosingId != null) {
			setEclosingId(eclosingId);
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

		String ticketNo = (String)attributes.get("ticketNo");

		if (ticketNo != null) {
			setTicketNo(ticketNo);
		}

		Integer staffCode = (Integer)attributes.get("staffCode");

		if (staffCode != null) {
			setStaffCode(staffCode);
		}

		String staffName = (String)attributes.get("staffName");

		if (staffName != null) {
			setStaffName(staffName);
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

		String functionName = (String)attributes.get("functionName");

		if (functionName != null) {
			setFunctionName(functionName);
		}

		String positionCode = (String)attributes.get("positionCode");

		if (positionCode != null) {
			setPositionCode(positionCode);
		}

		String employeeGroupId = (String)attributes.get("employeeGroupId");

		if (employeeGroupId != null) {
			setEmployeeGroupId(employeeGroupId);
		}

		String employeeGroupName = (String)attributes.get("employeeGroupName");

		if (employeeGroupName != null) {
			setEmployeeGroupName(employeeGroupName);
		}

		String privateEmailAddress = (String)attributes.get(
				"privateEmailAddress");

		if (privateEmailAddress != null) {
			setPrivateEmailAddress(privateEmailAddress);
		}

		Date startingDate = (Date)attributes.get("startingDate");

		if (startingDate != null) {
			setStartingDate(startingDate);
		}

		Date lastWorkingDay = (Date)attributes.get("lastWorkingDay");

		if (lastWorkingDay != null) {
			setLastWorkingDay(lastWorkingDay);
		}

		Date finishContractDate = (Date)attributes.get("finishContractDate");

		if (finishContractDate != null) {
			setFinishContractDate(finishContractDate);
		}

		String seatOfficeNumber = (String)attributes.get("seatOfficeNumber");

		if (seatOfficeNumber != null) {
			setSeatOfficeNumber(seatOfficeNumber);
		}

		String permanentAddress = (String)attributes.get("permanentAddress");

		if (permanentAddress != null) {
			setPermanentAddress(permanentAddress);
		}

		Boolean dmOption1 = (Boolean)attributes.get("dmOption1");

		if (dmOption1 != null) {
			setDmOption1(dmOption1);
		}

		Boolean dmOption2 = (Boolean)attributes.get("dmOption2");

		if (dmOption2 != null) {
			setDmOption2(dmOption2);
		}

		String dmStatus = (String)attributes.get("dmStatus");

		if (dmStatus != null) {
			setDmStatus(dmStatus);
		}

		String dmComments = (String)attributes.get("dmComments");

		if (dmComments != null) {
			setDmComments(dmComments);
		}

		Boolean adOption1 = (Boolean)attributes.get("adOption1");

		if (adOption1 != null) {
			setAdOption1(adOption1);
		}

		Boolean adOption2 = (Boolean)attributes.get("adOption2");

		if (adOption2 != null) {
			setAdOption2(adOption2);
		}

		Boolean adOption3 = (Boolean)attributes.get("adOption3");

		if (adOption3 != null) {
			setAdOption3(adOption3);
		}

		Boolean adOption4 = (Boolean)attributes.get("adOption4");

		if (adOption4 != null) {
			setAdOption4(adOption4);
		}

		Double adFinanceFee = (Double)attributes.get("adFinanceFee");

		if (adFinanceFee != null) {
			setAdFinanceFee(adFinanceFee);
		}

		String adStatus = (String)attributes.get("adStatus");

		if (adStatus != null) {
			setAdStatus(adStatus);
		}

		String adComments = (String)attributes.get("adComments");

		if (adComments != null) {
			setAdComments(adComments);
		}

		Boolean fsOption1 = (Boolean)attributes.get("fsOption1");

		if (fsOption1 != null) {
			setFsOption1(fsOption1);
		}

		String fsStatus = (String)attributes.get("fsStatus");

		if (fsStatus != null) {
			setFsStatus(fsStatus);
		}

		String fsComments = (String)attributes.get("fsComments");

		if (fsComments != null) {
			setFsComments(fsComments);
		}

		Boolean flcOption1 = (Boolean)attributes.get("flcOption1");

		if (flcOption1 != null) {
			setFlcOption1(flcOption1);
		}

		Boolean flcOption2 = (Boolean)attributes.get("flcOption2");

		if (flcOption2 != null) {
			setFlcOption2(flcOption2);
		}

		String flcStatus = (String)attributes.get("flcStatus");

		if (flcStatus != null) {
			setFlcStatus(flcStatus);
		}

		String flcComments = (String)attributes.get("flcComments");

		if (flcComments != null) {
			setFlcComments(flcComments);
		}

		Boolean securityOption1 = (Boolean)attributes.get("securityOption1");

		if (securityOption1 != null) {
			setSecurityOption1(securityOption1);
		}

		Double securityFinanceFee = (Double)attributes.get("securityFinanceFee");

		if (securityFinanceFee != null) {
			setSecurityFinanceFee(securityFinanceFee);
		}

		String securityStatus = (String)attributes.get("securityStatus");

		if (securityStatus != null) {
			setSecurityStatus(securityStatus);
		}

		String securityComments = (String)attributes.get("securityComments");

		if (securityComments != null) {
			setSecurityComments(securityComments);
		}

		Boolean idOption1 = (Boolean)attributes.get("idOption1");

		if (idOption1 != null) {
			setIdOption1(idOption1);
		}

		Boolean idOption2 = (Boolean)attributes.get("idOption2");

		if (idOption2 != null) {
			setIdOption2(idOption2);
		}

		Boolean idOption3 = (Boolean)attributes.get("idOption3");

		if (idOption3 != null) {
			setIdOption3(idOption3);
		}

		Boolean idOption4 = (Boolean)attributes.get("idOption4");

		if (idOption4 != null) {
			setIdOption4(idOption4);
		}

		Boolean idOption5 = (Boolean)attributes.get("idOption5");

		if (idOption5 != null) {
			setIdOption5(idOption5);
		}

		Boolean idOption6 = (Boolean)attributes.get("idOption6");

		if (idOption6 != null) {
			setIdOption6(idOption6);
		}

		Boolean idOption7 = (Boolean)attributes.get("idOption7");

		if (idOption7 != null) {
			setIdOption7(idOption7);
		}

		Boolean idOption8 = (Boolean)attributes.get("idOption8");

		if (idOption8 != null) {
			setIdOption8(idOption8);
		}

		Boolean idOption9 = (Boolean)attributes.get("idOption9");

		if (idOption9 != null) {
			setIdOption9(idOption9);
		}

		Double idHrFee = (Double)attributes.get("idHrFee");

		if (idHrFee != null) {
			setIdHrFee(idHrFee);
		}

		Double idFinanceFee = (Double)attributes.get("idFinanceFee");

		if (idFinanceFee != null) {
			setIdFinanceFee(idFinanceFee);
		}

		String idStatus = (String)attributes.get("idStatus");

		if (idStatus != null) {
			setIdStatus(idStatus);
		}

		String idComments = (String)attributes.get("idComments");

		if (idComments != null) {
			setIdComments(idComments);
		}

		Boolean htdOption1 = (Boolean)attributes.get("htdOption1");

		if (htdOption1 != null) {
			setHtdOption1(htdOption1);
		}

		Double htdHrFee = (Double)attributes.get("htdHrFee");

		if (htdHrFee != null) {
			setHtdHrFee(htdHrFee);
		}

		Double htdFinanceFee = (Double)attributes.get("htdFinanceFee");

		if (htdFinanceFee != null) {
			setHtdFinanceFee(htdFinanceFee);
		}

		String htdStatus = (String)attributes.get("htdStatus");

		if (htdStatus != null) {
			setHtdStatus(htdStatus);
		}

		String htdComments = (String)attributes.get("htdComments");

		if (htdComments != null) {
			setHtdComments(htdComments);
		}

		Boolean hdOption1 = (Boolean)attributes.get("hdOption1");

		if (hdOption1 != null) {
			setHdOption1(hdOption1);
		}

		Boolean hdOption2 = (Boolean)attributes.get("hdOption2");

		if (hdOption2 != null) {
			setHdOption2(hdOption2);
		}

		String hdOption2Text = (String)attributes.get("hdOption2Text");

		if (hdOption2Text != null) {
			setHdOption2Text(hdOption2Text);
		}

		Boolean hdOption3 = (Boolean)attributes.get("hdOption3");

		if (hdOption3 != null) {
			setHdOption3(hdOption3);
		}

		Double hdOption3Money = (Double)attributes.get("hdOption3Money");

		if (hdOption3Money != null) {
			setHdOption3Money(hdOption3Money);
		}

		Boolean hdOption4 = (Boolean)attributes.get("hdOption4");

		if (hdOption4 != null) {
			setHdOption4(hdOption4);
		}

		Double hdOption4Money = (Double)attributes.get("hdOption4Money");

		if (hdOption4Money != null) {
			setHdOption4Money(hdOption4Money);
		}

		String hdStatus = (String)attributes.get("hdStatus");

		if (hdStatus != null) {
			setHdStatus(hdStatus);
		}

		String hdComments = (String)attributes.get("hdComments");

		if (hdComments != null) {
			setHdComments(hdComments);
		}

		String hdleaveText = (String)attributes.get("hdleaveText");

		if (hdleaveText != null) {
			setHdleaveText(hdleaveText);
		}

		Boolean fdOption1 = (Boolean)attributes.get("fdOption1");

		if (fdOption1 != null) {
			setFdOption1(fdOption1);
		}

		Boolean fdOption2 = (Boolean)attributes.get("fdOption2");

		if (fdOption2 != null) {
			setFdOption2(fdOption2);
		}

		Boolean fdOption3 = (Boolean)attributes.get("fdOption3");

		if (fdOption3 != null) {
			setFdOption3(fdOption3);
		}

		Boolean fdOption4 = (Boolean)attributes.get("fdOption4");

		if (fdOption4 != null) {
			setFdOption4(fdOption4);
		}

		String fdOption4Text = (String)attributes.get("fdOption4Text");

		if (fdOption4Text != null) {
			setFdOption4Text(fdOption4Text);
		}

		String fdStatus = (String)attributes.get("fdStatus");

		if (fdStatus != null) {
			setFdStatus(fdStatus);
		}

		String fdComments = (String)attributes.get("fdComments");

		if (fdComments != null) {
			setFdComments(fdComments);
		}

		Boolean applicantAgent = (Boolean)attributes.get("applicantAgent");

		if (applicantAgent != null) {
			setApplicantAgent(applicantAgent);
		}

		Boolean approverAgent = (Boolean)attributes.get("approverAgent");

		if (approverAgent != null) {
			setApproverAgent(approverAgent);
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
	* Returns the primary key of this e closing.
	*
	* @return the primary key of this e closing
	*/
	@Override
	public long getPrimaryKey() {
		return _eClosing.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e closing.
	*
	* @param primaryKey the primary key of this e closing
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_eClosing.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the eclosing ID of this e closing.
	*
	* @return the eclosing ID of this e closing
	*/
	@Override
	public long getEclosingId() {
		return _eClosing.getEclosingId();
	}

	/**
	* Sets the eclosing ID of this e closing.
	*
	* @param eclosingId the eclosing ID of this e closing
	*/
	@Override
	public void setEclosingId(long eclosingId) {
		_eClosing.setEclosingId(eclosingId);
	}

	/**
	* Returns the group ID of this e closing.
	*
	* @return the group ID of this e closing
	*/
	@Override
	public long getGroupId() {
		return _eClosing.getGroupId();
	}

	/**
	* Sets the group ID of this e closing.
	*
	* @param groupId the group ID of this e closing
	*/
	@Override
	public void setGroupId(long groupId) {
		_eClosing.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this e closing.
	*
	* @return the company ID of this e closing
	*/
	@Override
	public long getCompanyId() {
		return _eClosing.getCompanyId();
	}

	/**
	* Sets the company ID of this e closing.
	*
	* @param companyId the company ID of this e closing
	*/
	@Override
	public void setCompanyId(long companyId) {
		_eClosing.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this e closing.
	*
	* @return the user ID of this e closing
	*/
	@Override
	public long getUserId() {
		return _eClosing.getUserId();
	}

	/**
	* Sets the user ID of this e closing.
	*
	* @param userId the user ID of this e closing
	*/
	@Override
	public void setUserId(long userId) {
		_eClosing.setUserId(userId);
	}

	/**
	* Returns the user uuid of this e closing.
	*
	* @return the user uuid of this e closing
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eClosing.getUserUuid();
	}

	/**
	* Sets the user uuid of this e closing.
	*
	* @param userUuid the user uuid of this e closing
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_eClosing.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this e closing.
	*
	* @return the user name of this e closing
	*/
	@Override
	public java.lang.String getUserName() {
		return _eClosing.getUserName();
	}

	/**
	* Sets the user name of this e closing.
	*
	* @param userName the user name of this e closing
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_eClosing.setUserName(userName);
	}

	/**
	* Returns the create date of this e closing.
	*
	* @return the create date of this e closing
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _eClosing.getCreateDate();
	}

	/**
	* Sets the create date of this e closing.
	*
	* @param createDate the create date of this e closing
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_eClosing.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this e closing.
	*
	* @return the modified date of this e closing
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _eClosing.getModifiedDate();
	}

	/**
	* Sets the modified date of this e closing.
	*
	* @param modifiedDate the modified date of this e closing
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_eClosing.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the ticket no of this e closing.
	*
	* @return the ticket no of this e closing
	*/
	@Override
	public java.lang.String getTicketNo() {
		return _eClosing.getTicketNo();
	}

	/**
	* Sets the ticket no of this e closing.
	*
	* @param ticketNo the ticket no of this e closing
	*/
	@Override
	public void setTicketNo(java.lang.String ticketNo) {
		_eClosing.setTicketNo(ticketNo);
	}

	/**
	* Returns the staff code of this e closing.
	*
	* @return the staff code of this e closing
	*/
	@Override
	public int getStaffCode() {
		return _eClosing.getStaffCode();
	}

	/**
	* Sets the staff code of this e closing.
	*
	* @param staffCode the staff code of this e closing
	*/
	@Override
	public void setStaffCode(int staffCode) {
		_eClosing.setStaffCode(staffCode);
	}

	/**
	* Returns the staff name of this e closing.
	*
	* @return the staff name of this e closing
	*/
	@Override
	public java.lang.String getStaffName() {
		return _eClosing.getStaffName();
	}

	/**
	* Sets the staff name of this e closing.
	*
	* @param staffName the staff name of this e closing
	*/
	@Override
	public void setStaffName(java.lang.String staffName) {
		_eClosing.setStaffName(staffName);
	}

	/**
	* Returns the company of this e closing.
	*
	* @return the company of this e closing
	*/
	@Override
	public java.lang.String getCompany() {
		return _eClosing.getCompany();
	}

	/**
	* Sets the company of this e closing.
	*
	* @param company the company of this e closing
	*/
	@Override
	public void setCompany(java.lang.String company) {
		_eClosing.setCompany(company);
	}

	/**
	* Returns the division of this e closing.
	*
	* @return the division of this e closing
	*/
	@Override
	public java.lang.String getDivision() {
		return _eClosing.getDivision();
	}

	/**
	* Sets the division of this e closing.
	*
	* @param division the division of this e closing
	*/
	@Override
	public void setDivision(java.lang.String division) {
		_eClosing.setDivision(division);
	}

	/**
	* Returns the department of this e closing.
	*
	* @return the department of this e closing
	*/
	@Override
	public java.lang.String getDepartment() {
		return _eClosing.getDepartment();
	}

	/**
	* Sets the department of this e closing.
	*
	* @param department the department of this e closing
	*/
	@Override
	public void setDepartment(java.lang.String department) {
		_eClosing.setDepartment(department);
	}

	/**
	* Returns the cost center of this e closing.
	*
	* @return the cost center of this e closing
	*/
	@Override
	public java.lang.String getCostCenter() {
		return _eClosing.getCostCenter();
	}

	/**
	* Sets the cost center of this e closing.
	*
	* @param costCenter the cost center of this e closing
	*/
	@Override
	public void setCostCenter(java.lang.String costCenter) {
		_eClosing.setCostCenter(costCenter);
	}

	/**
	* Returns the function name of this e closing.
	*
	* @return the function name of this e closing
	*/
	@Override
	public java.lang.String getFunctionName() {
		return _eClosing.getFunctionName();
	}

	/**
	* Sets the function name of this e closing.
	*
	* @param functionName the function name of this e closing
	*/
	@Override
	public void setFunctionName(java.lang.String functionName) {
		_eClosing.setFunctionName(functionName);
	}

	/**
	* Returns the position code of this e closing.
	*
	* @return the position code of this e closing
	*/
	@Override
	public java.lang.String getPositionCode() {
		return _eClosing.getPositionCode();
	}

	/**
	* Sets the position code of this e closing.
	*
	* @param positionCode the position code of this e closing
	*/
	@Override
	public void setPositionCode(java.lang.String positionCode) {
		_eClosing.setPositionCode(positionCode);
	}

	/**
	* Returns the employee group ID of this e closing.
	*
	* @return the employee group ID of this e closing
	*/
	@Override
	public java.lang.String getEmployeeGroupId() {
		return _eClosing.getEmployeeGroupId();
	}

	/**
	* Sets the employee group ID of this e closing.
	*
	* @param employeeGroupId the employee group ID of this e closing
	*/
	@Override
	public void setEmployeeGroupId(java.lang.String employeeGroupId) {
		_eClosing.setEmployeeGroupId(employeeGroupId);
	}

	/**
	* Returns the employee group name of this e closing.
	*
	* @return the employee group name of this e closing
	*/
	@Override
	public java.lang.String getEmployeeGroupName() {
		return _eClosing.getEmployeeGroupName();
	}

	/**
	* Sets the employee group name of this e closing.
	*
	* @param employeeGroupName the employee group name of this e closing
	*/
	@Override
	public void setEmployeeGroupName(java.lang.String employeeGroupName) {
		_eClosing.setEmployeeGroupName(employeeGroupName);
	}

	/**
	* Returns the private email address of this e closing.
	*
	* @return the private email address of this e closing
	*/
	@Override
	public java.lang.String getPrivateEmailAddress() {
		return _eClosing.getPrivateEmailAddress();
	}

	/**
	* Sets the private email address of this e closing.
	*
	* @param privateEmailAddress the private email address of this e closing
	*/
	@Override
	public void setPrivateEmailAddress(java.lang.String privateEmailAddress) {
		_eClosing.setPrivateEmailAddress(privateEmailAddress);
	}

	/**
	* Returns the starting date of this e closing.
	*
	* @return the starting date of this e closing
	*/
	@Override
	public java.util.Date getStartingDate() {
		return _eClosing.getStartingDate();
	}

	/**
	* Sets the starting date of this e closing.
	*
	* @param startingDate the starting date of this e closing
	*/
	@Override
	public void setStartingDate(java.util.Date startingDate) {
		_eClosing.setStartingDate(startingDate);
	}

	/**
	* Returns the last working day of this e closing.
	*
	* @return the last working day of this e closing
	*/
	@Override
	public java.util.Date getLastWorkingDay() {
		return _eClosing.getLastWorkingDay();
	}

	/**
	* Sets the last working day of this e closing.
	*
	* @param lastWorkingDay the last working day of this e closing
	*/
	@Override
	public void setLastWorkingDay(java.util.Date lastWorkingDay) {
		_eClosing.setLastWorkingDay(lastWorkingDay);
	}

	/**
	* Returns the finish contract date of this e closing.
	*
	* @return the finish contract date of this e closing
	*/
	@Override
	public java.util.Date getFinishContractDate() {
		return _eClosing.getFinishContractDate();
	}

	/**
	* Sets the finish contract date of this e closing.
	*
	* @param finishContractDate the finish contract date of this e closing
	*/
	@Override
	public void setFinishContractDate(java.util.Date finishContractDate) {
		_eClosing.setFinishContractDate(finishContractDate);
	}

	/**
	* Returns the seat office number of this e closing.
	*
	* @return the seat office number of this e closing
	*/
	@Override
	public java.lang.String getSeatOfficeNumber() {
		return _eClosing.getSeatOfficeNumber();
	}

	/**
	* Sets the seat office number of this e closing.
	*
	* @param seatOfficeNumber the seat office number of this e closing
	*/
	@Override
	public void setSeatOfficeNumber(java.lang.String seatOfficeNumber) {
		_eClosing.setSeatOfficeNumber(seatOfficeNumber);
	}

	/**
	* Returns the permanent address of this e closing.
	*
	* @return the permanent address of this e closing
	*/
	@Override
	public java.lang.String getPermanentAddress() {
		return _eClosing.getPermanentAddress();
	}

	/**
	* Sets the permanent address of this e closing.
	*
	* @param permanentAddress the permanent address of this e closing
	*/
	@Override
	public void setPermanentAddress(java.lang.String permanentAddress) {
		_eClosing.setPermanentAddress(permanentAddress);
	}

	/**
	* Returns the dm option1 of this e closing.
	*
	* @return the dm option1 of this e closing
	*/
	@Override
	public boolean getDmOption1() {
		return _eClosing.getDmOption1();
	}

	/**
	* Returns <code>true</code> if this e closing is dm option1.
	*
	* @return <code>true</code> if this e closing is dm option1; <code>false</code> otherwise
	*/
	@Override
	public boolean isDmOption1() {
		return _eClosing.isDmOption1();
	}

	/**
	* Sets whether this e closing is dm option1.
	*
	* @param dmOption1 the dm option1 of this e closing
	*/
	@Override
	public void setDmOption1(boolean dmOption1) {
		_eClosing.setDmOption1(dmOption1);
	}

	/**
	* Returns the dm option2 of this e closing.
	*
	* @return the dm option2 of this e closing
	*/
	@Override
	public boolean getDmOption2() {
		return _eClosing.getDmOption2();
	}

	/**
	* Returns <code>true</code> if this e closing is dm option2.
	*
	* @return <code>true</code> if this e closing is dm option2; <code>false</code> otherwise
	*/
	@Override
	public boolean isDmOption2() {
		return _eClosing.isDmOption2();
	}

	/**
	* Sets whether this e closing is dm option2.
	*
	* @param dmOption2 the dm option2 of this e closing
	*/
	@Override
	public void setDmOption2(boolean dmOption2) {
		_eClosing.setDmOption2(dmOption2);
	}

	/**
	* Returns the dm status of this e closing.
	*
	* @return the dm status of this e closing
	*/
	@Override
	public java.lang.String getDmStatus() {
		return _eClosing.getDmStatus();
	}

	/**
	* Sets the dm status of this e closing.
	*
	* @param dmStatus the dm status of this e closing
	*/
	@Override
	public void setDmStatus(java.lang.String dmStatus) {
		_eClosing.setDmStatus(dmStatus);
	}

	/**
	* Returns the dm comments of this e closing.
	*
	* @return the dm comments of this e closing
	*/
	@Override
	public java.lang.String getDmComments() {
		return _eClosing.getDmComments();
	}

	/**
	* Sets the dm comments of this e closing.
	*
	* @param dmComments the dm comments of this e closing
	*/
	@Override
	public void setDmComments(java.lang.String dmComments) {
		_eClosing.setDmComments(dmComments);
	}

	/**
	* Returns the ad option1 of this e closing.
	*
	* @return the ad option1 of this e closing
	*/
	@Override
	public boolean getAdOption1() {
		return _eClosing.getAdOption1();
	}

	/**
	* Returns <code>true</code> if this e closing is ad option1.
	*
	* @return <code>true</code> if this e closing is ad option1; <code>false</code> otherwise
	*/
	@Override
	public boolean isAdOption1() {
		return _eClosing.isAdOption1();
	}

	/**
	* Sets whether this e closing is ad option1.
	*
	* @param adOption1 the ad option1 of this e closing
	*/
	@Override
	public void setAdOption1(boolean adOption1) {
		_eClosing.setAdOption1(adOption1);
	}

	/**
	* Returns the ad option2 of this e closing.
	*
	* @return the ad option2 of this e closing
	*/
	@Override
	public boolean getAdOption2() {
		return _eClosing.getAdOption2();
	}

	/**
	* Returns <code>true</code> if this e closing is ad option2.
	*
	* @return <code>true</code> if this e closing is ad option2; <code>false</code> otherwise
	*/
	@Override
	public boolean isAdOption2() {
		return _eClosing.isAdOption2();
	}

	/**
	* Sets whether this e closing is ad option2.
	*
	* @param adOption2 the ad option2 of this e closing
	*/
	@Override
	public void setAdOption2(boolean adOption2) {
		_eClosing.setAdOption2(adOption2);
	}

	/**
	* Returns the ad option3 of this e closing.
	*
	* @return the ad option3 of this e closing
	*/
	@Override
	public boolean getAdOption3() {
		return _eClosing.getAdOption3();
	}

	/**
	* Returns <code>true</code> if this e closing is ad option3.
	*
	* @return <code>true</code> if this e closing is ad option3; <code>false</code> otherwise
	*/
	@Override
	public boolean isAdOption3() {
		return _eClosing.isAdOption3();
	}

	/**
	* Sets whether this e closing is ad option3.
	*
	* @param adOption3 the ad option3 of this e closing
	*/
	@Override
	public void setAdOption3(boolean adOption3) {
		_eClosing.setAdOption3(adOption3);
	}

	/**
	* Returns the ad option4 of this e closing.
	*
	* @return the ad option4 of this e closing
	*/
	@Override
	public boolean getAdOption4() {
		return _eClosing.getAdOption4();
	}

	/**
	* Returns <code>true</code> if this e closing is ad option4.
	*
	* @return <code>true</code> if this e closing is ad option4; <code>false</code> otherwise
	*/
	@Override
	public boolean isAdOption4() {
		return _eClosing.isAdOption4();
	}

	/**
	* Sets whether this e closing is ad option4.
	*
	* @param adOption4 the ad option4 of this e closing
	*/
	@Override
	public void setAdOption4(boolean adOption4) {
		_eClosing.setAdOption4(adOption4);
	}

	/**
	* Returns the ad finance fee of this e closing.
	*
	* @return the ad finance fee of this e closing
	*/
	@Override
	public double getAdFinanceFee() {
		return _eClosing.getAdFinanceFee();
	}

	/**
	* Sets the ad finance fee of this e closing.
	*
	* @param adFinanceFee the ad finance fee of this e closing
	*/
	@Override
	public void setAdFinanceFee(double adFinanceFee) {
		_eClosing.setAdFinanceFee(adFinanceFee);
	}

	/**
	* Returns the ad status of this e closing.
	*
	* @return the ad status of this e closing
	*/
	@Override
	public java.lang.String getAdStatus() {
		return _eClosing.getAdStatus();
	}

	/**
	* Sets the ad status of this e closing.
	*
	* @param adStatus the ad status of this e closing
	*/
	@Override
	public void setAdStatus(java.lang.String adStatus) {
		_eClosing.setAdStatus(adStatus);
	}

	/**
	* Returns the ad comments of this e closing.
	*
	* @return the ad comments of this e closing
	*/
	@Override
	public java.lang.String getAdComments() {
		return _eClosing.getAdComments();
	}

	/**
	* Sets the ad comments of this e closing.
	*
	* @param adComments the ad comments of this e closing
	*/
	@Override
	public void setAdComments(java.lang.String adComments) {
		_eClosing.setAdComments(adComments);
	}

	/**
	* Returns the fs option1 of this e closing.
	*
	* @return the fs option1 of this e closing
	*/
	@Override
	public boolean getFsOption1() {
		return _eClosing.getFsOption1();
	}

	/**
	* Returns <code>true</code> if this e closing is fs option1.
	*
	* @return <code>true</code> if this e closing is fs option1; <code>false</code> otherwise
	*/
	@Override
	public boolean isFsOption1() {
		return _eClosing.isFsOption1();
	}

	/**
	* Sets whether this e closing is fs option1.
	*
	* @param fsOption1 the fs option1 of this e closing
	*/
	@Override
	public void setFsOption1(boolean fsOption1) {
		_eClosing.setFsOption1(fsOption1);
	}

	/**
	* Returns the fs status of this e closing.
	*
	* @return the fs status of this e closing
	*/
	@Override
	public java.lang.String getFsStatus() {
		return _eClosing.getFsStatus();
	}

	/**
	* Sets the fs status of this e closing.
	*
	* @param fsStatus the fs status of this e closing
	*/
	@Override
	public void setFsStatus(java.lang.String fsStatus) {
		_eClosing.setFsStatus(fsStatus);
	}

	/**
	* Returns the fs comments of this e closing.
	*
	* @return the fs comments of this e closing
	*/
	@Override
	public java.lang.String getFsComments() {
		return _eClosing.getFsComments();
	}

	/**
	* Sets the fs comments of this e closing.
	*
	* @param fsComments the fs comments of this e closing
	*/
	@Override
	public void setFsComments(java.lang.String fsComments) {
		_eClosing.setFsComments(fsComments);
	}

	/**
	* Returns the flc option1 of this e closing.
	*
	* @return the flc option1 of this e closing
	*/
	@Override
	public boolean getFlcOption1() {
		return _eClosing.getFlcOption1();
	}

	/**
	* Returns <code>true</code> if this e closing is flc option1.
	*
	* @return <code>true</code> if this e closing is flc option1; <code>false</code> otherwise
	*/
	@Override
	public boolean isFlcOption1() {
		return _eClosing.isFlcOption1();
	}

	/**
	* Sets whether this e closing is flc option1.
	*
	* @param flcOption1 the flc option1 of this e closing
	*/
	@Override
	public void setFlcOption1(boolean flcOption1) {
		_eClosing.setFlcOption1(flcOption1);
	}

	/**
	* Returns the flc option2 of this e closing.
	*
	* @return the flc option2 of this e closing
	*/
	@Override
	public boolean getFlcOption2() {
		return _eClosing.getFlcOption2();
	}

	/**
	* Returns <code>true</code> if this e closing is flc option2.
	*
	* @return <code>true</code> if this e closing is flc option2; <code>false</code> otherwise
	*/
	@Override
	public boolean isFlcOption2() {
		return _eClosing.isFlcOption2();
	}

	/**
	* Sets whether this e closing is flc option2.
	*
	* @param flcOption2 the flc option2 of this e closing
	*/
	@Override
	public void setFlcOption2(boolean flcOption2) {
		_eClosing.setFlcOption2(flcOption2);
	}

	/**
	* Returns the flc status of this e closing.
	*
	* @return the flc status of this e closing
	*/
	@Override
	public java.lang.String getFlcStatus() {
		return _eClosing.getFlcStatus();
	}

	/**
	* Sets the flc status of this e closing.
	*
	* @param flcStatus the flc status of this e closing
	*/
	@Override
	public void setFlcStatus(java.lang.String flcStatus) {
		_eClosing.setFlcStatus(flcStatus);
	}

	/**
	* Returns the flc comments of this e closing.
	*
	* @return the flc comments of this e closing
	*/
	@Override
	public java.lang.String getFlcComments() {
		return _eClosing.getFlcComments();
	}

	/**
	* Sets the flc comments of this e closing.
	*
	* @param flcComments the flc comments of this e closing
	*/
	@Override
	public void setFlcComments(java.lang.String flcComments) {
		_eClosing.setFlcComments(flcComments);
	}

	/**
	* Returns the security option1 of this e closing.
	*
	* @return the security option1 of this e closing
	*/
	@Override
	public boolean getSecurityOption1() {
		return _eClosing.getSecurityOption1();
	}

	/**
	* Returns <code>true</code> if this e closing is security option1.
	*
	* @return <code>true</code> if this e closing is security option1; <code>false</code> otherwise
	*/
	@Override
	public boolean isSecurityOption1() {
		return _eClosing.isSecurityOption1();
	}

	/**
	* Sets whether this e closing is security option1.
	*
	* @param securityOption1 the security option1 of this e closing
	*/
	@Override
	public void setSecurityOption1(boolean securityOption1) {
		_eClosing.setSecurityOption1(securityOption1);
	}

	/**
	* Returns the security finance fee of this e closing.
	*
	* @return the security finance fee of this e closing
	*/
	@Override
	public double getSecurityFinanceFee() {
		return _eClosing.getSecurityFinanceFee();
	}

	/**
	* Sets the security finance fee of this e closing.
	*
	* @param securityFinanceFee the security finance fee of this e closing
	*/
	@Override
	public void setSecurityFinanceFee(double securityFinanceFee) {
		_eClosing.setSecurityFinanceFee(securityFinanceFee);
	}

	/**
	* Returns the security status of this e closing.
	*
	* @return the security status of this e closing
	*/
	@Override
	public java.lang.String getSecurityStatus() {
		return _eClosing.getSecurityStatus();
	}

	/**
	* Sets the security status of this e closing.
	*
	* @param securityStatus the security status of this e closing
	*/
	@Override
	public void setSecurityStatus(java.lang.String securityStatus) {
		_eClosing.setSecurityStatus(securityStatus);
	}

	/**
	* Returns the security comments of this e closing.
	*
	* @return the security comments of this e closing
	*/
	@Override
	public java.lang.String getSecurityComments() {
		return _eClosing.getSecurityComments();
	}

	/**
	* Sets the security comments of this e closing.
	*
	* @param securityComments the security comments of this e closing
	*/
	@Override
	public void setSecurityComments(java.lang.String securityComments) {
		_eClosing.setSecurityComments(securityComments);
	}

	/**
	* Returns the id option1 of this e closing.
	*
	* @return the id option1 of this e closing
	*/
	@Override
	public boolean getIdOption1() {
		return _eClosing.getIdOption1();
	}

	/**
	* Returns <code>true</code> if this e closing is id option1.
	*
	* @return <code>true</code> if this e closing is id option1; <code>false</code> otherwise
	*/
	@Override
	public boolean isIdOption1() {
		return _eClosing.isIdOption1();
	}

	/**
	* Sets whether this e closing is id option1.
	*
	* @param idOption1 the id option1 of this e closing
	*/
	@Override
	public void setIdOption1(boolean idOption1) {
		_eClosing.setIdOption1(idOption1);
	}

	/**
	* Returns the id option2 of this e closing.
	*
	* @return the id option2 of this e closing
	*/
	@Override
	public boolean getIdOption2() {
		return _eClosing.getIdOption2();
	}

	/**
	* Returns <code>true</code> if this e closing is id option2.
	*
	* @return <code>true</code> if this e closing is id option2; <code>false</code> otherwise
	*/
	@Override
	public boolean isIdOption2() {
		return _eClosing.isIdOption2();
	}

	/**
	* Sets whether this e closing is id option2.
	*
	* @param idOption2 the id option2 of this e closing
	*/
	@Override
	public void setIdOption2(boolean idOption2) {
		_eClosing.setIdOption2(idOption2);
	}

	/**
	* Returns the id option3 of this e closing.
	*
	* @return the id option3 of this e closing
	*/
	@Override
	public boolean getIdOption3() {
		return _eClosing.getIdOption3();
	}

	/**
	* Returns <code>true</code> if this e closing is id option3.
	*
	* @return <code>true</code> if this e closing is id option3; <code>false</code> otherwise
	*/
	@Override
	public boolean isIdOption3() {
		return _eClosing.isIdOption3();
	}

	/**
	* Sets whether this e closing is id option3.
	*
	* @param idOption3 the id option3 of this e closing
	*/
	@Override
	public void setIdOption3(boolean idOption3) {
		_eClosing.setIdOption3(idOption3);
	}

	/**
	* Returns the id option4 of this e closing.
	*
	* @return the id option4 of this e closing
	*/
	@Override
	public boolean getIdOption4() {
		return _eClosing.getIdOption4();
	}

	/**
	* Returns <code>true</code> if this e closing is id option4.
	*
	* @return <code>true</code> if this e closing is id option4; <code>false</code> otherwise
	*/
	@Override
	public boolean isIdOption4() {
		return _eClosing.isIdOption4();
	}

	/**
	* Sets whether this e closing is id option4.
	*
	* @param idOption4 the id option4 of this e closing
	*/
	@Override
	public void setIdOption4(boolean idOption4) {
		_eClosing.setIdOption4(idOption4);
	}

	/**
	* Returns the id option5 of this e closing.
	*
	* @return the id option5 of this e closing
	*/
	@Override
	public boolean getIdOption5() {
		return _eClosing.getIdOption5();
	}

	/**
	* Returns <code>true</code> if this e closing is id option5.
	*
	* @return <code>true</code> if this e closing is id option5; <code>false</code> otherwise
	*/
	@Override
	public boolean isIdOption5() {
		return _eClosing.isIdOption5();
	}

	/**
	* Sets whether this e closing is id option5.
	*
	* @param idOption5 the id option5 of this e closing
	*/
	@Override
	public void setIdOption5(boolean idOption5) {
		_eClosing.setIdOption5(idOption5);
	}

	/**
	* Returns the id option6 of this e closing.
	*
	* @return the id option6 of this e closing
	*/
	@Override
	public boolean getIdOption6() {
		return _eClosing.getIdOption6();
	}

	/**
	* Returns <code>true</code> if this e closing is id option6.
	*
	* @return <code>true</code> if this e closing is id option6; <code>false</code> otherwise
	*/
	@Override
	public boolean isIdOption6() {
		return _eClosing.isIdOption6();
	}

	/**
	* Sets whether this e closing is id option6.
	*
	* @param idOption6 the id option6 of this e closing
	*/
	@Override
	public void setIdOption6(boolean idOption6) {
		_eClosing.setIdOption6(idOption6);
	}

	/**
	* Returns the id option7 of this e closing.
	*
	* @return the id option7 of this e closing
	*/
	@Override
	public boolean getIdOption7() {
		return _eClosing.getIdOption7();
	}

	/**
	* Returns <code>true</code> if this e closing is id option7.
	*
	* @return <code>true</code> if this e closing is id option7; <code>false</code> otherwise
	*/
	@Override
	public boolean isIdOption7() {
		return _eClosing.isIdOption7();
	}

	/**
	* Sets whether this e closing is id option7.
	*
	* @param idOption7 the id option7 of this e closing
	*/
	@Override
	public void setIdOption7(boolean idOption7) {
		_eClosing.setIdOption7(idOption7);
	}

	/**
	* Returns the id option8 of this e closing.
	*
	* @return the id option8 of this e closing
	*/
	@Override
	public boolean getIdOption8() {
		return _eClosing.getIdOption8();
	}

	/**
	* Returns <code>true</code> if this e closing is id option8.
	*
	* @return <code>true</code> if this e closing is id option8; <code>false</code> otherwise
	*/
	@Override
	public boolean isIdOption8() {
		return _eClosing.isIdOption8();
	}

	/**
	* Sets whether this e closing is id option8.
	*
	* @param idOption8 the id option8 of this e closing
	*/
	@Override
	public void setIdOption8(boolean idOption8) {
		_eClosing.setIdOption8(idOption8);
	}

	/**
	* Returns the id option9 of this e closing.
	*
	* @return the id option9 of this e closing
	*/
	@Override
	public boolean getIdOption9() {
		return _eClosing.getIdOption9();
	}

	/**
	* Returns <code>true</code> if this e closing is id option9.
	*
	* @return <code>true</code> if this e closing is id option9; <code>false</code> otherwise
	*/
	@Override
	public boolean isIdOption9() {
		return _eClosing.isIdOption9();
	}

	/**
	* Sets whether this e closing is id option9.
	*
	* @param idOption9 the id option9 of this e closing
	*/
	@Override
	public void setIdOption9(boolean idOption9) {
		_eClosing.setIdOption9(idOption9);
	}

	/**
	* Returns the id hr fee of this e closing.
	*
	* @return the id hr fee of this e closing
	*/
	@Override
	public double getIdHrFee() {
		return _eClosing.getIdHrFee();
	}

	/**
	* Sets the id hr fee of this e closing.
	*
	* @param idHrFee the id hr fee of this e closing
	*/
	@Override
	public void setIdHrFee(double idHrFee) {
		_eClosing.setIdHrFee(idHrFee);
	}

	/**
	* Returns the id finance fee of this e closing.
	*
	* @return the id finance fee of this e closing
	*/
	@Override
	public double getIdFinanceFee() {
		return _eClosing.getIdFinanceFee();
	}

	/**
	* Sets the id finance fee of this e closing.
	*
	* @param idFinanceFee the id finance fee of this e closing
	*/
	@Override
	public void setIdFinanceFee(double idFinanceFee) {
		_eClosing.setIdFinanceFee(idFinanceFee);
	}

	/**
	* Returns the id status of this e closing.
	*
	* @return the id status of this e closing
	*/
	@Override
	public java.lang.String getIdStatus() {
		return _eClosing.getIdStatus();
	}

	/**
	* Sets the id status of this e closing.
	*
	* @param idStatus the id status of this e closing
	*/
	@Override
	public void setIdStatus(java.lang.String idStatus) {
		_eClosing.setIdStatus(idStatus);
	}

	/**
	* Returns the id comments of this e closing.
	*
	* @return the id comments of this e closing
	*/
	@Override
	public java.lang.String getIdComments() {
		return _eClosing.getIdComments();
	}

	/**
	* Sets the id comments of this e closing.
	*
	* @param idComments the id comments of this e closing
	*/
	@Override
	public void setIdComments(java.lang.String idComments) {
		_eClosing.setIdComments(idComments);
	}

	/**
	* Returns the htd option1 of this e closing.
	*
	* @return the htd option1 of this e closing
	*/
	@Override
	public boolean getHtdOption1() {
		return _eClosing.getHtdOption1();
	}

	/**
	* Returns <code>true</code> if this e closing is htd option1.
	*
	* @return <code>true</code> if this e closing is htd option1; <code>false</code> otherwise
	*/
	@Override
	public boolean isHtdOption1() {
		return _eClosing.isHtdOption1();
	}

	/**
	* Sets whether this e closing is htd option1.
	*
	* @param htdOption1 the htd option1 of this e closing
	*/
	@Override
	public void setHtdOption1(boolean htdOption1) {
		_eClosing.setHtdOption1(htdOption1);
	}

	/**
	* Returns the htd hr fee of this e closing.
	*
	* @return the htd hr fee of this e closing
	*/
	@Override
	public double getHtdHrFee() {
		return _eClosing.getHtdHrFee();
	}

	/**
	* Sets the htd hr fee of this e closing.
	*
	* @param htdHrFee the htd hr fee of this e closing
	*/
	@Override
	public void setHtdHrFee(double htdHrFee) {
		_eClosing.setHtdHrFee(htdHrFee);
	}

	/**
	* Returns the htd finance fee of this e closing.
	*
	* @return the htd finance fee of this e closing
	*/
	@Override
	public double getHtdFinanceFee() {
		return _eClosing.getHtdFinanceFee();
	}

	/**
	* Sets the htd finance fee of this e closing.
	*
	* @param htdFinanceFee the htd finance fee of this e closing
	*/
	@Override
	public void setHtdFinanceFee(double htdFinanceFee) {
		_eClosing.setHtdFinanceFee(htdFinanceFee);
	}

	/**
	* Returns the htd status of this e closing.
	*
	* @return the htd status of this e closing
	*/
	@Override
	public java.lang.String getHtdStatus() {
		return _eClosing.getHtdStatus();
	}

	/**
	* Sets the htd status of this e closing.
	*
	* @param htdStatus the htd status of this e closing
	*/
	@Override
	public void setHtdStatus(java.lang.String htdStatus) {
		_eClosing.setHtdStatus(htdStatus);
	}

	/**
	* Returns the htd comments of this e closing.
	*
	* @return the htd comments of this e closing
	*/
	@Override
	public java.lang.String getHtdComments() {
		return _eClosing.getHtdComments();
	}

	/**
	* Sets the htd comments of this e closing.
	*
	* @param htdComments the htd comments of this e closing
	*/
	@Override
	public void setHtdComments(java.lang.String htdComments) {
		_eClosing.setHtdComments(htdComments);
	}

	/**
	* Returns the hd option1 of this e closing.
	*
	* @return the hd option1 of this e closing
	*/
	@Override
	public boolean getHdOption1() {
		return _eClosing.getHdOption1();
	}

	/**
	* Returns <code>true</code> if this e closing is hd option1.
	*
	* @return <code>true</code> if this e closing is hd option1; <code>false</code> otherwise
	*/
	@Override
	public boolean isHdOption1() {
		return _eClosing.isHdOption1();
	}

	/**
	* Sets whether this e closing is hd option1.
	*
	* @param hdOption1 the hd option1 of this e closing
	*/
	@Override
	public void setHdOption1(boolean hdOption1) {
		_eClosing.setHdOption1(hdOption1);
	}

	/**
	* Returns the hd option2 of this e closing.
	*
	* @return the hd option2 of this e closing
	*/
	@Override
	public boolean getHdOption2() {
		return _eClosing.getHdOption2();
	}

	/**
	* Returns <code>true</code> if this e closing is hd option2.
	*
	* @return <code>true</code> if this e closing is hd option2; <code>false</code> otherwise
	*/
	@Override
	public boolean isHdOption2() {
		return _eClosing.isHdOption2();
	}

	/**
	* Sets whether this e closing is hd option2.
	*
	* @param hdOption2 the hd option2 of this e closing
	*/
	@Override
	public void setHdOption2(boolean hdOption2) {
		_eClosing.setHdOption2(hdOption2);
	}

	/**
	* Returns the hd option2 text of this e closing.
	*
	* @return the hd option2 text of this e closing
	*/
	@Override
	public java.lang.String getHdOption2Text() {
		return _eClosing.getHdOption2Text();
	}

	/**
	* Sets the hd option2 text of this e closing.
	*
	* @param hdOption2Text the hd option2 text of this e closing
	*/
	@Override
	public void setHdOption2Text(java.lang.String hdOption2Text) {
		_eClosing.setHdOption2Text(hdOption2Text);
	}

	/**
	* Returns the hd option3 of this e closing.
	*
	* @return the hd option3 of this e closing
	*/
	@Override
	public boolean getHdOption3() {
		return _eClosing.getHdOption3();
	}

	/**
	* Returns <code>true</code> if this e closing is hd option3.
	*
	* @return <code>true</code> if this e closing is hd option3; <code>false</code> otherwise
	*/
	@Override
	public boolean isHdOption3() {
		return _eClosing.isHdOption3();
	}

	/**
	* Sets whether this e closing is hd option3.
	*
	* @param hdOption3 the hd option3 of this e closing
	*/
	@Override
	public void setHdOption3(boolean hdOption3) {
		_eClosing.setHdOption3(hdOption3);
	}

	/**
	* Returns the hd option3 money of this e closing.
	*
	* @return the hd option3 money of this e closing
	*/
	@Override
	public double getHdOption3Money() {
		return _eClosing.getHdOption3Money();
	}

	/**
	* Sets the hd option3 money of this e closing.
	*
	* @param hdOption3Money the hd option3 money of this e closing
	*/
	@Override
	public void setHdOption3Money(double hdOption3Money) {
		_eClosing.setHdOption3Money(hdOption3Money);
	}

	/**
	* Returns the hd option4 of this e closing.
	*
	* @return the hd option4 of this e closing
	*/
	@Override
	public boolean getHdOption4() {
		return _eClosing.getHdOption4();
	}

	/**
	* Returns <code>true</code> if this e closing is hd option4.
	*
	* @return <code>true</code> if this e closing is hd option4; <code>false</code> otherwise
	*/
	@Override
	public boolean isHdOption4() {
		return _eClosing.isHdOption4();
	}

	/**
	* Sets whether this e closing is hd option4.
	*
	* @param hdOption4 the hd option4 of this e closing
	*/
	@Override
	public void setHdOption4(boolean hdOption4) {
		_eClosing.setHdOption4(hdOption4);
	}

	/**
	* Returns the hd option4 money of this e closing.
	*
	* @return the hd option4 money of this e closing
	*/
	@Override
	public double getHdOption4Money() {
		return _eClosing.getHdOption4Money();
	}

	/**
	* Sets the hd option4 money of this e closing.
	*
	* @param hdOption4Money the hd option4 money of this e closing
	*/
	@Override
	public void setHdOption4Money(double hdOption4Money) {
		_eClosing.setHdOption4Money(hdOption4Money);
	}

	/**
	* Returns the hd status of this e closing.
	*
	* @return the hd status of this e closing
	*/
	@Override
	public java.lang.String getHdStatus() {
		return _eClosing.getHdStatus();
	}

	/**
	* Sets the hd status of this e closing.
	*
	* @param hdStatus the hd status of this e closing
	*/
	@Override
	public void setHdStatus(java.lang.String hdStatus) {
		_eClosing.setHdStatus(hdStatus);
	}

	/**
	* Returns the hd comments of this e closing.
	*
	* @return the hd comments of this e closing
	*/
	@Override
	public java.lang.String getHdComments() {
		return _eClosing.getHdComments();
	}

	/**
	* Sets the hd comments of this e closing.
	*
	* @param hdComments the hd comments of this e closing
	*/
	@Override
	public void setHdComments(java.lang.String hdComments) {
		_eClosing.setHdComments(hdComments);
	}

	/**
	* Returns the hdleave text of this e closing.
	*
	* @return the hdleave text of this e closing
	*/
	@Override
	public java.lang.String getHdleaveText() {
		return _eClosing.getHdleaveText();
	}

	/**
	* Sets the hdleave text of this e closing.
	*
	* @param hdleaveText the hdleave text of this e closing
	*/
	@Override
	public void setHdleaveText(java.lang.String hdleaveText) {
		_eClosing.setHdleaveText(hdleaveText);
	}

	/**
	* Returns the fd option1 of this e closing.
	*
	* @return the fd option1 of this e closing
	*/
	@Override
	public boolean getFdOption1() {
		return _eClosing.getFdOption1();
	}

	/**
	* Returns <code>true</code> if this e closing is fd option1.
	*
	* @return <code>true</code> if this e closing is fd option1; <code>false</code> otherwise
	*/
	@Override
	public boolean isFdOption1() {
		return _eClosing.isFdOption1();
	}

	/**
	* Sets whether this e closing is fd option1.
	*
	* @param fdOption1 the fd option1 of this e closing
	*/
	@Override
	public void setFdOption1(boolean fdOption1) {
		_eClosing.setFdOption1(fdOption1);
	}

	/**
	* Returns the fd option2 of this e closing.
	*
	* @return the fd option2 of this e closing
	*/
	@Override
	public boolean getFdOption2() {
		return _eClosing.getFdOption2();
	}

	/**
	* Returns <code>true</code> if this e closing is fd option2.
	*
	* @return <code>true</code> if this e closing is fd option2; <code>false</code> otherwise
	*/
	@Override
	public boolean isFdOption2() {
		return _eClosing.isFdOption2();
	}

	/**
	* Sets whether this e closing is fd option2.
	*
	* @param fdOption2 the fd option2 of this e closing
	*/
	@Override
	public void setFdOption2(boolean fdOption2) {
		_eClosing.setFdOption2(fdOption2);
	}

	/**
	* Returns the fd option3 of this e closing.
	*
	* @return the fd option3 of this e closing
	*/
	@Override
	public boolean getFdOption3() {
		return _eClosing.getFdOption3();
	}

	/**
	* Returns <code>true</code> if this e closing is fd option3.
	*
	* @return <code>true</code> if this e closing is fd option3; <code>false</code> otherwise
	*/
	@Override
	public boolean isFdOption3() {
		return _eClosing.isFdOption3();
	}

	/**
	* Sets whether this e closing is fd option3.
	*
	* @param fdOption3 the fd option3 of this e closing
	*/
	@Override
	public void setFdOption3(boolean fdOption3) {
		_eClosing.setFdOption3(fdOption3);
	}

	/**
	* Returns the fd option4 of this e closing.
	*
	* @return the fd option4 of this e closing
	*/
	@Override
	public boolean getFdOption4() {
		return _eClosing.getFdOption4();
	}

	/**
	* Returns <code>true</code> if this e closing is fd option4.
	*
	* @return <code>true</code> if this e closing is fd option4; <code>false</code> otherwise
	*/
	@Override
	public boolean isFdOption4() {
		return _eClosing.isFdOption4();
	}

	/**
	* Sets whether this e closing is fd option4.
	*
	* @param fdOption4 the fd option4 of this e closing
	*/
	@Override
	public void setFdOption4(boolean fdOption4) {
		_eClosing.setFdOption4(fdOption4);
	}

	/**
	* Returns the fd option4 text of this e closing.
	*
	* @return the fd option4 text of this e closing
	*/
	@Override
	public java.lang.String getFdOption4Text() {
		return _eClosing.getFdOption4Text();
	}

	/**
	* Sets the fd option4 text of this e closing.
	*
	* @param fdOption4Text the fd option4 text of this e closing
	*/
	@Override
	public void setFdOption4Text(java.lang.String fdOption4Text) {
		_eClosing.setFdOption4Text(fdOption4Text);
	}

	/**
	* Returns the fd status of this e closing.
	*
	* @return the fd status of this e closing
	*/
	@Override
	public java.lang.String getFdStatus() {
		return _eClosing.getFdStatus();
	}

	/**
	* Sets the fd status of this e closing.
	*
	* @param fdStatus the fd status of this e closing
	*/
	@Override
	public void setFdStatus(java.lang.String fdStatus) {
		_eClosing.setFdStatus(fdStatus);
	}

	/**
	* Returns the fd comments of this e closing.
	*
	* @return the fd comments of this e closing
	*/
	@Override
	public java.lang.String getFdComments() {
		return _eClosing.getFdComments();
	}

	/**
	* Sets the fd comments of this e closing.
	*
	* @param fdComments the fd comments of this e closing
	*/
	@Override
	public void setFdComments(java.lang.String fdComments) {
		_eClosing.setFdComments(fdComments);
	}

	/**
	* Returns the applicant agent of this e closing.
	*
	* @return the applicant agent of this e closing
	*/
	@Override
	public boolean getApplicantAgent() {
		return _eClosing.getApplicantAgent();
	}

	/**
	* Returns <code>true</code> if this e closing is applicant agent.
	*
	* @return <code>true</code> if this e closing is applicant agent; <code>false</code> otherwise
	*/
	@Override
	public boolean isApplicantAgent() {
		return _eClosing.isApplicantAgent();
	}

	/**
	* Sets whether this e closing is applicant agent.
	*
	* @param applicantAgent the applicant agent of this e closing
	*/
	@Override
	public void setApplicantAgent(boolean applicantAgent) {
		_eClosing.setApplicantAgent(applicantAgent);
	}

	/**
	* Returns the approver agent of this e closing.
	*
	* @return the approver agent of this e closing
	*/
	@Override
	public boolean getApproverAgent() {
		return _eClosing.getApproverAgent();
	}

	/**
	* Returns <code>true</code> if this e closing is approver agent.
	*
	* @return <code>true</code> if this e closing is approver agent; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproverAgent() {
		return _eClosing.isApproverAgent();
	}

	/**
	* Sets whether this e closing is approver agent.
	*
	* @param approverAgent the approver agent of this e closing
	*/
	@Override
	public void setApproverAgent(boolean approverAgent) {
		_eClosing.setApproverAgent(approverAgent);
	}

	/**
	* Returns the process type of this e closing.
	*
	* @return the process type of this e closing
	*/
	@Override
	public java.lang.String getProcessType() {
		return _eClosing.getProcessType();
	}

	/**
	* Sets the process type of this e closing.
	*
	* @param processType the process type of this e closing
	*/
	@Override
	public void setProcessType(java.lang.String processType) {
		_eClosing.setProcessType(processType);
	}

	/**
	* Returns the sub process type of this e closing.
	*
	* @return the sub process type of this e closing
	*/
	@Override
	public java.lang.String getSubProcessType() {
		return _eClosing.getSubProcessType();
	}

	/**
	* Sets the sub process type of this e closing.
	*
	* @param subProcessType the sub process type of this e closing
	*/
	@Override
	public void setSubProcessType(java.lang.String subProcessType) {
		_eClosing.setSubProcessType(subProcessType);
	}

	/**
	* Returns the status of this e closing.
	*
	* @return the status of this e closing
	*/
	@Override
	public int getStatus() {
		return _eClosing.getStatus();
	}

	/**
	* Sets the status of this e closing.
	*
	* @param status the status of this e closing
	*/
	@Override
	public void setStatus(int status) {
		_eClosing.setStatus(status);
	}

	/**
	* Returns the status by user ID of this e closing.
	*
	* @return the status by user ID of this e closing
	*/
	@Override
	public long getStatusByUserId() {
		return _eClosing.getStatusByUserId();
	}

	/**
	* Sets the status by user ID of this e closing.
	*
	* @param statusByUserId the status by user ID of this e closing
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_eClosing.setStatusByUserId(statusByUserId);
	}

	/**
	* Returns the status by user uuid of this e closing.
	*
	* @return the status by user uuid of this e closing
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getStatusByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eClosing.getStatusByUserUuid();
	}

	/**
	* Sets the status by user uuid of this e closing.
	*
	* @param statusByUserUuid the status by user uuid of this e closing
	*/
	@Override
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_eClosing.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Returns the status by user name of this e closing.
	*
	* @return the status by user name of this e closing
	*/
	@Override
	public java.lang.String getStatusByUserName() {
		return _eClosing.getStatusByUserName();
	}

	/**
	* Sets the status by user name of this e closing.
	*
	* @param statusByUserName the status by user name of this e closing
	*/
	@Override
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_eClosing.setStatusByUserName(statusByUserName);
	}

	/**
	* Returns the status date of this e closing.
	*
	* @return the status date of this e closing
	*/
	@Override
	public java.util.Date getStatusDate() {
		return _eClosing.getStatusDate();
	}

	/**
	* Sets the status date of this e closing.
	*
	* @param statusDate the status date of this e closing
	*/
	@Override
	public void setStatusDate(java.util.Date statusDate) {
		_eClosing.setStatusDate(statusDate);
	}

	/**
	* @deprecated As of 6.1.0, replaced by {@link #isApproved()}
	*/
	@Override
	public boolean getApproved() {
		return _eClosing.getApproved();
	}

	/**
	* Returns <code>true</code> if this e closing is approved.
	*
	* @return <code>true</code> if this e closing is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _eClosing.isApproved();
	}

	/**
	* Returns <code>true</code> if this e closing is denied.
	*
	* @return <code>true</code> if this e closing is denied; <code>false</code> otherwise
	*/
	@Override
	public boolean isDenied() {
		return _eClosing.isDenied();
	}

	/**
	* Returns <code>true</code> if this e closing is a draft.
	*
	* @return <code>true</code> if this e closing is a draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _eClosing.isDraft();
	}

	/**
	* Returns <code>true</code> if this e closing is expired.
	*
	* @return <code>true</code> if this e closing is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _eClosing.isExpired();
	}

	/**
	* Returns <code>true</code> if this e closing is inactive.
	*
	* @return <code>true</code> if this e closing is inactive; <code>false</code> otherwise
	*/
	@Override
	public boolean isInactive() {
		return _eClosing.isInactive();
	}

	/**
	* Returns <code>true</code> if this e closing is incomplete.
	*
	* @return <code>true</code> if this e closing is incomplete; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncomplete() {
		return _eClosing.isIncomplete();
	}

	/**
	* Returns <code>true</code> if this e closing is pending.
	*
	* @return <code>true</code> if this e closing is pending; <code>false</code> otherwise
	*/
	@Override
	public boolean isPending() {
		return _eClosing.isPending();
	}

	/**
	* Returns <code>true</code> if this e closing is scheduled.
	*
	* @return <code>true</code> if this e closing is scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isScheduled() {
		return _eClosing.isScheduled();
	}

	@Override
	public boolean isNew() {
		return _eClosing.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_eClosing.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _eClosing.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_eClosing.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _eClosing.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _eClosing.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_eClosing.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _eClosing.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_eClosing.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_eClosing.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_eClosing.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EClosingWrapper((EClosing)_eClosing.clone());
	}

	@Override
	public int compareTo(com.e.closing.model.EClosing eClosing) {
		return _eClosing.compareTo(eClosing);
	}

	@Override
	public int hashCode() {
		return _eClosing.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.e.closing.model.EClosing> toCacheModel() {
		return _eClosing.toCacheModel();
	}

	@Override
	public com.e.closing.model.EClosing toEscapedModel() {
		return new EClosingWrapper(_eClosing.toEscapedModel());
	}

	@Override
	public com.e.closing.model.EClosing toUnescapedModel() {
		return new EClosingWrapper(_eClosing.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _eClosing.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _eClosing.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_eClosing.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EClosingWrapper)) {
			return false;
		}

		EClosingWrapper eClosingWrapper = (EClosingWrapper)obj;

		if (Validator.equals(_eClosing, eClosingWrapper._eClosing)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EClosing getWrappedEClosing() {
		return _eClosing;
	}

	@Override
	public EClosing getWrappedModel() {
		return _eClosing;
	}

	@Override
	public void resetOriginalValues() {
		_eClosing.resetOriginalValues();
	}

	private EClosing _eClosing;
}