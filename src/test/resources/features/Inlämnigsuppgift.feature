Feature: User Registration on Basketball England

  As a new user
  I want to register an account
  So that I can access Basketball England's services


  Scenario: Successful user registration
    Given I am on the registration page
    When I enter valid registration details
    And I submit the registration form
    Then I should be redirected to the confirmation page

  Scenario Outline: Registration with invalid data
    Given I am on the registration page and the user is using "<Browser>"
    When I enter registration details with "<First Name>", "<Last Name>", "<Date of Birth>", "<Email>", "<Confirm Email>", "<Password>", "<Confirm Password>", "<Terms Accepted>"
    And I submit the registration form
    Then I should see an error message "<Error message>"


    Examples:
      | First Name | Last Name | Date of Birth | Email               | Confirm Email       | Password | Confirm Password | Terms Accepted | Browser | Error message                                                             |
      | Jane       |           | 01/12/1988    | jans@example.com    | jane@example.com    | Pass123! | Pass123!         | Yes            | chrome  | Last Name is required                                                     |
      | Bob        | Brown     | 22/07/2000    | bob@example.com     | bob@wrong.com       | Pass123! | Pass123!         | Yes            | firefox | Confirm Email Address does not match                                      |
      | Charlie    | Adams     | 10/03/1995    | charlie@example.com | charlie@example.com | Pass123! | Pass456!         | Yes            | firefox | Password did not match                                                    |
      | Dave       | Johnson   | 30/09/1987    | dave@example.com    | dave@example.com    | Pass123! | Pass123!         | No             | chrome  | You must confirm that you have read and accepted our Terms and Conditions |
