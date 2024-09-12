package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Utility {

	
	public static void selectOptionFromDropdown(String option,WebElement dropdownWebElement) {
		
		Select select = new Select(dropdownWebElement);
		select.selectByVisibleText(option);
				
	}
	
	public static ArrayList<String> readExcel () throws IOException {
		
		ArrayList<String> arrayList =new ArrayList<String>();
		
		// this is required to reading writing files
		
		FileInputStream fileInputStream = new FileInputStream(new File("src\\test\\resources\\registrationdata.xlsx"));
		
		// this will represent whole workbook
		XSSFWorkbook  xssfWorkbook = new XSSFWorkbook(fileInputStream);
		
		//this will return sheet
		
		XSSFSheet xssfSheet =  xssfWorkbook.getSheet("data");
		
		
		int lastRowNum = xssfSheet.getLastRowNum();
		
		for (int i=1; i<=lastRowNum; i++) {
			
			XSSFRow xssfRow = xssfSheet.getRow(i);
			
			int lastCellNum = xssfRow.getLastCellNum();
			
			for(int j = 0; j<lastCellNum; j++) {
				
				XSSFCell cell = xssfRow.getCell(j);
				arrayList.add(cell.getStringCellValue());
			}
		}
		
		xssfWorkbook.close();
		return arrayList;
	}
	
	public static void screenshotsFailedtestcases(WebDriver driver, String screenshotsname) throws IOException {
		
		File screenshots = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(screenshots, new File("./screenshots/"+screenshotsname+".png"));
		
	}
}
