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

import com.e.closing.service.ClpSerializer;
import com.e.closing.service.EClosingLocalServiceUtil;

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
 * @author t.a.jiang
 */
public class EClosingClp extends BaseModelImpl<EClosing> implements EClosing {
	public EClosingClp() {
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
	public long getPrimaryKey() {
		return _eclosingId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEclosingId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _eclosingId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getEclosingId() {
		return _eclosingId;
	}

	@Override
	public void setEclosingId(long eclosingId) {
		_eclosingId = eclosingId;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setEclosingId", long.class);

				method.invoke(_eClosingRemoteModel, eclosingId);
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

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_eClosingRemoteModel, groupId);
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

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_eClosingRemoteModel, companyId);
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

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_eClosingRemoteModel, userId);
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

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_eClosingRemoteModel, userName);
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

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_eClosingRemoteModel, createDate);
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

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_eClosingRemoteModel, modifiedDate);
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

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setTicketNo", String.class);

				method.invoke(_eClosingRemoteModel, ticketNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStaffCode() {
		return _staffCode;
	}

	@Override
	public void setStaffCode(int staffCode) {
		_staffCode = staffCode;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setStaffCode", int.class);

				method.invoke(_eClosingRemoteModel, staffCode);
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

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setStaffName", String.class);

				method.invoke(_eClosingRemoteModel, staffName);
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

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setCompany", String.class);

				method.invoke(_eClosingRemoteModel, company);
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

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setDivision", String.class);

				method.invoke(_eClosingRemoteModel, division);
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

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setDepartment", String.class);

				method.invoke(_eClosingRemoteModel, department);
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

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setCostCenter", String.class);

				method.invoke(_eClosingRemoteModel, costCenter);
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

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setFunctionName", String.class);

				method.invoke(_eClosingRemoteModel, functionName);
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

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setPositionCode", String.class);

				method.invoke(_eClosingRemoteModel, positionCode);
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

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setEmployeeGroupId",
						String.class);

				method.invoke(_eClosingRemoteModel, employeeGroupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmployeeGroupName() {
		return _employeeGroupName;
	}

	@Override
	public void setEmployeeGroupName(String employeeGroupName) {
		_employeeGroupName = employeeGroupName;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setEmployeeGroupName",
						String.class);

				method.invoke(_eClosingRemoteModel, employeeGroupName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPrivateEmailAddress() {
		return _privateEmailAddress;
	}

	@Override
	public void setPrivateEmailAddress(String privateEmailAddress) {
		_privateEmailAddress = privateEmailAddress;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setPrivateEmailAddress",
						String.class);

				method.invoke(_eClosingRemoteModel, privateEmailAddress);
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

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setStartingDate", Date.class);

				method.invoke(_eClosingRemoteModel, startingDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getLastWorkingDay() {
		return _lastWorkingDay;
	}

	@Override
	public void setLastWorkingDay(Date lastWorkingDay) {
		_lastWorkingDay = lastWorkingDay;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setLastWorkingDay", Date.class);

				method.invoke(_eClosingRemoteModel, lastWorkingDay);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getFinishContractDate() {
		return _finishContractDate;
	}

	@Override
	public void setFinishContractDate(Date finishContractDate) {
		_finishContractDate = finishContractDate;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setFinishContractDate",
						Date.class);

				method.invoke(_eClosingRemoteModel, finishContractDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSeatOfficeNumber() {
		return _seatOfficeNumber;
	}

	@Override
	public void setSeatOfficeNumber(String seatOfficeNumber) {
		_seatOfficeNumber = seatOfficeNumber;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setSeatOfficeNumber",
						String.class);

				method.invoke(_eClosingRemoteModel, seatOfficeNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPermanentAddress() {
		return _permanentAddress;
	}

	@Override
	public void setPermanentAddress(String permanentAddress) {
		_permanentAddress = permanentAddress;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setPermanentAddress",
						String.class);

				method.invoke(_eClosingRemoteModel, permanentAddress);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getDmOption1() {
		return _dmOption1;
	}

	@Override
	public boolean isDmOption1() {
		return _dmOption1;
	}

	@Override
	public void setDmOption1(boolean dmOption1) {
		_dmOption1 = dmOption1;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setDmOption1", boolean.class);

				method.invoke(_eClosingRemoteModel, dmOption1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getDmOption2() {
		return _dmOption2;
	}

	@Override
	public boolean isDmOption2() {
		return _dmOption2;
	}

	@Override
	public void setDmOption2(boolean dmOption2) {
		_dmOption2 = dmOption2;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setDmOption2", boolean.class);

				method.invoke(_eClosingRemoteModel, dmOption2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDmStatus() {
		return _dmStatus;
	}

	@Override
	public void setDmStatus(String dmStatus) {
		_dmStatus = dmStatus;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setDmStatus", String.class);

				method.invoke(_eClosingRemoteModel, dmStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDmComments() {
		return _dmComments;
	}

	@Override
	public void setDmComments(String dmComments) {
		_dmComments = dmComments;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setDmComments", String.class);

				method.invoke(_eClosingRemoteModel, dmComments);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getAdOption1() {
		return _adOption1;
	}

	@Override
	public boolean isAdOption1() {
		return _adOption1;
	}

	@Override
	public void setAdOption1(boolean adOption1) {
		_adOption1 = adOption1;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setAdOption1", boolean.class);

				method.invoke(_eClosingRemoteModel, adOption1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getAdOption2() {
		return _adOption2;
	}

	@Override
	public boolean isAdOption2() {
		return _adOption2;
	}

	@Override
	public void setAdOption2(boolean adOption2) {
		_adOption2 = adOption2;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setAdOption2", boolean.class);

				method.invoke(_eClosingRemoteModel, adOption2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getAdOption3() {
		return _adOption3;
	}

	@Override
	public boolean isAdOption3() {
		return _adOption3;
	}

	@Override
	public void setAdOption3(boolean adOption3) {
		_adOption3 = adOption3;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setAdOption3", boolean.class);

				method.invoke(_eClosingRemoteModel, adOption3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getAdOption4() {
		return _adOption4;
	}

	@Override
	public boolean isAdOption4() {
		return _adOption4;
	}

	@Override
	public void setAdOption4(boolean adOption4) {
		_adOption4 = adOption4;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setAdOption4", boolean.class);

				method.invoke(_eClosingRemoteModel, adOption4);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getAdFinanceFee() {
		return _adFinanceFee;
	}

	@Override
	public void setAdFinanceFee(double adFinanceFee) {
		_adFinanceFee = adFinanceFee;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setAdFinanceFee", double.class);

				method.invoke(_eClosingRemoteModel, adFinanceFee);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAdStatus() {
		return _adStatus;
	}

	@Override
	public void setAdStatus(String adStatus) {
		_adStatus = adStatus;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setAdStatus", String.class);

				method.invoke(_eClosingRemoteModel, adStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAdComments() {
		return _adComments;
	}

	@Override
	public void setAdComments(String adComments) {
		_adComments = adComments;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setAdComments", String.class);

				method.invoke(_eClosingRemoteModel, adComments);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getFsOption1() {
		return _fsOption1;
	}

	@Override
	public boolean isFsOption1() {
		return _fsOption1;
	}

	@Override
	public void setFsOption1(boolean fsOption1) {
		_fsOption1 = fsOption1;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setFsOption1", boolean.class);

				method.invoke(_eClosingRemoteModel, fsOption1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFsStatus() {
		return _fsStatus;
	}

	@Override
	public void setFsStatus(String fsStatus) {
		_fsStatus = fsStatus;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setFsStatus", String.class);

				method.invoke(_eClosingRemoteModel, fsStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFsComments() {
		return _fsComments;
	}

	@Override
	public void setFsComments(String fsComments) {
		_fsComments = fsComments;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setFsComments", String.class);

				method.invoke(_eClosingRemoteModel, fsComments);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getFlcOption1() {
		return _flcOption1;
	}

	@Override
	public boolean isFlcOption1() {
		return _flcOption1;
	}

	@Override
	public void setFlcOption1(boolean flcOption1) {
		_flcOption1 = flcOption1;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setFlcOption1", boolean.class);

				method.invoke(_eClosingRemoteModel, flcOption1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getFlcOption2() {
		return _flcOption2;
	}

	@Override
	public boolean isFlcOption2() {
		return _flcOption2;
	}

	@Override
	public void setFlcOption2(boolean flcOption2) {
		_flcOption2 = flcOption2;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setFlcOption2", boolean.class);

				method.invoke(_eClosingRemoteModel, flcOption2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFlcStatus() {
		return _flcStatus;
	}

	@Override
	public void setFlcStatus(String flcStatus) {
		_flcStatus = flcStatus;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setFlcStatus", String.class);

				method.invoke(_eClosingRemoteModel, flcStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFlcComments() {
		return _flcComments;
	}

	@Override
	public void setFlcComments(String flcComments) {
		_flcComments = flcComments;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setFlcComments", String.class);

				method.invoke(_eClosingRemoteModel, flcComments);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getSecurityOption1() {
		return _securityOption1;
	}

	@Override
	public boolean isSecurityOption1() {
		return _securityOption1;
	}

	@Override
	public void setSecurityOption1(boolean securityOption1) {
		_securityOption1 = securityOption1;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setSecurityOption1",
						boolean.class);

				method.invoke(_eClosingRemoteModel, securityOption1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getSecurityFinanceFee() {
		return _securityFinanceFee;
	}

	@Override
	public void setSecurityFinanceFee(double securityFinanceFee) {
		_securityFinanceFee = securityFinanceFee;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setSecurityFinanceFee",
						double.class);

				method.invoke(_eClosingRemoteModel, securityFinanceFee);
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

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setSecurityStatus",
						String.class);

				method.invoke(_eClosingRemoteModel, securityStatus);
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

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setSecurityComments",
						String.class);

				method.invoke(_eClosingRemoteModel, securityComments);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIdOption1() {
		return _idOption1;
	}

	@Override
	public boolean isIdOption1() {
		return _idOption1;
	}

	@Override
	public void setIdOption1(boolean idOption1) {
		_idOption1 = idOption1;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setIdOption1", boolean.class);

				method.invoke(_eClosingRemoteModel, idOption1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIdOption2() {
		return _idOption2;
	}

	@Override
	public boolean isIdOption2() {
		return _idOption2;
	}

	@Override
	public void setIdOption2(boolean idOption2) {
		_idOption2 = idOption2;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setIdOption2", boolean.class);

				method.invoke(_eClosingRemoteModel, idOption2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIdOption3() {
		return _idOption3;
	}

	@Override
	public boolean isIdOption3() {
		return _idOption3;
	}

	@Override
	public void setIdOption3(boolean idOption3) {
		_idOption3 = idOption3;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setIdOption3", boolean.class);

				method.invoke(_eClosingRemoteModel, idOption3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIdOption4() {
		return _idOption4;
	}

	@Override
	public boolean isIdOption4() {
		return _idOption4;
	}

	@Override
	public void setIdOption4(boolean idOption4) {
		_idOption4 = idOption4;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setIdOption4", boolean.class);

				method.invoke(_eClosingRemoteModel, idOption4);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIdOption5() {
		return _idOption5;
	}

	@Override
	public boolean isIdOption5() {
		return _idOption5;
	}

	@Override
	public void setIdOption5(boolean idOption5) {
		_idOption5 = idOption5;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setIdOption5", boolean.class);

				method.invoke(_eClosingRemoteModel, idOption5);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIdOption6() {
		return _idOption6;
	}

	@Override
	public boolean isIdOption6() {
		return _idOption6;
	}

	@Override
	public void setIdOption6(boolean idOption6) {
		_idOption6 = idOption6;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setIdOption6", boolean.class);

				method.invoke(_eClosingRemoteModel, idOption6);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIdOption7() {
		return _idOption7;
	}

	@Override
	public boolean isIdOption7() {
		return _idOption7;
	}

	@Override
	public void setIdOption7(boolean idOption7) {
		_idOption7 = idOption7;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setIdOption7", boolean.class);

				method.invoke(_eClosingRemoteModel, idOption7);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIdOption8() {
		return _idOption8;
	}

	@Override
	public boolean isIdOption8() {
		return _idOption8;
	}

	@Override
	public void setIdOption8(boolean idOption8) {
		_idOption8 = idOption8;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setIdOption8", boolean.class);

				method.invoke(_eClosingRemoteModel, idOption8);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIdOption9() {
		return _idOption9;
	}

	@Override
	public boolean isIdOption9() {
		return _idOption9;
	}

	@Override
	public void setIdOption9(boolean idOption9) {
		_idOption9 = idOption9;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setIdOption9", boolean.class);

				method.invoke(_eClosingRemoteModel, idOption9);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getIdHrFee() {
		return _idHrFee;
	}

	@Override
	public void setIdHrFee(double idHrFee) {
		_idHrFee = idHrFee;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setIdHrFee", double.class);

				method.invoke(_eClosingRemoteModel, idHrFee);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getIdFinanceFee() {
		return _idFinanceFee;
	}

	@Override
	public void setIdFinanceFee(double idFinanceFee) {
		_idFinanceFee = idFinanceFee;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setIdFinanceFee", double.class);

				method.invoke(_eClosingRemoteModel, idFinanceFee);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIdStatus() {
		return _idStatus;
	}

	@Override
	public void setIdStatus(String idStatus) {
		_idStatus = idStatus;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setIdStatus", String.class);

				method.invoke(_eClosingRemoteModel, idStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIdComments() {
		return _idComments;
	}

	@Override
	public void setIdComments(String idComments) {
		_idComments = idComments;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setIdComments", String.class);

				method.invoke(_eClosingRemoteModel, idComments);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getHtdOption1() {
		return _htdOption1;
	}

	@Override
	public boolean isHtdOption1() {
		return _htdOption1;
	}

	@Override
	public void setHtdOption1(boolean htdOption1) {
		_htdOption1 = htdOption1;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setHtdOption1", boolean.class);

				method.invoke(_eClosingRemoteModel, htdOption1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getHtdHrFee() {
		return _htdHrFee;
	}

	@Override
	public void setHtdHrFee(double htdHrFee) {
		_htdHrFee = htdHrFee;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setHtdHrFee", double.class);

				method.invoke(_eClosingRemoteModel, htdHrFee);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getHtdFinanceFee() {
		return _htdFinanceFee;
	}

	@Override
	public void setHtdFinanceFee(double htdFinanceFee) {
		_htdFinanceFee = htdFinanceFee;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setHtdFinanceFee", double.class);

				method.invoke(_eClosingRemoteModel, htdFinanceFee);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHtdStatus() {
		return _htdStatus;
	}

	@Override
	public void setHtdStatus(String htdStatus) {
		_htdStatus = htdStatus;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setHtdStatus", String.class);

				method.invoke(_eClosingRemoteModel, htdStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHtdComments() {
		return _htdComments;
	}

	@Override
	public void setHtdComments(String htdComments) {
		_htdComments = htdComments;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setHtdComments", String.class);

				method.invoke(_eClosingRemoteModel, htdComments);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getHdOption1() {
		return _hdOption1;
	}

	@Override
	public boolean isHdOption1() {
		return _hdOption1;
	}

	@Override
	public void setHdOption1(boolean hdOption1) {
		_hdOption1 = hdOption1;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setHdOption1", boolean.class);

				method.invoke(_eClosingRemoteModel, hdOption1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getHdOption2() {
		return _hdOption2;
	}

	@Override
	public boolean isHdOption2() {
		return _hdOption2;
	}

	@Override
	public void setHdOption2(boolean hdOption2) {
		_hdOption2 = hdOption2;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setHdOption2", boolean.class);

				method.invoke(_eClosingRemoteModel, hdOption2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHdOption2Text() {
		return _hdOption2Text;
	}

	@Override
	public void setHdOption2Text(String hdOption2Text) {
		_hdOption2Text = hdOption2Text;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setHdOption2Text", String.class);

				method.invoke(_eClosingRemoteModel, hdOption2Text);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getHdOption3() {
		return _hdOption3;
	}

	@Override
	public boolean isHdOption3() {
		return _hdOption3;
	}

	@Override
	public void setHdOption3(boolean hdOption3) {
		_hdOption3 = hdOption3;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setHdOption3", boolean.class);

				method.invoke(_eClosingRemoteModel, hdOption3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getHdOption3Money() {
		return _hdOption3Money;
	}

	@Override
	public void setHdOption3Money(double hdOption3Money) {
		_hdOption3Money = hdOption3Money;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setHdOption3Money",
						double.class);

				method.invoke(_eClosingRemoteModel, hdOption3Money);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getHdOption4() {
		return _hdOption4;
	}

	@Override
	public boolean isHdOption4() {
		return _hdOption4;
	}

	@Override
	public void setHdOption4(boolean hdOption4) {
		_hdOption4 = hdOption4;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setHdOption4", boolean.class);

				method.invoke(_eClosingRemoteModel, hdOption4);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getHdOption4Money() {
		return _hdOption4Money;
	}

	@Override
	public void setHdOption4Money(double hdOption4Money) {
		_hdOption4Money = hdOption4Money;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setHdOption4Money",
						double.class);

				method.invoke(_eClosingRemoteModel, hdOption4Money);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHdStatus() {
		return _hdStatus;
	}

	@Override
	public void setHdStatus(String hdStatus) {
		_hdStatus = hdStatus;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setHdStatus", String.class);

				method.invoke(_eClosingRemoteModel, hdStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHdComments() {
		return _hdComments;
	}

	@Override
	public void setHdComments(String hdComments) {
		_hdComments = hdComments;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setHdComments", String.class);

				method.invoke(_eClosingRemoteModel, hdComments);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHdleaveText() {
		return _hdleaveText;
	}

	@Override
	public void setHdleaveText(String hdleaveText) {
		_hdleaveText = hdleaveText;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setHdleaveText", String.class);

				method.invoke(_eClosingRemoteModel, hdleaveText);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getFdOption1() {
		return _fdOption1;
	}

	@Override
	public boolean isFdOption1() {
		return _fdOption1;
	}

	@Override
	public void setFdOption1(boolean fdOption1) {
		_fdOption1 = fdOption1;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setFdOption1", boolean.class);

				method.invoke(_eClosingRemoteModel, fdOption1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getFdOption2() {
		return _fdOption2;
	}

	@Override
	public boolean isFdOption2() {
		return _fdOption2;
	}

	@Override
	public void setFdOption2(boolean fdOption2) {
		_fdOption2 = fdOption2;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setFdOption2", boolean.class);

				method.invoke(_eClosingRemoteModel, fdOption2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getFdOption3() {
		return _fdOption3;
	}

	@Override
	public boolean isFdOption3() {
		return _fdOption3;
	}

	@Override
	public void setFdOption3(boolean fdOption3) {
		_fdOption3 = fdOption3;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setFdOption3", boolean.class);

				method.invoke(_eClosingRemoteModel, fdOption3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getFdOption4() {
		return _fdOption4;
	}

	@Override
	public boolean isFdOption4() {
		return _fdOption4;
	}

	@Override
	public void setFdOption4(boolean fdOption4) {
		_fdOption4 = fdOption4;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setFdOption4", boolean.class);

				method.invoke(_eClosingRemoteModel, fdOption4);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFdOption4Text() {
		return _fdOption4Text;
	}

	@Override
	public void setFdOption4Text(String fdOption4Text) {
		_fdOption4Text = fdOption4Text;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setFdOption4Text", String.class);

				method.invoke(_eClosingRemoteModel, fdOption4Text);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFdStatus() {
		return _fdStatus;
	}

	@Override
	public void setFdStatus(String fdStatus) {
		_fdStatus = fdStatus;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setFdStatus", String.class);

				method.invoke(_eClosingRemoteModel, fdStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFdComments() {
		return _fdComments;
	}

	@Override
	public void setFdComments(String fdComments) {
		_fdComments = fdComments;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setFdComments", String.class);

				method.invoke(_eClosingRemoteModel, fdComments);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getApplicantAgent() {
		return _applicantAgent;
	}

	@Override
	public boolean isApplicantAgent() {
		return _applicantAgent;
	}

	@Override
	public void setApplicantAgent(boolean applicantAgent) {
		_applicantAgent = applicantAgent;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setApplicantAgent",
						boolean.class);

				method.invoke(_eClosingRemoteModel, applicantAgent);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getApproverAgent() {
		return _approverAgent;
	}

	@Override
	public boolean isApproverAgent() {
		return _approverAgent;
	}

	@Override
	public void setApproverAgent(boolean approverAgent) {
		_approverAgent = approverAgent;

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setApproverAgent",
						boolean.class);

				method.invoke(_eClosingRemoteModel, approverAgent);
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

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setProcessType", String.class);

				method.invoke(_eClosingRemoteModel, processType);
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

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setSubProcessType",
						String.class);

				method.invoke(_eClosingRemoteModel, subProcessType);
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

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_eClosingRemoteModel, status);
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

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusByUserId", long.class);

				method.invoke(_eClosingRemoteModel, statusByUserId);
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

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusByUserName",
						String.class);

				method.invoke(_eClosingRemoteModel, statusByUserName);
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

		if (_eClosingRemoteModel != null) {
			try {
				Class<?> clazz = _eClosingRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusDate", Date.class);

				method.invoke(_eClosingRemoteModel, statusDate);
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

	public BaseModel<?> getEClosingRemoteModel() {
		return _eClosingRemoteModel;
	}

	public void setEClosingRemoteModel(BaseModel<?> eClosingRemoteModel) {
		_eClosingRemoteModel = eClosingRemoteModel;
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

		Class<?> remoteModelClass = _eClosingRemoteModel.getClass();

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

		Object returnValue = method.invoke(_eClosingRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EClosingLocalServiceUtil.addEClosing(this);
		}
		else {
			EClosingLocalServiceUtil.updateEClosing(this);
		}
	}

	@Override
	public EClosing toEscapedModel() {
		return (EClosing)ProxyUtil.newProxyInstance(EClosing.class.getClassLoader(),
			new Class[] { EClosing.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EClosingClp clone = new EClosingClp();

		clone.setEclosingId(getEclosingId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setTicketNo(getTicketNo());
		clone.setStaffCode(getStaffCode());
		clone.setStaffName(getStaffName());
		clone.setCompany(getCompany());
		clone.setDivision(getDivision());
		clone.setDepartment(getDepartment());
		clone.setCostCenter(getCostCenter());
		clone.setFunctionName(getFunctionName());
		clone.setPositionCode(getPositionCode());
		clone.setEmployeeGroupId(getEmployeeGroupId());
		clone.setEmployeeGroupName(getEmployeeGroupName());
		clone.setPrivateEmailAddress(getPrivateEmailAddress());
		clone.setStartingDate(getStartingDate());
		clone.setLastWorkingDay(getLastWorkingDay());
		clone.setFinishContractDate(getFinishContractDate());
		clone.setSeatOfficeNumber(getSeatOfficeNumber());
		clone.setPermanentAddress(getPermanentAddress());
		clone.setDmOption1(getDmOption1());
		clone.setDmOption2(getDmOption2());
		clone.setDmStatus(getDmStatus());
		clone.setDmComments(getDmComments());
		clone.setAdOption1(getAdOption1());
		clone.setAdOption2(getAdOption2());
		clone.setAdOption3(getAdOption3());
		clone.setAdOption4(getAdOption4());
		clone.setAdFinanceFee(getAdFinanceFee());
		clone.setAdStatus(getAdStatus());
		clone.setAdComments(getAdComments());
		clone.setFsOption1(getFsOption1());
		clone.setFsStatus(getFsStatus());
		clone.setFsComments(getFsComments());
		clone.setFlcOption1(getFlcOption1());
		clone.setFlcOption2(getFlcOption2());
		clone.setFlcStatus(getFlcStatus());
		clone.setFlcComments(getFlcComments());
		clone.setSecurityOption1(getSecurityOption1());
		clone.setSecurityFinanceFee(getSecurityFinanceFee());
		clone.setSecurityStatus(getSecurityStatus());
		clone.setSecurityComments(getSecurityComments());
		clone.setIdOption1(getIdOption1());
		clone.setIdOption2(getIdOption2());
		clone.setIdOption3(getIdOption3());
		clone.setIdOption4(getIdOption4());
		clone.setIdOption5(getIdOption5());
		clone.setIdOption6(getIdOption6());
		clone.setIdOption7(getIdOption7());
		clone.setIdOption8(getIdOption8());
		clone.setIdOption9(getIdOption9());
		clone.setIdHrFee(getIdHrFee());
		clone.setIdFinanceFee(getIdFinanceFee());
		clone.setIdStatus(getIdStatus());
		clone.setIdComments(getIdComments());
		clone.setHtdOption1(getHtdOption1());
		clone.setHtdHrFee(getHtdHrFee());
		clone.setHtdFinanceFee(getHtdFinanceFee());
		clone.setHtdStatus(getHtdStatus());
		clone.setHtdComments(getHtdComments());
		clone.setHdOption1(getHdOption1());
		clone.setHdOption2(getHdOption2());
		clone.setHdOption2Text(getHdOption2Text());
		clone.setHdOption3(getHdOption3());
		clone.setHdOption3Money(getHdOption3Money());
		clone.setHdOption4(getHdOption4());
		clone.setHdOption4Money(getHdOption4Money());
		clone.setHdStatus(getHdStatus());
		clone.setHdComments(getHdComments());
		clone.setHdleaveText(getHdleaveText());
		clone.setFdOption1(getFdOption1());
		clone.setFdOption2(getFdOption2());
		clone.setFdOption3(getFdOption3());
		clone.setFdOption4(getFdOption4());
		clone.setFdOption4Text(getFdOption4Text());
		clone.setFdStatus(getFdStatus());
		clone.setFdComments(getFdComments());
		clone.setApplicantAgent(getApplicantAgent());
		clone.setApproverAgent(getApproverAgent());
		clone.setProcessType(getProcessType());
		clone.setSubProcessType(getSubProcessType());
		clone.setStatus(getStatus());
		clone.setStatusByUserId(getStatusByUserId());
		clone.setStatusByUserName(getStatusByUserName());
		clone.setStatusDate(getStatusDate());

		return clone;
	}

	@Override
	public int compareTo(EClosing eClosing) {
		int value = 0;

		if (getEclosingId() < eClosing.getEclosingId()) {
			value = -1;
		}
		else if (getEclosingId() > eClosing.getEclosingId()) {
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

		if (!(obj instanceof EClosingClp)) {
			return false;
		}

		EClosingClp eClosing = (EClosingClp)obj;

		long primaryKey = eClosing.getPrimaryKey();

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
		StringBundler sb = new StringBundler(179);

		sb.append("{eclosingId=");
		sb.append(getEclosingId());
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
		sb.append(", ticketNo=");
		sb.append(getTicketNo());
		sb.append(", staffCode=");
		sb.append(getStaffCode());
		sb.append(", staffName=");
		sb.append(getStaffName());
		sb.append(", company=");
		sb.append(getCompany());
		sb.append(", division=");
		sb.append(getDivision());
		sb.append(", department=");
		sb.append(getDepartment());
		sb.append(", costCenter=");
		sb.append(getCostCenter());
		sb.append(", functionName=");
		sb.append(getFunctionName());
		sb.append(", positionCode=");
		sb.append(getPositionCode());
		sb.append(", employeeGroupId=");
		sb.append(getEmployeeGroupId());
		sb.append(", employeeGroupName=");
		sb.append(getEmployeeGroupName());
		sb.append(", privateEmailAddress=");
		sb.append(getPrivateEmailAddress());
		sb.append(", startingDate=");
		sb.append(getStartingDate());
		sb.append(", lastWorkingDay=");
		sb.append(getLastWorkingDay());
		sb.append(", finishContractDate=");
		sb.append(getFinishContractDate());
		sb.append(", seatOfficeNumber=");
		sb.append(getSeatOfficeNumber());
		sb.append(", permanentAddress=");
		sb.append(getPermanentAddress());
		sb.append(", dmOption1=");
		sb.append(getDmOption1());
		sb.append(", dmOption2=");
		sb.append(getDmOption2());
		sb.append(", dmStatus=");
		sb.append(getDmStatus());
		sb.append(", dmComments=");
		sb.append(getDmComments());
		sb.append(", adOption1=");
		sb.append(getAdOption1());
		sb.append(", adOption2=");
		sb.append(getAdOption2());
		sb.append(", adOption3=");
		sb.append(getAdOption3());
		sb.append(", adOption4=");
		sb.append(getAdOption4());
		sb.append(", adFinanceFee=");
		sb.append(getAdFinanceFee());
		sb.append(", adStatus=");
		sb.append(getAdStatus());
		sb.append(", adComments=");
		sb.append(getAdComments());
		sb.append(", fsOption1=");
		sb.append(getFsOption1());
		sb.append(", fsStatus=");
		sb.append(getFsStatus());
		sb.append(", fsComments=");
		sb.append(getFsComments());
		sb.append(", flcOption1=");
		sb.append(getFlcOption1());
		sb.append(", flcOption2=");
		sb.append(getFlcOption2());
		sb.append(", flcStatus=");
		sb.append(getFlcStatus());
		sb.append(", flcComments=");
		sb.append(getFlcComments());
		sb.append(", securityOption1=");
		sb.append(getSecurityOption1());
		sb.append(", securityFinanceFee=");
		sb.append(getSecurityFinanceFee());
		sb.append(", securityStatus=");
		sb.append(getSecurityStatus());
		sb.append(", securityComments=");
		sb.append(getSecurityComments());
		sb.append(", idOption1=");
		sb.append(getIdOption1());
		sb.append(", idOption2=");
		sb.append(getIdOption2());
		sb.append(", idOption3=");
		sb.append(getIdOption3());
		sb.append(", idOption4=");
		sb.append(getIdOption4());
		sb.append(", idOption5=");
		sb.append(getIdOption5());
		sb.append(", idOption6=");
		sb.append(getIdOption6());
		sb.append(", idOption7=");
		sb.append(getIdOption7());
		sb.append(", idOption8=");
		sb.append(getIdOption8());
		sb.append(", idOption9=");
		sb.append(getIdOption9());
		sb.append(", idHrFee=");
		sb.append(getIdHrFee());
		sb.append(", idFinanceFee=");
		sb.append(getIdFinanceFee());
		sb.append(", idStatus=");
		sb.append(getIdStatus());
		sb.append(", idComments=");
		sb.append(getIdComments());
		sb.append(", htdOption1=");
		sb.append(getHtdOption1());
		sb.append(", htdHrFee=");
		sb.append(getHtdHrFee());
		sb.append(", htdFinanceFee=");
		sb.append(getHtdFinanceFee());
		sb.append(", htdStatus=");
		sb.append(getHtdStatus());
		sb.append(", htdComments=");
		sb.append(getHtdComments());
		sb.append(", hdOption1=");
		sb.append(getHdOption1());
		sb.append(", hdOption2=");
		sb.append(getHdOption2());
		sb.append(", hdOption2Text=");
		sb.append(getHdOption2Text());
		sb.append(", hdOption3=");
		sb.append(getHdOption3());
		sb.append(", hdOption3Money=");
		sb.append(getHdOption3Money());
		sb.append(", hdOption4=");
		sb.append(getHdOption4());
		sb.append(", hdOption4Money=");
		sb.append(getHdOption4Money());
		sb.append(", hdStatus=");
		sb.append(getHdStatus());
		sb.append(", hdComments=");
		sb.append(getHdComments());
		sb.append(", hdleaveText=");
		sb.append(getHdleaveText());
		sb.append(", fdOption1=");
		sb.append(getFdOption1());
		sb.append(", fdOption2=");
		sb.append(getFdOption2());
		sb.append(", fdOption3=");
		sb.append(getFdOption3());
		sb.append(", fdOption4=");
		sb.append(getFdOption4());
		sb.append(", fdOption4Text=");
		sb.append(getFdOption4Text());
		sb.append(", fdStatus=");
		sb.append(getFdStatus());
		sb.append(", fdComments=");
		sb.append(getFdComments());
		sb.append(", applicantAgent=");
		sb.append(getApplicantAgent());
		sb.append(", approverAgent=");
		sb.append(getApproverAgent());
		sb.append(", processType=");
		sb.append(getProcessType());
		sb.append(", subProcessType=");
		sb.append(getSubProcessType());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", statusByUserId=");
		sb.append(getStatusByUserId());
		sb.append(", statusByUserName=");
		sb.append(getStatusByUserName());
		sb.append(", statusDate=");
		sb.append(getStatusDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(271);

		sb.append("<model><model-name>");
		sb.append("com.e.closing.model.EClosing");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>eclosingId</column-name><column-value><![CDATA[");
		sb.append(getEclosingId());
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
			"<column><column-name>ticketNo</column-name><column-value><![CDATA[");
		sb.append(getTicketNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>staffCode</column-name><column-value><![CDATA[");
		sb.append(getStaffCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>staffName</column-name><column-value><![CDATA[");
		sb.append(getStaffName());
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
			"<column><column-name>functionName</column-name><column-value><![CDATA[");
		sb.append(getFunctionName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>positionCode</column-name><column-value><![CDATA[");
		sb.append(getPositionCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>employeeGroupId</column-name><column-value><![CDATA[");
		sb.append(getEmployeeGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>employeeGroupName</column-name><column-value><![CDATA[");
		sb.append(getEmployeeGroupName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>privateEmailAddress</column-name><column-value><![CDATA[");
		sb.append(getPrivateEmailAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startingDate</column-name><column-value><![CDATA[");
		sb.append(getStartingDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastWorkingDay</column-name><column-value><![CDATA[");
		sb.append(getLastWorkingDay());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>finishContractDate</column-name><column-value><![CDATA[");
		sb.append(getFinishContractDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>seatOfficeNumber</column-name><column-value><![CDATA[");
		sb.append(getSeatOfficeNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>permanentAddress</column-name><column-value><![CDATA[");
		sb.append(getPermanentAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dmOption1</column-name><column-value><![CDATA[");
		sb.append(getDmOption1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dmOption2</column-name><column-value><![CDATA[");
		sb.append(getDmOption2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dmStatus</column-name><column-value><![CDATA[");
		sb.append(getDmStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dmComments</column-name><column-value><![CDATA[");
		sb.append(getDmComments());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>adOption1</column-name><column-value><![CDATA[");
		sb.append(getAdOption1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>adOption2</column-name><column-value><![CDATA[");
		sb.append(getAdOption2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>adOption3</column-name><column-value><![CDATA[");
		sb.append(getAdOption3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>adOption4</column-name><column-value><![CDATA[");
		sb.append(getAdOption4());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>adFinanceFee</column-name><column-value><![CDATA[");
		sb.append(getAdFinanceFee());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>adStatus</column-name><column-value><![CDATA[");
		sb.append(getAdStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>adComments</column-name><column-value><![CDATA[");
		sb.append(getAdComments());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fsOption1</column-name><column-value><![CDATA[");
		sb.append(getFsOption1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fsStatus</column-name><column-value><![CDATA[");
		sb.append(getFsStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fsComments</column-name><column-value><![CDATA[");
		sb.append(getFsComments());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>flcOption1</column-name><column-value><![CDATA[");
		sb.append(getFlcOption1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>flcOption2</column-name><column-value><![CDATA[");
		sb.append(getFlcOption2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>flcStatus</column-name><column-value><![CDATA[");
		sb.append(getFlcStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>flcComments</column-name><column-value><![CDATA[");
		sb.append(getFlcComments());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>securityOption1</column-name><column-value><![CDATA[");
		sb.append(getSecurityOption1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>securityFinanceFee</column-name><column-value><![CDATA[");
		sb.append(getSecurityFinanceFee());
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
			"<column><column-name>idOption1</column-name><column-value><![CDATA[");
		sb.append(getIdOption1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idOption2</column-name><column-value><![CDATA[");
		sb.append(getIdOption2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idOption3</column-name><column-value><![CDATA[");
		sb.append(getIdOption3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idOption4</column-name><column-value><![CDATA[");
		sb.append(getIdOption4());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idOption5</column-name><column-value><![CDATA[");
		sb.append(getIdOption5());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idOption6</column-name><column-value><![CDATA[");
		sb.append(getIdOption6());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idOption7</column-name><column-value><![CDATA[");
		sb.append(getIdOption7());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idOption8</column-name><column-value><![CDATA[");
		sb.append(getIdOption8());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idOption9</column-name><column-value><![CDATA[");
		sb.append(getIdOption9());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idHrFee</column-name><column-value><![CDATA[");
		sb.append(getIdHrFee());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idFinanceFee</column-name><column-value><![CDATA[");
		sb.append(getIdFinanceFee());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idStatus</column-name><column-value><![CDATA[");
		sb.append(getIdStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idComments</column-name><column-value><![CDATA[");
		sb.append(getIdComments());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>htdOption1</column-name><column-value><![CDATA[");
		sb.append(getHtdOption1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>htdHrFee</column-name><column-value><![CDATA[");
		sb.append(getHtdHrFee());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>htdFinanceFee</column-name><column-value><![CDATA[");
		sb.append(getHtdFinanceFee());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>htdStatus</column-name><column-value><![CDATA[");
		sb.append(getHtdStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>htdComments</column-name><column-value><![CDATA[");
		sb.append(getHtdComments());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hdOption1</column-name><column-value><![CDATA[");
		sb.append(getHdOption1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hdOption2</column-name><column-value><![CDATA[");
		sb.append(getHdOption2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hdOption2Text</column-name><column-value><![CDATA[");
		sb.append(getHdOption2Text());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hdOption3</column-name><column-value><![CDATA[");
		sb.append(getHdOption3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hdOption3Money</column-name><column-value><![CDATA[");
		sb.append(getHdOption3Money());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hdOption4</column-name><column-value><![CDATA[");
		sb.append(getHdOption4());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hdOption4Money</column-name><column-value><![CDATA[");
		sb.append(getHdOption4Money());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hdStatus</column-name><column-value><![CDATA[");
		sb.append(getHdStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hdComments</column-name><column-value><![CDATA[");
		sb.append(getHdComments());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hdleaveText</column-name><column-value><![CDATA[");
		sb.append(getHdleaveText());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fdOption1</column-name><column-value><![CDATA[");
		sb.append(getFdOption1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fdOption2</column-name><column-value><![CDATA[");
		sb.append(getFdOption2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fdOption3</column-name><column-value><![CDATA[");
		sb.append(getFdOption3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fdOption4</column-name><column-value><![CDATA[");
		sb.append(getFdOption4());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fdOption4Text</column-name><column-value><![CDATA[");
		sb.append(getFdOption4Text());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fdStatus</column-name><column-value><![CDATA[");
		sb.append(getFdStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fdComments</column-name><column-value><![CDATA[");
		sb.append(getFdComments());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>applicantAgent</column-name><column-value><![CDATA[");
		sb.append(getApplicantAgent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>approverAgent</column-name><column-value><![CDATA[");
		sb.append(getApproverAgent());
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

		sb.append("</model>");

		return sb.toString();
	}

	private long _eclosingId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _ticketNo;
	private int _staffCode;
	private String _staffName;
	private String _company;
	private String _division;
	private String _department;
	private String _costCenter;
	private String _functionName;
	private String _positionCode;
	private String _employeeGroupId;
	private String _employeeGroupName;
	private String _privateEmailAddress;
	private Date _startingDate;
	private Date _lastWorkingDay;
	private Date _finishContractDate;
	private String _seatOfficeNumber;
	private String _permanentAddress;
	private boolean _dmOption1;
	private boolean _dmOption2;
	private String _dmStatus;
	private String _dmComments;
	private boolean _adOption1;
	private boolean _adOption2;
	private boolean _adOption3;
	private boolean _adOption4;
	private double _adFinanceFee;
	private String _adStatus;
	private String _adComments;
	private boolean _fsOption1;
	private String _fsStatus;
	private String _fsComments;
	private boolean _flcOption1;
	private boolean _flcOption2;
	private String _flcStatus;
	private String _flcComments;
	private boolean _securityOption1;
	private double _securityFinanceFee;
	private String _securityStatus;
	private String _securityComments;
	private boolean _idOption1;
	private boolean _idOption2;
	private boolean _idOption3;
	private boolean _idOption4;
	private boolean _idOption5;
	private boolean _idOption6;
	private boolean _idOption7;
	private boolean _idOption8;
	private boolean _idOption9;
	private double _idHrFee;
	private double _idFinanceFee;
	private String _idStatus;
	private String _idComments;
	private boolean _htdOption1;
	private double _htdHrFee;
	private double _htdFinanceFee;
	private String _htdStatus;
	private String _htdComments;
	private boolean _hdOption1;
	private boolean _hdOption2;
	private String _hdOption2Text;
	private boolean _hdOption3;
	private double _hdOption3Money;
	private boolean _hdOption4;
	private double _hdOption4Money;
	private String _hdStatus;
	private String _hdComments;
	private String _hdleaveText;
	private boolean _fdOption1;
	private boolean _fdOption2;
	private boolean _fdOption3;
	private boolean _fdOption4;
	private String _fdOption4Text;
	private String _fdStatus;
	private String _fdComments;
	private boolean _applicantAgent;
	private boolean _approverAgent;
	private String _processType;
	private String _subProcessType;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserUuid;
	private String _statusByUserName;
	private Date _statusDate;
	private BaseModel<?> _eClosingRemoteModel;
	private Class<?> _clpSerializerClass = com.e.closing.service.ClpSerializer.class;
}