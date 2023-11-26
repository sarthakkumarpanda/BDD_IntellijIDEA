package com.tutorialsninja.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
	
	@FindBy(id = "input-email")
	private WebElement emailTextboxField;
	
	@FindBy(id = "input-password")
	private WebElement passwordTextboxField;
	
	@FindBy(css = "input.btn.btn-primary")
	private WebElement loginButton;
	
	@FindBy(xpath = "//div[contains(@class, 'alert-dismissible')]")
	private WebElement warningMessage;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmail(String emailText) {
		emailTextboxField.sendKeys(emailText);
	}
	
	public void enterPassword(String passwordText) {
		passwordTextboxField.sendKeys(passwordText);
	}
	
	public AccountPage clickOnLoginButton() {
		loginButton.click();
		return new AccountPage(driver);
	
	}
	
	public String retrieveWarningMessageText() {
		String wMessage = warningMessage.getText();
		return wMessage;
	}


}
