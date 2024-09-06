@signup
Feature: User Account Sign-Up

  Scenario: User successfully signs up for an account
    Given the user is on the homepage
    When the user clicks on the "Create an Account" button
    Then the user should be redirected to the sign-up page
    And the page should display "Create New Customer Account"
    When the user enters valid sign-up details
    And the user submits the sign-up form
    Then the user should be redirected to the My Account dashboard