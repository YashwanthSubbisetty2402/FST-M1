@activity4
Feature: Data driven test without Example

Scenario: Testing with Data from Scenario
    Given User is on Login page
    When User entersa "admin" and "password"
    Then Read the page titlea and confirmation message
    And Close the Browsera