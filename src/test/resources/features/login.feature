@login
Feature: User should be able to login

  Scenario: login as a user
    Given the user is on the login page
    When the user enters valid credentials
    Then the user should be able to login

  Scenario: Only authorized users should be able to login
    Given the user is on the login page
    When the user enters valid credentials
    Then Account summary page should be displayed

  Scenario Outline: Users should not be able to login with <userNameType> and <passWordType>
    Given the user is on the login page
    When the user enters "<userNameType>" and "<passWordType>"
    Then The error message "Login and/or password are wrong." should be displayed.
    Examples:

      | userNameType  | passWordType  |
      | wrongUsername | validPassword |
      | validUsername | wrongPassword |
      | blankUsername | validPassword |
      | validUsername | blankPassword |



