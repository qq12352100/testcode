package com.e.onboarding.portlet.eOnboarding;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.delegation.model.ApplicantDelegation;
import com.delegation.service.ApplicantDelegationLocalServiceUtil;
import com.delegation.service.ApproverDelegationLocalServiceUtil;
import com.e.onboarding.constant.ApplicantConstrant;
import com.e.onboarding.model.EOnBoarding;
import com.e.onboarding.service.EOnBoardingLocalServiceUtil;
import com.e.onboarding.util.ActionConstants;
import com.file.management.model.FileManagement;
import com.file.management.service.FileManagementLocalServiceUtil;
import com.global.management.service.GlobalToolLocalServiceUtil;
import com.it.equipment.model.IENewEmployeesApplication;
import com.it.equipment.service.IENewEmployeesApplicationLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.image.ImageBag;
import com.liferay.portal.kernel.image.ImageToolUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowTask;
import com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil;
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
 * Portlet implementation class applicantPortlet
 */
public class EOnBoardingPortlet extends MVCPortlet {

	private static Log log = LogFactoryUtil.getLog(EOnBoardingPortlet.class);

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		// TODO Auto-generated method stub
		String staffCode = ParamUtil.getString(renderRequest, "staffCode2");
		try {
			SAPUser sapUser = SAPUserLocalServiceUtil.getSapUserByStaffCode(staffCode);
			long eOnBoardingId = ParamUtil.getLong(renderRequest, "eOnBoardingId2",0);
			boolean isApplicantAgent = ParamUtil.getBoolean(renderRequest, "isApplicantAgent",false);
			renderRequest.setAttribute("sapUser", sapUser);
			renderRequest.setAttribute("eOnBoardingId", eOnBoardingId);
			renderRequest.setAttribute("isApplicantAgent", isApplicantAgent);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.doView(renderRequest, renderResponse);
	}

