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

package com.seatoffice.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.seatoffice.model.SeatOffice;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SeatOffice in entity cache.
 *
 * @author Alice.zou
 * @see SeatOffice
 * @generated
 */
public class SeatOfficeCacheModel implements CacheModel<SeatOffice>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(95);

		sb.append("{seatId=");
		sb.append(seatId);
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
		sb.append(", companyName=");
		sb.append(companyName);
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
		sb.append(", officeSite=");
		sb.append(officeSite);
		sb.append(", currentCategory=");
		sb.append(currentCategory);
		sb.append(", currentSeatNo=");
		sb.append(currentSeatNo);
		sb.append(", movingDate=");
		sb.append(movingDate);
		sb.append(", expectedSeatNo=");
		sb.append(expectedSeatNo);
		sb.append(", reasonForChange=");
		sb.append(reasonForChange);
		sb.append(", officeKey=");
		sb.append(officeKey);
		sb.append(", plant=");
		sb.append(plant);
		sb.append(", telephoneAndExtNo=");
		sb.append(telephoneAndExtNo);
		sb.append(", namePlate=");
		sb.append(namePlate);
		sb.append(", cabinet=");
		sb.append(cabinet);
		sb.append(", isOnBehalfOf=");
		sb.append(isOnBehalfOf);
		sb.append(", nowCategory=");
		sb.append(nowCategory);
		sb.append(", newSeatNo=");
		sb.append(newSeatNo);
		sb.append(", workspaceId=");
		sb.append(workspaceId);
		sb.append(", seatStatus=");
		sb.append(seatStatus);
		sb.append(", sg=");
		sb.append(sg);
		sb.append(", leadingMark=");
		sb.append(leadingMark);
		sb.append(", positionFlag=");
		sb.append(positionFlag);
		sb.append(", isApplicantAgent=");
		sb.append(isApplicantAgent);
		sb.append(", isApproverAgent=");
		sb.append(isApproverAgent);
		sb.append(", candidateName=");
		sb.append(candidateName);
		sb.append(", desiredStartingDate=");
		sb.append(desiredStartingDate);
		sb.append(", comments=");
		sb.append(comments);
		sb.append(", contractType=");
		sb.append(contractType);
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
	public SeatOffice toEntityModel() {
		SeatOfficeImpl seatOfficeImpl = new SeatOfficeImpl();

		seatOfficeImpl.setSeatId(seatId);
		seatOfficeImpl.setGroupId(groupId);
		seatOfficeImpl.setUserId(userId);

		if (userName == null) {
			seatOfficeImpl.setUserName(StringPool.BLANK);
		}
		else {
			seatOfficeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			seatOfficeImpl.setCreateDate(null);
		}
		else {
			seatOfficeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			seatOfficeImpl.setModifiedDate(null);
		}
		else {
			seatOfficeImpl.setModifiedDate(new Date(modifiedDate));
		}

		seatOfficeImpl.setCompanyId(companyId);

		if (ticketNo == null) {
			seatOfficeImpl.setTicketNo(StringPool.BLANK);
		}
		else {
			seatOfficeImpl.setTicketNo(ticketNo);
		}

		if (staffName == null) {
			seatOfficeImpl.setStaffName(StringPool.BLANK);
		}
		else {
			seatOfficeImpl.setStaffName(staffName);
		}

		seatOfficeImpl.setStaffCode(staffCode);

		if (companyName == null) {
			seatOfficeImpl.setCompanyName(StringPool.BLANK);
		}
		else {
			seatOfficeImpl.setCompanyName(companyName);
		}

		if (division == null) {
			seatOfficeImpl.setDivision(StringPool.BLANK);
		}
		else {
			seatOfficeImpl.setDivision(division);
		}

		if (department == null) {
			seatOfficeImpl.setDepartment(StringPool.BLANK);
		}
		else {
			seatOfficeImpl.setDepartment(department);
		}

		if (costCenter == null) {
			seatOfficeImpl.setCostCenter(StringPool.BLANK);
		}
		else {
			seatOfficeImpl.setCostCenter(costCenter);
		}

		if (officePhone == null) {
			seatOfficeImpl.setOfficePhone(StringPool.BLANK);
		}
		else {
			seatOfficeImpl.setOfficePhone(officePhone);
		}

		if (mobilePhone == null) {
			seatOfficeImpl.setMobilePhone(StringPool.BLANK);
		}
		else {
			seatOfficeImpl.setMobilePhone(mobilePhone);
		}

		if (officeSite == null) {
			seatOfficeImpl.setOfficeSite(StringPool.BLANK);
		}
		else {
			seatOfficeImpl.setOfficeSite(officeSite);
		}

		seatOfficeImpl.setCurrentCategory(currentCategory);

		if (currentSeatNo == null) {
			seatOfficeImpl.setCurrentSeatNo(StringPool.BLANK);
		}
		else {
			seatOfficeImpl.setCurrentSeatNo(currentSeatNo);
		}

		if (movingDate == Long.MIN_VALUE) {
			seatOfficeImpl.setMovingDate(null);
		}
		else {
			seatOfficeImpl.setMovingDate(new Date(movingDate));
		}

		if (expectedSeatNo == null) {
			seatOfficeImpl.setExpectedSeatNo(StringPool.BLANK);
		}
		else {
			seatOfficeImpl.setExpectedSeatNo(expectedSeatNo);
		}

		if (reasonForChange == null) {
			seatOfficeImpl.setReasonForChange(StringPool.BLANK);
		}
		else {
			seatOfficeImpl.setReasonForChange(reasonForChange);
		}

		seatOfficeImpl.setOfficeKey(officeKey);
		seatOfficeImpl.setPlant(plant);
		seatOfficeImpl.setTelephoneAndExtNo(telephoneAndExtNo);
		seatOfficeImpl.setNamePlate(namePlate);
		seatOfficeImpl.setCabinet(cabinet);
		seatOfficeImpl.setIsOnBehalfOf(isOnBehalfOf);
		seatOfficeImpl.setNowCategory(nowCategory);

		if (newSeatNo == null) {
			seatOfficeImpl.setNewSeatNo(StringPool.BLANK);
		}
		else {
			seatOfficeImpl.setNewSeatNo(newSeatNo);
		}

		seatOfficeImpl.setWorkspaceId(workspaceId);

		if (seatStatus == null) {
			seatOfficeImpl.setSeatStatus(StringPool.BLANK);
		}
		else {
			seatOfficeImpl.setSeatStatus(seatStatus);
		}

		if (sg == null) {
			seatOfficeImpl.setSg(StringPool.BLANK);
		}
		else {
			seatOfficeImpl.setSg(sg);
		}

		if (leadingMark == null) {
			seatOfficeImpl.setLeadingMark(StringPool.BLANK);
		}
		else {
			seatOfficeImpl.setLeadingMark(leadingMark);
		}

		if (positionFlag == null) {
			seatOfficeImpl.setPositionFlag(StringPool.BLANK);
		}
		else {
			seatOfficeImpl.setPositionFlag(positionFlag);
		}

		seatOfficeImpl.setIsApplicantAgent(isApplicantAgent);
		seatOfficeImpl.setIsApproverAgent(isApproverAgent);

		if (candidateName == null) {
			seatOfficeImpl.setCandidateName(StringPool.BLANK);
		}
		else {
			seatOfficeImpl.setCandidateName(candidateName);
		}

		if (desiredStartingDate == Long.MIN_VALUE) {
			seatOfficeImpl.setDesiredStartingDate(null);
		}
		else {
			seatOfficeImpl.setDesiredStartingDate(new Date(desiredStartingDate));
		}

		if (comments == null) {
			seatOfficeImpl.setComments(StringPool.BLANK);
		}
		else {
			seatOfficeImpl.setComments(comments);
		}

		if (contractType == null) {
			seatOfficeImpl.setContractType(StringPool.BLANK);
		}
		else {
			seatOfficeImpl.setContractType(contractType);
		}

		if (processType == null) {
			seatOfficeImpl.setProcessType(StringPool.BLANK);
		}
		else {
			seatOfficeImpl.setProcessType(processType);
		}

		if (subProcessType == null) {
			seatOfficeImpl.setSubProcessType(StringPool.BLANK);
		}
		else {
			seatOfficeImpl.setSubProcessType(subProcessType);
		}

		seatOfficeImpl.setStatus(status);
		seatOfficeImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			seatOfficeImpl.setStatusByUserName(StringPool.BLANK);
		}
		else {
			seatOfficeImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			seatOfficeImpl.setStatusDate(null);
		}
		else {
			seatOfficeImpl.setStatusDate(new Date(statusDate));
		}

		seatOfficeImpl.resetOriginalValues();

		return seatOfficeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		seatId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		companyId = objectInput.readLong();
		ticketNo = objectInput.readUTF();
		staffName = objectInput.readUTF();
		staffCode = objectInput.readLong();
		companyName = objectInput.readUTF();
		division = objectInput.readUTF();
		department = objectInput.readUTF();
		costCenter = objectInput.readUTF();
		officePhone = objectInput.readUTF();
		mobilePhone = objectInput.readUTF();
		officeSite = objectInput.readUTF();
		currentCategory = objectInput.readLong();
		currentSeatNo = objectInput.readUTF();
		movingDate = objectInput.readLong();
		expectedSeatNo = objectInput.readUTF();
		reasonForChange = objectInput.readUTF();
		officeKey = objectInput.readBoolean();
		plant = objectInput.readBoolean();
		telephoneAndExtNo = objectInput.readBoolean();
		namePlate = objectInput.readBoolean();
		cabinet = objectInput.readBoolean();
		isOnBehalfOf = objectInput.readBoolean();
		nowCategory = objectInput.readLong();
		newSeatNo = objectInput.readUTF();
		workspaceId = objectInput.readLong();
		seatStatus = objectInput.readUTF();
		sg = objectInput.readUTF();
		leadingMark = objectInput.readUTF();
		positionFlag = objectInput.readUTF();
		isApplicantAgent = objectInput.readBoolean();
		isApproverAgent = objectInput.readBoolean();
		candidateName = objectInput.readUTF();
		desiredStartingDate = objectInput.readLong();
		comments = objectInput.readUTF();
		contractType = objectInput.readUTF();
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
		objectOutput.writeLong(seatId);
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

		objectOutput.writeLong(staffCode);

		if (companyName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(companyName);
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

		if (officeSite == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(officeSite);
		}

		objectOutput.writeLong(currentCategory);

		if (currentSeatNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(currentSeatNo);
		}

		objectOutput.writeLong(movingDate);

		if (expectedSeatNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(expectedSeatNo);
		}

		if (reasonForChange == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(reasonForChange);
		}

		objectOutput.writeBoolean(officeKey);
		objectOutput.writeBoolean(plant);
		objectOutput.writeBoolean(telephoneAndExtNo);
		objectOutput.writeBoolean(namePlate);
		objectOutput.writeBoolean(cabinet);
		objectOutput.writeBoolean(isOnBehalfOf);
		objectOutput.writeLong(nowCategory);

		if (newSeatNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(newSeatNo);
		}

		objectOutput.writeLong(workspaceId);

		if (seatStatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(seatStatus);
		}

		if (sg == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sg);
		}

		if (leadingMark == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(leadingMark);
		}

		if (positionFlag == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(positionFlag);
		}

		objectOutput.writeBoolean(isApplicantAgent);
		objectOutput.writeBoolean(isApproverAgent);

		if (candidateName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(candidateName);
		}

		objectOutput.writeLong(desiredStartingDate);

		if (comments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(comments);
		}

		if (contractType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contractType);
		}

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

	public long seatId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long companyId;
	public String ticketNo;
	public String staffName;
	public long staffCode;
	public String companyName;
	public String division;
	public String department;
	public String costCenter;
	public String officePhone;
	public String mobilePhone;
	public String officeSite;
	public long currentCategory;
	public String currentSeatNo;
	public long movingDate;
	public String expectedSeatNo;
	public String reasonForChange;
	public boolean officeKey;
	public boolean plant;
	public boolean telephoneAndExtNo;
	public boolean namePlate;
	public boolean cabinet;
	public boolean isOnBehalfOf;
	public long nowCategory;
	public String newSeatNo;
	public long workspaceId;
	public String seatStatus;
	public String sg;
	public String leadingMark;
	public String positionFlag;
	public boolean isApplicantAgent;
	public boolean isApproverAgent;
	public String candidateName;
	public long desiredStartingDate;
	public String comments;
	public String contractType;
	public String processType;
	public String subProcessType;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
}