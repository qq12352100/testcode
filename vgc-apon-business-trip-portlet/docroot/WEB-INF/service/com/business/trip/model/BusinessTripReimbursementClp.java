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

import com.business.trip.service.BusinessTripReimbursementLocalServiceUtil;
import com.business.trip.service.ClpSerializer;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
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
public class BusinessTripReimbursementClp extends BaseModelImpl<BusinessTripReimbursement>
	implements BusinessTripReimbursement {
	public BusinessTripReimbursementClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return BusinessTripReimbursement.class;
	}

	@Override
	public String getModelClassName() {
		return BusinessTripReimbursement.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _businessTripReimbursementId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBusinessTripReimbursementId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _businessTripReimbursementId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("businessTripReimbursementId",
			getBusinessTripReimbursementId());
		attributes.put("ticketNo", getTicketNo());
		attributes.put("bussinessTirpTicketNo", getBussinessTirpTicketNo());
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
		attributes.put("orgTotalCostRmb", getOrgTotalCostRmb());
		attributes.put("orgTotalCostEur", getOrgTotalCostEur());
		attributes.put("hotelTotalCostRmb", getHotelTotalCostRmb());
		attributes.put("hotelTotalCostEur", getHotelTotalCostEur());
		attributes.put("carRentalTotalCostRmb", getCarRentalTotalCostRmb());
		attributes.put("carRentalTotalCostEur", getCarRentalTotalCostEur());
		attributes.put("flightCurrency", getFlightCurrency());
		attributes.put("flightTotal", getFlightTotal());
		attributes.put("flightAirFare", getFlightAirFare());
		attributes.put("flightTaxes", getFlightTaxes());
		attributes.put("flightTransactionFee", getFlightTransactionFee());
		attributes.put("totalTravelExpenseRmb", getTotalTravelExpenseRmb());
		attributes.put("totalTravelExpenseEur", getTotalTravelExpenseEur());
		attributes.put("costListInlandTotalRmb", getCostListInlandTotalRmb());
		attributes.put("costListForeignTotalEur", getCostListForeignTotalEur());
		attributes.put("costListForeignTotalRmb", getCostListForeignTotalRmb());
		attributes.put("remark", getRemark());
		attributes.put("isPaybyRmb", getIsPaybyRmb());
		attributes.put("evpId", getEvpId());
		attributes.put("evpName", getEvpName());
		attributes.put("status", getStatus());
		attributes.put("sapStatus", getSapStatus());
		attributes.put("sapComments", getSapComments());
		attributes.put("sapDocumentId", getSapDocumentId());
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
		Long businessTripReimbursementId = (Long)attributes.get(
				"businessTripReimbursementId");

		if (businessTripReimbursementId != null) {
			setBusinessTripReimbursementId(businessTripReimbursementId);
		}

		String ticketNo = (String)attributes.get("ticketNo");

		if (ticketNo != null) {
			setTicketNo(ticketNo);
		}

		String bussinessTirpTicketNo = (String)attributes.get(
				"bussinessTirpTicketNo");

		if (bussinessTirpTicketNo != null) {
			setBussinessTirpTicketNo(bussinessTirpTicketNo);
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

		Double orgTotalCostRmb = (Double)attributes.get("orgTotalCostRmb");

		if (orgTotalCostRmb != null) {
			setOrgTotalCostRmb(orgTotalCostRmb);
		}

		Double orgTotalCostEur = (Double)attributes.get("orgTotalCostEur");

		if (orgTotalCostEur != null) {
			setOrgTotalCostEur(orgTotalCostEur);
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

		String flightCurrency = (String)attributes.get("flightCurrency");

		if (flightCurrency != null) {
			setFlightCurrency(flightCurrency);
		}

		Double flightTotal = (Double)attributes.get("flightTotal");

		if (flightTotal != null) {
			setFlightTotal(flightTotal);
		}

		Double flightAirFare = (Double)attributes.get("flightAirFare");

		if (flightAirFare != null) {
			setFlightAirFare(flightAirFare);
		}

		Double flightTaxes = (Double)attributes.get("flightTaxes");

		if (flightTaxes != null) {
			setFlightTaxes(flightTaxes);
		}

		Double flightTransactionFee = (Double)attributes.get(
				"flightTransactionFee");

		if (flightTransactionFee != null) {
			setFlightTransactionFee(flightTransactionFee);
		}

		Double totalTravelExpenseRmb = (Double)attributes.get(
				"totalTravelExpenseRmb");

		if (totalTravelExpenseRmb != null) {
			setTotalTravelExpenseRmb(totalTravelExpenseRmb);
		}

		Double totalTravelExpenseEur = (Double)attributes.get(
				"totalTravelExpenseEur");

		if (totalTravelExpenseEur != null) {
			setTotalTravelExpenseEur(totalTravelExpenseEur);
		}

		Double costListInlandTotalRmb = (Double)attributes.get(
				"costListInlandTotalRmb");

		if (costListInlandTotalRmb != null) {
			setCostListInlandTotalRmb(costListInlandTotalRmb);
		}

		Double costListForeignTotalEur = (Double)attributes.get(
				"costListForeignTotalEur");

		if (costListForeignTotalEur != null) {
			setCostListForeignTotalEur(costListForeignTotalEur);
		}

		Double costListForeignTotalRmb = (Double)attributes.get(
				"costListForeignTotalRmb");

		if (costListForeignTotalRmb != null) {
			setCostListForeignTotalRmb(costListForeignTotalRmb);
		}

		String remark = (String)attributes.get("remark");

		if (remark != null) {
			setRemark(remark);
		}

		Boolean isPaybyRmb = (Boolean)attributes.get("isPaybyRmb");

		if (isPaybyRmb != null) {
			setIsPaybyRmb(isPaybyRmb);
		}

		Long evpId = (Long)attributes.get("evpId");

		if (evpId != null) {
			setEvpId(evpId);
		}

		String evpName = (String)attributes.get("evpName");

		if (evpName != null) {
			setEvpName(evpName);
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
	public long getBusinessTripReimbursementId() {
		return _businessTripReimbursementId;
	}

	@Override
	public void setBusinessTripReimbursementId(long businessTripReimbursementId) {
		_businessTripReimbursementId = businessTripReimbursementId;

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setBusinessTripReimbursementId",
						long.class);

				method.invoke(_businessTripReimbursementRemoteModel,
					businessTripReimbursementId);
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

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setTicketNo", String.class);

				method.invoke(_businessTripReimbursementRemoteModel, ticketNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBussinessTirpTicketNo() {
		return _bussinessTirpTicketNo;
	}

	@Override
	public void setBussinessTirpTicketNo(String bussinessTirpTicketNo) {
		_bussinessTirpTicketNo = bussinessTirpTicketNo;

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setBussinessTirpTicketNo",
						String.class);

				method.invoke(_businessTripReimbursementRemoteModel,
					bussinessTirpTicketNo);
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

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setProcessType", String.class);

				method.invoke(_businessTripReimbursementRemoteModel, processType);
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

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setSubType", String.class);

				method.invoke(_businessTripReimbursementRemoteModel, subType);
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

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setPrintName", String.class);

				method.invoke(_businessTripReimbursementRemoteModel, printName);
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

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setStaffCode", long.class);

				method.invoke(_businessTripReimbursementRemoteModel, staffCode);
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

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyName", String.class);

				method.invoke(_businessTripReimbursementRemoteModel, companyName);
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

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setDivision", String.class);

				method.invoke(_businessTripReimbursementRemoteModel, division);
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

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setDepartment", String.class);

				method.invoke(_businessTripReimbursementRemoteModel, department);
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

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setCostCenter", String.class);

				method.invoke(_businessTripReimbursementRemoteModel, costCenter);
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

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setPersonalID", String.class);

				method.invoke(_businessTripReimbursementRemoteModel, personalID);
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

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setPassportNo", String.class);

				method.invoke(_businessTripReimbursementRemoteModel, passportNo);
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

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setOfficePhone", String.class);

				method.invoke(_businessTripReimbursementRemoteModel, officePhone);
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

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setMobilePhone", String.class);

				method.invoke(_businessTripReimbursementRemoteModel, mobilePhone);
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

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setEmail", String.class);

				method.invoke(_businessTripReimbursementRemoteModel, email);
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

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setOfficeSite", String.class);

				method.invoke(_businessTripReimbursementRemoteModel, officeSite);
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

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setApproverId", long.class);

				method.invoke(_businessTripReimbursementRemoteModel, approverId);
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

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setApproverName", String.class);

				method.invoke(_businessTripReimbursementRemoteModel,
					approverName);
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

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setIsCrossDepartment",
						boolean.class);

				method.invoke(_businessTripReimbursementRemoteModel,
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

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setTargetDepartmentId",
						long.class);

				method.invoke(_businessTripReimbursementRemoteModel,
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

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setTargetDepartmentName",
						String.class);

				method.invoke(_businessTripReimbursementRemoteModel,
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

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setTargetCostCenter",
						String.class);

				method.invoke(_businessTripReimbursementRemoteModel,
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

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setTargetDepartmentApproverId",
						long.class);

				method.invoke(_businessTripReimbursementRemoteModel,
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

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setTargetDepartmentApproverName",
						String.class);

				method.invoke(_businessTripReimbursementRemoteModel,
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

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setTripType", int.class);

				method.invoke(_businessTripReimbursementRemoteModel, tripType);
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

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setDepartureDate", Date.class);

				method.invoke(_businessTripReimbursementRemoteModel,
					departureDate);
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

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setReturnDate", Date.class);

				method.invoke(_businessTripReimbursementRemoteModel, returnDate);
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

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setPurposeOfTheTrip",
						String.class);

				method.invoke(_businessTripReimbursementRemoteModel,
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

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setVisitCountriesCities",
						String.class);

				method.invoke(_businessTripReimbursementRemoteModel,
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

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setAdvancePayment",
						double.class);

				method.invoke(_businessTripReimbursementRemoteModel,
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

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setCurrency", String.class);

				method.invoke(_businessTripReimbursementRemoteModel, currency);
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

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setPaymentMethods",
						String.class);

				method.invoke(_businessTripReimbursementRemoteModel,
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

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setTotalCostRmb", double.class);

				method.invoke(_businessTripReimbursementRemoteModel,
					totalCostRmb);
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

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setTotalCostEur", double.class);

				method.invoke(_businessTripReimbursementRemoteModel,
					totalCostEur);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getOrgTotalCostRmb() {
		return _orgTotalCostRmb;
	}

	@Override
	public void setOrgTotalCostRmb(double orgTotalCostRmb) {
		_orgTotalCostRmb = orgTotalCostRmb;

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setOrgTotalCostRmb",
						double.class);

				method.invoke(_businessTripReimbursementRemoteModel,
					orgTotalCostRmb);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getOrgTotalCostEur() {
		return _orgTotalCostEur;
	}

	@Override
	public void setOrgTotalCostEur(double orgTotalCostEur) {
		_orgTotalCostEur = orgTotalCostEur;

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setOrgTotalCostEur",
						double.class);

				method.invoke(_businessTripReimbursementRemoteModel,
					orgTotalCostEur);
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

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setHotelTotalCostRmb",
						double.class);

				method.invoke(_businessTripReimbursementRemoteModel,
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

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setHotelTotalCostEur",
						double.class);

				method.invoke(_businessTripReimbursementRemoteModel,
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

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setCarRentalTotalCostRmb",
						double.class);

				method.invoke(_businessTripReimbursementRemoteModel,
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

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setCarRentalTotalCostEur",
						double.class);

				method.invoke(_businessTripReimbursementRemoteModel,
					carRentalTotalCostEur);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFlightCurrency() {
		return _flightCurrency;
	}

	@Override
	public void setFlightCurrency(String flightCurrency) {
		_flightCurrency = flightCurrency;

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setFlightCurrency",
						String.class);

				method.invoke(_businessTripReimbursementRemoteModel,
					flightCurrency);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getFlightTotal() {
		return _flightTotal;
	}

	@Override
	public void setFlightTotal(double flightTotal) {
		_flightTotal = flightTotal;

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setFlightTotal", double.class);

				method.invoke(_businessTripReimbursementRemoteModel, flightTotal);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getFlightAirFare() {
		return _flightAirFare;
	}

	@Override
	public void setFlightAirFare(double flightAirFare) {
		_flightAirFare = flightAirFare;

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setFlightAirFare", double.class);

				method.invoke(_businessTripReimbursementRemoteModel,
					flightAirFare);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getFlightTaxes() {
		return _flightTaxes;
	}

	@Override
	public void setFlightTaxes(double flightTaxes) {
		_flightTaxes = flightTaxes;

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setFlightTaxes", double.class);

				method.invoke(_businessTripReimbursementRemoteModel, flightTaxes);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getFlightTransactionFee() {
		return _flightTransactionFee;
	}

	@Override
	public void setFlightTransactionFee(double flightTransactionFee) {
		_flightTransactionFee = flightTransactionFee;

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setFlightTransactionFee",
						double.class);

				method.invoke(_businessTripReimbursementRemoteModel,
					flightTransactionFee);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getTotalTravelExpenseRmb() {
		return _totalTravelExpenseRmb;
	}

	@Override
	public void setTotalTravelExpenseRmb(double totalTravelExpenseRmb) {
		_totalTravelExpenseRmb = totalTravelExpenseRmb;

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setTotalTravelExpenseRmb",
						double.class);

				method.invoke(_businessTripReimbursementRemoteModel,
					totalTravelExpenseRmb);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getTotalTravelExpenseEur() {
		return _totalTravelExpenseEur;
	}

	@Override
	public void setTotalTravelExpenseEur(double totalTravelExpenseEur) {
		_totalTravelExpenseEur = totalTravelExpenseEur;

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setTotalTravelExpenseEur",
						double.class);

				method.invoke(_businessTripReimbursementRemoteModel,
					totalTravelExpenseEur);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getCostListInlandTotalRmb() {
		return _costListInlandTotalRmb;
	}

	@Override
	public void setCostListInlandTotalRmb(double costListInlandTotalRmb) {
		_costListInlandTotalRmb = costListInlandTotalRmb;

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setCostListInlandTotalRmb",
						double.class);

				method.invoke(_businessTripReimbursementRemoteModel,
					costListInlandTotalRmb);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getCostListForeignTotalEur() {
		return _costListForeignTotalEur;
	}

	@Override
	public void setCostListForeignTotalEur(double costListForeignTotalEur) {
		_costListForeignTotalEur = costListForeignTotalEur;

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setCostListForeignTotalEur",
						double.class);

				method.invoke(_businessTripReimbursementRemoteModel,
					costListForeignTotalEur);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getCostListForeignTotalRmb() {
		return _costListForeignTotalRmb;
	}

	@Override
	public void setCostListForeignTotalRmb(double costListForeignTotalRmb) {
		_costListForeignTotalRmb = costListForeignTotalRmb;

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setCostListForeignTotalRmb",
						double.class);

				method.invoke(_businessTripReimbursementRemoteModel,
					costListForeignTotalRmb);
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

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setRemark", String.class);

				method.invoke(_businessTripReimbursementRemoteModel, remark);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsPaybyRmb() {
		return _isPaybyRmb;
	}

	@Override
	public boolean isIsPaybyRmb() {
		return _isPaybyRmb;
	}

	@Override
	public void setIsPaybyRmb(boolean isPaybyRmb) {
		_isPaybyRmb = isPaybyRmb;

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setIsPaybyRmb", boolean.class);

				method.invoke(_businessTripReimbursementRemoteModel, isPaybyRmb);
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

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setEvpId", long.class);

				method.invoke(_businessTripReimbursementRemoteModel, evpId);
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

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setEvpName", String.class);

				method.invoke(_businessTripReimbursementRemoteModel, evpName);
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

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_businessTripReimbursementRemoteModel, status);
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

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setSapStatus", int.class);

				method.invoke(_businessTripReimbursementRemoteModel, sapStatus);
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

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setSapComments", String.class);

				method.invoke(_businessTripReimbursementRemoteModel, sapComments);
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

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setSapDocumentId", String.class);

				method.invoke(_businessTripReimbursementRemoteModel,
					sapDocumentId);
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

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusByUserId", long.class);

				method.invoke(_businessTripReimbursementRemoteModel,
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

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusByUserName",
						String.class);

				method.invoke(_businessTripReimbursementRemoteModel,
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

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusDate", Date.class);

				method.invoke(_businessTripReimbursementRemoteModel, statusDate);
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

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setIsApplicantAgent",
						boolean.class);

				method.invoke(_businessTripReimbursementRemoteModel,
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

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setIsApproverAgent",
						boolean.class);

				method.invoke(_businessTripReimbursementRemoteModel,
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

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_businessTripReimbursementRemoteModel, groupId);
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

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_businessTripReimbursementRemoteModel, userId);
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

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_businessTripReimbursementRemoteModel, userName);
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

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_businessTripReimbursementRemoteModel, createDate);
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

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_businessTripReimbursementRemoteModel,
					modifiedDate);
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

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setSubmittedDate", Date.class);

				method.invoke(_businessTripReimbursementRemoteModel,
					submittedDate);
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

		if (_businessTripReimbursementRemoteModel != null) {
			try {
				Class<?> clazz = _businessTripReimbursementRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_businessTripReimbursementRemoteModel, companyId);
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

	public BaseModel<?> getBusinessTripReimbursementRemoteModel() {
		return _businessTripReimbursementRemoteModel;
	}

	public void setBusinessTripReimbursementRemoteModel(
		BaseModel<?> businessTripReimbursementRemoteModel) {
		_businessTripReimbursementRemoteModel = businessTripReimbursementRemoteModel;
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

		Class<?> remoteModelClass = _businessTripReimbursementRemoteModel.getClass();

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

		Object returnValue = method.invoke(_businessTripReimbursementRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			BusinessTripReimbursementLocalServiceUtil.addBusinessTripReimbursement(this);
		}
		else {
			BusinessTripReimbursementLocalServiceUtil.updateBusinessTripReimbursement(this);
		}
	}

	@Override
	public BusinessTripReimbursement toEscapedModel() {
		return (BusinessTripReimbursement)ProxyUtil.newProxyInstance(BusinessTripReimbursement.class.getClassLoader(),
			new Class[] { BusinessTripReimbursement.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BusinessTripReimbursementClp clone = new BusinessTripReimbursementClp();

		clone.setBusinessTripReimbursementId(getBusinessTripReimbursementId());
		clone.setTicketNo(getTicketNo());
		clone.setBussinessTirpTicketNo(getBussinessTirpTicketNo());
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
		clone.setOrgTotalCostRmb(getOrgTotalCostRmb());
		clone.setOrgTotalCostEur(getOrgTotalCostEur());
		clone.setHotelTotalCostRmb(getHotelTotalCostRmb());
		clone.setHotelTotalCostEur(getHotelTotalCostEur());
		clone.setCarRentalTotalCostRmb(getCarRentalTotalCostRmb());
		clone.setCarRentalTotalCostEur(getCarRentalTotalCostEur());
		clone.setFlightCurrency(getFlightCurrency());
		clone.setFlightTotal(getFlightTotal());
		clone.setFlightAirFare(getFlightAirFare());
		clone.setFlightTaxes(getFlightTaxes());
		clone.setFlightTransactionFee(getFlightTransactionFee());
		clone.setTotalTravelExpenseRmb(getTotalTravelExpenseRmb());
		clone.setTotalTravelExpenseEur(getTotalTravelExpenseEur());
		clone.setCostListInlandTotalRmb(getCostListInlandTotalRmb());
		clone.setCostListForeignTotalEur(getCostListForeignTotalEur());
		clone.setCostListForeignTotalRmb(getCostListForeignTotalRmb());
		clone.setRemark(getRemark());
		clone.setIsPaybyRmb(getIsPaybyRmb());
		clone.setEvpId(getEvpId());
		clone.setEvpName(getEvpName());
		clone.setStatus(getStatus());
		clone.setSapStatus(getSapStatus());
		clone.setSapComments(getSapComments());
		clone.setSapDocumentId(getSapDocumentId());
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
	public int compareTo(BusinessTripReimbursement businessTripReimbursement) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(),
				businessTripReimbursement.getCreateDate());

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

		if (!(obj instanceof BusinessTripReimbursementClp)) {
			return false;
		}

		BusinessTripReimbursementClp businessTripReimbursement = (BusinessTripReimbursementClp)obj;

		long primaryKey = businessTripReimbursement.getPrimaryKey();

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
		StringBundler sb = new StringBundler(143);

		sb.append("{businessTripReimbursementId=");
		sb.append(getBusinessTripReimbursementId());
		sb.append(", ticketNo=");
		sb.append(getTicketNo());
		sb.append(", bussinessTirpTicketNo=");
		sb.append(getBussinessTirpTicketNo());
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
		sb.append(", orgTotalCostRmb=");
		sb.append(getOrgTotalCostRmb());
		sb.append(", orgTotalCostEur=");
		sb.append(getOrgTotalCostEur());
		sb.append(", hotelTotalCostRmb=");
		sb.append(getHotelTotalCostRmb());
		sb.append(", hotelTotalCostEur=");
		sb.append(getHotelTotalCostEur());
		sb.append(", carRentalTotalCostRmb=");
		sb.append(getCarRentalTotalCostRmb());
		sb.append(", carRentalTotalCostEur=");
		sb.append(getCarRentalTotalCostEur());
		sb.append(", flightCurrency=");
		sb.append(getFlightCurrency());
		sb.append(", flightTotal=");
		sb.append(getFlightTotal());
		sb.append(", flightAirFare=");
		sb.append(getFlightAirFare());
		sb.append(", flightTaxes=");
		sb.append(getFlightTaxes());
		sb.append(", flightTransactionFee=");
		sb.append(getFlightTransactionFee());
		sb.append(", totalTravelExpenseRmb=");
		sb.append(getTotalTravelExpenseRmb());
		sb.append(", totalTravelExpenseEur=");
		sb.append(getTotalTravelExpenseEur());
		sb.append(", costListInlandTotalRmb=");
		sb.append(getCostListInlandTotalRmb());
		sb.append(", costListForeignTotalEur=");
		sb.append(getCostListForeignTotalEur());
		sb.append(", costListForeignTotalRmb=");
		sb.append(getCostListForeignTotalRmb());
		sb.append(", remark=");
		sb.append(getRemark());
		sb.append(", isPaybyRmb=");
		sb.append(getIsPaybyRmb());
		sb.append(", evpId=");
		sb.append(getEvpId());
		sb.append(", evpName=");
		sb.append(getEvpName());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", sapStatus=");
		sb.append(getSapStatus());
		sb.append(", sapComments=");
		sb.append(getSapComments());
		sb.append(", sapDocumentId=");
		sb.append(getSapDocumentId());
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
		StringBundler sb = new StringBundler(217);

		sb.append("<model><model-name>");
		sb.append("com.business.trip.model.BusinessTripReimbursement");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>businessTripReimbursementId</column-name><column-value><![CDATA[");
		sb.append(getBusinessTripReimbursementId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ticketNo</column-name><column-value><![CDATA[");
		sb.append(getTicketNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bussinessTirpTicketNo</column-name><column-value><![CDATA[");
		sb.append(getBussinessTirpTicketNo());
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
			"<column><column-name>orgTotalCostRmb</column-name><column-value><![CDATA[");
		sb.append(getOrgTotalCostRmb());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orgTotalCostEur</column-name><column-value><![CDATA[");
		sb.append(getOrgTotalCostEur());
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
			"<column><column-name>flightCurrency</column-name><column-value><![CDATA[");
		sb.append(getFlightCurrency());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>flightTotal</column-name><column-value><![CDATA[");
		sb.append(getFlightTotal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>flightAirFare</column-name><column-value><![CDATA[");
		sb.append(getFlightAirFare());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>flightTaxes</column-name><column-value><![CDATA[");
		sb.append(getFlightTaxes());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>flightTransactionFee</column-name><column-value><![CDATA[");
		sb.append(getFlightTransactionFee());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalTravelExpenseRmb</column-name><column-value><![CDATA[");
		sb.append(getTotalTravelExpenseRmb());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalTravelExpenseEur</column-name><column-value><![CDATA[");
		sb.append(getTotalTravelExpenseEur());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>costListInlandTotalRmb</column-name><column-value><![CDATA[");
		sb.append(getCostListInlandTotalRmb());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>costListForeignTotalEur</column-name><column-value><![CDATA[");
		sb.append(getCostListForeignTotalEur());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>costListForeignTotalRmb</column-name><column-value><![CDATA[");
		sb.append(getCostListForeignTotalRmb());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>remark</column-name><column-value><![CDATA[");
		sb.append(getRemark());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isPaybyRmb</column-name><column-value><![CDATA[");
		sb.append(getIsPaybyRmb());
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

	private long _businessTripReimbursementId;
	private String _ticketNo;
	private String _bussinessTirpTicketNo;
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
	private double _orgTotalCostRmb;
	private double _orgTotalCostEur;
	private double _hotelTotalCostRmb;
	private double _hotelTotalCostEur;
	private double _carRentalTotalCostRmb;
	private double _carRentalTotalCostEur;
	private String _flightCurrency;
	private double _flightTotal;
	private double _flightAirFare;
	private double _flightTaxes;
	private double _flightTransactionFee;
	private double _totalTravelExpenseRmb;
	private double _totalTravelExpenseEur;
	private double _costListInlandTotalRmb;
	private double _costListForeignTotalEur;
	private double _costListForeignTotalRmb;
	private String _remark;
	private boolean _isPaybyRmb;
	private long _evpId;
	private String _evpName;
	private int _status;
	private int _sapStatus;
	private String _sapComments;
	private String _sapDocumentId;
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
	private BaseModel<?> _businessTripReimbursementRemoteModel;
	private Class<?> _clpSerializerClass = com.business.trip.service.ClpSerializer.class;
}