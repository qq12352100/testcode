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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CompanyCarManagement}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CompanyCarManagement
 * @generated
 */
public class CompanyCarManagementWrapper implements CompanyCarManagement,
	ModelWrapper<CompanyCarManagement> {
	public CompanyCarManagementWrapper(
		CompanyCarManagement companyCarManagement) {
		_companyCarManagement = companyCarManagement;
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

	/**
	* Returns the primary key of this company car management.
	*
	* @return the primary key of this company car management
	*/
	@Override
	public long getPrimaryKey() {
		return _companyCarManagement.getPrimaryKey();
	}

	/**
	* Sets the primary key of this company car management.
	*
	* @param primaryKey the primary key of this company car management
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_companyCarManagement.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the company car management ID of this company car management.
	*
	* @return the company car management ID of this company car management
	*/
	@Override
	public long getCompanyCarManagementId() {
		return _companyCarManagement.getCompanyCarManagementId();
	}

	/**
	* Sets the company car management ID of this company car management.
	*
	* @param companyCarManagementId the company car management ID of this company car management
	*/
	@Override
	public void setCompanyCarManagementId(long companyCarManagementId) {
		_companyCarManagement.setCompanyCarManagementId(companyCarManagementId);
	}

	/**
	* Returns the create date of this company car management.
	*
	* @return the create date of this company car management
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _companyCarManagement.getCreateDate();
	}

	/**
	* Sets the create date of this company car management.
	*
	* @param createDate the create date of this company car management
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_companyCarManagement.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this company car management.
	*
	* @return the modified date of this company car management
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _companyCarManagement.getModifiedDate();
	}

	/**
	* Sets the modified date of this company car management.
	*
	* @param modifiedDate the modified date of this company car management
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_companyCarManagement.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the car no of this company car management.
	*
	* @return the car no of this company car management
	*/
	@Override
	public java.lang.String getCarNo() {
		return _companyCarManagement.getCarNo();
	}

	/**
	* Sets the car no of this company car management.
	*
	* @param carNo the car no of this company car management
	*/
	@Override
	public void setCarNo(java.lang.String carNo) {
		_companyCarManagement.setCarNo(carNo);
	}

	/**
	* Returns the car type of this company car management.
	*
	* @return the car type of this company car management
	*/
	@Override
	public java.lang.String getCarType() {
		return _companyCarManagement.getCarType();
	}

	/**
	* Sets the car type of this company car management.
	*
	* @param carType the car type of this company car management
	*/
	@Override
	public void setCarType(java.lang.String carType) {
		_companyCarManagement.setCarType(carType);
	}

	/**
	* Returns the contract type of this company car management.
	*
	* @return the contract type of this company car management
	*/
	@Override
	public java.lang.String getContractType() {
		return _companyCarManagement.getContractType();
	}

	/**
	* Sets the contract type of this company car management.
	*
	* @param contractType the contract type of this company car management
	*/
	@Override
	public void setContractType(java.lang.String contractType) {
		_companyCarManagement.setContractType(contractType);
	}

	/**
	* Returns the grade type of this company car management.
	*
	* @return the grade type of this company car management
	*/
	@Override
	public java.lang.String getGradeType() {
		return _companyCarManagement.getGradeType();
	}

	/**
	* Sets the grade type of this company car management.
	*
	* @param gradeType the grade type of this company car management
	*/
	@Override
	public void setGradeType(java.lang.String gradeType) {
		_companyCarManagement.setGradeType(gradeType);
	}

	/**
	* Returns the grade of this company car management.
	*
	* @return the grade of this company car management
	*/
	@Override
	public java.lang.String getGrade() {
		return _companyCarManagement.getGrade();
	}

	/**
	* Sets the grade of this company car management.
	*
	* @param grade the grade of this company car management
	*/
	@Override
	public void setGrade(java.lang.String grade) {
		_companyCarManagement.setGrade(grade);
	}

	/**
	* Returns the car brand of this company car management.
	*
	* @return the car brand of this company car management
	*/
	@Override
	public java.lang.String getCarBrand() {
		return _companyCarManagement.getCarBrand();
	}

	/**
	* Sets the car brand of this company car management.
	*
	* @param carBrand the car brand of this company car management
	*/
	@Override
	public void setCarBrand(java.lang.String carBrand) {
		_companyCarManagement.setCarBrand(carBrand);
	}

	/**
	* Returns the car model of this company car management.
	*
	* @return the car model of this company car management
	*/
	@Override
	public java.lang.String getCarModel() {
		return _companyCarManagement.getCarModel();
	}

	/**
	* Sets the car model of this company car management.
	*
	* @param carModel the car model of this company car management
	*/
	@Override
	public void setCarModel(java.lang.String carModel) {
		_companyCarManagement.setCarModel(carModel);
	}

	/**
	* Returns the car category of this company car management.
	*
	* @return the car category of this company car management
	*/
	@Override
	public java.lang.String getCarCategory() {
		return _companyCarManagement.getCarCategory();
	}

	/**
	* Sets the car category of this company car management.
	*
	* @param carCategory the car category of this company car management
	*/
	@Override
	public void setCarCategory(java.lang.String carCategory) {
		_companyCarManagement.setCarCategory(carCategory);
	}

	@Override
	public boolean isNew() {
		return _companyCarManagement.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_companyCarManagement.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _companyCarManagement.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_companyCarManagement.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _companyCarManagement.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _companyCarManagement.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_companyCarManagement.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _companyCarManagement.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_companyCarManagement.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_companyCarManagement.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_companyCarManagement.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CompanyCarManagementWrapper((CompanyCarManagement)_companyCarManagement.clone());
	}

	@Override
	public int compareTo(
		com.company.car.model.CompanyCarManagement companyCarManagement) {
		return _companyCarManagement.compareTo(companyCarManagement);
	}

	@Override
	public int hashCode() {
		return _companyCarManagement.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.company.car.model.CompanyCarManagement> toCacheModel() {
		return _companyCarManagement.toCacheModel();
	}

	@Override
	public com.company.car.model.CompanyCarManagement toEscapedModel() {
		return new CompanyCarManagementWrapper(_companyCarManagement.toEscapedModel());
	}

	@Override
	public com.company.car.model.CompanyCarManagement toUnescapedModel() {
		return new CompanyCarManagementWrapper(_companyCarManagement.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _companyCarManagement.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _companyCarManagement.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_companyCarManagement.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CompanyCarManagementWrapper)) {
			return false;
		}

		CompanyCarManagementWrapper companyCarManagementWrapper = (CompanyCarManagementWrapper)obj;

		if (Validator.equals(_companyCarManagement,
					companyCarManagementWrapper._companyCarManagement)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CompanyCarManagement getWrappedCompanyCarManagement() {
		return _companyCarManagement;
	}

	@Override
	public CompanyCarManagement getWrappedModel() {
		return _companyCarManagement;
	}

	@Override
	public void resetOriginalValues() {
		_companyCarManagement.resetOriginalValues();
	}

	private CompanyCarManagement _companyCarManagement;
}