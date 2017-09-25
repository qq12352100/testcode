package com.business.trip.portlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.business.trip.model.BtCarRentalInfo;
import com.business.trip.model.BtCostList;
import com.business.trip.model.BtEntertainmentDetail;
import com.business.trip.model.BtFlightTrainInfo;
import com.business.trip.model.BtHotelInfo;
import com.business.trip.model.BtTrainInfo;
import com.business.trip.model.BtTravelExpense;
import com.business.trip.model.BusinessTripApplication;
import com.business.trip.model.BusinessTripReimbursement;
import com.business.trip.model.RateCity;
import com.business.trip.service.BtCarRentalInfoLocalServiceUtil;
import com.business.trip.service.BtCostListLocalServiceUtil;
import com.business.trip.service.BtEntertainmentDetailLocalServiceUtil;
import com.business.trip.service.BtExchangeRateLocalServiceUtil;
import com.business.trip.service.BtFlightTrainInfoLocalServiceUtil;
import com.business.trip.service.BtHotelInfoLocalServiceUtil;
import com.business.trip.service.BtTrainInfoLocalServiceUtil;
import com.business.trip.service.BtTravelExpenseLocalServiceUtil;
import com.business.trip.service.BusinessTripApplicationLocalServiceUtil;
import com.business.trip.service.BusinessTripReimbursementLocalServiceUtil;
import com.business.trip.service.RateCityLocalServiceUtil;
import com.business.trip.util.ActionConstants;
import com.business.trip.util.BTApplicationUtil;
import com.business.trip.util.BusinessTripConstants;
import com.business.trip.util.PdfReaderUtil;
import com.business.trip.util.TravelExpenseUtil;
import com.file.management.model.FileManagement;
import com.file.management.service.FileManagementLocalServiceUtil;
import com.global.management.service.GlobalToolLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.model.WorkflowInstanceLink;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.WorkflowInstanceLinkLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.vgc.apon.model.SAPUser;
import com.vgc.apon.service.SAPUserLocalServiceUtil;

/**
 * Portlet implementation class BusinessTripReimbursementPortlet
 */
public class BusinessTripReimbursementPortlet extends MVCPortlet {
	private static Log log = LogFactoryUtil.getLog(BusinessTripReimbursementPortlet.class);
	private static String RMB = "RMB";
	private static String EUR = "EUR";

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		String bussinessTirpTicketNo = ParamUtil.getString(renderRequest,
				"bussinessTirpTicketNo2");
		String cmd2 = ParamUtil.getString(renderRequest, "cmd2");   
		double totalCostRmb = ParamUtil.getDouble(renderRequest,
				"totalCostRmb", 0d);
		double totalCostEur = ParamUtil.getDouble(renderRequest,
				"totalCostEur", 0d);
		double hotelTotalCostRmb = ParamUtil.getDouble(renderRequest,
				"hotelTotalCostRmb", 0d);
		double hotelTotalCostEur = ParamUtil.getDouble(renderRequest,
				"hotelTotalCostEur", 0d);
		double carRentalTotalCostRmb = ParamUtil.getDouble(renderRequest,
				"carRentalTotalCostRmb", 0d);
		double carRentalTotalCostEur = ParamUtil.getDouble(renderRequest,
				"carRentalTotalCostEur", 0d);
		double totalTravelExpenseRmb = ParamUtil.getDouble(renderRequest,
				"totalTravelExpenseRmb", 0d);
		double totalTravelExpenseEur = ParamUtil.getDouble(renderRequest,
				"totalTravelExpenseEur", 0d);
		String flightCurrency = ParamUtil.getString(renderRequest,
				"flightCurrency");
		double flightTotal = ParamUtil.getDouble(renderRequest, "flightTotal",
				0d);
		double flightTransactionFee = ParamUtil.getDouble(renderRequest,
				"flightTransactionFee", 0d);
		double flightAirFare = ParamUtil.getDouble(renderRequest,
				"flightAirFare", 0d);
		double flightTaxes = ParamUtil.getDouble(renderRequest, "flightTaxes",
				0d);
		String search = ParamUtil.getString(renderRequest, "search");
		System.out.println("****************doView************search="+search);
		BusinessTripApplication businessTripApplication = null;
		try {
			if (!"".equals(bussinessTirpTicketNo)) {
				if ("Yes".equals(search)) {
					Map<String, Object> map = BusinessTripApplicationLocalServiceUtil
							.searchBusinessTripApplicationByTicketNo(bussinessTirpTicketNo);
					String status = (String) map.get("status");
					if (status.equals("error")) {
						renderRequest.setAttribute("errorMessage",
								map.get("message"));
					} else {
						 businessTripApplication = (BusinessTripApplication) map
								.get("businessTripApplication");
						renderRequest.setAttribute("businessTripApplication",
								businessTripApplication);
						if(businessTripApplication != null){
							SAPUser sapUser = SAPUserLocalServiceUtil.getSapUserByStaffCode(String.valueOf(businessTripApplication.getStaffCode()));
							if(sapUser !=null){
								renderRequest.setAttribute("tempApproverId",sapUser.getSupervisorFgId());
								renderRequest.setAttribute("tempApproverName",sapUser.getSupervisorFgName());
								renderRequest.setAttribute("tempEvpName",sapUser.getDivisionManagerName());
								renderRequest.setAttribute("tempEvpId",sapUser.getDivisionManagerId());
								System.out.println("******************doview***********tempEvpId="+String.valueOf(sapUser.getDivisionManagerId()));
							}
						}
						renderRequest.setAttribute("selectBT","Y");
					}
				} else {
					 businessTripApplication = BusinessTripApplicationLocalServiceUtil
							.getBusinessTripApplicationByTicketNo(bussinessTirpTicketNo);
					renderRequest.setAttribute("businessTripApplication",
							businessTripApplication);
				}
				// BusinessTripApplication businessTripApplication =
				// BusinessTripApplicationLocalServiceUtil
				// .getBusinessTripApplicationByTicketNo(bussinessTirpTicketNo);
				renderRequest.setAttribute("totalCostRmb",
						String.valueOf(totalCostRmb));
				renderRequest.setAttribute("totalCostEur",
						String.valueOf(totalCostEur));
				renderRequest.setAttribute("hotelTotalCostRmb",
						String.valueOf(hotelTotalCostRmb));
				renderRequest.setAttribute("hotelTotalCostEur",
						String.valueOf(hotelTotalCostEur));
				renderRequest.setAttribute("carRentalTotalCostRmb",
						String.valueOf(carRentalTotalCostRmb));
				renderRequest.setAttribute("carRentalTotalCostEur",
						String.valueOf(carRentalTotalCostEur));
				renderRequest.setAttribute("totalTravelExpenseRmb",
						String.valueOf(totalTravelExpenseRmb));
				renderRequest.setAttribute("totalTravelExpenseEur",
						String.valueOf(totalTravelExpenseEur));
				renderRequest.setAttribute("flightCurrency", flightCurrency);
				renderRequest.setAttribute("flightTotal",
						String.valueOf(flightTotal));
				renderRequest.setAttribute("flightTransactionFee",
						String.valueOf(flightTransactionFee));
				renderRequest.setAttribute("flightAirFare",
						String.valueOf(flightAirFare));
				renderRequest.setAttribute("flightTaxes",
						String.valueOf(flightTaxes));
				renderRequest.setAttribute("cmd2", String.valueOf(cmd2));
			}
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		super.doView(renderRequest, renderResponse);
	}

	/**
	 * Save,Update,Submit the businessTripApplication
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void addBusinessTripReimbursement(ActionRequest request,
			ActionResponse response) throws Exception {
		UploadPortletRequest uploadPortletRequest = PortalUtil
				.getUploadPortletRequest(request);
		ThemeDisplay themeDisplay = (ThemeDisplay) uploadPortletRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		String cmd = ParamUtil.getString(uploadPortletRequest, Constants.CMD);
		long businessTripReimbursementId = ParamUtil.getLong(
				uploadPortletRequest, "businessTripReimbursementId");
		boolean isPaybyRmb = ParamUtil.getBoolean(uploadPortletRequest,
				"isPaybyRmb",false);
		String bussinessTirpTicketNo = ParamUtil.getString(
				uploadPortletRequest, "bussinessTirpTicketNo");
		double totalCostRmb = ParamUtil.getDouble(uploadPortletRequest,
				"totalCostRmb");
		double totalCostEur = ParamUtil.getDouble(uploadPortletRequest,
				"totalCostEur");
		double hotelTotalCostRmb = ParamUtil.getDouble(uploadPortletRequest,
				"hotelTotalCostRmb");
		double hotelTotalCostEur = ParamUtil.getDouble(uploadPortletRequest,
				"hotelTotalCostEur");
		double carRentalTotalCostRmb = ParamUtil.getDouble(
				uploadPortletRequest, "carRentalTotalCostRmb");
		double carRentalTotalCostEur = ParamUtil.getDouble(
				uploadPortletRequest, "carRentalTotalCostEur");
		double totalTravelExpenseRmb = ParamUtil.getDouble(
				uploadPortletRequest, "totalTravelExpenseRmb");
		double totalTravelExpenseEur = ParamUtil.getDouble(
				uploadPortletRequest, "totalTravelExpenseEur");
		double costListInlandTotalRmb = ParamUtil.getDouble(
				uploadPortletRequest, "costListInlandTotalRmb");
		double costListForeignTotalEur = ParamUtil.getDouble(
				uploadPortletRequest, "costListForeignTotalEur");
		double costListForeignTotalRmb = ParamUtil.getDouble(
				uploadPortletRequest, "costListForeignTotalRmb");
		String flightCurrency = ParamUtil.getString(uploadPortletRequest,
				"flightCurrency");
		double flightTotal = ParamUtil.getDouble(uploadPortletRequest,
				"flightTotal");
		double flightAirFare = ParamUtil.getDouble(uploadPortletRequest,
				"flightAirFare");
		double flightTaxes = ParamUtil.getDouble(uploadPortletRequest,
				"flightTaxes");
		double flightTransactionFee = ParamUtil.getDouble(uploadPortletRequest,
				"flightTransactionFee");
		
		long approverId = ParamUtil.getLong(uploadPortletRequest, "approverId");
		String approverName = ParamUtil.getString(uploadPortletRequest,
				"approverName");
		System.out.println("**********************approve name**************="+approverName);
	
				
		BusinessTripApplication businessTripApplication = BusinessTripApplicationLocalServiceUtil
				.getBusinessTripApplicationByTicketNo(bussinessTirpTicketNo);
		String remark = ParamUtil.getString(uploadPortletRequest, "remark");
		BusinessTripReimbursement businessTripReimbursement = BusinessTripReimbursementLocalServiceUtil
				.fetchBusinessTripReimbursement(businessTripReimbursementId);
		if (businessTripReimbursement == null) {
			if (businessTripReimbursementId == 0) {
				businessTripReimbursementId = CounterLocalServiceUtil
						.increment(BusinessTripReimbursement.class.getName(), 1);
			}
			businessTripReimbursement = BusinessTripReimbursementLocalServiceUtil
					.createBusinessTripReimbursement(businessTripReimbursementId);
			String ticketNo = GlobalToolLocalServiceUtil.generateTicketNo("BR");
			businessTripReimbursement.setTicketNo(ticketNo);
			Date now = new Date();
			businessTripReimbursement.setCreateDate(now);
		} else {
			if (businessTripReimbursement.getTicketNo() == null
					|| businessTripReimbursement.getTicketNo().equals("")) {
				String ticketNo = GlobalToolLocalServiceUtil
						.generateTicketNo("BR");
				businessTripReimbursement.setTicketNo(ticketNo);
				Date now = new Date();
				businessTripReimbursement.setCreateDate(now);
			}
		}
		System.out.println("***********businessTripReimbursement.getSapStatus()**********="+businessTripReimbursement.getSapStatus());
		if (businessTripReimbursement.getSapStatus() == 1) {
			System.out.println("***********businessTripReimbursement.getBussinessTirpTicketNo()**********="+businessTripReimbursement.getBussinessTirpTicketNo());
			System.out.println("***********bussinessTirpTicketNo**********="+bussinessTirpTicketNo);
			if (!businessTripReimbursement.getBussinessTirpTicketNo().equals(
					bussinessTirpTicketNo)) {
				businessTripReimbursement.setSapStatus(0);
			}
		}
		businessTripReimbursement.setStatus(2);//null
		businessTripReimbursement
				.setBussinessTirpTicketNo(bussinessTirpTicketNo);
		businessTripReimbursement
				.setProcessType(BusinessTripConstants.PROCESS_TYPE_BUSINESS_TRIP_REIMBURSEMENT);
		businessTripReimbursement
				.setSubType(BusinessTripConstants.SUB_TYPE_BUSINESS_TRIP_REIMBURSEMENT);
		businessTripReimbursement.setPrintName(businessTripApplication
				.getPrintName());
		businessTripReimbursement.setStaffCode(businessTripApplication
				.getStaffCode());
		businessTripReimbursement.setCompanyName(businessTripApplication
				.getCompanyName());
		businessTripReimbursement.setDivision(businessTripApplication
				.getDivision());
		businessTripReimbursement.setDepartment(businessTripApplication
				.getDepartment());
		businessTripReimbursement.setCostCenter(businessTripApplication
				.getCostCenter());
		businessTripReimbursement.setPersonalID(businessTripApplication
				.getPersonalID());
		businessTripReimbursement.setPassportNo(businessTripApplication
				.getPassportNo());
		businessTripReimbursement.setOfficePhone(businessTripApplication
				.getOfficePhone());
		businessTripReimbursement.setMobilePhone(businessTripApplication
				.getMobilePhone());
		businessTripReimbursement.setEmail(businessTripApplication.getEmail());
		businessTripReimbursement.setOfficeSite(businessTripApplication
				.getOfficeSite());
		long staffCode = businessTripApplication.getStaffCode();
		/**
		 * if the current user is applicant agent
		 */
		if(themeDisplay.getUser().getFacebookId() != staffCode){
			businessTripReimbursement.setIsApplicantAgent(true);
		}else{
			businessTripReimbursement.setIsApplicantAgent(false);
		}
		
