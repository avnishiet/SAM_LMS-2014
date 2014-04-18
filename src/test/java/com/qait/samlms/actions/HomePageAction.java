package com.qait.samlms.actions;

import org.openqa.selenium.WebDriver;

import com.qait.samlms.ui.pageobjects.HomePageUi;

public class HomePageAction extends HomePageUi {

	public HomePageAction(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
/**
 * verifies tab name in instructor home page tabs.
 * @param tabName
 * @return
 */
	public boolean verifyTabButton(String tabName){
		return getTabButton(tabName).getText().equalsIgnoreCase(tabName);
	}
	
	
	/**
	 * click on tab button in home page
	 * 
	 * @param tabName
	 * @return
	 */
	public boolean clickTabButton(String tabName) {
		try {
			getTabButton(tabName).click();
			Thread.sleep(5000);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * verifies home page is displayed
	 * 
	 * @return
	 */
	public boolean verifyHomePageIsDisplayed(String tabName) {
		if (getTabButton(tabName).getText().equalsIgnoreCase("Home"))
			return true;
		return false;
	}

}