	public void addEOnBoarding(ActionRequest request, ActionResponse response) {
		UploadPortletRequest uploadPortletRequest =  PortalUtil.getUploadPortletRequest(request);	
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		ThemeDisplay themeDisplay = (ThemeDisplay) uploadPortletRequest
				.getAttribute(WebKeys.THEME_DISPLAY);	
		long eOnBoardingId = ParamUtil.getLong(uploadPortletRequest, "eOnBoardingId");
		String staffCode = ParamUtil.getString(uploadPortletRequest, "staffCode");
		String cmd = ParamUtil.getString(uploadPortletRequest, Constants.CMD);
		String title = ParamUtil.getString(uploadPortletRequest, "title");
		String lastName = ParamUtil.getString(uploadPortletRequest, "lastName");
		String firstName = ParamUtil.getString(uploadPortletRequest, "firstName");
		Boolean isApplicantAgent = ParamUtil.getBoolean(uploadPortletRequest, "isApplicantAgent",false);	
		String name = ParamUtil.getString(uploadPortletRequest, "name");
		Date birthday = ParamUtil.getDate(uploadPortletRequest, "birthday", dateFormat);
		String contractType = ParamUtil.getString(uploadPortletRequest, "contractType2");
		String division = ParamUtil.getString(uploadPortletRequest, "division");
		String department = ParamUtil.getString(uploadPortletRequest, "department");
		String positionCode = ParamUtil.getString(uploadPortletRequest, "positionCode");
		String functionName = ParamUtil.getString(uploadPortletRequest, "functionName");
		String costCenter = ParamUtil.getString(uploadPortletRequest, "costCenter");
		String itRelatedHardware = ParamUtil.getString(uploadPortletRequest,
				"itRelatedHardware");
		String replacement = ParamUtil.getString(uploadPortletRequest, "replacement");
		String workLocation = ParamUtil.getString(uploadPortletRequest, "workLocation2");
		String officeSite = ParamUtil.getString(uploadPortletRequest, "officeSite2");
		Date startingDate = ParamUtil.getDate(uploadPortletRequest, "startingDate", dateFormat);
		String serviceLength = ParamUtil.getString(uploadPortletRequest, "serviceLength");
		String reportTo = ParamUtil.getString(uploadPortletRequest, "reportTo");
		String reportToStaffName = ParamUtil.getString(uploadPortletRequest, "reportToStaffName2");
		String gender = ParamUtil.getString(uploadPortletRequest, "gender");
		String companyCar = ParamUtil.getString(uploadPortletRequest, "companyCar2");
		String nameOfReplacePerson = ParamUtil.getString(uploadPortletRequest,
				"nameOfReplacePerson");
		String contactInfo = ParamUtil.getString(uploadPortletRequest, "contactInfo");
		if(contactInfo.indexOf("Please input email or phone info of BU Contact Person.")!=-1) {
			contactInfo = "";
		}
		String comments = ParamUtil.getString(uploadPortletRequest, "comments");

		try {
			EOnBoarding eOnBoarding = EOnBoardingLocalServiceUtil
					.fetchEOnBoarding(eOnBoardingId);
			if (eOnBoarding == null) {
				if(eOnBoardingId==0) {
					eOnBoardingId = CounterLocalServiceUtil.increment(EOnBoarding.class.getName(), 1);
				}
				eOnBoarding = EOnBoardingLocalServiceUtil
						.createEOnBoarding(eOnBoardingId);
				eOnBoarding.setCreateDate(new Date());
				eOnBoarding
						.setTicketNo(GlobalToolLocalServiceUtil.generateTicketNo("EO"));
			}
			eOnBoarding.setIsApplicantAgent(isApplicantAgent);
			eOnBoarding.setStaffCode(staffCode);
			eOnBoarding.setTitle(title);
			eOnBoarding.setLastName(lastName);
			eOnBoarding.setFirstName(firstName);
			eOnBoarding.setName(name);
			eOnBoarding.setBirthday(birthday);
			eOnBoarding.setContractType(contractType);
			eOnBoarding.setDivision(division);
			eOnBoarding.setDepartment(department);
			eOnBoarding.setPositionCode(positionCode);
			eOnBoarding.setFunctionName(functionName);
			eOnBoarding.setCostCenter(costCenter);
			eOnBoarding
					.setItRelatedHardware(Boolean.valueOf(itRelatedHardware));
			eOnBoarding.setReplacement(Boolean.valueOf(replacement));
			eOnBoarding.setWorkLocation(workLocation);
			eOnBoarding.setOfficeSite(officeSite);
			eOnBoarding.setStartingDate(startingDate);
			eOnBoarding.setServiceLength(serviceLength);
			eOnBoarding.setReportTo(reportTo);
			eOnBoarding.setReportToStaffName(reportToStaffName);
			eOnBoarding.setGender(gender);
			eOnBoarding.setCompanyCar(Boolean.valueOf(companyCar));
			eOnBoarding.setNameOfReplacedPerson(nameOfReplacePerson);
			eOnBoarding.setContactInfo(contactInfo);
			eOnBoarding.setComments(comments);
			eOnBoarding.setProcessType(ApplicantConstrant.EO_PROCESSTYPE);
			eOnBoarding
					.setSubType(ApplicantConstrant.EO_SUB_PROCESSTYPE_APPLICANT);
			String photoPath = this.getPhotoPath(uploadPortletRequest,eOnBoardingId);
			if(!"".equals(photoPath)) {
				eOnBoarding.setPhotoPath(photoPath);						
			}	
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					EOnBoarding.class.getName(), uploadPortletRequest);
			log.info("The eOnBoarding info is :"+eOnBoarding);	
			
			//Get the URL to redirect
			String url = themeDisplay.getURLPortal();
			url = url.indexOf("9080")!=-1?"":url.substring(url.lastIndexOf('/'));
			StringBuffer sb = new StringBuffer(url);
			String friendlyUrl = PropsUtil.get("vgc.apon.my.applications.page.friendly.url");
			sb.append("/web").append(themeDisplay.getScopeGroup().getFriendlyURL()).append(friendlyUrl);
			//Get the portlet Id of which need to forward
			String redirectPortletId = PropsUtil.get("vgc.apon.my.applications.portletId");
			sb.append("?p_p_id=").append(redirectPortletId).append("&_").append(redirectPortletId).append("_tabs2=");
			if (cmd.equals(Constants.PUBLISH)) {
				//Start the it equipment workflow
				long iENewEmployeesApplicationId = CounterLocalServiceUtil.increment(IENewEmployeesApplication.class.getName(), 1);		
				IENewEmployeesApplication iENewEmployeesApplication = IENewEmployeesApplicationLocalServiceUtil.createIENewEmployeesApplication(iENewEmployeesApplicationId);	
				iENewEmployeesApplication.setType(0);
				IENewEmployeesApplicationLocalServiceUtil.submitIENewEmployeesApplication(iENewEmployeesApplication, staffCode, eOnBoarding.getTicketNo(), uploadPortletRequest, serviceContext);
				
				String transitionName = ParamUtil.getString(uploadPortletRequest, "transitionName");
				if("resubmit".equals(transitionName)) {
					long companyId = serviceContext.getCompanyId();
					WorkflowInstanceLink w = WorkflowInstanceLinkLocalServiceUtil.fetchWorkflowInstanceLink(companyId, eOnBoarding.getGroupId(), EOnBoarding.class.getName(), eOnBoardingId);
					int end = WorkflowTaskManagerUtil.getWorkflowTaskCount(companyId, false);				
					List<WorkflowTask> list = WorkflowTaskManagerUtil.getWorkflowTasks(companyId, false, 0, end, null);
					for(WorkflowTask wt:list) {
						if(w.getWorkflowInstanceId()==wt.getWorkflowInstanceId()) {
							eOnBoarding = EOnBoardingLocalServiceUtil.saveAsDraft(eOnBoarding, serviceContext);
							WorkflowTaskManagerUtil.completeWorkflowTask(
									companyId, themeDisplay.getUserId(),
									wt.getWorkflowTaskId(), transitionName, "", null);
							break;
						}
					}
				}else {
					eOnBoarding = EOnBoardingLocalServiceUtil.submitEOnBoarding(eOnBoarding,
							serviceContext);		
				}				
				String operationUser = themeDisplay.getUser().getFirstName()+" "+themeDisplay.getUser().getLastName();
				EOnBoardingLocalServiceUtil.saveOrUpdateAuditTrailLog(serviceContext.getCompanyId(), serviceContext.getScopeGroupId(), eOnBoardingId, operationUser, ActionConstants.SUBMIT, "","");
				sb.append("pending");
				log.info("The redirect url is :"+sb.toString());
			} else {
				EOnBoardingLocalServiceUtil.saveAsDraft(eOnBoarding,
						serviceContext);
				sb.append("draft");
				log.info("The redirect url is :"+sb.toString());
			}			
			response.sendRedirect(sb.toString());
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void processAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		// TODO Auto-generated method stub
		String path = "/html/admin/select_reportToName.jsp";
		String positionPath = "/html/admin/select_position.jsp";
		String mvcPath = ParamUtil.getString(actionRequest, "mvcPath");
		String eventName = ParamUtil.getString(actionRequest, "eventName");
		if (path.equals(mvcPath)) {
			String staffCode = ParamUtil.getString(actionRequest, "staffCode");
			String staffName = ParamUtil.getString(actionRequest, "staffName");
			actionResponse.setRenderParameter("eventName", eventName);
			actionResponse.setRenderParameter("staffCode", staffCode);
			actionResponse.setRenderParameter("staffName", staffName);
			actionResponse.setRenderParameter("mvcPath", path);
			log.info("Forward to :" + path);
		} else if (positionPath.equals(mvcPath)) {
			String divisionName = ParamUtil.getString(actionRequest,
					"divisionName");
			String departmentName = ParamUtil.getString(actionRequest,
					"departmentName");
			String vacancyStatus = ParamUtil.getString(actionRequest,
					"vacancyStatus");
			String position = ParamUtil.getString(actionRequest, "position");
			actionResponse.setRenderParameter("eventName", eventName);
			actionResponse.setRenderParameter("divisionName", divisionName);
			actionResponse.setRenderParameter("departmentName", departmentName);
			actionResponse.setRenderParameter("vacancyStatus", vacancyStatus);
			actionResponse.setRenderParameter("position", position);
			actionResponse.setRenderParameter("mvcPath", positionPath);
			log.info("Forward to :" + path);
		} else {
			this.addEOnBoarding(actionRequest, actionResponse);
		}
		super.processAction(actionRequest, actionResponse);
	}

