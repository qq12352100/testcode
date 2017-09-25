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

import com.business.trip.service.BtHotelInfoLocalServiceUtil;
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
public class BtHotelInfoClp extends BaseModelImpl<BtHotelInfo>
	implements BtHotelInfo {
	public BtHotelInfoClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return BtHotelInfo.class;
	}

	@Override
	public String getModelClassName() {
		return BtHotelInfo.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _btHotelInfoId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBtHotelInfoId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _btHotelInfoId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("btHotelInfoId", getBtHotelInfoId());
		attributes.put("businessTripPkId", getBusinessTripPkId());
		attributes.put("ticketNo", getTicketNo());
		attributes.put("city", getCity());
		attributes.put("cityType", getCityType());
		attributes.put("hotel", getHotel());
		attributes.put("checkIn", getCheckIn());
		attributes.put("checkOut", getCheckOut());
		attributes.put("roomCategory", getRoomCategory());
		attributes.put("price", getPrice());
		attributes.put("currency", getCurrency());
		attributes.put("otherReasonInfo", getOtherReasonInfo());
		attributes.put("isNotBookedFromTA", getIsNotBookedFromTA());
		attributes.put("isOverBudget", getIsOverBudget());
		attributes.put("othersSpecify", getOthersSpecify());
		attributes.put("tripType", getTripType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long btHotelInfoId = (Long)attributes.get("btHotelInfoId");

		if (btHotelInfoId != null) {
			setBtHotelInfoId(btHotelInfoId);
		}

		Long businessTripPkId = (Long)attributes.get("businessTripPkId");

		if (businessTripPkId != null) {
			setBusinessTripPkId(businessTripPkId);
		}

		String ticketNo = (String)attributes.get("ticketNo");

		if (ticketNo != null) {
			setTicketNo(ticketNo);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String cityType = (String)attributes.get("cityType");

		if (cityType != null) {
			setCityType(cityType);
		}

		String hotel = (String)attributes.get("hotel");

		if (hotel != null) {
			setHotel(hotel);
		}

		Date checkIn = (Date)attributes.get("checkIn");

		if (checkIn != null) {
			setCheckIn(checkIn);
		}

		Date checkOut = (Date)attributes.get("checkOut");

		if (checkOut != null) {
			setCheckOut(checkOut);
		}

		String roomCategory = (String)attributes.get("roomCategory");

		if (roomCategory != null) {
			setRoomCategory(roomCategory);
		}

		Double price = (Double)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}

		String currency = (String)attributes.get("currency");

		if (currency != null) {
			setCurrency(currency);
		}

		String otherReasonInfo = (String)attributes.get("otherReasonInfo");

		if (otherReasonInfo != null) {
			setOtherReasonInfo(otherReasonInfo);
		}

		Boolean isNotBookedFromTA = (Boolean)attributes.get("isNotBookedFromTA");

		if (isNotBookedFromTA != null) {
			setIsNotBookedFromTA(isNotBookedFromTA);
		}

		Integer isOverBudget = (Integer)attributes.get("isOverBudget");

		if (isOverBudget != null) {
			setIsOverBudget(isOverBudget);
		}

		String othersSpecify = (String)attributes.get("othersSpecify");

		if (othersSpecify != null) {
			setOthersSpecify(othersSpecify);
		}

		String tripType = (String)attributes.get("tripType");

		if (tripType != null) {
			setTripType(tripType);
		}
	}

	@Override
	public long getBtHotelInfoId() {
		return _btHotelInfoId;
	}

	@Override
	public void setBtHotelInfoId(long btHotelInfoId) {
		_btHotelInfoId = btHotelInfoId;

		if (_btHotelInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btHotelInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setBtHotelInfoId", long.class);

				method.invoke(_btHotelInfoRemoteModel, btHotelInfoId);
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

		if (_btHotelInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btHotelInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setBusinessTripPkId",
						long.class);

				method.invoke(_btHotelInfoRemoteModel, businessTripPkId);
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

		if (_btHotelInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btHotelInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setTicketNo", String.class);

				method.invoke(_btHotelInfoRemoteModel, ticketNo);
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

		if (_btHotelInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btHotelInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setCity", String.class);

				method.invoke(_btHotelInfoRemoteModel, city);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCityType() {
		return _cityType;
	}

	@Override
	public void setCityType(String cityType) {
		_cityType = cityType;

		if (_btHotelInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btHotelInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setCityType", String.class);

				method.invoke(_btHotelInfoRemoteModel, cityType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHotel() {
		return _hotel;
	}

	@Override
	public void setHotel(String hotel) {
		_hotel = hotel;

		if (_btHotelInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btHotelInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setHotel", String.class);

				method.invoke(_btHotelInfoRemoteModel, hotel);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCheckIn() {
		return _checkIn;
	}

	@Override
	public void setCheckIn(Date checkIn) {
		_checkIn = checkIn;

		if (_btHotelInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btHotelInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setCheckIn", Date.class);

				method.invoke(_btHotelInfoRemoteModel, checkIn);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCheckOut() {
		return _checkOut;
	}

	@Override
	public void setCheckOut(Date checkOut) {
		_checkOut = checkOut;

		if (_btHotelInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btHotelInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setCheckOut", Date.class);

				method.invoke(_btHotelInfoRemoteModel, checkOut);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRoomCategory() {
		return _roomCategory;
	}

	@Override
	public void setRoomCategory(String roomCategory) {
		_roomCategory = roomCategory;

		if (_btHotelInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btHotelInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setRoomCategory", String.class);

				method.invoke(_btHotelInfoRemoteModel, roomCategory);
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

		if (_btHotelInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btHotelInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setPrice", double.class);

				method.invoke(_btHotelInfoRemoteModel, price);
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

		if (_btHotelInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btHotelInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setCurrency", String.class);

				method.invoke(_btHotelInfoRemoteModel, currency);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOtherReasonInfo() {
		return _otherReasonInfo;
	}

	@Override
	public void setOtherReasonInfo(String otherReasonInfo) {
		_otherReasonInfo = otherReasonInfo;

		if (_btHotelInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btHotelInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setOtherReasonInfo",
						String.class);

				method.invoke(_btHotelInfoRemoteModel, otherReasonInfo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsNotBookedFromTA() {
		return _isNotBookedFromTA;
	}

	@Override
	public boolean isIsNotBookedFromTA() {
		return _isNotBookedFromTA;
	}

	@Override
	public void setIsNotBookedFromTA(boolean isNotBookedFromTA) {
		_isNotBookedFromTA = isNotBookedFromTA;

		if (_btHotelInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btHotelInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setIsNotBookedFromTA",
						boolean.class);

				method.invoke(_btHotelInfoRemoteModel, isNotBookedFromTA);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getIsOverBudget() {
		return _isOverBudget;
	}

	@Override
	public void setIsOverBudget(int isOverBudget) {
		_isOverBudget = isOverBudget;

		if (_btHotelInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btHotelInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setIsOverBudget", int.class);

				method.invoke(_btHotelInfoRemoteModel, isOverBudget);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOthersSpecify() {
		return _othersSpecify;
	}

	@Override
	public void setOthersSpecify(String othersSpecify) {
		_othersSpecify = othersSpecify;

		if (_btHotelInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btHotelInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setOthersSpecify", String.class);

				method.invoke(_btHotelInfoRemoteModel, othersSpecify);
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

		if (_btHotelInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btHotelInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setTripType", String.class);

				method.invoke(_btHotelInfoRemoteModel, tripType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getBtHotelInfoRemoteModel() {
		return _btHotelInfoRemoteModel;
	}

	public void setBtHotelInfoRemoteModel(BaseModel<?> btHotelInfoRemoteModel) {
		_btHotelInfoRemoteModel = btHotelInfoRemoteModel;
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

		Class<?> remoteModelClass = _btHotelInfoRemoteModel.getClass();

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

		Object returnValue = method.invoke(_btHotelInfoRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			BtHotelInfoLocalServiceUtil.addBtHotelInfo(this);
		}
		else {
			BtHotelInfoLocalServiceUtil.updateBtHotelInfo(this);
		}
	}

	@Override
	public BtHotelInfo toEscapedModel() {
		return (BtHotelInfo)ProxyUtil.newProxyInstance(BtHotelInfo.class.getClassLoader(),
			new Class[] { BtHotelInfo.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BtHotelInfoClp clone = new BtHotelInfoClp();

		clone.setBtHotelInfoId(getBtHotelInfoId());
		clone.setBusinessTripPkId(getBusinessTripPkId());
		clone.setTicketNo(getTicketNo());
		clone.setCity(getCity());
		clone.setCityType(getCityType());
		clone.setHotel(getHotel());
		clone.setCheckIn(getCheckIn());
		clone.setCheckOut(getCheckOut());
		clone.setRoomCategory(getRoomCategory());
		clone.setPrice(getPrice());
		clone.setCurrency(getCurrency());
		clone.setOtherReasonInfo(getOtherReasonInfo());
		clone.setIsNotBookedFromTA(getIsNotBookedFromTA());
		clone.setIsOverBudget(getIsOverBudget());
		clone.setOthersSpecify(getOthersSpecify());
		clone.setTripType(getTripType());

		return clone;
	}

	@Override
	public int compareTo(BtHotelInfo btHotelInfo) {
		long primaryKey = btHotelInfo.getPrimaryKey();

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

		if (!(obj instanceof BtHotelInfoClp)) {
			return false;
		}

		BtHotelInfoClp btHotelInfo = (BtHotelInfoClp)obj;

		long primaryKey = btHotelInfo.getPrimaryKey();

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
		StringBundler sb = new StringBundler(33);

		sb.append("{btHotelInfoId=");
		sb.append(getBtHotelInfoId());
		sb.append(", businessTripPkId=");
		sb.append(getBusinessTripPkId());
		sb.append(", ticketNo=");
		sb.append(getTicketNo());
		sb.append(", city=");
		sb.append(getCity());
		sb.append(", cityType=");
		sb.append(getCityType());
		sb.append(", hotel=");
		sb.append(getHotel());
		sb.append(", checkIn=");
		sb.append(getCheckIn());
		sb.append(", checkOut=");
		sb.append(getCheckOut());
		sb.append(", roomCategory=");
		sb.append(getRoomCategory());
		sb.append(", price=");
		sb.append(getPrice());
		sb.append(", currency=");
		sb.append(getCurrency());
		sb.append(", otherReasonInfo=");
		sb.append(getOtherReasonInfo());
		sb.append(", isNotBookedFromTA=");
		sb.append(getIsNotBookedFromTA());
		sb.append(", isOverBudget=");
		sb.append(getIsOverBudget());
		sb.append(", othersSpecify=");
		sb.append(getOthersSpecify());
		sb.append(", tripType=");
		sb.append(getTripType());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(52);

		sb.append("<model><model-name>");
		sb.append("com.business.trip.model.BtHotelInfo");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>btHotelInfoId</column-name><column-value><![CDATA[");
		sb.append(getBtHotelInfoId());
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
			"<column><column-name>city</column-name><column-value><![CDATA[");
		sb.append(getCity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cityType</column-name><column-value><![CDATA[");
		sb.append(getCityType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hotel</column-name><column-value><![CDATA[");
		sb.append(getHotel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>checkIn</column-name><column-value><![CDATA[");
		sb.append(getCheckIn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>checkOut</column-name><column-value><![CDATA[");
		sb.append(getCheckOut());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>roomCategory</column-name><column-value><![CDATA[");
		sb.append(getRoomCategory());
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
			"<column><column-name>otherReasonInfo</column-name><column-value><![CDATA[");
		sb.append(getOtherReasonInfo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isNotBookedFromTA</column-name><column-value><![CDATA[");
		sb.append(getIsNotBookedFromTA());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isOverBudget</column-name><column-value><![CDATA[");
		sb.append(getIsOverBudget());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>othersSpecify</column-name><column-value><![CDATA[");
		sb.append(getOthersSpecify());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tripType</column-name><column-value><![CDATA[");
		sb.append(getTripType());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _btHotelInfoId;
	private long _businessTripPkId;
	private String _ticketNo;
	private String _city;
	private String _cityType;
	private String _hotel;
	private Date _checkIn;
	private Date _checkOut;
	private String _roomCategory;
	private double _price;
	private String _currency;
	private String _otherReasonInfo;
	private boolean _isNotBookedFromTA;
	private int _isOverBudget;
	private String _othersSpecify;
	private String _tripType;
	private BaseModel<?> _btHotelInfoRemoteModel;
	private Class<?> _clpSerializerClass = com.business.trip.service.ClpSerializer.class;
}