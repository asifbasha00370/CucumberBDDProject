package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Utilities.WaitHelper;

public class SearchCustomersPage {
	
	public  WebDriver ldriver;
	
	WaitHelper	waithelper;
	//constructor
	public SearchCustomersPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
		waithelper=new WaitHelper(ldriver);
	}
    
	//Find webElements on the web Page by this another approach pageobjects method
	
	@FindBy(how = How.ID, using = "SearchEmail")
	@CacheLookup           //Cache element sfter first lookup
	WebElement txtEmail;
	
	@FindBy(how=How.ID, using= "SearchFirstName")
	@CacheLookup
	WebElement txtFirstName;
	
	@FindBy(how=How.ID, using="SearchLastName")
	@CacheLookup
	WebElement txtLastName;
	
	@FindBy(how=How.NAME, using="SearchIsActive")
	@CacheLookup
	WebElement txtISActive;
	
	@FindBy(how=How.XPATH, using="//option[text()='All']")
	@CacheLookup
	WebElement txtAll;
	
	@FindBy(how=How.XPATH, using="//option[text()='Yes']")
	@CacheLookup
	WebElement txtYes;
	
	@FindBy(how=How.XPATH, using="//option[text()='No']")
	@CacheLookup
	WebElement txtNo;
	
	@FindBy(how=How.ID, using="SearchCompany")
	@CacheLookup
	WebElement txtSearchCompany;
	
	@FindBy(how=How.ID, using="SearchRegistrationDateFrom")
	@CacheLookup
	WebElement txtSearchRegistrationDateFrom;
	
	@FindBy(how=How.ID, using="SearchRegistrationDateFrom")
	@CacheLookup
	WebElement txtSearchRegistrationDateTo;
	
	@FindBy(how=How.ID,using="SearchIpAddress")
	@CacheLookup
	WebElement txtSearchIpAddress;

	@FindBy(how = How.XPATH, using = "//input[@role='searchbox']")
	@CacheLookup           //Cache element sfter first lookup
	WebElement txtCustomerRoles;
	
	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Administrators')]")
	@CacheLookup           //Cache element sfter first lookup
	WebElement listAdministrators;
	
	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Forum Moderators')]")
	@CacheLookup           //Cache element sfter first lookup
	WebElement listForumModerators;
	
	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Guests')]")
	@CacheLookup           //Cache element sfter first lookup
	WebElement listGuests;
	
	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Registered')]")
	@CacheLookup           //Cache element sfter first lookup
	WebElement listRegistered;
	
	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Vendors')]")
	@CacheLookup           //Cache element sfter first lookup
	WebElement listVendors;
	
	By btnSearch = By.id("search-customers");
	
	@FindBy(how=How.XPATH, using="//div[@class='card card-default']//div[@class='card-body']")
	@CacheLookup
	WebElement tableSearchResults;	
	
	@FindBy(how=How.XPATH, using="//div[@id='customers-grid_wrapper']")
	@CacheLookup
	WebElement table;
	
	//div[@class='card card-default']//div[@class='card-body']
	@FindBy(how=How.XPATH,using="//table[@class='table table-bordered table-hover table-striped dataTable']//tr")
	@CacheLookup
	List<WebElement> tableRows;
	
	@FindBy(how=How.XPATH,using="//table[@class='table table-bordered table-hover table-striped dataTable']//tr/td")
	@CacheLookup
	List<WebElement> tableColumns;
	
	public void setEmail(String email) {
		
		waithelper.WaitForElement(By.id("SearchEmail"), Duration.ofSeconds(30));
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}
	
	public void setFirstName(String fname) {
		
		waithelper.WaitForElement(By.id("SearchFirstName"), Duration.ofSeconds(30));
		txtFirstName.clear();
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		
		waithelper.WaitForElement(By.id("SearchLastName"), Duration.ofSeconds(30));
		txtLastName.clear();
		txtLastName.sendKeys(lname);
	}
	public void clickSearch() {
		
		waithelper.WaitForElement(btnSearch, Duration.ofSeconds(30));
		ldriver.findElement(btnSearch).click();
	}
	
	public int getNoOfRows() {
		return (tableRows.size());	
	}
	
	public int getNoOfColumns() {
		return tableColumns.size();
	}
	
	public boolean searchCustomerByEmail(String email) {
		
		boolean flag=false;
		
		for(int i=1;i<=getNoOfRows();i++) {
			
			String emailid=table.findElement(By.xpath("//table[@class='table table-bordered table-hover table-striped dataTable']/tbody/tr[\"+i+\"]/td[2]")).getText();
					
			System.out.println(emailid);	
			
			if(emailid.equals("steve_gates@nopCommerce.com")) {
				flag=true;
			}
		}
			
		return flag;	
	}
	
    public boolean searchCustomerByName(String email) {
		
		boolean flag=false;
		
		for(int i=1;i<=getNoOfRows();i++) {
			
			String name=table.findElement(By.xpath("//table[@class='table table-bordered table-hover table-striped dataTable']/tbody/tr[\"+i+\"]/td[3]")).getText();
					
			String names[]=name.split(" ");   //separarting fname &lname
			
			if(names[0].equals("Steve") && names[1].equals("Gates")) {
				flag=true;
			}
		}
			
		return flag;	
	}
}
