package com.company.car.portlet.admin;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.company.car.model.CompanyCarManagement;
import com.company.car.service.CompanyCarManagementLocalServiceUtil;
import com.company.car.util.ExcelUtil;
import com.global.management.service.GlobalExcelLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class CompanyCarManagementPortlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		super.doView(renderRequest, renderResponse);
	}

	/**
	 * Import the excel data to database
	 */
	@Override
	public void processAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		String cmd = ParamUtil.getString(actionRequest, "cmd");
		if (Constants.SEARCH.equals(cmd)) {
			this.query(actionRequest, actionResponse);
		}
		super.processAction(actionRequest, actionResponse);
	}

	// Execute the query for the query condition
	public void query(ActionRequest actionRequest, ActionResponse actionResponse) {
		String contractType = ParamUtil
				.getString(actionRequest, "contractType");
		String carCategory = ParamUtil.getString(actionRequest, "carCategory");
		String carType = ParamUtil.getString(actionRequest, "carType");
		String carBrand = ParamUtil.getString(actionRequest, "carBrand");
		actionResponse.setRenderParameter("carCategory", carCategory);
		actionResponse.setRenderParameter("carType", carType);
		actionResponse.setRenderParameter("carBrand", carBrand);
		actionResponse.setRenderParameter("contractType", contractType);
		actionResponse.setRenderParameter("mvcPath", "/html/admin/view.jsp");
	}

	//Upload the company car management
	public void upload(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {
		UploadPortletRequest uploadPortletRequest = PortalUtil
				.getUploadPortletRequest(actionRequest);
		String fileName = uploadPortletRequest.getFileName("cars");
		String fileType = fileName == null ? "" : fileName.substring(fileName
				.lastIndexOf('.') + 1);
		if (fileName != null
				&& !(fileType.equals("xlsx") || fileType.equals("xls"))) {
			SessionErrors.add(actionRequest, "importFileError");
		} else if (fileName != null) {
			InputStream inputStream = uploadPortletRequest
					.getFileAsStream("cars");
			List<Map<String, String>> list = ExcelUtil.importExcel(inputStream,
					fileType);
			try {
				CompanyCarManagementLocalServiceUtil
						.importCompanyCarManagement(list);
				_log.info("Import the car informations success!");
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		Map<String, String> headers = new LinkedHashMap<String, String>();
		headers.put("h0", "No.");
		headers.put("h1", "Car Type");
		headers.put("h2", "Contract Type");
		headers.put("h3", "Grade Type");
		headers.put("h4", "Grade");
		headers.put("h5", "Car Brand");
		headers.put("h6", "Car Model");
		headers.put("h7", "Car Category");
		List<Map<String, String>> rows = new ArrayList<Map<String, String>>();
		try {
			List<CompanyCarManagement> list = CompanyCarManagementLocalServiceUtil
					.findAll();
			for (int i = 0; i < list.size(); i++) {
				Map<String, String> row = new LinkedHashMap<String, String>();
				CompanyCarManagement carManagement = list.get(i);
				row.put("c0", carManagement.getCarNo());
				row.put("c1", carManagement.getCarType());
				row.put("c2", carManagement.getContractType());
				row.put("c3", carManagement.getGradeType());
				row.put("c4", carManagement.getGrade());
				row.put("c5", carManagement.getCarBrand());
				row.put("c6", carManagement.getCarModel());
				row.put("c7", carManagement.getCarCategory());
				rows.add(row);
			}
			GlobalExcelLocalServiceUtil.exportExcel(headers, rows,
					"CompanyCarManagement.xlsx", resourceResponse);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		super.serveResource(resourceRequest, resourceResponse);
	}

	/**
	 * Adds a new company car to the database.
	 * 
	 */

	public void addCompanyCar(ActionRequest request, ActionResponse response)
			throws Exception {

		CompanyCarManagement companyCar = CompanyCarManagementLocalServiceUtil
				.createCompanyCarManagement(0);

		companyCar.setCompanyCarManagementId(ParamUtil.getLong(request,
				"companyCarManagementId"));

		companyCar.setCarType(ParamUtil.getString(request, "carType"));
		companyCar
				.setContractType(ParamUtil.getString(request, "contractType"));
		companyCar.setGradeType(ParamUtil.getString(request, "gradeType"));
		companyCar.setGrade(ParamUtil.getString(request, "grade"));
		companyCar.setCarBrand(ParamUtil.getString(request, "carBrand"));
		companyCar.setCarModel(ParamUtil.getString(request, "carModel"));
		companyCar.setCarCategory(ParamUtil.getString(request, "carCategory"));

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				CompanyCarManagement.class.getName(), request);

		CompanyCarManagementLocalServiceUtil.addCompanyCarManagement(
				companyCar, serviceContext);

		sendRedirect(request, response);
	}

	/**
	 * Updates the database record of an existing company Car.
	 * 
	 */

	public void updateCompanyCar(ActionRequest request, ActionResponse response)
			throws Exception {

		long companyCarManagementId = ParamUtil.getLong(request,
				"companyCarManagementId");

		CompanyCarManagement companyCar = null;

		try {
			companyCar = CompanyCarManagementLocalServiceUtil
					.fetchCompanyCarManagement(companyCarManagementId);
		} catch (SystemException se) {
			_log.error(se);
		}

		companyCar.setCarType(ParamUtil.getString(request, "carType"));
		companyCar
				.setContractType(ParamUtil.getString(request, "contractType"));
		companyCar.setGradeType(ParamUtil.getString(request, "gradeType"));
		companyCar.setGrade(ParamUtil.getString(request, "grade"));
		companyCar.setCarBrand(ParamUtil.getString(request, "carBrand"));
		companyCar.setCarModel(ParamUtil.getString(request, "carModel"));
		companyCar.setCarCategory(ParamUtil.getString(request, "carCategory"));

		CompanyCarManagementLocalServiceUtil
				.updateCompanyCarManagement(companyCar);

		sendRedirect(request, response);
	}

	/**
	 * Deletes a company car from the database.
	 * 
	 */

	public void deleteCompanyCar(ActionRequest request, ActionResponse response)
			throws Exception {
		long companyCarManagementId = ParamUtil.getLong(request,
				"companyCarManagementId");

		if (Validator.isNotNull(companyCarManagementId)) {

			// delete company car by company car Id

			CompanyCarManagementLocalServiceUtil
					.deleteCompanyCarManagement(companyCarManagementId);

			SessionMessages.add(request, "companyCar-deleted");

			sendRedirect(request, response);
		} else {
			SessionErrors.add(request, "deletion-error");
		}
	}

	private static Log _log = LogFactoryUtil.getLog(CompanyCarManagement.class);

}
