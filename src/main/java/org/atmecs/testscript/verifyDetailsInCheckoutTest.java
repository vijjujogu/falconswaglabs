package org.atmecs.testscript;

import java.util.Properties;

import org.atmecs.constant.ExcelReader;
import org.atmecs.constant.FilePathConstants;
import org.atmecs.constant.Helper;
import org.atmecs.constant.Pageactions;
import org.atmecs.testsuite.TestSuiteBase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;

public class verifyDetailsInCheckoutTest extends TestSuiteBase{
	
	Helper helper=new Helper();
	Properties prop = ExcelReader.readProperties(FilePathConstants.SWAGLABSDEMO);
	Pageactions page= new Pageactions(browser);
	private ReportLogService report = new ReportLogServiceImpl(VerifyLoginTest.class);
	@DataProvider
	public Object[][] getLoginData()
	{
		Object data[][]=ExcelReader.getTestData("checkoutdata");
		return data;
	}
	@Test(dataProvider="getLoginData")
	public void loginTest(String username,String password,String paymentInfo,String shippingInfo,String orderDetails) throws InterruptedException
	{
		
		browser.getDriver();
		page.sendKeys(prop.getProperty("locator.username"),username);
		report.info("username");
		page.sendKeys(prop.getProperty("locator.pwd"),username);
		report.info("password");
		
		page.elementClick(prop.getProperty("locator.loginbutton"));
		report.info("clicked");
		Thread.sleep(5000);
		
		//page.elementClick(prop.getProperty("locator.productlink"));
		/**page.clickOnElement("locator.productlink");
		report.info("clicked on product");
		String productName=page.getText(prop.getProperty("locator.productName"));
		report.info(productName);
		String productPrice=page.getText(prop.getProperty("locator.productprice"));
		report.info(productPrice);
		page.elementClick(prop.getProperty("locator.addtoCart"));
		report.info("clicked on add to cart");
		page.elementClick(prop.getProperty("locator.cart"));
		report.info("click on cart");
		page.elementClick(prop.getProperty("locator.checkBtn"));
		report.info("clciked on checkout button");
		page.sendKeys(prop.getProperty("locator.firstname"), "firstName");
		page.sendKeys(prop.getProperty("locator.lastname"),"lastname");
		page.sendKeys(prop.getProperty("locator.pincode"),"pincode");
		page.elementClick(prop.getProperty("locator.continue"));
		
		String productnameInCheckout=page.getText(prop.getProperty("locator.productnameInCheckout"));
		page.verifyPositiveResult(productName, productnameInCheckout, "productname verified");
		String paymentInformation=page.getText(prop.getProperty("locator.paymentInfo"));
		page.verifyPositiveResult(paymentInfo, paymentInformation,"verified paymentinfo");
		String shippingInformation=page.getText(prop.getProperty("locator.shippingInfo"));
		page.verifyPositiveResult(shippingInfo,shippingInformation,"verified shippinginfo");
		String itemTotal=page.getText(prop.getProperty("locator.itemtotal"));
		page.verifyNumberResults(itemTotal, productPrice, "price is verified");
		page.elementClick(prop.getProperty("locator.finish"));
		String orderconformation=page.getText(prop.getProperty("locator.orderconformation"));
		page.verifyPositiveResult(orderDetails, orderconformation,"order conformation verified");**/
		
	}
	
}
