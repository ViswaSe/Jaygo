package assignments.feb17;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundHyperLinks {

	public static void main(String args[]) throws IOException
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		String url = "http://leafground.com/pages/Link.html";
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElementByLinkText("Go to Home Page").click();
		System.out.println("Home page title: "+driver.getTitle());
		
		//click to go back to hyper link page
		driver.findElementByXPath("//h5[text()='HyperLink']").click();
		System.out.println("Landed in page: "+driver.getTitle());
		
		//URL broken validations
		WebElement eleWithoutClick = driver.findElementByXPath("//a[contains(text(),'without clicking me')]");
		String landingPage = eleWithoutClick.getAttribute("href");
		System.out.println(landingPage);
		
		WebElement eleBroken = driver.findElementByLinkText("Verify am I broken?");
		URL brokenURL = new URL(eleBroken.getAttribute("href"));
		HttpURLConnection openConnection = (HttpURLConnection) brokenURL.openConnection();
		openConnection.connect();
	
		int statusCode = openConnection.getResponseCode();
		System.out.println(statusCode);
		
		if(statusCode>=400)
			System.out.println(landingPage + "is broken.");
		else
			System.out.println(landingPage + "is not broken.");
		
		driver.findElementByXPath("(//a[contains(text(),'Go to Home Page')])[2]").click();
		System.out.println("Back to home page: "+driver.getTitle());
		driver.findElementByXPath("//h5[text()='HyperLink']").click();
		
		List<WebElement> eleAllLinks = driver.findElementsByTagName("a");
		System.out.println("Total Number of links in the page: " +eleAllLinks.size());
		
	}
}
