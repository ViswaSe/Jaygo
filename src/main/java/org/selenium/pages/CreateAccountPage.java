package org.selenium.pages;

import org.openqa.selenium.WebElement;
import org.selenium.base.ProjectSpecificMethods;

public class CreateAccountPage extends ProjectSpecificMethods{
	
	WebElement ele;
	
	public CreateAccountPage enterAccountName(String accountName)
	{
		ele=locateElement("id","accountName");
		clearAndType(ele, accountName);
		return this;
	}
	
	public CreateAccountPage enterLocalName(String localName)
	{
		ele=locateElement("name","groupNameLocal");
		clearAndType(ele, localName);
		return this;
	}
	
	public CreateAccountPage selectIndustryDropdownByText(String industryText)
	{
		ele=locateElement("name","industryEnumId");
		selectDropDownUsingText(ele, industryText);
		return this;
	}
	
	public CreateAccountPage selectSourceDropdownByText(String sourceText)
	{
		ele=locateElement("id","dataSourceId");
		selectDropDownUsingText(ele, sourceText);
		return this;
	}
	
	public CreateAccountPage enterMailAddress(String email)
	{
		ele=locateElement("id","primaryEmail");
		clearAndType(ele, email);
		return this;
	}

	public ViewAccountPage clickSubmitButton()
	{
		ele=locateElement("classname","smallSubmit");
		click(ele);
		return new ViewAccountPage();
	}
}
