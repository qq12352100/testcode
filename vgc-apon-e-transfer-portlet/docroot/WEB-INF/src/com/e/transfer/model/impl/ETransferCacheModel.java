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

package com.e.transfer.model.impl;

import com.e.transfer.model.ETransfer;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ETransfer in entity cache.
 *
 * @author EZEYIFE
 * @see ETransfer
 * @generated
 */
public class ETransferCacheModel implements CacheModel<ETransfer>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(93);

		sb.append("{eTransferId=");
		sb.append(eTransferId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", ticketNo=");
		sb.append(ticketNo);
		sb.append(", staffName=");
		sb.append(staffName);
		sb.append(", currentStaffCode=");
		sb.append(currentStaffCode);
		sb.append(", contractType=");
		sb.append(contractType);
		sb.append(", newStaffCode=");
		sb.append(newStaffCode);
		sb.append(", PassedLL=");
		sb.append(PassedLL);
		sb.append(", AttendedSLT=");
		sb.append(AttendedSLT);
		sb.append(", currentCompany=");
		sb.append(currentCompany);
		sb.append(", currentDivision=");
		sb.append(currentDivision);
		sb.append(", currentDepartment=");
		sb.append(currentDepartment);
		sb.append(", currentFunctionName=");
		sb.append(currentFunctionName);
		sb.append(", currentCostCenter=");
		sb.append(currentCostCenter);
		sb.append(", currentReportingTo=");
		sb.append(currentReportingTo);
		sb.append(", otherAgreementIfAny=");
		sb.append(otherAgreementIfAny);
		sb.append(", currentOfficeSite=");
		sb.append(currentOfficeSite);
		sb.append(", currentPositionCode=");
		sb.append(currentPositionCode);
		sb.append(", receivingStaffCode=");
		sb.append(receivingStaffCode);
		sb.append(", receivingCompany=");
		sb.append(receivingCompany);
		sb.append(", receivingDivision=");
		sb.append(receivingDivision);
		sb.append(", receivingDepartment=");
		sb.append(receivingDepartment);
		sb.append(", newFunctionName=");
		sb.append(newFunctionName);
		sb.append(", newCostCenter=");
		sb.append(newCostCenter);
		sb.append(", newReportingTo=");
		sb.append(newReportingTo);
		sb.append(", effectiveDate=");
		sb.append(effectiveDate);
		sb.append(", newOfficeSite=");
		sb.append(newOfficeSite);
		sb.append(", sapPositionCode=");
		sb.append(sapPositionCode);
		sb.append(", replacement=");
		sb.append(replacement);
		sb.append(", functionGrade=");
		sb.append(functionGrade);
		sb.append(", budgetTypeOfPosition=");
		sb.append(budgetTypeOfPosition);
		sb.append(", chinaSixty=");
		sb.append(chinaSixty);
		sb.append(", targetPDSupervisor=");
		sb.append(targetPDSupervisor);
		sb.append(", processType=");
		sb.append(processType);
		sb.append(", subProcessType=");
		sb.append(subProcessType);
		sb.append(", submittedDate=");
		sb.append(submittedDate);
		sb.append(", comments=");
		sb.append(comments);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ETransfer toEntityModel() {
		ETransferImpl eTransferImpl = new ETransferImpl();

		eTransferImpl.setETransferId(eTransferId);
		eTransferImpl.setGroupId(groupId);
		eTransferImpl.setUserId(userId);

		if (userName == null) {
			eTransferImpl.setUserName(StringPool.BLANK);
		}
		else {
			eTransferImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			eTransferImpl.setCreateDate(null);
		}
		else {
			eTransferImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			eTransferImpl.setModifiedDate(null);
		}
		else {
			eTransferImpl.setModifiedDate(new Date(modifiedDate));
		}

		eTransferImpl.setCompanyId(companyId);

		if (ticketNo == null) {
			eTransferImpl.setTicketNo(StringPool.BLANK);
		}
		else {
			eTransferImpl.setTicketNo(ticketNo);
		}

		if (staffName == null) {
			eTransferImpl.setStaffName(StringPool.BLANK);
		}
		else {
			eTransferImpl.setStaffName(staffName);
		}

		if (currentStaffCode == null) {
			eTransferImpl.setCurrentStaffCode(StringPool.BLANK);
		}
		else {
			eTransferImpl.setCurrentStaffCode(currentStaffCode);
		}

		if (contractType == null) {
			eTransferImpl.setContractType(StringPool.BLANK);
		}
		else {
			eTransferImpl.setContractType(contractType);
		}

		if (newStaffCode == null) {
			eTransferImpl.setNewStaffCode(StringPool.BLANK);
		}
		else {
			eTransferImpl.setNewStaffCode(newStaffCode);
		}

		eTransferImpl.setPassedLL(PassedLL);
		eTransferImpl.setAttendedSLT(AttendedSLT);

		if (currentCompany == null) {
			eTransferImpl.setCurrentCompany(StringPool.BLANK);
		}
		else {
			eTransferImpl.setCurrentCompany(currentCompany);
		}

		if (currentDivision == null) {
			eTransferImpl.setCurrentDivision(StringPool.BLANK);
		}
		else {
			eTransferImpl.setCurrentDivision(currentDivision);
		}

		if (currentDepartment == null) {
			eTransferImpl.setCurrentDepartment(StringPool.BLANK);
		}
		else {
			eTransferImpl.setCurrentDepartment(currentDepartment);
		}

		if (currentFunctionName == null) {
			eTransferImpl.setCurrentFunctionName(StringPool.BLANK);
		}
		else {
			eTransferImpl.setCurrentFunctionName(currentFunctionName);
		}

		if (currentCostCenter == null) {
			eTransferImpl.setCurrentCostCenter(StringPool.BLANK);
		}
		else {
			eTransferImpl.setCurrentCostCenter(currentCostCenter);
		}

		if (currentReportingTo == null) {
			eTransferImpl.setCurrentReportingTo(StringPool.BLANK);
		}
		else {
			eTransferImpl.setCurrentReportingTo(currentReportingTo);
		}

		if (otherAgreementIfAny == null) {
			eTransferImpl.setOtherAgreementIfAny(StringPool.BLANK);
		}
		else {
			eTransferImpl.setOtherAgreementIfAny(otherAgreementIfAny);
		}

		if (currentOfficeSite == null) {
			eTransferImpl.setCurrentOfficeSite(StringPool.BLANK);
		}
		else {
			eTransferImpl.setCurrentOfficeSite(currentOfficeSite);
		}

		if (currentPositionCode == null) {
			eTransferImpl.setCurrentPositionCode(StringPool.BLANK);
		}
		else {
			eTransferImpl.setCurrentPositionCode(currentPositionCode);
		}

		if (receivingStaffCode == null) {
			eTransferImpl.setReceivingStaffCode(StringPool.BLANK);
		}
		else {
			eTransferImpl.setReceivingStaffCode(receivingStaffCode);
		}

		if (receivingCompany == null) {
			eTransferImpl.setReceivingCompany(StringPool.BLANK);
		}
		else {
			eTransferImpl.setReceivingCompany(receivingCompany);
		}

		if (receivingDivision == null) {
			eTransferImpl.setReceivingDivision(StringPool.BLANK);
		}
		else {
			eTransferImpl.setReceivingDivision(receivingDivision);
		}

		if (receivingDepartment == null) {
			eTransferImpl.setReceivingDepartment(StringPool.BLANK);
		}
		else {
			eTransferImpl.setReceivingDepartment(receivingDepartment);
		}

		if (newFunctionName == null) {
			eTransferImpl.setNewFunctionName(StringPool.BLANK);
		}
		else {
			eTransferImpl.setNewFunctionName(newFunctionName);
		}

		if (newCostCenter == null) {
			eTransferImpl.setNewCostCenter(StringPool.BLANK);
		}
		else {
			eTransferImpl.setNewCostCenter(newCostCenter);
		}

		if (newReportingTo == null) {
			eTransferImpl.setNewReportingTo(StringPool.BLANK);
		}
		else {
			eTransferImpl.setNewReportingTo(newReportingTo);
		}

		if (effectiveDate == Long.MIN_VALUE) {
			eTransferImpl.setEffectiveDate(null);
		}
		else {
			eTransferImpl.setEffectiveDate(new Date(effectiveDate));
		}

		if (newOfficeSite == null) {
			eTransferImpl.setNewOfficeSite(StringPool.BLANK);
		}
		else {
			eTransferImpl.setNewOfficeSite(newOfficeSite);
		}

		if (sapPositionCode == null) {
			eTransferImpl.setSapPositionCode(StringPool.BLANK);
		}
		else {
			eTransferImpl.setSapPositionCode(sapPositionCode);
		}

		if (replacement == null) {
			eTransferImpl.setReplacement(StringPool.BLANK);
		}
		else {
			eTransferImpl.setReplacement(replacement);
		}

		if (functionGrade == null) {
			eTransferImpl.setFunctionGrade(StringPool.BLANK);
		}
		else {
			eTransferImpl.setFunctionGrade(functionGrade);
		}

		eTransferImpl.setBudgetTypeOfPosition(budgetTypeOfPosition);
		eTransferImpl.setChinaSixty(chinaSixty);
		eTransferImpl.setTargetPDSupervisor(targetPDSupervisor);

		if (processType == null) {
			eTransferImpl.setProcessType(StringPool.BLANK);
		}
		else {
			eTransferImpl.setProcessType(processType);
		}

		if (subProcessType == null) {
			eTransferImpl.setSubProcessType(StringPool.BLANK);
		}
		else {
			eTransferImpl.setSubProcessType(subProcessType);
		}

		if (submittedDate == Long.MIN_VALUE) {
			eTransferImpl.setSubmittedDate(null);
		}
		else {
			eTransferImpl.setSubmittedDate(new Date(submittedDate));
		}

		if (comments == null) {
			eTransferImpl.setComments(StringPool.BLANK);
		}
		else {
			eTransferImpl.setComments(comments);
		}

		eTransferImpl.setStatus(status);
		eTransferImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			eTransferImpl.setStatusByUserName(StringPool.BLANK);
		}
		else {
			eTransferImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			eTransferImpl.setStatusDate(null);
		}
		else {
			eTransferImpl.setStatusDate(new Date(statusDate));
		}

		eTransferImpl.resetOriginalValues();

		return eTransferImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		eTransferId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		companyId = objectInput.readLong();
		ticketNo = objectInput.readUTF();
		staffName = objectInput.readUTF();
		currentStaffCode = objectInput.readUTF();
		contractType = objectInput.readUTF();
		newStaffCode = objectInput.readUTF();
		PassedLL = objectInput.readInt();
		AttendedSLT = objectInput.readInt();
		currentCompany = objectInput.readUTF();
		currentDivision = objectInput.readUTF();
		currentDepartment = objectInput.readUTF();
		currentFunctionName = objectInput.readUTF();
		currentCostCenter = objectInput.readUTF();
		currentReportingTo = objectInput.readUTF();
		otherAgreementIfAny = objectInput.readUTF();
		currentOfficeSite = objectInput.readUTF();
		currentPositionCode = objectInput.readUTF();
		receivingStaffCode = objectInput.readUTF();
		receivingCompany = objectInput.readUTF();
		receivingDivision = objectInput.readUTF();
		receivingDepartment = objectInput.readUTF();
		newFunctionName = objectInput.readUTF();
		newCostCenter = objectInput.readUTF();
		newReportingTo = objectInput.readUTF();
		effectiveDate = objectInput.readLong();
		newOfficeSite = objectInput.readUTF();
		sapPositionCode = objectInput.readUTF();
		replacement = objectInput.readUTF();
		functionGrade = objectInput.readUTF();
		budgetTypeOfPosition = objectInput.readInt();
		chinaSixty = objectInput.readInt();
		targetPDSupervisor = objectInput.readInt();
		processType = objectInput.readUTF();
		subProcessType = objectInput.readUTF();
		submittedDate = objectInput.readLong();
		comments = objectInput.readUTF();
		status = objectInput.readInt();
		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(eTransferId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(companyId);

		if (ticketNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ticketNo);
		}

		if (staffName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(staffName);
		}

		if (currentStaffCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(currentStaffCode);
		}

		if (contractType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contractType);
		}

		if (newStaffCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(newStaffCode);
		}

		objectOutput.writeInt(PassedLL);
		objectOutput.writeInt(AttendedSLT);

		if (currentCompany == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(currentCompany);
		}

		if (currentDivision == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(currentDivision);
		}

		if (currentDepartment == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(currentDepartment);
		}

		if (currentFunctionName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(currentFunctionName);
		}

		if (currentCostCenter == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(currentCostCenter);
		}

		if (currentReportingTo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(currentReportingTo);
		}

		if (otherAgreementIfAny == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(otherAgreementIfAny);
		}

		if (currentOfficeSite == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(currentOfficeSite);
		}

		if (currentPositionCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(currentPositionCode);
		}

		if (receivingStaffCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(receivingStaffCode);
		}

		if (receivingCompany == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(receivingCompany);
		}

		if (receivingDivision == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(receivingDivision);
		}

		if (receivingDepartment == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(receivingDepartment);
		}

		if (newFunctionName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(newFunctionName);
		}

		if (newCostCenter == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(newCostCenter);
		}

		if (newReportingTo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(newReportingTo);
		}

		objectOutput.writeLong(effectiveDate);

		if (newOfficeSite == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(newOfficeSite);
		}

		if (sapPositionCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sapPositionCode);
		}

		if (replacement == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(replacement);
		}

		if (functionGrade == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(functionGrade);
		}

		objectOutput.writeInt(budgetTypeOfPosition);
		objectOutput.writeInt(chinaSixty);
		objectOutput.writeInt(targetPDSupervisor);

		if (processType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(processType);
		}

		if (subProcessType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(subProcessType);
		}

		objectOutput.writeLong(submittedDate);

		if (comments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(comments);
		}

		objectOutput.writeInt(status);
		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);
	}

	public long eTransferId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long companyId;
	public String ticketNo;
	public String staffName;
	public String currentStaffCode;
	public String contractType;
	public String newStaffCode;
	public int PassedLL;
	public int AttendedSLT;
	public String currentCompany;
	public String currentDivision;
	public String currentDepartment;
	public String currentFunctionName;
	public String currentCostCenter;
	public String currentReportingTo;
	public String otherAgreementIfAny;
	public String currentOfficeSite;
	public String currentPositionCode;
	public String receivingStaffCode;
	public String receivingCompany;
	public String receivingDivision;
	public String receivingDepartment;
	public String newFunctionName;
	public String newCostCenter;
	public String newReportingTo;
	public long effectiveDate;
	public String newOfficeSite;
	public String sapPositionCode;
	public String replacement;
	public String functionGrade;
	public int budgetTypeOfPosition;
	public int chinaSixty;
	public int targetPDSupervisor;
	public String processType;
	public String subProcessType;
	public long submittedDate;
	public String comments;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
}