package com.business.trip.portlet;

import com.business.trip.service.BusinessTripReimbursementLocalServiceUtil;
import com.business.trip.util.DataGetterUtil;
import com.business.trip.util.DateUtil;
import com.business.trip.util.ExcelUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class TravelPortlet extends MVCPortlet {

	private final static String FORWARD = "forward";

	public void init() throws PortletException {
		viewJSP = getInitParameter("view-jsp");
	}

	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		String jspPage = renderRequest.getParameter(FORWARD);

		jspPage = jspPage == null ? this.viewJSP : jspPage;
		include(jspPage, renderRequest, renderResponse);
	}

	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {

		String reportName = resourceRequest.getParameter("reportName");
		if (reportName != null) {
			try {
				if ("exportExcel".equals(reportName))
					exportReportInfoExcel(resourceRequest, resourceResponse);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			super.serveResource(resourceRequest, resourceResponse);
		}
	}

	public static String exportReportInfoExcel(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
		HttpServletRequest request = PortalUtil.getHttpServletRequest(resourceRequest);
		HttpServletResponse response = PortalUtil.getHttpServletResponse(resourceResponse);

		String ticketNo = ParamUtil.getString(resourceRequest, "ticketNo");
		int status = ParamUtil.getInteger(resourceRequest, "status", -1);
		String periodStart = ParamUtil.getString(resourceRequest, "periodStart");
		String periodEnd = ParamUtil.getString(resourceRequest, "periodEnd");
		String travelType = ParamUtil.getString(resourceRequest, "travelType");

		List<Object[]> result = BusinessTripReimbursementLocalServiceUtil.reimbursementTravelForReport(travelType, ticketNo, status,
				periodStart, periodEnd);

		String templateName;
		if (travelType != null && travelType.equals("0")) {
			templateName = "TripDomestic";
		} else {
			templateName = "TripInternational";
		}
		File file = getExcelOut(templateName + ".xlsx", result, travelType);

		String exportName = templateName + "_" + DateUtil.formatYMDHm(new Date()) + ".xlsx";

		FileInputStream fis = new FileInputStream(file);
		ServletResponseUtil.sendFile(request, response, exportName, fis);
		file.delete();
		fis.close();
		return templateName;
	}

	public static File getExcelOut(String templateName, List<Object[]> result, String travelType) throws IOException {
		ExcelUtil excelUtil = new ExcelUtil();
		Workbook workbook = excelUtil.getWorkbook(templateName);
		CellStyle style = workbook.createCellStyle();
		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setBorderLeft(CellStyle.BORDER_THIN);
		style.setBorderBottom(CellStyle.BORDER_THIN);
		style.setBorderRight(CellStyle.BORDER_THIN);
		style.setBorderTop(CellStyle.BORDER_THIN);
		Row tempRow;
		Cell tempCell;
		DecimalFormat df = new DecimalFormat("0.00");
		try {
			Sheet sheet = workbook.getSheetAt(0);
			for (int k = 0; k < result.size(); k++) {
				Object[] temp = result.get(k);
				tempRow = sheet.createRow(k + 2);// 第一行为标题
				tempCell = tempRow.createCell(0);
				tempCell.setCellStyle(style);
				tempCell.setCellValue(k + 1);
				for (int i = 0; i < temp.length; i++) {
					tempCell = tempRow.createCell(i + 1);// 第一列为序号
					tempCell.setCellStyle(style);
					if (i == temp.length - 2 && temp[i] instanceof BigDecimal) {
						int status = DataGetterUtil.getInt(isNull(temp[i]));
						String sta = "";
						if (status == 1) {
							sta = "pending";
						} else if (status == 101) {
							sta = "pending Supervisor";
						} else if (status == 102) {
							sta = "pending EVP";
						} else if (status == 103) {
							sta = "pending Head of Controlling";
						} else if (status == 104) {
							sta = "pending HRG";
						} else if (status == 0) {
							sta = "compelete";
						}
						tempCell.setCellValue(sta);
						break;
					} else if (i == 1) {
						tempCell.setCellValue(isNull(temp[i]).toString());
					} else {
						if (temp[i] instanceof BigDecimal) {
							tempCell.setCellValue(df.format(DataGetterUtil.getDouble(isNull(temp[i]))));
						} else if (temp[i] instanceof Date) {
							tempCell.setCellValue(DateUtil.format(DataGetterUtil.getDate(isNull(temp[i]))));
						} else {
							tempCell.setCellValue(DataGetterUtil.getString(isNull(temp[i])));
						}
					}
				}
			}
			sheet.setForceFormulaRecalculation(true);
		} catch (Exception e) {
			_log.error(e);
			return excelUtil.getExcelFile(workbook, templateName);
		}
		return excelUtil.getExcelFile(workbook, templateName);
	}

	private static Object isNull(Object o) {
		if (o == null)
			return "";
		return o;
	}

	public void doDispatch(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		String jspPage = renderRequest.getParameter(FORWARD);

		if (jspPage != null) {
			include(jspPage, renderRequest, renderResponse);
		} else {
			super.doDispatch(renderRequest, renderResponse);
		}
	}

	protected void include(String path, RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		PortletRequestDispatcher portletRequestDispatcher = getPortletContext().getRequestDispatcher(path);

		if (portletRequestDispatcher == null) {
			_log.error(path + " is not a valid include");
		} else {
			portletRequestDispatcher.include(renderRequest, renderResponse);
		}
	}

	protected String viewJSP;

	private static Log _log = LogFactoryUtil.getLog(TravelPortlet.class);

}