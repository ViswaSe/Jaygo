package org.selenium.pages;

import org.openqa.selenium.WebElement;
import org.selenium.base.ProjectSpecificMethods;

public class AccountsPage extends ProjectSpecificMethods{
	
	WebElement ele;
	
	public CreateAccountPage clickCreateAccount()
	{
		ele=locateElement("linktext","Create Account");
		click(ele);
		return new CreateAccountPage();
	}
	
	
}
