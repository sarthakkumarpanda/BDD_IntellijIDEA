package com.tutorialsninja.qa.driver_Factory;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory_Code {

    public static WebDriver driver;
    public static ChromeOptions options;

    public static void initializeBrowser(String browserName){
        if(browserName.equals("chrome")){
        	options = new ChromeOptions();
        	options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        	options.addArguments("--start-maximized");
        	options.addArguments("--incognito");
            driver = new ChromeDriver(options);
        }else if(browserName.equals("firefox")){
            driver = new FirefoxDriver();
        }else if(browserName.equals("edge")){
            driver = new EdgeDriver();
        }
    }

    public static WebDriver getDriver(){

        return driver;
    }


}
