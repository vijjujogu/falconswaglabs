package org.atmecs.constant;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class ExcelReader {

	static Workbook swaglabsbook;
	static Sheet swaglabssheet;
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(FilePathConstants.TESTDATA);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			swaglabsbook = WorkbookFactory.create(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		swaglabssheet = swaglabsbook.getSheet(sheetName);
		Object[][] data = new Object[swaglabssheet.getLastRowNum()][swaglabssheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < swaglabssheet.getLastRowNum(); i++) {
			for (int k = 0; k < swaglabssheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = swaglabssheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
	
	
	//logic for reading properties file
			public static Properties readProperties(String path) {
				
				Properties properties = new Properties();
				try {
					FileInputStream inputStream = new FileInputStream(path);
					try {
						properties.load(inputStream);
					} catch (IOException e) {
						e.printStackTrace();
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				return properties;
			}
			
	
}
