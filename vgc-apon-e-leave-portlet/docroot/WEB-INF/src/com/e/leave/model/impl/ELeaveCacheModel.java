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

package com.e.leave.model.impl;

import com.e.leave.model.ELeave;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ELeave in entity cache.
 *
 * @author EZEYIFE
 * @see ELeave
 * @generated
 */
public class ELeaveCacheModel implements CacheModel<ELeave>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(65);

		sb.append("{eLeaveId=");
		sb.append(eLeaveId);
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
		sb.append(", staffCode=");
		sb.append(staffCode);
		sb.append(", company=");
		sb.append(company);
		sb.append(", division=");
		sb.append(division);
		sb.append(", department=");
		sb.append(department);
		sb.append(", costCenter=");
		sb.append(costCenter);
		sb.append(", officePhone=");
		sb.append(officePhone);
		sb.append(", mobilePhone=");
		sb.append(mobilePhone);
		sb.append(", email=");
		sb.append(email);
		sb.append(", positionType=");
		sb.append(positionType);
		sb.append(", isApplicantAgent=");
		sb.append(isApplicantAgent);
		sb.append(", isApproverAgent=");
		sb.append(isApproverAgent);
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
		sb.append(", totalLeaveEntitlement=");
		sb.append(totalLeaveEntitlement);
		sb.append(", totalDuration=");
		sb.append(totalDuration);
		sb.append(", remainingLeaveDaysBefore=");
		sb.append(remainingLeaveDaysBefore);
		sb.append(", remainingLeaveDaysAfter=");
		sb.append(remainingLeaveDaysAfter);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ELeave toEntityModel() {
		ELeaveImpl eLeaveImpl = new ELeaveImpl();

		eLeaveImpl.setELeaveId(eLeaveId);
		eLeaveImpl.setGroupId(groupId);
		eLeaveImpl.setUserId(userId);

		if (userName == null) {
			eLeaveImpl.setUserName(StringPool.BLANK);
		}
		else {
			eLeaveImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			eLeaveImpl.setCreateDate(null);
		}
		else {
			eLeaveImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			eLeaveImpl.setModifiedDate(null);
		}
		else {
			eLeaveImpl.setModifiedDate(new Date(modifiedDate));
		}

		eLeaveImpl.setCompanyId(companyId);

		if (ticketNo == null) {
			eLeaveImpl.setTicketNo(StringPool.BLANK);
		}
		else {
			eLeaveImpl.setTicketNo(ticketNo);
		}

		if (staffName == null) {
			eLeaveImpl.setStaffName(StringPool.BLANK);
		}
		else {
			eLeaveImpl.setStaffName(staffName);
		}

		if (staffCode == null) {
			eLeaveImpl.setStaffCode(StringPool.BLANK);
		}
		else {
			eLeaveImpl.setStaffCode(staffCode);
		}

		if (company == null) {
			eLeaveImpl.setCompany(StringPool.BLANK);
		}
		else {
			eLeaveImpl.setCompany(company);
		}

		if (division == null) {
			eLeaveImpl.setDivision(StringPool.BLANK);
		}
		else {
			eLeaveImpl.setDivision(division);
		}

		if (department == null) {
			eLeaveImpl.setDepartment(StringPool.BLANK);
		}
		else {
			eLeaveImpl.setDepartment(department);
		}

		if (costCenter == null) {
			eLeaveImpl.setCostCenter(StringPool.BLANK);
		}
		else {
			eLeaveImpl.setCostCenter(costCenter);
		}

		if (officePhone == null) {
			eLeaveImpl.setOfficePhone(StringPool.BLANK);
		}
		else {
			eLeaveImpl.setOfficePhone(officePhone);
		}

		if (mobilePhone == null) {
			eLeaveImpl.setMobilePhone(StringPool.BLANK);
		}
		else {
			eLeaveImpl.setMobilePhone(mobilePhone);
		}

		if (email == null) {
			eLeaveImpl.setEmail(StringPool.BLANK);
		}
		else {
			eLeaveImpl.setEmail(email);
		}

		if (positionType == null) {
			eLeaveImpl.setPositionType(StringPool.BLANK);
		}
		else {
			eLeaveImpl.setPositionType(positionType);
		}

		eLeaveImpl.setIsApplicantAgent(isApplicantAgent);
		eLeaveImpl.setIsApproverAgent(isApproverAgent);

		if (processType == null) {
			eLeaveImpl.setProcessType(StringPool.BLANK);
		}
		else {
			eLeaveImpl.setProcessType(processType);
		}

		if (subProcessType == null) {
			eLeaveImpl.setSubProcessType(StringPool.BLANK);
		}
		else {
			eLeaveImpl.setSubProcessType(subProcessType);
		}

		if (submittedDate == Long.MIN_VALUE) {
			eLeaveImpl.setSubmittedDate(null);
		}
		else {
			eLeaveImpl.setSubmittedDate(new Date(submittedDate));
		}

		if (comments == null) {
			eLeaveImpl.setComments(StringPool.BLANK);
		}
		else {
			eLeaveImpl.setComments(comments);
		}

		eLeaveImpl.setStatus(status);
		eLeaveImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			eLeaveImpl.setStatusByUserName(StringPool.BLANK);
		}
		else {
			eLeaveImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			eLeaveImpl.setStatusDate(null);
		}
		else {
			eLeaveImpl.setStatusDate(new Date(statusDate));
		}

		if (totalLeaveEntitlement == null) {
			eLeaveImpl.setTotalLeaveEntitlement(StringPool.BLANK);
		}
		else {
			eLeaveImpl.setTotalLeaveEntitlement(totalLeaveEntitlement);
		}

		if (totalDuration == null) {
			eLeaveImpl.setTotalDuration(StringPool.BLANK);
		}
		else {
			eLeaveImpl.setTotalDuration(totalDuration);
		}

		if (remainingLeaveDaysBefore == null) {
			eLeaveImpl.setRemainingLeaveDaysBefore(StringPool.BLANK);
		}
		else {
			eLeaveImpl.setRemainingLeaveDaysBefore(remainingLeaveDaysBefore);
		}

		if (remainingLeaveDaysAfter == null) {
			eLeaveImpl.setRemainingLeaveDaysAfter(StringPool.BLANK);
		}
		else {
			eLeaveImpl.setRemainingLeaveDaysAfter(remainingLeaveDaysAfter);
		}

		eLeaveImpl.resetOriginalValues();

		return eLeaveImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		eLeaveId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		companyId = objectInput.readLong();
		ticketNo = objectInput.readUTF();
		staffName = objectInput.readUTF();
		staffCode = objectInput.readUTF();
		company = objectInput.readUTF();
		division = objectInput.readUTF();
		department = objectInput.readUTF();
		costCenter = objectInput.readUTF();
		officePhone = objectInput.readUTF();
		mobilePhone = objectInput.readUTF();
		email = objectInput.readUTF();
		positionType = objectInput.readUTF();
		isApplicantAgent = objectInput.readBoolean();
		isApproverAgent = objectInput.readBoolean();
		processType = objectInput.readUTF();
		subProcessType = objectInput.readUTF();
		submittedDate = objectInput.readLong();
		comments = objectInput.readUTF();
		status = objectInput.readInt();
		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
		totalLeaveEntitlement = objectInput.readUTF();
		totalDuration = objectInput.readUTF();
		remainingLeaveDaysBefore = objectInput.readUTF();
		remainingLeaveDaysAfter = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(eLeaveId);
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

		if (staffCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(staffCode);
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

		if (officePhone == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(officePhone);
		}

		if (mobilePhone == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(mobilePhone);
		}

		if (email == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (positionType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(positionType);
		}

		objectOutput.writeBoolean(isApplicantAgent);
		objectOutput.writeBoolean(isApproverAgent);

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

		if (totalLeaveEntitlement == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(totalLeaveEntitlement);
		}

		if (totalDuration == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(totalDuration);
		}

		if (remainingLeaveDaysBefore == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(remainingLeaveDaysBefore);
		}

		if (remainingLeaveDaysAfter == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(remainingLeaveDaysAfter);
		}
	}

	public long eLeaveId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long companyId;
	public String ticketNo;
	public String staffName;
	public String staffCode;
	public String company;
	public String division;
	public String department;
	public String costCenter;
	public String officePhone;
	public String mobilePhone;
	public String email;
	public String positionType;
	public boolean isApplicantAgent;
	public boolean isApproverAgent;
	public String processType;
	public String subProcessType;
	public long submittedDate;
	public String comments;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public String totalLeaveEntitlement;
	public String totalDuration;
	public String remainingLeaveDaysBefore;
	public String remainingLeaveDaysAfter;
}