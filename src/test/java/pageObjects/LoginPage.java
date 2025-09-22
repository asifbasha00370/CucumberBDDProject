package pageObjects;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver ldriver;

	public LoginPage(WebDriver rDriver)      //constructor
	{
		ldriver=rDriver;                    // initiate the driver
		PageFactory.initElements(rDriver, this);
	}
	
    @FindBy(id ="Email")         //@FIndBy is the annotation 
    @CacheLookup
    WebElement email;
    
    @FindBy(id="Password")
    @CacheLookup
    WebElement password;
    
    @FindBy(xpath="//button[@class='button-1 login-button']")
    @CacheLookup
    WebElement loginBtn;
    
    @FindBy(xpath="//a[text()='Logout']")
    @CacheLookup	
    WebElement logoutBtn;
    
    //Actions
    public void enterEmail(String emailAdd) 
    {
    	email.clear();
    	email.sendKeys(emailAdd);
    }
    
    public void enterPassword(String pwd) 
    {
    	password.clear();
    	password.sendKeys(pwd);
    }
    
    public void clickLoginButton()
    {
    	loginBtn.click();
    }
    
    public void clickLogoutButton()
    {
			WebDriverWait wait= new WebDriverWait(ldriver, Duration.ofSeconds(10));
			WebElement logout = wait.until(ExpectedConditions.elementToBeClickable(logoutBtn));
    	      logoutBtn.click();
    }
    
}

