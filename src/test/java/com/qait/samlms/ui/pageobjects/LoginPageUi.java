package com.qait.samlms.ui.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageUi extends BasePage {

	public LoginPageUi(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub

	}

	@FindBy(xpath = "//div[@id='pageHeaderContainerDiv']")
	public WebElement loginPageSAM;

	@FindBy(xpath = "//input[@id='ctl00__mainConentPlaceholder_tbUserName']")
	public WebElement inp_username;

	@FindBy(xpath = "//input[@id='ctl00__mainConentPlaceholder_tbPassword']")
	public WebElement inp_password;

	@FindBy(xpath = "//input[@id='ctl00__mainConentPlaceholder_btnLogin']")
	public WebElement btn_logins;

	@FindBy(xpath = "//a[text()='Logout']")
	public WebElement btn_logOut;

	@FindBy(xpath = "//input[@title='I Agree']")
	public WebElement btn_IAgree;

	@FindBy(xpath = "//input[@id='ctl00__mainConentPlaceholder_tbAnswer']")
	public WebElement inp_secretAnswer;

	@FindBy(xpath = "//option[text()='index']")
	public WebElement inp_secretQuestion;

	@FindBy(xpath = "//select[@id='ctl00__mainConentPlaceholder_ddlQuestions']")
	public WebElement inp_selectsecretQuestion;

	@FindBy(xpath = "//input[@id='ctl00__mainConentPlaceholder_tbNewPassword']")
	public WebElement inp_newPassword;

	@FindBy(xpath = "//input[@id='ctl00__mainConentPlaceholder_tbConfirmPassword']")
	public WebElement inp_confirmPassword;

	public WebElement getUserNameField() {
		return waitForElementToBePresent(inp_username);
	}

	public WebElement getPasswordField() {
		return waitForElementToBePresent(inp_password);
	}

	public WebElement getLoginButton() {
		return waitForElementToBePresent(btn_logins);
	}

	public WebElement getIAgreeButton() {
		return waitForElementToBePresent(btn_IAgree);
	}

	public WebElement getLogOutButton() {
		return waitForElementToBePresent(btn_logOut);
	}

	public WebElement getLoginPage() {
		return waitForElementToBePresent(loginPageSAM);
	}

	public WebElement getSecretquestionField() {
		return waitForElementToBePresent(inp_secretQuestion);
	}

	public WebElement getSecretAnswerField() {
		return waitForElementToBePresent(inp_secretAnswer);
	}

	public WebElement getSelectsecretQuestionField() {
		return waitForElementToBePresent(inp_selectsecretQuestion);
	}

	public WebElement getNewPasswordField() {
		return waitForElementToBePresent(inp_newPassword);
	}

	public WebElement getConfirmPasswordField() {
		return waitForElementToBePresent(inp_confirmPassword);
	}

}