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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.e.closing.service.http.EClosingServiceSoap}.
 *
 * @author t.a.jiang
 * @see com.e.closing.service.http.EClosingServiceSoap
 * @generated
 */
public class EClosingSoap implements Serializable {
	public static EClosingSoap toSoapModel(EClosing model) {
		EClosingSoap soapModel = new EClosingSoap();

		soapModel.setEclosingId(model.getEclosingId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTicketNo(model.getTicketNo());
		soapModel.setStaffCode(model.getStaffCode());
		soapModel.setStaffName(model.getStaffName());
		soapModel.setCompany(model.getCompany());
		soapModel.setDivision(model.getDivision());
		soapModel.setDepartment(model.getDepartment());
		soapModel.setCostCenter(model.getCostCenter());
		soapModel.setFunctionName(model.getFunctionName());
		soapModel.setPositionCode(model.getPositionCode());
		soapModel.setEmployeeGroupId(model.getEmployeeGroupId());
		soapModel.setEmployeeGroupName(model.getEmployeeGroupName());
		soapModel.setPrivateEmailAddress(model.getPrivateEmailAddress());
		soapModel.setStartingDate(model.getStartingDate());
		soapModel.setLastWorkingDay(model.getLastWorkingDay());
		soapModel.setFinishContractDate(model.getFinishContractDate());
		soapModel.setSeatOfficeNumber(model.getSeatOfficeNumber());
		soapModel.setPermanentAddress(model.getPermanentAddress());
		soapModel.setDmOption1(model.getDmOption1());
		soapModel.setDmOption2(model.getDmOption2());
		soapModel.setDmStatus(model.getDmStatus());
		soapModel.setDmComments(model.getDmComments());
		soapModel.setAdOption1(model.getAdOption1());
		soapModel.setAdOption2(model.getAdOption2());
		soapModel.setAdOption3(model.getAdOption3());
		soapModel.setAdOption4(model.getAdOption4());
		soapModel.setAdFinanceFee(model.getAdFinanceFee());
		soapModel.setAdStatus(model.getAdStatus());
		soapModel.setAdComments(model.getAdComments());
		soapModel.setFsOption1(model.getFsOption1());
		soapModel.setFsStatus(model.getFsStatus());
		soapModel.setFsComments(model.getFsComments());
		soapModel.setFlcOption1(model.getFlcOption1());
		soapModel.setFlcOption2(model.getFlcOption2());
		soapModel.setFlcStatus(model.getFlcStatus());
		soapModel.setFlcComments(model.getFlcComments());
		soapModel.setSecurityOption1(model.getSecurityOption1());
		soapModel.setSecurityFinanceFee(model.getSecurityFinanceFee());
		soapModel.setSecurityStatus(model.getSecurityStatus());
		soapModel.setSecurityComments(model.getSecurityComments());
		soapModel.setIdOption1(model.getIdOption1());
		soapModel.setIdOption2(model.getIdOption2());
		soapModel.setIdOption3(model.getIdOption3());
		soapModel.setIdOption4(model.getIdOption4());
		soapModel.setIdOption5(model.getIdOption5());
		soapModel.setIdOption6(model.getIdOption6());
		soapModel.setIdOption7(model.getIdOption7());
		soapModel.setIdOption8(model.getIdOption8());
		soapModel.setIdOption9(model.getIdOption9());
		soapModel.setIdHrFee(model.getIdHrFee());
		soapModel.setIdFinanceFee(model.getIdFinanceFee());
		soapModel.setIdStatus(model.getIdStatus());
		soapModel.setIdComments(model.getIdComments());
		soapModel.setHtdOption1(model.getHtdOption1());
		soapModel.setHtdHrFee(model.getHtdHrFee());
		soapModel.setHtdFinanceFee(model.getHtdFinanceFee());
		soapModel.setHtdStatus(model.getHtdStatus());
		soapModel.setHtdComments(model.getHtdComments());
		soapModel.setHdOption1(model.getHdOption1());
		soapModel.setHdOption2(model.getHdOption2());
		soapModel.setHdOption2Text(model.getHdOption2Text());
		soapModel.setHdOption3(model.getHdOption3());
		soapModel.setHdOption3Money(model.getHdOption3Money());
		soapModel.setHdOption4(model.getHdOption4());
		soapModel.setHdOption4Money(model.getHdOption4Money());
		soapModel.setHdStatus(model.getHdStatus());
		soapModel.setHdComments(model.getHdComments());
		soapModel.setHdleaveText(model.getHdleaveText());
		soapModel.setFdOption1(model.getFdOption1());
		soapModel.setFdOption2(model.getFdOption2());
		soapModel.setFdOption3(model.getFdOption3());
		soapModel.setFdOption4(model.getFdOption4());
		soapModel.setFdOption4Text(model.getFdOption4Text());
		soapModel.setFdStatus(model.getFdStatus());
		soapModel.setFdComments(model.getFdComments());
		soapModel.setApplicantAgent(model.getApplicantAgent());
		soapModel.setApproverAgent(model.getApproverAgent());
		soapModel.setProcessType(model.getProcessType());
		soapModel.setSubProcessType(model.getSubProcessType());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());

		return soapModel;
	}

