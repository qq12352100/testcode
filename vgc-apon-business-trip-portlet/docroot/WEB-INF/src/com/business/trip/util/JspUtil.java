package com.business.trip.util;

import com.business.trip.model.BusinessTripApplication;
import com.business.trip.model.BusinessTripReimbursement;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.vgc.apon.model.SAPUser;
import com.vgc.apon.service.SAPUserLocalServiceUtil;

public class JspUtil {

	public static BusinessTripReimbursement include(BusinessTripReimbursement businessTripReimbursement,BusinessTripApplication businessTripApplication,
			double totalTravelExpenseRmb,double totalTravelExpenseEur,double costListInlandTotalRmb,double costListForeignTotalEur,double costListForeignTotalRmb) throws SystemException{
		businessTripReimbursement.setBussinessTirpTicketNo(businessTripApplication.getTicketNo());
		businessTripReimbursement.setPrintName(businessTripApplication.getPrintName());
		businessTripReimbursement.setStaffCode(businessTripApplication.getStaffCode());
		businessTripReimbursement.setCompanyId(businessTripApplication.getCompanyId());
		businessTripReimbursement.setCompanyName(businessTripApplication.getCompanyName());
		businessTripReimbursement.setDivision(businessTripApplication.getDivision());
		businessTripReimbursement.setDepartment(businessTripApplication.getDepartment());
		businessTripReimbursement.setCostCenter(businessTripApplication.getCostCenter());
		businessTripReimbursement.setPersonalID(businessTripApplication.getPersonalID());
		businessTripReimbursement.setPassportNo(businessTripApplication.getPassportNo());
		businessTripReimbursement.setOfficePhone(businessTripApplication.getOfficePhone());
		businessTripReimbursement.setMobilePhone(businessTripApplication.getMobilePhone());
		businessTripReimbursement.setEmail(businessTripApplication.getEmail());
		businessTripReimbursement.setOfficeSite(businessTripApplication.getOfficeSite());
		long staffCode = businessTripApplication.getStaffCode();
		if(staffCode!=0){
			SAPUser sapUser = SAPUserLocalServiceUtil.getSapUserByStaffCode(String.valueOf(staffCode));
			businessTripReimbursement.setApproverId(Long.valueOf(Validator.isNotNull(sapUser.getSupervisorFgId())?sapUser.getSupervisorFgId():"0"));
			businessTripReimbursement.setApproverName(sapUser.getSupervisorFgName());
		}
		businessTripReimbursement.setIsCrossDepartment(businessTripApplication.getIsCrossDepartment());
		businessTripReimbursement.setTargetDepartmentId(businessTripApplication.getTargetDepartmentId());
		businessTripReimbursement.setTargetDepartmentName(businessTripApplication.getTargetDepartmentName());
		businessTripReimbursement.setTargetCostCenter(businessTripApplication.getTargetCostCenter());
		businessTripReimbursement.setTargetDepartmentApproverId(businessTripApplication.getTargetDepartmentApproverId());
		businessTripReimbursement.setTargetDepartmentApproverName(businessTripApplication.getTargetDepartmentApproverName());
		businessTripReimbursement.setTripType(businessTripApplication.getTripType());
		businessTripReimbursement.setDepartureDate(businessTripApplication.getDepartureDate());
		businessTripReimbursement.setReturnDate(businessTripApplication.getReturnDate());
		businessTripReimbursement.setPurposeOfTheTrip(businessTripApplication.getPurposeOfTheTrip());
		businessTripReimbursement.setVisitCountriesCities(businessTripApplication.getVisitCountriesCities());
		
		businessTripReimbursement.setAdvancePayment(businessTripApplication.getAdvancePayment());
		businessTripReimbursement.setPaymentMethods(businessTripApplication.getPaymentMethods());
		businessTripReimbursement.setCurrency(businessTripApplication.getCurrency());
		businessTripReimbursement.setTotalCostRmb(businessTripApplication.getTotalCostRmb());
		businessTripReimbursement.setTotalCostEur(businessTripApplication.getTotalCostEur());
		businessTripReimbursement.setHotelTotalCostRmb(businessTripApplication.getHotelTotalCostRmb());
		businessTripReimbursement.setHotelTotalCostEur(businessTripApplication.getHotelTotalCostEur());
		businessTripReimbursement.setCarRentalTotalCostRmb(businessTripApplication.getCarRentalTotalCostRmb());
		businessTripReimbursement.setCarRentalTotalCostEur(businessTripApplication.getCarRentalTotalCostEur());
		
		businessTripReimbursement.setTotalTravelExpenseRmb(totalTravelExpenseRmb);
		businessTripReimbursement.setTotalTravelExpenseEur(totalTravelExpenseEur);
		
		businessTripReimbursement.setCostListInlandTotalRmb(costListInlandTotalRmb);
		businessTripReimbursement.setCostListForeignTotalEur(costListForeignTotalEur);
		businessTripReimbursement.setCostListForeignTotalRmb(costListForeignTotalRmb);
		
		return businessTripReimbursement;
	}
	
}
