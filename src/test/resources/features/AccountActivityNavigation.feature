@AccountActivityNavigation @V1.0
Feature: Navigation to specific accounts in Accounts Activity

  Background:
    Given the user logged in

  Scenario Outline: Account Activity page transactions <tab>
    When the user clicks on "<tab>" link on the Account Summary page
    Then the Account Activity page should be displayed
    And Account drop down should have "<tab>" selected
    Examples:
      | tab         |
      | Savings     |
      | Brokerage   |
      | Checking    |
      | Credit Card |
      | Loan        |

  Scenario: Account Summary Page should have the title "Zero – Account summary"
    When the user clicks on "Account Activity" tab
    Then Account Summary Page should have the title "Zero - Account Activity"

  Scenario: In the Account drop down default option should be Savings
    When the user clicks on "Account Activity" tab
    Then Account drop down should have "Savings" selected

  Scenario: Account drop down should have the following options:
  Savings, Checking, Loan, Credit Card, Brokerage.
    When the user clicks on "Account Activity" tab
    And Account drop down should have the following options:
      | Savings     |
      | Checking    |
      | Savings     |
      | Loan        |
      | Credit Card |
      | Brokerage   |

  Scenario: Transactions table should have column names Date, Description, Deposit,
  Withdrawal.
    When the user clicks on "Account Activity" tab
    Then Transactions table should have column names:
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |


