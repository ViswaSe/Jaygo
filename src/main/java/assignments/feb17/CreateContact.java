package assignments.feb17;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {
	
	public static void main(String args[])
	{
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		String url = "http://leaftaps.com/opentaps/control/login";
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		
		driver.findElementByPartialLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Create Lead").click();
		driver.findElementById("createLeadForm_companyName").sendKeys("Sedin Technologies");
		driver.findElementById("createLeadForm_firstName").sendKeys("Vishveshwar");
		driver.findElementById("createLeadForm_lastName").sendKeys("Duraiswamy");
		driver.findElementById("createLeadForm_departmentName").sendKeys("Testing");
		driver.findElementById("createLeadForm_description").sendKeys("Automation Tester - Senior Test Engineer at Sedin Technologies");
		driver.findElementById("createLeadForm_primaryEmail").sendKeys("vishveshwarduraiswamy94@gmail.com");
		
		WebElement stateDropdown = driver.findElementById("createLeadForm_generalStateProvinceGeoId");
		Select obj = new Select(stateDropdown);
		obj.selectByVisibleText("New York");
		
		driver.findElementById("createLeadForm_primaryPhoneCountryCode").clear();
		driver.findElementById("createLeadForm_primaryPhoneCountryCode").sendKeys("91");
		driver.findElementById("createLeadForm_primaryPhoneNumber").sendKeys("9578184957");
		
		driver.findElementByName("submitButton").click();
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement ele = driver.findElementByLinkText("Edit");
		wait.until(ExpectedConditions.visibilityOf(ele));
		ele.click();
		
		driver.findElementById("updateLeadForm_description").clear();
		driver.findElementById("updateLeadForm_description").sendKeys("Automation - Senior Test Engineer at Sedin Technologies");
		driver.findElementByXPath("//input[@value='Update']").click();
		
		String title = driver.getTitle();
		System.out.println("Title is: "+title);
		
		driver.close();
	}

}
