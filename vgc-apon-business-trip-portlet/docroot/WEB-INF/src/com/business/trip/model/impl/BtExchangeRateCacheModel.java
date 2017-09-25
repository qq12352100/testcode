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

import com.business.trip.model.BtExchangeRate;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BtExchangeRate in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see BtExchangeRate
 * @generated
 */
public class BtExchangeRateCacheModel implements CacheModel<BtExchangeRate>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{btExchangeRateId=");
		sb.append(btExchangeRateId);
		sb.append(", firstCurrency=");
		sb.append(firstCurrency);
		sb.append(", secondCurrency=");
		sb.append(secondCurrency);
		sb.append(", firToSecExchangeRate=");
		sb.append(firToSecExchangeRate);
		sb.append(", secToFirExchangeRate=");
		sb.append(secToFirExchangeRate);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BtExchangeRate toEntityModel() {
		BtExchangeRateImpl btExchangeRateImpl = new BtExchangeRateImpl();

		btExchangeRateImpl.setBtExchangeRateId(btExchangeRateId);

		if (firstCurrency == null) {
			btExchangeRateImpl.setFirstCurrency(StringPool.BLANK);
		}
		else {
			btExchangeRateImpl.setFirstCurrency(firstCurrency);
		}

		if (secondCurrency == null) {
			btExchangeRateImpl.setSecondCurrency(StringPool.BLANK);
		}
		else {
			btExchangeRateImpl.setSecondCurrency(secondCurrency);
		}

		btExchangeRateImpl.setFirToSecExchangeRate(firToSecExchangeRate);
		btExchangeRateImpl.setSecToFirExchangeRate(secToFirExchangeRate);
		btExchangeRateImpl.setUserId(userId);

		if (userName == null) {
			btExchangeRateImpl.setUserName(StringPool.BLANK);
		}
		else {
			btExchangeRateImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			btExchangeRateImpl.setCreateDate(null);
		}
		else {
			btExchangeRateImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			btExchangeRateImpl.setModifiedDate(null);
		}
		else {
			btExchangeRateImpl.setModifiedDate(new Date(modifiedDate));
		}

		btExchangeRateImpl.setStatus(status);

		btExchangeRateImpl.resetOriginalValues();

		return btExchangeRateImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		btExchangeRateId = objectInput.readLong();
		firstCurrency = objectInput.readUTF();
		secondCurrency = objectInput.readUTF();
		firToSecExchangeRate = objectInput.readDouble();
		secToFirExchangeRate = objectInput.readDouble();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(btExchangeRateId);

		if (firstCurrency == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(firstCurrency);
		}

		if (secondCurrency == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(secondCurrency);
		}

		objectOutput.writeDouble(firToSecExchangeRate);
		objectOutput.writeDouble(secToFirExchangeRate);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeInt(status);
	}

	public long btExchangeRateId;
	public String firstCurrency;
	public String secondCurrency;
	public double firToSecExchangeRate;
	public double secToFirExchangeRate;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int status;
}