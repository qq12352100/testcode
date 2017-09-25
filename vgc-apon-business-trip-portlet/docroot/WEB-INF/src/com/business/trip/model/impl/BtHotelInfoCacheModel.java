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

import com.business.trip.model.BtHotelInfo;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BtHotelInfo in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see BtHotelInfo
 * @generated
 */
public class BtHotelInfoCacheModel implements CacheModel<BtHotelInfo>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{btHotelInfoId=");
		sb.append(btHotelInfoId);
		sb.append(", businessTripPkId=");
		sb.append(businessTripPkId);
		sb.append(", ticketNo=");
		sb.append(ticketNo);
		sb.append(", city=");
		sb.append(city);
		sb.append(", cityType=");
		sb.append(cityType);
		sb.append(", hotel=");
		sb.append(hotel);
		sb.append(", checkIn=");
		sb.append(checkIn);
		sb.append(", checkOut=");
		sb.append(checkOut);
		sb.append(", roomCategory=");
		sb.append(roomCategory);
		sb.append(", price=");
		sb.append(price);
		sb.append(", currency=");
		sb.append(currency);
		sb.append(", otherReasonInfo=");
		sb.append(otherReasonInfo);
		sb.append(", isNotBookedFromTA=");
		sb.append(isNotBookedFromTA);
		sb.append(", isOverBudget=");
		sb.append(isOverBudget);
		sb.append(", othersSpecify=");
		sb.append(othersSpecify);
		sb.append(", tripType=");
		sb.append(tripType);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BtHotelInfo toEntityModel() {
		BtHotelInfoImpl btHotelInfoImpl = new BtHotelInfoImpl();

		btHotelInfoImpl.setBtHotelInfoId(btHotelInfoId);
		btHotelInfoImpl.setBusinessTripPkId(businessTripPkId);

		if (ticketNo == null) {
			btHotelInfoImpl.setTicketNo(StringPool.BLANK);
		}
		else {
			btHotelInfoImpl.setTicketNo(ticketNo);
		}

		if (city == null) {
			btHotelInfoImpl.setCity(StringPool.BLANK);
		}
		else {
			btHotelInfoImpl.setCity(city);
		}

		if (cityType == null) {
			btHotelInfoImpl.setCityType(StringPool.BLANK);
		}
		else {
			btHotelInfoImpl.setCityType(cityType);
		}

		if (hotel == null) {
			btHotelInfoImpl.setHotel(StringPool.BLANK);
		}
		else {
			btHotelInfoImpl.setHotel(hotel);
		}

		if (checkIn == Long.MIN_VALUE) {
			btHotelInfoImpl.setCheckIn(null);
		}
		else {
			btHotelInfoImpl.setCheckIn(new Date(checkIn));
		}

		if (checkOut == Long.MIN_VALUE) {
			btHotelInfoImpl.setCheckOut(null);
		}
		else {
			btHotelInfoImpl.setCheckOut(new Date(checkOut));
		}

		if (roomCategory == null) {
			btHotelInfoImpl.setRoomCategory(StringPool.BLANK);
		}
		else {
			btHotelInfoImpl.setRoomCategory(roomCategory);
		}

		btHotelInfoImpl.setPrice(price);

		if (currency == null) {
			btHotelInfoImpl.setCurrency(StringPool.BLANK);
		}
		else {
			btHotelInfoImpl.setCurrency(currency);
		}

		if (otherReasonInfo == null) {
			btHotelInfoImpl.setOtherReasonInfo(StringPool.BLANK);
		}
		else {
			btHotelInfoImpl.setOtherReasonInfo(otherReasonInfo);
		}

		btHotelInfoImpl.setIsNotBookedFromTA(isNotBookedFromTA);
		btHotelInfoImpl.setIsOverBudget(isOverBudget);

		if (othersSpecify == null) {
			btHotelInfoImpl.setOthersSpecify(StringPool.BLANK);
		}
		else {
			btHotelInfoImpl.setOthersSpecify(othersSpecify);
		}

		if (tripType == null) {
			btHotelInfoImpl.setTripType(StringPool.BLANK);
		}
		else {
			btHotelInfoImpl.setTripType(tripType);
		}

		btHotelInfoImpl.resetOriginalValues();

		return btHotelInfoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		btHotelInfoId = objectInput.readLong();
		businessTripPkId = objectInput.readLong();
		ticketNo = objectInput.readUTF();
		city = objectInput.readUTF();
		cityType = objectInput.readUTF();
		hotel = objectInput.readUTF();
		checkIn = objectInput.readLong();
		checkOut = objectInput.readLong();
		roomCategory = objectInput.readUTF();
		price = objectInput.readDouble();
		currency = objectInput.readUTF();
		otherReasonInfo = objectInput.readUTF();
		isNotBookedFromTA = objectInput.readBoolean();
		isOverBudget = objectInput.readInt();
		othersSpecify = objectInput.readUTF();
		tripType = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(btHotelInfoId);
		objectOutput.writeLong(businessTripPkId);

		if (ticketNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ticketNo);
		}

		if (city == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(city);
		}

		if (cityType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cityType);
		}

		if (hotel == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(hotel);
		}

		objectOutput.writeLong(checkIn);
		objectOutput.writeLong(checkOut);

		if (roomCategory == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(roomCategory);
		}

		objectOutput.writeDouble(price);

		if (currency == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(currency);
		}

		if (otherReasonInfo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(otherReasonInfo);
		}

		objectOutput.writeBoolean(isNotBookedFromTA);
		objectOutput.writeInt(isOverBudget);

		if (othersSpecify == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(othersSpecify);
		}

		if (tripType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tripType);
		}
	}

	public long btHotelInfoId;
	public long businessTripPkId;
	public String ticketNo;
	public String city;
	public String cityType;
	public String hotel;
	public long checkIn;
	public long checkOut;
	public String roomCategory;
	public double price;
	public String currency;
	public String otherReasonInfo;
	public boolean isNotBookedFromTA;
	public int isOverBudget;
	public String othersSpecify;
	public String tripType;
}