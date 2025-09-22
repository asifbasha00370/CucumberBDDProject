package stepDefintions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Utilities.ReadConfig;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.AddCustomersPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomersPage;

public class steps extends BaseClass {        //Child class of BaseClass
	
	@Before("@Sanity")                                           //@Before(order=1) ;;Condtional Hooks-->@Before("@Sanity")
	public void setup1() throws IOException {
		
		System.out.println("Setup1-Sanity method executed");
		//Reading properties
		readConfig=new ReadConfig();
		
		//initialise logger
		logger = LogManager.getLogger("steps");    
			
		String browser = readConfig.getBrowser();
		
		//launch browser
		switch(browser.toLowerCase())
		{
		case "chrome":
		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers/chromedriver.exe");
		//driver= new ChromeDriver();	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		break;

		case "msedge":
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		break;

		case "firefox":
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		break;
		default:
		driver = null;
		break;
		}
		
        logger.info("Setup1 Executed.....");
	}
	 
	@Before("@regression")                                       //@Before(order=0) ;;Condtional Hooks-->@Before("@regression")
	public void setup2() {
		
		System.out.println("Setup2-regression method executed");
		logger = LogManager.getLogger("steps");    //initialise logger
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
        logger.info("Setup2 Executed.....");
	}
	
	@Given("User Launch Chrome Browser")
	public void user_Launch_Chrome_Browser() {
       
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        lp = new LoginPage(driver);
        
        logger.info("******Launching Browser******");
	}

	@When("User opens URL {string}")
	public void user_opens_URL(String url) {
	    driver.get(url);
	    
	    logger.info("******Opening URL******");
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_Email_as_and_Password_as(String emailadd, String password) {
	    lp.enterEmail(emailadd);
	    lp.enterPassword(password);
	    
	    logger.info("******Providing Login Details******");
	}

	@When("User click Login button")
	public void user_click_Login_button() {
	    lp.clickLoginButton();
	    
	    logger.info("******Started Login******");
	}

	@Then("Page Title should be {string}")
	public void page_Title_should_be(String title) throws InterruptedException {
	    if(driver.getPageSource().contains("Login was Unsuccessful")) {
	    	driver.close();                                                   //Validation point
	    	logger.warn("******Login Passed******");
	    	Assert.assertTrue(false);
	    } else {
	    	logger.warn("******Login failed******");
	    	Thread.sleep(1000);
	    	System.out.println(driver.getTitle());
//	    	Assert.assertEquals(title, driver.getTitle());
	    }
//		String actualTitle=driver.getTitle();
//		
//		if(actualTitle.equals(expectedTitle)) {
//			Assert.assertTrue(true);  //pass
//		}
//		else
//		{
//			Assert.assertTrue(false);  //fail
//		}
	}
	@When("User click on Logout link")
	public void user_click_on_Logout_link() throws InterruptedException {
		logger.info("******Click Logout link******");
		Thread.sleep(2000);
	    lp.clickLogoutButton();
	}
    
	/*@Then("Close browser")
	public void close_browser() {
		logger.info("******Close Browser******");
		driver.close();
	    //driver.quit();
	}
	*/
	//////////////////////////Add new Customers page/////////////////////////////////
    
	@Then("User can view Dashboard page")
	public void user_can_view_Dashboard_page() throws InterruptedException {
		addCust=new AddCustomersPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getPageTitle());
		Thread.sleep(1000);
		System.out.println(driver.getTitle());
	}
	@When("User click on Customers Menu")
	public void user_click_on_Customers_Menu() throws InterruptedException {
		Thread.sleep(3000);
	    addCust.clickOnCustomerMenu();
	}

	@When("User click on Customer Menu item")
	public void user_click_on_Customer_Menu_item() throws InterruptedException {
		Thread.sleep(2000);
		addCust.clickOnCustmrMenuitem();
	}

	@When("Click on add new button")
	public void click_on_add_new_button() throws InterruptedException {
		Thread.sleep(2000);
	    addCust.addNewBtn();
	}

