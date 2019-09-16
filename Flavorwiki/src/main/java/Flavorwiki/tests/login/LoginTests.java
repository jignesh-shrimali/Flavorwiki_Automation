package Flavorwiki.tests.login;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Flavorwiki.functionalLibrary.common.TopNavigationLib;
import Flavorwiki.functionalLibrary.login.LoginLib;
import Flavorwiki.pageObjects.common.TopNavigationPO;
import Flavorwiki.pageObjects.surveys.CreateSurveysPO;
import utilities.Constants;
import utilities.ExceptionHandler;
import utilities.JavaHelpers;
import utilities.SeleniumHelpers;
import utilities.WebDriverManager;

public class LoginTests 
{
	private WebDriver driver;
	private WebDriverManager drivermanager;
	private TopNavigationLib navigationlib;
	private LoginLib loginlib;
	private SeleniumHelpers selenium;
	private SoftAssert sfassert;
	private ExceptionHandler ex;
	private TopNavigationPO toppnavigation;
	private CreateSurveysPO createsurvey;
	
	//Test Data
	private String propertyFile="test-input/login.properties";
	private String username = JavaHelpers.getPropertyValue(propertyFile,"username_" + Constants.Env);
	private String password = JavaHelpers.getPropertyValue(propertyFile,"password1_" + Constants.Env);
	private String name = JavaHelpers.getPropertyValue(propertyFile,"name_" + Constants.Env);
	private String errorMessage = JavaHelpers.getPropertyValue(propertyFile,"loginErrorMessage");
	
	
	@BeforeClass
	@Parameters({"node", "browser"})
	public void setUp(@Optional("local") String node, @Optional("chrome") String browser) throws Exception
	{
		drivermanager = new WebDriverManager();
		driver = drivermanager.setUp(node,browser);
		navigationlib = new TopNavigationLib(driver);
		loginlib = new LoginLib(driver);
		selenium = new SeleniumHelpers(driver);
		toppnavigation=new TopNavigationPO(driver);
		createsurvey=new CreateSurveysPO(driver);
	}
	

	@BeforeMethod
	public void beforeMethod()
	{
		sfassert = new SoftAssert();
		ex = new ExceptionHandler(driver);
	}
	
	
	/*Test 1 : Verify that user can't login with incorrect credentials */
	/*@Test (priority = 1)
	public void login_Failure() throws IOException
	{
		try {
			Reporter.log("Step 1 = Login to application at : " + Constants.LIVE_URL + " and loging in with incorrect credentails");
			selenium.navigateToPage(Constants.LIVE_URL);
			loginlib.loginToApplication("random@mail.com", "password");
			
			Reporter.log("Step 2 = Verify the validation message displayed");
			sfassert.assertEquals(loginlib.getErrorMessage(), errorMessage);
			
			
			//soft assert
			sfassert.assertAll();
			
		} 
		catch (AssertionError | Exception e) 
		{
			ex.TakeScreenshotAndLogException(e.getMessage());
		}
		
	}
	
	
	Test 2 : Verify that user can login/logout/change password successfully
	@Test (priority = 2)
	public void login_Success() throws IOException
	{
		try 
		{
			Reporter.log("Step 1 = Login to application");
			loginlib.loginToApplication(username, password);
			
			Reporter.log("Step 2 = Verify that user is logged in or not");
			sfassert.assertEquals(navigationlib.getLoggedInUserName(), name);
			
			Reporter.log("Step 3 = Click on logout, and login as new password");
			navigationlib.logout();			

			
			//soft assert
			sfassert.assertAll();
		} 
		catch (AssertionError | Exception e) 
		{
			ex.TakeScreenshotAndLogException(e.getMessage());
		}
	}*/
	
	/*Test 3: Create Survey - Verify all mandatory text fields with valid data in "basic info" tab*/
	@Test(priority = 3)
	public void valid_basicinfo()throws IOException
	{
		try
		{
			Reporter.log("Step 1 = Enter valid URL");
			driver.get("http://flavorwiki-staging.s3-website-eu-west-1.amazonaws.com/onboarding/login");
			
			Reporter.log("Step 2 = Signed in with valid credentials.");
			loginlib.loginToApplication("kmtank.qa@gmail.com", "Admin@123");
			
			Reporter.log("Step 3 = Click on Survey option from the side menu.");
			toppnavigation.clickOnSurveys();
			
			Reporter.log("Step 4 = Click on Create Survey button");
			createsurvey.ClickCreateSurveyButton();
			
			Reporter.log("Step 5 = Enter valid data in mandatory fields");
			createsurvey.EnterNameBasicInfo();
			
			
		}
		catch (AssertionError|Exception e) {
			
			ex.TakeScreenshotAndLogException(e.getMessage());
			
		}
	}
	

	
	
	@AfterClass
	public void tearDown() throws Exception
	{
		drivermanager.tearDown();
	}  
	
}
