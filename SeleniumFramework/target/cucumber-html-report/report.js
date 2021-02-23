$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/Rit.feature");
formatter.feature({
  "line": 1,
  "name": "Rit smoke testing",
  "description": "",
  "id": "rit-smoke-testing",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 3,
  "name": "Rev Registration manually",
  "description": "",
  "id": "rit-smoke-testing;rev-registration-manually",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 2,
      "name": "@run"
    }
  ]
});
formatter.step({
  "line": 4,
  "name": "Load the url \"\u003cenv\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "Entering the \"\u003cemail\u003e\" and \"\u003cpassword\u003e\" in rit Login page",
  "keyword": "Then "
});
formatter.step({
  "line": 6,
  "name": "CLick on Sign in rit home page",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "To verify the home page objects",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "To verify the \"Service Utilization\" homepage tile",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "To verify the \"Candidate Status\" homepage tile",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "To verify the \"Candidate Satisfaction\" homepage tile",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "To verify the \"Time To Land\" homepage tile",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "To verify the \"Investment\" homepage tile",
  "keyword": "Then "
});
formatter.examples({
  "line": 13,
  "name": "",
  "description": "",
  "id": "rit-smoke-testing;rev-registration-manually;",
  "rows": [
    {
      "cells": [
        "env",
        "email",
        "password"
      ],
      "line": 14,
      "id": "rit-smoke-testing;rev-registration-manually;;1"
    },
    {
      "cells": [
        "environmentrit",
        "usernamerit",
        "passwordrit"
      ],
      "line": 15,
      "id": "rit-smoke-testing;rev-registration-manually;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 5805470000,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "Rev Registration manually",
  "description": "",
  "id": "rit-smoke-testing;rev-registration-manually;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 2,
      "name": "@run"
    }
  ]
});
formatter.step({
  "line": 4,
  "name": "Load the url \"environmentrit\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "Entering the \"usernamerit\" and \"passwordrit\" in rit Login page",
  "matchedColumns": [
    1,
    2
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 6,
  "name": "CLick on Sign in rit home page",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "To verify the home page objects",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "To verify the \"Service Utilization\" homepage tile",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "To verify the \"Candidate Status\" homepage tile",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "To verify the \"Candidate Satisfaction\" homepage tile",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "To verify the \"Time To Land\" homepage tile",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "To verify the \"Investment\" homepage tile",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "environmentrit",
      "offset": 14
    }
  ],
  "location": "StepDefination.Load_the_url(String)"
});
formatter.result({
  "duration": 9882502700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "usernamerit",
      "offset": 14
    },
    {
      "val": "passwordrit",
      "offset": 32
    }
  ],
  "location": "StepDefination.Entering_the_email_password_in_rit(String,String)"
});
formatter.result({
  "duration": 432414600,
  "status": "passed"
});
formatter.match({
  "location": "StepDefination.CLick_on_Sign_in_rit_home_page()"
});
formatter.result({
  "duration": 8036689900,
  "status": "passed"
});
formatter.match({
  "location": "StepDefination.To_verify_the_home_page_objects()"
});
formatter.result({
  "duration": 173700300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Service Utilization",
      "offset": 15
    }
  ],
  "location": "StepDefination.To_verify_the_home_page_objects_navigation(String)"
});
formatter.result({
  "duration": 14874378400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Candidate Status",
      "offset": 15
    }
  ],
  "location": "StepDefination.To_verify_the_home_page_objects_navigation(String)"
});
formatter.result({
  "duration": 14691945700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Candidate Satisfaction",
      "offset": 15
    }
  ],
  "location": "StepDefination.To_verify_the_home_page_objects_navigation(String)"
});
formatter.result({
  "duration": 11329909200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Time To Land",
      "offset": 15
    }
  ],
  "location": "StepDefination.To_verify_the_home_page_objects_navigation(String)"
});
formatter.result({
  "duration": 12317345700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Investment",
      "offset": 15
    }
  ],
  "location": "StepDefination.To_verify_the_home_page_objects_navigation(String)"
});
formatter.result({
  "duration": 12008463200,
  "status": "passed"
});
formatter.after({
  "duration": 555200,
  "status": "passed"
});
});