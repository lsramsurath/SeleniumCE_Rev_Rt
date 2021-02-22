package com.pdp.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.pdp.test.SetUp;

public class REV_Login{
	WebDriver driver = SetUp.driver;
	
	@FindBy(how= How.XPATH, using = "//input[contains(@id,'email')]")
	public WebElement Email_inputbox;
	
	public WebElement return_InputWithValue(String strID) {
		return driver.findElement(By.xpath("//input[contains(@value,'"+strID+"')]"));
	}
	public WebElement return_InputWithID(String strID) {
		return driver.findElement(By.xpath("//input[contains(@id,'"+strID+"')]"));
	}
	public WebElement Time_dropdown(String strID) {
		return driver.findElement(By.xpath("//select[contains(@id,'"+strID+"')]"));
	}
	
	public WebElement Time_dropdownValue(String strID) {
		return driver.findElement(By.xpath("//option[contains(text(),'"+strID+"')]"));
	}
	@FindBy(how= How.XPATH, using = "//input[@name='regReview']")
	public WebElement Accept_privacy;
	
	@FindBy(how= How.XPATH, using = "//a[text()='here']")
	public WebElement Login_redirect;
	
	public WebElement return_buttonWithValue(String strID) {
		return driver.findElement(By.xpath("//button[contains(@value,'"+strID+"')]"));
	}
	
	@FindBy(how= How.XPATH, using = "//div[@class='modal-content']//button[@class='close']")
	public WebElement Popup_close;
	
	@FindBy(how= How.XPATH, using = "//ul[contains(@class,'header')]//a[@id='logoutlink']")
	public WebElement Logout;
	@FindBy(how= How.XPATH, using = "//button[@id='onetrust-accept-btn-handler']")
	public WebElement Cookie_acceptor;

}