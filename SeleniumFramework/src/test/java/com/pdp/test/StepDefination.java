package com.pdp.test;

import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pdp.pageobjects.Mpg_Aboutme;
import com.pdp.pageobjects.Mpg_Job;
import com.pdp.pageobjects.Mpg_Signup;
import com.pdp.pageobjects.REV_Login;
import com.pdp.pageobjects.RIT_obj;
import com.pdp.utilities.ActionMethods;
import com.pdp.utilities.Constant;
import com.pdp.utilities.ExceptionHandler;
import com.pdp.utilities.PropertiesFile;
import com.ibm.icu.text.DateFormat;
import com.ibm.icu.text.SimpleDateFormat;
import com.ibm.icu.util.Calendar;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.List;

public class StepDefination {
	
	public WebDriver driver = SetUp.driver;
	public ActionMethods user = new ActionMethods();
	public static Properties data=null;
	PropertiesFile prop = new PropertiesFile();
	public static String strPageTitle;
	public static WebDriverWait wait;
	public Constant constant = new Constant();
	public String strEmail = "qatest" + this.return_CurrentDateAndTime() + "@mailnator.com";
	
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	//connecting page objects to SetUp
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

	Mpg_Signup  mpg_sighuppageobj=SetUp.mpg_sighuppageobj;
	Mpg_Aboutme mpg_aboutmepageobj=SetUp.mpg_aboutmeobj;
	Mpg_Job mpg_jobpageobj=SetUp.mpg_jobpageobj;
	REV_Login rev_login=SetUp.rev_login;
	RIT_obj rit_obj=SetUp.rit_obj;
	
	
	
	public String return_CurrentDateAndTime() {
		DateFormat dateFormat = new SimpleDateFormat("ddMMHHmmss");               
        Date date = new Date();               
        String systemdateandtime= dateFormat.format(date);
        return systemdateandtime;
        
	}
	@Given("^Load the url \"(.*?)\"$")
	public void Load_the_url(String envUrl) throws Throwable {
		try {
            String url = prop.readPropertiesFile(constant.propertyFileName).getProperty(envUrl);
			wait=new WebDriverWait(driver, 70);
			driver.get(url);
			driver.manage().window().maximize();
		}catch(Exception e) {
			ExceptionHandler.handler(e, "Initial Page");
		}
	}
	
	@Then("^Clicking on Signup button$")
	public void Clicking_on_Sighnup_button() throws Throwable {
	    try {
	        user.sync(driver, mpg_sighuppageobj.Signup_button);
			user.click(mpg_sighuppageobj.Signup_button);
	    }catch(Exception e) {
	    	ExceptionHandler.handler(e, "Login Page");
	    }
		
	}