		// add select evp 		
	    long evpId = ParamUtil.getLong(uploadPortletRequest, "evpId",0);
	    String evpName = ParamUtil.getString(uploadPortletRequest, "evpName");
	    System.out.println("================submit+++++++++++++++evpid1="+evpId+"/"+evpName);
				
		if(staffCode!=0){
			SAPUser sapUser = SAPUserLocalServiceUtil.getSapUserByStaffCode(String.valueOf(staffCode));
			if( approverId ==0 && sapUser!=null){
				approverId = Long.valueOf(Validator.isNotNull(sapUser.getSupervisorFgId())?sapUser.getSupervisorFgId():"0");
				approverName = sapUser.getSupervisorFgName();
						
			}
			if( evpId==0 && sapUser!=null){
				evpId = Long.valueOf(Validator.isNotNull(sapUser.getDivisionManagerId())?sapUser.getDivisionManagerId():"0");
				evpName = sapUser.getDivisionManagerName();
			}
		
		}
		  System.out.println("================submit+++++++++++++++evpid2="+evpId+"/"+evpName);
			
		businessTripReimbursement.setEvpId(evpId);
		businessTripReimbursement.setEvpName(evpName);
		
	    businessTripReimbursement.setApproverId(approverId);
		businessTripReimbursement.setApproverName(approverName);
		
		businessTripReimbursement.setIsCrossDepartment(businessTripApplication
				.getIsCrossDepartment());
		businessTripReimbursement.setTargetDepartmentId(businessTripApplication
				.getTargetDepartmentId());
		businessTripReimbursement
				.setTargetDepartmentName(businessTripApplication
						.getTargetDepartmentName());
		businessTripReimbursement.setTargetCostCenter(businessTripApplication
				.getTargetCostCenter());
		businessTripReimbursement
				.setTargetDepartmentApproverId(businessTripApplication
						.getTargetDepartmentApproverId());
		businessTripReimbursement
				.setTargetDepartmentApproverName(businessTripApplication
						.getTargetDepartmentApproverName());
		businessTripReimbursement.setTripType(businessTripApplication
				.getTripType());
		businessTripReimbursement.setDepartureDate(businessTripApplication
				.getDepartureDate());
		businessTripReimbursement.setReturnDate(businessTripApplication
				.getReturnDate());
		businessTripReimbursement.setPurposeOfTheTrip(businessTripApplication
				.getPurposeOfTheTrip());
		businessTripReimbursement
				.setVisitCountriesCities(businessTripApplication
						.getVisitCountriesCities());
		businessTripReimbursement.setAdvancePayment(businessTripApplication
				.getAdvancePayment());
		businessTripReimbursement.setPaymentMethods(businessTripApplication
				.getPaymentMethods());
		businessTripReimbursement.setCurrency(businessTripApplication
				.getCurrency());
		businessTripReimbursement.setTotalCostRmb(totalCostRmb);
		businessTripReimbursement.setTotalCostEur(totalCostEur);
		businessTripReimbursement.setHotelTotalCostRmb(hotelTotalCostRmb);
		businessTripReimbursement.setHotelTotalCostEur(hotelTotalCostEur);
		businessTripReimbursement
				.setCarRentalTotalCostRmb(carRentalTotalCostRmb);
		businessTripReimbursement
				.setCarRentalTotalCostEur(carRentalTotalCostEur);
		businessTripReimbursement
				.setTotalTravelExpenseRmb(totalTravelExpenseRmb);
		businessTripReimbursement
				.setTotalTravelExpenseEur(totalTravelExpenseEur);
		businessTripReimbursement
				.setCostListInlandTotalRmb(costListInlandTotalRmb);
		businessTripReimbursement
				.setCostListForeignTotalEur(costListForeignTotalEur);
		businessTripReimbursement
				.setCostListForeignTotalRmb(costListForeignTotalRmb);
		businessTripReimbursement.setFlightTotal(flightTotal);
		businessTripReimbursement.setFlightAirFare(flightAirFare);
		businessTripReimbursement.setFlightCurrency(flightCurrency);
		businessTripReimbursement.setFlightTaxes(flightTaxes);
		businessTripReimbursement.setFlightTransactionFee(flightTransactionFee);
		businessTripReimbursement.setRemark(remark);
		businessTripReimbursement.setIsPaybyRmb(isPaybyRmb);
		List<BusinessTripReimbursement> compareList=BusinessTripReimbursementLocalServiceUtil.findByBussinessTirpTicketNo(bussinessTirpTicketNo);
		if(compareList!=null&&compareList.size()>0){
			int size=compareList.size();
			BusinessTripReimbursement oldBusinessTripReimbursement=compareList.get(size-1);
			if(oldBusinessTripReimbursement.getSapStatus()==1){
				int sapStatus=BTApplicationUtil.compareBusinessTripReimbursement(businessTripReimbursement,oldBusinessTripReimbursement);
				businessTripReimbursement.setSapStatus(sapStatus);  
			}
			
			//businessTripReimbursement.setSapStatus(0);  
		}

