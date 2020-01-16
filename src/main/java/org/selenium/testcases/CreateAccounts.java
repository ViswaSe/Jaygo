package org.selenium.testcases;

import java.util.Map;

import org.selenium.base.ProjectSpecificMethods;
import org.selenium.pages.LoginPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateAccounts extends ProjectSpecificMethods{
	
	@BeforeTest
	public void provideDataForCreateAccounts()
	{
		fileName=this.getClass().getSimpleName();
		testName="Create Accounts Test Case";
		testCaseName="Create Accounts test case functionality validations";
		testCaseDescription="This is to create a new Accounts in the test leaf application";
		browser="chrome";
		url="http://leaftaps.com/opentaps/control/main";
	}

	@Test(dataProvider="fetchData")
	public void createNewAccountInTestLeaf(Map<String,String> map)
	{
		new LoginPage()
		.enterUserName(map.get("username"))
		.enterPassword(map.get("password"))
		.clickLoginButton()
		.verifyHomePageTitle(map.get("title1"))
		.clickCRMSFALink()
		.clickAccountsPage()
		.clickCreateAccount()
		.enterAccountName(map.get("accountname"))
		.enterLocalName(map.get("localname"))
		.selectIndustryDropdownByText(map.get("industryvalue"))
		.selectSourceDropdownByText(map.get("sourcevalue"))
		.enterMailAddress(map.get("email"))
		.clickSubmitButton()
		.verifyAccountName(map.get("accountname"));
	}
}
