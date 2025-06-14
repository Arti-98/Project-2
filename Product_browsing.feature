Feature: Product Browsing and Details
  As a user
  I want to browse products and view details
  So that I can make informed purchase decisions

  Scenario: Browse products by category
    Given I am on the home page
    When I click on the "Books" category
    Then I should see a list of books
    And the page title should be "Books"

  Scenario: View product details
    Given I am on the "Books" category page
    When I click on the product "Computing and Internet"
    Then I should see the product details page for "Computing and Internet"
    And I should see the product price

  Scenario: Add product to cart from details page
    Given I am on the product details page for "Computing and Internet"
    When I click the "Add to cart" button
    Then I should see a notification that the product was added to cart