package com.tutorialsninja.qa.Step_Definitions;

import com.tutorialsninja.qa.Utilities.Util;
import com.tutorialsninja.qa.driver_Factory.DriverFactory_Code;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.util.Map;

public class Register {

    public WebDriver driver;

    @Given("User navigates to Register page")
    public void user_navigates_to_register_page() {
        driver = DriverFactory_Code.getDriver();
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.linkText("Register")).click();
    }
    @When("User enters below mandatory fields")
    public void user_enters_below_mandatory_fields(io.cucumber.datatable.DataTable dataTable) {
      Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstname"));
        driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastname"));
        driver.findElement(By.id("input-email")).sendKeys(Util.emailWithDateTimeStamp());
        driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
        driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
        driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("confirmpassword"));
    }

    @When("User enters below all fields")
    public void user_enters_below_all_fields(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstname"));
        driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastname"));
        driver.findElement(By.id("input-email")).sendKeys(Util.emailWithDateTimeStamp());
        driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
        driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
        driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("confirmpassword"));
    }

    @When("User enters below all fields with existing email")
    public void user_enters_below_all_fields_with_existing_email(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstname"));
        driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastname"));
        driver.findElement(By.id("input-email")).sendKeys(dataMap.get("email"));
        driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
        driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
        driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("confirmpassword"));
    }

    @And("User selects Yes for Newsletter")
    public void user_selects_yes_for_newsletter(){
        driver.findElement(By.xpath("//input[@name = 'newsletter' and @value = '1']")).click();
    }
    @When("User selects Privacy Policy checkbox")
    public void user_selects_privacy_policy_checkbox() {
        driver.findElement(By.xpath("//input[@name = 'agree' and @value = '1']")).click();

    }
    @And("User clicks on Continue button")
    public void user_clicks_on_continue_button() {
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
    }
    @Then("User account gets created successfully")
    public void user_account_gets_created_successfully() {
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(), 'Congratulations! Your new account has been successfully created!')]")).isDisplayed());

    }

    @Then("User gets warning message of duplicate email")
    public void user_gets_warning_message_of_duplicate_email(){
        String actualWarning = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText();
        String expectedWarning = "Warning: E-Mail Address is already registered!";
        Assert.assertTrue(actualWarning.contains(expectedWarning));
    }

    @Then("User gets warning message for every mandatory field")
    public void user_gets_warning_message_for_every_mandatory_field(){
        //Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText().contains("Warning:You must agree to the Privacy Policy!"));
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(), 'First Name must be between 1 and 32 characters!')]")).getText().contains("First Name must be between 1 and 32 characters!"));
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(), 'Last Name must be between 1 and 32 characters!')]")).getText().contains("Last Name must be between 1 and 32 characters!"));
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(), 'E-Mail Address does not appear to be valid!')]")).getText().contains("E-Mail Address does not appear to be valid!"));
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(), 'Telephone must be between 3 and 32 characters!')]")).getText().contains("Telephone must be between 3 and 32 characters!"));
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(), 'Password must be between 4 and 20 characters!')]")).getText().contains("Password must be between 4 and 20 characters!"));

    }
}
