@login
Feature: user should be able to login

  Background:
    Given the user is on the login page

  Scenario Outline: login with different accounts
    When the user log in as "<userType>"
    Then the page contains "<title>"

    Examples:
      | userType    |    title      |
      |driver       |Quick Launchpad|
      |sales_manager|Dashboard      |
      |store_manager|Dashboard      |