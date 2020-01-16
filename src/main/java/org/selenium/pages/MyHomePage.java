package org.selenium.pages;

import org.openqa.selenium.WebElement;
import org.selenium.base.ProjectSpecificMethods;

public class MyHomePage extends ProjectSpecificMethods{
	
	WebElement ele;
	
	public AccountsPage clickAccountsPage()
	{
		ele=locateElement("linktext","Accounts");
		click(ele);
		return new AccountsPage();
	}

}