	@Then("^Setting email ID in sign up$")
	public void Setting_email_as_in_Sign_up() throws Throwable {
		try {
		    String strEmail = "qatest" + this.return_CurrentDateAndTime() + "@mailnator.com";
			user.sync(driver, mpg_sighuppageobj.Email_inputbox);
			user.click(mpg_sighuppageobj.Email_inputbox);
			user.type(mpg_sighuppageobj.Email_inputbox, strEmail);
			PropertiesFile.writePropertiesFile(SetUp.constant.runTimrPropertyFileName, "Email",strEmail );
		}catch(Exception e) {
			ExceptionHandler.handler(e, "Initial Page");
		}
	}
	@Then("^Setting \"(.*?)\" as \"(.*?)\"$")
	public void Setting_as(String obj,String value) throws Throwable {
		try {
			user.sync(driver, mpg_sighuppageobj.return_InputWithID(obj));
			user.click(mpg_sighuppageobj.return_InputWithID(obj));
			user.type(mpg_sighuppageobj.return_InputWithID(obj), value);
		}catch(Exception e) {
			ExceptionHandler.handler(e, "Initial Page");
		}
	}
	@Then("^Clicking on the \"(.*?)\" button$")
	public void Clicking_on_Sighnup_button(String buttoname) throws Throwable {
	    try {
	        user.sync(driver, mpg_sighuppageobj.return_button(buttoname));
			user.click(mpg_sighuppageobj.return_button(buttoname));
	    }catch(Exception e) {
	    	ExceptionHandler.handler(e, "Login Page");
	    }
		
	}
	@Then("^Click on Create Manual Profile$")
	public void Click_on_Create_Manual_Profile() throws Throwable {
	    try {
	        user.sync(driver, mpg_sighuppageobj.Manualcrete_button);
			user.click(mpg_sighuppageobj.Manualcrete_button);
	    }catch(Exception e) {
	    	ExceptionHandler.handler(e, "Login Page");
	    }
		
	}
	@Then("^Slecting \"(.*?)\" from \"(.*?)\" dropdown$")
	public void Selcting_from_dropdown(String value,String field) throws Throwable {
	    try {
	        user.sync(driver, mpg_sighuppageobj.State_dropdown(field));
			user.click(mpg_sighuppageobj.State_dropdown(field));
		    user.sync(driver, mpg_sighuppageobj.State_dropdownValue(value));
			user.click(mpg_sighuppageobj.State_dropdownValue(value));
	    }catch(Exception e) {
	    	ExceptionHandler.handler(e, "Login Page");
	    }
		
	}
	@Then("^Slecting skills \"(.*?)\" from the skill dropdown$")
	public void Selcting_skill_from_dropdown(String value) throws Throwable {
	    try {
	        user.sync(driver, mpg_sighuppageobj.Skill_dropdown);
			user.click(mpg_sighuppageobj.Skill_dropdown);
			Thread.sleep(2000);
			 Robot robot = new Robot();
			 robot.keyPress(KeyEvent.VK_J);
	         robot.keyRelease(KeyEvent.VK_J);
	         robot.keyPress(KeyEvent.VK_A);
	         robot.keyRelease(KeyEvent.VK_A);
	         robot.keyPress(KeyEvent.VK_V);
	         robot.keyRelease(KeyEvent.VK_V);
	         robot.keyPress(KeyEvent.VK_A);
	         robot.keyRelease(KeyEvent.VK_A);
			 Thread.sleep(2000);
			 user.sync(driver, mpg_sighuppageobj.Skill_Dropdownvalue(value));
			 user.click(mpg_sighuppageobj.Skill_Dropdownvalue(value));
	    }catch(Exception e) {
	    	ExceptionHandler.handler(e, "Login Page");
	    }
		
	}
	@Then("^Clicking on the \"(.*?)\" in communication prferances$")
	public void Clicking_on_communication_prferances(String value) throws Throwable {
	    try {
	        user.sync(driver, mpg_sighuppageobj.Checkbox_prferences(value));
			user.click(mpg_sighuppageobj.Checkbox_prferences(value));
		   
	    }catch(Exception e) {
	    	ExceptionHandler.handler(e, "Login Page");
	    }
		
	}
	
