package com.pdp.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.pdp.test.SetUp;

public class Mpg_Signup {
	WebDriver driver = SetUp.driver;
	
	@FindBy(how= How.XPATH, using = "//input[contains(@id,'email')]")
	public WebElement Email_inputbox;
	
	public WebElement return_InputWithID(String strID) {
		return driver.findElement(By.xpath("//input[contains(@id,'"+strID+"')]"));
	}

	public WebElement return_button(String strID) {
		return driver.findElement(By.xpath("//button[contains(@id,'"+strID+"')]"));
	}
	@FindBy(how= How.XPATH, using = "//li[contains(@class,'button btn-signup')]//a[contains(text(),'Sign Up')]")
	public WebElement Signup_button;


	@FindBy(how= How.XPATH, using = "//a[contains(@id,'CreateManualProfile')]")
	public WebElement Manualcrete_button;
	
	public WebElement State_dropdown(String strID) {
		return driver.findElement(By.xpath("//select[contains(@id,'"+strID+"')]"));
	}
	
	public WebElement State_dropdownValue(String strID) {
		return driver.findElement(By.xpath("//option[contains(text(),'"+strID+"')]"));
	}
	
	@FindBy(how= How.XPATH, using = "//div[@class='bootstrap-tagsinput']")
	public WebElement Skill_dropdown;
	
	public WebElement Skill_Dropdownvalue(String strID) {
		return driver.findElement(By.xpath("//div[text()='"+strID+"']"));
	}
	public WebElement Checkbox_prferences(String strID) {
		return driver.findElement(By.xpath("//label[contains(text(),'"+strID+"')]//span"));
	}
	
	@FindBy(how= How.XPATH, using = "//form[@id='profileModel']//div[@class='rtMinht']//h3")
	public WebElement Profile_name;
    
	@FindBy(how= How.XPATH, using = "//li[contains(@class,'button li-login')]//a[contains(text(),'Log In')]")
	public WebElement Login_button;
	
	
	
	
	
}
