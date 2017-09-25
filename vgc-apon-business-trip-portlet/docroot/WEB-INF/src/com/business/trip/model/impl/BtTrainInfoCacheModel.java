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

import com.business.trip.model.BtTrainInfo;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BtTrainInfo in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see BtTrainInfo
 * @generated
 */
public class BtTrainInfoCacheModel implements CacheModel<BtTrainInfo>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{btTrainInfoId=");
		sb.append(btTrainInfoId);
		sb.append(", businessTripPkId=");
		sb.append(businessTripPkId);
		sb.append(", ticketNo=");
		sb.append(ticketNo);
		sb.append(", fromCity=");
		sb.append(fromCity);
		sb.append(", toCity=");
		sb.append(toCity);
		sb.append(", departureDate=");
		sb.append(departureDate);
		sb.append(", departureTrain=");
		sb.append(departureTrain);
		sb.append(", classInfo=");
		sb.append(classInfo);
		sb.append(", price=");
		sb.append(price);
		sb.append(", currency=");
		sb.append(currency);
		sb.append(", tripType=");
		sb.append(tripType);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BtTrainInfo toEntityModel() {
		BtTrainInfoImpl btTrainInfoImpl = new BtTrainInfoImpl();

		btTrainInfoImpl.setBtTrainInfoId(btTrainInfoId);
		btTrainInfoImpl.setBusinessTripPkId(businessTripPkId);

		if (ticketNo == null) {
			btTrainInfoImpl.setTicketNo(StringPool.BLANK);
		}
		else {
			btTrainInfoImpl.setTicketNo(ticketNo);
		}

		if (fromCity == null) {
			btTrainInfoImpl.setFromCity(StringPool.BLANK);
		}
		else {
			btTrainInfoImpl.setFromCity(fromCity);
		}

		if (toCity == null) {
			btTrainInfoImpl.setToCity(StringPool.BLANK);
		}
		else {
			btTrainInfoImpl.setToCity(toCity);
		}

		if (departureDate == Long.MIN_VALUE) {
			btTrainInfoImpl.setDepartureDate(null);
		}
		else {
			btTrainInfoImpl.setDepartureDate(new Date(departureDate));
		}

		if (departureTrain == null) {
			btTrainInfoImpl.setDepartureTrain(StringPool.BLANK);
		}
		else {
			btTrainInfoImpl.setDepartureTrain(departureTrain);
		}

		if (classInfo == null) {
			btTrainInfoImpl.setClassInfo(StringPool.BLANK);
		}
		else {
			btTrainInfoImpl.setClassInfo(classInfo);
		}

		btTrainInfoImpl.setPrice(price);

		if (currency == null) {
			btTrainInfoImpl.setCurrency(StringPool.BLANK);
		}
		else {
			btTrainInfoImpl.setCurrency(currency);
		}

		if (tripType == null) {
			btTrainInfoImpl.setTripType(StringPool.BLANK);
		}
		else {
			btTrainInfoImpl.setTripType(tripType);
		}

		btTrainInfoImpl.resetOriginalValues();

		return btTrainInfoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		btTrainInfoId = objectInput.readLong();
		businessTripPkId = objectInput.readLong();
		ticketNo = objectInput.readUTF();
		fromCity = objectInput.readUTF();
		toCity = objectInput.readUTF();
		departureDate = objectInput.readLong();
		departureTrain = objectInput.readUTF();
		classInfo = objectInput.readUTF();
		price = objectInput.readDouble();
		currency = objectInput.readUTF();
		tripType = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(btTrainInfoId);
		objectOutput.writeLong(businessTripPkId);

		if (ticketNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ticketNo);
		}

		if (fromCity == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fromCity);
		}

		if (toCity == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(toCity);
		}

		objectOutput.writeLong(departureDate);

		if (departureTrain == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(departureTrain);
		}

		if (classInfo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(classInfo);
		}

		objectOutput.writeDouble(price);

		if (currency == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(currency);
		}

		if (tripType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tripType);
		}
	}

	public long btTrainInfoId;
	public long businessTripPkId;
	public String ticketNo;
	public String fromCity;
	public String toCity;
	public long departureDate;
	public String departureTrain;
	public String classInfo;
	public double price;
	public String currency;
	public String tripType;
}