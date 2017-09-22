package com.company.car.portlet.firstCompanyCar;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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

import com.company.car.model.FirstCompanyCar;
import com.company.car.service.CompanyCarManagementLocalServiceUtil;
import com.company.car.service.FirstCompanyCarLocalServiceUtil;
import com.company.car.util.ActionConstants;
import com.company.car.util.CompanyCarConstants;
import com.delegation.model.ApplicantDelegation;
import com.delegation.service.ApplicantDelegationLocalServiceUtil;
import com.delegation.service.ApproverDelegationLocalServiceUtil;
import com.file.management.model.FileManagement;
import com.file.management.service.FileManagementLocalServiceUtil;
import com.global.management.service.GlobalToolLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
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

public class FirstCompanyCarPortlet extends MVCPortlet {
	private static Log log = LogFactoryUtil
			.getLog(FirstCompanyCarPortlet.class);

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {	
		/*try {
			//Get the SAPUser from database
			long staffCode = ParamUtil.getLong(renderRequest, "staffCode2",0);
			Boolean isApplicantAgent = ParamUtil.getBoolean(renderRequest, "isApplicantAgent2");
			long firstCompanyCarId = ParamUtil.getLong(renderRequest, "firstCompanyCarId2",0);
			firstCompanyCarId=FirstCompanyCarLocalServiceUtil.fetchFirstCompanyCar(firstCompanyCarId)==null?0:firstCompanyCarId;
			int childrenNumber = ParamUtil.getInteger(renderRequest, "childrenNumber");
			SAPUser sapUser = staffCode==0?null:SAPUserLocalServiceUtil.getSapUserByStaffCode(String.valueOf(staffCode));
			renderRequest.setAttribute("sapUser", sapUser);			
			renderRequest.setAttribute("isApplicantAgent", isApplicantAgent);
			renderRequest.setAttribute("childrenNumber", childrenNumber);		
			renderRequest.setAttribute("staffCode", staffCode);	
			renderRequest.setAttribute("firstCompanyCarId", firstCompanyCarId);
			log.info("The SapUser info is :"+sapUser);
		} catch (SystemException e) {
			e.printStackTrace();
		}*/
		super.doView(renderRequest, renderResponse);
	}