	@Then("^To verify the profile created$")
	public void To_verify_the_profile_created() throws Throwable {
	    try {
	    user.sync(driver, mpg_sighuppageobj.Profile_name);
	    String b=user.checkTextForParticularElement(driver,mpg_sighuppageobj.Profile_name);
	    boolean a=false;
	    if(b.contains("Bat")) {
	    	    a=true;
	    }
	    Assert.assertEquals(true, a);  
	    }catch(Exception e) {
	    	ExceptionHandler.handler(e, "Login Page");
	    }
		
	}
	@Then("^Clicking on Login button$")
	public void Clicking_on_Login_button() throws Throwable {
	    try {
	        user.sync(driver, mpg_sighuppageobj.Login_button);
			user.click(mpg_sighuppageobj.Login_button);
		   
	    }catch(Exception e) {
	    	ExceptionHandler.handler(e, "Login Page");
	    }
		
	}
	@Then("^Setting \"(.*?)\" in login \"(.*?)\" from output$")
	public void Setting_login_from_output(String value,String obj) throws Throwable {
	    try {
	    	 String strCandidateInfo = PropertiesFile.readPropertiesFile(constant.runTimrPropertyFileName).getProperty(value);
	    	 user.sync(driver, mpg_sighuppageobj.return_InputWithID(obj));
			 user.click(mpg_sighuppageobj.return_InputWithID(obj));
			 user.type(mpg_sighuppageobj.return_InputWithID(obj),strCandidateInfo);
	        
		   }catch(Exception e) {
	    	ExceptionHandler.handler(e, "Login Page");
	    }
		
	}
	@Then("^Setting \"(.*?)\" in login \"(.*?)\"$")
	public void Clicking_on_Login_button(String value,String obj) throws Throwable {
	    try {
	    	 String strCandidateInfo = PropertiesFile.readPropertiesFile(constant.propertyFileName).getProperty(value);
	    	 user.sync(driver, mpg_sighuppageobj.return_InputWithID(obj));
			 user.click(mpg_sighuppageobj.return_InputWithID(obj));
			 user.type(mpg_sighuppageobj.return_InputWithID(obj),strCandidateInfo);
	        
		   }catch(Exception e) {
	    	ExceptionHandler.handler(e, "Login Page");
	    }
		
	}

