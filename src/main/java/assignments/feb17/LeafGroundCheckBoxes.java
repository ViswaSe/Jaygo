package assignments.feb17;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundCheckBoxes {
	
	public static void main(String args[])
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		String url = "http://leafground.com/pages/checkbox.html";
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement cc1 = driver.findElementByXPath("(//div[@class='example'])[1]");
		List<WebElement> allCheckBox=cc1.findElements(By.tagName("input"));
		
		for(WebElement eachCheckBox:allCheckBox)
		{
			eachCheckBox.click();
		}
		
		//verify checkbox is enabled or not
		boolean enabled=driver.findElementByXPath("//div[text()='Selenium']/input[1]").isEnabled();
		System.out.println("Selenium checkbox enabled: "+enabled);
		
		//Deselect only selected
		WebElement deSelect = driver.findElementByXPath("(//div[@class='example'])[3]");
		List<WebElement> allCC=deSelect.findElements(By.tagName("input"));
		
		for(WebElement eachCC:allCC)
		{
			if(eachCC.isSelected())
				eachCC.click();
		}
		
		//Select all below checkboxes
		WebElement eleFinalCC = driver.findElementByXPath("(//div[@class='example'])[4]");
		List<WebElement> allFinalOptions = eleFinalCC.findElements(By.tagName("input"));
		for(WebElement eachFinalOption:allFinalOptions)
		{
			eachFinalOption.click();
		}
		
	}
}
