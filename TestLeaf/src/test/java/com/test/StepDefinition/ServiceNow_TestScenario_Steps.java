package com.test.StepDefinition;

import org.openqa.selenium.Keys;
import org.testng.Assert;

import com.cucumber.listener.Reporter;
import com.test.PageObjects.HomePage;
import com.test.StepActions.HomePageActions;
import com.test.common.GenericKeywords;
import com.test.controller.BrowserHandler;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * 
 * @author KRISHNENDU
 * @category Defined Step definitions by calling generic methods and step actions
 * */


public class ServiceNow_TestScenario_Steps {

	HomePageActions homepageActions= new HomePageActions();
	HomePage homepage = new HomePage();
	@Given("^ServiceNow Loginpage should get appeared$")
	public void servicenow_Loginpage_should_get_appeared() throws Throwable {
		Assert.assertEquals(BrowserHandler.getDriver().getTitle(), "ServiceNow", "Application title doesn't match");
		 Reporter.addStepLog("User on ServiceNow login Page");
	}

	
	@When("^User enters valid UserName and Password to the respective fields$")
	public void user_enters_valid_UserName_and_Password_to_the_respective_fields() throws Throwable {
		boolean testStatus = homepageActions.login_into_the_ServiceNow_homePage();
	    Assert.assertTrue(testStatus, "Error occured while entering login credentials");
	    Reporter.addStepLog("User successfully entered login credentials");
	}


	@When("^Click on LogIn button$")
	public void click_on_LogIn_button() throws Throwable {
		 Assert.assertTrue(homepageActions.click_on_login_button(), "Error occured while clicking on login button");
		 Reporter.addStepLog("User successfully clicked on login button");
	}

	@Then("^Application should take the user on ServiceNow Homepage$")
	public void application_should_take_the_user_on_ServiceNow_Homepage() throws Throwable {
		GenericKeywords.switchToFrame(homepage.getiFrame());
		Assert.assertTrue(GenericKeywords.elementIsPresent(homepage.getHomepageGrid()), "Homepage grid is not found");
		
	}
	
	@Given("^User should be on ServiceNow homepage$")
	public void user_should_be_on_ServiceNow_homepage() throws Throwable {
		GenericKeywords.switchToMainWindow();
		Assert.assertEquals(GenericKeywords.elementIsPresent(homepage.getFilterNavigator()), true);
		Reporter.addStepLog("User on ServiceNow home Page");
	}
	
	@When("^User click on Filter navigator text box and enters \"([^\"]*)\"$")
	public void user_click_on_Filter_navigator_text_box_and_enters(String valueToSearch) throws Throwable {
		
		Assert.assertTrue(homepageActions.click_on_Filter_navigator_textBox_and_enter_text(valueToSearch), "Unable to enter text in Filter Navigator text box");
		Reporter.addStepLog(valueToSearch+" sucessfully entered to the Filter Navigator text box");
	}

	@When("^Hit Enter and once \"([^\"]*)\" option is apeared click on it$")
	public void hit_Enter_and_once_option_is_apeared_click_on_it(String arg1) throws Throwable {
		GenericKeywords.performEnter(homepage.getFilterNavigator());
		Reporter.addStepLog("sucessfully entered to the Filter Navigator text box");
		
		GenericKeywords.elementIsPresent(homepage.Create_New_link);
		Assert.assertTrue(GenericKeywords.verifyText(homepage.getCreate_New_link(),arg1));
		homepage.getCreate_New_link().click();
		Reporter.addStepLog("Create New option is visible now and performed click on it successfully");
	}
	
	@Then("^New Record sction should be displayed$")
	public void new_Record_sction_should_be_displayed() throws Throwable {
		GenericKeywords.switchToFrame(homepage.getiFrame());
		Assert.assertTrue(GenericKeywords.elementIsPresent(homepage.getProblem_presentation_section()), "Presentation section is not displayed");
		
	}

