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
Feature: Scenario outline
  I am using this to chek the following is working accordingly

  @InvalidCredentials
  Scenario Outline: Login with valid credentials
    Given User is on Home Screen
    When User enters UserName as "<username>" and Password as "<password>"
    Then User should be able to see an "<error>"


  Examples: 
      |username  |password |errorMessage                |
      |Admin     |admin1   |Invalid credentials         |
      |          |admin123 |Required                    |
      |Admin     |         |Required                    |