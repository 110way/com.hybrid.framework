package testcases;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import pages.Register;
import utility.Utility;

public class VerifyRegistretionByUsingExcel {

	WebDriver driver;
	HomePage homePage; 	
	Register register;
	ExtentTest test2;
	 ExtentReports extent2;
		Logger log2;

	
	@BeforeMethod(alwaysRun = true)
	public void launchApplication() {
		
		

		//log implementation:
		
		PropertyConfigurator.configure("log.properties");
		 log2 = Logger.getLogger(VerifyRegistretionByUsingExcel.class); //have to class binary
//		---------------------------------
		
 ExtentSparkReporter htmlreporter2 = new ExtentSparkReporter("Report2.html");
		 
		 // create extent report and attach report
		 
		 extent2 = new ExtentReports();
		 
		 extent2.attachReporter(htmlreporter2);
		 
		 //create toggle for the given test add all log events under it
		 
		test2 = extent2.createTest("VerifyRegistretionByUsingExcel");
		

		log2.info("before launching of browser");
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/");
		driver.manage().window().maximize();
		
		log2.info("after launching of browser");

	}
	
	@Test
	public void verifyLogin() throws IOException, InterruptedException {
		
		homePage = new HomePage(driver);
		homePage.clickOnRegistretion();
		ArrayList<String> userData = Utility.readExcel();
		register = new Register(driver);
		register.setFirstName(userData.get(0));
		register.setLastName(userData.get(1));
		register.setPhone(userData.get(2));
		register.setEmail(userData.get(3));
		
		
		Utility.selectOptionFromDropdown("ALGERIA", driver.findElement(By.xpath("//select[@name = 'country']")));
		
		register.clickOnSubmit();
		
		log2.info("After registration");

		
		Assert.assertEquals(register.getRegistrationText(), "Thank you for registering. You may now sign-in using the user name and password you've just entered.","User not registered successfully");
		
		
		
	}
	
	

	
	@AfterMethod
	
	// this is code for taking screenshots of failed test case  we kept that in utility method
	
	
	public void failureScreenshots(ITestResult result) throws IOException {
		
		if (ITestResult.FAILURE == result.getStatus()) {
			
			
			Utility.screenshotsFailedtestcases(driver, result.getName());
		}
	}
	
	@AfterMethod(alwaysRun = true)

	public void closeBrowser(){
		
		driver.quit();
	}
}
