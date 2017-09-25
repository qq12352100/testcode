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

import com.business.trip.model.BtTravelExpense;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing BtTravelExpense in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see BtTravelExpense
 * @generated
 */
public class BtTravelExpenseCacheModel implements CacheModel<BtTravelExpense>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{btTravelExpenseId=");
		sb.append(btTravelExpenseId);
		sb.append(", businessTripPkId=");
		sb.append(businessTripPkId);
		sb.append(", ticketNo=");
		sb.append(ticketNo);
		sb.append(", travelDate=");
		sb.append(travelDate);
		sb.append(", departure=");
		sb.append(departure);
		sb.append(", arrival=");
		sb.append(arrival);
		sb.append(", fromCity=");
		sb.append(fromCity);
		sb.append(", toCity=");
		sb.append(toCity);
		sb.append(", isHasBreakfast=");
		sb.append(isHasBreakfast);
		sb.append(", isHasLunch=");
		sb.append(isHasLunch);
		sb.append(", isHasDinner=");
		sb.append(isHasDinner);
		sb.append(", country=");
		sb.append(country);
		sb.append(", city=");
		sb.append(city);
		sb.append(", rateOfDma=");
		sb.append(rateOfDma);
		sb.append(", currency=");
		sb.append(currency);
		sb.append(", allowance=");
		sb.append(allowance);
		sb.append(", comments=");
		sb.append(comments);
		sb.append(", tripType=");
		sb.append(tripType);
		sb.append(", allowanceRmb=");
		sb.append(allowanceRmb);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BtTravelExpense toEntityModel() {
		BtTravelExpenseImpl btTravelExpenseImpl = new BtTravelExpenseImpl();

		btTravelExpenseImpl.setBtTravelExpenseId(btTravelExpenseId);
		btTravelExpenseImpl.setBusinessTripPkId(businessTripPkId);

		if (ticketNo == null) {
			btTravelExpenseImpl.setTicketNo(StringPool.BLANK);
		}
		else {
			btTravelExpenseImpl.setTicketNo(ticketNo);
		}

		if (travelDate == null) {
			btTravelExpenseImpl.setTravelDate(StringPool.BLANK);
		}
		else {
			btTravelExpenseImpl.setTravelDate(travelDate);
		}

		if (departure == null) {
			btTravelExpenseImpl.setDeparture(StringPool.BLANK);
		}
		else {
			btTravelExpenseImpl.setDeparture(departure);
		}

		if (arrival == null) {
			btTravelExpenseImpl.setArrival(StringPool.BLANK);
		}
		else {
			btTravelExpenseImpl.setArrival(arrival);
		}

		if (fromCity == null) {
			btTravelExpenseImpl.setFromCity(StringPool.BLANK);
		}
		else {
			btTravelExpenseImpl.setFromCity(fromCity);
		}

		if (toCity == null) {
			btTravelExpenseImpl.setToCity(StringPool.BLANK);
		}
		else {
			btTravelExpenseImpl.setToCity(toCity);
		}

		btTravelExpenseImpl.setIsHasBreakfast(isHasBreakfast);
		btTravelExpenseImpl.setIsHasLunch(isHasLunch);
		btTravelExpenseImpl.setIsHasDinner(isHasDinner);

		if (country == null) {
			btTravelExpenseImpl.setCountry(StringPool.BLANK);
		}
		else {
			btTravelExpenseImpl.setCountry(country);
		}

		if (city == null) {
			btTravelExpenseImpl.setCity(StringPool.BLANK);
		}
		else {
			btTravelExpenseImpl.setCity(city);
		}

		btTravelExpenseImpl.setRateOfDma(rateOfDma);

		if (currency == null) {
			btTravelExpenseImpl.setCurrency(StringPool.BLANK);
		}
		else {
			btTravelExpenseImpl.setCurrency(currency);
		}

		btTravelExpenseImpl.setAllowance(allowance);

		if (comments == null) {
			btTravelExpenseImpl.setComments(StringPool.BLANK);
		}
		else {
			btTravelExpenseImpl.setComments(comments);
		}

		if (tripType == null) {
			btTravelExpenseImpl.setTripType(StringPool.BLANK);
		}
		else {
			btTravelExpenseImpl.setTripType(tripType);
		}

		btTravelExpenseImpl.setAllowanceRmb(allowanceRmb);

		btTravelExpenseImpl.resetOriginalValues();

		return btTravelExpenseImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		btTravelExpenseId = objectInput.readLong();
		businessTripPkId = objectInput.readLong();
		ticketNo = objectInput.readUTF();
		travelDate = objectInput.readUTF();
		departure = objectInput.readUTF();
		arrival = objectInput.readUTF();
		fromCity = objectInput.readUTF();
		toCity = objectInput.readUTF();
		isHasBreakfast = objectInput.readBoolean();
		isHasLunch = objectInput.readBoolean();
		isHasDinner = objectInput.readBoolean();
		country = objectInput.readUTF();
		city = objectInput.readUTF();
		rateOfDma = objectInput.readDouble();
		currency = objectInput.readUTF();
		allowance = objectInput.readDouble();
		comments = objectInput.readUTF();
		tripType = objectInput.readUTF();
		allowanceRmb = objectInput.readDouble();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(btTravelExpenseId);
		objectOutput.writeLong(businessTripPkId);

		if (ticketNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ticketNo);
		}

		if (travelDate == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(travelDate);
		}

		if (departure == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(departure);
		}

		if (arrival == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(arrival);
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

		objectOutput.writeBoolean(isHasBreakfast);
		objectOutput.writeBoolean(isHasLunch);
		objectOutput.writeBoolean(isHasDinner);

		if (country == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(country);
		}

		if (city == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(city);
		}

		objectOutput.writeDouble(rateOfDma);

		if (currency == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(currency);
		}

		objectOutput.writeDouble(allowance);

		if (comments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(comments);
		}

		if (tripType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tripType);
		}

		objectOutput.writeDouble(allowanceRmb);
	}

	public long btTravelExpenseId;
	public long businessTripPkId;
	public String ticketNo;
	public String travelDate;
	public String departure;
	public String arrival;
	public String fromCity;
	public String toCity;
	public boolean isHasBreakfast;
	public boolean isHasLunch;
	public boolean isHasDinner;
	public String country;
	public String city;
	public double rateOfDma;
	public String currency;
	public double allowance;
	public String comments;
	public String tripType;
	public double allowanceRmb;
}