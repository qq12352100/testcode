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

package com.e.onboarding.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.e.onboarding.service.http.DistributionServiceSoap}.
 *
 * @author sanguine
 * @see com.e.onboarding.service.http.DistributionServiceSoap
 * @generated
 */
public class DistributionSoap implements Serializable {
	public static DistributionSoap toSoapModel(Distribution model) {
		DistributionSoap soapModel = new DistributionSoap();

		soapModel.setDistributionId(model.getDistributionId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setEmailAddress(model.getEmailAddress());
		soapModel.setName(model.getName());
		soapModel.setComments(model.getComments());
		soapModel.setType(model.getType());

		return soapModel;
	}

	public static DistributionSoap[] toSoapModels(Distribution[] models) {
		DistributionSoap[] soapModels = new DistributionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DistributionSoap[][] toSoapModels(Distribution[][] models) {
		DistributionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DistributionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DistributionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DistributionSoap[] toSoapModels(List<Distribution> models) {
		List<DistributionSoap> soapModels = new ArrayList<DistributionSoap>(models.size());

		for (Distribution model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DistributionSoap[soapModels.size()]);
	}

	public DistributionSoap() {
	}

	public long getPrimaryKey() {
		return _distributionId;
	}

	public void setPrimaryKey(long pk) {
		setDistributionId(pk);
	}

	public long getDistributionId() {
		return _distributionId;
	}

	public void setDistributionId(long distributionId) {
		_distributionId = distributionId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
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

	public String getEmailAddress() {
		return _emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getComments() {
		return _comments;
	}

	public void setComments(String comments) {
		_comments = comments;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	private long _distributionId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _emailAddress;
	private String _name;
	private String _comments;
	private String _type;
}