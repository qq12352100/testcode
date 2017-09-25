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
 * This class is a wrapper for {@link BtEntertainmentDetail}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BtEntertainmentDetail
 * @generated
 */
public class BtEntertainmentDetailWrapper implements BtEntertainmentDetail,
	ModelWrapper<BtEntertainmentDetail> {
	public BtEntertainmentDetailWrapper(
		BtEntertainmentDetail btEntertainmentDetail) {
		_btEntertainmentDetail = btEntertainmentDetail;
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

	/**
	* Returns the primary key of this bt entertainment detail.
	*
	* @return the primary key of this bt entertainment detail
	*/
	@Override
	public long getPrimaryKey() {
		return _btEntertainmentDetail.getPrimaryKey();
	}

	/**
	* Sets the primary key of this bt entertainment detail.
	*
	* @param primaryKey the primary key of this bt entertainment detail
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_btEntertainmentDetail.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the bt entertainment detail ID of this bt entertainment detail.
	*
	* @return the bt entertainment detail ID of this bt entertainment detail
	*/
	@Override
	public long getBtEntertainmentDetailId() {
		return _btEntertainmentDetail.getBtEntertainmentDetailId();
	}

	/**
	* Sets the bt entertainment detail ID of this bt entertainment detail.
	*
	* @param btEntertainmentDetailId the bt entertainment detail ID of this bt entertainment detail
	*/
	@Override
	public void setBtEntertainmentDetailId(long btEntertainmentDetailId) {
		_btEntertainmentDetail.setBtEntertainmentDetailId(btEntertainmentDetailId);
	}

	/**
	* Returns the bt cost list ID of this bt entertainment detail.
	*
	* @return the bt cost list ID of this bt entertainment detail
	*/
	@Override
	public long getBtCostListId() {
		return _btEntertainmentDetail.getBtCostListId();
	}

	/**
	* Sets the bt cost list ID of this bt entertainment detail.
	*
	* @param btCostListId the bt cost list ID of this bt entertainment detail
	*/
	@Override
	public void setBtCostListId(long btCostListId) {
		_btEntertainmentDetail.setBtCostListId(btCostListId);
	}

	/**
	* Returns the business trip pk ID of this bt entertainment detail.
	*
	* @return the business trip pk ID of this bt entertainment detail
	*/
	@Override
	public long getBusinessTripPkId() {
		return _btEntertainmentDetail.getBusinessTripPkId();
	}

	/**
	* Sets the business trip pk ID of this bt entertainment detail.
	*
	* @param businessTripPkId the business trip pk ID of this bt entertainment detail
	*/
	@Override
	public void setBusinessTripPkId(long businessTripPkId) {
		_btEntertainmentDetail.setBusinessTripPkId(businessTripPkId);
	}

	/**
	* Returns the full name of this bt entertainment detail.
	*
	* @return the full name of this bt entertainment detail
	*/
	@Override
	public java.lang.String getFullName() {
		return _btEntertainmentDetail.getFullName();
	}

	/**
	* Sets the full name of this bt entertainment detail.
	*
	* @param fullName the full name of this bt entertainment detail
	*/
	@Override
	public void setFullName(java.lang.String fullName) {
		_btEntertainmentDetail.setFullName(fullName);
	}

	/**
	* Returns the position title of this bt entertainment detail.
	*
	* @return the position title of this bt entertainment detail
	*/
	@Override
	public java.lang.String getPositionTitle() {
		return _btEntertainmentDetail.getPositionTitle();
	}

	/**
	* Sets the position title of this bt entertainment detail.
	*
	* @param positionTitle the position title of this bt entertainment detail
	*/
	@Override
	public void setPositionTitle(java.lang.String positionTitle) {
		_btEntertainmentDetail.setPositionTitle(positionTitle);
	}

	/**
	* Returns the company of this bt entertainment detail.
	*
	* @return the company of this bt entertainment detail
	*/
	@Override
	public java.lang.String getCompany() {
		return _btEntertainmentDetail.getCompany();
	}

	/**
	* Sets the company of this bt entertainment detail.
	*
	* @param company the company of this bt entertainment detail
	*/
	@Override
	public void setCompany(java.lang.String company) {
		_btEntertainmentDetail.setCompany(company);
	}

	@Override
	public boolean isNew() {
		return _btEntertainmentDetail.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_btEntertainmentDetail.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _btEntertainmentDetail.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_btEntertainmentDetail.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _btEntertainmentDetail.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _btEntertainmentDetail.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_btEntertainmentDetail.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _btEntertainmentDetail.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_btEntertainmentDetail.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_btEntertainmentDetail.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_btEntertainmentDetail.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BtEntertainmentDetailWrapper((BtEntertainmentDetail)_btEntertainmentDetail.clone());
	}

	@Override
	public int compareTo(
		com.business.trip.model.BtEntertainmentDetail btEntertainmentDetail) {
		return _btEntertainmentDetail.compareTo(btEntertainmentDetail);
	}

	@Override
	public int hashCode() {
		return _btEntertainmentDetail.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.business.trip.model.BtEntertainmentDetail> toCacheModel() {
		return _btEntertainmentDetail.toCacheModel();
	}

	@Override
	public com.business.trip.model.BtEntertainmentDetail toEscapedModel() {
		return new BtEntertainmentDetailWrapper(_btEntertainmentDetail.toEscapedModel());
	}

	@Override
	public com.business.trip.model.BtEntertainmentDetail toUnescapedModel() {
		return new BtEntertainmentDetailWrapper(_btEntertainmentDetail.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _btEntertainmentDetail.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _btEntertainmentDetail.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_btEntertainmentDetail.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BtEntertainmentDetailWrapper)) {
			return false;
		}

		BtEntertainmentDetailWrapper btEntertainmentDetailWrapper = (BtEntertainmentDetailWrapper)obj;

		if (Validator.equals(_btEntertainmentDetail,
					btEntertainmentDetailWrapper._btEntertainmentDetail)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public BtEntertainmentDetail getWrappedBtEntertainmentDetail() {
		return _btEntertainmentDetail;
	}

	@Override
	public BtEntertainmentDetail getWrappedModel() {
		return _btEntertainmentDetail;
	}

	@Override
	public void resetOriginalValues() {
		_btEntertainmentDetail.resetOriginalValues();
	}

	private BtEntertainmentDetail _btEntertainmentDetail;
}