@AccountSummary
Feature: Account Summary Page should have following account types and columns

  Background:
    Given the user logged in

  Scenario: Account Summary Page should have the title "Zero – Account summary"
    Then Account Summary Page should have the title "Zero - Account Summary"

  Scenario: Account summary page should have following account types:
  Cash Accounts, Investment Accounts, Credit Accounts, Loan Accounts.
    Then Account summary page should have to following account types:
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |

  Scenario: Credit Accounts table should have following columns:
  Account, Credit Card and Balance.
    Then Credit Accounts table must have columns
      | Account     |
      | Credit Card |
      | Balance     |
