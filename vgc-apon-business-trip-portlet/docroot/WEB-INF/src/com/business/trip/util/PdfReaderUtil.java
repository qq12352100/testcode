package com.business.trip.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import com.business.trip.model.BtFlightTrainInfo;
import com.business.trip.service.BtFlightTrainInfoLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;

public class PdfReaderUtil {
	// gain the pdfInfo
	/**
	 * @author hai.a.wang  
	 * 国际pdf 导入 修复
	 */
	@SuppressWarnings("deprecation")
	public static Map<String, Object> getPdfInfo(InputStream inputStream,
			long businessTripPkId, String tripType) {
		boolean status = false;
		String errMsg = "";

		// total map
		Map<String, Object> map = new HashMap<String, Object>();

		try {
			String huanhang=System.getProperty("line.separator");
			// put in the fareDetails
			Map<String, String> fareDetails = new HashMap<String, String>();
			// put in the flight
			Map<String, Object> flight = new HashMap<String, Object>();

			String pdfInfo = PdfReaderUtil.getTextFromPDF(inputStream);
			String end1=":";
			String end2="：";
			// for sub Currency to Total
			String cur = "Currency";
			String af="Air Fare";
			String ts = "Taxes";
			String tf = "Transaction Fee";
			String tt="Total";

			// for sub Flight
			String fli = "Flight:";
			String dis = "Discount.";
			String dep = "Departing:";
			String dat = "Date/Time:";
			String arr = "Arriving:";
			String cab = "Cabin Class:";
			String bag = "Baggage Allowance:";

			if(pdfInfo.indexOf(cur+end1)!=-1){
				cur+=end1;
				af+=end1;
				ts+=end1;
				tf+=end1;
				tt+=end1;
			}
			
			if(pdfInfo.indexOf(cur+end2)!=-1){
				cur+=end2;
				af+=end2;
				ts+=end2;
				tf+=end2;
				tt+=end2;
			}
			
			// for one
			int curi= pdfInfo.indexOf(cur);
			int afi = pdfInfo.indexOf(af);
			int tsi= pdfInfo.indexOf(ts);
			int tfi = pdfInfo.indexOf(tf);
			int tti = pdfInfo.indexOf(tt);
			
			// for one
			int fl = pdfInfo.indexOf(fli);
			int d = pdfInfo.lastIndexOf(bag);
			
			String pos = pdfInfo.substring(fl, d);

			// sub Currency
			String curency = pdfInfo.substring(curi, afi).trim().replace(huanhang,"");
			curency=curency.substring(9,curency.length());
			// [1]is air,[2]is fare:43813
			String airFare =pdfInfo.substring(afi, tsi).trim().replace(huanhang,"");
			airFare=airFare.substring(9,airFare.length());
			// taxes
			String taxes = pdfInfo.substring(tsi, tfi).trim().replace(huanhang,"");
			taxes=taxes.substring(6,taxes.length());
			// [4]is Transaction [5]is Fee:511
			String transactionFee =  pdfInfo.substring(tfi, tti).trim().replace(huanhang,"");
			transactionFee=transactionFee.substring(16,transactionFee.length());
			
			String tmp=pdfInfo.substring(tti,pdfInfo.length());
			// Total
			String total =tmp.substring(6, tmp.indexOf(huanhang)).trim().replace(huanhang,"");
			// put in the curency
			fareDetails.put("curency", curency);
			// put in the airFare
			fareDetails.put("airFare", airFare);
			// put in the taxes
			fareDetails.put("taxes", taxes);
			// put in the transactionFee
			fareDetails.put("transactionFee", transactionFee);
			// put in the total
			fareDetails.put("total", total);
			// ----------------------sub complete------------------------------
			int newD = pos.lastIndexOf(dis) + 10;
			int i = 0;
			// put in the flightList
			List<BtFlightTrainInfo> flightList = new ArrayList<BtFlightTrainInfo>();
			// while xunhuan
			while (i < newD) {
				// gain object for BtFlightTrainInfo
				long pkId = CounterLocalServiceUtil.increment(
						BtFlightTrainInfo.class.getName(), 1);
				BtFlightTrainInfo btFlightTrainInfo = BtFlightTrainInfoLocalServiceUtil
						.createBtFlightTrainInfo(pkId);

				String fliString = pos.substring(i, newD);
				// Flight
				int intfli = fliString.indexOf(fli);
				// Departing
				int intdep = fliString.indexOf(dep);
				// Date/Time(first)
				int intdat = fliString.indexOf(dat);
				// Arriving
				int intarr = fliString.indexOf(arr);
				// Cabin Class
				int intcab = fliString.indexOf(cab);
				// discount(for test)
				int intdis = fliString.indexOf(dis);

				if (intfli != -1) {
					// gain FightNumber
					String flitoString = fliString.substring(intfli);// -162?
					String[] fliArrays = flitoString.trim().split(" +");// kongge

					String flightNumberTemp=fliArrays[0].trim().substring(7);
					if(flightNumberTemp.indexOf(huanhang)!=-1){
						flightNumberTemp=flightNumberTemp.substring(0,flightNumberTemp.indexOf(huanhang));
					}
					String flightNumber = flightNumberTemp.trim();

					// gain Departing, From for flightTranInfo
					String deptoString = fliString.substring(intdep);
					String[] depArrays = deptoString.trim().split(huanhang);// huan
																		// hang
																		// fen
																		// ge
					String depart = depArrays[0].trim().substring(10);// : to ?
					String departing = depart.substring(0, depart.indexOf(",")).trim();

					// gain Date/Time
					String dattoString = fliString.substring(intdat);
					String[] datArrays = dattoString.trim().split(huanhang);// huan
																		// hang
																		// fen
																		// ge
					String dT = datArrays[0].trim().substring(10);
					Date date = new Date(dT);
					SimpleDateFormat sdf = new SimpleDateFormat(
							"dd.MM.yyyy HH:mm");
					Date dateTime = sdf.parse(sdf.format(date));

					// gain Arriving, To for flightTranInfo
					String arrtoString = fliString.substring(intarr);
					String[] arrArrays = arrtoString.trim().split(huanhang);
					String arriv = arrArrays[0].trim().substring(9);
					String arriving = arriv.substring(0, arriv.indexOf(","));

					// gain Cabin Class
					String cabtoString = fliString.substring(intcab);
					String[] cabArrays = cabtoString.trim().split(huanhang);
					String cabinClass = cabArrays[0].trim().substring(12);

					// set vo
					// set Departure Flight
					btFlightTrainInfo.setDepartureFlight(flightNumber);
					// set From
					btFlightTrainInfo.setFromCity(departing);
					// set date xuyao format
					btFlightTrainInfo.setDepartureDate(dateTime);
					// set To
					btFlightTrainInfo.setToCity(arriving);
					// set Class
					btFlightTrainInfo.setClassInfo(cabinClass);
					// set businessTripPkId
					btFlightTrainInfo.setBusinessTripPkId(businessTripPkId);
					// set tripType
					btFlightTrainInfo.setTripType(tripType);

					// add the list<BtFlightTrainInfo>
					flightList.add(btFlightTrainInfo);
				} else {

					break;
				}
				i = i + 1 + intdis;
			}
			//
//			if(pdfInfo.contains("Itinerary Summary")){
//				String[] strarr=pdfInfo.split("Itinerary Summary")[0].split(huanhang);
//				for(int j=0;j<flightList.size();j++){
//					//String str=strarr[strarr.length-flightList.size()+j];正
//					String str=strarr[strarr.length-j-1];//反
//					flightList.get(j).setClassInfo(str);
//				}
//			}
			//
			status = true;
			// put in the fareDetails
			flight.put("fareDetails", fareDetails);
			// put in the flightList
			flight.put("flightList", flightList);

			// put flight in the map
			map.put("flight", flight);
			// put in the status
			map.put("status", status);
			// put in the errMsg
			map.put("errMsg", "");
		} catch (Exception e) {
			e.printStackTrace();
			status = false;
			errMsg = e.getMessage();
			// put in the Status
			map.put("status", status);
			map.put("errMsg", errMsg);
		}
		return map;
	}
	/**
	 * @author hai.a.wang  
	 * 国内pdf 导入 修复
	 */
	// gain the pdfInfo
		@SuppressWarnings("deprecation")
		public static Map<String, Object> getDemosticPdfInfo(InputStream inputStream,
				long businessTripPkId, String tripType) {
			boolean status = false;
			String errMsg = "";

			// total map
			Map<String, Object> map = new HashMap<String, Object>();

			try {
				String huanhang=System.getProperty("line.separator");
				// put in the fareDetails
				Map<String, String> fareDetails = new HashMap<String, String>();
				// put in the flight
				Map<String, Object> flight = new HashMap<String, Object>();

				String pdfInfo = PdfReaderUtil.getTextFromPDF(inputStream);
				String end1=":";
				String end2="：";
				// for sub Currency to Total
				String cur = "Currency";
				String af="Air Fare";
				String ts = "Taxes";
				String tf = "Transaction Fee";
				String tt="Total";

				// for sub Flight
				String fli = "Flight:";
				String dis = "Discount.";
				String dep = "Departing:";
				String dat = "Date/Time:";
				String arr = "Arriving:";
				String cab = "Cabin Class:";
				String bag = "Baggage Allowance:";

				if(pdfInfo.indexOf(cur+end1)!=-1){
					cur+=end1;
					af+=end1;
					ts+=end1;
					tf+=end1;
					tt+=end1;
				}
				
				if(pdfInfo.indexOf(cur+end2)!=-1){
					cur+=end2;
					af+=end2;
					ts+=end2;
					tf+=end2;
					tt+=end2;
				}
				
				// for one
				int curi= pdfInfo.indexOf(cur);
				int afi = pdfInfo.indexOf(af);
				int tsi= pdfInfo.indexOf(ts);
				int tfi = pdfInfo.indexOf(tf);
				int tti = pdfInfo.indexOf(tt);
				
				// for one
				int fl = pdfInfo.indexOf(fli);
				int d = pdfInfo.lastIndexOf(bag);
				
				String pos = pdfInfo.substring(fl, d);

				// sub Currency
				String curency = pdfInfo.substring(curi, afi).trim().replace(huanhang,"");
				curency=curency.substring(9,curency.length());
				// [1]is air,[2]is fare:43813
				String airFare =pdfInfo.substring(afi, tsi).trim().replace(huanhang,"");
				airFare=airFare.substring(9,airFare.length());
				// taxes
				String taxes = pdfInfo.substring(tsi, tfi).trim().replace(huanhang,"");
				taxes=taxes.substring(6,taxes.length());
				// [4]is Transaction [5]is Fee:511
				String transactionFee =  pdfInfo.substring(tfi, tti).trim().replace(huanhang,"");
				transactionFee=transactionFee.substring(16,transactionFee.length());
				
				String tmp=pdfInfo.substring(tti,pdfInfo.length());
				// Total
				String total =tmp.substring(6, tmp.indexOf(huanhang)).trim().replace(huanhang,"");
				// put in the curency
				fareDetails.put("curency", curency);
				// put in the airFare
				fareDetails.put("airFare", airFare);
				// put in the taxes
				fareDetails.put("taxes", taxes);
				// put in the transactionFee
				fareDetails.put("transactionFee", transactionFee);
				// put in the total
				fareDetails.put("total", total);
				// ----------------------sub complete------------------------------
				int newD = pos.lastIndexOf(dis) + 10;
				int i = 0;
				// put in the flightList
				List<BtFlightTrainInfo> flightList = new ArrayList<BtFlightTrainInfo>();
				// while xunhuan
				while (i < newD) {
					// gain object for BtFlightTrainInfo
					long pkId = CounterLocalServiceUtil.increment(
							BtFlightTrainInfo.class.getName(), 1);
					BtFlightTrainInfo btFlightTrainInfo = BtFlightTrainInfoLocalServiceUtil
							.createBtFlightTrainInfo(pkId);

					String fliString = pos.substring(i, newD);
					// Flight
					int intfli = fliString.indexOf(fli);
					// Departing
					int intdep = fliString.indexOf(dep);
					// Date/Time(first)
					int intdat = fliString.indexOf(dat);
					// Arriving
					int intarr = fliString.indexOf(arr);
					// Cabin Class
					int intcab = fliString.indexOf(cab);
					// discount(for test)
					int intdis = fliString.indexOf(dis);

					if (intfli != -1) {
						// gain FightNumber
						String flitoString = fliString.substring(intfli);// -162?
						String[] fliArrays = flitoString.trim().split(" +");// kongge

						String flightNumberTemp=fliArrays[0].trim().substring(7);
						if(flightNumberTemp.indexOf(huanhang)!=-1){
							flightNumberTemp=flightNumberTemp.substring(0,flightNumberTemp.indexOf(huanhang));
						}
						String flightNumber = flightNumberTemp.trim();

						// gain Departing, From for flightTranInfo
						String deptoString = fliString.substring(intdep);
						String[] depArrays = deptoString.trim().split(huanhang);// huan
																			// hang
																			// fen
																			// ge
						String depart = depArrays[0].trim().substring(10);// : to ?
						String departing = depart.substring(0, depart.indexOf(",")).trim();

						// gain Date/Time
						String dattoString = fliString.substring(intdat);
						String[] datArrays = dattoString.trim().split(huanhang);// huan
																			// hang
																			// fen
																			// ge
						String dT = datArrays[0].trim().substring(10);
						Date date = new Date(dT);
						SimpleDateFormat sdf = new SimpleDateFormat(
								"dd.MM.yyyy HH:mm");
						Date dateTime = sdf.parse(sdf.format(date));

						// gain Arriving, To for flightTranInfo
						String arrtoString = fliString.substring(intarr);
						String[] arrArrays = arrtoString.trim().split(huanhang);
						String arriv = arrArrays[0].trim().substring(9);
						String arriving = arriv.substring(0, arriv.indexOf(","));

						// gain Cabin Class
						String cabtoString = fliString.substring(intcab);
						String[] cabArrays = cabtoString.trim().split(huanhang);
						String cabinClass = cabArrays[0].trim().substring(12);

						// set vo
						// set Departure Flight
						btFlightTrainInfo.setDepartureFlight(flightNumber);
						// set From
						btFlightTrainInfo.setFromCity(departing);
						// set date xuyao format
						btFlightTrainInfo.setDepartureDate(dateTime);
						// set To
						btFlightTrainInfo.setToCity(arriving);
						// set Class
						btFlightTrainInfo.setClassInfo(cabinClass);
						// set businessTripPkId
						btFlightTrainInfo.setBusinessTripPkId(businessTripPkId);
						// set tripType
						btFlightTrainInfo.setTripType(tripType);

						// add the list<BtFlightTrainInfo>
						flightList.add(btFlightTrainInfo);
					} else {

						break;
					}
					i = i + 1 + intdis;
				}
				//
				if(pdfInfo.contains("Itinerary Summary")){
					String[] strarr=pdfInfo.split("Itinerary Summary")[0].split(huanhang);
					for(int j=0;j<flightList.size();j++){
						//String str=strarr[strarr.length-flightList.size()+j];正
						String str=strarr[strarr.length-j-1];//反
						if(str.length()<=75){
							flightList.get(j).setClassInfo(str);
						}else{
							
						}
						
					}
				}
				//
				status = true;
				// put in the fareDetails
				flight.put("fareDetails", fareDetails);
				// put in the flightList
				flight.put("flightList", flightList);

				// put flight in the map
				map.put("flight", flight);
				// put in the status
				map.put("status", status);
				// put in the errMsg
				map.put("errMsg", "");
			} catch (Exception e) {
				e.printStackTrace();
				status = false;
				errMsg = e.getMessage();
				// put in the Status
				map.put("status", status);
				map.put("errMsg", errMsg);
			}
			return map;
		}
	
	public static String getTextFromPDF(InputStream inputStream) {
		String result = null;
		//FileInputStream is = null;
		PDDocument document = null;
		try {
			//is = new FileInputStream(pdfFilePath);
			PDFParser parser = new PDFParser(inputStream);
			parser.parse();
			document = parser.getPDDocument();
			PDFTextStripper stripper = new PDFTextStripper();
			result = stripper.getText(document);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
//			if (is != null) {
//				try {
//					is.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
			if (document != null) {
				try {
					document.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
}
