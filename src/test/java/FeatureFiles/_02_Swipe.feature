Feature: Swipe Functionality

  Background:
    Given Open application
    When Navigate to swipe page

  @Smoke
  Scenario: Scroll Down
    And Scroll Down
    Then Logo should be visible

  @Smoke
  Scenario: Scroll Right
    And Scroll Right
    Then Last should be visible