	public static EClosingSoap[] toSoapModels(EClosing[] models) {
		EClosingSoap[] soapModels = new EClosingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EClosingSoap[][] toSoapModels(EClosing[][] models) {
		EClosingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EClosingSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EClosingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EClosingSoap[] toSoapModels(List<EClosing> models) {
		List<EClosingSoap> soapModels = new ArrayList<EClosingSoap>(models.size());

		for (EClosing model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EClosingSoap[soapModels.size()]);
	}

	public EClosingSoap() {
	}

	public long getPrimaryKey() {
		return _eclosingId;
	}

	public void setPrimaryKey(long pk) {
		setEclosingId(pk);
	}

	public long getEclosingId() {
		return _eclosingId;
	}

	public void setEclosingId(long eclosingId) {
		_eclosingId = eclosingId;
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

	public String getTicketNo() {
		return _ticketNo;
	}

	public void setTicketNo(String ticketNo) {
		_ticketNo = ticketNo;
	}

	public int getStaffCode() {
		return _staffCode;
	}

	public void setStaffCode(int staffCode) {
		_staffCode = staffCode;
	}

	public String getStaffName() {
		return _staffName;
	}

	public void setStaffName(String staffName) {
		_staffName = staffName;
	}

	public String getCompany() {
		return _company;
	}

	public void setCompany(String company) {
		_company = company;
	}

	public String getDivision() {
		return _division;
	}

	public void setDivision(String division) {
		_division = division;
	}

	public String getDepartment() {
		return _department;
	}

	public void setDepartment(String department) {
		_department = department;
	}

	public String getCostCenter() {
		return _costCenter;
	}

	public void setCostCenter(String costCenter) {
		_costCenter = costCenter;
	}

	public String getFunctionName() {
		return _functionName;
	}

	public void setFunctionName(String functionName) {
		_functionName = functionName;
	}

	public String getPositionCode() {
		return _positionCode;
	}

	public void setPositionCode(String positionCode) {
		_positionCode = positionCode;
	}

	public String getEmployeeGroupId() {
		return _employeeGroupId;
	}

	public void setEmployeeGroupId(String employeeGroupId) {
		_employeeGroupId = employeeGroupId;
	}

	public String getEmployeeGroupName() {
		return _employeeGroupName;
	}

	public void setEmployeeGroupName(String employeeGroupName) {
		_employeeGroupName = employeeGroupName;
	}

	public String getPrivateEmailAddress() {
		return _privateEmailAddress;
	}

	public void setPrivateEmailAddress(String privateEmailAddress) {
		_privateEmailAddress = privateEmailAddress;
	}

	public Date getStartingDate() {
		return _startingDate;
	}

	public void setStartingDate(Date startingDate) {
		_startingDate = startingDate;
	}

	public Date getLastWorkingDay() {
		return _lastWorkingDay;
	}

	public void setLastWorkingDay(Date lastWorkingDay) {
		_lastWorkingDay = lastWorkingDay;
	}

	public Date getFinishContractDate() {
		return _finishContractDate;
	}

	public void setFinishContractDate(Date finishContractDate) {
		_finishContractDate = finishContractDate;
	}

	public String getSeatOfficeNumber() {
		return _seatOfficeNumber;
	}

	public void setSeatOfficeNumber(String seatOfficeNumber) {
		_seatOfficeNumber = seatOfficeNumber;
	}

	public String getPermanentAddress() {
		return _permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		_permanentAddress = permanentAddress;
	}

	public boolean getDmOption1() {
		return _dmOption1;
	}

	public boolean isDmOption1() {
		return _dmOption1;
	}

	public void setDmOption1(boolean dmOption1) {
		_dmOption1 = dmOption1;
	}

	public boolean getDmOption2() {
		return _dmOption2;
	}

	public boolean isDmOption2() {
		return _dmOption2;
	}

	public void setDmOption2(boolean dmOption2) {
		_dmOption2 = dmOption2;
	}

	public String getDmStatus() {
		return _dmStatus;
	}

	public void setDmStatus(String dmStatus) {
		_dmStatus = dmStatus;
	}

	public String getDmComments() {
		return _dmComments;
	}

	public void setDmComments(String dmComments) {
		_dmComments = dmComments;
	}

	public boolean getAdOption1() {
		return _adOption1;
	}

	public boolean isAdOption1() {
		return _adOption1;
	}

	public void setAdOption1(boolean adOption1) {
		_adOption1 = adOption1;
	}

	public boolean getAdOption2() {
		return _adOption2;
	}

	public boolean isAdOption2() {
		return _adOption2;
	}

	public void setAdOption2(boolean adOption2) {
		_adOption2 = adOption2;
	}

	public boolean getAdOption3() {
		return _adOption3;
	}

	public boolean isAdOption3() {
		return _adOption3;
	}

	public void setAdOption3(boolean adOption3) {
		_adOption3 = adOption3;
	}

	public boolean getAdOption4() {
		return _adOption4;
	}

	public boolean isAdOption4() {
		return _adOption4;
	}

	public void setAdOption4(boolean adOption4) {
		_adOption4 = adOption4;
	}

	public double getAdFinanceFee() {
		return _adFinanceFee;
	}

	public void setAdFinanceFee(double adFinanceFee) {
		_adFinanceFee = adFinanceFee;
	}

	public String getAdStatus() {
		return _adStatus;
	}

	public void setAdStatus(String adStatus) {
		_adStatus = adStatus;
	}

	public String getAdComments() {
		return _adComments;
	}

	public void setAdComments(String adComments) {
		_adComments = adComments;
	}

	public boolean getFsOption1() {
		return _fsOption1;
	}

	public boolean isFsOption1() {
		return _fsOption1;
	}

	public void setFsOption1(boolean fsOption1) {
		_fsOption1 = fsOption1;
	}

	public String getFsStatus() {
		return _fsStatus;
	}

	public void setFsStatus(String fsStatus) {
		_fsStatus = fsStatus;
	}

	public String getFsComments() {
		return _fsComments;
	}

	public void setFsComments(String fsComments) {
		_fsComments = fsComments;
	}

	public boolean getFlcOption1() {
		return _flcOption1;
	}

	public boolean isFlcOption1() {
		return _flcOption1;
	}

	public void setFlcOption1(boolean flcOption1) {
		_flcOption1 = flcOption1;
	}

	public boolean getFlcOption2() {
		return _flcOption2;
	}

	public boolean isFlcOption2() {
		return _flcOption2;
	}

	public void setFlcOption2(boolean flcOption2) {
		_flcOption2 = flcOption2;
	}

	public String getFlcStatus() {
		return _flcStatus;
	}

	public void setFlcStatus(String flcStatus) {
		_flcStatus = flcStatus;
	}

	public String getFlcComments() {
		return _flcComments;
	}

	public void setFlcComments(String flcComments) {
		_flcComments = flcComments;
	}

	public boolean getSecurityOption1() {
		return _securityOption1;
	}

	public boolean isSecurityOption1() {
		return _securityOption1;
	}

	public void setSecurityOption1(boolean securityOption1) {
		_securityOption1 = securityOption1;
	}

	public double getSecurityFinanceFee() {
		return _securityFinanceFee;
	}

	public void setSecurityFinanceFee(double securityFinanceFee) {
		_securityFinanceFee = securityFinanceFee;
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

	public boolean getIdOption1() {
		return _idOption1;
	}

	public boolean isIdOption1() {
		return _idOption1;
	}

	public void setIdOption1(boolean idOption1) {
		_idOption1 = idOption1;
	}

	public boolean getIdOption2() {
		return _idOption2;
	}

	public boolean isIdOption2() {
		return _idOption2;
	}

	public void setIdOption2(boolean idOption2) {
		_idOption2 = idOption2;
	}

	public boolean getIdOption3() {
		return _idOption3;
	}

	public boolean isIdOption3() {
		return _idOption3;
	}

	public void setIdOption3(boolean idOption3) {
		_idOption3 = idOption3;
	}

	public boolean getIdOption4() {
		return _idOption4;
	}

	public boolean isIdOption4() {
		return _idOption4;
	}

	public void setIdOption4(boolean idOption4) {
		_idOption4 = idOption4;
	}

	public boolean getIdOption5() {
		return _idOption5;
	}

	public boolean isIdOption5() {
		return _idOption5;
	}

	public void setIdOption5(boolean idOption5) {
		_idOption5 = idOption5;
	}

	public boolean getIdOption6() {
		return _idOption6;
	}

	public boolean isIdOption6() {
		return _idOption6;
	}

	public void setIdOption6(boolean idOption6) {
		_idOption6 = idOption6;
	}

	public boolean getIdOption7() {
		return _idOption7;
	}

	public boolean isIdOption7() {
		return _idOption7;
	}

	public void setIdOption7(boolean idOption7) {
		_idOption7 = idOption7;
	}

	public boolean getIdOption8() {
		return _idOption8;
	}

	public boolean isIdOption8() {
		return _idOption8;
	}

	public void setIdOption8(boolean idOption8) {
		_idOption8 = idOption8;
	}

	public boolean getIdOption9() {
		return _idOption9;
	}

	public boolean isIdOption9() {
		return _idOption9;
	}

	public void setIdOption9(boolean idOption9) {
		_idOption9 = idOption9;
	}

	public double getIdHrFee() {
		return _idHrFee;
	}

	public void setIdHrFee(double idHrFee) {
		_idHrFee = idHrFee;
	}

	public double getIdFinanceFee() {
		return _idFinanceFee;
	}

	public void setIdFinanceFee(double idFinanceFee) {
		_idFinanceFee = idFinanceFee;
	}

	public String getIdStatus() {
		return _idStatus;
	}

	public void setIdStatus(String idStatus) {
		_idStatus = idStatus;
	}

	public String getIdComments() {
		return _idComments;
	}

	public void setIdComments(String idComments) {
		_idComments = idComments;
	}

	public boolean getHtdOption1() {
		return _htdOption1;
	}

	public boolean isHtdOption1() {
		return _htdOption1;
	}

	public void setHtdOption1(boolean htdOption1) {
		_htdOption1 = htdOption1;
	}

	public double getHtdHrFee() {
		return _htdHrFee;
	}

	public void setHtdHrFee(double htdHrFee) {
		_htdHrFee = htdHrFee;
	}

	public double getHtdFinanceFee() {
		return _htdFinanceFee;
	}

	public void setHtdFinanceFee(double htdFinanceFee) {
		_htdFinanceFee = htdFinanceFee;
	}

	public String getHtdStatus() {
		return _htdStatus;
	}

	public void setHtdStatus(String htdStatus) {
		_htdStatus = htdStatus;
	}

	public String getHtdComments() {
		return _htdComments;
	}

	public void setHtdComments(String htdComments) {
		_htdComments = htdComments;
	}

	public boolean getHdOption1() {
		return _hdOption1;
	}

	public boolean isHdOption1() {
		return _hdOption1;
	}

	public void setHdOption1(boolean hdOption1) {
		_hdOption1 = hdOption1;
	}

	public boolean getHdOption2() {
		return _hdOption2;
	}

	public boolean isHdOption2() {
		return _hdOption2;
	}

	public void setHdOption2(boolean hdOption2) {
		_hdOption2 = hdOption2;
	}

	public String getHdOption2Text() {
		return _hdOption2Text;
	}

	public void setHdOption2Text(String hdOption2Text) {
		_hdOption2Text = hdOption2Text;
	}

	public boolean getHdOption3() {
		return _hdOption3;
	}

	public boolean isHdOption3() {
		return _hdOption3;
	}

	public void setHdOption3(boolean hdOption3) {
		_hdOption3 = hdOption3;
	}

	public double getHdOption3Money() {
		return _hdOption3Money;
	}

	public void setHdOption3Money(double hdOption3Money) {
		_hdOption3Money = hdOption3Money;
	}

	public boolean getHdOption4() {
		return _hdOption4;
	}

	public boolean isHdOption4() {
		return _hdOption4;
	}

	public void setHdOption4(boolean hdOption4) {
		_hdOption4 = hdOption4;
	}

	public double getHdOption4Money() {
		return _hdOption4Money;
	}

	public void setHdOption4Money(double hdOption4Money) {
		_hdOption4Money = hdOption4Money;
	}

	public String getHdStatus() {
		return _hdStatus;
	}

	public void setHdStatus(String hdStatus) {
		_hdStatus = hdStatus;
	}

	public String getHdComments() {
		return _hdComments;
	}

	public void setHdComments(String hdComments) {
		_hdComments = hdComments;
	}

	public String getHdleaveText() {
		return _hdleaveText;
	}

	public void setHdleaveText(String hdleaveText) {
		_hdleaveText = hdleaveText;
	}

	public boolean getFdOption1() {
		return _fdOption1;
	}

	public boolean isFdOption1() {
		return _fdOption1;
	}

	public void setFdOption1(boolean fdOption1) {
		_fdOption1 = fdOption1;
	}

	public boolean getFdOption2() {
		return _fdOption2;
	}

	public boolean isFdOption2() {
		return _fdOption2;
	}

	public void setFdOption2(boolean fdOption2) {
		_fdOption2 = fdOption2;
	}

	public boolean getFdOption3() {
		return _fdOption3;
	}

	public boolean isFdOption3() {
		return _fdOption3;
	}

	public void setFdOption3(boolean fdOption3) {
		_fdOption3 = fdOption3;
	}

	public boolean getFdOption4() {
		return _fdOption4;
	}

	public boolean isFdOption4() {
		return _fdOption4;
	}

	public void setFdOption4(boolean fdOption4) {
		_fdOption4 = fdOption4;
	}

	public String getFdOption4Text() {
		return _fdOption4Text;
	}

	public void setFdOption4Text(String fdOption4Text) {
		_fdOption4Text = fdOption4Text;
	}

	public String getFdStatus() {
		return _fdStatus;
	}

	public void setFdStatus(String fdStatus) {
		_fdStatus = fdStatus;
	}

	public String getFdComments() {
		return _fdComments;
	}

	public void setFdComments(String fdComments) {
		_fdComments = fdComments;
	}

	public boolean getApplicantAgent() {
		return _applicantAgent;
	}

	public boolean isApplicantAgent() {
		return _applicantAgent;
	}

	public void setApplicantAgent(boolean applicantAgent) {
		_applicantAgent = applicantAgent;
	}

	public boolean getApproverAgent() {
		return _approverAgent;
	}

	public boolean isApproverAgent() {
		return _approverAgent;
	}

	public void setApproverAgent(boolean approverAgent) {
		_approverAgent = approverAgent;
	}

	public String getProcessType() {
		return _processType;
	}

	public void setProcessType(String processType) {
		_processType = processType;
	}

	public String getSubProcessType() {
		return _subProcessType;
	}

	public void setSubProcessType(String subProcessType) {
		_subProcessType = subProcessType;
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

	private long _eclosingId;
	private long _groupId;
	private long _companyId;
	private long _userId;
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
	private String _statusByUserName;
	private Date _statusDate;
}