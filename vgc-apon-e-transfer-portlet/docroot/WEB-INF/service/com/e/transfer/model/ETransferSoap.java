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

package com.e.transfer.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.e.transfer.service.http.ETransferServiceSoap}.
 *
 * @author EZEYIFE
 * @see com.e.transfer.service.http.ETransferServiceSoap
 * @generated
 */
public class ETransferSoap implements Serializable {
	public static ETransferSoap toSoapModel(ETransfer model) {
		ETransferSoap soapModel = new ETransferSoap();

		soapModel.setETransferId(model.getETransferId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setTicketNo(model.getTicketNo());
		soapModel.setStaffName(model.getStaffName());
		soapModel.setCurrentStaffCode(model.getCurrentStaffCode());
		soapModel.setContractType(model.getContractType());
		soapModel.setNewStaffCode(model.getNewStaffCode());
		soapModel.setPassedLL(model.getPassedLL());
		soapModel.setAttendedSLT(model.getAttendedSLT());
		soapModel.setCurrentCompany(model.getCurrentCompany());
		soapModel.setCurrentDivision(model.getCurrentDivision());
		soapModel.setCurrentDepartment(model.getCurrentDepartment());
		soapModel.setCurrentFunctionName(model.getCurrentFunctionName());
		soapModel.setCurrentCostCenter(model.getCurrentCostCenter());
		soapModel.setCurrentReportingTo(model.getCurrentReportingTo());
		soapModel.setOtherAgreementIfAny(model.getOtherAgreementIfAny());
		soapModel.setCurrentOfficeSite(model.getCurrentOfficeSite());
		soapModel.setCurrentPositionCode(model.getCurrentPositionCode());
		soapModel.setReceivingStaffCode(model.getReceivingStaffCode());
		soapModel.setReceivingCompany(model.getReceivingCompany());
		soapModel.setReceivingDivision(model.getReceivingDivision());
		soapModel.setReceivingDepartment(model.getReceivingDepartment());
		soapModel.setNewFunctionName(model.getNewFunctionName());
		soapModel.setNewCostCenter(model.getNewCostCenter());
		soapModel.setNewReportingTo(model.getNewReportingTo());
		soapModel.setEffectiveDate(model.getEffectiveDate());
		soapModel.setNewOfficeSite(model.getNewOfficeSite());
		soapModel.setSapPositionCode(model.getSapPositionCode());
		soapModel.setReplacement(model.getReplacement());
		soapModel.setFunctionGrade(model.getFunctionGrade());
		soapModel.setBudgetTypeOfPosition(model.getBudgetTypeOfPosition());
		soapModel.setChinaSixty(model.getChinaSixty());
		soapModel.setTargetPDSupervisor(model.getTargetPDSupervisor());
		soapModel.setProcessType(model.getProcessType());
		soapModel.setSubProcessType(model.getSubProcessType());
		soapModel.setSubmittedDate(model.getSubmittedDate());
		soapModel.setComments(model.getComments());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());

		return soapModel;
	}

