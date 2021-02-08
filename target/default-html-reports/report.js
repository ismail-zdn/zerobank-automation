$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/Payee.feature");
formatter.feature({
  "name": "Add new payee under pay bills",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Payee.feature"
    }
  ]
});
formatter.scenario({
  "name": "Add a new payee",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Payee.feature"
    },
    {
      "name": "@wip"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the user is on the \"Add New Payee\" tab",
  "keyword": "Given "
});
formatter.match({
  "location": "com.zerobank.step_definitions.PayeeDefs.the_user_is_on_the_tab(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "creates new payee using following information",
  "rows": [
    {},
    {},
    {},
    {}
  ],
  "keyword": "And "
});
formatter.match({
  "location": "com.zerobank.step_definitions.PayeeDefs.creates_new_payee_using_following_information(java.util.Map\u003cjava.lang.String, java.lang.String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "message \"The new payee The Law Offices of Hyde, Price \u0026 Scharks was successfully created.\" should be displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "com.zerobank.step_definitions.PayeeDefs.message_should_be_displayed(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});