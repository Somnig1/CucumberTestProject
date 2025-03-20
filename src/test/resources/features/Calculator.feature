Feature: Calculator

  Background: Happens before each test
    Given the test case starts with this
    And then something else happens

  Scenario: Add two numbers
    Given I have two numbers 10.0 and 20.0
    When I add the two numbers
    Then I get the result 30.0


  Scenario: Subtract two numbers
    Given I have two numbers 50.0 and 20.0
    When I subtract the two numbers
    Then I get the result 30.0

  Scenario: Subtract two numbers again
    Given I have two numbers 100.0 and 37.0
    When I subtract the two numbers
    Then I get the result 63.0