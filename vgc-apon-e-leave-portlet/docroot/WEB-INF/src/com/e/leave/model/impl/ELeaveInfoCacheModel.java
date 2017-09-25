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

import com.e.leave.model.ELeaveInfo;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ELeaveInfo in entity cache.
 *
 * @author EZEYIFE
 * @see ELeaveInfo
 * @generated
 */
public class ELeaveInfoCacheModel implements CacheModel<ELeaveInfo>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{eLeaveInfoId=");
		sb.append(eLeaveInfoId);
		sb.append(", eLeaveId=");
		sb.append(eLeaveId);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", startTime=");
		sb.append(startTime);
		sb.append(", endTime=");
		sb.append(endTime);
		sb.append(", typeOfLeave=");
		sb.append(typeOfLeave);
		sb.append(", typeOfLeaveId=");
		sb.append(typeOfLeaveId);
		sb.append(", absenceDays=");
		sb.append(absenceDays);
		sb.append(", remark=");
		sb.append(remark);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ELeaveInfo toEntityModel() {
		ELeaveInfoImpl eLeaveInfoImpl = new ELeaveInfoImpl();

		eLeaveInfoImpl.setELeaveInfoId(eLeaveInfoId);
		eLeaveInfoImpl.setELeaveId(eLeaveId);

		if (startDate == Long.MIN_VALUE) {
			eLeaveInfoImpl.setStartDate(null);
		}
		else {
			eLeaveInfoImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			eLeaveInfoImpl.setEndDate(null);
		}
		else {
			eLeaveInfoImpl.setEndDate(new Date(endDate));
		}

		if (startTime == null) {
			eLeaveInfoImpl.setStartTime(StringPool.BLANK);
		}
		else {
			eLeaveInfoImpl.setStartTime(startTime);
		}

		if (endTime == null) {
			eLeaveInfoImpl.setEndTime(StringPool.BLANK);
		}
		else {
			eLeaveInfoImpl.setEndTime(endTime);
		}

		if (typeOfLeave == null) {
			eLeaveInfoImpl.setTypeOfLeave(StringPool.BLANK);
		}
		else {
			eLeaveInfoImpl.setTypeOfLeave(typeOfLeave);
		}

		if (typeOfLeaveId == null) {
			eLeaveInfoImpl.setTypeOfLeaveId(StringPool.BLANK);
		}
		else {
			eLeaveInfoImpl.setTypeOfLeaveId(typeOfLeaveId);
		}

		if (absenceDays == null) {
			eLeaveInfoImpl.setAbsenceDays(StringPool.BLANK);
		}
		else {
			eLeaveInfoImpl.setAbsenceDays(absenceDays);
		}

		if (remark == null) {
			eLeaveInfoImpl.setRemark(StringPool.BLANK);
		}
		else {
			eLeaveInfoImpl.setRemark(remark);
		}

		eLeaveInfoImpl.resetOriginalValues();

		return eLeaveInfoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		eLeaveInfoId = objectInput.readLong();
		eLeaveId = objectInput.readLong();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
		startTime = objectInput.readUTF();
		endTime = objectInput.readUTF();
		typeOfLeave = objectInput.readUTF();
		typeOfLeaveId = objectInput.readUTF();
		absenceDays = objectInput.readUTF();
		remark = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(eLeaveInfoId);
		objectOutput.writeLong(eLeaveId);
		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);

		if (startTime == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(startTime);
		}

		if (endTime == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(endTime);
		}

		if (typeOfLeave == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(typeOfLeave);
		}

		if (typeOfLeaveId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(typeOfLeaveId);
		}

		if (absenceDays == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(absenceDays);
		}

		if (remark == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(remark);
		}
	}

	public long eLeaveInfoId;
	public long eLeaveId;
	public long startDate;
	public long endDate;
	public String startTime;
	public String endTime;
	public String typeOfLeave;
	public String typeOfLeaveId;
	public String absenceDays;
	public String remark;
}