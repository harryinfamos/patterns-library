package com.tek.test.patterns;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tek.test.cssdataLoader.CssButtonData;
import com.tek.test.cssdataLoader.CssDataBuilder;
import com.tek.test.util.AutomationCommonUtil;
import com.tek.test.util.HtmlLogUtil;
import com.tek.test.util.ReadPropertiesFileUtil;

public class ButtonVerify {

  private Properties prop = null;
  private WebDriver driver;
  private CssButtonData cssButton;
  public CssButtonData cssButtonFromPatterns;


private AutomationCommonUtil commUtil;
  
  //Button identifiers on Pattern page
  private final By byWebButtonEnabled = By.cssSelector("button.button.button--primary");
  private final By byWebButtonDisabled = By.cssSelector("button.button--primary.button--disabled");
  private final By byWebButtonDirectional = By.cssSelector("button.button--primary.button--directional");
  private final By byWebButtonLoading = By.cssSelector("button.button--primary.button--disabled.button--loading");
  //private final By byAttContactWebButton = By.id("cards-carousel__check-availability-business");
  //private By byAttContactWebButton =By.xpath("//div[@class='spotlights']//div[1]//a[@class='button button--primary button--small'][1]");
  //private  WebElement byAttContactWebButton;
  
  public ButtonVerify(WebDriver driver) {
	  
	this.driver = driver;
    try {	
    	//Read Button Properties
    	ReadPropertiesFileUtil propRead = new ReadPropertiesFileUtil();
		prop = propRead.readPropertiesFile("Resources/config.properties");
		commUtil = new AutomationCommonUtil(driver);
		
		//Read Test Data for the Button 
		String buttonObjName = prop.getProperty("ButtonName");
	    String buttonFontSize = prop.getProperty("ButtonFontSize");
	    String buttonFontFamily = prop.getProperty("ButtonFontFamily");
	    String buttonHeight = prop.getProperty("ButtonHeight");
	    String buttonColor = prop.getProperty("ButtonColor");
	    String buttonHoverColor = prop.getProperty("ButtonHoverColor");
	    String buttonLeftPadding = prop.getProperty("ButtonLeftPadding");
	    String buttonRightPadding = prop.getProperty("ButtonRightPadding");
	    
	    //Read CSS Data for Button
	    cssButton = new CssDataBuilder().withObjectName(buttonObjName).withFontFamily(buttonFontFamily)
	    		.withFontSize(buttonFontSize).withHeight(buttonHeight).withColor(buttonColor)
	    		.withHoverColor(buttonHoverColor).withLeftPadding(buttonLeftPadding)
	    		.withRightPadding(buttonRightPadding).buildButton();
	    		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }

  public boolean verifyEnabledButton() throws Exception {
	  
	//Verify the properties with the actuals from configuration file 
	driver.findElement(By.cssSelector("span.nav__title")).click();
	
	//Verify Button Properties
    boolean bolButtonVerify = commUtil.verifyCssObjectProperties(byWebButtonEnabled, cssButton);
    
    //Verify Button Hover Color
	//bolButtonVerify &= commUtil.verifyButtonHover(byWebButtonEnabled, cssButton);
	
    WebElement myDynamicButton = (new WebDriverWait(driver, 10))
            .until(ExpectedConditions.presenceOfElementLocated(byWebButtonEnabled));
    
    cssButtonFromPatterns = new CssDataBuilder().withObjectName("ButtonAttCSS").withFontFamily(myDynamicButton.getCssValue("font-family"))
    		.withFontSize(myDynamicButton.getCssValue("font-size")).withLineHeight(myDynamicButton.getCssValue("line-height")).withHeight(myDynamicButton.getCssValue("height")).withColor(myDynamicButton.getCssValue("background-color"))
    		.withLeftPadding(myDynamicButton.getCssValue("padding-left")).withRightPadding(myDynamicButton.getCssValue("padding-right")).buildButton();
    this.setCssButtonFromPatterns(cssButtonFromPatterns);
    return bolButtonVerify;
  }

  
  
  //Verify Disabled Button
  public void verifyDiabledButton() throws Exception {
    
	//Click on the Radio Button Disable
    driver.findElement(By.xpath("(//input[@name='primary-action-select'])[2]")).click();
    driver.findElement(By.xpath("//section[@id='buttons-section']/div/div[2]/div[3]/form/div[2]/label/span")).click();
   
    //Verify the Class Change
    if(driver.findElement(byWebButtonDisabled).getAttribute("Style").contains("inline-block")){
    	System.out.println("Pattern Verify - Button Diabled");
    	HtmlLogUtil.writeToLog(0,"Pattern Verify - Button Diabled",false);
    } else {
    	System.out.println("Pattern Verify - Button Enabled");
    	HtmlLogUtil.writeToLog(1,"Pattern Verify - Button Enabled",false);
    }   
  }
  
  //Verify Directional Button
  public void verifyDirectionalButton() throws Exception{  
	  
    //Click on the directional Radio Button
    driver.findElement(By.xpath("(//input[@name='primary-action-select'])[3]")).click();
    driver.findElement(By.xpath("//section[@id='buttons-section']/div/div[2]/div[3]/form/div[3]/label/span")).click();

    //Verify the Directional Button
    if(driver.findElement(byWebButtonDirectional).getAttribute("Style").contains("inline-block")){
    	System.out.println("Pattern Verify - Button Directional Enabled");
    	HtmlLogUtil.writeToLog(0,"Pattern Verify - Button Diabled",false);
    } else {
    	System.out.println("Pattern Verify - Button Directional disabled");
    	HtmlLogUtil.writeToLog(1,"Pattern Verify - Button Enabled",false);
    }  
	 
  }

  //Verify Button Loading   
  public void verifyLoadingButton() throws Exception{  
	 
	//Click on the Loading radio Button
	driver.findElement(By.xpath("(//input[@name='primary-action-select'])[4]")).click();
	driver.findElement(By.xpath("//section[@id='buttons-section']/div/div[2]/div[3]/form/div[4]/label/span")).click();  

	//Check the Loading Gif
	if(driver.findElement(byWebButtonLoading).getAttribute("Style").contains("inline-block")){
		System.out.println("Pattern Verify - Button Directional Enabled");
		HtmlLogUtil.writeToLog(0,"Pattern Verify - Button Diabled",false);
	} else {
		System.out.println("Pattern Verify - Button Directional disabled");
		HtmlLogUtil.writeToLog(1,"Pattern Verify - Button Enabled",false);
	}  
	 
  }
  
  //Verify Patterns on Veterans
  public boolean verifyButtonPatternsOnAtt(WebElement byAttContactWebButton){

	  //Verify Button Properties
	  
	  boolean bolButtonVerify = commUtil.verifyCssObjectProperties(byAttContactWebButton,cssButtonFromPatterns);
	  return bolButtonVerify;
	  
  }
  
 public CssButtonData getCssButtonFromPatterns() {
	return cssButtonFromPatterns;
 }

 public void setCssButtonFromPatterns(CssButtonData pCssButtonFromPatterns) {
		this.cssButtonFromPatterns = pCssButtonFromPatterns;
 }

  
  //set object to null
//  protected void finalize(){
//	   prop = null;
//	   cssButton = null;
//	   commUtil = null;
//  }
  
}