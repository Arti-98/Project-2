Feature: Checkout Process
  As a user
  I want to complete the checkout process
  So that I can purchase my selected items

  @checkout
  Scenario: Complete checkout process
    Given I am logged in as "john.doe@example.com"
    And I have "Computing and Internet" in my cart
    When I proceed to checkout
    And I enter billing address:
      | Country | United States |
      | City    | New York      |
      | Address | 123 Main St   |
      | Zip     | 10001         |
      | Phone   | 5551234567    |
    And I continue through shipping and payment
    And I confirm the order
    Then I should see the order confirmation page
    And I should receive an order number