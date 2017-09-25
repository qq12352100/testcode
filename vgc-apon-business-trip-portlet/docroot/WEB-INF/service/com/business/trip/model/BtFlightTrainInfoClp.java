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

import com.business.trip.service.BtFlightTrainInfoLocalServiceUtil;
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
public class BtFlightTrainInfoClp extends BaseModelImpl<BtFlightTrainInfo>
	implements BtFlightTrainInfo {
	public BtFlightTrainInfoClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return BtFlightTrainInfo.class;
	}

	@Override
	public String getModelClassName() {
		return BtFlightTrainInfo.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _btFlightTrainInfoId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBtFlightTrainInfoId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _btFlightTrainInfoId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("btFlightTrainInfoId", getBtFlightTrainInfoId());
		attributes.put("businessTripPkId", getBusinessTripPkId());
		attributes.put("ticketNo", getTicketNo());
		attributes.put("type", getType());
		attributes.put("fromCity", getFromCity());
		attributes.put("toCity", getToCity());
		attributes.put("departureDate", getDepartureDate());
		attributes.put("departureFlight", getDepartureFlight());
		attributes.put("departureTime", getDepartureTime());
		attributes.put("classInfo", getClassInfo());
		attributes.put("price", getPrice());
		attributes.put("currency", getCurrency());
		attributes.put("tripType", getTripType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long btFlightTrainInfoId = (Long)attributes.get("btFlightTrainInfoId");

		if (btFlightTrainInfoId != null) {
			setBtFlightTrainInfoId(btFlightTrainInfoId);
		}

		Long businessTripPkId = (Long)attributes.get("businessTripPkId");

		if (businessTripPkId != null) {
			setBusinessTripPkId(businessTripPkId);
		}

		String ticketNo = (String)attributes.get("ticketNo");

		if (ticketNo != null) {
			setTicketNo(ticketNo);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String fromCity = (String)attributes.get("fromCity");

		if (fromCity != null) {
			setFromCity(fromCity);
		}

		String toCity = (String)attributes.get("toCity");

		if (toCity != null) {
			setToCity(toCity);
		}

		Date departureDate = (Date)attributes.get("departureDate");

		if (departureDate != null) {
			setDepartureDate(departureDate);
		}

		String departureFlight = (String)attributes.get("departureFlight");

		if (departureFlight != null) {
			setDepartureFlight(departureFlight);
		}

		Date departureTime = (Date)attributes.get("departureTime");

		if (departureTime != null) {
			setDepartureTime(departureTime);
		}

		String classInfo = (String)attributes.get("classInfo");

		if (classInfo != null) {
			setClassInfo(classInfo);
		}

		Double price = (Double)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}

		String currency = (String)attributes.get("currency");

		if (currency != null) {
			setCurrency(currency);
		}

		String tripType = (String)attributes.get("tripType");

		if (tripType != null) {
			setTripType(tripType);
		}
	}

	@Override
	public long getBtFlightTrainInfoId() {
		return _btFlightTrainInfoId;
	}

	@Override
	public void setBtFlightTrainInfoId(long btFlightTrainInfoId) {
		_btFlightTrainInfoId = btFlightTrainInfoId;

		if (_btFlightTrainInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btFlightTrainInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setBtFlightTrainInfoId",
						long.class);

				method.invoke(_btFlightTrainInfoRemoteModel, btFlightTrainInfoId);
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

		if (_btFlightTrainInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btFlightTrainInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setBusinessTripPkId",
						long.class);

				method.invoke(_btFlightTrainInfoRemoteModel, businessTripPkId);
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

		if (_btFlightTrainInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btFlightTrainInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setTicketNo", String.class);

				method.invoke(_btFlightTrainInfoRemoteModel, ticketNo);
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

		if (_btFlightTrainInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btFlightTrainInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setType", String.class);

				method.invoke(_btFlightTrainInfoRemoteModel, type);
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

		if (_btFlightTrainInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btFlightTrainInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setFromCity", String.class);

				method.invoke(_btFlightTrainInfoRemoteModel, fromCity);
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

		if (_btFlightTrainInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btFlightTrainInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setToCity", String.class);

				method.invoke(_btFlightTrainInfoRemoteModel, toCity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDepartureDate() {
		return _departureDate;
	}

	@Override
	public void setDepartureDate(Date departureDate) {
		_departureDate = departureDate;

		if (_btFlightTrainInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btFlightTrainInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setDepartureDate", Date.class);

				method.invoke(_btFlightTrainInfoRemoteModel, departureDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDepartureFlight() {
		return _departureFlight;
	}

	@Override
	public void setDepartureFlight(String departureFlight) {
		_departureFlight = departureFlight;

		if (_btFlightTrainInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btFlightTrainInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setDepartureFlight",
						String.class);

				method.invoke(_btFlightTrainInfoRemoteModel, departureFlight);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDepartureTime() {
		return _departureTime;
	}

	@Override
	public void setDepartureTime(Date departureTime) {
		_departureTime = departureTime;

		if (_btFlightTrainInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btFlightTrainInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setDepartureTime", Date.class);

				method.invoke(_btFlightTrainInfoRemoteModel, departureTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getClassInfo() {
		return _classInfo;
	}

	@Override
	public void setClassInfo(String classInfo) {
		_classInfo = classInfo;

		if (_btFlightTrainInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btFlightTrainInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setClassInfo", String.class);

				method.invoke(_btFlightTrainInfoRemoteModel, classInfo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getPrice() {
		return _price;
	}

	@Override
	public void setPrice(double price) {
		_price = price;

		if (_btFlightTrainInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btFlightTrainInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setPrice", double.class);

				method.invoke(_btFlightTrainInfoRemoteModel, price);
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

		if (_btFlightTrainInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btFlightTrainInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setCurrency", String.class);

				method.invoke(_btFlightTrainInfoRemoteModel, currency);
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

		if (_btFlightTrainInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btFlightTrainInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setTripType", String.class);

				method.invoke(_btFlightTrainInfoRemoteModel, tripType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getBtFlightTrainInfoRemoteModel() {
		return _btFlightTrainInfoRemoteModel;
	}

	public void setBtFlightTrainInfoRemoteModel(
		BaseModel<?> btFlightTrainInfoRemoteModel) {
		_btFlightTrainInfoRemoteModel = btFlightTrainInfoRemoteModel;
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

		Class<?> remoteModelClass = _btFlightTrainInfoRemoteModel.getClass();

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

		Object returnValue = method.invoke(_btFlightTrainInfoRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			BtFlightTrainInfoLocalServiceUtil.addBtFlightTrainInfo(this);
		}
		else {
			BtFlightTrainInfoLocalServiceUtil.updateBtFlightTrainInfo(this);
		}
	}

	@Override
	public BtFlightTrainInfo toEscapedModel() {
		return (BtFlightTrainInfo)ProxyUtil.newProxyInstance(BtFlightTrainInfo.class.getClassLoader(),
			new Class[] { BtFlightTrainInfo.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BtFlightTrainInfoClp clone = new BtFlightTrainInfoClp();

		clone.setBtFlightTrainInfoId(getBtFlightTrainInfoId());
		clone.setBusinessTripPkId(getBusinessTripPkId());
		clone.setTicketNo(getTicketNo());
		clone.setType(getType());
		clone.setFromCity(getFromCity());
		clone.setToCity(getToCity());
		clone.setDepartureDate(getDepartureDate());
		clone.setDepartureFlight(getDepartureFlight());
		clone.setDepartureTime(getDepartureTime());
		clone.setClassInfo(getClassInfo());
		clone.setPrice(getPrice());
		clone.setCurrency(getCurrency());
		clone.setTripType(getTripType());

		return clone;
	}

	@Override
	public int compareTo(BtFlightTrainInfo btFlightTrainInfo) {
		long primaryKey = btFlightTrainInfo.getPrimaryKey();

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

		if (!(obj instanceof BtFlightTrainInfoClp)) {
			return false;
		}

		BtFlightTrainInfoClp btFlightTrainInfo = (BtFlightTrainInfoClp)obj;

		long primaryKey = btFlightTrainInfo.getPrimaryKey();

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
		StringBundler sb = new StringBundler(27);

		sb.append("{btFlightTrainInfoId=");
		sb.append(getBtFlightTrainInfoId());
		sb.append(", businessTripPkId=");
		sb.append(getBusinessTripPkId());
		sb.append(", ticketNo=");
		sb.append(getTicketNo());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", fromCity=");
		sb.append(getFromCity());
		sb.append(", toCity=");
		sb.append(getToCity());
		sb.append(", departureDate=");
		sb.append(getDepartureDate());
		sb.append(", departureFlight=");
		sb.append(getDepartureFlight());
		sb.append(", departureTime=");
		sb.append(getDepartureTime());
		sb.append(", classInfo=");
		sb.append(getClassInfo());
		sb.append(", price=");
		sb.append(getPrice());
		sb.append(", currency=");
		sb.append(getCurrency());
		sb.append(", tripType=");
		sb.append(getTripType());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.business.trip.model.BtFlightTrainInfo");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>btFlightTrainInfoId</column-name><column-value><![CDATA[");
		sb.append(getBtFlightTrainInfoId());
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
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
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
			"<column><column-name>departureDate</column-name><column-value><![CDATA[");
		sb.append(getDepartureDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>departureFlight</column-name><column-value><![CDATA[");
		sb.append(getDepartureFlight());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>departureTime</column-name><column-value><![CDATA[");
		sb.append(getDepartureTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classInfo</column-name><column-value><![CDATA[");
		sb.append(getClassInfo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>price</column-name><column-value><![CDATA[");
		sb.append(getPrice());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currency</column-name><column-value><![CDATA[");
		sb.append(getCurrency());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tripType</column-name><column-value><![CDATA[");
		sb.append(getTripType());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _btFlightTrainInfoId;
	private long _businessTripPkId;
	private String _ticketNo;
	private String _type;
	private String _fromCity;
	private String _toCity;
	private Date _departureDate;
	private String _departureFlight;
	private Date _departureTime;
	private String _classInfo;
	private double _price;
	private String _currency;
	private String _tripType;
	private BaseModel<?> _btFlightTrainInfoRemoteModel;
	private Class<?> _clpSerializerClass = com.business.trip.service.ClpSerializer.class;
}