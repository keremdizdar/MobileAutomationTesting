Feature: Login Functionality

  @Smoke
  Scenario: Login with valid credentials
    Given Open application
    When Navigate to login page
    And Enter credentials and click login button
    Then User should login successfully