package com.tek.test.util;

import com.tek.test.cssdataLoader.CssAccordionData;
import com.tek.test.cssdataLoader.CssButtonData;
import com.tek.test.cssdataLoader.CssCarouselData;
import com.tek.test.cssdataLoader.CssColorSelectorData;
import com.tek.test.cssdataLoader.CssDropDownData;
import com.tek.test.cssdataLoader.CssFloatingTabData;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by bs211w on 7/7/2014.
 */
public class AutomationCommonUtil {

    private WebDriver driver;
    private Actions action ;

    private final String strFailed = " : Failed -- Actual : ";
    private final String strPassed = " : Passed -- Actual : ";
    private final String strExpected = " Expected :";
    

    public AutomationCommonUtil(WebDriver driver){
        this.driver = driver;
        action = new Actions(driver);
    }

    public void launchPageURL(String url){
       try{
           driver.get(url);
       }
       catch(Exception e){
           HtmlLogUtil.writeToLog(1, "Exception occurred : - " + e.getMessage());
       }
    }

    //VerifyCSSProperties for Button
    public boolean verifyCssObjectProperties(By byWebElement, CssButtonData stringsObjectInfo){

    	WebElement myDynamicElement;
    	
            try {
            	
            	//Wait for Element to Load
                myDynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(byWebElement));
            	//myDynamicElement= byWebElement;
                System.out.println();
                System.out.println(stringsObjectInfo.getCssObjectName());

                //Verify the CSS properties of the Button
                //Font Family
                if (stringsObjectInfo.getFontFamily() != null) {
                    if (myDynamicElement.getCssValue("font-family").contentEquals(stringsObjectInfo.getFontFamily())) {
                        System.out.println("Font-Family" + strPassed + myDynamicElement.getCssValue("font-family") + strExpected + stringsObjectInfo.getFontFamily());
                        HtmlLogUtil.writeToLog(0, stringsObjectInfo.getCssObjectName() + ": Font-Family" + strPassed + myDynamicElement.getCssValue("font-family") + strExpected + stringsObjectInfo.getFontFamily(),false);
                    } else {
                        System.out.println("Font-Family" + strFailed + myDynamicElement.getCssValue("font-family") + strExpected + stringsObjectInfo.getFontFamily());
                        HtmlLogUtil.writeToLog(1, stringsObjectInfo.getCssObjectName() + ": Font-Family" + strFailed + myDynamicElement.getCssValue("font-family") + strExpected + stringsObjectInfo.getFontFamily(),true);
                    }
                }
                
                //Verify Font Size
                if (stringsObjectInfo.getFontSize() != null) {
                    if (myDynamicElement.getCssValue("font-size").contentEquals(stringsObjectInfo.getFontSize())) {
                        System.out.println("Font-Size" + strPassed + myDynamicElement.getCssValue("font-size") + strExpected + stringsObjectInfo.getFontSize());
                        HtmlLogUtil.writeToLog(0,stringsObjectInfo.getCssObjectName() + ": Font-Size" + strPassed + myDynamicElement.getCssValue("font-size") + strExpected + stringsObjectInfo.getFontSize());
                    } else {
                        System.out.println("Font-Size" + strFailed + myDynamicElement.getCssValue("font-size") + strExpected + stringsObjectInfo.getFontSize());
                        HtmlLogUtil.writeToLog(1,stringsObjectInfo.getCssObjectName() + ": Font-Size" + strFailed + myDynamicElement.getCssValue("font-size") + strExpected + stringsObjectInfo.getFontSize(),true);
                    }
                }
                
                //Verify Line Height
                if (stringsObjectInfo.getLineHeight() != null) {
                    if (myDynamicElement.getCssValue("line-height").contentEquals(stringsObjectInfo.getLineHeight())) {
                        System.out.println("Line-Height" + strPassed + myDynamicElement.getCssValue("line-height") + strExpected + stringsObjectInfo.getLineHeight());
                        HtmlLogUtil.writeToLog(0,stringsObjectInfo.getCssObjectName() + ": Line-Height" + strPassed + myDynamicElement.getCssValue("line-height") + strExpected + stringsObjectInfo.getLineHeight());
                    } else {
                        System.out.println("Line-Height" + strFailed + myDynamicElement.getCssValue("line-height") + strExpected + stringsObjectInfo.getLineHeight());
                        HtmlLogUtil.writeToLog(1,stringsObjectInfo.getCssObjectName() + ": Line-Height" + strFailed + myDynamicElement.getCssValue("line-height") + strExpected + stringsObjectInfo.getLineHeight(),true);
                    }
                }
                
                //Verify Button Width - if needed
                if (stringsObjectInfo.getWidth() != null) {
                    if (myDynamicElement.getCssValue("width").contentEquals(stringsObjectInfo.getWidth())) {
                        HtmlLogUtil.writeToLog(0,stringsObjectInfo.getCssObjectName() + ": Width" + strPassed + myDynamicElement.getCssValue("width") + strExpected + stringsObjectInfo.getWidth());
                        System.out.println("Width" + strPassed + myDynamicElement.getCssValue("width") + strExpected + stringsObjectInfo.getWidth());
                    } else {
                        HtmlLogUtil.writeToLog(1,stringsObjectInfo.getCssObjectName() + ": Width" + strFailed + myDynamicElement.getCssValue("width") + strExpected + stringsObjectInfo.getWidth(),true);
                        System.out.println("Width" + strFailed + myDynamicElement.getCssValue("width") + strExpected + stringsObjectInfo.getWidth());
                    }
                }
                
                //Verify Button Height
                if (stringsObjectInfo.getHeight() != null) {
                    if (myDynamicElement.getCssValue("height").contentEquals(stringsObjectInfo.getHeight())) {
                        HtmlLogUtil.writeToLog(0,stringsObjectInfo.getCssObjectName() + ": Height" + strPassed + myDynamicElement.getCssValue("height") + strExpected + stringsObjectInfo.getHeight());
                        System.out.println("Height" + strPassed + myDynamicElement.getCssValue("height") + strExpected + stringsObjectInfo.getHeight());
                    } else {
                        HtmlLogUtil.writeToLog(1,stringsObjectInfo.getCssObjectName() + ": Height" + strFailed + myDynamicElement.getCssValue("height") + strExpected + stringsObjectInfo.getHeight(),true);
                        System.out.println("Height" + strFailed + myDynamicElement.getCssValue("height") + strExpected + stringsObjectInfo.getHeight());
                    }
                }
                
                //Verify Button Color
                if (stringsObjectInfo.getColor() != null) {
                    if (myDynamicElement.getCssValue("background-color").contentEquals(stringsObjectInfo.getColor())) {
                        HtmlLogUtil.writeToLog(0,stringsObjectInfo.getCssObjectName() + ": background-color" + strPassed + myDynamicElement.getCssValue("background-color") + strExpected + stringsObjectInfo.getColor());
                        System.out.println("background-color" + strPassed + myDynamicElement.getCssValue("background-color") + strExpected + stringsObjectInfo.getColor());
                    } else {
                        HtmlLogUtil.writeToLog(1,stringsObjectInfo.getCssObjectName() + ": background-color" + strFailed + myDynamicElement.getCssValue("background-color") + strExpected + stringsObjectInfo.getColor(),true);
                        System.out.println("background-color" + strFailed + myDynamicElement.getCssValue("background-color") + strExpected + stringsObjectInfo.getColor());
                    }
                }
                
                //Verify Button Left Padding
                if (stringsObjectInfo.getLeftPadding() != null) {
                    if (myDynamicElement.getCssValue("padding-left").contentEquals(stringsObjectInfo.getLeftPadding())) {
                        HtmlLogUtil.writeToLog(0,stringsObjectInfo.getCssObjectName() + ": LeftPadding" + strPassed + myDynamicElement.getCssValue("padding-left") + strExpected + stringsObjectInfo.getLeftPadding());
                        System.out.println("LeftPadding" + strPassed + myDynamicElement.getCssValue("padding-left") + strExpected + stringsObjectInfo.getLeftPadding());
                    } else {
                        HtmlLogUtil.writeToLog(1,stringsObjectInfo.getCssObjectName() + ": LeftPadding" + strFailed + myDynamicElement.getCssValue("padding-left") + strExpected + stringsObjectInfo.getLeftPadding(),true);
                        System.out.println("LeftPadding" + strFailed + myDynamicElement.getCssValue("padding-left") + strExpected + stringsObjectInfo.getLeftPadding());
                    }
                }
                
                //Verify Button Right Padding
                if (stringsObjectInfo.getRightPadding() != null) {
                    if (myDynamicElement.getCssValue("padding-right").contentEquals(stringsObjectInfo.getLeftPadding())) {
                        HtmlLogUtil.writeToLog(0,stringsObjectInfo.getCssObjectName() + ": RightPadding" + strPassed + myDynamicElement.getCssValue("padding-right") + strExpected + stringsObjectInfo.getRightPadding());
                        System.out.println("RightPadding" + strPassed + myDynamicElement.getCssValue("padding-right") + strExpected + stringsObjectInfo.getRightPadding());
                    } else {
                        HtmlLogUtil.writeToLog(1,stringsObjectInfo.getCssObjectName() + ": RightPadding" + strFailed + myDynamicElement.getCssValue("padding-right") + strExpected + stringsObjectInfo.getRightPadding(),true);
                        System.out.println("RightPadding" + strFailed + myDynamicElement.getCssValue("padding-right") + strExpected + stringsObjectInfo.getRightPadding());
                    }
                }
                return true;
            }
            
