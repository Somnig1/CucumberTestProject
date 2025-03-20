Feature: User Registration on Basketball England

  As a new user
  I want to register an account
  So that I can access Basketball England's services


  Scenario: Successful user registration
    Given I am on the registration page
    When I enter valid registration details
    And I submit the registration form
    Then I should see a confirmation message

  Scenario Outline: Registration with invalid data
    Given I am on the registration page and the user is using "<Browser>"
    When I enter registration details with "<First Name>", "<Last Name>", "<Date of Birth>", "<Email>", "<Confirm Email>", "<Password>", "<Confirm Password>", "<Terms Accepted>"
    And I submit the registration form
    Then I should see the error message "<Expected Error>"

    Examples:
      | First Name | Last Name | Date of Birth | Email               | Confirm Email       | Password | Confirm Password | Terms Accepted | Expected Error                       | Browser |
      | John       | Doe       | 15/05/1990    | john@example.com    | john@example.com    | Pass123! | Pass123!         | Yes            |                                      | chrome  |
      | Jane       |           | 01/12/1988    | jane@example.com    | jane@example.com    | Pass123! | Pass123!         | Yes            | Last Name is required               | chrome  |
      | Alice      | Smith     |               | alice@example.com   | alice@example.com   | Pass123! | Pass123!         | Yes            | Date of Birth is required           | firefox |
      | Bob        | Brown     | 22/07/2000    | bob@example.com     | bob@wrong.com       | Pass123! | Pass123!         | Yes            | Confirm Email Address does not match       | chrome  |
      | Charlie    | Adams     | 10/03/1995    | charlie@example.com | charlie@example.com | Pass123! | Pass456!         | Yes            | Password did not match            | firefox |
      | Dave       | Johnson   | 30/09/1987    | dave@example.com    | dave@example.com    | Pass123! | Pass123!         | No             | You must accept terms and conditions | chrome  |