	public static ETransferSoap[] toSoapModels(ETransfer[] models) {
		ETransferSoap[] soapModels = new ETransferSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ETransferSoap[][] toSoapModels(ETransfer[][] models) {
		ETransferSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ETransferSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ETransferSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ETransferSoap[] toSoapModels(List<ETransfer> models) {
		List<ETransferSoap> soapModels = new ArrayList<ETransferSoap>(models.size());

		for (ETransfer model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ETransferSoap[soapModels.size()]);
	}

	public ETransferSoap() {
	}

	public long getPrimaryKey() {
		return _eTransferId;
	}

	public void setPrimaryKey(long pk) {
		setETransferId(pk);
	}

	public long getETransferId() {
		return _eTransferId;
	}

	public void setETransferId(long eTransferId) {
		_eTransferId = eTransferId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
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

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public String getTicketNo() {
		return _ticketNo;
	}

	public void setTicketNo(String ticketNo) {
		_ticketNo = ticketNo;
	}

	public String getStaffName() {
		return _staffName;
	}

	public void setStaffName(String staffName) {
		_staffName = staffName;
	}

	public String getCurrentStaffCode() {
		return _currentStaffCode;
	}

	public void setCurrentStaffCode(String currentStaffCode) {
		_currentStaffCode = currentStaffCode;
	}

	public String getContractType() {
		return _contractType;
	}

	public void setContractType(String contractType) {
		_contractType = contractType;
	}

	public String getNewStaffCode() {
		return _newStaffCode;
	}

	public void setNewStaffCode(String newStaffCode) {
		_newStaffCode = newStaffCode;
	}

	public int getPassedLL() {
		return _PassedLL;
	}

	public void setPassedLL(int PassedLL) {
		_PassedLL = PassedLL;
	}

	public int getAttendedSLT() {
		return _AttendedSLT;
	}

	public void setAttendedSLT(int AttendedSLT) {
		_AttendedSLT = AttendedSLT;
	}

	public String getCurrentCompany() {
		return _currentCompany;
	}

	public void setCurrentCompany(String currentCompany) {
		_currentCompany = currentCompany;
	}

	public String getCurrentDivision() {
		return _currentDivision;
	}

	public void setCurrentDivision(String currentDivision) {
		_currentDivision = currentDivision;
	}

	public String getCurrentDepartment() {
		return _currentDepartment;
	}

	public void setCurrentDepartment(String currentDepartment) {
		_currentDepartment = currentDepartment;
	}

	public String getCurrentFunctionName() {
		return _currentFunctionName;
	}

	public void setCurrentFunctionName(String currentFunctionName) {
		_currentFunctionName = currentFunctionName;
	}

	public String getCurrentCostCenter() {
		return _currentCostCenter;
	}

	public void setCurrentCostCenter(String currentCostCenter) {
		_currentCostCenter = currentCostCenter;
	}

	public String getCurrentReportingTo() {
		return _currentReportingTo;
	}

	public void setCurrentReportingTo(String currentReportingTo) {
		_currentReportingTo = currentReportingTo;
	}

	public String getOtherAgreementIfAny() {
		return _otherAgreementIfAny;
	}

	public void setOtherAgreementIfAny(String otherAgreementIfAny) {
		_otherAgreementIfAny = otherAgreementIfAny;
	}

	public String getCurrentOfficeSite() {
		return _currentOfficeSite;
	}

	public void setCurrentOfficeSite(String currentOfficeSite) {
		_currentOfficeSite = currentOfficeSite;
	}

	public String getCurrentPositionCode() {
		return _currentPositionCode;
	}

	public void setCurrentPositionCode(String currentPositionCode) {
		_currentPositionCode = currentPositionCode;
	}

	public String getReceivingStaffCode() {
		return _receivingStaffCode;
	}

	public void setReceivingStaffCode(String receivingStaffCode) {
		_receivingStaffCode = receivingStaffCode;
	}

	public String getReceivingCompany() {
		return _receivingCompany;
	}

	public void setReceivingCompany(String receivingCompany) {
		_receivingCompany = receivingCompany;
	}

	public String getReceivingDivision() {
		return _receivingDivision;
	}

	public void setReceivingDivision(String receivingDivision) {
		_receivingDivision = receivingDivision;
	}

	public String getReceivingDepartment() {
		return _receivingDepartment;
	}

	public void setReceivingDepartment(String receivingDepartment) {
		_receivingDepartment = receivingDepartment;
	}

	public String getNewFunctionName() {
		return _newFunctionName;
	}

	public void setNewFunctionName(String newFunctionName) {
		_newFunctionName = newFunctionName;
	}

	public String getNewCostCenter() {
		return _newCostCenter;
	}

	public void setNewCostCenter(String newCostCenter) {
		_newCostCenter = newCostCenter;
	}

	public String getNewReportingTo() {
		return _newReportingTo;
	}

	public void setNewReportingTo(String newReportingTo) {
		_newReportingTo = newReportingTo;
	}

	public Date getEffectiveDate() {
		return _effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		_effectiveDate = effectiveDate;
	}

	public String getNewOfficeSite() {
		return _newOfficeSite;
	}

	public void setNewOfficeSite(String newOfficeSite) {
		_newOfficeSite = newOfficeSite;
	}

	public String getSapPositionCode() {
		return _sapPositionCode;
	}

	public void setSapPositionCode(String sapPositionCode) {
		_sapPositionCode = sapPositionCode;
	}

	public String getReplacement() {
		return _replacement;
	}

	public void setReplacement(String replacement) {
		_replacement = replacement;
	}

	public String getFunctionGrade() {
		return _functionGrade;
	}

	public void setFunctionGrade(String functionGrade) {
		_functionGrade = functionGrade;
	}

	public int getBudgetTypeOfPosition() {
		return _budgetTypeOfPosition;
	}

	public void setBudgetTypeOfPosition(int budgetTypeOfPosition) {
		_budgetTypeOfPosition = budgetTypeOfPosition;
	}

	public int getChinaSixty() {
		return _chinaSixty;
	}

	public void setChinaSixty(int chinaSixty) {
		_chinaSixty = chinaSixty;
	}

	public int getTargetPDSupervisor() {
		return _targetPDSupervisor;
	}

	public void setTargetPDSupervisor(int targetPDSupervisor) {
		_targetPDSupervisor = targetPDSupervisor;
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

	public Date getSubmittedDate() {
		return _submittedDate;
	}

	public void setSubmittedDate(Date submittedDate) {
		_submittedDate = submittedDate;
	}

	public String getComments() {
		return _comments;
	}

	public void setComments(String comments) {
		_comments = comments;
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

	private long _eTransferId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _companyId;
	private String _ticketNo;
	private String _staffName;
	private String _currentStaffCode;
	private String _contractType;
	private String _newStaffCode;
	private int _PassedLL;
	private int _AttendedSLT;
	private String _currentCompany;
	private String _currentDivision;
	private String _currentDepartment;
	private String _currentFunctionName;
	private String _currentCostCenter;
	private String _currentReportingTo;
	private String _otherAgreementIfAny;
	private String _currentOfficeSite;
	private String _currentPositionCode;
	private String _receivingStaffCode;
	private String _receivingCompany;
	private String _receivingDivision;
	private String _receivingDepartment;
	private String _newFunctionName;
	private String _newCostCenter;
	private String _newReportingTo;
	private Date _effectiveDate;
	private String _newOfficeSite;
	private String _sapPositionCode;
	private String _replacement;
	private String _functionGrade;
	private int _budgetTypeOfPosition;
	private int _chinaSixty;
	private int _targetPDSupervisor;
	private String _processType;
	private String _subProcessType;
	private Date _submittedDate;
	private String _comments;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
}