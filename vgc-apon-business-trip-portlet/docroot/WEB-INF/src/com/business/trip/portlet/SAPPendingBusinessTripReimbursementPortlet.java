package com.business.trip.portlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
import com.business.trip.model.BtReimbursementSAPInfo;
import com.business.trip.model.BusinessTripApplication;
import com.business.trip.model.BusinessTripReimbursement;
import com.business.trip.service.BtCostListLocalServiceUtil;
import com.business.trip.service.BtExchangeRateLocalServiceUtil;
import com.business.trip.service.BtReimbursementSAPInfoLocalServiceUtil;
import com.business.trip.service.BtTravelExpenseLocalServiceUtil;
import com.business.trip.service.BusinessTripApplicationLocalServiceUtil;
import com.business.trip.service.BusinessTripReimbursementLocalServiceUtil;
import com.business.trip.util.BusinessTripConstants;
import com.liferay.counter.service.CounterLocalServiceUtil;
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
 * Portlet implementation class SAPPendingBusinessTripReimbursementPortlet
 */
public class SAPPendingBusinessTripReimbursementPortlet extends MVCPortlet {

	private static Log log = LogFactoryUtil
			.getLog(SAPPendingBusinessTripReimbursementPortlet.class);

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
       System.out.println("*******************SAPPendingBusinessTripReimbursementPortlet*****************start");
		String cmd = ParamUtil.getString(resourceRequest, "cmd");
		String businessTripReimbursementIds = ParamUtil.getString(
				resourceRequest, "businessTripReimbursementIds");
		boolean flag = true;
	    System.out.println("*******************SAPPendingBusinessTripReimbursementPortlet*****************cmd = "+cmd);
		if (cmd.equals("pendingtosap")) {
			try {
				// double
				// sum=BtTravelExpenseLocalServiceUtil.findSumByCurrency(219,
				// "RMB").get(0);
				// System.out.println("===================RMB TravelExpense"+sum);
				// RMB EUR
				 List<Map<String, Object>> params=new
				 ArrayList<Map<String,Object>>();      //閺囧瓨鏌� sap鏉╂柨娲栭崥搴ｆ畱閺佺増宓侀惃鍕Ц閹拷 閿涘奔淇婇幁顖ょ礉缁涘』ap鏉╂柨娲栭惃锟� sapStatus   閿涘apDocumentId閿涘apComments
				
				ServiceContext serviceContext = ServiceContextFactory.getInstance(
						BusinessTripReimbursement.class.getName(), resourceRequest);
				SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
				BtExchangeRate btExchangeRate = BtExchangeRateLocalServiceUtil.fetchByF_S_S("RMB", "EUR", BusinessTripConstants.VALID_STATUS);//閼惧嘲褰囧Ч鍥╁芳
				String[] ids = businessTripReimbursementIds.split(",");// 閼惧嘲褰�   businessTripReimbursementId閻ㄥ嫰娉﹂崥锟�
				 System.out.println("*******************SAPPendingBusinessTripReimbursementPortlet*****************ids length = "+ids.length);
				for (String businessTripReimbursementId : ids) {
					
					BusinessTripReimbursement businessTripReimbursement = BusinessTripReimbursementLocalServiceUtil
							.fetchBusinessTripReimbursement(Long
									.parseLong(businessTripReimbursementId)); //閼惧嘲褰�   娴肩姴鍙嗛惃鍒琩閻拷 BusinessTripReimbursement  鐎电钖�
					BusinessTripApplication businessTripApplication=BusinessTripApplicationLocalServiceUtil.fetchBusinessTripApplicationByTicketNo(businessTripReimbursement.getBussinessTirpTicketNo());
					//閼惧嘲褰囩�电懓绨查惃鍑歶sinessTripReimbursement閻拷 BusinessTripApplication
					Map<String,Object> sap_map=new HashMap<String, Object>();//閹绘劒姘﹂崚鐨奱p閺冨爼娓剁憰浣烘畱閸欏倹鏆� 閺�鎯ф躬鏉╂瑤閲渕ap鐎电钖勯柌锟�
					if(businessTripApplication!=null&&businessTripApplication.getAdvancePayment()>0d&&businessTripApplication.getSapStatus()>0&&businessTripApplication.getStatus()!=-1){//瑜版弮usinessTripApplication 娑撳秳璐熺粚鐑樻 楠炴湹绗栭悽瀹狀嚞濞嗗彞绗夋稉锟�0閻ㄥ嫭鍎忛崘鍏哥瑓  閹跺﹦鏁电拠宄板礋 pending sap 閹存劕濮涢崥搴ょ箲閸ョ偟娈戞穱鈩冧紖   娴肩姴鍙�  sap_map
						sap_map.put("businessTripApplicationSapCertificateNo", businessTripApplication.getSapCertificateNo());
						sap_map.put("businessTripApplicationSapCompany", businessTripApplication.getSapCompany());
						sap_map.put("businessTripApplicationSapYear", businessTripApplication.getSapYear());
					}else if((businessTripApplication!=null&&businessTripApplication.getAdvancePayment()<=0d) ||(businessTripApplication!=null&&businessTripApplication.getStatus()==-1)){ //閸欘垯浜掗惄瀛樺复 pending   BusinessTripReimbursement
						
					}else if(businessTripApplication!=null&&businessTripApplication.getAdvancePayment()>0d&&businessTripApplication.getSapStatus()<=0){
						//瑜版弮usinessTripApplication 娑撳秳璐熺粚鐑樻 楠炴湹绗栭悽瀹狀嚞濞嗗彞绗夋稉锟�0閻ㄥ嫭鍎忛崘鍏哥瑓 娴ｅ棙妲竍usinessTripApplication sapStatus鐏忓繋绨幋鏍拷鍛搼娴滐拷0 閻╁瓨甯存潻鏂挎礀闁挎瑨顕� 娑撳秷铔� pending sap
						 Map<String,Object> map=new HashMap<String, Object>();
							 map.put("businessTripReimbursementId",businessTripReimbursementId);
							 map.put("sapComments","Please pending BusinessTripApplication first");
							 map.put("sapStatus",-1);
							 params.add(map);
							 continue;
					}
					sap_map.put("staffCode", businessTripReimbursement.getStaffCode());
					sap_map.put("ticketNo", businessTripReimbursement.getBussinessTirpTicketNo());
					sap_map.put("currency", businessTripReimbursement.getCurrency());
					sap_map.put("amount", businessTripReimbursement.getAdvancePayment());
					sap_map.put("aponII_rate", btExchangeRate!=null?btExchangeRate.getFirToSecExchangeRate():0);
					String dates=sdf.format(businessTripReimbursement.getDepartureDate())+","+sdf.format(businessTripReimbursement.getReturnDate());
					String fourContent=businessTripReimbursement.getPrintName()+","+businessTripReimbursement.getVisitCountriesCities()+","+dates;
					sap_map.put("fourContent",fourContent);
					sap_map.put("costcenter", businessTripReimbursement.getCostCenter());
					sap_map.put("isPaybyRmb", businessTripReimbursement.getIsPaybyRmb());
					List<Map<String, String>> paramList_RMB = null;    // rmb  閹绘劒姘� 閸掞拷 sap閻ㄥ嫬寮弫锟�
					List<Map<String, String>> paramList_EUR = null;	   // eur  閹绘劒姘﹂崚鐨奱p閻ㄥ嫬寮弫锟�
					List<Map<String, String>> paramList_EUR_RMB = null;	 //Eur post to SAP in RMB
					if (businessTripReimbursement.getTripType() == 0) {// 閸ヨ棄鍞�
						//RMB costList
						 paramList_RMB = getItemsToSAP("RMB", businessTripReimbursementId,0);
					
						 paramList_EUR = getItemsToSAP("EUR", businessTripReimbursementId,0);
						 
						// travelExpense will be post to HR salary system.
					} else if (businessTripReimbursement.getTripType() == 1) {
						//RMB costList
						 paramList_RMB = getItemsToSAP("RMB", businessTripReimbursementId,1);
						 /**
						  * change the EUR to RMB then post to SAP
						  */
						 if(businessTripReimbursement.getIsPaybyRmb()){
							 
							 paramList_EUR_RMB = this.getItemsOfEURByRmbToSAP(businessTripReimbursementId, 1);
							 
							double travel_eur_sum_rmb = BtTravelExpenseLocalServiceUtil.findSumInRMBByCurrency(
											Long.parseLong(businessTripReimbursementId),"EUR");
							BigDecimal bd2 = new BigDecimal(travel_eur_sum_rmb);
							travel_eur_sum_rmb = bd2.setScale(2,
									BigDecimal.ROUND_HALF_UP).doubleValue();
							if (travel_eur_sum_rmb > 0d) {
								HashMap<String, String> travel_params_eur = new HashMap<String, String>();
								travel_params_eur.put("item", "9008402003");
								travel_params_eur.put("price",String.valueOf(travel_eur_sum_rmb));
								paramList_EUR_RMB.add(travel_params_eur);
							}
							paramList_RMB.addAll(paramList_EUR_RMB);
						 }else{
							paramList_EUR = getItemsToSAP("EUR",businessTripReimbursementId, 1);
							
							// RMB TravelExpense
//							double travel_rmb_sum = BtTravelExpenseLocalServiceUtil
//									.findSumByCurrency(
//											Long.parseLong(businessTripReimbursementId),
//											"RMB");
//							if(travel_rmb_sum>0d){
//							HashMap<String, String> travel_params_rmb = new HashMap<String, String>();
//							travel_params_rmb.put("item", "9008402003");
//							travel_params_rmb.put("price",
//									String.valueOf(travel_rmb_sum));
//							paramList_RMB.add(travel_params_rmb);
//							}
							// EUR TravelExpense
							
							double travel_eur_sum = BtTravelExpenseLocalServiceUtil.findSumByCurrency(Long.parseLong(businessTripReimbursementId),"EUR");
							BigDecimal bd2 = new BigDecimal(travel_eur_sum);
							travel_eur_sum = bd2.setScale(2,
									BigDecimal.ROUND_HALF_UP).doubleValue();
							if (travel_eur_sum > 0d) {
								HashMap<String, String> travel_params_eur = new HashMap<String, String>();
								travel_params_eur.put("item", "9008402003");
								travel_params_eur.put("price",String.valueOf(travel_eur_sum));
								paramList_EUR.add(travel_params_eur);
							}

			
						}
					}
					//閹绘劒姘﹂崚鐧滱P
					boolean sap_rmb=true;
					boolean sap_eur=true;
					String sapComments="";
					String sapDocumentId="";
					if(paramList_RMB!=null&&paramList_RMB.size()>0){
						System.out.println("=========================RMB-PENDING SAP");
						 if(businessTripReimbursement.getIsPaybyRmb()){
							 System.out.println("=========================EUR===changed to RMB -PENDING SAP");
						 }
						BtReimbursementSAPInfo btReimbursementSAPInfo=excuseSAPInterface("RMB", sap_map, paramList_RMB, businessTripReimbursement);
						if(btReimbursementSAPInfo.getStep()!=2){
							sap_rmb=false;
							if(sapComments.equals("")){
								sapComments+=btReimbursementSAPInfo.getMessage();
							}else{
							sapComments+=","+btReimbursementSAPInfo.getMessage();
							}
						}else{
							if(sapDocumentId.equals("")){
								sapDocumentId+=btReimbursementSAPInfo.getMessage();
							}else{
								sapDocumentId+=","+btReimbursementSAPInfo.getMessage();
							}
						}

					}
					if(paramList_EUR!=null&&paramList_EUR.size()>0){
						System.out.println("=========================EUR-PENDING SAP");
						BtReimbursementSAPInfo btReimbursementSAPInfo=excuseSAPInterface("EUR", sap_map, paramList_EUR, businessTripReimbursement);
						if(btReimbursementSAPInfo.getStep()!=2){
							sap_eur=false;
							if(sapComments.equals("")){
								sapComments+=btReimbursementSAPInfo.getMessage();
							}else{
							sapComments+=","+btReimbursementSAPInfo.getMessage();
							}
						}else{
							if(sapDocumentId.equals("")){
								sapDocumentId+=btReimbursementSAPInfo.getMessage();
							}else{
								sapDocumentId+=","+btReimbursementSAPInfo.getMessage();
							}
						}
					}
					 Map<String,Object> map=new HashMap<String, Object>();
					boolean sap_flag =sap_rmb&&sap_eur;
						int sapStatus=0;
						if(sap_flag){
							sapStatus=1;
						}else{
							sapStatus=-1;
						}
					 map.put("businessTripReimbursementId",businessTripReimbursementId);
					 map.put("sapComments",sapComments);
					 map.put("sapDocumentId",sapDocumentId);
					 map.put("sapStatus",sapStatus);
					 params.add(map);
					 
				}
				BusinessTripReimbursementLocalServiceUtil.updateSAPStatusAsSAPInfo(params,
						 serviceContext);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				flag=false;
				throw new RuntimeException();
			}catch (PortalException e) {
				// TODO: handle exception
				e.printStackTrace();
				flag=false;
				throw new RuntimeException();
			}catch (RuntimeException e) {
				flag=false;
				log.error(e.getMessage(),e);
				throw new RuntimeException();
			}
			resourceResponse.setContentType("text/html");
			PrintWriter writer = resourceResponse.getWriter();
			writer.write(String.valueOf(flag));
			writer.flush();
			writer.close();
		} else if (cmd.equals("postedinsap")) {
			try {
				ServiceContext serviceContext = ServiceContextFactory
						.getInstance(BusinessTripApplication.class.getName(),
								resourceRequest);
				List<Map<String, Object>> params = new ArrayList<Map<String, Object>>();
				String[] ids = businessTripReimbursementIds.split(",");
				for (String businessTripReimbursementId : ids) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("businessTripReimbursementId",businessTripReimbursementId);
					map.put("sapStatus",2);
					params.add(map);
				}
			 BusinessTripReimbursementLocalServiceUtil
						.updateSAPStatusAsSAPInfo(params,
								serviceContext);
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				flag = false;
				throw new RuntimeException();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				flag = false;
				throw new RuntimeException();
			}
			resourceResponse.setContentType("text/html");
			PrintWriter writer = resourceResponse.getWriter();
			writer.write(String.valueOf(flag));
			writer.flush();
			writer.close();
		}
		super.serveResource(resourceRequest, resourceResponse);
	}

	@Override
	public void processAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
