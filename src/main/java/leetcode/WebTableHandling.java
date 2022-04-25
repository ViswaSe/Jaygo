package leetcode;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableHandling {
	
	public static void main(String args[])
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		String url="http://www.leafground.com/pages/table.html";
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//taking the entire table into a webelement
		WebElement table = driver.findElementByXPath("//table");
		
		//finding row size & column size
		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		int rowSize = allRows.size();
		
		//travel to first row
		WebElement firstRow = allRows.get(0);
		
		//take all the columns from first row
		List<WebElement> firstRowColumns=firstRow.findElements(By.tagName("th"));
		
		//find the column size
		int columnSize = firstRowColumns.size();
		
		//travel to entire table row by row and travel to entire column in each row
		
		for(int i=0;i<rowSize;i++)
		{
			WebElement eachRow = allRows.get(i); //first second third fourth
			
			List<WebElement> allCols;
			
			if(i==0)
				allCols = eachRow.findElements(By.tagName("th")); //allCols = 0th row all cols 
			else
				allCols = eachRow.findElements(By.tagName("td")); //allCols = 1st row all cols 2ndrow all cols
			
			for(int j=0;j<columnSize;j++)
			{
				String text = allCols.get(j).getText();
				System.out.print(text+" ");
				
				if(text.contains("80"))
				{
					allCols.get(j+1).click();
				}
			}
			
			System.out.println();
		}
		
	}

}
