package assignments.feb28;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InteractWithNykaaApplication {
	
	public static void main(String args[]) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		String url = "https://www.nykaa.com/";
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement ele_Brands = driver.findElementByXPath("//a[text()='brands']");
		Actions builder = new Actions(driver);
		builder.moveToElement(ele_Brands).perform();
		
		driver.findElementById("brandSearchBox").sendKeys("L'Oreal Paris");
		driver.findElementByXPath("//a[contains(text(),'Oreal Paris')]").click();
		
		String title = driver.getTitle();
		
		if(title.contains("L'Oreal Paris"))
			System.out.println(title);
		
		driver.findElementByXPath("//span[contains(text(),'Sort By')]").click();
		driver.findElementByXPath("//span[contains(text(),'customer top rated')]").click();
		driver.findElementByXPath("//span[contains(text(),'Category')]").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//span[contains(text(),'Hair')]").click();
		Thread.sleep(1000);
		driver.findElementByXPath("//span[contains(text(),'Hair Care')]").click();
		Thread.sleep(1000);
		driver.findElementByXPath("//span[contains(text(),'Shampoo')]").click();
		
		driver.findElementByXPath("//span[contains(text(),'Concern')]").click();
		Thread.sleep(1000);
		driver.findElementByXPath("//span[contains(text(),'Color Protection')]").click();
		
		WebElement ele_filters = driver.findElementByXPath("//div[@id='filters-listing']/div[1]/div[2]");
		
		String filter_search="Shampoo";
		
		List<WebElement> filters_list = ele_filters.findElements(By.tagName("span"));
		for(WebElement each_filter:filters_list)
		{
			if(each_filter.getText().contains(filter_search))
			{
				System.out.println(each_filter.getText());	
				break;
			}
			else
				System.out.println("Filter search is not working as expected");
		}
		
		int i=1;
		WebElement ele_firstProduct = driver.findElementByXPath("//div[@id='product-list-wrap']/div["+i+"]");
		ele_firstProduct.click();
		
		Set<String> allWindows=driver.getWindowHandles();
		String expectedTitle = "Oreal Paris Colour Protect Shampoo";
		
		for(String eachWindow:allWindows)
		{
			String actual_title=driver.switchTo().window(eachWindow).getTitle();
			System.out.println(actual_title);
			if(actual_title.contains(expectedTitle))
			{
				driver.switchTo().window(eachWindow);
				break;
			}
		}
		
		System.out.println("Window switching is done..");
		
		WebElement ele_select = driver.findElementByXPath("//select[@title='SIZE']");
		Select obj = new Select(ele_select);
		obj.selectByValue("1");
		
		String mrp_Price = driver.findElementByXPath("//span[text()='MRP:']/following::span[1]").getText();
		mrp_Price=mrp_Price.replaceAll("[^a-zA-Z0-9]","");
		System.out.println(mrp_Price);
		
		driver.findElementByXPath("//span[text()='ADD TO BAG']").click();
		driver.findElementByXPath("//span[@class='cart-count']").click();
		Thread.sleep(1000);
		
		driver.switchTo().frame(0);
		String grand_Total=driver.findElementByXPath("//div[@class='value medium-strong']").getText();
		grand_Total=grand_Total.replaceAll("[^a-zA-Z0-9]","");
		System.out.println(grand_Total);
		
		Thread.sleep(1000);
		driver.findElementByXPath("//span[text()='PROCEED']//..//..").click();
		Thread.sleep(1000);
		driver.findElementByXPath("//button[text()='CONTINUE AS GUEST']").click();
	
		String final_grandTotal = driver.findElementByXPath("//div[text()='Grand Total']/following::span[1]").getText();
		System.out.println(final_grandTotal); 
		
		Thread.sleep(1000);
		if(grand_Total.equals(final_grandTotal))
			System.out.println("Application is working fine");
		else
			System.out.println("Application is not working as expected");
		
		driver.quit();
	}

}
