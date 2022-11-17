package org.atmecs.constant;

import java.util.Properties;


import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;

public class Helper {
	
	Browser browser=null;
	
	Properties prop = ExcelReader.readProperties(FilePathConstants.SWAGLABSDEMO);
    Pageactions page;
    private ReportLogService report = new ReportLogServiceImpl(Helper.class);
//	public Helper(Browser browser) {
//		this.browser = browser;
//		page=new Pageactions(browser);
//	}
	
	public void login(String usernamelocator,String pwdlocator,String btnlocator,String erromsglocator,String username,String password,String title)
	{
//		page.sendKeys(prop.getProperty(usernamelocator),username);
//		page.sendKeys(prop.getProperty(pwdlocator),username);
//		page.clickOnElement(btnlocator);
//		page.getText(erromsglocator);
//		
		
		
	}
	

}
