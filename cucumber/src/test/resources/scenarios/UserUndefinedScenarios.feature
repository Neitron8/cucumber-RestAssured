@functional
Feature: User created Scenarios

  Scenario: I create user
    Given the user endpoint for created user
    When create user
    And  check response created user


