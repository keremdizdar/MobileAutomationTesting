Feature: Drag Functionality

  Background:
    Given Open application
    When Navigate to drag page

  @Smoke
  Scenario: Drag and Drop
    When User completes drag and drop
    Then Success message should be displayed