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

package com.company.car.model;

import com.company.car.service.ClpSerializer;
import com.company.car.service.CompanyCarManagementLocalServiceUtil;

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
public class CompanyCarManagementClp extends BaseModelImpl<CompanyCarManagement>
	implements CompanyCarManagement {
	public CompanyCarManagementClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return CompanyCarManagement.class;
	}

	@Override
	public String getModelClassName() {
		return CompanyCarManagement.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _companyCarManagementId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCompanyCarManagementId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _companyCarManagementId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("companyCarManagementId", getCompanyCarManagementId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("carNo", getCarNo());
		attributes.put("carType", getCarType());
		attributes.put("contractType", getContractType());
		attributes.put("gradeType", getGradeType());
		attributes.put("grade", getGrade());
		attributes.put("carBrand", getCarBrand());
		attributes.put("carModel", getCarModel());
		attributes.put("carCategory", getCarCategory());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long companyCarManagementId = (Long)attributes.get(
				"companyCarManagementId");

		if (companyCarManagementId != null) {
			setCompanyCarManagementId(companyCarManagementId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String carNo = (String)attributes.get("carNo");

		if (carNo != null) {
			setCarNo(carNo);
		}

		String carType = (String)attributes.get("carType");

		if (carType != null) {
			setCarType(carType);
		}

		String contractType = (String)attributes.get("contractType");

		if (contractType != null) {
			setContractType(contractType);
		}

		String gradeType = (String)attributes.get("gradeType");

		if (gradeType != null) {
			setGradeType(gradeType);
		}

		String grade = (String)attributes.get("grade");

		if (grade != null) {
			setGrade(grade);
		}

		String carBrand = (String)attributes.get("carBrand");

		if (carBrand != null) {
			setCarBrand(carBrand);
		}

		String carModel = (String)attributes.get("carModel");

		if (carModel != null) {
			setCarModel(carModel);
		}

		String carCategory = (String)attributes.get("carCategory");

		if (carCategory != null) {
			setCarCategory(carCategory);
		}
	}

	@Override
	public long getCompanyCarManagementId() {
		return _companyCarManagementId;
	}

	@Override
	public void setCompanyCarManagementId(long companyCarManagementId) {
		_companyCarManagementId = companyCarManagementId;

		if (_companyCarManagementRemoteModel != null) {
			try {
				Class<?> clazz = _companyCarManagementRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyCarManagementId",
						long.class);

				method.invoke(_companyCarManagementRemoteModel,
					companyCarManagementId);
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

		if (_companyCarManagementRemoteModel != null) {
			try {
				Class<?> clazz = _companyCarManagementRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_companyCarManagementRemoteModel, createDate);
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

		if (_companyCarManagementRemoteModel != null) {
			try {
				Class<?> clazz = _companyCarManagementRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_companyCarManagementRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCarNo() {
		return _carNo;
	}

	@Override
	public void setCarNo(String carNo) {
		_carNo = carNo;

		if (_companyCarManagementRemoteModel != null) {
			try {
				Class<?> clazz = _companyCarManagementRemoteModel.getClass();

				Method method = clazz.getMethod("setCarNo", String.class);

				method.invoke(_companyCarManagementRemoteModel, carNo);
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

		if (_companyCarManagementRemoteModel != null) {
			try {
				Class<?> clazz = _companyCarManagementRemoteModel.getClass();

				Method method = clazz.getMethod("setCarType", String.class);

				method.invoke(_companyCarManagementRemoteModel, carType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContractType() {
		return _contractType;
	}

	@Override
	public void setContractType(String contractType) {
		_contractType = contractType;

		if (_companyCarManagementRemoteModel != null) {
			try {
				Class<?> clazz = _companyCarManagementRemoteModel.getClass();

				Method method = clazz.getMethod("setContractType", String.class);

				method.invoke(_companyCarManagementRemoteModel, contractType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGradeType() {
		return _gradeType;
	}

	@Override
	public void setGradeType(String gradeType) {
		_gradeType = gradeType;

		if (_companyCarManagementRemoteModel != null) {
			try {
				Class<?> clazz = _companyCarManagementRemoteModel.getClass();

				Method method = clazz.getMethod("setGradeType", String.class);

				method.invoke(_companyCarManagementRemoteModel, gradeType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGrade() {
		return _grade;
	}

	@Override
	public void setGrade(String grade) {
		_grade = grade;

		if (_companyCarManagementRemoteModel != null) {
			try {
				Class<?> clazz = _companyCarManagementRemoteModel.getClass();

				Method method = clazz.getMethod("setGrade", String.class);

				method.invoke(_companyCarManagementRemoteModel, grade);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCarBrand() {
		return _carBrand;
	}

	@Override
	public void setCarBrand(String carBrand) {
		_carBrand = carBrand;

		if (_companyCarManagementRemoteModel != null) {
			try {
				Class<?> clazz = _companyCarManagementRemoteModel.getClass();

				Method method = clazz.getMethod("setCarBrand", String.class);

				method.invoke(_companyCarManagementRemoteModel, carBrand);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCarModel() {
		return _carModel;
	}

	@Override
	public void setCarModel(String carModel) {
		_carModel = carModel;

		if (_companyCarManagementRemoteModel != null) {
			try {
				Class<?> clazz = _companyCarManagementRemoteModel.getClass();

				Method method = clazz.getMethod("setCarModel", String.class);

				method.invoke(_companyCarManagementRemoteModel, carModel);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCarCategory() {
		return _carCategory;
	}

	@Override
	public void setCarCategory(String carCategory) {
		_carCategory = carCategory;

		if (_companyCarManagementRemoteModel != null) {
			try {
				Class<?> clazz = _companyCarManagementRemoteModel.getClass();

				Method method = clazz.getMethod("setCarCategory", String.class);

				method.invoke(_companyCarManagementRemoteModel, carCategory);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCompanyCarManagementRemoteModel() {
		return _companyCarManagementRemoteModel;
	}

	public void setCompanyCarManagementRemoteModel(
		BaseModel<?> companyCarManagementRemoteModel) {
		_companyCarManagementRemoteModel = companyCarManagementRemoteModel;
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

		Class<?> remoteModelClass = _companyCarManagementRemoteModel.getClass();

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

		Object returnValue = method.invoke(_companyCarManagementRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CompanyCarManagementLocalServiceUtil.addCompanyCarManagement(this);
		}
		else {
			CompanyCarManagementLocalServiceUtil.updateCompanyCarManagement(this);
		}
	}

	@Override
	public CompanyCarManagement toEscapedModel() {
		return (CompanyCarManagement)ProxyUtil.newProxyInstance(CompanyCarManagement.class.getClassLoader(),
			new Class[] { CompanyCarManagement.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CompanyCarManagementClp clone = new CompanyCarManagementClp();

		clone.setCompanyCarManagementId(getCompanyCarManagementId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setCarNo(getCarNo());
		clone.setCarType(getCarType());
		clone.setContractType(getContractType());
		clone.setGradeType(getGradeType());
		clone.setGrade(getGrade());
		clone.setCarBrand(getCarBrand());
		clone.setCarModel(getCarModel());
		clone.setCarCategory(getCarCategory());

		return clone;
	}

	@Override
	public int compareTo(CompanyCarManagement companyCarManagement) {
		int value = 0;

		value = getCarCategory().compareTo(companyCarManagement.getCarCategory());

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

		if (!(obj instanceof CompanyCarManagementClp)) {
			return false;
		}

		CompanyCarManagementClp companyCarManagement = (CompanyCarManagementClp)obj;

		long primaryKey = companyCarManagement.getPrimaryKey();

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

		sb.append("{companyCarManagementId=");
		sb.append(getCompanyCarManagementId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", carNo=");
		sb.append(getCarNo());
		sb.append(", carType=");
		sb.append(getCarType());
		sb.append(", contractType=");
		sb.append(getContractType());
		sb.append(", gradeType=");
		sb.append(getGradeType());
		sb.append(", grade=");
		sb.append(getGrade());
		sb.append(", carBrand=");
		sb.append(getCarBrand());
		sb.append(", carModel=");
		sb.append(getCarModel());
		sb.append(", carCategory=");
		sb.append(getCarCategory());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.company.car.model.CompanyCarManagement");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>companyCarManagementId</column-name><column-value><![CDATA[");
		sb.append(getCompanyCarManagementId());
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
			"<column><column-name>carNo</column-name><column-value><![CDATA[");
		sb.append(getCarNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>carType</column-name><column-value><![CDATA[");
		sb.append(getCarType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contractType</column-name><column-value><![CDATA[");
		sb.append(getContractType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gradeType</column-name><column-value><![CDATA[");
		sb.append(getGradeType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>grade</column-name><column-value><![CDATA[");
		sb.append(getGrade());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>carBrand</column-name><column-value><![CDATA[");
		sb.append(getCarBrand());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>carModel</column-name><column-value><![CDATA[");
		sb.append(getCarModel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>carCategory</column-name><column-value><![CDATA[");
		sb.append(getCarCategory());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _companyCarManagementId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _carNo;
	private String _carType;
	private String _contractType;
	private String _gradeType;
	private String _grade;
	private String _carBrand;
	private String _carModel;
	private String _carCategory;
	private BaseModel<?> _companyCarManagementRemoteModel;
	private Class<?> _clpSerializerClass = com.company.car.service.ClpSerializer.class;
}