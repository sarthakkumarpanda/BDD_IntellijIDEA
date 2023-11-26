package com.tutorialsninja.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	public WebDriver driver;
	
	@FindBy(id = "input-firstname")
	private WebElement firstnameTextBox;
	
	@FindBy(id = "input-lastname")
	private WebElement lastnameTextBox;
	
	@FindBy(id = "input-email")
	private WebElement emailTextBox;
	
	@FindBy(id = "input-telephone")
	private WebElement telephoneTextBox;
	
	@FindBy(id = "input-password")
	private WebElement passwordTextBox;
	
	@FindBy(id = "input-confirm")
	private WebElement confirmPasswordTextBox;
	
	@FindBy(xpath = "//input[@name = 'newsletter' and @value = '1']")
	private WebElement newsletterRadioYesButton;
	
	@FindBy(xpath = "//input[@name = 'agree' and @value = '1']")
	private WebElement privacyPolicyCheckbox;
	
	@FindBy(css = "input.btn.btn-primary")
	private WebElement continueButton;
	
	@FindBy(xpath = "//div[contains(@class, 'alert-dismissible')]")
	private WebElement duplicateEmailWarningMessage;
	
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterFirstName(String firstNameText) {
		firstnameTextBox.sendKeys(firstNameText);
	}
	
	public void enterLastName(String lastNameText) {
		lastnameTextBox.sendKeys(lastNameText);
	}
	
	public void enterEmail(String emailText) {
		emailTextBox.sendKeys(emailText);
	}
	
	public void enterTelephone(String telephoneText) {
		telephoneTextBox.sendKeys(telephoneText);
	}
	
	public void enterPassword(String passwordText) {
		passwordTextBox.sendKeys(passwordText);
	}
	
	public void enterConfirmPassword(String confirmPasswordText) {
		confirmPasswordTextBox.sendKeys(confirmPasswordText);
	}
	
	public void selectNewsLetterRadioButton() {
		newsletterRadioYesButton.click();	
	}
	
	public void selectPrivacyPolicyCheckBox() {
		privacyPolicyCheckbox.click();	
	}
	
	public void clickContinueButton() {
		continueButton.click();	
	}
	
	public String retrieveDuplicateEmailWarningText() {
		String dEmailMessage = duplicateEmailWarningMessage.getText();
		return dEmailMessage;
	}
}
