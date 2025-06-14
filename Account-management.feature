Feature: User Account Management
  As a user
  I want to manage my account
  So that I can register, login and logout

  @register
  Scenario: Successful user registration
    Given I am on the registration page
    When I select "Male" gender
    And I enter "John" as first name
    And I enter "Doe" as last name
    And I enter "john.doe@example.com" as email
    And I enter "password123" as password
    And I confirm "password123" as password
    And I click the register button
    Then I should see the registration success message
    And I should be logged in as "john.doe@example.com"

  @login
  Scenario: Successful user login
    Given I am on the login page
    When I enter "john.doe@example.com" as email
    And I enter "password123" as password
    And I click the login button
    Then I should be logged in as "john.doe@example.com"

  @login @negative
  Scenario: Failed user login with invalid credentials
    Given I am on the login page
    When I enter "invalid@example.com" as email
    And I enter "wrongpassword" as password
    And I click the login button
    Then I should see an error message "Login was unsuccessful"