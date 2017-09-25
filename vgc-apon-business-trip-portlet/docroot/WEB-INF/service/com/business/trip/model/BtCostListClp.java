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

package com.business.trip.model;

import com.business.trip.service.BtCostListLocalServiceUtil;
import com.business.trip.service.ClpSerializer;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class BtCostListClp extends BaseModelImpl<BtCostList>
	implements BtCostList {
	public BtCostListClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return BtCostList.class;
	}

	@Override
	public String getModelClassName() {
		return BtCostList.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _btCostListId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBtCostListId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _btCostListId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("btCostListId", getBtCostListId());
		attributes.put("businessTripPkId", getBusinessTripPkId());
		attributes.put("ticketNo", getTicketNo());
		attributes.put("item", getItem());
		attributes.put("invoiceCurrency", getInvoiceCurrency());
		attributes.put("paymentAmount", getPaymentAmount());
		attributes.put("paymentCurrency", getPaymentCurrency());
		attributes.put("countryCity", getCountryCity());
		attributes.put("type", getType());
		attributes.put("invoiceAmount", getInvoiceAmount());
		attributes.put("taxRate", getTaxRate());
		attributes.put("netAmount", getNetAmount());
		attributes.put("taxAmount", getTaxAmount());
		attributes.put("netAmountRmb", getNetAmountRmb());
		attributes.put("entertainmentDate", getEntertainmentDate());
		attributes.put("entertainmentPlace", getEntertainmentPlace());
		attributes.put("reasonesInfo", getReasonesInfo());
		attributes.put("attendeesTotal", getAttendeesTotal());
		attributes.put("averageSpend", getAverageSpend());
		attributes.put("mealCategory", getMealCategory());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long btCostListId = (Long)attributes.get("btCostListId");

		if (btCostListId != null) {
			setBtCostListId(btCostListId);
		}

		Long businessTripPkId = (Long)attributes.get("businessTripPkId");

		if (businessTripPkId != null) {
			setBusinessTripPkId(businessTripPkId);
		}

		String ticketNo = (String)attributes.get("ticketNo");

		if (ticketNo != null) {
			setTicketNo(ticketNo);
		}

		String item = (String)attributes.get("item");

		if (item != null) {
			setItem(item);
		}

		String invoiceCurrency = (String)attributes.get("invoiceCurrency");

		if (invoiceCurrency != null) {
			setInvoiceCurrency(invoiceCurrency);
		}

		Double paymentAmount = (Double)attributes.get("paymentAmount");

		if (paymentAmount != null) {
			setPaymentAmount(paymentAmount);
		}

		String paymentCurrency = (String)attributes.get("paymentCurrency");

		if (paymentCurrency != null) {
			setPaymentCurrency(paymentCurrency);
		}

		String countryCity = (String)attributes.get("countryCity");

		if (countryCity != null) {
			setCountryCity(countryCity);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		Double invoiceAmount = (Double)attributes.get("invoiceAmount");

		if (invoiceAmount != null) {
			setInvoiceAmount(invoiceAmount);
		}

		Double taxRate = (Double)attributes.get("taxRate");

		if (taxRate != null) {
			setTaxRate(taxRate);
		}

		Double netAmount = (Double)attributes.get("netAmount");

		if (netAmount != null) {
			setNetAmount(netAmount);
		}

		Double taxAmount = (Double)attributes.get("taxAmount");

		if (taxAmount != null) {
			setTaxAmount(taxAmount);
		}

		Double netAmountRmb = (Double)attributes.get("netAmountRmb");

		if (netAmountRmb != null) {
			setNetAmountRmb(netAmountRmb);
		}

		Date entertainmentDate = (Date)attributes.get("entertainmentDate");

		if (entertainmentDate != null) {
			setEntertainmentDate(entertainmentDate);
		}

		String entertainmentPlace = (String)attributes.get("entertainmentPlace");

		if (entertainmentPlace != null) {
			setEntertainmentPlace(entertainmentPlace);
		}

		String reasonesInfo = (String)attributes.get("reasonesInfo");

		if (reasonesInfo != null) {
			setReasonesInfo(reasonesInfo);
		}

		Integer attendeesTotal = (Integer)attributes.get("attendeesTotal");

		if (attendeesTotal != null) {
			setAttendeesTotal(attendeesTotal);
		}

		Double averageSpend = (Double)attributes.get("averageSpend");

		if (averageSpend != null) {
			setAverageSpend(averageSpend);
		}

		String mealCategory = (String)attributes.get("mealCategory");

		if (mealCategory != null) {
			setMealCategory(mealCategory);
		}
	}

	@Override
	public long getBtCostListId() {
		return _btCostListId;
	}

	@Override
	public void setBtCostListId(long btCostListId) {
		_btCostListId = btCostListId;

		if (_btCostListRemoteModel != null) {
			try {
				Class<?> clazz = _btCostListRemoteModel.getClass();

				Method method = clazz.getMethod("setBtCostListId", long.class);

				method.invoke(_btCostListRemoteModel, btCostListId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getBusinessTripPkId() {
		return _businessTripPkId;
	}

	@Override
	public void setBusinessTripPkId(long businessTripPkId) {
		_businessTripPkId = businessTripPkId;

		if (_btCostListRemoteModel != null) {
			try {
				Class<?> clazz = _btCostListRemoteModel.getClass();

				Method method = clazz.getMethod("setBusinessTripPkId",
						long.class);

				method.invoke(_btCostListRemoteModel, businessTripPkId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTicketNo() {
		return _ticketNo;
	}

	@Override
	public void setTicketNo(String ticketNo) {
		_ticketNo = ticketNo;

		if (_btCostListRemoteModel != null) {
			try {
				Class<?> clazz = _btCostListRemoteModel.getClass();

				Method method = clazz.getMethod("setTicketNo", String.class);

				method.invoke(_btCostListRemoteModel, ticketNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getItem() {
		return _item;
	}

	@Override
	public void setItem(String item) {
		_item = item;

		if (_btCostListRemoteModel != null) {
			try {
				Class<?> clazz = _btCostListRemoteModel.getClass();

				Method method = clazz.getMethod("setItem", String.class);

				method.invoke(_btCostListRemoteModel, item);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getInvoiceCurrency() {
		return _invoiceCurrency;
	}

	@Override
	public void setInvoiceCurrency(String invoiceCurrency) {
		_invoiceCurrency = invoiceCurrency;

		if (_btCostListRemoteModel != null) {
			try {
				Class<?> clazz = _btCostListRemoteModel.getClass();

				Method method = clazz.getMethod("setInvoiceCurrency",
						String.class);

				method.invoke(_btCostListRemoteModel, invoiceCurrency);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getPaymentAmount() {
		return _paymentAmount;
	}

	@Override
	public void setPaymentAmount(double paymentAmount) {
		_paymentAmount = paymentAmount;

		if (_btCostListRemoteModel != null) {
			try {
				Class<?> clazz = _btCostListRemoteModel.getClass();

				Method method = clazz.getMethod("setPaymentAmount", double.class);

				method.invoke(_btCostListRemoteModel, paymentAmount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPaymentCurrency() {
		return _paymentCurrency;
	}

	@Override
	public void setPaymentCurrency(String paymentCurrency) {
		_paymentCurrency = paymentCurrency;

		if (_btCostListRemoteModel != null) {
			try {
				Class<?> clazz = _btCostListRemoteModel.getClass();

				Method method = clazz.getMethod("setPaymentCurrency",
						String.class);

				method.invoke(_btCostListRemoteModel, paymentCurrency);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCountryCity() {
		return _countryCity;
	}

	@Override
	public void setCountryCity(String countryCity) {
		_countryCity = countryCity;

		if (_btCostListRemoteModel != null) {
			try {
				Class<?> clazz = _btCostListRemoteModel.getClass();

				Method method = clazz.getMethod("setCountryCity", String.class);

				method.invoke(_btCostListRemoteModel, countryCity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getType() {
		return _type;
	}

	@Override
	public void setType(String type) {
		_type = type;

		if (_btCostListRemoteModel != null) {
			try {
				Class<?> clazz = _btCostListRemoteModel.getClass();

				Method method = clazz.getMethod("setType", String.class);

				method.invoke(_btCostListRemoteModel, type);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getInvoiceAmount() {
		return _invoiceAmount;
	}

	@Override
	public void setInvoiceAmount(double invoiceAmount) {
		_invoiceAmount = invoiceAmount;

		if (_btCostListRemoteModel != null) {
			try {
				Class<?> clazz = _btCostListRemoteModel.getClass();

				Method method = clazz.getMethod("setInvoiceAmount", double.class);

				method.invoke(_btCostListRemoteModel, invoiceAmount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getTaxRate() {
		return _taxRate;
	}

	@Override
	public void setTaxRate(double taxRate) {
		_taxRate = taxRate;

		if (_btCostListRemoteModel != null) {
			try {
				Class<?> clazz = _btCostListRemoteModel.getClass();

				Method method = clazz.getMethod("setTaxRate", double.class);

				method.invoke(_btCostListRemoteModel, taxRate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getNetAmount() {
		return _netAmount;
	}

	@Override
	public void setNetAmount(double netAmount) {
		_netAmount = netAmount;

		if (_btCostListRemoteModel != null) {
			try {
				Class<?> clazz = _btCostListRemoteModel.getClass();

				Method method = clazz.getMethod("setNetAmount", double.class);

				method.invoke(_btCostListRemoteModel, netAmount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getTaxAmount() {
		return _taxAmount;
	}

	@Override
	public void setTaxAmount(double taxAmount) {
		_taxAmount = taxAmount;

		if (_btCostListRemoteModel != null) {
			try {
				Class<?> clazz = _btCostListRemoteModel.getClass();

				Method method = clazz.getMethod("setTaxAmount", double.class);

				method.invoke(_btCostListRemoteModel, taxAmount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getNetAmountRmb() {
		return _netAmountRmb;
	}

	@Override
	public void setNetAmountRmb(double netAmountRmb) {
		_netAmountRmb = netAmountRmb;

		if (_btCostListRemoteModel != null) {
			try {
				Class<?> clazz = _btCostListRemoteModel.getClass();

				Method method = clazz.getMethod("setNetAmountRmb", double.class);

				method.invoke(_btCostListRemoteModel, netAmountRmb);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEntertainmentDate() {
		return _entertainmentDate;
	}

	@Override
	public void setEntertainmentDate(Date entertainmentDate) {
		_entertainmentDate = entertainmentDate;

		if (_btCostListRemoteModel != null) {
			try {
				Class<?> clazz = _btCostListRemoteModel.getClass();

				Method method = clazz.getMethod("setEntertainmentDate",
						Date.class);

				method.invoke(_btCostListRemoteModel, entertainmentDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEntertainmentPlace() {
		return _entertainmentPlace;
	}

	@Override
	public void setEntertainmentPlace(String entertainmentPlace) {
		_entertainmentPlace = entertainmentPlace;

		if (_btCostListRemoteModel != null) {
			try {
				Class<?> clazz = _btCostListRemoteModel.getClass();

				Method method = clazz.getMethod("setEntertainmentPlace",
						String.class);

				method.invoke(_btCostListRemoteModel, entertainmentPlace);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getReasonesInfo() {
		return _reasonesInfo;
	}

	@Override
	public void setReasonesInfo(String reasonesInfo) {
		_reasonesInfo = reasonesInfo;

		if (_btCostListRemoteModel != null) {
			try {
				Class<?> clazz = _btCostListRemoteModel.getClass();

				Method method = clazz.getMethod("setReasonesInfo", String.class);

				method.invoke(_btCostListRemoteModel, reasonesInfo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getAttendeesTotal() {
		return _attendeesTotal;
	}

	@Override
	public void setAttendeesTotal(int attendeesTotal) {
		_attendeesTotal = attendeesTotal;

		if (_btCostListRemoteModel != null) {
			try {
				Class<?> clazz = _btCostListRemoteModel.getClass();

				Method method = clazz.getMethod("setAttendeesTotal", int.class);

				method.invoke(_btCostListRemoteModel, attendeesTotal);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getAverageSpend() {
		return _averageSpend;
	}

	@Override
	public void setAverageSpend(double averageSpend) {
		_averageSpend = averageSpend;

		if (_btCostListRemoteModel != null) {
			try {
				Class<?> clazz = _btCostListRemoteModel.getClass();

				Method method = clazz.getMethod("setAverageSpend", double.class);

				method.invoke(_btCostListRemoteModel, averageSpend);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMealCategory() {
		return _mealCategory;
	}

	@Override
	public void setMealCategory(String mealCategory) {
		_mealCategory = mealCategory;

		if (_btCostListRemoteModel != null) {
			try {
				Class<?> clazz = _btCostListRemoteModel.getClass();

				Method method = clazz.getMethod("setMealCategory", String.class);

				method.invoke(_btCostListRemoteModel, mealCategory);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getBtCostListRemoteModel() {
		return _btCostListRemoteModel;
	}

	public void setBtCostListRemoteModel(BaseModel<?> btCostListRemoteModel) {
		_btCostListRemoteModel = btCostListRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _btCostListRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_btCostListRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			BtCostListLocalServiceUtil.addBtCostList(this);
		}
		else {
			BtCostListLocalServiceUtil.updateBtCostList(this);
		}
	}

	@Override
	public BtCostList toEscapedModel() {
		return (BtCostList)ProxyUtil.newProxyInstance(BtCostList.class.getClassLoader(),
			new Class[] { BtCostList.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BtCostListClp clone = new BtCostListClp();

		clone.setBtCostListId(getBtCostListId());
		clone.setBusinessTripPkId(getBusinessTripPkId());
		clone.setTicketNo(getTicketNo());
		clone.setItem(getItem());
		clone.setInvoiceCurrency(getInvoiceCurrency());
		clone.setPaymentAmount(getPaymentAmount());
		clone.setPaymentCurrency(getPaymentCurrency());
		clone.setCountryCity(getCountryCity());
		clone.setType(getType());
		clone.setInvoiceAmount(getInvoiceAmount());
		clone.setTaxRate(getTaxRate());
		clone.setNetAmount(getNetAmount());
		clone.setTaxAmount(getTaxAmount());
		clone.setNetAmountRmb(getNetAmountRmb());
		clone.setEntertainmentDate(getEntertainmentDate());
		clone.setEntertainmentPlace(getEntertainmentPlace());
		clone.setReasonesInfo(getReasonesInfo());
		clone.setAttendeesTotal(getAttendeesTotal());
		clone.setAverageSpend(getAverageSpend());
		clone.setMealCategory(getMealCategory());

		return clone;
	}

	@Override
	public int compareTo(BtCostList btCostList) {
		long primaryKey = btCostList.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BtCostListClp)) {
			return false;
		}

		BtCostListClp btCostList = (BtCostListClp)obj;

		long primaryKey = btCostList.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{btCostListId=");
		sb.append(getBtCostListId());
		sb.append(", businessTripPkId=");
		sb.append(getBusinessTripPkId());
		sb.append(", ticketNo=");
		sb.append(getTicketNo());
		sb.append(", item=");
		sb.append(getItem());
		sb.append(", invoiceCurrency=");
		sb.append(getInvoiceCurrency());
		sb.append(", paymentAmount=");
		sb.append(getPaymentAmount());
		sb.append(", paymentCurrency=");
		sb.append(getPaymentCurrency());
		sb.append(", countryCity=");
		sb.append(getCountryCity());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", invoiceAmount=");
		sb.append(getInvoiceAmount());
		sb.append(", taxRate=");
		sb.append(getTaxRate());
		sb.append(", netAmount=");
		sb.append(getNetAmount());
		sb.append(", taxAmount=");
		sb.append(getTaxAmount());
		sb.append(", netAmountRmb=");
		sb.append(getNetAmountRmb());
		sb.append(", entertainmentDate=");
		sb.append(getEntertainmentDate());
		sb.append(", entertainmentPlace=");
		sb.append(getEntertainmentPlace());
		sb.append(", reasonesInfo=");
		sb.append(getReasonesInfo());
		sb.append(", attendeesTotal=");
		sb.append(getAttendeesTotal());
		sb.append(", averageSpend=");
		sb.append(getAverageSpend());
		sb.append(", mealCategory=");
		sb.append(getMealCategory());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(64);

		sb.append("<model><model-name>");
		sb.append("com.business.trip.model.BtCostList");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>btCostListId</column-name><column-value><![CDATA[");
		sb.append(getBtCostListId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>businessTripPkId</column-name><column-value><![CDATA[");
		sb.append(getBusinessTripPkId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ticketNo</column-name><column-value><![CDATA[");
		sb.append(getTicketNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>item</column-name><column-value><![CDATA[");
		sb.append(getItem());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>invoiceCurrency</column-name><column-value><![CDATA[");
		sb.append(getInvoiceCurrency());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>paymentAmount</column-name><column-value><![CDATA[");
		sb.append(getPaymentAmount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>paymentCurrency</column-name><column-value><![CDATA[");
		sb.append(getPaymentCurrency());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>countryCity</column-name><column-value><![CDATA[");
		sb.append(getCountryCity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>invoiceAmount</column-name><column-value><![CDATA[");
		sb.append(getInvoiceAmount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>taxRate</column-name><column-value><![CDATA[");
		sb.append(getTaxRate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>netAmount</column-name><column-value><![CDATA[");
		sb.append(getNetAmount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>taxAmount</column-name><column-value><![CDATA[");
		sb.append(getTaxAmount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>netAmountRmb</column-name><column-value><![CDATA[");
		sb.append(getNetAmountRmb());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>entertainmentDate</column-name><column-value><![CDATA[");
		sb.append(getEntertainmentDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>entertainmentPlace</column-name><column-value><![CDATA[");
		sb.append(getEntertainmentPlace());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reasonesInfo</column-name><column-value><![CDATA[");
		sb.append(getReasonesInfo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>attendeesTotal</column-name><column-value><![CDATA[");
		sb.append(getAttendeesTotal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>averageSpend</column-name><column-value><![CDATA[");
		sb.append(getAverageSpend());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mealCategory</column-name><column-value><![CDATA[");
		sb.append(getMealCategory());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _btCostListId;
	private long _businessTripPkId;
	private String _ticketNo;
	private String _item;
	private String _invoiceCurrency;
	private double _paymentAmount;
	private String _paymentCurrency;
	private String _countryCity;
	private String _type;
	private double _invoiceAmount;
	private double _taxRate;
	private double _netAmount;
	private double _taxAmount;
	private double _netAmountRmb;
	private Date _entertainmentDate;
	private String _entertainmentPlace;
	private String _reasonesInfo;
	private int _attendeesTotal;
	private double _averageSpend;
	private String _mealCategory;
	private BaseModel<?> _btCostListRemoteModel;
	private Class<?> _clpSerializerClass = com.business.trip.service.ClpSerializer.class;
}