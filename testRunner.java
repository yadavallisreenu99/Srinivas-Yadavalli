package Runner;

import java.io.File;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;



@CucumberOptions(
		
		features = "src/main/java/Features/login.feature",
		glue = "stepDefinitions",
		format = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"},
		
		plugin = {"pretty:STDOUT",
				"html:target\\cucumber-pretty",
				"json:target\\cucumber-json\\cucumber.json",
				"com.cucumber.listener.ExtentCucumberFormatter:target\\cucumber-extent\\report.html"}
		
		)


public class testRunner {
	
	
	
	 private TestNGCucumberRunner testNGCucumberRunner;
	 
	    @BeforeClass(alwaysRun = true)
	    public void setUpClass() throws Exception {
	    	
	        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	       
	    }
	 
	    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
	    public void feature(CucumberFeatureWrapper cucumberFeature) {
	        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	    }
	 
	    @DataProvider
	    public Object[][] features() {
	        return testNGCucumberRunner.provideFeatures();
	    }
	    
	    
	    @AfterClass(alwaysRun = true)
	    public void tearDownClass() throws Exception {
	    	Reporter.loadXMLConfig(new File("Resources/extent-config.xml"));
	        testNGCucumberRunner.finish();
	    }

}
