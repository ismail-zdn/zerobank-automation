@login
  Feature: User should be able to login
    Scenario: login as a user
      Given the user is on the login page
      When the user enters valid credentials
      Then the user should be able to login