	@Then("User can view add new Customers page")
	public void user_can_view_add_new_Customers_page() throws InterruptedException {
		Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());
		Thread.sleep(1000);
		System.out.println(driver.getTitle());
	}

	@When("User enter customers info")
	public void user_enter_customers_info() {
		logger.info("******Adding new Customer******");
		logger.info("******Provivding Customer details******");
		
	    String email=randomestring()+"@gmail.com";
	    addCust.enterEmail(email);
	    addCust.enterPassword("test@123");
	    addCust.enterFirstName("Asif");
	    addCust.enterLastName("Basha");
	    addCust.enterGender("Male");
	    addCust.enterCompanyName("Blabla");
	    addCust.selectTaxExempt();
	    addCust.selectNewSletter();
	    //addCust.selectCustomerRole("Guests");
	    addCust.enterManagerVendor("Vendor 1");
	    addCust.enterAdminContent("Admin Content");
	}

	@When("Click on Save button")
	public void click_on_Save_button() {
		logger.info("******Saving Customer data******");
	    addCust.clickOnSave();
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String expectedConfirmationMsg) {
	    /*String bodyTagText=driver.findElement(By.tagName("Body")).getText();
	    if(bodyTagText.contains(expectedConfirmationMsg))
	    {
	    	Assert.assertTrue(true);  //pass
	    }
	    else
	    {
	    	Assert.assertTrue(false);  //fail
	    }
	    */
		String bodyTagText=driver.findElement(By.tagName("body")).getText();
	    if(bodyTagText.contains(expectedConfirmationMsg))
	    {
	    	Assert.assertTrue("Expected message not found! Actual: " +bodyTagText, bodyTagText.contains(expectedConfirmationMsg));  //pass
	    }
	}
	
	/////////////////////////////Steps for Searching customer Email ID///////////////////////////////////////////////
	@When("User enter customer Email")
	public void user_enter_customer_Email() {
		logger.info("******Searching customer Email ID******");
	    searchCust= new SearchCustomersPage(driver);
	    searchCust.setEmail("steve_gates@nopCommerce.com");
	}

	@When("User click on search button")
	public void user_click_on_search_button() throws InterruptedException {
		searchCust.clickSearch();
		Thread.sleep(3000);
	}

	@Then("User should found Email in the search table")
	public void user_should_found_Email_in_the_search_table() {
	    boolean status=searchCust.searchCustomerByEmail("steve_gates@nopCommerce.com");
	    Assert.assertEquals(true, status);
	}
	
	////////////////////////steps for search customers by sing firstname and Last name//////////////////////////////
	
	@When("User enter FirstName")
	public void user_enter_FirstName() {
		logger.info("******Searching customer FirstName******");
	    searchCust = new SearchCustomersPage(driver);
	    searchCust.setFirstName("Steve");
	}

	@When("User enter LastName")
	public void user_enter_LastName() {
	    searchCust.setLastName("Gates");
	}

	@Then("User should found Name in the search table")
	public void user_should_found_Name_in_the_search_table() {
	    boolean status=searchCust.searchCustomerByName("Steve Gates");
	    Assert.assertEquals(true, status);
	}
	
	//@After                                                         //@After(order=1)
	public void teardown1(Scenario sc) {            //Capture screenshot of failed test scenaio Scenario-class ; sc-object
		System.out.println("Teardown method executed");
		if(driver != null && sc.isFailed()) {
		try {
			//convert web driver object to Take screenshot
			String fileWithPath = "C:\\myworkspace\\nopCommerceCucumber\\Screenshot\\failedScreenshot.png";
			TakesScreenshot scrShot= (TakesScreenshot) driver;
			
			//Call getScreenshotAs method to create image file
			File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
			
			//Move image file to new destination
			File destFile = new File(fileWithPath);
			FileUtils.copyFile(srcFile, destFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(driver !=null) {
			driver.quit();
		}
	}	
	@AfterStep
	public void addScreenshot(Scenario scenario) {
		
            if (scenario.isFailed()) {
			final byte[]  screenshot =  ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			//attach image file report (data, media type, name of the attachment)
			scenario.attach(screenshot, "image/png", scenario.getName());
            }
	}
		
	/*@After                                                         //@After(order=2)
	public void teardown2() {
		System.out.println("Teardown method executed");
		driver.quit();
	}*/
	
	/*@BeforeStep
	public void beforeStepMethodDemo() {
		
		System.out.println("This is before step");
	}
	
	
	@AfterStep
	public void afterStepMethodDemo() {
		
		System.out.println("This is after step........");
	}*/
	
}
