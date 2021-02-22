Feature: CE Canada Smoke testing

 Scenario Outline: Signup manually
    Given Load the url "<env>" 
  	Then Clicking on Signup button 
    Then Setting email ID in sign up
    Then Setting "password" as "Right@123"
    Then Setting "confirmpassword" as "Right@123"
    Then Clicking on the "signUpNewBtn" button
    Then Click on Create Manual Profile
    Then Setting "firstName" as "Bat"
    Then Setting "lastname" as "Man" 
    Then Setting "streetAddress1" as "220,P.K.Street"
    Then Setting "city" as "Milwauke"
    Then Setting "postCode" as "<pincode>"
    Then Setting "phoneNumber" as "9876543212" 
    Then Slecting "Alaska" from "state" dropdown
    Then Slecting skills "Java - Programming" from the skill dropdown
    Then Wait for the page to load "4000"
    Then Clicking on the "contactNext" button
    Then Clicking on the "Phone" in communication prferances
    Then Clicking on the "Weekly Email Notifications" in communication prferances
    Then Clicking on the "finishProfile" button
    Then To verify the profile created
    Then Sign out of the user
Examples:
	 | env                 | pincode  |
	 | environment         | A1A 1A1  |


Scenario Outline: Login and editing
    Given Load the url "<env>"
    Then Clicking on Login button 	 
    Then Setting "Email" in login "txtUserName" from output
    Then Setting "Password" in login "txtPassword"
    Then Clicking on the "loginbtn" button
    Then Clicking on "Manage Your Profile" in about me page
    Then Clicking on "#editExperienceModal" in manage profile page
    Then Setting "companyName1" as "Wayne Enterprises"
    Then Setting "title1" as "CEO"
    Then Selecting Start and end date as "Present" 
    Then Clicking on Save experience button
    Then Clicking on "#editEducationModal" in manage profile page 
    Then Setting "schoolName1" as "BVB"
    Then Slecting Other from degree dropdown
    Then Clicking on the no checkbox
    Then Clicking on Save education button
    Then Clicking on "#editResumeUploadModal" in manage profile page 
    Then Clicking on Upload resume link
    Then Uploading the resume
    Then Clicking on Upload button 
    Then Clicking on Save resume button
    Then Clicking on "About Me" tab
    Then To verify the profile percentage
    Then Sign out of the user

Examples:
	 | env         | 
	 | environment |   
    
Scenario Outline: Apply and save job
    Given Load the url "<env>"
    Then Clicking on Login button 	 
    Then Setting "Email" in login "txtUserName" from output
    Then Setting "Password" in login "txtPassword"
    Then Clicking on the "loginbtn" button
    Then Clicking on find jobs
    Then Setting Job Serach filter as "<hours>"
    Then Setting Job Serach filter as "<jobtype>"
    Then To verify the filtered job results and click view and apply
    Then Wait for the page to load "4000"
    Then Clicking on "Job Tracker" tab
    Then To verify the applied job
    Then Clicking on find jobs
    Then To verify the filtered job results and click view and save
    Then Wait for the page to load "4000"
    Then Clicking on "Job Tracker" tab
    Then To verify the saved job
    Then Sign out of the user

Examples:
	 | env         | hours     | jobtype   | 
	 | environment | Full-Time | Permanent | 
	
Scenario Outline: Change Language and other links
    Given Load the url "<env>"
    Then Clicking on Login button 	 
    Then Setting "Email" in login "txtUserName" from output
    Then Setting "Password" in login "txtPassword"
    Then Clicking on the "loginbtn" button
    Then Clicking on "Settings" in top toggle
    Then Selecting "French" language from dropdown
    Then Clicking on Language Save 
    Then Clicking on "propos de moi" tab
    Then Clicking on "Suivi des emplois" tab
    Then Clicking on "Centre des" tab
    Then Clicking on "Ressources de" tab
    Then Clicking on "Param" in top toggle
    Then Selecting "Anglais" language from dropdown
    Then Clicking on Language Save
    Then Clicking on "About Me" tab
    Then Sign out of the user
   
    

Examples:
	 | env         | 
	 | environment | 
 
Scenario Outline: Change password
    Given Load the url "<env>" 
    Then Clicking on Login button 	 
    Then Setting "Email" in login "txtUserName" from output
    Then Setting "Password" in login "txtPassword"
    Then Clicking on the "loginbtn" button
    Then Clicking on "Settings" in top toggle
    Then Setting "oldPassword" in change password as "Password"
    Then Setting "newPassword" in change password as "ChangedPassword"
    Then Wait for the page to load "4000" 
    Then Setting "cfmPassword" in change password as "ChangedPassword"
    Then Clicking on Change password Save
    Then Clicking on "About Me" tab
    Then Sign out of the user
    Then Clicking on Login button
    Then Wait for the page to load "7000" 	 
    Then Setting "Email" in login "txtUserName" from output
    Then Setting "ChangedPassword" in login "txtPassword"
    Then Clicking on the "loginbtn" button
    Then Clicking on "Job Tracker" tab
    Then Clicking on "Associate Centre" tab
    Then Clicking on "Career Resources" tab
    Then Sign out of the user
    

Examples:
	 | env         | 
	 | environment | 


   
   