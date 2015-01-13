package com.tek.test.patterns;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.tek.test.cssdataLoader.CssAccordionData;
import com.tek.test.cssdataLoader.CssDataBuilder;
import com.tek.test.util.AutomationCommonUtil;
import com.tek.test.util.ReadPropertiesFileUtil;

public class AccordionVerify {
	
	private Properties prop = null;
	  private WebDriver driver;
	  private CssAccordionData cssAccordian;
	  private By byWebButton = By.cssSelector("div.att-accordion__group");
	  
	  public AccordionVerify(WebDriver driver) {
		  
		this.driver = driver;
		ReadPropertiesFileUtil propRead = new ReadPropertiesFileUtil();
	    
	    try {	
	    	//Read Button Properties
			prop = propRead.readPropertiesFile("Resources/config.properties");
			
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
	    finally{
	    	propRead = null;
	    }
	  }

	  public boolean verifyAccordion() throws Exception {
		//Verify the properties with the actuals from configuration file 
		//driver.findElement(By.cssSelector("span.nav__title")).click();
	    boolean bolAccordionVerify = new AutomationCommonUtil(driver).verifyCssObjectProperties(byWebButton, cssAccordian);  
	    	
	    return bolAccordionVerify;
	  }
	  
	  //release Memory

	  protected void finalize(){
		   prop = null;
		   cssAccordian	= null;	   
	  }

}
