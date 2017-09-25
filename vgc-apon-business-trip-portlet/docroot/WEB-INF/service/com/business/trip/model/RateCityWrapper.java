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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link RateCity}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RateCity
 * @generated
 */
public class RateCityWrapper implements RateCity, ModelWrapper<RateCity> {
	public RateCityWrapper(RateCity rateCity) {
		_rateCity = rateCity;
	}

	@Override
	public Class<?> getModelClass() {
		return RateCity.class;
	}

	@Override
	public String getModelClassName() {
		return RateCity.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ratecityId", getRatecityId());
		attributes.put("areaName", getAreaName());
		attributes.put("rateOfDma", getRateOfDma());
		attributes.put("currency", getCurrency());
		attributes.put("parentId", getParentId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ratecityId = (Long)attributes.get("ratecityId");

		if (ratecityId != null) {
			setRatecityId(ratecityId);
		}

		String areaName = (String)attributes.get("areaName");

		if (areaName != null) {
			setAreaName(areaName);
		}

		Double rateOfDma = (Double)attributes.get("rateOfDma");

		if (rateOfDma != null) {
			setRateOfDma(rateOfDma);
		}

		String currency = (String)attributes.get("currency");

		if (currency != null) {
			setCurrency(currency);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}
	}

	/**
	* Returns the primary key of this rate city.
	*
	* @return the primary key of this rate city
	*/
	@Override
	public long getPrimaryKey() {
		return _rateCity.getPrimaryKey();
	}

	/**
	* Sets the primary key of this rate city.
	*
	* @param primaryKey the primary key of this rate city
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_rateCity.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ratecity ID of this rate city.
	*
	* @return the ratecity ID of this rate city
	*/
	@Override
	public long getRatecityId() {
		return _rateCity.getRatecityId();
	}

	/**
	* Sets the ratecity ID of this rate city.
	*
	* @param ratecityId the ratecity ID of this rate city
	*/
	@Override
	public void setRatecityId(long ratecityId) {
		_rateCity.setRatecityId(ratecityId);
	}

	/**
	* Returns the area name of this rate city.
	*
	* @return the area name of this rate city
	*/
	@Override
	public java.lang.String getAreaName() {
		return _rateCity.getAreaName();
	}

	/**
	* Sets the area name of this rate city.
	*
	* @param areaName the area name of this rate city
	*/
	@Override
	public void setAreaName(java.lang.String areaName) {
		_rateCity.setAreaName(areaName);
	}

	/**
	* Returns the rate of dma of this rate city.
	*
	* @return the rate of dma of this rate city
	*/
	@Override
	public double getRateOfDma() {
		return _rateCity.getRateOfDma();
	}

	/**
	* Sets the rate of dma of this rate city.
	*
	* @param rateOfDma the rate of dma of this rate city
	*/
	@Override
	public void setRateOfDma(double rateOfDma) {
		_rateCity.setRateOfDma(rateOfDma);
	}

	/**
	* Returns the currency of this rate city.
	*
	* @return the currency of this rate city
	*/
	@Override
	public java.lang.String getCurrency() {
		return _rateCity.getCurrency();
	}

	/**
	* Sets the currency of this rate city.
	*
	* @param currency the currency of this rate city
	*/
	@Override
	public void setCurrency(java.lang.String currency) {
		_rateCity.setCurrency(currency);
	}

	/**
	* Returns the parent ID of this rate city.
	*
	* @return the parent ID of this rate city
	*/
	@Override
	public long getParentId() {
		return _rateCity.getParentId();
	}

	/**
	* Sets the parent ID of this rate city.
	*
	* @param parentId the parent ID of this rate city
	*/
	@Override
	public void setParentId(long parentId) {
		_rateCity.setParentId(parentId);
	}

	@Override
	public boolean isNew() {
		return _rateCity.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_rateCity.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _rateCity.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_rateCity.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _rateCity.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _rateCity.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_rateCity.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _rateCity.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_rateCity.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_rateCity.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_rateCity.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new RateCityWrapper((RateCity)_rateCity.clone());
	}

	@Override
	public int compareTo(com.business.trip.model.RateCity rateCity) {
		return _rateCity.compareTo(rateCity);
	}

	@Override
	public int hashCode() {
		return _rateCity.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.business.trip.model.RateCity> toCacheModel() {
		return _rateCity.toCacheModel();
	}

	@Override
	public com.business.trip.model.RateCity toEscapedModel() {
		return new RateCityWrapper(_rateCity.toEscapedModel());
	}

	@Override
	public com.business.trip.model.RateCity toUnescapedModel() {
		return new RateCityWrapper(_rateCity.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _rateCity.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _rateCity.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_rateCity.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RateCityWrapper)) {
			return false;
		}

		RateCityWrapper rateCityWrapper = (RateCityWrapper)obj;

		if (Validator.equals(_rateCity, rateCityWrapper._rateCity)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public RateCity getWrappedRateCity() {
		return _rateCity;
	}

	@Override
	public RateCity getWrappedModel() {
		return _rateCity;
	}

	@Override
	public void resetOriginalValues() {
		_rateCity.resetOriginalValues();
	}

	private RateCity _rateCity;
}