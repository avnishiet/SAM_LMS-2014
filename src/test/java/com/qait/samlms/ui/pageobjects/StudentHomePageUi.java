package com.qait.samlms.ui.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StudentHomePageUi extends BasePage{

	public StudentHomePageUi(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//a[text()='Help']")
	WebElement link_help;
	
	@FindBy(xpath = "//a[text()='Online Help']")
	WebElement link_onlineHelp;
	
	@FindBy(xpath = "//a[@name='_GoBack']/parent::*")
	WebElement txt_samStudentUserManual;
	
	@FindBy(xpath = "//a[text()='My Account']")
	WebElement link_myAccount;
	
	@FindBy(xpath = "//button[text()='Edit']")
	WebElement btn_edit;
	
	@FindBy(xpath = "//h3[text()='My Account Details']")
	WebElement txt_myAccountHeading;
	
	@FindBy(xpath = "//button[text()='Save']")
	WebElement btn_myAccountSave;
	
	
	
	
	
	public WebElement getHelpLink(){
		return waitForElementToBePresent(link_help);
	}
	
	public WebElement getOnlineHelpLink(){
		return waitForElementToBePresent(link_onlineHelp);
	}
	
	public WebElement getTitleForOnlineHelpLink(){
		return waitForElementToBePresent(txt_samStudentUserManual);
	}
	
	public WebElement getMyAccountLink(){
		return waitForElementToBePresent(link_myAccount);
	}
	
	public WebElement getEditButton(){
		return waitForElementToBePresent(btn_edit);
	}
	
	public WebElement getMyAccountHeading(){
		return waitForElementToBePresent(txt_myAccountHeading);
	}
	
	public WebElement getMyAccountDetails(String middleInitial){
		return waitForElementToBePresent(driver.findElement(By.xpath("//label[contains(text(),'"+middleInitial+"')]/following-sibling::input[1]")));
	}
	
	public WebElement getMyAccountSave(){
		return waitForElementToBePresent(btn_myAccountSave);
	}
	
	public WebElement getSelectTab(String tabName) {
		String tab = "//a[text()='" + tabName + "']";
		return waitForElementToBePresent(driver.findElement(By
				.xpath(tab)));
	}
	
}