            catch (Exception e) {
                System.out.println();
                System.out.println("Exception Occurred : Check Exception for Element -" + stringsObjectInfo.getCssObjectName());
                System.out.println(e.getMessage());
                HtmlLogUtil.writeToLog(1,"Exception Occurred for Element : " + stringsObjectInfo.getCssObjectName() + ": " + e.getMessage(),true);
                return false;
            }
			finally{
				myDynamicElement = null;
			}
    }
    
    
    
    public boolean verifyCssObjectProperties(WebElement byWebElement, CssButtonData stringsObjectInfo){

    	WebElement myDynamicElement;
    	
            try {
            	
            	//Wait for Element to Load
               // myDynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(byWebElement));
            	myDynamicElement= byWebElement;
                System.out.println();
                System.out.println(stringsObjectInfo.getCssObjectName());

                //Verify the CSS properties of the Button
                //Font Family
                if (stringsObjectInfo.getFontFamily() != null) {
                    if (myDynamicElement.getCssValue("font-family").contentEquals(stringsObjectInfo.getFontFamily())) {
                        System.out.println("Font-Family" + strPassed + myDynamicElement.getCssValue("font-family") + strExpected + stringsObjectInfo.getFontFamily());
                        HtmlLogUtil.writeToLog(0, stringsObjectInfo.getCssObjectName() + ": Font-Family" + strPassed + myDynamicElement.getCssValue("font-family") + strExpected + stringsObjectInfo.getFontFamily(),false);
                    } else {
                        System.out.println("Font-Family" + strFailed + myDynamicElement.getCssValue("font-family") + strExpected + stringsObjectInfo.getFontFamily());
                        HtmlLogUtil.writeToLog(1, stringsObjectInfo.getCssObjectName() + ": Font-Family" + strFailed + myDynamicElement.getCssValue("font-family") + strExpected + stringsObjectInfo.getFontFamily(),true);
                    }
                }
                
                //Verify Font Size
                if (stringsObjectInfo.getFontSize() != null) {
                    if (myDynamicElement.getCssValue("font-size").contentEquals(stringsObjectInfo.getFontSize())) {
                        System.out.println("Font-Size" + strPassed + myDynamicElement.getCssValue("font-size") + strExpected + stringsObjectInfo.getFontSize());
                        HtmlLogUtil.writeToLog(0,stringsObjectInfo.getCssObjectName() + ": Font-Size" + strPassed + myDynamicElement.getCssValue("font-size") + strExpected + stringsObjectInfo.getFontSize());
                    } else {
                        System.out.println("Font-Size" + strFailed + myDynamicElement.getCssValue("font-size") + strExpected + stringsObjectInfo.getFontSize());
                        HtmlLogUtil.writeToLog(1,stringsObjectInfo.getCssObjectName() + ": Font-Size" + strFailed + myDynamicElement.getCssValue("font-size") + strExpected + stringsObjectInfo.getFontSize(),true);
                    }
                }
                
                //Verify Line Height
                if (stringsObjectInfo.getLineHeight() != null) {
                    if (myDynamicElement.getCssValue("line-height").contentEquals(stringsObjectInfo.getLineHeight())) {
                        System.out.println("Line-Height" + strPassed + myDynamicElement.getCssValue("line-height") + strExpected + stringsObjectInfo.getLineHeight());
                        HtmlLogUtil.writeToLog(0,stringsObjectInfo.getCssObjectName() + ": Line-Height" + strPassed + myDynamicElement.getCssValue("line-height") + strExpected + stringsObjectInfo.getLineHeight());
                    } else {
                        System.out.println("Line-Height" + strFailed + myDynamicElement.getCssValue("line-height") + strExpected + stringsObjectInfo.getLineHeight());
                        HtmlLogUtil.writeToLog(1,stringsObjectInfo.getCssObjectName() + ": Line-Height" + strFailed + myDynamicElement.getCssValue("line-height") + strExpected + stringsObjectInfo.getLineHeight(),true);
                    }
                }
                
                //Verify Button Width - if needed
                if (stringsObjectInfo.getWidth() != null) {
                    if (myDynamicElement.getCssValue("width").contentEquals(stringsObjectInfo.getWidth())) {
                        HtmlLogUtil.writeToLog(0,stringsObjectInfo.getCssObjectName() + ": Width" + strPassed + myDynamicElement.getCssValue("width") + strExpected + stringsObjectInfo.getWidth());
                        System.out.println("Width" + strPassed + myDynamicElement.getCssValue("width") + strExpected + stringsObjectInfo.getWidth());
                    } else {
                        HtmlLogUtil.writeToLog(1,stringsObjectInfo.getCssObjectName() + ": Width" + strFailed + myDynamicElement.getCssValue("width") + strExpected + stringsObjectInfo.getWidth(),true);
                        System.out.println("Width" + strFailed + myDynamicElement.getCssValue("width") + strExpected + stringsObjectInfo.getWidth());
                    }
                }
                
                //Verify Button Height
                if (stringsObjectInfo.getHeight() != null) {
                    if (myDynamicElement.getCssValue("height").contentEquals(stringsObjectInfo.getHeight())) {
                        HtmlLogUtil.writeToLog(0,stringsObjectInfo.getCssObjectName() + ": Height" + strPassed + myDynamicElement.getCssValue("height") + strExpected + stringsObjectInfo.getHeight());
                        System.out.println("Height" + strPassed + myDynamicElement.getCssValue("height") + strExpected + stringsObjectInfo.getHeight());
                    } else {
                        HtmlLogUtil.writeToLog(1,stringsObjectInfo.getCssObjectName() + ": Height" + strFailed + myDynamicElement.getCssValue("height") + strExpected + stringsObjectInfo.getHeight(),true);
                        System.out.println("Height" + strFailed + myDynamicElement.getCssValue("height") + strExpected + stringsObjectInfo.getHeight());
                    }
                }
                
                //Verify Button Color
                if (stringsObjectInfo.getColor() != null) {
                    if (myDynamicElement.getCssValue("background-color").contentEquals(stringsObjectInfo.getColor())) {
                        HtmlLogUtil.writeToLog(0,stringsObjectInfo.getCssObjectName() + ": background-color" + strPassed + myDynamicElement.getCssValue("background-color") + strExpected + stringsObjectInfo.getColor());
                        System.out.println("background-color" + strPassed + myDynamicElement.getCssValue("background-color") + strExpected + stringsObjectInfo.getColor());
                    } else {
                        HtmlLogUtil.writeToLog(1,stringsObjectInfo.getCssObjectName() + ": background-color" + strFailed + myDynamicElement.getCssValue("background-color") + strExpected + stringsObjectInfo.getColor(),true);
                        System.out.println("background-color" + strFailed + myDynamicElement.getCssValue("background-color") + strExpected + stringsObjectInfo.getColor());
                    }
                }
                
                //Verify Button Left Padding
                if (stringsObjectInfo.getLeftPadding() != null) {
                    if (myDynamicElement.getCssValue("padding-left").contentEquals(stringsObjectInfo.getLeftPadding())) {
                        HtmlLogUtil.writeToLog(0,stringsObjectInfo.getCssObjectName() + ": LeftPadding" + strPassed + myDynamicElement.getCssValue("padding-left") + strExpected + stringsObjectInfo.getLeftPadding());
                        System.out.println("LeftPadding" + strPassed + myDynamicElement.getCssValue("padding-left") + strExpected + stringsObjectInfo.getLeftPadding());
                    } else {
                        HtmlLogUtil.writeToLog(1,stringsObjectInfo.getCssObjectName() + ": LeftPadding" + strFailed + myDynamicElement.getCssValue("padding-left") + strExpected + stringsObjectInfo.getLeftPadding(),true);
                        System.out.println("LeftPadding" + strFailed + myDynamicElement.getCssValue("padding-left") + strExpected + stringsObjectInfo.getLeftPadding());
                    }
                }
                
                //Verify Button Right Padding
                if (stringsObjectInfo.getRightPadding() != null) {
                    if (myDynamicElement.getCssValue("padding-right").contentEquals(stringsObjectInfo.getLeftPadding())) {
                        HtmlLogUtil.writeToLog(0,stringsObjectInfo.getCssObjectName() + ": RightPadding" + strPassed + myDynamicElement.getCssValue("padding-right") + strExpected + stringsObjectInfo.getRightPadding());
                        System.out.println("RightPadding" + strPassed + myDynamicElement.getCssValue("padding-right") + strExpected + stringsObjectInfo.getRightPadding());
                    } else {
                        HtmlLogUtil.writeToLog(1,stringsObjectInfo.getCssObjectName() + ": RightPadding" + strFailed + myDynamicElement.getCssValue("padding-right") + strExpected + stringsObjectInfo.getRightPadding(),true);
                        System.out.println("RightPadding" + strFailed + myDynamicElement.getCssValue("padding-right") + strExpected + stringsObjectInfo.getRightPadding());
                    }
                }
                return true;
            }
            
            catch (Exception e) {
                System.out.println();
                System.out.println("Exception Occurred : Check Exception for Element -" + stringsObjectInfo.getCssObjectName());
                System.out.println(e.getMessage());
                HtmlLogUtil.writeToLog(1,"Exception Occurred for Element : " + stringsObjectInfo.getCssObjectName() + ": " + e.getMessage(),true);
                return false;
            }
			finally{
				myDynamicElement = null;
			}
    }
    
    

    //Check properties of the drop-down
	public boolean verifyCssObjectProperties(By byWebElement, CssDropDownData stringsObjectInfo) {

    	WebElement myDynamicElement;
    	
            try {
            	
            	//Wait for Element to Load
                myDynamicElement = (new WebDriverWait(driver, 10))
                        .until(ExpectedConditions.presenceOfElementLocated(byWebElement));
                System.out.println();
                System.out.println(stringsObjectInfo.getCssObjectName());

                //Verify the CSS properties of the Button
                //Font Family
                if (stringsObjectInfo.getFontFamily() != null) 
                {
                	writeHtmlLog("font-family", "Font-Family", stringsObjectInfo.getFontFamily(),stringsObjectInfo.getCssObjectName() ,myDynamicElement);
                }
                
                //Verify Font Size
                if (stringsObjectInfo.getFontSize() != null) 
                {
                	writeHtmlLog("font-size", "Font-Size", stringsObjectInfo.getFontSize(),stringsObjectInfo.getCssObjectName() ,myDynamicElement);
                }
                
                //Verify Line Height
                if (stringsObjectInfo.getLineHeight() != null) 
                {
                	writeHtmlLog("line-height", "Line-Height", stringsObjectInfo.getLineHeight(),stringsObjectInfo.getCssObjectName() ,myDynamicElement);
                }
                
                //Verify Button Width - if needed
                if (stringsObjectInfo.getWidth() != null) 
                {
                	writeHtmlLog("width", "Width", stringsObjectInfo.getWidth(),stringsObjectInfo.getCssObjectName() ,myDynamicElement);
                }
                
                //Verify Button Height
                if (stringsObjectInfo.getHeight() != null) 
                {
                	writeHtmlLog("height", "Height", stringsObjectInfo.getHeight(),stringsObjectInfo.getCssObjectName() ,myDynamicElement);
                }
                
                //Verify Button Color
                if (stringsObjectInfo.getColor() != null) 
                {
                	writeHtmlLog("background-color", "Background-Color", stringsObjectInfo.getColor(),stringsObjectInfo.getCssObjectName() ,myDynamicElement);
                }
                
                //Verify Button Left Padding
                if (stringsObjectInfo.getLeftPadding() != null) 
                {
                	writeHtmlLog("padding-left", "Padding-Left", stringsObjectInfo.getLeftPadding(),stringsObjectInfo.getCssObjectName() ,myDynamicElement);
                }
                
                //Verify Button Right Padding
                if (stringsObjectInfo.getRightPadding() != null) 
                {
                	writeHtmlLog("padding-right", "Padding-Right", stringsObjectInfo.getRightPadding(),stringsObjectInfo.getCssObjectName() ,myDynamicElement);
                }
                return true;
            }
            
            catch (Exception e) {
                System.out.println();
                System.out.println("Exception Occurred : Check Exception for Element -" + stringsObjectInfo.getCssObjectName());
                System.out.println(e.getMessage());
                HtmlLogUtil.writeToLog(1,"Exception Occurred for Element : " + stringsObjectInfo.getCssObjectName() + ": " + e.getMessage(),true);
                return false;
            }
			finally{
				myDynamicElement = null;
			}
	}
	
	
	public boolean verifyCssObjectProperties(WebElement byWebElement, CssDropDownData stringsObjectInfo) {

    	WebElement myDynamicElement;
    	
            try {
            	
            	//Wait for Element to Load
                myDynamicElement = byWebElement;
                System.out.println();
                System.out.println(stringsObjectInfo.getCssObjectName());

                //Verify the CSS properties of the Button
                //Font Family
                if (stringsObjectInfo.getFontFamily() != null) 
                {
                	writeHtmlLog("font-family", "Font-Family", stringsObjectInfo.getFontFamily(),stringsObjectInfo.getCssObjectName() ,myDynamicElement);
                }
                
                //Verify Font Size
                if (stringsObjectInfo.getFontSize() != null) 
                {
                	writeHtmlLog("font-size", "Font-Size", stringsObjectInfo.getFontSize(),stringsObjectInfo.getCssObjectName() ,myDynamicElement);
                }
                
                //Verify Line Height
                if (stringsObjectInfo.getLineHeight() != null) 
                {
                	writeHtmlLog("line-height", "Line-Height", stringsObjectInfo.getLineHeight(),stringsObjectInfo.getCssObjectName() ,myDynamicElement);
                }
                
                //Verify Button Width - if needed
                if (stringsObjectInfo.getWidth() != null) 
                {
                	writeHtmlLog("width", "Width", stringsObjectInfo.getWidth(),stringsObjectInfo.getCssObjectName() ,myDynamicElement);
                }
                
                //Verify Button Height
                if (stringsObjectInfo.getHeight() != null) 
                {
                	writeHtmlLog("height", "Height", stringsObjectInfo.getHeight(),stringsObjectInfo.getCssObjectName() ,myDynamicElement);
                }
                
                //Verify Button Color
                if (stringsObjectInfo.getColor() != null) 
                {
                	writeHtmlLog("background-color", "Background-Color", stringsObjectInfo.getColor(),stringsObjectInfo.getCssObjectName() ,myDynamicElement);
                }
                
                //Verify Button Left Padding
                if (stringsObjectInfo.getLeftPadding() != null) 
                {
                	writeHtmlLog("padding-left", "Padding-Left", stringsObjectInfo.getLeftPadding(),stringsObjectInfo.getCssObjectName() ,myDynamicElement);
                }
                
                //Verify Button Right Padding
                if (stringsObjectInfo.getRightPadding() != null) 
                {
                	writeHtmlLog("padding-right", "Padding-Right", stringsObjectInfo.getRightPadding(),stringsObjectInfo.getCssObjectName() ,myDynamicElement);
                }
                return true;
            }
            
            catch (Exception e) {
                System.out.println();
                System.out.println("Exception Occurred : Check Exception for Element -" + stringsObjectInfo.getCssObjectName());
                System.out.println(e.getMessage());
                HtmlLogUtil.writeToLog(1,"Exception Occurred for Element : " + stringsObjectInfo.getCssObjectName() + ": " + e.getMessage(),true);
                return false;
            }
			finally{
				myDynamicElement = null;
			}
	}
	
    
    //Verify CSS properties for Color Selector
    public boolean verifyCssObjectProperties(By byWebElement, CssColorSelectorData stringsObjectInfo){

        try {
        	
            WebElement myDynamicElement = (new WebDriverWait(driver, 10))
            		.until(ExpectedConditions.presenceOfElementLocated(byWebElement));

            System.out.println();
            System.out.println(stringsObjectInfo.getCssObjectName());

            if (stringsObjectInfo.getColorSelectorWidth() != null) 
            {
            	writeHtmlLog("width", "Width", stringsObjectInfo.getColorSelectorWidth(),stringsObjectInfo.getCssObjectName() ,myDynamicElement);
            }
            if (stringsObjectInfo.getColorSelectorHeight() != null) 
            {
            	writeHtmlLog("height", "Height", stringsObjectInfo.getColorSelectorHeight(),stringsObjectInfo.getCssObjectName() ,myDynamicElement);
            }
            if (stringsObjectInfo.getColorSelectorBorderRadius() != null) 
            {
            	writeHtmlLog("border-top-right-radius", "Border-Radius", stringsObjectInfo.getColorSelectorBorderRadius(),stringsObjectInfo.getCssObjectName() ,myDynamicElement);
            }
            if (stringsObjectInfo.getColorSelectorCursor() != null) 
            {
            	writeHtmlLog("cursor", "Hover-Cursor", stringsObjectInfo.getColorSelectorCursor(),stringsObjectInfo.getCssObjectName() ,myDynamicElement);
            }
            return true;
        }
        catch (Exception e) {
            System.out.println();
            System.out.println("Exception Occurred : Check Exception for Element -" + stringsObjectInfo.getCssObjectName());
            System.out.println(e.getMessage());
            HtmlLogUtil.writeToLog(1,"Exception Occurred for Element : " + stringsObjectInfo.getCssObjectName() + ": " + e.getMessage(),true);
            return false;
        }
		
}
    
    public boolean verifyCssObjectProperties(WebElement byWebElement, CssColorSelectorData stringsObjectInfo){

    	WebElement myDynamicElement;
    	
    	try {
        	
        	
        	myDynamicElement= byWebElement;

            System.out.println();
            System.out.println(stringsObjectInfo.getCssObjectName());

            if (stringsObjectInfo.getColorSelectorWidth() != null) 
            {
            	writeHtmlLog("width", "Width", stringsObjectInfo.getColorSelectorWidth(),stringsObjectInfo.getCssObjectName() ,myDynamicElement);
            }
            if (stringsObjectInfo.getColorSelectorHeight() != null) 
            {
            	writeHtmlLog("height", "Height", stringsObjectInfo.getColorSelectorHeight(),stringsObjectInfo.getCssObjectName() ,myDynamicElement);
            }
            if (stringsObjectInfo.getColorSelectorBorderRadius() != null) 
            {
            	writeHtmlLog("border-top-right-radius", "Border-Radius", stringsObjectInfo.getColorSelectorBorderRadius(),stringsObjectInfo.getCssObjectName() ,myDynamicElement);
            }
            if (stringsObjectInfo.getColorSelectorCursor() != null) 
            {
            	writeHtmlLog("cursor", "Hover-Cursor", stringsObjectInfo.getColorSelectorCursor(),stringsObjectInfo.getCssObjectName() ,myDynamicElement);
            }
            return true;
        }
        catch (Exception e) {
            System.out.println();
            System.out.println("Exception Occurred : Check Exception for Element -" + stringsObjectInfo.getCssObjectName());
            System.out.println(e.getMessage());
            HtmlLogUtil.writeToLog(1,"Exception Occurred for Element : " + stringsObjectInfo.getCssObjectName() + ": " + e.getMessage(),true);
            return false;
        }
		
}

    //Verify CSS properties for Accordian
    public boolean verifyCssObjectProperties(By byWebElement, CssAccordionData stringsObjectInfo){

        try {
        	
            WebElement myDynamicElement = (new WebDriverWait(driver, 10))
            		.until(ExpectedConditions.presenceOfElementLocated(byWebElement));

            System.out.println();
            System.out.println(stringsObjectInfo.getCssObjectName());

            if (stringsObjectInfo.getFontFamily() != null) 
            {
            	writeHtmlLog("font-family", "Font-Family", stringsObjectInfo.getFontFamily(),stringsObjectInfo.getCssObjectName() ,myDynamicElement);
            }
            if (stringsObjectInfo.getFontSize() != null) 
            {
            	writeHtmlLog("font-size", "Font-Size", stringsObjectInfo.getFontFamily(),stringsObjectInfo.getCssObjectName() ,myDynamicElement);
            }
            if (stringsObjectInfo.getBorderStyle() != null) 
            {
            	writeHtmlLog("border-top-style", "Border-Style", stringsObjectInfo.getBorderStyle(),stringsObjectInfo.getCssObjectName() ,myDynamicElement);
            }
            if (stringsObjectInfo.getPadding() != null) 
            {
            	writeHtmlLog("padding-right", "Padding Right", stringsObjectInfo.getPadding(),stringsObjectInfo.getCssObjectName() ,myDynamicElement);
            }
            return true;
        }
        catch (Exception e) {
            System.out.println();
            System.out.println("Exception Occurred : Check Exception for Element -" + stringsObjectInfo.getCssObjectName());
            System.out.println(e.getMessage());
            HtmlLogUtil.writeToLog(1,"Exception Occurred for Element : " + stringsObjectInfo.getCssObjectName() + ": " + e.getMessage(),true);
            return false;
        }
		
}
    
    public boolean verifyCssObjectProperties(WebElement byWebElement, CssAccordionData stringsObjectInfo){

    	WebElement myDynamicElement;
    	try {
        	
        	myDynamicElement= byWebElement;

            System.out.println();
            System.out.println(stringsObjectInfo.getCssObjectName());

            if (stringsObjectInfo.getFontFamily() != null) 
            {
            	writeHtmlLog("font-family", "Font-Family", stringsObjectInfo.getFontFamily(),stringsObjectInfo.getCssObjectName() ,myDynamicElement);
            }
            if (stringsObjectInfo.getFontSize() != null) 
            {
            	writeHtmlLog("font-size", "Font-Size", stringsObjectInfo.getFontFamily(),stringsObjectInfo.getCssObjectName() ,myDynamicElement);
            }
            if (stringsObjectInfo.getBorderStyle() != null) 
            {
            	writeHtmlLog("border-top-style", "Border-Style", stringsObjectInfo.getBorderStyle(),stringsObjectInfo.getCssObjectName() ,myDynamicElement);
            }
            if (stringsObjectInfo.getPadding() != null) 
            {
            	writeHtmlLog("padding-right", "Padding Right", stringsObjectInfo.getPadding(),stringsObjectInfo.getCssObjectName() ,myDynamicElement);
            }
            return true;
        }
        catch (Exception e) {
            System.out.println();
            System.out.println("Exception Occurred : Check Exception for Element -" + stringsObjectInfo.getCssObjectName());
            System.out.println(e.getMessage());
            HtmlLogUtil.writeToLog(1,"Exception Occurred for Element : " + stringsObjectInfo.getCssObjectName() + ": " + e.getMessage(),true);
            return false;
        }
		
}
    
  //VerifyCSSProperties for Button
    public boolean verifyCssObjectProperties(By byWebElement, CssCarouselData stringsObjectInfo){

    	WebElement myDynamicElement;
    	
            try {
            	
            	//Wait for Element to Load
                myDynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(byWebElement));
            	//myDynamicElement= byWebElement;
                System.out.println();
                System.out.println(stringsObjectInfo.getCssObjectName());

                //Verify the CSS properties of the Carousel
                //Background Color
                if (stringsObjectInfo.getCarouselBackgroundColor() != null) 
                {
                	 writeHtmlLog("background-color", "Background-Color", stringsObjectInfo.getCarouselBackgroundColor(),stringsObjectInfo.getCssObjectName() ,myDynamicElement);
                }
                
                //Verify Border radius
                if (stringsObjectInfo.getCarouselBorderRaduis() != null) 
                {
                	 writeHtmlLog("border-top-left-radius", "Border-Radius", stringsObjectInfo.getCarouselBorderRaduis(),stringsObjectInfo.getCssObjectName() ,myDynamicElement);
                }
                
                //Verify margin
                if (stringsObjectInfo.getCarouselMargin() != null) 
                {
                	 writeHtmlLog("margin-left", "Margin-Left", stringsObjectInfo.getCarouselMargin(),stringsObjectInfo.getCssObjectName() ,myDynamicElement);
                }
                
                //Verify Padding
                if (stringsObjectInfo.getCarouselPadding() != null) 
                {
                	 writeHtmlLog("padding-right", "Padding-Right", stringsObjectInfo.getCarouselPadding(),stringsObjectInfo.getCssObjectName() ,myDynamicElement);
                }
                
                //Verify Text-Align
                if (stringsObjectInfo.getCarouselTextAlign() != null) 
                {
                	 writeHtmlLog("text-align", "Text-Align", stringsObjectInfo.getCarouselTextAlign(),stringsObjectInfo.getCssObjectName() ,myDynamicElement);
                }
                
                return true;
            }
            
            catch (Exception e) {
                System.out.println();
                System.out.println("Exception Occurred : Check Exception for Element -" + stringsObjectInfo.getCssObjectName());
                System.out.println(e.getMessage());
                HtmlLogUtil.writeToLog(1,"Exception Occurred for Element : " + stringsObjectInfo.getCssObjectName() + ": " + e.getMessage(),true);
                return false;
            }
			finally{
				myDynamicElement = null;
			}
    }
    
    public boolean verifyCssObjectProperties(WebElement byWebElement, CssCarouselData stringsObjectInfo){

    	WebElement myDynamicElement;
    	
            try {
            	
            	//Wait for Element to Load
                myDynamicElement = byWebElement;
            	//myDynamicElement= byWebElement;
                System.out.println();
                System.out.println(stringsObjectInfo.getCssObjectName());
                
        	    

                //Verify the CSS properties of the Carousel
                //Background Color
                if (stringsObjectInfo.getCarouselBackgroundColor() != null) 
                {
                	 writeHtmlLog("background-color", "Background-Color", stringsObjectInfo.getCarouselBackgroundColor(),stringsObjectInfo.getCssObjectName() ,myDynamicElement);
                }
                
                //Verify Border radius
                if (stringsObjectInfo.getCarouselBorderRaduis() != null) 
                {
                	 writeHtmlLog("border-top-left-radius", "Border-Radius", stringsObjectInfo.getCarouselBorderRaduis(),stringsObjectInfo.getCssObjectName() ,myDynamicElement);
                }
                
                //Verify margin
                if (stringsObjectInfo.getCarouselMargin() != null) 
                {
                	 writeHtmlLog("margin-left", "Margin-Left", stringsObjectInfo.getCarouselMargin(),stringsObjectInfo.getCssObjectName() ,myDynamicElement);
                }
                
                //Verify Padding
                if (stringsObjectInfo.getCarouselPadding() != null) 
                {
                	 writeHtmlLog("padding-right", "Padding-Right", stringsObjectInfo.getCarouselPadding(),stringsObjectInfo.getCssObjectName() ,myDynamicElement);
                }
                
                //Verify Text-Align
                if (stringsObjectInfo.getCarouselTextAlign() != null) 
                {
                	 writeHtmlLog("text-align", "Text-Align", stringsObjectInfo.getCarouselTextAlign(),stringsObjectInfo.getCssObjectName() ,myDynamicElement);
                }
                
                return true;
            }
            
            catch (Exception e) {
                System.out.println();
                System.out.println("Exception Occurred : Check Exception for Element -" + stringsObjectInfo.getCssObjectName());
                System.out.println(e.getMessage());
                HtmlLogUtil.writeToLog(1,"Exception Occurred for Element : " + stringsObjectInfo.getCssObjectName() + ": " + e.getMessage(),true);
                return false;
            }
			finally{
				myDynamicElement = null;
			}
    }
    
    //Verify CSS properties for Color Selector
    public boolean verifyCssObjectProperties(By byWebElement, CssFloatingTabData stringsObjectInfo){

        try {
        	
            WebElement myDynamicElement = (new WebDriverWait(driver, 10))
            		.until(ExpectedConditions.presenceOfElementLocated(byWebElement));

            System.out.println();
            System.out.println(stringsObjectInfo.getCssObjectName());

            if (stringsObjectInfo.getFloatingTabBackgroundColor() != null) 
            {
            	writeHtmlLog("background-color", "Background-Color", stringsObjectInfo.getFloatingTabBackgroundColor(),stringsObjectInfo.getCssObjectName() ,myDynamicElement);
            }
            if (stringsObjectInfo.getFloatingTabRadius() != null) 
            {
            	writeHtmlLog("border-top-right-radius", "Border-Radius", stringsObjectInfo.getFloatingTabRadius(),stringsObjectInfo.getCssObjectName() ,myDynamicElement);
            }
            if (stringsObjectInfo.getFloatingTabCursor() != null) 
            {
            	writeHtmlLog("cursor", "Cursor", stringsObjectInfo.getFloatingTabCursor(),stringsObjectInfo.getCssObjectName() ,myDynamicElement);
            }
            if (stringsObjectInfo.getFloatingTabFontFamily() != null) 
            {
            	writeHtmlLog("font-family", "Font-Fmaily", stringsObjectInfo.getFloatingTabFontFamily(),stringsObjectInfo.getCssObjectName() ,myDynamicElement);
            }
            if (stringsObjectInfo.getFloatingTabTextAlign() != null) 
            {
            	writeHtmlLog("text-align", "Text-Align", stringsObjectInfo.getFloatingTabTextAlign(),stringsObjectInfo.getCssObjectName() ,myDynamicElement);
            }
            return true;
        }
        catch (Exception e) {
            System.out.println();
            System.out.println("Exception Occurred : Check Exception for Element -" + stringsObjectInfo.getCssObjectName());
            System.out.println(e.getMessage());
            HtmlLogUtil.writeToLog(1,"Exception Occurred for Element : " + stringsObjectInfo.getCssObjectName() + ": " + e.getMessage(),true);
            return false;
        }
    }
    
    public boolean verifyCssObjectProperties(WebElement byWebElement, CssFloatingTabData stringsObjectInfo){

        try {
        	
            WebElement myDynamicElement = byWebElement;

            System.out.println();
            System.out.println(stringsObjectInfo.getCssObjectName());

            if (stringsObjectInfo.getFloatingTabBackgroundColor() != null) 
            {
            	writeHtmlLog("background-color", "Background-Color", stringsObjectInfo.getFloatingTabBackgroundColor(),stringsObjectInfo.getCssObjectName() ,myDynamicElement);
            }
            if (stringsObjectInfo.getFloatingTabRadius() != null) 
            {
            	writeHtmlLog("border-top-right-radius", "Border-Radius", stringsObjectInfo.getFloatingTabRadius(),stringsObjectInfo.getCssObjectName() ,myDynamicElement);
            }
            if (stringsObjectInfo.getFloatingTabCursor() != null) 
            {
            	writeHtmlLog("cursor", "Cursor", stringsObjectInfo.getFloatingTabCursor(),stringsObjectInfo.getCssObjectName() ,myDynamicElement);
            }
            if (stringsObjectInfo.getFloatingTabFontFamily() != null) 
            {
            	writeHtmlLog("font-family", "Font-Fmaily", stringsObjectInfo.getFloatingTabFontFamily(),stringsObjectInfo.getCssObjectName() ,myDynamicElement);
            }
            if (stringsObjectInfo.getFloatingTabTextAlign() != null) 
            {
            	writeHtmlLog("text-align", "Text-Align", stringsObjectInfo.getFloatingTabTextAlign(),stringsObjectInfo.getCssObjectName() ,myDynamicElement);
            }
            return true;
        }
        catch (Exception e) {
            System.out.println();
            System.out.println("Exception Occurred : Check Exception for Element -" + stringsObjectInfo.getCssObjectName());
            System.out.println(e.getMessage());
            HtmlLogUtil.writeToLog(1,"Exception Occurred for Element : " + stringsObjectInfo.getCssObjectName() + ": " + e.getMessage(),true);
            return false;
        }
    }
    
    
    public void writeHtmlLog(String property, String name, String expected,String objName,WebElement myDynamicElement)
    {
    	if (myDynamicElement.getCssValue(property).contentEquals(expected)) 
    	{
	    	HtmlLogUtil.writeToLog(0,objName+ name + strPassed + myDynamicElement.getCssValue(property) + strExpected + expected);
	        System.out.println(name + strPassed + myDynamicElement.getCssValue(property) + strExpected + expected);
    	}
    	else
    	{
    		{
    	    	HtmlLogUtil.writeToLog(0,objName + name + strFailed + myDynamicElement.getCssValue(property) + strExpected + expected);
    	        System.out.println(name + strFailed + myDynamicElement.getCssValue(property) + strExpected + expected);
        	}
    	}
    	
    }
    
    
    
    //Hover and Takes the ScreenShot of the page
    public void verifyHover(By byWebElement){
        WebElement webElement = driver.findElement(byWebElement);
        action.moveToElement(webElement).build().perform();
        HtmlLogUtil.writeToLog(0, "Verify Screeshot",true);
    }
    
    //Verify Button Hover and Check the color change
    public boolean verifyButtonHover(By byWebElement, CssButtonData stringsObjectInfo){
    	
    	try
    	{
	    	//Find Element
	    	WebElement myDynamicElement = (new WebDriverWait(driver, 10))
	                  .until(ExpectedConditions.presenceOfElementLocated(byWebElement));
	    	//Move to Element and Hover the Element  
	    	
	        action.moveToElement(myDynamicElement,1,1);
	        Thread.sleep(2000);
	        
	        //Verify the BackGround change on Hover
	        if (stringsObjectInfo.getColor() != null) {
	            if (myDynamicElement.getCssValue("background-color").contentEquals(stringsObjectInfo.getColor())) {
	                HtmlLogUtil.writeToLog(0,stringsObjectInfo.getCssObjectName() + ": background-color" + strPassed + myDynamicElement.getCssValue("background-color") + strExpected + stringsObjectInfo.getColor());
	                System.out.println("background-color" + strPassed + myDynamicElement.getCssValue("background-color") + strExpected + stringsObjectInfo.getColor());
	            } else {
	                HtmlLogUtil.writeToLog(1,stringsObjectInfo.getCssObjectName() + ": background-color" + strFailed + myDynamicElement.getCssValue("background-color") + strExpected + stringsObjectInfo.getColor(),true);
	                System.out.println("background-color" + strFailed + myDynamicElement.getCssValue("background-color") + strExpected + stringsObjectInfo.getColor());
	            }
	        }
	        return true;
    	}
    	catch(Exception e){
		   System.out.println();
           System.out.println("Exception Occurred : Check Exception for Element -" + stringsObjectInfo.getCssObjectName());
           System.out.println(e.getMessage());
           HtmlLogUtil.writeToLog(1,"Exception Occurred for Element : " + stringsObjectInfo.getCssObjectName() + ": " + e.getMessage(),true);
           return false;
    	}
    }
    
    //Validate the Link Text
    public void validateElementHref(By byWebElement){
        try {
            WebElement webElement = driver.findElement(byWebElement);
            String linkHref = webElement.getAttribute("href");
            //Assert.assertNotEquals(linkHref, null);
            System.out.println();
            if (linkHref != null) {
                HtmlLogUtil.writeToLog(0, webElement.getText() + "- Link Contains the Href -" + linkHref);
                System.out.println(linkHref);
            } else {
                HtmlLogUtil.writeToLog(1, webElement.getText() + "- Link does not Contain the Href -" + linkHref);
            }
        }
        catch(Exception e){
            HtmlLogUtil.writeToLog(1, "Exception occurred : - " + e.getMessage());
        }
    }

    //Check Margin
    public void checkMargin(By byWebElementOne , By byWebElementTwo){
        WebElement webElement1 = driver.findElement(byWebElementOne);
        WebElement webElement2 = driver.findElement(byWebElementTwo);
        Point p1 = webElement1.getLocation();
        Point p2 = webElement2.getLocation();
        Dimension d1 = webElement1.getSize();
        Dimension d2 = webElement2.getSize();
        System.out.println(p1 + " " + d1 + " " + p2 + " "+ d2);
        System.out.println(p2.getX() - (p1.getX() + d1.getWidth()));

    }


}
