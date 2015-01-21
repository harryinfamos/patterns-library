package com.tek.test.patterns;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tek.test.cssdataLoader.CssDataBuilder;
import com.tek.test.cssdataLoader.CssFloatingTabData;
import com.tek.test.util.AutomationCommonUtil;
import com.tek.test.util.ReadPropertiesFileUtil;

public class FloatingTabVerify {
	
	private Properties prop = null;
	  private WebDriver driver;
	  private CssFloatingTabData cssFloatingTab;
	  //private By byWebButton = By.cssSelector("div.att-radio att-radio--on att-color-selector__item");
	  private By byFloatingTab = By.xpath(".//*[@id='navigation-floating-tabs']/div/div[3]/div[1]/ul/li[3]/a");
	  public CssFloatingTabData cssFloatingTabFromPatterns;
	  private AutomationCommonUtil commUtil;
	  
	  public FloatingTabVerify(WebDriver driver) {
		  
		this.driver = driver;
	    try {
	    	//Read Button Properties
	    	ReadPropertiesFileUtil propRead = new ReadPropertiesFileUtil();
			prop = propRead.readPropertiesFile("Resources/config.properties");
			commUtil=new AutomationCommonUtil(driver);
			
			//Read Test Data for the Button 
			String floatingTabName = prop.getProperty("TabName");
			String floatingTabBackgroundColor = prop.getProperty("TabBackgroundColor");
		    String floatingTabRadius = prop.getProperty("TabBorderLeftRadius");
		    String floatingTabCursor = prop.getProperty("TabCursor");
		    String floatingTabFontFamily = prop.getProperty("TabFontFamily");
		    String floatingTabTextAlign = prop.getProperty("TabTextAlign");
		    
		    //Read CSS Data for Button
		    cssFloatingTab = new CssDataBuilder().withObjectName(floatingTabName).withFloatingTabBackgroundColor(floatingTabBackgroundColor).withFloatingTabRadius(floatingTabRadius).
		    		withFloatingTabCursor(floatingTabCursor).withFloatingTabFontFamily(floatingTabFontFamily).withFloatingTabTextAlign(floatingTabTextAlign).floatingTabBuild();
		    		
		    		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }

	  public boolean verifyFloatingTab() throws Exception {
		//Verify the properties with the actuals from configuration file 
		//driver.findElement(By.cssSelector("span.nav__title")).click();
	    boolean bolFloatingTabVerify =commUtil.verifyCssObjectProperties(byFloatingTab, cssFloatingTab);  
	    
	    
	    WebElement myDynamicButton = (new WebDriverWait(driver, 10))
	            .until(ExpectedConditions.presenceOfElementLocated(byFloatingTab));
	    
	    cssFloatingTabFromPatterns = new  CssDataBuilder().withObjectName("FloatingTabAttCSS").withFloatingTabBackgroundColor(myDynamicButton.getCssValue("background-color")).withFloatingTabRadius(myDynamicButton.getCssValue("border-top-right-radius")).
	    		withFloatingTabCursor(myDynamicButton.getCssValue("cursor")).withFloatingTabFontFamily(myDynamicButton.getCssValue("font-family")).withFloatingTabTextAlign(myDynamicButton.getCssValue("text-align")).floatingTabBuild();
	    
	    this.setCssColorSelectorFromPatterns(cssFloatingTabFromPatterns);
	        
	    return bolFloatingTabVerify; 
	  }
	  
	  	  
	  public boolean verifyFloatingTabPatternsOnAtt(WebElement FloatingTab){

		  //Verify ColorSelector Properties
		  boolean bolVerify = commUtil.verifyCssObjectProperties(FloatingTab,cssFloatingTabFromPatterns);
		  return bolVerify;
		  
	  }
	  
	 public CssFloatingTabData getCssButtonFromPatterns() {
		return cssFloatingTabFromPatterns;
	 }

	 public void setCssColorSelectorFromPatterns(CssFloatingTabData pCssButtonFromPatterns) {
			this.cssFloatingTabFromPatterns = pCssButtonFromPatterns;
	 }

}
