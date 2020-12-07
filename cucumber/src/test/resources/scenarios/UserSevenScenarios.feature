@functional
Feature: User Seven Scenarios

  Scenario: I get user seven
    Given the user seven endpoint exists
    When I send a valid get user
    And get user seven response

