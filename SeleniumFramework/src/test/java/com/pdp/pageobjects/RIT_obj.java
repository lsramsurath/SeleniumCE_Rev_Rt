package com.pdp.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.pdp.test.SetUp;

public class RIT_obj{
	WebDriver driver = SetUp.driver;
	@FindBy(how= How.XPATH, using = "//input[contains(@name,'NewLoginUsername')]")
	public WebElement Email_inputbox;
	@FindBy(how= How.XPATH, using = "//input[contains(@name,'NewLoginPassword')]")
	public WebElement Password_inputbox;
	@FindBy(how= How.XPATH, using = "//input[contains(@name,'NewLoginSubmit')]")
	public WebElement Signin_button;
	@FindBy(how= How.XPATH, using = "//span[@class='profile-full-name']")
	public WebElement Profile_Name;
	@FindBy(how= How.XPATH, using = "//h3[contains(@id,'WelcomeUsernameid')]")
	public WebElement Welcome_text;
	
	public WebElement Tiles_homepage(int count) {
		return driver.findElement(By.xpath("//div[@class='row']/div["+count+"]/div/a/span"));
	}
	
	public WebElement Tiles_homepage_navigation(String str) {
		return driver.findElement(By.xpath("//span[contains(text(),'"+str+"')]"));
	}
	public WebElement Tiles_homepage_navigation_active(String str) {
		return driver.findElement(By.xpath("//ul[@class='sidebar-navigation']//a[contains(text(),'"+str+"') and @class='tab-active-inner-link']"));
	}
	
	
}