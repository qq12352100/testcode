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

import com.business.trip.model.BtCostList;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BtCostList in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see BtCostList
 * @generated
 */
public class BtCostListCacheModel implements CacheModel<BtCostList>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{btCostListId=");
		sb.append(btCostListId);
		sb.append(", businessTripPkId=");
		sb.append(businessTripPkId);
		sb.append(", ticketNo=");
		sb.append(ticketNo);
		sb.append(", item=");
		sb.append(item);
		sb.append(", invoiceCurrency=");
		sb.append(invoiceCurrency);
		sb.append(", paymentAmount=");
		sb.append(paymentAmount);
		sb.append(", paymentCurrency=");
		sb.append(paymentCurrency);
		sb.append(", countryCity=");
		sb.append(countryCity);
		sb.append(", type=");
		sb.append(type);
		sb.append(", invoiceAmount=");
		sb.append(invoiceAmount);
		sb.append(", taxRate=");
		sb.append(taxRate);
		sb.append(", netAmount=");
		sb.append(netAmount);
		sb.append(", taxAmount=");
		sb.append(taxAmount);
		sb.append(", netAmountRmb=");
		sb.append(netAmountRmb);
		sb.append(", entertainmentDate=");
		sb.append(entertainmentDate);
		sb.append(", entertainmentPlace=");
		sb.append(entertainmentPlace);
		sb.append(", reasonesInfo=");
		sb.append(reasonesInfo);
		sb.append(", attendeesTotal=");
		sb.append(attendeesTotal);
		sb.append(", averageSpend=");
		sb.append(averageSpend);
		sb.append(", mealCategory=");
		sb.append(mealCategory);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BtCostList toEntityModel() {
		BtCostListImpl btCostListImpl = new BtCostListImpl();

		btCostListImpl.setBtCostListId(btCostListId);
		btCostListImpl.setBusinessTripPkId(businessTripPkId);

		if (ticketNo == null) {
			btCostListImpl.setTicketNo(StringPool.BLANK);
		}
		else {
			btCostListImpl.setTicketNo(ticketNo);
		}

		if (item == null) {
			btCostListImpl.setItem(StringPool.BLANK);
		}
		else {
			btCostListImpl.setItem(item);
		}

		if (invoiceCurrency == null) {
			btCostListImpl.setInvoiceCurrency(StringPool.BLANK);
		}
		else {
			btCostListImpl.setInvoiceCurrency(invoiceCurrency);
		}

		btCostListImpl.setPaymentAmount(paymentAmount);

		if (paymentCurrency == null) {
			btCostListImpl.setPaymentCurrency(StringPool.BLANK);
		}
		else {
			btCostListImpl.setPaymentCurrency(paymentCurrency);
		}

		if (countryCity == null) {
			btCostListImpl.setCountryCity(StringPool.BLANK);
		}
		else {
			btCostListImpl.setCountryCity(countryCity);
		}

		if (type == null) {
			btCostListImpl.setType(StringPool.BLANK);
		}
		else {
			btCostListImpl.setType(type);
		}

		btCostListImpl.setInvoiceAmount(invoiceAmount);
		btCostListImpl.setTaxRate(taxRate);
		btCostListImpl.setNetAmount(netAmount);
		btCostListImpl.setTaxAmount(taxAmount);
		btCostListImpl.setNetAmountRmb(netAmountRmb);

		if (entertainmentDate == Long.MIN_VALUE) {
			btCostListImpl.setEntertainmentDate(null);
		}
		else {
			btCostListImpl.setEntertainmentDate(new Date(entertainmentDate));
		}

		if (entertainmentPlace == null) {
			btCostListImpl.setEntertainmentPlace(StringPool.BLANK);
		}
		else {
			btCostListImpl.setEntertainmentPlace(entertainmentPlace);
		}

		if (reasonesInfo == null) {
			btCostListImpl.setReasonesInfo(StringPool.BLANK);
		}
		else {
			btCostListImpl.setReasonesInfo(reasonesInfo);
		}

		btCostListImpl.setAttendeesTotal(attendeesTotal);
		btCostListImpl.setAverageSpend(averageSpend);

		if (mealCategory == null) {
			btCostListImpl.setMealCategory(StringPool.BLANK);
		}
		else {
			btCostListImpl.setMealCategory(mealCategory);
		}

		btCostListImpl.resetOriginalValues();

		return btCostListImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		btCostListId = objectInput.readLong();
		businessTripPkId = objectInput.readLong();
		ticketNo = objectInput.readUTF();
		item = objectInput.readUTF();
		invoiceCurrency = objectInput.readUTF();
		paymentAmount = objectInput.readDouble();
		paymentCurrency = objectInput.readUTF();
		countryCity = objectInput.readUTF();
		type = objectInput.readUTF();
		invoiceAmount = objectInput.readDouble();
		taxRate = objectInput.readDouble();
		netAmount = objectInput.readDouble();
		taxAmount = objectInput.readDouble();
		netAmountRmb = objectInput.readDouble();
		entertainmentDate = objectInput.readLong();
		entertainmentPlace = objectInput.readUTF();
		reasonesInfo = objectInput.readUTF();
		attendeesTotal = objectInput.readInt();
		averageSpend = objectInput.readDouble();
		mealCategory = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(btCostListId);
		objectOutput.writeLong(businessTripPkId);

		if (ticketNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ticketNo);
		}

		if (item == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(item);
		}

		if (invoiceCurrency == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(invoiceCurrency);
		}

		objectOutput.writeDouble(paymentAmount);

		if (paymentCurrency == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(paymentCurrency);
		}

		if (countryCity == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(countryCity);
		}

		if (type == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(type);
		}

		objectOutput.writeDouble(invoiceAmount);
		objectOutput.writeDouble(taxRate);
		objectOutput.writeDouble(netAmount);
		objectOutput.writeDouble(taxAmount);
		objectOutput.writeDouble(netAmountRmb);
		objectOutput.writeLong(entertainmentDate);

		if (entertainmentPlace == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(entertainmentPlace);
		}

		if (reasonesInfo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(reasonesInfo);
		}

		objectOutput.writeInt(attendeesTotal);
		objectOutput.writeDouble(averageSpend);

		if (mealCategory == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(mealCategory);
		}
	}

	public long btCostListId;
	public long businessTripPkId;
	public String ticketNo;
	public String item;
	public String invoiceCurrency;
	public double paymentAmount;
	public String paymentCurrency;
	public String countryCity;
	public String type;
	public double invoiceAmount;
	public double taxRate;
	public double netAmount;
	public double taxAmount;
	public double netAmountRmb;
	public long entertainmentDate;
	public String entertainmentPlace;
	public String reasonesInfo;
	public int attendeesTotal;
	public double averageSpend;
	public String mealCategory;
}