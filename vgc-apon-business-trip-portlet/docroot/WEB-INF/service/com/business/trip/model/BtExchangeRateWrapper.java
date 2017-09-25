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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link BtExchangeRate}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BtExchangeRate
 * @generated
 */
public class BtExchangeRateWrapper implements BtExchangeRate,
	ModelWrapper<BtExchangeRate> {
	public BtExchangeRateWrapper(BtExchangeRate btExchangeRate) {
		_btExchangeRate = btExchangeRate;
	}

	@Override
	public Class<?> getModelClass() {
		return BtExchangeRate.class;
	}

	@Override
	public String getModelClassName() {
		return BtExchangeRate.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("btExchangeRateId", getBtExchangeRateId());
		attributes.put("firstCurrency", getFirstCurrency());
		attributes.put("secondCurrency", getSecondCurrency());
		attributes.put("firToSecExchangeRate", getFirToSecExchangeRate());
		attributes.put("secToFirExchangeRate", getSecToFirExchangeRate());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long btExchangeRateId = (Long)attributes.get("btExchangeRateId");

		if (btExchangeRateId != null) {
			setBtExchangeRateId(btExchangeRateId);
		}

		String firstCurrency = (String)attributes.get("firstCurrency");

		if (firstCurrency != null) {
			setFirstCurrency(firstCurrency);
		}

		String secondCurrency = (String)attributes.get("secondCurrency");

		if (secondCurrency != null) {
			setSecondCurrency(secondCurrency);
		}

		Double firToSecExchangeRate = (Double)attributes.get(
				"firToSecExchangeRate");

		if (firToSecExchangeRate != null) {
			setFirToSecExchangeRate(firToSecExchangeRate);
		}

		Double secToFirExchangeRate = (Double)attributes.get(
				"secToFirExchangeRate");

		if (secToFirExchangeRate != null) {
			setSecToFirExchangeRate(secToFirExchangeRate);
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

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	* Returns the primary key of this bt exchange rate.
	*
	* @return the primary key of this bt exchange rate
	*/
	@Override
	public long getPrimaryKey() {
		return _btExchangeRate.getPrimaryKey();
	}

	/**
	* Sets the primary key of this bt exchange rate.
	*
	* @param primaryKey the primary key of this bt exchange rate
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_btExchangeRate.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the bt exchange rate ID of this bt exchange rate.
	*
	* @return the bt exchange rate ID of this bt exchange rate
	*/
	@Override
	public long getBtExchangeRateId() {
		return _btExchangeRate.getBtExchangeRateId();
	}

	/**
	* Sets the bt exchange rate ID of this bt exchange rate.
	*
	* @param btExchangeRateId the bt exchange rate ID of this bt exchange rate
	*/
	@Override
	public void setBtExchangeRateId(long btExchangeRateId) {
		_btExchangeRate.setBtExchangeRateId(btExchangeRateId);
	}

	/**
	* Returns the first currency of this bt exchange rate.
	*
	* @return the first currency of this bt exchange rate
	*/
	@Override
	public java.lang.String getFirstCurrency() {
		return _btExchangeRate.getFirstCurrency();
	}

	/**
	* Sets the first currency of this bt exchange rate.
	*
	* @param firstCurrency the first currency of this bt exchange rate
	*/
	@Override
	public void setFirstCurrency(java.lang.String firstCurrency) {
		_btExchangeRate.setFirstCurrency(firstCurrency);
	}

	/**
	* Returns the second currency of this bt exchange rate.
	*
	* @return the second currency of this bt exchange rate
	*/
	@Override
	public java.lang.String getSecondCurrency() {
		return _btExchangeRate.getSecondCurrency();
	}

	/**
	* Sets the second currency of this bt exchange rate.
	*
	* @param secondCurrency the second currency of this bt exchange rate
	*/
	@Override
	public void setSecondCurrency(java.lang.String secondCurrency) {
		_btExchangeRate.setSecondCurrency(secondCurrency);
	}

	/**
	* Returns the fir to sec exchange rate of this bt exchange rate.
	*
	* @return the fir to sec exchange rate of this bt exchange rate
	*/
	@Override
	public double getFirToSecExchangeRate() {
		return _btExchangeRate.getFirToSecExchangeRate();
	}

	/**
	* Sets the fir to sec exchange rate of this bt exchange rate.
	*
	* @param firToSecExchangeRate the fir to sec exchange rate of this bt exchange rate
	*/
	@Override
	public void setFirToSecExchangeRate(double firToSecExchangeRate) {
		_btExchangeRate.setFirToSecExchangeRate(firToSecExchangeRate);
	}

	/**
	* Returns the sec to fir exchange rate of this bt exchange rate.
	*
	* @return the sec to fir exchange rate of this bt exchange rate
	*/
	@Override
	public double getSecToFirExchangeRate() {
		return _btExchangeRate.getSecToFirExchangeRate();
	}

	/**
	* Sets the sec to fir exchange rate of this bt exchange rate.
	*
	* @param secToFirExchangeRate the sec to fir exchange rate of this bt exchange rate
	*/
	@Override
	public void setSecToFirExchangeRate(double secToFirExchangeRate) {
		_btExchangeRate.setSecToFirExchangeRate(secToFirExchangeRate);
	}

	/**
	* Returns the user ID of this bt exchange rate.
	*
	* @return the user ID of this bt exchange rate
	*/
	@Override
	public long getUserId() {
		return _btExchangeRate.getUserId();
	}

	/**
	* Sets the user ID of this bt exchange rate.
	*
	* @param userId the user ID of this bt exchange rate
	*/
	@Override
	public void setUserId(long userId) {
		_btExchangeRate.setUserId(userId);
	}

	/**
	* Returns the user uuid of this bt exchange rate.
	*
	* @return the user uuid of this bt exchange rate
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btExchangeRate.getUserUuid();
	}

	/**
	* Sets the user uuid of this bt exchange rate.
	*
	* @param userUuid the user uuid of this bt exchange rate
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_btExchangeRate.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this bt exchange rate.
	*
	* @return the user name of this bt exchange rate
	*/
	@Override
	public java.lang.String getUserName() {
		return _btExchangeRate.getUserName();
	}

	/**
	* Sets the user name of this bt exchange rate.
	*
	* @param userName the user name of this bt exchange rate
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_btExchangeRate.setUserName(userName);
	}

	/**
	* Returns the create date of this bt exchange rate.
	*
	* @return the create date of this bt exchange rate
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _btExchangeRate.getCreateDate();
	}

	/**
	* Sets the create date of this bt exchange rate.
	*
	* @param createDate the create date of this bt exchange rate
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_btExchangeRate.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this bt exchange rate.
	*
	* @return the modified date of this bt exchange rate
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _btExchangeRate.getModifiedDate();
	}

	/**
	* Sets the modified date of this bt exchange rate.
	*
	* @param modifiedDate the modified date of this bt exchange rate
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_btExchangeRate.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the status of this bt exchange rate.
	*
	* @return the status of this bt exchange rate
	*/
	@Override
	public int getStatus() {
		return _btExchangeRate.getStatus();
	}

	/**
	* Sets the status of this bt exchange rate.
	*
	* @param status the status of this bt exchange rate
	*/
	@Override
	public void setStatus(int status) {
		_btExchangeRate.setStatus(status);
	}

	@Override
	public boolean isNew() {
		return _btExchangeRate.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_btExchangeRate.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _btExchangeRate.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_btExchangeRate.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _btExchangeRate.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _btExchangeRate.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_btExchangeRate.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _btExchangeRate.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_btExchangeRate.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_btExchangeRate.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_btExchangeRate.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BtExchangeRateWrapper((BtExchangeRate)_btExchangeRate.clone());
	}

	@Override
	public int compareTo(com.business.trip.model.BtExchangeRate btExchangeRate) {
		return _btExchangeRate.compareTo(btExchangeRate);
	}

	@Override
	public int hashCode() {
		return _btExchangeRate.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.business.trip.model.BtExchangeRate> toCacheModel() {
		return _btExchangeRate.toCacheModel();
	}

	@Override
	public com.business.trip.model.BtExchangeRate toEscapedModel() {
		return new BtExchangeRateWrapper(_btExchangeRate.toEscapedModel());
	}

	@Override
	public com.business.trip.model.BtExchangeRate toUnescapedModel() {
		return new BtExchangeRateWrapper(_btExchangeRate.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _btExchangeRate.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _btExchangeRate.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_btExchangeRate.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BtExchangeRateWrapper)) {
			return false;
		}

		BtExchangeRateWrapper btExchangeRateWrapper = (BtExchangeRateWrapper)obj;

		if (Validator.equals(_btExchangeRate,
					btExchangeRateWrapper._btExchangeRate)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public BtExchangeRate getWrappedBtExchangeRate() {
		return _btExchangeRate;
	}

	@Override
	public BtExchangeRate getWrappedModel() {
		return _btExchangeRate;
	}

	@Override
	public void resetOriginalValues() {
		_btExchangeRate.resetOriginalValues();
	}

	private BtExchangeRate _btExchangeRate;
}