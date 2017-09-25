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

package com.business.trip.model.impl;

import com.business.trip.model.BusinessTripReimbursement;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BusinessTripReimbursement in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see BusinessTripReimbursement
 * @generated
 */
public class BusinessTripReimbursementCacheModel implements CacheModel<BusinessTripReimbursement>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(143);

		sb.append("{businessTripReimbursementId=");
		sb.append(businessTripReimbursementId);
		sb.append(", ticketNo=");
		sb.append(ticketNo);
		sb.append(", bussinessTirpTicketNo=");
		sb.append(bussinessTirpTicketNo);
		sb.append(", processType=");
		sb.append(processType);
		sb.append(", subType=");
		sb.append(subType);
		sb.append(", printName=");
		sb.append(printName);
		sb.append(", staffCode=");
		sb.append(staffCode);
		sb.append(", companyName=");
		sb.append(companyName);
		sb.append(", division=");
		sb.append(division);
		sb.append(", department=");
		sb.append(department);
		sb.append(", costCenter=");
		sb.append(costCenter);
		sb.append(", personalID=");
		sb.append(personalID);
		sb.append(", passportNo=");
		sb.append(passportNo);
		sb.append(", officePhone=");
		sb.append(officePhone);
		sb.append(", mobilePhone=");
		sb.append(mobilePhone);
		sb.append(", email=");
		sb.append(email);
		sb.append(", officeSite=");
		sb.append(officeSite);
		sb.append(", approverId=");
		sb.append(approverId);
		sb.append(", approverName=");
		sb.append(approverName);
		sb.append(", isCrossDepartment=");
		sb.append(isCrossDepartment);
		sb.append(", targetDepartmentId=");
		sb.append(targetDepartmentId);
		sb.append(", targetDepartmentName=");
		sb.append(targetDepartmentName);
		sb.append(", targetCostCenter=");
		sb.append(targetCostCenter);
		sb.append(", targetDepartmentApproverId=");
		sb.append(targetDepartmentApproverId);
		sb.append(", targetDepartmentApproverName=");
		sb.append(targetDepartmentApproverName);
		sb.append(", tripType=");
		sb.append(tripType);
		sb.append(", departureDate=");
		sb.append(departureDate);
		sb.append(", returnDate=");
		sb.append(returnDate);
		sb.append(", purposeOfTheTrip=");
		sb.append(purposeOfTheTrip);
		sb.append(", visitCountriesCities=");
		sb.append(visitCountriesCities);
		sb.append(", advancePayment=");
		sb.append(advancePayment);
		sb.append(", currency=");
		sb.append(currency);
		sb.append(", paymentMethods=");
		sb.append(paymentMethods);
		sb.append(", totalCostRmb=");
		sb.append(totalCostRmb);
		sb.append(", totalCostEur=");
		sb.append(totalCostEur);
		sb.append(", orgTotalCostRmb=");
		sb.append(orgTotalCostRmb);
		sb.append(", orgTotalCostEur=");
		sb.append(orgTotalCostEur);
		sb.append(", hotelTotalCostRmb=");
		sb.append(hotelTotalCostRmb);
		sb.append(", hotelTotalCostEur=");
		sb.append(hotelTotalCostEur);
		sb.append(", carRentalTotalCostRmb=");
		sb.append(carRentalTotalCostRmb);
		sb.append(", carRentalTotalCostEur=");
		sb.append(carRentalTotalCostEur);
		sb.append(", flightCurrency=");
		sb.append(flightCurrency);
		sb.append(", flightTotal=");
		sb.append(flightTotal);
		sb.append(", flightAirFare=");
		sb.append(flightAirFare);
		sb.append(", flightTaxes=");
		sb.append(flightTaxes);
		sb.append(", flightTransactionFee=");
		sb.append(flightTransactionFee);
		sb.append(", totalTravelExpenseRmb=");
		sb.append(totalTravelExpenseRmb);
		sb.append(", totalTravelExpenseEur=");
		sb.append(totalTravelExpenseEur);
		sb.append(", costListInlandTotalRmb=");
		sb.append(costListInlandTotalRmb);
		sb.append(", costListForeignTotalEur=");
		sb.append(costListForeignTotalEur);
		sb.append(", costListForeignTotalRmb=");
		sb.append(costListForeignTotalRmb);
		sb.append(", remark=");
		sb.append(remark);
		sb.append(", isPaybyRmb=");
		sb.append(isPaybyRmb);
		sb.append(", evpId=");
		sb.append(evpId);
		sb.append(", evpName=");
		sb.append(evpName);
		sb.append(", status=");
		sb.append(status);
		sb.append(", sapStatus=");
		sb.append(sapStatus);
		sb.append(", sapComments=");
		sb.append(sapComments);
		sb.append(", sapDocumentId=");
		sb.append(sapDocumentId);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", isApplicantAgent=");
		sb.append(isApplicantAgent);
		sb.append(", isApproverAgent=");
		sb.append(isApproverAgent);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", submittedDate=");
		sb.append(submittedDate);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BusinessTripReimbursement toEntityModel() {
		BusinessTripReimbursementImpl businessTripReimbursementImpl = new BusinessTripReimbursementImpl();

		businessTripReimbursementImpl.setBusinessTripReimbursementId(businessTripReimbursementId);

		if (ticketNo == null) {
			businessTripReimbursementImpl.setTicketNo(StringPool.BLANK);
		}
		else {
			businessTripReimbursementImpl.setTicketNo(ticketNo);
		}

		if (bussinessTirpTicketNo == null) {
			businessTripReimbursementImpl.setBussinessTirpTicketNo(StringPool.BLANK);
		}
		else {
			businessTripReimbursementImpl.setBussinessTirpTicketNo(bussinessTirpTicketNo);
		}

		if (processType == null) {
			businessTripReimbursementImpl.setProcessType(StringPool.BLANK);
		}
		else {
			businessTripReimbursementImpl.setProcessType(processType);
		}

		if (subType == null) {
			businessTripReimbursementImpl.setSubType(StringPool.BLANK);
		}
		else {
			businessTripReimbursementImpl.setSubType(subType);
		}

		if (printName == null) {
			businessTripReimbursementImpl.setPrintName(StringPool.BLANK);
		}
		else {
			businessTripReimbursementImpl.setPrintName(printName);
		}

		businessTripReimbursementImpl.setStaffCode(staffCode);

		if (companyName == null) {
			businessTripReimbursementImpl.setCompanyName(StringPool.BLANK);
		}
		else {
			businessTripReimbursementImpl.setCompanyName(companyName);
		}

		if (division == null) {
			businessTripReimbursementImpl.setDivision(StringPool.BLANK);
		}
		else {
			businessTripReimbursementImpl.setDivision(division);
		}

		if (department == null) {
			businessTripReimbursementImpl.setDepartment(StringPool.BLANK);
		}
		else {
			businessTripReimbursementImpl.setDepartment(department);
		}

		if (costCenter == null) {
			businessTripReimbursementImpl.setCostCenter(StringPool.BLANK);
		}
		else {
			businessTripReimbursementImpl.setCostCenter(costCenter);
		}

		if (personalID == null) {
			businessTripReimbursementImpl.setPersonalID(StringPool.BLANK);
		}
		else {
			businessTripReimbursementImpl.setPersonalID(personalID);
		}

		if (passportNo == null) {
			businessTripReimbursementImpl.setPassportNo(StringPool.BLANK);
		}
		else {
			businessTripReimbursementImpl.setPassportNo(passportNo);
		}

		if (officePhone == null) {
			businessTripReimbursementImpl.setOfficePhone(StringPool.BLANK);
		}
		else {
			businessTripReimbursementImpl.setOfficePhone(officePhone);
		}

		if (mobilePhone == null) {
			businessTripReimbursementImpl.setMobilePhone(StringPool.BLANK);
		}
		else {
			businessTripReimbursementImpl.setMobilePhone(mobilePhone);
		}

		if (email == null) {
			businessTripReimbursementImpl.setEmail(StringPool.BLANK);
		}
		else {
			businessTripReimbursementImpl.setEmail(email);
		}

		if (officeSite == null) {
			businessTripReimbursementImpl.setOfficeSite(StringPool.BLANK);
		}
		else {
			businessTripReimbursementImpl.setOfficeSite(officeSite);
		}

		businessTripReimbursementImpl.setApproverId(approverId);

		if (approverName == null) {
			businessTripReimbursementImpl.setApproverName(StringPool.BLANK);
		}
		else {
			businessTripReimbursementImpl.setApproverName(approverName);
		}

		businessTripReimbursementImpl.setIsCrossDepartment(isCrossDepartment);
		businessTripReimbursementImpl.setTargetDepartmentId(targetDepartmentId);

		if (targetDepartmentName == null) {
			businessTripReimbursementImpl.setTargetDepartmentName(StringPool.BLANK);
		}
		else {
			businessTripReimbursementImpl.setTargetDepartmentName(targetDepartmentName);
		}

		if (targetCostCenter == null) {
			businessTripReimbursementImpl.setTargetCostCenter(StringPool.BLANK);
		}
		else {
			businessTripReimbursementImpl.setTargetCostCenter(targetCostCenter);
		}

		businessTripReimbursementImpl.setTargetDepartmentApproverId(targetDepartmentApproverId);

		if (targetDepartmentApproverName == null) {
			businessTripReimbursementImpl.setTargetDepartmentApproverName(StringPool.BLANK);
		}
		else {
			businessTripReimbursementImpl.setTargetDepartmentApproverName(targetDepartmentApproverName);
		}

		businessTripReimbursementImpl.setTripType(tripType);

		if (departureDate == Long.MIN_VALUE) {
			businessTripReimbursementImpl.setDepartureDate(null);
		}
		else {
			businessTripReimbursementImpl.setDepartureDate(new Date(
					departureDate));
		}

		if (returnDate == Long.MIN_VALUE) {
			businessTripReimbursementImpl.setReturnDate(null);
		}
		else {
			businessTripReimbursementImpl.setReturnDate(new Date(returnDate));
		}

		if (purposeOfTheTrip == null) {
			businessTripReimbursementImpl.setPurposeOfTheTrip(StringPool.BLANK);
		}
		else {
			businessTripReimbursementImpl.setPurposeOfTheTrip(purposeOfTheTrip);
		}

		if (visitCountriesCities == null) {
			businessTripReimbursementImpl.setVisitCountriesCities(StringPool.BLANK);
		}
		else {
			businessTripReimbursementImpl.setVisitCountriesCities(visitCountriesCities);
		}

		businessTripReimbursementImpl.setAdvancePayment(advancePayment);

		if (currency == null) {
			businessTripReimbursementImpl.setCurrency(StringPool.BLANK);
		}
		else {
			businessTripReimbursementImpl.setCurrency(currency);
		}

		if (paymentMethods == null) {
			businessTripReimbursementImpl.setPaymentMethods(StringPool.BLANK);
		}
		else {
			businessTripReimbursementImpl.setPaymentMethods(paymentMethods);
		}

		businessTripReimbursementImpl.setTotalCostRmb(totalCostRmb);
		businessTripReimbursementImpl.setTotalCostEur(totalCostEur);
		businessTripReimbursementImpl.setOrgTotalCostRmb(orgTotalCostRmb);
		businessTripReimbursementImpl.setOrgTotalCostEur(orgTotalCostEur);
		businessTripReimbursementImpl.setHotelTotalCostRmb(hotelTotalCostRmb);
		businessTripReimbursementImpl.setHotelTotalCostEur(hotelTotalCostEur);
		businessTripReimbursementImpl.setCarRentalTotalCostRmb(carRentalTotalCostRmb);
		businessTripReimbursementImpl.setCarRentalTotalCostEur(carRentalTotalCostEur);

		if (flightCurrency == null) {
			businessTripReimbursementImpl.setFlightCurrency(StringPool.BLANK);
		}
		else {
			businessTripReimbursementImpl.setFlightCurrency(flightCurrency);
		}

		businessTripReimbursementImpl.setFlightTotal(flightTotal);
		businessTripReimbursementImpl.setFlightAirFare(flightAirFare);
		businessTripReimbursementImpl.setFlightTaxes(flightTaxes);
		businessTripReimbursementImpl.setFlightTransactionFee(flightTransactionFee);
		businessTripReimbursementImpl.setTotalTravelExpenseRmb(totalTravelExpenseRmb);
		businessTripReimbursementImpl.setTotalTravelExpenseEur(totalTravelExpenseEur);
		businessTripReimbursementImpl.setCostListInlandTotalRmb(costListInlandTotalRmb);
		businessTripReimbursementImpl.setCostListForeignTotalEur(costListForeignTotalEur);
		businessTripReimbursementImpl.setCostListForeignTotalRmb(costListForeignTotalRmb);

		if (remark == null) {
			businessTripReimbursementImpl.setRemark(StringPool.BLANK);
		}
		else {
			businessTripReimbursementImpl.setRemark(remark);
		}

		businessTripReimbursementImpl.setIsPaybyRmb(isPaybyRmb);
		businessTripReimbursementImpl.setEvpId(evpId);

		if (evpName == null) {
			businessTripReimbursementImpl.setEvpName(StringPool.BLANK);
		}
		else {
			businessTripReimbursementImpl.setEvpName(evpName);
		}

		businessTripReimbursementImpl.setStatus(status);
		businessTripReimbursementImpl.setSapStatus(sapStatus);

		if (sapComments == null) {
			businessTripReimbursementImpl.setSapComments(StringPool.BLANK);
		}
		else {
			businessTripReimbursementImpl.setSapComments(sapComments);
		}

		if (sapDocumentId == null) {
			businessTripReimbursementImpl.setSapDocumentId(StringPool.BLANK);
		}
		else {
			businessTripReimbursementImpl.setSapDocumentId(sapDocumentId);
		}

		businessTripReimbursementImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			businessTripReimbursementImpl.setStatusByUserName(StringPool.BLANK);
		}
		else {
			businessTripReimbursementImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			businessTripReimbursementImpl.setStatusDate(null);
		}
		else {
			businessTripReimbursementImpl.setStatusDate(new Date(statusDate));
		}

		businessTripReimbursementImpl.setIsApplicantAgent(isApplicantAgent);
		businessTripReimbursementImpl.setIsApproverAgent(isApproverAgent);
		businessTripReimbursementImpl.setGroupId(groupId);
		businessTripReimbursementImpl.setUserId(userId);

		if (userName == null) {
			businessTripReimbursementImpl.setUserName(StringPool.BLANK);
		}
		else {
			businessTripReimbursementImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			businessTripReimbursementImpl.setCreateDate(null);
		}
		else {
			businessTripReimbursementImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			businessTripReimbursementImpl.setModifiedDate(null);
		}
		else {
			businessTripReimbursementImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (submittedDate == Long.MIN_VALUE) {
			businessTripReimbursementImpl.setSubmittedDate(null);
		}
		else {
			businessTripReimbursementImpl.setSubmittedDate(new Date(
					submittedDate));
		}

		businessTripReimbursementImpl.setCompanyId(companyId);

		businessTripReimbursementImpl.resetOriginalValues();

		return businessTripReimbursementImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		businessTripReimbursementId = objectInput.readLong();
		ticketNo = objectInput.readUTF();
		bussinessTirpTicketNo = objectInput.readUTF();
		processType = objectInput.readUTF();
		subType = objectInput.readUTF();
		printName = objectInput.readUTF();
		staffCode = objectInput.readLong();
		companyName = objectInput.readUTF();
		division = objectInput.readUTF();
		department = objectInput.readUTF();
		costCenter = objectInput.readUTF();
		personalID = objectInput.readUTF();
		passportNo = objectInput.readUTF();
		officePhone = objectInput.readUTF();
		mobilePhone = objectInput.readUTF();
		email = objectInput.readUTF();
		officeSite = objectInput.readUTF();
		approverId = objectInput.readLong();
		approverName = objectInput.readUTF();
		isCrossDepartment = objectInput.readBoolean();
		targetDepartmentId = objectInput.readLong();
		targetDepartmentName = objectInput.readUTF();
		targetCostCenter = objectInput.readUTF();
		targetDepartmentApproverId = objectInput.readLong();
		targetDepartmentApproverName = objectInput.readUTF();
		tripType = objectInput.readInt();
		departureDate = objectInput.readLong();
		returnDate = objectInput.readLong();
		purposeOfTheTrip = objectInput.readUTF();
		visitCountriesCities = objectInput.readUTF();
		advancePayment = objectInput.readDouble();
		currency = objectInput.readUTF();
		paymentMethods = objectInput.readUTF();
		totalCostRmb = objectInput.readDouble();
		totalCostEur = objectInput.readDouble();
		orgTotalCostRmb = objectInput.readDouble();
		orgTotalCostEur = objectInput.readDouble();
		hotelTotalCostRmb = objectInput.readDouble();
		hotelTotalCostEur = objectInput.readDouble();
		carRentalTotalCostRmb = objectInput.readDouble();
		carRentalTotalCostEur = objectInput.readDouble();
		flightCurrency = objectInput.readUTF();
		flightTotal = objectInput.readDouble();
		flightAirFare = objectInput.readDouble();
		flightTaxes = objectInput.readDouble();
		flightTransactionFee = objectInput.readDouble();
		totalTravelExpenseRmb = objectInput.readDouble();
		totalTravelExpenseEur = objectInput.readDouble();
		costListInlandTotalRmb = objectInput.readDouble();
		costListForeignTotalEur = objectInput.readDouble();
		costListForeignTotalRmb = objectInput.readDouble();
		remark = objectInput.readUTF();
		isPaybyRmb = objectInput.readBoolean();
		evpId = objectInput.readLong();
		evpName = objectInput.readUTF();
		status = objectInput.readInt();
		sapStatus = objectInput.readInt();
		sapComments = objectInput.readUTF();
		sapDocumentId = objectInput.readUTF();
		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
		isApplicantAgent = objectInput.readBoolean();
		isApproverAgent = objectInput.readBoolean();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		submittedDate = objectInput.readLong();
		companyId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(businessTripReimbursementId);

		if (ticketNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ticketNo);
		}

		if (bussinessTirpTicketNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bussinessTirpTicketNo);
		}

		if (processType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(processType);
		}

		if (subType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(subType);
		}

		if (printName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(printName);
		}

		objectOutput.writeLong(staffCode);

		if (companyName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(companyName);
		}

		if (division == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(division);
		}

		if (department == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(department);
		}

		if (costCenter == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(costCenter);
		}

		if (personalID == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(personalID);
		}

		if (passportNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(passportNo);
		}

		if (officePhone == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(officePhone);
		}

		if (mobilePhone == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(mobilePhone);
		}

		if (email == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (officeSite == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(officeSite);
		}

		objectOutput.writeLong(approverId);

		if (approverName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(approverName);
		}

		objectOutput.writeBoolean(isCrossDepartment);
		objectOutput.writeLong(targetDepartmentId);

		if (targetDepartmentName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(targetDepartmentName);
		}

		if (targetCostCenter == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(targetCostCenter);
		}

		objectOutput.writeLong(targetDepartmentApproverId);

		if (targetDepartmentApproverName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(targetDepartmentApproverName);
		}

		objectOutput.writeInt(tripType);
		objectOutput.writeLong(departureDate);
		objectOutput.writeLong(returnDate);

		if (purposeOfTheTrip == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(purposeOfTheTrip);
		}

		if (visitCountriesCities == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(visitCountriesCities);
		}

		objectOutput.writeDouble(advancePayment);

		if (currency == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(currency);
		}

		if (paymentMethods == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(paymentMethods);
		}

		objectOutput.writeDouble(totalCostRmb);
		objectOutput.writeDouble(totalCostEur);
		objectOutput.writeDouble(orgTotalCostRmb);
		objectOutput.writeDouble(orgTotalCostEur);
		objectOutput.writeDouble(hotelTotalCostRmb);
		objectOutput.writeDouble(hotelTotalCostEur);
		objectOutput.writeDouble(carRentalTotalCostRmb);
		objectOutput.writeDouble(carRentalTotalCostEur);

		if (flightCurrency == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(flightCurrency);
		}

		objectOutput.writeDouble(flightTotal);
		objectOutput.writeDouble(flightAirFare);
		objectOutput.writeDouble(flightTaxes);
		objectOutput.writeDouble(flightTransactionFee);
		objectOutput.writeDouble(totalTravelExpenseRmb);
		objectOutput.writeDouble(totalTravelExpenseEur);
		objectOutput.writeDouble(costListInlandTotalRmb);
		objectOutput.writeDouble(costListForeignTotalEur);
		objectOutput.writeDouble(costListForeignTotalRmb);

		if (remark == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(remark);
		}

		objectOutput.writeBoolean(isPaybyRmb);
		objectOutput.writeLong(evpId);

		if (evpName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(evpName);
		}

		objectOutput.writeInt(status);
		objectOutput.writeInt(sapStatus);

		if (sapComments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sapComments);
		}

		if (sapDocumentId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sapDocumentId);
		}

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);
		objectOutput.writeBoolean(isApplicantAgent);
		objectOutput.writeBoolean(isApproverAgent);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(submittedDate);
		objectOutput.writeLong(companyId);
	}

	public long businessTripReimbursementId;
	public String ticketNo;
	public String bussinessTirpTicketNo;
	public String processType;
	public String subType;
	public String printName;
	public long staffCode;
	public String companyName;
	public String division;
	public String department;
	public String costCenter;
	public String personalID;
	public String passportNo;
	public String officePhone;
	public String mobilePhone;
	public String email;
	public String officeSite;
	public long approverId;
	public String approverName;
	public boolean isCrossDepartment;
	public long targetDepartmentId;
	public String targetDepartmentName;
	public String targetCostCenter;
	public long targetDepartmentApproverId;
	public String targetDepartmentApproverName;
	public int tripType;
	public long departureDate;
	public long returnDate;
	public String purposeOfTheTrip;
	public String visitCountriesCities;
	public double advancePayment;
	public String currency;
	public String paymentMethods;
	public double totalCostRmb;
	public double totalCostEur;
	public double orgTotalCostRmb;
	public double orgTotalCostEur;
	public double hotelTotalCostRmb;
	public double hotelTotalCostEur;
	public double carRentalTotalCostRmb;
	public double carRentalTotalCostEur;
	public String flightCurrency;
	public double flightTotal;
	public double flightAirFare;
	public double flightTaxes;
	public double flightTransactionFee;
	public double totalTravelExpenseRmb;
	public double totalTravelExpenseEur;
	public double costListInlandTotalRmb;
	public double costListForeignTotalEur;
	public double costListForeignTotalRmb;
	public String remark;
	public boolean isPaybyRmb;
	public long evpId;
	public String evpName;
	public int status;
	public int sapStatus;
	public String sapComments;
	public String sapDocumentId;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public boolean isApplicantAgent;
	public boolean isApproverAgent;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long submittedDate;
	public long companyId;
}