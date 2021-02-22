package com.pdp.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/*import com.target.objects.HomePageObjects;
import com.target.objects.PensionPageObjects;*/
import com.thoughtworks.selenium.SeleniumException;

import junit.framework.Assert;

public class ActionMethods {

	public void sync(WebDriver driver, WebElement element) {
		try {
			Wait<WebDriver> wait = new WebDriverWait(driver, 100).ignoring(StaleElementReferenceException.class);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void syncClickable(WebDriver driver, WebElement element) {
		try {
			Wait<WebDriver> wait = (WebDriverWait) new WebDriverWait(driver, 100)
					.ignoring(StaleElementReferenceException.class);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void type(WebElement element, String str) {
		element.clear();
		element.sendKeys(str.toString());

	}

	public File getLatestFilefromDir(String dirPath){
	    File dir = new File(dirPath);
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	        return null;
	    }

	    File lastModifiedFile = files[0];
	    for (int i = 1; i < files.length; i++) {
	       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
	           lastModifiedFile = files[i];
	       }
	    }
	    return lastModifiedFile;
	}
	

	public void click(WebElement element) {
		element.click();
	}

	public boolean verifyElement(Object element) {
		try {
			if (element instanceof WebElement) {
				if (((WebElement) element).isDisplayed()) {
					return true;
				} else {
					return false;
				}
			} else

			{
				return false;
			}
		} catch (NullPointerException e) {
			System.out.println("Object value null");
			e.printStackTrace();
		} catch (ElementNotVisibleException e) {
			System.out.println("Object not visible");
			e.printStackTrace();
		} catch (MoveTargetOutOfBoundsException e) {
			System.out.println("Object Cannot be scrolled into view");
			e.printStackTrace();
		}
		catch (NoSuchElementException e) {
			Assert.assertTrue("Object does Not exist", false);
			System.out.println("Object Not exists");
			e.printStackTrace();
		} catch (SeleniumException e) {
			System.out.println("Selenium Exception: " + e.getMessage());
			e.printStackTrace();
		} catch (WebDriverException e) {
			System.out.println("Webdriver Exception: " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Unknown Exception: " + e.getMessage());
			e.printStackTrace();
		}
		return false;
	}

	public boolean isElementPrsent(WebElement element) {
		try {
			element.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}

	}

	public void setClipBoardData(String str) {
		StringSelection stringselection = new StringSelection(str);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, null);
	}

	public void selectElementFromDropDown(WebDriver driver, By element, String visibleText) {

		Select dropDown = new Select(driver.findElement(element));
		dropDown.selectByVisibleText(visibleText);

	}

	public boolean containsText(WebDriver driver, String str) {
		try {
			String containsObject = "//*[contains(text(),'" + str + "')]";
			new WebDriverWait(driver, 30)
			.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(containsObject)));
			return true;
		} catch (Exception e) {
			System.out.println("Text : " + str + " is not present in the view");
			return false;
		}

	}
	
	public void click2(WebDriver driver,WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}


