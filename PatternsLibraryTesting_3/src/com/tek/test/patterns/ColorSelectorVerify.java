package com.tek.test.patterns;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tek.test.cssdataLoader.CssButtonData;
import com.tek.test.cssdataLoader.CssColorSelectorData;
import com.tek.test.cssdataLoader.CssDataBuilder;
import com.tek.test.util.AutomationCommonUtil;
import com.tek.test.util.HtmlLogUtil;
import com.tek.test.util.ReadPropertiesFileUtil;

public class ColorSelectorVerify {
	
	private Properties prop = null;
	  private WebDriver driver;
	  private CssColorSelectorData cssColorSelector;
	  //private By byWebButton = By.cssSelector("div.att-radio att-radio--on att-color-selector__item");
	  private By byColorSelector = By.xpath("//section[@id='selectors-color-selector']//div[@class='att-radio att-color-selector__item'][1]");
	  public CssColorSelectorData cssColorSelectorFromPatterns;
	  private AutomationCommonUtil commUtil;
	  
	  public ColorSelectorVerify(WebDriver driver) {
		  
		this.driver = driver;
	    try {
	    	//Read Button Properties
	    	ReadPropertiesFileUtil propRead = new ReadPropertiesFileUtil();
			prop = propRead.readPropertiesFile("Resources/config.properties");
			commUtil=new AutomationCommonUtil(driver);
			
			//Read Test Data for the Button 
			String colorSelectorName = prop.getProperty("ColorSelectorName");
		    String colorSelectorWidth = prop.getProperty("ColorSelectorWidth");
		    String colorSelectorHeight = prop.getProperty("ColorSelectorHeight");
		    String colorSelectorBorderRadius = prop.getProperty("ColorSelectorBorderRadius");
		    String colorSelectorCursor = prop.getProperty("ColorSelectorCursor");
		    
		    //Read CSS Data for Button
		    cssColorSelector = new CssDataBuilder().withObjectName(colorSelectorName).withColorSelectorWidth(colorSelectorWidth)
		    		.withColorSelectorHeight(colorSelectorHeight).withColorSelectorBorderRadius(colorSelectorBorderRadius).
		    		withColorSelectorCursor(colorSelectorCursor).colorSelectorBuild();
		    		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }

	  public boolean verifyColorSelector() throws Exception {
		//Verify the properties with the actuals from configuration file 
		//driver.findElement(By.cssSelector("span.nav__title")).click();
	    boolean bolColorSelectorVerify =commUtil.verifyCssObjectProperties(byColorSelector, cssColorSelector);  
	    WebElement selector= driver.findElement(By.xpath("//section[@id='selectors-color-selector']//div[@class='att-radio att-color-selector__item'][1]"));
	    selector.click();
	    
	    if(selector.getAttribute("class").contains("att-radio--on")) {
	    	System.out.println("Class changed after click");
	    	HtmlLogUtil.writeToLog(0,"Class changed to radio-on",false);
	    } else {
	    	HtmlLogUtil.writeToLog(1,"Class changed to radio-on",false);
	    }	
	    
	    WebElement myDynamicButton = (new WebDriverWait(driver, 10))
	            .until(ExpectedConditions.presenceOfElementLocated(byColorSelector));
	    
	    cssColorSelectorFromPatterns = new  CssDataBuilder().withObjectName("ColorSelectorAttCSS").withColorSelectorWidth(myDynamicButton.getCssValue("width"))
	    		.withColorSelectorHeight(myDynamicButton.getCssValue("height")).withColorSelectorBorderRadius(myDynamicButton.getCssValue("border-top-right-radius")).
	    		withColorSelectorCursor(myDynamicButton.getCssValue("cursor")).colorSelectorBuild(); 
	    this.setCssColorSelectorFromPatterns(cssColorSelectorFromPatterns);
	        
	    return bolColorSelectorVerify; 
	  }
	  
	  public boolean verifyColorSelectorOnSite() throws Exception {
			//Verify the properties with the actuals from configuration file 
			//driver.findElement(By.cssSelector("span.nav__title")).click();
		  	WebElement quickView=driver.findElement(By.xpath("//a[@id='quick_view_prod11960193']"));
			 quickView.click();
			 byColorSelector=By.xpath("//div[@class='att-radio att-color-selector__item'][1]");
		    boolean bolColorSelectorVerify = new AutomationCommonUtil(driver).verifyCssObjectProperties(byColorSelector, cssColorSelector);  
		    /*WebElement selector= (WebElement) byWebButton;
		    selector.click();
		    
		    if(selector.getAttribute("class").contains("att-radio--on")) {
		    	System.out.println("Class changed after click");
		    	HtmlLogUtil.writeToLog(0,"Class changed to radio-on",false);
		    } else {
		    	HtmlLogUtil.writeToLog(1,"Class changed to radio-on",false);
		    }	*/
		    return bolColorSelectorVerify; 
		  }
	  
	  public boolean verifyColorSelectorPatternsOnAtt(WebElement ColorSelector){

		  //Verify ColorSelector Properties
		  boolean bolVerify = commUtil.verifyCssObjectProperties(ColorSelector,cssColorSelectorFromPatterns);
		  return bolVerify;
		  
	  }
	  
	 public CssColorSelectorData getCssButtonFromPatterns() {
		return cssColorSelectorFromPatterns;
	 }

	 public void setCssColorSelectorFromPatterns(CssColorSelectorData pCssButtonFromPatterns) {
			this.cssColorSelectorFromPatterns = pCssButtonFromPatterns;
	 }
}
