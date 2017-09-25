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
 * This class is a wrapper for {@link BusinessTripApplication}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BusinessTripApplication
 * @generated
 */
public class BusinessTripApplicationWrapper implements BusinessTripApplication,
	ModelWrapper<BusinessTripApplication> {
	public BusinessTripApplicationWrapper(
		BusinessTripApplication businessTripApplication) {
		_businessTripApplication = businessTripApplication;
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

	/**
	* Returns the primary key of this business trip application.
	*
	* @return the primary key of this business trip application
	*/
	@Override
	public long getPrimaryKey() {
		return _businessTripApplication.getPrimaryKey();
	}

	/**
	* Sets the primary key of this business trip application.
	*
	* @param primaryKey the primary key of this business trip application
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_businessTripApplication.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the business trip application ID of this business trip application.
	*
	* @return the business trip application ID of this business trip application
	*/
	@Override
	public long getBusinessTripApplicationId() {
		return _businessTripApplication.getBusinessTripApplicationId();
	}

	/**
	* Sets the business trip application ID of this business trip application.
	*
	* @param businessTripApplicationId the business trip application ID of this business trip application
	*/
	@Override
	public void setBusinessTripApplicationId(long businessTripApplicationId) {
		_businessTripApplication.setBusinessTripApplicationId(businessTripApplicationId);
	}

	/**
	* Returns the ticket no of this business trip application.
	*
	* @return the ticket no of this business trip application
	*/
	@Override
	public java.lang.String getTicketNo() {
		return _businessTripApplication.getTicketNo();
	}

	/**
	* Sets the ticket no of this business trip application.
	*
	* @param ticketNo the ticket no of this business trip application
	*/
	@Override
	public void setTicketNo(java.lang.String ticketNo) {
		_businessTripApplication.setTicketNo(ticketNo);
	}

	/**
	* Returns the process type of this business trip application.
	*
	* @return the process type of this business trip application
	*/
	@Override
	public java.lang.String getProcessType() {
		return _businessTripApplication.getProcessType();
	}

	/**
	* Sets the process type of this business trip application.
	*
	* @param processType the process type of this business trip application
	*/
	@Override
	public void setProcessType(java.lang.String processType) {
		_businessTripApplication.setProcessType(processType);
	}

	/**
	* Returns the sub type of this business trip application.
	*
	* @return the sub type of this business trip application
	*/
	@Override
	public java.lang.String getSubType() {
		return _businessTripApplication.getSubType();
	}

	/**
	* Sets the sub type of this business trip application.
	*
	* @param subType the sub type of this business trip application
	*/
	@Override
	public void setSubType(java.lang.String subType) {
		_businessTripApplication.setSubType(subType);
	}

	/**
	* Returns the print name of this business trip application.
	*
	* @return the print name of this business trip application
	*/
	@Override
	public java.lang.String getPrintName() {
		return _businessTripApplication.getPrintName();
	}

	/**
	* Sets the print name of this business trip application.
	*
	* @param printName the print name of this business trip application
	*/
	@Override
	public void setPrintName(java.lang.String printName) {
		_businessTripApplication.setPrintName(printName);
	}

	/**
	* Returns the staff code of this business trip application.
	*
	* @return the staff code of this business trip application
	*/
	@Override
	public long getStaffCode() {
		return _businessTripApplication.getStaffCode();
	}

	/**
	* Sets the staff code of this business trip application.
	*
	* @param staffCode the staff code of this business trip application
	*/
	@Override
	public void setStaffCode(long staffCode) {
		_businessTripApplication.setStaffCode(staffCode);
	}

	/**
	* Returns the company name of this business trip application.
	*
	* @return the company name of this business trip application
	*/
	@Override
	public java.lang.String getCompanyName() {
		return _businessTripApplication.getCompanyName();
	}

	/**
	* Sets the company name of this business trip application.
	*
	* @param companyName the company name of this business trip application
	*/
	@Override
	public void setCompanyName(java.lang.String companyName) {
		_businessTripApplication.setCompanyName(companyName);
	}

	/**
	* Returns the division of this business trip application.
	*
	* @return the division of this business trip application
	*/
	@Override
	public java.lang.String getDivision() {
		return _businessTripApplication.getDivision();
	}

	/**
	* Sets the division of this business trip application.
	*
	* @param division the division of this business trip application
	*/
	@Override
	public void setDivision(java.lang.String division) {
		_businessTripApplication.setDivision(division);
	}

	/**
	* Returns the department of this business trip application.
	*
	* @return the department of this business trip application
	*/
	@Override
	public java.lang.String getDepartment() {
		return _businessTripApplication.getDepartment();
	}

	/**
	* Sets the department of this business trip application.
	*
	* @param department the department of this business trip application
	*/
	@Override
	public void setDepartment(java.lang.String department) {
		_businessTripApplication.setDepartment(department);
	}

	/**
	* Returns the cost center of this business trip application.
	*
	* @return the cost center of this business trip application
	*/
	@Override
	public java.lang.String getCostCenter() {
		return _businessTripApplication.getCostCenter();
	}

	/**
	* Sets the cost center of this business trip application.
	*
	* @param costCenter the cost center of this business trip application
	*/
	@Override
	public void setCostCenter(java.lang.String costCenter) {
		_businessTripApplication.setCostCenter(costCenter);
	}

	/**
	* Returns the personal i d of this business trip application.
	*
	* @return the personal i d of this business trip application
	*/
	@Override
	public java.lang.String getPersonalID() {
		return _businessTripApplication.getPersonalID();
	}

	/**
	* Sets the personal i d of this business trip application.
	*
	* @param personalID the personal i d of this business trip application
	*/
	@Override
	public void setPersonalID(java.lang.String personalID) {
		_businessTripApplication.setPersonalID(personalID);
	}

	/**
	* Returns the passport no of this business trip application.
	*
	* @return the passport no of this business trip application
	*/
	@Override
	public java.lang.String getPassportNo() {
		return _businessTripApplication.getPassportNo();
	}

	/**
	* Sets the passport no of this business trip application.
	*
	* @param passportNo the passport no of this business trip application
	*/
	@Override
	public void setPassportNo(java.lang.String passportNo) {
		_businessTripApplication.setPassportNo(passportNo);
	}

	/**
	* Returns the office phone of this business trip application.
	*
	* @return the office phone of this business trip application
	*/
	@Override
	public java.lang.String getOfficePhone() {
		return _businessTripApplication.getOfficePhone();
	}

	/**
	* Sets the office phone of this business trip application.
	*
	* @param officePhone the office phone of this business trip application
	*/
	@Override
	public void setOfficePhone(java.lang.String officePhone) {
		_businessTripApplication.setOfficePhone(officePhone);
	}

	/**
	* Returns the mobile phone of this business trip application.
	*
	* @return the mobile phone of this business trip application
	*/
	@Override
	public java.lang.String getMobilePhone() {
		return _businessTripApplication.getMobilePhone();
	}

	/**
	* Sets the mobile phone of this business trip application.
	*
	* @param mobilePhone the mobile phone of this business trip application
	*/
	@Override
	public void setMobilePhone(java.lang.String mobilePhone) {
		_businessTripApplication.setMobilePhone(mobilePhone);
	}

	/**
	* Returns the email of this business trip application.
	*
	* @return the email of this business trip application
	*/
	@Override
	public java.lang.String getEmail() {
		return _businessTripApplication.getEmail();
	}

	/**
	* Sets the email of this business trip application.
	*
	* @param email the email of this business trip application
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_businessTripApplication.setEmail(email);
	}

	/**
	* Returns the office site of this business trip application.
	*
	* @return the office site of this business trip application
	*/
	@Override
	public java.lang.String getOfficeSite() {
		return _businessTripApplication.getOfficeSite();
	}

	/**
	* Sets the office site of this business trip application.
	*
	* @param officeSite the office site of this business trip application
	*/
	@Override
	public void setOfficeSite(java.lang.String officeSite) {
		_businessTripApplication.setOfficeSite(officeSite);
	}

	/**
	* Returns the approver ID of this business trip application.
	*
	* @return the approver ID of this business trip application
	*/
	@Override
	public long getApproverId() {
		return _businessTripApplication.getApproverId();
	}

	/**
	* Sets the approver ID of this business trip application.
	*
	* @param approverId the approver ID of this business trip application
	*/
	@Override
	public void setApproverId(long approverId) {
		_businessTripApplication.setApproverId(approverId);
	}

	/**
	* Returns the approver name of this business trip application.
	*
	* @return the approver name of this business trip application
	*/
	@Override
	public java.lang.String getApproverName() {
		return _businessTripApplication.getApproverName();
	}

	/**
	* Sets the approver name of this business trip application.
	*
	* @param approverName the approver name of this business trip application
	*/
	@Override
	public void setApproverName(java.lang.String approverName) {
		_businessTripApplication.setApproverName(approverName);
	}

	/**
	* Returns the evp ID of this business trip application.
	*
	* @return the evp ID of this business trip application
	*/
	@Override
	public long getEvpId() {
		return _businessTripApplication.getEvpId();
	}

	/**
	* Sets the evp ID of this business trip application.
	*
	* @param evpId the evp ID of this business trip application
	*/
	@Override
	public void setEvpId(long evpId) {
		_businessTripApplication.setEvpId(evpId);
	}

	/**
	* Returns the evp name of this business trip application.
	*
	* @return the evp name of this business trip application
	*/
	@Override
	public java.lang.String getEvpName() {
		return _businessTripApplication.getEvpName();
	}

	/**
	* Sets the evp name of this business trip application.
	*
	* @param evpName the evp name of this business trip application
	*/
	@Override
	public void setEvpName(java.lang.String evpName) {
		_businessTripApplication.setEvpName(evpName);
	}

	/**
	* Returns the is cross department of this business trip application.
	*
	* @return the is cross department of this business trip application
	*/
	@Override
	public boolean getIsCrossDepartment() {
		return _businessTripApplication.getIsCrossDepartment();
	}

	/**
	* Returns <code>true</code> if this business trip application is is cross department.
	*
	* @return <code>true</code> if this business trip application is is cross department; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsCrossDepartment() {
		return _businessTripApplication.isIsCrossDepartment();
	}

	/**
	* Sets whether this business trip application is is cross department.
	*
	* @param isCrossDepartment the is cross department of this business trip application
	*/
	@Override
	public void setIsCrossDepartment(boolean isCrossDepartment) {
		_businessTripApplication.setIsCrossDepartment(isCrossDepartment);
	}

	/**
	* Returns the target department ID of this business trip application.
	*
	* @return the target department ID of this business trip application
	*/
	@Override
	public long getTargetDepartmentId() {
		return _businessTripApplication.getTargetDepartmentId();
	}

	/**
	* Sets the target department ID of this business trip application.
	*
	* @param targetDepartmentId the target department ID of this business trip application
	*/
	@Override
	public void setTargetDepartmentId(long targetDepartmentId) {
		_businessTripApplication.setTargetDepartmentId(targetDepartmentId);
	}

	/**
	* Returns the target department name of this business trip application.
	*
	* @return the target department name of this business trip application
	*/
	@Override
	public java.lang.String getTargetDepartmentName() {
		return _businessTripApplication.getTargetDepartmentName();
	}

	/**
	* Sets the target department name of this business trip application.
	*
	* @param targetDepartmentName the target department name of this business trip application
	*/
	@Override
	public void setTargetDepartmentName(java.lang.String targetDepartmentName) {
		_businessTripApplication.setTargetDepartmentName(targetDepartmentName);
	}

	/**
	* Returns the target cost center of this business trip application.
	*
	* @return the target cost center of this business trip application
	*/
	@Override
	public java.lang.String getTargetCostCenter() {
		return _businessTripApplication.getTargetCostCenter();
	}

	/**
	* Sets the target cost center of this business trip application.
	*
	* @param targetCostCenter the target cost center of this business trip application
	*/
	@Override
	public void setTargetCostCenter(java.lang.String targetCostCenter) {
		_businessTripApplication.setTargetCostCenter(targetCostCenter);
	}

	/**
	* Returns the target department approver ID of this business trip application.
	*
	* @return the target department approver ID of this business trip application
	*/
	@Override
	public long getTargetDepartmentApproverId() {
		return _businessTripApplication.getTargetDepartmentApproverId();
	}

	/**
	* Sets the target department approver ID of this business trip application.
	*
	* @param targetDepartmentApproverId the target department approver ID of this business trip application
	*/
	@Override
	public void setTargetDepartmentApproverId(long targetDepartmentApproverId) {
		_businessTripApplication.setTargetDepartmentApproverId(targetDepartmentApproverId);
	}

	/**
	* Returns the target department approver name of this business trip application.
	*
	* @return the target department approver name of this business trip application
	*/
	@Override
	public java.lang.String getTargetDepartmentApproverName() {
		return _businessTripApplication.getTargetDepartmentApproverName();
	}

	/**
	* Sets the target department approver name of this business trip application.
	*
	* @param targetDepartmentApproverName the target department approver name of this business trip application
	*/
	@Override
	public void setTargetDepartmentApproverName(
		java.lang.String targetDepartmentApproverName) {
		_businessTripApplication.setTargetDepartmentApproverName(targetDepartmentApproverName);
	}

	/**
	* Returns the trip type of this business trip application.
	*
	* @return the trip type of this business trip application
	*/
	@Override
	public int getTripType() {
		return _businessTripApplication.getTripType();
	}

	/**
	* Sets the trip type of this business trip application.
	*
	* @param tripType the trip type of this business trip application
	*/
	@Override
	public void setTripType(int tripType) {
		_businessTripApplication.setTripType(tripType);
	}

	/**
	* Returns the departure date of this business trip application.
	*
	* @return the departure date of this business trip application
	*/
	@Override
	public java.util.Date getDepartureDate() {
		return _businessTripApplication.getDepartureDate();
	}

	/**
	* Sets the departure date of this business trip application.
	*
	* @param departureDate the departure date of this business trip application
	*/
	@Override
	public void setDepartureDate(java.util.Date departureDate) {
		_businessTripApplication.setDepartureDate(departureDate);
	}

	/**
	* Returns the return date of this business trip application.
	*
	* @return the return date of this business trip application
	*/
	@Override
	public java.util.Date getReturnDate() {
		return _businessTripApplication.getReturnDate();
	}

	/**
	* Sets the return date of this business trip application.
	*
	* @param returnDate the return date of this business trip application
	*/
	@Override
	public void setReturnDate(java.util.Date returnDate) {
		_businessTripApplication.setReturnDate(returnDate);
	}

	/**
	* Returns the purpose of the trip of this business trip application.
	*
	* @return the purpose of the trip of this business trip application
	*/
	@Override
	public java.lang.String getPurposeOfTheTrip() {
		return _businessTripApplication.getPurposeOfTheTrip();
	}

	/**
	* Sets the purpose of the trip of this business trip application.
	*
	* @param purposeOfTheTrip the purpose of the trip of this business trip application
	*/
	@Override
	public void setPurposeOfTheTrip(java.lang.String purposeOfTheTrip) {
		_businessTripApplication.setPurposeOfTheTrip(purposeOfTheTrip);
	}

	/**
	* Returns the visit countries cities of this business trip application.
	*
	* @return the visit countries cities of this business trip application
	*/
	@Override
	public java.lang.String getVisitCountriesCities() {
		return _businessTripApplication.getVisitCountriesCities();
	}

	/**
	* Sets the visit countries cities of this business trip application.
	*
	* @param visitCountriesCities the visit countries cities of this business trip application
	*/
	@Override
	public void setVisitCountriesCities(java.lang.String visitCountriesCities) {
		_businessTripApplication.setVisitCountriesCities(visitCountriesCities);
	}

	/**
	* Returns the advance payment of this business trip application.
	*
	* @return the advance payment of this business trip application
	*/
	@Override
	public double getAdvancePayment() {
		return _businessTripApplication.getAdvancePayment();
	}

	/**
	* Sets the advance payment of this business trip application.
	*
	* @param advancePayment the advance payment of this business trip application
	*/
	@Override
	public void setAdvancePayment(double advancePayment) {
		_businessTripApplication.setAdvancePayment(advancePayment);
	}

	/**
	* Returns the currency of this business trip application.
	*
	* @return the currency of this business trip application
	*/
	@Override
	public java.lang.String getCurrency() {
		return _businessTripApplication.getCurrency();
	}

	/**
	* Sets the currency of this business trip application.
	*
	* @param currency the currency of this business trip application
	*/
	@Override
	public void setCurrency(java.lang.String currency) {
		_businessTripApplication.setCurrency(currency);
	}

	/**
	* Returns the payment methods of this business trip application.
	*
	* @return the payment methods of this business trip application
	*/
	@Override
	public java.lang.String getPaymentMethods() {
		return _businessTripApplication.getPaymentMethods();
	}

	/**
	* Sets the payment methods of this business trip application.
	*
	* @param paymentMethods the payment methods of this business trip application
	*/
	@Override
	public void setPaymentMethods(java.lang.String paymentMethods) {
		_businessTripApplication.setPaymentMethods(paymentMethods);
	}

	/**
	* Returns the total cost rmb of this business trip application.
	*
	* @return the total cost rmb of this business trip application
	*/
	@Override
	public double getTotalCostRmb() {
		return _businessTripApplication.getTotalCostRmb();
	}

	/**
	* Sets the total cost rmb of this business trip application.
	*
	* @param totalCostRmb the total cost rmb of this business trip application
	*/
	@Override
	public void setTotalCostRmb(double totalCostRmb) {
		_businessTripApplication.setTotalCostRmb(totalCostRmb);
	}

	/**
	* Returns the total cost eur of this business trip application.
	*
	* @return the total cost eur of this business trip application
	*/
	@Override
	public double getTotalCostEur() {
		return _businessTripApplication.getTotalCostEur();
	}

	/**
	* Sets the total cost eur of this business trip application.
	*
	* @param totalCostEur the total cost eur of this business trip application
	*/
	@Override
	public void setTotalCostEur(double totalCostEur) {
		_businessTripApplication.setTotalCostEur(totalCostEur);
	}

	/**
	* Returns the hotel total cost rmb of this business trip application.
	*
	* @return the hotel total cost rmb of this business trip application
	*/
	@Override
	public double getHotelTotalCostRmb() {
		return _businessTripApplication.getHotelTotalCostRmb();
	}

	/**
	* Sets the hotel total cost rmb of this business trip application.
	*
	* @param hotelTotalCostRmb the hotel total cost rmb of this business trip application
	*/
	@Override
	public void setHotelTotalCostRmb(double hotelTotalCostRmb) {
		_businessTripApplication.setHotelTotalCostRmb(hotelTotalCostRmb);
	}

	/**
	* Returns the hotel total cost eur of this business trip application.
	*
	* @return the hotel total cost eur of this business trip application
	*/
	@Override
	public double getHotelTotalCostEur() {
		return _businessTripApplication.getHotelTotalCostEur();
	}

	/**
	* Sets the hotel total cost eur of this business trip application.
	*
	* @param hotelTotalCostEur the hotel total cost eur of this business trip application
	*/
	@Override
	public void setHotelTotalCostEur(double hotelTotalCostEur) {
		_businessTripApplication.setHotelTotalCostEur(hotelTotalCostEur);
	}

	/**
	* Returns the car rental total cost rmb of this business trip application.
	*
	* @return the car rental total cost rmb of this business trip application
	*/
	@Override
	public double getCarRentalTotalCostRmb() {
		return _businessTripApplication.getCarRentalTotalCostRmb();
	}

	/**
	* Sets the car rental total cost rmb of this business trip application.
	*
	* @param carRentalTotalCostRmb the car rental total cost rmb of this business trip application
	*/
	@Override
	public void setCarRentalTotalCostRmb(double carRentalTotalCostRmb) {
		_businessTripApplication.setCarRentalTotalCostRmb(carRentalTotalCostRmb);
	}

	/**
	* Returns the car rental total cost eur of this business trip application.
	*
	* @return the car rental total cost eur of this business trip application
	*/
	@Override
	public double getCarRentalTotalCostEur() {
		return _businessTripApplication.getCarRentalTotalCostEur();
	}

	/**
	* Sets the car rental total cost eur of this business trip application.
	*
	* @param carRentalTotalCostEur the car rental total cost eur of this business trip application
	*/
	@Override
	public void setCarRentalTotalCostEur(double carRentalTotalCostEur) {
		_businessTripApplication.setCarRentalTotalCostEur(carRentalTotalCostEur);
	}

	/**
	* Returns the remark of this business trip application.
	*
	* @return the remark of this business trip application
	*/
	@Override
	public java.lang.String getRemark() {
		return _businessTripApplication.getRemark();
	}

	/**
	* Sets the remark of this business trip application.
	*
	* @param remark the remark of this business trip application
	*/
	@Override
	public void setRemark(java.lang.String remark) {
		_businessTripApplication.setRemark(remark);
	}

	/**
	* Returns the other emails of this business trip application.
	*
	* @return the other emails of this business trip application
	*/
	@Override
	public java.lang.String getOtherEmails() {
		return _businessTripApplication.getOtherEmails();
	}

	/**
	* Sets the other emails of this business trip application.
	*
	* @param otherEmails the other emails of this business trip application
	*/
	@Override
	public void setOtherEmails(java.lang.String otherEmails) {
		_businessTripApplication.setOtherEmails(otherEmails);
	}

	/**
	* Returns the status of this business trip application.
	*
	* @return the status of this business trip application
	*/
	@Override
	public int getStatus() {
		return _businessTripApplication.getStatus();
	}

	/**
	* Sets the status of this business trip application.
	*
	* @param status the status of this business trip application
	*/
	@Override
	public void setStatus(int status) {
		_businessTripApplication.setStatus(status);
	}

	/**
	* Returns the sap status of this business trip application.
	*
	* @return the sap status of this business trip application
	*/
	@Override
	public int getSapStatus() {
		return _businessTripApplication.getSapStatus();
	}

	/**
	* Sets the sap status of this business trip application.
	*
	* @param sapStatus the sap status of this business trip application
	*/
	@Override
	public void setSapStatus(int sapStatus) {
		_businessTripApplication.setSapStatus(sapStatus);
	}

	/**
	* Returns the sap comments of this business trip application.
	*
	* @return the sap comments of this business trip application
	*/
	@Override
	public java.lang.String getSapComments() {
		return _businessTripApplication.getSapComments();
	}

	/**
	* Sets the sap comments of this business trip application.
	*
	* @param sapComments the sap comments of this business trip application
	*/
	@Override
	public void setSapComments(java.lang.String sapComments) {
		_businessTripApplication.setSapComments(sapComments);
	}

	/**
	* Returns the sap document ID of this business trip application.
	*
	* @return the sap document ID of this business trip application
	*/
	@Override
	public java.lang.String getSapDocumentId() {
		return _businessTripApplication.getSapDocumentId();
	}

	/**
	* Sets the sap document ID of this business trip application.
	*
	* @param sapDocumentId the sap document ID of this business trip application
	*/
	@Override
	public void setSapDocumentId(java.lang.String sapDocumentId) {
		_businessTripApplication.setSapDocumentId(sapDocumentId);
	}

	/**
	* Returns the sap certificate no of this business trip application.
	*
	* @return the sap certificate no of this business trip application
	*/
	@Override
	public java.lang.String getSapCertificateNo() {
		return _businessTripApplication.getSapCertificateNo();
	}

	/**
	* Sets the sap certificate no of this business trip application.
	*
	* @param sapCertificateNo the sap certificate no of this business trip application
	*/
	@Override
	public void setSapCertificateNo(java.lang.String sapCertificateNo) {
		_businessTripApplication.setSapCertificateNo(sapCertificateNo);
	}

	/**
	* Returns the sap company of this business trip application.
	*
	* @return the sap company of this business trip application
	*/
	@Override
	public java.lang.String getSapCompany() {
		return _businessTripApplication.getSapCompany();
	}

	/**
	* Sets the sap company of this business trip application.
	*
	* @param sapCompany the sap company of this business trip application
	*/
	@Override
	public void setSapCompany(java.lang.String sapCompany) {
		_businessTripApplication.setSapCompany(sapCompany);
	}

	/**
	* Returns the sap year of this business trip application.
	*
	* @return the sap year of this business trip application
	*/
	@Override
	public java.lang.String getSapYear() {
		return _businessTripApplication.getSapYear();
	}

	/**
	* Sets the sap year of this business trip application.
	*
	* @param sapYear the sap year of this business trip application
	*/
	@Override
	public void setSapYear(java.lang.String sapYear) {
		_businessTripApplication.setSapYear(sapYear);
	}

	/**
	* Returns the status by user ID of this business trip application.
	*
	* @return the status by user ID of this business trip application
	*/
	@Override
	public long getStatusByUserId() {
		return _businessTripApplication.getStatusByUserId();
	}

	/**
	* Sets the status by user ID of this business trip application.
	*
	* @param statusByUserId the status by user ID of this business trip application
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_businessTripApplication.setStatusByUserId(statusByUserId);
	}

	/**
	* Returns the status by user uuid of this business trip application.
	*
	* @return the status by user uuid of this business trip application
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getStatusByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _businessTripApplication.getStatusByUserUuid();
	}

	/**
	* Sets the status by user uuid of this business trip application.
	*
	* @param statusByUserUuid the status by user uuid of this business trip application
	*/
	@Override
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_businessTripApplication.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Returns the status by user name of this business trip application.
	*
	* @return the status by user name of this business trip application
	*/
	@Override
	public java.lang.String getStatusByUserName() {
		return _businessTripApplication.getStatusByUserName();
	}

	/**
	* Sets the status by user name of this business trip application.
	*
	* @param statusByUserName the status by user name of this business trip application
	*/
	@Override
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_businessTripApplication.setStatusByUserName(statusByUserName);
	}

	/**
	* Returns the status date of this business trip application.
	*
	* @return the status date of this business trip application
	*/
	@Override
	public java.util.Date getStatusDate() {
		return _businessTripApplication.getStatusDate();
	}

	/**
	* Sets the status date of this business trip application.
	*
	* @param statusDate the status date of this business trip application
	*/
	@Override
	public void setStatusDate(java.util.Date statusDate) {
		_businessTripApplication.setStatusDate(statusDate);
	}

	/**
	* Returns the is applicant agent of this business trip application.
	*
	* @return the is applicant agent of this business trip application
	*/
	@Override
	public boolean getIsApplicantAgent() {
		return _businessTripApplication.getIsApplicantAgent();
	}

	/**
	* Returns <code>true</code> if this business trip application is is applicant agent.
	*
	* @return <code>true</code> if this business trip application is is applicant agent; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsApplicantAgent() {
		return _businessTripApplication.isIsApplicantAgent();
	}

	/**
	* Sets whether this business trip application is is applicant agent.
	*
	* @param isApplicantAgent the is applicant agent of this business trip application
	*/
	@Override
	public void setIsApplicantAgent(boolean isApplicantAgent) {
		_businessTripApplication.setIsApplicantAgent(isApplicantAgent);
	}

	/**
	* Returns the is approver agent of this business trip application.
	*
	* @return the is approver agent of this business trip application
	*/
	@Override
	public boolean getIsApproverAgent() {
		return _businessTripApplication.getIsApproverAgent();
	}

	/**
	* Returns <code>true</code> if this business trip application is is approver agent.
	*
	* @return <code>true</code> if this business trip application is is approver agent; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsApproverAgent() {
		return _businessTripApplication.isIsApproverAgent();
	}

	/**
	* Sets whether this business trip application is is approver agent.
	*
	* @param isApproverAgent the is approver agent of this business trip application
	*/
	@Override
	public void setIsApproverAgent(boolean isApproverAgent) {
		_businessTripApplication.setIsApproverAgent(isApproverAgent);
	}

	/**
	* Returns the group ID of this business trip application.
	*
	* @return the group ID of this business trip application
	*/
	@Override
	public long getGroupId() {
		return _businessTripApplication.getGroupId();
	}

	/**
	* Sets the group ID of this business trip application.
	*
	* @param groupId the group ID of this business trip application
	*/
	@Override
	public void setGroupId(long groupId) {
		_businessTripApplication.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this business trip application.
	*
	* @return the user ID of this business trip application
	*/
	@Override
	public long getUserId() {
		return _businessTripApplication.getUserId();
	}

	/**
	* Sets the user ID of this business trip application.
	*
	* @param userId the user ID of this business trip application
	*/
	@Override
	public void setUserId(long userId) {
		_businessTripApplication.setUserId(userId);
	}

	/**
	* Returns the user uuid of this business trip application.
	*
	* @return the user uuid of this business trip application
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _businessTripApplication.getUserUuid();
	}

	/**
	* Sets the user uuid of this business trip application.
	*
	* @param userUuid the user uuid of this business trip application
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_businessTripApplication.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this business trip application.
	*
	* @return the user name of this business trip application
	*/
	@Override
	public java.lang.String getUserName() {
		return _businessTripApplication.getUserName();
	}

	/**
	* Sets the user name of this business trip application.
	*
	* @param userName the user name of this business trip application
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_businessTripApplication.setUserName(userName);
	}

	/**
	* Returns the create date of this business trip application.
	*
	* @return the create date of this business trip application
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _businessTripApplication.getCreateDate();
	}

	/**
	* Sets the create date of this business trip application.
	*
	* @param createDate the create date of this business trip application
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_businessTripApplication.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this business trip application.
	*
	* @return the modified date of this business trip application
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _businessTripApplication.getModifiedDate();
	}

	/**
	* Sets the modified date of this business trip application.
	*
	* @param modifiedDate the modified date of this business trip application
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_businessTripApplication.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the submitted date of this business trip application.
	*
	* @return the submitted date of this business trip application
	*/
	@Override
	public java.util.Date getSubmittedDate() {
		return _businessTripApplication.getSubmittedDate();
	}

	/**
	* Sets the submitted date of this business trip application.
	*
	* @param submittedDate the submitted date of this business trip application
	*/
	@Override
	public void setSubmittedDate(java.util.Date submittedDate) {
		_businessTripApplication.setSubmittedDate(submittedDate);
	}

	/**
	* Returns the company ID of this business trip application.
	*
	* @return the company ID of this business trip application
	*/
	@Override
	public long getCompanyId() {
		return _businessTripApplication.getCompanyId();
	}

	/**
	* Sets the company ID of this business trip application.
	*
	* @param companyId the company ID of this business trip application
	*/
	@Override
	public void setCompanyId(long companyId) {
		_businessTripApplication.setCompanyId(companyId);
	}

	/**
	* @deprecated As of 6.1.0, replaced by {@link #isApproved()}
	*/
	@Override
	public boolean getApproved() {
		return _businessTripApplication.getApproved();
	}

	/**
	* Returns <code>true</code> if this business trip application is approved.
	*
	* @return <code>true</code> if this business trip application is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _businessTripApplication.isApproved();
	}

	/**
	* Returns <code>true</code> if this business trip application is denied.
	*
	* @return <code>true</code> if this business trip application is denied; <code>false</code> otherwise
	*/
	@Override
	public boolean isDenied() {
		return _businessTripApplication.isDenied();
	}

	/**
	* Returns <code>true</code> if this business trip application is a draft.
	*
	* @return <code>true</code> if this business trip application is a draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _businessTripApplication.isDraft();
	}

	/**
	* Returns <code>true</code> if this business trip application is expired.
	*
	* @return <code>true</code> if this business trip application is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _businessTripApplication.isExpired();
	}

	/**
	* Returns <code>true</code> if this business trip application is inactive.
	*
	* @return <code>true</code> if this business trip application is inactive; <code>false</code> otherwise
	*/
	@Override
	public boolean isInactive() {
		return _businessTripApplication.isInactive();
	}

	/**
	* Returns <code>true</code> if this business trip application is incomplete.
	*
	* @return <code>true</code> if this business trip application is incomplete; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncomplete() {
		return _businessTripApplication.isIncomplete();
	}

	/**
	* Returns <code>true</code> if this business trip application is pending.
	*
	* @return <code>true</code> if this business trip application is pending; <code>false</code> otherwise
	*/
	@Override
	public boolean isPending() {
		return _businessTripApplication.isPending();
	}

	/**
	* Returns <code>true</code> if this business trip application is scheduled.
	*
	* @return <code>true</code> if this business trip application is scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isScheduled() {
		return _businessTripApplication.isScheduled();
	}

	@Override
	public boolean isNew() {
		return _businessTripApplication.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_businessTripApplication.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _businessTripApplication.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_businessTripApplication.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _businessTripApplication.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _businessTripApplication.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_businessTripApplication.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _businessTripApplication.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_businessTripApplication.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_businessTripApplication.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_businessTripApplication.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BusinessTripApplicationWrapper((BusinessTripApplication)_businessTripApplication.clone());
	}

	@Override
	public int compareTo(
		com.business.trip.model.BusinessTripApplication businessTripApplication) {
		return _businessTripApplication.compareTo(businessTripApplication);
	}

	@Override
	public int hashCode() {
		return _businessTripApplication.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.business.trip.model.BusinessTripApplication> toCacheModel() {
		return _businessTripApplication.toCacheModel();
	}

	@Override
	public com.business.trip.model.BusinessTripApplication toEscapedModel() {
		return new BusinessTripApplicationWrapper(_businessTripApplication.toEscapedModel());
	}

	@Override
	public com.business.trip.model.BusinessTripApplication toUnescapedModel() {
		return new BusinessTripApplicationWrapper(_businessTripApplication.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _businessTripApplication.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _businessTripApplication.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_businessTripApplication.persist();
	}

	@Override
	public com.liferay.portal.model.User findSupervisorUser(
		com.business.trip.model.BusinessTripApplication businessTripApplication)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _businessTripApplication.findSupervisorUser(businessTripApplication);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BusinessTripApplicationWrapper)) {
			return false;
		}

		BusinessTripApplicationWrapper businessTripApplicationWrapper = (BusinessTripApplicationWrapper)obj;

		if (Validator.equals(_businessTripApplication,
					businessTripApplicationWrapper._businessTripApplication)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public BusinessTripApplication getWrappedBusinessTripApplication() {
		return _businessTripApplication;
	}

	@Override
	public BusinessTripApplication getWrappedModel() {
		return _businessTripApplication;
	}

	@Override
	public void resetOriginalValues() {
		_businessTripApplication.resetOriginalValues();
	}

	private BusinessTripApplication _businessTripApplication;
}