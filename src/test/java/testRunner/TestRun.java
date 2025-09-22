package testRunner;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions( 
		  features   = {".//Features/Login.feature",".//Features/Customers.feature"},  
		  glue       = {"stepDefintions"},
		  dryRun     = false,
		  monochrome = true, 
		  plugin     = {
			 "pretty",
			 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",  //for extent report
			 "html:target/cucumber-reports/reports1.html",
			 "json:target/cucumber-reports/report_json.json",
			 "junit:target/cucumber-reports/report_xml.xml"},
		  tags = ""
/*{".//Features/"},		  
//{".//Features/Customers.feature",".//Features/Login.feature"}, 
//tags= {"@Sanity"},     //scenarios under @sanity tag will be executed
tags="@Sanity or @regression", //tags="@sanity and not @regression",
*/		)
public class TestRun extends AbstractTestNGCucumberTests{	
	

}
