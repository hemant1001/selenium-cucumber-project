Feature: Drag and Drop functionality

  Scenario: Drag the red circle to target
    Given I open the drag and drop page
    When I drag the red circle to the target
    Then the circle should be successfully dropped
