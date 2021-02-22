package com.pdp.test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pdp.pageobjects.Mpg_Aboutme;
import com.pdp.pageobjects.Mpg_Job;
import com.pdp.pageobjects.Mpg_Signup;
import com.pdp.pageobjects.REV_Login;
import com.pdp.pageobjects.RIT_obj;
import com.pdp.utilities.Constant;
import com.pdp.utilities.Log;
import com.pdp.utilities.PropertiesFile;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class SetUp {
	
	public static WebDriver driver;
	public static Scenario scenario; 
	public static Actions action;
	public static String message ="";
	FileOutputStream fop =null;
	File file;
	public static byte[][] screenshotsArray = new byte[10][10000];
	public static Date date;
	public static String BrowserName="";
	public static Properties data=null;
	public static String ScenarioName = "";
	public static HashMap<String,String> InspectionDataMap = new HashMap<String,String>();
	public static String lastUpdatedDateTime="";
	
	//Declaration of instance of Constant class
	public static Constant constant = new Constant();
//Changes RAMS
	public static boolean blnFlagScenarioExecution = true;
	public static int intAppLaunchCounter = 0;
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	//Declaration of page objects with instance
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

	public static Mpg_Aboutme mpg_aboutmeobj=new Mpg_Aboutme();
	public static Mpg_Signup mpg_sighuppageobj=new Mpg_Signup();
	public static Mpg_Job mpg_jobpageobj=new Mpg_Job();
	public static REV_Login rev_login= new REV_Login ();
	public static RIT_obj rit_obj= new RIT_obj();
	
	
	public static WebDriverWait wait;
	static {
		DOMConfigurator.configure("log4j.xml");
	}
	
	@Before
	public static void setupTest(Scenario scenario) throws Exception{
		
		
		ScenarioName = scenario.getName();
		System.out.println("Starting Scenario execution for Scenario Name >> "+ScenarioName);
		Log.startTestCase("Starting Scenario execution for Scenario Name >> "+ScenarioName);

		System.out.println("Path :"+ System.getProperty("user.dir")+"\\exe\\chromedriver.exe");
		System.out.println("Path:"+System.getProperty("user.dir")+"/exe/IEDriverServer.exe");

		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\exe\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
	    options.setExperimentalOption("useAutomationExtension", false);
		driver = new ChromeDriver(options);

		
		//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		//Define all the page objects here only
		//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

		
		mpg_aboutmeobj=PageFactory.initElements(driver, Mpg_Aboutme.class);
		mpg_sighuppageobj=PageFactory.initElements(driver, Mpg_Signup.class);
		mpg_jobpageobj=PageFactory.initElements(driver, Mpg_Job.class);
		rev_login=PageFactory.initElements(driver, REV_Login.class);
		rit_obj=PageFactory.initElements(driver, RIT_obj.class);
		
		System.out.println("path "+System.getProperty("user.dir"));

		action = new Actions(driver);

		}
		
	
	
	@After
	public static void tearDown(Scenario result) throws Exception{
		if(result.isFailed()) {
			
			result.write(result.toString());
			result.write(result.getStatus());
			result.write("Screenshot takn for failed steps");
			byte[] screenshot= ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			result.write(message);
			result.embed(screenshot, "image/png");			
		}
//		driver.close();
//		driver.quit();
		Log.endTestCase("Ending scenario execution with Execution result as >> "+result.getStatus());
		System.out.println("Ending scenario execution with Execution result as >> "+result.getStatus());
				
	}
	
}
