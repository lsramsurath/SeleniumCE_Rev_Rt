Feature: Rit smoke testing
@run
 Scenario Outline: Rev Registration manually
    Given Load the url "<env>"
    Then Entering the "<email>" and "<password>" in rit Login page
    Then CLick on Sign in rit home page
    Then To verify the home page objects
    
    
Examples:
	 | env            | email      |password   |
	 | environmentrit | usernamerit|passwordrit|