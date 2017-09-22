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

package com.e.onboarding.model.impl;

import com.e.onboarding.model.EOnBoarding;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EOnBoarding in entity cache.
 *
 * @author sanguine
 * @see EOnBoarding
 * @generated
 */
public class EOnBoardingCacheModel implements CacheModel<EOnBoarding>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(119);

		sb.append("{eOnBoardingId=");
		sb.append(eOnBoardingId);
		sb.append(", ticketNo=");
		sb.append(ticketNo);
		sb.append(", processType=");
		sb.append(processType);
		sb.append(", subType=");
		sb.append(subType);
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
		sb.append(", submittedDate=");
		sb.append(submittedDate);
		sb.append(", modifiedUserId=");
		sb.append(modifiedUserId);
		sb.append(", modifiedUserName=");
		sb.append(modifiedUserName);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", staffCode=");
		sb.append(staffCode);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", name=");
		sb.append(name);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", birthday=");
		sb.append(birthday);
		sb.append(", photoPath=");
		sb.append(photoPath);
		sb.append(", contractType=");
		sb.append(contractType);
		sb.append(", workLocation=");
		sb.append(workLocation);
		sb.append(", division=");
		sb.append(division);
		sb.append(", officeSite=");
		sb.append(officeSite);
		sb.append(", department=");
		sb.append(department);
		sb.append(", startingDate=");
		sb.append(startingDate);
		sb.append(", positionCode=");
		sb.append(positionCode);
		sb.append(", serviceLength=");
		sb.append(serviceLength);
		sb.append(", functionName=");
		sb.append(functionName);
		sb.append(", reportTo=");
		sb.append(reportTo);
		sb.append(", reportToStaffName=");
		sb.append(reportToStaffName);
		sb.append(", title=");
		sb.append(title);
		sb.append(", costCenter=");
		sb.append(costCenter);
		sb.append(", itRelatedHardware=");
		sb.append(itRelatedHardware);
		sb.append(", companyCar=");
		sb.append(companyCar);
		sb.append(", replacement=");
		sb.append(replacement);
		sb.append(", nameOfReplacedPerson=");
		sb.append(nameOfReplacedPerson);
		sb.append(", contactInfo=");
		sb.append(contactInfo);
		sb.append(", comments=");
		sb.append(comments);
		sb.append(", isApplicantAgent=");
		sb.append(isApplicantAgent);
		sb.append(", isApproverAgent=");
		sb.append(isApproverAgent);
		sb.append(", adminEntitlement=");
		sb.append(adminEntitlement);
		sb.append(", adminSeatNo=");
		sb.append(adminSeatNo);
		sb.append(", adminTasks=");
		sb.append(adminTasks);
		sb.append(", adminStatus=");
		sb.append(adminStatus);
		sb.append(", adminComments=");
		sb.append(adminComments);
		sb.append(", securityTasks=");
		sb.append(securityTasks);
		sb.append(", securityStatus=");
		sb.append(securityStatus);
		sb.append(", securityComments=");
		sb.append(securityComments);
		sb.append(", itpTasks=");
		sb.append(itpTasks);
		sb.append(", itpStatus=");
		sb.append(itpStatus);
		sb.append(", iptComments=");
		sb.append(iptComments);
		sb.append(", financeTasks=");
		sb.append(financeTasks);
		sb.append(", financeStatus=");
		sb.append(financeStatus);
		sb.append(", financeComments=");
		sb.append(financeComments);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EOnBoarding toEntityModel() {
		EOnBoardingImpl eOnBoardingImpl = new EOnBoardingImpl();

		eOnBoardingImpl.setEOnBoardingId(eOnBoardingId);

		if (ticketNo == null) {
			eOnBoardingImpl.setTicketNo(StringPool.BLANK);
		}
		else {
			eOnBoardingImpl.setTicketNo(ticketNo);
		}

		if (processType == null) {
			eOnBoardingImpl.setProcessType(StringPool.BLANK);
		}
		else {
			eOnBoardingImpl.setProcessType(processType);
		}

		if (subType == null) {
			eOnBoardingImpl.setSubType(StringPool.BLANK);
		}
		else {
			eOnBoardingImpl.setSubType(subType);
		}

		eOnBoardingImpl.setGroupId(groupId);
		eOnBoardingImpl.setCompanyId(companyId);
		eOnBoardingImpl.setUserId(userId);

		if (userName == null) {
			eOnBoardingImpl.setUserName(StringPool.BLANK);
		}
		else {
			eOnBoardingImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			eOnBoardingImpl.setCreateDate(null);
		}
		else {
			eOnBoardingImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			eOnBoardingImpl.setModifiedDate(null);
		}
		else {
			eOnBoardingImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (submittedDate == Long.MIN_VALUE) {
			eOnBoardingImpl.setSubmittedDate(null);
		}
		else {
			eOnBoardingImpl.setSubmittedDate(new Date(submittedDate));
		}

		eOnBoardingImpl.setModifiedUserId(modifiedUserId);

		if (modifiedUserName == null) {
			eOnBoardingImpl.setModifiedUserName(StringPool.BLANK);
		}
		else {
			eOnBoardingImpl.setModifiedUserName(modifiedUserName);
		}

		eOnBoardingImpl.setStatus(status);
		eOnBoardingImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			eOnBoardingImpl.setStatusByUserName(StringPool.BLANK);
		}
		else {
			eOnBoardingImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			eOnBoardingImpl.setStatusDate(null);
		}
		else {
			eOnBoardingImpl.setStatusDate(new Date(statusDate));
		}

		if (staffCode == null) {
			eOnBoardingImpl.setStaffCode(StringPool.BLANK);
		}
		else {
			eOnBoardingImpl.setStaffCode(staffCode);
		}

		if (lastName == null) {
			eOnBoardingImpl.setLastName(StringPool.BLANK);
		}
		else {
			eOnBoardingImpl.setLastName(lastName);
		}

		if (firstName == null) {
			eOnBoardingImpl.setFirstName(StringPool.BLANK);
		}
		else {
			eOnBoardingImpl.setFirstName(firstName);
		}

		if (name == null) {
			eOnBoardingImpl.setName(StringPool.BLANK);
		}
		else {
			eOnBoardingImpl.setName(name);
		}

		if (gender == null) {
			eOnBoardingImpl.setGender(StringPool.BLANK);
		}
		else {
			eOnBoardingImpl.setGender(gender);
		}

		if (birthday == Long.MIN_VALUE) {
			eOnBoardingImpl.setBirthday(null);
		}
		else {
			eOnBoardingImpl.setBirthday(new Date(birthday));
		}

		if (photoPath == null) {
			eOnBoardingImpl.setPhotoPath(StringPool.BLANK);
		}
		else {
			eOnBoardingImpl.setPhotoPath(photoPath);
		}

		if (contractType == null) {
			eOnBoardingImpl.setContractType(StringPool.BLANK);
		}
		else {
			eOnBoardingImpl.setContractType(contractType);
		}

		if (workLocation == null) {
			eOnBoardingImpl.setWorkLocation(StringPool.BLANK);
		}
		else {
			eOnBoardingImpl.setWorkLocation(workLocation);
		}

		if (division == null) {
			eOnBoardingImpl.setDivision(StringPool.BLANK);
		}
		else {
			eOnBoardingImpl.setDivision(division);
		}

		if (officeSite == null) {
			eOnBoardingImpl.setOfficeSite(StringPool.BLANK);
		}
		else {
			eOnBoardingImpl.setOfficeSite(officeSite);
		}

		if (department == null) {
			eOnBoardingImpl.setDepartment(StringPool.BLANK);
		}
		else {
			eOnBoardingImpl.setDepartment(department);
		}

		if (startingDate == Long.MIN_VALUE) {
			eOnBoardingImpl.setStartingDate(null);
		}
		else {
			eOnBoardingImpl.setStartingDate(new Date(startingDate));
		}

		if (positionCode == null) {
			eOnBoardingImpl.setPositionCode(StringPool.BLANK);
		}
		else {
			eOnBoardingImpl.setPositionCode(positionCode);
		}

		if (serviceLength == null) {
			eOnBoardingImpl.setServiceLength(StringPool.BLANK);
		}
		else {
			eOnBoardingImpl.setServiceLength(serviceLength);
		}

		if (functionName == null) {
			eOnBoardingImpl.setFunctionName(StringPool.BLANK);
		}
		else {
			eOnBoardingImpl.setFunctionName(functionName);
		}

		if (reportTo == null) {
			eOnBoardingImpl.setReportTo(StringPool.BLANK);
		}
		else {
			eOnBoardingImpl.setReportTo(reportTo);
		}

		if (reportToStaffName == null) {
			eOnBoardingImpl.setReportToStaffName(StringPool.BLANK);
		}
		else {
			eOnBoardingImpl.setReportToStaffName(reportToStaffName);
		}

		if (title == null) {
			eOnBoardingImpl.setTitle(StringPool.BLANK);
		}
		else {
			eOnBoardingImpl.setTitle(title);
		}

		if (costCenter == null) {
			eOnBoardingImpl.setCostCenter(StringPool.BLANK);
		}
		else {
			eOnBoardingImpl.setCostCenter(costCenter);
		}

		eOnBoardingImpl.setItRelatedHardware(itRelatedHardware);
		eOnBoardingImpl.setCompanyCar(companyCar);
		eOnBoardingImpl.setReplacement(replacement);

		if (nameOfReplacedPerson == null) {
			eOnBoardingImpl.setNameOfReplacedPerson(StringPool.BLANK);
		}
		else {
			eOnBoardingImpl.setNameOfReplacedPerson(nameOfReplacedPerson);
		}

		if (contactInfo == null) {
			eOnBoardingImpl.setContactInfo(StringPool.BLANK);
		}
		else {
			eOnBoardingImpl.setContactInfo(contactInfo);
		}

		if (comments == null) {
			eOnBoardingImpl.setComments(StringPool.BLANK);
		}
		else {
			eOnBoardingImpl.setComments(comments);
		}

		eOnBoardingImpl.setIsApplicantAgent(isApplicantAgent);
		eOnBoardingImpl.setIsApproverAgent(isApproverAgent);

		if (adminEntitlement == null) {
			eOnBoardingImpl.setAdminEntitlement(StringPool.BLANK);
		}
		else {
			eOnBoardingImpl.setAdminEntitlement(adminEntitlement);
		}

		if (adminSeatNo == null) {
			eOnBoardingImpl.setAdminSeatNo(StringPool.BLANK);
		}
		else {
			eOnBoardingImpl.setAdminSeatNo(adminSeatNo);
		}

		if (adminTasks == null) {
			eOnBoardingImpl.setAdminTasks(StringPool.BLANK);
		}
		else {
			eOnBoardingImpl.setAdminTasks(adminTasks);
		}

		if (adminStatus == null) {
			eOnBoardingImpl.setAdminStatus(StringPool.BLANK);
		}
		else {
			eOnBoardingImpl.setAdminStatus(adminStatus);
		}

		if (adminComments == null) {
			eOnBoardingImpl.setAdminComments(StringPool.BLANK);
		}
		else {
			eOnBoardingImpl.setAdminComments(adminComments);
		}

		if (securityTasks == null) {
			eOnBoardingImpl.setSecurityTasks(StringPool.BLANK);
		}
		else {
			eOnBoardingImpl.setSecurityTasks(securityTasks);
		}

		if (securityStatus == null) {
			eOnBoardingImpl.setSecurityStatus(StringPool.BLANK);
		}
		else {
			eOnBoardingImpl.setSecurityStatus(securityStatus);
		}

		if (securityComments == null) {
			eOnBoardingImpl.setSecurityComments(StringPool.BLANK);
		}
		else {
			eOnBoardingImpl.setSecurityComments(securityComments);
		}

		if (itpTasks == null) {
			eOnBoardingImpl.setItpTasks(StringPool.BLANK);
		}
		else {
			eOnBoardingImpl.setItpTasks(itpTasks);
		}

		if (itpStatus == null) {
			eOnBoardingImpl.setItpStatus(StringPool.BLANK);
		}
		else {
			eOnBoardingImpl.setItpStatus(itpStatus);
		}

		if (iptComments == null) {
			eOnBoardingImpl.setIptComments(StringPool.BLANK);
		}
		else {
			eOnBoardingImpl.setIptComments(iptComments);
		}

		if (financeTasks == null) {
			eOnBoardingImpl.setFinanceTasks(StringPool.BLANK);
		}
		else {
			eOnBoardingImpl.setFinanceTasks(financeTasks);
		}

		if (financeStatus == null) {
			eOnBoardingImpl.setFinanceStatus(StringPool.BLANK);
		}
		else {
			eOnBoardingImpl.setFinanceStatus(financeStatus);
		}

		if (financeComments == null) {
			eOnBoardingImpl.setFinanceComments(StringPool.BLANK);
		}
		else {
			eOnBoardingImpl.setFinanceComments(financeComments);
		}

		eOnBoardingImpl.resetOriginalValues();

		return eOnBoardingImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		eOnBoardingId = objectInput.readLong();
		ticketNo = objectInput.readUTF();
		processType = objectInput.readUTF();
		subType = objectInput.readUTF();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		submittedDate = objectInput.readLong();
		modifiedUserId = objectInput.readLong();
		modifiedUserName = objectInput.readUTF();
		status = objectInput.readInt();
		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
		staffCode = objectInput.readUTF();
		lastName = objectInput.readUTF();
		firstName = objectInput.readUTF();
		name = objectInput.readUTF();
		gender = objectInput.readUTF();
		birthday = objectInput.readLong();
		photoPath = objectInput.readUTF();
		contractType = objectInput.readUTF();
		workLocation = objectInput.readUTF();
		division = objectInput.readUTF();
		officeSite = objectInput.readUTF();
		department = objectInput.readUTF();
		startingDate = objectInput.readLong();
		positionCode = objectInput.readUTF();
		serviceLength = objectInput.readUTF();
		functionName = objectInput.readUTF();
		reportTo = objectInput.readUTF();
		reportToStaffName = objectInput.readUTF();
		title = objectInput.readUTF();
		costCenter = objectInput.readUTF();
		itRelatedHardware = objectInput.readBoolean();
		companyCar = objectInput.readBoolean();
		replacement = objectInput.readBoolean();
		nameOfReplacedPerson = objectInput.readUTF();
		contactInfo = objectInput.readUTF();
		comments = objectInput.readUTF();
		isApplicantAgent = objectInput.readBoolean();
		isApproverAgent = objectInput.readBoolean();
		adminEntitlement = objectInput.readUTF();
		adminSeatNo = objectInput.readUTF();
		adminTasks = objectInput.readUTF();
		adminStatus = objectInput.readUTF();
		adminComments = objectInput.readUTF();
		securityTasks = objectInput.readUTF();
		securityStatus = objectInput.readUTF();
		securityComments = objectInput.readUTF();
		itpTasks = objectInput.readUTF();
		itpStatus = objectInput.readUTF();
		iptComments = objectInput.readUTF();
		financeTasks = objectInput.readUTF();
		financeStatus = objectInput.readUTF();
		financeComments = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(eOnBoardingId);

		if (ticketNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ticketNo);
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
		objectOutput.writeLong(submittedDate);
		objectOutput.writeLong(modifiedUserId);

		if (modifiedUserName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(modifiedUserName);
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

		if (staffCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(staffCode);
		}

		if (lastName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		if (firstName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (gender == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(gender);
		}

		objectOutput.writeLong(birthday);

		if (photoPath == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(photoPath);
		}

		if (contractType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contractType);
		}

		if (workLocation == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(workLocation);
		}

		if (division == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(division);
		}

		if (officeSite == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(officeSite);
		}

		if (department == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(department);
		}

		objectOutput.writeLong(startingDate);

		if (positionCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(positionCode);
		}

		if (serviceLength == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(serviceLength);
		}

		if (functionName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(functionName);
		}

		if (reportTo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(reportTo);
		}

		if (reportToStaffName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(reportToStaffName);
		}

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (costCenter == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(costCenter);
		}

		objectOutput.writeBoolean(itRelatedHardware);
		objectOutput.writeBoolean(companyCar);
		objectOutput.writeBoolean(replacement);

		if (nameOfReplacedPerson == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nameOfReplacedPerson);
		}

		if (contactInfo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contactInfo);
		}

		if (comments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(comments);
		}

		objectOutput.writeBoolean(isApplicantAgent);
		objectOutput.writeBoolean(isApproverAgent);

		if (adminEntitlement == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(adminEntitlement);
		}

		if (adminSeatNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(adminSeatNo);
		}

		if (adminTasks == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(adminTasks);
		}

		if (adminStatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(adminStatus);
		}

		if (adminComments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(adminComments);
		}

		if (securityTasks == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(securityTasks);
		}

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

		if (itpTasks == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(itpTasks);
		}

		if (itpStatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(itpStatus);
		}

		if (iptComments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(iptComments);
		}

		if (financeTasks == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(financeTasks);
		}

		if (financeStatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(financeStatus);
		}

		if (financeComments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(financeComments);
		}
	}

	public long eOnBoardingId;
	public String ticketNo;
	public String processType;
	public String subType;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long submittedDate;
	public long modifiedUserId;
	public String modifiedUserName;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public String staffCode;
	public String lastName;
	public String firstName;
	public String name;
	public String gender;
	public long birthday;
	public String photoPath;
	public String contractType;
	public String workLocation;
	public String division;
	public String officeSite;
	public String department;
	public long startingDate;
	public String positionCode;
	public String serviceLength;
	public String functionName;
	public String reportTo;
	public String reportToStaffName;
	public String title;
	public String costCenter;
	public boolean itRelatedHardware;
	public boolean companyCar;
	public boolean replacement;
	public String nameOfReplacedPerson;
	public String contactInfo;
	public String comments;
	public boolean isApplicantAgent;
	public boolean isApproverAgent;
	public String adminEntitlement;
	public String adminSeatNo;
	public String adminTasks;
	public String adminStatus;
	public String adminComments;
	public String securityTasks;
	public String securityStatus;
	public String securityComments;
	public String itpTasks;
	public String itpStatus;
	public String iptComments;
	public String financeTasks;
	public String financeStatus;
	public String financeComments;
}