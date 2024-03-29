package Flavorwiki.pageObjects.common;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utilities.Constants;
import utilities.JavaHelpers;
import utilities.SeleniumHelpers;

public class ItemListPO 
{
	WebDriver driver;
	SeleniumHelpers selenium;
	CommonPO help;
	JavaHelpers java;
	
	public ItemListPO(WebDriver driver)
	{	 
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);
        help = new CommonPO(driver);
        java = new JavaHelpers();

        //This initElements method will create all WebElements
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, Constants.PAGEFACTORY_WAIT_DURATION), this);
	}
	
	
	/*
	 * All WebElements are identified by @FindBy annotation
	 * @FindBy can accept tagName, partialLinkText, name, linkText, id, css, className, xpath as attributes.
	 */ 
				
	
	//Search section
	
		@FindBy(css="div[id='griddata'] > table > tbody > tr > td:nth-of-type(5) > a")
		private WebElement search_FirstItem;
	
		@FindBy(css=".no-records > span")
		private WebElement search_NoRecordMsg;	
				
		@FindBy(css="#item-list ul li")
		private List<WebElement> search_AllItems;
		
	
	
		//Search method
			public void search_SearchWithTextType(String text,WebElement e)
			{
				e.clear();
				e.sendKeys(text);
			}
			
			
			public void search_SearchWithSelectCheckbox(WebElement e)
			{
				if(!e.isSelected())
				{
					e.click();
				}
			}
			
			
			public void search_SearchWithUnSelectCheckbox(WebElement e)
			{
				if(e.isSelected())
				{
					e.click();
				}
			}
			
			
			public void search_ClickOnFirstSearchedItem()
			{	
				selenium.waitTillElementIsClickable(search_FirstItem).click();
			}
			
			
			public void search_ClickOnFirstSearchedItem(WebElement e)
			{
				selenium.waitTillElementIsClickable(e).click();
			}
			
			
			public boolean search_IsFirstSearchedItemDisplayed()
			{
				try 
				{
		            return search_FirstItem.isDisplayed();
				} 
				catch (Exception e) 
				{
		            return false;
		        }
			}

			
			public String search_GetNoRecordMsgText()
			{
				return search_NoRecordMsg.getText().trim();
			}
		
			
			public int list_GetTotalItems()
			{
				return search_AllItems.size();
			}
			
		
		
	
			
			
			
}

