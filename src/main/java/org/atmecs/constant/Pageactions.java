package org.atmecs.constant;

import java.util.Set;

import org.atmecs.testsuite.TestSuiteBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.atmecs.falcon.automation.ui.selenium.Browser;



public class Pageactions extends TestSuiteBase{
	
	
	//WebDriver browser;
 Browser browser = null;
	

	public Pageactions(Browser browser) {
		this.browser = (Browser) browser;
	}

	public void elementClick(String element) {
		WebElement webelement=browser.getFindFromBrowser().findElementByXpath(element);
		webelement.click();
	}
	
	public void clickOnElement(String element) {
		
			WebElement webelement= browser.getFindFromBrowser().findElementByXpath("//div[text()='Sauce Labs Backpack']");
			webelement.click();
		
		//browser.getFindFromBrowser().findElementById(element);
	}
	
	public void sendKeys(String element,String value) {

		WebElement webelement= browser.getFindFromBrowser().findElementById(element);
		webelement.sendKeys(value);
	}

	public String getText(String element) {
			WebElement webelement= browser.getFindFromBrowser().findElementByXpath(element);
			return webelement.getText();
	}

	public boolean verifyNegativeResults(Object actual,Object expected,String message)
	{
		try {
			Assert.assertNotEquals(actual, expected);
			System.out.println("PASS : " + message + ": " + "ACTUAL : " + actual + " 	" + "EXPECTED :" + expected);
			return true;
		}
			catch (AssertionError assertionError) {
				return false;
			}
	}
	public  boolean verifyPositiveResult(Object actual,Object expected,String message) {
		try {
			Assert.assertEquals(actual, expected);
			System.out.println("PASS : " + message + ": " + "ACTUAL : " + actual + " 	" + "EXPECTED :" + expected);
			return true;
		}
			catch (AssertionError assertionError) {
				return false;
			}
		
	}
	public boolean verifyNumberResults(Object actual,Object expected,String message)
	{
		int actualresult=Integer.parseInt(((String) actual).replaceAll("[^0-9]", ""));
		int expectedresult=Integer.parseInt(((String) actual).replaceAll("[^0-9]", ""));
	
		try {
			Assert.assertEquals(actualresult, expectedresult);
			System.out.println("PASS : " + message + ": " + "ACTUAL : " + actual + " 	" + "EXPECTED :" + expected);
			return true;
			
		}
		catch (AssertionError assertionError) {
			return false;
		}
	}

}
