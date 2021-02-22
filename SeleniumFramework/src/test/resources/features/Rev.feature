Feature: Rev smoke testing

 Scenario Outline: Rev Registration manually
    Given Load the url "<env>"
    Then Clicking on the "GET STARTED" button in rev 
    Then Entering the "regCode" as "<Regesteration Code>" in regesteration page
    Then Clicking on the "Continue" button in rev
    Then Entering the "firstName" as "Bat" in complete regesteration page
    Then Entering the "userName" as "qatest" in complete regesteration page
    Then Entering the "password" as "Manpower@123" in complete regesteration page
    Then Entering the "lastName" as "Man" in complete regesteration page
    Then Entering the "emailId" as "qatest@mailinator.com" in complete regesteration page
    Then Entering the "confirmPassword" as "Manpower@123" in complete regesteration page
    Then Slecting "(UTC-08:00) Pacific Time (US & Canada)" from "selectedTimeZone" dropdown in rev
    Then Clicking on the "Continue" button in rev
    Then Clicking on Accept privacy policy
    Then Clicking on the "Continue" button in rev
    Then Clicking on Login page redirect
    Then Entering the "txtUserName" as "UserNameRev" in login page
    Then Entering the "txtPassword" as "Password" in login page
    Then Clicking on the "LOGIN" button in login page
    Then Wait for the page to load "4000"
    Then Clicking on logout
Examples:
	 | env            | Regesteration Code|
	 | environmentrev | regCode           |
@run	 
Scenario Outline: Rev Registration manually
    Given Load the url "<env>"
    Then Click on Accept cookies
    Then Entering the "txtUserName" as "UserNameRev" in login page
    Then Entering the "txtPassword" as "Password" in login page
    Then Clicking on the "LOGIN" button in login page
    Then Wait for the page to load "4000"
    
Examples:
	 | env         | Regesteration Code|
	 | environmentrev | regCode           |	 

	 