	public String generateTicketNo(String prefix) {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyyMM");
		String name = prefix + dateFormat.format(date);
		long number;
		try {
			number = CounterLocalServiceUtil.increment(name, 1);
			return name + String.format("%07d", number, 1);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}
	
	//Display the photo
	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		String photoPath = ParamUtil.getString(resourceRequest, "photoPath");
		if(Validator.isNotNull(photoPath)) {
			File file = new File(photoPath);
			if(file.exists()) {
				InputStream is =  new FileInputStream(file);
				ImageBag imageBag = ImageToolUtil.read(is);
				byte[] bytes = ImageToolUtil.getBytes(
					imageBag.getRenderedImage(), imageBag.getType());
				String contentType = MimeTypesUtil.getExtensionContentType(
					imageBag.getType());
				resourceResponse.setContentType(contentType);
				PortletResponseUtil.write(resourceResponse, bytes);
			}	
		}
	}
	
	private String getPhotoPath(UploadPortletRequest uploadPortletRequest,long eOnBoardingId) throws IOException, PortalException, SystemException {
		File photo = uploadPortletRequest.getFile("photo");
		String photoName = uploadPortletRequest.getFileName("photo");
		if(photo!=null && Validator.isNotNull(photoName)) {
			ServiceContext serviceContext = ServiceContextFactory
					.getInstance(uploadPortletRequest);
			String randomSourceFileName = FileManagementLocalServiceUtil
					.getRandomSourceFileName(photoName);
			File destination = null;
			String filePath = PropsUtil
					.get("dl.store.file.system.root.dir");
			filePath = filePath
					+ new SimpleDateFormat("/yyyy/MM/dd/").format(new Date());
			filePath = filePath.concat(randomSourceFileName);
			destination = new File(filePath);
			FileUtil.copyFile(photo, destination);
			FileUtil.delete(photo);
			List<FileManagement> fileManagements = FileManagementLocalServiceUtil.getByAssetClassNameAndAssetPrimaryKey(EOnBoarding.class.getName(),eOnBoardingId);
			long fileManagementId = fileManagements.size()>0?fileManagements.get(0).getFileManagementId():0;
			FileManagementLocalServiceUtil.saveOrUpdateFileManagement(
					fileManagementId, EOnBoarding.class.getName(),
					eOnBoardingId, 0, photoName, photoName,
					FileManagementLocalServiceUtil
							.getFileType(photoName), filePath, photoName,
					photo.length(), serviceContext);
			return filePath;
		}
		return "";
	}
	
	//Get the applicant agent staffcode
	public void applicantAgent(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException, SystemException {
		boolean isApplicantAgent = ParamUtil.getBoolean(actionRequest, "isApplicantAgent",false);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user  = themeDisplay.getUser();
		long staffCode = user.getFacebookId();
		if(isApplicantAgent) {
			ApplicantDelegation applicantDelegation = ApplicantDelegationLocalServiceUtil.fetchByP_S(ApproverDelegationLocalServiceUtil.getProcessOfEOnboarding(), String.valueOf(staffCode));
			staffCode = UserLocalServiceUtil.fetchUserById(applicantDelegation.getUserId()).getFacebookId();
		}		
		long firstCompanyCarId = ParamUtil.getLong(actionRequest, "firstCompanyCarId");
		actionResponse.setRenderParameter("staffCode", String.valueOf(staffCode));
		actionResponse.setRenderParameter("isApplicantAgent", String.valueOf(isApplicantAgent));
		actionResponse.setRenderParameter("firstCompanyCarId", String.valueOf(firstCompanyCarId));
	}
}
