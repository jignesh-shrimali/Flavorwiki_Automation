package Flavorwiki.tests.surveys;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

public class SurveysTests
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
/*
  Test 1 : Verify that user can't login with incorrect credentials 
	
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
			 * 
			sfassert.assertAll();
		} 
		catch (AssertionError | Exception e) 
		{
			ex.TakeScreenshotAndLogException(e.getMessage());
		}
	}
*/
	
	/*Test 3: Create Survey*/ 
	@Test(priority = 3)
	public void create_survey()throws IOException
	{
		try
		{
			Reporter.log("Step 1=Enter valid url");
			driver.get("http://flavorwiki-staging.s3-website-eu-west-1.amazonaws.com/onboarding/login");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			
			Reporter.log("Step 2 = Signed in with valid credentials.");
			loginlib.loginToApplication("kmtank.qa@gmail.com", "Admin@123");
			
			Reporter.log("Step 3 = Click on Survey option from the side menu.");
			toppnavigation.clickOnSurveys();
				
			Reporter.log("Step 4 = Click on Create Survey button");
			createsurvey.ClickCreateSurveyButton();	
			
			Reporter.log("Step 5 = Enter valid data in mandatory fields");
			createsurvey.EnterInforNameField();            
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
			Reporter.log("Step 6= Click on Product and add product");
			createsurvey.ClickOnProduct();
			createsurvey.ClickOnNewProductButton();
			createsurvey.EnterProductName();
			createsurvey.EnterBrandName();
			createsurvey.SelectProductPhoto();
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			Reporter.log("Step 7= Click On Screening and enter valid data in mandatory fields");
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			createsurvey.ClickOnScreening();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			createsurvey.ClickOnNewStepButton();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			createsurvey.TypeOfQuestion();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			createsurvey.Select_TypeOfQuestion_ChooseDate();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			Reporter.log("Step 8 = Click On Before product selection and enter valid data in mandatory fields");
			createsurvey.ClickOnBeforeProductSection();
			createsurvey.ClickOnNewStepButton();
			createsurvey.Select_TypeOfQuestion_ChooseEmail();
			  
			 Reporter.log("Step 9 = Click on Tasting loop and Enter valid data in mandatory fields");
			 createsurvey.ClickOnTastingLoop();
			 createsurvey.ClickOnNewStepButton();
			 createsurvey.Select_TypeOfQuestion_ChooseMultiple();
			  
			 Reporter.log("Step 10 = Click on After tasting and enter valid data in mandatory fields");
			 createsurvey.ClickOnAftertasting();
			 Thread.sleep(4000);
			 createsurvey.ClickOnNewStepButton(); 
			 Thread.sleep(5000);
			 createsurvey.Select_TypeOfQuestion_ChooseUpload();
			 Thread.sleep(15000);
			 
			  
			Reporter.log("Step 8 = Click Publish button");
			//seleniumhelpers.javascript_ClickOn(ClickOnPublishButton);
			createsurvey.ClickOnPublishButton();
			Thread.sleep(4000);
			

		}
		catch (AssertionError|Exception e) {  
			
		//	ex.TakeScreenshotAndLogException(e.getMessage());
		}
		
	}
	
	
	/*Test 4: Create Survey - Verify text fields with only space in "basic info" tab 
	@Test(priority = 4)
	
	public void invalid_basicinfo()throws IOException
	{
		try {
		
			Reporter.log("Step 1 = Enter valid URL");
			driver.get("http://flavorwiki-staging.s3-website-eu-west-1.amazonaws.com/onboarding/login");
			
			Reporter.log("Step 2 = Signed in with valid credentials.");
			loginlib.loginToApplication("kmtank.qa@gmail.com", "Admin@123");
			
			Reporter.log("Step 3 = Click on Survey option from the side menu.");
			toppnavigation.clickOnSurveys();
			
			Thread.sleep(3000);
			
			Reporter.log("Step 4 = Click on Create Survey button");
			createsurvey.ClickCreateSurveyButton();
			
			Thread.sleep(2000);
			
			Reporter.log("Step 5 = Enter only space in text fields");
			createsurvey.EnterInfoName(" ");
			
			Thread.sleep(2000);
			
			
		} catch (AssertionError|Exception e) {
			// TODO: handle exception
			ex.TakeScreenshotAndLogException(e.getMessage());
		}
		
		
		
	}
		
	 Test 5: Verify "Unique Name" is generated automatic or not after entered name 
	@Test(priority=5)
	public void Unique_Name()throws IOException
	{
		try {
			
			Reporter.log("Step 1 = Enter valid URL");
			driver.get("http://flavorwiki-staging.s3-website-eu-west-1.amazonaws.com/onboarding/login");
			
			Reporter.log("Step 2 = Signed in with valid credentials.");
			loginlib.loginToApplication("kmtank.qa@gmail.com", "Admin@123");
			
			Reporter.log("Step 3 = Click on Survey option from the side menu.");
			toppnavigation.clickOnSurveys();
			
			Thread.sleep(3000);
			
			Reporter.log("Step 4 = Click on Create Survey button");
			createsurvey.ClickCreateSurveyButton();
			
			Thread.sleep(2000);
			
			Reporter.log("Step 5= Enter valid name of the survey in Name field");
			createsurvey.EnterInforNameField();
			
			Thread.sleep(3000);
			
			Reporter.log("Step 6 = Verify Unique Name field");
			
	
			} catch (AssertionError|Exception e) {
		
			ex.TakeScreenshotAndLogException(e.getMessage());
		}
	}
	
	*/
	
	@AfterClass
	public void tearDown() throws Exception
	{
		drivermanager.tearDown();
	}  
	
}
