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

import com.business.trip.service.BtTrainInfoLocalServiceUtil;
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
public class BtTrainInfoClp extends BaseModelImpl<BtTrainInfo>
	implements BtTrainInfo {
	public BtTrainInfoClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return BtTrainInfo.class;
	}

	@Override
	public String getModelClassName() {
		return BtTrainInfo.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _btTrainInfoId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBtTrainInfoId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _btTrainInfoId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("btTrainInfoId", getBtTrainInfoId());
		attributes.put("businessTripPkId", getBusinessTripPkId());
		attributes.put("ticketNo", getTicketNo());
		attributes.put("fromCity", getFromCity());
		attributes.put("toCity", getToCity());
		attributes.put("departureDate", getDepartureDate());
		attributes.put("departureTrain", getDepartureTrain());
		attributes.put("classInfo", getClassInfo());
		attributes.put("price", getPrice());
		attributes.put("currency", getCurrency());
		attributes.put("tripType", getTripType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long btTrainInfoId = (Long)attributes.get("btTrainInfoId");

		if (btTrainInfoId != null) {
			setBtTrainInfoId(btTrainInfoId);
		}

		Long businessTripPkId = (Long)attributes.get("businessTripPkId");

		if (businessTripPkId != null) {
			setBusinessTripPkId(businessTripPkId);
		}

		String ticketNo = (String)attributes.get("ticketNo");

		if (ticketNo != null) {
			setTicketNo(ticketNo);
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

		String departureTrain = (String)attributes.get("departureTrain");

		if (departureTrain != null) {
			setDepartureTrain(departureTrain);
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
	public long getBtTrainInfoId() {
		return _btTrainInfoId;
	}

	@Override
	public void setBtTrainInfoId(long btTrainInfoId) {
		_btTrainInfoId = btTrainInfoId;

		if (_btTrainInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btTrainInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setBtTrainInfoId", long.class);

				method.invoke(_btTrainInfoRemoteModel, btTrainInfoId);
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

		if (_btTrainInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btTrainInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setBusinessTripPkId",
						long.class);

				method.invoke(_btTrainInfoRemoteModel, businessTripPkId);
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

		if (_btTrainInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btTrainInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setTicketNo", String.class);

				method.invoke(_btTrainInfoRemoteModel, ticketNo);
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

		if (_btTrainInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btTrainInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setFromCity", String.class);

				method.invoke(_btTrainInfoRemoteModel, fromCity);
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

		if (_btTrainInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btTrainInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setToCity", String.class);

				method.invoke(_btTrainInfoRemoteModel, toCity);
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

		if (_btTrainInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btTrainInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setDepartureDate", Date.class);

				method.invoke(_btTrainInfoRemoteModel, departureDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDepartureTrain() {
		return _departureTrain;
	}

	@Override
	public void setDepartureTrain(String departureTrain) {
		_departureTrain = departureTrain;

		if (_btTrainInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btTrainInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setDepartureTrain",
						String.class);

				method.invoke(_btTrainInfoRemoteModel, departureTrain);
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

		if (_btTrainInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btTrainInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setClassInfo", String.class);

				method.invoke(_btTrainInfoRemoteModel, classInfo);
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

		if (_btTrainInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btTrainInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setPrice", double.class);

				method.invoke(_btTrainInfoRemoteModel, price);
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

		if (_btTrainInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btTrainInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setCurrency", String.class);

				method.invoke(_btTrainInfoRemoteModel, currency);
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

		if (_btTrainInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btTrainInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setTripType", String.class);

				method.invoke(_btTrainInfoRemoteModel, tripType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getBtTrainInfoRemoteModel() {
		return _btTrainInfoRemoteModel;
	}

	public void setBtTrainInfoRemoteModel(BaseModel<?> btTrainInfoRemoteModel) {
		_btTrainInfoRemoteModel = btTrainInfoRemoteModel;
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

		Class<?> remoteModelClass = _btTrainInfoRemoteModel.getClass();

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

		Object returnValue = method.invoke(_btTrainInfoRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			BtTrainInfoLocalServiceUtil.addBtTrainInfo(this);
		}
		else {
			BtTrainInfoLocalServiceUtil.updateBtTrainInfo(this);
		}
	}

	@Override
	public BtTrainInfo toEscapedModel() {
		return (BtTrainInfo)ProxyUtil.newProxyInstance(BtTrainInfo.class.getClassLoader(),
			new Class[] { BtTrainInfo.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BtTrainInfoClp clone = new BtTrainInfoClp();

		clone.setBtTrainInfoId(getBtTrainInfoId());
		clone.setBusinessTripPkId(getBusinessTripPkId());
		clone.setTicketNo(getTicketNo());
		clone.setFromCity(getFromCity());
		clone.setToCity(getToCity());
		clone.setDepartureDate(getDepartureDate());
		clone.setDepartureTrain(getDepartureTrain());
		clone.setClassInfo(getClassInfo());
		clone.setPrice(getPrice());
		clone.setCurrency(getCurrency());
		clone.setTripType(getTripType());

		return clone;
	}

	@Override
	public int compareTo(BtTrainInfo btTrainInfo) {
		long primaryKey = btTrainInfo.getPrimaryKey();

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

		if (!(obj instanceof BtTrainInfoClp)) {
			return false;
		}

		BtTrainInfoClp btTrainInfo = (BtTrainInfoClp)obj;

		long primaryKey = btTrainInfo.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{btTrainInfoId=");
		sb.append(getBtTrainInfoId());
		sb.append(", businessTripPkId=");
		sb.append(getBusinessTripPkId());
		sb.append(", ticketNo=");
		sb.append(getTicketNo());
		sb.append(", fromCity=");
		sb.append(getFromCity());
		sb.append(", toCity=");
		sb.append(getToCity());
		sb.append(", departureDate=");
		sb.append(getDepartureDate());
		sb.append(", departureTrain=");
		sb.append(getDepartureTrain());
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
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.business.trip.model.BtTrainInfo");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>btTrainInfoId</column-name><column-value><![CDATA[");
		sb.append(getBtTrainInfoId());
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
			"<column><column-name>departureTrain</column-name><column-value><![CDATA[");
		sb.append(getDepartureTrain());
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

	private long _btTrainInfoId;
	private long _businessTripPkId;
	private String _ticketNo;
	private String _fromCity;
	private String _toCity;
	private Date _departureDate;
	private String _departureTrain;
	private String _classInfo;
	private double _price;
	private String _currency;
	private String _tripType;
	private BaseModel<?> _btTrainInfoRemoteModel;
	private Class<?> _clpSerializerClass = com.business.trip.service.ClpSerializer.class;
}