Feature: Box Test

  Scenario: Test the box functionality on the dynamic page
    Given I am on the dynamic page
    When I click the add button
    Then a new box should appear
    When I reveal the box and enter text
    Then the text should be entered and submitted successfully