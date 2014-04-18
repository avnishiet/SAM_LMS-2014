package com.qait.samlms.ui.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserPageUi extends BasePage {

	public UserPageUi(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@title='Add New']")
	public WebElement btn_addNew;

	@FindBy(id = "ctl00_ContentPlaceHolder1_FirstNameTextBox")
	public WebElement inp_userFirstName;

	@FindBy(id = "ctl00_ContentPlaceHolder1_LastNameTextBox")
	public WebElement inp_userlastName;

	@FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_UserNameTextBox']")
	public WebElement inp_adminUserNameEmail;

	@FindBy(id = "ctl00_ContentPlaceHolder1_PasswordTextBox")
	public WebElement inp_userPassword;

	@FindBy(id = "ctl00_ContentPlaceHolder1_VerPasswordTextBox")
	public WebElement inp_verifyUserPassword;

	@FindBy(xpath = "//input[@title='Save']")
	public WebElement inp_saveButton;

	@FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_txtSearch']")
	public WebElement inp_search;

	@FindBy(xpath = "//label[text()='UserName']/preceding-sibling::input")
	public WebElement rd_userName;

	@FindBy(xpath = "//input[@title='Search Users']")
	public WebElement btn_search;

	@FindBy(xpath = "//tr[@class='GridViewItem']/td")
	public WebElement table_td;

	@FindBy(xpath = "//table[@id='ctl00_ContentPlaceHolder1_tabStrip_1']//td")
	public WebElement tab_sectionTabInUserPage;
	
	@FindBy(xpath = "//span[text()='All Sections']")
	public WebElement txt_allSectionInSectionTab;
	
	
	public WebElement getAddNewButton() {
		return waitForElementToBePresent(btn_addNew);
	}

	public WebElement getUserFirstName() {
		return waitForElementToBePresent(inp_userFirstName);
	}

	public WebElement getUserLastName() {
		return waitForElementToBePresent(inp_userlastName);
	}

	public WebElement getAdminUserNameEmail() {
		return waitForElementToBePresent(inp_adminUserNameEmail);
	}

	public WebElement getUserPassword() {
		return waitForElementToBePresent(inp_userPassword);
	}

	public WebElement getVerifyUserPassword() {
		return waitForElementToBePresent(inp_verifyUserPassword);
	}

	public WebElement getSaveButton() {
		return waitForElementToBePresent(inp_saveButton);
	}

	public WebElement getSearchField() {
		return waitForElementToBePresent(inp_search);
	}

	public WebElement getUserNameRadio() {
		return waitForElementToBePresent(rd_userName);
	}

	public WebElement getSearchButton() {
		return waitForElementToBePresent(btn_search);
	}

	public WebElement getVerifyUser() {
		return waitForElementToBePresent(table_td);
	}

	public WebElement getSectionTabInUserPage() {
		return waitForElementToBePresent(tab_sectionTabInUserPage);
	}
	
	public WebElement getAllSectionTextInSectionTab() {
		return waitForElementToBePresent(txt_allSectionInSectionTab);
	}
	
	public WebElement getSelectSectionNameForEnrolUser(String sectionName) {
		return waitForElementToBePresent(driver.findElement(By.xpath("//select/option[contains(text(),'"+sectionName+"')]")));
	}
	
	
	
	
}
