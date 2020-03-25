#Author: Krishnendu Halder
Feature: To verify various functionalities of ServiceNow application

  @UI
  Scenario: To validate that user is able to login to the Dev environment and landing on homepage
    Given ServiceNow Loginpage should get appeared
    When User enters valid UserName and Password to the respective fields
    And Click on LogIn button
    Then Application should take the user on ServiceNow Homepage

  @UI
  Scenario: To validate that user is able to Log a Problem Ticket number from non editable field
    Given User should be on ServiceNow homepage
    When User click on Filter navigator text box and enters "Problem"
    And Hit Enter and once "Create New" option is apeared click on it
    Then New Record sction should be displayed
    And Record the Problem Number from the non editable field

  @UI
  Scenario Outline: To validate that user user is able to select a random number from the pop up window
    Given User should be on New Record sction of homepage
    When User clicks on First Reported By lookup icon
    Then User should see a pop up window along with numbers listed
    When User select a  "<number>" from the list
    Then The child pop up window should get closed and user should be on Parent window

    Examples: 
      | number     |
      | CHG0000001 |

  @UI
  Scenario Outline: To validate that user is able to select category and sub category values from the respective dropdown fields
    Given User should be on New Record sction of homepage once child pop up is closed
    When User clicks on Category dropdown
    Then User should be able to select "<option>" from the visible options
    When User clicks on the sub category dropdown 
    Then User should be able to select the longgest value from the dropdown

    Examples: 
      | option   |
      | Database |

  @UI
  Scenario: To validate that user user is able to select Service and Configuration Item from the list
    Given User should be on New Record sction of homepage
    When User clicks on Service lookup icon and selects the last value from the list
    Then User should see a pop up window is closed and user should landing down on Parent window
    When User clicks on Configuration lookup 
    And  Determine the total records presents on the window and search for any random number comes under 100 records of the page
    Then Once selection is done child pop up should get closed
    
   @UI  
  Scenario: To validate that user is able to enter problem statement, description and also determine the state of the problem
  	Given User should be on New Record sction of homepage
  	When  User enters "TESTLEAF CONTEST" as problem statement along with the timestamp
  	And   User enters "TESTLEAF CONTEST" as	description 
  	And   Navigate to State field
  	Then  User should see thestate field contains a by default value as "New" into te field
  	
  @UI  
  Scenario: To validate that user is able to select Impact and Urgency value from the respective dropdown
  	Given User should be on New Record sction of homepage
  	When  User enters "3 - Low" as Impact
  	And   User enters "3 - Low" as	Urgency 
  	And   User type "Problem Admin" in Assign to field and select the first value 
  	Then  User should be able to submit the problem by clicking Submit button
  	
   @UI  
  Scenario: To validate that user is able to serach the problem number which is created just now
  	When  User enters the problem number to the search field and hit Enter
  	Then  The problem number should get dispplay in the table as a single record
  	
      