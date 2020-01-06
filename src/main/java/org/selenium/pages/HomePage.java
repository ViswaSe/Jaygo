package org.selenium.pages;

import org.openqa.selenium.WebElement;
import org.selenium.base.ProjectSpecificMethods;

public class HomePage extends ProjectSpecificMethods{
	
	public WebElement ele;
	
	public LoginPage clickLogout()
	{
		ele=locateElement("className","decorativeSubmit");
		click(ele);
		return new LoginPage();
	}

}
