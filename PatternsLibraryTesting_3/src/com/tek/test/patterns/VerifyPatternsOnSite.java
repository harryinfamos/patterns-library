package com.tek.test.patterns;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.tek.test.util.HtmlLogUtil;
import com.tek.test.util.ReadPropertiesFileUtil;
import com.tek.test.util.SeleniumDriverUtil;

public class VerifyPatternsOnSite {
	
	  private WebDriver driver;  
	  private String baseUrl;
	  private Properties prop;
	  private HtmlLogUtil htmlLogUtil;
	  
	  @BeforeGroups(enabled = true, groups= { "ATTPatternsTest"})
	  @Parameters({ "BrowserType" })
	 public void intialSetUp(String browserType) throws Exception {
		 
	    //Read Properties
	    ReadPropertiesFileUtil propRead = new ReadPropertiesFileUtil();
	    prop = propRead.readPropertiesFile("Resources/config.properties");     
	   
	    //Read URL and Browser type from configuration
	    baseUrl = prop.getProperty("BaseAttUrl");
		 
	    //select BrowserType  
	    driver = new SeleniumDriverUtil().loadSeleniumDriver(browserType); 
	 
	    //Create Custom HTML Log
	    htmlLogUtil = new HtmlLogUtil(driver);
	    htmlLogUtil.createSummaryHtmlLogFile(2);
	    
	    //Launch URL and Maximize
	    driver.get(baseUrl);
	    driver.manage().window().maximize();    
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 }
	 
	 @Test(priority = 1, enabled = true, groups= { "ATTPatternsTest"})
	 public void testVerifyButton() throws Exception{
		 //Verify Button on Veterans site adheres to the patterns library
		  Thread.sleep(10000);
		 String logPath = htmlLogUtil.createHtmlLogFile("Button-Patterns-Veterans-VerifyTest"); 
		 ButtonVerify bVerify = VerifyComponents.bVerify;
		 WebElement  element =driver.findElement(By.xpath("//div[@class='spotlights']//div[1]//a[@class='button button--primary button--small'][1]"));
		 bVerify.verifyButtonPatternsOnAtt(element);
		 htmlLogUtil.closeHtmlLogFile();
		 htmlLogUtil.writeToSummaryLog("ButtonTest001","Verify Button CSS Properties",logPath);
	 }
	 
	 @Test(priority = 2, enabled = false, groups= { "ATTPatternsTest"})
	 public void testVerifyAccordian() throws Exception{
		 String logPath = htmlLogUtil.createHtmlLogFile("Accordian-Patterns-Veterans-VerifyTest");
		 driver.get("http://veterans.tekzenit.pt/scholarships/");
		 AccordionVerify aVerify = new AccordionVerify(driver);
		 assert aVerify.verifyAccordion();	
		 htmlLogUtil.closeHtmlLogFile();
		 htmlLogUtil.writeToSummaryLog("AccordionTest001","Verify Accordion CSS Properties",logPath);
	 }
	 
	 @Test(priority = 3, enabled = true, groups= { "ATTPatternsTest"})
	 public void testVerifyColorSelector() throws Exception{
		 
		 Thread.sleep(10000);
	     // driver.get("http://zltv1019.vci.att.com:8791/smallbusiness/content/shop/internet-phone-tv/business-phone.page");
		 String logPath = htmlLogUtil.createHtmlLogFile("ColorSelector-Patterns-Veterans-VerifyTest"); 
		 ColorSelectorVerify cVerify = VerifyComponents.cVerify;
		 driver.get("http://zltv1019.vci.att.com:8791/smallbusiness/shop/wireless/all-devices");
		  WebElement quickView=driver.findElement(By.xpath("//a[@id='quick_view_prod11960193']"));
		  quickView.click();
		  Thread.sleep(2000);
		  WebElement element=driver.findElement(By.xpath("//div[@class='att-radio att-color-selector__item'][1]"));
		 cVerify.verifyColorSelectorPatternsOnAtt(element);
		 htmlLogUtil.closeHtmlLogFile();
		 htmlLogUtil.writeToSummaryLog("ColorSelectorTest001","Verify ColorSelector CSS Properties",logPath);
	 }
	 
	 @AfterGroups(groups= { "ATTPatternsTest"})
	 public void closureMethod() throws Exception {
		 driver.close();
		 htmlLogUtil.closeSummaryHtmlLogFile();
	  }
}