	@Then("^Clicking on \"(.*?)\" in about me page$")
	public void Clicking_on_in_about_me_page(String value) throws Throwable {
	    try {
	        user.sync(driver, mpg_aboutmepageobj.manage_profile(value));
			user.click(mpg_aboutmepageobj.manage_profile(value));
		   
	    }catch(Exception e) {
	    	ExceptionHandler.handler(e, "Login Page");
	    }
		
	}
	@Then("^Clicking on \"(.*?)\" in manage profile page$")
	public void Clicking_on_manage_profile_page(String value) throws Throwable {
	    try {
	        user.sync(driver, mpg_aboutmepageobj.edit_button(value));
			user.click(mpg_aboutmepageobj.edit_button(value));
		   
	    }catch(Exception e) {
	    	ExceptionHandler.handler(e, "Login Page");
	    }
		
	}	
	@Then("^Selecting Start and end date as \"(.*?)\"$")
	public void Selecting_Start_and_end_date(String value) throws Throwable {
	    try {
	        user.sync(driver, mpg_aboutmepageobj.return_InputWithID("startDate1"));
			user.click(mpg_aboutmepageobj.return_InputWithID("startDate1"));
			user.sync(driver, mpg_aboutmepageobj.Start_date);
			user.click(mpg_aboutmepageobj.Start_date);
			user.sync(driver, mpg_aboutmepageobj.Current_date(value));
			user.click(mpg_aboutmepageobj.Current_date(value));
			 }catch(Exception e) {
	    	ExceptionHandler.handler(e, "Login Page");
	    }
		
	}
	@Then("^Clicking on Save experience button$")
	public void Clicking_on_Save_experience_button() throws Throwable {
	    try {
	        user.sync(driver, mpg_aboutmepageobj.Save_Experience);
			user.click(mpg_aboutmepageobj.Save_Experience);
		   
	    }catch(Exception e) {
	    	ExceptionHandler.handler(e, "Login Page");
	    }
		
	}	
	@Then("^Slecting Other from degree dropdown$")
	public void Slecting_Other_from_degree_dropdown() throws Throwable {
	    try {
	    	Select drp = new Select(driver.findElement(By.name("educations[0].degree")));
			Thread.sleep(1000);
			drp.selectByValue("OTD");
	    }catch(Exception e) {
	    	ExceptionHandler.handler(e, "Login Page");
	    }
		
	}
	@Then("^Clicking on the no checkbox$")
	public void Clicking_on_the_no_checkbox() throws Throwable {
	    try {
	    	user.sync(driver, mpg_aboutmepageobj.no_checkbox);
			user.click(mpg_aboutmepageobj.no_checkbox);
	   }catch(Exception e) {
	    	ExceptionHandler.handler(e, "Login Page");
	    }
		
	}	
	@Then("^Clicking on Save education button$")
	public void Clicking_on_Save_education_button() throws Throwable {
	    try {
	        user.sync(driver, mpg_aboutmepageobj.Save_education);
			user.click(mpg_aboutmepageobj.Save_education);
		   
	    }catch(Exception e) {
	    	ExceptionHandler.handler(e, "Login Page");
	    }
		
	}
	@Then("^Clicking on Upload resume link$")
	public void Clicking_on_Upload_resume_link() throws Throwable {
	    try {
	        user.sync(driver, mpg_aboutmepageobj.Upload_resume);
			user.click(mpg_aboutmepageobj.Upload_resume);
		   
	    }catch(Exception e) {
	    	ExceptionHandler.handler(e, "Login Page");
	    }
		
	}	
	@Then("^Uploading the resume$")
	public void Uploading_the_resume() throws Throwable {
	    try {
	    	Thread.sleep(5000);
	    	String cwd = System.getProperty("user.dir")+"/Data/Resume.docx";
	    	WebElement addFile = driver.findElement(By.xpath("//*[@id='inputFile']"));
	    	user.sync(driver,addFile );
	    	addFile.sendKeys(cwd);
	    }catch(Exception e) {
	    	ExceptionHandler.handler(e, "Login Page");
	    }
	    	
   }	
	@Then("^Clicking on Upload button$")
	public void Clicking_on_Upload_button() throws Throwable {
	    try {
	        user.sync(driver, mpg_aboutmepageobj.Upload_button);
			user.click(mpg_aboutmepageobj.Upload_button);
		   
	    }catch(Exception e) {
	    	ExceptionHandler.handler(e, "Login Page");
	    }
		
	}	
	@Then("^Clicking on Save resume button$")
	public void Clicking_on_Save_resume_button() throws Throwable {
	    try {
	        user.sync(driver, mpg_aboutmepageobj.Save_resume);
			user.click(mpg_aboutmepageobj.Save_resume);
		   
	    }catch(Exception e) {
	    	ExceptionHandler.handler(e, "Login Page");
	    }
		
	}
	@Then("^Clicking on \"(.*?)\" tab$")
	public void Clicking_on_tab(String obj) throws Throwable {
	    try {
	        user.sync(driver, mpg_aboutmepageobj.Top_tabs(obj));
			user.click(mpg_aboutmepageobj.Top_tabs(obj));
		   
	    }catch(Exception e) {
	    	ExceptionHandler.handler(e, "Login Page");
	    }
		
	}
	@Then("^To verify the profile percentage$")
	public void To_verify_the_profile_percentage() throws Throwable {
	    try {
	    user.sync(driver, mpg_sighuppageobj.Profile_name);
	    user.sync(driver, mpg_aboutmepageobj.profile_percent);
	    String b=user.checkTextForParticularElement(driver,mpg_aboutmepageobj.profile_percent);
	    boolean a=false;
	    if(b.contains("100")) {
	    	    a=true;
	    }
	    Assert.assertEquals(true, a);  
	    }catch(Exception e) {
	    	ExceptionHandler.handler(e, "Login Page");
	    }
	}
	@Then("^Sign out of the user$")
	public void Sign_out_of_the_user() throws Throwable {
	    try {
	        user.sync(driver, mpg_aboutmepageobj.Sign_Out_button);
			user.click(mpg_aboutmepageobj.Sign_Out_button);
		   
	    }catch(Exception e) {
	    	ExceptionHandler.handler(e, "Login Page");
	    }
		
	}
	@Then("^Clicking on find jobs$")
	public void Clicking_on_find_jobs() throws Throwable {
	    try {
	        user.sync(driver, mpg_jobpageobj.Job_Serach);
			user.click(mpg_jobpageobj.Job_Serach);
		   
	    }catch(Exception e) {
	    	ExceptionHandler.handler(e, "Login Page");
	    }
		
	}
	@Then("^Setting Job Serach filter as \"(.*?)\"$")
	public void Setting_Job_Serach_filter_as(String value) throws Throwable {
	    try {
	    	Thread.sleep(4000);
	        user.sync(driver, mpg_jobpageobj.JobSearch_filters(value));
			user.click(mpg_jobpageobj.JobSearch_filters(value));
		    Thread.sleep(4000);
	    }catch(Exception e) {
	    	ExceptionHandler.handler(e, "Login Page");
	    }
		
	}
	@Then("^To verify the filtered job results and click view and apply$")
	public void To_verify_the_filtered_job_results_and_click_view_and_apply() throws Throwable {
	    
	    	List<WebElement> optionCount = driver.findElements(By.xpath("//*[@id='jobResultsDiv']/div[4]/div"));
	    	boolean flag=false;
			int a=optionCount.size();
			int b=a-3;
			System.out.println("jobs found"+b);
			for(int i=3;i<=a;i++) {
				user.sync(driver, mpg_jobpageobj.View_job(i));
				user.click(mpg_jobpageobj.View_job(i));
				
				boolean d=user.isElementPrsent(mpg_jobpageobj.Job_nolonger_available);
				System.out.println(d);
				String jobstatus=user.getElementText(mpg_sighuppageobj.return_button("applyButton"));
				if((d==true) || jobstatus.contains("Applied")) {
					user.sync(driver, mpg_jobpageobj.Back_to_job);
					user.click(mpg_jobpageobj.Back_to_job);
				    Thread.sleep(4000);

				}
				else {
					 user.sync(driver, mpg_sighuppageobj.return_button("applyButton"));
					 user.click(mpg_sighuppageobj.return_button("applyButton"));
					 flag=true;
					 break;
					
				}
			}
		
		Assert.assertEquals(true, flag);
			
		   
	    }
	@Then("^To verify the applied job$")
	public void To_verify_the_applied_job() throws Throwable {
	    try {
	    	Thread.sleep(4000);
	        user.sync(driver, mpg_jobpageobj.Job_card_title);
			String s=user.getElementText(mpg_jobpageobj.Job_card_title);
			PropertiesFile.writePropertiesFile(SetUp.constant.runTimrPropertyFileName, "The applied job is ",s );
	    }catch(Exception e) {
	    	ExceptionHandler.handler(e, "Login Page");
	    }
		
	}
	@Then("^To verify the filtered job results and click view and save$")
	public void To_verify_the_filtered_job_results_and_click_view_and_save() throws Throwable {
	    
	    	List<WebElement> optionCount = driver.findElements(By.xpath("//*[@id='jobResultsDiv']/div[4]/div"));
	    	boolean flag=false;
			int a=optionCount.size();
			int b=a-3;
			System.out.println("jobs found"+b);
			for(int i=3;i<=a;i++) {
				user.sync(driver, mpg_jobpageobj.View_job(i));
				user.click(mpg_jobpageobj.View_job(i));
				
				boolean d=user.isElementPrsent(mpg_jobpageobj.Job_nolonger_available);
				System.out.println(d);
				String jobstatus=user.getElementText(mpg_sighuppageobj.return_button("applyButton"));
				if((d==true) || jobstatus.contains("Applied")) {
					user.sync(driver, mpg_jobpageobj.Back_to_job);
					user.click(mpg_jobpageobj.Back_to_job);
				    Thread.sleep(4000);

				}
				else {
					 user.sync(driver, mpg_jobpageobj.Save_job_button);
					 user.click(mpg_jobpageobj.Save_job_button);
					 flag=true;
					 break;
					
				}
			}
		
		Assert.assertEquals(true, flag);
			
		   
	    }
	@Then("^Wait for the page to load \"(.*?)\"$")
	public void Wait_for_the_page_to_load(int i) throws Throwable {
	    try {
	    	Thread.sleep(i);
	        
	    }catch(Exception e) {
	    	ExceptionHandler.handler(e, "Login Page");
	    }
		
	}
	@Then("^To verify the saved job$")
	public void To_verify_the_saved_job() throws Throwable {
	    try {
	    	Thread.sleep(4000);
	    	user.sync(driver, mpg_jobpageobj.Saved_Job_tab);
			user.click(mpg_jobpageobj.Saved_Job_tab);
	        user.sync(driver, mpg_jobpageobj.Saved_Job_card);
			String s=user.getElementText(mpg_jobpageobj.Saved_Job_card);
			PropertiesFile.writePropertiesFile(SetUp.constant.runTimrPropertyFileName, "The saved job is ",s );
	    }catch(Exception e) {
	    	ExceptionHandler.handler(e, "Login Page");
	    }
		
	}
	@Then("^Clicking on \"(.*?)\" in top toggle$")
	public void Clicking_on_settings_in_top_toggle(String value) throws Throwable {
	    try {
	    	
	    	user.sync(driver,mpg_aboutmepageobj.top_toggle);
			user.click(mpg_aboutmepageobj.top_toggle);
	        user.sync(driver, mpg_aboutmepageobj.Settings_button(value));
	        user.click(mpg_aboutmepageobj.Settings_button(value));
	    }catch(Exception e) {
	    	ExceptionHandler.handler(e, "Login Page");
	    }
		
	}
	@Then("^Selecting \"(.*?)\" language from dropdown$")
	public void Selecting_language_from_dropdown(String value) throws Throwable {
	    try {
	    	
	    	user.sync(driver,mpg_aboutmepageobj.Change_Language);
			user.click(mpg_aboutmepageobj.Change_Language);
	        user.sync(driver, mpg_aboutmepageobj.return_OptionWithID(value));
	        user.click(mpg_aboutmepageobj.return_OptionWithID(value));
	    }catch(Exception e) {
	    	ExceptionHandler.handler(e, "Login Page");
	    }
		
	}
	@Then("^Clicking on Language Save$")
	public void Clicking_on_Language_Save() throws Throwable {
	    try {
	    	
	    	user.sync(driver,mpg_aboutmepageobj.Language_Save_button);
			user.click(mpg_aboutmepageobj.Language_Save_button);

	    }catch(Exception e) {
	    	ExceptionHandler.handler(e, "Login Page");
	    }
		
	}

