package org.atmecs.testsuite;

import java.net.MalformedURLException;
import java.util.Properties;

import org.atmecs.constant.ExcelReader;
import org.atmecs.constant.FilePathConstants;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.ui.selenium.RunModeGrid;
import com.atmecs.falcon.automation.util.logging.LogLevel;
import com.atmecs.falcon.automation.util.logging.LogManager;
import com.atmecs.falcon.automation.util.parser.PropertyParser;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;


public class TestSuiteBase {

	public Browser browser;
	
	
	
	 Properties prop = ExcelReader.readProperties(FilePathConstants.SWAGLABSDEMO);
	private ReportLogService report = new ReportLogServiceImpl(TestSuiteBase.class);

	
	  
//	  public Browser TestSuiteBase(){
//		  browser = new Browser();
//	       browser.getDriver();
//	    if (browser == null){
//	    	browser = new Browser();
//	      return browser;
//	    }else{ 
//	      return browser ;
//	    }
//	  }
//	
	
	
	  public TestSuiteBase(){
		 
	   browser =new Browser();
	  }
	  public Browser getdriver(){
	    if (browser == null){
	    	browser =new Browser();
	      return browser;
	    }else{
	      return browser;
	    }
	  }
	// In this method the browser is invoked and url is opened
	@BeforeMethod
	public Browser preSetup()  {
		
		String browserName =System.getProperty("browser", "chrome");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName(browserName);
		
		//cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		String jenkinsurl=System.getProperty("url");
		
		RunModeGrid run=new RunModeGrid("win", "10","chrome", "107",cap);
		//driver = new RemoteWebDriver(new URL("http://55.55.54.149:4444"),cap);
		
		//browser = new Browser();
		browser.getDriver();
		
	      
		LogManager.setLogLevel(LogLevel.valueOf(PropertyParser.readEnvOrConfigProperty("LOG_LEVEL")));
		report.info("Opening browser: " + browserName);
		String url = prop.getProperty("url");
		browser.openURL(url,"win", "10",browserName,"107");
		report.info("Maximizing browser window");
		browser.maximizeWindow();
		browser.getWait().implicitWait(5);
		return browser;
		
	}
    //In this method the browser is closed after the execution of the script 
	@AfterMethod
	public void teardown() {
		browser.closeBrowser();
	}
}
