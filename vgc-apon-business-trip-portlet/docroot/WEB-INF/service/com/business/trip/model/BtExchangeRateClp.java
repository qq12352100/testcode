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

import com.business.trip.service.BtExchangeRateLocalServiceUtil;
import com.business.trip.service.ClpSerializer;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class BtExchangeRateClp extends BaseModelImpl<BtExchangeRate>
	implements BtExchangeRate {
	public BtExchangeRateClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return BtExchangeRate.class;
	}

	@Override
	public String getModelClassName() {
		return BtExchangeRate.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _btExchangeRateId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBtExchangeRateId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _btExchangeRateId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("btExchangeRateId", getBtExchangeRateId());
		attributes.put("firstCurrency", getFirstCurrency());
		attributes.put("secondCurrency", getSecondCurrency());
		attributes.put("firToSecExchangeRate", getFirToSecExchangeRate());
		attributes.put("secToFirExchangeRate", getSecToFirExchangeRate());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long btExchangeRateId = (Long)attributes.get("btExchangeRateId");

		if (btExchangeRateId != null) {
			setBtExchangeRateId(btExchangeRateId);
		}

		String firstCurrency = (String)attributes.get("firstCurrency");

		if (firstCurrency != null) {
			setFirstCurrency(firstCurrency);
		}

		String secondCurrency = (String)attributes.get("secondCurrency");

		if (secondCurrency != null) {
			setSecondCurrency(secondCurrency);
		}

		Double firToSecExchangeRate = (Double)attributes.get(
				"firToSecExchangeRate");

		if (firToSecExchangeRate != null) {
			setFirToSecExchangeRate(firToSecExchangeRate);
		}

		Double secToFirExchangeRate = (Double)attributes.get(
				"secToFirExchangeRate");

		if (secToFirExchangeRate != null) {
			setSecToFirExchangeRate(secToFirExchangeRate);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public long getBtExchangeRateId() {
		return _btExchangeRateId;
	}

	@Override
	public void setBtExchangeRateId(long btExchangeRateId) {
		_btExchangeRateId = btExchangeRateId;

		if (_btExchangeRateRemoteModel != null) {
			try {
				Class<?> clazz = _btExchangeRateRemoteModel.getClass();

				Method method = clazz.getMethod("setBtExchangeRateId",
						long.class);

				method.invoke(_btExchangeRateRemoteModel, btExchangeRateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFirstCurrency() {
		return _firstCurrency;
	}

	@Override
	public void setFirstCurrency(String firstCurrency) {
		_firstCurrency = firstCurrency;

		if (_btExchangeRateRemoteModel != null) {
			try {
				Class<?> clazz = _btExchangeRateRemoteModel.getClass();

				Method method = clazz.getMethod("setFirstCurrency", String.class);

				method.invoke(_btExchangeRateRemoteModel, firstCurrency);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSecondCurrency() {
		return _secondCurrency;
	}

	@Override
	public void setSecondCurrency(String secondCurrency) {
		_secondCurrency = secondCurrency;

		if (_btExchangeRateRemoteModel != null) {
			try {
				Class<?> clazz = _btExchangeRateRemoteModel.getClass();

				Method method = clazz.getMethod("setSecondCurrency",
						String.class);

				method.invoke(_btExchangeRateRemoteModel, secondCurrency);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getFirToSecExchangeRate() {
		return _firToSecExchangeRate;
	}

	@Override
	public void setFirToSecExchangeRate(double firToSecExchangeRate) {
		_firToSecExchangeRate = firToSecExchangeRate;

		if (_btExchangeRateRemoteModel != null) {
			try {
				Class<?> clazz = _btExchangeRateRemoteModel.getClass();

				Method method = clazz.getMethod("setFirToSecExchangeRate",
						double.class);

				method.invoke(_btExchangeRateRemoteModel, firToSecExchangeRate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getSecToFirExchangeRate() {
		return _secToFirExchangeRate;
	}

	@Override
	public void setSecToFirExchangeRate(double secToFirExchangeRate) {
		_secToFirExchangeRate = secToFirExchangeRate;

		if (_btExchangeRateRemoteModel != null) {
			try {
				Class<?> clazz = _btExchangeRateRemoteModel.getClass();

				Method method = clazz.getMethod("setSecToFirExchangeRate",
						double.class);

				method.invoke(_btExchangeRateRemoteModel, secToFirExchangeRate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_btExchangeRateRemoteModel != null) {
			try {
				Class<?> clazz = _btExchangeRateRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_btExchangeRateRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_btExchangeRateRemoteModel != null) {
			try {
				Class<?> clazz = _btExchangeRateRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_btExchangeRateRemoteModel, userName);
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

		if (_btExchangeRateRemoteModel != null) {
			try {
				Class<?> clazz = _btExchangeRateRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_btExchangeRateRemoteModel, createDate);
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

		if (_btExchangeRateRemoteModel != null) {
			try {
				Class<?> clazz = _btExchangeRateRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_btExchangeRateRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;

		if (_btExchangeRateRemoteModel != null) {
			try {
				Class<?> clazz = _btExchangeRateRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_btExchangeRateRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getBtExchangeRateRemoteModel() {
		return _btExchangeRateRemoteModel;
	}

	public void setBtExchangeRateRemoteModel(
		BaseModel<?> btExchangeRateRemoteModel) {
		_btExchangeRateRemoteModel = btExchangeRateRemoteModel;
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

		Class<?> remoteModelClass = _btExchangeRateRemoteModel.getClass();

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

		Object returnValue = method.invoke(_btExchangeRateRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			BtExchangeRateLocalServiceUtil.addBtExchangeRate(this);
		}
		else {
			BtExchangeRateLocalServiceUtil.updateBtExchangeRate(this);
		}
	}

	@Override
	public BtExchangeRate toEscapedModel() {
		return (BtExchangeRate)ProxyUtil.newProxyInstance(BtExchangeRate.class.getClassLoader(),
			new Class[] { BtExchangeRate.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BtExchangeRateClp clone = new BtExchangeRateClp();

		clone.setBtExchangeRateId(getBtExchangeRateId());
		clone.setFirstCurrency(getFirstCurrency());
		clone.setSecondCurrency(getSecondCurrency());
		clone.setFirToSecExchangeRate(getFirToSecExchangeRate());
		clone.setSecToFirExchangeRate(getSecToFirExchangeRate());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setStatus(getStatus());

		return clone;
	}

	@Override
	public int compareTo(BtExchangeRate btExchangeRate) {
		long primaryKey = btExchangeRate.getPrimaryKey();

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

		if (!(obj instanceof BtExchangeRateClp)) {
			return false;
		}

		BtExchangeRateClp btExchangeRate = (BtExchangeRateClp)obj;

		long primaryKey = btExchangeRate.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{btExchangeRateId=");
		sb.append(getBtExchangeRateId());
		sb.append(", firstCurrency=");
		sb.append(getFirstCurrency());
		sb.append(", secondCurrency=");
		sb.append(getSecondCurrency());
		sb.append(", firToSecExchangeRate=");
		sb.append(getFirToSecExchangeRate());
		sb.append(", secToFirExchangeRate=");
		sb.append(getSecToFirExchangeRate());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.business.trip.model.BtExchangeRate");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>btExchangeRateId</column-name><column-value><![CDATA[");
		sb.append(getBtExchangeRateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firstCurrency</column-name><column-value><![CDATA[");
		sb.append(getFirstCurrency());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>secondCurrency</column-name><column-value><![CDATA[");
		sb.append(getSecondCurrency());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firToSecExchangeRate</column-name><column-value><![CDATA[");
		sb.append(getFirToSecExchangeRate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>secToFirExchangeRate</column-name><column-value><![CDATA[");
		sb.append(getSecToFirExchangeRate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _btExchangeRateId;
	private String _firstCurrency;
	private String _secondCurrency;
	private double _firToSecExchangeRate;
	private double _secToFirExchangeRate;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _status;
	private BaseModel<?> _btExchangeRateRemoteModel;
	private Class<?> _clpSerializerClass = com.business.trip.service.ClpSerializer.class;
}