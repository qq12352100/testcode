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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Distribution}.
 * </p>
 *
 * @author sanguine
 * @see Distribution
 * @generated
 */
public class DistributionWrapper implements Distribution,
	ModelWrapper<Distribution> {
	public DistributionWrapper(Distribution distribution) {
		_distribution = distribution;
	}

	@Override
	public Class<?> getModelClass() {
		return Distribution.class;
	}

	@Override
	public String getModelClassName() {
		return Distribution.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("distributionId", getDistributionId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("name", getName());
		attributes.put("comments", getComments());
		attributes.put("type", getType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long distributionId = (Long)attributes.get("distributionId");

		if (distributionId != null) {
			setDistributionId(distributionId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
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

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}
	}

	/**
	* Returns the primary key of this distribution.
	*
	* @return the primary key of this distribution
	*/
	@Override
	public long getPrimaryKey() {
		return _distribution.getPrimaryKey();
	}

	/**
	* Sets the primary key of this distribution.
	*
	* @param primaryKey the primary key of this distribution
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_distribution.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the distribution ID of this distribution.
	*
	* @return the distribution ID of this distribution
	*/
	@Override
	public long getDistributionId() {
		return _distribution.getDistributionId();
	}

	/**
	* Sets the distribution ID of this distribution.
	*
	* @param distributionId the distribution ID of this distribution
	*/
	@Override
	public void setDistributionId(long distributionId) {
		_distribution.setDistributionId(distributionId);
	}

	/**
	* Returns the group ID of this distribution.
	*
	* @return the group ID of this distribution
	*/
	@Override
	public long getGroupId() {
		return _distribution.getGroupId();
	}

	/**
	* Sets the group ID of this distribution.
	*
	* @param groupId the group ID of this distribution
	*/
	@Override
	public void setGroupId(long groupId) {
		_distribution.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this distribution.
	*
	* @return the company ID of this distribution
	*/
	@Override
	public long getCompanyId() {
		return _distribution.getCompanyId();
	}

	/**
	* Sets the company ID of this distribution.
	*
	* @param companyId the company ID of this distribution
	*/
	@Override
	public void setCompanyId(long companyId) {
		_distribution.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this distribution.
	*
	* @return the user ID of this distribution
	*/
	@Override
	public long getUserId() {
		return _distribution.getUserId();
	}

	/**
	* Sets the user ID of this distribution.
	*
	* @param userId the user ID of this distribution
	*/
	@Override
	public void setUserId(long userId) {
		_distribution.setUserId(userId);
	}

	/**
	* Returns the user uuid of this distribution.
	*
	* @return the user uuid of this distribution
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _distribution.getUserUuid();
	}

	/**
	* Sets the user uuid of this distribution.
	*
	* @param userUuid the user uuid of this distribution
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_distribution.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this distribution.
	*
	* @return the user name of this distribution
	*/
	@Override
	public java.lang.String getUserName() {
		return _distribution.getUserName();
	}

	/**
	* Sets the user name of this distribution.
	*
	* @param userName the user name of this distribution
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_distribution.setUserName(userName);
	}

	/**
	* Returns the create date of this distribution.
	*
	* @return the create date of this distribution
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _distribution.getCreateDate();
	}

	/**
	* Sets the create date of this distribution.
	*
	* @param createDate the create date of this distribution
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_distribution.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this distribution.
	*
	* @return the modified date of this distribution
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _distribution.getModifiedDate();
	}

	/**
	* Sets the modified date of this distribution.
	*
	* @param modifiedDate the modified date of this distribution
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_distribution.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the email address of this distribution.
	*
	* @return the email address of this distribution
	*/
	@Override
	public java.lang.String getEmailAddress() {
		return _distribution.getEmailAddress();
	}

	/**
	* Sets the email address of this distribution.
	*
	* @param emailAddress the email address of this distribution
	*/
	@Override
	public void setEmailAddress(java.lang.String emailAddress) {
		_distribution.setEmailAddress(emailAddress);
	}

	/**
	* Returns the name of this distribution.
	*
	* @return the name of this distribution
	*/
	@Override
	public java.lang.String getName() {
		return _distribution.getName();
	}

	/**
	* Sets the name of this distribution.
	*
	* @param name the name of this distribution
	*/
	@Override
	public void setName(java.lang.String name) {
		_distribution.setName(name);
	}

	/**
	* Returns the comments of this distribution.
	*
	* @return the comments of this distribution
	*/
	@Override
	public java.lang.String getComments() {
		return _distribution.getComments();
	}

	/**
	* Sets the comments of this distribution.
	*
	* @param comments the comments of this distribution
	*/
	@Override
	public void setComments(java.lang.String comments) {
		_distribution.setComments(comments);
	}

	/**
	* Returns the type of this distribution.
	*
	* @return the type of this distribution
	*/
	@Override
	public java.lang.String getType() {
		return _distribution.getType();
	}

	/**
	* Sets the type of this distribution.
	*
	* @param type the type of this distribution
	*/
	@Override
	public void setType(java.lang.String type) {
		_distribution.setType(type);
	}

	@Override
	public boolean isNew() {
		return _distribution.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_distribution.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _distribution.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_distribution.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _distribution.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _distribution.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_distribution.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _distribution.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_distribution.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_distribution.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_distribution.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DistributionWrapper((Distribution)_distribution.clone());
	}

	@Override
	public int compareTo(com.e.onboarding.model.Distribution distribution) {
		return _distribution.compareTo(distribution);
	}

	@Override
	public int hashCode() {
		return _distribution.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.e.onboarding.model.Distribution> toCacheModel() {
		return _distribution.toCacheModel();
	}

	@Override
	public com.e.onboarding.model.Distribution toEscapedModel() {
		return new DistributionWrapper(_distribution.toEscapedModel());
	}

	@Override
	public com.e.onboarding.model.Distribution toUnescapedModel() {
		return new DistributionWrapper(_distribution.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _distribution.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _distribution.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_distribution.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DistributionWrapper)) {
			return false;
		}

		DistributionWrapper distributionWrapper = (DistributionWrapper)obj;

		if (Validator.equals(_distribution, distributionWrapper._distribution)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Distribution getWrappedDistribution() {
		return _distribution;
	}

	@Override
	public Distribution getWrappedModel() {
		return _distribution;
	}

	@Override
	public void resetOriginalValues() {
		_distribution.resetOriginalValues();
	}

	private Distribution _distribution;
}