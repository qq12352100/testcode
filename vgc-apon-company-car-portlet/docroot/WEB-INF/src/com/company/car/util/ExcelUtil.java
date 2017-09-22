package com.company.car.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * Excel Import and Export
 */
public class ExcelUtil {
	private static Log _log = LogFactoryUtil.getLog(ExcelUtil.class);

	/**
	 * Read the Excel
	 * 
	 * @throws IOException
	 */
	public static List<Map<String, String>> importExcel(
			InputStream inputStream, String fileType) throws IOException {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Workbook wb = null;
		try {
			if("xlsx".equals(fileType)) {
				wb = new XSSFWorkbook(inputStream);
			}else if("xls".equals(fileType)) {
				wb = new HSSFWorkbook(inputStream);
			}
			
			Sheet st = wb.getSheetAt(0);
			for (int rowIndex = 0; rowIndex <= st.getLastRowNum(); rowIndex++) {
				Row row = st.getRow(rowIndex);
				Map<String, String> map = new HashMap<String, String>();
				int i = 0;
				for (Cell cell : row) {
					cell.setCellType(Cell.CELL_TYPE_STRING);
					String content = cell.getStringCellValue();
					map.put("c" + i++, content);
				}
				list.add(map);
			}
			_log.info("Read the excel file success!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (wb != null) {
				wb.cloneSheet(0);
			}
		}
		return list;
	}
}