	@Then("^Record the Problem Number from the non editable field$")
	public void record_the_Problem_Number_from_the_non_editable_field() throws Throwable {
	   Assert.assertEquals(homepageActions.capture_problemNumber_and_determine_the_field_is_non_editable(), true);
	   Reporter.addStepLog("Captured Problem ID successfully and Number field appear as Non Editable");
	}
	
	@Given("^User should be on New Record sction of homepage$")
	public void user_should_be_on_New_Record_sction_of_homepage() throws Throwable {
		Assert.assertTrue(GenericKeywords.elementIsPresent(homepage.getProblem_presentation_section()), "New Record section is not displayed"); 
	}
	
	@When("^User clicks on First Reported By lookup icon$")
	public void user_clicks_on_First_Reported_By_lookup_icon() throws Throwable {
	   homepage.getLookup_icon_firstReportedBy().click();
	   Reporter.addStepLog("First Reported By lookup icon is clicked");
	}
	
	@Then("^User should see a pop up window along with numbers listed$")
	public void user_should_see_a_pop_up_window_along_with_numbers_listed() throws Throwable {
		GenericKeywords.windowHandler("Child");
		Reporter.addStepLog("Child pop up window is displayed along with list of numbers");
	}
	
	@When("^User select a  \"([^\"]*)\" from the list$")
	public void user_select_a_from_the_list(String number) throws Throwable {
		Assert.assertEquals(homepageActions.select_number_from_new_window(number), number);
		Reporter.addStepLog("User selects "+number+" from the list succussfully");
	}

	@Then("^The child pop up window should get closed and user should be on Parent window$")
	public void the_child_pop_up_window_should_get_closed_and_user_should_be_on_Parent_window() throws Throwable {
		GenericKeywords.windowHandler("Parent");
		Reporter.addStepLog("Child pop up window is closed and user landing on Parent window");
	}

	@Given("^User should be on New Record sction of homepage once child pop up is closed$")
	public void user_should_be_on_New_Record_sction_of_homepage_once_child_pop_up_is_closed() throws Throwable {
		GenericKeywords.switchToFrame(homepage.getiFrame());
		Assert.assertTrue(GenericKeywords.elementIsPresent(homepage.getProblem_presentation_section()), "New Record section is not displayed");
	}
	@When("^User clicks on Category dropdown$")
	public void user_clicks_on_Category_dropdown() throws Throwable {
		
	    homepage.getCategory_dropdown().click();
	}

	@Then("^User should be able to select \"([^\"]*)\" from the visible options$")
	public void user_should_be_able_to_select_from_the_visible_options(String arg1) throws Throwable {
		Assert.assertEquals(GenericKeywords.selectValueFromDropDownBasedOnOptions(homepage.getCategory_dropdown(), arg1), true);
	   
	}

	@When("^User clicks on the sub category dropdown$")
	public void user_clicks_on_the_sub_category_dropdown() throws Throwable {
		homepage.getSubCategory_drodown().click();
	}

	@Then("^User should be able to select the longgest value from the dropdown$")
	public void user_should_be_able_to_select_the_longgest_value_from_the_dropdown() throws Throwable {
	  Assert.assertEquals( homepageActions.select_max_length_value_from_subCategory(), true); 
	}

	@When("^User clicks on Service lookup icon and selects the last value from the list$")
	public void user_clicks_on_Service_lookup_icon_and_selects_the_last_value_from_the_list() throws Throwable {
	   homepage.getServive_lookup_icon().click();
	   Assert.assertEquals(homepageActions.select_service_option_from_popWindow_and_confirm(), true);
	   GenericKeywords.switchToFrame(homepage.getiFrame());
	   Reporter.addStepLog("Service value is selected and populated on the field");
	}

	@Then("^User should see a pop up window is closed and user should landing down on Parent window$")
	public void user_should_see_a_pop_up_window_is_closed_and_user_should_landing_down_on_Parent_window() throws Throwable {
	    GenericKeywords.elementIsPresent(homepage.getConfiguration_item_lookup());
	    Reporter.addStepLog("Confuguration lookup is visible, hence control comes on Parent window");
	}

