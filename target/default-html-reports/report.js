$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/AccountActivityNavigation.feature");
formatter.feature({
  "name": "Navigation to specific accounts in Accounts Activity",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@AccountActivityNavigation"
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the user logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "com.zerobank.step_definitions.AccountActivityNavigationDefs.the_user_logged_in()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Savings account redirect",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@AccountActivityNavigation"
    },
    {
      "name": "@wip"
    }
  ]
});
formatter.step({
  "name": "the user clicks on Savings link on the Account Summary page",
  "keyword": "When "
});
formatter.match({
  "location": "com.zerobank.step_definitions.AccountActivityNavigationDefs.the_user_clicks_on_Savings_link_on_the_Account_Summary_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the Account Activity page should be displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "com.zerobank.step_definitions.AccountActivityNavigationDefs.the_Account_Activity_page_should_be_displayed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Account drop down should have Savings selected",
  "keyword": "And "
});
formatter.match({
  "location": "com.zerobank.step_definitions.AccountActivityNavigationDefs.account_drop_down_should_have_Savings_selected()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});