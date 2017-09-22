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

package com.company.car.model.impl;

import com.company.car.model.SecondCompanyCar;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SecondCompanyCar in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see SecondCompanyCar
 * @generated
 */
public class SecondCompanyCarCacheModel implements CacheModel<SecondCompanyCar>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(83);

		sb.append("{secondCompanyCarId=");
		sb.append(secondCompanyCarId);
		sb.append(", ticketNo=");
		sb.append(ticketNo);
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
		sb.append(", submittedDate=");
		sb.append(submittedDate);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", staffCode=");
		sb.append(staffCode);
		sb.append(", division=");
		sb.append(division);
		sb.append(", department=");
		sb.append(department);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", companyName=");
		sb.append(companyName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", contactNo=");
		sb.append(contactNo);
		sb.append(", workingLocation=");
		sb.append(workingLocation);
		sb.append(", officeSite=");
		sb.append(officeSite);
		sb.append(", currentCarModel=");
		sb.append(currentCarModel);
		sb.append(", currentCarColor=");
		sb.append(currentCarColor);
		sb.append(", currentPlateNumber=");
		sb.append(currentPlateNumber);
		sb.append(", acquiringDate=");
		sb.append(acquiringDate);
		sb.append(", expectedCarModel=");
		sb.append(expectedCarModel);
		sb.append(", expectedCarColor=");
		sb.append(expectedCarColor);
		sb.append(", expectedLastPlateNumber=");
		sb.append(expectedLastPlateNumber);
		sb.append(", positionCostCenterId=");
		sb.append(positionCostCenterId);
		sb.append(", employeeGroupId=");
		sb.append(employeeGroupId);
		sb.append(", contractEndDate=");
		sb.append(contractEndDate);
		sb.append(", mobilePhone=");
		sb.append(mobilePhone);
		sb.append(", officePhone=");
		sb.append(officePhone);
		sb.append(", email=");
		sb.append(email);
		sb.append(", isApplicantAgent=");
		sb.append(isApplicantAgent);
		sb.append(", isApproverAgent=");
		sb.append(isApproverAgent);
		sb.append(", drivingLicenseInformation=");
		sb.append(drivingLicenseInformation);
		sb.append(", estimatedObtainingDate=");
		sb.append(estimatedObtainingDate);
		sb.append(", comments=");
		sb.append(comments);
		sb.append(", processType=");
		sb.append(processType);
		sb.append(", subType=");
		sb.append(subType);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SecondCompanyCar toEntityModel() {
		SecondCompanyCarImpl secondCompanyCarImpl = new SecondCompanyCarImpl();

		secondCompanyCarImpl.setSecondCompanyCarId(secondCompanyCarId);

		if (ticketNo == null) {
			secondCompanyCarImpl.setTicketNo(StringPool.BLANK);
		}
		else {
			secondCompanyCarImpl.setTicketNo(ticketNo);
		}

		secondCompanyCarImpl.setGroupId(groupId);
		secondCompanyCarImpl.setUserId(userId);

		if (userName == null) {
			secondCompanyCarImpl.setUserName(StringPool.BLANK);
		}
		else {
			secondCompanyCarImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			secondCompanyCarImpl.setCreateDate(null);
		}
		else {
			secondCompanyCarImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			secondCompanyCarImpl.setModifiedDate(null);
		}
		else {
			secondCompanyCarImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (submittedDate == Long.MIN_VALUE) {
			secondCompanyCarImpl.setSubmittedDate(null);
		}
		else {
			secondCompanyCarImpl.setSubmittedDate(new Date(submittedDate));
		}

		secondCompanyCarImpl.setCompanyId(companyId);

		if (name == null) {
			secondCompanyCarImpl.setName(StringPool.BLANK);
		}
		else {
			secondCompanyCarImpl.setName(name);
		}

		secondCompanyCarImpl.setStaffCode(staffCode);

		if (division == null) {
			secondCompanyCarImpl.setDivision(StringPool.BLANK);
		}
		else {
			secondCompanyCarImpl.setDivision(division);
		}

		if (department == null) {
			secondCompanyCarImpl.setDepartment(StringPool.BLANK);
		}
		else {
			secondCompanyCarImpl.setDepartment(department);
		}

		secondCompanyCarImpl.setStatus(status);
		secondCompanyCarImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			secondCompanyCarImpl.setStatusByUserName(StringPool.BLANK);
		}
		else {
			secondCompanyCarImpl.setStatusByUserName(statusByUserName);
		}

		if (companyName == null) {
			secondCompanyCarImpl.setCompanyName(StringPool.BLANK);
		}
		else {
			secondCompanyCarImpl.setCompanyName(companyName);
		}

		if (statusDate == Long.MIN_VALUE) {
			secondCompanyCarImpl.setStatusDate(null);
		}
		else {
			secondCompanyCarImpl.setStatusDate(new Date(statusDate));
		}

		if (contactNo == null) {
			secondCompanyCarImpl.setContactNo(StringPool.BLANK);
		}
		else {
			secondCompanyCarImpl.setContactNo(contactNo);
		}

		if (workingLocation == null) {
			secondCompanyCarImpl.setWorkingLocation(StringPool.BLANK);
		}
		else {
			secondCompanyCarImpl.setWorkingLocation(workingLocation);
		}

		if (officeSite == null) {
			secondCompanyCarImpl.setOfficeSite(StringPool.BLANK);
		}
		else {
			secondCompanyCarImpl.setOfficeSite(officeSite);
		}

		if (currentCarModel == null) {
			secondCompanyCarImpl.setCurrentCarModel(StringPool.BLANK);
		}
		else {
			secondCompanyCarImpl.setCurrentCarModel(currentCarModel);
		}

		if (currentCarColor == null) {
			secondCompanyCarImpl.setCurrentCarColor(StringPool.BLANK);
		}
		else {
			secondCompanyCarImpl.setCurrentCarColor(currentCarColor);
		}

		if (currentPlateNumber == null) {
			secondCompanyCarImpl.setCurrentPlateNumber(StringPool.BLANK);
		}
		else {
			secondCompanyCarImpl.setCurrentPlateNumber(currentPlateNumber);
		}

		if (acquiringDate == Long.MIN_VALUE) {
			secondCompanyCarImpl.setAcquiringDate(null);
		}
		else {
			secondCompanyCarImpl.setAcquiringDate(new Date(acquiringDate));
		}

		if (expectedCarModel == null) {
			secondCompanyCarImpl.setExpectedCarModel(StringPool.BLANK);
		}
		else {
			secondCompanyCarImpl.setExpectedCarModel(expectedCarModel);
		}

		if (expectedCarColor == null) {
			secondCompanyCarImpl.setExpectedCarColor(StringPool.BLANK);
		}
		else {
			secondCompanyCarImpl.setExpectedCarColor(expectedCarColor);
		}

		if (expectedLastPlateNumber == null) {
			secondCompanyCarImpl.setExpectedLastPlateNumber(StringPool.BLANK);
		}
		else {
			secondCompanyCarImpl.setExpectedLastPlateNumber(expectedLastPlateNumber);
		}

		if (positionCostCenterId == null) {
			secondCompanyCarImpl.setPositionCostCenterId(StringPool.BLANK);
		}
		else {
			secondCompanyCarImpl.setPositionCostCenterId(positionCostCenterId);
		}

		if (employeeGroupId == null) {
			secondCompanyCarImpl.setEmployeeGroupId(StringPool.BLANK);
		}
		else {
			secondCompanyCarImpl.setEmployeeGroupId(employeeGroupId);
		}

		if (contractEndDate == Long.MIN_VALUE) {
			secondCompanyCarImpl.setContractEndDate(null);
		}
		else {
			secondCompanyCarImpl.setContractEndDate(new Date(contractEndDate));
		}

		if (mobilePhone == null) {
			secondCompanyCarImpl.setMobilePhone(StringPool.BLANK);
		}
		else {
			secondCompanyCarImpl.setMobilePhone(mobilePhone);
		}

		if (officePhone == null) {
			secondCompanyCarImpl.setOfficePhone(StringPool.BLANK);
		}
		else {
			secondCompanyCarImpl.setOfficePhone(officePhone);
		}

		if (email == null) {
			secondCompanyCarImpl.setEmail(StringPool.BLANK);
		}
		else {
			secondCompanyCarImpl.setEmail(email);
		}

		secondCompanyCarImpl.setIsApplicantAgent(isApplicantAgent);
		secondCompanyCarImpl.setIsApproverAgent(isApproverAgent);
		secondCompanyCarImpl.setDrivingLicenseInformation(drivingLicenseInformation);

		if (estimatedObtainingDate == Long.MIN_VALUE) {
			secondCompanyCarImpl.setEstimatedObtainingDate(null);
		}
		else {
			secondCompanyCarImpl.setEstimatedObtainingDate(new Date(
					estimatedObtainingDate));
		}

		if (comments == null) {
			secondCompanyCarImpl.setComments(StringPool.BLANK);
		}
		else {
			secondCompanyCarImpl.setComments(comments);
		}

		if (processType == null) {
			secondCompanyCarImpl.setProcessType(StringPool.BLANK);
		}
		else {
			secondCompanyCarImpl.setProcessType(processType);
		}

		if (subType == null) {
			secondCompanyCarImpl.setSubType(StringPool.BLANK);
		}
		else {
			secondCompanyCarImpl.setSubType(subType);
		}

		secondCompanyCarImpl.resetOriginalValues();

		return secondCompanyCarImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		secondCompanyCarId = objectInput.readLong();
		ticketNo = objectInput.readUTF();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		submittedDate = objectInput.readLong();
		companyId = objectInput.readLong();
		name = objectInput.readUTF();
		staffCode = objectInput.readLong();
		division = objectInput.readUTF();
		department = objectInput.readUTF();
		status = objectInput.readInt();
		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		companyName = objectInput.readUTF();
		statusDate = objectInput.readLong();
		contactNo = objectInput.readUTF();
		workingLocation = objectInput.readUTF();
		officeSite = objectInput.readUTF();
		currentCarModel = objectInput.readUTF();
		currentCarColor = objectInput.readUTF();
		currentPlateNumber = objectInput.readUTF();
		acquiringDate = objectInput.readLong();
		expectedCarModel = objectInput.readUTF();
		expectedCarColor = objectInput.readUTF();
		expectedLastPlateNumber = objectInput.readUTF();
		positionCostCenterId = objectInput.readUTF();
		employeeGroupId = objectInput.readUTF();
		contractEndDate = objectInput.readLong();
		mobilePhone = objectInput.readUTF();
		officePhone = objectInput.readUTF();
		email = objectInput.readUTF();
		isApplicantAgent = objectInput.readBoolean();
		isApproverAgent = objectInput.readBoolean();
		drivingLicenseInformation = objectInput.readInt();
		estimatedObtainingDate = objectInput.readLong();
		comments = objectInput.readUTF();
		processType = objectInput.readUTF();
		subType = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(secondCompanyCarId);

		if (ticketNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ticketNo);
		}

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
		objectOutput.writeLong(submittedDate);
		objectOutput.writeLong(companyId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(staffCode);

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

		objectOutput.writeInt(status);
		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		if (companyName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(companyName);
		}

		objectOutput.writeLong(statusDate);

		if (contactNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contactNo);
		}

		if (workingLocation == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(workingLocation);
		}

		if (officeSite == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(officeSite);
		}

		if (currentCarModel == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(currentCarModel);
		}

		if (currentCarColor == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(currentCarColor);
		}

		if (currentPlateNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(currentPlateNumber);
		}

		objectOutput.writeLong(acquiringDate);

		if (expectedCarModel == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(expectedCarModel);
		}

		if (expectedCarColor == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(expectedCarColor);
		}

		if (expectedLastPlateNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(expectedLastPlateNumber);
		}

		if (positionCostCenterId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(positionCostCenterId);
		}

		if (employeeGroupId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(employeeGroupId);
		}

		objectOutput.writeLong(contractEndDate);

		if (mobilePhone == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(mobilePhone);
		}

		if (officePhone == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(officePhone);
		}

		if (email == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(email);
		}

		objectOutput.writeBoolean(isApplicantAgent);
		objectOutput.writeBoolean(isApproverAgent);
		objectOutput.writeInt(drivingLicenseInformation);
		objectOutput.writeLong(estimatedObtainingDate);

		if (comments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(comments);
		}

		if (processType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(processType);
		}

		if (subType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(subType);
		}
	}

	public long secondCompanyCarId;
	public String ticketNo;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long submittedDate;
	public long companyId;
	public String name;
	public long staffCode;
	public String division;
	public String department;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public String companyName;
	public long statusDate;
	public String contactNo;
	public String workingLocation;
	public String officeSite;
	public String currentCarModel;
	public String currentCarColor;
	public String currentPlateNumber;
	public long acquiringDate;
	public String expectedCarModel;
	public String expectedCarColor;
	public String expectedLastPlateNumber;
	public String positionCostCenterId;
	public String employeeGroupId;
	public long contractEndDate;
	public String mobilePhone;
	public String officePhone;
	public String email;
	public boolean isApplicantAgent;
	public boolean isApproverAgent;
	public int drivingLicenseInformation;
	public long estimatedObtainingDate;
	public String comments;
	public String processType;
	public String subType;
}