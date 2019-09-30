package Flavorwiki.pageObjects.surveys;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utilities.Constants;
import utilities.SeleniumHelpers;

public class CreateSurveysPO 
{
	
	private static final String WebDriver = null;
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
		
		@FindBy(css=".ant-select-selection-selected-value[title='public']")
		public WebElement AutorizationTypePublic; 
		
		@FindBy(css=".ant-select-selection-selected-value[title='email']")
		public WebElement AuthorizationTypeEmail;
		
		@FindBy(css=".ant-select-selection-selected-value[title='selected']")
		public WebElement AuthorizationTypeSelected;
		
		@FindBy(xpath="//div[contains(text(),'Products')]")
		public WebElement ProductTab;
		
		@FindBy(xpath="//*[@data-testid='new-product-button']")
		public WebElement NewProductButton;
		
		@FindBy(name="name")
		public WebElement ProductName;
		
		@FindBy(name="brand")
		public WebElement BrandName;
		
		@FindBy(xpath="//*[@data-icon='plus']")
		public WebElement ProductPhoto;
		
		@FindBy(xpath="//div[contains(text(),'Questions')]")
		public WebElement ClickOnQuestionTab;
		
		@FindBy(css=".ant-tabs-nav.ant-tabs-nav-animated > div> div:nth-of-type(3)")
		public WebElement ScreeningTab;
	
		@FindBy(css=".ant-tabs-nav.ant-tabs-nav-animated > div> div:nth-of-type(4)")
		public WebElement BeforeProductionselectionTab;
		
		@FindBy(css=".ant-tabs-nav.ant-tabs-nav-animated > div> div:nth-of-type(5)")
		public WebElement TastingloopTab;
		
		@FindBy(css=".ant-tabs-nav.ant-tabs-nav-animated > div> div:nth-of-type(6)")
		public WebElement Aftertastingtab;
		
		@FindBy(xpath="//*[@data-testid='new-step-button']")
		public WebElement NewStepInSurveyButton;
		
		@FindBy(xpath="//*[@class=\"ant-tabs-tab-active ant-tabs-tab\"]")
		public WebElement Question;
		
		@FindBy(xpath="//button[@class='ant-btn styles__ButtonWithMargin-sc-1wuhaqx-0 kzrrHU styles__SecondaryButton-v0kam7-4 kLYJCE styles__CustomButtonStyle-v0kam7-0 exqTlp']")
		public WebElement SaveDraftButton;
		
		
		@FindBy(xpath="//span[contains(text(),'Publish')]")
		//@FindBy(xpath="//button[@data-testid='publish-survey-button']")
		public WebElement PublishButton;
	
		@FindBy(xpath="//*[@data-icon='down']")
		public WebElement Choosetypeofquestion;
		
		@FindBy(xpath="//div[@class='styles__Container-w7xl2u-0 juYUZi']//span[1]//*[@data-icon='down']")
		public WebElement TypeOfChart;
		
		@FindBy(xpath="//li[contains(text(),'Choose Date')]")
		//@FindBy(xpath="//*[@data-testid='questionType-select-option-0']")
		public WebElement ChooseDateQustion;
		
		//Question text for Question
		@FindBy(xpath="//*[@name='prompt']")
		public WebElement QuestionText;
		
		
		//title information
		@FindBy(xpath="//textarea[@name='prompt']")
		public WebElement TitleInformation;
		
		//Chart column type
		@FindBy(xpath="//li[contains(text(),'Column')]")
		public WebElement ColumnChart;
		
		//Information Text
		@FindBy(className="public-DraftStyleDefault-block public-DraftStyleDefault-ltr")
		public WebElement InformationText;
		
		@FindBy(xpath="//input[@name='chartTopic']")
		public WebElement ChartTopic;
		
		@FindBy(xpath="//*[@name='chartTitle']")
		public WebElement ChartTitle;
		
		//Answer label
		@FindBy(xpath="//*[@name='0-label']")
		public WebElement Answer_Label1;
		
		@FindBy(xpath="//*[@name='1-label']")
		public WebElement Answer_Label2;
		
		@FindBy(xpath="//div[@class='styles__Container-w7xl2u-0 juYUZi']/div[8]//input[@placeholder='Analytics Value']")
		public WebElement Analytics_Value_One;
		
		@FindBy(xpath="//div[@class='styles__Container-w7xl2u-0 juYUZi']/div[7]//input[@placeholder='Analytics Value']")
		public WebElement Analytics_Value_Two;
		
		@FindBy(xpath="//li[contains(text(),'Choose Multiple')]")
		public WebElement ChooseMultipleQuestion;
		
		@FindBy(css="li[data-testid='questionType-select-option-1']")
		public WebElement ChooseOneQuestion;
		
		@FindBy(css="li[data-testid='questionType-select-option-2']")
		public WebElement ChooseProductQuestion;
		
		@FindBy(css="li[data-testid='questionType-select-option-3']")
		public WebElement ChooseDropdownQuestion;
		
		
		@FindBy(xpath="//li[contains(text(),'Email')]")
//		@FindBy(css="li[data-testid='questionType-select-option-4']")
		public WebElement ChooseEmailQuestion;
		