//		String rate = ParamUtil.getString(actionRequest,
//				"rate", "No");
//		if("Yes".equals(rate)){
//			PendingToSAPLocalServiceUtil.synchroniseSAPRate();
//		}
		super.processAction(actionRequest, actionResponse);
	}

	// Execute the query for the query condition
	public void queryBusinessTripReimbursement(ActionRequest actionRequest,
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
	}

	private BtReimbursementSAPInfo excuseSAPInterface(String currency,Map<String, Object> sap_map,List<Map<String, String>> paramList,BusinessTripReimbursement businessTripReimbursement) throws SystemException{
		//String currency 閸欘垯浜掗崪锟�   sap_map闁插苯鍑＄紒蹇撶摠閸︺劎娈慶urrency 鏉╂稖顢戦崠褰掑帳 閻╁摜鐡戦崚娆愵劀鐢拷 閸氾箑鍨崣顏囩箲閸ユ咖鐏忚京鐣婚幋鎰
		System.out.println("*************************excuseSAPInterface***********************start");
		BtReimbursementSAPInfo  btReimbursementSAPInfo=BtReimbursementSAPInfoLocalServiceUtil.fetchByB_C(currency, businessTripReimbursement.getBusinessTripReimbursementId());
		System.out.println("*************************excuseSAPInterface***********************btReimbursementSAPInfo="+btReimbursementSAPInfo);
		if(btReimbursementSAPInfo!=null&&btReimbursementSAPInfo.getStep()==2){
			System.out.println("*************************excuseSAPInterface***********************return");
			return btReimbursementSAPInfo;
		}
		
		sap_map.put("otherCurrency", currency);
		
//		else if(btReimbursementSAPInfo!=null&&btReimbursementSAPInfo.getStep()==1){
//			sap_map.put("clear", "C");
//			sap_map.put("certificateNo", btReimbursementSAPInfo.getCertificateNo());
//			sap_map.put("company", btReimbursementSAPInfo.getCompany());
//			sap_map.put("year", btReimbursementSAPInfo.getYear());
//			//濞ｈ濮為崣鍌涙殶  闁匡拷鐠愶箑寮弫鐗堝潑閸旓拷
//		}
		System.out.println("*************************excuseSAPInterface***********************btReimbursementSAPInfo.getStep()="+(btReimbursementSAPInfo !=null?btReimbursementSAPInfo.getStep():""));
	Map<String, Object> returnMap=PendingToSAPLocalServiceUtil.pendingToSAPBusinessTripReimbursement(sap_map, paramList);
	if(btReimbursementSAPInfo==null){
		long btReimbursementSAPInfoId=CounterLocalServiceUtil.increment(BtReimbursementSAPInfo.class.getName(), 1);
		btReimbursementSAPInfo=BtReimbursementSAPInfoLocalServiceUtil.createBtReimbursementSAPInfo(btReimbursementSAPInfoId);
		btReimbursementSAPInfo.setCreateDate(new Date());
	}else{
		btReimbursementSAPInfo.setModifiedDate(new Date());
	}
	int step=0;
	System.out.println("*************************excuseSAPInterface***********************returnMap.status="+(returnMap!=null?(String) returnMap.get("status"):"null"));
	String cers="";
	if(returnMap != null){
		String messageType=(String) returnMap.get("status");
		//String clear=(String) returnMap.get("clear");
		if(messageType!=null&&messageType.equalsIgnoreCase("S")){
			step=2;
		}else if(messageType!=null&&messageType.equalsIgnoreCase("E")){
//		if(clear!=null&&clear.equalsIgnoreCase("X")){
//			step=1;
//		}else{
			step=0;
			//	}
		}
		btReimbursementSAPInfo.setMessageType(messageType);//閺嶈宓侀幒銉ュ經鏉╂柨娲栭崐闂存叏閺�锟�
		
		if(currency.equals(sap_map.get("currency"))){
			cers=(String) returnMap.get("certificateNo_a")+","+(String) returnMap.get("certificateNo");
		}else{
			cers=(String) returnMap.get("certificateNo");
		}
		btReimbursementSAPInfo.setMessage((String) returnMap.get("message"));//閺嶈宓侀幒銉ュ經鏉╂柨娲栭崐闂存叏閺�锟�
		btReimbursementSAPInfo.setCompany((String) returnMap.get("company"));//閸忣剙寰冩禒锝囩垳
		btReimbursementSAPInfo.setYear((String) returnMap.get("year"));//鐠佸墽鐤嗛獮鏉戝
	}
	btReimbursementSAPInfo.setStep(step);//閺嶈宓侀幒銉ュ經鏉╂柨娲栭崐闂存叏閺�锟� 0  1  2   2 娑撶儤鍨氶崝锟�
	btReimbursementSAPInfo.setCertificateNo(cers);//閸戭叀鐦夐崣锟�
	btReimbursementSAPInfo.setBusinessTripPkId(businessTripReimbursement.getBusinessTripReimbursementId());
	btReimbursementSAPInfo.setCurrency(currency);
	btReimbursementSAPInfo.setTicketNo(businessTripReimbursement.getTicketNo());

	return BtReimbursementSAPInfoLocalServiceUtil.saveOrUpdateBtReimbursementSAPInfo(btReimbursementSAPInfo);
	}
	
	private List<Map<String, String>> getItemsToSAP(String currency,
			String businessTripReimbursementId, int triptype)
			throws NumberFormatException, SystemException {
		List<Map<String, String>> items = new ArrayList<Map<String, String>>();
		Map<String, String> airMap= getItemAsSAP( currency,businessTripReimbursementId,new String[]{"Air ticket(If not booked by HRG)"}, triptype);
		if(airMap!=null){
			items.add(airMap);
		}
		Map<String, String> taxMap= getItemAsSAP( currency,businessTripReimbursementId,new String[]{"Taxi/Bus/Subway"}, triptype);
		if(taxMap!=null){
			items.add(taxMap);
		}
		Map<String, String> accMap= getItemAsSAP( currency,businessTripReimbursementId,new String[]{"Accommodation-Domestic","Accommodation-International"}, triptype);
		if(accMap!=null){
			items.add(accMap);
		}
		Map<String, String> entMap= getItemAsSAP( currency,businessTripReimbursementId,new String[]{"Entertainment"}, triptype);
		if(entMap!=null){
			items.add(entMap);
		}
		Map<String, String> othersMap= getItemAsSAP( currency,businessTripReimbursementId,new String[]{"Fuel/Oil/CarWash", "Car Maintenance","Parking/Garage", "Railway/Ferry", "Rented Car",
				"Telephone", "Laundry", "Gifts", "Bank Fees",
				"Currency Loss", "Others"}, triptype);
		if(othersMap!=null){
			items.add(othersMap);
		}
		return items;
	}
	
	
	private List<Map<String, String>> getItemsOfEURByRmbToSAP(String businessTripReimbursementId, int triptype)
			throws NumberFormatException, SystemException {
		List<Map<String, String>> items = new ArrayList<Map<String, String>>();
		Map<String, String> airMap= getItemEURToRMBAsSAP( "EUR",businessTripReimbursementId,new String[]{"Air ticket(If not booked by HRG)"}, triptype);
		if(airMap!=null){
			items.add(airMap);
		}
		Map<String, String> taxMap= getItemEURToRMBAsSAP( "EUR",businessTripReimbursementId,new String[]{"Taxi/Bus/Subway"}, triptype);
		if(taxMap!=null){
			items.add(taxMap);
		}
		Map<String, String> accMap= getItemEURToRMBAsSAP( "EUR",businessTripReimbursementId,new String[]{"Accommodation-Domestic","Accommodation-International"}, triptype);
		if(accMap!=null){
			items.add(accMap);
		}
		Map<String, String> entMap= getItemEURToRMBAsSAP( "EUR",businessTripReimbursementId,new String[]{"Entertainment"}, triptype);
		if(entMap!=null){
			items.add(entMap);
		}
		Map<String, String> othersMap= getItemEURToRMBAsSAP( "EUR",businessTripReimbursementId,new String[]{"Fuel/Oil/CarWash", "Car Maintenance","Parking/Garage", "Railway/Ferry", "Rented Car",
				"Telephone", "Laundry", "Gifts", "Bank Fees",
				"Currency Loss", "Others"}, triptype);
		if(othersMap!=null){
			items.add(othersMap);
		}
		return items;
	}
	
	private Map<String, String> setCostItemCode(Map<String, String> item,String[] liststring,int triptype){
			if(liststring != null && liststring.length >0){
				if (liststring[0].equalsIgnoreCase("Air ticket(If not booked by HRG)")) {
					if (triptype == 0) {// 閸ヨ棄鍞�
						item.put("item", "9008401001");
					} else if (triptype == 1) {
						item.put("item", "9008402001");
					}
				} else if (liststring[0].equalsIgnoreCase("Taxi/Bus/Subway")) {
					if (triptype == 0) {// 閸ヨ棄鍞�
						item.put("item", "9008401002");
					} else if (triptype == 1) {
						item.put("item", "9008402002");
					}
				
				} else if (liststring[0].equalsIgnoreCase("Accommodation-Domestic")||liststring[0].equalsIgnoreCase("Accommodation-International")) {
					if (triptype == 0) {// 閸ヨ棄鍞�
						item.put("item", "9008401005");
					} else if (triptype == 1) {
						item.put("item", "9008402005");
					}
				
				} else if (liststring[0].equalsIgnoreCase("Entertainment")) {
					if (triptype == 0) {// 閸ヨ棄鍞�
						item.put("item", "9008401004");
					} else if (triptype == 1) {
						item.put("item", "9008402004");
					}
				} else if (liststring.length == 11) {
					if (triptype == 0) {// 閸ヨ棄鍞�
						item.put("item", "9008401006");
					} else if (triptype == 1) {
						item.put("item", "9008402006");
					}
				}
		}
			return item;
	}
	
	private Map<String, String> getItemEURToRMBAsSAP(
			 String currency,String businessTripReimbursementId,
			String[] liststring, int triptype) throws NumberFormatException,
			SystemException {
		Map<String, String> item = new HashMap<String, String>();
		List<String> paramItems = null;
		if(liststring != null){
			paramItems = Arrays.asList(liststring);
		}
		double itemdouble = BtCostListLocalServiceUtil.findSumNetAmountRmbByCurrency(
				Long.parseLong(businessTripReimbursementId), currency,paramItems);
		BigDecimal bd = new BigDecimal(itemdouble);  
		itemdouble=bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue(); //閸ユ稖鍨楁禍鏂垮弳  娣団晙缍呯亸蹇旀殶 娴肩姴鍩宻ap
		
		if(itemdouble>0d){
			item = setCostItemCode(item, liststring, triptype);
			item.put("price", String.valueOf(itemdouble));
			/**
			 * EUR no TAX
			 */
			item.put("taxprice", "0");
			return item;
		}else{
			return null;
		}
}

	
	private Map<String, String> getItemAsSAP(
			 String currency,String businessTripReimbursementId,
			String[] liststring, int triptype) throws NumberFormatException,
			SystemException {
		Map<String, String> item = new HashMap<String, String>();
		double itemdouble =0;
		double itemtaxdouble =0;
		if (liststring != null && liststring[0].equalsIgnoreCase("Entertainment")){
			itemdouble = BtCostListLocalServiceUtil.findSumEntertainmentByCurrency(
					Long.parseLong(businessTripReimbursementId), currency,
					Arrays.asList(liststring));
			BigDecimal bd = new BigDecimal(itemdouble);  
			itemdouble=bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue(); //閸ユ稖鍨楁禍鏂垮弳  娣団晙缍呯亸蹇旀殶 娴肩姴鍩宻ap
		}else{
			itemdouble = BtCostListLocalServiceUtil.findSumByCurrency(
					Long.parseLong(businessTripReimbursementId), currency,
					liststring != null?Arrays.asList(liststring):null);
			BigDecimal bd = new BigDecimal(itemdouble);  
			itemdouble=bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue(); //閸ユ稖鍨楁禍鏂垮弳  娣団晙缍呯亸蹇旀殶 娴肩姴鍩宻ap
			
			itemtaxdouble = BtCostListLocalServiceUtil.findSumTaxByCurrency(
					Long.parseLong(businessTripReimbursementId), currency,
					liststring != null?Arrays.asList(liststring):null);
			BigDecimal bd2 = new BigDecimal(itemtaxdouble);  
			itemtaxdouble=bd2.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue(); //閸ユ稖鍨楁禍鏂垮弳  娣団晙缍呯亸蹇旀殶 娴肩姴鍩宻ap
		}
		if(itemdouble>0d){
			item = setCostItemCode(item, liststring, triptype);
			item.put("price", String.valueOf(itemdouble));
			item.put("taxprice", String.valueOf(itemtaxdouble));
			return item;
		}else{
			return null;
		}
	}
}
