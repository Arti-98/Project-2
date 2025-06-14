Feature: Responsiveness Testing
  As a user
  I want the website to be responsive
  So that I can use it on different devices

  @responsive
  Scenario: Verify home page on mobile device
    Given I am on the home page with mobile viewport
    Then all main elements should be visible and properly aligned
    When I click on the menu toggle
    Then I should see the navigation menu

  @responsive
  Scenario: Verify product page on tablet device
    Given I am on the "Books" category page with tablet viewport
    Then the product grid should adjust to the screen size
    And all product information should be readable