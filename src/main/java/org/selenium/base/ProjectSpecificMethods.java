package org.selenium.base;

import org.selenium.utils.ExcelUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class ProjectSpecificMethods extends SeMethods {
	
	@BeforeMethod
	public void startApplication()
	{
		node=getSuiteTest().createNode(testCaseName, testCaseDescription);
		setNode(node);
		startApp(browser, url);
	}
	
	@DataProvider(name="fetchData")
	public Object[][] readExcelValue()
	{
		System.out.println(fileName);
		return new ExcelUtils().readExcel(fileName);
	}
	
	@AfterMethod
	public void endResult()
	{
		quit();
		doFlush();
	}

}
