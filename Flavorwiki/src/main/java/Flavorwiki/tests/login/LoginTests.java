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
	}
	

	@BeforeMethod
	public void beforeMethod()
	{
		sfassert = new SoftAssert();
		ex = new ExceptionHandler(driver);
	}
	
	
	/*Test 1 : Verify that user can't login with incorrect credentials */
	@Test (priority = 1)
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
	
	
	/*Test 2 : Verify that user can login/logout/change password successfully*/
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
	}
	
	
	@AfterClass
	public void tearDown() throws Exception
	{
		drivermanager.tearDown();
	}  
	
}
