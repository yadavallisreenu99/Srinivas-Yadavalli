package stepDefinitions;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;

import PageObjects.TestNGDemo.LoginPage;
import org.testng.Assert;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class loginTest extends TestBase {
	
	
	LoginPage lp = new LoginPage(getDriver());
	
	@Before
	public void setUp()
	{
		PageFactory.initElements(getDriver(),lp);
		
		
	}
	
	@Given("navigate to openMRS application")
	public void navigate_to_open_mrs_application() throws IOException {
		
		String url1 = getProperties().getProperty("url");
		
		System.out.println("URl is " +url1);
		
		
		getDriver().get(url1);
	    
	}

	@When("user is on openMRS login page")
	public void user_is_on_open_mrs_login_page() {
		
		assertEquals("LOGIN", lp.verifyloginPage());
		
	//	Assert.assertEquals("Login", lp.verifyloginPage());
	   
	}

	@Then("enter loginID and password")
	public void enter_login_id_and_password() throws IOException {
		
		String uName = getProperties().getProperty("UID");
		String pwd = getProperties().getProperty("password");
		
		lp.loginCredentials(uName, pwd);
	  
	}

	@Then("click on login button")
	public void click_on_login_button() {
		
		lp.clickLoginBtn();
	    
	}

	@Then("user should navigate to openMRS home page")
	public void user_should_navigate_to_open_mrs_home_page() {
		assertEquals("Logged in as Super User (admin) at Inpatient Ward.", lp.homePageLocation());
		//Assert.assertEquals("Logged in as Super User (admin) at Inpatient Ward.", lp.homePageLocation());
		getDriver().close();
	   
	}


}
