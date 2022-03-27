package assignments.feb17;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {
	
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
		
		String name="Vishveshwar";
		
		driver.findElementByXPath("(//input[@name='firstName'])[3]").sendKeys(name);
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(3000);
		
		driver.findElementByXPath("(//a[text()='"+name+"'])[1]").click();
		
		String title = driver.getTitle();
		if(title.equals("View Lead | opentaps CRM"))
			System.out.println("Title matches as expected: "+title);
		else
			System.out.println("Title is not matching as expected");
		
		driver.findElementByLinkText("Edit").click();
		driver.findElementById("updateLeadForm_companyName").clear();
		driver.findElementById("updateLeadForm_companyName").sendKeys("Sedin Technologies Private Limited");
		driver.findElementByName("submitButton").click();
		
		String company_name=driver.findElementById("viewLead_companyName_sp").getText();
		String actual_name=company_name.replaceAll("[^a-zA-Z]", " ");
		System.out.println(actual_name);
		
		driver.close();
		
	}

}