	public boolean exactText(WebDriver driver, String str) {

		try {
			String exactobjects = "//*[text()='" + str + "')]";
			new WebDriverWait(driver, 30)
			.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(exactobjects)));
			return true;

		} catch (Exception e) {
			System.out.println("Exact Text : " + str + " is not present in the view");
			return false;
		}

	}

	public void scrolldown(WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

	}

	public boolean redirect(WebDriver driver, String url) {

		String currentURL = driver.getCurrentUrl();
		boolean urlRediection = false;
		if (!currentURL.contains(url)) {
			urlRediection = true;
		}
		return urlRediection;

	}

	public boolean checkTitle(WebDriver driver, String title) {
		try {

			if (driver.getTitle().equalsIgnoreCase(title)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public void highlightElement(WebDriver driver, WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;' )",
					element);
			Thread.sleep(3000);
			js.executeScript("arguments[0].setAttribute('style', 'border: 2px white')", element);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void checkBrokenLinks(WebDriver driver) {
		try {
			List<WebElement> links = driver.findElements(By.tagName("a"));
			System.out.println("Total links present in the page are  " + links.size());

			for (int i = 0; i < links.size(); i++) {
				WebElement element = links.get(i);
				String url = element.getAttribute("href");
				verifyActiveLink(url);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyActiveLink(String linkurl) {
		try {
			URL url = new URL(linkurl);
			HttpURLConnection httpconnect = (HttpURLConnection) url.openConnection();
			httpconnect.setConnectTimeout(3000);
			httpconnect.connect();

			if (httpconnect.getResponseCode() == 200) {
				System.out.println(linkurl + "  -" + httpconnect.getResponseMessage());
			}

			if (httpconnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
				System.out.println(
						linkurl + "  -" + httpconnect.getResponseMessage() + " " + HttpURLConnection.HTTP_NOT_FOUND);
			}

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String checkTextForParticularElement(WebDriver driver, WebElement element) {
		String text = element.getText();
		return text;
	}


	@SuppressWarnings("unused")
	public String getTextFromTextBox(WebDriver driver, WebElement element) {
		String text = element.getAttribute("value");
		String newText = text.trim(); 
		String noText = "Text Box is Empty";
		if (text != null) {
			if (newText.length() == 0) {
				return noText;
			}

			else
				return text;
		} else

			return noText;

	}

	public String getCurrentValueFromDropDown(WebDriver driver, By element)
	{
		Select dropDown = new Select(driver.findElement(element));
		WebElement value = dropDown.getFirstSelectedOption();
		String text = value.getText();
		return text;
	}

	public String getElementColorHex(WebDriver driver, WebElement element)
	{
		String color = element.getCssValue("color");
		String[] hexValue = color.replace("rgba(", "").replace(")", "").split(",");

		int hexValue1=Integer.parseInt(hexValue[0]);
		hexValue[1] = hexValue[1].trim();
		int hexValue2=Integer.parseInt(hexValue[1]);
		hexValue[2] = hexValue[2].trim();
		int hexValue3=Integer.parseInt(hexValue[2]);

		String actualColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);
		return actualColor;
	}

	public String getPageTitle(WebDriver driver)
	{
		String title = driver.getTitle();
		return title;
	}

	public String getElementText(WebElement element)
	{
		String elementText=null;
		try {
			elementText=element.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return elementText;
	}


	public void movetoElement(WebDriver driver, WebElement element)
	{
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();

	}


	public List<String> getWebElementnames(List<WebElement> elementlist)
	{
		List<String> elementlistname=new ArrayList<String>();
		String s1=null;
		for(WebElement we:elementlist)
		{
			s1=we.getText();
			elementlistname.add(s1);
		}
		return elementlistname;
	}

	public List<String> getWebElementnamesByAttribute(List<WebElement> elementlist)
	{
		List<String> elementlistname=new ArrayList<String>();
		String s1=null;
		for(WebElement we:elementlist)
		{
			s1=we.getAttribute("innerText");
			elementlistname.add(s1);
		}
		return elementlistname;
	}

	public boolean searchList(String str,List<String> stringList)
	{
		boolean blnFound = stringList.contains(str);  
		return blnFound;
	}

	public void sync(WebDriver driver, List<WebElement> elements) {
		try {
			Wait<WebDriver> wait = new WebDriverWait(driver, 3000).ignoring(StaleElementReferenceException.class);
			wait.until(ExpectedConditions.visibilityOfAllElements(elements));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectElementFromDropDown(WebDriver driver, WebElement element, String visibleText) {

		Select dropDown = new Select(element);
		dropDown.selectByVisibleText(visibleText);

	}


	public List<String> splitSringOnNewline(String str){
		String[] words= str.split("\\r\\n|\\n|\\r");
		List<String> strList = Arrays.asList(words);
		return strList;
	}

	public boolean isSelected(WebElement element)
	{
		return element.isSelected();
	}


	public static boolean equals(String str1, String str2) {
		return str1 == null ? str2 == null : str1.equals(str2);
	}


	public int search_string_list_webelement(String str,List<WebElement> lwe){
		boolean stringfound=false;
		int i=0;
		Iterator<WebElement> itr = lwe.iterator();
		while (itr.hasNext()) {
			WebElement element = itr.next();
			i++;
			System.out.println("userlist: "+element.getText());
			if (element.getText().equals(str))
			{
				stringfound=true;
				break;
			}
		}
		System.out.println("string position "+i);
		if (stringfound)
			return i;
		else return 0;
	}

	public void refresh_page(WebDriver driver)
	{
		driver.navigate().refresh();
	}

	public boolean isElementVisible(WebDriver driver,String id)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;

		String script = "return $(document.getElementById('"+id+"')).is(':visible')";
		boolean visible=(Boolean) js.executeScript(script);
		return visible;
	}


	//sumit
	public int search_substring_list_webelement(String str,List<WebElement> lwe){
		boolean stringfound=false;
		int i=0;
		Iterator<WebElement> itr = lwe.iterator();
		while (itr.hasNext()) {
			WebElement element = itr.next();
			i++;
			System.out.println("userlist: "+element.getText());
			if (element.getText().contains(str))
			{
				stringfound=true;
				break;
			}
		}
		System.out.println("string position "+i);
		if (stringfound)
			return i;
		else return 0;
	}
	
	

	public void open_file_dialog(String filepath) throws AWTException, InterruptedException{
		setClipBoardData(filepath);
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
	}

	public boolean searchList1(List<String> s1list,List<String> stringList)
	{
		boolean blnFound = stringList.contains(s1list);
		return blnFound;
	}
	
	public void elementIsDisable(WebDriver driver, WebElement element) throws Exception {
	   
	    Thread.sleep(2000);
	    String disableAttribute = element.getAttribute("disabled");
	    Assert.assertEquals("true", disableAttribute);
	}
	
	public int click_string_list_webelement(WebDriver driver,String str,List<WebElement> lwe){
		boolean stringfound=false;
		int i=0;
		Iterator<WebElement> itr = lwe.iterator();
		while (itr.hasNext()) {
			WebElement element = itr.next();
			i++;
			System.out.println("userlist: "+element.getText());
			if (element.getText().equals(str))
			{
				stringfound=true;
				click2(driver,element);
				break;
			}
		}
		System.out.println("string position "+i);
		if (stringfound)
			return i;
		else return 0;
	}
	
	public int click_substring_list_webelement_ignore_case(WebDriver driver,String str,List<WebElement> lwe){
		boolean stringfound=false;
		int i=0;
		Iterator<WebElement> itr = lwe.iterator();
		while (itr.hasNext()) {
			WebElement element = itr.next();
			i++;
			System.out.println("userlist: "+element.getText());
			if (element.getText().toLowerCase().contains(str.toLowerCase()))
			{
				stringfound=true;
				click(element);
				break;
			}
		}
		System.out.println("string position "+i);
		if (stringfound)
			return i;
		else return 0;
	}

	
	
	
	
	
	
	
	
}
	
	

