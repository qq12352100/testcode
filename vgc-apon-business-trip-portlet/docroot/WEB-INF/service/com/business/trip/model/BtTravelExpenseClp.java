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

import com.business.trip.service.BtTravelExpenseLocalServiceUtil;
import com.business.trip.service.ClpSerializer;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class BtTravelExpenseClp extends BaseModelImpl<BtTravelExpense>
	implements BtTravelExpense {
	public BtTravelExpenseClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return BtTravelExpense.class;
	}

	@Override
	public String getModelClassName() {
		return BtTravelExpense.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _btTravelExpenseId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBtTravelExpenseId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _btTravelExpenseId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("btTravelExpenseId", getBtTravelExpenseId());
		attributes.put("businessTripPkId", getBusinessTripPkId());
		attributes.put("ticketNo", getTicketNo());
		attributes.put("travelDate", getTravelDate());
		attributes.put("departure", getDeparture());
		attributes.put("arrival", getArrival());
		attributes.put("fromCity", getFromCity());
		attributes.put("toCity", getToCity());
		attributes.put("isHasBreakfast", getIsHasBreakfast());
		attributes.put("isHasLunch", getIsHasLunch());
		attributes.put("isHasDinner", getIsHasDinner());
		attributes.put("country", getCountry());
		attributes.put("city", getCity());
		attributes.put("rateOfDma", getRateOfDma());
		attributes.put("currency", getCurrency());
		attributes.put("allowance", getAllowance());
		attributes.put("comments", getComments());
		attributes.put("tripType", getTripType());
		attributes.put("allowanceRmb", getAllowanceRmb());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long btTravelExpenseId = (Long)attributes.get("btTravelExpenseId");

		if (btTravelExpenseId != null) {
			setBtTravelExpenseId(btTravelExpenseId);
		}

		Long businessTripPkId = (Long)attributes.get("businessTripPkId");

		if (businessTripPkId != null) {
			setBusinessTripPkId(businessTripPkId);
		}

		String ticketNo = (String)attributes.get("ticketNo");

		if (ticketNo != null) {
			setTicketNo(ticketNo);
		}

		String travelDate = (String)attributes.get("travelDate");

		if (travelDate != null) {
			setTravelDate(travelDate);
		}

		String departure = (String)attributes.get("departure");

		if (departure != null) {
			setDeparture(departure);
		}

		String arrival = (String)attributes.get("arrival");

		if (arrival != null) {
			setArrival(arrival);
		}

		String fromCity = (String)attributes.get("fromCity");

		if (fromCity != null) {
			setFromCity(fromCity);
		}

		String toCity = (String)attributes.get("toCity");

		if (toCity != null) {
			setToCity(toCity);
		}

		Boolean isHasBreakfast = (Boolean)attributes.get("isHasBreakfast");

		if (isHasBreakfast != null) {
			setIsHasBreakfast(isHasBreakfast);
		}

		Boolean isHasLunch = (Boolean)attributes.get("isHasLunch");

		if (isHasLunch != null) {
			setIsHasLunch(isHasLunch);
		}

		Boolean isHasDinner = (Boolean)attributes.get("isHasDinner");

		if (isHasDinner != null) {
			setIsHasDinner(isHasDinner);
		}

		String country = (String)attributes.get("country");

		if (country != null) {
			setCountry(country);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		Double rateOfDma = (Double)attributes.get("rateOfDma");

		if (rateOfDma != null) {
			setRateOfDma(rateOfDma);
		}

		String currency = (String)attributes.get("currency");

		if (currency != null) {
			setCurrency(currency);
		}

		Double allowance = (Double)attributes.get("allowance");

		if (allowance != null) {
			setAllowance(allowance);
		}

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
		}

		String tripType = (String)attributes.get("tripType");

		if (tripType != null) {
			setTripType(tripType);
		}

		Double allowanceRmb = (Double)attributes.get("allowanceRmb");

		if (allowanceRmb != null) {
			setAllowanceRmb(allowanceRmb);
		}
	}

	@Override
	public long getBtTravelExpenseId() {
		return _btTravelExpenseId;
	}

	@Override
	public void setBtTravelExpenseId(long btTravelExpenseId) {
		_btTravelExpenseId = btTravelExpenseId;

		if (_btTravelExpenseRemoteModel != null) {
			try {
				Class<?> clazz = _btTravelExpenseRemoteModel.getClass();

				Method method = clazz.getMethod("setBtTravelExpenseId",
						long.class);

				method.invoke(_btTravelExpenseRemoteModel, btTravelExpenseId);
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

		if (_btTravelExpenseRemoteModel != null) {
			try {
				Class<?> clazz = _btTravelExpenseRemoteModel.getClass();

				Method method = clazz.getMethod("setBusinessTripPkId",
						long.class);

				method.invoke(_btTravelExpenseRemoteModel, businessTripPkId);
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

		if (_btTravelExpenseRemoteModel != null) {
			try {
				Class<?> clazz = _btTravelExpenseRemoteModel.getClass();

				Method method = clazz.getMethod("setTicketNo", String.class);

				method.invoke(_btTravelExpenseRemoteModel, ticketNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTravelDate() {
		return _travelDate;
	}

	@Override
	public void setTravelDate(String travelDate) {
		_travelDate = travelDate;

		if (_btTravelExpenseRemoteModel != null) {
			try {
				Class<?> clazz = _btTravelExpenseRemoteModel.getClass();

				Method method = clazz.getMethod("setTravelDate", String.class);

				method.invoke(_btTravelExpenseRemoteModel, travelDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDeparture() {
		return _departure;
	}

	@Override
	public void setDeparture(String departure) {
		_departure = departure;

		if (_btTravelExpenseRemoteModel != null) {
			try {
				Class<?> clazz = _btTravelExpenseRemoteModel.getClass();

				Method method = clazz.getMethod("setDeparture", String.class);

				method.invoke(_btTravelExpenseRemoteModel, departure);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getArrival() {
		return _arrival;
	}

	@Override
	public void setArrival(String arrival) {
		_arrival = arrival;

		if (_btTravelExpenseRemoteModel != null) {
			try {
				Class<?> clazz = _btTravelExpenseRemoteModel.getClass();

				Method method = clazz.getMethod("setArrival", String.class);

				method.invoke(_btTravelExpenseRemoteModel, arrival);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFromCity() {
		return _fromCity;
	}

	@Override
	public void setFromCity(String fromCity) {
		_fromCity = fromCity;

		if (_btTravelExpenseRemoteModel != null) {
			try {
				Class<?> clazz = _btTravelExpenseRemoteModel.getClass();

				Method method = clazz.getMethod("setFromCity", String.class);

				method.invoke(_btTravelExpenseRemoteModel, fromCity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getToCity() {
		return _toCity;
	}

	@Override
	public void setToCity(String toCity) {
		_toCity = toCity;

		if (_btTravelExpenseRemoteModel != null) {
			try {
				Class<?> clazz = _btTravelExpenseRemoteModel.getClass();

				Method method = clazz.getMethod("setToCity", String.class);

				method.invoke(_btTravelExpenseRemoteModel, toCity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsHasBreakfast() {
		return _isHasBreakfast;
	}

	@Override
	public boolean isIsHasBreakfast() {
		return _isHasBreakfast;
	}

	@Override
	public void setIsHasBreakfast(boolean isHasBreakfast) {
		_isHasBreakfast = isHasBreakfast;

		if (_btTravelExpenseRemoteModel != null) {
			try {
				Class<?> clazz = _btTravelExpenseRemoteModel.getClass();

				Method method = clazz.getMethod("setIsHasBreakfast",
						boolean.class);

				method.invoke(_btTravelExpenseRemoteModel, isHasBreakfast);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsHasLunch() {
		return _isHasLunch;
	}

	@Override
	public boolean isIsHasLunch() {
		return _isHasLunch;
	}

	@Override
	public void setIsHasLunch(boolean isHasLunch) {
		_isHasLunch = isHasLunch;

		if (_btTravelExpenseRemoteModel != null) {
			try {
				Class<?> clazz = _btTravelExpenseRemoteModel.getClass();

				Method method = clazz.getMethod("setIsHasLunch", boolean.class);

				method.invoke(_btTravelExpenseRemoteModel, isHasLunch);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsHasDinner() {
		return _isHasDinner;
	}

	@Override
	public boolean isIsHasDinner() {
		return _isHasDinner;
	}

	@Override
	public void setIsHasDinner(boolean isHasDinner) {
		_isHasDinner = isHasDinner;

		if (_btTravelExpenseRemoteModel != null) {
			try {
				Class<?> clazz = _btTravelExpenseRemoteModel.getClass();

				Method method = clazz.getMethod("setIsHasDinner", boolean.class);

				method.invoke(_btTravelExpenseRemoteModel, isHasDinner);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCountry() {
		return _country;
	}

	@Override
	public void setCountry(String country) {
		_country = country;

		if (_btTravelExpenseRemoteModel != null) {
			try {
				Class<?> clazz = _btTravelExpenseRemoteModel.getClass();

				Method method = clazz.getMethod("setCountry", String.class);

				method.invoke(_btTravelExpenseRemoteModel, country);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCity() {
		return _city;
	}

	@Override
	public void setCity(String city) {
		_city = city;

		if (_btTravelExpenseRemoteModel != null) {
			try {
				Class<?> clazz = _btTravelExpenseRemoteModel.getClass();

				Method method = clazz.getMethod("setCity", String.class);

				method.invoke(_btTravelExpenseRemoteModel, city);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getRateOfDma() {
		return _rateOfDma;
	}

	@Override
	public void setRateOfDma(double rateOfDma) {
		_rateOfDma = rateOfDma;

		if (_btTravelExpenseRemoteModel != null) {
			try {
				Class<?> clazz = _btTravelExpenseRemoteModel.getClass();

				Method method = clazz.getMethod("setRateOfDma", double.class);

				method.invoke(_btTravelExpenseRemoteModel, rateOfDma);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCurrency() {
		return _currency;
	}

	@Override
	public void setCurrency(String currency) {
		_currency = currency;

		if (_btTravelExpenseRemoteModel != null) {
			try {
				Class<?> clazz = _btTravelExpenseRemoteModel.getClass();

				Method method = clazz.getMethod("setCurrency", String.class);

				method.invoke(_btTravelExpenseRemoteModel, currency);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getAllowance() {
		return _allowance;
	}

	@Override
	public void setAllowance(double allowance) {
		_allowance = allowance;

		if (_btTravelExpenseRemoteModel != null) {
			try {
				Class<?> clazz = _btTravelExpenseRemoteModel.getClass();

				Method method = clazz.getMethod("setAllowance", double.class);

				method.invoke(_btTravelExpenseRemoteModel, allowance);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getComments() {
		return _comments;
	}

	@Override
	public void setComments(String comments) {
		_comments = comments;

		if (_btTravelExpenseRemoteModel != null) {
			try {
				Class<?> clazz = _btTravelExpenseRemoteModel.getClass();

				Method method = clazz.getMethod("setComments", String.class);

				method.invoke(_btTravelExpenseRemoteModel, comments);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTripType() {
		return _tripType;
	}

	@Override
	public void setTripType(String tripType) {
		_tripType = tripType;

		if (_btTravelExpenseRemoteModel != null) {
			try {
				Class<?> clazz = _btTravelExpenseRemoteModel.getClass();

				Method method = clazz.getMethod("setTripType", String.class);

				method.invoke(_btTravelExpenseRemoteModel, tripType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getAllowanceRmb() {
		return _allowanceRmb;
	}

	@Override
	public void setAllowanceRmb(double allowanceRmb) {
		_allowanceRmb = allowanceRmb;

		if (_btTravelExpenseRemoteModel != null) {
			try {
				Class<?> clazz = _btTravelExpenseRemoteModel.getClass();

				Method method = clazz.getMethod("setAllowanceRmb", double.class);

				method.invoke(_btTravelExpenseRemoteModel, allowanceRmb);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getBtTravelExpenseRemoteModel() {
		return _btTravelExpenseRemoteModel;
	}

	public void setBtTravelExpenseRemoteModel(
		BaseModel<?> btTravelExpenseRemoteModel) {
		_btTravelExpenseRemoteModel = btTravelExpenseRemoteModel;
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

		Class<?> remoteModelClass = _btTravelExpenseRemoteModel.getClass();

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

		Object returnValue = method.invoke(_btTravelExpenseRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			BtTravelExpenseLocalServiceUtil.addBtTravelExpense(this);
		}
		else {
			BtTravelExpenseLocalServiceUtil.updateBtTravelExpense(this);
		}
	}

	@Override
	public BtTravelExpense toEscapedModel() {
		return (BtTravelExpense)ProxyUtil.newProxyInstance(BtTravelExpense.class.getClassLoader(),
			new Class[] { BtTravelExpense.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BtTravelExpenseClp clone = new BtTravelExpenseClp();

		clone.setBtTravelExpenseId(getBtTravelExpenseId());
		clone.setBusinessTripPkId(getBusinessTripPkId());
		clone.setTicketNo(getTicketNo());
		clone.setTravelDate(getTravelDate());
		clone.setDeparture(getDeparture());
		clone.setArrival(getArrival());
		clone.setFromCity(getFromCity());
		clone.setToCity(getToCity());
		clone.setIsHasBreakfast(getIsHasBreakfast());
		clone.setIsHasLunch(getIsHasLunch());
		clone.setIsHasDinner(getIsHasDinner());
		clone.setCountry(getCountry());
		clone.setCity(getCity());
		clone.setRateOfDma(getRateOfDma());
		clone.setCurrency(getCurrency());
		clone.setAllowance(getAllowance());
		clone.setComments(getComments());
		clone.setTripType(getTripType());
		clone.setAllowanceRmb(getAllowanceRmb());

		return clone;
	}

	@Override
	public int compareTo(BtTravelExpense btTravelExpense) {
		long primaryKey = btTravelExpense.getPrimaryKey();

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

		if (!(obj instanceof BtTravelExpenseClp)) {
			return false;
		}

		BtTravelExpenseClp btTravelExpense = (BtTravelExpenseClp)obj;

		long primaryKey = btTravelExpense.getPrimaryKey();

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
		StringBundler sb = new StringBundler(39);

		sb.append("{btTravelExpenseId=");
		sb.append(getBtTravelExpenseId());
		sb.append(", businessTripPkId=");
		sb.append(getBusinessTripPkId());
		sb.append(", ticketNo=");
		sb.append(getTicketNo());
		sb.append(", travelDate=");
		sb.append(getTravelDate());
		sb.append(", departure=");
		sb.append(getDeparture());
		sb.append(", arrival=");
		sb.append(getArrival());
		sb.append(", fromCity=");
		sb.append(getFromCity());
		sb.append(", toCity=");
		sb.append(getToCity());
		sb.append(", isHasBreakfast=");
		sb.append(getIsHasBreakfast());
		sb.append(", isHasLunch=");
		sb.append(getIsHasLunch());
		sb.append(", isHasDinner=");
		sb.append(getIsHasDinner());
		sb.append(", country=");
		sb.append(getCountry());
		sb.append(", city=");
		sb.append(getCity());
		sb.append(", rateOfDma=");
		sb.append(getRateOfDma());
		sb.append(", currency=");
		sb.append(getCurrency());
		sb.append(", allowance=");
		sb.append(getAllowance());
		sb.append(", comments=");
		sb.append(getComments());
		sb.append(", tripType=");
		sb.append(getTripType());
		sb.append(", allowanceRmb=");
		sb.append(getAllowanceRmb());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(61);

		sb.append("<model><model-name>");
		sb.append("com.business.trip.model.BtTravelExpense");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>btTravelExpenseId</column-name><column-value><![CDATA[");
		sb.append(getBtTravelExpenseId());
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
			"<column><column-name>travelDate</column-name><column-value><![CDATA[");
		sb.append(getTravelDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>departure</column-name><column-value><![CDATA[");
		sb.append(getDeparture());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>arrival</column-name><column-value><![CDATA[");
		sb.append(getArrival());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fromCity</column-name><column-value><![CDATA[");
		sb.append(getFromCity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>toCity</column-name><column-value><![CDATA[");
		sb.append(getToCity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isHasBreakfast</column-name><column-value><![CDATA[");
		sb.append(getIsHasBreakfast());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isHasLunch</column-name><column-value><![CDATA[");
		sb.append(getIsHasLunch());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isHasDinner</column-name><column-value><![CDATA[");
		sb.append(getIsHasDinner());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>country</column-name><column-value><![CDATA[");
		sb.append(getCountry());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>city</column-name><column-value><![CDATA[");
		sb.append(getCity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rateOfDma</column-name><column-value><![CDATA[");
		sb.append(getRateOfDma());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currency</column-name><column-value><![CDATA[");
		sb.append(getCurrency());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>allowance</column-name><column-value><![CDATA[");
		sb.append(getAllowance());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>comments</column-name><column-value><![CDATA[");
		sb.append(getComments());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tripType</column-name><column-value><![CDATA[");
		sb.append(getTripType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>allowanceRmb</column-name><column-value><![CDATA[");
		sb.append(getAllowanceRmb());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _btTravelExpenseId;
	private long _businessTripPkId;
	private String _ticketNo;
	private String _travelDate;
	private String _departure;
	private String _arrival;
	private String _fromCity;
	private String _toCity;
	private boolean _isHasBreakfast;
	private boolean _isHasLunch;
	private boolean _isHasDinner;
	private String _country;
	private String _city;
	private double _rateOfDma;
	private String _currency;
	private double _allowance;
	private String _comments;
	private String _tripType;
	private double _allowanceRmb;
	private BaseModel<?> _btTravelExpenseRemoteModel;
	private Class<?> _clpSerializerClass = com.business.trip.service.ClpSerializer.class;
}