package Flavorwiki.functionalLibrary.login;
import org.openqa.selenium.WebDriver;

import Flavorwiki.functionalLibrary.common.CommonLib;
import Flavorwiki.pageObjects.login.LoginPO;
import utilities.SeleniumHelpers;

public class LoginLib 
{
	WebDriver driver;
	SeleniumHelpers selenium;
	LoginPO loginpo;
	CommonLib common;
	
	public LoginLib(WebDriver driver)
	{	 
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);
        loginpo = new LoginPO(driver);
        common = new CommonLib(driver);
	}
	
	
	/**
	 * Login to application with url, username, and password
	 * @param url login page url
	 * @param username username
	 * @param password password
	 */
	public void loginToApplication(String url, String username, String password)
	{
		selenium.navigateToPage(url);
		loginpo.enterUsername(username);
		loginpo.enterPassword(password);
		loginpo.clickOnLogin();
	}
	
	/**
	 * Login to application 
	 * @param username username
	 * @param password password
	 */
	public void loginToApplication(String username, String password)
	{
		loginpo.enterUsername(username);
		loginpo.enterPassword(password);
		loginpo.clickOnLogin();
	}
	
	/**
	 * Get validation message on login page
	 * @return validation text
	 */
	public String getErrorMessage()
	{
		return loginpo.getErrorMessage();
	}
	
	/**
	 * To check whether error message displayed or not
	 * @return true or false
	 */
	public boolean isErrorMessageDispalyed()
	{
		boolean b = true;
		
		try
		{
			getErrorMessage();
		}
		catch(Exception e)
		{
			b=false;
		}
		return b;
	}
	
}
