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

import com.business.trip.model.BusinessTripApplication;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BusinessTripApplication in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see BusinessTripApplication
 * @generated
 */
public class BusinessTripApplicationCacheModel implements CacheModel<BusinessTripApplication>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(123);

		sb.append("{businessTripApplicationId=");
		sb.append(businessTripApplicationId);
		sb.append(", ticketNo=");
		sb.append(ticketNo);
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
		sb.append(", evpId=");
		sb.append(evpId);
		sb.append(", evpName=");
		sb.append(evpName);
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
		sb.append(", hotelTotalCostRmb=");
		sb.append(hotelTotalCostRmb);
		sb.append(", hotelTotalCostEur=");
		sb.append(hotelTotalCostEur);
		sb.append(", carRentalTotalCostRmb=");
		sb.append(carRentalTotalCostRmb);
		sb.append(", carRentalTotalCostEur=");
		sb.append(carRentalTotalCostEur);
		sb.append(", remark=");
		sb.append(remark);
		sb.append(", otherEmails=");
		sb.append(otherEmails);
		sb.append(", status=");
		sb.append(status);
		sb.append(", sapStatus=");
		sb.append(sapStatus);
		sb.append(", sapComments=");
		sb.append(sapComments);
		sb.append(", sapDocumentId=");
		sb.append(sapDocumentId);
		sb.append(", sapCertificateNo=");
		sb.append(sapCertificateNo);
		sb.append(", sapCompany=");
		sb.append(sapCompany);
		sb.append(", sapYear=");
		sb.append(sapYear);
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
	public BusinessTripApplication toEntityModel() {
		BusinessTripApplicationImpl businessTripApplicationImpl = new BusinessTripApplicationImpl();

		businessTripApplicationImpl.setBusinessTripApplicationId(businessTripApplicationId);

		if (ticketNo == null) {
			businessTripApplicationImpl.setTicketNo(StringPool.BLANK);
		}
		else {
			businessTripApplicationImpl.setTicketNo(ticketNo);
		}

		if (processType == null) {
			businessTripApplicationImpl.setProcessType(StringPool.BLANK);
		}
		else {
			businessTripApplicationImpl.setProcessType(processType);
		}

		if (subType == null) {
			businessTripApplicationImpl.setSubType(StringPool.BLANK);
		}
		else {
			businessTripApplicationImpl.setSubType(subType);
		}

		if (printName == null) {
			businessTripApplicationImpl.setPrintName(StringPool.BLANK);
		}
		else {
			businessTripApplicationImpl.setPrintName(printName);
		}

		businessTripApplicationImpl.setStaffCode(staffCode);

		if (companyName == null) {
			businessTripApplicationImpl.setCompanyName(StringPool.BLANK);
		}
		else {
			businessTripApplicationImpl.setCompanyName(companyName);
		}

		if (division == null) {
			businessTripApplicationImpl.setDivision(StringPool.BLANK);
		}
		else {
			businessTripApplicationImpl.setDivision(division);
		}

		if (department == null) {
			businessTripApplicationImpl.setDepartment(StringPool.BLANK);
		}
		else {
			businessTripApplicationImpl.setDepartment(department);
		}

		if (costCenter == null) {
			businessTripApplicationImpl.setCostCenter(StringPool.BLANK);
		}
		else {
			businessTripApplicationImpl.setCostCenter(costCenter);
		}

		if (personalID == null) {
			businessTripApplicationImpl.setPersonalID(StringPool.BLANK);
		}
		else {
			businessTripApplicationImpl.setPersonalID(personalID);
		}

		if (passportNo == null) {
			businessTripApplicationImpl.setPassportNo(StringPool.BLANK);
		}
		else {
			businessTripApplicationImpl.setPassportNo(passportNo);
		}

		if (officePhone == null) {
			businessTripApplicationImpl.setOfficePhone(StringPool.BLANK);
		}
		else {
			businessTripApplicationImpl.setOfficePhone(officePhone);
		}

		if (mobilePhone == null) {
			businessTripApplicationImpl.setMobilePhone(StringPool.BLANK);
		}
		else {
			businessTripApplicationImpl.setMobilePhone(mobilePhone);
		}

		if (email == null) {
			businessTripApplicationImpl.setEmail(StringPool.BLANK);
		}
		else {
			businessTripApplicationImpl.setEmail(email);
		}

		if (officeSite == null) {
			businessTripApplicationImpl.setOfficeSite(StringPool.BLANK);
		}
		else {
			businessTripApplicationImpl.setOfficeSite(officeSite);
		}

		businessTripApplicationImpl.setApproverId(approverId);

		if (approverName == null) {
			businessTripApplicationImpl.setApproverName(StringPool.BLANK);
		}
		else {
			businessTripApplicationImpl.setApproverName(approverName);
		}

		businessTripApplicationImpl.setEvpId(evpId);

		if (evpName == null) {
			businessTripApplicationImpl.setEvpName(StringPool.BLANK);
		}
		else {
			businessTripApplicationImpl.setEvpName(evpName);
		}

		businessTripApplicationImpl.setIsCrossDepartment(isCrossDepartment);
		businessTripApplicationImpl.setTargetDepartmentId(targetDepartmentId);

		if (targetDepartmentName == null) {
			businessTripApplicationImpl.setTargetDepartmentName(StringPool.BLANK);
		}
		else {
			businessTripApplicationImpl.setTargetDepartmentName(targetDepartmentName);
		}

		if (targetCostCenter == null) {
			businessTripApplicationImpl.setTargetCostCenter(StringPool.BLANK);
		}
		else {
			businessTripApplicationImpl.setTargetCostCenter(targetCostCenter);
		}

		businessTripApplicationImpl.setTargetDepartmentApproverId(targetDepartmentApproverId);

		if (targetDepartmentApproverName == null) {
			businessTripApplicationImpl.setTargetDepartmentApproverName(StringPool.BLANK);
		}
		else {
			businessTripApplicationImpl.setTargetDepartmentApproverName(targetDepartmentApproverName);
		}

		businessTripApplicationImpl.setTripType(tripType);

		if (departureDate == Long.MIN_VALUE) {
			businessTripApplicationImpl.setDepartureDate(null);
		}
		else {
			businessTripApplicationImpl.setDepartureDate(new Date(departureDate));
		}

		if (returnDate == Long.MIN_VALUE) {
			businessTripApplicationImpl.setReturnDate(null);
		}
		else {
			businessTripApplicationImpl.setReturnDate(new Date(returnDate));
		}

		if (purposeOfTheTrip == null) {
			businessTripApplicationImpl.setPurposeOfTheTrip(StringPool.BLANK);
		}
		else {
			businessTripApplicationImpl.setPurposeOfTheTrip(purposeOfTheTrip);
		}

		if (visitCountriesCities == null) {
			businessTripApplicationImpl.setVisitCountriesCities(StringPool.BLANK);
		}
		else {
			businessTripApplicationImpl.setVisitCountriesCities(visitCountriesCities);
		}

		businessTripApplicationImpl.setAdvancePayment(advancePayment);

		if (currency == null) {
			businessTripApplicationImpl.setCurrency(StringPool.BLANK);
		}
		else {
			businessTripApplicationImpl.setCurrency(currency);
		}

		if (paymentMethods == null) {
			businessTripApplicationImpl.setPaymentMethods(StringPool.BLANK);
		}
		else {
			businessTripApplicationImpl.setPaymentMethods(paymentMethods);
		}

		businessTripApplicationImpl.setTotalCostRmb(totalCostRmb);
		businessTripApplicationImpl.setTotalCostEur(totalCostEur);
		businessTripApplicationImpl.setHotelTotalCostRmb(hotelTotalCostRmb);
		businessTripApplicationImpl.setHotelTotalCostEur(hotelTotalCostEur);
		businessTripApplicationImpl.setCarRentalTotalCostRmb(carRentalTotalCostRmb);
		businessTripApplicationImpl.setCarRentalTotalCostEur(carRentalTotalCostEur);

		if (remark == null) {
			businessTripApplicationImpl.setRemark(StringPool.BLANK);
		}
		else {
			businessTripApplicationImpl.setRemark(remark);
		}

		if (otherEmails == null) {
			businessTripApplicationImpl.setOtherEmails(StringPool.BLANK);
		}
		else {
			businessTripApplicationImpl.setOtherEmails(otherEmails);
		}

		businessTripApplicationImpl.setStatus(status);
		businessTripApplicationImpl.setSapStatus(sapStatus);

		if (sapComments == null) {
			businessTripApplicationImpl.setSapComments(StringPool.BLANK);
		}
		else {
			businessTripApplicationImpl.setSapComments(sapComments);
		}

		if (sapDocumentId == null) {
			businessTripApplicationImpl.setSapDocumentId(StringPool.BLANK);
		}
		else {
			businessTripApplicationImpl.setSapDocumentId(sapDocumentId);
		}

		if (sapCertificateNo == null) {
			businessTripApplicationImpl.setSapCertificateNo(StringPool.BLANK);
		}
		else {
			businessTripApplicationImpl.setSapCertificateNo(sapCertificateNo);
		}

		if (sapCompany == null) {
			businessTripApplicationImpl.setSapCompany(StringPool.BLANK);
		}
		else {
			businessTripApplicationImpl.setSapCompany(sapCompany);
		}

		if (sapYear == null) {
			businessTripApplicationImpl.setSapYear(StringPool.BLANK);
		}
		else {
			businessTripApplicationImpl.setSapYear(sapYear);
		}

		businessTripApplicationImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			businessTripApplicationImpl.setStatusByUserName(StringPool.BLANK);
		}
		else {
			businessTripApplicationImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			businessTripApplicationImpl.setStatusDate(null);
		}
		else {
			businessTripApplicationImpl.setStatusDate(new Date(statusDate));
		}

		businessTripApplicationImpl.setIsApplicantAgent(isApplicantAgent);
		businessTripApplicationImpl.setIsApproverAgent(isApproverAgent);
		businessTripApplicationImpl.setGroupId(groupId);
		businessTripApplicationImpl.setUserId(userId);

		if (userName == null) {
			businessTripApplicationImpl.setUserName(StringPool.BLANK);
		}
		else {
			businessTripApplicationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			businessTripApplicationImpl.setCreateDate(null);
		}
		else {
			businessTripApplicationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			businessTripApplicationImpl.setModifiedDate(null);
		}
		else {
			businessTripApplicationImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (submittedDate == Long.MIN_VALUE) {
			businessTripApplicationImpl.setSubmittedDate(null);
		}
		else {
			businessTripApplicationImpl.setSubmittedDate(new Date(submittedDate));
		}

		businessTripApplicationImpl.setCompanyId(companyId);

		businessTripApplicationImpl.resetOriginalValues();

		return businessTripApplicationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		businessTripApplicationId = objectInput.readLong();
		ticketNo = objectInput.readUTF();
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
		evpId = objectInput.readLong();
		evpName = objectInput.readUTF();
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
		hotelTotalCostRmb = objectInput.readDouble();
		hotelTotalCostEur = objectInput.readDouble();
		carRentalTotalCostRmb = objectInput.readDouble();
		carRentalTotalCostEur = objectInput.readDouble();
		remark = objectInput.readUTF();
		otherEmails = objectInput.readUTF();
		status = objectInput.readInt();
		sapStatus = objectInput.readInt();
		sapComments = objectInput.readUTF();
		sapDocumentId = objectInput.readUTF();
		sapCertificateNo = objectInput.readUTF();
		sapCompany = objectInput.readUTF();
		sapYear = objectInput.readUTF();
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
		objectOutput.writeLong(businessTripApplicationId);

		if (ticketNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ticketNo);
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

		objectOutput.writeLong(evpId);

		if (evpName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(evpName);
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
		objectOutput.writeDouble(hotelTotalCostRmb);
		objectOutput.writeDouble(hotelTotalCostEur);
		objectOutput.writeDouble(carRentalTotalCostRmb);
		objectOutput.writeDouble(carRentalTotalCostEur);

		if (remark == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(remark);
		}

		if (otherEmails == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(otherEmails);
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

		if (sapCertificateNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sapCertificateNo);
		}

		if (sapCompany == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sapCompany);
		}

		if (sapYear == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sapYear);
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

	public long businessTripApplicationId;
	public String ticketNo;
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
	public long evpId;
	public String evpName;
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
	public double hotelTotalCostRmb;
	public double hotelTotalCostEur;
	public double carRentalTotalCostRmb;
	public double carRentalTotalCostEur;
	public String remark;
	public String otherEmails;
	public int status;
	public int sapStatus;
	public String sapComments;
	public String sapDocumentId;
	public String sapCertificateNo;
	public String sapCompany;
	public String sapYear;
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