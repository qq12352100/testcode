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
 * This class is a wrapper for {@link BtReimbursementSAPInfo}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BtReimbursementSAPInfo
 * @generated
 */
public class BtReimbursementSAPInfoWrapper implements BtReimbursementSAPInfo,
	ModelWrapper<BtReimbursementSAPInfo> {
	public BtReimbursementSAPInfoWrapper(
		BtReimbursementSAPInfo btReimbursementSAPInfo) {
		_btReimbursementSAPInfo = btReimbursementSAPInfo;
	}

	@Override
	public Class<?> getModelClass() {
		return BtReimbursementSAPInfo.class;
	}

	@Override
	public String getModelClassName() {
		return BtReimbursementSAPInfo.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("btReimbursementSAPInfoId", getBtReimbursementSAPInfoId());
		attributes.put("businessTripPkId", getBusinessTripPkId());
		attributes.put("ticketNo", getTicketNo());
		attributes.put("currency", getCurrency());
		attributes.put("step", getStep());
		attributes.put("messageType", getMessageType());
		attributes.put("message", getMessage());
		attributes.put("certificateNo", getCertificateNo());
		attributes.put("company", getCompany());
		attributes.put("year", getYear());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long btReimbursementSAPInfoId = (Long)attributes.get(
				"btReimbursementSAPInfoId");

		if (btReimbursementSAPInfoId != null) {
			setBtReimbursementSAPInfoId(btReimbursementSAPInfoId);
		}

		Long businessTripPkId = (Long)attributes.get("businessTripPkId");

		if (businessTripPkId != null) {
			setBusinessTripPkId(businessTripPkId);
		}

		String ticketNo = (String)attributes.get("ticketNo");

		if (ticketNo != null) {
			setTicketNo(ticketNo);
		}

		String currency = (String)attributes.get("currency");

		if (currency != null) {
			setCurrency(currency);
		}

		Integer step = (Integer)attributes.get("step");

		if (step != null) {
			setStep(step);
		}

		String messageType = (String)attributes.get("messageType");

		if (messageType != null) {
			setMessageType(messageType);
		}

		String message = (String)attributes.get("message");

		if (message != null) {
			setMessage(message);
		}

		String certificateNo = (String)attributes.get("certificateNo");

		if (certificateNo != null) {
			setCertificateNo(certificateNo);
		}

		String company = (String)attributes.get("company");

		if (company != null) {
			setCompany(company);
		}

		String year = (String)attributes.get("year");

		if (year != null) {
			setYear(year);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	/**
	* Returns the primary key of this bt reimbursement s a p info.
	*
	* @return the primary key of this bt reimbursement s a p info
	*/
	@Override
	public long getPrimaryKey() {
		return _btReimbursementSAPInfo.getPrimaryKey();
	}

	/**
	* Sets the primary key of this bt reimbursement s a p info.
	*
	* @param primaryKey the primary key of this bt reimbursement s a p info
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_btReimbursementSAPInfo.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the bt reimbursement s a p info ID of this bt reimbursement s a p info.
	*
	* @return the bt reimbursement s a p info ID of this bt reimbursement s a p info
	*/
	@Override
	public long getBtReimbursementSAPInfoId() {
		return _btReimbursementSAPInfo.getBtReimbursementSAPInfoId();
	}

	/**
	* Sets the bt reimbursement s a p info ID of this bt reimbursement s a p info.
	*
	* @param btReimbursementSAPInfoId the bt reimbursement s a p info ID of this bt reimbursement s a p info
	*/
	@Override
	public void setBtReimbursementSAPInfoId(long btReimbursementSAPInfoId) {
		_btReimbursementSAPInfo.setBtReimbursementSAPInfoId(btReimbursementSAPInfoId);
	}

	/**
	* Returns the business trip pk ID of this bt reimbursement s a p info.
	*
	* @return the business trip pk ID of this bt reimbursement s a p info
	*/
	@Override
	public long getBusinessTripPkId() {
		return _btReimbursementSAPInfo.getBusinessTripPkId();
	}

	/**
	* Sets the business trip pk ID of this bt reimbursement s a p info.
	*
	* @param businessTripPkId the business trip pk ID of this bt reimbursement s a p info
	*/
	@Override
	public void setBusinessTripPkId(long businessTripPkId) {
		_btReimbursementSAPInfo.setBusinessTripPkId(businessTripPkId);
	}

	/**
	* Returns the ticket no of this bt reimbursement s a p info.
	*
	* @return the ticket no of this bt reimbursement s a p info
	*/
	@Override
	public java.lang.String getTicketNo() {
		return _btReimbursementSAPInfo.getTicketNo();
	}

	/**
	* Sets the ticket no of this bt reimbursement s a p info.
	*
	* @param ticketNo the ticket no of this bt reimbursement s a p info
	*/
	@Override
	public void setTicketNo(java.lang.String ticketNo) {
		_btReimbursementSAPInfo.setTicketNo(ticketNo);
	}

	/**
	* Returns the currency of this bt reimbursement s a p info.
	*
	* @return the currency of this bt reimbursement s a p info
	*/
	@Override
	public java.lang.String getCurrency() {
		return _btReimbursementSAPInfo.getCurrency();
	}

	/**
	* Sets the currency of this bt reimbursement s a p info.
	*
	* @param currency the currency of this bt reimbursement s a p info
	*/
	@Override
	public void setCurrency(java.lang.String currency) {
		_btReimbursementSAPInfo.setCurrency(currency);
	}

	/**
	* Returns the step of this bt reimbursement s a p info.
	*
	* @return the step of this bt reimbursement s a p info
	*/
	@Override
	public int getStep() {
		return _btReimbursementSAPInfo.getStep();
	}

	/**
	* Sets the step of this bt reimbursement s a p info.
	*
	* @param step the step of this bt reimbursement s a p info
	*/
	@Override
	public void setStep(int step) {
		_btReimbursementSAPInfo.setStep(step);
	}

	/**
	* Returns the message type of this bt reimbursement s a p info.
	*
	* @return the message type of this bt reimbursement s a p info
	*/
	@Override
	public java.lang.String getMessageType() {
		return _btReimbursementSAPInfo.getMessageType();
	}

	/**
	* Sets the message type of this bt reimbursement s a p info.
	*
	* @param messageType the message type of this bt reimbursement s a p info
	*/
	@Override
	public void setMessageType(java.lang.String messageType) {
		_btReimbursementSAPInfo.setMessageType(messageType);
	}

	/**
	* Returns the message of this bt reimbursement s a p info.
	*
	* @return the message of this bt reimbursement s a p info
	*/
	@Override
	public java.lang.String getMessage() {
		return _btReimbursementSAPInfo.getMessage();
	}

	/**
	* Sets the message of this bt reimbursement s a p info.
	*
	* @param message the message of this bt reimbursement s a p info
	*/
	@Override
	public void setMessage(java.lang.String message) {
		_btReimbursementSAPInfo.setMessage(message);
	}

	/**
	* Returns the certificate no of this bt reimbursement s a p info.
	*
	* @return the certificate no of this bt reimbursement s a p info
	*/
	@Override
	public java.lang.String getCertificateNo() {
		return _btReimbursementSAPInfo.getCertificateNo();
	}

	/**
	* Sets the certificate no of this bt reimbursement s a p info.
	*
	* @param certificateNo the certificate no of this bt reimbursement s a p info
	*/
	@Override
	public void setCertificateNo(java.lang.String certificateNo) {
		_btReimbursementSAPInfo.setCertificateNo(certificateNo);
	}

	/**
	* Returns the company of this bt reimbursement s a p info.
	*
	* @return the company of this bt reimbursement s a p info
	*/
	@Override
	public java.lang.String getCompany() {
		return _btReimbursementSAPInfo.getCompany();
	}

	/**
	* Sets the company of this bt reimbursement s a p info.
	*
	* @param company the company of this bt reimbursement s a p info
	*/
	@Override
	public void setCompany(java.lang.String company) {
		_btReimbursementSAPInfo.setCompany(company);
	}

	/**
	* Returns the year of this bt reimbursement s a p info.
	*
	* @return the year of this bt reimbursement s a p info
	*/
	@Override
	public java.lang.String getYear() {
		return _btReimbursementSAPInfo.getYear();
	}

	/**
	* Sets the year of this bt reimbursement s a p info.
	*
	* @param year the year of this bt reimbursement s a p info
	*/
	@Override
	public void setYear(java.lang.String year) {
		_btReimbursementSAPInfo.setYear(year);
	}

	/**
	* Returns the create date of this bt reimbursement s a p info.
	*
	* @return the create date of this bt reimbursement s a p info
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _btReimbursementSAPInfo.getCreateDate();
	}

	/**
	* Sets the create date of this bt reimbursement s a p info.
	*
	* @param createDate the create date of this bt reimbursement s a p info
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_btReimbursementSAPInfo.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this bt reimbursement s a p info.
	*
	* @return the modified date of this bt reimbursement s a p info
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _btReimbursementSAPInfo.getModifiedDate();
	}

	/**
	* Sets the modified date of this bt reimbursement s a p info.
	*
	* @param modifiedDate the modified date of this bt reimbursement s a p info
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_btReimbursementSAPInfo.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _btReimbursementSAPInfo.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_btReimbursementSAPInfo.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _btReimbursementSAPInfo.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_btReimbursementSAPInfo.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _btReimbursementSAPInfo.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _btReimbursementSAPInfo.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_btReimbursementSAPInfo.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _btReimbursementSAPInfo.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_btReimbursementSAPInfo.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_btReimbursementSAPInfo.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_btReimbursementSAPInfo.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BtReimbursementSAPInfoWrapper((BtReimbursementSAPInfo)_btReimbursementSAPInfo.clone());
	}

	@Override
	public int compareTo(
		com.business.trip.model.BtReimbursementSAPInfo btReimbursementSAPInfo) {
		return _btReimbursementSAPInfo.compareTo(btReimbursementSAPInfo);
	}

	@Override
	public int hashCode() {
		return _btReimbursementSAPInfo.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.business.trip.model.BtReimbursementSAPInfo> toCacheModel() {
		return _btReimbursementSAPInfo.toCacheModel();
	}

	@Override
	public com.business.trip.model.BtReimbursementSAPInfo toEscapedModel() {
		return new BtReimbursementSAPInfoWrapper(_btReimbursementSAPInfo.toEscapedModel());
	}

	@Override
	public com.business.trip.model.BtReimbursementSAPInfo toUnescapedModel() {
		return new BtReimbursementSAPInfoWrapper(_btReimbursementSAPInfo.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _btReimbursementSAPInfo.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _btReimbursementSAPInfo.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_btReimbursementSAPInfo.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BtReimbursementSAPInfoWrapper)) {
			return false;
		}

		BtReimbursementSAPInfoWrapper btReimbursementSAPInfoWrapper = (BtReimbursementSAPInfoWrapper)obj;

		if (Validator.equals(_btReimbursementSAPInfo,
					btReimbursementSAPInfoWrapper._btReimbursementSAPInfo)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public BtReimbursementSAPInfo getWrappedBtReimbursementSAPInfo() {
		return _btReimbursementSAPInfo;
	}

	@Override
	public BtReimbursementSAPInfo getWrappedModel() {
		return _btReimbursementSAPInfo;
	}

	@Override
	public void resetOriginalValues() {
		_btReimbursementSAPInfo.resetOriginalValues();
	}

	private BtReimbursementSAPInfo _btReimbursementSAPInfo;
}