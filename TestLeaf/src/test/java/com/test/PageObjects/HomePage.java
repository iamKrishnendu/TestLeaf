package com.test.PageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.test.controller.BrowserHandler;

/**
 * 
 * @author KRISHNENDU
 * @category Contains All locators or elements of Homepage. Followed by PageFactory 
 * */


public class HomePage {
	
	public HomePage() {
		PageFactory.initElements(BrowserHandler.getDriver(), this);
	}
	
	@FindBy(how=How.CSS,using="input[id='user_name']")
	public WebElement username;
	
	@FindBy(how=How.CSS,using="input[id='user_password']")
	public WebElement password;
	
	@FindBy(how=How.CSS,using="button[id='sysverb_login']")
	public WebElement logIn_button;
	
	@FindBy(how=How.CSS,using="iframe[aria-label='Main content']")
	public WebElement iFrame;
	
	@FindBy(how=How.CSS,using="input[id='filter']")
	public WebElement filterNavigator;
	
	@FindBy(how=How.CSS,using="table[id='homepage_grid']")
	public WebElement homepageGrid;
	
	@FindBy(how=How.XPATH,using="//ul[@aria-label='Modules for Application: Problem']//div[contains(text(),'Create New')]")
	public WebElement Create_New_link;
	
	@FindBy(how=How.XPATH,using="//div[@aria-label='Problem form section']//table[1]")
	public WebElement problem_presentation_section;
	
	@FindBy(how=How.XPATH,using="//div[@aria-label='Problem form section']//input[@aria-label='Number']")
	public WebElement problem_number;
	
	@FindBy(how=How.XPATH,using="(//div[@aria-label='Problem form section']//span[@class='input-group-btn'])[1]//button")
	public WebElement lookup_icon_firstReportedBy;
	
	@FindBy(how=How.XPATH,using="//tbody[@class='list2_body']//a")
	public List<WebElement>list_of_numbers;
	
	@FindBy(how=How.CSS,using="select[id='problem.category']")
	public WebElement category_dropdown;
	
	@FindBy(how=How.CSS,using="select[id='problem.subcategory']")
	public WebElement subCategory_drodown;
	
	@FindBy(how=How.XPATH,using="(//div[@aria-label='Problem form section']//span[@class='input-group-btn'])[2]//button")
	public WebElement servive_lookup_icon;
	
	@FindBy(how=How.XPATH,using="(//div[@aria-label='Problem form section']//span[@class='input-group-btn'])[3]//button")
	public WebElement configuration_item_lookup;
	
	@FindBy(how=How.XPATH,using="//div[@class='input-group']//input")
	public WebElement search_box;
	
	@FindBy(how=How.XPATH,using="(//button[@data-original-title='Next page'])[1]")
	public WebElement nextPageButton;
	
	@FindBy(how=How.CSS,using="input[aria-label='Problem statement']")
	public WebElement problemStatement;
	
	@FindBy(how=How.CSS,using="textarea[aria-label='Description']")
	public WebElement description;
	
	@FindBy(how=How.CSS,using="select[aria-label='State']")
	public WebElement stateField;
	
	@FindBy(how=How.CSS,using="select[aria-label='State'] option")
	public List<WebElement>stateOptions;
	
	@FindBy(how=How.CSS,using="select[name='problem.impact']")
	public WebElement impact;
	
	@FindBy(how=How.CSS,using="select[name='problem.urgency']")
	public WebElement urgency;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Assigned to')]/following::input[4]")
	public WebElement assignTo;
	
	@FindBy(how=How.XPATH,using="(//button[@value='sysverb_insert'])[2]")
	public WebElement submitButton;
	
	@FindBy(how=How.XPATH,using="//tbody[@class='list2_body']//tr//td[3]//a")
	public WebElement problemNumber_from_grid;
	
	public WebElement getAssignTo() {
		return assignTo;
	}

	public WebElement getProblemNumber_from_grid() {
		return problemNumber_from_grid;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public WebElement getImpact() {
		return impact;
	}

	public WebElement getUrgency() {
		return urgency;
	}

	public WebElement getStateField() {
		return stateField;
	}

	public WebElement getProblemStatement() {
		return problemStatement;
	}

	public WebElement getDescription() {
		return description;
	}

	public List<WebElement> getStateOptions() {
		return stateOptions;
	}

	public WebElement getSearch_box() {
		return search_box;
	}

	public WebElement getNextPageButton() {
		return nextPageButton;
	}

	public WebElement getConfiguration_item_lookup() {
		return configuration_item_lookup;
	}

	public WebElement getServive_lookup_icon() {
		return servive_lookup_icon;
	}

	public WebElement getSubCategory_drodown() {
		return subCategory_drodown;
	}

	@FindBy(how=How.CSS,using="select[id='problem.subcategory']  option")
	public List<WebElement>subCategory_drodown_options;

	public List<WebElement> getSubCategory_drodown_options() {
		return subCategory_drodown_options;
	}

	public WebElement getCategory_dropdown() {
		return category_dropdown;
	}

	public List<WebElement> getList_of_numbers() {
		return list_of_numbers;
	}

	public WebElement getLookup_icon_firstReportedBy() {
		return lookup_icon_firstReportedBy;
	}

	public WebElement getProblem_number() {
		return problem_number;
	}

	public WebElement getProblem_presentation_section() {
		return problem_presentation_section;
	}

	public WebElement getCreate_New_link() {
		return Create_New_link;
	}

	public WebElement getHomepageGrid() {
		return homepageGrid;
	}

	public WebElement getFilterNavigator() {
		return filterNavigator;
	}

	public WebElement getiFrame() {
		return iFrame;
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLogIn_button() {
		return logIn_button;
	}

	

}
