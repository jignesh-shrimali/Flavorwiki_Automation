package Flavorwiki.pageObjects.surveys;

import javax.management.loading.PrivateClassLoader;

import org.apache.tika.config.Field;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utilities.Constants;
import utilities.SeleniumHelpers;

public class CreateSurveysPO 
{
	WebDriver driver;
	SeleniumHelpers selenium;
	
	public CreateSurveysPO(WebDriver driver)
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
		
		
		@FindBy(xpath="//*[@data-testid='create-survey-button']")
		public WebElement CreateSurveyButton;
		
		@FindBy(xpath="//*[@class=\"ant-tabs-tab-active ant-tabs-tab\"]")
		public WebElement BasicInfo;
		
		@FindBy(name="name")
		public WebElement BasicInfoName;
		
		@FindBy(xpath="//*[@class=\"ant-tabs-tab-active ant-tabs-tab\"]")
		public WebElement Product;
		
		@FindBy(name="name")
		public WebElement ProductName;
		
		@FindBy(name="brand")
		public WebElement BrandName;
		
		@FindBy(xpath="//*[@data-icon='plus']")
		public WebElement ProductPhoto;
		
		@FindBy(xpath="//*[@class=\"ant-tabs-tab-active ant-tabs-tab\"]")
		public WebElement Question;
		
		@FindBy(xpath="//button[@class='ant-btn styles__ButtonWithMargin-sc-1wuhaqx-0 kzrrHU styles__SecondaryButton-v0kam7-4 kLYJCE styles__CustomButtonStyle-v0kam7-0 exqTlp']")
		public WebElement SaveDraftButton;
		
		
		
		@FindBy(css=".ant-form-item-control.has-success > span div > div[role='combobox']")
		public WebElement Choosetypeofquestion;
		
		@FindBy(css="li[data-testid='questionType-select-option-0']")
		public WebElement ChooseDateQustion;
		
		@FindBy(css="li[data-testid='questionType-select-option-1']")
		public WebElement ChooseMultipleQuestion;
		
		@FindBy(css="li[data-testid='questionType-select-option-2']")
		public WebElement ChooseOneQuestion;
		
		@FindBy(css="li[data-testid='questionType-select-option-3']")
		public WebElement ChooseProductQuestion;
		
		@FindBy(css="li[data-testid='questionType-select-option-4']")
		public WebElement ChooseDropdownQuestion;
		
		@FindBy(css="li[data-testid='questionType-select-option-5']")
		public WebElement ChooseEmailQuestion;
		
		@FindBy(css="li[data-testid='questionType-select-option-6']")
		public WebElement ChooseInfoQuestion;
		
		@FindBy(css="li[data-testid='questionType-select-option-7']")
		public WebElement ChooseOpenAnswerQuestion;
		
		@FindBy(css="li[data-testid='questionType-select-option-8']")
		public WebElement ChoosePairedQuestion;
		
		@FindBy(css="li[data-testid='questionType-select-option-9']")
		public WebElement SelectAndJustifyQuestion;
		
		@FindBy(css="li[data-testid='questionType-select-option-10']")
		public WebElement ChooseSliderQuestion;
		
		@FindBy(css="li[data-testid='questionType-select-option-11']")
		public WebElement ChooseUploadPictureQuestion;
		
		@FindBy(css="li[data-testid='questionType-select-option-12']")
		public WebElement ChooseVerticleRatingQuestion;
		
		//Question text for Question
		@FindBy(name="prompt")
		public WebElement QuestionTextDate;
		
		
				
		
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

		public void ClickCreateSurveyButton()
		{
			CreateSurveyButton.click();
		}
		
		public void ClickBasicInfo()
		{
			BasicInfo.click();
		}
		
		public void EnterInforNameField() {
			BasicInfoName.sendKeys("kalpesh");
		}
		
		public void EnterInfoName(String enterInfoName) {
			// TODO Auto-generated method stub
			BasicInfoName.sendKeys(" ");
		}

		public void Products(String productName2, String brandName2) {
			// TODO Auto-generated method stub
			ProductName.sendKeys("Pizza");
			BrandName.sendKeys("Pizzeria");
		}

		public void EnterQuestionDetails() {
			
			Question.click();
			ChooseDateQustion.click();
			
			
		}

		public void ChooseDateQustion() {
			// TODO Auto-generated method stub
	
			QuestionTextDate.sendKeys("Enter Dob");	
			
			
		}

		
		

		
}
