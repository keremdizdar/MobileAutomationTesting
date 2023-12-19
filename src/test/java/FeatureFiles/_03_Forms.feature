Feature: Forms Functionality

  Background:
    Given Open application
    When Navigate to forms page

  @Smoke
  Scenario:
    When User turns on switch
    Then Switch should be turned on

  @Smoke
  Scenario: Select an option from drowdown
    When User opens drowdown menu
    And Select second option
    Then Second option should be selected