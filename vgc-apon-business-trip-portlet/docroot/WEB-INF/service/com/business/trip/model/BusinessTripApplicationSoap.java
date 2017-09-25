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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BusinessTripApplicationSoap implements Serializable {
	public static BusinessTripApplicationSoap toSoapModel(
		BusinessTripApplication model) {
		BusinessTripApplicationSoap soapModel = new BusinessTripApplicationSoap();

		soapModel.setBusinessTripApplicationId(model.getBusinessTripApplicationId());
		soapModel.setTicketNo(model.getTicketNo());
		soapModel.setProcessType(model.getProcessType());
		soapModel.setSubType(model.getSubType());
		soapModel.setPrintName(model.getPrintName());
		soapModel.setStaffCode(model.getStaffCode());
		soapModel.setCompanyName(model.getCompanyName());
		soapModel.setDivision(model.getDivision());
		soapModel.setDepartment(model.getDepartment());
		soapModel.setCostCenter(model.getCostCenter());
		soapModel.setPersonalID(model.getPersonalID());
		soapModel.setPassportNo(model.getPassportNo());
		soapModel.setOfficePhone(model.getOfficePhone());
		soapModel.setMobilePhone(model.getMobilePhone());
		soapModel.setEmail(model.getEmail());
		soapModel.setOfficeSite(model.getOfficeSite());
		soapModel.setApproverId(model.getApproverId());
		soapModel.setApproverName(model.getApproverName());
		soapModel.setEvpId(model.getEvpId());
		soapModel.setEvpName(model.getEvpName());
		soapModel.setIsCrossDepartment(model.getIsCrossDepartment());
		soapModel.setTargetDepartmentId(model.getTargetDepartmentId());
		soapModel.setTargetDepartmentName(model.getTargetDepartmentName());
		soapModel.setTargetCostCenter(model.getTargetCostCenter());
		soapModel.setTargetDepartmentApproverId(model.getTargetDepartmentApproverId());
		soapModel.setTargetDepartmentApproverName(model.getTargetDepartmentApproverName());
		soapModel.setTripType(model.getTripType());
		soapModel.setDepartureDate(model.getDepartureDate());
		soapModel.setReturnDate(model.getReturnDate());
		soapModel.setPurposeOfTheTrip(model.getPurposeOfTheTrip());
		soapModel.setVisitCountriesCities(model.getVisitCountriesCities());
		soapModel.setAdvancePayment(model.getAdvancePayment());
		soapModel.setCurrency(model.getCurrency());
		soapModel.setPaymentMethods(model.getPaymentMethods());
		soapModel.setTotalCostRmb(model.getTotalCostRmb());
		soapModel.setTotalCostEur(model.getTotalCostEur());
		soapModel.setHotelTotalCostRmb(model.getHotelTotalCostRmb());
		soapModel.setHotelTotalCostEur(model.getHotelTotalCostEur());
		soapModel.setCarRentalTotalCostRmb(model.getCarRentalTotalCostRmb());
		soapModel.setCarRentalTotalCostEur(model.getCarRentalTotalCostEur());
		soapModel.setRemark(model.getRemark());
		soapModel.setOtherEmails(model.getOtherEmails());
		soapModel.setStatus(model.getStatus());
		soapModel.setSapStatus(model.getSapStatus());
		soapModel.setSapComments(model.getSapComments());
		soapModel.setSapDocumentId(model.getSapDocumentId());
		soapModel.setSapCertificateNo(model.getSapCertificateNo());
		soapModel.setSapCompany(model.getSapCompany());
		soapModel.setSapYear(model.getSapYear());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());
		soapModel.setIsApplicantAgent(model.getIsApplicantAgent());
		soapModel.setIsApproverAgent(model.getIsApproverAgent());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setSubmittedDate(model.getSubmittedDate());
		soapModel.setCompanyId(model.getCompanyId());

		return soapModel;
	}

	public static BusinessTripApplicationSoap[] toSoapModels(
		BusinessTripApplication[] models) {
		BusinessTripApplicationSoap[] soapModels = new BusinessTripApplicationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BusinessTripApplicationSoap[][] toSoapModels(
		BusinessTripApplication[][] models) {
		BusinessTripApplicationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BusinessTripApplicationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BusinessTripApplicationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BusinessTripApplicationSoap[] toSoapModels(
		List<BusinessTripApplication> models) {
		List<BusinessTripApplicationSoap> soapModels = new ArrayList<BusinessTripApplicationSoap>(models.size());

		for (BusinessTripApplication model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BusinessTripApplicationSoap[soapModels.size()]);
	}

	public BusinessTripApplicationSoap() {
	}

	public long getPrimaryKey() {
		return _businessTripApplicationId;
	}

	public void setPrimaryKey(long pk) {
		setBusinessTripApplicationId(pk);
	}

	public long getBusinessTripApplicationId() {
		return _businessTripApplicationId;
	}

	public void setBusinessTripApplicationId(long businessTripApplicationId) {
		_businessTripApplicationId = businessTripApplicationId;
	}

	public String getTicketNo() {
		return _ticketNo;
	}

	public void setTicketNo(String ticketNo) {
		_ticketNo = ticketNo;
	}

	public String getProcessType() {
		return _processType;
	}

	public void setProcessType(String processType) {
		_processType = processType;
	}

	public String getSubType() {
		return _subType;
	}

	public void setSubType(String subType) {
		_subType = subType;
	}

	public String getPrintName() {
		return _printName;
	}

	public void setPrintName(String printName) {
		_printName = printName;
	}

	public long getStaffCode() {
		return _staffCode;
	}

	public void setStaffCode(long staffCode) {
		_staffCode = staffCode;
	}

	public String getCompanyName() {
		return _companyName;
	}

	public void setCompanyName(String companyName) {
		_companyName = companyName;
	}

	public String getDivision() {
		return _division;
	}

	public void setDivision(String division) {
		_division = division;
	}

	public String getDepartment() {
		return _department;
	}

	public void setDepartment(String department) {
		_department = department;
	}

	public String getCostCenter() {
		return _costCenter;
	}

	public void setCostCenter(String costCenter) {
		_costCenter = costCenter;
	}

	public String getPersonalID() {
		return _personalID;
	}

	public void setPersonalID(String personalID) {
		_personalID = personalID;
	}

	public String getPassportNo() {
		return _passportNo;
	}

	public void setPassportNo(String passportNo) {
		_passportNo = passportNo;
	}

	public String getOfficePhone() {
		return _officePhone;
	}

	public void setOfficePhone(String officePhone) {
		_officePhone = officePhone;
	}

	public String getMobilePhone() {
		return _mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		_mobilePhone = mobilePhone;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getOfficeSite() {
		return _officeSite;
	}

	public void setOfficeSite(String officeSite) {
		_officeSite = officeSite;
	}

	public long getApproverId() {
		return _approverId;
	}

	public void setApproverId(long approverId) {
		_approverId = approverId;
	}

	public String getApproverName() {
		return _approverName;
	}

	public void setApproverName(String approverName) {
		_approverName = approverName;
	}

	public long getEvpId() {
		return _evpId;
	}

	public void setEvpId(long evpId) {
		_evpId = evpId;
	}

	public String getEvpName() {
		return _evpName;
	}

	public void setEvpName(String evpName) {
		_evpName = evpName;
	}

	public boolean getIsCrossDepartment() {
		return _isCrossDepartment;
	}

	public boolean isIsCrossDepartment() {
		return _isCrossDepartment;
	}

	public void setIsCrossDepartment(boolean isCrossDepartment) {
		_isCrossDepartment = isCrossDepartment;
	}

	public long getTargetDepartmentId() {
		return _targetDepartmentId;
	}

	public void setTargetDepartmentId(long targetDepartmentId) {
		_targetDepartmentId = targetDepartmentId;
	}

	public String getTargetDepartmentName() {
		return _targetDepartmentName;
	}

	public void setTargetDepartmentName(String targetDepartmentName) {
		_targetDepartmentName = targetDepartmentName;
	}

	public String getTargetCostCenter() {
		return _targetCostCenter;
	}

	public void setTargetCostCenter(String targetCostCenter) {
		_targetCostCenter = targetCostCenter;
	}

	public long getTargetDepartmentApproverId() {
		return _targetDepartmentApproverId;
	}

	public void setTargetDepartmentApproverId(long targetDepartmentApproverId) {
		_targetDepartmentApproverId = targetDepartmentApproverId;
	}

	public String getTargetDepartmentApproverName() {
		return _targetDepartmentApproverName;
	}

	public void setTargetDepartmentApproverName(
		String targetDepartmentApproverName) {
		_targetDepartmentApproverName = targetDepartmentApproverName;
	}

	public int getTripType() {
		return _tripType;
	}

	public void setTripType(int tripType) {
		_tripType = tripType;
	}

	public Date getDepartureDate() {
		return _departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		_departureDate = departureDate;
	}

	public Date getReturnDate() {
		return _returnDate;
	}

	public void setReturnDate(Date returnDate) {
		_returnDate = returnDate;
	}

	public String getPurposeOfTheTrip() {
		return _purposeOfTheTrip;
	}

	public void setPurposeOfTheTrip(String purposeOfTheTrip) {
		_purposeOfTheTrip = purposeOfTheTrip;
	}

	public String getVisitCountriesCities() {
		return _visitCountriesCities;
	}

	public void setVisitCountriesCities(String visitCountriesCities) {
		_visitCountriesCities = visitCountriesCities;
	}

	public double getAdvancePayment() {
		return _advancePayment;
	}

	public void setAdvancePayment(double advancePayment) {
		_advancePayment = advancePayment;
	}

	public String getCurrency() {
		return _currency;
	}

	public void setCurrency(String currency) {
		_currency = currency;
	}

	public String getPaymentMethods() {
		return _paymentMethods;
	}

	public void setPaymentMethods(String paymentMethods) {
		_paymentMethods = paymentMethods;
	}

	public double getTotalCostRmb() {
		return _totalCostRmb;
	}

	public void setTotalCostRmb(double totalCostRmb) {
		_totalCostRmb = totalCostRmb;
	}

	public double getTotalCostEur() {
		return _totalCostEur;
	}

	public void setTotalCostEur(double totalCostEur) {
		_totalCostEur = totalCostEur;
	}

	public double getHotelTotalCostRmb() {
		return _hotelTotalCostRmb;
	}

	public void setHotelTotalCostRmb(double hotelTotalCostRmb) {
		_hotelTotalCostRmb = hotelTotalCostRmb;
	}

	public double getHotelTotalCostEur() {
		return _hotelTotalCostEur;
	}

	public void setHotelTotalCostEur(double hotelTotalCostEur) {
		_hotelTotalCostEur = hotelTotalCostEur;
	}

	public double getCarRentalTotalCostRmb() {
		return _carRentalTotalCostRmb;
	}

	public void setCarRentalTotalCostRmb(double carRentalTotalCostRmb) {
		_carRentalTotalCostRmb = carRentalTotalCostRmb;
	}

	public double getCarRentalTotalCostEur() {
		return _carRentalTotalCostEur;
	}

	public void setCarRentalTotalCostEur(double carRentalTotalCostEur) {
		_carRentalTotalCostEur = carRentalTotalCostEur;
	}

	public String getRemark() {
		return _remark;
	}

	public void setRemark(String remark) {
		_remark = remark;
	}

	public String getOtherEmails() {
		return _otherEmails;
	}

	public void setOtherEmails(String otherEmails) {
		_otherEmails = otherEmails;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public int getSapStatus() {
		return _sapStatus;
	}

	public void setSapStatus(int sapStatus) {
		_sapStatus = sapStatus;
	}

	public String getSapComments() {
		return _sapComments;
	}

	public void setSapComments(String sapComments) {
		_sapComments = sapComments;
	}

	public String getSapDocumentId() {
		return _sapDocumentId;
	}

	public void setSapDocumentId(String sapDocumentId) {
		_sapDocumentId = sapDocumentId;
	}

	public String getSapCertificateNo() {
		return _sapCertificateNo;
	}

	public void setSapCertificateNo(String sapCertificateNo) {
		_sapCertificateNo = sapCertificateNo;
	}

	public String getSapCompany() {
		return _sapCompany;
	}

	public void setSapCompany(String sapCompany) {
		_sapCompany = sapCompany;
	}

	public String getSapYear() {
		return _sapYear;
	}

	public void setSapYear(String sapYear) {
		_sapYear = sapYear;
	}

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserName() {
		return _statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	public boolean getIsApplicantAgent() {
		return _isApplicantAgent;
	}

	public boolean isIsApplicantAgent() {
		return _isApplicantAgent;
	}

	public void setIsApplicantAgent(boolean isApplicantAgent) {
		_isApplicantAgent = isApplicantAgent;
	}

	public boolean getIsApproverAgent() {
		return _isApproverAgent;
	}

	public boolean isIsApproverAgent() {
		return _isApproverAgent;
	}

	public void setIsApproverAgent(boolean isApproverAgent) {
		_isApproverAgent = isApproverAgent;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public Date getSubmittedDate() {
		return _submittedDate;
	}

	public void setSubmittedDate(Date submittedDate) {
		_submittedDate = submittedDate;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
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
	private String _statusByUserName;
	private Date _statusDate;
	private boolean _isApplicantAgent;
	private boolean _isApproverAgent;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _submittedDate;
	private long _companyId;
}