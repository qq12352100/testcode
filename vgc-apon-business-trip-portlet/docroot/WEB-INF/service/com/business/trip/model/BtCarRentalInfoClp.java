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

import com.business.trip.service.BtCarRentalInfoLocalServiceUtil;
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
public class BtCarRentalInfoClp extends BaseModelImpl<BtCarRentalInfo>
	implements BtCarRentalInfo {
	public BtCarRentalInfoClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return BtCarRentalInfo.class;
	}

	@Override
	public String getModelClassName() {
		return BtCarRentalInfo.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _btCarRentalInfoId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBtCarRentalInfoId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _btCarRentalInfoId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("btCarRentalInfoId", getBtCarRentalInfoId());
		attributes.put("businessTripPkId", getBusinessTripPkId());
		attributes.put("ticketNo", getTicketNo());
		attributes.put("pickupLocation", getPickupLocation());
		attributes.put("pickupDate", getPickupDate());
		attributes.put("dropoffLocation", getDropoffLocation());
		attributes.put("dropoffDate", getDropoffDate());
		attributes.put("carType", getCarType());
		attributes.put("typeOfRental", getTypeOfRental());
		attributes.put("price", getPrice());
		attributes.put("currency", getCurrency());
		attributes.put("tripType", getTripType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long btCarRentalInfoId = (Long)attributes.get("btCarRentalInfoId");

		if (btCarRentalInfoId != null) {
			setBtCarRentalInfoId(btCarRentalInfoId);
		}

		Long businessTripPkId = (Long)attributes.get("businessTripPkId");

		if (businessTripPkId != null) {
			setBusinessTripPkId(businessTripPkId);
		}

		String ticketNo = (String)attributes.get("ticketNo");

		if (ticketNo != null) {
			setTicketNo(ticketNo);
		}

		String pickupLocation = (String)attributes.get("pickupLocation");

		if (pickupLocation != null) {
			setPickupLocation(pickupLocation);
		}

		Date pickupDate = (Date)attributes.get("pickupDate");

		if (pickupDate != null) {
			setPickupDate(pickupDate);
		}

		String dropoffLocation = (String)attributes.get("dropoffLocation");

		if (dropoffLocation != null) {
			setDropoffLocation(dropoffLocation);
		}

		Date dropoffDate = (Date)attributes.get("dropoffDate");

		if (dropoffDate != null) {
			setDropoffDate(dropoffDate);
		}

		String carType = (String)attributes.get("carType");

		if (carType != null) {
			setCarType(carType);
		}

		String typeOfRental = (String)attributes.get("typeOfRental");

		if (typeOfRental != null) {
			setTypeOfRental(typeOfRental);
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
	public long getBtCarRentalInfoId() {
		return _btCarRentalInfoId;
	}

	@Override
	public void setBtCarRentalInfoId(long btCarRentalInfoId) {
		_btCarRentalInfoId = btCarRentalInfoId;

		if (_btCarRentalInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btCarRentalInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setBtCarRentalInfoId",
						long.class);

				method.invoke(_btCarRentalInfoRemoteModel, btCarRentalInfoId);
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

		if (_btCarRentalInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btCarRentalInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setBusinessTripPkId",
						long.class);

				method.invoke(_btCarRentalInfoRemoteModel, businessTripPkId);
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

		if (_btCarRentalInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btCarRentalInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setTicketNo", String.class);

				method.invoke(_btCarRentalInfoRemoteModel, ticketNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPickupLocation() {
		return _pickupLocation;
	}

	@Override
	public void setPickupLocation(String pickupLocation) {
		_pickupLocation = pickupLocation;

		if (_btCarRentalInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btCarRentalInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setPickupLocation",
						String.class);

				method.invoke(_btCarRentalInfoRemoteModel, pickupLocation);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getPickupDate() {
		return _pickupDate;
	}

	@Override
	public void setPickupDate(Date pickupDate) {
		_pickupDate = pickupDate;

		if (_btCarRentalInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btCarRentalInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setPickupDate", Date.class);

				method.invoke(_btCarRentalInfoRemoteModel, pickupDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDropoffLocation() {
		return _dropoffLocation;
	}

	@Override
	public void setDropoffLocation(String dropoffLocation) {
		_dropoffLocation = dropoffLocation;

		if (_btCarRentalInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btCarRentalInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setDropoffLocation",
						String.class);

				method.invoke(_btCarRentalInfoRemoteModel, dropoffLocation);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDropoffDate() {
		return _dropoffDate;
	}

	@Override
	public void setDropoffDate(Date dropoffDate) {
		_dropoffDate = dropoffDate;

		if (_btCarRentalInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btCarRentalInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setDropoffDate", Date.class);

				method.invoke(_btCarRentalInfoRemoteModel, dropoffDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCarType() {
		return _carType;
	}

	@Override
	public void setCarType(String carType) {
		_carType = carType;

		if (_btCarRentalInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btCarRentalInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setCarType", String.class);

				method.invoke(_btCarRentalInfoRemoteModel, carType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTypeOfRental() {
		return _typeOfRental;
	}

	@Override
	public void setTypeOfRental(String typeOfRental) {
		_typeOfRental = typeOfRental;

		if (_btCarRentalInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btCarRentalInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setTypeOfRental", String.class);

				method.invoke(_btCarRentalInfoRemoteModel, typeOfRental);
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

		if (_btCarRentalInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btCarRentalInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setPrice", double.class);

				method.invoke(_btCarRentalInfoRemoteModel, price);
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

		if (_btCarRentalInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btCarRentalInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setCurrency", String.class);

				method.invoke(_btCarRentalInfoRemoteModel, currency);
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

		if (_btCarRentalInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btCarRentalInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setTripType", String.class);

				method.invoke(_btCarRentalInfoRemoteModel, tripType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getBtCarRentalInfoRemoteModel() {
		return _btCarRentalInfoRemoteModel;
	}

	public void setBtCarRentalInfoRemoteModel(
		BaseModel<?> btCarRentalInfoRemoteModel) {
		_btCarRentalInfoRemoteModel = btCarRentalInfoRemoteModel;
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

		Class<?> remoteModelClass = _btCarRentalInfoRemoteModel.getClass();

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

		Object returnValue = method.invoke(_btCarRentalInfoRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			BtCarRentalInfoLocalServiceUtil.addBtCarRentalInfo(this);
		}
		else {
			BtCarRentalInfoLocalServiceUtil.updateBtCarRentalInfo(this);
		}
	}

	@Override
	public BtCarRentalInfo toEscapedModel() {
		return (BtCarRentalInfo)ProxyUtil.newProxyInstance(BtCarRentalInfo.class.getClassLoader(),
			new Class[] { BtCarRentalInfo.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BtCarRentalInfoClp clone = new BtCarRentalInfoClp();

		clone.setBtCarRentalInfoId(getBtCarRentalInfoId());
		clone.setBusinessTripPkId(getBusinessTripPkId());
		clone.setTicketNo(getTicketNo());
		clone.setPickupLocation(getPickupLocation());
		clone.setPickupDate(getPickupDate());
		clone.setDropoffLocation(getDropoffLocation());
		clone.setDropoffDate(getDropoffDate());
		clone.setCarType(getCarType());
		clone.setTypeOfRental(getTypeOfRental());
		clone.setPrice(getPrice());
		clone.setCurrency(getCurrency());
		clone.setTripType(getTripType());

		return clone;
	}

	@Override
	public int compareTo(BtCarRentalInfo btCarRentalInfo) {
		long primaryKey = btCarRentalInfo.getPrimaryKey();

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

		if (!(obj instanceof BtCarRentalInfoClp)) {
			return false;
		}

		BtCarRentalInfoClp btCarRentalInfo = (BtCarRentalInfoClp)obj;

		long primaryKey = btCarRentalInfo.getPrimaryKey();

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
		StringBundler sb = new StringBundler(25);

		sb.append("{btCarRentalInfoId=");
		sb.append(getBtCarRentalInfoId());
		sb.append(", businessTripPkId=");
		sb.append(getBusinessTripPkId());
		sb.append(", ticketNo=");
		sb.append(getTicketNo());
		sb.append(", pickupLocation=");
		sb.append(getPickupLocation());
		sb.append(", pickupDate=");
		sb.append(getPickupDate());
		sb.append(", dropoffLocation=");
		sb.append(getDropoffLocation());
		sb.append(", dropoffDate=");
		sb.append(getDropoffDate());
		sb.append(", carType=");
		sb.append(getCarType());
		sb.append(", typeOfRental=");
		sb.append(getTypeOfRental());
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
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.business.trip.model.BtCarRentalInfo");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>btCarRentalInfoId</column-name><column-value><![CDATA[");
		sb.append(getBtCarRentalInfoId());
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
			"<column><column-name>pickupLocation</column-name><column-value><![CDATA[");
		sb.append(getPickupLocation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pickupDate</column-name><column-value><![CDATA[");
		sb.append(getPickupDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dropoffLocation</column-name><column-value><![CDATA[");
		sb.append(getDropoffLocation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dropoffDate</column-name><column-value><![CDATA[");
		sb.append(getDropoffDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>carType</column-name><column-value><![CDATA[");
		sb.append(getCarType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>typeOfRental</column-name><column-value><![CDATA[");
		sb.append(getTypeOfRental());
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

	private long _btCarRentalInfoId;
	private long _businessTripPkId;
	private String _ticketNo;
	private String _pickupLocation;
	private Date _pickupDate;
	private String _dropoffLocation;
	private Date _dropoffDate;
	private String _carType;
	private String _typeOfRental;
	private double _price;
	private String _currency;
	private String _tripType;
	private BaseModel<?> _btCarRentalInfoRemoteModel;
	private Class<?> _clpSerializerClass = com.business.trip.service.ClpSerializer.class;
}