package org.atmecs.testscript;

import java.util.Properties;

import org.atmecs.constant.ExcelReader;
import org.atmecs.constant.FilePathConstants;
import org.atmecs.constant.Helper;
import org.atmecs.constant.LocatorKeyContainer;
import org.atmecs.constant.Pageactions;
import org.atmecs.testsuite.SampleTestSuiteBase;
import org.atmecs.testsuite.TestSuiteBase;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;


import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.ui.selenium.Click;
import com.atmecs.falcon.automation.ui.selenium.TextField;
import com.atmecs.falcon.automation.util.enums.BrowserType;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.locatorSmartFixTool.models.SmartFixPageFileHandler;


public class VerifyLoginTest extends TestSuiteBase{
	

	private ReportLogService report = new ReportLogServiceImpl(VerifyLoginTest.class);
	Helper helper=new Helper();
	Properties prop = ExcelReader.readProperties(FilePathConstants.SWAGLABSDEMO);
	Pageactions page= new Pageactions(browser);
	
	
	@DataProvider
	public Object[][] getLoginData()
	{
		Object data[][]=ExcelReader.getTestData("login");
		return data;
	}

	@Test(dataProvider="getLoginData")
	public void loginTest(String username,String password,String title)
	{
		browser.getDriver();
		//System.out.println(username+""+password+""+title);
		//helper.login("locator.username", "locator.pwd", "locator.loginbutton","locator.error", username,password,title);
		page.sendKeys(prop.getProperty("locator.username"),username);
		report.info("username");
		page.sendKeys(prop.getProperty("locator.pwd"),username);
		report.info("password");
		
		page.elementClick(prop.getProperty("locator.loginbutton"));
		report.info("clicked");
		String actualtext=page.getText(prop.getProperty("locator.error"));
		report.info("title");
		page.verifyNegativeResults(actualtext, title, "verified");
	}
	
	
	

	
}
