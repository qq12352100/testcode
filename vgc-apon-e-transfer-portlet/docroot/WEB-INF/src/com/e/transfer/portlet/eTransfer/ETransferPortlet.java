package com.e.transfer.portlet.eTransfer;

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

import com.e.transfer.model.ETransfer;
import com.e.transfer.service.ETransferLocalServiceUtil;
import com.e.transfer.util.ActionConstants;
import com.e.transfer.util.ETConstants;
import com.e.transfer.util.TicketNoGeneration;
import com.file.management.model.FileManagement;
import com.file.management.service.FileManagementLocalServiceUtil;
import com.global.management.service.GlobalToolLocalServiceUtil;
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
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowTask;
import com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil;
import com.liferay.portal.model.WorkflowInstanceLink;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.WorkflowInstanceLinkLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.vgc.apon.model.SAPUser;
import com.vgc.apon.service.SAPUserLocalServiceUtil;

public class ETransferPortlet extends MVCPortlet {
	private static Log log = LogFactoryUtil
			.getLog(ETransferPortlet.class);
	
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		String staffCode = ParamUtil.getString(renderRequest, "staffCode2");
		try {
			SAPUser sapUser = SAPUserLocalServiceUtil.getSapUserByStaffCode(staffCode);
			long eTransferId = ParamUtil.getLong(renderRequest, "eTransferId2",0);
			eTransferId=ETransferLocalServiceUtil.fetchETransfer(eTransferId)==null?0:eTransferId;
			renderRequest.setAttribute("sapUser", sapUser);
			renderRequest.setAttribute("eTransferId", eTransferId);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		super.doView(renderRequest, renderResponse);
	}

