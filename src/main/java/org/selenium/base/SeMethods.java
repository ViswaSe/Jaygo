package org.selenium.base;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.design.Browser;
import org.selenium.design.Element;
import org.selenium.utils.Reporter;

public class SeMethods extends Reporter implements Browser,Element{
	
	public static ThreadLocal<RemoteWebDriver> td=new ThreadLocal<RemoteWebDriver>();
	public static String text;
	public WebDriverWait wait;
	
	public long takeSnap()
	{	
		try 
		{
			long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L; 
			File src=getDriver().getScreenshotAs(OutputType.FILE);
			File desc=new File("./screenshots/"+number+".png");
			FileUtils.copyFile(src, desc);
			return number;
		} 
		
		catch (Exception e) {
			e.printStackTrace();
			reportStep("couldn't take the screenshot of the webpage","info");
		}
		
		return 0;
	}
	
	
	public RemoteWebDriver getDriver()
	{
		return td.get();
	}
	
	public void setDriver(RemoteWebDriver driver)
	{
		td.set(driver);
	}

	public void click(WebElement ele) {
		
		try 
		{
			ele.click();
			reportStep("Webelement clicked successfully in the page","pass");
		} 
		
		catch (Exception e) {
			e.printStackTrace();
			reportStep("unable to click on the webelement in the page","fail");
		}
		
	}

	public void append(WebElement ele, String data) {
		
		try
		{
			ele.sendKeys(data);
			reportStep("Data value: "+data+" appended to the text box successfully","pass");
		}
		catch(Exception e)
		{
			reportStep("couldn't append the data value: "+data+" to the text box","fail");
		}
		
	}

	public void clear(WebElement ele) {
		
		try
		{
			ele.clear();
			reportStep("Webelement cleared successfully","pass");
		}
		catch(Exception e)
		{
			reportStep("couldn't clear the value of the webelement","fail");
		}
		
	}

	public void clearAndType(WebElement ele, String data) {
		
		try 
		{
			ele.clear();
			ele.sendKeys(data);
			reportStep("Webelement cleared and data value: "+data+" entered successfully","pass");
		}
		
		catch (Exception e) {
			e.printStackTrace();
			reportStep("couldn't cleared the webelement in the page and unable to send the data: "+data,"fail");
		}
		
	}

	public String getElementText(WebElement ele) {
		
		try
		{
			text=ele.getText();
			reportStep("Text value: "+text+" retrived from the textbox successfully","pass");
		}
		catch(Exception e)
		{
			reportStep("couldn't retrive the text value of the webelement","fail");
		}
		
		return text;
	}

	public String getBackgroundColor(WebElement ele) {
		
		try
		{
			text=ele.getCssValue("background-color");
			reportStep("Background css value retrived from the webelement: "+text,"pass");
		}
		catch(Exception e)
		{
			reportStep("couldn't retrive the css value of the webelement","fail");
		}
		
		return text;
	}

	public String getTypedText(WebElement ele) {
		// TODO Auto-generated method stub
		return null;
	}

	public void selectDropDownUsingText(WebElement ele, String value) {
		
		try
		{
			new Select(ele).selectByVisibleText(value);
			reportStep("Dropdown value selected based on the given text: "+value,"pass");
		}
		catch(Exception e)
		{
			reportStep("couldn't select the value from the dropdown based on the given text: "+text,"fail");
		}
		
	}

	public void selectDropDownUsingIndex(WebElement ele, int index) {
		
		try
		{
			new Select(ele).selectByIndex(index);
			reportStep("Dropdown value selected based on the given index: "+index,"pass");
		}
		catch(Exception e)
		{
			reportStep("couldn't select the value from the dropdown based on the given index: "+index,"fail");
		}
		
	}

	public void selectDropDownUsingValue(WebElement ele, String value) {
		
		try
		{
			new Select(ele).selectByValue(value);
			reportStep("Dropdown value selected based on the value: "+value,"pass");
		}
		catch(Exception e)
		{
			reportStep("couldn't select the value from the dropdown based on the given value: "+value,"fail");
		}
		
	}

	public boolean verifyExactText(WebElement ele, String expectedText) {
		
		try
		{
			text=getElementText(ele);
			if(text.equals(expectedText))
			{
				reportStep("Text value: "+text+" is exactly matching with the expected text: "+expectedText,"pass");
				return true;
			}
			else
			{
				reportStep("Text value: "+text+" is not exactly matching with the expected text: "+expectedText,"fail");
				return false;
			}
		}
		catch(Exception e)
		{
			reportStep("couldn't validate the text value: "+text+" for exact match with the expected text: "+expectedText,"fail");
		}
		
		return false;
	}

	public boolean verifyPartialText(WebElement ele, String expectedText) {
		
		
		try
		{
			text=getElementText(ele);
			if(text.contains(expectedText))
			{
				reportStep("Text value: "+text+" is partially matching with the expected text: "+expectedText,"pass");
				return true;
			}
			else
			{
				reportStep("Text value: "+text+" is not even partially matching with the expected text: "+expectedText,"fail");
				return false;
			}
		}
		catch(Exception e)
		{
			reportStep("couldn't validate the text value: "+text+" for partial match with the expected text: "+expectedText,"fail");
		}
		
		return false;
	}