	@Then("^Selecting Ingls language from dropdown$")
	public void Selecting_Ingls_language_from_dropdown() throws Throwable {
	    try {
	    	
	    	user.sync(driver,mpg_aboutmepageobj.Change_Language);
			user.click(mpg_aboutmepageobj.Change_Language);
	        user.sync(driver, mpg_aboutmepageobj.Inglish_option);
	        user.click(mpg_aboutmepageobj.Inglish_option);
	    }catch(Exception e) {
	    	ExceptionHandler.handler(e, "Login Page");
	    }

}
	@Then("^Setting \"(.*?)\" in change password as \"(.*?)\"$")
	public void Setting_in_change_password_as(String obj,String value) throws Throwable {
	    try {
	    	String changepassword = PropertiesFile.readPropertiesFile(constant.propertyFileName).getProperty(value);
	    	user.sync(driver,mpg_aboutmepageobj.return_InputWithID(obj));
			user.click(mpg_aboutmepageobj.return_InputWithID(obj));
			user.type(mpg_aboutmepageobj.return_InputWithID(obj), changepassword);
	        
	    }catch(Exception e) {
	    	ExceptionHandler.handler(e, "Login Page");
	    }

}
	@Then("^Clicking on Change password Save$")
	public void Clicking_on_Change_password_Save() throws Throwable {
	    try {
	    	
	    	user.sync(driver,mpg_aboutmepageobj.Change_password_save);
			user.click(mpg_aboutmepageobj.Change_password_save);

	    }catch(Exception e) {
	    	ExceptionHandler.handler(e, "Login Page");
	    }
		
	}

////////////////////////////////////////////////////////////////////////////////////
/////////////////Rev////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////

@Then("^Clicking on the \"(.*?)\" button in rev$")
public void Clicking_on_the_button_in_home_page(String value) throws Throwable {
    try {
    	user.sync(driver,rev_login.return_InputWithValue(value));
		user.click(rev_login.return_InputWithValue(value));

    }catch(Exception e) {
    	ExceptionHandler.handler(e, "Login Page");
    }
	
}
@Then("^Entering the \"(.*?)\" as \"(.*?)\" in regesteration page$")
public void Entering_the_regcode(String value,String regcode) throws Throwable {
    try {
    	String code = prop.readPropertiesFile(constant.propertyFileName).getProperty(regcode);
    	user.sync(driver,rev_login.return_InputWithID(value));
		user.click(rev_login.return_InputWithID(value));
		user.type(rev_login.return_InputWithID(value),code);
		

    }catch(Exception e) {
    	ExceptionHandler.handler(e, "Login Page");
    }
	
}
@Then("^Entering the \"(.*?)\" as \"(.*?)\" in complete regesteration page$")
public void Entering_the_details_in_complete_reg_page(String obj,String value) throws Throwable {
    try {
    	if(value.equalsIgnoreCase("qatest"))
    	{
    	 String strEmail = "qatest" + this.return_CurrentDateAndTime();
		 user.sync(driver, rev_login.return_InputWithID(obj));
		 user.click(rev_login.return_InputWithID(obj));
		 user.type(rev_login.return_InputWithID(obj), strEmail);
		 PropertiesFile.writePropertiesFile(SetUp.constant.runTimrPropertyFileName, "UserNameRev",strEmail );
    	}
    	else {
    	user.sync(driver,rev_login.return_InputWithID(obj));
		user.click(rev_login.return_InputWithID(obj));
		user.type(rev_login.return_InputWithID(obj),value);
    	}

    }catch(Exception e) {
    	ExceptionHandler.handler(e, "Login Page");
    }
	
}
@Then("^Slecting \"(.*?)\" from \"(.*?)\" dropdown in rev$")
public void Selcting_from_time_dropdown(String value,String field) throws Throwable {
    try {
        user.sync(driver, rev_login.Time_dropdown(field));
		user.click(rev_login.Time_dropdown(field));
	    user.sync(driver, rev_login.Time_dropdownValue(value));
		user.click(rev_login.Time_dropdownValue(value));
    }catch(Exception e) {
    	ExceptionHandler.handler(e, "Login Page");
    }
	
}

@Then("^Clicking on Accept privacy policy$")
public void Clicking_on_Accept_privacy_policy() throws Throwable {
    try {
        user.sync(driver, rev_login.Accept_privacy);
		user.click(rev_login.Accept_privacy);

    }catch(Exception e) {
    	ExceptionHandler.handler(e, "Login Page");
    }
	
}
@Then("^Clicking on Login page redirect$")
public void Clicking_on_Login_page_redirect() throws Throwable {
    try {
        user.sync(driver, rev_login.Login_redirect);
		user.click(rev_login.Login_redirect);

    }catch(Exception e) {
    	ExceptionHandler.handler(e, "Login Page");
    }
	
}
@Then("^Entering the \"(.*?)\" as \"(.*?)\" in login page$")
public void Entering_the_details_login_page(String obj,String value) throws Throwable {
    try {
    	if(value.equalsIgnoreCase("UserNameRev"))
    	{
         String info = PropertiesFile.readPropertiesFile(constant.runTimrPropertyFileName).getProperty(value);
         user.sync(driver,rev_login.return_InputWithID(obj));
 		 user.click(rev_login.return_InputWithID(obj));
 		 user.type(rev_login.return_InputWithID(obj),info);
    	}
    	else {
    	 String info = PropertiesFile.readPropertiesFile(constant.propertyFileName).getProperty(value);
    	 user.sync(driver,rev_login.return_InputWithID(obj));
 		 user.click(rev_login.return_InputWithID(obj));
 		 user.type(rev_login.return_InputWithID(obj),info);
    	}
    	

    }catch(Exception e) {
    	ExceptionHandler.handler(e, "Login Page");
    }
	
}
@Then("^Clicking on the \"(.*?)\" button in login page$")
public void Clicking_on_the_button_in_login_page(String value) throws Throwable {
    try {
    	
    	user.sync(driver,rev_login.return_buttonWithValue(value));
		user.click(rev_login.return_buttonWithValue(value));
		WebElement a=driver.findElement(By.xpath("//div[@class='modal-content']"));
		if(a.isDisplayed()) {
			 user.sync(driver,rev_login.Popup_close);
	 		 user.click(rev_login.Popup_close);
		}

    }catch(Exception e) {
    	ExceptionHandler.handler(e, "Login Page");
    }
	
}
@Then("^Clicking on logout$")
public void Clicking_on_logout() throws Throwable {
    try {
        user.sync(driver, rev_login.Logout);
		user.click(rev_login.Logout);

    }catch(Exception e) {
    	ExceptionHandler.handler(e, "Login Page");
    }
	
}
@Then("^Click on Accept cookies$")
public void Click_on_Accept_cookies() throws Throwable {
    try {
        user.sync(driver, rev_login.Cookie_acceptor);
		user.click(rev_login.Cookie_acceptor);

    }catch(Exception e) {
    	ExceptionHandler.handler(e, "Login Page");
    }
	
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////RIT///////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////

@Then("^Entering the \"(.*?)\" and \"(.*?)\" in rit Login page$")
public void Entering_the_email_password_in_rit(String username,String password) throws Throwable {
    try {
    	String username_obj = prop.readPropertiesFile(constant.propertyFileName).getProperty(username);
    	String password_obj = prop.readPropertiesFile(constant.propertyFileName).getProperty(password);
    	user.sync(driver,rit_obj.Email_inputbox);
		user.click(rit_obj.Email_inputbox);
		user.type(rit_obj.Email_inputbox,username_obj);
		user.sync(driver,rit_obj.Password_inputbox);
		user.click(rit_obj.Password_inputbox);
		user.type(rit_obj.Password_inputbox,password_obj);
		

    }catch(Exception e) {
    	ExceptionHandler.handler(e, "Login Page");
    }
	
}
@Then("^CLick on Sign in rit home page$")
public void CLick_on_Sign_in_rit_home_page() throws Throwable {
    try {
        user.sync(driver,rit_obj.Signin_button);
		user.click(rit_obj.Signin_button);
        }catch(Exception e) {
    	ExceptionHandler.handler(e, "Login Page");
    }
	
}

@Then("^To verify the home page objects$")
public void To_verify_the_home_page_objects() throws Throwable {
    try {
    	int i=0;
    	if(user.isElementPrsent(rit_obj.Profile_Name)) i++;
    	if(user.isElementPrsent(rit_obj.Welcome_text)) i++;
        for(int j=1;j<5;j++) {
        	if(user.isElementPrsent(rit_obj.Tiles_homepage(j))) i++;
        	else break;
        }
       Assert.assertEquals(6,i);
		
        }catch(Exception e) {
    	ExceptionHandler.handler(e, "Login Page");
    }
	
}











}



	
	
	