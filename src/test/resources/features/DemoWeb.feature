Feature: Navigate to product categories on Tricentis demowebshop

  Scenario Outline: Visit Tricentis demowebshop and verify a product category
    Given I am on the Tricentis demowebshop
    When I click on "<category>" in the main menu
    Then I should see a list of products on the page

    Examples:
      | category          |
      | Books             |
      | Apparel & Shoes   |
      | Electronics       |
      | Computers         |
      | Digital downloads |
      | Jewelry           |
      | Gift Cards        |