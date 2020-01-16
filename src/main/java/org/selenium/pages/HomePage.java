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
	
	public HomePage verifyHomePageTitle(String pageTitle)
	{
		verifyTitle(pageTitle);
		return this;
	}

	public MyHomePage clickCRMSFALink()
	{
		ele=locateElement("linktext","CRM/SFA");
		click(ele);
		return new MyHomePage();
	}
}
