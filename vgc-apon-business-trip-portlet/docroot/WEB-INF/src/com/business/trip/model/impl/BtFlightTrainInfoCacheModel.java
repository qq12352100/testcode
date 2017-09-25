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

import com.business.trip.model.BtFlightTrainInfo;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BtFlightTrainInfo in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see BtFlightTrainInfo
 * @generated
 */
public class BtFlightTrainInfoCacheModel implements CacheModel<BtFlightTrainInfo>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{btFlightTrainInfoId=");
		sb.append(btFlightTrainInfoId);
		sb.append(", businessTripPkId=");
		sb.append(businessTripPkId);
		sb.append(", ticketNo=");
		sb.append(ticketNo);
		sb.append(", type=");
		sb.append(type);
		sb.append(", fromCity=");
		sb.append(fromCity);
		sb.append(", toCity=");
		sb.append(toCity);
		sb.append(", departureDate=");
		sb.append(departureDate);
		sb.append(", departureFlight=");
		sb.append(departureFlight);
		sb.append(", departureTime=");
		sb.append(departureTime);
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
	public BtFlightTrainInfo toEntityModel() {
		BtFlightTrainInfoImpl btFlightTrainInfoImpl = new BtFlightTrainInfoImpl();

		btFlightTrainInfoImpl.setBtFlightTrainInfoId(btFlightTrainInfoId);
		btFlightTrainInfoImpl.setBusinessTripPkId(businessTripPkId);

		if (ticketNo == null) {
			btFlightTrainInfoImpl.setTicketNo(StringPool.BLANK);
		}
		else {
			btFlightTrainInfoImpl.setTicketNo(ticketNo);
		}

		if (type == null) {
			btFlightTrainInfoImpl.setType(StringPool.BLANK);
		}
		else {
			btFlightTrainInfoImpl.setType(type);
		}

		if (fromCity == null) {
			btFlightTrainInfoImpl.setFromCity(StringPool.BLANK);
		}
		else {
			btFlightTrainInfoImpl.setFromCity(fromCity);
		}

		if (toCity == null) {
			btFlightTrainInfoImpl.setToCity(StringPool.BLANK);
		}
		else {
			btFlightTrainInfoImpl.setToCity(toCity);
		}

		if (departureDate == Long.MIN_VALUE) {
			btFlightTrainInfoImpl.setDepartureDate(null);
		}
		else {
			btFlightTrainInfoImpl.setDepartureDate(new Date(departureDate));
		}

		if (departureFlight == null) {
			btFlightTrainInfoImpl.setDepartureFlight(StringPool.BLANK);
		}
		else {
			btFlightTrainInfoImpl.setDepartureFlight(departureFlight);
		}

		if (departureTime == Long.MIN_VALUE) {
			btFlightTrainInfoImpl.setDepartureTime(null);
		}
		else {
			btFlightTrainInfoImpl.setDepartureTime(new Date(departureTime));
		}

		if (classInfo == null) {
			btFlightTrainInfoImpl.setClassInfo(StringPool.BLANK);
		}
		else {
			btFlightTrainInfoImpl.setClassInfo(classInfo);
		}

		btFlightTrainInfoImpl.setPrice(price);

		if (currency == null) {
			btFlightTrainInfoImpl.setCurrency(StringPool.BLANK);
		}
		else {
			btFlightTrainInfoImpl.setCurrency(currency);
		}

		if (tripType == null) {
			btFlightTrainInfoImpl.setTripType(StringPool.BLANK);
		}
		else {
			btFlightTrainInfoImpl.setTripType(tripType);
		}

		btFlightTrainInfoImpl.resetOriginalValues();

		return btFlightTrainInfoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		btFlightTrainInfoId = objectInput.readLong();
		businessTripPkId = objectInput.readLong();
		ticketNo = objectInput.readUTF();
		type = objectInput.readUTF();
		fromCity = objectInput.readUTF();
		toCity = objectInput.readUTF();
		departureDate = objectInput.readLong();
		departureFlight = objectInput.readUTF();
		departureTime = objectInput.readLong();
		classInfo = objectInput.readUTF();
		price = objectInput.readDouble();
		currency = objectInput.readUTF();
		tripType = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(btFlightTrainInfoId);
		objectOutput.writeLong(businessTripPkId);

		if (ticketNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ticketNo);
		}

		if (type == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(type);
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

		if (departureFlight == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(departureFlight);
		}

		objectOutput.writeLong(departureTime);

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

	public long btFlightTrainInfoId;
	public long businessTripPkId;
	public String ticketNo;
	public String type;
	public String fromCity;
	public String toCity;
	public long departureDate;
	public String departureFlight;
	public long departureTime;
	public String classInfo;
	public double price;
	public String currency;
	public String tripType;
}