	@When("^User clicks on Configuration lookup$")
	public void user_clicks_on_Configuration_lookup() throws Throwable {
		homepage.getConfiguration_item_lookup().click();
		Reporter.addStepLog("Confuguration lookup is clicked");
	}

	@When("^Determine the total records presents on the window and search for any random number comes under (\\d+) records of the page$")
	public void determine_the_total_records_presents_on_the_window_and_search_for_any_random_number_comes_under_records_of_the_page(int arg1) throws Throwable {
	  Assert.assertEquals(homepageActions.select_configurationOption_from_theList(), true);
	}

	@Then("^Once selection is done child pop up should get closed$")
	public void once_selection_is_done_child_pop_up_should_get_closed() throws Throwable {
		GenericKeywords.windowHandler("Parent");
		GenericKeywords.switchToFrame(homepage.getiFrame());
		Reporter.addStepLog("Child pop up is closed for Configuration selection");
		
	}
	
	@When("^User enters \"([^\"]*)\" as problem statement along with the timestamp$")
	public void user_enters_as_problem_statement_along_with_the_timestamp(String statement) throws Throwable {
	  Assert.assertEquals(homepageActions.enter_problem_statement(statement), true); 
	  
	}

	@When("^User enters \"([^\"]*)\" as	description$")
	public void user_enters_as_description(String description) throws Throwable {
		homepage.getDescription().sendKeys(description); 
		Reporter.addStepLog(description+ " is provided as Description");
	}

	@When("^Navigate to State field$")
	public void navigate_to_State_field() throws Throwable {
	    GenericKeywords.elementIsPresent(homepage.stateField);
	    Reporter.addStepLog("State field is visible");
	}

	@Then("^User should see thestate field contains a by default value as \"([^\"]*)\" into te field$")
	public void user_should_see_thestate_field_contains_a_by_default_value_as_into_te_field(String defaultValue) throws Throwable {
	  Assert.assertEquals(homepageActions.validate_default_state_field_value(defaultValue), true); 
	  Reporter.addStepLog(defaultValue+ " is the default field value on disabled state field");
	}
	
	@When("^User enters \"([^\"]*)\" as Impact$")
	public void user_enters_as_Impact(String impact) throws Throwable {
	   GenericKeywords.selectDropDownJS(homepage.getImpact(),"//select[@name='problem.impact']//option[contains(text(),'"+impact+"')]");
	   Reporter.addStepLog(impact+ " is the Selected");
	}

	@When("^User enters \"([^\"]*)\" as	Urgency$")
	public void user_enters_as_Urgency(String urgency) throws Throwable {
		GenericKeywords.selectDropDownJS(homepage.getUrgency(),"//select[@name='problem.urgency']//option[contains(text(),'"+urgency+"')]");
		 Reporter.addStepLog(urgency+ " is the Selected");
	}

	@When("^User type \"([^\"]*)\" in Assign to field and select the first value$")
	public void user_type_in_Assign_to_field_and_select_the_first_value(String assignTo) throws Throwable {
	    homepage.getAssignTo().sendKeys(assignTo);
	    Thread.sleep(500);
	    GenericKeywords.performDownArrowAndEnter(homepage.getAssignTo());
	    Reporter.addStepLog("Problem Assign to: "+assignTo);
	 
	}

	@Then("^User should be able to submit the problem by clicking Submit button$")
	public void user_should_be_able_to_submit_the_problem_by_clicking_Submit_button() throws Throwable {
	   homepage.getSubmitButton().click();
	   Reporter.addStepLog("Problem has been submitted successfully");
	}
	
	@When("^User enters the problem number to the search field and hit Enter$")
	public void user_enters_the_problem_number_to_the_search_field_and_hit_Enter() throws Throwable {
	   Assert.assertEquals(homepageActions.enter_stored_problem_number_and_hit_enter(), true);
	}

	@Then("^The problem number should get dispplay in the table as a single record$")
	public void the_problem_number_should_get_dispplay_in_the_table_as_a_single_record() throws Throwable {
		homepageActions.validate_record_on_the_grid();
	}



}
