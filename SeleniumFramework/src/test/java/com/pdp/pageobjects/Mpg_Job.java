package com.pdp.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.pdp.test.SetUp;

public class Mpg_Job {
	WebDriver driver = SetUp.driver;
	
	@FindBy(how= How.XPATH, using = "//input[contains(@id,'email')]")
	public WebElement Email_inputbox;
	public WebElement return_InputWithID(String strID) {
		return driver.findElement(By.xpath("//input[contains(@id,'"+strID+"')]"));
	}
	
	@FindBy(how= How.XPATH, using = "//input[contains(@value,'Find Jobs')]")
	public WebElement Job_Serach;
	
	public WebElement JobSearch_filters(String strID) {
		return driver.findElement(By.xpath("//label[contains(text(),'"+strID+"')]"));
	}
	
	public WebElement View_job(int count) {
		return driver.findElement(By.xpath("//*[@id='jobResultsDiv']/div[4]/div["+count+"]/div/div[3]/a"));
	}
	
	@FindBy(how= How.XPATH, using = "//div[@id='expiredJobMsgDivId']")
	public WebElement Job_nolonger_available;
	
	@FindBy(how= How.XPATH, using = "//a[@class='link-back']")
	public WebElement Back_to_job;
	
	@FindBy(how= How.XPATH, using = "//div[@class='job-card apply'][1]//div[@class='panel-title']")
	public WebElement Job_card_title;
	
	@FindBy(how= How.XPATH, using = "//a[@id='saveLink']")
	public WebElement Save_job_button;
	
	@FindBy(how= How.XPATH, using = "//div[2]//a[text()='Saved Jobs']")
	public WebElement Saved_Job_tab;
	
	@FindBy(how= How.XPATH, using = "//div[@class='job-card save'][1]//div[@class='panel-title']")
	public WebElement Saved_Job_card;



}