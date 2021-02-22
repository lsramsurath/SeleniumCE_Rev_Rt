package com.pdp.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.pdp.test.SetUp;

public class Rev_Dashboard{
	WebDriver driver = SetUp.driver;
	
	@FindBy(how= How.XPATH, using = "//input[contains(@id,'email')]")
	public WebElement Email_inputbox;
	
	public WebElement return_InputWithValue(String strID) {
	return driver.findElement(By.xpath("//input[contains(@value,'"+strID+"')]"));
	}
	
}