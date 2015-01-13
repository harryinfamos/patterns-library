package com.tek.test.patterns;

import java.io.File;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.tek.test.util.HtmlLogUtil;
import com.tek.test.util.ReadPropertiesFileUtil;
import com.tek.test.util.SeleniumDriverUtil;


public class VerifyComponents {
	
	  private WebDriver driver;
	  private String baseUrl;
	  private Properties prop;
	  private HtmlLogUtil htmlLogUtil;
	  public static ButtonVerify bVerify;
	  public static ColorSelectorVerify cVerify;
	  
	  
	 @BeforeGroups(enabled = true, groups= { "CSSPatternsTest"})
	 @Parameters({ "BrowserType" })
	 public void intialSetUp(String browserType) throws Exception {
		 
	    //Read Properties
	    ReadPropertiesFileUtil propRead = new ReadPropertiesFileUtil();
	    prop = propRead.readPropertiesFile("Resources/config.properties");     
	   
	    //Read URL and Browser type from configuration
	    baseUrl = prop.getProperty("BaseUrl");
		 
	    //select BrowserType
	    driver = new SeleniumDriverUtil().loadSeleniumDriver(browserType); 
	 
	    //Create Custom HTML Log
	    htmlLogUtil = new HtmlLogUtil(driver);
	    htmlLogUtil.createSummaryHtmlLogFile(4);
	    
	    //Trigger AutoIt
	   // new SeleniumDriverUtil().triggerAutoit(browserType);   	    
	   
	    //Launch URL and Maximize
	    driver.get(baseUrl);
	    driver.manage().window().maximize();    
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 }
	 
	 @Test(priority = 1, enabled = true, groups= { "CSSPatternsTest"})
	 public void testVerifyButton() throws Exception{
		 
		 //Verify CSS Properties - Button
		 String logPath = htmlLogUtil.createHtmlLogFile("Button-Patterns-VerifyTest");
		 bVerify = new ButtonVerify(driver);	
		 bVerify.verifyEnabledButton();
		 bVerify.verifyDiabledButton();
		 bVerify.verifyDirectionalButton();
		 bVerify.verifyLoadingButton();
		 htmlLogUtil.closeHtmlLogFile();
		 htmlLogUtil.writeToSummaryLog("ButtonTest001","Verify Button CSS Properties",logPath);
	 }
	 
	 @Test(priority = 2, enabled = true, groups= { "CSSPatternsTest"})
	 public void testVerifyDropDown() throws Exception{
		 
		 //Verify CSS Properties - DropDown
		 String logPath = htmlLogUtil.createHtmlLogFile("DropDown-Patterns-VerifyTest");
		 DropDownVerify dVerify = new DropDownVerify(driver);
		 dVerify.verifyEnabledDropDown();
		 htmlLogUtil.closeHtmlLogFile();
		 htmlLogUtil.writeToSummaryLog("DropDownTest001","Verify Drop-Down CSS Properties",logPath);
	 }
	 
	 @Test(priority = 3, enabled = true, groups= { "CSSPatternsTest"})
	 public void testVerifyColorSelector() throws Exception{
		 
		 //Verify CSS Properties - ColorSelector
		 String logPath = htmlLogUtil.createHtmlLogFile("ColorSelector-Patterns-VerifyTest");
		 cVerify = new ColorSelectorVerify(driver);
		 cVerify.verifyColorSelector();
		 htmlLogUtil.closeHtmlLogFile();
		 htmlLogUtil.writeToSummaryLog("ColorSelector001","Verify ColorSelector CSS Properties",logPath);
	 }
	 
	 @Test(priority = 4, enabled = true, groups= { "CSSPatternsTest"})
	 public void testVerifyAccordion() throws Exception{
		 
		//Verify CSS Properties - Accordion
		 String logPath = htmlLogUtil.createHtmlLogFile("Accordion-Patterns-VerifyTest");
		 AccordionVerify aVerify = new AccordionVerify(driver);
		 assert aVerify.verifyAccordion();	
		 htmlLogUtil.closeHtmlLogFile();
		 htmlLogUtil.writeToSummaryLog("Accordion001","Verify Accordion CSS Properties",logPath);
	 }

	 @AfterGroups(groups= { "CSSPatternsTest"})
	 public void closureMethod() throws Exception {
		 driver.close();
		 htmlLogUtil.closeSummaryHtmlLogFile();
	  }
}
