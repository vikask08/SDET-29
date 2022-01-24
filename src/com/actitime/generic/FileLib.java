package com.actitime.generic;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {
	public String getProertyData(String key) throws Throwable {
		FileInputStream fis=new FileInputStream("./data/commonData1.properties");
		Properties p=new Properties();
		p.load(fis);
		String data = p.getProperty(key);
		return data;
	}
	public String getExcelData(String sheet,int row,int cell) throws Throwable {
		FileInputStream fis=new FileInputStream("./data/TestScript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data2 = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		return data2;
	}
}
