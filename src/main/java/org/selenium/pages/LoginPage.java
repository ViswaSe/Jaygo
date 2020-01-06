package org.selenium.pages;

import org.openqa.selenium.WebElement;
import org.selenium.base.ProjectSpecificMethods;

public class LoginPage extends ProjectSpecificMethods {
	
	public WebElement ele;
	
	public LoginPage enterUserName(String username)
	{
		ele=locateElement("id", "username");
		clearAndType(ele, username);
		return this;
	}
	
	public LoginPage enterPassword(String password)
	{
		ele=locateElement("id", "password");
		clearAndType(ele,password);
		return this;
	}
	
	public HomePage clickLoginButton()
	{
		ele=locateElement("className","decorativeSubmit");
		click(ele);
		return new HomePage();
	}

}
