package com.business.trip.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.business.trip.model.BtCarRentalInfo;
import com.business.trip.model.BtCostList;
import com.business.trip.model.BtExchangeRate;
import com.business.trip.model.BtFlightTrainInfo;
import com.business.trip.model.BtHotelInfo;
import com.business.trip.model.BtTrainInfo;
import com.business.trip.model.BtTravelExpense;
import com.business.trip.model.BusinessTripReimbursement;
import com.business.trip.service.BtCostListLocalServiceUtil;
import com.business.trip.service.BtExchangeRateLocalServiceUtil;
import com.business.trip.service.BtHotelInfoLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;

public class BTApplicationUtil {
	//For Calculate
	public static double addCalculate(double oldTotal,String totalCurrency,double amount,String currency) throws SystemException {
		double newTotal = oldTotal;
		if(currency.equals(totalCurrency)) {
			newTotal = oldTotal + amount;
		}else {
			BtExchangeRate btExchangeRate = BtExchangeRateLocalServiceUtil.fetchByF_S_S(currency, totalCurrency, BusinessTripConstants.VALID_STATUS);
			if(btExchangeRate!=null) {
				newTotal = oldTotal + amount*btExchangeRate.getFirToSecExchangeRate();
			}else {
				btExchangeRate = BtExchangeRateLocalServiceUtil.fetchByF_S_S(totalCurrency, currency, BusinessTripConstants.VALID_STATUS);
				newTotal = btExchangeRate!=null?oldTotal + amount*btExchangeRate.getSecToFirExchangeRate():newTotal;				
			}
		}
		return newTotal;
	}
	
	//For Calculate
	public static double deleteCalculate(double oldTotal,String totalCurrency,double amount,String currency) throws SystemException {
		double newTotal = oldTotal;
		if(currency.equals(totalCurrency)) {
			newTotal = oldTotal - amount;
		}else {
			BtExchangeRate btExchangeRate = BtExchangeRateLocalServiceUtil.fetchByF_S_S(currency, totalCurrency, BusinessTripConstants.VALID_STATUS);
			if(btExchangeRate!=null) {
				newTotal = oldTotal - amount*btExchangeRate.getFirToSecExchangeRate();
			}else {
				btExchangeRate = BtExchangeRateLocalServiceUtil.fetchByF_S_S(totalCurrency, currency, BusinessTripConstants.VALID_STATUS);
				newTotal = btExchangeRate!=null?oldTotal - amount*btExchangeRate.getSecToFirExchangeRate():newTotal;				
			}
		}
		return newTotal;
	}
	
