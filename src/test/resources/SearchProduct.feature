@TutorialsNinjaSearchProduct
Feature: Search Product Functionality of TutorialsNinja

  @ValidProduct
  Scenario: Search with valid product
    Given User opens the application
    When User enters valid product "HP"
    And User clicks on search button
    Then User gets valid product info display in search page

  @InvalidProduct
  Scenario: Search with invalid product
    Given User opens the application
    When User enters invalid product "DELL"
    And User clicks on search button
    Then User gets warning message no product found

  @NoProduct
  Scenario: Search with no product
    Given User opens the application
    And User clicks on search button
    Then User gets warning message no product found