@TutorialsNinjaLogin
Feature: Login Functionality of TutorialsNinja

  @ValidCredentials
  Scenario: Login With Valid Credentials
    Given User navigates to login page
    When User enters valid email "seleniumpanda@gmail.com"
    And User enters valid password "Selenium@123"
    And User clicks on Login button
    Then User is redirected to Account Page

  @InvalidCredentials
  Scenario: Login With Invalid Credentials
    Given User navigates to login page
    When User enters invalid email
    And User enters invalid password "Selenium@123456"
    And User clicks on Login button
    Then User gets warning message about credentials mismatch

  @ValidEmailInvalidPassword
  Scenario: Login With Valid Email Invalid Password
    Given User navigates to login page
    When User enters valid email "seleniumpanda@gmail.com"
    And User enters invalid password "Selenium@123456"
    And User clicks on Login button
    Then User gets warning message about credentials mismatch

  @InvalidEmailValidPassword
  Scenario: Login With invalid Email Valid Password
    Given User navigates to login page
    When User enters invalid email
    And User enters valid password "Selenium@123"
    And User clicks on Login button
    Then User gets warning message about credentials mismatch

  @NoCredentials
  Scenario: Login Without credentials
    Given User navigates to login page
    And User clicks on Login button
    Then User gets warning message about credentials mismatch

