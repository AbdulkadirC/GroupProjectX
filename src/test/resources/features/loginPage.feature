@login
Feature: user should be able to login

  Background:
    Given the user is on the login page
    And the user enters own "userType" and "password"


#@TRN-1090
  @TRN-1104
  Scenario Outline: login with different accounts
    When the user log in as "<userType>"
    Then the page contains "<title>"

    Examples:
      | userType    |    title      |
      |driver       |Dashboard      |
      |sales_manager|Dashboard      |
      |store_manager|Dashboard      |

  #@TRN-1095
    @TRN-1105
  Scenario Outline: invalid username or password
    Given the user enter "<username>" and "<password>"
    Then the error "<message>" displayed

    Examples:
    | username | password | message |
    | user        | UserUser123| "Invalid user name or password."|
    | user1        |  useruser |"Invalid user name or password."  |
    | Salesmanager1    |   UserUser123  | "Invalid user name or password."  |
    | Salesmanager101  |   useruser     |  "Invalid user name or password." |
    | storemanager     |   UserUser123  | "Invalid user name or password."  |
    | Salesmanager101  |  useruser      |  "Invalid user name or password." |

    #@TRN-1096
      @TRN-1106
    Scenario Outline: login with different accounts and verify username
      Given the user log in as "<userType>"
      Then the user can see own "<name>"
      Examples:
        | userType | name |
        |driver    |John Doe|
        |sales_manager|John Doe|
        |store_manager|John Doe|

      #@TRN-1097
      @TRN-1107
      Scenario: the user should see password as bullet sign
        Given the user enter the following "<userType>"
        When the user enter own password
        Then the user see that as bullet sign

        #@TRN-1098
        @TRN-1108
        Scenario: the user click on forgot password link
          Given the user should be able to click on the link
          Then the user should land on "Forgot Password" page

        #@TRN-1099
        @TRN-1109
        Scenario: the user should be able to see Remember me link
          Given the user should be able to see "Remember me on this computer" link
          Then the link should be clickable

          #@TRN-1100
          @TRN-1110
          Scenario: the enter button should be able work
            Given the user enter own username and press enter
            And the user enter own password and press enter
            Then the user should be able to login









