$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/login.feature");
formatter.feature({
  "name": "User should be able to login",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@login"
    }
  ]
});
formatter.scenario({
  "name": "Only authorized users should be able to login",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@login"
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
  "name": "the user is on the login page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.zerobank.step_definitions.LoginStepDefs.the_user_is_on_the_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user enters valid credentials",
  "keyword": "When "
});
formatter.match({
  "location": "com.zerobank.step_definitions.LoginStepDefs.the_user_enters_valid_credentials()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Account summary page should be displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "com.zerobank.step_definitions.LoginStepDefs.account_summary_page_should_be_displayed()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Users should not be able to login with \u003cuserNameType\u003e username and \u003cpassWordType\u003e password",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@wip"
    }
  ]
});
formatter.step({
  "name": "the user is on the login page",
  "keyword": "Given "
});
formatter.step({
  "name": "the user enters \"\u003cuserNameType\u003e\" \"\u003cuserName\u003e\" username and \"\u003cpassWordType\u003e\" \"\u003cpassWord\u003e\" password",
  "keyword": "When "
});
formatter.step({
  "name": "The error message \"Login and/or password are wrong.\" should be displayed.",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "userNameType",
        "userName",
        "passWordType",
        "passWord"
      ]
    },
    {
      "cells": [
        "wrong",
        "wrongUsername",
        "valid",
        "password"
      ]
    },
    {
      "cells": [
        "valid",
        "username",
        "wrong",
        "wrongPassword"
      ]
    },
    {
      "cells": [
        "blank",
        "",
        "valid",
        "password"
      ]
    },
    {
      "cells": [
        "valid",
        "username",
        "blank",
        ""
      ]
    }
  ]
});
formatter.scenario({
  "name": "Users should not be able to login with wrong username and valid password",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@login"
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
  "name": "the user is on the login page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.zerobank.step_definitions.LoginStepDefs.the_user_is_on_the_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user enters \"wrong\" \"wrongUsername\" username and \"valid\" \"password\" password",
  "keyword": "When "
});
formatter.match({
  "location": "com.zerobank.step_definitions.LoginStepDefs.the_user_enters_username_and_password(java.lang.String,java.lang.String,java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The error message \"Login and/or password are wrong.\" should be displayed.",
  "keyword": "Then "
});
formatter.match({
  "location": "com.zerobank.step_definitions.LoginStepDefs.the_error_message_should_be_displayed(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Users should not be able to login with valid username and wrong password",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@login"
    },
    {
      "name": "@wip"
    }
  ]
});