	public boolean verifyExactAttribute(WebElement ele, String attribute, String value) {
		
		try
		{
			text=ele.getAttribute(attribute);
			if(text.equals(value))
			{
				reportStep("Attribute value: "+text+" is exactly matching with the expected value: "+value,"pass");
				return true;
			}
			else
			{
				reportStep("Attribute value: "+text+" is not exactly matching with the expected value: "+value,"fail");
				return false;
			}
		}
		catch(Exception e)
		{
			reportStep("couldn't validate the attribute value: "+text+" for exact match with the expected value: "+value,"fail");
		}
		
		return false;
	}

	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		
		try
		{
			text=ele.getAttribute(attribute);
			if(text.contains(value))
			{
				reportStep("Attribute value: "+text+" is partially matching with the expected value: "+value,"pass");
			}
			else
			{
				reportStep("Attribute value: "+text+" is not even partially matching with the expected value: "+value,"fail");
			}
		}
		catch(Exception e)
		{
			reportStep("couldn't validate the attribute value: "+text+" for partial match with the expected value: "+value,"fail");
		}
		
	}

	public boolean verifyDisplayed(WebElement ele) {
		
		try
		{
			if(ele.isDisplayed())
			{
				reportStep("Webelement:"+getElementText(ele)+" is displayed on the webpage successfully","pass");
				return true;
			}
			else
			{
				reportStep("Webelement:"+getElementText(ele)+" is not displayed on the webpage successfully","fail");
				return false;
			}
			
		}
		catch(Exception e)
		{
			reportStep("couldn't validate whether the webelement is displayed or not","fail");
		}
		
		return false;
	}

	public boolean verifyDisappeared(WebElement ele) {
		
		try
		{
			wait.until(ExpectedConditions.visibilityOf(ele));
			if(ele.isDisplayed())
			{
				reportStep("Webelement:"+getElementText(ele)+" is appeared on the webpage successfully","pass");
				return true;
			}
			else
			{
				reportStep("Webelement:"+getElementText(ele)+" is not appeared on the webpage successfully","fail");
				return false;
			}
			
		}
		catch(Exception e)
		{
			reportStep("couldn't validate whether the webelement is disappeared or not","fail");
		}
		
		
		return false;
	}

	public boolean verifyEnabled(WebElement ele) {
		
		
		
		return false;
	}

	public void verifySelected(WebElement ele) {
		// TODO Auto-generated method stub
		
	}

	public void startApp(String url) {
		// TODO Auto-generated method stub
		
	}

	public void startApp(String browser, String url) {
		
		RemoteWebDriver driver;
		
		try 
		{	
			switch(browser.toLowerCase())
			{
				case "chrome":
					System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_win32/chromedriver.exe");
					driver=new ChromeDriver();
					setDriver(driver);
					break;
				
				case "firefox":
					System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
					driver=new FirefoxDriver();
					setDriver(driver);
					break;
			}
			
			getDriver().get(url);
			getDriver().manage().window().maximize();
			getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			System.out.println(browser+" browser invoked and maximised successfully");
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("couldn't initiate the browser:"+browser);
		}
		
	}

	public WebElement locateElement(String locatorType, String value) {
		
		try 
		{	
			WebElement ele=null;
			
			switch(locatorType.toLowerCase())
			{
				case "id":
					ele=getDriver().findElementById(value);break;
					
				case "classname":
					ele=getDriver().findElementByClassName(value);break;
				
				case "name":
					ele=getDriver().findElementByName(value);break;
				
				case "xpath":
					ele=getDriver().findElementByXPath(value);break;
					
				case "tagName":
					ele=getDriver().findElementByTagName(value);break;
				
				case "linktext":
					ele=getDriver().findElementByLinkText(value);break;
				
				case "partiallinktext":
					ele=getDriver().findElementByPartialLinkText(value);break;
					
			}
		
			return ele;
			
		} 
		
		catch (Exception e) {
			e.printStackTrace();
			reportStep("couldn't locate the element properly in the webpage","error");
		}
		
		return null;
	}

	public WebElement locateElement(String value) {

		try 
		{
			WebElement ele=getDriver().findElementByXPath(value);
			return ele;
		} 
		
		catch (Exception e) {
			e.printStackTrace();
			reportStep("couldn't find the webelement based on the xpath","error");
		}
		return null;
	}

	public List<WebElement> locateElements(String type, String value) {
		
		List<WebElement> eleList=null;
		
		try 
		{
			switch(type.toLowerCase())
			{
				case "tagname": 
				eleList=getDriver().findElements(By.tagName(value));
				break;
				
				case "classname":
				eleList=getDriver().findElements(By.className(value));
				break;
				
				case "id":
				eleList=getDriver().findElements(By.id(value));
			}
			
		} 
		
		catch (Exception e) {
			e.printStackTrace();
			reportStep("couldn't find the webelements based on the given type:"+type,"error");
		}
		
		return eleList;
	}

	public void switchToAlert() {
		
		try
		{
			getDriver().switchTo().alert();
			reportStep("switched to the respective alert successfully","info");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			reportStep("couldn't switched to the alert properly","error");
		}
		
	}

	public void acceptAlert() {
		
		Alert obj;
		
		try
		{
			obj=getDriver().switchTo().alert();
			obj.accept();
			reportStep("switched to the respective alert and accepted successfully","info");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			reportStep("couldn't switched to the alert and accept it properly","error");
		}
		
	}

	public void dismissAlert() {
		
		Alert obj;
		
		try
		{
			obj=getDriver().switchTo().alert();
			obj.dismiss();
			reportStep("switched to the respective alert and dismissed successfully","info");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			reportStep("couldn't switched to the alert and dismiss it properly","error");
		}
		
	}

	public String getAlertText() {
		
		Alert obj;
		
		try
		{
			obj=getDriver().switchTo().alert();
			text=obj.getText();
			reportStep("switched to the respective alert and retrived the text value successfully: "+text,"info");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			reportStep("couldn't switched to the alert and unable to retrive the text value of it","error");
		}
		
		return text;
	}

	public void typeAlert(String data) {
		
		Alert obj;
		
		try
		{
			obj=getDriver().switchTo().alert();
			obj.sendKeys(data);
			reportStep("switched to the respective alert and entered the given value in the alert: "+data,"info");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			reportStep("couldn't switched to the alert and entered the value in it properly","error");
		}
		
	}

	public void switchToWindow(int index) {
		
		Set<String> allWindows=new HashSet<String>();
		List<String> windows=new ArrayList<String>();
		
		try
		{
			allWindows=getDriver().getWindowHandles();
			windows.addAll(allWindows);
			text=windows.get(index);
			getDriver().switchTo().window(text);
			reportStep("Switched to the respective window based on the index: "+index,"pass");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			reportStep("couldn't switched to the respective window based on the given index: "+index,"fail");
		}
		
	}

	public void switchToWindow(String title) {
		
		Set<String> allWindows=new HashSet<String>();
		List<String> windows=new ArrayList<String>();
		
		try
		{
			allWindows=getDriver().getWindowHandles();
			windows.addAll(allWindows);
		
			for(int i=0;i<windows.size();i++)
			{
				text=getDriver().switchTo().window(windows.get(i)).getTitle();
				
				if(text.equals(title))
				{
					getDriver().switchTo().window(windows.get(i));
					reportStep("Switched to the window based on the title: "+title,"pass");
				}
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			reportStep("couldn't switched to the window based on the title: "+title,"fail");
		}
		
		
	}

	public void switchToFrame(int index) {
		
		try
		{
			getDriver().switchTo().frame(index);
			reportStep("switched to the respective frame based on the given index: "+index,"pass");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			reportStep("couldn't switched to the respective frame based on the given index: "+index,"fail");
		}
		
	}

	public void switchToFrame(WebElement ele) {
		
		try
		{
			getDriver().switchTo().frame(ele);
			reportStep("switched to the respective frame based on the given webelement: "+getElementText(ele),"pass");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			reportStep("couldn't switched to the respective frame based on the given webelement: "+getElementText(ele),"fail");
		}
		
	}

	public void switchToFrame(String idOrName) {
		

		try
		{
			getDriver().switchTo().frame(idOrName);
			reportStep("switched to the respective frame based on the given id/name: "+idOrName,"pass");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			reportStep("couldn't switched to the respective frame based on the given id/name: "+idOrName,"fail");
		}
		
	}

	public void defaultContent() {
		
		try
		{
			getDriver().switchTo().defaultContent();
			reportStep("Switched back to the default content successfully","info");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			reportStep("couldn't switched back to the default content of the webpage","fail");
		}
		
	}

	public boolean verifyUrl(String url) {
		
		try
		{
			text=getDriver().getCurrentUrl();
			if(text.equals(url))
			{
				reportStep("Current url: "+text+" is matching with the expected one: "+url,"pass");
				return true;
			}
			else
			{
				reportStep("Current url: "+text+" is not matching with the expected one: "+url,"fail");
				return false;
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			reportStep("couldn't verify the current url: "+text+" with the expected one: "+url,"fail");
		}
		
		return false;
	}

	public boolean verifyTitle(String title) {
		
		try
		{
			text=getDriver().getTitle();
			if(text.equals(title))
			{
				reportStep("Title of the webpage: "+text+"  is matching with the expected title: "+title,"pass");
				return true;
			}
			else
			{
				reportStep("Title of the webpage: "+text+"  is not matching with the expected title: "+title,"fail");
				return false;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			reportStep("couldn't validate the title of the webpage: "+text+" with the expected one: "+title,"fail");
		}
		
		return false;
	}

	public void close() {
		
		try
		{
			getDriver().close();
			reportStep("current browser closed successfully","info");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			reportStep("couldn't close the current browser","error");
		}
		
	}

	public void quit() {
		
		try 
		{
			getDriver().quit();
			reportStep("All the opened browsers has been closed successfully","info");
		}
		
		catch (Exception e) {
			e.printStackTrace();
			reportStep("couldn't close all the opened browsers","error");
		}
		
	}

}
