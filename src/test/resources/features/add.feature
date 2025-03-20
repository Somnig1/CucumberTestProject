Feature: Add two numbers

  Scenario: Adding two numbers
    Given I have the first number 20
    And I have the second number 30
    When I perform add of the two numbers
    Then I receive the result 50


  Scenario: Adding two numbers
    Given I have the first number 10
    And I have the second number 20
    When I perform add of the two numbers
    Then I receive the result 30
