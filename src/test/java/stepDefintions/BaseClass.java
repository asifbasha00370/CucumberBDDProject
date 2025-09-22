package stepDefintions;



import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import Utilities.ReadConfig;
import pageObjects.AddCustomersPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomersPage;





public class BaseClass {          //parent class we created
	public static WebDriver driver;   // global variable
	public LoginPage lp;       // global variable
	public AddCustomersPage addCust;
	public SearchCustomersPage searchCust;
	public ReadConfig  readConfig;
	public static Logger logger;

	
	// Created for generating ramdom strong for unique email

	public static String randomestring() {
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);
	}
}
