package testStep;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinition {
	
	
	WebDriver driver;

	@Given("Launch application")
	
	public void launchApplication() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		
		driver.get("https://demo.guru99.com/test/newtours/");
		
		driver.manage().window().maximize();
		
		driver.quit();
	}
	
	
	@And("set username")
	public void setUserName() {
		
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("Admin");// taking from parameter
	}
	
	@And("set password")

	public void setPassword() {
		
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin");
	}
	
	@When("click on submit")
	public void clickOnSubmit() {
		
		driver.findElement(By.xpath("//input[@name='submit']")).click();
	}
	
	
	@Then("Verify user is logged in successfully")
	public void  verifyUserLogin() {
		
		Assert.assertEquals(driver.findElement(By.xpath("//h3[text()='Login Successfully']")).getText(), "Login Successfully");
		
	
		
		
	}

}
