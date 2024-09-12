# Author Admin  
Feature: Login feature.

Scenario: Verify valid user login
					Given Launch application
					And set username
					And set password
					When click on submit
					Then Verify user is logged in successfully

Scenario: Verify invalid user login

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