		this.saveTheUploadAttachment(uploadPortletRequest, response,
				businessTripReimbursementId);
		ServiceContext serviceContext = ServiceContextFactory
				.getInstance(BusinessTripReimbursement.class.getName(),
						uploadPortletRequest);
		// Get the URL to redirect
		String url = themeDisplay.getURLPortal();
		url = url.indexOf("9080") != -1 || url.indexOf("8080") != -1 ? "" : url
				.substring(url.lastIndexOf('/'));
		StringBuffer sb = new StringBuffer(url);
		String friendlyUrl = PropsUtil
				.get("vgc.apon.my.applications.page.friendly.url");
		sb.append("/web").append(themeDisplay.getScopeGroup().getFriendlyURL())
				.append(friendlyUrl);
		// Get the portlet Id of which need to forward
		String redirectPortletId = PropsUtil
				.get("vgc.apon.my.applications.portletId");
		sb.append("?p_p_id=").append(redirectPortletId).append("&_")
				.append(redirectPortletId).append("_tabs2=");
		if (cmd.equals(Constants.PUBLISH)) {
			String transitionName = businessTripReimbursement.getSapStatus() == 1 ? "resubmitToHRG"
					: "resubmit";
			long companyId = serviceContext.getCompanyId();
			WorkflowInstanceLink w = WorkflowInstanceLinkLocalServiceUtil
					.fetchWorkflowInstanceLink(companyId,
							businessTripReimbursement.getGroupId(),
							BusinessTripReimbursement.class.getName(),
							businessTripReimbursementId);
			if (w != null) {
				WorkflowInstanceLinkLocalServiceUtil
						.deleteWorkflowInstanceLink(w);
			}
			
			businessTripReimbursement = BusinessTripReimbursementLocalServiceUtil
					.submitBusinessTripReimbursement(businessTripReimbursement,
							serviceContext,false);
			String operationUser = themeDisplay.getUser().getFirstName() + " "
					+ themeDisplay.getUser().getLastName();
			String action = "resubmitToHRG".equals(transitionName) ? ActionConstants.SUBMIT_TO_HRG
					: ActionConstants.SUBMIT;
			BusinessTripReimbursementLocalServiceUtil
					.saveOrUpdateAuditTrailLog(serviceContext.getCompanyId(),
							serviceContext.getScopeGroupId(),
							businessTripReimbursementId,
							themeDisplay.getUserId(), operationUser, action, "");
			sb.append("pending");
		} else {
			businessTripReimbursement = BusinessTripReimbursementLocalServiceUtil
					.saveOrUpdateBusinessTripReimbursement(
							businessTripReimbursement, serviceContext);
			sb.append("draft");
		}
		response.sendRedirect(sb.toString());
	}

	// Download the attachments
	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		String cmd = ParamUtil.getString(resourceRequest, "cmd");
		List<RateCity> ratecitys = null;
		if (cmd.equals("ratecity")) {
			try {
				ratecitys = RateCityLocalServiceUtil.getRateCities(0,
						Integer.MAX_VALUE);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JSONArray jsonarr = JSONFactoryUtil.createJSONArray();
			if (ratecitys != null && ratecitys.size() > 0) {
				for (int i = 0; i < ratecitys.size(); i++) {
					RateCity rateCity = ratecitys.get(i);
					JSONObject jsonobj = JSONFactoryUtil.createJSONObject();
					jsonobj.put("ratecityId", rateCity.getRatecityId());
					jsonobj.put("areaName", rateCity.getAreaName());
					jsonobj.put("rateOfDma", rateCity.getRateOfDma());
					jsonobj.put("currency", rateCity.getCurrency());
					jsonobj.put("parentId", rateCity.getParentId());
					jsonarr.put(jsonobj);
				}
			}
			resourceResponse.setContentType("text/html");
			PrintWriter writer = resourceResponse.getWriter();
			writer.write(jsonarr.toString());
			writer.flush();
			writer.close();
		} else {
			String filePath = ParamUtil.getString(resourceRequest, "filePath");
			String fileName = ParamUtil.getString(resourceRequest, "fileName");
			File file = new File(filePath);
			HttpServletResponse response = PortalUtil
					.getHttpServletResponse(resourceResponse);
			response.setContentType(GlobalToolLocalServiceUtil
					.getContentType(fileName));
			response.setContentLength((int) file.length());
			response.setHeader("Content-Disposition", "attachment;filename="
					+ fileName);
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			byte[] b = new byte[1024];
			long k = 0;
			ServletOutputStream sos = response.getOutputStream();
			BufferedOutputStream bos = new BufferedOutputStream(sos);
			while (k < file.length()) {
				int j = bis.read(b, 0, b.length);
				k += j;
				bos.write(b, 0, j);
			}
			bis.close();
			bos.flush();
			bos.close();
			sos.close();
		}
		super.serveResource(resourceRequest, resourceResponse);
	}

	// import pdf
	@SuppressWarnings("unchecked")
	public void upload(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, SystemException {
		UploadPortletRequest uploadPortletRequest = PortalUtil
				.getUploadPortletRequest(actionRequest);
		String bussinessTirpTicketNo = ParamUtil.getString(
				uploadPortletRequest, "bussinessTirpTicketNo2");
		String cmd2 = ParamUtil.getString(uploadPortletRequest, "cmd2");
		double totalCostRmb = ParamUtil.getDouble(uploadPortletRequest,
				"totalCostRmb", 0d);
		double totalCostEur = ParamUtil.getDouble(uploadPortletRequest,
				"totalCostEur", 0d);
		double hotelTotalCostRmb = ParamUtil.getDouble(uploadPortletRequest,
				"hotelTotalCostRmb", 0d);
		double hotelTotalCostEur = ParamUtil.getDouble(uploadPortletRequest,
				"hotelTotalCostEur", 0d);
		double carRentalTotalCostRmb = ParamUtil.getDouble(
				uploadPortletRequest, "carRentalTotalCostRmb", 0d);
		double carRentalTotalCostEur = ParamUtil.getDouble(
				uploadPortletRequest, "carRentalTotalCostEur", 0d);
		// wirte by wanghai
		double totalTravelExpenseRmb = ParamUtil.getDouble(
				uploadPortletRequest, "totalTravelExpenseRmb", 0d);
		double totalTravelExpenseEur = ParamUtil.getDouble(
				uploadPortletRequest, "totalTravelExpenseEur", 0d);
		// end
		// this for list
		double costListInlandTotalRmb = ParamUtil.getDouble(
				uploadPortletRequest, "costListInlandTotalRmb", 0d);
		double costListForeignTotalEur = ParamUtil.getDouble(
				uploadPortletRequest, "costListForeignTotalEur", 0d);
		double costListForeignTotalRmb = ParamUtil.getDouble(
				uploadPortletRequest, "costListForeignTotalRmb", 0d);
		
		//add in 2017/01/23
		String tempApproverId = ParamUtil.getString(actionRequest, "tempApproverId","");
		String tempApproverName = ParamUtil.getString(actionRequest, "tempApproverName","");
		//end in 2017/01/23
		String tempEvpId = ParamUtil.getString(actionRequest, "tempEvpId","");
		String tempEvpName = ParamUtil.getString(actionRequest, "tempEvpName","");
		
		boolean tempIsGetRMB = ParamUtil.getBoolean(actionRequest,"tempIsGetRMB");
		
		int tripCategory=ParamUtil.getInteger(uploadPortletRequest, "tripCategory",0);
		String curency = "";
		double total = 0d;
		double transactionFee = 0d;
		double airFare = 0d;
		double taxes = 0d;
		boolean isNew = true;
		
		if(bussinessTirpTicketNo==null||bussinessTirpTicketNo.equals("")){
			actionResponse.setRenderParameter("importError", "No");
		}else{
		
		long businessTripReimbursementId = ParamUtil.getLong(
				uploadPortletRequest, "businessTripReimbursementId");
		BusinessTripReimbursement businessTripReimbursement = BusinessTripReimbursementLocalServiceUtil
				.fetchBusinessTripReimbursement(businessTripReimbursementId);
		if (businessTripReimbursement == null) {
			isNew = false;
			businessTripReimbursement = BusinessTripReimbursementLocalServiceUtil
					.createBusinessTripReimbursement(businessTripReimbursementId);
			businessTripReimbursement.setStatus(-1);//è§£å†³null null æ•°æ�®
		}
		String fileName = uploadPortletRequest.getFileName("pdfImport");
		String fileType = fileName == null ? "" : fileName.substring(fileName
				.lastIndexOf('.') + 1);
		if (fileName != null && !fileType.equals("pdf")) {
			actionResponse.setRenderParameter("importError", "false");
		} else if (fileName != null) {
		//	int sapStatus = 0;
			InputStream inputStream = uploadPortletRequest
					.getFileAsStream("pdfImport");
			String tripType = PropsUtil
					.get("vgc.apon.business.trip.reimbursement.type");
			Map<String, Object> map=null;
			/**
			 * @author hai.a.wang  
			 * å›½å†…å’Œå›½é™…pdf å¯¼å…¥ ä¿®å¤�
			 */
			if(tripCategory==0){
				map = PdfReaderUtil.getDemosticPdfInfo(inputStream,
						businessTripReimbursementId, tripType);
			}else{
				map = PdfReaderUtil.getPdfInfo(inputStream,
						businessTripReimbursementId, tripType);
			}
			if (map != null && map.containsKey("status")) {
				boolean status = (Boolean) map.get("status");
				if (status) {
					Map<String, Object> flightData = (Map<String, Object>) map
							.get("flight");
					Map<String, String> fareDetails = (Map<String, String>) flightData
							.get("fareDetails");
					List<BtFlightTrainInfo> flightList = (List<BtFlightTrainInfo>) flightData
							.get("flightList");
					curency = fareDetails.get("curency") == null ? ""
							: fareDetails.get("curency");
					total = fareDetails.get("total") == null ? 0d : Double
							.valueOf(fareDetails.get("total").replace(",", ""));
					transactionFee = fareDetails.get("transactionFee") == null ? 0d
							: Double.valueOf(fareDetails.get("transactionFee")
									.replace(",", ""));
					airFare = fareDetails.get("airFare") == null ? 0d : Double
							.valueOf(fareDetails.get("airFare")
									.replace(",", ""));
					taxes = fareDetails.get("taxes") == null ? 0d : Double
							.valueOf(fareDetails.get("taxes").replace(",", ""));
					//BusinessTripReimbursement oldBusinessTripReimbursement = businessTripReimbursement;
					businessTripReimbursement.setFlightTotal(total);
					businessTripReimbursement.setFlightAirFare(airFare);
					businessTripReimbursement.setFlightCurrency(curency);
					businessTripReimbursement.setFlightTaxes(taxes);
					businessTripReimbursement
							.setFlightTransactionFee(transactionFee);
					//List<BtFlightTrainInfo> oldBtFlightTrainInfos = BtFlightTrainInfoLocalServiceUtil.findByB_T(businessTripReimbursementId, tripType,-1, -1);
					BtFlightTrainInfoLocalServiceUtil
							.deleteBtFlightTrainInfoByB_T(
									businessTripReimbursementId, tripType);
					for (BtFlightTrainInfo btFlightTrainInfo : flightList) {
						BtFlightTrainInfoLocalServiceUtil
								.addBtFlightTrainInfo(btFlightTrainInfo);
					}
					if (!isNew) {
//						if (businessTripReimbursement.getSapStatus() == 1) {
//							sapStatus = BTApplicationUtil.compareTabs(
//									"flight-fareDetails",
//									oldBusinessTripReimbursement,
//									businessTripReimbursement);
//							if (sapStatus == 1) {
//								List<BtFlightTrainInfo> newBtFlightTrainInfos = BtFlightTrainInfoLocalServiceUtil
//										.findByB_T(businessTripReimbursementId,
//												tripType, -1, -1);
//								sapStatus = BTApplicationUtil.compareTabs(
//										"flight", oldBtFlightTrainInfos,
//										newBtFlightTrainInfos);
//							}
//							businessTripReimbursement.setSapStatus(sapStatus);
//						}
						BusinessTripReimbursementLocalServiceUtil
								.updateBusinessTripReimbursement(businessTripReimbursement);
					}
					actionResponse.setRenderParameter("importError", "true");
				} else {
					actionResponse.setRenderParameter("importError", "false");
				}
			} else {
				actionResponse.setRenderParameter("importError", "false");
			}
		}
		actionResponse.setRenderParameter("totalCostRmb",
				String.valueOf(totalCostRmb));
		actionResponse.setRenderParameter("totalCostEur",
				String.valueOf(totalCostEur));
		actionResponse.setRenderParameter("hotelTotalCostRmb",
				String.valueOf(hotelTotalCostRmb));
		actionResponse.setRenderParameter("hotelTotalCostEur",
				String.valueOf(hotelTotalCostEur));
		actionResponse.setRenderParameter("carRentalTotalCostRmb",
				String.valueOf(carRentalTotalCostRmb));
		actionResponse.setRenderParameter("carRentalTotalCostEur",
				String.valueOf(carRentalTotalCostEur));
		// test
		actionResponse.setRenderParameter("costListInlandTotalRmb",
				String.valueOf(costListInlandTotalRmb));
		actionResponse.setRenderParameter("costListForeignTotalRmb",
				String.valueOf(costListForeignTotalRmb));
		actionResponse.setRenderParameter("costListForeignTotalEur",
				String.valueOf(costListForeignTotalEur));
		// --------------
		actionResponse.setRenderParameter("totalTravelExpenseRmb",
				String.valueOf(totalTravelExpenseRmb));
		actionResponse.setRenderParameter("totalTravelExpenseEur",
				String.valueOf(totalTravelExpenseEur));
		actionResponse.setRenderParameter("flightCurrency", curency);
		actionResponse.setRenderParameter("flightTotal", String.valueOf(total));
		actionResponse.setRenderParameter("flightTransactionFee",
				String.valueOf(transactionFee));
		actionResponse.setRenderParameter("flightAirFare",
				String.valueOf(airFare));
		actionResponse.setRenderParameter("flightTaxes", String.valueOf(taxes));
		actionResponse.setRenderParameter("tabs2", "flight");
		actionResponse.setRenderParameter("cmd2", cmd2);
		actionResponse.setRenderParameter("bussinessTirpTicketNo2",
				bussinessTirpTicketNo);
		actionResponse.setRenderParameter("businessTripReimbursementId",
				String.valueOf(businessTripReimbursementId));
		
		actionResponse.setRenderParameter("tempApproverId",String.valueOf(tempApproverId));
		actionResponse.setRenderParameter("tempApproverName",String.valueOf(tempApproverName));
		actionResponse.setRenderParameter("tempEvpId",String.valueOf(tempEvpId ));
		actionResponse.setRenderParameter("tempEvpName",String.valueOf(tempEvpName ));
		actionResponse.setRenderParameter("tempIsGetRMB",String.valueOf(tempIsGetRMB));
		
		}
		// actionResponse.setRenderParameter("mvcPath","/html/businessTripReimbursement/view.jsp");
	}

	// save or update the attachments
	public void saveTheUploadAttachment(
			UploadPortletRequest uploadPortletRequest,
			ActionResponse actionResponse, long businessTripReimbursementId)
			throws PortalException, SystemException, IOException {
		// E:/liferay-portal-6.2.10.1-ee-ga1/data/document_library
		String fileNames[] = uploadPortletRequest.getFileNames("fileName");
		String existFileIds = ParamUtil.getString(uploadPortletRequest,
				"existFileIds");
		String existTitles = ParamUtil.getString(uploadPortletRequest,
				"existTitles");
		String fileManagementIds[] = StringUtil.split(existFileIds, ',');
		String title[] = StringUtil.split(existTitles, ',');
		List<FileManagement> fileManagements = FileManagementLocalServiceUtil
				.getByAssetClassNameAndAssetPrimaryKey(
						BusinessTripReimbursement.class.getName(),
						businessTripReimbursementId);
		for (FileManagement fileManagement : fileManagements) {
			if (fileManagementIds.length == 0) {
				FileManagementLocalServiceUtil
						.deleteFileManagement(fileManagement);
			} else {
				boolean isDelete = true;
				String t = "";
				for (int i = 0; i < fileManagementIds.length; i++) {
					if (fileManagement.getFileManagementId() == Long
							.valueOf(fileManagementIds[i])) {
						isDelete = false;
						t = "XXX".equals(title[i]) ? fileManagement
								.getFileName() : title[i];
						break;
					}
				}
				if (isDelete) {
					FileManagementLocalServiceUtil
							.deleteFileManagement(fileManagement);
				} else {
					fileManagement.setTitle(t);
					FileManagementLocalServiceUtil
							.updateFileManagement(fileManagement);
				}
			}
		}
		if (fileNames != null) {
			ServiceContext serviceContext = ServiceContextFactory
					.getInstance(uploadPortletRequest);
			String newTitles = ParamUtil.getString(uploadPortletRequest,
					"newTitles");
			ParamUtil
					.getParameterValues(uploadPortletRequest, "attachmentName");
			String newTitle[] = StringUtil.split(newTitles, ',');
			File file[] = uploadPortletRequest.getFiles("fileName");
			Date date = new Date();
			for (int i = 0; i < fileNames.length; i++) {
				String fileName = fileNames[i];
				if (fileName != null && !"".equals(fileName)) {
					String randomSourceFileName = FileManagementLocalServiceUtil
							.getRandomSourceFileName(fileName);
					File destination = null;
					String filePath = PropsUtil
							.get("dl.store.file.system.root.dir");
					filePath = filePath
							+ new SimpleDateFormat("/yyyy/MM/dd/").format(date);
					filePath = filePath.concat(randomSourceFileName);
					destination = new File(filePath);
					FileUtil.copyFile(file[i], destination);
					FileUtil.delete(file[i]);
					String t = "XXX".equals(newTitle[i]) ? FileManagementLocalServiceUtil
							.getFileName(fileName) : newTitle[i];
					FileManagementLocalServiceUtil.saveOrUpdateFileManagement(
							0, BusinessTripReimbursement.class.getName(),
							businessTripReimbursementId, 0, fileName, fileName,
							FileManagementLocalServiceUtil
									.getFileType(fileName), filePath, t,
							file[i].length(), serviceContext);
				}
			}
		}
	}

	@Override
	public void processAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		try {
			String isRedirect = ParamUtil.getString(actionRequest,
					"isRedirect", "No");
			String isImport = ParamUtil.getString(actionRequest, "isImport",
					"No");
			String search = ParamUtil.getString(actionRequest, "search", "No");
			String updateMore = ParamUtil.getString(actionRequest, "updateMore", "No");
			if ("Yes".equals(isRedirect)) {
				this.addBusinessTripReimbursement(actionRequest, actionResponse);
			}
			if ("Yes".equals(isImport)) {
				this.upload(actionRequest, actionResponse);
			}
			if ("Yes".equals(search)) {
				searchBussinessTirpTicketNo(actionRequest, actionResponse);
			}
			if ("Yes".equals(updateMore)) {
				updateMoreAllowance(actionRequest, actionResponse);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		super.processAction(actionRequest, actionResponse);
	}
	private void updateMoreAllowance(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortalException, SystemException, ParseException{
		//Add in 2017/01/19
		SimpleDateFormat sdf_allowance = new SimpleDateFormat("dd.MM.yyyy");
		String[] departures = ParamUtil.getParameterValues(actionRequest, "departure");
		String[] arrivals = ParamUtil.getParameterValues(actionRequest, "arrival");
		long businessTripReimbursementId = ParamUtil.getLong(actionRequest, "businessTripReimbursementId",0);
		String tripType = ParamUtil.getString(actionRequest, "tripType");
		//Add in 2017/01/19
		
		// wirte by wanghai
		double totalTravelExpenseRmb = ParamUtil.getDouble(actionRequest,"totalTravelExpenseRmb", 0d);
		double totalTravelExpenseEur = ParamUtil.getDouble(actionRequest,"totalTravelExpenseEur", 0d);
		String[] btTravelExpenseIds=ParamUtil.getParameterValues(actionRequest, "btTravelExpenseId");
		String[] isHasBreakfasts=ParamUtil.getParameterValues(actionRequest, "isHasBreakfast");
		String[] isHasLunchs=ParamUtil.getParameterValues(actionRequest, "isHasLunch");
		String[] isHasDinners=ParamUtil.getParameterValues(actionRequest, "isHasDinner");
		String[] rateOfDmas=ParamUtil.getParameterValues(actionRequest, "rateOfDma");
		String[] countrys=ParamUtil.getParameterValues(actionRequest, "country");
		String[] citys=ParamUtil.getParameterValues(actionRequest, "city");
		String[] currencys=ParamUtil.getParameterValues(actionRequest, "currency");
		String[] allowances=ParamUtil.getParameterValues(actionRequest, "allowance");
		
		Date fromTravelDate = new Date();//ParamUtil.getDate(actionRequest, "fromTravelDate", sdf_allowance);
		Date toTravelDate = new Date();//ParamUtil.getDate(actionRequest, "toTravelDate", sdf_allowance);
		if(0!=businessTripReimbursementId){
			List<BtTravelExpense> tempBtTravelExpenseList = BtTravelExpenseLocalServiceUtil.findByB_T(businessTripReimbursementId, tripType,-1,-1);
			if(null!=tempBtTravelExpenseList){
				fromTravelDate =  sdf_allowance.parse(tempBtTravelExpenseList.get(0).getTravelDate());
				toTravelDate =  sdf_allowance.parse(tempBtTravelExpenseList.get(tempBtTravelExpenseList.size()-1).getTravelDate());
			}
//			long btTravelExpenseIdFirst=Long.parseLong(btTravelExpenseIds[0]);
//			long btTravelExpenseIdSecond=Long.parseLong(btTravelExpenseIds[btTravelExpenseIds.length-1]);
//			BtTravelExpense btTravelExpense=BtTravelExpenseLocalServiceUtil.getBtTravelExpense(btTravelExpenseIdFirst);
			
		}
		
		for(int i=0;i<btTravelExpenseIds.length;i++){
			long btTravelExpenseId=Long.parseLong(btTravelExpenseIds[i]);
			BtTravelExpense btTravelExpense=BtTravelExpenseLocalServiceUtil.getBtTravelExpense(btTravelExpenseId);
			double oldallowance=btTravelExpense.getAllowance();
			String oldCurrency=btTravelExpense.getCurrency();
			
			double allowance=Double.parseDouble(allowances[i]);
			boolean isHasBreakfast = Boolean.parseBoolean(isHasBreakfasts[i]);
			boolean isHasLunch = Boolean.parseBoolean(isHasLunchs[i]);
			boolean isHasDinner = Boolean.parseBoolean(isHasDinners[i]);
			double rateOfDma = Double.parseDouble(rateOfDmas[i]);
			String departure = departures[i];
			String arrival = arrivals[i];
			String travelDate=TravelExpenseUtil.getTravelDateAsMany(fromTravelDate,i);
			
			allowance=BtTravelExpenseLocalServiceUtil.getAllowance(travelDate,fromTravelDate,toTravelDate,departure, arrival, rateOfDma, isHasBreakfast, isHasLunch, isHasDinner);
			
			String currency=currencys[i];
			btTravelExpense.setIsHasBreakfast(isHasBreakfast);
			btTravelExpense.setIsHasLunch(isHasLunch);
			btTravelExpense.setIsHasDinner(isHasDinner);
			btTravelExpense.setRateOfDma(rateOfDma);
			btTravelExpense.setCountry(countrys[i]);
			btTravelExpense.setCity(citys[i]);
			btTravelExpense.setCurrency(currencys[i]);
			
			btTravelExpense.setAllowance(allowance);
			if(EUR.equals(currency)){
				btTravelExpense.setAllowanceRmb(BtExchangeRateLocalServiceUtil.changeEURToRMB(allowance));
			}else{
				btTravelExpense.setAllowanceRmb(allowance);
			}
			BtTravelExpenseLocalServiceUtil.updateBtTravelExpense(btTravelExpense);
			totalTravelExpenseRmb = BTApplicationUtil.deleteCalculate(
					totalTravelExpenseRmb, RMB, oldallowance, oldCurrency);
					totalTravelExpenseRmb = BTApplicationUtil.addCalculate(
					totalTravelExpenseRmb, RMB, allowance, currency);
			totalTravelExpenseEur = BTApplicationUtil.deleteCalculate(
					totalTravelExpenseEur, EUR, oldallowance, oldCurrency);
			 		totalTravelExpenseEur = BTApplicationUtil.addCalculate(
					totalTravelExpenseEur, EUR, allowance, currency);
		}
		
	}
	//Search the BusinessTripApplication
	public void searchBusinessTripApplication(ActionRequest actionRequest,
			ActionResponse actionResponse) {
		String eventName = ParamUtil.getString(actionRequest, "eventName");
		String ticketNo = ParamUtil.getString(actionRequest,
				"ticketNo");
		String printName = ParamUtil.getString(actionRequest,
				"printName");
		String staffCode = ParamUtil.getString(actionRequest,
				"staffCode");
		String personalID = ParamUtil.getString(actionRequest,
				"personalID");
		String mvcPath = ParamUtil.getString(actionRequest,
				"mvcPath");		
		
		actionResponse.setRenderParameter("eventName", eventName);
		actionResponse.setRenderParameter("ticketNo", ticketNo);
		actionResponse.setRenderParameter("printName", printName);
		actionResponse.setRenderParameter("staffCode", staffCode);
		actionResponse.setRenderParameter("personalID", personalID);
		actionResponse.setRenderParameter("mvcPath", mvcPath);

	}
	
	public void addDetailInfo(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException, PortalException, ParseException {
		long token=ParamUtil.getLong(actionRequest,"token");
		PortletSession session=actionRequest.getPortletSession();
		long tokenInSession=Long.parseLong(session.getAttribute("token")+"");
		String bussinessTirpTicketNo = ParamUtil.getString(actionRequest,"bussinessTirpTicketNo2");
		String tabs2 = ParamUtil.getString(actionRequest, "tabs2", "train");
		String cmd2 = ParamUtil.getString(actionRequest, "cmd2");
		long businessTripReimbursementId = ParamUtil.getLong(actionRequest,"businessTripReimbursementId", 0);
		long pkId = ParamUtil.get(actionRequest, "pkId", 0);
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
		SimpleDateFormat sdf_allowance = new SimpleDateFormat("dd.MM.yyyy");
		String tripType = PropsUtil.get("vgc.apon.business.trip.reimbursement.type");
		double totalCostRmb = ParamUtil.getDouble(actionRequest,"totalCostRmb", 0d);
		double totalCostEur = ParamUtil.getDouble(actionRequest,"totalCostEur", 0d);
		double hotelTotalCostRmb = ParamUtil.getDouble(actionRequest,"hotelTotalCostRmb", 0d);
		double hotelTotalCostEur = ParamUtil.getDouble(actionRequest,"hotelTotalCostEur", 0d);
		double carRentalTotalCostRmb = ParamUtil.getDouble(actionRequest,"carRentalTotalCostRmb", 0d);
		double carRentalTotalCostEur = ParamUtil.getDouble(actionRequest,"carRentalTotalCostEur", 0d);
		// wirte by wanghai
		double totalTravelExpenseRmb = ParamUtil.getDouble(actionRequest,"totalTravelExpenseRmb", 0d);
		double totalTravelExpenseEur = ParamUtil.getDouble(actionRequest,"totalTravelExpenseEur", 0d);
		// end
		// this for list
		double costListInlandTotalRmb = ParamUtil.getDouble(actionRequest,"costListInlandTotalRmb", 0d);
		double costListForeignTotalEur = ParamUtil.getDouble(actionRequest,"costListForeignTotalEur", 0d);
		double costListForeignTotalRmb = ParamUtil.getDouble(actionRequest,"costListForeignTotalRmb", 0d);
		String flightCurrency = ParamUtil.getString(actionRequest,"flightCurrency");
		double flightTotal = ParamUtil.getDouble(actionRequest, "flightTotal");
		double flightAirFare = ParamUtil.getDouble(actionRequest,"flightAirFare");
		double flightTaxes = ParamUtil.getDouble(actionRequest, "flightTaxes");
		double flightTransactionFee = ParamUtil.getDouble(actionRequest,"flightTransactionFee");
		
/*		//add in 2017/1/6
		boolean isApplicantAgent = ParamUtil.getBoolean(actionRequest,
				"isApplicantAgent", false);
		System.out.println("In Add Detail"+isApplicantAgent);
		//end in 2017/1/6
*/		//add in 2017/01/23
		String tempApproverId = ParamUtil.getString(actionRequest, "tempApproverId","");
		String tempApproverName = ParamUtil.getString(actionRequest, "tempApproverName","");
		String tempEvpId = ParamUtil.getString(actionRequest, "tempEvpId","");
		String tempEvpName = ParamUtil.getString(actionRequest, "tempEvpName","");
		//end in 2017/01/23
		boolean tempIsGetRMB = ParamUtil.getBoolean(actionRequest,"tempIsGetRMB");
		System.out.println("In Add Detail tempApproverId"+tempApproverId);
		System.out.println("In Add Detail tempApproverName"+tempApproverName);
		
		boolean isNew = true;
		if(token==tokenInSession){
		if ("train".equals(tabs2)) {
			addorUpdateTrain(pkId, actionRequest, businessTripReimbursementId, tripType, sdf);
		} else if ("hotelInformation".equals(tabs2)) {
			pkId = pkId > 0 ? pkId : CounterLocalServiceUtil.increment(BtHotelInfo.class.getName(), 1);
			BtHotelInfo btHotelInfo = BtHotelInfoLocalServiceUtil.fetchBtHotelInfo(pkId);
			if (btHotelInfo != null) {
				isNew = false;
			} else {
				btHotelInfo = BtHotelInfoLocalServiceUtil.createBtHotelInfo(pkId);
			}
			double oldPrice = btHotelInfo.getPrice();
			String oldCurrency = btHotelInfo.getCurrency();
			btHotelInfo=addorUpdateHotel(actionRequest, businessTripReimbursementId, tripType, sdf, btHotelInfo);
			double price = btHotelInfo.getPrice();
			String currency = btHotelInfo.getCurrency();
			if (isNew) {
				hotelTotalCostRmb = BTApplicationUtil.addCalculate(hotelTotalCostRmb, RMB, price, currency);
				hotelTotalCostEur = BTApplicationUtil.addCalculate(hotelTotalCostEur, EUR, price, currency);
			} else {
				hotelTotalCostRmb = BTApplicationUtil.deleteCalculate(hotelTotalCostRmb, RMB, oldPrice, oldCurrency);
				hotelTotalCostRmb = BTApplicationUtil.addCalculate(hotelTotalCostRmb, RMB, price, currency);
				hotelTotalCostEur = BTApplicationUtil.deleteCalculate(hotelTotalCostEur, EUR, oldPrice, oldCurrency);
				hotelTotalCostEur = BTApplicationUtil.addCalculate(hotelTotalCostEur, EUR, price, currency);
			}
		} else if ("carRental".equals(tabs2)) {
			pkId = pkId > 0 ? pkId : CounterLocalServiceUtil.increment(BtCarRentalInfo.class.getName(), 1);
			BtCarRentalInfo btCarRentalInfo = BtCarRentalInfoLocalServiceUtil.fetchBtCarRentalInfo(pkId);
			if (btCarRentalInfo != null) {
				isNew = false;
			} else {
				btCarRentalInfo = BtCarRentalInfoLocalServiceUtil.createBtCarRentalInfo(pkId);
			}
			double oldPrice = btCarRentalInfo.getPrice();
			String oldCurrency = btCarRentalInfo.getCurrency();
			btCarRentalInfo=addorUpdateCarRental(actionRequest, businessTripReimbursementId, tripType, sdf, btCarRentalInfo);
			double price =btCarRentalInfo.getPrice();
			String currency=btCarRentalInfo.getCurrency();
			if (isNew) {
				carRentalTotalCostRmb = BTApplicationUtil.addCalculate(carRentalTotalCostRmb, RMB, price, currency);
				carRentalTotalCostEur = BTApplicationUtil.addCalculate(carRentalTotalCostEur, EUR, price, currency);
			} else {
				carRentalTotalCostRmb = BTApplicationUtil.deleteCalculate(carRentalTotalCostRmb, RMB, oldPrice, oldCurrency);
				carRentalTotalCostRmb = BTApplicationUtil.addCalculate(carRentalTotalCostRmb, RMB, price, currency);
				carRentalTotalCostEur = BTApplicationUtil.deleteCalculate(carRentalTotalCostEur, EUR, oldPrice, oldCurrency);
				carRentalTotalCostEur = BTApplicationUtil.addCalculate(carRentalTotalCostEur, EUR, price, currency);
			}
		} else if ("travelExpense".equals(tabs2)) {
			double allowance = 0;

			String departure = ParamUtil.getString(actionRequest, "departure");
			String arrival = ParamUtil.getString(actionRequest, "arrival");
			String fromCity = ParamUtil.getString(actionRequest, "fromCity");
			String toCity = ParamUtil.getString(actionRequest, "toCity");
			boolean isHasBreakfast = ParamUtil.getBoolean(actionRequest,"isHasBreakfast", true);
			boolean isHasLunch = ParamUtil.getBoolean(actionRequest,"isHasLunch", true);
			boolean isHasDinner = ParamUtil.getBoolean(actionRequest,"isHasDinner", true);
			String country = ParamUtil.getString(actionRequest, "country");
			String city = ParamUtil.getString(actionRequest, "city");
			double rateOfDma = ParamUtil.getDouble(actionRequest, "rateOfDma");
			String currency = ParamUtil.getString(actionRequest, "currency");
			String comments = ParamUtil.getString(actionRequest, "comments");
			Date fromTravelDate = ParamUtil.getDate(actionRequest, "fromTravelDate", sdf_allowance);
			Date toTravelDate = ParamUtil.getDate(actionRequest, "toTravelDate", sdf_allowance);
			String isAdd=ParamUtil.getString(actionRequest, "isAdd","No");
			if(isAdd.equalsIgnoreCase("Yes")){
				int size=TravelExpenseUtil.daysBetween(fromTravelDate, toTravelDate)+1;
				for(int i=0;i<size;i++){
					long allowanceId = CounterLocalServiceUtil.increment(BtTravelExpense.class.getName(), 1);
					BtTravelExpense btTravelExpense = BtTravelExpenseLocalServiceUtil.createBtTravelExpense(allowanceId);
					if(size==1){
						btTravelExpense.setDeparture(departure);
						btTravelExpense.setArrival(arrival);
					}else{
						if(i == 0 ){
							btTravelExpense.setDeparture(departure);
							btTravelExpense.setArrival("23:59");
						}else if(i == size-1){
							btTravelExpense.setDeparture("00:00");
							btTravelExpense.setArrival(arrival);
						}else{
							btTravelExpense.setDeparture("00:00");
							btTravelExpense.setArrival("23:59");
						}
					}
					String travelDate=TravelExpenseUtil.getTravelDateAsMany(fromTravelDate,i);
					allowance=BtTravelExpenseLocalServiceUtil.getAllowance(travelDate,fromTravelDate,toTravelDate,departure, arrival, rateOfDma, isHasBreakfast, isHasLunch, isHasDinner);
					System.out.println("in add");
					btTravelExpense.setTravelDate(travelDate);

					btTravelExpense.setFromCity(fromCity);
					btTravelExpense.setToCity(toCity);
					btTravelExpense.setIsHasBreakfast(isHasBreakfast);
					btTravelExpense.setIsHasLunch(isHasLunch);
					btTravelExpense.setIsHasDinner(isHasDinner);
					btTravelExpense.setCountry(country);
					btTravelExpense.setCity(city);
					btTravelExpense.setRateOfDma(rateOfDma);
					btTravelExpense.setCurrency(currency);
					btTravelExpense.setAllowance(allowance);
					if(EUR.equals(currency)){
						btTravelExpense.setAllowanceRmb(BtExchangeRateLocalServiceUtil.changeEURToRMB(allowance));
					}else{
						btTravelExpense.setAllowanceRmb(allowance);
					}
					btTravelExpense.setComments(comments);
					btTravelExpense.setTripType(tripType);
					btTravelExpense.setBusinessTripPkId(businessTripReimbursementId);
					BtTravelExpenseLocalServiceUtil.updateBtTravelExpense(btTravelExpense);
					if (isNew) {
						totalTravelExpenseRmb = BTApplicationUtil.addCalculate(totalTravelExpenseRmb, RMB, allowance, currency);
						totalTravelExpenseEur = BTApplicationUtil.addCalculate(totalTravelExpenseEur, EUR, allowance, currency);
					}
				}
			
			
			}else if(isAdd.equalsIgnoreCase("updateMore")){
				tabs2="travelExpense";
			}else{
				BtTravelExpense btTravelExpense = BtTravelExpenseLocalServiceUtil.fetchBtTravelExpense(pkId);
				List<BtTravelExpense> btTravelExpenseList = BtTravelExpenseLocalServiceUtil.findByB_C(businessTripReimbursementId, currency);
				String travelDateUpdate = ParamUtil.getString(actionRequest, "travelDate");
				
				if(btTravelExpenseList != null && btTravelExpenseList.size() > 0){
					fromTravelDate = TravelExpenseUtil.StringToDate(btTravelExpenseList.get(0).getTravelDate(), "dd.MM.yyyy");
					toTravelDate = TravelExpenseUtil.StringToDate(btTravelExpenseList.get(btTravelExpenseList.size()-1).getTravelDate(), "dd.MM.yyyy");
				}else{
					fromTravelDate = TravelExpenseUtil.StringToDate(travelDateUpdate, "dd.MM.yyyy");
					toTravelDate = TravelExpenseUtil.StringToDate(travelDateUpdate, "dd.MM.yyyy");
				}
				double oldallowance = btTravelExpense.getAllowance();
				String oldCurrency = btTravelExpense.getCurrency();
				allowance=BtTravelExpenseLocalServiceUtil.getAllowance(travelDateUpdate,fromTravelDate,toTravelDate,departure, arrival, rateOfDma, isHasBreakfast, isHasLunch, isHasDinner);
				System.out.println("in update");
				btTravelExpense.setTravelDate(travelDateUpdate);
				btTravelExpense.setDeparture(departure);
				btTravelExpense.setArrival(arrival);
				btTravelExpense.setFromCity(fromCity);
				btTravelExpense.setToCity(toCity);
				btTravelExpense.setIsHasBreakfast(isHasBreakfast);
				btTravelExpense.setIsHasLunch(isHasLunch);
				btTravelExpense.setIsHasDinner(isHasDinner);
				btTravelExpense.setCountry(country);
				btTravelExpense.setCity(city);
				btTravelExpense.setRateOfDma(rateOfDma);
				btTravelExpense.setCurrency(currency);
				btTravelExpense.setAllowance(allowance);
				if(EUR.equals(currency)){
					btTravelExpense.setAllowanceRmb(BtExchangeRateLocalServiceUtil.changeEURToRMB(allowance));
				}else{
					btTravelExpense.setAllowanceRmb(allowance);
				}
				btTravelExpense.setComments(comments);
				btTravelExpense.setTripType(tripType);
				btTravelExpense.setBusinessTripPkId(businessTripReimbursementId);
				BtTravelExpenseLocalServiceUtil.updateBtTravelExpense(btTravelExpense);
				totalTravelExpenseRmb = BTApplicationUtil.deleteCalculate(totalTravelExpenseRmb, RMB, oldallowance, oldCurrency);
				totalTravelExpenseRmb = BTApplicationUtil.addCalculate(totalTravelExpenseRmb, RMB, allowance, currency);
				totalTravelExpenseEur = BTApplicationUtil.deleteCalculate(totalTravelExpenseEur, EUR, oldallowance, oldCurrency);
				totalTravelExpenseEur = BTApplicationUtil.addCalculate(totalTravelExpenseEur, EUR, allowance, currency);
			}
			// end by wanghai
		} else if ("costList".equals(tabs2)) {
			pkId = pkId > 0 ? pkId : CounterLocalServiceUtil.increment(BtCostList.class.getName(), 1);
			BtCostList btCostList = BtCostListLocalServiceUtil.fetchBtCostList(pkId);
			BtCostList oldBtCostList = null;
			if (btCostList != null) {
				isNew = false;
				oldBtCostList = (BtCostList) btCostList.clone();
			} else {
				btCostList = BtCostListLocalServiceUtil.createBtCostList(pkId);
			}
			btCostList = btCostList != null ? btCostList: BtCostListLocalServiceUtil.createBtCostList(pkId);
			String isEntertainment = ParamUtil.getString(actionRequest,"isEntertainment");
			if ("true".equals(isEntertainment)) {
				long btCostListId = ParamUtil.getLong(actionRequest,"btCostListId", 0);
				// Parameters
				String mealCategory = ParamUtil.getString(actionRequest,"mealCategory");
				String btEntertainmentDetailIds = ParamUtil.getString(actionRequest, "btEntertainmentDetailId");
				String fullNames = ParamUtil.getString(actionRequest,"fullName");
				String positionTitles = ParamUtil.getString(actionRequest,"positionTitle");
				String companys = ParamUtil.getString(actionRequest, "company");
				String[] btEntertainmentDetailIdStr = btEntertainmentDetailIds.split("#");
				String[] fullName = fullNames.split("#");
				String[] positionTitle = positionTitles.split("#");
				String[] company = companys.split("#");
				int len = fullName.length;
				// convert String[] to long[]
				long[] btEntertainmentDetailIdl = new long[btEntertainmentDetailIdStr.length];
				for (int i = 0; i < btEntertainmentDetailIdStr.length; i++) {
					// if user havn't EntertainmentDetail
					if (btEntertainmentDetailIdStr[i].equals("")&& btEntertainmentDetailIdStr.length == 1) {
						len = 0;
					} else {
						btEntertainmentDetailIdl[i] = Long.parseLong(btEntertainmentDetailIdStr[i]);
					}
				}
				int pos = btEntertainmentDetailIdl.length;
				// remove old datas
				List<BtEntertainmentDetail> btEntertainmentInfos = BtEntertainmentDetailLocalServiceUtil.findByBtCostListId(btCostListId);
				if (btEntertainmentInfos != null) {
					for (BtEntertainmentDetail btEntertainmentDetail : btEntertainmentInfos) {
						BtEntertainmentDetailLocalServiceUtil.deleteBtEntertainmentDetail(btEntertainmentDetail);
					}
				}
				// update datas
				long btEntertainmentDetailId = 0;
				for (int i = 0; i < len; i++) {
					if (i < pos) {
						btEntertainmentDetailId = btEntertainmentDetailIdl[i] > 0 ? btEntertainmentDetailIdl[i]
								: CounterLocalServiceUtil.increment(BtEntertainmentDetail.class.getName(),1);
					} else {
						btEntertainmentDetailId = CounterLocalServiceUtil
								.increment(BtEntertainmentDetail.class.getName(),1);
					}
					BtEntertainmentDetail btEntertainmentDetail = BtEntertainmentDetailLocalServiceUtil.fetchBtEntertainmentDetail(btEntertainmentDetailId);
					btEntertainmentDetail = btEntertainmentDetail != null ? btEntertainmentDetail
							: BtEntertainmentDetailLocalServiceUtil.createBtEntertainmentDetail(btEntertainmentDetailId);
					btEntertainmentDetail.setBtEntertainmentDetailId(btEntertainmentDetailId);
					btEntertainmentDetail.setBtCostListId(btCostListId);
					btEntertainmentDetail.setBusinessTripPkId(businessTripReimbursementId);
					btEntertainmentDetail.setFullName(fullName[i]);
					btEntertainmentDetail.setPositionTitle(positionTitle[i]);
					btEntertainmentDetail.setCompany(company[i]);
					btEntertainmentDetailId = 0;
					BtEntertainmentDetailLocalServiceUtil.updateBtEntertainmentDetail(btEntertainmentDetail);
				}
				String item = "Entertainment";
				Date entertainmentDate = ParamUtil.getDate(actionRequest,"entertainmentDate", sdf);
				String type = ParamUtil.getString(actionRequest,"entertainmentType");
				String entertainmentPlace = ParamUtil.getString(actionRequest,"entertainmentPlace");
				String countryCity = ParamUtil.getString(actionRequest,"countryCity");
				String reasonesInfo = ParamUtil.getString(actionRequest,"reasonsInfo");
				Double invoiceAmount = ParamUtil.getDouble(actionRequest,"amountTotal");
				String paymentCurrency = ParamUtil.getString(actionRequest,"paymentCurrency");
				Double averageSpend = ParamUtil.getDouble(actionRequest,"averageSpend");
				Integer attendeesTotal = ParamUtil.getInteger(actionRequest,"attendeesTotal");
				Double netAmount = ParamUtil.getDouble(actionRequest,"netAmount");
				Double taxRate = ParamUtil.getDouble(actionRequest,"taxRate");
				Double taxAmount = ParamUtil.getDouble(actionRequest,"taxAmount");
				double oldPrice = btCostList.getInvoiceAmount();
				String oldCurrency = btCostList.getInvoiceCurrency();
				// set Parameters
				btCostList.setMealCategory(mealCategory);
				btCostList.setItem(item);
				btCostList.setEntertainmentDate(entertainmentDate);
				btCostList.setType(type);
				btCostList.setEntertainmentPlace(entertainmentPlace);
				btCostList.setCountryCity(countryCity);
				btCostList.setReasonesInfo(reasonesInfo);
				btCostList.setInvoiceAmount(invoiceAmount);
				btCostList.setPaymentAmount(invoiceAmount);
				btCostList.setInvoiceCurrency(paymentCurrency);
				btCostList.setPaymentCurrency(paymentCurrency);
				btCostList.setAverageSpend(averageSpend);
				btCostList.setAttendeesTotal(attendeesTotal);
	
				
				//   last modify
				btCostList.setTaxRate(taxRate);
				btCostList.setNetAmount(netAmount);
				if(EUR.equals(paymentCurrency)){
					btCostList.setNetAmountRmb(BtExchangeRateLocalServiceUtil.changeEURToRMB(invoiceAmount));
				}else{
					btCostList.setNetAmountRmb(invoiceAmount);
				}
				btCostList.setTaxAmount(taxAmount);
				
				//end
				
				btCostList.setBusinessTripPkId(businessTripReimbursementId);
				BtCostListLocalServiceUtil.updateBtCostList(btCostList);
				if (isNew) {
					if ("RMB".equals(paymentCurrency)) {
						costListInlandTotalRmb = BTApplicationUtil
								.addCalculate(costListInlandTotalRmb, RMB,invoiceAmount, paymentCurrency);
					} else if ("EUR".equals(paymentCurrency)) {
						costListForeignTotalEur = BTApplicationUtil
								.addCalculate(costListForeignTotalEur, EUR,invoiceAmount, paymentCurrency);
					}
				} else {
					if ("RMB".equals(paymentCurrency) && "RMB".equals(oldCurrency)) {
						costListInlandTotalRmb = BTApplicationUtil
								.deleteCalculate(costListInlandTotalRmb, RMB,oldPrice, oldCurrency);
						costListInlandTotalRmb = BTApplicationUtil
								.addCalculate(costListInlandTotalRmb, RMB,invoiceAmount, paymentCurrency);
					} else if("RMB".equals(paymentCurrency) && "EUR".equals(oldCurrency)){
						costListForeignTotalEur = BTApplicationUtil
								.deleteCalculate(costListForeignTotalEur, EUR,oldPrice, oldCurrency);
						costListInlandTotalRmb = BTApplicationUtil
								.addCalculate(costListInlandTotalRmb, RMB,invoiceAmount, paymentCurrency);
					} else if("EUR".equals(paymentCurrency)&& "RMB".equals(oldCurrency) ){
						costListInlandTotalRmb = BTApplicationUtil
								.deleteCalculate(costListInlandTotalRmb, RMB,oldPrice, oldCurrency);
						costListForeignTotalEur = BTApplicationUtil
								.addCalculate(costListForeignTotalEur, EUR,invoiceAmount, paymentCurrency);
					} else if ("EUR".equals(paymentCurrency) && "EUR".equals(oldCurrency)) {
						costListForeignTotalEur = BTApplicationUtil
								.deleteCalculate(costListForeignTotalEur, EUR,oldPrice, oldCurrency);
						costListForeignTotalEur = BTApplicationUtil
								.addCalculate(costListForeignTotalEur, EUR,invoiceAmount, paymentCurrency);
					}
				}
				costListForeignTotalRmb = BTApplicationUtil.addCalculate(0,RMB, costListForeignTotalEur, EUR);
			} else {
				String item = ParamUtil.getString(actionRequest, "item");
				long btCostListId = ParamUtil.getLong(actionRequest,"btCostListId");
				String type = ParamUtil.getString(actionRequest, "costType");
				Double invoiceAmount = ParamUtil.getDouble(actionRequest,"invoiceAmount");
				String invoiceCurrency = ParamUtil.getString(actionRequest,"invoiceCurrency");
				String countryCity = ParamUtil.getString(actionRequest,"countryCity");
				String paymentCurrency = ParamUtil.getString(actionRequest,"paymentCurrency");
				Double paymentAmount = ParamUtil.getDouble(actionRequest,"paymentAmount");
				Double netAmount = ParamUtil.getDouble(actionRequest,"netAmount");
				Double taxRate = ParamUtil.getDouble(actionRequest,"taxRate");
				Double taxAmount = ParamUtil.getDouble(actionRequest,"taxAmount");
				double oldPrice = btCostList.getInvoiceAmount();
				String oldCurrency = btCostList.getInvoiceCurrency();
				btCostList.setItem(item);
				btCostList.setType(type);
				btCostList.setInvoiceAmount(invoiceAmount);
				//   last modify
				btCostList.setTaxRate(taxRate);
				btCostList.setNetAmount(netAmount);
				if(EUR.equals(paymentCurrency)){
					btCostList.setNetAmountRmb(BtExchangeRateLocalServiceUtil.changeEURToRMB(paymentAmount));
				}else{
					btCostList.setNetAmountRmb(paymentAmount);
				}
				btCostList.setTaxAmount(taxAmount);
				//end
				btCostList.setInvoiceCurrency(invoiceCurrency);
				btCostList.setCountryCity(countryCity);
				btCostList.setPaymentCurrency(paymentCurrency);
				btCostList.setPaymentAmount(paymentAmount);
				btCostList.setBtCostListId(btCostListId);
				btCostList.setBusinessTripPkId(businessTripReimbursementId);
				BtCostListLocalServiceUtil.updateBtCostList(btCostList);
				
				if (isNew) {
					if ("RMB".equals(invoiceCurrency)) {
						costListInlandTotalRmb = BTApplicationUtil
								.addCalculate(costListInlandTotalRmb, RMB,invoiceAmount, invoiceCurrency);
					} else if ("EUR".equals(invoiceCurrency)) {
						costListForeignTotalEur = BTApplicationUtil
								.addCalculate(costListForeignTotalEur, EUR,invoiceAmount, invoiceCurrency);
					}
				} else {
					if ("RMB".equals(invoiceCurrency) && "RMB".endsWith(oldCurrency)) {
						costListInlandTotalRmb = BTApplicationUtil
								.deleteCalculate(costListInlandTotalRmb, RMB,oldPrice, oldCurrency);
						costListInlandTotalRmb = BTApplicationUtil
								.addCalculate(costListInlandTotalRmb, RMB,invoiceAmount, invoiceCurrency);
					} else if("RMB".equals(invoiceCurrency) && "EUR".equals(oldCurrency)){
						costListForeignTotalEur = BTApplicationUtil
								.deleteCalculate(costListForeignTotalEur, EUR,oldPrice, oldCurrency);
						costListInlandTotalRmb = BTApplicationUtil
								.addCalculate(costListInlandTotalRmb, RMB,invoiceAmount, invoiceCurrency);
					} else if("EUR".equals(invoiceCurrency) && "RMB".endsWith(oldCurrency)){
						costListInlandTotalRmb = BTApplicationUtil
								.deleteCalculate(costListInlandTotalRmb, RMB,oldPrice, oldCurrency);
						costListForeignTotalEur = BTApplicationUtil
								.addCalculate(costListForeignTotalEur, EUR,invoiceAmount, invoiceCurrency);
					} else if ("EUR".equals(invoiceCurrency) && "EUR".equals(oldCurrency)) {
						costListForeignTotalEur = BTApplicationUtil
								.deleteCalculate(costListForeignTotalEur, EUR,oldPrice, oldCurrency);
						costListForeignTotalEur = BTApplicationUtil
								.addCalculate(costListForeignTotalEur, EUR,invoiceAmount, invoiceCurrency);
					}
				}
				costListForeignTotalRmb = BTApplicationUtil.addCalculate(0,RMB, costListForeignTotalEur, EUR);
			}
		}
		}
		
		totalCostRmb = BTApplicationUtil.addCalculate(hotelTotalCostRmb, RMB,carRentalTotalCostRmb, RMB);
		totalCostEur = BTApplicationUtil.addCalculate(hotelTotalCostEur, EUR,carRentalTotalCostEur, EUR);
		
		//Add in 2017/01/03
		BusinessTripReimbursement businessTripReimbursement = BusinessTripReimbursementLocalServiceUtil.fetchBusinessTripReimbursement(businessTripReimbursementId);
		
		if(businessTripReimbursement!=null){
//			System.out.println("In Add Detail update before"+isApplicantAgent);
//			businessTripReimbursement.setIsApplicantAgent(isApplicantAgent);
//			System.out.println("In Add Detail update after"+businessTripReimbursement.getIsApplicantAgent());
			
			businessTripReimbursement.setCostListInlandTotalRmb(costListInlandTotalRmb);
			businessTripReimbursement.setCostListForeignTotalRmb(costListForeignTotalRmb);
			businessTripReimbursement.setCostListForeignTotalEur(costListForeignTotalEur);
			businessTripReimbursement.setOrgTotalCostRmb(costListInlandTotalRmb);
			businessTripReimbursement.setOrgTotalCostEur(costListForeignTotalEur);
			BusinessTripReimbursementLocalServiceUtil.updateBusinessTripReimbursement(businessTripReimbursement);
		}else{
			System.out.println("BusinessTripReimbursement is null");
		}
		//Add in 2017/01/03
		
//		if (businessTripReimbursement != null
//				&& businessTripReimbursement.getSapStatus() == 1) {
//			//businessTripReimbursement.setSapStatus(sapStatus);
//			BusinessTripReimbursementLocalServiceUtil.updateBusinessTripReimbursement(businessTripReimbursement);
//		}
		actionResponse.setRenderParameter("totalCostRmb",String.valueOf(totalCostRmb));
		actionResponse.setRenderParameter("totalCostEur",String.valueOf(totalCostEur));
		actionResponse.setRenderParameter("hotelTotalCostRmb",String.valueOf(hotelTotalCostRmb));
		actionResponse.setRenderParameter("hotelTotalCostEur",String.valueOf(hotelTotalCostEur));
		actionResponse.setRenderParameter("carRentalTotalCostRmb",String.valueOf(carRentalTotalCostRmb));
		actionResponse.setRenderParameter("carRentalTotalCostEur",String.valueOf(carRentalTotalCostEur));
		// test
		actionResponse.setRenderParameter("costListInlandTotalRmb",String.valueOf(costListInlandTotalRmb));
		actionResponse.setRenderParameter("costListForeignTotalRmb",String.valueOf(costListForeignTotalRmb));
		actionResponse.setRenderParameter("costListForeignTotalEur",String.valueOf(costListForeignTotalEur));
		// --------------
		actionResponse.setRenderParameter("totalTravelExpenseRmb",String.valueOf(totalTravelExpenseRmb));
		actionResponse.setRenderParameter("totalTravelExpenseEur",String.valueOf(totalTravelExpenseEur));
		actionResponse.setRenderParameter("flightCurrency", flightCurrency);
		actionResponse.setRenderParameter("flightTotal",String.valueOf(flightTotal));
		actionResponse.setRenderParameter("flightAirFare",String.valueOf(flightAirFare));
		actionResponse.setRenderParameter("flightTaxes",String.valueOf(flightTaxes));
		actionResponse.setRenderParameter("flightTransactionFee",String.valueOf(flightTransactionFee));
		actionResponse.setRenderParameter("tabs2", tabs2);
		actionResponse.setRenderParameter("cmd2", cmd2);
		actionResponse.setRenderParameter("bussinessTirpTicketNo2",bussinessTirpTicketNo);
		actionResponse.setRenderParameter("businessTripReimbursementId",String.valueOf(businessTripReimbursementId));
		
/*		actionResponse.setRenderParameter("isApplicantAgent",String.valueOf(isApplicantAgent));*/
		actionResponse.setRenderParameter("tempApproverId",String.valueOf(tempApproverId));
		actionResponse.setRenderParameter("tempApproverName",String.valueOf(tempApproverName));
		actionResponse.setRenderParameter("tempEvpId",String.valueOf(tempEvpId ));
		actionResponse.setRenderParameter("tempEvpName",String.valueOf(tempEvpName ));
		actionResponse.setRenderParameter("tempIsGetRMB",String.valueOf(tempIsGetRMB));
	}

	// Delete the detail info
	public void deleteDetailInfo(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException, PortalException {
		long token=ParamUtil.getLong(actionRequest,"token");
		PortletSession session=actionRequest.getPortletSession();
		long tokenInSession=Long.parseLong(session.getAttribute("token")+"");
		
		String bussinessTirpTicketNo = ParamUtil.getString(actionRequest,
				"bussinessTirpTicketNo2");
		String tabs2 = ParamUtil.getString(actionRequest, "tabs2", "train");
		String cmd2 = ParamUtil.getString(actionRequest, "cmd2");
		long businessTripReimbursementId = ParamUtil.getLong(actionRequest,
				"businessTripReimbursementId", 0);
		System.out.println("****************deleteDetailInfo:businessTripReimbursementId="+businessTripReimbursementId);
		long pkId = ParamUtil.getLong(actionRequest, "pkId", 0);
		String tripType = PropsUtil
				.get("vgc.apon.business.trip.reimbursement.type");
		double totalCostRmb = ParamUtil.getDouble(actionRequest,
				"totalCostRmb", 0d);
		double totalCostEur = ParamUtil.getDouble(actionRequest,
				"totalCostEur", 0d);
		double hotelTotalCostRmb = ParamUtil.getDouble(actionRequest,
				"hotelTotalCostRmb", 0d);
		double hotelTotalCostEur = ParamUtil.getDouble(actionRequest,
				"hotelTotalCostEur", 0d);
		double carRentalTotalCostRmb = ParamUtil.getDouble(actionRequest,
				"carRentalTotalCostRmb", 0d);
		double carRentalTotalCostEur = ParamUtil.getDouble(actionRequest,
				"carRentalTotalCostEur", 0d);
		// wirte by wanghai
		double totalTravelExpenseRmb = ParamUtil.getDouble(actionRequest,
				"totalTravelExpenseRmb", 0d);
		double totalTravelExpenseEur = ParamUtil.getDouble(actionRequest,
				"totalTravelExpenseEur", 0d);
		// end
		// this for list
		double costListInlandTotalRmb = ParamUtil.getDouble(actionRequest,
				"costListInlandTotalRmb", 0d);
		double costListForeignTotalEur = ParamUtil.getDouble(actionRequest,
				"costListForeignTotalEur", 0d);
		double costListForeignTotalRmb = ParamUtil.getDouble(actionRequest,
				"costListForeignTotalRmb", 0d);
		String flightCurrency = ParamUtil.getString(actionRequest,
				"flightCurrency");
		double flightTotal = ParamUtil.getDouble(actionRequest, "flightTotal");
		double flightAirFare = ParamUtil.getDouble(actionRequest,
				"flightAirFare");
		double flightTaxes = ParamUtil.getDouble(actionRequest, "flightTaxes");
		double flightTransactionFee = ParamUtil.getDouble(actionRequest,
				"flightTransactionFee");
		//
		
/*		//add in 2017/1/6
		boolean isApplicantAgent = ParamUtil.getBoolean(actionRequest,
				"isApplicantAgent", false);
		System.out.println("In Del Detail"+isApplicantAgent);*/
		//end in 2017/1/6
		//add in 2017/01/23
		String tempApproverId = ParamUtil.getString(actionRequest, "tempApproverId","");
		String tempApproverName = ParamUtil.getString(actionRequest, "tempApproverName","");
		String tempEvpId = ParamUtil.getString(actionRequest, "tempEvpId","");
        String tempEvpName = ParamUtil.getString(actionRequest, "tempEvpName","");
		//end in 2017/01/23
		boolean tempIsGetRMB = ParamUtil.getBoolean(actionRequest,"tempIsGetRMB");
		
		if(token==tokenInSession){
			if ("train".equals(tabs2)) {
				BtTrainInfoLocalServiceUtil.deleteBtTrainInfo(pkId);
			} else if ("hotelInformation".equals(tabs2)) {
				BtHotelInfo btHotelInfo = BtHotelInfoLocalServiceUtil
						.fetchBtHotelInfo(pkId);
				hotelTotalCostRmb = BTApplicationUtil.deleteCalculate(
						hotelTotalCostRmb, RMB, btHotelInfo.getPrice(),
						btHotelInfo.getCurrency());
				hotelTotalCostEur = BTApplicationUtil.deleteCalculate(
						hotelTotalCostEur, EUR, btHotelInfo.getPrice(),
						btHotelInfo.getCurrency());
				BtHotelInfoLocalServiceUtil.deleteBtHotelInfo(pkId);
				hotelTotalCostRmb = BtHotelInfoLocalServiceUtil.findCountByB_T(
						businessTripReimbursementId, tripType) == 0 ? 0
						: hotelTotalCostRmb;
				hotelTotalCostEur = BtHotelInfoLocalServiceUtil.findCountByB_T(
						businessTripReimbursementId, tripType) == 0 ? 0
						: hotelTotalCostEur;
			} else if ("carRental".equals(tabs2)) {
				BtCarRentalInfo btCarRentalInfo = BtCarRentalInfoLocalServiceUtil
						.fetchBtCarRentalInfo(pkId);
				carRentalTotalCostRmb = BTApplicationUtil.deleteCalculate(
						carRentalTotalCostRmb, RMB, btCarRentalInfo.getPrice(),
						btCarRentalInfo.getCurrency());
				carRentalTotalCostEur = BTApplicationUtil.deleteCalculate(
						carRentalTotalCostEur, EUR, btCarRentalInfo.getPrice(),
						btCarRentalInfo.getCurrency());
				BtCarRentalInfoLocalServiceUtil.deleteBtCarRentalInfo(pkId);
				carRentalTotalCostRmb = BtCarRentalInfoLocalServiceUtil
						.findCountByB_T(businessTripReimbursementId, tripType) == 0 ? 0
						: carRentalTotalCostRmb;
				carRentalTotalCostEur = BtCarRentalInfoLocalServiceUtil
						.findCountByB_T(businessTripReimbursementId, tripType) == 0 ? 0
						: carRentalTotalCostEur;
			} else if ("travelExpense".equals(tabs2)) {
				BtTravelExpense travelExpense = BtTravelExpenseLocalServiceUtil
						.fetchBtTravelExpense(pkId);
				totalTravelExpenseRmb = BTApplicationUtil.deleteCalculate(
						totalTravelExpenseRmb, RMB, travelExpense.getAllowance(),
						travelExpense.getCurrency());
				totalTravelExpenseEur = BTApplicationUtil.deleteCalculate(
						totalTravelExpenseEur, EUR, travelExpense.getAllowance(),
						travelExpense.getCurrency());
				BtTravelExpenseLocalServiceUtil.deleteBtTravelExpense(pkId);
			}else if ("deleteAllTravelExpense".equals(tabs2)) {
				totalTravelExpenseRmb = 0;
				totalTravelExpenseEur = 0;
				BtTravelExpenseLocalServiceUtil.deleteBtTravelExpenseByB_T(businessTripReimbursementId, tripType);
				tabs2 = "travelExpense";
			} else if ("costList".equals(tabs2)) {
				BtCostList btCostList = BtCostListLocalServiceUtil
						.fetchBtCostList(pkId);
				if (btCostList.getInvoiceCurrency().equals(RMB)) {
					costListInlandTotalRmb = BTApplicationUtil.deleteCalculate(
							costListInlandTotalRmb, RMB,
							btCostList.getInvoiceAmount(),
							btCostList.getInvoiceCurrency());
				} else if (btCostList.getInvoiceCurrency().equals(EUR)) {
					costListForeignTotalEur = BTApplicationUtil.deleteCalculate(
							costListForeignTotalEur, EUR,
							btCostList.getInvoiceAmount(),
							btCostList.getInvoiceCurrency());
				}
				costListForeignTotalRmb = BTApplicationUtil.addCalculate(0, RMB,
						costListForeignTotalEur, EUR);
				BtCostListLocalServiceUtil.deleteBtCostList(pkId);
			} else if ("deleteAllCostList".equals(tabs2)) {
				costListInlandTotalRmb =0;
				costListForeignTotalEur = 0;
				costListForeignTotalRmb = 0;
				tabs2 = "costList";
				BtCostListLocalServiceUtil.deleteCostListByBRPKId(businessTripReimbursementId);
			}
	    }
		totalCostRmb = BTApplicationUtil.addCalculate(hotelTotalCostRmb, RMB,
				carRentalTotalCostRmb, RMB);
		totalCostEur = BTApplicationUtil.addCalculate(hotelTotalCostEur, EUR,
				carRentalTotalCostEur, EUR);
		
		//Add in 2017/01/03
		BusinessTripReimbursement businessTripReimbursement = BusinessTripReimbursementLocalServiceUtil.fetchBusinessTripReimbursement(businessTripReimbursementId);
		if(businessTripReimbursement!=null){
			
//			businessTripReimbursement.setIsApplicantAgent(isApplicantAgent);
			
			businessTripReimbursement.setCostListInlandTotalRmb(costListInlandTotalRmb);
			businessTripReimbursement.setCostListForeignTotalRmb(costListForeignTotalRmb);
			businessTripReimbursement.setCostListForeignTotalEur(costListForeignTotalEur);
			businessTripReimbursement.setOrgTotalCostRmb(costListInlandTotalRmb);
			businessTripReimbursement.setOrgTotalCostEur(costListForeignTotalEur);
			businessTripReimbursement.setTotalTravelExpenseEur(totalTravelExpenseEur);
			businessTripReimbursement.setTotalTravelExpenseRmb(totalTravelExpenseRmb);
			BusinessTripReimbursementLocalServiceUtil.updateBusinessTripReimbursement(businessTripReimbursement);
		}
		//Add in 2017/01/03
		
//		if (businessTripReimbursement != null
//				&& businessTripReimbursement.getSapStatus() == 1) {
//		//	businessTripReimbursement.setSapStatus(0);
//			BusinessTripReimbursementLocalServiceUtil
//					.updateBusinessTripReimbursement(businessTripReimbursement);
//		}
		actionResponse.setRenderParameter("totalCostRmb",
				String.valueOf(totalCostRmb));
		actionResponse.setRenderParameter("totalCostEur",
				String.valueOf(totalCostEur));
		actionResponse.setRenderParameter("hotelTotalCostRmb",
				String.valueOf(hotelTotalCostRmb));
		actionResponse.setRenderParameter("hotelTotalCostEur",
				String.valueOf(hotelTotalCostEur));
		actionResponse.setRenderParameter("carRentalTotalCostRmb",
				String.valueOf(carRentalTotalCostRmb));
		actionResponse.setRenderParameter("carRentalTotalCostEur",
				String.valueOf(carRentalTotalCostEur));
		// test
		actionResponse.setRenderParameter("costListInlandTotalRmb",
				String.valueOf(costListInlandTotalRmb));
		actionResponse.setRenderParameter("costListForeignTotalRmb",
				String.valueOf(costListForeignTotalRmb));
		actionResponse.setRenderParameter("costListForeignTotalEur",
				String.valueOf(costListForeignTotalEur));
		// --------------
		actionResponse.setRenderParameter("totalTravelExpenseRmb",
				String.valueOf(totalTravelExpenseRmb));
		actionResponse.setRenderParameter("totalTravelExpenseEur",
				String.valueOf(totalTravelExpenseEur));
		actionResponse.setRenderParameter("flightCurrency", flightCurrency);
		actionResponse.setRenderParameter("flightTotal",
				String.valueOf(flightTotal));
		actionResponse.setRenderParameter("flightAirFare",
				String.valueOf(flightAirFare));
		actionResponse.setRenderParameter("flightTaxes",
				String.valueOf(flightTaxes));
		actionResponse.setRenderParameter("flightTransactionFee",
				String.valueOf(flightTransactionFee));
		actionResponse.setRenderParameter("tabs2", tabs2);
		actionResponse.setRenderParameter("cmd2", cmd2);
		actionResponse.setRenderParameter("bussinessTirpTicketNo2",
				bussinessTirpTicketNo);
		actionResponse.setRenderParameter("businessTripReimbursementId",
				String.valueOf(businessTripReimbursementId));
		// actionResponse.setRenderParameter("mvcPath","/html/businessTripReimbursement/view.jsp");
		
	/*	actionResponse.setRenderParameter("isApplicantAgent",String.valueOf(isApplicantAgent));*/
		actionResponse.setRenderParameter("tempApproverId",String.valueOf(tempApproverId));
		actionResponse.setRenderParameter("tempApproverName",String.valueOf(tempApproverName));
		actionResponse.setRenderParameter("tempEvpId",String.valueOf(tempEvpId));
		actionResponse.setRenderParameter("tempEvpName",String.valueOf(tempEvpName));
		actionResponse.setRenderParameter("tempIsGetRMB",String.valueOf(tempIsGetRMB));
	}
	// Get the applicant agent staffcode
	public void applicantAgent(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException, PortalException {
		String bussinessTirpTicketNo = ParamUtil.getString(actionRequest,
				"bussinessTirpTicketNo2");
		Long applicantAgentUserId = ParamUtil.getLong(actionRequest, "applicantAgentPerson");
		
		//add in 2017/01/23
/*		String tempApproverId = ParamUtil.getString(actionRequest, "tempApproverId","");
		String tempApproverName = ParamUtil.getString(actionRequest, "tempApproverName","");*/
		//end in 2017/01/23
		boolean tempIsGetRMB = ParamUtil.getBoolean(actionRequest,"tempIsGetRMB");
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		long staffCode = user.getFacebookId();
		
		if(!applicantAgentUserId.equals(user.getUserId())){
			staffCode = UserLocalServiceUtil.fetchUserById(applicantAgentUserId).getFacebookId();
		}
		long businessTripReimbursementId = ParamUtil.getLong(actionRequest,"businessTripReimbursementId");
		actionResponse.setRenderParameter("staffCode",String.valueOf(staffCode));
		actionResponse.setRenderParameter("bussinessTirpTicketNo2",bussinessTirpTicketNo);
		actionResponse.setRenderParameter("businessTripReimbursementId",
				String.valueOf(businessTripReimbursementId));
		actionResponse.setRenderParameter("tempIsGetRMB",String.valueOf(tempIsGetRMB));
	}

	/**
	 * select Bussiness trip
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void searchBussinessTirpTicketNo(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, SystemException,
			PortalException {
		String bussinessTirpTicketNo = ParamUtil.getString(actionRequest,"bussinessTirpTicketNo2");
		long businessTripReimbursementId = ParamUtil.getLong(actionRequest,"businessTripReimbursementId2", 0);
		businessTripReimbursementId = BusinessTripReimbursementLocalServiceUtil
				.fetchBusinessTripReimbursement(businessTripReimbursementId) == null ? 0
				: businessTripReimbursementId;
		actionResponse.setRenderParameter("bussinessTirpTicketNo2",bussinessTirpTicketNo);
		actionResponse.setRenderParameter("businessTripReimbursementId",String.valueOf(businessTripReimbursementId));
		actionResponse.setRenderParameter("search", "Yes");
	}
	
	private void addorUpdateTrain(long pkId,ActionRequest actionRequest,long businessTripReimbursementId,String tripType,SimpleDateFormat sdf) throws SystemException{
		//boolean isNew = true;
		pkId = pkId > 0 ? pkId : CounterLocalServiceUtil.increment(
				BtTrainInfo.class.getName(), 1);
		BtTrainInfo btTrainInfo = BtTrainInfoLocalServiceUtil.fetchBtTrainInfo(pkId);
		if (btTrainInfo != null) {
		//	isNew = false;
		} else {
			btTrainInfo = BtTrainInfoLocalServiceUtil.createBtTrainInfo(pkId);
		}
		String fromCity = ParamUtil.getString(actionRequest, "fromCity");
		String toCity = ParamUtil.getString(actionRequest, "toCity");
		Date departureDate = ParamUtil.getDate(actionRequest,"departureDate", sdf);
		String departureTrain = ParamUtil.getString(actionRequest,"departureTrain");
		String classInfo = ParamUtil.getString(actionRequest, "classInfo");
		btTrainInfo.setFromCity(fromCity);
		btTrainInfo.setToCity(toCity);
		btTrainInfo.setDepartureDate(departureDate);
		btTrainInfo.setDepartureTrain(departureTrain);
		btTrainInfo.setClassInfo(classInfo);
		btTrainInfo.setTripType(tripType);
		btTrainInfo.setBusinessTripPkId(businessTripReimbursementId);
		BtTrainInfoLocalServiceUtil.updateBtTrainInfo(btTrainInfo);
	}
	private BtHotelInfo addorUpdateHotel(ActionRequest actionRequest,long businessTripReimbursementId,String tripType,SimpleDateFormat sdf,BtHotelInfo btHotelInfo) throws SystemException{
		String city = ParamUtil.getString(actionRequest, "city");
		String cityType = ParamUtil.getString(actionRequest, "cityType");
		String hotel = ParamUtil.getString(actionRequest, "hotel");
		Date checkIn = ParamUtil.getDate(actionRequest, "checkIn", sdf);
		Date checkOut = ParamUtil.getDate(actionRequest, "checkOut", sdf);
		String roomCategory = ParamUtil.getString(actionRequest,"roomCategory");
		double price = ParamUtil.getDouble(actionRequest, "price");
		String currency = ParamUtil.getString(actionRequest, "currency");
		int isOverBudget = ParamUtil.getInteger(actionRequest,"isOverBudget");
		String otherReasonInfo = ParamUtil.getString(actionRequest,"otherReasonInfo");
		boolean isNotBookedFromTA = ParamUtil.getBoolean(actionRequest,"isNotBookedFromTA");
		String othersSpecify = ParamUtil.getString(actionRequest,"othersSpecify");
		btHotelInfo.setCity(city);
		btHotelInfo.setCityType(cityType);
		btHotelInfo.setHotel(hotel);
		btHotelInfo.setCheckIn(checkIn);
		btHotelInfo.setCheckOut(checkOut);
		btHotelInfo.setRoomCategory(roomCategory);
		btHotelInfo.setPrice(price);
		btHotelInfo.setCurrency(currency);
		btHotelInfo.setIsOverBudget(isOverBudget);
		btHotelInfo.setOtherReasonInfo(otherReasonInfo);
		btHotelInfo.setIsNotBookedFromTA(isNotBookedFromTA);
		btHotelInfo.setOthersSpecify(othersSpecify);
		btHotelInfo.setTripType(tripType);
		btHotelInfo.setBusinessTripPkId(businessTripReimbursementId);
		BtHotelInfoLocalServiceUtil.updateBtHotelInfo(btHotelInfo);
		return btHotelInfo;
	}
	private BtCarRentalInfo addorUpdateCarRental(ActionRequest actionRequest,long businessTripReimbursementId,String tripType,SimpleDateFormat sdf,BtCarRentalInfo btCarRentalInfo) throws SystemException{
		String pickupLocation = ParamUtil.getString(actionRequest,"pickupLocation");
		Date pickupDate = ParamUtil.getDate(actionRequest, "pickupDate",sdf);
		String dropoffLocation = ParamUtil.getString(actionRequest,"dropoffLocation");
		Date dropoffDate = ParamUtil.getDate(actionRequest, "dropoffDate",sdf);
		String carType = ParamUtil.getString(actionRequest, "carType");
		String typeOfRental = ParamUtil.getString(actionRequest,"typeOfRental");
		Double price = ParamUtil.getDouble(actionRequest, "carPrice");
		String currency = ParamUtil.getString(actionRequest, "carCurrency");
		btCarRentalInfo.setPickupLocation(pickupLocation);
		btCarRentalInfo.setPickupDate(pickupDate);
		btCarRentalInfo.setDropoffLocation(dropoffLocation);
		btCarRentalInfo.setDropoffDate(dropoffDate);
		btCarRentalInfo.setCarType(carType);
		btCarRentalInfo.setTypeOfRental(typeOfRental);
		btCarRentalInfo.setPrice(price);
		btCarRentalInfo.setCurrency(currency);
		btCarRentalInfo.setTripType(tripType);
		btCarRentalInfo.setBusinessTripPkId(businessTripReimbursementId);
		BtCarRentalInfoLocalServiceUtil.updateBtCarRentalInfo(btCarRentalInfo);
		return btCarRentalInfo;
	}
	

   
   
	// For the select_approver.jsp query
	public void searchApprover(ActionRequest actionRequest,
			ActionResponse actionResponse) throws SystemException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		long staffCode = user.getFacebookId();
		SAPUser sapUser = SAPUserLocalServiceUtil.getSapUserByStaffCode(String
				.valueOf(staffCode));
		String eventName = ParamUtil.getString(actionRequest, "eventName");
		String mvcPath = ParamUtil.getString(actionRequest, "mvcPath");
		String sapCompanyName = ParamUtil.getString(actionRequest,
				"sapCompanyName");
		String divisionName = ParamUtil
				.getString(actionRequest, "divisionName");
		if (divisionName == null || divisionName.equals("")) {
			divisionName = sapUser.getDivisionName();
		}
		String departmentName = ParamUtil.getString(actionRequest,
				"departmentName");
		String staffName = ParamUtil.getString(actionRequest, "staffName");
		actionResponse.setRenderParameter("myindex", sapUser.getSg());
		actionResponse.setRenderParameter("eventName", eventName);
		actionResponse.setRenderParameter("mvcPath", mvcPath);
		actionResponse.setRenderParameter("sapCompanyName", sapCompanyName);
		actionResponse.setRenderParameter("divisionName", divisionName);
		actionResponse.setRenderParameter("departmentName", departmentName);
		actionResponse.setRenderParameter("staffName", staffName);
		// actionResponse.setRenderParameter("mvcPath","/html/businessTripApplication/view.jsp");
	}
   
}
