@activity2
Feature: Login Test

Scenario: Testing Login
    Given User is on Login page
    When User entersu username and password
    Then Read the page titleu and confirmation message
    And Close the Browseru