	/**
	 * Save,Update,Submit the firstCompanyCar
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void addFirstCompanyCar(ActionRequest request,
			ActionResponse response) throws Exception {
		UploadPortletRequest uploadPortletRequest =  PortalUtil.getUploadPortletRequest(request);		
		ThemeDisplay themeDisplay = (ThemeDisplay) uploadPortletRequest
				.getAttribute(WebKeys.THEME_DISPLAY);	
		String cmd = ParamUtil.getString(uploadPortletRequest, Constants.CMD);
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		long firstCompanyCarId = ParamUtil
				.getLong(uploadPortletRequest, "firstCompanyCarId");
		Boolean isApplicantAgent = ParamUtil.getBoolean(uploadPortletRequest, "isApplicantAgent",false);		
		long staffCode = ParamUtil.getLong(uploadPortletRequest, "staffCode");	
		if(staffCode==0) {
			staffCode = 190002l;
		}		
		SAPUser sapUser = SAPUserLocalServiceUtil.getSapUserByStaffCode(String.valueOf(staffCode));	
		String workingLocation = ParamUtil
				.getString(uploadPortletRequest, "workingLocation");
		String email = ParamUtil.getString(uploadPortletRequest, "email");
		String officeSite = ParamUtil.getString(uploadPortletRequest, "officeSite");
		String mobilePhone = ParamUtil.getString(uploadPortletRequest, "mobilePhone");
		String officePhone = ParamUtil.getString(uploadPortletRequest, "officePhone");		
		int childrenNumber = ParamUtil.getInteger(uploadPortletRequest,
				"childrenNumber");
		int drivingLicenseInformation = ParamUtil
				.getInteger(uploadPortletRequest, "drivingLicenseInformation",-1);
		String comments = ParamUtil.getString(uploadPortletRequest, "comments");
		if(comments.indexOf("If you plan to change the working location during your assignment, please list the different working locations")!=-1) {
			comments = "";
		}
		String currentCarModel = ParamUtil
				.getString(uploadPortletRequest, "currentCarModel");
		String currentCarColor = ParamUtil
				.getString(uploadPortletRequest, "currentCarColor");
		String currentPlateNumber = ParamUtil.getString(uploadPortletRequest,
				"currentPlateNumber");
		String acquiringDateStr = ParamUtil.getString(uploadPortletRequest, "acquiringDate");
		Date acquiringDate = ParamUtil.getDate(uploadPortletRequest, "acquiringDate",
				dateFormat);
		if(acquiringDateStr==null || "".equals(acquiringDateStr)) {
			acquiringDate = null;
		}		
		Date estimatedObtainingDate = ParamUtil.getDate(uploadPortletRequest, "estimatedObtainingDate", dateFormat);
		String estimatedObtainingDateStr = ParamUtil.getString(uploadPortletRequest, "estimatedObtainingDate");
		if(estimatedObtainingDateStr==null || "".equals(estimatedObtainingDateStr)) {
			estimatedObtainingDate = null;
		}		
		String expectedCarModel = ParamUtil.getString(uploadPortletRequest,
				"expectedCarModel2");
		String expectedCarColor = ParamUtil.getString(uploadPortletRequest,
				"expectedCarColor");
		String expectedLastPlateNumber = ParamUtil.getString(uploadPortletRequest,
				"expectedLastPlateNumber");
		FirstCompanyCar firstCompanyCar = FirstCompanyCarLocalServiceUtil.fetchFirstCompanyCar(firstCompanyCarId);	
		if(firstCompanyCar==null) {
			if(firstCompanyCarId==0) {
				firstCompanyCarId  = CounterLocalServiceUtil.increment(FirstCompanyCar.class.getName(), 1);
			}
			firstCompanyCar = FirstCompanyCarLocalServiceUtil
					.createFirstCompanyCar(firstCompanyCarId);
			String ticketNo = CompanyCarManagementLocalServiceUtil.generateTicketNo("CC");
			firstCompanyCar.setTicketNo(ticketNo);
			Date now = new Date();
			firstCompanyCar.setCreateDate(now);	
		}
		firstCompanyCar.setIsApplicantAgent(isApplicantAgent);
		firstCompanyCar.setCompanyName(sapUser.getSapCompanyName());
		firstCompanyCar.setStaffCode(staffCode);
		firstCompanyCar.setName(sapUser.getStaffName());
		firstCompanyCar.setDivision(sapUser.getDivisionName());
		firstCompanyCar.setDepartment(sapUser.getDepartmentName());
		firstCompanyCar.setPositionCostCenterId(sapUser.getCostCener());
		firstCompanyCar.setEmployeeGroupId(sapUser.getEmployeeGroupId());
		firstCompanyCar.setWorkingLocation(workingLocation);
		firstCompanyCar.setEmail(email);
		firstCompanyCar.setOfficeSite(officeSite);
		firstCompanyCar.setMobilePhone(mobilePhone);
		firstCompanyCar.setOfficePhone(officePhone);
		firstCompanyCar.setContractEndDate(sapUser.getContractEndDate());
		firstCompanyCar.setContractEndDate(sapUser.getContractEndDate());
		firstCompanyCar.setChildrenNumber(sapUser.getChildrenNumber());
		firstCompanyCar.setDrivingLicenseInformation(drivingLicenseInformation);
		firstCompanyCar.setComments(comments);
		firstCompanyCar.setCurrentCarModel(currentCarModel);
		firstCompanyCar.setCurrentCarColor(currentCarColor);
		firstCompanyCar.setCurrentPlateNumber(currentPlateNumber);
		firstCompanyCar.setAcquiringDate(acquiringDate);
		firstCompanyCar.setExpectedCarModel(expectedCarModel);
		firstCompanyCar.setExpectedCarColor(expectedCarColor);
		firstCompanyCar.setExpectedLastPlateNumber(expectedLastPlateNumber);
		firstCompanyCar.setEstimatedObtainingDate(estimatedObtainingDate);
		firstCompanyCar.setProcessType(CompanyCarConstants.PROCESS_TYPE);
		firstCompanyCar.setSubType(CompanyCarConstants.SUB_TYPE_FIRST_COMPANY_CAR);
		firstCompanyCar.setUserName(themeDisplay.getUser().getFullName());
		this.saveTheUploadAttachment(uploadPortletRequest, response, firstCompanyCarId);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				FirstCompanyCar.class.getName(), uploadPortletRequest);
		log.info("The firstCompanyCar info is :"+firstCompanyCar);	
	
		//Get the URL to redirect
		String url = themeDisplay.getURLPortal();
		url = url.indexOf("9080")!=-1||url.indexOf("8080")!=-1?"":url.substring(url.lastIndexOf('/'));
		StringBuffer sb = new StringBuffer(url);
		String friendlyUrl = PropsUtil.get("vgc.apon.my.applications.page.friendly.url");
		sb.append("/web").append(themeDisplay.getScopeGroup().getFriendlyURL()).append(friendlyUrl);
		//Get the portlet Id of which need to forward
		String redirectPortletId = PropsUtil.get("vgc.apon.my.applications.portletId");
		sb.append("?p_p_id=").append(redirectPortletId).append("&_").append(redirectPortletId).append("_tabs2=");
		if(cmd.equals(Constants.PUBLISH)) {
			String transitionName = "resubmit";
			long companyId = serviceContext.getCompanyId();
			WorkflowInstanceLink w = WorkflowInstanceLinkLocalServiceUtil.fetchWorkflowInstanceLink(companyId, firstCompanyCar.getGroupId(), FirstCompanyCar.class.getName(), firstCompanyCarId);
			if(w!=null) {
				WorkflowInstanceLinkLocalServiceUtil.deleteWorkflowInstanceLink(w);									
			}	
			firstCompanyCar = FirstCompanyCarLocalServiceUtil.submitFirstCompanyCar(firstCompanyCar, serviceContext);
			String operationUser = themeDisplay.getUser().getFirstName()+" "+themeDisplay.getUser().getLastName();
			FirstCompanyCarLocalServiceUtil.saveOrUpdateAuditTrailLog(serviceContext.getCompanyId(), serviceContext.getScopeGroupId(), firstCompanyCarId, operationUser, ActionConstants.SUBMIT, "");
			sb.append("pending");
			log.info("The redirect url is :"+sb.toString());
		}else {
			firstCompanyCar = FirstCompanyCarLocalServiceUtil.saveOrUpdateFirstCompanyCar(firstCompanyCar, serviceContext);
			sb.append("draft");
			log.info("The redirect url is :"+sb.toString());
		}
		response.sendRedirect(sb.toString());
	}
	
	//Download the attachments
	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
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
		super.serveResource(resourceRequest, resourceResponse);
	}
	
	//save or update the attachments
	public void saveTheUploadAttachment(
			UploadPortletRequest uploadPortletRequest,
			ActionResponse actionResponse, long firstCompanyCarId)
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
						FirstCompanyCar.class.getName(), firstCompanyCarId);
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
							0, FirstCompanyCar.class.getName(),
							firstCompanyCarId, 0, fileName, fileName,
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
			String mvcPath = ParamUtil.getString(actionRequest, "mvcPath","addFirstCompanyCar");
			if(CompanyCarConstants.SELECT_CAR_PATH.equals(mvcPath)) {
				this.selectCarQuery(actionRequest, actionResponse);
			}else if("addFirstCompanyCar".equals(mvcPath)){
				this.addFirstCompanyCar(actionRequest, actionResponse);				
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		super.processAction(actionRequest, actionResponse);
	}
	
	public void selectCarQuery(ActionRequest actionRequest,
			ActionResponse actionResponse) {
		String staffCode = ParamUtil.getString(actionRequest, "staffCode");
		String childrenNumber = ParamUtil.getString(actionRequest, "childrenNumber");
		String carCategory = ParamUtil.getString(actionRequest, "carCategory");
		String carType = ParamUtil.getString(actionRequest, "carType");
		String carBrand = ParamUtil.getString(actionRequest, "carBrand");
		String eventName = ParamUtil.getString(actionRequest, "eventName");
		actionResponse.setRenderParameter("carCategory", carCategory);
		actionResponse.setRenderParameter("carType", carType);
		actionResponse.setRenderParameter("carBrand", carBrand);
		actionResponse.setRenderParameter("staffCode", staffCode);
		actionResponse.setRenderParameter("childrenNumber", childrenNumber);
		actionResponse.setRenderParameter("eventName", eventName);
		actionResponse.setRenderParameter("mvcPath", CompanyCarConstants.SELECT_CAR_PATH);
		log.info("Forward to :"+CompanyCarConstants.SELECT_CAR_PATH);
	}
	
	//Get the applicant agent staffcode
	public void applicantAgent(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException, SystemException {
		boolean isApplicantAgent = ParamUtil.getBoolean(actionRequest, "isApplicantAgent",false);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user  = themeDisplay.getUser();
		long staffCode = user.getFacebookId();
		if(isApplicantAgent) {
			ApplicantDelegation applicantDelegation = ApplicantDelegationLocalServiceUtil.fetchByP_S(ApproverDelegationLocalServiceUtil.getProcessOfCompanyCarApplication(), String.valueOf(staffCode));
			staffCode = UserLocalServiceUtil.fetchUserById(applicantDelegation.getUserId()).getFacebookId();
		}		
		long firstCompanyCarId = ParamUtil.getLong(actionRequest, "firstCompanyCarId");
		actionResponse.setRenderParameter("staffCode", String.valueOf(staffCode));
		actionResponse.setRenderParameter("isApplicantAgent", String.valueOf(isApplicantAgent));
		actionResponse.setRenderParameter("firstCompanyCarId", String.valueOf(firstCompanyCarId));
		actionResponse.setRenderParameter("isClickAgent", "Yes");
	}
}
