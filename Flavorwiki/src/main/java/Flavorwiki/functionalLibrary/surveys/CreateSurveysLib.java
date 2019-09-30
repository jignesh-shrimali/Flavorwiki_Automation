package Flavorwiki.functionalLibrary.surveys;

import org.openqa.selenium.WebDriver;

import Flavorwiki.functionalLibrary.common.CommonLib;
import Flavorwiki.pageObjects.login.LoginPO;
import Flavorwiki.pageObjects.surveys.CreateSurveysPO;
import utilities.SeleniumHelpers;

public class CreateSurveysLib {

	WebDriver driver;
	SeleniumHelpers selenium;
	CreateSurveysPO surveypo;
	CommonLib common;
	

	
	 public CreateSurveysLib(WebDriver driver) {
		    this.driver = driver;
	        selenium = new SeleniumHelpers(driver);
	        surveypo = new CreateSurveysPO(driver);
	        common = new CommonLib(driver);
	}
	 

	 
	 

}
