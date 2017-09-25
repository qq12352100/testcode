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
 * This class is a wrapper for {@link BusinessTripReimbursement}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BusinessTripReimbursement
 * @generated
 */
public class BusinessTripReimbursementWrapper
	implements BusinessTripReimbursement,
		ModelWrapper<BusinessTripReimbursement> {
	public BusinessTripReimbursementWrapper(
		BusinessTripReimbursement businessTripReimbursement) {
		_businessTripReimbursement = businessTripReimbursement;
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

	/**
	* Returns the primary key of this business trip reimbursement.
	*
	* @return the primary key of this business trip reimbursement
	*/
	@Override
	public long getPrimaryKey() {
		return _businessTripReimbursement.getPrimaryKey();
	}

	/**
	* Sets the primary key of this business trip reimbursement.
	*
	* @param primaryKey the primary key of this business trip reimbursement
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_businessTripReimbursement.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the business trip reimbursement ID of this business trip reimbursement.
	*
	* @return the business trip reimbursement ID of this business trip reimbursement
	*/
	@Override
	public long getBusinessTripReimbursementId() {
		return _businessTripReimbursement.getBusinessTripReimbursementId();
	}

	/**
	* Sets the business trip reimbursement ID of this business trip reimbursement.
	*
	* @param businessTripReimbursementId the business trip reimbursement ID of this business trip reimbursement
	*/
	@Override
	public void setBusinessTripReimbursementId(long businessTripReimbursementId) {
		_businessTripReimbursement.setBusinessTripReimbursementId(businessTripReimbursementId);
	}

	/**
	* Returns the ticket no of this business trip reimbursement.
	*
	* @return the ticket no of this business trip reimbursement
	*/
	@Override
	public java.lang.String getTicketNo() {
		return _businessTripReimbursement.getTicketNo();
	}

	/**
	* Sets the ticket no of this business trip reimbursement.
	*
	* @param ticketNo the ticket no of this business trip reimbursement
	*/
	@Override
	public void setTicketNo(java.lang.String ticketNo) {
		_businessTripReimbursement.setTicketNo(ticketNo);
	}

	/**
	* Returns the bussiness tirp ticket no of this business trip reimbursement.
	*
	* @return the bussiness tirp ticket no of this business trip reimbursement
	*/
	@Override
	public java.lang.String getBussinessTirpTicketNo() {
		return _businessTripReimbursement.getBussinessTirpTicketNo();
	}

	/**
	* Sets the bussiness tirp ticket no of this business trip reimbursement.
	*
	* @param bussinessTirpTicketNo the bussiness tirp ticket no of this business trip reimbursement
	*/
	@Override
	public void setBussinessTirpTicketNo(java.lang.String bussinessTirpTicketNo) {
		_businessTripReimbursement.setBussinessTirpTicketNo(bussinessTirpTicketNo);
	}

	/**
	* Returns the process type of this business trip reimbursement.
	*
	* @return the process type of this business trip reimbursement
	*/
	@Override
	public java.lang.String getProcessType() {
		return _businessTripReimbursement.getProcessType();
	}

	/**
	* Sets the process type of this business trip reimbursement.
	*
	* @param processType the process type of this business trip reimbursement
	*/
	@Override
	public void setProcessType(java.lang.String processType) {
		_businessTripReimbursement.setProcessType(processType);
	}

	/**
	* Returns the sub type of this business trip reimbursement.
	*
	* @return the sub type of this business trip reimbursement
	*/
	@Override
	public java.lang.String getSubType() {
		return _businessTripReimbursement.getSubType();
	}

	/**
	* Sets the sub type of this business trip reimbursement.
	*
	* @param subType the sub type of this business trip reimbursement
	*/
	@Override
	public void setSubType(java.lang.String subType) {
		_businessTripReimbursement.setSubType(subType);
	}

	/**
	* Returns the print name of this business trip reimbursement.
	*
	* @return the print name of this business trip reimbursement
	*/
	@Override
	public java.lang.String getPrintName() {
		return _businessTripReimbursement.getPrintName();
	}

	/**
	* Sets the print name of this business trip reimbursement.
	*
	* @param printName the print name of this business trip reimbursement
	*/
	@Override
	public void setPrintName(java.lang.String printName) {
		_businessTripReimbursement.setPrintName(printName);
	}

	/**
	* Returns the staff code of this business trip reimbursement.
	*
	* @return the staff code of this business trip reimbursement
	*/
	@Override
	public long getStaffCode() {
		return _businessTripReimbursement.getStaffCode();
	}

	/**
	* Sets the staff code of this business trip reimbursement.
	*
	* @param staffCode the staff code of this business trip reimbursement
	*/
	@Override
	public void setStaffCode(long staffCode) {
		_businessTripReimbursement.setStaffCode(staffCode);
	}

	/**
	* Returns the company name of this business trip reimbursement.
	*
	* @return the company name of this business trip reimbursement
	*/
	@Override
	public java.lang.String getCompanyName() {
		return _businessTripReimbursement.getCompanyName();
	}

	/**
	* Sets the company name of this business trip reimbursement.
	*
	* @param companyName the company name of this business trip reimbursement
	*/
	@Override
	public void setCompanyName(java.lang.String companyName) {
		_businessTripReimbursement.setCompanyName(companyName);
	}

	/**
	* Returns the division of this business trip reimbursement.
	*
	* @return the division of this business trip reimbursement
	*/
	@Override
	public java.lang.String getDivision() {
		return _businessTripReimbursement.getDivision();
	}

	/**
	* Sets the division of this business trip reimbursement.
	*
	* @param division the division of this business trip reimbursement
	*/
	@Override
	public void setDivision(java.lang.String division) {
		_businessTripReimbursement.setDivision(division);
	}

	/**
	* Returns the department of this business trip reimbursement.
	*
	* @return the department of this business trip reimbursement
	*/
	@Override
	public java.lang.String getDepartment() {
		return _businessTripReimbursement.getDepartment();
	}

	/**
	* Sets the department of this business trip reimbursement.
	*
	* @param department the department of this business trip reimbursement
	*/
	@Override
	public void setDepartment(java.lang.String department) {
		_businessTripReimbursement.setDepartment(department);
	}

	/**
	* Returns the cost center of this business trip reimbursement.
	*
	* @return the cost center of this business trip reimbursement
	*/
	@Override
	public java.lang.String getCostCenter() {
		return _businessTripReimbursement.getCostCenter();
	}

	/**
	* Sets the cost center of this business trip reimbursement.
	*
	* @param costCenter the cost center of this business trip reimbursement
	*/
	@Override
	public void setCostCenter(java.lang.String costCenter) {
		_businessTripReimbursement.setCostCenter(costCenter);
	}

	/**
	* Returns the personal i d of this business trip reimbursement.
	*
	* @return the personal i d of this business trip reimbursement
	*/
	@Override
	public java.lang.String getPersonalID() {
		return _businessTripReimbursement.getPersonalID();
	}

	/**
	* Sets the personal i d of this business trip reimbursement.
	*
	* @param personalID the personal i d of this business trip reimbursement
	*/
	@Override
	public void setPersonalID(java.lang.String personalID) {
		_businessTripReimbursement.setPersonalID(personalID);
	}

	/**
	* Returns the passport no of this business trip reimbursement.
	*
	* @return the passport no of this business trip reimbursement
	*/
	@Override
	public java.lang.String getPassportNo() {
		return _businessTripReimbursement.getPassportNo();
	}

	/**
	* Sets the passport no of this business trip reimbursement.
	*
	* @param passportNo the passport no of this business trip reimbursement
	*/
	@Override
	public void setPassportNo(java.lang.String passportNo) {
		_businessTripReimbursement.setPassportNo(passportNo);
	}

	/**
	* Returns the office phone of this business trip reimbursement.
	*
	* @return the office phone of this business trip reimbursement
	*/
	@Override
	public java.lang.String getOfficePhone() {
		return _businessTripReimbursement.getOfficePhone();
	}

	/**
	* Sets the office phone of this business trip reimbursement.
	*
	* @param officePhone the office phone of this business trip reimbursement
	*/
	@Override
	public void setOfficePhone(java.lang.String officePhone) {
		_businessTripReimbursement.setOfficePhone(officePhone);
	}

	/**
	* Returns the mobile phone of this business trip reimbursement.
	*
	* @return the mobile phone of this business trip reimbursement
	*/
	@Override
	public java.lang.String getMobilePhone() {
		return _businessTripReimbursement.getMobilePhone();
	}

	/**
	* Sets the mobile phone of this business trip reimbursement.
	*
	* @param mobilePhone the mobile phone of this business trip reimbursement
	*/
	@Override
	public void setMobilePhone(java.lang.String mobilePhone) {
		_businessTripReimbursement.setMobilePhone(mobilePhone);
	}

	/**
	* Returns the email of this business trip reimbursement.
	*
	* @return the email of this business trip reimbursement
	*/
	@Override
	public java.lang.String getEmail() {
		return _businessTripReimbursement.getEmail();
	}

	/**
	* Sets the email of this business trip reimbursement.
	*
	* @param email the email of this business trip reimbursement
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_businessTripReimbursement.setEmail(email);
	}

	/**
	* Returns the office site of this business trip reimbursement.
	*
	* @return the office site of this business trip reimbursement
	*/
	@Override
	public java.lang.String getOfficeSite() {
		return _businessTripReimbursement.getOfficeSite();
	}

	/**
	* Sets the office site of this business trip reimbursement.
	*
	* @param officeSite the office site of this business trip reimbursement
	*/
	@Override
	public void setOfficeSite(java.lang.String officeSite) {
		_businessTripReimbursement.setOfficeSite(officeSite);
	}

	/**
	* Returns the approver ID of this business trip reimbursement.
	*
	* @return the approver ID of this business trip reimbursement
	*/
	@Override
	public long getApproverId() {
		return _businessTripReimbursement.getApproverId();
	}

	/**
	* Sets the approver ID of this business trip reimbursement.
	*
	* @param approverId the approver ID of this business trip reimbursement
	*/
	@Override
	public void setApproverId(long approverId) {
		_businessTripReimbursement.setApproverId(approverId);
	}

	/**
	* Returns the approver name of this business trip reimbursement.
	*
	* @return the approver name of this business trip reimbursement
	*/
	@Override
	public java.lang.String getApproverName() {
		return _businessTripReimbursement.getApproverName();
	}

	/**
	* Sets the approver name of this business trip reimbursement.
	*
	* @param approverName the approver name of this business trip reimbursement
	*/
	@Override
	public void setApproverName(java.lang.String approverName) {
		_businessTripReimbursement.setApproverName(approverName);
	}

	/**
	* Returns the is cross department of this business trip reimbursement.
	*
	* @return the is cross department of this business trip reimbursement
	*/
	@Override
	public boolean getIsCrossDepartment() {
		return _businessTripReimbursement.getIsCrossDepartment();
	}

	/**
	* Returns <code>true</code> if this business trip reimbursement is is cross department.
	*
	* @return <code>true</code> if this business trip reimbursement is is cross department; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsCrossDepartment() {
		return _businessTripReimbursement.isIsCrossDepartment();
	}

	/**
	* Sets whether this business trip reimbursement is is cross department.
	*
	* @param isCrossDepartment the is cross department of this business trip reimbursement
	*/
	@Override
	public void setIsCrossDepartment(boolean isCrossDepartment) {
		_businessTripReimbursement.setIsCrossDepartment(isCrossDepartment);
	}

	/**
	* Returns the target department ID of this business trip reimbursement.
	*
	* @return the target department ID of this business trip reimbursement
	*/
	@Override
	public long getTargetDepartmentId() {
		return _businessTripReimbursement.getTargetDepartmentId();
	}

	/**
	* Sets the target department ID of this business trip reimbursement.
	*
	* @param targetDepartmentId the target department ID of this business trip reimbursement
	*/
	@Override
	public void setTargetDepartmentId(long targetDepartmentId) {
		_businessTripReimbursement.setTargetDepartmentId(targetDepartmentId);
	}

	/**
	* Returns the target department name of this business trip reimbursement.
	*
	* @return the target department name of this business trip reimbursement
	*/
	@Override
	public java.lang.String getTargetDepartmentName() {
		return _businessTripReimbursement.getTargetDepartmentName();
	}

	/**
	* Sets the target department name of this business trip reimbursement.
	*
	* @param targetDepartmentName the target department name of this business trip reimbursement
	*/
	@Override
	public void setTargetDepartmentName(java.lang.String targetDepartmentName) {
		_businessTripReimbursement.setTargetDepartmentName(targetDepartmentName);
	}

	/**
	* Returns the target cost center of this business trip reimbursement.
	*
	* @return the target cost center of this business trip reimbursement
	*/
	@Override
	public java.lang.String getTargetCostCenter() {
		return _businessTripReimbursement.getTargetCostCenter();
	}

	/**
	* Sets the target cost center of this business trip reimbursement.
	*
	* @param targetCostCenter the target cost center of this business trip reimbursement
	*/
	@Override
	public void setTargetCostCenter(java.lang.String targetCostCenter) {
		_businessTripReimbursement.setTargetCostCenter(targetCostCenter);
	}

	/**
	* Returns the target department approver ID of this business trip reimbursement.
	*
	* @return the target department approver ID of this business trip reimbursement
	*/
	@Override
	public long getTargetDepartmentApproverId() {
		return _businessTripReimbursement.getTargetDepartmentApproverId();
	}

	/**
	* Sets the target department approver ID of this business trip reimbursement.
	*
	* @param targetDepartmentApproverId the target department approver ID of this business trip reimbursement
	*/
	@Override
	public void setTargetDepartmentApproverId(long targetDepartmentApproverId) {
		_businessTripReimbursement.setTargetDepartmentApproverId(targetDepartmentApproverId);
	}

	/**
	* Returns the target department approver name of this business trip reimbursement.
	*
	* @return the target department approver name of this business trip reimbursement
	*/
	@Override
	public java.lang.String getTargetDepartmentApproverName() {
		return _businessTripReimbursement.getTargetDepartmentApproverName();
	}

	/**
	* Sets the target department approver name of this business trip reimbursement.
	*
	* @param targetDepartmentApproverName the target department approver name of this business trip reimbursement
	*/
	@Override
	public void setTargetDepartmentApproverName(
		java.lang.String targetDepartmentApproverName) {
		_businessTripReimbursement.setTargetDepartmentApproverName(targetDepartmentApproverName);
	}

	/**
	* Returns the trip type of this business trip reimbursement.
	*
	* @return the trip type of this business trip reimbursement
	*/
	@Override
	public int getTripType() {
		return _businessTripReimbursement.getTripType();
	}

	/**
	* Sets the trip type of this business trip reimbursement.
	*
	* @param tripType the trip type of this business trip reimbursement
	*/
	@Override
	public void setTripType(int tripType) {
		_businessTripReimbursement.setTripType(tripType);
	}

	/**
	* Returns the departure date of this business trip reimbursement.
	*
	* @return the departure date of this business trip reimbursement
	*/
	@Override
	public java.util.Date getDepartureDate() {
		return _businessTripReimbursement.getDepartureDate();
	}

	/**
	* Sets the departure date of this business trip reimbursement.
	*
	* @param departureDate the departure date of this business trip reimbursement
	*/
	@Override
	public void setDepartureDate(java.util.Date departureDate) {
		_businessTripReimbursement.setDepartureDate(departureDate);
	}

	/**
	* Returns the return date of this business trip reimbursement.
	*
	* @return the return date of this business trip reimbursement
	*/
	@Override
	public java.util.Date getReturnDate() {
		return _businessTripReimbursement.getReturnDate();
	}

	/**
	* Sets the return date of this business trip reimbursement.
	*
	* @param returnDate the return date of this business trip reimbursement
	*/
	@Override
	public void setReturnDate(java.util.Date returnDate) {
		_businessTripReimbursement.setReturnDate(returnDate);
	}

	/**
	* Returns the purpose of the trip of this business trip reimbursement.
	*
	* @return the purpose of the trip of this business trip reimbursement
	*/
	@Override
	public java.lang.String getPurposeOfTheTrip() {
		return _businessTripReimbursement.getPurposeOfTheTrip();
	}

	/**
	* Sets the purpose of the trip of this business trip reimbursement.
	*
	* @param purposeOfTheTrip the purpose of the trip of this business trip reimbursement
	*/
	@Override
	public void setPurposeOfTheTrip(java.lang.String purposeOfTheTrip) {
		_businessTripReimbursement.setPurposeOfTheTrip(purposeOfTheTrip);
	}

	/**
	* Returns the visit countries cities of this business trip reimbursement.
	*
	* @return the visit countries cities of this business trip reimbursement
	*/
	@Override
	public java.lang.String getVisitCountriesCities() {
		return _businessTripReimbursement.getVisitCountriesCities();
	}

	/**
	* Sets the visit countries cities of this business trip reimbursement.
	*
	* @param visitCountriesCities the visit countries cities of this business trip reimbursement
	*/
	@Override
	public void setVisitCountriesCities(java.lang.String visitCountriesCities) {
		_businessTripReimbursement.setVisitCountriesCities(visitCountriesCities);
	}

	/**
	* Returns the advance payment of this business trip reimbursement.
	*
	* @return the advance payment of this business trip reimbursement
	*/
	@Override
	public double getAdvancePayment() {
		return _businessTripReimbursement.getAdvancePayment();
	}

	/**
	* Sets the advance payment of this business trip reimbursement.
	*
	* @param advancePayment the advance payment of this business trip reimbursement
	*/
	@Override
	public void setAdvancePayment(double advancePayment) {
		_businessTripReimbursement.setAdvancePayment(advancePayment);
	}

	/**
	* Returns the currency of this business trip reimbursement.
	*
	* @return the currency of this business trip reimbursement
	*/
	@Override
	public java.lang.String getCurrency() {
		return _businessTripReimbursement.getCurrency();
	}

	/**
	* Sets the currency of this business trip reimbursement.
	*
	* @param currency the currency of this business trip reimbursement
	*/
	@Override
	public void setCurrency(java.lang.String currency) {
		_businessTripReimbursement.setCurrency(currency);
	}

	/**
	* Returns the payment methods of this business trip reimbursement.
	*
	* @return the payment methods of this business trip reimbursement
	*/
	@Override
	public java.lang.String getPaymentMethods() {
		return _businessTripReimbursement.getPaymentMethods();
	}

	/**
	* Sets the payment methods of this business trip reimbursement.
	*
	* @param paymentMethods the payment methods of this business trip reimbursement
	*/
	@Override
	public void setPaymentMethods(java.lang.String paymentMethods) {
		_businessTripReimbursement.setPaymentMethods(paymentMethods);
	}

	/**
	* Returns the total cost rmb of this business trip reimbursement.
	*
	* @return the total cost rmb of this business trip reimbursement
	*/
	@Override
	public double getTotalCostRmb() {
		return _businessTripReimbursement.getTotalCostRmb();
	}

	/**
	* Sets the total cost rmb of this business trip reimbursement.
	*
	* @param totalCostRmb the total cost rmb of this business trip reimbursement
	*/
	@Override
	public void setTotalCostRmb(double totalCostRmb) {
		_businessTripReimbursement.setTotalCostRmb(totalCostRmb);
	}

	/**
	* Returns the total cost eur of this business trip reimbursement.
	*
	* @return the total cost eur of this business trip reimbursement
	*/
	@Override
	public double getTotalCostEur() {
		return _businessTripReimbursement.getTotalCostEur();
	}

	/**
	* Sets the total cost eur of this business trip reimbursement.
	*
	* @param totalCostEur the total cost eur of this business trip reimbursement
	*/
	@Override
	public void setTotalCostEur(double totalCostEur) {
		_businessTripReimbursement.setTotalCostEur(totalCostEur);
	}

	/**
	* Returns the org total cost rmb of this business trip reimbursement.
	*
	* @return the org total cost rmb of this business trip reimbursement
	*/
	@Override
	public double getOrgTotalCostRmb() {
		return _businessTripReimbursement.getOrgTotalCostRmb();
	}

	/**
	* Sets the org total cost rmb of this business trip reimbursement.
	*
	* @param orgTotalCostRmb the org total cost rmb of this business trip reimbursement
	*/
	@Override
	public void setOrgTotalCostRmb(double orgTotalCostRmb) {
		_businessTripReimbursement.setOrgTotalCostRmb(orgTotalCostRmb);
	}

	/**
	* Returns the org total cost eur of this business trip reimbursement.
	*
	* @return the org total cost eur of this business trip reimbursement
	*/
	@Override
	public double getOrgTotalCostEur() {
		return _businessTripReimbursement.getOrgTotalCostEur();
	}

	/**
	* Sets the org total cost eur of this business trip reimbursement.
	*
	* @param orgTotalCostEur the org total cost eur of this business trip reimbursement
	*/
	@Override
	public void setOrgTotalCostEur(double orgTotalCostEur) {
		_businessTripReimbursement.setOrgTotalCostEur(orgTotalCostEur);
	}

	/**
	* Returns the hotel total cost rmb of this business trip reimbursement.
	*
	* @return the hotel total cost rmb of this business trip reimbursement
	*/
	@Override
	public double getHotelTotalCostRmb() {
		return _businessTripReimbursement.getHotelTotalCostRmb();
	}

	/**
	* Sets the hotel total cost rmb of this business trip reimbursement.
	*
	* @param hotelTotalCostRmb the hotel total cost rmb of this business trip reimbursement
	*/
	@Override
	public void setHotelTotalCostRmb(double hotelTotalCostRmb) {
		_businessTripReimbursement.setHotelTotalCostRmb(hotelTotalCostRmb);
	}

	/**
	* Returns the hotel total cost eur of this business trip reimbursement.
	*
	* @return the hotel total cost eur of this business trip reimbursement
	*/
	@Override
	public double getHotelTotalCostEur() {
		return _businessTripReimbursement.getHotelTotalCostEur();
	}

	/**
	* Sets the hotel total cost eur of this business trip reimbursement.
	*
	* @param hotelTotalCostEur the hotel total cost eur of this business trip reimbursement
	*/
	@Override
	public void setHotelTotalCostEur(double hotelTotalCostEur) {
		_businessTripReimbursement.setHotelTotalCostEur(hotelTotalCostEur);
	}

	/**
	* Returns the car rental total cost rmb of this business trip reimbursement.
	*
	* @return the car rental total cost rmb of this business trip reimbursement
	*/
	@Override
	public double getCarRentalTotalCostRmb() {
		return _businessTripReimbursement.getCarRentalTotalCostRmb();
	}

	/**
	* Sets the car rental total cost rmb of this business trip reimbursement.
	*
	* @param carRentalTotalCostRmb the car rental total cost rmb of this business trip reimbursement
	*/
	@Override
	public void setCarRentalTotalCostRmb(double carRentalTotalCostRmb) {
		_businessTripReimbursement.setCarRentalTotalCostRmb(carRentalTotalCostRmb);
	}

	/**
	* Returns the car rental total cost eur of this business trip reimbursement.
	*
	* @return the car rental total cost eur of this business trip reimbursement
	*/
	@Override
	public double getCarRentalTotalCostEur() {
		return _businessTripReimbursement.getCarRentalTotalCostEur();
	}

	/**
	* Sets the car rental total cost eur of this business trip reimbursement.
	*
	* @param carRentalTotalCostEur the car rental total cost eur of this business trip reimbursement
	*/
	@Override
	public void setCarRentalTotalCostEur(double carRentalTotalCostEur) {
		_businessTripReimbursement.setCarRentalTotalCostEur(carRentalTotalCostEur);
	}

	/**
	* Returns the flight currency of this business trip reimbursement.
	*
	* @return the flight currency of this business trip reimbursement
	*/
	@Override
	public java.lang.String getFlightCurrency() {
		return _businessTripReimbursement.getFlightCurrency();
	}

	/**
	* Sets the flight currency of this business trip reimbursement.
	*
	* @param flightCurrency the flight currency of this business trip reimbursement
	*/
	@Override
	public void setFlightCurrency(java.lang.String flightCurrency) {
		_businessTripReimbursement.setFlightCurrency(flightCurrency);
	}

	/**
	* Returns the flight total of this business trip reimbursement.
	*
	* @return the flight total of this business trip reimbursement
	*/
	@Override
	public double getFlightTotal() {
		return _businessTripReimbursement.getFlightTotal();
	}

	/**
	* Sets the flight total of this business trip reimbursement.
	*
	* @param flightTotal the flight total of this business trip reimbursement
	*/
	@Override
	public void setFlightTotal(double flightTotal) {
		_businessTripReimbursement.setFlightTotal(flightTotal);
	}

	/**
	* Returns the flight air fare of this business trip reimbursement.
	*
	* @return the flight air fare of this business trip reimbursement
	*/
	@Override
	public double getFlightAirFare() {
		return _businessTripReimbursement.getFlightAirFare();
	}

	/**
	* Sets the flight air fare of this business trip reimbursement.
	*
	* @param flightAirFare the flight air fare of this business trip reimbursement
	*/
	@Override
	public void setFlightAirFare(double flightAirFare) {
		_businessTripReimbursement.setFlightAirFare(flightAirFare);
	}

	/**
	* Returns the flight taxes of this business trip reimbursement.
	*
	* @return the flight taxes of this business trip reimbursement
	*/
	@Override
	public double getFlightTaxes() {
		return _businessTripReimbursement.getFlightTaxes();
	}

	/**
	* Sets the flight taxes of this business trip reimbursement.
	*
	* @param flightTaxes the flight taxes of this business trip reimbursement
	*/
	@Override
	public void setFlightTaxes(double flightTaxes) {
		_businessTripReimbursement.setFlightTaxes(flightTaxes);
	}

	/**
	* Returns the flight transaction fee of this business trip reimbursement.
	*
	* @return the flight transaction fee of this business trip reimbursement
	*/
	@Override
	public double getFlightTransactionFee() {
		return _businessTripReimbursement.getFlightTransactionFee();
	}

	/**
	* Sets the flight transaction fee of this business trip reimbursement.
	*
	* @param flightTransactionFee the flight transaction fee of this business trip reimbursement
	*/
	@Override
	public void setFlightTransactionFee(double flightTransactionFee) {
		_businessTripReimbursement.setFlightTransactionFee(flightTransactionFee);
	}

	/**
	* Returns the total travel expense rmb of this business trip reimbursement.
	*
	* @return the total travel expense rmb of this business trip reimbursement
	*/
	@Override
	public double getTotalTravelExpenseRmb() {
		return _businessTripReimbursement.getTotalTravelExpenseRmb();
	}

	/**
	* Sets the total travel expense rmb of this business trip reimbursement.
	*
	* @param totalTravelExpenseRmb the total travel expense rmb of this business trip reimbursement
	*/
	@Override
	public void setTotalTravelExpenseRmb(double totalTravelExpenseRmb) {
		_businessTripReimbursement.setTotalTravelExpenseRmb(totalTravelExpenseRmb);
	}

	/**
	* Returns the total travel expense eur of this business trip reimbursement.
	*
	* @return the total travel expense eur of this business trip reimbursement
	*/
	@Override
	public double getTotalTravelExpenseEur() {
		return _businessTripReimbursement.getTotalTravelExpenseEur();
	}

	/**
	* Sets the total travel expense eur of this business trip reimbursement.
	*
	* @param totalTravelExpenseEur the total travel expense eur of this business trip reimbursement
	*/
	@Override
	public void setTotalTravelExpenseEur(double totalTravelExpenseEur) {
		_businessTripReimbursement.setTotalTravelExpenseEur(totalTravelExpenseEur);
	}

	/**
	* Returns the cost list inland total rmb of this business trip reimbursement.
	*
	* @return the cost list inland total rmb of this business trip reimbursement
	*/
	@Override
	public double getCostListInlandTotalRmb() {
		return _businessTripReimbursement.getCostListInlandTotalRmb();
	}

	/**
	* Sets the cost list inland total rmb of this business trip reimbursement.
	*
	* @param costListInlandTotalRmb the cost list inland total rmb of this business trip reimbursement
	*/
	@Override
	public void setCostListInlandTotalRmb(double costListInlandTotalRmb) {
		_businessTripReimbursement.setCostListInlandTotalRmb(costListInlandTotalRmb);
	}

	/**
	* Returns the cost list foreign total eur of this business trip reimbursement.
	*
	* @return the cost list foreign total eur of this business trip reimbursement
	*/
	@Override
	public double getCostListForeignTotalEur() {
		return _businessTripReimbursement.getCostListForeignTotalEur();
	}

	/**
	* Sets the cost list foreign total eur of this business trip reimbursement.
	*
	* @param costListForeignTotalEur the cost list foreign total eur of this business trip reimbursement
	*/
	@Override
	public void setCostListForeignTotalEur(double costListForeignTotalEur) {
		_businessTripReimbursement.setCostListForeignTotalEur(costListForeignTotalEur);
	}

	/**
	* Returns the cost list foreign total rmb of this business trip reimbursement.
	*
	* @return the cost list foreign total rmb of this business trip reimbursement
	*/
	@Override
	public double getCostListForeignTotalRmb() {
		return _businessTripReimbursement.getCostListForeignTotalRmb();
	}

	/**
	* Sets the cost list foreign total rmb of this business trip reimbursement.
	*
	* @param costListForeignTotalRmb the cost list foreign total rmb of this business trip reimbursement
	*/
	@Override
	public void setCostListForeignTotalRmb(double costListForeignTotalRmb) {
		_businessTripReimbursement.setCostListForeignTotalRmb(costListForeignTotalRmb);
	}

	/**
	* Returns the remark of this business trip reimbursement.
	*
	* @return the remark of this business trip reimbursement
	*/
	@Override
	public java.lang.String getRemark() {
		return _businessTripReimbursement.getRemark();
	}

	/**
	* Sets the remark of this business trip reimbursement.
	*
	* @param remark the remark of this business trip reimbursement
	*/
	@Override
	public void setRemark(java.lang.String remark) {
		_businessTripReimbursement.setRemark(remark);
	}

	/**
	* Returns the is payby rmb of this business trip reimbursement.
	*
	* @return the is payby rmb of this business trip reimbursement
	*/
	@Override
	public boolean getIsPaybyRmb() {
		return _businessTripReimbursement.getIsPaybyRmb();
	}

	/**
	* Returns <code>true</code> if this business trip reimbursement is is payby rmb.
	*
	* @return <code>true</code> if this business trip reimbursement is is payby rmb; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsPaybyRmb() {
		return _businessTripReimbursement.isIsPaybyRmb();
	}

	/**
	* Sets whether this business trip reimbursement is is payby rmb.
	*
	* @param isPaybyRmb the is payby rmb of this business trip reimbursement
	*/
	@Override
	public void setIsPaybyRmb(boolean isPaybyRmb) {
		_businessTripReimbursement.setIsPaybyRmb(isPaybyRmb);
	}

	/**
	* Returns the status of this business trip reimbursement.
	*
	* @return the status of this business trip reimbursement
	*/
	@Override
	public int getStatus() {
		return _businessTripReimbursement.getStatus();
	}

	/**
	* Sets the status of this business trip reimbursement.
	*
	* @param status the status of this business trip reimbursement
	*/
	@Override
	public void setStatus(int status) {
		_businessTripReimbursement.setStatus(status);
	}

	/**
	* Returns the sap status of this business trip reimbursement.
	*
	* @return the sap status of this business trip reimbursement
	*/
	@Override
	public int getSapStatus() {
		return _businessTripReimbursement.getSapStatus();
	}

	/**
	* Sets the sap status of this business trip reimbursement.
	*
	* @param sapStatus the sap status of this business trip reimbursement
	*/
	@Override
	public void setSapStatus(int sapStatus) {
		_businessTripReimbursement.setSapStatus(sapStatus);
	}

	/**
	* Returns the sap comments of this business trip reimbursement.
	*
	* @return the sap comments of this business trip reimbursement
	*/
	@Override
	public java.lang.String getSapComments() {
		return _businessTripReimbursement.getSapComments();
	}

	/**
	* Sets the sap comments of this business trip reimbursement.
	*
	* @param sapComments the sap comments of this business trip reimbursement
	*/
	@Override
	public void setSapComments(java.lang.String sapComments) {
		_businessTripReimbursement.setSapComments(sapComments);
	}

	/**
	* Returns the sap document ID of this business trip reimbursement.
	*
	* @return the sap document ID of this business trip reimbursement
	*/
	@Override
	public java.lang.String getSapDocumentId() {
		return _businessTripReimbursement.getSapDocumentId();
	}

	/**
	* Sets the sap document ID of this business trip reimbursement.
	*
	* @param sapDocumentId the sap document ID of this business trip reimbursement
	*/
	@Override
	public void setSapDocumentId(java.lang.String sapDocumentId) {
		_businessTripReimbursement.setSapDocumentId(sapDocumentId);
	}

	/**
	* Returns the status by user ID of this business trip reimbursement.
	*
	* @return the status by user ID of this business trip reimbursement
	*/
	@Override
	public long getStatusByUserId() {
		return _businessTripReimbursement.getStatusByUserId();
	}

	/**
	* Sets the status by user ID of this business trip reimbursement.
	*
	* @param statusByUserId the status by user ID of this business trip reimbursement
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_businessTripReimbursement.setStatusByUserId(statusByUserId);
	}

	/**
	* Returns the status by user uuid of this business trip reimbursement.
	*
	* @return the status by user uuid of this business trip reimbursement
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getStatusByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _businessTripReimbursement.getStatusByUserUuid();
	}

	/**
	* Sets the status by user uuid of this business trip reimbursement.
	*
	* @param statusByUserUuid the status by user uuid of this business trip reimbursement
	*/
	@Override
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_businessTripReimbursement.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Returns the status by user name of this business trip reimbursement.
	*
	* @return the status by user name of this business trip reimbursement
	*/
	@Override
	public java.lang.String getStatusByUserName() {
		return _businessTripReimbursement.getStatusByUserName();
	}

	/**
	* Sets the status by user name of this business trip reimbursement.
	*
	* @param statusByUserName the status by user name of this business trip reimbursement
	*/
	@Override
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_businessTripReimbursement.setStatusByUserName(statusByUserName);
	}

	/**
	* Returns the status date of this business trip reimbursement.
	*
	* @return the status date of this business trip reimbursement
	*/
	@Override
	public java.util.Date getStatusDate() {
		return _businessTripReimbursement.getStatusDate();
	}

	/**
	* Sets the status date of this business trip reimbursement.
	*
	* @param statusDate the status date of this business trip reimbursement
	*/
	@Override
	public void setStatusDate(java.util.Date statusDate) {
		_businessTripReimbursement.setStatusDate(statusDate);
	}

	/**
	* Returns the is applicant agent of this business trip reimbursement.
	*
	* @return the is applicant agent of this business trip reimbursement
	*/
	@Override
	public boolean getIsApplicantAgent() {
		return _businessTripReimbursement.getIsApplicantAgent();
	}

	/**
	* Returns <code>true</code> if this business trip reimbursement is is applicant agent.
	*
	* @return <code>true</code> if this business trip reimbursement is is applicant agent; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsApplicantAgent() {
		return _businessTripReimbursement.isIsApplicantAgent();
	}

	/**
	* Sets whether this business trip reimbursement is is applicant agent.
	*
	* @param isApplicantAgent the is applicant agent of this business trip reimbursement
	*/
	@Override
	public void setIsApplicantAgent(boolean isApplicantAgent) {
		_businessTripReimbursement.setIsApplicantAgent(isApplicantAgent);
	}

	/**
	* Returns the is approver agent of this business trip reimbursement.
	*
	* @return the is approver agent of this business trip reimbursement
	*/
	@Override
	public boolean getIsApproverAgent() {
		return _businessTripReimbursement.getIsApproverAgent();
	}

	/**
	* Returns <code>true</code> if this business trip reimbursement is is approver agent.
	*
	* @return <code>true</code> if this business trip reimbursement is is approver agent; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsApproverAgent() {
		return _businessTripReimbursement.isIsApproverAgent();
	}

	/**
	* Sets whether this business trip reimbursement is is approver agent.
	*
	* @param isApproverAgent the is approver agent of this business trip reimbursement
	*/
	@Override
	public void setIsApproverAgent(boolean isApproverAgent) {
		_businessTripReimbursement.setIsApproverAgent(isApproverAgent);
	}

	/**
	* Returns the group ID of this business trip reimbursement.
	*
	* @return the group ID of this business trip reimbursement
	*/
	@Override
	public long getGroupId() {
		return _businessTripReimbursement.getGroupId();
	}

	/**
	* Sets the group ID of this business trip reimbursement.
	*
	* @param groupId the group ID of this business trip reimbursement
	*/
	@Override
	public void setGroupId(long groupId) {
		_businessTripReimbursement.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this business trip reimbursement.
	*
	* @return the user ID of this business trip reimbursement
	*/
	@Override
	public long getUserId() {
		return _businessTripReimbursement.getUserId();
	}

	/**
	* Sets the user ID of this business trip reimbursement.
	*
	* @param userId the user ID of this business trip reimbursement
	*/
	@Override
	public void setUserId(long userId) {
		_businessTripReimbursement.setUserId(userId);
	}

	/**
	* Returns the user uuid of this business trip reimbursement.
	*
	* @return the user uuid of this business trip reimbursement
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _businessTripReimbursement.getUserUuid();
	}

	/**
	* Sets the user uuid of this business trip reimbursement.
	*
	* @param userUuid the user uuid of this business trip reimbursement
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_businessTripReimbursement.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this business trip reimbursement.
	*
	* @return the user name of this business trip reimbursement
	*/
	@Override
	public java.lang.String getUserName() {
		return _businessTripReimbursement.getUserName();
	}

	/**
	* Sets the user name of this business trip reimbursement.
	*
	* @param userName the user name of this business trip reimbursement
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_businessTripReimbursement.setUserName(userName);
	}

	/**
	* Returns the create date of this business trip reimbursement.
	*
	* @return the create date of this business trip reimbursement
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _businessTripReimbursement.getCreateDate();
	}

	/**
	* Sets the create date of this business trip reimbursement.
	*
	* @param createDate the create date of this business trip reimbursement
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_businessTripReimbursement.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this business trip reimbursement.
	*
	* @return the modified date of this business trip reimbursement
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _businessTripReimbursement.getModifiedDate();
	}

	/**
	* Sets the modified date of this business trip reimbursement.
	*
	* @param modifiedDate the modified date of this business trip reimbursement
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_businessTripReimbursement.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the submitted date of this business trip reimbursement.
	*
	* @return the submitted date of this business trip reimbursement
	*/
	@Override
	public java.util.Date getSubmittedDate() {
		return _businessTripReimbursement.getSubmittedDate();
	}

	/**
	* Sets the submitted date of this business trip reimbursement.
	*
	* @param submittedDate the submitted date of this business trip reimbursement
	*/
	@Override
	public void setSubmittedDate(java.util.Date submittedDate) {
		_businessTripReimbursement.setSubmittedDate(submittedDate);
	}

	/**
	* Returns the company ID of this business trip reimbursement.
	*
	* @return the company ID of this business trip reimbursement
	*/
	@Override
	public long getCompanyId() {
		return _businessTripReimbursement.getCompanyId();
	}

	/**
	* Sets the company ID of this business trip reimbursement.
	*
	* @param companyId the company ID of this business trip reimbursement
	*/
	@Override
	public void setCompanyId(long companyId) {
		_businessTripReimbursement.setCompanyId(companyId);
	}

	/**
	* @deprecated As of 6.1.0, replaced by {@link #isApproved()}
	*/
	@Override
	public boolean getApproved() {
		return _businessTripReimbursement.getApproved();
	}

	/**
	* Returns <code>true</code> if this business trip reimbursement is approved.
	*
	* @return <code>true</code> if this business trip reimbursement is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _businessTripReimbursement.isApproved();
	}

	/**
	* Returns <code>true</code> if this business trip reimbursement is denied.
	*
	* @return <code>true</code> if this business trip reimbursement is denied; <code>false</code> otherwise
	*/
	@Override
	public boolean isDenied() {
		return _businessTripReimbursement.isDenied();
	}

	/**
	* Returns <code>true</code> if this business trip reimbursement is a draft.
	*
	* @return <code>true</code> if this business trip reimbursement is a draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _businessTripReimbursement.isDraft();
	}

	/**
	* Returns <code>true</code> if this business trip reimbursement is expired.
	*
	* @return <code>true</code> if this business trip reimbursement is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _businessTripReimbursement.isExpired();
	}

	/**
	* Returns <code>true</code> if this business trip reimbursement is inactive.
	*
	* @return <code>true</code> if this business trip reimbursement is inactive; <code>false</code> otherwise
	*/
	@Override
	public boolean isInactive() {
		return _businessTripReimbursement.isInactive();
	}

	/**
	* Returns <code>true</code> if this business trip reimbursement is incomplete.
	*
	* @return <code>true</code> if this business trip reimbursement is incomplete; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncomplete() {
		return _businessTripReimbursement.isIncomplete();
	}

	/**
	* Returns <code>true</code> if this business trip reimbursement is pending.
	*
	* @return <code>true</code> if this business trip reimbursement is pending; <code>false</code> otherwise
	*/
	@Override
	public boolean isPending() {
		return _businessTripReimbursement.isPending();
	}

	/**
	* Returns <code>true</code> if this business trip reimbursement is scheduled.
	*
	* @return <code>true</code> if this business trip reimbursement is scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isScheduled() {
		return _businessTripReimbursement.isScheduled();
	}

	@Override
	public boolean isNew() {
		return _businessTripReimbursement.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_businessTripReimbursement.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _businessTripReimbursement.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_businessTripReimbursement.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _businessTripReimbursement.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _businessTripReimbursement.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_businessTripReimbursement.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _businessTripReimbursement.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_businessTripReimbursement.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_businessTripReimbursement.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_businessTripReimbursement.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BusinessTripReimbursementWrapper((BusinessTripReimbursement)_businessTripReimbursement.clone());
	}

	@Override
	public int compareTo(
		com.business.trip.model.BusinessTripReimbursement businessTripReimbursement) {
		return _businessTripReimbursement.compareTo(businessTripReimbursement);
	}

	@Override
	public int hashCode() {
		return _businessTripReimbursement.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.business.trip.model.BusinessTripReimbursement> toCacheModel() {
		return _businessTripReimbursement.toCacheModel();
	}

	@Override
	public com.business.trip.model.BusinessTripReimbursement toEscapedModel() {
		return new BusinessTripReimbursementWrapper(_businessTripReimbursement.toEscapedModel());
	}

	@Override
	public com.business.trip.model.BusinessTripReimbursement toUnescapedModel() {
		return new BusinessTripReimbursementWrapper(_businessTripReimbursement.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _businessTripReimbursement.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _businessTripReimbursement.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_businessTripReimbursement.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BusinessTripReimbursementWrapper)) {
			return false;
		}

		BusinessTripReimbursementWrapper businessTripReimbursementWrapper = (BusinessTripReimbursementWrapper)obj;

		if (Validator.equals(_businessTripReimbursement,
					businessTripReimbursementWrapper._businessTripReimbursement)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public BusinessTripReimbursement getWrappedBusinessTripReimbursement() {
		return _businessTripReimbursement;
	}

	@Override
	public BusinessTripReimbursement getWrappedModel() {
		return _businessTripReimbursement;
	}

	@Override
	public void resetOriginalValues() {
		_businessTripReimbursement.resetOriginalValues();
	}

	private BusinessTripReimbursement _businessTripReimbursement;
}