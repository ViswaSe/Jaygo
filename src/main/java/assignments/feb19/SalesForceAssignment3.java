package assignments.feb19;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForceAssignment3 {
	
	public static void main(String args[]) throws ParseException
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(op);
		
		String url = "https://login.salesforce.com/";
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
		driver.findElementById("username").sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElementById("password").sendKeys("Password@123");
		driver.findElementById("Login").click();
		
		driver.findElementByXPath("(//div[@data-aura-class='uiTooltip'])[9]").click();
		driver.findElementByXPath("//button[text()='View All']").click();
		driver.findElementByXPath("//p[text()='Sales']").click();
		
		WebElement eleOppurtunities = driver.findElementByXPath("//a[@title='Opportunities']");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", eleOppurtunities);
		
		driver.findElementByXPath("//div[text()='New']").click();
		
		String oppurtunity_name="Salesforce Automation by Anirudh";
		driver.findElementByXPath("//input[@name='Name']").sendKeys(oppurtunity_name);
		System.out.println(oppurtunity_name);
		
		driver.findElementByXPath("//input[@name='CloseDate']").click();
		
		//select date from date picker
		String expectedDate="2/19/2022";
	
		String[] date_split = expectedDate.split("/");
		int monthToSelect = Integer.parseInt(date_split[1]);
		
		String actualMonth = "February";
		
		SimpleDateFormat inputFormat = new SimpleDateFormat("MMMM");
		Calendar cal = Calendar.getInstance();
		cal.setTime(inputFormat.parse(actualMonth));
		
		SimpleDateFormat outputFormat = new SimpleDateFormat("MM");
		System.out.println(outputFormat.format(cal.getTime()));
		
		int presentMonth = Integer.parseInt(outputFormat.format(cal.getTime()));
		System.out.println(presentMonth);
		
		if(monthToSelect>presentMonth)
		{
			
		}
	}

}
