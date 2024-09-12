package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Register {

	WebDriver driver;

	public Register(WebDriver driver) {

		this.driver = driver;
	}

	//test cases
	public void setFirstName(String firstName) {

		driver.findElement(By.xpath("//input[@name ='firstName']")).sendKeys(firstName);
	}

	public void setLastName(String lastName) {

		driver.findElement(By.xpath("//input[@name ='lastName']")).sendKeys(lastName);
	}
	
	public void setPhone(String phone){

		driver.findElement(By.xpath("//input[@name ='phone']")).sendKeys(phone);

	}
	
	
	
	public void setEmail(String userName) {

		driver.findElement(By.xpath("//input[@name ='userName']")).sendKeys(userName);
	}
	
	
	public void clickOnSubmit() {

		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
	
	public String getRegistrationText() {

		return driver.findElement(By.xpath("//font[contains(text(),'Thank you for registering.')]")).getText();
	}
	

}
