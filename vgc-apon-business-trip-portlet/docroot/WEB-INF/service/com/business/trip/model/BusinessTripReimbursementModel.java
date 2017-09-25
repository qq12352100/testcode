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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.model.WorkflowedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the BusinessTripReimbursement service. Represents a row in the &quot;VgcApon_BtReimbursement&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.business.trip.model.impl.BusinessTripReimbursementModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.business.trip.model.impl.BusinessTripReimbursementImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BusinessTripReimbursement
 * @see com.business.trip.model.impl.BusinessTripReimbursementImpl
 * @see com.business.trip.model.impl.BusinessTripReimbursementModelImpl
 * @generated
 */
public interface BusinessTripReimbursementModel extends BaseModel<BusinessTripReimbursement>,
	GroupedModel, WorkflowedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a business trip reimbursement model instance should use the {@link BusinessTripReimbursement} interface instead.
	 */

	/**
	 * Returns the primary key of this business trip reimbursement.
	 *
	 * @return the primary key of this business trip reimbursement
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this business trip reimbursement.
	 *
	 * @param primaryKey the primary key of this business trip reimbursement
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the business trip reimbursement ID of this business trip reimbursement.
	 *
	 * @return the business trip reimbursement ID of this business trip reimbursement
	 */
	public long getBusinessTripReimbursementId();

	/**
	 * Sets the business trip reimbursement ID of this business trip reimbursement.
	 *
	 * @param businessTripReimbursementId the business trip reimbursement ID of this business trip reimbursement
	 */
	public void setBusinessTripReimbursementId(long businessTripReimbursementId);

	/**
	 * Returns the ticket no of this business trip reimbursement.
	 *
	 * @return the ticket no of this business trip reimbursement
	 */
	@AutoEscape
	public String getTicketNo();

	/**
	 * Sets the ticket no of this business trip reimbursement.
	 *
	 * @param ticketNo the ticket no of this business trip reimbursement
	 */
	public void setTicketNo(String ticketNo);

	/**
	 * Returns the bussiness tirp ticket no of this business trip reimbursement.
	 *
	 * @return the bussiness tirp ticket no of this business trip reimbursement
	 */
	@AutoEscape
	public String getBussinessTirpTicketNo();

	/**
	 * Sets the bussiness tirp ticket no of this business trip reimbursement.
	 *
	 * @param bussinessTirpTicketNo the bussiness tirp ticket no of this business trip reimbursement
	 */
	public void setBussinessTirpTicketNo(String bussinessTirpTicketNo);

	/**
	 * Returns the process type of this business trip reimbursement.
	 *
	 * @return the process type of this business trip reimbursement
	 */
	@AutoEscape
	public String getProcessType();

	/**
	 * Sets the process type of this business trip reimbursement.
	 *
	 * @param processType the process type of this business trip reimbursement
	 */
	public void setProcessType(String processType);

	/**
	 * Returns the sub type of this business trip reimbursement.
	 *
	 * @return the sub type of this business trip reimbursement
	 */
	@AutoEscape
	public String getSubType();

	/**
	 * Sets the sub type of this business trip reimbursement.
	 *
	 * @param subType the sub type of this business trip reimbursement
	 */
	public void setSubType(String subType);

	/**
	 * Returns the print name of this business trip reimbursement.
	 *
	 * @return the print name of this business trip reimbursement
	 */
	@AutoEscape
	public String getPrintName();

	/**
	 * Sets the print name of this business trip reimbursement.
	 *
	 * @param printName the print name of this business trip reimbursement
	 */
	public void setPrintName(String printName);

	/**
	 * Returns the staff code of this business trip reimbursement.
	 *
	 * @return the staff code of this business trip reimbursement
	 */
	public long getStaffCode();

	/**
	 * Sets the staff code of this business trip reimbursement.
	 *
	 * @param staffCode the staff code of this business trip reimbursement
	 */
	public void setStaffCode(long staffCode);

	/**
	 * Returns the company name of this business trip reimbursement.
	 *
	 * @return the company name of this business trip reimbursement
	 */
	@AutoEscape
	public String getCompanyName();

	/**
	 * Sets the company name of this business trip reimbursement.
	 *
	 * @param companyName the company name of this business trip reimbursement
	 */
	public void setCompanyName(String companyName);

	/**
	 * Returns the division of this business trip reimbursement.
	 *
	 * @return the division of this business trip reimbursement
	 */
	@AutoEscape
	public String getDivision();

	/**
	 * Sets the division of this business trip reimbursement.
	 *
	 * @param division the division of this business trip reimbursement
	 */
	public void setDivision(String division);

	/**
	 * Returns the department of this business trip reimbursement.
	 *
	 * @return the department of this business trip reimbursement
	 */
	@AutoEscape
	public String getDepartment();

	/**
	 * Sets the department of this business trip reimbursement.
	 *
	 * @param department the department of this business trip reimbursement
	 */
	public void setDepartment(String department);

	/**
	 * Returns the cost center of this business trip reimbursement.
	 *
	 * @return the cost center of this business trip reimbursement
	 */
	@AutoEscape
	public String getCostCenter();

	/**
	 * Sets the cost center of this business trip reimbursement.
	 *
	 * @param costCenter the cost center of this business trip reimbursement
	 */
	public void setCostCenter(String costCenter);

	/**
	 * Returns the personal i d of this business trip reimbursement.
	 *
	 * @return the personal i d of this business trip reimbursement
	 */
	@AutoEscape
	public String getPersonalID();

	/**
	 * Sets the personal i d of this business trip reimbursement.
	 *
	 * @param personalID the personal i d of this business trip reimbursement
	 */
	public void setPersonalID(String personalID);

	/**
	 * Returns the passport no of this business trip reimbursement.
	 *
	 * @return the passport no of this business trip reimbursement
	 */
	@AutoEscape
	public String getPassportNo();

	/**
	 * Sets the passport no of this business trip reimbursement.
	 *
	 * @param passportNo the passport no of this business trip reimbursement
	 */
	public void setPassportNo(String passportNo);

	/**
	 * Returns the office phone of this business trip reimbursement.
	 *
	 * @return the office phone of this business trip reimbursement
	 */
	@AutoEscape
	public String getOfficePhone();

	/**
	 * Sets the office phone of this business trip reimbursement.
	 *
	 * @param officePhone the office phone of this business trip reimbursement
	 */
	public void setOfficePhone(String officePhone);

	/**
	 * Returns the mobile phone of this business trip reimbursement.
	 *
	 * @return the mobile phone of this business trip reimbursement
	 */
	@AutoEscape
	public String getMobilePhone();

	/**
	 * Sets the mobile phone of this business trip reimbursement.
	 *
	 * @param mobilePhone the mobile phone of this business trip reimbursement
	 */
	public void setMobilePhone(String mobilePhone);

	/**
	 * Returns the email of this business trip reimbursement.
	 *
	 * @return the email of this business trip reimbursement
	 */
	@AutoEscape
	public String getEmail();

	/**
	 * Sets the email of this business trip reimbursement.
	 *
	 * @param email the email of this business trip reimbursement
	 */
	public void setEmail(String email);

	/**
	 * Returns the office site of this business trip reimbursement.
	 *
	 * @return the office site of this business trip reimbursement
	 */
	@AutoEscape
	public String getOfficeSite();

	/**
	 * Sets the office site of this business trip reimbursement.
	 *
	 * @param officeSite the office site of this business trip reimbursement
	 */
	public void setOfficeSite(String officeSite);

	/**
	 * Returns the approver ID of this business trip reimbursement.
	 *
	 * @return the approver ID of this business trip reimbursement
	 */
	public long getApproverId();

	/**
	 * Sets the approver ID of this business trip reimbursement.
	 *
	 * @param approverId the approver ID of this business trip reimbursement
	 */
	public void setApproverId(long approverId);

	/**
	 * Returns the approver name of this business trip reimbursement.
	 *
	 * @return the approver name of this business trip reimbursement
	 */
	@AutoEscape
	public String getApproverName();

	/**
	 * Sets the approver name of this business trip reimbursement.
	 *
	 * @param approverName the approver name of this business trip reimbursement
	 */
	public void setApproverName(String approverName);

	/**
	 * Returns the is cross department of this business trip reimbursement.
	 *
	 * @return the is cross department of this business trip reimbursement
	 */
	public boolean getIsCrossDepartment();

	/**
	 * Returns <code>true</code> if this business trip reimbursement is is cross department.
	 *
	 * @return <code>true</code> if this business trip reimbursement is is cross department; <code>false</code> otherwise
	 */
	public boolean isIsCrossDepartment();

	/**
	 * Sets whether this business trip reimbursement is is cross department.
	 *
	 * @param isCrossDepartment the is cross department of this business trip reimbursement
	 */
	public void setIsCrossDepartment(boolean isCrossDepartment);

	/**
	 * Returns the target department ID of this business trip reimbursement.
	 *
	 * @return the target department ID of this business trip reimbursement
	 */
	public long getTargetDepartmentId();

	/**
	 * Sets the target department ID of this business trip reimbursement.
	 *
	 * @param targetDepartmentId the target department ID of this business trip reimbursement
	 */
	public void setTargetDepartmentId(long targetDepartmentId);

	/**
	 * Returns the target department name of this business trip reimbursement.
	 *
	 * @return the target department name of this business trip reimbursement
	 */
	@AutoEscape
	public String getTargetDepartmentName();

	/**
	 * Sets the target department name of this business trip reimbursement.
	 *
	 * @param targetDepartmentName the target department name of this business trip reimbursement
	 */
	public void setTargetDepartmentName(String targetDepartmentName);

	/**
	 * Returns the target cost center of this business trip reimbursement.
	 *
	 * @return the target cost center of this business trip reimbursement
	 */
	@AutoEscape
	public String getTargetCostCenter();

	/**
	 * Sets the target cost center of this business trip reimbursement.
	 *
	 * @param targetCostCenter the target cost center of this business trip reimbursement
	 */
	public void setTargetCostCenter(String targetCostCenter);

	/**
	 * Returns the target department approver ID of this business trip reimbursement.
	 *
	 * @return the target department approver ID of this business trip reimbursement
	 */
	public long getTargetDepartmentApproverId();

	/**
	 * Sets the target department approver ID of this business trip reimbursement.
	 *
	 * @param targetDepartmentApproverId the target department approver ID of this business trip reimbursement
	 */
	public void setTargetDepartmentApproverId(long targetDepartmentApproverId);

	/**
	 * Returns the target department approver name of this business trip reimbursement.
	 *
	 * @return the target department approver name of this business trip reimbursement
	 */
	@AutoEscape
	public String getTargetDepartmentApproverName();

	/**
	 * Sets the target department approver name of this business trip reimbursement.
	 *
	 * @param targetDepartmentApproverName the target department approver name of this business trip reimbursement
	 */
	public void setTargetDepartmentApproverName(
		String targetDepartmentApproverName);

	/**
	 * Returns the trip type of this business trip reimbursement.
	 *
	 * @return the trip type of this business trip reimbursement
	 */
	public int getTripType();

	/**
	 * Sets the trip type of this business trip reimbursement.
	 *
	 * @param tripType the trip type of this business trip reimbursement
	 */
	public void setTripType(int tripType);

	/**
	 * Returns the departure date of this business trip reimbursement.
	 *
	 * @return the departure date of this business trip reimbursement
	 */
	public Date getDepartureDate();

	/**
	 * Sets the departure date of this business trip reimbursement.
	 *
	 * @param departureDate the departure date of this business trip reimbursement
	 */
	public void setDepartureDate(Date departureDate);

	/**
	 * Returns the return date of this business trip reimbursement.
	 *
	 * @return the return date of this business trip reimbursement
	 */
	public Date getReturnDate();

	/**
	 * Sets the return date of this business trip reimbursement.
	 *
	 * @param returnDate the return date of this business trip reimbursement
	 */
	public void setReturnDate(Date returnDate);

	/**
	 * Returns the purpose of the trip of this business trip reimbursement.
	 *
	 * @return the purpose of the trip of this business trip reimbursement
	 */
	@AutoEscape
	public String getPurposeOfTheTrip();

	/**
	 * Sets the purpose of the trip of this business trip reimbursement.
	 *
	 * @param purposeOfTheTrip the purpose of the trip of this business trip reimbursement
	 */
	public void setPurposeOfTheTrip(String purposeOfTheTrip);

	/**
	 * Returns the visit countries cities of this business trip reimbursement.
	 *
	 * @return the visit countries cities of this business trip reimbursement
	 */
	@AutoEscape
	public String getVisitCountriesCities();

	/**
	 * Sets the visit countries cities of this business trip reimbursement.
	 *
	 * @param visitCountriesCities the visit countries cities of this business trip reimbursement
	 */
	public void setVisitCountriesCities(String visitCountriesCities);

	/**
	 * Returns the advance payment of this business trip reimbursement.
	 *
	 * @return the advance payment of this business trip reimbursement
	 */
	public double getAdvancePayment();

	/**
	 * Sets the advance payment of this business trip reimbursement.
	 *
	 * @param advancePayment the advance payment of this business trip reimbursement
	 */
	public void setAdvancePayment(double advancePayment);

	/**
	 * Returns the currency of this business trip reimbursement.
	 *
	 * @return the currency of this business trip reimbursement
	 */
	@AutoEscape
	public String getCurrency();

	/**
	 * Sets the currency of this business trip reimbursement.
	 *
	 * @param currency the currency of this business trip reimbursement
	 */
	public void setCurrency(String currency);

	/**
	 * Returns the payment methods of this business trip reimbursement.
	 *
	 * @return the payment methods of this business trip reimbursement
	 */
	@AutoEscape
	public String getPaymentMethods();

	/**
	 * Sets the payment methods of this business trip reimbursement.
	 *
	 * @param paymentMethods the payment methods of this business trip reimbursement
	 */
	public void setPaymentMethods(String paymentMethods);

	/**
	 * Returns the total cost rmb of this business trip reimbursement.
	 *
	 * @return the total cost rmb of this business trip reimbursement
	 */
	public double getTotalCostRmb();

	/**
	 * Sets the total cost rmb of this business trip reimbursement.
	 *
	 * @param totalCostRmb the total cost rmb of this business trip reimbursement
	 */
	public void setTotalCostRmb(double totalCostRmb);

	/**
	 * Returns the total cost eur of this business trip reimbursement.
	 *
	 * @return the total cost eur of this business trip reimbursement
	 */
	public double getTotalCostEur();

	/**
	 * Sets the total cost eur of this business trip reimbursement.
	 *
	 * @param totalCostEur the total cost eur of this business trip reimbursement
	 */
	public void setTotalCostEur(double totalCostEur);

	/**
	 * Returns the org total cost rmb of this business trip reimbursement.
	 *
	 * @return the org total cost rmb of this business trip reimbursement
	 */
	public double getOrgTotalCostRmb();

	/**
	 * Sets the org total cost rmb of this business trip reimbursement.
	 *
	 * @param orgTotalCostRmb the org total cost rmb of this business trip reimbursement
	 */
	public void setOrgTotalCostRmb(double orgTotalCostRmb);

	/**
	 * Returns the org total cost eur of this business trip reimbursement.
	 *
	 * @return the org total cost eur of this business trip reimbursement
	 */
	public double getOrgTotalCostEur();

	/**
	 * Sets the org total cost eur of this business trip reimbursement.
	 *
	 * @param orgTotalCostEur the org total cost eur of this business trip reimbursement
	 */
	public void setOrgTotalCostEur(double orgTotalCostEur);

	/**
	 * Returns the hotel total cost rmb of this business trip reimbursement.
	 *
	 * @return the hotel total cost rmb of this business trip reimbursement
	 */
	public double getHotelTotalCostRmb();

	/**
	 * Sets the hotel total cost rmb of this business trip reimbursement.
	 *
	 * @param hotelTotalCostRmb the hotel total cost rmb of this business trip reimbursement
	 */
	public void setHotelTotalCostRmb(double hotelTotalCostRmb);

	/**
	 * Returns the hotel total cost eur of this business trip reimbursement.
	 *
	 * @return the hotel total cost eur of this business trip reimbursement
	 */
	public double getHotelTotalCostEur();

	/**
	 * Sets the hotel total cost eur of this business trip reimbursement.
	 *
	 * @param hotelTotalCostEur the hotel total cost eur of this business trip reimbursement
	 */
	public void setHotelTotalCostEur(double hotelTotalCostEur);

	/**
	 * Returns the car rental total cost rmb of this business trip reimbursement.
	 *
	 * @return the car rental total cost rmb of this business trip reimbursement
	 */
	public double getCarRentalTotalCostRmb();

	/**
	 * Sets the car rental total cost rmb of this business trip reimbursement.
	 *
	 * @param carRentalTotalCostRmb the car rental total cost rmb of this business trip reimbursement
	 */
	public void setCarRentalTotalCostRmb(double carRentalTotalCostRmb);

	/**
	 * Returns the car rental total cost eur of this business trip reimbursement.
	 *
	 * @return the car rental total cost eur of this business trip reimbursement
	 */
	public double getCarRentalTotalCostEur();

	/**
	 * Sets the car rental total cost eur of this business trip reimbursement.
	 *
	 * @param carRentalTotalCostEur the car rental total cost eur of this business trip reimbursement
	 */
	public void setCarRentalTotalCostEur(double carRentalTotalCostEur);

	/**
	 * Returns the flight currency of this business trip reimbursement.
	 *
	 * @return the flight currency of this business trip reimbursement
	 */
	@AutoEscape
	public String getFlightCurrency();

	/**
	 * Sets the flight currency of this business trip reimbursement.
	 *
	 * @param flightCurrency the flight currency of this business trip reimbursement
	 */
	public void setFlightCurrency(String flightCurrency);

	/**
	 * Returns the flight total of this business trip reimbursement.
	 *
	 * @return the flight total of this business trip reimbursement
	 */
	public double getFlightTotal();

	/**
	 * Sets the flight total of this business trip reimbursement.
	 *
	 * @param flightTotal the flight total of this business trip reimbursement
	 */
	public void setFlightTotal(double flightTotal);

	/**
	 * Returns the flight air fare of this business trip reimbursement.
	 *
	 * @return the flight air fare of this business trip reimbursement
	 */
	public double getFlightAirFare();

	/**
	 * Sets the flight air fare of this business trip reimbursement.
	 *
	 * @param flightAirFare the flight air fare of this business trip reimbursement
	 */
	public void setFlightAirFare(double flightAirFare);

	/**
	 * Returns the flight taxes of this business trip reimbursement.
	 *
	 * @return the flight taxes of this business trip reimbursement
	 */
	public double getFlightTaxes();

	/**
	 * Sets the flight taxes of this business trip reimbursement.
	 *
	 * @param flightTaxes the flight taxes of this business trip reimbursement
	 */
	public void setFlightTaxes(double flightTaxes);

	/**
	 * Returns the flight transaction fee of this business trip reimbursement.
	 *
	 * @return the flight transaction fee of this business trip reimbursement
	 */
	public double getFlightTransactionFee();

	/**
	 * Sets the flight transaction fee of this business trip reimbursement.
	 *
	 * @param flightTransactionFee the flight transaction fee of this business trip reimbursement
	 */
	public void setFlightTransactionFee(double flightTransactionFee);

	/**
	 * Returns the total travel expense rmb of this business trip reimbursement.
	 *
	 * @return the total travel expense rmb of this business trip reimbursement
	 */
	public double getTotalTravelExpenseRmb();

	/**
	 * Sets the total travel expense rmb of this business trip reimbursement.
	 *
	 * @param totalTravelExpenseRmb the total travel expense rmb of this business trip reimbursement
	 */
	public void setTotalTravelExpenseRmb(double totalTravelExpenseRmb);

	/**
	 * Returns the total travel expense eur of this business trip reimbursement.
	 *
	 * @return the total travel expense eur of this business trip reimbursement
	 */
	public double getTotalTravelExpenseEur();

	/**
	 * Sets the total travel expense eur of this business trip reimbursement.
	 *
	 * @param totalTravelExpenseEur the total travel expense eur of this business trip reimbursement
	 */
	public void setTotalTravelExpenseEur(double totalTravelExpenseEur);

	/**
	 * Returns the cost list inland total rmb of this business trip reimbursement.
	 *
	 * @return the cost list inland total rmb of this business trip reimbursement
	 */
	public double getCostListInlandTotalRmb();

	/**
	 * Sets the cost list inland total rmb of this business trip reimbursement.
	 *
	 * @param costListInlandTotalRmb the cost list inland total rmb of this business trip reimbursement
	 */
	public void setCostListInlandTotalRmb(double costListInlandTotalRmb);

	/**
	 * Returns the cost list foreign total eur of this business trip reimbursement.
	 *
	 * @return the cost list foreign total eur of this business trip reimbursement
	 */
	public double getCostListForeignTotalEur();

	/**
	 * Sets the cost list foreign total eur of this business trip reimbursement.
	 *
	 * @param costListForeignTotalEur the cost list foreign total eur of this business trip reimbursement
	 */
	public void setCostListForeignTotalEur(double costListForeignTotalEur);

	/**
	 * Returns the cost list foreign total rmb of this business trip reimbursement.
	 *
	 * @return the cost list foreign total rmb of this business trip reimbursement
	 */
	public double getCostListForeignTotalRmb();

	/**
	 * Sets the cost list foreign total rmb of this business trip reimbursement.
	 *
	 * @param costListForeignTotalRmb the cost list foreign total rmb of this business trip reimbursement
	 */
	public void setCostListForeignTotalRmb(double costListForeignTotalRmb);

	/**
	 * Returns the remark of this business trip reimbursement.
	 *
	 * @return the remark of this business trip reimbursement
	 */
	@AutoEscape
	public String getRemark();

	/**
	 * Sets the remark of this business trip reimbursement.
	 *
	 * @param remark the remark of this business trip reimbursement
	 */
	public void setRemark(String remark);

	/**
	 * Returns the is payby rmb of this business trip reimbursement.
	 *
	 * @return the is payby rmb of this business trip reimbursement
	 */
	public boolean getIsPaybyRmb();

	/**
	 * Returns <code>true</code> if this business trip reimbursement is is payby rmb.
	 *
	 * @return <code>true</code> if this business trip reimbursement is is payby rmb; <code>false</code> otherwise
	 */
	public boolean isIsPaybyRmb();

	/**
	 * Sets whether this business trip reimbursement is is payby rmb.
	 *
	 * @param isPaybyRmb the is payby rmb of this business trip reimbursement
	 */
	public void setIsPaybyRmb(boolean isPaybyRmb);

	/**
	 * Returns the evp ID of this business trip reimbursement.
	 *
	 * @return the evp ID of this business trip reimbursement
	 */
	public long getEvpId();

	/**
	 * Sets the evp ID of this business trip reimbursement.
	 *
	 * @param evpId the evp ID of this business trip reimbursement
	 */
	public void setEvpId(long evpId);

	/**
	 * Returns the evp name of this business trip reimbursement.
	 *
	 * @return the evp name of this business trip reimbursement
	 */
	@AutoEscape
	public String getEvpName();

	/**
	 * Sets the evp name of this business trip reimbursement.
	 *
	 * @param evpName the evp name of this business trip reimbursement
	 */
	public void setEvpName(String evpName);

	/**
	 * Returns the status of this business trip reimbursement.
	 *
	 * @return the status of this business trip reimbursement
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this business trip reimbursement.
	 *
	 * @param status the status of this business trip reimbursement
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the sap status of this business trip reimbursement.
	 *
	 * @return the sap status of this business trip reimbursement
	 */
	public int getSapStatus();

	/**
	 * Sets the sap status of this business trip reimbursement.
	 *
	 * @param sapStatus the sap status of this business trip reimbursement
	 */
	public void setSapStatus(int sapStatus);

	/**
	 * Returns the sap comments of this business trip reimbursement.
	 *
	 * @return the sap comments of this business trip reimbursement
	 */
	@AutoEscape
	public String getSapComments();

	/**
	 * Sets the sap comments of this business trip reimbursement.
	 *
	 * @param sapComments the sap comments of this business trip reimbursement
	 */
	public void setSapComments(String sapComments);

	/**
	 * Returns the sap document ID of this business trip reimbursement.
	 *
	 * @return the sap document ID of this business trip reimbursement
	 */
	@AutoEscape
	public String getSapDocumentId();

	/**
	 * Sets the sap document ID of this business trip reimbursement.
	 *
	 * @param sapDocumentId the sap document ID of this business trip reimbursement
	 */
	public void setSapDocumentId(String sapDocumentId);

	/**
	 * Returns the status by user ID of this business trip reimbursement.
	 *
	 * @return the status by user ID of this business trip reimbursement
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this business trip reimbursement.
	 *
	 * @param statusByUserId the status by user ID of this business trip reimbursement
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this business trip reimbursement.
	 *
	 * @return the status by user uuid of this business trip reimbursement
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getStatusByUserUuid() throws SystemException;

	/**
	 * Sets the status by user uuid of this business trip reimbursement.
	 *
	 * @param statusByUserUuid the status by user uuid of this business trip reimbursement
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this business trip reimbursement.
	 *
	 * @return the status by user name of this business trip reimbursement
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this business trip reimbursement.
	 *
	 * @param statusByUserName the status by user name of this business trip reimbursement
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this business trip reimbursement.
	 *
	 * @return the status date of this business trip reimbursement
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this business trip reimbursement.
	 *
	 * @param statusDate the status date of this business trip reimbursement
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns the is applicant agent of this business trip reimbursement.
	 *
	 * @return the is applicant agent of this business trip reimbursement
	 */
	public boolean getIsApplicantAgent();

	/**
	 * Returns <code>true</code> if this business trip reimbursement is is applicant agent.
	 *
	 * @return <code>true</code> if this business trip reimbursement is is applicant agent; <code>false</code> otherwise
	 */
	public boolean isIsApplicantAgent();

	/**
	 * Sets whether this business trip reimbursement is is applicant agent.
	 *
	 * @param isApplicantAgent the is applicant agent of this business trip reimbursement
	 */
	public void setIsApplicantAgent(boolean isApplicantAgent);

	/**
	 * Returns the is approver agent of this business trip reimbursement.
	 *
	 * @return the is approver agent of this business trip reimbursement
	 */
	public boolean getIsApproverAgent();

	/**
	 * Returns <code>true</code> if this business trip reimbursement is is approver agent.
	 *
	 * @return <code>true</code> if this business trip reimbursement is is approver agent; <code>false</code> otherwise
	 */
	public boolean isIsApproverAgent();

	/**
	 * Sets whether this business trip reimbursement is is approver agent.
	 *
	 * @param isApproverAgent the is approver agent of this business trip reimbursement
	 */
	public void setIsApproverAgent(boolean isApproverAgent);

	/**
	 * Returns the group ID of this business trip reimbursement.
	 *
	 * @return the group ID of this business trip reimbursement
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this business trip reimbursement.
	 *
	 * @param groupId the group ID of this business trip reimbursement
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the user ID of this business trip reimbursement.
	 *
	 * @return the user ID of this business trip reimbursement
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this business trip reimbursement.
	 *
	 * @param userId the user ID of this business trip reimbursement
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this business trip reimbursement.
	 *
	 * @return the user uuid of this business trip reimbursement
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this business trip reimbursement.
	 *
	 * @param userUuid the user uuid of this business trip reimbursement
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this business trip reimbursement.
	 *
	 * @return the user name of this business trip reimbursement
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this business trip reimbursement.
	 *
	 * @param userName the user name of this business trip reimbursement
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this business trip reimbursement.
	 *
	 * @return the create date of this business trip reimbursement
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this business trip reimbursement.
	 *
	 * @param createDate the create date of this business trip reimbursement
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this business trip reimbursement.
	 *
	 * @return the modified date of this business trip reimbursement
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this business trip reimbursement.
	 *
	 * @param modifiedDate the modified date of this business trip reimbursement
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the submitted date of this business trip reimbursement.
	 *
	 * @return the submitted date of this business trip reimbursement
	 */
	public Date getSubmittedDate();

	/**
	 * Sets the submitted date of this business trip reimbursement.
	 *
	 * @param submittedDate the submitted date of this business trip reimbursement
	 */
	public void setSubmittedDate(Date submittedDate);

	/**
	 * Returns the company ID of this business trip reimbursement.
	 *
	 * @return the company ID of this business trip reimbursement
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this business trip reimbursement.
	 *
	 * @param companyId the company ID of this business trip reimbursement
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #isApproved()}
	 */
	@Override
	public boolean getApproved();

	/**
	 * Returns <code>true</code> if this business trip reimbursement is approved.
	 *
	 * @return <code>true</code> if this business trip reimbursement is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this business trip reimbursement is denied.
	 *
	 * @return <code>true</code> if this business trip reimbursement is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this business trip reimbursement is a draft.
	 *
	 * @return <code>true</code> if this business trip reimbursement is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this business trip reimbursement is expired.
	 *
	 * @return <code>true</code> if this business trip reimbursement is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this business trip reimbursement is inactive.
	 *
	 * @return <code>true</code> if this business trip reimbursement is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this business trip reimbursement is incomplete.
	 *
	 * @return <code>true</code> if this business trip reimbursement is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this business trip reimbursement is pending.
	 *
	 * @return <code>true</code> if this business trip reimbursement is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this business trip reimbursement is scheduled.
	 *
	 * @return <code>true</code> if this business trip reimbursement is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled();

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(
		com.business.trip.model.BusinessTripReimbursement businessTripReimbursement);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.business.trip.model.BusinessTripReimbursement> toCacheModel();

	@Override
	public com.business.trip.model.BusinessTripReimbursement toEscapedModel();

	@Override
	public com.business.trip.model.BusinessTripReimbursement toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}