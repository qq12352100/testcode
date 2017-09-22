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

import com.company.car.model.FirstCompanyCar;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FirstCompanyCar in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see FirstCompanyCar
 * @generated
 */
public class FirstCompanyCarCacheModel implements CacheModel<FirstCompanyCar>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(85);

		sb.append("{firstCompanyCarId=");
		sb.append(firstCompanyCarId);
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
		sb.append(", childrenNumber=");
		sb.append(childrenNumber);
		sb.append(", processType=");
		sb.append(processType);
		sb.append(", subType=");
		sb.append(subType);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FirstCompanyCar toEntityModel() {
		FirstCompanyCarImpl firstCompanyCarImpl = new FirstCompanyCarImpl();

		firstCompanyCarImpl.setFirstCompanyCarId(firstCompanyCarId);

		if (ticketNo == null) {
			firstCompanyCarImpl.setTicketNo(StringPool.BLANK);
		}
		else {
			firstCompanyCarImpl.setTicketNo(ticketNo);
		}

		firstCompanyCarImpl.setGroupId(groupId);
		firstCompanyCarImpl.setUserId(userId);

		if (userName == null) {
			firstCompanyCarImpl.setUserName(StringPool.BLANK);
		}
		else {
			firstCompanyCarImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			firstCompanyCarImpl.setCreateDate(null);
		}
		else {
			firstCompanyCarImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			firstCompanyCarImpl.setModifiedDate(null);
		}
		else {
			firstCompanyCarImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (submittedDate == Long.MIN_VALUE) {
			firstCompanyCarImpl.setSubmittedDate(null);
		}
		else {
			firstCompanyCarImpl.setSubmittedDate(new Date(submittedDate));
		}

		firstCompanyCarImpl.setCompanyId(companyId);

		if (name == null) {
			firstCompanyCarImpl.setName(StringPool.BLANK);
		}
		else {
			firstCompanyCarImpl.setName(name);
		}

		firstCompanyCarImpl.setStaffCode(staffCode);

		if (division == null) {
			firstCompanyCarImpl.setDivision(StringPool.BLANK);
		}
		else {
			firstCompanyCarImpl.setDivision(division);
		}

		if (department == null) {
			firstCompanyCarImpl.setDepartment(StringPool.BLANK);
		}
		else {
			firstCompanyCarImpl.setDepartment(department);
		}

		firstCompanyCarImpl.setStatus(status);
		firstCompanyCarImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			firstCompanyCarImpl.setStatusByUserName(StringPool.BLANK);
		}
		else {
			firstCompanyCarImpl.setStatusByUserName(statusByUserName);
		}

		if (companyName == null) {
			firstCompanyCarImpl.setCompanyName(StringPool.BLANK);
		}
		else {
			firstCompanyCarImpl.setCompanyName(companyName);
		}

		if (statusDate == Long.MIN_VALUE) {
			firstCompanyCarImpl.setStatusDate(null);
		}
		else {
			firstCompanyCarImpl.setStatusDate(new Date(statusDate));
		}

		if (contactNo == null) {
			firstCompanyCarImpl.setContactNo(StringPool.BLANK);
		}
		else {
			firstCompanyCarImpl.setContactNo(contactNo);
		}

		if (workingLocation == null) {
			firstCompanyCarImpl.setWorkingLocation(StringPool.BLANK);
		}
		else {
			firstCompanyCarImpl.setWorkingLocation(workingLocation);
		}

		if (officeSite == null) {
			firstCompanyCarImpl.setOfficeSite(StringPool.BLANK);
		}
		else {
			firstCompanyCarImpl.setOfficeSite(officeSite);
		}

		if (currentCarModel == null) {
			firstCompanyCarImpl.setCurrentCarModel(StringPool.BLANK);
		}
		else {
			firstCompanyCarImpl.setCurrentCarModel(currentCarModel);
		}

		if (currentCarColor == null) {
			firstCompanyCarImpl.setCurrentCarColor(StringPool.BLANK);
		}
		else {
			firstCompanyCarImpl.setCurrentCarColor(currentCarColor);
		}

		if (currentPlateNumber == null) {
			firstCompanyCarImpl.setCurrentPlateNumber(StringPool.BLANK);
		}
		else {
			firstCompanyCarImpl.setCurrentPlateNumber(currentPlateNumber);
		}

		if (acquiringDate == Long.MIN_VALUE) {
			firstCompanyCarImpl.setAcquiringDate(null);
		}
		else {
			firstCompanyCarImpl.setAcquiringDate(new Date(acquiringDate));
		}

		if (expectedCarModel == null) {
			firstCompanyCarImpl.setExpectedCarModel(StringPool.BLANK);
		}
		else {
			firstCompanyCarImpl.setExpectedCarModel(expectedCarModel);
		}

		if (expectedCarColor == null) {
			firstCompanyCarImpl.setExpectedCarColor(StringPool.BLANK);
		}
		else {
			firstCompanyCarImpl.setExpectedCarColor(expectedCarColor);
		}

		if (expectedLastPlateNumber == null) {
			firstCompanyCarImpl.setExpectedLastPlateNumber(StringPool.BLANK);
		}
		else {
			firstCompanyCarImpl.setExpectedLastPlateNumber(expectedLastPlateNumber);
		}

		if (positionCostCenterId == null) {
			firstCompanyCarImpl.setPositionCostCenterId(StringPool.BLANK);
		}
		else {
			firstCompanyCarImpl.setPositionCostCenterId(positionCostCenterId);
		}

		if (employeeGroupId == null) {
			firstCompanyCarImpl.setEmployeeGroupId(StringPool.BLANK);
		}
		else {
			firstCompanyCarImpl.setEmployeeGroupId(employeeGroupId);
		}

		if (contractEndDate == Long.MIN_VALUE) {
			firstCompanyCarImpl.setContractEndDate(null);
		}
		else {
			firstCompanyCarImpl.setContractEndDate(new Date(contractEndDate));
		}

		if (mobilePhone == null) {
			firstCompanyCarImpl.setMobilePhone(StringPool.BLANK);
		}
		else {
			firstCompanyCarImpl.setMobilePhone(mobilePhone);
		}

		if (officePhone == null) {
			firstCompanyCarImpl.setOfficePhone(StringPool.BLANK);
		}
		else {
			firstCompanyCarImpl.setOfficePhone(officePhone);
		}

		if (email == null) {
			firstCompanyCarImpl.setEmail(StringPool.BLANK);
		}
		else {
			firstCompanyCarImpl.setEmail(email);
		}

		firstCompanyCarImpl.setIsApplicantAgent(isApplicantAgent);
		firstCompanyCarImpl.setIsApproverAgent(isApproverAgent);
		firstCompanyCarImpl.setDrivingLicenseInformation(drivingLicenseInformation);

		if (estimatedObtainingDate == Long.MIN_VALUE) {
			firstCompanyCarImpl.setEstimatedObtainingDate(null);
		}
		else {
			firstCompanyCarImpl.setEstimatedObtainingDate(new Date(
					estimatedObtainingDate));
		}

		if (comments == null) {
			firstCompanyCarImpl.setComments(StringPool.BLANK);
		}
		else {
			firstCompanyCarImpl.setComments(comments);
		}

		firstCompanyCarImpl.setChildrenNumber(childrenNumber);

		if (processType == null) {
			firstCompanyCarImpl.setProcessType(StringPool.BLANK);
		}
		else {
			firstCompanyCarImpl.setProcessType(processType);
		}

		if (subType == null) {
			firstCompanyCarImpl.setSubType(StringPool.BLANK);
		}
		else {
			firstCompanyCarImpl.setSubType(subType);
		}

		firstCompanyCarImpl.resetOriginalValues();

		return firstCompanyCarImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		firstCompanyCarId = objectInput.readLong();
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
		childrenNumber = objectInput.readInt();
		processType = objectInput.readUTF();
		subType = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(firstCompanyCarId);

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

		objectOutput.writeInt(childrenNumber);

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

	public long firstCompanyCarId;
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
	public int childrenNumber;
	public String processType;
	public String subType;
}