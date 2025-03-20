Feature: Book Purchase on Demo Webshop

  Scenario Outline: Purchase "Computer och Internet" book
    Given I am on the books page
    When I search for "Computing and Internet"
    And I add the book to the cart
    And I go to the checkout page
    And I proceed to checkout
    And I go through the entire purchase process "<name>" "<lName>" "<email>" "<country>" "<city>" "<street>" "<zip>" "<phone>"
    And I select "Pay on Delivery"
    And I select In-Store Pickup
    Then I should see the order confirmation page
    And the order should contain "Computing and Internet"

    Examples:
      | name | lName | email                | country       | city     | street      | zip   | phone      |
      | John | Doe   | john.doe@example.com | United States | New York | 123 Main St | 10001 | 1234567890 |