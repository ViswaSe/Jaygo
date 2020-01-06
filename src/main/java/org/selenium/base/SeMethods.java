package org.selenium.base;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.selenium.design.Browser;
import org.selenium.design.Element;
import org.selenium.utils.Reporter;

public class SeMethods extends Reporter implements Browser,Element{
	
	public static ThreadLocal<RemoteWebDriver> td=new ThreadLocal<RemoteWebDriver>();
	
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
		// TODO Auto-generated method stub
		
	}

	public void clear(WebElement ele) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return null;
	}

	public String getBackgroundColor(WebElement ele) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTypedText(WebElement ele) {
		// TODO Auto-generated method stub
		return null;
	}

	public void selectDropDownUsingText(WebElement ele, String value) {
		// TODO Auto-generated method stub
		
	}

	public void selectDropDownUsingIndex(WebElement ele, int index) {
		// TODO Auto-generated method stub
		
	}

	public void selectDropDownUsingValue(WebElement ele, String value) {
		// TODO Auto-generated method stub
		
	}

	public boolean verifyExactText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean verifyPartialText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean verifyExactAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub
		return false;
	}

	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub
		
	}

	public boolean verifyDisplayed(WebElement ele) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean verifyDisappeared(WebElement ele) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean verifyEnabled(WebElement ele) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return null;
	}

	public List<WebElement> locateElements(String type, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	public void switchToAlert() {
		// TODO Auto-generated method stub
		
	}

	public void acceptAlert() {
		// TODO Auto-generated method stub
		
	}

	public void dismissAlert() {
		// TODO Auto-generated method stub
		
	}

	public String getAlertText() {
		// TODO Auto-generated method stub
		return null;
	}

	public void typeAlert(String data) {
		// TODO Auto-generated method stub
		
	}

	public void switchToWindow(int index) {
		// TODO Auto-generated method stub
		
	}

	public void switchToWindow(String title) {
		// TODO Auto-generated method stub
		
	}

	public void switchToFrame(int index) {
		// TODO Auto-generated method stub
		
	}

	public void switchToFrame(WebElement ele) {
		// TODO Auto-generated method stub
		
	}

	public void switchToFrame(String idOrName) {
		// TODO Auto-generated method stub
		
	}

	public void defaultContent() {
		// TODO Auto-generated method stub
		
	}

	public boolean verifyUrl(String url) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean verifyTitle(String title) {
		// TODO Auto-generated method stub
		return false;
	}

	public void close() {
		// TODO Auto-generated method stub
		
	}

	public void quit() {
		
		try 
		{
			getDriver().quit();
			reportStep("All the opened browsers has been closed successfully","info");
		}
		
		catch (Exception e) {
			reportStep("couldn't close all the opened browsers","error");
		}
		
	}

}
