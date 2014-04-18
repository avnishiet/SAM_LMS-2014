package com.qait.samlms.ui.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReadingActivityPageUi extends BasePage{

	public ReadingActivityPageUi(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	@FindBy(xpath = "//p[contains(text(),'Microsoft® Office® 2010 - Illustrated First Course, Introductory')]")
	WebElement txt_eBookTitleInmindtap;
	
	public WebElement getEBookTitleInMindTap(){
		return waitForElementToBePresent(txt_eBookTitleInmindtap);
	}
}
