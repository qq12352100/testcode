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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.company.car.service.http.CompanyCarManagementServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.company.car.service.http.CompanyCarManagementServiceSoap
 * @generated
 */
public class CompanyCarManagementSoap implements Serializable {
	public static CompanyCarManagementSoap toSoapModel(
		CompanyCarManagement model) {
		CompanyCarManagementSoap soapModel = new CompanyCarManagementSoap();

		soapModel.setCompanyCarManagementId(model.getCompanyCarManagementId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCarNo(model.getCarNo());
		soapModel.setCarType(model.getCarType());
		soapModel.setContractType(model.getContractType());
		soapModel.setGradeType(model.getGradeType());
		soapModel.setGrade(model.getGrade());
		soapModel.setCarBrand(model.getCarBrand());
		soapModel.setCarModel(model.getCarModel());
		soapModel.setCarCategory(model.getCarCategory());

		return soapModel;
	}

	public static CompanyCarManagementSoap[] toSoapModels(
		CompanyCarManagement[] models) {
		CompanyCarManagementSoap[] soapModels = new CompanyCarManagementSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CompanyCarManagementSoap[][] toSoapModels(
		CompanyCarManagement[][] models) {
		CompanyCarManagementSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CompanyCarManagementSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CompanyCarManagementSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CompanyCarManagementSoap[] toSoapModels(
		List<CompanyCarManagement> models) {
		List<CompanyCarManagementSoap> soapModels = new ArrayList<CompanyCarManagementSoap>(models.size());

		for (CompanyCarManagement model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CompanyCarManagementSoap[soapModels.size()]);
	}

	public CompanyCarManagementSoap() {
	}

	public long getPrimaryKey() {
		return _companyCarManagementId;
	}

	public void setPrimaryKey(long pk) {
		setCompanyCarManagementId(pk);
	}

	public long getCompanyCarManagementId() {
		return _companyCarManagementId;
	}

	public void setCompanyCarManagementId(long companyCarManagementId) {
		_companyCarManagementId = companyCarManagementId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getCarNo() {
		return _carNo;
	}

	public void setCarNo(String carNo) {
		_carNo = carNo;
	}

	public String getCarType() {
		return _carType;
	}

	public void setCarType(String carType) {
		_carType = carType;
	}

	public String getContractType() {
		return _contractType;
	}

	public void setContractType(String contractType) {
		_contractType = contractType;
	}

	public String getGradeType() {
		return _gradeType;
	}

	public void setGradeType(String gradeType) {
		_gradeType = gradeType;
	}

	public String getGrade() {
		return _grade;
	}

	public void setGrade(String grade) {
		_grade = grade;
	}

	public String getCarBrand() {
		return _carBrand;
	}

	public void setCarBrand(String carBrand) {
		_carBrand = carBrand;
	}

	public String getCarModel() {
		return _carModel;
	}

	public void setCarModel(String carModel) {
		_carModel = carModel;
	}

	public String getCarCategory() {
		return _carCategory;
	}

	public void setCarCategory(String carCategory) {
		_carCategory = carCategory;
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
}