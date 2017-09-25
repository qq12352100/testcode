package com.e.leave.portlet.eLeave;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.delegation.model.ApplicantDelegation;
import com.delegation.service.ApplicantDelegationLocalServiceUtil;
import com.delegation.service.ApproverDelegationLocalServiceUtil;
import com.e.leave.model.ELeave;
import com.e.leave.model.ELeaveInfo;
import com.e.leave.service.ELeaveInfoLocalServiceUtil;
import com.e.leave.service.ELeaveLocalServiceUtil;
import com.e.leave.util.ActionConstants;
import com.e.leave.util.ELConstants;
import com.e.leave.util.TicketNoGeneration;
import com.file.management.model.FileManagement;
import com.file.management.service.FileManagementLocalServiceUtil;
import com.global.management.service.GlobalToolLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringUtil;
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
import com.vgc.apon.model.AbsenceQuotaData;
import com.vgc.apon.service.AbsenceQuotaDataLocalServiceUtil;

public class ELeavePortlet extends MVCPortlet{
	private static Log log = LogFactoryUtil
			.getLog(ELeavePortlet.class);
	
	@SuppressWarnings("static-access")
	public void AddELeave(ActionRequest request, ActionResponse response)
			throws SystemException, PortalException, IOException, InterruptedException {
		UploadPortletRequest uploadPortletRequest =  PortalUtil.getUploadPortletRequest(request);

		ThemeDisplay themeDisplay = (ThemeDisplay) uploadPortletRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		String cmd = ParamUtil.getString(uploadPortletRequest, Constants.CMD);

		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		long eLeaveId = ParamUtil.getLong(uploadPortletRequest, "eLeaveId");
		
		//Employee Information
		String staffName = ParamUtil.getString(uploadPortletRequest, "staffName");
		String staffCode = ParamUtil.getString(uploadPortletRequest, "staffCode");
		String company = ParamUtil.getString(uploadPortletRequest, "company");
		String division = ParamUtil.getString(uploadPortletRequest, "division");
		String department = ParamUtil.getString(uploadPortletRequest, "department");
		String costCenter = ParamUtil.getString(uploadPortletRequest, "costCenter");
		String officePhone = ParamUtil.getString(uploadPortletRequest, "officePhone");
		String mobilePhone = ParamUtil.getString(uploadPortletRequest, "mobilePhone");
		String email = ParamUtil.getString(uploadPortletRequest, "email");
		String positionType = ParamUtil.getString(uploadPortletRequest, "positionType");
		Boolean isApplicantAgent = ParamUtil.getBoolean(uploadPortletRequest, "isApplicantAgent",false);
		ELeave eLeave = ELeaveLocalServiceUtil.fetchELeave(eLeaveId);

		if(eLeave == null) {
			eLeave = ELeaveLocalServiceUtil.createELeave(eLeaveId);

			String ticketNo = TicketNoGeneration.generateTicketNo("EA");

			eLeave.setTicketNo(ticketNo);

			Date now = new Date();
	
			eLeave.setCreateDate(now);
		}

		//Employee Information
		eLeave.setStaffName(staffName);
		eLeave.setStaffCode(staffCode);
		eLeave.setCompany(company);
		eLeave.setDivision(division);
		eLeave.setDepartment(department);
		eLeave.setCostCenter(costCenter);
		eLeave.setOfficePhone(officePhone);
		eLeave.setMobilePhone(mobilePhone);
		eLeave.setEmail(email);
		eLeave.setPositionType(positionType);
		eLeave.setIsApplicantAgent(isApplicantAgent);
	
	
		// Common
		eLeave.setProcessType(ELConstants.PROCESS_TYPE);
		eLeave.setSubProcessType(ELConstants.SUB_TYPE_E_LEAVE);

		if(!cmd.equals(Constants.DELETE_TEMP)){
			this.saveTheUploadAttachment(uploadPortletRequest, response, eLeaveId);
		}

		ServiceContext serviceContext = 
				ServiceContextFactory.getInstance(
						ELeave.class.getName(), uploadPortletRequest);

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
			/**
			 * when supervisor reject the ticket, then change the e-leave content, the transitionName will be lost.  So here to check again.
			 */
			transitionName = WorkflowInstanceLinkLocalServiceUtil.fetchWorkflowInstanceLink(themeDisplay.getCompanyId(),eLeave.getGroupId(), ELeave.class.getName(), eLeave.getELeaveId())==null?transitionName:"resubmit";
			System.out.println("********AddELeave**************transitionName***********="+transitionName);
			if("resubmit".equals(transitionName)) {
				long companyId = serviceContext.getCompanyId();
				WorkflowInstanceLink w = WorkflowInstanceLinkLocalServiceUtil.fetchWorkflowInstanceLink(companyId, eLeave.getGroupId(), ELeave.class.getName(), eLeaveId);
				int end = WorkflowTaskManagerUtil.getWorkflowTaskCount(companyId, false);				
				List<WorkflowTask> list = WorkflowTaskManagerUtil.getWorkflowTasks(companyId, false, 0, end, null);
				for(WorkflowTask wt:list) {
					if(w.getWorkflowInstanceId()==wt.getWorkflowInstanceId()) {
						eLeave = ELeaveLocalServiceUtil.saveOrUpdateELeave(eLeave, serviceContext);
						WorkflowTaskManagerUtil.completeWorkflowTask(
								companyId, themeDisplay.getUserId(),
								wt.getWorkflowTaskId(), transitionName, "", null);
						break;
					}
				}
				Thread thread = new Thread();
				thread.sleep(2000);
			}else {
				ELeaveLocalServiceUtil.submitELeave(eLeave, serviceContext);
			}				
			String operationUser = themeDisplay.getUser().getFirstName()+" "+themeDisplay.getUser().getLastName();
			ELeaveLocalServiceUtil.saveOrUpdateAuditTrailLog(serviceContext.getCompanyId(), serviceContext.getScopeGroupId(), eLeaveId,themeDisplay.getUserId(),operationUser, ActionConstants.SUBMIT, "");
			sb.append("pending");
			log.info("The redirect url is :"+sb.toString());
			response.sendRedirect(sb.toString());
		}else if(cmd.equals(Constants.ADD_TEMP)){
			eLeave = calcaulteAddEleaveDuration(uploadPortletRequest,eLeave);
			//ELeaveLocalServiceUtil.updateELeave(eLeave);
			ELeaveLocalServiceUtil.saveOrUpdateELeave(eLeave, serviceContext);
			
			String typeOfLeave=ParamUtil.getString(uploadPortletRequest, "typeOfLeave");
			Date[] startDates = ParamUtil.getDateValues(uploadPortletRequest, "startDate", dateFormat);
			Date[] endDates = ParamUtil.getDateValues(uploadPortletRequest, "endDate", dateFormat);
			String startTimes=ParamUtil.getString(uploadPortletRequest, "startTimes");
			String endTimes=ParamUtil.getString(uploadPortletRequest, "endTimes");
			String[] leaveDays=ParamUtil.getParameterValues(uploadPortletRequest, "leaveDays");
			if(leaveDays==null||leaveDays.length<=0){
				leaveDays=new String[]{""};
			}
			//String[] startTimes=ParamUtil.getParameterValues(uploadPortletRequest, "startTime");
			//String[] endTimes=ParamUtil.getParameterValues(uploadPortletRequest, "endTime");
			String remark=ParamUtil.getString(uploadPortletRequest, "remark");
			long token=ParamUtil.getLong(uploadPortletRequest,"token");
			PortletSession session=request.getPortletSession();
			long tokenInSession=Long.parseLong(session.getAttribute("token")+"");
			response.setRenderParameter("eLeaveId",String.valueOf(eLeaveId));
			if(token==tokenInSession){
				boolean isCheckDateList=ELeaveInfoLocalServiceUtil.saveOrUpdateELeaveInfo(eLeaveId, typeOfLeave, startDates, endDates, startTimes.split(","), endTimes.split(","),leaveDays, remark);
				response.setRenderParameter("isCheckDateList",String.valueOf(isCheckDateList));
				session.setAttribute("token", System.currentTimeMillis());    
	        }
		}else if(cmd.equals(Constants.DELETE_TEMP)){
			long eLeaveInfoId=ParamUtil.getLong(uploadPortletRequest, "eLeaveInfoId",0);
			ELeaveInfo eLeaveInfo=ELeaveInfoLocalServiceUtil.fetchELeaveInfo(eLeaveInfoId);
			if(eLeaveInfo!=null){
				calcaulteDelEleaveDuration(eLeave,eLeaveInfo,serviceContext);
				ELeaveInfoLocalServiceUtil.deleteELeaveInfo(eLeaveInfoId);
			}
			response.setRenderParameter("eLeaveId",String.valueOf(eLeaveId));
		}else {
			ELeaveLocalServiceUtil.saveOrUpdateELeave(eLeave, serviceContext);
			sb.append("draft");
			log.info("The redirect url is :"+sb.toString());
			response.sendRedirect(sb.toString());
		}
	}
	
	/**
	 * when add a item of leave, need update the totalLeaveEntitlement, TotalDuration,remainingLeaveDaysBefore,RemainingLeaveDaysAfter
	 * @param uploadPortletRequest
	 * @param eLeave
	 * @return
	 */
	private ELeave calcaulteAddEleaveDuration(UploadPortletRequest uploadPortletRequest,ELeave eLeave){
		    String typeOfLeave=ParamUtil.getString(uploadPortletRequest, "typeOfLeave");
			String typeOfLeaveTxt=LanguageUtil.get(LocaleUtil.getDefault(), typeOfLeave);
		    String typeOfLeaveId=ELConstants.getTypeOfLeaveCode(typeOfLeaveTxt);
		    if(!"0100".equals(typeOfLeaveId)){
		    	return eLeave;
		    }
			String totalLeaveEntitlement = ParamUtil.getString(uploadPortletRequest, "totalLeaveEntitlement");
			String totalDuration = ParamUtil.getString(uploadPortletRequest, "totalDuration");
			String remainingLeaveDaysBefore = ParamUtil.getString(uploadPortletRequest, "remainingLeaveDaysBefore");
			String remainingLeaveDaysAfter = ParamUtil.getString(uploadPortletRequest, "remainingLeaveDaysAfter");
			eLeave.setTotalLeaveEntitlement(totalLeaveEntitlement);
			if(eLeave.getTotalDuration() == null || "".equals(eLeave.getTotalDuration())){
				eLeave.setTotalDuration(totalDuration);
			}else{
				if(totalDuration != null && "".equals(totalDuration.trim())){
					double curTotalDur = Double.valueOf(eLeave.getTotalDuration())+ Double.valueOf(totalDuration);
					eLeave.setTotalDuration(curTotalDur+"");
				}
			}
			
			if(eLeave.getRemainingLeaveDaysBefore() == null || "".equals(eLeave.getRemainingLeaveDaysBefore())){
				eLeave.setRemainingLeaveDaysBefore(remainingLeaveDaysBefore);
			}
			if(eLeave.getRemainingLeaveDaysAfter() == null || "".equals(eLeave.getRemainingLeaveDaysAfter())){
				eLeave.setRemainingLeaveDaysAfter(remainingLeaveDaysAfter);
			}else{
				
				if(eLeave.getTotalDuration() != null && "".equals(eLeave.getTotalDuration().trim())){
				   double rldb = Double.valueOf(eLeave.getRemainingLeaveDaysBefore())-Double.valueOf(eLeave.getTotalDuration());
					eLeave.setRemainingLeaveDaysAfter(""+rldb);
				}
			}
			System.out.println("************AddELeaveinfo********** totalLeaveEntitlement="+totalLeaveEntitlement + " "+ eLeave.getTotalLeaveEntitlement());
			System.out.println("************AddELeaveinfo********** totalDuration="+totalDuration+ " "+ eLeave.getTotalDuration());
			System.out.println("************AddELeaveinfo********** remainingLeaveDaysBefore="+remainingLeaveDaysBefore+ " "+ eLeave.getRemainingLeaveDaysBefore());
			System.out.println("************AddELeaveinfo********** remainingLeaveDaysAfter="+remainingLeaveDaysAfter+ " "+ eLeave.getRemainingLeaveDaysAfter());
		return eLeave;
	}
	
	/**
	 * when delete a item of leave, need update the  TotalDuration,RemainingLeaveDaysAfter
	 * @param uploadPortletRequest
	 * @param eLeave
	 * @return
	 */
	private ELeave calcaulteDelEleaveDuration(ELeave eLeave,ELeaveInfo eLeaveInfo,ServiceContext serviceContext) throws SystemException{
	    if(!"0100".equals(eLeaveInfo.getTypeOfLeaveId())){
	    	return eLeave;
	    }
        double delDuration = Double.valueOf(eLeaveInfo.getAbsenceDays());
        double totalDuration = Double.valueOf(eLeave.getTotalDuration());
        double remainingLeaveDaysAfter = Double.valueOf(eLeave.getRemainingLeaveDaysAfter());
        eLeave.setTotalDuration(String.valueOf(totalDuration-delDuration));
        eLeave.setRemainingLeaveDaysAfter(String.valueOf(remainingLeaveDaysAfter+delDuration));
		System.out.println("************delELeaveinfo********** totalLeaveEntitlement="+ eLeave.getTotalLeaveEntitlement());
		System.out.println("************delELeaveinfo********** totalDuration="+ eLeave.getTotalDuration());
		System.out.println("************delELeaveinfo********** remainingLeaveDaysBefore="+eLeave.getRemainingLeaveDaysBefore());
		System.out.println("************delELeaveinfo********** remainingLeaveDaysAfter="+ eLeave.getRemainingLeaveDaysAfter());
        ELeaveLocalServiceUtil.saveOrUpdateELeave(eLeave, serviceContext);
	    return eLeave;
   }
	
	
	
	//Download the attachments
	@SuppressWarnings("unchecked")
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		String cmd = ParamUtil.getString(resourceRequest, "cmd");	
		if("ajax".equals(cmd)){
			String eLeaveId = ParamUtil.getString(resourceRequest, "eLeaveId");	
			String staffCode = ParamUtil.getString(resourceRequest, "staffCode");	
			String typeOfLeave = ParamUtil.getString(resourceRequest, "typeOfLeave");
			String typeOfLeaveTxt=LanguageUtil.get(LocaleUtil.getDefault(), typeOfLeave);
			String typeOfLeaveId=ELConstants.getTypeOfLeaveCode(typeOfLeaveTxt);
			String startDates = ParamUtil.getString(resourceRequest, "startDates"); 
			String endDates = ParamUtil.getString(resourceRequest, "endDates");
			String startTimes = ParamUtil.getString(resourceRequest, "startTimes");
			String endTimes = ParamUtil.getString(resourceRequest, "endTimes");
			double totalLeaveEntitlement=0d;
			double tduration=0d;
			//change type to decimalformat			
			DecimalFormat df = new DecimalFormat("#.00");
			boolean isLeaveInfoExist=false;
			boolean isCheck=false;
			boolean isUnpaidLeave=false;
			boolean isLeaveDaysAfter=false;
			String msg="";
			double duration=0d;
			double leaveDaysBefor=0d;
			double leaveDaysAfter=0d;
			double annualLeaveTotalLeave=0d;
			double annualLeaveDuration=0d;
			List<String> durationList=new ArrayList<String>();
			if(!"9001".equals(typeOfLeaveId)&&!"9002".equals(typeOfLeaveId)&&!"9003".equals(typeOfLeaveId)&&!"9004".equals(typeOfLeaveId)){
				try {
					isLeaveInfoExist=ELeaveInfoLocalServiceUtil.isLeaveInfoExist(Long.valueOf(eLeaveId), typeOfLeave);
					if(!isLeaveInfoExist){
						List<AbsenceQuotaData> absenceQuotaDatas=AbsenceQuotaDataLocalServiceUtil.getAbsenceQuotaDataByStaffCode(staffCode);
						log.info("absenceQuotaDatas.size()= "+absenceQuotaDatas);
						if(absenceQuotaDatas!=null&&absenceQuotaDatas.size()>0){
							for(AbsenceQuotaData absenceQuotaData:absenceQuotaDatas){
								if(absenceQuotaData.getAbsenceQuotaTypeText()!=null&&!absenceQuotaData.getAbsenceQuotaTypeText().equals("")){
									log.info(" typeOfLeaveId = "+typeOfLeaveId);
									log.info("absenceQuotaData.TotalEntitlement= "+absenceQuotaData.getTotalEntitlement());
									log.info("absenceQuotaData.Deduction"+absenceQuotaData.getDeduction());
									log.info("AbsenceQuotaTypeText= "+absenceQuotaData.getAbsenceQuotaTypeText());
									if(this.getQuotaTypeCompare(typeOfLeaveId,absenceQuotaData.getAbsenceQuotaTypeText())){
										if(absenceQuotaData.getTotalEntitlement()!=null&&
												!absenceQuotaData.getTotalEntitlement().equals("")){
											totalLeaveEntitlement=Double.valueOf(absenceQuotaData.getTotalEntitlement());
										}
										if(absenceQuotaData.getDeduction()!=null&&
												!absenceQuotaData.getDeduction().equals("")){
											tduration=Double.valueOf(absenceQuotaData.getDeduction());
										}
										break;
									}else{
										if("0900".equals(typeOfLeaveId)&&this.getQuotaTypeCompare("0100",absenceQuotaData.getAbsenceQuotaTypeText())){
											if(absenceQuotaData.getTotalEntitlement()!=null&&
													!absenceQuotaData.getTotalEntitlement().equals("")){
												annualLeaveTotalLeave=Double.valueOf(absenceQuotaData.getTotalEntitlement());
												log.info("annualLeaveTotalLeave "+annualLeaveTotalLeave);
											}
											if(absenceQuotaData.getDeduction()!=null&&
													!absenceQuotaData.getDeduction().equals("")){
												annualLeaveDuration=Double.valueOf(absenceQuotaData.getDeduction());
												log.info("annualLeaveDuration "+annualLeaveDuration);
											}
											break;
										}
									}
									log.info(" end of 'for iterator' ");
								}
							}
						}
						List<Map<String,String>> paramList=new ArrayList<Map<String,String>>();
						for(int i=0;i<startDates.split(",").length;i++){
							Map<String,String> param=new HashMap<String,String>();
							param.put("staffCode", staffCode);
							param.put("typeOfLeave", typeOfLeaveId);
							param.put("startDate",startDates.split(",")[i]);
							param.put("endDate",endDates.split(",")[i]);
							param.put("startTime",startTimes.split(",")[i]);
							param.put("endTime",endTimes.split(",")[i]);
							paramList.add(param);
							System.out.println("startDate="+startDates.split(",")[i]);
							System.out.println("startTime="+startTimes.split(",")[i]);
							System.out.println("endDate="+endDates.split(",")[i]);
							System.out.println("endTime="+endTimes.split(",")[i]);
						}
						Map<String,Object> map=AbsenceQuotaDataLocalServiceUtil.checkLeaveData(paramList);
						if(map.containsKey("status")){
							log.info("status= "+map.get("status"));
							String status=String.valueOf(map.get("status"));
							if("Success".equals(status)){
								isCheck=true;
								msg="";
								duration=Double.valueOf(String.valueOf(map.get("duration")));
							}else if("Error".equals(status)){
								isCheck=false;
								msg=String.valueOf(map.get("msg"));
							}
							durationList=(List<String>)map.get("durationList");
							log.info("durationList= "+durationList);
						}
						if(isCheck){
							double totalEntitlement=totalLeaveEntitlement;
							double totalDuration=duration;
							double absenceDays1=ELeaveLocalServiceUtil.getSubmittedOrApprovedAbsenceDays(staffCode, typeOfLeaveId);
							double absenceDays2=ELeaveLocalServiceUtil.getCompletedOfCurrentDayAbsenceDays(staffCode, typeOfLeaveId);
							log.info("================================Check eleave data=====================");
							System.out.println("================================Check eleave data=====================");
							System.out.println("tduration= "+tduration);
							System.out.println("absenceDays1= "+absenceDays1);
							System.out.println("absenceDays2= "+absenceDays2);
							System.out.println("totalEntitlement= "+totalEntitlement);
						//JAVA-672
							leaveDaysBefor=totalEntitlement-tduration-absenceDays1-absenceDays2;
							BigDecimal bd2 = new BigDecimal(leaveDaysBefor);
							leaveDaysBefor = bd2.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
							
							leaveDaysAfter=leaveDaysBefor-totalDuration;
							bd2 = new BigDecimal(leaveDaysAfter);
							leaveDaysAfter = bd2.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
							
							isLeaveDaysAfter=leaveDaysAfter<0d?true:false;
							if("0900".equals(typeOfLeaveId)){
								double absenceDays3= 0;
								double absenceDays4 =0;
								absenceDays3=ELeaveLocalServiceUtil.getSubmittedOrApprovedAbsenceDays(staffCode, "0100");
								absenceDays4=ELeaveLocalServiceUtil.getCompletedOfCurrentDayAbsenceDays(staffCode,"0100");
								isUnpaidLeave=annualLeaveTotalLeave-annualLeaveDuration-absenceDays3-absenceDays4<=0d?true:false;
							}else{
								isUnpaidLeave=annualLeaveTotalLeave-annualLeaveDuration-absenceDays1-absenceDays2<=0d?true:false;
							}
							System.out.println("================================Check eleave data=======isUnpaidLeave==============="+isUnpaidLeave);
						}
					}
				} catch (SystemException e1) {
					e1.printStackTrace();
					throw new RuntimeException();
				} catch (PortalException e) {
					e.printStackTrace();
					throw new RuntimeException();
				} catch (ParseException e) {
					e.printStackTrace();
					throw new RuntimeException();    
				}
				if("0140".equals(typeOfLeaveId)||"0300".equals(typeOfLeaveId)||"0301".equals(typeOfLeaveId)||"0400".equals(typeOfLeaveId)||"0124".equals(typeOfLeaveId)){
					if(startDates.split(",").length==1&&startTimes.split(",").length==1&&endDates.split(",").length==1&&endTimes.split(",").length==1){
						SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
						String startDateStr=startDates.split(",")[0]+" "+startTimes.split(",")[0];
						System.out.println("0300 startDateStr="+startDateStr);
						String endDateStr=endDates.split(",")[0]+" "+endTimes.split(",")[0];	
						System.out.println("0300 endDateStr="+endDateStr);
						try {
							Date startDate=sdf.parse(startDateStr);
							System.out.println("0300 startDate="+startDate);
							Date endDate=sdf.parse(endDateStr);
							System.out.println("0300 endDate="+endDate);
							long m =endDate.getTime()-startDate.getTime();
							System.out.println("0300 m="+m);
							duration=Double.valueOf((m/86400000))+1d;
							System.out.println("0300 duration="+duration);
							durationList=new ArrayList<String>();
							durationList.add(String.valueOf(duration));
						} catch (ParseException e) {
							e.printStackTrace();
							throw new RuntimeException();
						}
					}
				}
			}else{
				isLeaveInfoExist=false;
				isCheck=true;
			}
			resourceResponse.setContentType("text/html");
			JSONObject jsonObj=null;
			try {
				jsonObj = JSONFactoryUtil.createJSONObject("");
			} catch (JSONException e) {
				e.printStackTrace();
			}
			jsonObj.put("isLeaveInfoExist",isLeaveInfoExist);
			jsonObj.put("totalLeaveEntitlement",totalLeaveEntitlement);	
			jsonObj.put("isCheck",true);
			jsonObj.put("isUnpaidLeave",isUnpaidLeave);
			jsonObj.put("isLeaveDaysAfter",isLeaveDaysAfter);
			jsonObj.put("msg",msg);
			jsonObj.put("duration",duration);
			//jsonObj.put("leaveDaysBefor",leaveDaysBefor);
			jsonObj.put("leaveDaysBefor",df.format(leaveDaysBefor));
			//jsonObj.put("leaveDaysAfter",leaveDaysAfter);
			jsonObj.put("leaveDaysAfter",df.format(leaveDaysAfter));
			jsonObj.put("leaveDaysBefor",leaveDaysBefor);
			jsonObj.put("leaveDaysAfter",leaveDaysAfter);
			jsonObj.put("typeOfLeaveId",typeOfLeaveId);
			jsonObj.put("typeOfLeave", typeOfLeave);
			JSONArray jsonArray=JSONFactoryUtil.createJSONArray();
			if(durationList!=null&&durationList.size()>0){
				for(String durationVal:durationList){
					jsonArray.put(durationVal);
				}
			}
			jsonObj.put("durationList", jsonArray);
			resourceResponse.getWriter().write(jsonObj.toString());
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
			super.serveResource(resourceRequest, resourceResponse);
		}
	}
	
	private boolean getQuotaTypeCompare(String typeOfLeaveId,String absenceQuotaTypeText){
		boolean isEquals=false;
		if("0100".equals(typeOfLeaveId)){
			if(absenceQuotaTypeText.toLowerCase().startsWith("annual leave")){
				isEquals=true;
			}
		}else if("0120".equals(typeOfLeaveId)||"0121".equals(typeOfLeaveId)){
			if(absenceQuotaTypeText.toLowerCase().startsWith("sick leave")){
				isEquals=true;
			}
		}else if("0124".equals(typeOfLeaveId)){
			if(absenceQuotaTypeText.toLowerCase().equals("service year award leave")){
				isEquals=true;
			}
		}
		return isEquals;
	}
	
	//save or update the attachments
	public void saveTheUploadAttachment(
			UploadPortletRequest uploadPortletRequest,
			ActionResponse actionResponse, long eLeaveId)
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
						ELeave.class.getName(), eLeaveId);
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
							0, ELeave.class.getName(),
							eLeaveId, 0, fileName, fileName,
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
			String cmd= ParamUtil.getString(actionRequest,Constants.CMD);
			if(!"applicantAgent".equals(cmd)){
			this.AddELeave(actionRequest, actionResponse);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		super.processAction(actionRequest, actionResponse);
	}
	
	//Get the applicant agent staffcode
	public void applicantAgent(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException, SystemException {
		boolean isApplicantAgent = ParamUtil.getBoolean(actionRequest, "isApplicantAgent",false);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user  = themeDisplay.getUser();
		long staffCode = user.getFacebookId();
		if(isApplicantAgent) {
			ApplicantDelegation applicantDelegation = ApplicantDelegationLocalServiceUtil.fetchByP_S(
					ApproverDelegationLocalServiceUtil.getProcessOfELeave(), String.valueOf(staffCode));
			staffCode = UserLocalServiceUtil.fetchUserById(applicantDelegation.getUserId()).getFacebookId();
		}		
		long eLeaveId = ParamUtil.getLong(actionRequest, "eLeaveId");
		actionResponse.setRenderParameter("staffCode", String.valueOf(staffCode));
		actionResponse.setRenderParameter("isApplicantAgent", String.valueOf(isApplicantAgent));
		actionResponse.setRenderParameter("eLeaveId", String.valueOf(eLeaveId));
		actionResponse.setRenderParameter("isClickAgent", "Yes");
	}
}