		@FindBy(xpath="//li[contains(text(),'Info')]")
		public WebElement ChooseInfoQuestion;
		
		@FindBy(xpath="//li[contains(text(),'Open Answer')]")
		public WebElement ChooseOpenAnswerQuestion;
		
		@FindBy(xpath="//li[contains(text(),'Paired Questions')]")
		public WebElement ChoosePairedQuestion;
		
		@FindBy(xpath="//li[contains(text(),'Select And Justify')]")
		public WebElement SelectAndJustifyQuestion;
		
		@FindBy(xpath="//li[contains(text(),'Slider')]")
		public WebElement ChooseSliderQuestion;
		               
		@FindBy(xpath="//li[contains(text(),'Upload Picture')]")
		public WebElement ChooseUploadPictureQuestion;
		
		@FindBy(xpath="//li[contains(text(),'Vertical Rating')]")
		public WebElement ChooseVerticleRatingQuestion;
		
	
			
		
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
		

		public void SelectPublicType()
		{
			AutorizationTypePublic.click();
		}
		
		public void SelectEmailType()
		{
			
			AuthorizationTypeEmail.click();
		}
		
		public void Select_SelectedType()
		{
			AuthorizationTypeSelected.click();
		}
		
		public void ClickOnProduct()
		{
			ProductTab.click();
		}
	
		
		public void ClickOnNewProductButton()
		{
			NewProductButton.click();
		}
		
		public void EnterProductName()
		{
			ProductName.sendKeys("Pizza");
		}

		public void EnterBrandName()
		{
			BrandName.sendKeys("Pizzeria");
		}
		
		public void SelectProductPhoto()
		{
			ProductPhoto.isSelected();
		}
		
		public void ClickOnQuestion()
		{
			ClickOnQuestionTab.click();
		}
		
		
		public void TypeOfQuestion() throws InterruptedException
		{
			Choosetypeofquestion.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			ChooseEmailQuestion.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			QuestionText.sendKeys("Enter valid email..");
		}

		public void Select_TypeOfQuestion_ChooseDate() throws InterruptedException
		{
			Choosetypeofquestion.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			ChooseDateQustion.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			QuestionText.sendKeys("Enter dob?");
			
			
		}
		
		public void Select_TypeOfQuestion_ChooseEmail() throws InterruptedException
		{
			Choosetypeofquestion.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			ChooseEmailQuestion.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			QuestionText.sendKeys("Enter valid email..");
		}
		

		public void Select_TypeOfQuestion_ChooseMultiple() throws InterruptedException
		{
			Choosetypeofquestion.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			ChooseMultipleQuestion.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			TypeOfChart.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			ColumnChart.click();
			ChartTopic.sendKeys("Foods");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			ChartTitle.sendKeys("abc");
			QuestionText.sendKeys("Food");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Answer_Label1.sendKeys("pizza");
			Analytics_Value_One.sendKeys("yes");
			Answer_Label2.sendKeys("Burger");
			Analytics_Value_Two.sendKeys("yes1");
			
		}
		
		public void Select_TypeOfQuestion_ChooseUpload()
		{
			Choosetypeofquestion.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].scrollIntoView(true);",ChooseUploadPictureQuestion);
			ChooseUploadPictureQuestion.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			QuestionText.sendKeys("Select Photo");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		public void ClickOnScreening()
		{
			ScreeningTab.click();
		}
		
		
		public void ClickOnNewStepButton()
		{
			
			NewStepInSurveyButton.click();
		}
		
		
		public void ClickOnBeforeProductSectionTab()
		{
			BeforeProductionselectionTab.click();
		}
		
		
	
		public void ClickDateQuestion()
		{
			ChooseDateQustion.click();
			
			QuestionText.sendKeys("Enter Dob");
		}
		
	
		public void ClickOnBeforeProductSection()
		{
			BeforeProductionselectionTab.click();
			//ChooseEmailQuestion.click();
			
		}
		
		public void ClickOnEmailQuestion()
		{
			ChooseEmailQuestion.click();
			
		}
		
		public void ClickOnTastingLoop()
		{
			TastingloopTab.click();
		}
		
		public void ClickOnAftertasting()
		{
			Aftertastingtab.click();
		}
	
		public void ClickOnPublishButton() throws InterruptedException
		{ 
			Thread.sleep(2000);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", PublishButton);
			Thread.sleep(4000);
		//	PublishButton.click(); 
			Thread.sleep(3000);
			//WebDriverWait wait = new WebDriverWait(driver, 20);
		//WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("//span[contains(text(),'Publish')]")));
		
		
	/*	WebDriverWait wait = new WebDriverWait(driver, Constants.WEBDRIVER_WAIT_DURATION);
		WebElement element= (WebElement) wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[contains(text(),'Publish')]")));*/
		//element.click();
		
		
		
		}
		
		// Column chart
		public void ClickOnColumnchart()
		{
			ColumnChart.click();
		}

		
}
