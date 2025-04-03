#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

@tag
Feature: Title of your feature
  I want to use this template for my feature file
  


  @tValidate
  Scenario Outline: Title of your scenario
      Given I want to Assert the dashboard
  
    		When The user enters username as "<username>" and Password as "<password>"
    And Assert the name Dashboard "<Dashboard>"
    Then the user asserts all the quick Action "<QuickAction>"

    Examples: 
      | username  | password | Dashboard  | QuickAction  |
      | Admin     | admin123 | Dashboard  | Assign Leave |
      | Admin     | admin123 | Dashboard  | Leave List   |
      | Admin     | admin123 | Dashboard  | Timesheets   |
      | Admin     | admin123 | Dashboard  | Apply Leave  |
      | Admin     | admin123 | Dashboard  | My Leave     |
      | Admin     | admin123 | Dashboard  | My Timesheet |
