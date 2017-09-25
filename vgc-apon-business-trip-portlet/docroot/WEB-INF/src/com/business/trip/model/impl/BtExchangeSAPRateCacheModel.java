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

import com.business.trip.model.BtExchangeSAPRate;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BtExchangeSAPRate in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see BtExchangeSAPRate
 * @generated
 */
public class BtExchangeSAPRateCacheModel implements CacheModel<BtExchangeSAPRate>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{btExchangeSAPRateId=");
		sb.append(btExchangeSAPRateId);
		sb.append(", fromCurrency=");
		sb.append(fromCurrency);
		sb.append(", toCurrency=");
		sb.append(toCurrency);
		sb.append(", currencyRate=");
		sb.append(currencyRate);
		sb.append(", rateType=");
		sb.append(rateType);
		sb.append(", sapDate=");
		sb.append(sapDate);
		sb.append(", importDate=");
		sb.append(importDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BtExchangeSAPRate toEntityModel() {
		BtExchangeSAPRateImpl btExchangeSAPRateImpl = new BtExchangeSAPRateImpl();

		btExchangeSAPRateImpl.setBtExchangeSAPRateId(btExchangeSAPRateId);

		if (fromCurrency == null) {
			btExchangeSAPRateImpl.setFromCurrency(StringPool.BLANK);
		}
		else {
			btExchangeSAPRateImpl.setFromCurrency(fromCurrency);
		}

		if (toCurrency == null) {
			btExchangeSAPRateImpl.setToCurrency(StringPool.BLANK);
		}
		else {
			btExchangeSAPRateImpl.setToCurrency(toCurrency);
		}

		btExchangeSAPRateImpl.setCurrencyRate(currencyRate);

		if (rateType == null) {
			btExchangeSAPRateImpl.setRateType(StringPool.BLANK);
		}
		else {
			btExchangeSAPRateImpl.setRateType(rateType);
		}

		if (sapDate == Long.MIN_VALUE) {
			btExchangeSAPRateImpl.setSapDate(null);
		}
		else {
			btExchangeSAPRateImpl.setSapDate(new Date(sapDate));
		}

		if (importDate == Long.MIN_VALUE) {
			btExchangeSAPRateImpl.setImportDate(null);
		}
		else {
			btExchangeSAPRateImpl.setImportDate(new Date(importDate));
		}

		btExchangeSAPRateImpl.resetOriginalValues();

		return btExchangeSAPRateImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		btExchangeSAPRateId = objectInput.readLong();
		fromCurrency = objectInput.readUTF();
		toCurrency = objectInput.readUTF();
		currencyRate = objectInput.readDouble();
		rateType = objectInput.readUTF();
		sapDate = objectInput.readLong();
		importDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(btExchangeSAPRateId);

		if (fromCurrency == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fromCurrency);
		}

		if (toCurrency == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(toCurrency);
		}

		objectOutput.writeDouble(currencyRate);

		if (rateType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(rateType);
		}

		objectOutput.writeLong(sapDate);
		objectOutput.writeLong(importDate);
	}

	public long btExchangeSAPRateId;
	public String fromCurrency;
	public String toCurrency;
	public double currencyRate;
	public String rateType;
	public long sapDate;
	public long importDate;
}