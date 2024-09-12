package testcases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;

public class VerifyLogin {
	

	
	// we are not using main method here so we will use test-ng class to run our test case
	
	
	WebDriver driver;
	HomePage homePage; // we created object of the home page to access its component
	Logger log;
	 ExtentTest test1;
	 ExtentReports extent;
	//Browser launch method
	// this code will run before every method
	
	@BeforeMethod(alwaysRun = true)
	public void launchApplication() {
		
		//log implementation:
		
		PropertyConfigurator.configure("log.properties");
		 log = Logger.getLogger(VerifyLogin.class); //have to class binary
//		---------------------------------
		
		 
		 //extent report code 
		 
		 //create html reporter object
		 
		 ExtentSparkReporter htmlreporter = new ExtentSparkReporter("Report.html");
		 
		 // create extent report and attach report
		 
		 extent = new ExtentReports();
		 
		 extent.attachReporter(htmlreporter);
		 
		 //create toggle for the given test add all log events under it
		 
		test1 = extent.createTest("Verify registretion");
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		log.info("before launching url");
		
		driver.get("https://demo.guru99.com/test/newtours/");
		
		log.info("after launching url");
		
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void verifyLogin() throws InterruptedException {
		
		
		// we have initialized driver for this page object this is code
		homePage = new HomePage(driver);
		
		test1.info("before filling username");
		
		// using page class code in test cases class by using it objects
		
		homePage.setUserName("admin");
		
		test1.info("after filling username");

		test1.info("before filling password");

		
		homePage.setPassword("admin");
		
		test1.info("after filling password");

		
		homePage.clickOnSubmit();
		log.info("after submit");
		
		test1.info("before submit");



		//for login verification of login message we are using assert class
		
		String loginMsg = homePage.getLoginMsg();
		Assert.assertEquals(loginMsg, "Login Successfully");
		
//		homePage.clickOnRegistretion();
//		
//		Thread.sleep(2000);
		
	}
	
	

	
// this method will run after each method
	@AfterMethod(alwaysRun = true)
	
	public void closeBrowser(){
		
		test1.info("before browser close");

		
		driver.quit();
		
		
		extent.flush();


	}
	
	
}
