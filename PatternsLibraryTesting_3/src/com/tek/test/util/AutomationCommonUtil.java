package com.tek.test.util;

import com.tek.test.cssdataLoader.CssAccordionData;
import com.tek.test.cssdataLoader.CssButtonData;
import com.tek.test.cssdataLoader.CssColorSelectorData;
import com.tek.test.cssdataLoader.CssDropDownData;

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
    
    //Verify CSS properties for Color Selector
    public boolean verifyCssObjectProperties(By byWebElement, CssColorSelectorData stringsObjectInfo){

        try {
        	
            WebElement myDynamicElement = (new WebDriverWait(driver, 10))
            		.until(ExpectedConditions.presenceOfElementLocated(byWebElement));

            System.out.println();
            System.out.println(stringsObjectInfo.getCssObjectName());

            if (stringsObjectInfo.getColorSelectorWidth() != null) {
                if (myDynamicElement.getCssValue("width").contentEquals(stringsObjectInfo.getColorSelectorWidth())) {
                    System.out.println("Width" + strPassed + myDynamicElement.getCssValue("width") + strExpected + stringsObjectInfo.getColorSelectorWidth());
                    HtmlLogUtil.writeToLog(0, stringsObjectInfo.getCssObjectName() + ": Width" + strPassed + myDynamicElement.getCssValue("width") + strExpected + stringsObjectInfo.getColorSelectorWidth(),false);
                } else {
                    System.out.println("Width" + strFailed + myDynamicElement.getCssValue("width") + strExpected + stringsObjectInfo.getColorSelectorWidth());
                    HtmlLogUtil.writeToLog(1, stringsObjectInfo.getCssObjectName() + ": Width" + strFailed + myDynamicElement.getCssValue("width") + strExpected + stringsObjectInfo.getColorSelectorWidth(),false);
                }
            }
            if (stringsObjectInfo.getColorSelectorHeight() != null) {
                if (myDynamicElement.getCssValue("height").contentEquals(stringsObjectInfo.getColorSelectorHeight())) {
                    System.out.println("Height" + strPassed + myDynamicElement.getCssValue("height") + strExpected + stringsObjectInfo.getColorSelectorHeight());
                    HtmlLogUtil.writeToLog(0,stringsObjectInfo.getCssObjectName() + ": Height" + strPassed + myDynamicElement.getCssValue("height") + strExpected + stringsObjectInfo.getColorSelectorHeight());
                } else {
                    System.out.println("Height" + strFailed + myDynamicElement.getCssValue("height") + strExpected + stringsObjectInfo.getColorSelectorHeight());
                    HtmlLogUtil.writeToLog(1,stringsObjectInfo.getCssObjectName() + ": Height" + strFailed + myDynamicElement.getCssValue("height") + strExpected + stringsObjectInfo.getColorSelectorHeight());
                }
            }
            if (stringsObjectInfo.getColorSelectorBorderRadius() != null) {
                if (myDynamicElement.getCssValue("border-top-right-radius").contentEquals(stringsObjectInfo.getColorSelectorBorderRadius())) {
                    System.out.println("Border-Radius" + strPassed + myDynamicElement.getCssValue("border-top-right-radius") + strExpected + stringsObjectInfo.getColorSelectorBorderRadius());
                    HtmlLogUtil.writeToLog(0,stringsObjectInfo.getCssObjectName() + ": Border-Radius" + strPassed + myDynamicElement.getCssValue("border-top-right-radius") + strExpected + stringsObjectInfo.getColorSelectorBorderRadius());
                } else {
                    System.out.println("Border-Radius" + strFailed + myDynamicElement.getCssValue("border-top-right-radius") + strExpected + stringsObjectInfo.getColorSelectorBorderRadius());
                    HtmlLogUtil.writeToLog(1,stringsObjectInfo.getCssObjectName() + ": Border-Radius" + strFailed + myDynamicElement.getCssValue("border-top-right-radius") + strExpected + stringsObjectInfo.getColorSelectorBorderRadius());
                }
            }
            if (stringsObjectInfo.getColorSelectorCursor() != null) {
                if (myDynamicElement.getCssValue("cursor").contentEquals(stringsObjectInfo.getColorSelectorCursor())) {
                    HtmlLogUtil.writeToLog(0,stringsObjectInfo.getCssObjectName() + ": Cursor" + strPassed + myDynamicElement.getCssValue("cursor") + strExpected + stringsObjectInfo.getColorSelectorCursor());
                    System.out.println("Cursor" + strPassed + myDynamicElement.getCssValue("cursor") + strExpected + stringsObjectInfo.getColorSelectorCursor());
                } else {
                    HtmlLogUtil.writeToLog(1,stringsObjectInfo.getCssObjectName() + ": Cursor" + strFailed + myDynamicElement.getCssValue("cursor") + strExpected + stringsObjectInfo.getColorSelectorCursor());
                    System.out.println("Cursor" + strFailed + myDynamicElement.getCssValue("cursor") + strExpected + stringsObjectInfo.getColorSelectorCursor());
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
		
}
    
    public boolean verifyCssObjectProperties(WebElement byWebElement, CssColorSelectorData stringsObjectInfo){

    	WebElement myDynamicElement;
    	
    	try {
        	
        	
        	myDynamicElement= byWebElement;

            System.out.println();
            System.out.println(stringsObjectInfo.getCssObjectName());

            if (stringsObjectInfo.getColorSelectorWidth() != null) {
                if (myDynamicElement.getCssValue("width").contentEquals(stringsObjectInfo.getColorSelectorWidth())) {
                    System.out.println("Width" + strPassed + myDynamicElement.getCssValue("width") + strExpected + stringsObjectInfo.getColorSelectorWidth());
                    HtmlLogUtil.writeToLog(0, stringsObjectInfo.getCssObjectName() + ": Width" + strPassed + myDynamicElement.getCssValue("width") + strExpected + stringsObjectInfo.getColorSelectorWidth(),false);
                } else {
                    System.out.println("Width" + strFailed + myDynamicElement.getCssValue("width") + strExpected + stringsObjectInfo.getColorSelectorWidth());
                    HtmlLogUtil.writeToLog(1, stringsObjectInfo.getCssObjectName() + ": Width" + strFailed + myDynamicElement.getCssValue("width") + strExpected + stringsObjectInfo.getColorSelectorWidth(),false);
                }
            }
            if (stringsObjectInfo.getColorSelectorHeight() != null) {
                if (myDynamicElement.getCssValue("height").contentEquals(stringsObjectInfo.getColorSelectorHeight())) {
                    System.out.println("Height" + strPassed + myDynamicElement.getCssValue("height") + strExpected + stringsObjectInfo.getColorSelectorHeight());
                    HtmlLogUtil.writeToLog(0,stringsObjectInfo.getCssObjectName() + ": Height" + strPassed + myDynamicElement.getCssValue("height") + strExpected + stringsObjectInfo.getColorSelectorHeight());
                } else {
                    System.out.println("Height" + strFailed + myDynamicElement.getCssValue("height") + strExpected + stringsObjectInfo.getColorSelectorHeight());
                    HtmlLogUtil.writeToLog(1,stringsObjectInfo.getCssObjectName() + ": Height" + strFailed + myDynamicElement.getCssValue("height") + strExpected + stringsObjectInfo.getColorSelectorHeight());
                }
            }
            if (stringsObjectInfo.getColorSelectorBorderRadius() != null) {
                if (myDynamicElement.getCssValue("border-top-right-radius").contentEquals(stringsObjectInfo.getColorSelectorBorderRadius())) {
                    System.out.println("Border-Radius" + strPassed + myDynamicElement.getCssValue("border-top-right-radius") + strExpected + stringsObjectInfo.getColorSelectorBorderRadius());
                    HtmlLogUtil.writeToLog(0,stringsObjectInfo.getCssObjectName() + ": Border-Radius" + strPassed + myDynamicElement.getCssValue("border-top-right-radius") + strExpected + stringsObjectInfo.getColorSelectorBorderRadius());
                } else {
                    System.out.println("Border-Radius" + strFailed + myDynamicElement.getCssValue("border-top-right-radius") + strExpected + stringsObjectInfo.getColorSelectorBorderRadius());
                    HtmlLogUtil.writeToLog(1,stringsObjectInfo.getCssObjectName() + ": Border-Radius" + strFailed + myDynamicElement.getCssValue("border-top-right-radius") + strExpected + stringsObjectInfo.getColorSelectorBorderRadius());
                }
            }
            if (stringsObjectInfo.getColorSelectorCursor() != null) {
                if (myDynamicElement.getCssValue("cursor").contentEquals(stringsObjectInfo.getColorSelectorCursor())) {
                    HtmlLogUtil.writeToLog(0,stringsObjectInfo.getCssObjectName() + ": Cursor" + strPassed + myDynamicElement.getCssValue("cursor") + strExpected + stringsObjectInfo.getColorSelectorCursor());
                    System.out.println("Cursor" + strPassed + myDynamicElement.getCssValue("cursor") + strExpected + stringsObjectInfo.getColorSelectorCursor());
                } else {
                    HtmlLogUtil.writeToLog(1,stringsObjectInfo.getCssObjectName() + ": Cursor" + strFailed + myDynamicElement.getCssValue("cursor") + strExpected + stringsObjectInfo.getColorSelectorCursor());
                    System.out.println("Cursor" + strFailed + myDynamicElement.getCssValue("cursor") + strExpected + stringsObjectInfo.getColorSelectorCursor());
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
		
}

    //Verify CSS properties for Accordian
    public boolean verifyCssObjectProperties(By byWebElement, CssAccordionData stringsObjectInfo){

        try {
        	
            WebElement myDynamicElement = (new WebDriverWait(driver, 10))
            		.until(ExpectedConditions.presenceOfElementLocated(byWebElement));

            System.out.println();
            System.out.println(stringsObjectInfo.getCssObjectName());

            if (stringsObjectInfo.getFontFamily() != null) {
                if (myDynamicElement.getCssValue("font-family").contentEquals(stringsObjectInfo.getFontFamily())) {
                    System.out.println("Font-Family" + strPassed + myDynamicElement.getCssValue("font-family") + strExpected + stringsObjectInfo.getFontFamily());
                    HtmlLogUtil.writeToLog(0, stringsObjectInfo.getCssObjectName() + ": Font-Family" + strPassed + myDynamicElement.getCssValue("font-family") + strExpected + stringsObjectInfo.getFontFamily(),false);
                } else {
                    System.out.println("Font-Family" + strFailed + myDynamicElement.getCssValue("font-family") + strExpected + stringsObjectInfo.getFontFamily());
                    HtmlLogUtil.writeToLog(1, stringsObjectInfo.getCssObjectName() + ": Font-Family" + strFailed + myDynamicElement.getCssValue("font-family") + strExpected + stringsObjectInfo.getFontFamily(),false);
                }
            }
            if (stringsObjectInfo.getFontSize() != null) {
                if (myDynamicElement.getCssValue("font-size").contentEquals(stringsObjectInfo.getFontSize())) {
                    System.out.println("Font-Size" + strPassed + myDynamicElement.getCssValue("font-size") + strExpected + stringsObjectInfo.getFontSize());
                    HtmlLogUtil.writeToLog(0,stringsObjectInfo.getCssObjectName() + ": Font-Size" + strPassed + myDynamicElement.getCssValue("font-size") + strExpected + stringsObjectInfo.getFontSize());
                } else {
                    System.out.println("Font-Size" + strFailed + myDynamicElement.getCssValue("font-size") + strExpected + stringsObjectInfo.getFontSize());
                    HtmlLogUtil.writeToLog(1,stringsObjectInfo.getCssObjectName() + ": Font-Size" + strFailed + myDynamicElement.getCssValue("font-size") + strExpected + stringsObjectInfo.getFontSize());
                }
            }
            if (stringsObjectInfo.getBorderStyle() != null) {
                if (myDynamicElement.getCssValue("border-top-style").contentEquals(stringsObjectInfo.getBorderStyle())) {
                    System.out.println("Border-Style" + strPassed + myDynamicElement.getCssValue("border-top-style") + strExpected + stringsObjectInfo.getBorderStyle());
                    HtmlLogUtil.writeToLog(0,stringsObjectInfo.getCssObjectName() + ": Border-Style" + strPassed + myDynamicElement.getCssValue("border-top-style") + strExpected + stringsObjectInfo.getBorderStyle());
                } else {
                    System.out.println("Border-Style" + strFailed + myDynamicElement.getCssValue("border-top-style") + strExpected + stringsObjectInfo.getBorderStyle());
                    HtmlLogUtil.writeToLog(1,stringsObjectInfo.getCssObjectName() + ": Border-Style" + strFailed + myDynamicElement.getCssValue("border-top-style") + strExpected + stringsObjectInfo.getBorderStyle());
                }
            }
            if (stringsObjectInfo.getPadding() != null) {
                if (myDynamicElement.getCssValue("padding-right").contentEquals(stringsObjectInfo.getPadding())) {
                    HtmlLogUtil.writeToLog(0,stringsObjectInfo.getCssObjectName() + ": Padding-Right" + strPassed + myDynamicElement.getCssValue("padding-right") + strExpected + stringsObjectInfo.getPadding());
                    System.out.println("Padding-Right" + strPassed + myDynamicElement.getCssValue("padding-right") + strExpected + stringsObjectInfo.getPadding());
                } else {
                    HtmlLogUtil.writeToLog(1,stringsObjectInfo.getCssObjectName() + ": Padding-Right" + strFailed + myDynamicElement.getCssValue("padding-right") + strExpected + stringsObjectInfo.getPadding());
                    System.out.println("Padding-Right" + strFailed + myDynamicElement.getCssValue("padding-right") + strExpected + stringsObjectInfo.getPadding());
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
