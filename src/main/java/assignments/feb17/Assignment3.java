package assignments.feb17;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3 {
	
	public static void main(String args[])
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		String url = "https://acme-test.uipath.com/login";
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElementByName("email").sendKeys("kumar.testleaf@gmail.com");
		driver.findElementByName("password").sendKeys("leaf@12");
		driver.findElementByXPath("//button[contains(text(),'Login')]").click();
		
		System.out.println("Title of the page: "+driver.getTitle());
		
		driver.findElementByLinkText("Log Out").click();
		driver.close();
	}

}
