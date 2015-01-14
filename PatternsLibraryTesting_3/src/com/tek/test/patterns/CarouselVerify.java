package com.tek.test.patterns;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tek.test.cssdataLoader.CssCarouselData;
import com.tek.test.cssdataLoader.CssDataBuilder;
import com.tek.test.util.AutomationCommonUtil;
import com.tek.test.util.ReadPropertiesFileUtil;

public class CarouselVerify {
	
	private Properties prop = null;
	  private WebDriver driver;
	  private CssCarouselData cssCarousel;
	  //private By byWebButton = By.cssSelector("div.att-radio att-radio--on att-color-selector__item");
	  private By byCarousel = By.xpath(".//*[@id='carousel-section']//div[@class='bx-pager bx-default-pager']");
	  public CssCarouselData cssCarouselFromPatterns;
	  private AutomationCommonUtil commUtil;
	  
	  public CarouselVerify(WebDriver driver) {
		  
		this.driver = driver;
	    try {
	    	//Read Button Properties
	    	ReadPropertiesFileUtil propRead = new ReadPropertiesFileUtil();
			prop = propRead.readPropertiesFile("Resources/config.properties");
			commUtil=new AutomationCommonUtil(driver);
			
			//Read Test Data for the Button 
			String carouselName = prop.getProperty("CarouselName");
			String carouselBackgroundColor = prop.getProperty("CarouselBackgroundColor");
		    String carouselBorderRaduis = prop.getProperty("CarouselBorderRadius");
		    String carouselMargin = prop.getProperty("CarouselMargin");
		    String carouselPadding = prop.getProperty("CarouselPadding");
			String carouselTextAlign = prop.getProperty("CarouselTextAlign");
		    
		    //Read CSS Data for Button
		    cssCarousel = new CssDataBuilder().withObjectName(carouselName).withCarouselBackgroundColor(carouselBackgroundColor)
		    		.withCarouselBorderRaduis(carouselBorderRaduis).withCarouselMargin(carouselMargin).withCarouselPadding(carouselPadding)
		    		.withCarouselTextAlign(carouselTextAlign).carouselBuild();
		    		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }

	  public boolean verifyCarousel() throws Exception {
		//Verify the properties with the actuals from configuration file 
		//driver.findElement(By.cssSelector("span.nav__title")).click();
		driver.findElement(By.xpath("//li/a/span[text()='Navigation']")).click();
		
	    boolean bolCarouselVerify =commUtil.verifyCssObjectProperties(byCarousel, cssCarousel);  
	    
	    WebElement myDynamicButton = (new WebDriverWait(driver, 10))
	            .until(ExpectedConditions.presenceOfElementLocated(byCarousel));
	    
	    cssCarouselFromPatterns = new CssDataBuilder().withObjectName("CarouselAttCSS").withCarouselBackgroundColor(myDynamicButton.getCssValue("background-color"))
	    		.withCarouselBorderRaduis(myDynamicButton.getCssValue("border-top-left-radius")).withCarouselMargin(myDynamicButton.getCssValue("margin-left"))
	    		.withCarouselPadding(myDynamicButton.getCssValue("padding-right")).withCarouselTextAlign(myDynamicButton.getCssValue("text-align")).carouselBuild();
	    
	    this.setCarouselFromPatterns(cssCarouselFromPatterns);
	        
	    return bolCarouselVerify; 
	  }
	  
	  public boolean verifyCarouselPatternsOnAtt(WebElement Carousel){

		  //Verify ColorSelector Properties
		  boolean bolVerify = commUtil.verifyCssObjectProperties(Carousel,cssCarouselFromPatterns);
		  return bolVerify;
		  
	  }
	  
	 public CssCarouselData getCssCarouselFromPatterns() {
		return cssCarouselFromPatterns;
	 }

	 public void setCarouselFromPatterns(CssCarouselData pCssButtonFromPatterns) {
			this.cssCarouselFromPatterns = pCssButtonFromPatterns;
	 }

}
