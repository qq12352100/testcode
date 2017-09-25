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

import com.business.trip.service.BusinessTripApplicationLocalServiceUtil;
import com.business.trip.service.ClpSerializer;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class BusinessTripApplicationClp extends BaseModelImpl<BusinessTripApplication>
	implements BusinessTripApplication {
	public BusinessTripApplicationClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return BusinessTripApplication.class;
	}

	@Override
	public String getModelClassName() {
		return BusinessTripApplication.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _businessTripApplicationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBusinessTripApplicationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _businessTripApplicationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("businessTripApplicationId",
			getBusinessTripApplicationId());
		attributes.put("ticketNo", getTicketNo());
		attributes.put("processType", getProcessType());
		attributes.put("subType", getSubType());
		attributes.put("printName", getPrintName());
		attributes.put("staffCode", getStaffCode());
		attributes.put("companyName", getCompanyName());
		attributes.put("division", getDivision());
		attributes.put("department", getDepartment());
		attributes.put("costCenter", getCostCenter());
		attributes.put("personalID", getPersonalID());
		attributes.put("passportNo", getPassportNo());
		attributes.put("officePhone", getOfficePhone());
		attributes.put("mobilePhone", getMobilePhone());
		attributes.put("email", getEmail());
		attributes.put("officeSite", getOfficeSite());
		attributes.put("approverId", getApproverId());
		attributes.put("approverName", getApproverName());
		attributes.put("evpId", getEvpId());
		attributes.put("evpName", getEvpName());
		attributes.put("isCrossDepartment", getIsCrossDepartment());
		attributes.put("targetDepartmentId", getTargetDepartmentId());
		attributes.put("targetDepartmentName", getTargetDepartmentName());
		attributes.put("targetCostCenter", getTargetCostCenter());
		attributes.put("targetDepartmentApproverId",
			getTargetDepartmentApproverId());
		attributes.put("targetDepartmentApproverName",
			getTargetDepartmentApproverName());
		attributes.put("tripType", getTripType());
		attributes.put("departureDate", getDepartureDate());
		attributes.put("returnDate", getReturnDate());
		attributes.put("purposeOfTheTrip", getPurposeOfTheTrip());
		attributes.put("visitCountriesCities", getVisitCountriesCities());
		attributes.put("advancePayment", getAdvancePayment());
		attributes.put("currency", getCurrency());
		attributes.put("paymentMethods", getPaymentMethods());
		attributes.put("totalCostRmb", getTotalCostRmb());
		attributes.put("totalCostEur", getTotalCostEur());
		attributes.put("hotelTotalCostRmb", getHotelTotalCostRmb());
		attributes.put("hotelTotalCostEur", getHotelTotalCostEur());
		attributes.put("carRentalTotalCostRmb", getCarRentalTotalCostRmb());
		attributes.put("carRentalTotalCostEur", getCarRentalTotalCostEur());
		attributes.put("remark", getRemark());
		attributes.put("otherEmails", getOtherEmails());
		attributes.put("status", getStatus());
		attributes.put("sapStatus", getSapStatus());
		attributes.put("sapComments", getSapComments());
		attributes.put("sapDocumentId", getSapDocumentId());
		attributes.put("sapCertificateNo", getSapCertificateNo());
		attributes.put("sapCompany", getSapCompany());
		attributes.put("sapYear", getSapYear());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("isApplicantAgent", getIsApplicantAgent());
		attributes.put("isApproverAgent", getIsApproverAgent());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("submittedDate", getSubmittedDate());
		attributes.put("companyId", getCompanyId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long businessTripApplicationId = (Long)attributes.get(
				"businessTripApplicationId");

		if (businessTripApplicationId != null) {
			setBusinessTripApplicationId(businessTripApplicationId);
		}

		String ticketNo = (String)attributes.get("ticketNo");

		if (ticketNo != null) {
			setTicketNo(ticketNo);
		}

		String processType = (String)attributes.get("processType");

		if (processType != null) {
			setProcessType(processType);
		}

		String subType = (String)attributes.get("subType");

		if (subType != null) {
			setSubType(subType);
		}

		String printName = (String)attributes.get("printName");

		if (printName != null) {
			setPrintName(printName);
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

		String personalID = (String)attributes.get("personalID");

		if (personalID != null) {
			setPersonalID(personalID);
		}

		String passportNo = (String)attributes.get("passportNo");

		if (passportNo != null) {
			setPassportNo(passportNo);
		}

		String officePhone = (String)attributes.get("officePhone");

		if (officePhone != null) {
			setOfficePhone(officePhone);
		}

		String mobilePhone = (String)attributes.get("mobilePhone");

		if (mobilePhone != null) {
			setMobilePhone(mobilePhone);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String officeSite = (String)attributes.get("officeSite");

		if (officeSite != null) {
			setOfficeSite(officeSite);
		}

		Long approverId = (Long)attributes.get("approverId");

		if (approverId != null) {
			setApproverId(approverId);
		}

		String approverName = (String)attributes.get("approverName");

		if (approverName != null) {
			setApproverName(approverName);
		}

		Long evpId = (Long)attributes.get("evpId");

		if (evpId != null) {
			setEvpId(evpId);
		}

		String evpName = (String)attributes.get("evpName");

		if (evpName != null) {
			setEvpName(evpName);
		}

		Boolean isCrossDepartment = (Boolean)attributes.get("isCrossDepartment");

		if (isCrossDepartment != null) {
			setIsCrossDepartment(isCrossDepartment);
		}

		Long targetDepartmentId = (Long)attributes.get("targetDepartmentId");

		if (targetDepartmentId != null) {
			setTargetDepartmentId(targetDepartmentId);
		}

		String targetDepartmentName = (String)attributes.get(
				"targetDepartmentName");

		if (targetDepartmentName != null) {
			setTargetDepartmentName(targetDepartmentName);
		}

		String targetCostCenter = (String)attributes.get("targetCostCenter");

		if (targetCostCenter != null) {
			setTargetCostCenter(targetCostCenter);
		}

		Long targetDepartmentApproverId = (Long)attributes.get(
				"targetDepartmentApproverId");

		if (targetDepartmentApproverId != null) {
			setTargetDepartmentApproverId(targetDepartmentApproverId);
		}

		String targetDepartmentApproverName = (String)attributes.get(
				"targetDepartmentApproverName");

		if (targetDepartmentApproverName != null) {
			setTargetDepartmentApproverName(targetDepartmentApproverName);
		}

		Integer tripType = (Integer)attributes.get("tripType");

		if (tripType != null) {
			setTripType(tripType);
		}

		Date departureDate = (Date)attributes.get("departureDate");

		if (departureDate != null) {
			setDepartureDate(departureDate);
		}

		Date returnDate = (Date)attributes.get("returnDate");

		if (returnDate != null) {
			setReturnDate(returnDate);
		}

		String purposeOfTheTrip = (String)attributes.get("purposeOfTheTrip");

		if (purposeOfTheTrip != null) {
			setPurposeOfTheTrip(purposeOfTheTrip);
		}

		String visitCountriesCities = (String)attributes.get(
				"visitCountriesCities");

		if (visitCountriesCities != null) {
			setVisitCountriesCities(visitCountriesCities);
		}

		Double advancePayment = (Double)attributes.get("advancePayment");

		if (advancePayment != null) {
			setAdvancePayment(advancePayment);
		}

		String currency = (String)attributes.get("currency");

		if (currency != null) {
			setCurrency(currency);
		}

		String paymentMethods = (String)attributes.get("paymentMethods");

		if (paymentMethods != null) {
			setPaymentMethods(paymentMethods);
		}

		Double totalCostRmb = (Double)attributes.get("totalCostRmb");

		if (totalCostRmb != null) {
			setTotalCostRmb(totalCostRmb);
		}

		Double totalCostEur = (Double)attributes.get("totalCostEur");

		if (totalCostEur != null) {
			setTotalCostEur(totalCostEur);
		}

		Double hotelTotalCostRmb = (Double)attributes.get("hotelTotalCostRmb");

		if (hotelTotalCostRmb != null) {
			setHotelTotalCostRmb(hotelTotalCostRmb);
		}

		Double hotelTotalCostEur = (Double)attributes.get("hotelTotalCostEur");

		if (hotelTotalCostEur != null) {
			setHotelTotalCostEur(hotelTotalCostEur);
		}

		Double carRentalTotalCostRmb = (Double)attributes.get(
				"carRentalTotalCostRmb");

		if (carRentalTotalCostRmb != null) {
			setCarRentalTotalCostRmb(carRentalTotalCostRmb);
		}

		Double carRentalTotalCostEur = (Double)attributes.get(
				"carRentalTotalCostEur");

		if (carRentalTotalCostEur != null) {
			setCarRentalTotalCostEur(carRentalTotalCostEur);
		}

		String remark = (String)attributes.get("remark");

		if (remark != null) {
			setRemark(remark);
		}

		String otherEmails = (String)attributes.get("otherEmails");

		if (otherEmails != null) {
			setOtherEmails(otherEmails);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Integer sapStatus = (Integer)attributes.get("sapStatus");

		if (sapStatus != null) {
			setSapStatus(sapStatus);
		}

		String sapComments = (String)attributes.get("sapComments");

		if (sapComments != null) {
			setSapComments(sapComments);
		}

		String sapDocumentId = (String)attributes.get("sapDocumentId");

		if (sapDocumentId != null) {
			setSapDocumentId(sapDocumentId);
		}

		String sapCertificateNo = (String)attributes.get("sapCertificateNo");

		if (sapCertificateNo != null) {
			setSapCertificateNo(sapCertificateNo);
		}

		String sapCompany = (String)attributes.get("sapCompany");

		if (sapCompany != null) {
			setSapCompany(sapCompany);
		}

		String sapYear = (String)attributes.get("sapYear");

		if (sapYear != null) {
			setSapYear(sapYear);
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

		Boolean isApplicantAgent = (Boolean)attributes.get("isApplicantAgent");

		if (isApplicantAgent != null) {
			setIsApplicantAgent(isApplicantAgent);
		}

		Boolean isApproverAgent = (Boolean)attributes.get("isApproverAgent");

		if (isApproverAgent != null) {
			setIsApproverAgent(isApproverAgent);
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

		Date submittedDate = (Date)attributes.get("submittedDate");

		if (submittedDate != null) {
			setSubmittedDate(submittedDate);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}
	}

	@Override
	public long getBusinessTripApplicationId() {
		return _businessTripApplicationId;
	}

	@Override
	public void setBusinessTripApplicationId(long businessTripApplicationId) {
		_businessTripApplicationId = businessTripApplicationId;

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setBusinessTripApplicationId",
						long.class);

				method.invoke(_businessTripApplicationRemoteModel,
					businessTripApplicationId);
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

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setTicketNo", String.class);

				method.invoke(_businessTripApplicationRemoteModel, ticketNo);
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

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setProcessType", String.class);

				method.invoke(_businessTripApplicationRemoteModel, processType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSubType() {
		return _subType;
	}

	@Override
	public void setSubType(String subType) {
		_subType = subType;

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setSubType", String.class);

				method.invoke(_businessTripApplicationRemoteModel, subType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPrintName() {
		return _printName;
	}

	@Override
	public void setPrintName(String printName) {
		_printName = printName;

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setPrintName", String.class);

				method.invoke(_businessTripApplicationRemoteModel, printName);
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

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setStaffCode", long.class);

				method.invoke(_businessTripApplicationRemoteModel, staffCode);
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

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyName", String.class);

				method.invoke(_businessTripApplicationRemoteModel, companyName);
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

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setDivision", String.class);

				method.invoke(_businessTripApplicationRemoteModel, division);
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

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setDepartment", String.class);

				method.invoke(_businessTripApplicationRemoteModel, department);
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

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setCostCenter", String.class);

				method.invoke(_businessTripApplicationRemoteModel, costCenter);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPersonalID() {
		return _personalID;
	}

	@Override
	public void setPersonalID(String personalID) {
		_personalID = personalID;

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setPersonalID", String.class);

				method.invoke(_businessTripApplicationRemoteModel, personalID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPassportNo() {
		return _passportNo;
	}

	@Override
	public void setPassportNo(String passportNo) {
		_passportNo = passportNo;

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setPassportNo", String.class);

				method.invoke(_businessTripApplicationRemoteModel, passportNo);
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

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setOfficePhone", String.class);

				method.invoke(_businessTripApplicationRemoteModel, officePhone);
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

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setMobilePhone", String.class);

				method.invoke(_businessTripApplicationRemoteModel, mobilePhone);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmail() {
		return _email;
	}

	@Override
	public void setEmail(String email) {
		_email = email;

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setEmail", String.class);

				method.invoke(_businessTripApplicationRemoteModel, email);
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

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setOfficeSite", String.class);

				method.invoke(_businessTripApplicationRemoteModel, officeSite);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getApproverId() {
		return _approverId;
	}

	@Override
	public void setApproverId(long approverId) {
		_approverId = approverId;

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setApproverId", long.class);

				method.invoke(_businessTripApplicationRemoteModel, approverId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getApproverName() {
		return _approverName;
	}

	@Override
	public void setApproverName(String approverName) {
		_approverName = approverName;

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setApproverName", String.class);

				method.invoke(_businessTripApplicationRemoteModel, approverName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEvpId() {
		return _evpId;
	}

	@Override
	public void setEvpId(long evpId) {
		_evpId = evpId;

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setEvpId", long.class);

				method.invoke(_businessTripApplicationRemoteModel, evpId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEvpName() {
		return _evpName;
	}

	@Override
	public void setEvpName(String evpName) {
		_evpName = evpName;

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setEvpName", String.class);

				method.invoke(_businessTripApplicationRemoteModel, evpName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsCrossDepartment() {
		return _isCrossDepartment;
	}

	@Override
	public boolean isIsCrossDepartment() {
		return _isCrossDepartment;
	}

	@Override
	public void setIsCrossDepartment(boolean isCrossDepartment) {
		_isCrossDepartment = isCrossDepartment;

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setIsCrossDepartment",
						boolean.class);

				method.invoke(_businessTripApplicationRemoteModel,
					isCrossDepartment);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTargetDepartmentId() {
		return _targetDepartmentId;
	}

	@Override
	public void setTargetDepartmentId(long targetDepartmentId) {
		_targetDepartmentId = targetDepartmentId;

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setTargetDepartmentId",
						long.class);

				method.invoke(_businessTripApplicationRemoteModel,
					targetDepartmentId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTargetDepartmentName() {
		return _targetDepartmentName;
	}

	@Override
	public void setTargetDepartmentName(String targetDepartmentName) {
		_targetDepartmentName = targetDepartmentName;

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setTargetDepartmentName",
						String.class);

				method.invoke(_businessTripApplicationRemoteModel,
					targetDepartmentName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTargetCostCenter() {
		return _targetCostCenter;
	}

	@Override
	public void setTargetCostCenter(String targetCostCenter) {
		_targetCostCenter = targetCostCenter;

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setTargetCostCenter",
						String.class);

				method.invoke(_businessTripApplicationRemoteModel,
					targetCostCenter);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTargetDepartmentApproverId() {
		return _targetDepartmentApproverId;
	}

	@Override
	public void setTargetDepartmentApproverId(long targetDepartmentApproverId) {
		_targetDepartmentApproverId = targetDepartmentApproverId;

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setTargetDepartmentApproverId",
						long.class);

				method.invoke(_businessTripApplicationRemoteModel,
					targetDepartmentApproverId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTargetDepartmentApproverName() {
		return _targetDepartmentApproverName;
	}

	@Override
	public void setTargetDepartmentApproverName(
		String targetDepartmentApproverName) {
		_targetDepartmentApproverName = targetDepartmentApproverName;

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setTargetDepartmentApproverName",
						String.class);

				method.invoke(_businessTripApplicationRemoteModel,
					targetDepartmentApproverName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getTripType() {
		return _tripType;
	}

	@Override
	public void setTripType(int tripType) {
		_tripType = tripType;

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setTripType", int.class);

				method.invoke(_businessTripApplicationRemoteModel, tripType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDepartureDate() {
		return _departureDate;
	}

	@Override
	public void setDepartureDate(Date departureDate) {
		_departureDate = departureDate;

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setDepartureDate", Date.class);

				method.invoke(_businessTripApplicationRemoteModel, departureDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getReturnDate() {
		return _returnDate;
	}

	@Override
	public void setReturnDate(Date returnDate) {
		_returnDate = returnDate;

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setReturnDate", Date.class);

				method.invoke(_businessTripApplicationRemoteModel, returnDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPurposeOfTheTrip() {
		return _purposeOfTheTrip;
	}

	@Override
	public void setPurposeOfTheTrip(String purposeOfTheTrip) {
		_purposeOfTheTrip = purposeOfTheTrip;

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setPurposeOfTheTrip",
						String.class);

				method.invoke(_businessTripApplicationRemoteModel,
					purposeOfTheTrip);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVisitCountriesCities() {
		return _visitCountriesCities;
	}

	@Override
	public void setVisitCountriesCities(String visitCountriesCities) {
		_visitCountriesCities = visitCountriesCities;

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setVisitCountriesCities",
						String.class);

				method.invoke(_businessTripApplicationRemoteModel,
					visitCountriesCities);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getAdvancePayment() {
		return _advancePayment;
	}

	@Override
	public void setAdvancePayment(double advancePayment) {
		_advancePayment = advancePayment;

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setAdvancePayment",
						double.class);

				method.invoke(_businessTripApplicationRemoteModel,
					advancePayment);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCurrency() {
		return _currency;
	}

	@Override
	public void setCurrency(String currency) {
		_currency = currency;

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setCurrency", String.class);

				method.invoke(_businessTripApplicationRemoteModel, currency);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPaymentMethods() {
		return _paymentMethods;
	}

	@Override
	public void setPaymentMethods(String paymentMethods) {
		_paymentMethods = paymentMethods;

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setPaymentMethods",
						String.class);

				method.invoke(_businessTripApplicationRemoteModel,
					paymentMethods);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getTotalCostRmb() {
		return _totalCostRmb;
	}

	@Override
	public void setTotalCostRmb(double totalCostRmb) {
		_totalCostRmb = totalCostRmb;

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setTotalCostRmb", double.class);

				method.invoke(_businessTripApplicationRemoteModel, totalCostRmb);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getTotalCostEur() {
		return _totalCostEur;
	}

	@Override
	public void setTotalCostEur(double totalCostEur) {
		_totalCostEur = totalCostEur;

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setTotalCostEur", double.class);

				method.invoke(_businessTripApplicationRemoteModel, totalCostEur);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getHotelTotalCostRmb() {
		return _hotelTotalCostRmb;
	}

	@Override
	public void setHotelTotalCostRmb(double hotelTotalCostRmb) {
		_hotelTotalCostRmb = hotelTotalCostRmb;

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setHotelTotalCostRmb",
						double.class);

				method.invoke(_businessTripApplicationRemoteModel,
					hotelTotalCostRmb);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getHotelTotalCostEur() {
		return _hotelTotalCostEur;
	}

	@Override
	public void setHotelTotalCostEur(double hotelTotalCostEur) {
		_hotelTotalCostEur = hotelTotalCostEur;

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setHotelTotalCostEur",
						double.class);

				method.invoke(_businessTripApplicationRemoteModel,
					hotelTotalCostEur);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getCarRentalTotalCostRmb() {
		return _carRentalTotalCostRmb;
	}

	@Override
	public void setCarRentalTotalCostRmb(double carRentalTotalCostRmb) {
		_carRentalTotalCostRmb = carRentalTotalCostRmb;

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setCarRentalTotalCostRmb",
						double.class);

				method.invoke(_businessTripApplicationRemoteModel,
					carRentalTotalCostRmb);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getCarRentalTotalCostEur() {
		return _carRentalTotalCostEur;
	}

	@Override
	public void setCarRentalTotalCostEur(double carRentalTotalCostEur) {
		_carRentalTotalCostEur = carRentalTotalCostEur;

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setCarRentalTotalCostEur",
						double.class);

				method.invoke(_businessTripApplicationRemoteModel,
					carRentalTotalCostEur);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRemark() {
		return _remark;
	}

	@Override
	public void setRemark(String remark) {
		_remark = remark;

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setRemark", String.class);

				method.invoke(_businessTripApplicationRemoteModel, remark);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOtherEmails() {
		return _otherEmails;
	}

	@Override
	public void setOtherEmails(String otherEmails) {
		_otherEmails = otherEmails;

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setOtherEmails", String.class);

				method.invoke(_businessTripApplicationRemoteModel, otherEmails);
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

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_businessTripApplicationRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getSapStatus() {
		return _sapStatus;
	}

	@Override
	public void setSapStatus(int sapStatus) {
		_sapStatus = sapStatus;

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setSapStatus", int.class);

				method.invoke(_businessTripApplicationRemoteModel, sapStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSapComments() {
		return _sapComments;
	}

	@Override
	public void setSapComments(String sapComments) {
		_sapComments = sapComments;

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setSapComments", String.class);

				method.invoke(_businessTripApplicationRemoteModel, sapComments);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSapDocumentId() {
		return _sapDocumentId;
	}

	@Override
	public void setSapDocumentId(String sapDocumentId) {
		_sapDocumentId = sapDocumentId;

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setSapDocumentId", String.class);

				method.invoke(_businessTripApplicationRemoteModel, sapDocumentId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSapCertificateNo() {
		return _sapCertificateNo;
	}

	@Override
	public void setSapCertificateNo(String sapCertificateNo) {
		_sapCertificateNo = sapCertificateNo;

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setSapCertificateNo",
						String.class);

				method.invoke(_businessTripApplicationRemoteModel,
					sapCertificateNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSapCompany() {
		return _sapCompany;
	}

	@Override
	public void setSapCompany(String sapCompany) {
		_sapCompany = sapCompany;

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setSapCompany", String.class);

				method.invoke(_businessTripApplicationRemoteModel, sapCompany);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSapYear() {
		return _sapYear;
	}

	@Override
	public void setSapYear(String sapYear) {
		_sapYear = sapYear;

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setSapYear", String.class);

				method.invoke(_businessTripApplicationRemoteModel, sapYear);
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

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusByUserId", long.class);

				method.invoke(_businessTripApplicationRemoteModel,
					statusByUserId);
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

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusByUserName",
						String.class);

				method.invoke(_businessTripApplicationRemoteModel,
					statusByUserName);
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

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusDate", Date.class);

				method.invoke(_businessTripApplicationRemoteModel, statusDate);
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

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setIsApplicantAgent",
						boolean.class);

				method.invoke(_businessTripApplicationRemoteModel,
					isApplicantAgent);
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

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setIsApproverAgent",
						boolean.class);

				method.invoke(_businessTripApplicationRemoteModel,
					isApproverAgent);
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

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_businessTripApplicationRemoteModel, groupId);
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

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_businessTripApplicationRemoteModel, userId);
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

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_businessTripApplicationRemoteModel, userName);
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

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_businessTripApplicationRemoteModel, createDate);
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

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_businessTripApplicationRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getSubmittedDate() {
		return _submittedDate;
	}

	@Override
	public void setSubmittedDate(Date submittedDate) {
		_submittedDate = submittedDate;

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setSubmittedDate", Date.class);

				method.invoke(_businessTripApplicationRemoteModel, submittedDate);
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

		if (_businessTripApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_businessTripApplicationRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public com.liferay.portal.model.User findSupervisorUser(
		com.business.trip.model.BusinessTripApplication businessTripApplication) {
		try {
			String methodName = "findSupervisorUser";

			Class<?>[] parameterTypes = new Class<?>[] {
					com.business.trip.model.BusinessTripApplication.class
				};

			Object[] parameterValues = new Object[] { businessTripApplication };

			com.liferay.portal.model.User returnObj = (com.liferay.portal.model.User)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
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

	public BaseModel<?> getBusinessTripApplicationRemoteModel() {
		return _businessTripApplicationRemoteModel;
	}

	public void setBusinessTripApplicationRemoteModel(
		BaseModel<?> businessTripApplicationRemoteModel) {
		_businessTripApplicationRemoteModel = businessTripApplicationRemoteModel;
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

		Class<?> remoteModelClass = _businessTripApplicationRemoteModel.getClass();

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

		Object returnValue = method.invoke(_businessTripApplicationRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			BusinessTripApplicationLocalServiceUtil.addBusinessTripApplication(this);
		}
		else {
			BusinessTripApplicationLocalServiceUtil.updateBusinessTripApplication(this);
		}
	}

	@Override
	public BusinessTripApplication toEscapedModel() {
		return (BusinessTripApplication)ProxyUtil.newProxyInstance(BusinessTripApplication.class.getClassLoader(),
			new Class[] { BusinessTripApplication.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BusinessTripApplicationClp clone = new BusinessTripApplicationClp();

		clone.setBusinessTripApplicationId(getBusinessTripApplicationId());
		clone.setTicketNo(getTicketNo());
		clone.setProcessType(getProcessType());
		clone.setSubType(getSubType());
		clone.setPrintName(getPrintName());
		clone.setStaffCode(getStaffCode());
		clone.setCompanyName(getCompanyName());
		clone.setDivision(getDivision());
		clone.setDepartment(getDepartment());
		clone.setCostCenter(getCostCenter());
		clone.setPersonalID(getPersonalID());
		clone.setPassportNo(getPassportNo());
		clone.setOfficePhone(getOfficePhone());
		clone.setMobilePhone(getMobilePhone());
		clone.setEmail(getEmail());
		clone.setOfficeSite(getOfficeSite());
		clone.setApproverId(getApproverId());
		clone.setApproverName(getApproverName());
		clone.setEvpId(getEvpId());
		clone.setEvpName(getEvpName());
		clone.setIsCrossDepartment(getIsCrossDepartment());
		clone.setTargetDepartmentId(getTargetDepartmentId());
		clone.setTargetDepartmentName(getTargetDepartmentName());
		clone.setTargetCostCenter(getTargetCostCenter());
		clone.setTargetDepartmentApproverId(getTargetDepartmentApproverId());
		clone.setTargetDepartmentApproverName(getTargetDepartmentApproverName());
		clone.setTripType(getTripType());
		clone.setDepartureDate(getDepartureDate());
		clone.setReturnDate(getReturnDate());
		clone.setPurposeOfTheTrip(getPurposeOfTheTrip());
		clone.setVisitCountriesCities(getVisitCountriesCities());
		clone.setAdvancePayment(getAdvancePayment());
		clone.setCurrency(getCurrency());
		clone.setPaymentMethods(getPaymentMethods());
		clone.setTotalCostRmb(getTotalCostRmb());
		clone.setTotalCostEur(getTotalCostEur());
		clone.setHotelTotalCostRmb(getHotelTotalCostRmb());
		clone.setHotelTotalCostEur(getHotelTotalCostEur());
		clone.setCarRentalTotalCostRmb(getCarRentalTotalCostRmb());
		clone.setCarRentalTotalCostEur(getCarRentalTotalCostEur());
		clone.setRemark(getRemark());
		clone.setOtherEmails(getOtherEmails());
		clone.setStatus(getStatus());
		clone.setSapStatus(getSapStatus());
		clone.setSapComments(getSapComments());
		clone.setSapDocumentId(getSapDocumentId());
		clone.setSapCertificateNo(getSapCertificateNo());
		clone.setSapCompany(getSapCompany());
		clone.setSapYear(getSapYear());
		clone.setStatusByUserId(getStatusByUserId());
		clone.setStatusByUserName(getStatusByUserName());
		clone.setStatusDate(getStatusDate());
		clone.setIsApplicantAgent(getIsApplicantAgent());
		clone.setIsApproverAgent(getIsApproverAgent());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setSubmittedDate(getSubmittedDate());
		clone.setCompanyId(getCompanyId());

		return clone;
	}

	@Override
	public int compareTo(BusinessTripApplication businessTripApplication) {
		long primaryKey = businessTripApplication.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BusinessTripApplicationClp)) {
			return false;
		}

		BusinessTripApplicationClp businessTripApplication = (BusinessTripApplicationClp)obj;

		long primaryKey = businessTripApplication.getPrimaryKey();

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
		StringBundler sb = new StringBundler(123);

		sb.append("{businessTripApplicationId=");
		sb.append(getBusinessTripApplicationId());
		sb.append(", ticketNo=");
		sb.append(getTicketNo());
		sb.append(", processType=");
		sb.append(getProcessType());
		sb.append(", subType=");
		sb.append(getSubType());
		sb.append(", printName=");
		sb.append(getPrintName());
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
		sb.append(", personalID=");
		sb.append(getPersonalID());
		sb.append(", passportNo=");
		sb.append(getPassportNo());
		sb.append(", officePhone=");
		sb.append(getOfficePhone());
		sb.append(", mobilePhone=");
		sb.append(getMobilePhone());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", officeSite=");
		sb.append(getOfficeSite());
		sb.append(", approverId=");
		sb.append(getApproverId());
		sb.append(", approverName=");
		sb.append(getApproverName());
		sb.append(", evpId=");
		sb.append(getEvpId());
		sb.append(", evpName=");
		sb.append(getEvpName());
		sb.append(", isCrossDepartment=");
		sb.append(getIsCrossDepartment());
		sb.append(", targetDepartmentId=");
		sb.append(getTargetDepartmentId());
		sb.append(", targetDepartmentName=");
		sb.append(getTargetDepartmentName());
		sb.append(", targetCostCenter=");
		sb.append(getTargetCostCenter());
		sb.append(", targetDepartmentApproverId=");
		sb.append(getTargetDepartmentApproverId());
		sb.append(", targetDepartmentApproverName=");
		sb.append(getTargetDepartmentApproverName());
		sb.append(", tripType=");
		sb.append(getTripType());
		sb.append(", departureDate=");
		sb.append(getDepartureDate());
		sb.append(", returnDate=");
		sb.append(getReturnDate());
		sb.append(", purposeOfTheTrip=");
		sb.append(getPurposeOfTheTrip());
		sb.append(", visitCountriesCities=");
		sb.append(getVisitCountriesCities());
		sb.append(", advancePayment=");
		sb.append(getAdvancePayment());
		sb.append(", currency=");
		sb.append(getCurrency());
		sb.append(", paymentMethods=");
		sb.append(getPaymentMethods());
		sb.append(", totalCostRmb=");
		sb.append(getTotalCostRmb());
		sb.append(", totalCostEur=");
		sb.append(getTotalCostEur());
		sb.append(", hotelTotalCostRmb=");
		sb.append(getHotelTotalCostRmb());
		sb.append(", hotelTotalCostEur=");
		sb.append(getHotelTotalCostEur());
		sb.append(", carRentalTotalCostRmb=");
		sb.append(getCarRentalTotalCostRmb());
		sb.append(", carRentalTotalCostEur=");
		sb.append(getCarRentalTotalCostEur());
		sb.append(", remark=");
		sb.append(getRemark());
		sb.append(", otherEmails=");
		sb.append(getOtherEmails());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", sapStatus=");
		sb.append(getSapStatus());
		sb.append(", sapComments=");
		sb.append(getSapComments());
		sb.append(", sapDocumentId=");
		sb.append(getSapDocumentId());
		sb.append(", sapCertificateNo=");
		sb.append(getSapCertificateNo());
		sb.append(", sapCompany=");
		sb.append(getSapCompany());
		sb.append(", sapYear=");
		sb.append(getSapYear());
		sb.append(", statusByUserId=");
		sb.append(getStatusByUserId());
		sb.append(", statusByUserName=");
		sb.append(getStatusByUserName());
		sb.append(", statusDate=");
		sb.append(getStatusDate());
		sb.append(", isApplicantAgent=");
		sb.append(getIsApplicantAgent());
		sb.append(", isApproverAgent=");
		sb.append(getIsApproverAgent());
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
		sb.append(", submittedDate=");
		sb.append(getSubmittedDate());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(187);

		sb.append("<model><model-name>");
		sb.append("com.business.trip.model.BusinessTripApplication");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>businessTripApplicationId</column-name><column-value><![CDATA[");
		sb.append(getBusinessTripApplicationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ticketNo</column-name><column-value><![CDATA[");
		sb.append(getTicketNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>processType</column-name><column-value><![CDATA[");
		sb.append(getProcessType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subType</column-name><column-value><![CDATA[");
		sb.append(getSubType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>printName</column-name><column-value><![CDATA[");
		sb.append(getPrintName());
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
			"<column><column-name>personalID</column-name><column-value><![CDATA[");
		sb.append(getPersonalID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>passportNo</column-name><column-value><![CDATA[");
		sb.append(getPassportNo());
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
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>officeSite</column-name><column-value><![CDATA[");
		sb.append(getOfficeSite());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>approverId</column-name><column-value><![CDATA[");
		sb.append(getApproverId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>approverName</column-name><column-value><![CDATA[");
		sb.append(getApproverName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>evpId</column-name><column-value><![CDATA[");
		sb.append(getEvpId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>evpName</column-name><column-value><![CDATA[");
		sb.append(getEvpName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isCrossDepartment</column-name><column-value><![CDATA[");
		sb.append(getIsCrossDepartment());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>targetDepartmentId</column-name><column-value><![CDATA[");
		sb.append(getTargetDepartmentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>targetDepartmentName</column-name><column-value><![CDATA[");
		sb.append(getTargetDepartmentName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>targetCostCenter</column-name><column-value><![CDATA[");
		sb.append(getTargetCostCenter());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>targetDepartmentApproverId</column-name><column-value><![CDATA[");
		sb.append(getTargetDepartmentApproverId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>targetDepartmentApproverName</column-name><column-value><![CDATA[");
		sb.append(getTargetDepartmentApproverName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tripType</column-name><column-value><![CDATA[");
		sb.append(getTripType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>departureDate</column-name><column-value><![CDATA[");
		sb.append(getDepartureDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>returnDate</column-name><column-value><![CDATA[");
		sb.append(getReturnDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>purposeOfTheTrip</column-name><column-value><![CDATA[");
		sb.append(getPurposeOfTheTrip());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>visitCountriesCities</column-name><column-value><![CDATA[");
		sb.append(getVisitCountriesCities());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>advancePayment</column-name><column-value><![CDATA[");
		sb.append(getAdvancePayment());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currency</column-name><column-value><![CDATA[");
		sb.append(getCurrency());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>paymentMethods</column-name><column-value><![CDATA[");
		sb.append(getPaymentMethods());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalCostRmb</column-name><column-value><![CDATA[");
		sb.append(getTotalCostRmb());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalCostEur</column-name><column-value><![CDATA[");
		sb.append(getTotalCostEur());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hotelTotalCostRmb</column-name><column-value><![CDATA[");
		sb.append(getHotelTotalCostRmb());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hotelTotalCostEur</column-name><column-value><![CDATA[");
		sb.append(getHotelTotalCostEur());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>carRentalTotalCostRmb</column-name><column-value><![CDATA[");
		sb.append(getCarRentalTotalCostRmb());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>carRentalTotalCostEur</column-name><column-value><![CDATA[");
		sb.append(getCarRentalTotalCostEur());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>remark</column-name><column-value><![CDATA[");
		sb.append(getRemark());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>otherEmails</column-name><column-value><![CDATA[");
		sb.append(getOtherEmails());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sapStatus</column-name><column-value><![CDATA[");
		sb.append(getSapStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sapComments</column-name><column-value><![CDATA[");
		sb.append(getSapComments());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sapDocumentId</column-name><column-value><![CDATA[");
		sb.append(getSapDocumentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sapCertificateNo</column-name><column-value><![CDATA[");
		sb.append(getSapCertificateNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sapCompany</column-name><column-value><![CDATA[");
		sb.append(getSapCompany());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sapYear</column-name><column-value><![CDATA[");
		sb.append(getSapYear());
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
		sb.append(
			"<column><column-name>isApplicantAgent</column-name><column-value><![CDATA[");
		sb.append(getIsApplicantAgent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isApproverAgent</column-name><column-value><![CDATA[");
		sb.append(getIsApproverAgent());
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
			"<column><column-name>submittedDate</column-name><column-value><![CDATA[");
		sb.append(getSubmittedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _businessTripApplicationId;
	private String _ticketNo;
	private String _processType;
	private String _subType;
	private String _printName;
	private long _staffCode;
	private String _companyName;
	private String _division;
	private String _department;
	private String _costCenter;
	private String _personalID;
	private String _passportNo;
	private String _officePhone;
	private String _mobilePhone;
	private String _email;
	private String _officeSite;
	private long _approverId;
	private String _approverName;
	private long _evpId;
	private String _evpName;
	private boolean _isCrossDepartment;
	private long _targetDepartmentId;
	private String _targetDepartmentName;
	private String _targetCostCenter;
	private long _targetDepartmentApproverId;
	private String _targetDepartmentApproverName;
	private int _tripType;
	private Date _departureDate;
	private Date _returnDate;
	private String _purposeOfTheTrip;
	private String _visitCountriesCities;
	private double _advancePayment;
	private String _currency;
	private String _paymentMethods;
	private double _totalCostRmb;
	private double _totalCostEur;
	private double _hotelTotalCostRmb;
	private double _hotelTotalCostEur;
	private double _carRentalTotalCostRmb;
	private double _carRentalTotalCostEur;
	private String _remark;
	private String _otherEmails;
	private int _status;
	private int _sapStatus;
	private String _sapComments;
	private String _sapDocumentId;
	private String _sapCertificateNo;
	private String _sapCompany;
	private String _sapYear;
	private long _statusByUserId;
	private String _statusByUserUuid;
	private String _statusByUserName;
	private Date _statusDate;
	private boolean _isApplicantAgent;
	private boolean _isApproverAgent;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _submittedDate;
	private long _companyId;
	private BaseModel<?> _businessTripApplicationRemoteModel;
	private Class<?> _clpSerializerClass = com.business.trip.service.ClpSerializer.class;
}