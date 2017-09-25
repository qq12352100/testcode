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

import com.business.trip.service.BtExchangeSAPRateLocalServiceUtil;
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
public class BtExchangeSAPRateClp extends BaseModelImpl<BtExchangeSAPRate>
	implements BtExchangeSAPRate {
	public BtExchangeSAPRateClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return BtExchangeSAPRate.class;
	}

	@Override
	public String getModelClassName() {
		return BtExchangeSAPRate.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _btExchangeSAPRateId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBtExchangeSAPRateId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _btExchangeSAPRateId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("btExchangeSAPRateId", getBtExchangeSAPRateId());
		attributes.put("fromCurrency", getFromCurrency());
		attributes.put("toCurrency", getToCurrency());
		attributes.put("currencyRate", getCurrencyRate());
		attributes.put("rateType", getRateType());
		attributes.put("sapDate", getSapDate());
		attributes.put("importDate", getImportDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long btExchangeSAPRateId = (Long)attributes.get("btExchangeSAPRateId");

		if (btExchangeSAPRateId != null) {
			setBtExchangeSAPRateId(btExchangeSAPRateId);
		}

		String fromCurrency = (String)attributes.get("fromCurrency");

		if (fromCurrency != null) {
			setFromCurrency(fromCurrency);
		}

		String toCurrency = (String)attributes.get("toCurrency");

		if (toCurrency != null) {
			setToCurrency(toCurrency);
		}

		Double currencyRate = (Double)attributes.get("currencyRate");

		if (currencyRate != null) {
			setCurrencyRate(currencyRate);
		}

		String rateType = (String)attributes.get("rateType");

		if (rateType != null) {
			setRateType(rateType);
		}

		Date sapDate = (Date)attributes.get("sapDate");

		if (sapDate != null) {
			setSapDate(sapDate);
		}

		Date importDate = (Date)attributes.get("importDate");

		if (importDate != null) {
			setImportDate(importDate);
		}
	}

	@Override
	public long getBtExchangeSAPRateId() {
		return _btExchangeSAPRateId;
	}

	@Override
	public void setBtExchangeSAPRateId(long btExchangeSAPRateId) {
		_btExchangeSAPRateId = btExchangeSAPRateId;

		if (_btExchangeSAPRateRemoteModel != null) {
			try {
				Class<?> clazz = _btExchangeSAPRateRemoteModel.getClass();

				Method method = clazz.getMethod("setBtExchangeSAPRateId",
						long.class);

				method.invoke(_btExchangeSAPRateRemoteModel, btExchangeSAPRateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFromCurrency() {
		return _fromCurrency;
	}

	@Override
	public void setFromCurrency(String fromCurrency) {
		_fromCurrency = fromCurrency;

		if (_btExchangeSAPRateRemoteModel != null) {
			try {
				Class<?> clazz = _btExchangeSAPRateRemoteModel.getClass();

				Method method = clazz.getMethod("setFromCurrency", String.class);

				method.invoke(_btExchangeSAPRateRemoteModel, fromCurrency);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getToCurrency() {
		return _toCurrency;
	}

	@Override
	public void setToCurrency(String toCurrency) {
		_toCurrency = toCurrency;

		if (_btExchangeSAPRateRemoteModel != null) {
			try {
				Class<?> clazz = _btExchangeSAPRateRemoteModel.getClass();

				Method method = clazz.getMethod("setToCurrency", String.class);

				method.invoke(_btExchangeSAPRateRemoteModel, toCurrency);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getCurrencyRate() {
		return _currencyRate;
	}

	@Override
	public void setCurrencyRate(double currencyRate) {
		_currencyRate = currencyRate;

		if (_btExchangeSAPRateRemoteModel != null) {
			try {
				Class<?> clazz = _btExchangeSAPRateRemoteModel.getClass();

				Method method = clazz.getMethod("setCurrencyRate", double.class);

				method.invoke(_btExchangeSAPRateRemoteModel, currencyRate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRateType() {
		return _rateType;
	}

	@Override
	public void setRateType(String rateType) {
		_rateType = rateType;

		if (_btExchangeSAPRateRemoteModel != null) {
			try {
				Class<?> clazz = _btExchangeSAPRateRemoteModel.getClass();

				Method method = clazz.getMethod("setRateType", String.class);

				method.invoke(_btExchangeSAPRateRemoteModel, rateType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getSapDate() {
		return _sapDate;
	}

	@Override
	public void setSapDate(Date sapDate) {
		_sapDate = sapDate;

		if (_btExchangeSAPRateRemoteModel != null) {
			try {
				Class<?> clazz = _btExchangeSAPRateRemoteModel.getClass();

				Method method = clazz.getMethod("setSapDate", Date.class);

				method.invoke(_btExchangeSAPRateRemoteModel, sapDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getImportDate() {
		return _importDate;
	}

	@Override
	public void setImportDate(Date importDate) {
		_importDate = importDate;

		if (_btExchangeSAPRateRemoteModel != null) {
			try {
				Class<?> clazz = _btExchangeSAPRateRemoteModel.getClass();

				Method method = clazz.getMethod("setImportDate", Date.class);

				method.invoke(_btExchangeSAPRateRemoteModel, importDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getBtExchangeSAPRateRemoteModel() {
		return _btExchangeSAPRateRemoteModel;
	}

	public void setBtExchangeSAPRateRemoteModel(
		BaseModel<?> btExchangeSAPRateRemoteModel) {
		_btExchangeSAPRateRemoteModel = btExchangeSAPRateRemoteModel;
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

		Class<?> remoteModelClass = _btExchangeSAPRateRemoteModel.getClass();

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

		Object returnValue = method.invoke(_btExchangeSAPRateRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			BtExchangeSAPRateLocalServiceUtil.addBtExchangeSAPRate(this);
		}
		else {
			BtExchangeSAPRateLocalServiceUtil.updateBtExchangeSAPRate(this);
		}
	}

	@Override
	public BtExchangeSAPRate toEscapedModel() {
		return (BtExchangeSAPRate)ProxyUtil.newProxyInstance(BtExchangeSAPRate.class.getClassLoader(),
			new Class[] { BtExchangeSAPRate.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BtExchangeSAPRateClp clone = new BtExchangeSAPRateClp();

		clone.setBtExchangeSAPRateId(getBtExchangeSAPRateId());
		clone.setFromCurrency(getFromCurrency());
		clone.setToCurrency(getToCurrency());
		clone.setCurrencyRate(getCurrencyRate());
		clone.setRateType(getRateType());
		clone.setSapDate(getSapDate());
		clone.setImportDate(getImportDate());

		return clone;
	}

	@Override
	public int compareTo(BtExchangeSAPRate btExchangeSAPRate) {
		long primaryKey = btExchangeSAPRate.getPrimaryKey();

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

		if (!(obj instanceof BtExchangeSAPRateClp)) {
			return false;
		}

		BtExchangeSAPRateClp btExchangeSAPRate = (BtExchangeSAPRateClp)obj;

		long primaryKey = btExchangeSAPRate.getPrimaryKey();

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
		StringBundler sb = new StringBundler(15);

		sb.append("{btExchangeSAPRateId=");
		sb.append(getBtExchangeSAPRateId());
		sb.append(", fromCurrency=");
		sb.append(getFromCurrency());
		sb.append(", toCurrency=");
		sb.append(getToCurrency());
		sb.append(", currencyRate=");
		sb.append(getCurrencyRate());
		sb.append(", rateType=");
		sb.append(getRateType());
		sb.append(", sapDate=");
		sb.append(getSapDate());
		sb.append(", importDate=");
		sb.append(getImportDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.business.trip.model.BtExchangeSAPRate");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>btExchangeSAPRateId</column-name><column-value><![CDATA[");
		sb.append(getBtExchangeSAPRateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fromCurrency</column-name><column-value><![CDATA[");
		sb.append(getFromCurrency());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>toCurrency</column-name><column-value><![CDATA[");
		sb.append(getToCurrency());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currencyRate</column-name><column-value><![CDATA[");
		sb.append(getCurrencyRate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rateType</column-name><column-value><![CDATA[");
		sb.append(getRateType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sapDate</column-name><column-value><![CDATA[");
		sb.append(getSapDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>importDate</column-name><column-value><![CDATA[");
		sb.append(getImportDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _btExchangeSAPRateId;
	private String _fromCurrency;
	private String _toCurrency;
	private double _currencyRate;
	private String _rateType;
	private Date _sapDate;
	private Date _importDate;
	private BaseModel<?> _btExchangeSAPRateRemoteModel;
	private Class<?> _clpSerializerClass = com.business.trip.service.ClpSerializer.class;
}