	//Pass the value to render phase
	public static void passRenderParameter(ActionRequest actionRequest,
			ActionResponse actionResponse) {
		SimpleDateFormat sdf_dmy = new SimpleDateFormat("dd.MM.yyyy");
		String isApplicantAgent = ParamUtil.getString(actionRequest, "isApplicantAgent");
		String staffCode = ParamUtil.getString(actionRequest, "staffCode");
		long approverId = ParamUtil.getLong(actionRequest, "approverId");
		String approverName = ParamUtil.getString(actionRequest, "approverName");
		boolean isCrossDepartment = ParamUtil.getBoolean(actionRequest, "isCrossDepartment");
		long targetDepartmentId = ParamUtil.getLong(actionRequest, "targetDepartmentId");
		String targetDepartmentName = ParamUtil.getString(actionRequest, "targetDepartmentName");
		String targetCostCenter = ParamUtil.getString(actionRequest, "targetCostCenter");
		long targetDepartmentApproverId = ParamUtil.getLong(actionRequest, "targetDepartmentApproverId");
		String targetDepartmentApproverName = ParamUtil.getString(actionRequest, "targetDepartmentApproverName");
		int tripType = ParamUtil.getInteger(actionRequest, "tripType");
		String tripTypeStr = actionRequest.getParameter("tripType");
		if(tripTypeStr==null||tripTypeStr.trim().equalsIgnoreCase("undefined")){
			tripType = 99;
		}
		Date departureDate = ParamUtil.getDate(actionRequest, "departureDate", sdf_dmy);
		Date returnDate = ParamUtil.getDate(actionRequest, "returnDate", sdf_dmy);
		String purposeOfTheTrip = ParamUtil.getString(actionRequest, "purposeOfTheTrip");
		String visitCountriesCities = ParamUtil.getString(actionRequest, "visitCountriesCities");
		double advancePayment = ParamUtil.getDouble(actionRequest, "advancePayment");
		String currency = ParamUtil.getString(actionRequest, "currency");

		actionResponse.setRenderParameter("isApplicantAgent", isApplicantAgent);
		actionResponse.setRenderParameter("staffCode", staffCode);
		actionResponse.setRenderParameter("approverId", String.valueOf(approverId));
		actionResponse.setRenderParameter("approverName", approverName);
		actionResponse.setRenderParameter("isCrossDepartment", String.valueOf(isCrossDepartment));
		actionResponse.setRenderParameter("targetDepartmentId", String.valueOf(targetDepartmentId));
		actionResponse.setRenderParameter("targetDepartmentName", targetDepartmentName);
		actionResponse.setRenderParameter("targetCostCenter", targetCostCenter);
		actionResponse.setRenderParameter("targetDepartmentApproverId", String.valueOf(targetDepartmentApproverId));
		actionResponse.setRenderParameter("targetDepartmentApproverName", targetDepartmentApproverName);
		actionResponse.setRenderParameter("tripType", String.valueOf(tripType));
		actionResponse.setRenderParameter("departureDate", sdf_dmy.format(departureDate));
		actionResponse.setRenderParameter("returnDate", sdf_dmy.format(returnDate));
		actionResponse.setRenderParameter("purposeOfTheTrip", purposeOfTheTrip);
		actionResponse.setRenderParameter("visitCountriesCities", visitCountriesCities);
		actionResponse.setRenderParameter("advancePayment", String.valueOf(advancePayment));
		actionResponse.setRenderParameter("currency", currency);
	}
	
