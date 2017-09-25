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

import com.business.trip.service.BtEntertainmentDetailLocalServiceUtil;
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
public class BtEntertainmentDetailClp extends BaseModelImpl<BtEntertainmentDetail>
	implements BtEntertainmentDetail {
	public BtEntertainmentDetailClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return BtEntertainmentDetail.class;
	}

	@Override
	public String getModelClassName() {
		return BtEntertainmentDetail.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _btEntertainmentDetailId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBtEntertainmentDetailId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _btEntertainmentDetailId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("btEntertainmentDetailId", getBtEntertainmentDetailId());
		attributes.put("btCostListId", getBtCostListId());
		attributes.put("businessTripPkId", getBusinessTripPkId());
		attributes.put("fullName", getFullName());
		attributes.put("positionTitle", getPositionTitle());
		attributes.put("company", getCompany());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long btEntertainmentDetailId = (Long)attributes.get(
				"btEntertainmentDetailId");

		if (btEntertainmentDetailId != null) {
			setBtEntertainmentDetailId(btEntertainmentDetailId);
		}

		Long btCostListId = (Long)attributes.get("btCostListId");

		if (btCostListId != null) {
			setBtCostListId(btCostListId);
		}

		Long businessTripPkId = (Long)attributes.get("businessTripPkId");

		if (businessTripPkId != null) {
			setBusinessTripPkId(businessTripPkId);
		}

		String fullName = (String)attributes.get("fullName");

		if (fullName != null) {
			setFullName(fullName);
		}

		String positionTitle = (String)attributes.get("positionTitle");

		if (positionTitle != null) {
			setPositionTitle(positionTitle);
		}

		String company = (String)attributes.get("company");

		if (company != null) {
			setCompany(company);
		}
	}

	@Override
	public long getBtEntertainmentDetailId() {
		return _btEntertainmentDetailId;
	}

	@Override
	public void setBtEntertainmentDetailId(long btEntertainmentDetailId) {
		_btEntertainmentDetailId = btEntertainmentDetailId;

		if (_btEntertainmentDetailRemoteModel != null) {
			try {
				Class<?> clazz = _btEntertainmentDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setBtEntertainmentDetailId",
						long.class);

				method.invoke(_btEntertainmentDetailRemoteModel,
					btEntertainmentDetailId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getBtCostListId() {
		return _btCostListId;
	}

	@Override
	public void setBtCostListId(long btCostListId) {
		_btCostListId = btCostListId;

		if (_btEntertainmentDetailRemoteModel != null) {
			try {
				Class<?> clazz = _btEntertainmentDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setBtCostListId", long.class);

				method.invoke(_btEntertainmentDetailRemoteModel, btCostListId);
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

		if (_btEntertainmentDetailRemoteModel != null) {
			try {
				Class<?> clazz = _btEntertainmentDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setBusinessTripPkId",
						long.class);

				method.invoke(_btEntertainmentDetailRemoteModel,
					businessTripPkId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFullName() {
		return _fullName;
	}

	@Override
	public void setFullName(String fullName) {
		_fullName = fullName;

		if (_btEntertainmentDetailRemoteModel != null) {
			try {
				Class<?> clazz = _btEntertainmentDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setFullName", String.class);

				method.invoke(_btEntertainmentDetailRemoteModel, fullName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPositionTitle() {
		return _positionTitle;
	}

	@Override
	public void setPositionTitle(String positionTitle) {
		_positionTitle = positionTitle;

		if (_btEntertainmentDetailRemoteModel != null) {
			try {
				Class<?> clazz = _btEntertainmentDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setPositionTitle", String.class);

				method.invoke(_btEntertainmentDetailRemoteModel, positionTitle);
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

		if (_btEntertainmentDetailRemoteModel != null) {
			try {
				Class<?> clazz = _btEntertainmentDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setCompany", String.class);

				method.invoke(_btEntertainmentDetailRemoteModel, company);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getBtEntertainmentDetailRemoteModel() {
		return _btEntertainmentDetailRemoteModel;
	}

	public void setBtEntertainmentDetailRemoteModel(
		BaseModel<?> btEntertainmentDetailRemoteModel) {
		_btEntertainmentDetailRemoteModel = btEntertainmentDetailRemoteModel;
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

		Class<?> remoteModelClass = _btEntertainmentDetailRemoteModel.getClass();

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

		Object returnValue = method.invoke(_btEntertainmentDetailRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			BtEntertainmentDetailLocalServiceUtil.addBtEntertainmentDetail(this);
		}
		else {
			BtEntertainmentDetailLocalServiceUtil.updateBtEntertainmentDetail(this);
		}
	}

	@Override
	public BtEntertainmentDetail toEscapedModel() {
		return (BtEntertainmentDetail)ProxyUtil.newProxyInstance(BtEntertainmentDetail.class.getClassLoader(),
			new Class[] { BtEntertainmentDetail.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BtEntertainmentDetailClp clone = new BtEntertainmentDetailClp();

		clone.setBtEntertainmentDetailId(getBtEntertainmentDetailId());
		clone.setBtCostListId(getBtCostListId());
		clone.setBusinessTripPkId(getBusinessTripPkId());
		clone.setFullName(getFullName());
		clone.setPositionTitle(getPositionTitle());
		clone.setCompany(getCompany());

		return clone;
	}

	@Override
	public int compareTo(BtEntertainmentDetail btEntertainmentDetail) {
		long primaryKey = btEntertainmentDetail.getPrimaryKey();

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

		if (!(obj instanceof BtEntertainmentDetailClp)) {
			return false;
		}

		BtEntertainmentDetailClp btEntertainmentDetail = (BtEntertainmentDetailClp)obj;

		long primaryKey = btEntertainmentDetail.getPrimaryKey();

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
		StringBundler sb = new StringBundler(13);

		sb.append("{btEntertainmentDetailId=");
		sb.append(getBtEntertainmentDetailId());
		sb.append(", btCostListId=");
		sb.append(getBtCostListId());
		sb.append(", businessTripPkId=");
		sb.append(getBusinessTripPkId());
		sb.append(", fullName=");
		sb.append(getFullName());
		sb.append(", positionTitle=");
		sb.append(getPositionTitle());
		sb.append(", company=");
		sb.append(getCompany());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.business.trip.model.BtEntertainmentDetail");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>btEntertainmentDetailId</column-name><column-value><![CDATA[");
		sb.append(getBtEntertainmentDetailId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>btCostListId</column-name><column-value><![CDATA[");
		sb.append(getBtCostListId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>businessTripPkId</column-name><column-value><![CDATA[");
		sb.append(getBusinessTripPkId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fullName</column-name><column-value><![CDATA[");
		sb.append(getFullName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>positionTitle</column-name><column-value><![CDATA[");
		sb.append(getPositionTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>company</column-name><column-value><![CDATA[");
		sb.append(getCompany());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _btEntertainmentDetailId;
	private long _btCostListId;
	private long _businessTripPkId;
	private String _fullName;
	private String _positionTitle;
	private String _company;
	private BaseModel<?> _btEntertainmentDetailRemoteModel;
	private Class<?> _clpSerializerClass = com.business.trip.service.ClpSerializer.class;
}