	@SuppressWarnings("static-access")
	public void AddETransfer(ActionRequest request, ActionResponse response)
		throws SystemException, PortalException, IOException, InterruptedException {

		UploadPortletRequest uploadPortletRequest =  PortalUtil.getUploadPortletRequest(request);

		ThemeDisplay themeDisplay = (ThemeDisplay) uploadPortletRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		String cmd = ParamUtil.getString(uploadPortletRequest, Constants.CMD);

		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		long eTransferId = ParamUtil.getLong(uploadPortletRequest, "eTransferId");

		// Position Information
		String staffName = ParamUtil.getString(uploadPortletRequest, "staffName");
		String currentStaffCode = ParamUtil.getString(uploadPortletRequest, "currentStaffCode");
		String contractType = ParamUtil.getString(uploadPortletRequest, "contractType");
		String newStaffCode = ParamUtil.getString(uploadPortletRequest, "newStaffCode");
		int passedLL = ParamUtil.getInteger(uploadPortletRequest, "passedLL");
		int attendedSLT = ParamUtil.getInteger(uploadPortletRequest, "attendedSLT");
		String currentCompany=ParamUtil.getString(uploadPortletRequest, "currentCompany");
		String currentDivision=ParamUtil.getString(uploadPortletRequest, "currentDivision");
		String currentDepartment=ParamUtil.getString(uploadPortletRequest, "currentDepartment");
		String currentFunctionName=ParamUtil.getString(uploadPortletRequest, "currentFunctionName");
		String currentCostCenter=ParamUtil.getString(uploadPortletRequest, "currentCostCenter");
		String currentReportingTo=ParamUtil.getString(uploadPortletRequest, "currentReportingTo");
		String otherAgreementIfAny=ParamUtil.getString(uploadPortletRequest, "otherAgreementIfAny");
		String currentOfficeSite=ParamUtil.getString(uploadPortletRequest, "currentOfficeSite");
		String receivingCompany=ParamUtil.getString(uploadPortletRequest, "receivingCompany");
		String receivingDivision=ParamUtil.getString(uploadPortletRequest, "receivingDivision");
		String receivingDepartment=ParamUtil.getString(uploadPortletRequest, "receivingDepartment");
		String newFunctionName=ParamUtil.getString(uploadPortletRequest, "newFunctionName");
		String newCostCenter=ParamUtil.getString(uploadPortletRequest, "newCostCenter");
		String newReportingTo=ParamUtil.getString(uploadPortletRequest, "newReportingTo");
		Date effectiveDate = ParamUtil.getDate(uploadPortletRequest, "effectiveDate", dateFormat);
		String newOfficeSite=ParamUtil.getString(uploadPortletRequest, "newOfficeSite");
		String sapPositionCode=ParamUtil.getString(uploadPortletRequest, "sapPositionCode");
		String functionGrade=ParamUtil.getString(uploadPortletRequest, "functionGrade");
		String replacement=ParamUtil.getString(uploadPortletRequest, "replacement");
		int budgetTypeOfPosition=ParamUtil.getInteger(uploadPortletRequest, "budgetTypeOfPosition");
		int chinaSixty=ParamUtil.getInteger(uploadPortletRequest, "chinaSixty");
		int targetPDSupervisor=ParamUtil.getInteger(uploadPortletRequest, "targetPDSupervisor");
		String receivingStaffCode=ParamUtil.getString(uploadPortletRequest, "receivingStaffCode");
		String currentPositionCode=ParamUtil.getString(uploadPortletRequest, "currentPositionCode");

		ETransfer eTransfer = ETransferLocalServiceUtil.fetchETransfer(eTransferId);

		if(eTransfer == null) {
			eTransfer = ETransferLocalServiceUtil.createETransfer(eTransferId);

			String ticketNo = TicketNoGeneration.generateTicketNo("ESC");

			eTransfer.setTicketNo(ticketNo);

			Date now = new Date();
	
			eTransfer.setCreateDate(now);
		}

		// Position Information
		eTransfer.setStaffName(staffName);
		eTransfer.setCurrentStaffCode(currentStaffCode);
		eTransfer.setContractType(contractType);
		eTransfer.setNewStaffCode(newStaffCode);
		eTransfer.setPassedLL(passedLL);
		eTransfer.setAttendedSLT(attendedSLT);
		eTransfer.setCurrentCompany(currentCompany);
		eTransfer.setCurrentDivision(currentDivision);
		eTransfer.setCurrentDepartment(currentDepartment);
		eTransfer.setCurrentFunctionName(currentFunctionName);
		eTransfer.setCurrentCostCenter(currentCostCenter);
		eTransfer.setCurrentReportingTo(currentReportingTo);
		eTransfer.setOtherAgreementIfAny(otherAgreementIfAny);
		eTransfer.setCurrentOfficeSite(currentOfficeSite);
		eTransfer.setReceivingStaffCode(receivingStaffCode);
		eTransfer.setReceivingCompany(receivingCompany);
		eTransfer.setReceivingDivision(receivingDivision);
		eTransfer.setReceivingDepartment(receivingDepartment);
		eTransfer.setNewFunctionName(newFunctionName);
		eTransfer.setNewCostCenter(newCostCenter);
		eTransfer.setNewReportingTo(newReportingTo);
		eTransfer.setEffectiveDate(effectiveDate);
		eTransfer.setNewOfficeSite(newOfficeSite);
		eTransfer.setSapPositionCode(sapPositionCode);
		eTransfer.setReplacement(replacement);
		eTransfer.setFunctionGrade(functionGrade);
		eTransfer.setBudgetTypeOfPosition(budgetTypeOfPosition);
		eTransfer.setChinaSixty(chinaSixty);
		eTransfer.setTargetPDSupervisor(targetPDSupervisor);
		eTransfer.setCurrentPositionCode(currentPositionCode);

		// Common
		eTransfer.setProcessType(ETConstants.PROCESS_TYPE);
		eTransfer.setSubProcessType(ETConstants.SUB_TYPE_E_TRANSFER);

		this.saveTheUploadAttachment(uploadPortletRequest, response, eTransferId);

		ServiceContext serviceContext = 
				ServiceContextFactory.getInstance(
						ETransfer.class.getName(), uploadPortletRequest);

		String url = themeDisplay.getURLPortal();
		url = url.indexOf("9080")!=-1||url.indexOf("8080")!=-1?"":url.substring(url.lastIndexOf('/'));
		StringBuffer sb = new StringBuffer(url);
		String friendlyUrl = PropsUtil.get("vgc.apon.my.applications.page.friendly.url");
		sb.append("/web").append(themeDisplay.getScopeGroup().getFriendlyURL()).append(friendlyUrl);
		//Get the portlet Id of which need to forward
		String redirectPortletId = PropsUtil.get("vgc.apon.my.applications.portletId");
		sb.append("?p_p_id=").append(redirectPortletId).append("&_").append(redirectPortletId).append("_tabs2=");
		if(cmd.equals(Constants.PUBLISH)){
			String transitionName = ParamUtil.getString(uploadPortletRequest, "transitionName");
			if("resubmit".equals(transitionName)) {
				long companyId = serviceContext.getCompanyId();
				WorkflowInstanceLink w = WorkflowInstanceLinkLocalServiceUtil.fetchWorkflowInstanceLink(companyId, eTransfer.getGroupId(), ETransfer.class.getName(), eTransferId);
				int end = WorkflowTaskManagerUtil.getWorkflowTaskCount(companyId, false);				
				List<WorkflowTask> list = WorkflowTaskManagerUtil.getWorkflowTasks(companyId, false, 0, end, null);
				for(WorkflowTask wt:list) {
					if(w.getWorkflowInstanceId()==wt.getWorkflowInstanceId()) {
						eTransfer = ETransferLocalServiceUtil.saveOrUpdateETransfer(eTransfer, serviceContext);
						WorkflowTaskManagerUtil.completeWorkflowTask(
								companyId, themeDisplay.getUserId(),
								wt.getWorkflowTaskId(), transitionName, "", null);
						break;
					}
				}
				Thread thread = new Thread();
				thread.sleep(2000);
			}else {
				ETransferLocalServiceUtil.submitETransfer(eTransfer, serviceContext);
			}				
			String operationUser = themeDisplay.getUser().getFirstName()+" "+themeDisplay.getUser().getLastName();
			ETransferLocalServiceUtil.saveOrUpdateAuditTrailLog(serviceContext.getCompanyId(), serviceContext.getScopeGroupId(), eTransferId,themeDisplay.getUserId(),operationUser, ActionConstants.SUBMIT, "");
			sb.append("pending");
			log.info("The redirect url is :"+sb.toString());
		}else {
			ETransferLocalServiceUtil.saveOrUpdateETransfer(eTransfer, serviceContext);
			sb.append("draft");
			log.info("The redirect url is :"+sb.toString());
		}
		response.sendRedirect(sb.toString());
	}
	
