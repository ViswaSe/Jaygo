package assignments.feb17;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {
	
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
		
		driver.findElementByXPath("//span[text()='Email']").click();
		driver.findElementByName("emailAddress").sendKeys("vishveshwarduraiswamy94@gmail.com");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(3000);
		
		String name = driver.findElementByXPath("(//table[@class='x-grid3-row-table'])[1]/tbody/tr/td[3]").getText();
		System.out.println(name);
		
		driver.findElementByXPath("(//table[@class='x-grid3-row-table'])[1]/tbody/tr/td[3]/div/a[1]").click();
		driver.findElementByLinkText("Duplicate Lead").click();
		
		String title = driver.getTitle();
		if(title.equals("Duplicate Lead | opentaps CRM"))
		{
			System.out.println(title);
		}
		else
			System.out.println("Title doesn't matches as expected");
		
		driver.findElementByName("submitButton").click();
		String duplicateLeadName = driver.findElementById("viewLead_firstName_sp").getText();
		
		if(duplicateLeadName.equals(name))
			System.out.println("Lead first name is matching as expected: "+duplicateLeadName);
		else
			System.out.println("Lead first name is not matching as expected");

		
		driver.close();
		
	}

}
