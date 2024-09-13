package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	WebDriver driver;
	
	//this constructor for all pages
	
	public HomePage (WebDriver driver) {
		
		this.driver = driver;
	}
	
	
	//we have parameterized the input of user name w4tw4tw4twtw4t
	
	// in page class we are storing all locators for web elements
	public void setUserName(String userName) {
		
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(userName);// taking from parameter
	}
	
	public void setPassword(String password) {
		
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	}
	
	public void clickOnSubmit() {
		
		driver.findElement(By.xpath("//input[@name='submit']")).click();
	}
	
	public String getLoginMsg() {
		
		return driver.findElement(By.xpath("//h3[text()='Login Successfully']")).getText();
		
		
	}
	
	
	public void clickOnRegistretion() throws InterruptedException {
		

		
		driver.findElement(By.xpath("//a[normalize-space()='REGISTER']")).click();
	}

}
