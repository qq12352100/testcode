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

package com.business.trip.model.impl;

import com.business.trip.model.BtReimbursementSAPInfo;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BtReimbursementSAPInfo in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see BtReimbursementSAPInfo
 * @generated
 */
public class BtReimbursementSAPInfoCacheModel implements CacheModel<BtReimbursementSAPInfo>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{btReimbursementSAPInfoId=");
		sb.append(btReimbursementSAPInfoId);
		sb.append(", businessTripPkId=");
		sb.append(businessTripPkId);
		sb.append(", ticketNo=");
		sb.append(ticketNo);
		sb.append(", currency=");
		sb.append(currency);
		sb.append(", step=");
		sb.append(step);
		sb.append(", messageType=");
		sb.append(messageType);
		sb.append(", message=");
		sb.append(message);
		sb.append(", certificateNo=");
		sb.append(certificateNo);
		sb.append(", company=");
		sb.append(company);
		sb.append(", year=");
		sb.append(year);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BtReimbursementSAPInfo toEntityModel() {
		BtReimbursementSAPInfoImpl btReimbursementSAPInfoImpl = new BtReimbursementSAPInfoImpl();

		btReimbursementSAPInfoImpl.setBtReimbursementSAPInfoId(btReimbursementSAPInfoId);
		btReimbursementSAPInfoImpl.setBusinessTripPkId(businessTripPkId);

		if (ticketNo == null) {
			btReimbursementSAPInfoImpl.setTicketNo(StringPool.BLANK);
		}
		else {
			btReimbursementSAPInfoImpl.setTicketNo(ticketNo);
		}

		if (currency == null) {
			btReimbursementSAPInfoImpl.setCurrency(StringPool.BLANK);
		}
		else {
			btReimbursementSAPInfoImpl.setCurrency(currency);
		}

		btReimbursementSAPInfoImpl.setStep(step);

		if (messageType == null) {
			btReimbursementSAPInfoImpl.setMessageType(StringPool.BLANK);
		}
		else {
			btReimbursementSAPInfoImpl.setMessageType(messageType);
		}

		if (message == null) {
			btReimbursementSAPInfoImpl.setMessage(StringPool.BLANK);
		}
		else {
			btReimbursementSAPInfoImpl.setMessage(message);
		}

		if (certificateNo == null) {
			btReimbursementSAPInfoImpl.setCertificateNo(StringPool.BLANK);
		}
		else {
			btReimbursementSAPInfoImpl.setCertificateNo(certificateNo);
		}

		if (company == null) {
			btReimbursementSAPInfoImpl.setCompany(StringPool.BLANK);
		}
		else {
			btReimbursementSAPInfoImpl.setCompany(company);
		}

		if (year == null) {
			btReimbursementSAPInfoImpl.setYear(StringPool.BLANK);
		}
		else {
			btReimbursementSAPInfoImpl.setYear(year);
		}

		if (createDate == Long.MIN_VALUE) {
			btReimbursementSAPInfoImpl.setCreateDate(null);
		}
		else {
			btReimbursementSAPInfoImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			btReimbursementSAPInfoImpl.setModifiedDate(null);
		}
		else {
			btReimbursementSAPInfoImpl.setModifiedDate(new Date(modifiedDate));
		}

		btReimbursementSAPInfoImpl.resetOriginalValues();

		return btReimbursementSAPInfoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		btReimbursementSAPInfoId = objectInput.readLong();
		businessTripPkId = objectInput.readLong();
		ticketNo = objectInput.readUTF();
		currency = objectInput.readUTF();
		step = objectInput.readInt();
		messageType = objectInput.readUTF();
		message = objectInput.readUTF();
		certificateNo = objectInput.readUTF();
		company = objectInput.readUTF();
		year = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(btReimbursementSAPInfoId);
		objectOutput.writeLong(businessTripPkId);

		if (ticketNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ticketNo);
		}

		if (currency == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(currency);
		}

		objectOutput.writeInt(step);

		if (messageType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(messageType);
		}

		if (message == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(message);
		}

		if (certificateNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(certificateNo);
		}

		if (company == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(company);
		}

		if (year == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(year);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long btReimbursementSAPInfoId;
	public long businessTripPkId;
	public String ticketNo;
	public String currency;
	public int step;
	public String messageType;
	public String message;
	public String certificateNo;
	public String company;
	public String year;
	public long createDate;
	public long modifiedDate;
}