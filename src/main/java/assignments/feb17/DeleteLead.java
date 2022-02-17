package assignments.feb17;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {
	
	public static void main(String args[]) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		String url = "http://leaftaps.com/opentaps/control/main";
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		
		driver.findElementByPartialLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Find Leads").click();
		
		driver.findElementByXPath("//span[text()='Phone']").click();
		driver.findElementByName("phoneCountryCode").clear();
		driver.findElementByName("phoneCountryCode").sendKeys("91");
		driver.findElementByName("phoneNumber").sendKeys("9578184957");
		
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(5000);
		
		String lead_Id=driver.findElementByXPath("//table[@class='x-grid3-row-table']/tbody/tr/td[1]").getText();
		System.out.println(lead_Id);
		
		driver.findElementByXPath("//a[text()='"+lead_Id+"']").click();
		driver.findElementByLinkText("Delete").click();
		driver.findElementByLinkText("Find Leads").click();
		
		driver.findElementByXPath("//input[@name='id']").sendKeys(lead_Id);
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(3000);
		
		String result = driver.findElementByXPath("//div[contains(text(),'No records')]").getText();
		System.out.println(result);
		
		driver.close();
	}

}
