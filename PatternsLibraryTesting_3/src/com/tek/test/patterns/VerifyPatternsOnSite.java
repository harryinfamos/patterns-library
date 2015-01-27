package com.tek.test.patterns;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
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
	 
	 @Test(priority = 2, enabled = true, groups= { "ATTPatternsTest"})
	 public void testVerifyAccordian() throws Exception{
		 Thread.sleep(10000);
		 String logPath = htmlLogUtil.createHtmlLogFile("Accordian-Patterns-Veterans-VerifyTest");
		 AccordionVerify aVerify = VerifyComponents.aVerify;
		 driver.get("http://www.att.com/smallbusiness/content/shop/wireless/mobile-plans.page");
//		 WebElement  element =driver.findElement(By.xpath("//div[@class='att-accordion att-accordion--no-box'][1]//div[@class='att-accordion__group'][1]"));
		 WebElement  element =driver.findElement(By.xpath(".//*[@id='1411672555838']/div/div/div/div[1]/div[1]/div[1]/a"));
		 aVerify.verifyAccordionPatternsOnAtt(element);	
		 htmlLogUtil.closeHtmlLogFile();
		 htmlLogUtil.writeToSummaryLog("AccordionTest001","Verify Accordion CSS Properties",logPath);
	 }
	 
	 @Test(priority = 3, enabled =true , groups= { "ATTPatternsTest"})
	 public void testVerifyColorSelector() throws Exception{
		 
		 Thread.sleep(10000);
	     // driver.get("http://zltv1019.vci.att.com:8791/smallbusiness/content/shop/internet-phone-tv/business-phone.page");
		 String logPath = htmlLogUtil.createHtmlLogFile("ColorSelector-Patterns-At&t-VerifyTest"); 
		 ColorSelectorVerify cVerify = VerifyComponents.cVerify;
		 driver.get("http://www.att.com/smallbusiness/shop/wireless/all-devices/smartphones");
		  WebElement quickView=driver.findElement(By.xpath("//a[@id='quick_view_prod12390101']"));
		  quickView.click();
		  Thread.sleep(2000);
		  WebElement element=driver.findElement(By.xpath("//div[@class='att-radio att-color-selector__item'][1]"));
		 cVerify.verifyColorSelectorPatternsOnAtt(element);
		 htmlLogUtil.closeHtmlLogFile();
		 htmlLogUtil.writeToSummaryLog("ColorSelectorTest001","Verify ColorSelector CSS Properties",logPath);
	 }
	 
	 @Test(priority = 4, enabled =true , groups= { "ATTPatternsTest"})
	 public void testVerifyCarousel() throws Exception{
		 
		 Thread.sleep(10000);
	     // driver.get("http://zltv1019.vci.att.com:8791/smallbusiness/content/shop/internet-phone-tv/business-phone.page");
		 String logPath = htmlLogUtil.createHtmlLogFile("ColorSelector-Patterns-At&t-VerifyTest"); 
		 CarouselVerify caVerify = VerifyComponents.caVerify;
		 driver.get("http://www.att.com/smallbusiness/content/shop.page");
		  WebElement element=driver.findElement(By.xpath("//div[@class='bx-pager bx-default-pager']"));
		 caVerify.verifyCarouselPatternsOnAtt(element);
		 htmlLogUtil.closeHtmlLogFile();
		 htmlLogUtil.writeToSummaryLog("CarouselTest001","Verify Carousel CSS Properties",logPath);
	 }
	 
	 @Test(priority = 5, enabled =true , groups= { "ATTPatternsTest"})
	 public void testVerifyDropDown() throws Exception{
		 
		 Thread.sleep(10000);
	     // driver.get("http://zltv1019.vci.att.com:8791/smallbusiness/content/shop/internet-phone-tv/business-phone.page");
		 String logPath = htmlLogUtil.createHtmlLogFile("DropDown-Patterns-At&t-VerifyTest"); 
		 DropDownVerify dVerify = VerifyComponents.dVerify;
		 driver.get("http://www.att.com/smallbusiness/content/shop.page");
		  WebElement element=driver.findElement(By.xpath(".//*[@id='select2-chosen-2']"));
		  System.out.println(element.getText());
		 dVerify.verifyDropDownPatternsOnAtt(element);
		 htmlLogUtil.closeHtmlLogFile();
		 htmlLogUtil.writeToSummaryLog("DropDownTest001","Verify Drop Down CSS Properties",logPath);
	 }
	 
	 @Test(priority = 6, enabled =true , groups= { "ATTPatternsTest"})
	 public void testVerifyFloatingTab() throws Exception{
		 
		 Thread.sleep(10000);
	     // driver.get("http://zltv1019.vci.att.com:8791/smallbusiness/content/shop/internet-phone-tv/business-phone.page");
		 String logPath = htmlLogUtil.createHtmlLogFile("DropDown-Patterns-At&t-VerifyTest"); 
		 FloatingTabVerify fVerify = VerifyComponents.fVerify;
		 driver.get("http://www.att.com/smallbusiness/shop/wireless/all-devices");
		  WebElement element=driver.findElement(By.xpath("//a[@class='tabs__item-link' and contains(text(),'Smartphones')]"));
		  System.out.println(element.getText());
		 fVerify.verifyFloatingTabPatternsOnAtt(element);
		 htmlLogUtil.closeHtmlLogFile();
		 htmlLogUtil.writeToSummaryLog("DropDownTest001","Verify Drop Down CSS Properties",logPath);
	 }
	 
	 @AfterGroups(groups= { "ATTPatternsTest"})
	 public void closureMethod() throws Exception {
		 driver.close();
		 htmlLogUtil.closeSummaryHtmlLogFile();
	  }
}
