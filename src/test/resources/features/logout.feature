@logout
Feature: user should be able to login

  Background:
    Given the user is on the login page
    And the user enter userType and password


    @logoutStep
  Scenario: User can log out by using log out button inside profile info and ends up in login page.
    Given the user should be able to see logout button
    When the user be able to click logout button
    Then the user be able to logout
    And the user should land on login page

    @backButton
  Scenario: The user can not go to the home page again by clicking the step back button after successfully logged out.
    When the user click even back button after logout
    Then the user should land on login page

    @closeTab
    Scenario: The user must be logged out if the user close the open tab (all tabs if there are multiple open tabs)
      When the user should land on login page
      Then the user close the tab
      And the user should not be able to login as opening the login page