	//Download the attachments
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
			ActionResponse actionResponse, long eTransferId)
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
						ETransfer.class.getName(), eTransferId);
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
							0, ETransfer.class.getName(),
							eTransferId, 0, fileName, fileName,
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
			String mvcPath = ParamUtil.getString(actionRequest, "mvcPath");
			if(ETConstants.SELECT_POSITION_PATH.equals(mvcPath)) {
				String searchType=ParamUtil.getString(actionRequest, "searchType");
				String division = ParamUtil.getString(actionRequest, "division");
				String divisionName = ParamUtil.getString(actionRequest, "divisionName");
				String department= ParamUtil.getString(actionRequest,"department");
				String departmentName= ParamUtil.getString(actionRequest,"departmentName");
				String functionName=ParamUtil.getString(actionRequest,"functionName");
				String reportToSupervisorName=ParamUtil.getString(actionRequest,"reportToSupervisorName");
				String positionCode=ParamUtil.getString(actionRequest,"positionCode");
				String company=ParamUtil.getString(actionRequest,"company");
				actionResponse.setRenderParameter("searchType", searchType);
				actionResponse.setRenderParameter("division", division);
				actionResponse.setRenderParameter("divisionName", divisionName);
				actionResponse.setRenderParameter("departmentName", departmentName);
				actionResponse.setRenderParameter("department", department);
				actionResponse.setRenderParameter("functionName", functionName);
				actionResponse.setRenderParameter("reportToSupervisorName", reportToSupervisorName);
				actionResponse.setRenderParameter("positionCode", positionCode);
				actionResponse.setRenderParameter("company", company);
				actionResponse.setRenderParameter("mvcPath", ETConstants.SELECT_POSITION_PATH);
			}else{
				this.AddETransfer(actionRequest, actionResponse);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		super.processAction(actionRequest, actionResponse);
	}
}
