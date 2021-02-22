$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/Rev.feature");
formatter.feature({
  "line": 1,
  "name": "Rev smoke testing",
  "description": "",
  "id": "rev-smoke-testing",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 28,
  "name": "Rev Registration manually",
  "description": "",
  "id": "rev-smoke-testing;rev-registration-manually",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 27,
      "name": "@run"
    }
  ]
});
formatter.step({
  "line": 29,
  "name": "Load the url \"\u003cenv\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "line": 30,
  "name": "Click on Accept cookies",
  "keyword": "Then "
});
formatter.step({
  "line": 31,
  "name": "Entering the \"txtUserName\" as \"UserNameRev\" in login page",
  "keyword": "Then "
});
formatter.step({
  "line": 32,
  "name": "Entering the \"txtPassword\" as \"Password\" in login page",
  "keyword": "Then "
});
formatter.step({
  "line": 33,
  "name": "Clicking on the \"LOGIN\" button in login page",
  "keyword": "Then "
});
formatter.step({
  "line": 34,
  "name": "Wait for the page to load \"4000\"",
  "keyword": "Then "
});
formatter.examples({
  "line": 36,
  "name": "",
  "description": "",
  "id": "rev-smoke-testing;rev-registration-manually;",
  "rows": [
    {
      "cells": [
        "env",
        "Regesteration Code"
      ],
      "line": 37,
      "id": "rev-smoke-testing;rev-registration-manually;;1"
    },
    {
      "cells": [
        "environmentrev",
        "regCode"
      ],
      "line": 38,
      "id": "rev-smoke-testing;rev-registration-manually;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 14008433800,
  "status": "passed"
});
formatter.scenario({
  "line": 38,
  "name": "Rev Registration manually",
  "description": "",
  "id": "rev-smoke-testing;rev-registration-manually;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 27,
      "name": "@run"
    }
  ]
});
formatter.step({
  "line": 29,
  "name": "Load the url \"environmentrev\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 30,
  "name": "Click on Accept cookies",
  "keyword": "Then "
});
formatter.step({
  "line": 31,
  "name": "Entering the \"txtUserName\" as \"UserNameRev\" in login page",
  "keyword": "Then "
});
formatter.step({
  "line": 32,
  "name": "Entering the \"txtPassword\" as \"Password\" in login page",
  "keyword": "Then "
});
formatter.step({
  "line": 33,
  "name": "Clicking on the \"LOGIN\" button in login page",
  "keyword": "Then "
});
formatter.step({
  "line": 34,
  "name": "Wait for the page to load \"4000\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "environmentrev",
      "offset": 14
    }
  ],
  "location": "StepDefination.Load_the_url(String)"
});
formatter.result({
  "duration": 16287697200,
  "status": "passed"
});
formatter.match({
  "location": "StepDefination.Click_on_Accept_cookies()"
});
formatter.result({
  "duration": 277265800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "txtUserName",
      "offset": 14
    },
    {
      "val": "UserNameRev",
      "offset": 31
    }
  ],
  "location": "StepDefination.Entering_the_details_login_page(String,String)"
});
formatter.result({
  "duration": 332952800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "txtPassword",
      "offset": 14
    },
    {
      "val": "Password",
      "offset": 31
    }
  ],
  "location": "StepDefination.Entering_the_details_login_page(String,String)"
});
formatter.result({
  "duration": 232383200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "LOGIN",
      "offset": 17
    }
  ],
  "location": "StepDefination.Clicking_on_the_button_in_login_page(String)"
});
formatter.result({
  "duration": 101073073700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "4000",
      "offset": 27
    }
  ],
  "location": "StepDefination.Wait_for_the_page_to_load(int)"
});
formatter.result({
  "duration": 4001692000,
  "status": "passed"
});
formatter.after({
  "duration": 587000,
  "status": "passed"
});
});