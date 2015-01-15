package com.tek.test.patterns;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tek.test.cssdataLoader.CssAccordionData;
import com.tek.test.cssdataLoader.CssDataBuilder;
import com.tek.test.util.AutomationCommonUtil;
import com.tek.test.util.ReadPropertiesFileUtil;

public class AccordionVerify {
	
	private Properties prop = null;
	  private WebDriver driver;
	  private CssAccordionData cssAccordian;
	  private By byWebButton = By.cssSelector("div.att-accordion__group");
	  public CssAccordionData cssAccordionFromPatterns;
	  private AutomationCommonUtil commUtil;
	  
	  public AccordionVerify(WebDriver driver) {
		  
		this.driver = driver;
	    
	    try {	
	    	//Read Button Properties
			ReadPropertiesFileUtil propRead = new ReadPropertiesFileUtil();
			prop = propRead.readPropertiesFile("Resources/config.properties");
			commUtil=new AutomationCommonUtil(driver);
			
			//Read Test Data for the Button 
			String accordianName = prop.getProperty("AccordianName");
		    String accordianFontFamily = prop.getProperty("AccordionFontFamily");
		    String accordianFontSize = prop.getProperty("AccordionFontSize");
		    String accordianBorderStyle = prop.getProperty("AccordionBorderStyle");
		    String accordianPadding = prop.getProperty("AccordionPadding");
		    
		    //Read CSS Data for Button
		    cssAccordian= new CssDataBuilder().withObjectName(accordianName).withAccordianFontFamily(accordianFontFamily).withAccordianFontSize(accordianFontSize).
		    		withAccordianBorderStyle(accordianBorderStyle).withAccordianPadding(accordianPadding).accordianBuild();
		    		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    /*finally{
	    	propRead = null;
	    }*/
	  }

	  public boolean verifyAccordion() throws Exception {
		//Verify the properties with the actuals from configuration file 
		//driver.findElement(By.cssSelector("span.nav__title")).click();
	    boolean bolAccordionVerify = commUtil.verifyCssObjectProperties(byWebButton, cssAccordian);  
	    
	    WebElement myDynamicButton = (new WebDriverWait(driver, 10))
	            .until(ExpectedConditions.presenceOfElementLocated(byWebButton));
	    
	    cssAccordionFromPatterns= new CssDataBuilder().withObjectName("AccordionAttCSS").withAccordianFontFamily(myDynamicButton.getCssValue("font-family")).withAccordianFontSize(myDynamicButton.getCssValue("font-size")).
	    		withAccordianBorderStyle(myDynamicButton.getCssValue("border-top-style")).withAccordianPadding(myDynamicButton.getCssValue("padding-right")).accordianBuild();
	    
	    this.setCssAccordionFromPatterns(cssAccordionFromPatterns);
	    	
	    return bolAccordionVerify;
	  }
	  
	  public boolean verifyAccordionPatternsOnAtt(WebElement accordion){

		  //Verify ColorSelector Properties
		  boolean bolVerify = commUtil.verifyCssObjectProperties(accordion,cssAccordionFromPatterns);
		  return bolVerify;
		  
	  }
	  
	 public CssAccordionData getCssAccordionFromPatterns() {
		return cssAccordionFromPatterns;
	 }

	 public void setCssAccordionFromPatterns(CssAccordionData pCssButtonFromPatterns) {
			this.cssAccordionFromPatterns = pCssButtonFromPatterns;
	 }
	  
	  //release Memory

	  /*protected void finalize(){
		   prop = null;
		   cssAccordian	= null;	   
	  }*/

}
