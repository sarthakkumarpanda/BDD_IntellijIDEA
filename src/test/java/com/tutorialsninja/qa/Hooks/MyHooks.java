package com.tutorialsninja.qa.Hooks;

import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import com.tutorialsninja.qa.Utilities.ConfigReader;
import com.tutorialsninja.qa.Utilities.Util;
import com.tutorialsninja.qa.driver_Factory.DriverFactory_Code;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class MyHooks {
    public WebDriver driver;
    

    @Before
    public void setup() throws Exception{
    	Properties prop = ConfigReader.initializePropertiesFile();
        DriverFactory_Code.initializeBrowser(prop.getProperty("browser"));
        driver = DriverFactory_Code.getDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Util.IMPLICIT_WAIT_TIME));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Util.PAGE_LOAD_TIME));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Util.SCRIPT_TIME));
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));


    }

    @After
    public void tearDown(){

        driver.quit();
    }


}
