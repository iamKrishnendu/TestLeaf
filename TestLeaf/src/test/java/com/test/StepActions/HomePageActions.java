package com.test.StepActions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.log4testng.Logger;

import com.cucumber.listener.Reporter;
import com.test.Base.BaseClass;
import com.test.PageObjects.HomePage;
import com.test.common.GenericKeywords;
import com.test.common.PropertyFileHandler;
import com.test.controller.BrowserHandler;
import com.test.utilities.Encrypter;
import com.test.utilities.PrepareJSON;

/**
 * 
 * @author KRISHNENDU
 * @category Defined the business logics of steps
 * */


public class HomePageActions extends GenericKeywords {

	static Logger log = Logger.getLogger(HomePageActions.class);
	HomePage homepage = new HomePage();
	PropertyFileHandler properties = new PropertyFileHandler();
	Encrypter decrypter = null;
	PrepareJSON json = null;
	
	
	public boolean  login_into_the_ServiceNow_homePage() {
		boolean stepCompletionFlag = false;
		
		try {
			decrypter = new Encrypter();
			String password =decrypter.decrypt(properties.getPropertyValues().getProperty("password")); 
			switchToFrame(homepage.iFrame);
			homepage.username.click();
			enterTextIntoTextBox(homepage.getUsername(),properties.getPropertyValues().getProperty("username"));
			homepage.getPassword().click();
			enterTextIntoTextBox(homepage.getPassword(),password);
			
			stepCompletionFlag = true;
		}catch(Throwable e) {
			log.error(e);
			log.info("Exception occured while completing the step login_into_the_ServiceNow_homePage");
		}
		return stepCompletionFlag;
	}
	
	public boolean click_on_login_button() {
		boolean stepCompletionFlag = false;
		try {
			homepage.logIn_button.click();
			stepCompletionFlag = true;
		}catch(Throwable e) {
			log.error(e);
			log.info("Exception occured while completing the step click_on_login_button");
		}
		return stepCompletionFlag;
		
	}
	
	public boolean click_on_Filter_navigator_textBox_and_enter_text(String textToSearch) {
		boolean stepCompletionFlag = false;
		try {
			
			switchToMainWindow();
			homepage.getFilterNavigator().click();
			enterTextIntoTextBox(homepage.getFilterNavigator(),textToSearch);
			stepCompletionFlag = true;
			
		}catch(Throwable e) {
			log.error(e);
			log.info("Exception occured while completing the step click_on_Filter_navigator_textBox_and_enter_text");
			
		}
		return stepCompletionFlag;
	}
	
	public boolean capture_problemNumber_and_determine_the_field_is_non_editable() {
		boolean testStatus = false;
		try {
				json = new PrepareJSON();
				//switchToFrame(homepage.getiFrame());
				awaitForElementToVisible(homepage.getProblem_number());
				String problemNumber = homepage.getProblem_number().getAttribute("value");
				String property = homepage.getProblem_number().getAttribute("readonly");
				
				if(!problemNumber.isEmpty() && property.equalsIgnoreCase("true")) {
					json.writeIntoJson(problemNumber);
					return testStatus=true;
				}
			
		}catch(Throwable e) {
			log.error(e);
			log.info("Exception occured while completing the step capture_problemNumber_and_determine_the_field_is_non_editable");
		}
		return testStatus;
	}
	
	public String select_number_from_new_window(String number) {
		String actualNumber = null;
		json = new PrepareJSON();
		
		try {
			
			List<WebElement>numbers = homepage.getList_of_numbers();
			for(WebElement eachNumber : numbers) {
				actualNumber = eachNumber.getText();
				if(!actualNumber.isEmpty() && actualNumber.equalsIgnoreCase(number)) {
					
					eachNumber.click();
					return actualNumber;
				}
			}
			
		}catch(Throwable e) {
			log.error(e);
			log.info("Exception occured while completing the step select_number_from_new_window");
		}
		return actualNumber;
	}
	
	public boolean select_max_length_value_from_subCategory() {
		boolean testStatus = false;
		try {
			Thread.sleep(1500);
			int maxLength = 0;
			String longestOption = null;
			List<String>ListOptions = new ArrayList<String>();
			for(WebElement eachOptions : homepage.subCategory_drodown_options) {
				String value = eachOptions.getText(); 
				ListOptions.add(value);
			}
			
			for(int i=0;i<ListOptions.size();i++) {
				String first_value = ListOptions.get(i);
				if(first_value.length()>maxLength) {
					maxLength = first_value.length();
					longestOption = first_value;
				}			
			}
			
			homepage.getSubCategory_drodown().click();
			selectValueFromDropDownBasedOnOptions(homepage.getSubCategory_drodown(),longestOption);
			return testStatus = true;
			
		}catch(Throwable e) {
			log.error(e);
			log.info("Exception occured while completing the step select_max_length_value_from_subCategory");
		}
		return testStatus;
	}
	
