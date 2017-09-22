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

import com.e.transfer.service.ClpSerializer;
import com.e.transfer.service.ETransferLocalServiceUtil;

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
public class ETransferClp extends BaseModelImpl<ETransfer> implements ETransfer {
	public ETransferClp() {
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
	public long getPrimaryKey() {
		return _eTransferId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setETransferId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _eTransferId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getETransferId() {
		return _eTransferId;
	}

	@Override
	public void setETransferId(long eTransferId) {
		_eTransferId = eTransferId;

		if (_eTransferRemoteModel != null) {
			try {
				Class<?> clazz = _eTransferRemoteModel.getClass();

				Method method = clazz.getMethod("setETransferId", long.class);

				method.invoke(_eTransferRemoteModel, eTransferId);
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

		if (_eTransferRemoteModel != null) {
			try {
				Class<?> clazz = _eTransferRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_eTransferRemoteModel, groupId);
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

		if (_eTransferRemoteModel != null) {
			try {
				Class<?> clazz = _eTransferRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_eTransferRemoteModel, userId);
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

		if (_eTransferRemoteModel != null) {
			try {
				Class<?> clazz = _eTransferRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_eTransferRemoteModel, userName);
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

		if (_eTransferRemoteModel != null) {
			try {
				Class<?> clazz = _eTransferRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_eTransferRemoteModel, createDate);
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

		if (_eTransferRemoteModel != null) {
			try {
				Class<?> clazz = _eTransferRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_eTransferRemoteModel, modifiedDate);
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

		if (_eTransferRemoteModel != null) {
			try {
				Class<?> clazz = _eTransferRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_eTransferRemoteModel, companyId);
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

		if (_eTransferRemoteModel != null) {
			try {
				Class<?> clazz = _eTransferRemoteModel.getClass();

				Method method = clazz.getMethod("setTicketNo", String.class);

				method.invoke(_eTransferRemoteModel, ticketNo);
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

		if (_eTransferRemoteModel != null) {
			try {
				Class<?> clazz = _eTransferRemoteModel.getClass();

				Method method = clazz.getMethod("setStaffName", String.class);

				method.invoke(_eTransferRemoteModel, staffName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCurrentStaffCode() {
		return _currentStaffCode;
	}

	@Override
	public void setCurrentStaffCode(String currentStaffCode) {
		_currentStaffCode = currentStaffCode;

		if (_eTransferRemoteModel != null) {
			try {
				Class<?> clazz = _eTransferRemoteModel.getClass();

				Method method = clazz.getMethod("setCurrentStaffCode",
						String.class);

				method.invoke(_eTransferRemoteModel, currentStaffCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContractType() {
		return _contractType;
	}

	@Override
	public void setContractType(String contractType) {
		_contractType = contractType;

		if (_eTransferRemoteModel != null) {
			try {
				Class<?> clazz = _eTransferRemoteModel.getClass();

				Method method = clazz.getMethod("setContractType", String.class);

				method.invoke(_eTransferRemoteModel, contractType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNewStaffCode() {
		return _newStaffCode;
	}

	@Override
	public void setNewStaffCode(String newStaffCode) {
		_newStaffCode = newStaffCode;

		if (_eTransferRemoteModel != null) {
			try {
				Class<?> clazz = _eTransferRemoteModel.getClass();

				Method method = clazz.getMethod("setNewStaffCode", String.class);

				method.invoke(_eTransferRemoteModel, newStaffCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getPassedLL() {
		return _PassedLL;
	}

	@Override
	public void setPassedLL(int PassedLL) {
		_PassedLL = PassedLL;

		if (_eTransferRemoteModel != null) {
			try {
				Class<?> clazz = _eTransferRemoteModel.getClass();

				Method method = clazz.getMethod("setPassedLL", int.class);

				method.invoke(_eTransferRemoteModel, PassedLL);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getAttendedSLT() {
		return _AttendedSLT;
	}

	@Override
	public void setAttendedSLT(int AttendedSLT) {
		_AttendedSLT = AttendedSLT;

		if (_eTransferRemoteModel != null) {
			try {
				Class<?> clazz = _eTransferRemoteModel.getClass();

				Method method = clazz.getMethod("setAttendedSLT", int.class);

				method.invoke(_eTransferRemoteModel, AttendedSLT);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCurrentCompany() {
		return _currentCompany;
	}

	@Override
	public void setCurrentCompany(String currentCompany) {
		_currentCompany = currentCompany;

		if (_eTransferRemoteModel != null) {
			try {
				Class<?> clazz = _eTransferRemoteModel.getClass();

				Method method = clazz.getMethod("setCurrentCompany",
						String.class);

				method.invoke(_eTransferRemoteModel, currentCompany);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCurrentDivision() {
		return _currentDivision;
	}

	@Override
	public void setCurrentDivision(String currentDivision) {
		_currentDivision = currentDivision;

		if (_eTransferRemoteModel != null) {
			try {
				Class<?> clazz = _eTransferRemoteModel.getClass();

				Method method = clazz.getMethod("setCurrentDivision",
						String.class);

				method.invoke(_eTransferRemoteModel, currentDivision);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCurrentDepartment() {
		return _currentDepartment;
	}

	@Override
	public void setCurrentDepartment(String currentDepartment) {
		_currentDepartment = currentDepartment;

		if (_eTransferRemoteModel != null) {
			try {
				Class<?> clazz = _eTransferRemoteModel.getClass();

				Method method = clazz.getMethod("setCurrentDepartment",
						String.class);

				method.invoke(_eTransferRemoteModel, currentDepartment);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCurrentFunctionName() {
		return _currentFunctionName;
	}

	@Override
	public void setCurrentFunctionName(String currentFunctionName) {
		_currentFunctionName = currentFunctionName;

		if (_eTransferRemoteModel != null) {
			try {
				Class<?> clazz = _eTransferRemoteModel.getClass();

				Method method = clazz.getMethod("setCurrentFunctionName",
						String.class);

				method.invoke(_eTransferRemoteModel, currentFunctionName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCurrentCostCenter() {
		return _currentCostCenter;
	}

	@Override
	public void setCurrentCostCenter(String currentCostCenter) {
		_currentCostCenter = currentCostCenter;

		if (_eTransferRemoteModel != null) {
			try {
				Class<?> clazz = _eTransferRemoteModel.getClass();

				Method method = clazz.getMethod("setCurrentCostCenter",
						String.class);

				method.invoke(_eTransferRemoteModel, currentCostCenter);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCurrentReportingTo() {
		return _currentReportingTo;
	}

	@Override
	public void setCurrentReportingTo(String currentReportingTo) {
		_currentReportingTo = currentReportingTo;

		if (_eTransferRemoteModel != null) {
			try {
				Class<?> clazz = _eTransferRemoteModel.getClass();

				Method method = clazz.getMethod("setCurrentReportingTo",
						String.class);

				method.invoke(_eTransferRemoteModel, currentReportingTo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOtherAgreementIfAny() {
		return _otherAgreementIfAny;
	}

	@Override
	public void setOtherAgreementIfAny(String otherAgreementIfAny) {
		_otherAgreementIfAny = otherAgreementIfAny;

		if (_eTransferRemoteModel != null) {
			try {
				Class<?> clazz = _eTransferRemoteModel.getClass();

				Method method = clazz.getMethod("setOtherAgreementIfAny",
						String.class);

				method.invoke(_eTransferRemoteModel, otherAgreementIfAny);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCurrentOfficeSite() {
		return _currentOfficeSite;
	}

	@Override
	public void setCurrentOfficeSite(String currentOfficeSite) {
		_currentOfficeSite = currentOfficeSite;

		if (_eTransferRemoteModel != null) {
			try {
				Class<?> clazz = _eTransferRemoteModel.getClass();

				Method method = clazz.getMethod("setCurrentOfficeSite",
						String.class);

				method.invoke(_eTransferRemoteModel, currentOfficeSite);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCurrentPositionCode() {
		return _currentPositionCode;
	}

	@Override
	public void setCurrentPositionCode(String currentPositionCode) {
		_currentPositionCode = currentPositionCode;

		if (_eTransferRemoteModel != null) {
			try {
				Class<?> clazz = _eTransferRemoteModel.getClass();

				Method method = clazz.getMethod("setCurrentPositionCode",
						String.class);

				method.invoke(_eTransferRemoteModel, currentPositionCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getReceivingStaffCode() {
		return _receivingStaffCode;
	}

	@Override
	public void setReceivingStaffCode(String receivingStaffCode) {
		_receivingStaffCode = receivingStaffCode;

		if (_eTransferRemoteModel != null) {
			try {
				Class<?> clazz = _eTransferRemoteModel.getClass();

				Method method = clazz.getMethod("setReceivingStaffCode",
						String.class);

				method.invoke(_eTransferRemoteModel, receivingStaffCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getReceivingCompany() {
		return _receivingCompany;
	}

	@Override
	public void setReceivingCompany(String receivingCompany) {
		_receivingCompany = receivingCompany;

		if (_eTransferRemoteModel != null) {
			try {
				Class<?> clazz = _eTransferRemoteModel.getClass();

				Method method = clazz.getMethod("setReceivingCompany",
						String.class);

				method.invoke(_eTransferRemoteModel, receivingCompany);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getReceivingDivision() {
		return _receivingDivision;
	}

	@Override
	public void setReceivingDivision(String receivingDivision) {
		_receivingDivision = receivingDivision;

		if (_eTransferRemoteModel != null) {
			try {
				Class<?> clazz = _eTransferRemoteModel.getClass();

				Method method = clazz.getMethod("setReceivingDivision",
						String.class);

				method.invoke(_eTransferRemoteModel, receivingDivision);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getReceivingDepartment() {
		return _receivingDepartment;
	}

	@Override
	public void setReceivingDepartment(String receivingDepartment) {
		_receivingDepartment = receivingDepartment;

		if (_eTransferRemoteModel != null) {
			try {
				Class<?> clazz = _eTransferRemoteModel.getClass();

				Method method = clazz.getMethod("setReceivingDepartment",
						String.class);

				method.invoke(_eTransferRemoteModel, receivingDepartment);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNewFunctionName() {
		return _newFunctionName;
	}

	@Override
	public void setNewFunctionName(String newFunctionName) {
		_newFunctionName = newFunctionName;

		if (_eTransferRemoteModel != null) {
			try {
				Class<?> clazz = _eTransferRemoteModel.getClass();

				Method method = clazz.getMethod("setNewFunctionName",
						String.class);

				method.invoke(_eTransferRemoteModel, newFunctionName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNewCostCenter() {
		return _newCostCenter;
	}

	@Override
	public void setNewCostCenter(String newCostCenter) {
		_newCostCenter = newCostCenter;

		if (_eTransferRemoteModel != null) {
			try {
				Class<?> clazz = _eTransferRemoteModel.getClass();

				Method method = clazz.getMethod("setNewCostCenter", String.class);

				method.invoke(_eTransferRemoteModel, newCostCenter);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNewReportingTo() {
		return _newReportingTo;
	}

	@Override
	public void setNewReportingTo(String newReportingTo) {
		_newReportingTo = newReportingTo;

		if (_eTransferRemoteModel != null) {
			try {
				Class<?> clazz = _eTransferRemoteModel.getClass();

				Method method = clazz.getMethod("setNewReportingTo",
						String.class);

				method.invoke(_eTransferRemoteModel, newReportingTo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEffectiveDate() {
		return _effectiveDate;
	}

	@Override
	public void setEffectiveDate(Date effectiveDate) {
		_effectiveDate = effectiveDate;

		if (_eTransferRemoteModel != null) {
			try {
				Class<?> clazz = _eTransferRemoteModel.getClass();

				Method method = clazz.getMethod("setEffectiveDate", Date.class);

				method.invoke(_eTransferRemoteModel, effectiveDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNewOfficeSite() {
		return _newOfficeSite;
	}

	@Override
	public void setNewOfficeSite(String newOfficeSite) {
		_newOfficeSite = newOfficeSite;

		if (_eTransferRemoteModel != null) {
			try {
				Class<?> clazz = _eTransferRemoteModel.getClass();

				Method method = clazz.getMethod("setNewOfficeSite", String.class);

				method.invoke(_eTransferRemoteModel, newOfficeSite);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSapPositionCode() {
		return _sapPositionCode;
	}

	@Override
	public void setSapPositionCode(String sapPositionCode) {
		_sapPositionCode = sapPositionCode;

		if (_eTransferRemoteModel != null) {
			try {
				Class<?> clazz = _eTransferRemoteModel.getClass();

				Method method = clazz.getMethod("setSapPositionCode",
						String.class);

				method.invoke(_eTransferRemoteModel, sapPositionCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getReplacement() {
		return _replacement;
	}

	@Override
	public void setReplacement(String replacement) {
		_replacement = replacement;

		if (_eTransferRemoteModel != null) {
			try {
				Class<?> clazz = _eTransferRemoteModel.getClass();

				Method method = clazz.getMethod("setReplacement", String.class);

				method.invoke(_eTransferRemoteModel, replacement);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFunctionGrade() {
		return _functionGrade;
	}

	@Override
	public void setFunctionGrade(String functionGrade) {
		_functionGrade = functionGrade;

		if (_eTransferRemoteModel != null) {
			try {
				Class<?> clazz = _eTransferRemoteModel.getClass();

				Method method = clazz.getMethod("setFunctionGrade", String.class);

				method.invoke(_eTransferRemoteModel, functionGrade);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getBudgetTypeOfPosition() {
		return _budgetTypeOfPosition;
	}

	@Override
	public void setBudgetTypeOfPosition(int budgetTypeOfPosition) {
		_budgetTypeOfPosition = budgetTypeOfPosition;

		if (_eTransferRemoteModel != null) {
			try {
				Class<?> clazz = _eTransferRemoteModel.getClass();

				Method method = clazz.getMethod("setBudgetTypeOfPosition",
						int.class);

				method.invoke(_eTransferRemoteModel, budgetTypeOfPosition);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getChinaSixty() {
		return _chinaSixty;
	}

	@Override
	public void setChinaSixty(int chinaSixty) {
		_chinaSixty = chinaSixty;

		if (_eTransferRemoteModel != null) {
			try {
				Class<?> clazz = _eTransferRemoteModel.getClass();

				Method method = clazz.getMethod("setChinaSixty", int.class);

				method.invoke(_eTransferRemoteModel, chinaSixty);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getTargetPDSupervisor() {
		return _targetPDSupervisor;
	}

	@Override
	public void setTargetPDSupervisor(int targetPDSupervisor) {
		_targetPDSupervisor = targetPDSupervisor;

		if (_eTransferRemoteModel != null) {
			try {
				Class<?> clazz = _eTransferRemoteModel.getClass();

				Method method = clazz.getMethod("setTargetPDSupervisor",
						int.class);

				method.invoke(_eTransferRemoteModel, targetPDSupervisor);
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

		if (_eTransferRemoteModel != null) {
			try {
				Class<?> clazz = _eTransferRemoteModel.getClass();

				Method method = clazz.getMethod("setProcessType", String.class);

				method.invoke(_eTransferRemoteModel, processType);
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

		if (_eTransferRemoteModel != null) {
			try {
				Class<?> clazz = _eTransferRemoteModel.getClass();

				Method method = clazz.getMethod("setSubProcessType",
						String.class);

				method.invoke(_eTransferRemoteModel, subProcessType);
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

		if (_eTransferRemoteModel != null) {
			try {
				Class<?> clazz = _eTransferRemoteModel.getClass();

				Method method = clazz.getMethod("setSubmittedDate", Date.class);

				method.invoke(_eTransferRemoteModel, submittedDate);
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

		if (_eTransferRemoteModel != null) {
			try {
				Class<?> clazz = _eTransferRemoteModel.getClass();

				Method method = clazz.getMethod("setComments", String.class);

				method.invoke(_eTransferRemoteModel, comments);
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

		if (_eTransferRemoteModel != null) {
			try {
				Class<?> clazz = _eTransferRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_eTransferRemoteModel, status);
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

		if (_eTransferRemoteModel != null) {
			try {
				Class<?> clazz = _eTransferRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusByUserId", long.class);

				method.invoke(_eTransferRemoteModel, statusByUserId);
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

		if (_eTransferRemoteModel != null) {
			try {
				Class<?> clazz = _eTransferRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusByUserName",
						String.class);

				method.invoke(_eTransferRemoteModel, statusByUserName);
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

		if (_eTransferRemoteModel != null) {
			try {
				Class<?> clazz = _eTransferRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusDate", Date.class);

				method.invoke(_eTransferRemoteModel, statusDate);
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

	public BaseModel<?> getETransferRemoteModel() {
		return _eTransferRemoteModel;
	}

	public void setETransferRemoteModel(BaseModel<?> eTransferRemoteModel) {
		_eTransferRemoteModel = eTransferRemoteModel;
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

		Class<?> remoteModelClass = _eTransferRemoteModel.getClass();

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

		Object returnValue = method.invoke(_eTransferRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ETransferLocalServiceUtil.addETransfer(this);
		}
		else {
			ETransferLocalServiceUtil.updateETransfer(this);
		}
	}

	@Override
	public ETransfer toEscapedModel() {
		return (ETransfer)ProxyUtil.newProxyInstance(ETransfer.class.getClassLoader(),
			new Class[] { ETransfer.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ETransferClp clone = new ETransferClp();

		clone.setETransferId(getETransferId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setCompanyId(getCompanyId());
		clone.setTicketNo(getTicketNo());
		clone.setStaffName(getStaffName());
		clone.setCurrentStaffCode(getCurrentStaffCode());
		clone.setContractType(getContractType());
		clone.setNewStaffCode(getNewStaffCode());
		clone.setPassedLL(getPassedLL());
		clone.setAttendedSLT(getAttendedSLT());
		clone.setCurrentCompany(getCurrentCompany());
		clone.setCurrentDivision(getCurrentDivision());
		clone.setCurrentDepartment(getCurrentDepartment());
		clone.setCurrentFunctionName(getCurrentFunctionName());
		clone.setCurrentCostCenter(getCurrentCostCenter());
		clone.setCurrentReportingTo(getCurrentReportingTo());
		clone.setOtherAgreementIfAny(getOtherAgreementIfAny());
		clone.setCurrentOfficeSite(getCurrentOfficeSite());
		clone.setCurrentPositionCode(getCurrentPositionCode());
		clone.setReceivingStaffCode(getReceivingStaffCode());
		clone.setReceivingCompany(getReceivingCompany());
		clone.setReceivingDivision(getReceivingDivision());
		clone.setReceivingDepartment(getReceivingDepartment());
		clone.setNewFunctionName(getNewFunctionName());
		clone.setNewCostCenter(getNewCostCenter());
		clone.setNewReportingTo(getNewReportingTo());
		clone.setEffectiveDate(getEffectiveDate());
		clone.setNewOfficeSite(getNewOfficeSite());
		clone.setSapPositionCode(getSapPositionCode());
		clone.setReplacement(getReplacement());
		clone.setFunctionGrade(getFunctionGrade());
		clone.setBudgetTypeOfPosition(getBudgetTypeOfPosition());
		clone.setChinaSixty(getChinaSixty());
		clone.setTargetPDSupervisor(getTargetPDSupervisor());
		clone.setProcessType(getProcessType());
		clone.setSubProcessType(getSubProcessType());
		clone.setSubmittedDate(getSubmittedDate());
		clone.setComments(getComments());
		clone.setStatus(getStatus());
		clone.setStatusByUserId(getStatusByUserId());
		clone.setStatusByUserName(getStatusByUserName());
		clone.setStatusDate(getStatusDate());

		return clone;
	}

	@Override
	public int compareTo(ETransfer eTransfer) {
		int value = 0;

		if (getETransferId() < eTransfer.getETransferId()) {
			value = -1;
		}
		else if (getETransferId() > eTransfer.getETransferId()) {
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

		if (!(obj instanceof ETransferClp)) {
			return false;
		}

		ETransferClp eTransfer = (ETransferClp)obj;

		long primaryKey = eTransfer.getPrimaryKey();

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
		StringBundler sb = new StringBundler(93);

		sb.append("{eTransferId=");
		sb.append(getETransferId());
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
		sb.append(", currentStaffCode=");
		sb.append(getCurrentStaffCode());
		sb.append(", contractType=");
		sb.append(getContractType());
		sb.append(", newStaffCode=");
		sb.append(getNewStaffCode());
		sb.append(", PassedLL=");
		sb.append(getPassedLL());
		sb.append(", AttendedSLT=");
		sb.append(getAttendedSLT());
		sb.append(", currentCompany=");
		sb.append(getCurrentCompany());
		sb.append(", currentDivision=");
		sb.append(getCurrentDivision());
		sb.append(", currentDepartment=");
		sb.append(getCurrentDepartment());
		sb.append(", currentFunctionName=");
		sb.append(getCurrentFunctionName());
		sb.append(", currentCostCenter=");
		sb.append(getCurrentCostCenter());
		sb.append(", currentReportingTo=");
		sb.append(getCurrentReportingTo());
		sb.append(", otherAgreementIfAny=");
		sb.append(getOtherAgreementIfAny());
		sb.append(", currentOfficeSite=");
		sb.append(getCurrentOfficeSite());
		sb.append(", currentPositionCode=");
		sb.append(getCurrentPositionCode());
		sb.append(", receivingStaffCode=");
		sb.append(getReceivingStaffCode());
		sb.append(", receivingCompany=");
		sb.append(getReceivingCompany());
		sb.append(", receivingDivision=");
		sb.append(getReceivingDivision());
		sb.append(", receivingDepartment=");
		sb.append(getReceivingDepartment());
		sb.append(", newFunctionName=");
		sb.append(getNewFunctionName());
		sb.append(", newCostCenter=");
		sb.append(getNewCostCenter());
		sb.append(", newReportingTo=");
		sb.append(getNewReportingTo());
		sb.append(", effectiveDate=");
		sb.append(getEffectiveDate());
		sb.append(", newOfficeSite=");
		sb.append(getNewOfficeSite());
		sb.append(", sapPositionCode=");
		sb.append(getSapPositionCode());
		sb.append(", replacement=");
		sb.append(getReplacement());
		sb.append(", functionGrade=");
		sb.append(getFunctionGrade());
		sb.append(", budgetTypeOfPosition=");
		sb.append(getBudgetTypeOfPosition());
		sb.append(", chinaSixty=");
		sb.append(getChinaSixty());
		sb.append(", targetPDSupervisor=");
		sb.append(getTargetPDSupervisor());
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(142);

		sb.append("<model><model-name>");
		sb.append("com.e.transfer.model.ETransfer");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>eTransferId</column-name><column-value><![CDATA[");
		sb.append(getETransferId());
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
			"<column><column-name>currentStaffCode</column-name><column-value><![CDATA[");
		sb.append(getCurrentStaffCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contractType</column-name><column-value><![CDATA[");
		sb.append(getContractType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>newStaffCode</column-name><column-value><![CDATA[");
		sb.append(getNewStaffCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>PassedLL</column-name><column-value><![CDATA[");
		sb.append(getPassedLL());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>AttendedSLT</column-name><column-value><![CDATA[");
		sb.append(getAttendedSLT());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currentCompany</column-name><column-value><![CDATA[");
		sb.append(getCurrentCompany());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currentDivision</column-name><column-value><![CDATA[");
		sb.append(getCurrentDivision());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currentDepartment</column-name><column-value><![CDATA[");
		sb.append(getCurrentDepartment());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currentFunctionName</column-name><column-value><![CDATA[");
		sb.append(getCurrentFunctionName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currentCostCenter</column-name><column-value><![CDATA[");
		sb.append(getCurrentCostCenter());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currentReportingTo</column-name><column-value><![CDATA[");
		sb.append(getCurrentReportingTo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>otherAgreementIfAny</column-name><column-value><![CDATA[");
		sb.append(getOtherAgreementIfAny());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currentOfficeSite</column-name><column-value><![CDATA[");
		sb.append(getCurrentOfficeSite());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currentPositionCode</column-name><column-value><![CDATA[");
		sb.append(getCurrentPositionCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>receivingStaffCode</column-name><column-value><![CDATA[");
		sb.append(getReceivingStaffCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>receivingCompany</column-name><column-value><![CDATA[");
		sb.append(getReceivingCompany());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>receivingDivision</column-name><column-value><![CDATA[");
		sb.append(getReceivingDivision());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>receivingDepartment</column-name><column-value><![CDATA[");
		sb.append(getReceivingDepartment());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>newFunctionName</column-name><column-value><![CDATA[");
		sb.append(getNewFunctionName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>newCostCenter</column-name><column-value><![CDATA[");
		sb.append(getNewCostCenter());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>newReportingTo</column-name><column-value><![CDATA[");
		sb.append(getNewReportingTo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>effectiveDate</column-name><column-value><![CDATA[");
		sb.append(getEffectiveDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>newOfficeSite</column-name><column-value><![CDATA[");
		sb.append(getNewOfficeSite());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sapPositionCode</column-name><column-value><![CDATA[");
		sb.append(getSapPositionCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>replacement</column-name><column-value><![CDATA[");
		sb.append(getReplacement());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>functionGrade</column-name><column-value><![CDATA[");
		sb.append(getFunctionGrade());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>budgetTypeOfPosition</column-name><column-value><![CDATA[");
		sb.append(getBudgetTypeOfPosition());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>chinaSixty</column-name><column-value><![CDATA[");
		sb.append(getChinaSixty());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>targetPDSupervisor</column-name><column-value><![CDATA[");
		sb.append(getTargetPDSupervisor());
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

		sb.append("</model>");

		return sb.toString();
	}

	private long _eTransferId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
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
	private String _statusByUserUuid;
	private String _statusByUserName;
	private Date _statusDate;
	private BaseModel<?> _eTransferRemoteModel;
	private Class<?> _clpSerializerClass = com.e.transfer.service.ClpSerializer.class;
}