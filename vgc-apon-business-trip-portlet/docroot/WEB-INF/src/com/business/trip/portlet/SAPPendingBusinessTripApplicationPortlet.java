package com.business.trip.portlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.business.trip.model.BtExchangeRate;
import com.business.trip.model.BusinessTripApplication;
import com.business.trip.service.BtExchangeRateLocalServiceUtil;
import com.business.trip.service.BusinessTripApplicationLocalServiceUtil;
import com.business.trip.util.BusinessTripConstants;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.vgc.apon.service.PendingToSAPLocalServiceUtil;

/**
 * Portlet implementation class SAPPendingBusinessTripApplicationPortlet
 */
public class SAPPendingBusinessTripApplicationPortlet extends MVCPortlet {

	private static Log log = LogFactoryUtil
			.getLog(SAPPendingBusinessTripApplicationPortlet.class);

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		String tabs2 = ParamUtil.getString(renderRequest, "tabs2");
		String ticketNo = ParamUtil.getString(renderRequest,"ticketNo");
		String applicant = ParamUtil.getString(renderRequest,"applicant");
		String startDate = ParamUtil.getString(renderRequest,"startDate");
		String endDate = ParamUtil.getString(renderRequest,"endDate");
		renderRequest.setAttribute("tabs2", tabs2);
		renderRequest.setAttribute("ticketNo", ticketNo);
		renderRequest.setAttribute("applicant", applicant);
		renderRequest.setAttribute("startDate", startDate);
		renderRequest.setAttribute("endDate", endDate);
		super.doView(renderRequest, renderResponse);
	}


	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		// TODO Auto-generated method stub
		System.out.println("############SAPPendingBusinessTripApplicationPortlet  start  ##### " );
		String cmd = ParamUtil.getString(resourceRequest, "cmd");
		String businessTripApplicationIds = ParamUtil.getString(resourceRequest,
				"businessTripApplicationIds");
		boolean flag=true;
		System.out.println("############SAPPendingBusinessTripApplicationPortlet  serveResource  ##### " );
		if (cmd.equals("pendingtosap")) {
			try {
				SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
				String[] ids=businessTripApplicationIds.split(",");
				ServiceContext serviceContext = ServiceContextFactory.getInstance(
				BusinessTripApplication.class.getName(), resourceRequest);
				BtExchangeRate btExchangeRate = BtExchangeRateLocalServiceUtil.fetchByF_S_S("RMB", "EUR", BusinessTripConstants.VALID_STATUS);
				//
				System.out.println("############SAPPendingBusinessTripApplicationPortlet  ids:  ##### "+ids.length);
				for(String businessTripApplicationId:ids){
					BusinessTripApplication tripApplication=BusinessTripApplicationLocalServiceUtil.fetchBusinessTripApplication(Long.parseLong(businessTripApplicationId));
					Map<String,Object> sap_map=new HashMap<String, Object>();
					sap_map.put("staffCode", tripApplication.getStaffCode());
					sap_map.put("ticketNo", tripApplication.getTicketNo());
					sap_map.put("currency", tripApplication.getCurrency());
					sap_map.put("amount", tripApplication.getAdvancePayment());
					sap_map.put("aponII_rate", btExchangeRate!=null?btExchangeRate.getFirToSecExchangeRate():0);
					String dates=sdf.format(tripApplication.getDepartureDate())+","+sdf.format(tripApplication.getReturnDate());
					String fourContent=tripApplication.getPrintName()+","+tripApplication.getVisitCountriesCities()+","+dates;
					sap_map.put("fourContent",fourContent);
					System.out.println("############SAPPendingBusinessTripApplicationPortlet  ticketNo:  ##### "+tripApplication.getTicketNo() );
					
					Map<String, Object>  rtn_params=PendingToSAPLocalServiceUtil.pendingToSAPBusinessTripApplication(sap_map);
					System.out.println("############SAPPendingBusinessTripApplicationPortlet  status:  ##### "+(rtn_params!=null?rtn_params.get("status"):"null") );
					if(null!=rtn_params.get("status")&&rtn_params.get("status").equals("S")){
						//成功
						List<Map<String, Object>>  params=new ArrayList<Map<String,Object>>();
						Map<String,Object> map=new HashMap<String, Object>();
						map.put("businessTripApplicationId",businessTripApplicationId);
						map.put("sapComments","");
						map.put("sapDocumentId",String.valueOf(rtn_params.get("message")));
						map.put("sapCertificateNo", String.valueOf(rtn_params.get("certificateNo")));
						map.put("sapCompany",String.valueOf(rtn_params.get("company")));
						map.put("sapYear", String.valueOf(rtn_params.get("year")));
						params.add(map);
						int sapStatus=1;
						BusinessTripApplicationLocalServiceUtil.updateSAPStatusAsSAPInfo(params, sapStatus, serviceContext);
					}else if(null!=rtn_params.get("status")&&rtn_params.get("status").equals("E")){
						//失败
						List<Map<String, Object>>  params=new ArrayList<Map<String,Object>>();
						Map<String,Object> map=new HashMap<String, Object>();
						map.put("businessTripApplicationId",businessTripApplicationId);
						map.put("sapComments",String.valueOf(rtn_params.get("message")));
						map.put("sapDocumentId","");
						params.add(map);
						int sapStatus=-1;
						BusinessTripApplicationLocalServiceUtil.updateSAPStatusAsSAPInfo(params, sapStatus, serviceContext);
					}
				}
				
				//


			} catch (PortalException e) {
				log.error(e.getMessage(), e);
				flag=false;
				throw new RuntimeException();
			} catch (SystemException e) {
				log.error(e.getMessage(), e);
				flag=false;
				throw new RuntimeException();
			}
			resourceResponse.setContentType("text/html");
			PrintWriter writer = resourceResponse.getWriter();
			try {
				writer.write(String.valueOf(flag));
			} finally{
				if(writer !=null){
					writer.flush();
					writer.close();
				}
			}
		}else if(cmd.equals("postedinsap")){
			try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					BusinessTripApplication.class.getName(), resourceRequest);
			List<Map<String, Object>>  params=new ArrayList<Map<String,Object>>();
			String[] ids=businessTripApplicationIds.split(",");
			for(String businessTripApplicationId:ids){
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("businessTripApplicationId", businessTripApplicationId);
			params.add(map);
			}
			int sapStatus=2;
			BusinessTripApplicationLocalServiceUtil.updateSAPStatusAsSAPInfo(params, sapStatus, serviceContext);
			} catch (PortalException e) {
				log.error(e.getMessage(), e);
				flag=false;
				throw new RuntimeException();
			} catch (SystemException e) {
				log.error(e.getMessage(), e);
				flag=false;
				throw new RuntimeException();
			}
			resourceResponse.setContentType("text/html");
			PrintWriter writer = resourceResponse.getWriter();
			try {
				writer.write(String.valueOf(flag));
			} finally{
				if(writer !=null){
					writer.flush();
					writer.close();
				}
			}
		}
		super.serveResource(resourceRequest, resourceResponse);
	}

	@Override
	public void processAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		super.processAction(actionRequest, actionResponse);
	}

	// Execute the query for the query condition
	public void queryBusinessTripApplication(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {
		String ticketNo = actionRequest.getParameter("ticketNo");
		String applicant = actionRequest.getParameter("applicant");
		String startDate = actionRequest.getParameter("startDate");
		String endDate = actionRequest.getParameter("endDate");
		String tabs2 = actionRequest.getParameter("tabs2");
		if (ticketNo != null && !"".equals(ticketNo)) {
			actionResponse.setRenderParameter("ticketNo", ticketNo);
		}
		if (applicant != null && !"".equals(applicant)) {
			actionResponse.setRenderParameter("applicant", applicant);
		}
		if (tabs2 != null && !"".equals(tabs2)) {
			actionResponse.setRenderParameter("tabs2", tabs2);
		}
		if (startDate != null && !"".equals(startDate)) {
			actionResponse.setRenderParameter("startDate", startDate);
		}
		if (endDate != null && !"".equals(endDate)) {
			actionResponse.setRenderParameter("endDate", endDate);
		}
		/*
		 * actionResponse.setRenderParameter("hello", "hello");
		 * actionResponse.setRenderParameter("mvcPath",
		 * "/html/sappendingbusinesstripapplication/view.jsp");
		 * PortalUtil.copyRequestParameters(actionRequest, actionResponse);
		 */
		// actionResponse.setRenderParameter("ticketNo", ticketNo);
		// sendRedirect(actionRequest, actionResponse);
	}
}
