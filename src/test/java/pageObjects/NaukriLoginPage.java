package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class NaukriLoginPage {
	
	WebDriver ldriver;
	
	public NaukriLoginPage(WebDriver rDriver) {
		
		ldriver=rDriver;
		
		PageFactory.initElements(rDriver,this);
	}

	By txtEmail=By.id("usernameField");
	
	By txtPassword=By.xpath("//input[@id='passwordField']");
	
	By Login=By.xpath("//button[normalize-space()='Login']");
	
	By Profile_icon=By.xpath("//div[@class='nI-gNb-drawer__icon']");
	
	By Logout=By.xpath("//a[normalize-space()='Logout']");
	
	
	//Action Methods
	
	public void setEmail(String email) 
	{
		ldriver.findElement(txtEmail).sendKeys(email);
	}
	
	public void setPassword(String password) 
	{
		ldriver.findElement(txtPassword).sendKeys(password);
	}
	
	
	
}
