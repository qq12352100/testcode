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

package com.e.closing.model.impl;

import com.e.closing.model.EClosing;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EClosing in entity cache.
 *
 * @author t.a.jiang
 * @see EClosing
 * @generated
 */
public class EClosingCacheModel implements CacheModel<EClosing>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(179);

		sb.append("{eclosingId=");
		sb.append(eclosingId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", ticketNo=");
		sb.append(ticketNo);
		sb.append(", staffCode=");
		sb.append(staffCode);
		sb.append(", staffName=");
		sb.append(staffName);
		sb.append(", company=");
		sb.append(company);
		sb.append(", division=");
		sb.append(division);
		sb.append(", department=");
		sb.append(department);
		sb.append(", costCenter=");
		sb.append(costCenter);
		sb.append(", functionName=");
		sb.append(functionName);
		sb.append(", positionCode=");
		sb.append(positionCode);
		sb.append(", employeeGroupId=");
		sb.append(employeeGroupId);
		sb.append(", employeeGroupName=");
		sb.append(employeeGroupName);
		sb.append(", privateEmailAddress=");
		sb.append(privateEmailAddress);
		sb.append(", startingDate=");
		sb.append(startingDate);
		sb.append(", lastWorkingDay=");
		sb.append(lastWorkingDay);
		sb.append(", finishContractDate=");
		sb.append(finishContractDate);
		sb.append(", seatOfficeNumber=");
		sb.append(seatOfficeNumber);
		sb.append(", permanentAddress=");
		sb.append(permanentAddress);
		sb.append(", dmOption1=");
		sb.append(dmOption1);
		sb.append(", dmOption2=");
		sb.append(dmOption2);
		sb.append(", dmStatus=");
		sb.append(dmStatus);
		sb.append(", dmComments=");
		sb.append(dmComments);
		sb.append(", adOption1=");
		sb.append(adOption1);
		sb.append(", adOption2=");
		sb.append(adOption2);
		sb.append(", adOption3=");
		sb.append(adOption3);
		sb.append(", adOption4=");
		sb.append(adOption4);
		sb.append(", adFinanceFee=");
		sb.append(adFinanceFee);
		sb.append(", adStatus=");
		sb.append(adStatus);
		sb.append(", adComments=");
		sb.append(adComments);
		sb.append(", fsOption1=");
		sb.append(fsOption1);
		sb.append(", fsStatus=");
		sb.append(fsStatus);
		sb.append(", fsComments=");
		sb.append(fsComments);
		sb.append(", flcOption1=");
		sb.append(flcOption1);
		sb.append(", flcOption2=");
		sb.append(flcOption2);
		sb.append(", flcStatus=");
		sb.append(flcStatus);
		sb.append(", flcComments=");
		sb.append(flcComments);
		sb.append(", securityOption1=");
		sb.append(securityOption1);
		sb.append(", securityFinanceFee=");
		sb.append(securityFinanceFee);
		sb.append(", securityStatus=");
		sb.append(securityStatus);
		sb.append(", securityComments=");
		sb.append(securityComments);
		sb.append(", idOption1=");
		sb.append(idOption1);
		sb.append(", idOption2=");
		sb.append(idOption2);
		sb.append(", idOption3=");
		sb.append(idOption3);
		sb.append(", idOption4=");
		sb.append(idOption4);
		sb.append(", idOption5=");
		sb.append(idOption5);
		sb.append(", idOption6=");
		sb.append(idOption6);
		sb.append(", idOption7=");
		sb.append(idOption7);
		sb.append(", idOption8=");
		sb.append(idOption8);
		sb.append(", idOption9=");
		sb.append(idOption9);
		sb.append(", idHrFee=");
		sb.append(idHrFee);
		sb.append(", idFinanceFee=");
		sb.append(idFinanceFee);
		sb.append(", idStatus=");
		sb.append(idStatus);
		sb.append(", idComments=");
		sb.append(idComments);
		sb.append(", htdOption1=");
		sb.append(htdOption1);
		sb.append(", htdHrFee=");
		sb.append(htdHrFee);
		sb.append(", htdFinanceFee=");
		sb.append(htdFinanceFee);
		sb.append(", htdStatus=");
		sb.append(htdStatus);
		sb.append(", htdComments=");
		sb.append(htdComments);
		sb.append(", hdOption1=");
		sb.append(hdOption1);
		sb.append(", hdOption2=");
		sb.append(hdOption2);
		sb.append(", hdOption2Text=");
		sb.append(hdOption2Text);
		sb.append(", hdOption3=");
		sb.append(hdOption3);
		sb.append(", hdOption3Money=");
		sb.append(hdOption3Money);
		sb.append(", hdOption4=");
		sb.append(hdOption4);
		sb.append(", hdOption4Money=");
		sb.append(hdOption4Money);
		sb.append(", hdStatus=");
		sb.append(hdStatus);
		sb.append(", hdComments=");
		sb.append(hdComments);
		sb.append(", hdleaveText=");
		sb.append(hdleaveText);
		sb.append(", fdOption1=");
		sb.append(fdOption1);
		sb.append(", fdOption2=");
		sb.append(fdOption2);
		sb.append(", fdOption3=");
		sb.append(fdOption3);
		sb.append(", fdOption4=");
		sb.append(fdOption4);
		sb.append(", fdOption4Text=");
		sb.append(fdOption4Text);
		sb.append(", fdStatus=");
		sb.append(fdStatus);
		sb.append(", fdComments=");
		sb.append(fdComments);
		sb.append(", applicantAgent=");
		sb.append(applicantAgent);
		sb.append(", approverAgent=");
		sb.append(approverAgent);
		sb.append(", processType=");
		sb.append(processType);
		sb.append(", subProcessType=");
		sb.append(subProcessType);
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
	public EClosing toEntityModel() {
		EClosingImpl eClosingImpl = new EClosingImpl();

		eClosingImpl.setEclosingId(eclosingId);
		eClosingImpl.setGroupId(groupId);
		eClosingImpl.setCompanyId(companyId);
		eClosingImpl.setUserId(userId);

		if (userName == null) {
			eClosingImpl.setUserName(StringPool.BLANK);
		}
		else {
			eClosingImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			eClosingImpl.setCreateDate(null);
		}
		else {
			eClosingImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			eClosingImpl.setModifiedDate(null);
		}
		else {
			eClosingImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (ticketNo == null) {
			eClosingImpl.setTicketNo(StringPool.BLANK);
		}
		else {
			eClosingImpl.setTicketNo(ticketNo);
		}

		eClosingImpl.setStaffCode(staffCode);

		if (staffName == null) {
			eClosingImpl.setStaffName(StringPool.BLANK);
		}
		else {
			eClosingImpl.setStaffName(staffName);
		}

		if (company == null) {
			eClosingImpl.setCompany(StringPool.BLANK);
		}
		else {
			eClosingImpl.setCompany(company);
		}

		if (division == null) {
			eClosingImpl.setDivision(StringPool.BLANK);
		}
		else {
			eClosingImpl.setDivision(division);
		}

		if (department == null) {
			eClosingImpl.setDepartment(StringPool.BLANK);
		}
		else {
			eClosingImpl.setDepartment(department);
		}

		if (costCenter == null) {
			eClosingImpl.setCostCenter(StringPool.BLANK);
		}
		else {
			eClosingImpl.setCostCenter(costCenter);
		}

		if (functionName == null) {
			eClosingImpl.setFunctionName(StringPool.BLANK);
		}
		else {
			eClosingImpl.setFunctionName(functionName);
		}

		if (positionCode == null) {
			eClosingImpl.setPositionCode(StringPool.BLANK);
		}
		else {
			eClosingImpl.setPositionCode(positionCode);
		}

		if (employeeGroupId == null) {
			eClosingImpl.setEmployeeGroupId(StringPool.BLANK);
		}
		else {
			eClosingImpl.setEmployeeGroupId(employeeGroupId);
		}

		if (employeeGroupName == null) {
			eClosingImpl.setEmployeeGroupName(StringPool.BLANK);
		}
		else {
			eClosingImpl.setEmployeeGroupName(employeeGroupName);
		}

		if (privateEmailAddress == null) {
			eClosingImpl.setPrivateEmailAddress(StringPool.BLANK);
		}
		else {
			eClosingImpl.setPrivateEmailAddress(privateEmailAddress);
		}

		if (startingDate == Long.MIN_VALUE) {
			eClosingImpl.setStartingDate(null);
		}
		else {
			eClosingImpl.setStartingDate(new Date(startingDate));
		}

		if (lastWorkingDay == Long.MIN_VALUE) {
			eClosingImpl.setLastWorkingDay(null);
		}
		else {
			eClosingImpl.setLastWorkingDay(new Date(lastWorkingDay));
		}

		if (finishContractDate == Long.MIN_VALUE) {
			eClosingImpl.setFinishContractDate(null);
		}
		else {
			eClosingImpl.setFinishContractDate(new Date(finishContractDate));
		}

		if (seatOfficeNumber == null) {
			eClosingImpl.setSeatOfficeNumber(StringPool.BLANK);
		}
		else {
			eClosingImpl.setSeatOfficeNumber(seatOfficeNumber);
		}

		if (permanentAddress == null) {
			eClosingImpl.setPermanentAddress(StringPool.BLANK);
		}
		else {
			eClosingImpl.setPermanentAddress(permanentAddress);
		}

		eClosingImpl.setDmOption1(dmOption1);
		eClosingImpl.setDmOption2(dmOption2);

		if (dmStatus == null) {
			eClosingImpl.setDmStatus(StringPool.BLANK);
		}
		else {
			eClosingImpl.setDmStatus(dmStatus);
		}

		if (dmComments == null) {
			eClosingImpl.setDmComments(StringPool.BLANK);
		}
		else {
			eClosingImpl.setDmComments(dmComments);
		}

		eClosingImpl.setAdOption1(adOption1);
		eClosingImpl.setAdOption2(adOption2);
		eClosingImpl.setAdOption3(adOption3);
		eClosingImpl.setAdOption4(adOption4);
		eClosingImpl.setAdFinanceFee(adFinanceFee);

		if (adStatus == null) {
			eClosingImpl.setAdStatus(StringPool.BLANK);
		}
		else {
			eClosingImpl.setAdStatus(adStatus);
		}

		if (adComments == null) {
			eClosingImpl.setAdComments(StringPool.BLANK);
		}
		else {
			eClosingImpl.setAdComments(adComments);
		}

		eClosingImpl.setFsOption1(fsOption1);

		if (fsStatus == null) {
			eClosingImpl.setFsStatus(StringPool.BLANK);
		}
		else {
			eClosingImpl.setFsStatus(fsStatus);
		}

		if (fsComments == null) {
			eClosingImpl.setFsComments(StringPool.BLANK);
		}
		else {
			eClosingImpl.setFsComments(fsComments);
		}

		eClosingImpl.setFlcOption1(flcOption1);
		eClosingImpl.setFlcOption2(flcOption2);

		if (flcStatus == null) {
			eClosingImpl.setFlcStatus(StringPool.BLANK);
		}
		else {
			eClosingImpl.setFlcStatus(flcStatus);
		}

		if (flcComments == null) {
			eClosingImpl.setFlcComments(StringPool.BLANK);
		}
		else {
			eClosingImpl.setFlcComments(flcComments);
		}

		eClosingImpl.setSecurityOption1(securityOption1);
		eClosingImpl.setSecurityFinanceFee(securityFinanceFee);

		if (securityStatus == null) {
			eClosingImpl.setSecurityStatus(StringPool.BLANK);
		}
		else {
			eClosingImpl.setSecurityStatus(securityStatus);
		}

		if (securityComments == null) {
			eClosingImpl.setSecurityComments(StringPool.BLANK);
		}
		else {
			eClosingImpl.setSecurityComments(securityComments);
		}

		eClosingImpl.setIdOption1(idOption1);
		eClosingImpl.setIdOption2(idOption2);
		eClosingImpl.setIdOption3(idOption3);
		eClosingImpl.setIdOption4(idOption4);
		eClosingImpl.setIdOption5(idOption5);
		eClosingImpl.setIdOption6(idOption6);
		eClosingImpl.setIdOption7(idOption7);
		eClosingImpl.setIdOption8(idOption8);
		eClosingImpl.setIdOption9(idOption9);
		eClosingImpl.setIdHrFee(idHrFee);
		eClosingImpl.setIdFinanceFee(idFinanceFee);

		if (idStatus == null) {
			eClosingImpl.setIdStatus(StringPool.BLANK);
		}
		else {
			eClosingImpl.setIdStatus(idStatus);
		}

		if (idComments == null) {
			eClosingImpl.setIdComments(StringPool.BLANK);
		}
		else {
			eClosingImpl.setIdComments(idComments);
		}

		eClosingImpl.setHtdOption1(htdOption1);
		eClosingImpl.setHtdHrFee(htdHrFee);
		eClosingImpl.setHtdFinanceFee(htdFinanceFee);

		if (htdStatus == null) {
			eClosingImpl.setHtdStatus(StringPool.BLANK);
		}
		else {
			eClosingImpl.setHtdStatus(htdStatus);
		}

		if (htdComments == null) {
			eClosingImpl.setHtdComments(StringPool.BLANK);
		}
		else {
			eClosingImpl.setHtdComments(htdComments);
		}

		eClosingImpl.setHdOption1(hdOption1);
		eClosingImpl.setHdOption2(hdOption2);

		if (hdOption2Text == null) {
			eClosingImpl.setHdOption2Text(StringPool.BLANK);
		}
		else {
			eClosingImpl.setHdOption2Text(hdOption2Text);
		}

		eClosingImpl.setHdOption3(hdOption3);
		eClosingImpl.setHdOption3Money(hdOption3Money);
		eClosingImpl.setHdOption4(hdOption4);
		eClosingImpl.setHdOption4Money(hdOption4Money);

		if (hdStatus == null) {
			eClosingImpl.setHdStatus(StringPool.BLANK);
		}
		else {
			eClosingImpl.setHdStatus(hdStatus);
		}

		if (hdComments == null) {
			eClosingImpl.setHdComments(StringPool.BLANK);
		}
		else {
			eClosingImpl.setHdComments(hdComments);
		}

		if (hdleaveText == null) {
			eClosingImpl.setHdleaveText(StringPool.BLANK);
		}
		else {
			eClosingImpl.setHdleaveText(hdleaveText);
		}

		eClosingImpl.setFdOption1(fdOption1);
		eClosingImpl.setFdOption2(fdOption2);
		eClosingImpl.setFdOption3(fdOption3);
		eClosingImpl.setFdOption4(fdOption4);

		if (fdOption4Text == null) {
			eClosingImpl.setFdOption4Text(StringPool.BLANK);
		}
		else {
			eClosingImpl.setFdOption4Text(fdOption4Text);
		}

		if (fdStatus == null) {
			eClosingImpl.setFdStatus(StringPool.BLANK);
		}
		else {
			eClosingImpl.setFdStatus(fdStatus);
		}

		if (fdComments == null) {
			eClosingImpl.setFdComments(StringPool.BLANK);
		}
		else {
			eClosingImpl.setFdComments(fdComments);
		}

		eClosingImpl.setApplicantAgent(applicantAgent);
		eClosingImpl.setApproverAgent(approverAgent);

		if (processType == null) {
			eClosingImpl.setProcessType(StringPool.BLANK);
		}
		else {
			eClosingImpl.setProcessType(processType);
		}

		if (subProcessType == null) {
			eClosingImpl.setSubProcessType(StringPool.BLANK);
		}
		else {
			eClosingImpl.setSubProcessType(subProcessType);
		}

		eClosingImpl.setStatus(status);
		eClosingImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			eClosingImpl.setStatusByUserName(StringPool.BLANK);
		}
		else {
			eClosingImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			eClosingImpl.setStatusDate(null);
		}
		else {
			eClosingImpl.setStatusDate(new Date(statusDate));
		}

		eClosingImpl.resetOriginalValues();

		return eClosingImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		eclosingId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		ticketNo = objectInput.readUTF();
		staffCode = objectInput.readInt();
		staffName = objectInput.readUTF();
		company = objectInput.readUTF();
		division = objectInput.readUTF();
		department = objectInput.readUTF();
		costCenter = objectInput.readUTF();
		functionName = objectInput.readUTF();
		positionCode = objectInput.readUTF();
		employeeGroupId = objectInput.readUTF();
		employeeGroupName = objectInput.readUTF();
		privateEmailAddress = objectInput.readUTF();
		startingDate = objectInput.readLong();
		lastWorkingDay = objectInput.readLong();
		finishContractDate = objectInput.readLong();
		seatOfficeNumber = objectInput.readUTF();
		permanentAddress = objectInput.readUTF();
		dmOption1 = objectInput.readBoolean();
		dmOption2 = objectInput.readBoolean();
		dmStatus = objectInput.readUTF();
		dmComments = objectInput.readUTF();
		adOption1 = objectInput.readBoolean();
		adOption2 = objectInput.readBoolean();
		adOption3 = objectInput.readBoolean();
		adOption4 = objectInput.readBoolean();
		adFinanceFee = objectInput.readDouble();
		adStatus = objectInput.readUTF();
		adComments = objectInput.readUTF();
		fsOption1 = objectInput.readBoolean();
		fsStatus = objectInput.readUTF();
		fsComments = objectInput.readUTF();
		flcOption1 = objectInput.readBoolean();
		flcOption2 = objectInput.readBoolean();
		flcStatus = objectInput.readUTF();
		flcComments = objectInput.readUTF();
		securityOption1 = objectInput.readBoolean();
		securityFinanceFee = objectInput.readDouble();
		securityStatus = objectInput.readUTF();
		securityComments = objectInput.readUTF();
		idOption1 = objectInput.readBoolean();
		idOption2 = objectInput.readBoolean();
		idOption3 = objectInput.readBoolean();
		idOption4 = objectInput.readBoolean();
		idOption5 = objectInput.readBoolean();
		idOption6 = objectInput.readBoolean();
		idOption7 = objectInput.readBoolean();
		idOption8 = objectInput.readBoolean();
		idOption9 = objectInput.readBoolean();
		idHrFee = objectInput.readDouble();
		idFinanceFee = objectInput.readDouble();
		idStatus = objectInput.readUTF();
		idComments = objectInput.readUTF();
		htdOption1 = objectInput.readBoolean();
		htdHrFee = objectInput.readDouble();
		htdFinanceFee = objectInput.readDouble();
		htdStatus = objectInput.readUTF();
		htdComments = objectInput.readUTF();
		hdOption1 = objectInput.readBoolean();
		hdOption2 = objectInput.readBoolean();
		hdOption2Text = objectInput.readUTF();
		hdOption3 = objectInput.readBoolean();
		hdOption3Money = objectInput.readDouble();
		hdOption4 = objectInput.readBoolean();
		hdOption4Money = objectInput.readDouble();
		hdStatus = objectInput.readUTF();
		hdComments = objectInput.readUTF();
		hdleaveText = objectInput.readUTF();
		fdOption1 = objectInput.readBoolean();
		fdOption2 = objectInput.readBoolean();
		fdOption3 = objectInput.readBoolean();
		fdOption4 = objectInput.readBoolean();
		fdOption4Text = objectInput.readUTF();
		fdStatus = objectInput.readUTF();
		fdComments = objectInput.readUTF();
		applicantAgent = objectInput.readBoolean();
		approverAgent = objectInput.readBoolean();
		processType = objectInput.readUTF();
		subProcessType = objectInput.readUTF();
		status = objectInput.readInt();
		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(eclosingId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (ticketNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ticketNo);
		}

		objectOutput.writeInt(staffCode);

		if (staffName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(staffName);
		}

		if (company == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(company);
		}

		if (division == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(division);
		}

		if (department == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(department);
		}

		if (costCenter == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(costCenter);
		}

		if (functionName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(functionName);
		}

		if (positionCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(positionCode);
		}

		if (employeeGroupId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(employeeGroupId);
		}

		if (employeeGroupName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(employeeGroupName);
		}

		if (privateEmailAddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(privateEmailAddress);
		}

		objectOutput.writeLong(startingDate);
		objectOutput.writeLong(lastWorkingDay);
		objectOutput.writeLong(finishContractDate);

		if (seatOfficeNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(seatOfficeNumber);
		}

		if (permanentAddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(permanentAddress);
		}

		objectOutput.writeBoolean(dmOption1);
		objectOutput.writeBoolean(dmOption2);

		if (dmStatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dmStatus);
		}

		if (dmComments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dmComments);
		}

		objectOutput.writeBoolean(adOption1);
		objectOutput.writeBoolean(adOption2);
		objectOutput.writeBoolean(adOption3);
		objectOutput.writeBoolean(adOption4);
		objectOutput.writeDouble(adFinanceFee);

		if (adStatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(adStatus);
		}

		if (adComments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(adComments);
		}

		objectOutput.writeBoolean(fsOption1);

		if (fsStatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fsStatus);
		}

		if (fsComments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fsComments);
		}

		objectOutput.writeBoolean(flcOption1);
		objectOutput.writeBoolean(flcOption2);

		if (flcStatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(flcStatus);
		}

		if (flcComments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(flcComments);
		}

		objectOutput.writeBoolean(securityOption1);
		objectOutput.writeDouble(securityFinanceFee);

		if (securityStatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(securityStatus);
		}

		if (securityComments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(securityComments);
		}

		objectOutput.writeBoolean(idOption1);
		objectOutput.writeBoolean(idOption2);
		objectOutput.writeBoolean(idOption3);
		objectOutput.writeBoolean(idOption4);
		objectOutput.writeBoolean(idOption5);
		objectOutput.writeBoolean(idOption6);
		objectOutput.writeBoolean(idOption7);
		objectOutput.writeBoolean(idOption8);
		objectOutput.writeBoolean(idOption9);
		objectOutput.writeDouble(idHrFee);
		objectOutput.writeDouble(idFinanceFee);

		if (idStatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(idStatus);
		}

		if (idComments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(idComments);
		}

		objectOutput.writeBoolean(htdOption1);
		objectOutput.writeDouble(htdHrFee);
		objectOutput.writeDouble(htdFinanceFee);

		if (htdStatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(htdStatus);
		}

		if (htdComments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(htdComments);
		}

		objectOutput.writeBoolean(hdOption1);
		objectOutput.writeBoolean(hdOption2);

		if (hdOption2Text == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(hdOption2Text);
		}

		objectOutput.writeBoolean(hdOption3);
		objectOutput.writeDouble(hdOption3Money);
		objectOutput.writeBoolean(hdOption4);
		objectOutput.writeDouble(hdOption4Money);

		if (hdStatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(hdStatus);
		}

		if (hdComments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(hdComments);
		}

		if (hdleaveText == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(hdleaveText);
		}

		objectOutput.writeBoolean(fdOption1);
		objectOutput.writeBoolean(fdOption2);
		objectOutput.writeBoolean(fdOption3);
		objectOutput.writeBoolean(fdOption4);

		if (fdOption4Text == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fdOption4Text);
		}

		if (fdStatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fdStatus);
		}

		if (fdComments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fdComments);
		}

		objectOutput.writeBoolean(applicantAgent);
		objectOutput.writeBoolean(approverAgent);

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

	public long eclosingId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String ticketNo;
	public int staffCode;
	public String staffName;
	public String company;
	public String division;
	public String department;
	public String costCenter;
	public String functionName;
	public String positionCode;
	public String employeeGroupId;
	public String employeeGroupName;
	public String privateEmailAddress;
	public long startingDate;
	public long lastWorkingDay;
	public long finishContractDate;
	public String seatOfficeNumber;
	public String permanentAddress;
	public boolean dmOption1;
	public boolean dmOption2;
	public String dmStatus;
	public String dmComments;
	public boolean adOption1;
	public boolean adOption2;
	public boolean adOption3;
	public boolean adOption4;
	public double adFinanceFee;
	public String adStatus;
	public String adComments;
	public boolean fsOption1;
	public String fsStatus;
	public String fsComments;
	public boolean flcOption1;
	public boolean flcOption2;
	public String flcStatus;
	public String flcComments;
	public boolean securityOption1;
	public double securityFinanceFee;
	public String securityStatus;
	public String securityComments;
	public boolean idOption1;
	public boolean idOption2;
	public boolean idOption3;
	public boolean idOption4;
	public boolean idOption5;
	public boolean idOption6;
	public boolean idOption7;
	public boolean idOption8;
	public boolean idOption9;
	public double idHrFee;
	public double idFinanceFee;
	public String idStatus;
	public String idComments;
	public boolean htdOption1;
	public double htdHrFee;
	public double htdFinanceFee;
	public String htdStatus;
	public String htdComments;
	public boolean hdOption1;
	public boolean hdOption2;
	public String hdOption2Text;
	public boolean hdOption3;
	public double hdOption3Money;
	public boolean hdOption4;
	public double hdOption4Money;
	public String hdStatus;
	public String hdComments;
	public String hdleaveText;
	public boolean fdOption1;
	public boolean fdOption2;
	public boolean fdOption3;
	public boolean fdOption4;
	public String fdOption4Text;
	public String fdStatus;
	public String fdComments;
	public boolean applicantAgent;
	public boolean approverAgent;
	public String processType;
	public String subProcessType;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
}