@manual
Feature: Selenium example (manual)

  Scenario: open example.com in Chrome (manual)
    Given browser is ready
    When I open example.com
    Then page title contains Example
