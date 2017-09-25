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

import com.business.trip.model.BtCarRentalInfo;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BtCarRentalInfo in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see BtCarRentalInfo
 * @generated
 */
public class BtCarRentalInfoCacheModel implements CacheModel<BtCarRentalInfo>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{btCarRentalInfoId=");
		sb.append(btCarRentalInfoId);
		sb.append(", businessTripPkId=");
		sb.append(businessTripPkId);
		sb.append(", ticketNo=");
		sb.append(ticketNo);
		sb.append(", pickupLocation=");
		sb.append(pickupLocation);
		sb.append(", pickupDate=");
		sb.append(pickupDate);
		sb.append(", dropoffLocation=");
		sb.append(dropoffLocation);
		sb.append(", dropoffDate=");
		sb.append(dropoffDate);
		sb.append(", carType=");
		sb.append(carType);
		sb.append(", typeOfRental=");
		sb.append(typeOfRental);
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
	public BtCarRentalInfo toEntityModel() {
		BtCarRentalInfoImpl btCarRentalInfoImpl = new BtCarRentalInfoImpl();

		btCarRentalInfoImpl.setBtCarRentalInfoId(btCarRentalInfoId);
		btCarRentalInfoImpl.setBusinessTripPkId(businessTripPkId);

		if (ticketNo == null) {
			btCarRentalInfoImpl.setTicketNo(StringPool.BLANK);
		}
		else {
			btCarRentalInfoImpl.setTicketNo(ticketNo);
		}

		if (pickupLocation == null) {
			btCarRentalInfoImpl.setPickupLocation(StringPool.BLANK);
		}
		else {
			btCarRentalInfoImpl.setPickupLocation(pickupLocation);
		}

		if (pickupDate == Long.MIN_VALUE) {
			btCarRentalInfoImpl.setPickupDate(null);
		}
		else {
			btCarRentalInfoImpl.setPickupDate(new Date(pickupDate));
		}

		if (dropoffLocation == null) {
			btCarRentalInfoImpl.setDropoffLocation(StringPool.BLANK);
		}
		else {
			btCarRentalInfoImpl.setDropoffLocation(dropoffLocation);
		}

		if (dropoffDate == Long.MIN_VALUE) {
			btCarRentalInfoImpl.setDropoffDate(null);
		}
		else {
			btCarRentalInfoImpl.setDropoffDate(new Date(dropoffDate));
		}

		if (carType == null) {
			btCarRentalInfoImpl.setCarType(StringPool.BLANK);
		}
		else {
			btCarRentalInfoImpl.setCarType(carType);
		}

		if (typeOfRental == null) {
			btCarRentalInfoImpl.setTypeOfRental(StringPool.BLANK);
		}
		else {
			btCarRentalInfoImpl.setTypeOfRental(typeOfRental);
		}

		btCarRentalInfoImpl.setPrice(price);

		if (currency == null) {
			btCarRentalInfoImpl.setCurrency(StringPool.BLANK);
		}
		else {
			btCarRentalInfoImpl.setCurrency(currency);
		}

		if (tripType == null) {
			btCarRentalInfoImpl.setTripType(StringPool.BLANK);
		}
		else {
			btCarRentalInfoImpl.setTripType(tripType);
		}

		btCarRentalInfoImpl.resetOriginalValues();

		return btCarRentalInfoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		btCarRentalInfoId = objectInput.readLong();
		businessTripPkId = objectInput.readLong();
		ticketNo = objectInput.readUTF();
		pickupLocation = objectInput.readUTF();
		pickupDate = objectInput.readLong();
		dropoffLocation = objectInput.readUTF();
		dropoffDate = objectInput.readLong();
		carType = objectInput.readUTF();
		typeOfRental = objectInput.readUTF();
		price = objectInput.readDouble();
		currency = objectInput.readUTF();
		tripType = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(btCarRentalInfoId);
		objectOutput.writeLong(businessTripPkId);

		if (ticketNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ticketNo);
		}

		if (pickupLocation == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(pickupLocation);
		}

		objectOutput.writeLong(pickupDate);

		if (dropoffLocation == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dropoffLocation);
		}

		objectOutput.writeLong(dropoffDate);

		if (carType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(carType);
		}

		if (typeOfRental == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(typeOfRental);
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

	public long btCarRentalInfoId;
	public long businessTripPkId;
	public String ticketNo;
	public String pickupLocation;
	public long pickupDate;
	public String dropoffLocation;
	public long dropoffDate;
	public String carType;
	public String typeOfRental;
	public double price;
	public String currency;
	public String tripType;
}