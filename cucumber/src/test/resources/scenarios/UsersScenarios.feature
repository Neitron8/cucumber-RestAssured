@functional
Feature: Users Scenarios

  Scenario: get all users
    Given the users endpoint exists
    When I send a valid get users
    Then response status code should be 200
    And get users response should be validthe user's response must have email, first_name, last_name for each use

