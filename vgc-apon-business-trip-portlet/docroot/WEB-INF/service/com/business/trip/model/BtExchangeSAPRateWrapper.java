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
 * This class is a wrapper for {@link BtExchangeSAPRate}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BtExchangeSAPRate
 * @generated
 */
public class BtExchangeSAPRateWrapper implements BtExchangeSAPRate,
	ModelWrapper<BtExchangeSAPRate> {
	public BtExchangeSAPRateWrapper(BtExchangeSAPRate btExchangeSAPRate) {
		_btExchangeSAPRate = btExchangeSAPRate;
	}

	@Override
	public Class<?> getModelClass() {
		return BtExchangeSAPRate.class;
	}

	@Override
	public String getModelClassName() {
		return BtExchangeSAPRate.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("btExchangeSAPRateId", getBtExchangeSAPRateId());
		attributes.put("fromCurrency", getFromCurrency());
		attributes.put("toCurrency", getToCurrency());
		attributes.put("currencyRate", getCurrencyRate());
		attributes.put("rateType", getRateType());
		attributes.put("sapDate", getSapDate());
		attributes.put("importDate", getImportDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long btExchangeSAPRateId = (Long)attributes.get("btExchangeSAPRateId");

		if (btExchangeSAPRateId != null) {
			setBtExchangeSAPRateId(btExchangeSAPRateId);
		}

		String fromCurrency = (String)attributes.get("fromCurrency");

		if (fromCurrency != null) {
			setFromCurrency(fromCurrency);
		}

		String toCurrency = (String)attributes.get("toCurrency");

		if (toCurrency != null) {
			setToCurrency(toCurrency);
		}

		Double currencyRate = (Double)attributes.get("currencyRate");

		if (currencyRate != null) {
			setCurrencyRate(currencyRate);
		}

		String rateType = (String)attributes.get("rateType");

		if (rateType != null) {
			setRateType(rateType);
		}

		Date sapDate = (Date)attributes.get("sapDate");

		if (sapDate != null) {
			setSapDate(sapDate);
		}

		Date importDate = (Date)attributes.get("importDate");

		if (importDate != null) {
			setImportDate(importDate);
		}
	}

	/**
	* Returns the primary key of this bt exchange s a p rate.
	*
	* @return the primary key of this bt exchange s a p rate
	*/
	@Override
	public long getPrimaryKey() {
		return _btExchangeSAPRate.getPrimaryKey();
	}

	/**
	* Sets the primary key of this bt exchange s a p rate.
	*
	* @param primaryKey the primary key of this bt exchange s a p rate
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_btExchangeSAPRate.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the bt exchange s a p rate ID of this bt exchange s a p rate.
	*
	* @return the bt exchange s a p rate ID of this bt exchange s a p rate
	*/
	@Override
	public long getBtExchangeSAPRateId() {
		return _btExchangeSAPRate.getBtExchangeSAPRateId();
	}

	/**
	* Sets the bt exchange s a p rate ID of this bt exchange s a p rate.
	*
	* @param btExchangeSAPRateId the bt exchange s a p rate ID of this bt exchange s a p rate
	*/
	@Override
	public void setBtExchangeSAPRateId(long btExchangeSAPRateId) {
		_btExchangeSAPRate.setBtExchangeSAPRateId(btExchangeSAPRateId);
	}

	/**
	* Returns the from currency of this bt exchange s a p rate.
	*
	* @return the from currency of this bt exchange s a p rate
	*/
	@Override
	public java.lang.String getFromCurrency() {
		return _btExchangeSAPRate.getFromCurrency();
	}

	/**
	* Sets the from currency of this bt exchange s a p rate.
	*
	* @param fromCurrency the from currency of this bt exchange s a p rate
	*/
	@Override
	public void setFromCurrency(java.lang.String fromCurrency) {
		_btExchangeSAPRate.setFromCurrency(fromCurrency);
	}

	/**
	* Returns the to currency of this bt exchange s a p rate.
	*
	* @return the to currency of this bt exchange s a p rate
	*/
	@Override
	public java.lang.String getToCurrency() {
		return _btExchangeSAPRate.getToCurrency();
	}

	/**
	* Sets the to currency of this bt exchange s a p rate.
	*
	* @param toCurrency the to currency of this bt exchange s a p rate
	*/
	@Override
	public void setToCurrency(java.lang.String toCurrency) {
		_btExchangeSAPRate.setToCurrency(toCurrency);
	}

	/**
	* Returns the currency rate of this bt exchange s a p rate.
	*
	* @return the currency rate of this bt exchange s a p rate
	*/
	@Override
	public double getCurrencyRate() {
		return _btExchangeSAPRate.getCurrencyRate();
	}

	/**
	* Sets the currency rate of this bt exchange s a p rate.
	*
	* @param currencyRate the currency rate of this bt exchange s a p rate
	*/
	@Override
	public void setCurrencyRate(double currencyRate) {
		_btExchangeSAPRate.setCurrencyRate(currencyRate);
	}

	/**
	* Returns the rate type of this bt exchange s a p rate.
	*
	* @return the rate type of this bt exchange s a p rate
	*/
	@Override
	public java.lang.String getRateType() {
		return _btExchangeSAPRate.getRateType();
	}

	/**
	* Sets the rate type of this bt exchange s a p rate.
	*
	* @param rateType the rate type of this bt exchange s a p rate
	*/
	@Override
	public void setRateType(java.lang.String rateType) {
		_btExchangeSAPRate.setRateType(rateType);
	}

	/**
	* Returns the sap date of this bt exchange s a p rate.
	*
	* @return the sap date of this bt exchange s a p rate
	*/
	@Override
	public java.util.Date getSapDate() {
		return _btExchangeSAPRate.getSapDate();
	}

	/**
	* Sets the sap date of this bt exchange s a p rate.
	*
	* @param sapDate the sap date of this bt exchange s a p rate
	*/
	@Override
	public void setSapDate(java.util.Date sapDate) {
		_btExchangeSAPRate.setSapDate(sapDate);
	}

	/**
	* Returns the import date of this bt exchange s a p rate.
	*
	* @return the import date of this bt exchange s a p rate
	*/
	@Override
	public java.util.Date getImportDate() {
		return _btExchangeSAPRate.getImportDate();
	}

	/**
	* Sets the import date of this bt exchange s a p rate.
	*
	* @param importDate the import date of this bt exchange s a p rate
	*/
	@Override
	public void setImportDate(java.util.Date importDate) {
		_btExchangeSAPRate.setImportDate(importDate);
	}

	@Override
	public boolean isNew() {
		return _btExchangeSAPRate.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_btExchangeSAPRate.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _btExchangeSAPRate.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_btExchangeSAPRate.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _btExchangeSAPRate.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _btExchangeSAPRate.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_btExchangeSAPRate.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _btExchangeSAPRate.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_btExchangeSAPRate.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_btExchangeSAPRate.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_btExchangeSAPRate.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BtExchangeSAPRateWrapper((BtExchangeSAPRate)_btExchangeSAPRate.clone());
	}

	@Override
	public int compareTo(
		com.business.trip.model.BtExchangeSAPRate btExchangeSAPRate) {
		return _btExchangeSAPRate.compareTo(btExchangeSAPRate);
	}

	@Override
	public int hashCode() {
		return _btExchangeSAPRate.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.business.trip.model.BtExchangeSAPRate> toCacheModel() {
		return _btExchangeSAPRate.toCacheModel();
	}

	@Override
	public com.business.trip.model.BtExchangeSAPRate toEscapedModel() {
		return new BtExchangeSAPRateWrapper(_btExchangeSAPRate.toEscapedModel());
	}

	@Override
	public com.business.trip.model.BtExchangeSAPRate toUnescapedModel() {
		return new BtExchangeSAPRateWrapper(_btExchangeSAPRate.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _btExchangeSAPRate.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _btExchangeSAPRate.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_btExchangeSAPRate.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BtExchangeSAPRateWrapper)) {
			return false;
		}

		BtExchangeSAPRateWrapper btExchangeSAPRateWrapper = (BtExchangeSAPRateWrapper)obj;

		if (Validator.equals(_btExchangeSAPRate,
					btExchangeSAPRateWrapper._btExchangeSAPRate)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public BtExchangeSAPRate getWrappedBtExchangeSAPRate() {
		return _btExchangeSAPRate;
	}

	@Override
	public BtExchangeSAPRate getWrappedModel() {
		return _btExchangeSAPRate;
	}

	@Override
	public void resetOriginalValues() {
		_btExchangeSAPRate.resetOriginalValues();
	}

	private BtExchangeSAPRate _btExchangeSAPRate;
}