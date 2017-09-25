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

package com.e.leave.model;

import com.e.leave.service.ClpSerializer;
import com.e.leave.service.ELeaveInfoLocalServiceUtil;

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
 * @author EZEYIFE
 */
public class ELeaveInfoClp extends BaseModelImpl<ELeaveInfo>
	implements ELeaveInfo {
	public ELeaveInfoClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ELeaveInfo.class;
	}

	@Override
	public String getModelClassName() {
		return ELeaveInfo.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _eLeaveInfoId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setELeaveInfoId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _eLeaveInfoId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("eLeaveInfoId", getELeaveInfoId());
		attributes.put("eLeaveId", getELeaveId());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("startTime", getStartTime());
		attributes.put("endTime", getEndTime());
		attributes.put("typeOfLeave", getTypeOfLeave());
		attributes.put("typeOfLeaveId", getTypeOfLeaveId());
		attributes.put("absenceDays", getAbsenceDays());
		attributes.put("remark", getRemark());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long eLeaveInfoId = (Long)attributes.get("eLeaveInfoId");

		if (eLeaveInfoId != null) {
			setELeaveInfoId(eLeaveInfoId);
		}

		Long eLeaveId = (Long)attributes.get("eLeaveId");

		if (eLeaveId != null) {
			setELeaveId(eLeaveId);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		String startTime = (String)attributes.get("startTime");

		if (startTime != null) {
			setStartTime(startTime);
		}

		String endTime = (String)attributes.get("endTime");

		if (endTime != null) {
			setEndTime(endTime);
		}

		String typeOfLeave = (String)attributes.get("typeOfLeave");

		if (typeOfLeave != null) {
			setTypeOfLeave(typeOfLeave);
		}

		String typeOfLeaveId = (String)attributes.get("typeOfLeaveId");

		if (typeOfLeaveId != null) {
			setTypeOfLeaveId(typeOfLeaveId);
		}

		String absenceDays = (String)attributes.get("absenceDays");

		if (absenceDays != null) {
			setAbsenceDays(absenceDays);
		}

		String remark = (String)attributes.get("remark");

		if (remark != null) {
			setRemark(remark);
		}
	}

	@Override
	public long getELeaveInfoId() {
		return _eLeaveInfoId;
	}

	@Override
	public void setELeaveInfoId(long eLeaveInfoId) {
		_eLeaveInfoId = eLeaveInfoId;

		if (_eLeaveInfoRemoteModel != null) {
			try {
				Class<?> clazz = _eLeaveInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setELeaveInfoId", long.class);

				method.invoke(_eLeaveInfoRemoteModel, eLeaveInfoId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getELeaveId() {
		return _eLeaveId;
	}

	@Override
	public void setELeaveId(long eLeaveId) {
		_eLeaveId = eLeaveId;

		if (_eLeaveInfoRemoteModel != null) {
			try {
				Class<?> clazz = _eLeaveInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setELeaveId", long.class);

				method.invoke(_eLeaveInfoRemoteModel, eLeaveId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getStartDate() {
		return _startDate;
	}

	@Override
	public void setStartDate(Date startDate) {
		_startDate = startDate;

		if (_eLeaveInfoRemoteModel != null) {
			try {
				Class<?> clazz = _eLeaveInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setStartDate", Date.class);

				method.invoke(_eLeaveInfoRemoteModel, startDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEndDate() {
		return _endDate;
	}

	@Override
	public void setEndDate(Date endDate) {
		_endDate = endDate;

		if (_eLeaveInfoRemoteModel != null) {
			try {
				Class<?> clazz = _eLeaveInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setEndDate", Date.class);

				method.invoke(_eLeaveInfoRemoteModel, endDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStartTime() {
		return _startTime;
	}

	@Override
	public void setStartTime(String startTime) {
		_startTime = startTime;

		if (_eLeaveInfoRemoteModel != null) {
			try {
				Class<?> clazz = _eLeaveInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setStartTime", String.class);

				method.invoke(_eLeaveInfoRemoteModel, startTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEndTime() {
		return _endTime;
	}

	@Override
	public void setEndTime(String endTime) {
		_endTime = endTime;

		if (_eLeaveInfoRemoteModel != null) {
			try {
				Class<?> clazz = _eLeaveInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setEndTime", String.class);

				method.invoke(_eLeaveInfoRemoteModel, endTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTypeOfLeave() {
		return _typeOfLeave;
	}

	@Override
	public void setTypeOfLeave(String typeOfLeave) {
		_typeOfLeave = typeOfLeave;

		if (_eLeaveInfoRemoteModel != null) {
			try {
				Class<?> clazz = _eLeaveInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setTypeOfLeave", String.class);

				method.invoke(_eLeaveInfoRemoteModel, typeOfLeave);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTypeOfLeaveId() {
		return _typeOfLeaveId;
	}

	@Override
	public void setTypeOfLeaveId(String typeOfLeaveId) {
		_typeOfLeaveId = typeOfLeaveId;

		if (_eLeaveInfoRemoteModel != null) {
			try {
				Class<?> clazz = _eLeaveInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setTypeOfLeaveId", String.class);

				method.invoke(_eLeaveInfoRemoteModel, typeOfLeaveId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAbsenceDays() {
		return _absenceDays;
	}

	@Override
	public void setAbsenceDays(String absenceDays) {
		_absenceDays = absenceDays;

		if (_eLeaveInfoRemoteModel != null) {
			try {
				Class<?> clazz = _eLeaveInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setAbsenceDays", String.class);

				method.invoke(_eLeaveInfoRemoteModel, absenceDays);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRemark() {
		return _remark;
	}

	@Override
	public void setRemark(String remark) {
		_remark = remark;

		if (_eLeaveInfoRemoteModel != null) {
			try {
				Class<?> clazz = _eLeaveInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setRemark", String.class);

				method.invoke(_eLeaveInfoRemoteModel, remark);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getELeaveInfoRemoteModel() {
		return _eLeaveInfoRemoteModel;
	}

	public void setELeaveInfoRemoteModel(BaseModel<?> eLeaveInfoRemoteModel) {
		_eLeaveInfoRemoteModel = eLeaveInfoRemoteModel;
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

		Class<?> remoteModelClass = _eLeaveInfoRemoteModel.getClass();

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

		Object returnValue = method.invoke(_eLeaveInfoRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ELeaveInfoLocalServiceUtil.addELeaveInfo(this);
		}
		else {
			ELeaveInfoLocalServiceUtil.updateELeaveInfo(this);
		}
	}

	@Override
	public ELeaveInfo toEscapedModel() {
		return (ELeaveInfo)ProxyUtil.newProxyInstance(ELeaveInfo.class.getClassLoader(),
			new Class[] { ELeaveInfo.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ELeaveInfoClp clone = new ELeaveInfoClp();

		clone.setELeaveInfoId(getELeaveInfoId());
		clone.setELeaveId(getELeaveId());
		clone.setStartDate(getStartDate());
		clone.setEndDate(getEndDate());
		clone.setStartTime(getStartTime());
		clone.setEndTime(getEndTime());
		clone.setTypeOfLeave(getTypeOfLeave());
		clone.setTypeOfLeaveId(getTypeOfLeaveId());
		clone.setAbsenceDays(getAbsenceDays());
		clone.setRemark(getRemark());

		return clone;
	}

	@Override
	public int compareTo(ELeaveInfo eLeaveInfo) {
		int value = 0;

		if (getELeaveInfoId() < eLeaveInfo.getELeaveInfoId()) {
			value = -1;
		}
		else if (getELeaveInfoId() > eLeaveInfo.getELeaveInfoId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ELeaveInfoClp)) {
			return false;
		}

		ELeaveInfoClp eLeaveInfo = (ELeaveInfoClp)obj;

		long primaryKey = eLeaveInfo.getPrimaryKey();

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

		sb.append("{eLeaveInfoId=");
		sb.append(getELeaveInfoId());
		sb.append(", eLeaveId=");
		sb.append(getELeaveId());
		sb.append(", startDate=");
		sb.append(getStartDate());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append(", startTime=");
		sb.append(getStartTime());
		sb.append(", endTime=");
		sb.append(getEndTime());
		sb.append(", typeOfLeave=");
		sb.append(getTypeOfLeave());
		sb.append(", typeOfLeaveId=");
		sb.append(getTypeOfLeaveId());
		sb.append(", absenceDays=");
		sb.append(getAbsenceDays());
		sb.append(", remark=");
		sb.append(getRemark());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.e.leave.model.ELeaveInfo");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>eLeaveInfoId</column-name><column-value><![CDATA[");
		sb.append(getELeaveInfoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eLeaveId</column-name><column-value><![CDATA[");
		sb.append(getELeaveId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startDate</column-name><column-value><![CDATA[");
		sb.append(getStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endDate</column-name><column-value><![CDATA[");
		sb.append(getEndDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startTime</column-name><column-value><![CDATA[");
		sb.append(getStartTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endTime</column-name><column-value><![CDATA[");
		sb.append(getEndTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>typeOfLeave</column-name><column-value><![CDATA[");
		sb.append(getTypeOfLeave());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>typeOfLeaveId</column-name><column-value><![CDATA[");
		sb.append(getTypeOfLeaveId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>absenceDays</column-name><column-value><![CDATA[");
		sb.append(getAbsenceDays());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>remark</column-name><column-value><![CDATA[");
		sb.append(getRemark());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _eLeaveInfoId;
	private long _eLeaveId;
	private Date _startDate;
	private Date _endDate;
	private String _startTime;
	private String _endTime;
	private String _typeOfLeave;
	private String _typeOfLeaveId;
	private String _absenceDays;
	private String _remark;
	private BaseModel<?> _eLeaveInfoRemoteModel;
	private Class<?> _clpSerializerClass = com.e.leave.service.ClpSerializer.class;
}