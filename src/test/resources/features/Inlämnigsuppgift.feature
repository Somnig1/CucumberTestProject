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
    Then I should see an error message


    Examples:
      | First Name | Last Name | Date of Birth | Email                 | Confirm Email         | Password | Confirm Password | Terms Accepted | Browser |
      | Jane       |           | 01/12/1988    | janess@example.com    | janess@example.com    | Pass123! | Pass123!         | Yes            | chrome  |
      | Alice      | Smith     |               | alicess@example.com   | alicess@example.com   | Pass123! | Pass123!         | Yes            | firefox |
      | Bob        | Brown     | 22/07/2000    | bobss@example.com     | bobss@wrong.com       | Pass123! | Pass123!         | Yes            | chrome  |
      | Charlie    | Adams     | 10/03/1995    | charliess@example.com | charliess@example.com | Pass123! | Pass456!         | Yes            | firefox |
      | Dave       | Johnson   | 30/09/1987    | davess@example.com    | davess@example.com    | Pass123! | Pass123!         | No             | chrome  |
