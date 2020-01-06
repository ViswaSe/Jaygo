package org.selenium.testcases;

import java.util.Map;

import org.selenium.base.ProjectSpecificMethods;
import org.selenium.pages.LoginPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginAndLogout extends ProjectSpecificMethods{

	
	@BeforeTest
	public void provideData()
	{
		fileName=this.getClass().getSimpleName();
		testName="Login And Logout Scenario";
		testCaseName="Login And Logout Validations";
		testCaseDescription="This test case is to validate the login and logout functionality";
		browser="chrome";
		url="http://leaftaps.com/opentaps/control/main";
	}
	
	@Test(dataProvider="fetchData")
	public void doLoginAndLogout(Map<String,String> map)
	{
		new LoginPage()
		.enterUserName(map.get("username"))
		.enterPassword(map.get("password"))
		.clickLoginButton()
		.clickLogout();
	}
	
}
