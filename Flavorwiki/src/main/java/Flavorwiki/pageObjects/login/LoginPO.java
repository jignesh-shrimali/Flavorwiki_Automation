package Flavorwiki.pageObjects.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utilities.Constants;
import utilities.SeleniumHelpers;

public class LoginPO 
{
	WebDriver driver;
	SeleniumHelpers selenium;
	
	public LoginPO(WebDriver driver)
	{	 
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);

        //This initElements method will create all WebElements
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, Constants.PAGEFACTORY_WAIT_DURATION), this);
	}
	
	
	/*
	 * All WebElements are identified by @FindBy annotation
	 * @FindBy can accept tagName, partialLinkText, name, linkText, id, css, className, xpath as attributes.
	 */ 	
	
		@FindBy(name="email")
	    private WebElement userName;
		
		@FindBy(name="password")
		private WebElement passWord;
		
		@FindBy(css=".ant-spin-container")
		private WebElement signin;
		
		@FindBy(css=".styles__Text-sc-9s8mvr-2.drwCUz")
		private WebElement errorMessage;
		
		
		
		public void enterUsername(String username)
		{
			userName.clear();
			userName.sendKeys(username);
		}
		
		public void enterPassword(String password)
		{
			passWord.clear();
			passWord.sendKeys(password);
		}
		
		public void clickOnLogin()
		{
			signin.click();
		}
		
		public String getErrorMessage()
		{
			return errorMessage.getText().trim();
		}
		
}
