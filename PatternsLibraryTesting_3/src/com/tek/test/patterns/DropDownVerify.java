package com.tek.test.patterns;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tek.test.cssdataLoader.CssDataBuilder;
import com.tek.test.cssdataLoader.CssDropDownData;
import com.tek.test.util.AutomationCommonUtil;
import com.tek.test.util.ReadPropertiesFileUtil;

public class DropDownVerify {

  private Properties prop = null;
  private WebDriver driver;
  private CssDropDownData cssDropDown;
  public CssDropDownData cssDropDownFromPatterns;
  private AutomationCommonUtil commUtil;
  
  //Button identifiers on Pattern page
  private final By byDropDownEnabled = By.cssSelector("span.select2-chosen.needsclick");
   
  public DropDownVerify(WebDriver driver) {
	  
	this.driver = driver;   
    
    try {	
    	//Read Button Properties
    	ReadPropertiesFileUtil propRead = new ReadPropertiesFileUtil();
		prop = propRead.readPropertiesFile("Resources/config.properties");
		commUtil = new AutomationCommonUtil(driver);
		
		//Read Test Data for the Button 
		String dropDownObjName = prop.getProperty("DropDownName");
	    String dropDownFontSize = prop.getProperty("DropDownFontSize");
	    String dropDownFontFamily = prop.getProperty("DropDownFontFamily");
	    String dropDownHeight = prop.getProperty("DropDownHeight");
	    String dropDownColor = prop.getProperty("DropDownColor");
	    String dropDownHoverColor = prop.getProperty("DropDownHoverColor");
	    String dropDownLeftPadding = prop.getProperty("DropDownLeftPadding");
	    String dropDownRightPadding = prop.getProperty("ButtonRightPadding");

	    //Read CSS Data for Button
	    cssDropDown = new CssDataBuilder().withObjectName(dropDownObjName).withFontFamily(dropDownFontFamily)
	    		.withFontSize(dropDownFontSize).withHeight(dropDownHeight).withColor(dropDownColor)
	    		.withHoverColor(dropDownHoverColor).withLeftPadding(dropDownLeftPadding)
	    		.withRightPadding(dropDownRightPadding).buildDropDown();
	    		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }

  public boolean verifyEnabledDropDown() throws Exception {
	  
	//Verify the properties with the actuals from configuration file 
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("http://patterns.tekzenit.com/uielements.html#input-fields-dropdowns");
	//Verify Button Properties
    boolean bolDropDownVerify = commUtil.verifyCssObjectProperties(byDropDownEnabled, cssDropDown);
    
    WebElement myDynamicButton = (new WebDriverWait(driver, 10))
            .until(ExpectedConditions.presenceOfElementLocated(byDropDownEnabled));
    
    cssDropDownFromPatterns = new CssDataBuilder().withObjectName("DropDownAttCSS").withFontFamily(myDynamicButton.getCssValue("font-family"))
    		.withFontSize(myDynamicButton.getCssValue("font-size")).withHeight(myDynamicButton.getCssValue("height")).withColor(myDynamicButton.getCssValue("color"))
    		.withHoverColor(myDynamicButton.getCssValue("outline-color")).withLeftPadding(myDynamicButton.getCssValue("padding-left"))
    		.withRightPadding(myDynamicButton.getCssValue("padding-right")).buildDropDown();
    		
    this.setCssDropDownFromPatterns(cssDropDownFromPatterns);
    
    return bolDropDownVerify;
  }
  
//Verify Patterns on Att
  public boolean verifyDropDownPatternsOnAtt(WebElement byAttDropDown){

	  //Verify Button Properties
	  
	  boolean bolButtonVerify = commUtil.verifyCssObjectProperties(byAttDropDown,cssDropDownFromPatterns);
	  return bolButtonVerify;
	  
  }
  
  
  public CssDropDownData getCssDropDownFromPatterns() {
		return cssDropDownFromPatterns;
	 }

	 public void setCssDropDownFromPatterns(CssDropDownData pCssButtonFromPatterns) {
			this.cssDropDownFromPatterns = pCssButtonFromPatterns;
	 }


   /*protected void finalize(){
	   prop = null;
	   cssDropDown = null;
	   commUtil = null;
  }*/
  
}