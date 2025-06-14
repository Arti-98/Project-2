Feature: Shopping Cart Management
  As a user
  I want to manage my shopping cart
  So that I can control what I purchase

  @cart
  Scenario: Add product to cart
    Given I am on the "Books" category page
    When I add the product "Computing and Internet" to cart
    And I navigate to the shopping cart
    Then I should see "Computing and Internet" in my cart
    And the cart should have 1 item

  @cart
  Scenario: Update product quantity in cart
    Given I have "Computing and Internet" in my cart
    When I update the quantity to "2"
    And I click the update cart button
    Then the quantity should be "2"
    And the subtotal should reflect the updated quantity

  @cart
  Scenario: Remove product from cart
    Given I have "Computing and Internet" in my cart
    When I remove the product from cart
    Then the cart should be empty
    And I should see the empty cart message