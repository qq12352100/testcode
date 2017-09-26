package com.business.trip.portlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.business.trip.model.BusinessTripReimbursement;
import com.business.trip.service.BtTravelExpenseLocalServiceUtil;
import com.global.management.service.GlobalExcelLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.vgc.apon.model.SAPUser;
import com.vgc.apon.service.PendingToSAPLocalServiceUtil;
import com.vgc.apon.service.SAPUserLocalServiceUtil;

/**
 * Portlet implementation class TravelExpenseAllowancePortlet
 */
public class TravelExpenseAllowancePortlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		// TODO Auto-generated method stub
		String startDate = ParamUtil.getString(renderRequest, "startDate");
		String endDate = ParamUtil.getString(renderRequest, "endDate");
		renderRequest.setAttribute("startDate", startDate);
		renderRequest.setAttribute("endDate", endDate);
		super.doView(renderRequest, renderResponse);
	}

	// Execute the query for the query condition
	public void queryBusinessTripReimbursementAsTravelAllowance(
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException {
		String startDate = actionRequest.getParameter("startDate");
		String endDate = actionRequest.getParameter("endDate");
		if (startDate != null && !"".equals(startDate)) {
			actionResponse.setRenderParameter("startDate", startDate);
		}
		if (endDate != null && !"".equals(endDate)) {
			actionResponse.setRenderParameter("endDate", endDate);
		}
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		// TODO Auto-generated method stub
		String startDate = ParamUtil.getString(resourceRequest, "startDate");
		String endDate = ParamUtil.getString(resourceRequest, "endDate");
		Map<String, String> headers = new LinkedHashMap<String, String>();
		headers.put("h0", "No.");
		headers.put("h1", "Ticket No");
		headers.put("h2", "Personal ID");
		headers.put("h3", "Print Name");
		headers.put("h4", "Date");
		headers.put("h5", "Wage Type");
		headers.put("h6", "Wage Type Test");
		headers.put("h7", "Amount");
		headers.put("h8", "Currency");
		headers.put("h9", "Number");
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		List<Map<String, String>> rows = new ArrayList<Map<String, String>>();
		try {
			List<BusinessTripReimbursement> list = BtTravelExpenseLocalServiceUtil
					.getDomesticBusinessTripReimbursementTravelExpenses(
							startDate, endDate, 0, Integer.MAX_VALUE);
			for (int i = 0; i < list.size(); i++) {
			
				Map<String, String> row = new LinkedHashMap<String, String>();
				BusinessTripReimbursement businessTripReimbursement = list
						.get(i);
				double amount=0d;
				if(businessTripReimbursement.getTripType()==0){
					amount=businessTripReimbursement.getTotalTravelExpenseRmb();
				}else{
					amount=BtTravelExpenseLocalServiceUtil.findSumByCurrency(businessTripReimbursement.getBusinessTripReimbursementId(), "RMB");
				} 
				row.put("c0", String.valueOf(businessTripReimbursement
						.getBusinessTripReimbursementId()));
				row.put("c1",
						businessTripReimbursement.getBussinessTirpTicketNo());
				row.put("c2", String.valueOf(businessTripReimbursement
						.getStaffCode()));
				row.put("c3", businessTripReimbursement.getPrintName());
				row.put("c4",
						sdf.format(businessTripReimbursement.getStatusDate()));
				SAPUser sapUser = SAPUserLocalServiceUtil
						.getSapUserByStaffCode(String
								.valueOf(businessTripReimbursement
										.getStaffCode()));
				String lgart = "";
				String lgart_test = "";
				if (sapUser != null
						&& (sapUser.getEmployeeGroupId().equals("1") || sapUser
								.getEmployeeGroupId().equals("9"))) {
					lgart = "1691";
					lgart_test="Travel Allowance";
				} else if (sapUser != null
						&& sapUser.getEmployeeGroupId().equals("3")) {
					if(sapUser.getPayrollArea()!=null&&sapUser.getPayrollArea().equalsIgnoreCase("F2")){
						lgart = "8091";
						lgart_test="Travel Allowance-Domestic";
					}else if(sapUser.getPayrollArea()!=null&&(sapUser.getPayrollArea().equalsIgnoreCase("V1")||sapUser.getPayrollArea().equalsIgnoreCase("V4"))){
						lgart = "1691";
						lgart_test="Travel Allowance";
					}
				} else if (sapUser != null
						&& (sapUser.getEmployeeGroupId().equals("5"))){
					lgart = "8091";
					lgart_test="Travel Allowance-Domestic";
				} else if (sapUser != null
						&& (sapUser.getEmployeeGroupId().equals("4") || sapUser
								.getEmployeeGroupId().equals("6"))) {
					lgart = "2009";
					lgart_test="Gross Amount";
				} else if (sapUser != null
						&& (sapUser.getEmployeeGroupId().equals("7") || sapUser
								.getEmployeeGroupId().equals("8"))) {
					lgart = "N/A";
					lgart_test= "N/A";
				} else {
					lgart = "N/A";
					lgart_test= "N/A";
				}

				row.put("c5", lgart);
				row.put("c6", lgart_test);
				row.put("c7",String.valueOf(amount));
				row.put("c8","RMB");
				row.put("c9", "");
				rows.add(row);
			}
			GlobalExcelLocalServiceUtil.exportExcel(headers, rows,
					"DomesticTripTravelAllowance.xlsx", resourceResponse);
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		super.serveResource(resourceRequest, resourceResponse);
	}

}
