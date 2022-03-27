package assignments.feb17;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundEditFields {
	
	public static void main(String args[])
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		String url = "http://leafground.com/pages/Edit.html";
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElementById("email").sendKeys("vishveshwarduraiswamy94@gmail.com");
		driver.findElementByXPath("//input[contains(@value,'Append')]").sendKeys("Text appended additionally");
		
		String value=driver.findElementByName("username").getAttribute("value");
		System.out.println(value);
		
		driver.findElementByXPath("(//input[@name='username'])[2]").clear();
		
		boolean enabledValue=driver.findElementByXPath("//label[contains(text(),'edit field')]/following::input[1]").isEnabled();
		System.out.println("Enabled: "+ enabledValue);
	}

}