	public boolean select_service_option_from_popWindow_and_confirm() {
		boolean testStatus = false;
		String selectedService = null;
		try {
			windowHandler("Child");
			List<WebElement>locator = BrowserHandler.getDriver().findElements(By.xpath("//tbody[@class='list2_body']//tr"));
			By lastOption = By.xpath("//tbody[@class='list2_body']//tr["+locator.size()+"]//td[3]//a");
			scrollToView(BrowserHandler.getDriver().findElement(lastOption));
			selectedService = BrowserHandler.getDriver().findElement(lastOption).getText();
			BrowserHandler.getDriver().findElement(lastOption).click();
			windowHandler("Parent");
			Reporter.addStepLog("Selected Service is: "+selectedService);
			return testStatus = true;
	}catch(Throwable e) {
		log.error(e);
		log.info("Exception occured while completing the step select_service_option_from_popWindow_and_confirm");
	}
		return testStatus;
}
	
	public boolean select_configurationOption_from_theList() {
		boolean testStatus =  false;
		try {
			windowHandler("Child");
			Assert.assertEquals(BrowserHandler.getDriver().getTitle(), "Configuration Items | ServiceNow");
			String totalCount = BrowserHandler.getDriver().findElement(By.xpath("(//div[@class='vcr_controls'])[1]//following::span[4]")).getText();
			
			
			for(int index=0;index<Integer.parseInt(totalCount.replace(",", ""));index++) {
				String subCount = BrowserHandler.getDriver().findElement(By.xpath("(//div[@class='vcr_controls'])[1]//following::span[3]")).getText();
				if(subCount.trim().equals("100")) {
					Thread.sleep(1500);
					String option = BrowserHandler.getDriver().findElement(By.xpath("//tbody[@class='list2_body']//tr[4]//td[3]//a")).getText();
					homepage.getSearch_box().sendKeys(option);
					homepage.getSearch_box().sendKeys(Keys.ENTER);
					Thread.sleep(1500);
					awaitForElementToVisible(BrowserHandler.getDriver().findElement(By.xpath("//tbody[@class='list2_body']//tr[1]//td[3]//a")));
					Assert.assertEquals(BrowserHandler.getDriver().findElement(By.xpath("//tbody[@class='list2_body']//tr[1]//td[3]//a")).getText(), option);
					BrowserHandler.getDriver().findElement(By.xpath("//tbody[@class='list2_body']//tr[1]//td[3]//a")).click();
					Reporter.addStepLog(option+" is selected as Configuration option");
					return testStatus=true;
				}else {
					homepage.getNextPageButton().click();
					Thread.sleep(1500);
				}
			}
			
			
		}catch(Throwable e) {
			log.error(e);
			log.info("Exception occured while completing the step select_configurationOption_from_theList");
		}
		return testStatus;
	}
	
	public boolean enter_problem_statement(String statement) {
		boolean testStatus =  false;
		try {
			String value = statement+"_"+BaseClass.startDate;
			homepage.getProblemStatement().sendKeys(value);
			Reporter.addStepLog(value+ " is provided as Problem Statement");
			return testStatus = true;
			
		}catch(Throwable e) {
			log.error(e);
			log.info("Exception occured while completing the step enter_problem_statement_and_description");
		}
		return testStatus;
	}
	
	public boolean validate_default_state_field_value(String defaultValue) {
		boolean testStatus =  false;
		try {
			List<WebElement>allOptions = homepage.getStateOptions();
			for(WebElement eachOption : allOptions) {
				String optionDisableAttrib = eachOption.getAttribute("disabled");
				String option = eachOption.getText();
				
				if(optionDisableAttrib.equalsIgnoreCase("true") && option.equals(defaultValue)) {
					return testStatus =true;
				}
			}
		}catch(Throwable e) {
			log.error(e);
			log.info("Exception occured while completing the step validate_default_state_field_value");
		}
		return testStatus;
	}
	
	public boolean enter_stored_problem_number_and_hit_enter() {
		boolean testFlag = false;
		try {
			PrepareJSON json = new PrepareJSON();
			awaitForElementToVisible(homepage.getSearch_box());
			homepage.getSearch_box().sendKeys(json.readJson("ProblemNo"));
			performEnter(homepage.getSearch_box());
			Reporter.addStepLog("Serached stored value: "+json.readJson("ProblemNo"));
			return testFlag = true;
		}catch(Throwable e) {
			log.error(e);
			log.info("Exception occured while completing the step enter_stored_problem_number_and_hit_enter");
		}
		return testFlag;
	}
	
	public boolean validate_record_on_the_grid() {
		boolean testFlag = false;
		try {
			
			List<WebElement>records = BrowserHandler.getDriver().findElements(By.xpath("//tbody[@class='list2_body']//tr"));
			Assert.assertEquals(records.size(), 1);
			String problemNumberFromGrid = homepage.getProblemNumber_from_grid().getText();
			Assert.assertEquals(json.readJson("ProblemNo"), problemNumberFromGrid);
			Reporter.addStepLog("Total record found after search with "+json.readJson("ProblemNo")+ " is "+records.size());
			return testFlag = true;
			
		}catch(Throwable e) {
			log.error(e);
			log.info("Exception occured while completing the step validate_record_on_the_grid");
		}
		return testFlag;
	}
}
