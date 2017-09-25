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

package com.e.leave.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ELeaveInfo}.
 * </p>
 *
 * @author EZEYIFE
 * @see ELeaveInfo
 * @generated
 */
public class ELeaveInfoWrapper implements ELeaveInfo, ModelWrapper<ELeaveInfo> {
	public ELeaveInfoWrapper(ELeaveInfo eLeaveInfo) {
		_eLeaveInfo = eLeaveInfo;
	}

	@Override
	public Class<?> getModelClass() {
		return ELeaveInfo.class;
	}

	@Override
	public String getModelClassName() {
		return ELeaveInfo.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("eLeaveInfoId", getELeaveInfoId());
		attributes.put("eLeaveId", getELeaveId());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("startTime", getStartTime());
		attributes.put("endTime", getEndTime());
		attributes.put("typeOfLeave", getTypeOfLeave());
		attributes.put("typeOfLeaveId", getTypeOfLeaveId());
		attributes.put("absenceDays", getAbsenceDays());
		attributes.put("remark", getRemark());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long eLeaveInfoId = (Long)attributes.get("eLeaveInfoId");

		if (eLeaveInfoId != null) {
			setELeaveInfoId(eLeaveInfoId);
		}

		Long eLeaveId = (Long)attributes.get("eLeaveId");

		if (eLeaveId != null) {
			setELeaveId(eLeaveId);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		String startTime = (String)attributes.get("startTime");

		if (startTime != null) {
			setStartTime(startTime);
		}

		String endTime = (String)attributes.get("endTime");

		if (endTime != null) {
			setEndTime(endTime);
		}

		String typeOfLeave = (String)attributes.get("typeOfLeave");

		if (typeOfLeave != null) {
			setTypeOfLeave(typeOfLeave);
		}

		String typeOfLeaveId = (String)attributes.get("typeOfLeaveId");

		if (typeOfLeaveId != null) {
			setTypeOfLeaveId(typeOfLeaveId);
		}

		String absenceDays = (String)attributes.get("absenceDays");

		if (absenceDays != null) {
			setAbsenceDays(absenceDays);
		}

		String remark = (String)attributes.get("remark");

		if (remark != null) {
			setRemark(remark);
		}
	}

	/**
	* Returns the primary key of this e leave info.
	*
	* @return the primary key of this e leave info
	*/
	@Override
	public long getPrimaryKey() {
		return _eLeaveInfo.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e leave info.
	*
	* @param primaryKey the primary key of this e leave info
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_eLeaveInfo.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the e leave info ID of this e leave info.
	*
	* @return the e leave info ID of this e leave info
	*/
	@Override
	public long getELeaveInfoId() {
		return _eLeaveInfo.getELeaveInfoId();
	}

	/**
	* Sets the e leave info ID of this e leave info.
	*
	* @param eLeaveInfoId the e leave info ID of this e leave info
	*/
	@Override
	public void setELeaveInfoId(long eLeaveInfoId) {
		_eLeaveInfo.setELeaveInfoId(eLeaveInfoId);
	}

	/**
	* Returns the e leave ID of this e leave info.
	*
	* @return the e leave ID of this e leave info
	*/
	@Override
	public long getELeaveId() {
		return _eLeaveInfo.getELeaveId();
	}

	/**
	* Sets the e leave ID of this e leave info.
	*
	* @param eLeaveId the e leave ID of this e leave info
	*/
	@Override
	public void setELeaveId(long eLeaveId) {
		_eLeaveInfo.setELeaveId(eLeaveId);
	}

	/**
	* Returns the start date of this e leave info.
	*
	* @return the start date of this e leave info
	*/
	@Override
	public java.util.Date getStartDate() {
		return _eLeaveInfo.getStartDate();
	}

	/**
	* Sets the start date of this e leave info.
	*
	* @param startDate the start date of this e leave info
	*/
	@Override
	public void setStartDate(java.util.Date startDate) {
		_eLeaveInfo.setStartDate(startDate);
	}

	/**
	* Returns the end date of this e leave info.
	*
	* @return the end date of this e leave info
	*/
	@Override
	public java.util.Date getEndDate() {
		return _eLeaveInfo.getEndDate();
	}

	/**
	* Sets the end date of this e leave info.
	*
	* @param endDate the end date of this e leave info
	*/
	@Override
	public void setEndDate(java.util.Date endDate) {
		_eLeaveInfo.setEndDate(endDate);
	}

	/**
	* Returns the start time of this e leave info.
	*
	* @return the start time of this e leave info
	*/
	@Override
	public java.lang.String getStartTime() {
		return _eLeaveInfo.getStartTime();
	}

	/**
	* Sets the start time of this e leave info.
	*
	* @param startTime the start time of this e leave info
	*/
	@Override
	public void setStartTime(java.lang.String startTime) {
		_eLeaveInfo.setStartTime(startTime);
	}

	/**
	* Returns the end time of this e leave info.
	*
	* @return the end time of this e leave info
	*/
	@Override
	public java.lang.String getEndTime() {
		return _eLeaveInfo.getEndTime();
	}

	/**
	* Sets the end time of this e leave info.
	*
	* @param endTime the end time of this e leave info
	*/
	@Override
	public void setEndTime(java.lang.String endTime) {
		_eLeaveInfo.setEndTime(endTime);
	}

	/**
	* Returns the type of leave of this e leave info.
	*
	* @return the type of leave of this e leave info
	*/
	@Override
	public java.lang.String getTypeOfLeave() {
		return _eLeaveInfo.getTypeOfLeave();
	}

	/**
	* Sets the type of leave of this e leave info.
	*
	* @param typeOfLeave the type of leave of this e leave info
	*/
	@Override
	public void setTypeOfLeave(java.lang.String typeOfLeave) {
		_eLeaveInfo.setTypeOfLeave(typeOfLeave);
	}

	/**
	* Returns the type of leave ID of this e leave info.
	*
	* @return the type of leave ID of this e leave info
	*/
	@Override
	public java.lang.String getTypeOfLeaveId() {
		return _eLeaveInfo.getTypeOfLeaveId();
	}

	/**
	* Sets the type of leave ID of this e leave info.
	*
	* @param typeOfLeaveId the type of leave ID of this e leave info
	*/
	@Override
	public void setTypeOfLeaveId(java.lang.String typeOfLeaveId) {
		_eLeaveInfo.setTypeOfLeaveId(typeOfLeaveId);
	}

	/**
	* Returns the absence days of this e leave info.
	*
	* @return the absence days of this e leave info
	*/
	@Override
	public java.lang.String getAbsenceDays() {
		return _eLeaveInfo.getAbsenceDays();
	}

	/**
	* Sets the absence days of this e leave info.
	*
	* @param absenceDays the absence days of this e leave info
	*/
	@Override
	public void setAbsenceDays(java.lang.String absenceDays) {
		_eLeaveInfo.setAbsenceDays(absenceDays);
	}

	/**
	* Returns the remark of this e leave info.
	*
	* @return the remark of this e leave info
	*/
	@Override
	public java.lang.String getRemark() {
		return _eLeaveInfo.getRemark();
	}

	/**
	* Sets the remark of this e leave info.
	*
	* @param remark the remark of this e leave info
	*/
	@Override
	public void setRemark(java.lang.String remark) {
		_eLeaveInfo.setRemark(remark);
	}

	@Override
	public boolean isNew() {
		return _eLeaveInfo.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_eLeaveInfo.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _eLeaveInfo.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_eLeaveInfo.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _eLeaveInfo.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _eLeaveInfo.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_eLeaveInfo.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _eLeaveInfo.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_eLeaveInfo.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_eLeaveInfo.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_eLeaveInfo.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ELeaveInfoWrapper((ELeaveInfo)_eLeaveInfo.clone());
	}

	@Override
	public int compareTo(com.e.leave.model.ELeaveInfo eLeaveInfo) {
		return _eLeaveInfo.compareTo(eLeaveInfo);
	}

	@Override
	public int hashCode() {
		return _eLeaveInfo.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.e.leave.model.ELeaveInfo> toCacheModel() {
		return _eLeaveInfo.toCacheModel();
	}

	@Override
	public com.e.leave.model.ELeaveInfo toEscapedModel() {
		return new ELeaveInfoWrapper(_eLeaveInfo.toEscapedModel());
	}

	@Override
	public com.e.leave.model.ELeaveInfo toUnescapedModel() {
		return new ELeaveInfoWrapper(_eLeaveInfo.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _eLeaveInfo.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _eLeaveInfo.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_eLeaveInfo.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ELeaveInfoWrapper)) {
			return false;
		}

		ELeaveInfoWrapper eLeaveInfoWrapper = (ELeaveInfoWrapper)obj;

		if (Validator.equals(_eLeaveInfo, eLeaveInfoWrapper._eLeaveInfo)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ELeaveInfo getWrappedELeaveInfo() {
		return _eLeaveInfo;
	}

	@Override
	public ELeaveInfo getWrappedModel() {
		return _eLeaveInfo;
	}

	@Override
	public void resetOriginalValues() {
		_eLeaveInfo.resetOriginalValues();
	}

	private ELeaveInfo _eLeaveInfo;
}