	@SuppressWarnings("unchecked")
	public static int compareTabs(String tabName,Object oldCompare,Object newCompare){
		if("flight-fareDetails".equals(tabName)){
			BusinessTripReimbursement oldBusinessTripReimbursement=(BusinessTripReimbursement)oldCompare;
			BusinessTripReimbursement newBusinessTripReimbursement=(BusinessTripReimbursement)newCompare;
			if(!compareValue(oldBusinessTripReimbursement.getFlightCurrency(),newBusinessTripReimbursement.getFlightCurrency())){
				return 0;
			}
			if(!compareValue(String.valueOf(oldBusinessTripReimbursement.getFlightTotal()),String.valueOf(newBusinessTripReimbursement.getFlightTotal()))){
				return 0;
			}
			if(!compareValue(String.valueOf(oldBusinessTripReimbursement.getFlightAirFare()),String.valueOf(newBusinessTripReimbursement.getFlightAirFare()))){
				return 0;
			}
			if(!compareValue(String.valueOf(oldBusinessTripReimbursement.getFlightTaxes()),String.valueOf(newBusinessTripReimbursement.getFlightTaxes()))){
				return 0;
			}
			if(!compareValue(String.valueOf(oldBusinessTripReimbursement.getFlightTransactionFee()),String.valueOf(newBusinessTripReimbursement.getFlightTransactionFee()))){
				return 0;
			}
		}else if("flight".equals(tabName)){
			List<BtFlightTrainInfo> oldBtFlightTrainInfos=(List<BtFlightTrainInfo>)oldCompare;
			List<BtFlightTrainInfo> newBtFlightTrainInfos=(List<BtFlightTrainInfo>)newCompare;
			
			if(oldBtFlightTrainInfos.size()!=newBtFlightTrainInfos.size()){
				return 0;
			}
			
			boolean isCompare=false;
			for(int i=0;i<oldBtFlightTrainInfos.size();i++){
				BtFlightTrainInfo oldBtFlightTrainInfo=oldBtFlightTrainInfos.get(i);
				for(int j=0;j<newBtFlightTrainInfos.size();j++){
					BtFlightTrainInfo newBtFlightTrainInfo=newBtFlightTrainInfos.get(i);
					if(oldBtFlightTrainInfo.getBtFlightTrainInfoId()==newBtFlightTrainInfo.getBtFlightTrainInfoId()){
						if(!compareValue(oldBtFlightTrainInfo.getFromCity(),newBtFlightTrainInfo.getFromCity())){
							return 0;
						}
						if(!compareValue(oldBtFlightTrainInfo.getToCity(),newBtFlightTrainInfo.getToCity())){
							return 0;
						}
						if(!compareValue(String.valueOf(oldBtFlightTrainInfo.getDepartureDate()),String.valueOf(newBtFlightTrainInfo.getDepartureDate()))){
							return 0;
						}
						if(!compareValue(oldBtFlightTrainInfo.getDepartureFlight(),newBtFlightTrainInfo.getDepartureFlight())){
							return 0;
						}
						if(!compareValue(oldBtFlightTrainInfo.getClassInfo(),newBtFlightTrainInfo.getClassInfo())){
							return 0;
						}
						isCompare=true;
					}
				}
			}
			
			if(!isCompare){
				return 0;
			}
		}else if("train".equals(tabName)){
			BtTrainInfo oldBtTrainInfo=(BtTrainInfo)oldCompare;
			BtTrainInfo newBtTrainInfo=(BtTrainInfo)newCompare;
			if(!compareValue(oldBtTrainInfo.getFromCity(),newBtTrainInfo.getFromCity())){
				return 0;
			}
			if(!compareValue(oldBtTrainInfo.getToCity(),newBtTrainInfo.getToCity())){
				return 0;
			}
			if(!compareValue(String.valueOf(oldBtTrainInfo.getDepartureDate()),String.valueOf(newBtTrainInfo.getDepartureDate()))){
				return 0;
			}
			if(!compareValue(oldBtTrainInfo.getDepartureTrain(),newBtTrainInfo.getDepartureTrain())){
				return 0;
			}
			if(!compareValue(oldBtTrainInfo.getClassInfo(),newBtTrainInfo.getClassInfo())){
				return 0;
			}
		}else if("hotelInformation".equals(tabName)){
			BtHotelInfo oldBtHotelInfo=(BtHotelInfo)oldCompare;
			BtHotelInfo newBtHotelInfo=(BtHotelInfo)newCompare;
			if(!compareValue(oldBtHotelInfo.getCity(),newBtHotelInfo.getCity())){
				return 0;
			}
			if(!compareValue(oldBtHotelInfo.getCityType(),newBtHotelInfo.getCityType())){
				return 0;
			}
			if(!compareValue(oldBtHotelInfo.getHotel(),newBtHotelInfo.getHotel())){
				return 0;
			}
			if(!compareValue(String.valueOf(oldBtHotelInfo.getCheckIn()),String.valueOf(newBtHotelInfo.getCheckIn()))){
				return 0;
			}
			if(!compareValue(String.valueOf(oldBtHotelInfo.getCheckOut()),String.valueOf(newBtHotelInfo.getCheckOut()))){
				return 0;
			}
			if(!compareValue(oldBtHotelInfo.getRoomCategory(),newBtHotelInfo.getRoomCategory())){
				return 0;
			}
			if(!compareValue(String.valueOf(oldBtHotelInfo.getPrice()),String.valueOf(newBtHotelInfo.getPrice()))){
				return 0;
			}
			if(!compareValue(oldBtHotelInfo.getCurrency(),newBtHotelInfo.getCurrency())){
				return 0;
			}
			if(!compareValue(String.valueOf(oldBtHotelInfo.getIsOverBudget()),String.valueOf(newBtHotelInfo.getIsOverBudget()))){
				return 0;
			}
			if(!compareValue(oldBtHotelInfo.getOtherReasonInfo(),newBtHotelInfo.getOtherReasonInfo())){
				return 0;
			}
			if(!compareValue(String.valueOf(oldBtHotelInfo.getIsNotBookedFromTA()),String.valueOf(newBtHotelInfo.getIsNotBookedFromTA()))){
				return 0;
			}
			if(!compareValue(oldBtHotelInfo.getOthersSpecify(),newBtHotelInfo.getOthersSpecify())){
				return 0;
			}
		}else if("carRental".equals(tabName)){
			BtCarRentalInfo oldBtCarRentalInfo=(BtCarRentalInfo)oldCompare;
			BtCarRentalInfo newBtCarRentalInfo=(BtCarRentalInfo)newCompare;
			
			if(!compareValue(oldBtCarRentalInfo.getPickupLocation(),newBtCarRentalInfo.getPickupLocation())){
				return 0;
			}
			if(!compareValue(String.valueOf(oldBtCarRentalInfo.getPickupDate()),String.valueOf(newBtCarRentalInfo.getPickupDate()))){
				return 0;
			}
			if(!compareValue(oldBtCarRentalInfo.getDropoffLocation(),newBtCarRentalInfo.getDropoffLocation())){
				return 0;
			}
			if(!compareValue(String.valueOf(oldBtCarRentalInfo.getDropoffDate()),String.valueOf(newBtCarRentalInfo.getDropoffDate()))){
				return 0;
			}
			if(!compareValue(oldBtCarRentalInfo.getCarType(),newBtCarRentalInfo.getCarType())){
				return 0;
			}
			if(!compareValue(oldBtCarRentalInfo.getTypeOfRental(),newBtCarRentalInfo.getTypeOfRental())){
				return 0;
			}
			if(!compareValue(String.valueOf(oldBtCarRentalInfo.getPrice()),String.valueOf(newBtCarRentalInfo.getPrice()))){
				return 0;
			}
			if(!compareValue(oldBtCarRentalInfo.getCurrency(),newBtCarRentalInfo.getCurrency())){
				return 0;
			}
		}else if("travelExpense".equals(tabName)){
			BtTravelExpense oldBtTravelExpense=(BtTravelExpense)oldCompare;
			BtTravelExpense newBtTravelExpense=(BtTravelExpense)newCompare;
			if(!compareValue(String.valueOf(oldBtTravelExpense.getDeparture()),String.valueOf(newBtTravelExpense.getDeparture()))){
				return 0;
			}
			if(!compareValue(String.valueOf(oldBtTravelExpense.getArrival()),String.valueOf(newBtTravelExpense.getArrival()))){
				return 0;
			}
			if(!compareValue(oldBtTravelExpense.getFromCity(),newBtTravelExpense.getFromCity())){
				return 0;
			}
			if(!compareValue(oldBtTravelExpense.getToCity(),newBtTravelExpense.getToCity())){
				return 0;
			}
			if(!compareValue(String.valueOf(oldBtTravelExpense.getIsHasBreakfast()),String.valueOf(newBtTravelExpense.getIsHasBreakfast()))){
				return 0;
			}
			if(!compareValue(String.valueOf(oldBtTravelExpense.getIsHasLunch()),String.valueOf(newBtTravelExpense.getIsHasLunch()))){
				return 0;
			}
			if(!compareValue(String.valueOf(oldBtTravelExpense.getIsHasDinner()),String.valueOf(newBtTravelExpense.getIsHasDinner()))){
				return 0;
			}
			if(!compareValue(oldBtTravelExpense.getCountry(),newBtTravelExpense.getCountry())){
				return 0;
			}
			if(!compareValue(oldBtTravelExpense.getCity(),newBtTravelExpense.getCity())){
				return 0;
			}
			if(!compareValue(String.valueOf(oldBtTravelExpense.getRateOfDma()),String.valueOf(newBtTravelExpense.getRateOfDma()))){
				return 0;
			}
			if(!compareValue(oldBtTravelExpense.getCurrency(),newBtTravelExpense.getCurrency())){
				return 0;
			}
			if(!compareValue(String.valueOf(oldBtTravelExpense.getAllowance()),String.valueOf(newBtTravelExpense.getAllowance()))){
				return 0;
			}
		}else if("costList".equals(tabName)){
			BtCostList oldBtCostList=(BtCostList)oldCompare;
			BtCostList newBtCostList=(BtCostList)newCompare;
			if(!compareValue(String.valueOf(oldBtCostList.getEntertainmentDate()),String.valueOf(newBtCostList.getEntertainmentDate()))){
				return 0;
			}
			if(!compareValue(oldBtCostList.getType(),newBtCostList.getType())){
				return 0;
			}
			if(!compareValue(String.valueOf(oldBtCostList.getEntertainmentPlace()),String.valueOf(newBtCostList.getEntertainmentPlace()))){
				return 0;
			}
			if(!compareValue(oldBtCostList.getCountryCity(),newBtCostList.getCountryCity())){
				return 0;
			}
			if(!compareValue(String.valueOf(oldBtCostList.getInvoiceAmount()),String.valueOf(newBtCostList.getInvoiceAmount()))){
				return 0;
			}
			if(!compareValue(String.valueOf(oldBtCostList.getPaymentAmount()),String.valueOf(newBtCostList.getPaymentAmount()))){
				return 0;
			}
			if(!compareValue(oldBtCostList.getInvoiceCurrency(),newBtCostList.getInvoiceCurrency())){
				return 0;
			}
			if(!compareValue(oldBtCostList.getPaymentCurrency(),newBtCostList.getPaymentCurrency())){
				return 0;
			}
			if(!compareValue(String.valueOf(oldBtCostList.getAverageSpend()),String.valueOf(newBtCostList.getAverageSpend()))){
				return 0;
			}
			if(!compareValue(String.valueOf(oldBtCostList.getAttendeesTotal()),String.valueOf(newBtCostList.getAttendeesTotal()))){
				return 0;
			}
		}
		return 1;
	}
	public static int compareBusinessTripReimbursement(BusinessTripReimbursement newBT,BusinessTripReimbursement oldBT) throws SystemException{
		String tripType = PropsUtil.get("vgc.apon.business.trip.reimbursement.type");
		String newNeedEV=BtHotelInfoLocalServiceUtil.isNeedEVPApprove(newBT.getBusinessTripReimbursementId(), tripType)?"Yes":"No";
		String oldNeedEV=BtHotelInfoLocalServiceUtil.isNeedEVPApprove(oldBT.getBusinessTripReimbursementId(), tripType)?"Yes":"No";
		if(!newNeedEV.equals(oldNeedEV)){
			return 0;
		}
		
		String newIsEnterDuringTrip=BtCostListLocalServiceUtil.isEntertainmentCondition(newBT.getBusinessTripReimbursementId(),0)?"Yes":"No";
		String oldIsEnterDuringTrip=BtCostListLocalServiceUtil.isEntertainmentCondition(oldBT.getBusinessTripReimbursementId(),0)?"Yes":"No";
		if(!newIsEnterDuringTrip.equals(oldIsEnterDuringTrip)){
			return 0;
		}
		String newIsEnterFee=BtCostListLocalServiceUtil.isEntertainmentCondition(newBT.getBusinessTripReimbursementId(),1)?"Yes":"No";
		String oldIsEnterFee=BtCostListLocalServiceUtil.isEntertainmentCondition(oldBT.getBusinessTripReimbursementId(),1)?"Yes":"No";
		if(!newIsEnterFee.equals(oldIsEnterFee)){
			return 0;
		}
		double newcostListInlandTotalRmb=newBT.getCostListInlandTotalRmb();
		double oldcostListInlandTotalRmb=oldBT.getCostListInlandTotalRmb();
		double  sub=newcostListInlandTotalRmb-oldcostListInlandTotalRmb;
		if(sub>1){
			return 0;
		}
//		if(newcostListInlandTotalRmb!=oldcostListInlandTotalRmb){
//			return 0;
//		}
//		double newcostListForeignTotalEur=newBT.getCostListForeignTotalEur();
//		double oldcostListForeignTotalEur=oldBT.getCostListForeignTotalEur();
//		if(newcostListForeignTotalEur!=oldcostListForeignTotalEur){
//			return 0;
//		}
		return 1;
	}
	private static boolean compareValue(String oldValue,String newValue){
		boolean isCompare=false;
		if(oldValue!=null&&newValue!=null&&oldValue.equals(newValue)){
			isCompare=true;
		}
		return isCompare;
	}
}