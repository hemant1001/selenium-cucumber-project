Feature: Login

  Scenario: Valid Login
    Given I navigate to login page
    When I enter username and password
    And I select user radio button
    And I click okay button
    And I select dropdown option
    And I accept terms and submit login
    Then login is successful
