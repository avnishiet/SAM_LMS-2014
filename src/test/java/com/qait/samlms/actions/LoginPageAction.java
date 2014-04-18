package com.qait.samlms.actions;

import org.openqa.selenium.WebDriver;
import com.qait.samlms.ui.pageobjects.LoginPageUi;

/**
 * class for login page actions
 * 
 * @author avnishrawat
 * 
 */
public class LoginPageAction extends LoginPageUi {
	HomePageAction homePageAction;

	/**
	 * construstor for login page action
	 * 
	 * @param driver
	 */
	public LoginPageAction(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	/**
	 * verifies SAM login page
	 * 
	 * @return
	 */
	public boolean verifyLoginPage() {
		if (getLoginPage().isDisplayed())
			return true;
		return false;
	}

	/**
	 * enter user name and password in to the application
	 * 
	 * @param username
	 * @param password
	 */
	public boolean enterCredentialsInToApplication(String username,
			String password) {
		enterText(getUserNameField(), username);
		enterText(getPasswordField(), password);
		clickLoginButton();
		handleAlert();
		return verifyPageTitle("SAM - Home");
	}

	/**
	 * type user name in text box
	 * 
	 * @param value
	 */
	public void typeUserName(String value) {
		getUserNameField().clear();
		getUserNameField().sendKeys(value);

	}

	/**
	 * type password in text box
	 * 
	 * @param value
	 */
	public void typePassword(String value) {
		getPasswordField().clear();
		getPasswordField().sendKeys(value);
	}

	/**
	 * click on button and verify the navigation page
	 * 
	 * @param element
	 * @return
	 */
	public void clickLoginButton() {
		getLoginButton().click();

	}

	/**
	 * log out from application
	 */
	public void clickLogOutButton() {
		System.out.println(getLogOutButton().getText());
		getLogOutButton().click();

	}

	/**
	 * agree user eula and verify sam secret question page
	 */
	public boolean clickIAgreeButton() {
		getIAgreeButton().click();
		if (verifyPageTitle("SAM Prompt Secret Question"))
			return true;
		return false;
	}

	/**
	 * select secret question for user
	 * 
	 * @param value
	 */
	public boolean selectSecretQuestion(String value) {
		return getSelectedDropdownValue(value);
	}

	/**
	 * type secret answer for user
	 * 
	 * @param value
	 */
	public void typeSecretAnswer(String value) {
		enterText(getSecretAnswerField(), value);
	}

	/**
	 * enter new password for user
	 * 
	 * @param value
	 */
	public void typeNewPassword(String value) {
		enterText(getNewPasswordField(), value);
	}

	/**
	 * enter comfirm password
	 * 
	 * @param value
	 */
	public void typeConfirmPassword(String value) {
		enterText(getConfirmPasswordField(), value);
	}

}
