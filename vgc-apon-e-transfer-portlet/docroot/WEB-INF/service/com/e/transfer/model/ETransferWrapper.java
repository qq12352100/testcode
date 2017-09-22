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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ETransfer}.
 * </p>
 *
 * @author EZEYIFE
 * @see ETransfer
 * @generated
 */
public class ETransferWrapper implements ETransfer, ModelWrapper<ETransfer> {
	public ETransferWrapper(ETransfer eTransfer) {
		_eTransfer = eTransfer;
	}

	@Override
	public Class<?> getModelClass() {
		return ETransfer.class;
	}

	@Override
	public String getModelClassName() {
		return ETransfer.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("eTransferId", getETransferId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("companyId", getCompanyId());
		attributes.put("ticketNo", getTicketNo());
		attributes.put("staffName", getStaffName());
		attributes.put("currentStaffCode", getCurrentStaffCode());
		attributes.put("contractType", getContractType());
		attributes.put("newStaffCode", getNewStaffCode());
		attributes.put("PassedLL", getPassedLL());
		attributes.put("AttendedSLT", getAttendedSLT());
		attributes.put("currentCompany", getCurrentCompany());
		attributes.put("currentDivision", getCurrentDivision());
		attributes.put("currentDepartment", getCurrentDepartment());
		attributes.put("currentFunctionName", getCurrentFunctionName());
		attributes.put("currentCostCenter", getCurrentCostCenter());
		attributes.put("currentReportingTo", getCurrentReportingTo());
		attributes.put("otherAgreementIfAny", getOtherAgreementIfAny());
		attributes.put("currentOfficeSite", getCurrentOfficeSite());
		attributes.put("currentPositionCode", getCurrentPositionCode());
		attributes.put("receivingStaffCode", getReceivingStaffCode());
		attributes.put("receivingCompany", getReceivingCompany());
		attributes.put("receivingDivision", getReceivingDivision());
		attributes.put("receivingDepartment", getReceivingDepartment());
		attributes.put("newFunctionName", getNewFunctionName());
		attributes.put("newCostCenter", getNewCostCenter());
		attributes.put("newReportingTo", getNewReportingTo());
		attributes.put("effectiveDate", getEffectiveDate());
		attributes.put("newOfficeSite", getNewOfficeSite());
		attributes.put("sapPositionCode", getSapPositionCode());
		attributes.put("replacement", getReplacement());
		attributes.put("functionGrade", getFunctionGrade());
		attributes.put("budgetTypeOfPosition", getBudgetTypeOfPosition());
		attributes.put("chinaSixty", getChinaSixty());
		attributes.put("targetPDSupervisor", getTargetPDSupervisor());
		attributes.put("processType", getProcessType());
		attributes.put("subProcessType", getSubProcessType());
		attributes.put("submittedDate", getSubmittedDate());
		attributes.put("comments", getComments());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long eTransferId = (Long)attributes.get("eTransferId");

		if (eTransferId != null) {
			setETransferId(eTransferId);
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

		String currentStaffCode = (String)attributes.get("currentStaffCode");

		if (currentStaffCode != null) {
			setCurrentStaffCode(currentStaffCode);
		}

		String contractType = (String)attributes.get("contractType");

		if (contractType != null) {
			setContractType(contractType);
		}

		String newStaffCode = (String)attributes.get("newStaffCode");

		if (newStaffCode != null) {
			setNewStaffCode(newStaffCode);
		}

		Integer PassedLL = (Integer)attributes.get("PassedLL");

		if (PassedLL != null) {
			setPassedLL(PassedLL);
		}

		Integer AttendedSLT = (Integer)attributes.get("AttendedSLT");

		if (AttendedSLT != null) {
			setAttendedSLT(AttendedSLT);
		}

		String currentCompany = (String)attributes.get("currentCompany");

		if (currentCompany != null) {
			setCurrentCompany(currentCompany);
		}

		String currentDivision = (String)attributes.get("currentDivision");

		if (currentDivision != null) {
			setCurrentDivision(currentDivision);
		}

		String currentDepartment = (String)attributes.get("currentDepartment");

		if (currentDepartment != null) {
			setCurrentDepartment(currentDepartment);
		}

		String currentFunctionName = (String)attributes.get(
				"currentFunctionName");

		if (currentFunctionName != null) {
			setCurrentFunctionName(currentFunctionName);
		}

		String currentCostCenter = (String)attributes.get("currentCostCenter");

		if (currentCostCenter != null) {
			setCurrentCostCenter(currentCostCenter);
		}

		String currentReportingTo = (String)attributes.get("currentReportingTo");

		if (currentReportingTo != null) {
			setCurrentReportingTo(currentReportingTo);
		}

		String otherAgreementIfAny = (String)attributes.get(
				"otherAgreementIfAny");

		if (otherAgreementIfAny != null) {
			setOtherAgreementIfAny(otherAgreementIfAny);
		}

		String currentOfficeSite = (String)attributes.get("currentOfficeSite");

		if (currentOfficeSite != null) {
			setCurrentOfficeSite(currentOfficeSite);
		}

		String currentPositionCode = (String)attributes.get(
				"currentPositionCode");

		if (currentPositionCode != null) {
			setCurrentPositionCode(currentPositionCode);
		}

		String receivingStaffCode = (String)attributes.get("receivingStaffCode");

		if (receivingStaffCode != null) {
			setReceivingStaffCode(receivingStaffCode);
		}

		String receivingCompany = (String)attributes.get("receivingCompany");

		if (receivingCompany != null) {
			setReceivingCompany(receivingCompany);
		}

		String receivingDivision = (String)attributes.get("receivingDivision");

		if (receivingDivision != null) {
			setReceivingDivision(receivingDivision);
		}

		String receivingDepartment = (String)attributes.get(
				"receivingDepartment");

		if (receivingDepartment != null) {
			setReceivingDepartment(receivingDepartment);
		}

		String newFunctionName = (String)attributes.get("newFunctionName");

		if (newFunctionName != null) {
			setNewFunctionName(newFunctionName);
		}

		String newCostCenter = (String)attributes.get("newCostCenter");

		if (newCostCenter != null) {
			setNewCostCenter(newCostCenter);
		}

		String newReportingTo = (String)attributes.get("newReportingTo");

		if (newReportingTo != null) {
			setNewReportingTo(newReportingTo);
		}

		Date effectiveDate = (Date)attributes.get("effectiveDate");

		if (effectiveDate != null) {
			setEffectiveDate(effectiveDate);
		}

		String newOfficeSite = (String)attributes.get("newOfficeSite");

		if (newOfficeSite != null) {
			setNewOfficeSite(newOfficeSite);
		}

		String sapPositionCode = (String)attributes.get("sapPositionCode");

		if (sapPositionCode != null) {
			setSapPositionCode(sapPositionCode);
		}

		String replacement = (String)attributes.get("replacement");

		if (replacement != null) {
			setReplacement(replacement);
		}

		String functionGrade = (String)attributes.get("functionGrade");

		if (functionGrade != null) {
			setFunctionGrade(functionGrade);
		}

		Integer budgetTypeOfPosition = (Integer)attributes.get(
				"budgetTypeOfPosition");

		if (budgetTypeOfPosition != null) {
			setBudgetTypeOfPosition(budgetTypeOfPosition);
		}

		Integer chinaSixty = (Integer)attributes.get("chinaSixty");

		if (chinaSixty != null) {
			setChinaSixty(chinaSixty);
		}

		Integer targetPDSupervisor = (Integer)attributes.get(
				"targetPDSupervisor");

		if (targetPDSupervisor != null) {
			setTargetPDSupervisor(targetPDSupervisor);
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
	}

	/**
	* Returns the primary key of this e transfer.
	*
	* @return the primary key of this e transfer
	*/
	@Override
	public long getPrimaryKey() {
		return _eTransfer.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e transfer.
	*
	* @param primaryKey the primary key of this e transfer
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_eTransfer.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the e transfer ID of this e transfer.
	*
	* @return the e transfer ID of this e transfer
	*/
	@Override
	public long getETransferId() {
		return _eTransfer.getETransferId();
	}

	/**
	* Sets the e transfer ID of this e transfer.
	*
	* @param eTransferId the e transfer ID of this e transfer
	*/
	@Override
	public void setETransferId(long eTransferId) {
		_eTransfer.setETransferId(eTransferId);
	}

	/**
	* Returns the group ID of this e transfer.
	*
	* @return the group ID of this e transfer
	*/
	@Override
	public long getGroupId() {
		return _eTransfer.getGroupId();
	}

	/**
	* Sets the group ID of this e transfer.
	*
	* @param groupId the group ID of this e transfer
	*/
	@Override
	public void setGroupId(long groupId) {
		_eTransfer.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this e transfer.
	*
	* @return the user ID of this e transfer
	*/
	@Override
	public long getUserId() {
		return _eTransfer.getUserId();
	}

	/**
	* Sets the user ID of this e transfer.
	*
	* @param userId the user ID of this e transfer
	*/
	@Override
	public void setUserId(long userId) {
		_eTransfer.setUserId(userId);
	}

	/**
	* Returns the user uuid of this e transfer.
	*
	* @return the user uuid of this e transfer
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eTransfer.getUserUuid();
	}

	/**
	* Sets the user uuid of this e transfer.
	*
	* @param userUuid the user uuid of this e transfer
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_eTransfer.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this e transfer.
	*
	* @return the user name of this e transfer
	*/
	@Override
	public java.lang.String getUserName() {
		return _eTransfer.getUserName();
	}

	/**
	* Sets the user name of this e transfer.
	*
	* @param userName the user name of this e transfer
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_eTransfer.setUserName(userName);
	}

	/**
	* Returns the create date of this e transfer.
	*
	* @return the create date of this e transfer
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _eTransfer.getCreateDate();
	}

	/**
	* Sets the create date of this e transfer.
	*
	* @param createDate the create date of this e transfer
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_eTransfer.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this e transfer.
	*
	* @return the modified date of this e transfer
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _eTransfer.getModifiedDate();
	}

	/**
	* Sets the modified date of this e transfer.
	*
	* @param modifiedDate the modified date of this e transfer
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_eTransfer.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the company ID of this e transfer.
	*
	* @return the company ID of this e transfer
	*/
	@Override
	public long getCompanyId() {
		return _eTransfer.getCompanyId();
	}

	/**
	* Sets the company ID of this e transfer.
	*
	* @param companyId the company ID of this e transfer
	*/
	@Override
	public void setCompanyId(long companyId) {
		_eTransfer.setCompanyId(companyId);
	}

	/**
	* Returns the ticket no of this e transfer.
	*
	* @return the ticket no of this e transfer
	*/
	@Override
	public java.lang.String getTicketNo() {
		return _eTransfer.getTicketNo();
	}

	/**
	* Sets the ticket no of this e transfer.
	*
	* @param ticketNo the ticket no of this e transfer
	*/
	@Override
	public void setTicketNo(java.lang.String ticketNo) {
		_eTransfer.setTicketNo(ticketNo);
	}

	/**
	* Returns the staff name of this e transfer.
	*
	* @return the staff name of this e transfer
	*/
	@Override
	public java.lang.String getStaffName() {
		return _eTransfer.getStaffName();
	}

	/**
	* Sets the staff name of this e transfer.
	*
	* @param staffName the staff name of this e transfer
	*/
	@Override
	public void setStaffName(java.lang.String staffName) {
		_eTransfer.setStaffName(staffName);
	}

	/**
	* Returns the current staff code of this e transfer.
	*
	* @return the current staff code of this e transfer
	*/
	@Override
	public java.lang.String getCurrentStaffCode() {
		return _eTransfer.getCurrentStaffCode();
	}

	/**
	* Sets the current staff code of this e transfer.
	*
	* @param currentStaffCode the current staff code of this e transfer
	*/
	@Override
	public void setCurrentStaffCode(java.lang.String currentStaffCode) {
		_eTransfer.setCurrentStaffCode(currentStaffCode);
	}

	/**
	* Returns the contract type of this e transfer.
	*
	* @return the contract type of this e transfer
	*/
	@Override
	public java.lang.String getContractType() {
		return _eTransfer.getContractType();
	}

	/**
	* Sets the contract type of this e transfer.
	*
	* @param contractType the contract type of this e transfer
	*/
	@Override
	public void setContractType(java.lang.String contractType) {
		_eTransfer.setContractType(contractType);
	}

	/**
	* Returns the new staff code of this e transfer.
	*
	* @return the new staff code of this e transfer
	*/
	@Override
	public java.lang.String getNewStaffCode() {
		return _eTransfer.getNewStaffCode();
	}

	/**
	* Sets the new staff code of this e transfer.
	*
	* @param newStaffCode the new staff code of this e transfer
	*/
	@Override
	public void setNewStaffCode(java.lang.String newStaffCode) {
		_eTransfer.setNewStaffCode(newStaffCode);
	}

	/**
	* Returns the passed l l of this e transfer.
	*
	* @return the passed l l of this e transfer
	*/
	@Override
	public int getPassedLL() {
		return _eTransfer.getPassedLL();
	}

	/**
	* Sets the passed l l of this e transfer.
	*
	* @param PassedLL the passed l l of this e transfer
	*/
	@Override
	public void setPassedLL(int PassedLL) {
		_eTransfer.setPassedLL(PassedLL);
	}

	/**
	* Returns the attended s l t of this e transfer.
	*
	* @return the attended s l t of this e transfer
	*/
	@Override
	public int getAttendedSLT() {
		return _eTransfer.getAttendedSLT();
	}

	/**
	* Sets the attended s l t of this e transfer.
	*
	* @param AttendedSLT the attended s l t of this e transfer
	*/
	@Override
	public void setAttendedSLT(int AttendedSLT) {
		_eTransfer.setAttendedSLT(AttendedSLT);
	}

	/**
	* Returns the current company of this e transfer.
	*
	* @return the current company of this e transfer
	*/
	@Override
	public java.lang.String getCurrentCompany() {
		return _eTransfer.getCurrentCompany();
	}

	/**
	* Sets the current company of this e transfer.
	*
	* @param currentCompany the current company of this e transfer
	*/
	@Override
	public void setCurrentCompany(java.lang.String currentCompany) {
		_eTransfer.setCurrentCompany(currentCompany);
	}

	/**
	* Returns the current division of this e transfer.
	*
	* @return the current division of this e transfer
	*/
	@Override
	public java.lang.String getCurrentDivision() {
		return _eTransfer.getCurrentDivision();
	}

	/**
	* Sets the current division of this e transfer.
	*
	* @param currentDivision the current division of this e transfer
	*/
	@Override
	public void setCurrentDivision(java.lang.String currentDivision) {
		_eTransfer.setCurrentDivision(currentDivision);
	}

	/**
	* Returns the current department of this e transfer.
	*
	* @return the current department of this e transfer
	*/
	@Override
	public java.lang.String getCurrentDepartment() {
		return _eTransfer.getCurrentDepartment();
	}

	/**
	* Sets the current department of this e transfer.
	*
	* @param currentDepartment the current department of this e transfer
	*/
	@Override
	public void setCurrentDepartment(java.lang.String currentDepartment) {
		_eTransfer.setCurrentDepartment(currentDepartment);
	}

	/**
	* Returns the current function name of this e transfer.
	*
	* @return the current function name of this e transfer
	*/
	@Override
	public java.lang.String getCurrentFunctionName() {
		return _eTransfer.getCurrentFunctionName();
	}

	/**
	* Sets the current function name of this e transfer.
	*
	* @param currentFunctionName the current function name of this e transfer
	*/
	@Override
	public void setCurrentFunctionName(java.lang.String currentFunctionName) {
		_eTransfer.setCurrentFunctionName(currentFunctionName);
	}

	/**
	* Returns the current cost center of this e transfer.
	*
	* @return the current cost center of this e transfer
	*/
	@Override
	public java.lang.String getCurrentCostCenter() {
		return _eTransfer.getCurrentCostCenter();
	}

	/**
	* Sets the current cost center of this e transfer.
	*
	* @param currentCostCenter the current cost center of this e transfer
	*/
	@Override
	public void setCurrentCostCenter(java.lang.String currentCostCenter) {
		_eTransfer.setCurrentCostCenter(currentCostCenter);
	}

	/**
	* Returns the current reporting to of this e transfer.
	*
	* @return the current reporting to of this e transfer
	*/
	@Override
	public java.lang.String getCurrentReportingTo() {
		return _eTransfer.getCurrentReportingTo();
	}

	/**
	* Sets the current reporting to of this e transfer.
	*
	* @param currentReportingTo the current reporting to of this e transfer
	*/
	@Override
	public void setCurrentReportingTo(java.lang.String currentReportingTo) {
		_eTransfer.setCurrentReportingTo(currentReportingTo);
	}

	/**
	* Returns the other agreement if any of this e transfer.
	*
	* @return the other agreement if any of this e transfer
	*/
	@Override
	public java.lang.String getOtherAgreementIfAny() {
		return _eTransfer.getOtherAgreementIfAny();
	}

	/**
	* Sets the other agreement if any of this e transfer.
	*
	* @param otherAgreementIfAny the other agreement if any of this e transfer
	*/
	@Override
	public void setOtherAgreementIfAny(java.lang.String otherAgreementIfAny) {
		_eTransfer.setOtherAgreementIfAny(otherAgreementIfAny);
	}

	/**
	* Returns the current office site of this e transfer.
	*
	* @return the current office site of this e transfer
	*/
	@Override
	public java.lang.String getCurrentOfficeSite() {
		return _eTransfer.getCurrentOfficeSite();
	}

	/**
	* Sets the current office site of this e transfer.
	*
	* @param currentOfficeSite the current office site of this e transfer
	*/
	@Override
	public void setCurrentOfficeSite(java.lang.String currentOfficeSite) {
		_eTransfer.setCurrentOfficeSite(currentOfficeSite);
	}

	/**
	* Returns the current position code of this e transfer.
	*
	* @return the current position code of this e transfer
	*/
	@Override
	public java.lang.String getCurrentPositionCode() {
		return _eTransfer.getCurrentPositionCode();
	}

	/**
	* Sets the current position code of this e transfer.
	*
	* @param currentPositionCode the current position code of this e transfer
	*/
	@Override
	public void setCurrentPositionCode(java.lang.String currentPositionCode) {
		_eTransfer.setCurrentPositionCode(currentPositionCode);
	}

	/**
	* Returns the receiving staff code of this e transfer.
	*
	* @return the receiving staff code of this e transfer
	*/
	@Override
	public java.lang.String getReceivingStaffCode() {
		return _eTransfer.getReceivingStaffCode();
	}

	/**
	* Sets the receiving staff code of this e transfer.
	*
	* @param receivingStaffCode the receiving staff code of this e transfer
	*/
	@Override
	public void setReceivingStaffCode(java.lang.String receivingStaffCode) {
		_eTransfer.setReceivingStaffCode(receivingStaffCode);
	}

	/**
	* Returns the receiving company of this e transfer.
	*
	* @return the receiving company of this e transfer
	*/
	@Override
	public java.lang.String getReceivingCompany() {
		return _eTransfer.getReceivingCompany();
	}

	/**
	* Sets the receiving company of this e transfer.
	*
	* @param receivingCompany the receiving company of this e transfer
	*/
	@Override
	public void setReceivingCompany(java.lang.String receivingCompany) {
		_eTransfer.setReceivingCompany(receivingCompany);
	}

	/**
	* Returns the receiving division of this e transfer.
	*
	* @return the receiving division of this e transfer
	*/
	@Override
	public java.lang.String getReceivingDivision() {
		return _eTransfer.getReceivingDivision();
	}

	/**
	* Sets the receiving division of this e transfer.
	*
	* @param receivingDivision the receiving division of this e transfer
	*/
	@Override
	public void setReceivingDivision(java.lang.String receivingDivision) {
		_eTransfer.setReceivingDivision(receivingDivision);
	}

	/**
	* Returns the receiving department of this e transfer.
	*
	* @return the receiving department of this e transfer
	*/
	@Override
	public java.lang.String getReceivingDepartment() {
		return _eTransfer.getReceivingDepartment();
	}

	/**
	* Sets the receiving department of this e transfer.
	*
	* @param receivingDepartment the receiving department of this e transfer
	*/
	@Override
	public void setReceivingDepartment(java.lang.String receivingDepartment) {
		_eTransfer.setReceivingDepartment(receivingDepartment);
	}

	/**
	* Returns the new function name of this e transfer.
	*
	* @return the new function name of this e transfer
	*/
	@Override
	public java.lang.String getNewFunctionName() {
		return _eTransfer.getNewFunctionName();
	}

	/**
	* Sets the new function name of this e transfer.
	*
	* @param newFunctionName the new function name of this e transfer
	*/
	@Override
	public void setNewFunctionName(java.lang.String newFunctionName) {
		_eTransfer.setNewFunctionName(newFunctionName);
	}

	/**
	* Returns the new cost center of this e transfer.
	*
	* @return the new cost center of this e transfer
	*/
	@Override
	public java.lang.String getNewCostCenter() {
		return _eTransfer.getNewCostCenter();
	}

	/**
	* Sets the new cost center of this e transfer.
	*
	* @param newCostCenter the new cost center of this e transfer
	*/
	@Override
	public void setNewCostCenter(java.lang.String newCostCenter) {
		_eTransfer.setNewCostCenter(newCostCenter);
	}

	/**
	* Returns the new reporting to of this e transfer.
	*
	* @return the new reporting to of this e transfer
	*/
	@Override
	public java.lang.String getNewReportingTo() {
		return _eTransfer.getNewReportingTo();
	}

	/**
	* Sets the new reporting to of this e transfer.
	*
	* @param newReportingTo the new reporting to of this e transfer
	*/
	@Override
	public void setNewReportingTo(java.lang.String newReportingTo) {
		_eTransfer.setNewReportingTo(newReportingTo);
	}

	/**
	* Returns the effective date of this e transfer.
	*
	* @return the effective date of this e transfer
	*/
	@Override
	public java.util.Date getEffectiveDate() {
		return _eTransfer.getEffectiveDate();
	}

	/**
	* Sets the effective date of this e transfer.
	*
	* @param effectiveDate the effective date of this e transfer
	*/
	@Override
	public void setEffectiveDate(java.util.Date effectiveDate) {
		_eTransfer.setEffectiveDate(effectiveDate);
	}

	/**
	* Returns the new office site of this e transfer.
	*
	* @return the new office site of this e transfer
	*/
	@Override
	public java.lang.String getNewOfficeSite() {
		return _eTransfer.getNewOfficeSite();
	}

	/**
	* Sets the new office site of this e transfer.
	*
	* @param newOfficeSite the new office site of this e transfer
	*/
	@Override
	public void setNewOfficeSite(java.lang.String newOfficeSite) {
		_eTransfer.setNewOfficeSite(newOfficeSite);
	}

	/**
	* Returns the sap position code of this e transfer.
	*
	* @return the sap position code of this e transfer
	*/
	@Override
	public java.lang.String getSapPositionCode() {
		return _eTransfer.getSapPositionCode();
	}

	/**
	* Sets the sap position code of this e transfer.
	*
	* @param sapPositionCode the sap position code of this e transfer
	*/
	@Override
	public void setSapPositionCode(java.lang.String sapPositionCode) {
		_eTransfer.setSapPositionCode(sapPositionCode);
	}

	/**
	* Returns the replacement of this e transfer.
	*
	* @return the replacement of this e transfer
	*/
	@Override
	public java.lang.String getReplacement() {
		return _eTransfer.getReplacement();
	}

	/**
	* Sets the replacement of this e transfer.
	*
	* @param replacement the replacement of this e transfer
	*/
	@Override
	public void setReplacement(java.lang.String replacement) {
		_eTransfer.setReplacement(replacement);
	}

	/**
	* Returns the function grade of this e transfer.
	*
	* @return the function grade of this e transfer
	*/
	@Override
	public java.lang.String getFunctionGrade() {
		return _eTransfer.getFunctionGrade();
	}

	/**
	* Sets the function grade of this e transfer.
	*
	* @param functionGrade the function grade of this e transfer
	*/
	@Override
	public void setFunctionGrade(java.lang.String functionGrade) {
		_eTransfer.setFunctionGrade(functionGrade);
	}

	/**
	* Returns the budget type of position of this e transfer.
	*
	* @return the budget type of position of this e transfer
	*/
	@Override
	public int getBudgetTypeOfPosition() {
		return _eTransfer.getBudgetTypeOfPosition();
	}

	/**
	* Sets the budget type of position of this e transfer.
	*
	* @param budgetTypeOfPosition the budget type of position of this e transfer
	*/
	@Override
	public void setBudgetTypeOfPosition(int budgetTypeOfPosition) {
		_eTransfer.setBudgetTypeOfPosition(budgetTypeOfPosition);
	}

	/**
	* Returns the china sixty of this e transfer.
	*
	* @return the china sixty of this e transfer
	*/
	@Override
	public int getChinaSixty() {
		return _eTransfer.getChinaSixty();
	}

	/**
	* Sets the china sixty of this e transfer.
	*
	* @param chinaSixty the china sixty of this e transfer
	*/
	@Override
	public void setChinaSixty(int chinaSixty) {
		_eTransfer.setChinaSixty(chinaSixty);
	}

	/**
	* Returns the target p d supervisor of this e transfer.
	*
	* @return the target p d supervisor of this e transfer
	*/
	@Override
	public int getTargetPDSupervisor() {
		return _eTransfer.getTargetPDSupervisor();
	}

	/**
	* Sets the target p d supervisor of this e transfer.
	*
	* @param targetPDSupervisor the target p d supervisor of this e transfer
	*/
	@Override
	public void setTargetPDSupervisor(int targetPDSupervisor) {
		_eTransfer.setTargetPDSupervisor(targetPDSupervisor);
	}

	/**
	* Returns the process type of this e transfer.
	*
	* @return the process type of this e transfer
	*/
	@Override
	public java.lang.String getProcessType() {
		return _eTransfer.getProcessType();
	}

	/**
	* Sets the process type of this e transfer.
	*
	* @param processType the process type of this e transfer
	*/
	@Override
	public void setProcessType(java.lang.String processType) {
		_eTransfer.setProcessType(processType);
	}

	/**
	* Returns the sub process type of this e transfer.
	*
	* @return the sub process type of this e transfer
	*/
	@Override
	public java.lang.String getSubProcessType() {
		return _eTransfer.getSubProcessType();
	}

	/**
	* Sets the sub process type of this e transfer.
	*
	* @param subProcessType the sub process type of this e transfer
	*/
	@Override
	public void setSubProcessType(java.lang.String subProcessType) {
		_eTransfer.setSubProcessType(subProcessType);
	}

	/**
	* Returns the submitted date of this e transfer.
	*
	* @return the submitted date of this e transfer
	*/
	@Override
	public java.util.Date getSubmittedDate() {
		return _eTransfer.getSubmittedDate();
	}

	/**
	* Sets the submitted date of this e transfer.
	*
	* @param submittedDate the submitted date of this e transfer
	*/
	@Override
	public void setSubmittedDate(java.util.Date submittedDate) {
		_eTransfer.setSubmittedDate(submittedDate);
	}

	/**
	* Returns the comments of this e transfer.
	*
	* @return the comments of this e transfer
	*/
	@Override
	public java.lang.String getComments() {
		return _eTransfer.getComments();
	}

	/**
	* Sets the comments of this e transfer.
	*
	* @param comments the comments of this e transfer
	*/
	@Override
	public void setComments(java.lang.String comments) {
		_eTransfer.setComments(comments);
	}

	/**
	* Returns the status of this e transfer.
	*
	* @return the status of this e transfer
	*/
	@Override
	public int getStatus() {
		return _eTransfer.getStatus();
	}

	/**
	* Sets the status of this e transfer.
	*
	* @param status the status of this e transfer
	*/
	@Override
	public void setStatus(int status) {
		_eTransfer.setStatus(status);
	}

	/**
	* Returns the status by user ID of this e transfer.
	*
	* @return the status by user ID of this e transfer
	*/
	@Override
	public long getStatusByUserId() {
		return _eTransfer.getStatusByUserId();
	}

	/**
	* Sets the status by user ID of this e transfer.
	*
	* @param statusByUserId the status by user ID of this e transfer
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_eTransfer.setStatusByUserId(statusByUserId);
	}

	/**
	* Returns the status by user uuid of this e transfer.
	*
	* @return the status by user uuid of this e transfer
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getStatusByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eTransfer.getStatusByUserUuid();
	}

	/**
	* Sets the status by user uuid of this e transfer.
	*
	* @param statusByUserUuid the status by user uuid of this e transfer
	*/
	@Override
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_eTransfer.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Returns the status by user name of this e transfer.
	*
	* @return the status by user name of this e transfer
	*/
	@Override
	public java.lang.String getStatusByUserName() {
		return _eTransfer.getStatusByUserName();
	}

	/**
	* Sets the status by user name of this e transfer.
	*
	* @param statusByUserName the status by user name of this e transfer
	*/
	@Override
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_eTransfer.setStatusByUserName(statusByUserName);
	}

	/**
	* Returns the status date of this e transfer.
	*
	* @return the status date of this e transfer
	*/
	@Override
	public java.util.Date getStatusDate() {
		return _eTransfer.getStatusDate();
	}

	/**
	* Sets the status date of this e transfer.
	*
	* @param statusDate the status date of this e transfer
	*/
	@Override
	public void setStatusDate(java.util.Date statusDate) {
		_eTransfer.setStatusDate(statusDate);
	}

	/**
	* @deprecated As of 6.1.0, replaced by {@link #isApproved()}
	*/
	@Override
	public boolean getApproved() {
		return _eTransfer.getApproved();
	}

	/**
	* Returns <code>true</code> if this e transfer is approved.
	*
	* @return <code>true</code> if this e transfer is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _eTransfer.isApproved();
	}

	/**
	* Returns <code>true</code> if this e transfer is denied.
	*
	* @return <code>true</code> if this e transfer is denied; <code>false</code> otherwise
	*/
	@Override
	public boolean isDenied() {
		return _eTransfer.isDenied();
	}

	/**
	* Returns <code>true</code> if this e transfer is a draft.
	*
	* @return <code>true</code> if this e transfer is a draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _eTransfer.isDraft();
	}

	/**
	* Returns <code>true</code> if this e transfer is expired.
	*
	* @return <code>true</code> if this e transfer is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _eTransfer.isExpired();
	}

	/**
	* Returns <code>true</code> if this e transfer is inactive.
	*
	* @return <code>true</code> if this e transfer is inactive; <code>false</code> otherwise
	*/
	@Override
	public boolean isInactive() {
		return _eTransfer.isInactive();
	}

	/**
	* Returns <code>true</code> if this e transfer is incomplete.
	*
	* @return <code>true</code> if this e transfer is incomplete; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncomplete() {
		return _eTransfer.isIncomplete();
	}

	/**
	* Returns <code>true</code> if this e transfer is pending.
	*
	* @return <code>true</code> if this e transfer is pending; <code>false</code> otherwise
	*/
	@Override
	public boolean isPending() {
		return _eTransfer.isPending();
	}

	/**
	* Returns <code>true</code> if this e transfer is scheduled.
	*
	* @return <code>true</code> if this e transfer is scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isScheduled() {
		return _eTransfer.isScheduled();
	}

	@Override
	public boolean isNew() {
		return _eTransfer.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_eTransfer.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _eTransfer.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_eTransfer.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _eTransfer.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _eTransfer.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_eTransfer.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _eTransfer.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_eTransfer.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_eTransfer.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_eTransfer.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ETransferWrapper((ETransfer)_eTransfer.clone());
	}

	@Override
	public int compareTo(com.e.transfer.model.ETransfer eTransfer) {
		return _eTransfer.compareTo(eTransfer);
	}

	@Override
	public int hashCode() {
		return _eTransfer.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.e.transfer.model.ETransfer> toCacheModel() {
		return _eTransfer.toCacheModel();
	}

	@Override
	public com.e.transfer.model.ETransfer toEscapedModel() {
		return new ETransferWrapper(_eTransfer.toEscapedModel());
	}

	@Override
	public com.e.transfer.model.ETransfer toUnescapedModel() {
		return new ETransferWrapper(_eTransfer.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _eTransfer.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _eTransfer.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_eTransfer.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ETransferWrapper)) {
			return false;
		}

		ETransferWrapper eTransferWrapper = (ETransferWrapper)obj;

		if (Validator.equals(_eTransfer, eTransferWrapper._eTransfer)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ETransfer getWrappedETransfer() {
		return _eTransfer;
	}

	@Override
	public ETransfer getWrappedModel() {
		return _eTransfer;
	}

	@Override
	public void resetOriginalValues() {
		_eTransfer.resetOriginalValues();
	}

	private ETransfer _eTransfer;
}