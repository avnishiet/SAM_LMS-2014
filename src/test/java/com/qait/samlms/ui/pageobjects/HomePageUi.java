package com.qait.samlms.ui.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageUi extends BasePage{
	
	public HomePageUi(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	String homePageTabXpath="//a[text()='index']";
	public WebElement getTabButton(String tabName) {
		
		//homePageTabXpath.replaceAll("index", "Users");
		return waitForElementToBePresent(driver.findElement(By.xpath("//a[text()='"+tabName+"']")));
	//	return waitForElementToBePresent(driver.findElement(By.xpath(homePageTabXpath.replaceAll("index", tabName))));
		
	}
	
	
	

	

	
	
	
}
