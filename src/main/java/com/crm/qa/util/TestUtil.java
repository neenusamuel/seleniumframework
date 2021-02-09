package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestUtil {
	public static long Implicit_Wait = 10;
	public static long Pageload_Wait = 20;
	static Workbook book;
	static FileInputStream fis;
	static Sheet sheet;
	public static WebDriver driver;
	
	public static Object[][] getTestData(String sheetName){
		try {
		 fis = new FileInputStream("C:\\Users\\neenu\\eclipse-workspace\\freeCRMtest\\"
				+ "src\\main\\java\\com\\crm\\qa\\testdata\\contacts.xlsx");
	}catch(FileNotFoundException e) {
		e.printStackTrace();
	}
		try {
			book = WorkbookFactory.create(fis);
		}catch(IOException io) {
			io.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int j=0; j<sheet.getRow(0).getLastCellNum();j++)
			{
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
//		String currentDir = "./"
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

}
