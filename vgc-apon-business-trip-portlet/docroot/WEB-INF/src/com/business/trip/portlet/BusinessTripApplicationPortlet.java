package com.business.trip.portlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.business.trip.model.BtCarRentalInfo;
import com.business.trip.model.BtFlightTrainInfo;
import com.business.trip.model.BtHotelInfo;
import com.business.trip.model.BtTrainInfo;
import com.business.trip.model.BusinessTripApplication;
import com.business.trip.service.BtCarRentalInfoLocalServiceUtil;
import com.business.trip.service.BtFlightTrainInfoLocalServiceUtil;
import com.business.trip.service.BtHotelInfoLocalServiceUtil;
import com.business.trip.service.BtTrainInfoLocalServiceUtil;
import com.business.trip.service.BusinessTripApplicationLocalServiceUtil;
import com.business.trip.util.ActionConstants;
import com.business.trip.util.BTApplicationUtil;
import com.business.trip.util.BusinessTripConstants;
import com.delegation.model.ApplicantDelegation;
import com.delegation.service.ApplicantDelegationLocalServiceUtil;
import com.delegation.service.ApproverDelegationLocalServiceUtil;
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
 * Portlet implementation class BusinessTripApplication
 */
public class BusinessTripApplicationPortlet extends MVCPortlet {
	private static Log log = LogFactoryUtil
			.getLog(BusinessTripApplicationPortlet.class);
	private static String RMB = "RMB";
	private static String EUR = "EUR";

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		super.doView(renderRequest, renderResponse);
	}

	/**
	 * Save,Update,Submit the businessTripApplication
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void addBusinessTripApplication(ActionRequest request,
			ActionResponse response) throws Exception {
		UploadPortletRequest uploadPortletRequest = PortalUtil
				.getUploadPortletRequest(request);

		// WorkflowTaskManagerUtil.getWorkflowTasksByWorkflowInstance(companyId,
		// userId, workflowInstanceId, false, start, end, orderByComparator);

		ThemeDisplay themeDisplay = (ThemeDisplay) uploadPortletRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		String cmd = ParamUtil.getString(uploadPortletRequest, Constants.CMD);
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		long businessTripApplicationId = ParamUtil.getLong(
				uploadPortletRequest, "businessTripApplicationId");
		Boolean isApplicantAgent = ParamUtil.getBoolean(uploadPortletRequest,
				"isApplicantAgent", false);
		long staffCode = ParamUtil.getLong(uploadPortletRequest, "staffCode");
		if (staffCode == 0) {
			staffCode = 190002l;
		}
		SAPUser sapUser = SAPUserLocalServiceUtil.getSapUserByStaffCode(String
				.valueOf(staffCode));
		long approverId = ParamUtil.getLong(uploadPortletRequest, "approverId");
		String approverName = ParamUtil.getString(uploadPortletRequest,
				"approverName");

		long evpId = ParamUtil.getLong(uploadPortletRequest, "evpId");
		String evpName = ParamUtil.getString(uploadPortletRequest, "evpName");
		String otherEmails = ParamUtil.getString(uploadPortletRequest,
				"otherEmails");
		boolean isCrossDepartment = ParamUtil.getBoolean(uploadPortletRequest,
				"isCrossDepartment");
		long targetDepartmentId = ParamUtil.getLong(uploadPortletRequest,
				"targetDepartmentId");
		String targetDepartmentName = ParamUtil.getString(uploadPortletRequest,
				"targetDepartmentName");
		String targetCostCenter = ParamUtil.getString(uploadPortletRequest,
				"targetCostCenter");
		long targetDepartmentApproverId = ParamUtil.getLong(
				uploadPortletRequest, "targetDepartmentApproverId");
		String targetDepartmentApproverName = ParamUtil.getString(
				uploadPortletRequest, "targetDepartmentApproverName");
		int tripType = ParamUtil.getInteger(uploadPortletRequest, "tripType");
		Date departureDate = ParamUtil.getDate(uploadPortletRequest,
				"departureDate", dateFormat);
		Date returnDate = ParamUtil.getDate(uploadPortletRequest, "returnDate",
				dateFormat);
		String purposeOfTheTrip = ParamUtil.getString(uploadPortletRequest,
				"purposeOfTheTrip");
		String visitCountriesCities = ParamUtil.getString(uploadPortletRequest,
				"visitCountriesCities");
		double advancePayment = ParamUtil.getDouble(uploadPortletRequest,
				"advancePayment");
		String currency = ParamUtil.getString(uploadPortletRequest, "currency");
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
		String remark = ParamUtil.getString(uploadPortletRequest, "remark");

		BusinessTripApplication businessTripApplication = BusinessTripApplicationLocalServiceUtil
				.fetchBusinessTripApplication(businessTripApplicationId);
		if (businessTripApplication == null) {
			if (businessTripApplicationId == 0) {
				businessTripApplicationId = CounterLocalServiceUtil.increment(
						BusinessTripApplication.class.getName(), 1);
			}
			businessTripApplication = BusinessTripApplicationLocalServiceUtil
					.createBusinessTripApplication(businessTripApplicationId);
			String ticketNo = GlobalToolLocalServiceUtil.generateTicketNo("BT");
			businessTripApplication.setTicketNo(ticketNo);
			Date now = new Date();
			businessTripApplication.setCreateDate(now);
		}
		businessTripApplication.setIsApplicantAgent(isApplicantAgent);
		businessTripApplication
				.setProcessType(BusinessTripConstants.PROCESS_TYPE_BUSINESS_TRIP_APPLICATION);
		businessTripApplication
				.setSubType(BusinessTripConstants.SUB_TYPE_BUSINESS_TRIP_APPLICATION);
		businessTripApplication.setPrintName(sapUser.getStaffName());
		businessTripApplication.setStaffCode(Long.valueOf(sapUser
				.getStaffCode()));
		if(businessTripApplication.getStatus()!=104) {
			businessTripApplication.setCompanyName(sapUser.getSapCompanyName());
			businessTripApplication.setDivision(sapUser.getDivisionName());
			businessTripApplication.setDepartment(sapUser.getDepartmentName());
			businessTripApplication.setCostCenter(sapUser.getCostCener());
			businessTripApplication.setPersonalID(sapUser.getPersonalId());
			businessTripApplication.setPassportNo(sapUser.getPassportNo());
			businessTripApplication.setOfficePhone(sapUser.getContactNo());
			businessTripApplication.setMobilePhone(sapUser.getCellPhone());
			businessTripApplication.setEmail(sapUser.getEmail());
			businessTripApplication.setOfficeSite(sapUser.getOfficeSite());
			businessTripApplication.setApproverId(approverId);
			businessTripApplication.setApproverName(approverName);
			
			businessTripApplication.setEvpId(evpId);
			businessTripApplication.setEvpName(evpName);
			businessTripApplication.setOtherEmails(otherEmails);
			businessTripApplication.setIsCrossDepartment(isCrossDepartment);
			businessTripApplication.setTargetDepartmentId(targetDepartmentId);
			businessTripApplication.setTargetDepartmentName(targetDepartmentName);
			businessTripApplication.setTargetCostCenter(targetCostCenter);
			businessTripApplication
					.setTargetDepartmentApproverId(targetDepartmentApproverId);
			businessTripApplication
					.setTargetDepartmentApproverName(targetDepartmentApproverName);
			businessTripApplication.setTripType(tripType);
			businessTripApplication.setPurposeOfTheTrip(purposeOfTheTrip);
			businessTripApplication.setVisitCountriesCities(visitCountriesCities);
		}
		businessTripApplication.setDepartureDate(departureDate);
		businessTripApplication.setReturnDate(returnDate);
		
		businessTripApplication.setAdvancePayment(advancePayment);
		businessTripApplication.setCurrency(currency);
		businessTripApplication.setTotalCostRmb(totalCostRmb);
		businessTripApplication.setTotalCostEur(totalCostEur);
		businessTripApplication.setHotelTotalCostRmb(hotelTotalCostRmb);
		businessTripApplication.setHotelTotalCostEur(hotelTotalCostEur);
		businessTripApplication.setCarRentalTotalCostRmb(carRentalTotalCostRmb);
		businessTripApplication.setCarRentalTotalCostEur(carRentalTotalCostEur);
		businessTripApplication.setRemark(remark);
		//固定值
		businessTripApplication.setPaymentMethods("Bank Transfer");
		this.saveTheUploadAttachment(uploadPortletRequest, response,
				businessTripApplicationId);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				BusinessTripApplication.class.getName(), uploadPortletRequest);

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
			String transitionName = businessTripApplication.getSapStatus() == 1 ? "resubmitToCashAdvance"
					: "resubmit";
			/*long companyId = serviceContext.getCompanyId();
			WorkflowInstanceLink w = WorkflowInstanceLinkLocalServiceUtil
					.fetchWorkflowInstanceLink(companyId,
							businessTripApplication.getGroupId(),
							BusinessTripApplication.class.getName(),
							businessTripApplicationId);
			if (w != null) {
				// For special workflow
				WorkflowInstanceLinkLocalServiceUtil
						.deleteWorkflowInstanceLink(w);
			}*/
			String completeCmd = ParamUtil.getString(uploadPortletRequest, "completeCmd", "No");
			businessTripApplication = BusinessTripApplicationLocalServiceUtil
					.submitBusinessTripApplication(businessTripApplication,
							serviceContext);
			String operationUser = themeDisplay.getUser().getFirstName() + " "
					+ themeDisplay.getUser().getLastName();
			String action = "resubmitToCashAdvance".equals(transitionName) ? ActionConstants.SUBMIT_TO_CASH_ADVANCE
					: ActionConstants.SUBMIT;
			action = "Yes".equals(completeCmd)?ActionConstants.COMPLETE:ActionConstants.SUBMIT;
			BusinessTripApplicationLocalServiceUtil.saveOrUpdateAuditTrailLog(
					serviceContext.getCompanyId(),
					serviceContext.getScopeGroupId(),
					businessTripApplicationId, themeDisplay.getUserId(),
					operationUser, action, "");
			
			if(!"Yes".equals(completeCmd)){
				BusinessTripApplicationLocalServiceUtil.sendEmailtoApprover(businessTripApplication);
			}
			
			sb.append(businessTripApplication.getStatus()!=0?"pending":"completed");
			if(businessTripApplication.getStatus()==0) {
				Thread thread1 = new Thread();
				thread1.sleep(2000);
			}
		} else {
			businessTripApplication = BusinessTripApplicationLocalServiceUtil
					.saveOrUpdateBusinessTripApplication(
							businessTripApplication, serviceContext);
			sb.append("draft");
		}
		response.sendRedirect(sb.toString());
	}

	// Download the attachments
	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		String cmd=ParamUtil.getString(resourceRequest, "cmd");
		if(cmd.equals("autocomplete")){
			String emailSelect = ParamUtil.getString(resourceRequest, "emailSelect");
			
			try {
				List<SAPUser> sapUsers=SAPUserLocalServiceUtil.findSapUserByEmail(emailSelect);
				JSONArray jsonArray=JSONFactoryUtil.createJSONArray();
				for(int i=0;i<sapUsers.size();i++){
					SAPUser sapUser=sapUsers.get(i);
					JSONObject obj=JSONFactoryUtil.createJSONObject();
					obj.put("value", sapUser.getFirstName() + " " + sapUser.getLastName());
					obj.put("data",sapUser.getEmail());
					jsonArray.put(obj);
			}
				resourceResponse.setContentType("text/html");
				PrintWriter writer = resourceResponse.getWriter();
				writer.write(String.valueOf(jsonArray.toString()));
				writer.flush();
				writer.close();	
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else{
		String filePath = ParamUtil.getString(resourceRequest, "filePath");
		String fileName = ParamUtil.getString(resourceRequest, "fileName");
		File file = new File(filePath);
		HttpServletResponse response = PortalUtil.getHttpServletResponse(resourceResponse);	
		response.setContentType(GlobalToolLocalServiceUtil.getContentType(fileName)); 
		response.setContentLength((int)file.length()); 
		response.setHeader("Content-Disposition", "attachment;filename="+fileName);
		FileInputStream fis = new FileInputStream(file); 
		BufferedInputStream bis = new BufferedInputStream(fis); 
		byte[] b = new byte[1024]; 
		long k = 0; 
		ServletOutputStream sos = response.getOutputStream(); 
		BufferedOutputStream bos = new BufferedOutputStream(sos); 
		while(k < file.length()){ 
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

	// save or update the attachments
	public void saveTheUploadAttachment(
			UploadPortletRequest uploadPortletRequest,
			ActionResponse actionResponse, long businessTripApplicationId)
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
						BusinessTripApplication.class.getName(),
						businessTripApplicationId);
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
							0, BusinessTripApplication.class.getName(),
							businessTripApplicationId, 0, fileName, fileName,
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
			if ("Yes".equals(isRedirect)) {
				this.addBusinessTripApplication(actionRequest, actionResponse);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		super.processAction(actionRequest, actionResponse);
	}

	public void addDetailInfo(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException {
		String tabs2 = ParamUtil.get(actionRequest, "tabs2", "flight");
		long businessTripApplicationId = ParamUtil.getLong(actionRequest,
				"businessTripApplicationId", 0);
		long pkId = ParamUtil.get(actionRequest, "pkId", 0);
		double totalCostRmb = ParamUtil
				.getDouble(actionRequest, "totalCostRmb");
		double totalCostEur = ParamUtil
				.getDouble(actionRequest, "totalCostEur");
		double hotelTotalCostRmb = ParamUtil.getDouble(actionRequest,
				"hotelTotalCostRmb");
		double hotelTotalCostEur = ParamUtil.getDouble(actionRequest,
				"hotelTotalCostEur");
		double carRentalTotalCostRmb = ParamUtil.getDouble(actionRequest,
				"carRentalTotalCostRmb");
		double carRentalTotalCostEur = ParamUtil.getDouble(actionRequest,
				"carRentalTotalCostEur");
		int tripTypeAsForm = ParamUtil.getInteger(actionRequest,
				"tripTypeAsForm");
		String otherEmails = ParamUtil.getString(actionRequest, "otherEmails");
		String evpId = ParamUtil.getString(actionRequest, "evpId");
		String evpName = ParamUtil.getString(actionRequest, "evpName");
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
		String tripType = PropsUtil
				.get("vgc.apon.business.trip.application.type");
		if ("flight".equals(tabs2)) {
			pkId = pkId > 0 ? pkId : CounterLocalServiceUtil.increment(
					BtFlightTrainInfo.class.getName(), 1);
			BtFlightTrainInfo btFlightTrainInfo = BtFlightTrainInfoLocalServiceUtil
					.fetchBtFlightTrainInfo(pkId);
			btFlightTrainInfo = btFlightTrainInfo != null ? btFlightTrainInfo
					: BtFlightTrainInfoLocalServiceUtil
							.createBtFlightTrainInfo(pkId);

			String fromCity = ParamUtil.getString(actionRequest, "fromCity");
			String toCity = ParamUtil.getString(actionRequest, "toCity");
			Date departureDate = ParamUtil.getDate(actionRequest,
					"departureDate_", sdf);
			String departureFlight = ParamUtil.getString(actionRequest,
					"departureFlight");
			String classInfo = ParamUtil.getString(actionRequest, "classInfo");

			btFlightTrainInfo.setFromCity(fromCity);
			btFlightTrainInfo.setToCity(toCity);
			btFlightTrainInfo.setDepartureDate(departureDate);
			btFlightTrainInfo.setDepartureFlight(departureFlight);
			btFlightTrainInfo.setClassInfo(classInfo);
			btFlightTrainInfo.setTripType(tripType);
			btFlightTrainInfo.setBusinessTripPkId(businessTripApplicationId);
			BtFlightTrainInfoLocalServiceUtil
					.updateBtFlightTrainInfo(btFlightTrainInfo);
		} else if ("train".equals(tabs2)) {
			pkId = pkId > 0 ? pkId : CounterLocalServiceUtil.increment(
					BtTrainInfo.class.getName(), 1);
			BtTrainInfo btTrainInfo = BtTrainInfoLocalServiceUtil
					.fetchBtTrainInfo(pkId);
			btTrainInfo = btTrainInfo != null ? btTrainInfo
					: BtTrainInfoLocalServiceUtil.createBtTrainInfo(pkId);

			String fromCity = ParamUtil.getString(actionRequest, "fromCity");
			String toCity = ParamUtil.getString(actionRequest, "toCity");
			Date departureDate = ParamUtil.getDate(actionRequest,
					"departureDate_", sdf);
			String departureTrain = ParamUtil.getString(actionRequest,
					"departureTrain");
			String classInfo = ParamUtil.getString(actionRequest, "classInfo");

			btTrainInfo.setFromCity(fromCity);
			btTrainInfo.setToCity(toCity);
			btTrainInfo.setDepartureDate(departureDate);
			btTrainInfo.setDepartureTrain(departureTrain);
			btTrainInfo.setClassInfo(classInfo);
			btTrainInfo.setTripType(tripType);
			btTrainInfo.setBusinessTripPkId(businessTripApplicationId);
			BtTrainInfoLocalServiceUtil.updateBtTrainInfo(btTrainInfo);
		} else if ("hotelInformation".equals(tabs2)) {
			pkId = pkId > 0 ? pkId : CounterLocalServiceUtil.increment(
					BtHotelInfo.class.getName(), 1);
			BtHotelInfo btHotelInfo = BtHotelInfoLocalServiceUtil
					.fetchBtHotelInfo(pkId);
			boolean isNew = btHotelInfo == null ? true : false;
			btHotelInfo = btHotelInfo != null ? btHotelInfo
					: BtHotelInfoLocalServiceUtil.createBtHotelInfo(pkId);

			String city = ParamUtil.getString(actionRequest, "city");
			String cityType = ParamUtil.getString(actionRequest, "cityType");
			String hotel = ParamUtil.getString(actionRequest, "hotel");
			Date checkIn = ParamUtil.getDate(actionRequest, "checkIn", sdf);
			Date checkOut = ParamUtil.getDate(actionRequest, "checkOut", sdf);
			String roomCategory = ParamUtil.getString(actionRequest,
					"roomCategory");
			double price = ParamUtil.getDouble(actionRequest, "price");
			String currency = ParamUtil.getString(actionRequest, "currency_");
			double oldPrice = btHotelInfo.getPrice();
			String oldCurrency = btHotelInfo.getCurrency();
			int isOverBudget = ParamUtil.getInteger(actionRequest,
					"isOverBudget");
			String otherReasonInfo = ParamUtil.getString(actionRequest,
					"otherReasonInfo");
			boolean isNotBookedFromTA = ParamUtil.getBoolean(actionRequest,
					"isNotBookedFromTA");
			String othersSpecify = ParamUtil.getString(actionRequest,
					"othersSpecify");

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
			btHotelInfo.setBusinessTripPkId(businessTripApplicationId);
			BtHotelInfoLocalServiceUtil.updateBtHotelInfo(btHotelInfo);
			if (isNew) {
				hotelTotalCostRmb = BTApplicationUtil.addCalculate(
						hotelTotalCostRmb, RMB, price, currency);
				hotelTotalCostEur = BTApplicationUtil.addCalculate(
						hotelTotalCostEur, EUR, price, currency);
			} else {
				hotelTotalCostRmb = BTApplicationUtil.deleteCalculate(
						hotelTotalCostRmb, RMB, oldPrice, oldCurrency);
				hotelTotalCostRmb = BTApplicationUtil.addCalculate(
						hotelTotalCostRmb, RMB, price, currency);
				hotelTotalCostEur = BTApplicationUtil.deleteCalculate(
						hotelTotalCostEur, EUR, oldPrice, oldCurrency);
				hotelTotalCostEur = BTApplicationUtil.addCalculate(
						hotelTotalCostEur, EUR, price, currency);
			}
		} else if ("carRental".equals(tabs2)) {
			pkId = pkId > 0 ? pkId : CounterLocalServiceUtil.increment(
					BtCarRentalInfo.class.getName(), 1);
			BtCarRentalInfo btCarRentalInfo = BtCarRentalInfoLocalServiceUtil
					.fetchBtCarRentalInfo(pkId);
			boolean isNew = btCarRentalInfo == null ? true : false;
			btCarRentalInfo = btCarRentalInfo != null ? btCarRentalInfo
					: BtCarRentalInfoLocalServiceUtil
							.createBtCarRentalInfo(pkId);

			String pickupLocation = ParamUtil.getString(actionRequest,
					"pickupLocation");
			Date pickupDate = ParamUtil.getDate(actionRequest, "pickupDate",
					sdf);
			String dropoffLocation = ParamUtil.getString(actionRequest,
					"dropoffLocation");
			Date dropoffDate = ParamUtil.getDate(actionRequest, "dropoffDate",
					sdf);
			String carType = ParamUtil.getString(actionRequest, "carType");
			String typeOfRental = ParamUtil.getString(actionRequest,
					"typeOfRental");
			Double price = ParamUtil.getDouble(actionRequest, "carPrice");
			String currency = ParamUtil.getString(actionRequest, "carCurrency");
			double oldPrice = btCarRentalInfo.getPrice();
			String oldCurrency = btCarRentalInfo.getCurrency();

			btCarRentalInfo.setPickupLocation(pickupLocation);
			btCarRentalInfo.setPickupDate(pickupDate);
			btCarRentalInfo.setDropoffLocation(dropoffLocation);
			btCarRentalInfo.setDropoffDate(dropoffDate);
			btCarRentalInfo.setCarType(carType);
			btCarRentalInfo.setTypeOfRental(typeOfRental);
			btCarRentalInfo.setPrice(price);
			btCarRentalInfo.setCurrency(currency);
			btCarRentalInfo.setTripType(tripType);
			btCarRentalInfo.setBusinessTripPkId(businessTripApplicationId);
			BtCarRentalInfoLocalServiceUtil
					.updateBtCarRentalInfo(btCarRentalInfo);
			if (isNew) {
				carRentalTotalCostRmb = BTApplicationUtil.addCalculate(
						carRentalTotalCostRmb, RMB, price, currency);
				carRentalTotalCostEur = BTApplicationUtil.addCalculate(
						carRentalTotalCostEur, EUR, price, currency);
			} else {
				carRentalTotalCostRmb = BTApplicationUtil.deleteCalculate(
						carRentalTotalCostRmb, RMB, oldPrice, oldCurrency);
				carRentalTotalCostRmb = BTApplicationUtil.addCalculate(
						carRentalTotalCostRmb, RMB, price, currency);
				carRentalTotalCostEur = BTApplicationUtil.deleteCalculate(
						carRentalTotalCostEur, EUR, oldPrice, oldCurrency);
				carRentalTotalCostEur = BTApplicationUtil.addCalculate(
						carRentalTotalCostEur, EUR, price, currency);
			}
		}
		totalCostRmb = BTApplicationUtil.addCalculate(hotelTotalCostRmb, RMB,
				carRentalTotalCostRmb, RMB);
		totalCostEur = BTApplicationUtil.addCalculate(hotelTotalCostEur, EUR,
				carRentalTotalCostEur, EUR);
		actionResponse.setRenderParameter("evpId",
				evpId);
		actionResponse.setRenderParameter("evpName",
				evpName);
		actionResponse.setRenderParameter("otherEmails",
				String.valueOf(otherEmails));
		actionResponse.setRenderParameter("tripTypeAsForm",
				String.valueOf(tripTypeAsForm));
		actionResponse.setRenderParameter("tabs2", tabs2);
		actionResponse.setRenderParameter("businessTripApplicationId",
				String.valueOf(businessTripApplicationId));
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
		// actionResponse.setRenderParameter("mvcPath","/html/businessTripApplication/view.jsp");
		BTApplicationUtil.passRenderParameter(actionRequest, actionResponse);
	}

	// Delete the detail info
	public void deleteDetailInfo(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException, PortalException {
		String tabs2 = ParamUtil.get(actionRequest, "tabs2", "flightTrain");
		long businessTripApplicationId = ParamUtil.getLong(actionRequest,
				"businessTripApplicationId", 0);
		double totalCostRmb = ParamUtil
				.getDouble(actionRequest, "totalCostRmb");
		double totalCostEur = ParamUtil
				.getDouble(actionRequest, "totalCostEur");
		double hotelTotalCostRmb = ParamUtil.getDouble(actionRequest,
				"hotelTotalCostRmb");
		double hotelTotalCostEur = ParamUtil.getDouble(actionRequest,
				"hotelTotalCostEur");
		double carRentalTotalCostRmb = ParamUtil.getDouble(actionRequest,
				"carRentalTotalCostRmb");
		double carRentalTotalCostEur = ParamUtil.getDouble(actionRequest,
				"carRentalTotalCostEur");
		int tripTypeAsForm = ParamUtil.getInteger(actionRequest,
				"tripTypeAsForm");
		String otherEmails = ParamUtil.getString(actionRequest, "otherEmails");
		String evpId = ParamUtil.getString(actionRequest, "evpId");
		String evpName = ParamUtil.getString(actionRequest, "evpName");
		long pkId = ParamUtil.getLong(actionRequest, "pkId", 0);
		String tripType = PropsUtil
				.get("vgc.apon.business.trip.application.type");
		if ("flight".equals(tabs2)) {
			BtFlightTrainInfoLocalServiceUtil.deleteBtFlightTrainInfo(pkId);
		} else if ("train".equals(tabs2)) {
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
					businessTripApplicationId, tripType) == 0 ? 0
					: hotelTotalCostRmb;
			hotelTotalCostEur = BtHotelInfoLocalServiceUtil.findCountByB_T(
					businessTripApplicationId, tripType) == 0 ? 0
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
					.findCountByB_T(businessTripApplicationId, tripType) == 0 ? 0
					: carRentalTotalCostRmb;
			carRentalTotalCostEur = BtCarRentalInfoLocalServiceUtil
					.findCountByB_T(businessTripApplicationId, tripType) == 0 ? 0
					: carRentalTotalCostEur;
		}
		totalCostRmb = BTApplicationUtil.addCalculate(hotelTotalCostRmb, RMB,
				carRentalTotalCostRmb, RMB);
		totalCostEur = BTApplicationUtil.addCalculate(hotelTotalCostEur, EUR,
				carRentalTotalCostEur, EUR);
		actionResponse.setRenderParameter("tripTypeAsForm",
				String.valueOf(tripTypeAsForm));
		actionResponse.setRenderParameter("evpId",
				evpId);
		actionResponse.setRenderParameter("evpName",
				evpName);
		actionResponse.setRenderParameter("otherEmails",
				String.valueOf(otherEmails));
		actionResponse.setRenderParameter("tabs2", tabs2);
		actionResponse.setRenderParameter("businessTripApplicationId",
				String.valueOf(businessTripApplicationId));
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
		// actionResponse.setRenderParameter("mvcPath","/html/businessTripApplication/view.jsp");
		BTApplicationUtil.passRenderParameter(actionRequest, actionResponse);
	}

	// Get the applicant agent staffcode
	public void applicantAgent(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException {
		boolean isApplicantAgent = ParamUtil.getBoolean(actionRequest,
				"isApplicantAgent", false);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		long staffCode = user.getFacebookId();
		if (isApplicantAgent) {
			ApplicantDelegation applicantDelegation = ApplicantDelegationLocalServiceUtil
					.fetchByP_S(ApproverDelegationLocalServiceUtil
							.getProcessOfBusinessTripApplication(), String
							.valueOf(staffCode));
			staffCode = UserLocalServiceUtil.fetchUserById(
					applicantDelegation.getUserId()).getFacebookId();
		}
		long businessTripApplicationId = ParamUtil.getLong(actionRequest,
				"businessTripApplicationId");
		actionResponse.setRenderParameter("staffCode",
				String.valueOf(staffCode));
		actionResponse.setRenderParameter("isApplicantAgent",
				String.valueOf(isApplicantAgent));
		actionResponse.setRenderParameter("businessTripApplicationId",
				String.valueOf(businessTripApplicationId));
		actionResponse.setRenderParameter("isClickAgent", "Yes");
		// actionResponse.setRenderParameter("mvcPath","/html/businessTripApplication/view.jsp");
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

	// For the select_target_department.jsp query
	public void searchTargetDepartmentApprover(ActionRequest actionRequest,
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
		actionResponse.setRenderParameter("eventName", eventName);
		actionResponse.setRenderParameter("mvcPath", mvcPath);
		actionResponse.setRenderParameter("sapCompanyName", sapCompanyName);
		actionResponse.setRenderParameter("divisionName", divisionName);
		actionResponse.setRenderParameter("departmentName", departmentName);
		actionResponse.setRenderParameter("staffName", staffName);
		// actionResponse.setRenderParameter("mvcPath","/html/businessTripApplication/view.jsp");
	}
}
