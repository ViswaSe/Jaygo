package org.selenium.pages;

import org.openqa.selenium.WebElement;
import org.selenium.base.ProjectSpecificMethods;

public class ViewAccountPage extends ProjectSpecificMethods{
	
	WebElement ele;
	
	public ViewAccountPage verifyAccountName(String accountName)
	{
		ele=locateElement("//span[text()='Account Name']/following::span[1]");
		verifyPartialText(ele, accountName);
		return this;
	}
	

}
