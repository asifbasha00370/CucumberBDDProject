package pageObjects;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomersPage {

	public WebDriver ldriver;
	
	//Constructors
	public AddCustomersPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	//Find webElements on the web Page
	
	By lnkCustomer_menu=By.xpath("(//p[contains(text(),'Customers')])[1]");
	By lnkCustomer_menuitem=By.xpath("(//p[contains(text(),' Customers')])[2]");
	
	By add_NewBtn=By.xpath("//a[@class='btn btn-primary']");
	
	By txtEmail=By.xpath("//input[@id='Email']");
	By txtPassword=By.xpath("//input[@id='Password']");
	
	By firstName=By.xpath("//input[@id='FirstName']");
	By lastName=By.xpath("//input[@id='LastName']");
	
	By maleGender=By.id("Gender_Male");
	By femaleGender=By.id("Gender_Female");
	
	
	By companyName=By.name("Company");
	
	By taxExempt=By.id("IsTaxExempt");   //input[@id='IsTaxExempt']
	
	By newsletter=By.xpath("//span[@class='select2 select2-container select2-container--default']//input[@role='searchbox']");
	
	By txtCustomerRoles= By.xpath("//span[@aria-expanded='true']//input[@role='searchbox']");
	By rd_Administrators=By.xpath("//li[text()='Administrators']");
	By rd_Forum_Moderators=By.xpath("//li[text()='Forum Moderators']");
	By rd_Registered=By.xpath("//li[text()='Registered']");
	By rd_Guests=By.xpath("//li[text()='Guests']");
	By rd_Vendors=By.xpath("//li[text()='Vendors']");
	
	By drpdwnMgrVendors=By.xpath("//select[@id='VendorId']");
	By mgr_of_NotVendors=By.xpath("//option[text()='Not a vendor']");
	By mgr_of_Vendors1=By.xpath("//option[text()='Vendor 1']");
	//By mgr_of_Vendors2=By.xpath("//option[text()='Vendor 2']");
	
	By active=By.xpath("//input[@id='Active']");
	
	By change_Password=By.xpath("//input[@id='MustChangePassword']");
	
	By admin_Content=By.xpath("//textarea[@id='AdminComment']");
	
	By save_btn=By.xpath("//button[@name='save']");
	
	//Action Methods
	
	public String  getPageTitle() {
		return ldriver.getTitle();
	}
	
	public void clickOnCustomerMenu() {
		
		ldriver.findElement(lnkCustomer_menu).click();
	}
	
	public void clickOnCustmrMenuitem() {
		ldriver.findElement(lnkCustomer_menuitem).click();
	}
	
	public void addNewBtn() {
		ldriver.findElement(add_NewBtn).click();
	}
	
	public void enterEmail(String email) {
		ldriver.findElement(txtEmail).sendKeys(email);
	}
	
	public void enterPassword(String password) {
		ldriver.findElement(txtPassword).sendKeys(password);
	}
	
	public void enterFirstName(String fname) {
		ldriver.findElement(firstName).sendKeys(fname);
	}
	
	public void enterLastName(String lname) {
		ldriver.findElement(lastName).sendKeys(lname);
	}
	
	public void enterGender(String gender) {
		if(gender.equals("Male")) 
		{
			ldriver.findElement(maleGender).click();
		}
		else if (gender.equals("Female")) 
		{
			ldriver.findElement(femaleGender).click();
		}
		else 
		{
			ldriver.findElement(maleGender).click(); //Default
		}
	}
	
	public void enterCompanyName(String coname) {
		ldriver.findElement(companyName).sendKeys(coname);
	}
	
	public void selectChecbox(By locator) {
		WebElement checkbox = ldriver.findElement(locator);
		if(!checkbox.isSelected());   //check if already selected
			checkbox.click();
		//selectChecbox(Locator);
		
	}
	public void deselectChecbox(By locator) 
	{
		WebElement checkbox = ldriver.findElement(locator);
		if(checkbox.isSelected())   //check if already selected
			checkbox.click();
		//deselectChecbox(Locator);
	}
	public void selectTaxExempt()
	{
		selectChecbox(taxExempt);
	}
	public void enterNewsletter(By locator) {
		ldriver.findElement(locator).click();    //click drpdwn
	}
	public void selectNewSletter() {
		enterNewsletter(newsletter);
	}
	
	/*public void selectCustomerRole(String role) throws InterruptedException {
		
		ldriver.findElement(txtCustomerRoles).click();
		Thread.sleep(3000);
		WebElement listitem;
		try {
			WebElement defaultRole =ldriver.findElement(By.xpath("//span[@title='delete']"));
			defaultRole.click();
		}catch (Exception e) {
			
		}
		if(role.equals("Administrators")) 
		{
			listitem=ldriver.findElement(rd_Administrators);
		}
		else if (role.equals("Forum Moderators")) 
		{
			listitem=ldriver.findElement(rd_Forum_Moderators);
		}
		else if (role.equals("Registered")) 
		{
			listitem=ldriver.findElement(rd_Registered);
		}	
		else if (role.equals("Guests")) 
		{
			listitem=ldriver.findElement(rd_Guests);
		}
		else  
		{
			listitem=ldriver.findElement(rd_Vendors);
		}
		listitem.click();
		
		JavascriptExecutor js = (JavascriptExecutor)ldriver;
		js.executeScript("arguments[0].click();", listitem);
	}
	*/
	public void enterManagerVendor(String value) {
		Select drp=new Select(ldriver.findElement(drpdwnMgrVendors));
		drp.selectByVisibleText(value);
	}
	
//	public void enteractive() {
//		ldriver.findElement(active).click();
//	}
//	
//	public void enterCustomerchangePassword() {
//		ldriver.findElement(change_Password).click();
//	}
	
	public void enterAdminContent(String content) {
		ldriver.findElement(admin_Content).sendKeys(content);
	}
	
	public void clickOnSave() {
		ldriver.findElement(save_btn).click();
	}
}	
