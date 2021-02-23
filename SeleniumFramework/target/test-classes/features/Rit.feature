Feature: Rit smoke testing
@run
 Scenario Outline: Rev Registration manually
    Given Load the url "<env>"
    Then Entering the "<email>" and "<password>" in rit Login page
    Then CLick on Sign in rit home page
    Then To verify the home page objects
    Then To verify the "Service Utilization" homepage tile
    Then To verify the "Candidate Status" homepage tile
    Then To verify the "Candidate Satisfaction" homepage tile
    Then To verify the "Time To Land" homepage tile
    Then To verify the "Investment" homepage tile
Examples:
	 | env            | email      |password   |
	 | environmentrit | usernamerit|passwordrit|