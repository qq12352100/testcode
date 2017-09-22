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

package com.seatoffice.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.seatoffice.service.ClpSerializer;
import com.seatoffice.service.SeatOfficeLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Alice.zou
 */
public class SeatOfficeClp extends BaseModelImpl<SeatOffice>
	implements SeatOffice {
	public SeatOfficeClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SeatOffice.class;
	}

	@Override
	public String getModelClassName() {
		return SeatOffice.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _seatId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSeatId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _seatId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("seatId", getSeatId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("companyId", getCompanyId());
		attributes.put("ticketNo", getTicketNo());
		attributes.put("staffName", getStaffName());
		attributes.put("staffCode", getStaffCode());
		attributes.put("companyName", getCompanyName());
		attributes.put("division", getDivision());
		attributes.put("department", getDepartment());
		attributes.put("costCenter", getCostCenter());
		attributes.put("officePhone", getOfficePhone());
		attributes.put("mobilePhone", getMobilePhone());
		attributes.put("officeSite", getOfficeSite());
		attributes.put("currentCategory", getCurrentCategory());
		attributes.put("currentSeatNo", getCurrentSeatNo());
		attributes.put("movingDate", getMovingDate());
		attributes.put("expectedSeatNo", getExpectedSeatNo());
		attributes.put("reasonForChange", getReasonForChange());
		attributes.put("officeKey", getOfficeKey());
		attributes.put("plant", getPlant());
		attributes.put("telephoneAndExtNo", getTelephoneAndExtNo());
		attributes.put("namePlate", getNamePlate());
		attributes.put("cabinet", getCabinet());
		attributes.put("isOnBehalfOf", getIsOnBehalfOf());
		attributes.put("nowCategory", getNowCategory());
		attributes.put("newSeatNo", getNewSeatNo());
		attributes.put("workspaceId", getWorkspaceId());
		attributes.put("seatStatus", getSeatStatus());
		attributes.put("sg", getSg());
		attributes.put("leadingMark", getLeadingMark());
		attributes.put("positionFlag", getPositionFlag());
		attributes.put("isApplicantAgent", getIsApplicantAgent());
		attributes.put("isApproverAgent", getIsApproverAgent());
		attributes.put("candidateName", getCandidateName());
		attributes.put("desiredStartingDate", getDesiredStartingDate());
		attributes.put("comments", getComments());
		attributes.put("contractType", getContractType());
		attributes.put("processType", getProcessType());
		attributes.put("subProcessType", getSubProcessType());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long seatId = (Long)attributes.get("seatId");

		if (seatId != null) {
			setSeatId(seatId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
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

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String ticketNo = (String)attributes.get("ticketNo");

		if (ticketNo != null) {
			setTicketNo(ticketNo);
		}

		String staffName = (String)attributes.get("staffName");

		if (staffName != null) {
			setStaffName(staffName);
		}

		Long staffCode = (Long)attributes.get("staffCode");

		if (staffCode != null) {
			setStaffCode(staffCode);
		}

		String companyName = (String)attributes.get("companyName");

		if (companyName != null) {
			setCompanyName(companyName);
		}

		String division = (String)attributes.get("division");

		if (division != null) {
			setDivision(division);
		}

		String department = (String)attributes.get("department");

		if (department != null) {
			setDepartment(department);
		}

		String costCenter = (String)attributes.get("costCenter");

		if (costCenter != null) {
			setCostCenter(costCenter);
		}

		String officePhone = (String)attributes.get("officePhone");

		if (officePhone != null) {
			setOfficePhone(officePhone);
		}

		String mobilePhone = (String)attributes.get("mobilePhone");

		if (mobilePhone != null) {
			setMobilePhone(mobilePhone);
		}

		String officeSite = (String)attributes.get("officeSite");

		if (officeSite != null) {
			setOfficeSite(officeSite);
		}

		Long currentCategory = (Long)attributes.get("currentCategory");

		if (currentCategory != null) {
			setCurrentCategory(currentCategory);
		}

		String currentSeatNo = (String)attributes.get("currentSeatNo");

		if (currentSeatNo != null) {
			setCurrentSeatNo(currentSeatNo);
		}

		Date movingDate = (Date)attributes.get("movingDate");

		if (movingDate != null) {
			setMovingDate(movingDate);
		}

		String expectedSeatNo = (String)attributes.get("expectedSeatNo");

		if (expectedSeatNo != null) {
			setExpectedSeatNo(expectedSeatNo);
		}

		String reasonForChange = (String)attributes.get("reasonForChange");

		if (reasonForChange != null) {
			setReasonForChange(reasonForChange);
		}

		Boolean officeKey = (Boolean)attributes.get("officeKey");

		if (officeKey != null) {
			setOfficeKey(officeKey);
		}

		Boolean plant = (Boolean)attributes.get("plant");

		if (plant != null) {
			setPlant(plant);
		}

		Boolean telephoneAndExtNo = (Boolean)attributes.get("telephoneAndExtNo");

		if (telephoneAndExtNo != null) {
			setTelephoneAndExtNo(telephoneAndExtNo);
		}

		Boolean namePlate = (Boolean)attributes.get("namePlate");

		if (namePlate != null) {
			setNamePlate(namePlate);
		}

		Boolean cabinet = (Boolean)attributes.get("cabinet");

		if (cabinet != null) {
			setCabinet(cabinet);
		}

		Boolean isOnBehalfOf = (Boolean)attributes.get("isOnBehalfOf");

		if (isOnBehalfOf != null) {
			setIsOnBehalfOf(isOnBehalfOf);
		}

		Long nowCategory = (Long)attributes.get("nowCategory");

		if (nowCategory != null) {
			setNowCategory(nowCategory);
		}

		String newSeatNo = (String)attributes.get("newSeatNo");

		if (newSeatNo != null) {
			setNewSeatNo(newSeatNo);
		}

		Long workspaceId = (Long)attributes.get("workspaceId");

		if (workspaceId != null) {
			setWorkspaceId(workspaceId);
		}

		String seatStatus = (String)attributes.get("seatStatus");

		if (seatStatus != null) {
			setSeatStatus(seatStatus);
		}

		String sg = (String)attributes.get("sg");

		if (sg != null) {
			setSg(sg);
		}

		String leadingMark = (String)attributes.get("leadingMark");

		if (leadingMark != null) {
			setLeadingMark(leadingMark);
		}

		String positionFlag = (String)attributes.get("positionFlag");

		if (positionFlag != null) {
			setPositionFlag(positionFlag);
		}

		Boolean isApplicantAgent = (Boolean)attributes.get("isApplicantAgent");

		if (isApplicantAgent != null) {
			setIsApplicantAgent(isApplicantAgent);
		}

		Boolean isApproverAgent = (Boolean)attributes.get("isApproverAgent");

		if (isApproverAgent != null) {
			setIsApproverAgent(isApproverAgent);
		}

		String candidateName = (String)attributes.get("candidateName");

		if (candidateName != null) {
			setCandidateName(candidateName);
		}

		Date desiredStartingDate = (Date)attributes.get("desiredStartingDate");

		if (desiredStartingDate != null) {
			setDesiredStartingDate(desiredStartingDate);
		}

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
		}

		String contractType = (String)attributes.get("contractType");

		if (contractType != null) {
			setContractType(contractType);
		}

		String processType = (String)attributes.get("processType");

		if (processType != null) {
			setProcessType(processType);
		}

		String subProcessType = (String)attributes.get("subProcessType");

		if (subProcessType != null) {
			setSubProcessType(subProcessType);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}
	}

	@Override
	public long getSeatId() {
		return _seatId;
	}

	@Override
	public void setSeatId(long seatId) {
		_seatId = seatId;

		if (_seatOfficeRemoteModel != null) {
			try {
				Class<?> clazz = _seatOfficeRemoteModel.getClass();

				Method method = clazz.getMethod("setSeatId", long.class);

				method.invoke(_seatOfficeRemoteModel, seatId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_seatOfficeRemoteModel != null) {
			try {
				Class<?> clazz = _seatOfficeRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_seatOfficeRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_seatOfficeRemoteModel != null) {
			try {
				Class<?> clazz = _seatOfficeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_seatOfficeRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_seatOfficeRemoteModel != null) {
			try {
				Class<?> clazz = _seatOfficeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_seatOfficeRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_seatOfficeRemoteModel != null) {
			try {
				Class<?> clazz = _seatOfficeRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_seatOfficeRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_seatOfficeRemoteModel != null) {
			try {
				Class<?> clazz = _seatOfficeRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_seatOfficeRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_seatOfficeRemoteModel != null) {
			try {
				Class<?> clazz = _seatOfficeRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_seatOfficeRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTicketNo() {
		return _ticketNo;
	}

	@Override
	public void setTicketNo(String ticketNo) {
		_ticketNo = ticketNo;

		if (_seatOfficeRemoteModel != null) {
			try {
				Class<?> clazz = _seatOfficeRemoteModel.getClass();

				Method method = clazz.getMethod("setTicketNo", String.class);

				method.invoke(_seatOfficeRemoteModel, ticketNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStaffName() {
		return _staffName;
	}

	@Override
	public void setStaffName(String staffName) {
		_staffName = staffName;

		if (_seatOfficeRemoteModel != null) {
			try {
				Class<?> clazz = _seatOfficeRemoteModel.getClass();

				Method method = clazz.getMethod("setStaffName", String.class);

				method.invoke(_seatOfficeRemoteModel, staffName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getStaffCode() {
		return _staffCode;
	}

	@Override
	public void setStaffCode(long staffCode) {
		_staffCode = staffCode;

		if (_seatOfficeRemoteModel != null) {
			try {
				Class<?> clazz = _seatOfficeRemoteModel.getClass();

				Method method = clazz.getMethod("setStaffCode", long.class);

				method.invoke(_seatOfficeRemoteModel, staffCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCompanyName() {
		return _companyName;
	}

	@Override
	public void setCompanyName(String companyName) {
		_companyName = companyName;

		if (_seatOfficeRemoteModel != null) {
			try {
				Class<?> clazz = _seatOfficeRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyName", String.class);

				method.invoke(_seatOfficeRemoteModel, companyName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDivision() {
		return _division;
	}

	@Override
	public void setDivision(String division) {
		_division = division;

		if (_seatOfficeRemoteModel != null) {
			try {
				Class<?> clazz = _seatOfficeRemoteModel.getClass();

				Method method = clazz.getMethod("setDivision", String.class);

				method.invoke(_seatOfficeRemoteModel, division);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDepartment() {
		return _department;
	}

	@Override
	public void setDepartment(String department) {
		_department = department;

		if (_seatOfficeRemoteModel != null) {
			try {
				Class<?> clazz = _seatOfficeRemoteModel.getClass();

				Method method = clazz.getMethod("setDepartment", String.class);

				method.invoke(_seatOfficeRemoteModel, department);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCostCenter() {
		return _costCenter;
	}

	@Override
	public void setCostCenter(String costCenter) {
		_costCenter = costCenter;

		if (_seatOfficeRemoteModel != null) {
			try {
				Class<?> clazz = _seatOfficeRemoteModel.getClass();

				Method method = clazz.getMethod("setCostCenter", String.class);

				method.invoke(_seatOfficeRemoteModel, costCenter);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOfficePhone() {
		return _officePhone;
	}

	@Override
	public void setOfficePhone(String officePhone) {
		_officePhone = officePhone;

		if (_seatOfficeRemoteModel != null) {
			try {
				Class<?> clazz = _seatOfficeRemoteModel.getClass();

				Method method = clazz.getMethod("setOfficePhone", String.class);

				method.invoke(_seatOfficeRemoteModel, officePhone);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMobilePhone() {
		return _mobilePhone;
	}

	@Override
	public void setMobilePhone(String mobilePhone) {
		_mobilePhone = mobilePhone;

		if (_seatOfficeRemoteModel != null) {
			try {
				Class<?> clazz = _seatOfficeRemoteModel.getClass();

				Method method = clazz.getMethod("setMobilePhone", String.class);

				method.invoke(_seatOfficeRemoteModel, mobilePhone);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOfficeSite() {
		return _officeSite;
	}

	@Override
	public void setOfficeSite(String officeSite) {
		_officeSite = officeSite;

		if (_seatOfficeRemoteModel != null) {
			try {
				Class<?> clazz = _seatOfficeRemoteModel.getClass();

				Method method = clazz.getMethod("setOfficeSite", String.class);

				method.invoke(_seatOfficeRemoteModel, officeSite);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCurrentCategory() {
		return _currentCategory;
	}

	@Override
	public void setCurrentCategory(long currentCategory) {
		_currentCategory = currentCategory;

		if (_seatOfficeRemoteModel != null) {
			try {
				Class<?> clazz = _seatOfficeRemoteModel.getClass();

				Method method = clazz.getMethod("setCurrentCategory", long.class);

				method.invoke(_seatOfficeRemoteModel, currentCategory);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCurrentSeatNo() {
		return _currentSeatNo;
	}

	@Override
	public void setCurrentSeatNo(String currentSeatNo) {
		_currentSeatNo = currentSeatNo;

		if (_seatOfficeRemoteModel != null) {
			try {
				Class<?> clazz = _seatOfficeRemoteModel.getClass();

				Method method = clazz.getMethod("setCurrentSeatNo", String.class);

				method.invoke(_seatOfficeRemoteModel, currentSeatNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getMovingDate() {
		return _movingDate;
	}

	@Override
	public void setMovingDate(Date movingDate) {
		_movingDate = movingDate;

		if (_seatOfficeRemoteModel != null) {
			try {
				Class<?> clazz = _seatOfficeRemoteModel.getClass();

				Method method = clazz.getMethod("setMovingDate", Date.class);

				method.invoke(_seatOfficeRemoteModel, movingDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExpectedSeatNo() {
		return _expectedSeatNo;
	}

	@Override
	public void setExpectedSeatNo(String expectedSeatNo) {
		_expectedSeatNo = expectedSeatNo;

		if (_seatOfficeRemoteModel != null) {
			try {
				Class<?> clazz = _seatOfficeRemoteModel.getClass();

				Method method = clazz.getMethod("setExpectedSeatNo",
						String.class);

				method.invoke(_seatOfficeRemoteModel, expectedSeatNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getReasonForChange() {
		return _reasonForChange;
	}

	@Override
	public void setReasonForChange(String reasonForChange) {
		_reasonForChange = reasonForChange;

		if (_seatOfficeRemoteModel != null) {
			try {
				Class<?> clazz = _seatOfficeRemoteModel.getClass();

				Method method = clazz.getMethod("setReasonForChange",
						String.class);

				method.invoke(_seatOfficeRemoteModel, reasonForChange);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getOfficeKey() {
		return _officeKey;
	}

	@Override
	public boolean isOfficeKey() {
		return _officeKey;
	}

	@Override
	public void setOfficeKey(boolean officeKey) {
		_officeKey = officeKey;

		if (_seatOfficeRemoteModel != null) {
			try {
				Class<?> clazz = _seatOfficeRemoteModel.getClass();

				Method method = clazz.getMethod("setOfficeKey", boolean.class);

				method.invoke(_seatOfficeRemoteModel, officeKey);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getPlant() {
		return _plant;
	}

	@Override
	public boolean isPlant() {
		return _plant;
	}

	@Override
	public void setPlant(boolean plant) {
		_plant = plant;

		if (_seatOfficeRemoteModel != null) {
			try {
				Class<?> clazz = _seatOfficeRemoteModel.getClass();

				Method method = clazz.getMethod("setPlant", boolean.class);

				method.invoke(_seatOfficeRemoteModel, plant);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getTelephoneAndExtNo() {
		return _telephoneAndExtNo;
	}

	@Override
	public boolean isTelephoneAndExtNo() {
		return _telephoneAndExtNo;
	}

	@Override
	public void setTelephoneAndExtNo(boolean telephoneAndExtNo) {
		_telephoneAndExtNo = telephoneAndExtNo;

		if (_seatOfficeRemoteModel != null) {
			try {
				Class<?> clazz = _seatOfficeRemoteModel.getClass();

				Method method = clazz.getMethod("setTelephoneAndExtNo",
						boolean.class);

				method.invoke(_seatOfficeRemoteModel, telephoneAndExtNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getNamePlate() {
		return _namePlate;
	}

	@Override
	public boolean isNamePlate() {
		return _namePlate;
	}

	@Override
	public void setNamePlate(boolean namePlate) {
		_namePlate = namePlate;

		if (_seatOfficeRemoteModel != null) {
			try {
				Class<?> clazz = _seatOfficeRemoteModel.getClass();

				Method method = clazz.getMethod("setNamePlate", boolean.class);

				method.invoke(_seatOfficeRemoteModel, namePlate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getCabinet() {
		return _cabinet;
	}

	@Override
	public boolean isCabinet() {
		return _cabinet;
	}

	@Override
	public void setCabinet(boolean cabinet) {
		_cabinet = cabinet;

		if (_seatOfficeRemoteModel != null) {
			try {
				Class<?> clazz = _seatOfficeRemoteModel.getClass();

				Method method = clazz.getMethod("setCabinet", boolean.class);

				method.invoke(_seatOfficeRemoteModel, cabinet);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsOnBehalfOf() {
		return _isOnBehalfOf;
	}

	@Override
	public boolean isIsOnBehalfOf() {
		return _isOnBehalfOf;
	}

	@Override
	public void setIsOnBehalfOf(boolean isOnBehalfOf) {
		_isOnBehalfOf = isOnBehalfOf;

		if (_seatOfficeRemoteModel != null) {
			try {
				Class<?> clazz = _seatOfficeRemoteModel.getClass();

				Method method = clazz.getMethod("setIsOnBehalfOf", boolean.class);

				method.invoke(_seatOfficeRemoteModel, isOnBehalfOf);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNowCategory() {
		return _nowCategory;
	}

	@Override
	public void setNowCategory(long nowCategory) {
		_nowCategory = nowCategory;

		if (_seatOfficeRemoteModel != null) {
			try {
				Class<?> clazz = _seatOfficeRemoteModel.getClass();

				Method method = clazz.getMethod("setNowCategory", long.class);

				method.invoke(_seatOfficeRemoteModel, nowCategory);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNewSeatNo() {
		return _newSeatNo;
	}

	@Override
	public void setNewSeatNo(String newSeatNo) {
		_newSeatNo = newSeatNo;

		if (_seatOfficeRemoteModel != null) {
			try {
				Class<?> clazz = _seatOfficeRemoteModel.getClass();

				Method method = clazz.getMethod("setNewSeatNo", String.class);

				method.invoke(_seatOfficeRemoteModel, newSeatNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getWorkspaceId() {
		return _workspaceId;
	}

	@Override
	public void setWorkspaceId(long workspaceId) {
		_workspaceId = workspaceId;

		if (_seatOfficeRemoteModel != null) {
			try {
				Class<?> clazz = _seatOfficeRemoteModel.getClass();

				Method method = clazz.getMethod("setWorkspaceId", long.class);

				method.invoke(_seatOfficeRemoteModel, workspaceId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSeatStatus() {
		return _seatStatus;
	}

	@Override
	public void setSeatStatus(String seatStatus) {
		_seatStatus = seatStatus;

		if (_seatOfficeRemoteModel != null) {
			try {
				Class<?> clazz = _seatOfficeRemoteModel.getClass();

				Method method = clazz.getMethod("setSeatStatus", String.class);

				method.invoke(_seatOfficeRemoteModel, seatStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSg() {
		return _sg;
	}

	@Override
	public void setSg(String sg) {
		_sg = sg;

		if (_seatOfficeRemoteModel != null) {
			try {
				Class<?> clazz = _seatOfficeRemoteModel.getClass();

				Method method = clazz.getMethod("setSg", String.class);

				method.invoke(_seatOfficeRemoteModel, sg);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLeadingMark() {
		return _leadingMark;
	}

	@Override
	public void setLeadingMark(String leadingMark) {
		_leadingMark = leadingMark;

		if (_seatOfficeRemoteModel != null) {
			try {
				Class<?> clazz = _seatOfficeRemoteModel.getClass();

				Method method = clazz.getMethod("setLeadingMark", String.class);

				method.invoke(_seatOfficeRemoteModel, leadingMark);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPositionFlag() {
		return _positionFlag;
	}

	@Override
	public void setPositionFlag(String positionFlag) {
		_positionFlag = positionFlag;

		if (_seatOfficeRemoteModel != null) {
			try {
				Class<?> clazz = _seatOfficeRemoteModel.getClass();

				Method method = clazz.getMethod("setPositionFlag", String.class);

				method.invoke(_seatOfficeRemoteModel, positionFlag);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsApplicantAgent() {
		return _isApplicantAgent;
	}

	@Override
	public boolean isIsApplicantAgent() {
		return _isApplicantAgent;
	}

	@Override
	public void setIsApplicantAgent(boolean isApplicantAgent) {
		_isApplicantAgent = isApplicantAgent;

		if (_seatOfficeRemoteModel != null) {
			try {
				Class<?> clazz = _seatOfficeRemoteModel.getClass();

				Method method = clazz.getMethod("setIsApplicantAgent",
						boolean.class);

				method.invoke(_seatOfficeRemoteModel, isApplicantAgent);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsApproverAgent() {
		return _isApproverAgent;
	}

	@Override
	public boolean isIsApproverAgent() {
		return _isApproverAgent;
	}

	@Override
	public void setIsApproverAgent(boolean isApproverAgent) {
		_isApproverAgent = isApproverAgent;

		if (_seatOfficeRemoteModel != null) {
			try {
				Class<?> clazz = _seatOfficeRemoteModel.getClass();

				Method method = clazz.getMethod("setIsApproverAgent",
						boolean.class);

				method.invoke(_seatOfficeRemoteModel, isApproverAgent);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCandidateName() {
		return _candidateName;
	}

	@Override
	public void setCandidateName(String candidateName) {
		_candidateName = candidateName;

		if (_seatOfficeRemoteModel != null) {
			try {
				Class<?> clazz = _seatOfficeRemoteModel.getClass();

				Method method = clazz.getMethod("setCandidateName", String.class);

				method.invoke(_seatOfficeRemoteModel, candidateName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDesiredStartingDate() {
		return _desiredStartingDate;
	}

	@Override
	public void setDesiredStartingDate(Date desiredStartingDate) {
		_desiredStartingDate = desiredStartingDate;

		if (_seatOfficeRemoteModel != null) {
			try {
				Class<?> clazz = _seatOfficeRemoteModel.getClass();

				Method method = clazz.getMethod("setDesiredStartingDate",
						Date.class);

				method.invoke(_seatOfficeRemoteModel, desiredStartingDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getComments() {
		return _comments;
	}

	@Override
	public void setComments(String comments) {
		_comments = comments;

		if (_seatOfficeRemoteModel != null) {
			try {
				Class<?> clazz = _seatOfficeRemoteModel.getClass();

				Method method = clazz.getMethod("setComments", String.class);

				method.invoke(_seatOfficeRemoteModel, comments);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContractType() {
		return _contractType;
	}

	@Override
	public void setContractType(String contractType) {
		_contractType = contractType;

		if (_seatOfficeRemoteModel != null) {
			try {
				Class<?> clazz = _seatOfficeRemoteModel.getClass();

				Method method = clazz.getMethod("setContractType", String.class);

				method.invoke(_seatOfficeRemoteModel, contractType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getProcessType() {
		return _processType;
	}

	@Override
	public void setProcessType(String processType) {
		_processType = processType;

		if (_seatOfficeRemoteModel != null) {
			try {
				Class<?> clazz = _seatOfficeRemoteModel.getClass();

				Method method = clazz.getMethod("setProcessType", String.class);

				method.invoke(_seatOfficeRemoteModel, processType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSubProcessType() {
		return _subProcessType;
	}

	@Override
	public void setSubProcessType(String subProcessType) {
		_subProcessType = subProcessType;

		if (_seatOfficeRemoteModel != null) {
			try {
				Class<?> clazz = _seatOfficeRemoteModel.getClass();

				Method method = clazz.getMethod("setSubProcessType",
						String.class);

				method.invoke(_seatOfficeRemoteModel, subProcessType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;

		if (_seatOfficeRemoteModel != null) {
			try {
				Class<?> clazz = _seatOfficeRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_seatOfficeRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getStatusByUserId() {
		return _statusByUserId;
	}

	@Override
	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;

		if (_seatOfficeRemoteModel != null) {
			try {
				Class<?> clazz = _seatOfficeRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusByUserId", long.class);

				method.invoke(_seatOfficeRemoteModel, statusByUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStatusByUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getStatusByUserId(), "uuid",
			_statusByUserUuid);
	}

	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		_statusByUserUuid = statusByUserUuid;
	}

	@Override
	public String getStatusByUserName() {
		return _statusByUserName;
	}

	@Override
	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;

		if (_seatOfficeRemoteModel != null) {
			try {
				Class<?> clazz = _seatOfficeRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusByUserName",
						String.class);

				method.invoke(_seatOfficeRemoteModel, statusByUserName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getStatusDate() {
		return _statusDate;
	}

	@Override
	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;

		if (_seatOfficeRemoteModel != null) {
			try {
				Class<?> clazz = _seatOfficeRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusDate", Date.class);

				method.invoke(_seatOfficeRemoteModel, statusDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #isApproved}
	 */
	@Override
	public boolean getApproved() {
		return isApproved();
	}

	@Override
	public boolean isApproved() {
		if (getStatus() == WorkflowConstants.STATUS_APPROVED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDenied() {
		if (getStatus() == WorkflowConstants.STATUS_DENIED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDraft() {
		if (getStatus() == WorkflowConstants.STATUS_DRAFT) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isExpired() {
		if (getStatus() == WorkflowConstants.STATUS_EXPIRED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isInactive() {
		if (getStatus() == WorkflowConstants.STATUS_INACTIVE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isIncomplete() {
		if (getStatus() == WorkflowConstants.STATUS_INCOMPLETE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isPending() {
		if (getStatus() == WorkflowConstants.STATUS_PENDING) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isScheduled() {
		if (getStatus() == WorkflowConstants.STATUS_SCHEDULED) {
			return true;
		}
		else {
			return false;
		}
	}

	public BaseModel<?> getSeatOfficeRemoteModel() {
		return _seatOfficeRemoteModel;
	}

	public void setSeatOfficeRemoteModel(BaseModel<?> seatOfficeRemoteModel) {
		_seatOfficeRemoteModel = seatOfficeRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _seatOfficeRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_seatOfficeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SeatOfficeLocalServiceUtil.addSeatOffice(this);
		}
		else {
			SeatOfficeLocalServiceUtil.updateSeatOffice(this);
		}
	}

	@Override
	public SeatOffice toEscapedModel() {
		return (SeatOffice)ProxyUtil.newProxyInstance(SeatOffice.class.getClassLoader(),
			new Class[] { SeatOffice.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SeatOfficeClp clone = new SeatOfficeClp();

		clone.setSeatId(getSeatId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setCompanyId(getCompanyId());
		clone.setTicketNo(getTicketNo());
		clone.setStaffName(getStaffName());
		clone.setStaffCode(getStaffCode());
		clone.setCompanyName(getCompanyName());
		clone.setDivision(getDivision());
		clone.setDepartment(getDepartment());
		clone.setCostCenter(getCostCenter());
		clone.setOfficePhone(getOfficePhone());
		clone.setMobilePhone(getMobilePhone());
		clone.setOfficeSite(getOfficeSite());
		clone.setCurrentCategory(getCurrentCategory());
		clone.setCurrentSeatNo(getCurrentSeatNo());
		clone.setMovingDate(getMovingDate());
		clone.setExpectedSeatNo(getExpectedSeatNo());
		clone.setReasonForChange(getReasonForChange());
		clone.setOfficeKey(getOfficeKey());
		clone.setPlant(getPlant());
		clone.setTelephoneAndExtNo(getTelephoneAndExtNo());
		clone.setNamePlate(getNamePlate());
		clone.setCabinet(getCabinet());
		clone.setIsOnBehalfOf(getIsOnBehalfOf());
		clone.setNowCategory(getNowCategory());
		clone.setNewSeatNo(getNewSeatNo());
		clone.setWorkspaceId(getWorkspaceId());
		clone.setSeatStatus(getSeatStatus());
		clone.setSg(getSg());
		clone.setLeadingMark(getLeadingMark());
		clone.setPositionFlag(getPositionFlag());
		clone.setIsApplicantAgent(getIsApplicantAgent());
		clone.setIsApproverAgent(getIsApproverAgent());
		clone.setCandidateName(getCandidateName());
		clone.setDesiredStartingDate(getDesiredStartingDate());
		clone.setComments(getComments());
		clone.setContractType(getContractType());
		clone.setProcessType(getProcessType());
		clone.setSubProcessType(getSubProcessType());
		clone.setStatus(getStatus());
		clone.setStatusByUserId(getStatusByUserId());
		clone.setStatusByUserName(getStatusByUserName());
		clone.setStatusDate(getStatusDate());

		return clone;
	}

	@Override
	public int compareTo(SeatOffice seatOffice) {
		int value = 0;

		if (getSeatId() < seatOffice.getSeatId()) {
			value = -1;
		}
		else if (getSeatId() > seatOffice.getSeatId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SeatOfficeClp)) {
			return false;
		}

		SeatOfficeClp seatOffice = (SeatOfficeClp)obj;

		long primaryKey = seatOffice.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(95);

		sb.append("{seatId=");
		sb.append(getSeatId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", ticketNo=");
		sb.append(getTicketNo());
		sb.append(", staffName=");
		sb.append(getStaffName());
		sb.append(", staffCode=");
		sb.append(getStaffCode());
		sb.append(", companyName=");
		sb.append(getCompanyName());
		sb.append(", division=");
		sb.append(getDivision());
		sb.append(", department=");
		sb.append(getDepartment());
		sb.append(", costCenter=");
		sb.append(getCostCenter());
		sb.append(", officePhone=");
		sb.append(getOfficePhone());
		sb.append(", mobilePhone=");
		sb.append(getMobilePhone());
		sb.append(", officeSite=");
		sb.append(getOfficeSite());
		sb.append(", currentCategory=");
		sb.append(getCurrentCategory());
		sb.append(", currentSeatNo=");
		sb.append(getCurrentSeatNo());
		sb.append(", movingDate=");
		sb.append(getMovingDate());
		sb.append(", expectedSeatNo=");
		sb.append(getExpectedSeatNo());
		sb.append(", reasonForChange=");
		sb.append(getReasonForChange());
		sb.append(", officeKey=");
		sb.append(getOfficeKey());
		sb.append(", plant=");
		sb.append(getPlant());
		sb.append(", telephoneAndExtNo=");
		sb.append(getTelephoneAndExtNo());
		sb.append(", namePlate=");
		sb.append(getNamePlate());
		sb.append(", cabinet=");
		sb.append(getCabinet());
		sb.append(", isOnBehalfOf=");
		sb.append(getIsOnBehalfOf());
		sb.append(", nowCategory=");
		sb.append(getNowCategory());
		sb.append(", newSeatNo=");
		sb.append(getNewSeatNo());
		sb.append(", workspaceId=");
		sb.append(getWorkspaceId());
		sb.append(", seatStatus=");
		sb.append(getSeatStatus());
		sb.append(", sg=");
		sb.append(getSg());
		sb.append(", leadingMark=");
		sb.append(getLeadingMark());
		sb.append(", positionFlag=");
		sb.append(getPositionFlag());
		sb.append(", isApplicantAgent=");
		sb.append(getIsApplicantAgent());
		sb.append(", isApproverAgent=");
		sb.append(getIsApproverAgent());
		sb.append(", candidateName=");
		sb.append(getCandidateName());
		sb.append(", desiredStartingDate=");
		sb.append(getDesiredStartingDate());
		sb.append(", comments=");
		sb.append(getComments());
		sb.append(", contractType=");
		sb.append(getContractType());
		sb.append(", processType=");
		sb.append(getProcessType());
		sb.append(", subProcessType=");
		sb.append(getSubProcessType());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", statusByUserId=");
		sb.append(getStatusByUserId());
		sb.append(", statusByUserName=");
		sb.append(getStatusByUserName());
		sb.append(", statusDate=");
		sb.append(getStatusDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(145);

		sb.append("<model><model-name>");
		sb.append("com.seatoffice.model.SeatOffice");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>seatId</column-name><column-value><![CDATA[");
		sb.append(getSeatId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ticketNo</column-name><column-value><![CDATA[");
		sb.append(getTicketNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>staffName</column-name><column-value><![CDATA[");
		sb.append(getStaffName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>staffCode</column-name><column-value><![CDATA[");
		sb.append(getStaffCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyName</column-name><column-value><![CDATA[");
		sb.append(getCompanyName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>division</column-name><column-value><![CDATA[");
		sb.append(getDivision());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>department</column-name><column-value><![CDATA[");
		sb.append(getDepartment());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>costCenter</column-name><column-value><![CDATA[");
		sb.append(getCostCenter());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>officePhone</column-name><column-value><![CDATA[");
		sb.append(getOfficePhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mobilePhone</column-name><column-value><![CDATA[");
		sb.append(getMobilePhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>officeSite</column-name><column-value><![CDATA[");
		sb.append(getOfficeSite());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currentCategory</column-name><column-value><![CDATA[");
		sb.append(getCurrentCategory());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currentSeatNo</column-name><column-value><![CDATA[");
		sb.append(getCurrentSeatNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>movingDate</column-name><column-value><![CDATA[");
		sb.append(getMovingDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expectedSeatNo</column-name><column-value><![CDATA[");
		sb.append(getExpectedSeatNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reasonForChange</column-name><column-value><![CDATA[");
		sb.append(getReasonForChange());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>officeKey</column-name><column-value><![CDATA[");
		sb.append(getOfficeKey());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>plant</column-name><column-value><![CDATA[");
		sb.append(getPlant());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>telephoneAndExtNo</column-name><column-value><![CDATA[");
		sb.append(getTelephoneAndExtNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>namePlate</column-name><column-value><![CDATA[");
		sb.append(getNamePlate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cabinet</column-name><column-value><![CDATA[");
		sb.append(getCabinet());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isOnBehalfOf</column-name><column-value><![CDATA[");
		sb.append(getIsOnBehalfOf());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nowCategory</column-name><column-value><![CDATA[");
		sb.append(getNowCategory());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>newSeatNo</column-name><column-value><![CDATA[");
		sb.append(getNewSeatNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>workspaceId</column-name><column-value><![CDATA[");
		sb.append(getWorkspaceId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>seatStatus</column-name><column-value><![CDATA[");
		sb.append(getSeatStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sg</column-name><column-value><![CDATA[");
		sb.append(getSg());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>leadingMark</column-name><column-value><![CDATA[");
		sb.append(getLeadingMark());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>positionFlag</column-name><column-value><![CDATA[");
		sb.append(getPositionFlag());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isApplicantAgent</column-name><column-value><![CDATA[");
		sb.append(getIsApplicantAgent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isApproverAgent</column-name><column-value><![CDATA[");
		sb.append(getIsApproverAgent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>candidateName</column-name><column-value><![CDATA[");
		sb.append(getCandidateName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>desiredStartingDate</column-name><column-value><![CDATA[");
		sb.append(getDesiredStartingDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>comments</column-name><column-value><![CDATA[");
		sb.append(getComments());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contractType</column-name><column-value><![CDATA[");
		sb.append(getContractType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>processType</column-name><column-value><![CDATA[");
		sb.append(getProcessType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subProcessType</column-name><column-value><![CDATA[");
		sb.append(getSubProcessType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserId</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserName</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusDate</column-name><column-value><![CDATA[");
		sb.append(getStatusDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _seatId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _companyId;
	private String _ticketNo;
	private String _staffName;
	private long _staffCode;
	private String _companyName;
	private String _division;
	private String _department;
	private String _costCenter;
	private String _officePhone;
	private String _mobilePhone;
	private String _officeSite;
	private long _currentCategory;
	private String _currentSeatNo;
	private Date _movingDate;
	private String _expectedSeatNo;
	private String _reasonForChange;
	private boolean _officeKey;
	private boolean _plant;
	private boolean _telephoneAndExtNo;
	private boolean _namePlate;
	private boolean _cabinet;
	private boolean _isOnBehalfOf;
	private long _nowCategory;
	private String _newSeatNo;
	private long _workspaceId;
	private String _seatStatus;
	private String _sg;
	private String _leadingMark;
	private String _positionFlag;
	private boolean _isApplicantAgent;
	private boolean _isApproverAgent;
	private String _candidateName;
	private Date _desiredStartingDate;
	private String _comments;
	private String _contractType;
	private String _processType;
	private String _subProcessType;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserUuid;
	private String _statusByUserName;
	private Date _statusDate;
	private BaseModel<?> _seatOfficeRemoteModel;
	private Class<?> _clpSerializerClass = com.seatoffice.service.ClpSerializer.class;
}