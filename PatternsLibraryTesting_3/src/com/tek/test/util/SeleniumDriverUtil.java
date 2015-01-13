package com.tek.test.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

/**
 * Created by bs211w on 7/7/2014.
 */
public class SeleniumDriverUtil {
    public WebDriver driver;

    //Constructor
    public WebDriver loadSeleniumDriver(String browserType) throws Exception{
    	
    	try{

        if (browserType.contentEquals("FireFox")){
            FirefoxProfile fp = new FirefoxProfile();
            fp.setEnableNativeEvents(true);
            driver = new FirefoxDriver(fp);
            assert driver != null;
        }
        else if (browserType.contentEquals("InternetExplorer")){
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            File file = new File("src/Resources/IEDriverServer.exe");
            System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
            driver = new InternetExplorerDriver(capabilities);
            assert driver != null;
        }
        else if (browserType.contentEquals("Chrome")){
            File file = new File("src/Resources/chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
            driver = new ChromeDriver();
            assert driver != null;
        }
        else{
            FirefoxProfile fp = new FirefoxProfile();
            fp.setEnableNativeEvents(true);
            driver = new FirefoxDriver();
            assert driver != null;
        }
    	}
    	catch(Exception e){
    		e.printStackTrace();
    		throw e;
    	}
        return driver;
    }

    //Kills the IE Driver
    public void killDriver(String browserType) {
        final String KILL = "taskkill /F /IM ";
        if (browserType == "FireFox") {
            try {
                driver.close();
                Runtime.getRuntime().exec(KILL + "firefox.exe");
                System.out.println("Driver Closed");
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        else {
            try {
                Runtime.getRuntime().exec(KILL + "iexplore.exe");
                Runtime.getRuntime().exec(KILL + "IEDriverServer.exe");
            } catch (Exception e) {
                System.out.println(e);
                //throw e;
            }
        }
    }
    
    public void triggerAutoit(String browserType){
	    //Only on windows operating system
    	try{
		    if (browserType.contentEquals("FireFox")){
		    	Runtime.getRuntime().exec("C:\\Users\\bs211w\\Desktop\\PatternsTesting\\AutoIt\\Patterns.exe");
	        }
	        else if (browserType.contentEquals("InternetExplorer")){
	        	Runtime.getRuntime().exec("C:\\Users\\bs211w\\Desktop\\PatternsTesting\\AutoIt\\Patterns.exe");
	        }
	        else if (browserType.contentEquals("Chrome")){
	        	Runtime.getRuntime().exec("C:\\Users\\bs211w\\Desktop\\PatternsTesting\\AutoIt\\PatternsChrome.exe");
	        }
    	}
        catch(Exception e){
        	e.printStackTrace();
        }
    }
}
