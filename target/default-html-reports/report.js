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
  "name": "the user logged in",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "skipped"
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
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the Account Activity page should be displayed",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "Account drop down should have Savings selected",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.after({
  "status": "skipped"
});
});