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

import com.business.trip.service.BtReimbursementSAPInfoLocalServiceUtil;
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
public class BtReimbursementSAPInfoClp extends BaseModelImpl<BtReimbursementSAPInfo>
	implements BtReimbursementSAPInfo {
	public BtReimbursementSAPInfoClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return BtReimbursementSAPInfo.class;
	}

	@Override
	public String getModelClassName() {
		return BtReimbursementSAPInfo.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _btReimbursementSAPInfoId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBtReimbursementSAPInfoId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _btReimbursementSAPInfoId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("btReimbursementSAPInfoId", getBtReimbursementSAPInfoId());
		attributes.put("businessTripPkId", getBusinessTripPkId());
		attributes.put("ticketNo", getTicketNo());
		attributes.put("currency", getCurrency());
		attributes.put("step", getStep());
		attributes.put("messageType", getMessageType());
		attributes.put("message", getMessage());
		attributes.put("certificateNo", getCertificateNo());
		attributes.put("company", getCompany());
		attributes.put("year", getYear());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long btReimbursementSAPInfoId = (Long)attributes.get(
				"btReimbursementSAPInfoId");

		if (btReimbursementSAPInfoId != null) {
			setBtReimbursementSAPInfoId(btReimbursementSAPInfoId);
		}

		Long businessTripPkId = (Long)attributes.get("businessTripPkId");

		if (businessTripPkId != null) {
			setBusinessTripPkId(businessTripPkId);
		}

		String ticketNo = (String)attributes.get("ticketNo");

		if (ticketNo != null) {
			setTicketNo(ticketNo);
		}

		String currency = (String)attributes.get("currency");

		if (currency != null) {
			setCurrency(currency);
		}

		Integer step = (Integer)attributes.get("step");

		if (step != null) {
			setStep(step);
		}

		String messageType = (String)attributes.get("messageType");

		if (messageType != null) {
			setMessageType(messageType);
		}

		String message = (String)attributes.get("message");

		if (message != null) {
			setMessage(message);
		}

		String certificateNo = (String)attributes.get("certificateNo");

		if (certificateNo != null) {
			setCertificateNo(certificateNo);
		}

		String company = (String)attributes.get("company");

		if (company != null) {
			setCompany(company);
		}

		String year = (String)attributes.get("year");

		if (year != null) {
			setYear(year);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public long getBtReimbursementSAPInfoId() {
		return _btReimbursementSAPInfoId;
	}

	@Override
	public void setBtReimbursementSAPInfoId(long btReimbursementSAPInfoId) {
		_btReimbursementSAPInfoId = btReimbursementSAPInfoId;

		if (_btReimbursementSAPInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btReimbursementSAPInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setBtReimbursementSAPInfoId",
						long.class);

				method.invoke(_btReimbursementSAPInfoRemoteModel,
					btReimbursementSAPInfoId);
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

		if (_btReimbursementSAPInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btReimbursementSAPInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setBusinessTripPkId",
						long.class);

				method.invoke(_btReimbursementSAPInfoRemoteModel,
					businessTripPkId);
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

		if (_btReimbursementSAPInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btReimbursementSAPInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setTicketNo", String.class);

				method.invoke(_btReimbursementSAPInfoRemoteModel, ticketNo);
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

		if (_btReimbursementSAPInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btReimbursementSAPInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setCurrency", String.class);

				method.invoke(_btReimbursementSAPInfoRemoteModel, currency);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStep() {
		return _step;
	}

	@Override
	public void setStep(int step) {
		_step = step;

		if (_btReimbursementSAPInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btReimbursementSAPInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setStep", int.class);

				method.invoke(_btReimbursementSAPInfoRemoteModel, step);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMessageType() {
		return _messageType;
	}

	@Override
	public void setMessageType(String messageType) {
		_messageType = messageType;

		if (_btReimbursementSAPInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btReimbursementSAPInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setMessageType", String.class);

				method.invoke(_btReimbursementSAPInfoRemoteModel, messageType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMessage() {
		return _message;
	}

	@Override
	public void setMessage(String message) {
		_message = message;

		if (_btReimbursementSAPInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btReimbursementSAPInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setMessage", String.class);

				method.invoke(_btReimbursementSAPInfoRemoteModel, message);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCertificateNo() {
		return _certificateNo;
	}

	@Override
	public void setCertificateNo(String certificateNo) {
		_certificateNo = certificateNo;

		if (_btReimbursementSAPInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btReimbursementSAPInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setCertificateNo", String.class);

				method.invoke(_btReimbursementSAPInfoRemoteModel, certificateNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCompany() {
		return _company;
	}

	@Override
	public void setCompany(String company) {
		_company = company;

		if (_btReimbursementSAPInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btReimbursementSAPInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setCompany", String.class);

				method.invoke(_btReimbursementSAPInfoRemoteModel, company);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getYear() {
		return _year;
	}

	@Override
	public void setYear(String year) {
		_year = year;

		if (_btReimbursementSAPInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btReimbursementSAPInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setYear", String.class);

				method.invoke(_btReimbursementSAPInfoRemoteModel, year);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_btReimbursementSAPInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btReimbursementSAPInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_btReimbursementSAPInfoRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_btReimbursementSAPInfoRemoteModel != null) {
			try {
				Class<?> clazz = _btReimbursementSAPInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_btReimbursementSAPInfoRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getBtReimbursementSAPInfoRemoteModel() {
		return _btReimbursementSAPInfoRemoteModel;
	}

	public void setBtReimbursementSAPInfoRemoteModel(
		BaseModel<?> btReimbursementSAPInfoRemoteModel) {
		_btReimbursementSAPInfoRemoteModel = btReimbursementSAPInfoRemoteModel;
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

		Class<?> remoteModelClass = _btReimbursementSAPInfoRemoteModel.getClass();

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

		Object returnValue = method.invoke(_btReimbursementSAPInfoRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			BtReimbursementSAPInfoLocalServiceUtil.addBtReimbursementSAPInfo(this);
		}
		else {
			BtReimbursementSAPInfoLocalServiceUtil.updateBtReimbursementSAPInfo(this);
		}
	}

	@Override
	public BtReimbursementSAPInfo toEscapedModel() {
		return (BtReimbursementSAPInfo)ProxyUtil.newProxyInstance(BtReimbursementSAPInfo.class.getClassLoader(),
			new Class[] { BtReimbursementSAPInfo.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BtReimbursementSAPInfoClp clone = new BtReimbursementSAPInfoClp();

		clone.setBtReimbursementSAPInfoId(getBtReimbursementSAPInfoId());
		clone.setBusinessTripPkId(getBusinessTripPkId());
		clone.setTicketNo(getTicketNo());
		clone.setCurrency(getCurrency());
		clone.setStep(getStep());
		clone.setMessageType(getMessageType());
		clone.setMessage(getMessage());
		clone.setCertificateNo(getCertificateNo());
		clone.setCompany(getCompany());
		clone.setYear(getYear());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(BtReimbursementSAPInfo btReimbursementSAPInfo) {
		long primaryKey = btReimbursementSAPInfo.getPrimaryKey();

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

		if (!(obj instanceof BtReimbursementSAPInfoClp)) {
			return false;
		}

		BtReimbursementSAPInfoClp btReimbursementSAPInfo = (BtReimbursementSAPInfoClp)obj;

		long primaryKey = btReimbursementSAPInfo.getPrimaryKey();

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

		sb.append("{btReimbursementSAPInfoId=");
		sb.append(getBtReimbursementSAPInfoId());
		sb.append(", businessTripPkId=");
		sb.append(getBusinessTripPkId());
		sb.append(", ticketNo=");
		sb.append(getTicketNo());
		sb.append(", currency=");
		sb.append(getCurrency());
		sb.append(", step=");
		sb.append(getStep());
		sb.append(", messageType=");
		sb.append(getMessageType());
		sb.append(", message=");
		sb.append(getMessage());
		sb.append(", certificateNo=");
		sb.append(getCertificateNo());
		sb.append(", company=");
		sb.append(getCompany());
		sb.append(", year=");
		sb.append(getYear());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.business.trip.model.BtReimbursementSAPInfo");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>btReimbursementSAPInfoId</column-name><column-value><![CDATA[");
		sb.append(getBtReimbursementSAPInfoId());
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
			"<column><column-name>currency</column-name><column-value><![CDATA[");
		sb.append(getCurrency());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>step</column-name><column-value><![CDATA[");
		sb.append(getStep());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>messageType</column-name><column-value><![CDATA[");
		sb.append(getMessageType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>message</column-name><column-value><![CDATA[");
		sb.append(getMessage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>certificateNo</column-name><column-value><![CDATA[");
		sb.append(getCertificateNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>company</column-name><column-value><![CDATA[");
		sb.append(getCompany());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>year</column-name><column-value><![CDATA[");
		sb.append(getYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _btReimbursementSAPInfoId;
	private long _businessTripPkId;
	private String _ticketNo;
	private String _currency;
	private int _step;
	private String _messageType;
	private String _message;
	private String _certificateNo;
	private String _company;
	private String _year;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _btReimbursementSAPInfoRemoteModel;
	private Class<?> _clpSerializerClass = com.business.trip.service.ClpSerializer.class;
}