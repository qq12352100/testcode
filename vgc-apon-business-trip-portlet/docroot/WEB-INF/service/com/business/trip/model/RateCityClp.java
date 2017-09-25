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

import com.business.trip.service.ClpSerializer;
import com.business.trip.service.RateCityLocalServiceUtil;

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
public class RateCityClp extends BaseModelImpl<RateCity> implements RateCity {
	public RateCityClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return RateCity.class;
	}

	@Override
	public String getModelClassName() {
		return RateCity.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _ratecityId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setRatecityId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ratecityId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ratecityId", getRatecityId());
		attributes.put("areaName", getAreaName());
		attributes.put("rateOfDma", getRateOfDma());
		attributes.put("currency", getCurrency());
		attributes.put("parentId", getParentId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ratecityId = (Long)attributes.get("ratecityId");

		if (ratecityId != null) {
			setRatecityId(ratecityId);
		}

		String areaName = (String)attributes.get("areaName");

		if (areaName != null) {
			setAreaName(areaName);
		}

		Double rateOfDma = (Double)attributes.get("rateOfDma");

		if (rateOfDma != null) {
			setRateOfDma(rateOfDma);
		}

		String currency = (String)attributes.get("currency");

		if (currency != null) {
			setCurrency(currency);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}
	}

	@Override
	public long getRatecityId() {
		return _ratecityId;
	}

	@Override
	public void setRatecityId(long ratecityId) {
		_ratecityId = ratecityId;

		if (_rateCityRemoteModel != null) {
			try {
				Class<?> clazz = _rateCityRemoteModel.getClass();

				Method method = clazz.getMethod("setRatecityId", long.class);

				method.invoke(_rateCityRemoteModel, ratecityId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAreaName() {
		return _areaName;
	}

	@Override
	public void setAreaName(String areaName) {
		_areaName = areaName;

		if (_rateCityRemoteModel != null) {
			try {
				Class<?> clazz = _rateCityRemoteModel.getClass();

				Method method = clazz.getMethod("setAreaName", String.class);

				method.invoke(_rateCityRemoteModel, areaName);
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

		if (_rateCityRemoteModel != null) {
			try {
				Class<?> clazz = _rateCityRemoteModel.getClass();

				Method method = clazz.getMethod("setRateOfDma", double.class);

				method.invoke(_rateCityRemoteModel, rateOfDma);
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

		if (_rateCityRemoteModel != null) {
			try {
				Class<?> clazz = _rateCityRemoteModel.getClass();

				Method method = clazz.getMethod("setCurrency", String.class);

				method.invoke(_rateCityRemoteModel, currency);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getParentId() {
		return _parentId;
	}

	@Override
	public void setParentId(long parentId) {
		_parentId = parentId;

		if (_rateCityRemoteModel != null) {
			try {
				Class<?> clazz = _rateCityRemoteModel.getClass();

				Method method = clazz.getMethod("setParentId", long.class);

				method.invoke(_rateCityRemoteModel, parentId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getRateCityRemoteModel() {
		return _rateCityRemoteModel;
	}

	public void setRateCityRemoteModel(BaseModel<?> rateCityRemoteModel) {
		_rateCityRemoteModel = rateCityRemoteModel;
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

		Class<?> remoteModelClass = _rateCityRemoteModel.getClass();

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

		Object returnValue = method.invoke(_rateCityRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			RateCityLocalServiceUtil.addRateCity(this);
		}
		else {
			RateCityLocalServiceUtil.updateRateCity(this);
		}
	}

	@Override
	public RateCity toEscapedModel() {
		return (RateCity)ProxyUtil.newProxyInstance(RateCity.class.getClassLoader(),
			new Class[] { RateCity.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		RateCityClp clone = new RateCityClp();

		clone.setRatecityId(getRatecityId());
		clone.setAreaName(getAreaName());
		clone.setRateOfDma(getRateOfDma());
		clone.setCurrency(getCurrency());
		clone.setParentId(getParentId());

		return clone;
	}

	@Override
	public int compareTo(RateCity rateCity) {
		long primaryKey = rateCity.getPrimaryKey();

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

		if (!(obj instanceof RateCityClp)) {
			return false;
		}

		RateCityClp rateCity = (RateCityClp)obj;

		long primaryKey = rateCity.getPrimaryKey();

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
		StringBundler sb = new StringBundler(11);

		sb.append("{ratecityId=");
		sb.append(getRatecityId());
		sb.append(", areaName=");
		sb.append(getAreaName());
		sb.append(", rateOfDma=");
		sb.append(getRateOfDma());
		sb.append(", currency=");
		sb.append(getCurrency());
		sb.append(", parentId=");
		sb.append(getParentId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.business.trip.model.RateCity");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ratecityId</column-name><column-value><![CDATA[");
		sb.append(getRatecityId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>areaName</column-name><column-value><![CDATA[");
		sb.append(getAreaName());
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
			"<column><column-name>parentId</column-name><column-value><![CDATA[");
		sb.append(getParentId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _ratecityId;
	private String _areaName;
	private double _rateOfDma;
	private String _currency;
	private long _parentId;
	private BaseModel<?> _rateCityRemoteModel;
	private Class<?> _clpSerializerClass = com.business.trip.service.ClpSerializer.class;
}