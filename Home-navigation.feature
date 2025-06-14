Feature: Home Page Navigation
  As a user
  I want to navigate the home page
  So that I can access different sections of the website

  Scenario: Verify home page elements
    Given I am on the home page
    Then I should see the following links:
      | Register |
      | Log in   |
      | Shopping cart |
      | Wishlist |
      | Books |
      | Computers |
      | Electronics |
      | Apparel & Shoes |

  Scenario: Navigate to registration page
    Given I am on the home page
    When I click on the "Register" link
    Then I should be on the registration page

  Scenario: Navigate to login page
    Given I am on the home page
    When I click on the "Log in" link
    Then I should be on the login page