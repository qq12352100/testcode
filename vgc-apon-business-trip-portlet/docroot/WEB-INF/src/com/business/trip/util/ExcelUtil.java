package com.business.trip.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.util.portlet.PortletProps;

/**
 * @description: operate excel method
 * 
 */
public class ExcelUtil {

	private static Log _log = LogFactoryUtil.getLog(ExcelUtil.class);

    public static final String MICROSOFT_EXCEL_97 = "xls";
    public static final String MICROSOFT_EXCEL_2007 = "lsx";
    /**
     * Gets the excel type
     * 
     * @param fileName
     * @return
     */
    private String getSuffix(String fileName) {
	return fileName.substring(fileName.length() - 3);
    }

    /**
     * Gets the temp file
     * 
     * @param fileName
     * @return
     * @modify zack zhang  2014-2-25 下午4:56:59
     */
    private File getTempFile(String fileName) {
	File tempFile = null;
	String excelVersion = getSuffix(fileName);
	try {
	    if (MICROSOFT_EXCEL_97.equals(excelVersion)) {
		tempFile = File.createTempFile("temp", "xls");
	    } else if (MICROSOFT_EXCEL_2007.equals(excelVersion)) {
		tempFile = File.createTempFile("temp", "xlsx");
	    } else {
		_log.info("The format of fileName is not a excel");
	    }
	} catch (Exception e) {
	    _log.info("Failed to create temp file",e);
	    if (_log.isErrorEnabled()) {
		_log.error(e.getCause());
	    }
	}
	return tempFile;
    }

    /**
     * Get the workbook template
     * 
     * @param templateName
     * @param excelTemplate
     * @return
     * @modify zack zhang  2014-2-25 下午4:56:59
     */
    private Workbook getWorkbookTemplate(String templateName,
	    InputStream excelTemplate) {
	Workbook workbook = null;
	try {
	    if (getSuffix(templateName).equals(MICROSOFT_EXCEL_97)) {
		workbook = (Workbook) new HSSFWorkbook(excelTemplate);
	    } else if (getSuffix(templateName).equals(MICROSOFT_EXCEL_2007)) {
		workbook = new XSSFWorkbook(excelTemplate);
	    } else {
		_log.info("The TemplateName is incorrect");
	    }
	    excelTemplate.close();
	} catch (Exception e) {
	    _log.info("Create MICROSOFT_EXCEL_TEMPLATE failure",e);
	    if (_log.isErrorEnabled()) {
		_log.error(e.getCause());
	    }
	}
	return workbook;
    }


    /**
     * Get Workbook
     * 
     * @param templateName
     * @return
     */
    public Workbook getWorkbook(String templateName) {
		String printpath = null;
		printpath = GetterUtil.getString(PortletProps.get("printpath"));
		InputStream fis = ExcelUtil.class.getClassLoader().getResourceAsStream(
			printpath + templateName);
		return getWorkbookTemplate(templateName, fis);
    }

    /**
     * Get excel file
     * @param workbook
     * @param templateName
     * @return
     * @modify zack zhang  2014-2-25 下午4:56:59
     */
    public File getExcelFile(Workbook workbook, String templateName)throws IOException {
	File tempFile = getTempFile(templateName);
	 FileOutputStream fos = null;
	try {
	    fos = new FileOutputStream(tempFile);
	    workbook.write(fos);
	    fos.flush();
		fos.close();
	} catch (IOException e) {
	    _log.info("The Workbook writting is fail",e);
	}finally{
		if(fos != null){
			  try {
				fos.close();
			} catch (IOException e) {
				 _log.info("The Workbook writting is fail",e);
			}
			 
		}
	}
	return tempFile;
    }
    
    

}
