package com.business.trip.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.business.trip.model.BusinessTripApplication;
import com.business.trip.service.BusinessTripApplicationLocalServiceUtil;
import com.delegation.service.ApplicantDelegationLocalServiceUtil;
import com.delegation.service.ApproverDelegationLocalServiceUtil;
import com.global.management.service.GlobalEmailLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowTask;
import com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.model.WorkflowInstanceLink;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.WorkflowInstanceLinkLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

public class AutoCloseMessageListener implements MessageListener {

	@Override
	public void receive(Message message) throws MessageListenerException {
		try {
			this.autoClose();
		} catch (SystemException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (NumberFormatException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (PortalException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}	
	}
	
	//Auto close the businessTripApplication
	public void autoClose() throws SystemException, PortalException{
		List<BusinessTripApplication> list = BusinessTripApplicationLocalServiceUtil.findByStatus(104);
		List<WorkflowTask> workflowTasks = WorkflowTaskManagerUtil.getWorkflowTasks(PortalUtil.getDefaultCompanyId(), false, -1, -1, null);	
		List<WorkflowTask> result = new ArrayList<WorkflowTask>();
		for(WorkflowTask wt:workflowTasks) {
			if("applicant".equalsIgnoreCase(wt.getName())) {
				result.add(wt);
			}
		}
		Date now = new Date();
		for(BusinessTripApplication businessTripApplication:list) {
			Date departureDate = businessTripApplication.getDepartureDate();
			int days = (int) ((departureDate.getTime()-now.getTime())/1000/60/60/24);
			String currency = businessTripApplication.getCurrency();
			if(businessTripApplication.getAdvancePayment()==0 && ("RMB".equals(currency) && days<3 || "EUR".equals(currency) && days<7 )) {
				this.close(businessTripApplication,result);
			}
		}
	}
	
	private void close(BusinessTripApplication businessTripApplication,List<WorkflowTask> workflowTasks) throws PortalException, SystemException {
		long companyId = PortalUtil.getDefaultCompanyId();
		long businessTripApplicationId = businessTripApplication.getBusinessTripApplicationId();
		WorkflowInstanceLink w = WorkflowInstanceLinkLocalServiceUtil.fetchWorkflowInstanceLink(companyId,
						businessTripApplication.getGroupId(),
						BusinessTripApplication.class.getName(),
						businessTripApplicationId);		
		for(WorkflowTask wt:workflowTasks) {
			if(w!=null && w.getWorkflowInstanceId()==wt.getWorkflowInstanceId()) {
				Map<String, Serializable>	workflowContext = new HashMap<String, Serializable>();
				ServiceContext serviceContext =  new ServiceContext();
				serviceContext.setAttribute("vgcapon_btApplication_isNeedCashAdvance", "No");//vgcapon_btApplication_isNeedCashAdvance
				workflowContext.put(WorkflowConstants.CONTEXT_SERVICE_CONTEXT, serviceContext);
				WorkflowTaskManagerUtil.completeWorkflowTask(
						companyId, UserLocalServiceUtil.getDefaultUserId(companyId),
						wt.getWorkflowTaskId(), "approve", "", workflowContext);
				BusinessTripApplicationLocalServiceUtil.saveOrUpdateAuditTrailLog(businessTripApplication.getCompanyId(),
						businessTripApplication.getGroupId(), businessTripApplication.getBusinessTripApplicationId(), 
						businessTripApplication.getUserId(), businessTripApplication.getUserName(), ActionConstants.COMPLETE, "Auto Completed");
				this.sendEmailToApplicant(businessTripApplication);
				break;
			}
		}
	}
	
	private void sendEmailToApplicant(BusinessTripApplication businessTripApplication) throws PortalException, SystemException {
		User applicant = UserLocalServiceUtil.fetchUserById(businessTripApplication.getUserId());
		String[] toAddresses = new String[]{applicant.getEmailAddress()};	
		if(businessTripApplication.getIsApplicantAgent()) {
			toAddresses = ApplicantDelegationLocalServiceUtil.findEmailsByP_U(ApproverDelegationLocalServiceUtil.getProcessOfCompanyCarApplication(), applicant);
		}		
		String cssContent = BusinessTripApplicationLocalServiceUtil.getCssContent();
		String subject = "Business Trip Application-"+businessTripApplication.getTicketNo()+"-Cash Advance";
		StringBuffer mailbody = new StringBuffer();	
		mailbody.append("<div class='emailTmp'>")
				.append("<p>Dear Applicant, </p>")
				.append("<p>Based on travel expense advance policy, you can only apply cash advance 3 days in advance for RMB or 7 days in advance for EUR.</p>")
				.append("<p>As it's due date now, cash advance application won't be supported. Please view the detail information in <a href='")
				.append(PropsUtil.get("vgc.apon.system.href.url")).append("'>APON System</a>.</p>")
				.append("<p>PLEASE DO NOT REPLY to this email, as it is system generated.</p>")
				.append("</div>");		
		GlobalEmailLocalServiceUtil.sendEmail(toAddresses, null, subject, cssContent, mailbody.toString(), null);
	}
}
