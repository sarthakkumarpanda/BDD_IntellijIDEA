package com.tutorialsninja.qa.Hooks;

import com.tutorialsninja.qa.Utilities.Util;
import com.tutorialsninja.qa.driver_Factory.DriverFactory_Code;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class MyHooks {
    public WebDriver driver;

    @Before
    public void setup(){
        DriverFactory_Code.initializeBrowser("chrome");
        driver = DriverFactory_Code.getDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Util.IMPLICIT_WAIT_TIME));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Util.PAGE_LOAD_TIME));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Util.SCRIPT_TIME));
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo");


    }

    @After
    public void tearDown(){

        driver.quit();
    }


}
