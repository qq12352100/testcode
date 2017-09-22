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

package com.company.car.model.impl;

import com.company.car.model.CompanyCarManagement;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CompanyCarManagement in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see CompanyCarManagement
 * @generated
 */
public class CompanyCarManagementCacheModel implements CacheModel<CompanyCarManagement>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{companyCarManagementId=");
		sb.append(companyCarManagementId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", carNo=");
		sb.append(carNo);
		sb.append(", carType=");
		sb.append(carType);
		sb.append(", contractType=");
		sb.append(contractType);
		sb.append(", gradeType=");
		sb.append(gradeType);
		sb.append(", grade=");
		sb.append(grade);
		sb.append(", carBrand=");
		sb.append(carBrand);
		sb.append(", carModel=");
		sb.append(carModel);
		sb.append(", carCategory=");
		sb.append(carCategory);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CompanyCarManagement toEntityModel() {
		CompanyCarManagementImpl companyCarManagementImpl = new CompanyCarManagementImpl();

		companyCarManagementImpl.setCompanyCarManagementId(companyCarManagementId);

		if (createDate == Long.MIN_VALUE) {
			companyCarManagementImpl.setCreateDate(null);
		}
		else {
			companyCarManagementImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			companyCarManagementImpl.setModifiedDate(null);
		}
		else {
			companyCarManagementImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (carNo == null) {
			companyCarManagementImpl.setCarNo(StringPool.BLANK);
		}
		else {
			companyCarManagementImpl.setCarNo(carNo);
		}

		if (carType == null) {
			companyCarManagementImpl.setCarType(StringPool.BLANK);
		}
		else {
			companyCarManagementImpl.setCarType(carType);
		}

		if (contractType == null) {
			companyCarManagementImpl.setContractType(StringPool.BLANK);
		}
		else {
			companyCarManagementImpl.setContractType(contractType);
		}

		if (gradeType == null) {
			companyCarManagementImpl.setGradeType(StringPool.BLANK);
		}
		else {
			companyCarManagementImpl.setGradeType(gradeType);
		}

		if (grade == null) {
			companyCarManagementImpl.setGrade(StringPool.BLANK);
		}
		else {
			companyCarManagementImpl.setGrade(grade);
		}

		if (carBrand == null) {
			companyCarManagementImpl.setCarBrand(StringPool.BLANK);
		}
		else {
			companyCarManagementImpl.setCarBrand(carBrand);
		}

		if (carModel == null) {
			companyCarManagementImpl.setCarModel(StringPool.BLANK);
		}
		else {
			companyCarManagementImpl.setCarModel(carModel);
		}

		if (carCategory == null) {
			companyCarManagementImpl.setCarCategory(StringPool.BLANK);
		}
		else {
			companyCarManagementImpl.setCarCategory(carCategory);
		}

		companyCarManagementImpl.resetOriginalValues();

		return companyCarManagementImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		companyCarManagementId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		carNo = objectInput.readUTF();
		carType = objectInput.readUTF();
		contractType = objectInput.readUTF();
		gradeType = objectInput.readUTF();
		grade = objectInput.readUTF();
		carBrand = objectInput.readUTF();
		carModel = objectInput.readUTF();
		carCategory = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(companyCarManagementId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (carNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(carNo);
		}

		if (carType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(carType);
		}

		if (contractType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contractType);
		}

		if (gradeType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(gradeType);
		}

		if (grade == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(grade);
		}

		if (carBrand == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(carBrand);
		}

		if (carModel == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(carModel);
		}

		if (carCategory == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(carCategory);
		}
	}

	public long companyCarManagementId;
	public long createDate;
	public long modifiedDate;
	public String carNo;
	public String carType;
	public String contractType;
	public String gradeType;
	public String grade;
	public String carBrand;
	public String carModel;
	public String carCategory;
}