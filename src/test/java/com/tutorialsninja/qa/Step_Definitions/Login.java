package com.tutorialsninja.qa.Step_Definitions;

import com.tutorialsninja.qa.Utilities.Util;
import com.tutorialsninja.qa.driver_Factory.DriverFactory_Code;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.time.Duration;

public class Login {
    public WebDriver driver;

    @Given("User navigates to login page")
    public void user_navigates_to_login_page() {
        driver = DriverFactory_Code.getDriver();
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.linkText("Login")).click();
    }

    @When("User enters valid email {string}")
    public void user_enters_valid_email(String emailText) {
        driver.findElement(By.id("input-email")).sendKeys(emailText);
    }

    @And("User enters valid password {string}")
    public void user_enters_valid_password(String passwordText) {
        driver.findElement(By.id("input-password")).sendKeys(passwordText);
    }

    @When("User enters invalid email")
    public void user_enters_invalid_email(){
        driver.findElement(By.id("input-email")).sendKeys(Util.emailWithDateTimeStamp());
    }

    @Then("User gets warning message about credentials mismatch")
    public void user_gets_warning_message_about_credentials_mismatch(){
     String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText();
     String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
        Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
    }

    @And("User enters invalid password {string}")
    public void user_enters_invalid_password(String invalidPasswordText){
        driver.findElement(By.id("input-password")).sendKeys(invalidPasswordText);
    }


    @And("User clicks on Login button")
    public void user_clicks_on_login_button() {
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
    }

    @Then("User is redirected to Account Page")
    public void user_is_redirected_to_account_page() {
        Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
    }


}

