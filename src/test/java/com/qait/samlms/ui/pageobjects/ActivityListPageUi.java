package com.qait.samlms.ui.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qait.samlms.util.PropFileHandler;

public class ActivityListPageUi extends BasePage {

	public ActivityListPageUi(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//button[text()='Start']")
	WebElement btn_start;
	
	
	public WebElement getSetOnFilterButton(String tabName) {
		System.out.println("tab name in ui "+tabName);
		String tabsInActivityList = "//li[text()='"+tabName+"']";
		return waitForElementToBePresent(driver.findElement(By
				.xpath(tabsInActivityList)));

	}

	public WebElement getAlwaysAvailableTab() {
		return waitForElementToBePresent(driver.findElement(By
				.xpath("//li/a[text()='Always Available']")));
	}

	public WebElement getSelectAssignment(String assignmentName) {
		String assignmentname=PropFileHandler.readProperty(assignmentName);
		String xpath="//a[text()='"+assignmentname+"']";
		return waitForElementToBePresent(driver.findElement(By.xpath(xpath)));
	}
	
	public WebElement getAssignmentStratButton() {
		return waitForElementToBePresent(btn_start);
	}
	
}
