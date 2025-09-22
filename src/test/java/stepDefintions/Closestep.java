package stepDefintions;

import io.cucumber.java.en.Then;

public class Closestep extends BaseClass {
	
	@Then("Close browser")
	public void close_browser() {
		
		logger.info("******Close Browser******");
		driver.close();
	    //driver.quit();
	}

}
