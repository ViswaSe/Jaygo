package assignments.feb17;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundDropdown {
	
	public static void main(String args[])
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		String url = "http://leafground.com/pages/Dropdown.html";
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//select by index
		WebElement eleDD1 = driver.findElementById("dropdown1");
		Select obj = new Select(eleDD1);
		obj.selectByIndex(1);
		
		//select by text
		WebElement eleDD2 = driver.findElementByName("dropdown2");
		Select obj1 = new Select(eleDD2);
		obj1.selectByVisibleText("Loadrunner");
		
		//select by value
		WebElement eleDD3 = driver.findElementByName("dropdown3");
		Select obj2 = new Select(eleDD3);
		obj2.selectByValue("2");
		
		//Get the number of dropdown options
		WebElement dropdown=driver.findElementByXPath("//select[@class='dropdown']");
		Select obj3 = new Select(dropdown);
		int size = obj3.getOptions().size();	
		System.out.println("Total number of dropdown options: "+size);
		
		//using sendkeys
		WebElement eleDropdown=driver.findElementByXPath("(//select)[5]");
		eleDropdown.sendKeys("UFT/QTP");
		
		//Multiselect 
		WebElement eleFinalDD = driver.findElementByXPath("(//select)[6]");
		Select objeleFinal = new Select(eleFinalDD);
		List<WebElement> allOptions = objeleFinal.getOptions();
		
		for(WebElement each:allOptions)
		{
			System.out.println(each.getText());
			each.click();
		}
		
		
	}

}
