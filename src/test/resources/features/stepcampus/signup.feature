Feature: StepCampus Signup

  Scenario: Fill the signup form with captcha
    Given I open the StepCampus signup page
    When I enter email and password
    And I solve the captcha
    And I submit the signup form
    Then signup should be successful
