@Payee.feature @V1.0
Feature: Add new payee under pay bills

  Scenario: Add a new payee
    Given the user is on the "Add New Payee" tab
    And creates new payee using following information
      | Payee Name    | The Law Offices of Hyde, Price & Scharks |
      | Payee Address | 100 Same st, Anytown, USA, 10001         |
      | Account       | Checking                                 |
      | Payee details | XYZ account                              |
    Then message "The new payee The Law Offices of Hyde, Price & Scharks was successfully created." should be displayed

  Scenario: Pay Bills Page should have the title "Zero – Pay Bills"
    Given the user logged in
    When the user clicks on "Pay Bills" tab
    Then Account Summary Page should have the title "Zero - Pay Bills"

  Scenario: Verify that when the user completes a successful Pay operation,
  "The payment was successfully submitted." should be displayed.
    Given the user logged in
    When the user clicks on "Pay Bills" tab
    And the user enter following information for a successful pay operation
      | Bank of America     |
      | Savings             |
      | 100                 |
      | 2008-04-18          |
      | Happy Birthday Gift |
    Then message "The payment was successfully submitted." should be displayed
