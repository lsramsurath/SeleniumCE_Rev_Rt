package com.pdp.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.pdp.test.SetUp;

public class Mpg_Aboutme {
	WebDriver driver = SetUp.driver;
	
	@FindBy(how= How.XPATH, using = "//input[contains(@id,'email')]")
	public WebElement Email_inputbox;
	public WebElement return_InputWithID(String strID) {
		return driver.findElement(By.xpath("//input[contains(@id,'"+strID+"')]"));
	}
	public WebElement manage_profile(String strID) {
		return driver.findElement(By.xpath("//a[contains(text(),'"+strID+"')]"));
	}
	
	public WebElement edit_button(String strID) {
		return driver.findElement(By.xpath("//a[@data-target='"+strID+"']//i"));
	}
	@FindBy(how= How.XPATH, using = "//div[@class='datepicker-days']//tr[1]//td[1]")
	public WebElement Start_date;
	
	public WebElement Current_date(String strID) {
		return driver.findElement(By.xpath("//label[text()='"+strID+"']"));
	}

//Should find good object	
	@FindBy(how= How.XPATH, using = "//div[2]/div[3]//form//button[2]")
	public WebElement Save_Experience;
	
	@FindBy(how= How.XPATH, using = "//div[2]//form[2]/div[3]//button[1]")
	public WebElement Save_education;
	@FindBy(how= How.XPATH, using = "//fieldset//div[4]//div[2]//label")
	public WebElement no_checkbox;

	@FindBy(how= How.XPATH, using = "//a[@id='uploadResumelink']")
	public WebElement Upload_resume;
	
	@FindBy(how= How.XPATH, using = "//input[@id='upload_button']")
	public WebElement Upload_button;
	@FindBy(how= How.XPATH, using = "//div[8]//form/div[3]//button[2]")
	public WebElement Save_resume;
	
	public WebElement Top_tabs(String strID) {
		return driver.findElement(By.xpath("//span[contains(text(),'"+strID+"')]"));
	}
	@FindBy(how= How.XPATH, using = "//span[@class='percent']")
	public WebElement profile_percent;
	
	@FindBy(how= How.XPATH, using = "//li[14]//a[contains(text(),'Sign Out')]")
	public WebElement Sign_Out_button;
	
	@FindBy(how= How.XPATH, using = "//a[@class='dropdown-toggle']")
	public WebElement top_toggle;
	
	public WebElement Settings_button(String strID) {
		return driver.findElement(By.xpath("//a[contains(text(),'"+strID+"')]"));
	}
	
	
	@FindBy(how= How.XPATH, using = "//select[@id='lang']")
	public WebElement Change_Language;
	
	public WebElement return_OptionWithID(String strID) {
		return driver.findElement(By.xpath("//option[contains(@id,'"+strID+"')]"));
	}
	
	@FindBy(how= How.XPATH, using = "//*[@id='languagePreferemce']//button")
	public WebElement Language_Save_button;
	
	@FindBy(how= How.XPATH, using = "//select[@id='lang']//option[2]")
	public WebElement Inglish_option;
	
	@FindBy(how= How.XPATH, using = "//*[@id='changePassword']/div[5]/button")
	public WebElement Change_password_save;
	
	
}