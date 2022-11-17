/***
 *
 */
package org.atmecs.testsuite;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.enums.BrowserType;

public class SampleTestSuiteBase {
	public Browser browser;

	

	@BeforeClass
	public void preSetup() {
		browser = new Browser();
		
		
	}

	@AfterClass
	public void teardown() {
		browser.closeBrowser();
	}

}