package assignments.feb17;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundImage {
	
	public static void main(String args[]) throws ClientProtocolException, IOException
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		String url = "http://leafground.com/pages/Image.html";
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.findElementByXPath("//img[@src='../images/home.png']").click();
		System.out.println("Take you to the page: "+driver.getTitle());
		
		driver.findElementByXPath("//h5[text()='Image']").click();
		
		//broken images validations in selenium
		WebElement eleBroken = driver.findElementByXPath("//img[@src='../images/abcd.jpg']");
		
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(eleBroken.getAttribute("src"));
		HttpResponse response = client.execute(request);
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println(statusCode);
		
		if(statusCode!=200)
			System.out.println(eleBroken.getAttribute("src")+ " is broken image");
		else
			System.out.println(eleBroken.getAttribute("src") + " is not broken image");
		
		WebElement eleMouseClick = driver.findElementByXPath("//img[@src='../images/keyboard.png']");
		Actions builder = new Actions(driver);
		builder.moveToElement(eleMouseClick).pause(3000).click(eleMouseClick).build().perform();
		
		//builder.moveToElement(eleMouseClick).sendKeys(Keys.ENTER).build().perform();
		
	}

}
