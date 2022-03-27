package org.selenium.utils;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public abstract class Reporter {
	
	public static ExtentHtmlReporter html;
	public static ExtentReports extent;
	public ExtentTest suiteTest,node;
	
	public static ThreadLocal<ExtentTest> st=new ThreadLocal<ExtentTest>();
	public static ThreadLocal<ExtentTest> nd=new ThreadLocal<ExtentTest>();
	
	public String fileName,testName,testCaseName,testCaseDescription,browser,url,author,category;
	
	
	public void setSuiteTest(ExtentTest suiteTest)
	{
		st.set(suiteTest);
	}
	
	public ExtentTest getSuiteTest()
	{
		return st.get();
	}
	
	public void setNode(ExtentTest node)
	{
		nd.set(node);
	}
	
	public ExtentTest getNode()
	{
		return nd.get();
	}
	
	
	
	@BeforeSuite
	public void start()
	{
		html=new ExtentHtmlReporter("./reports/AccountModule.html");
		html.setAppendExisting(true);
		extent=new ExtentReports();
		extent.attachReporter(html);
	}
	
	@BeforeClass
	public ExtentTest init()
	{
		suiteTest=extent.createTest(testName);
		setSuiteTest(suiteTest);
		getSuiteTest().assignAuthor(author);
		getSuiteTest().assignCategory(category);
		return getSuiteTest();
	}
	
	public void reportStep(String desc,String status)
	{
		reportStep(desc,status,true);
	}
	
	public abstract long takeSnap();
	
	public void reportStep(String desc,String status,boolean bsnap)
	{
		long snapNumber=1000000L;
		
		if(!(bsnap && status.equals("info")))
		{
			
			MediaEntityModelProvider img=null;
			snapNumber=takeSnap();
			
			try 
			{
				img=MediaEntityBuilder.createScreenCaptureFromPath("./../screenshots/"+snapNumber+".png")
						.build();
				
				if(status.equals("pass"))
				{
					getNode().pass(desc, img);
				}
				
				else
				{
					getNode().fail(desc,img);
				}
				
			}
			
			catch (IOException e) 
			{
				System.out.println("Issue in taking screenshot path");
			}
			
		}
		
		else if(status.equals("info"))
		{
			getNode().info(desc);
		}
		
		else if(status.equals("error"))
		{
			getNode().error(desc);
		}
		
	}
	
	public void doFlush()
	{
		extent.flush();
	}

}
