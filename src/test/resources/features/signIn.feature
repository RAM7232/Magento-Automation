@signin
Feature: User Sign-In Functionality

  Scenario: User successfully signs in to their account
    Given the user is on the magento homepage
    When the user clicks on the "Sign In" button
    And the user enters valid login credentials
    And the user submits the login form
   #Then the user should be redirected to the "My Account" dashboard
    #And the page should display "Welcome, Test User!"
 