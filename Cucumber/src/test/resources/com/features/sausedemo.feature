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
Feature: Sause Demo Login 
  I want to use this for my Sausedemo login
  
  Background:
    Given Iam in the SauseDemo Login Page
  
  
  

  @ValidCredential @Valid
  Scenario: As a user i want to log in to my sausedemo 
    
    When The user provides the Username 
    And The User provides the Passowrd
    And Clicking on the login button
    Then I want to verify that i am logged in or not

  @Invalid_1 
  Scenario: As a user i want to log in to my sausedemo with invalid credentials 
    When The user provides invalid the Username 
    And The User provides the Passowrd
    And Clicking on the login button
    Then i want to see error message
    
    
  @Invalid-2 @Chrome
  Scenario: As a user i want to log in to my sausedemo with invalid credentials 
    When The user provides the Username 
    And The User provides invalid the Passowrd
    And Clicking on the login button
    Then i want to see error message
    
     @Invalid-3
  Scenario: As a user i want to log in to my sausedemo with Blank credentials 
    When The user provides no username
    And The User provides the Passowrd
    And Clicking on the login button
    Then i want to see error message of No username
    
    
  @Invalid-4
  Scenario: As a user i want to log in to my sausedemo with Blank credentials 
    When The user provides the Username 
    And The User provides no Passowrd
    And Clicking on the login button
    Then i want to see error message of no Password
    