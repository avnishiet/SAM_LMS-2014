package com.qait.samlms.actions;

import org.openqa.selenium.WebDriver;
import com.qait.samlms.ui.pageobjects.StudentHomePageUi;

public class StudentHomePageAction extends StudentHomePageUi {

	public StudentHomePageAction(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	/**
	 * click on help link in home page
	 * 
	 * @return
	 */
	public boolean clickOnHelpLink() {
		try {
			getHelpLink().click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * verifies help link availability in student home page
	 * 
	 * @param help
	 * @return
	 */
	public boolean verifyHelpLinkAvailable(String help) {
		return getHelpLink().getText().equalsIgnoreCase(help);
	}

	/**
	 * click on Online help link in help link
	 * 
	 * @return
	 */
	public boolean clickOnOnlineHelpLink() {
		try {
			getOnlineHelpLink().click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * verify help launch for text ie. SAM and close the browser window
	 * 
	 * @param text
	 * @return
	 */
	public boolean verifyHelpLaunchForText(String text) {
		try {
			if (getTitleForOnlineHelpLink().getText().contains(text)) {
				closeDriver();
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * click on My Account link in student home page
	 * 
	 * @return
	 */
	public boolean clickOnMyAccountLink() {
		try {
			getMyAccountLink().click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean clickOnEditInMyAccountLink() {
		getEditButton().click();
		return getMyAccountHeading().getText().equalsIgnoreCase(
				"My Account Details");
	}

	/**
	 * verify middle initial is not editable by student user in My Account link
	 * 
	 * @param middleInitial
	 * @return
	 */
	public boolean verifyMyAccountMiddleNameIsNotEditable(String middleInitial) {
		return !getMyAccountDetails(middleInitial).isEnabled();
	}

	/**
	 * verify user name is not editable by student user in My Account link
	 * 
	 * @param userName
	 * @return
	 */
	public boolean verifyMyAccountUserNameIsNotEditable(String userName) {
		return !getMyAccountDetails(userName).isEnabled();
	}

	/**
	 * click on save button in My Account link
	 * 
	 * @return
	 */
	public boolean clickOnSaveButton() {
		try {
			getMyAccountSave().click();
			return verifyPageTitle("SAM - Activity Calendar");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * select tab in student home page
	 * 
	 * @param tabName
	 * @return
	 */
	public boolean selectTab(String tabName) {
		try {
			getSelectTab(tabName).click();
			if (tabName.equalsIgnoreCase("Sections"))
				return verifyPageTitle("SAM - Section List");
			else if(tabName.equalsIgnoreCase("Reports"))
				return verifyPageTitle("SAM - Activity Results");
				return verifyPageTitle("SAM - Activity Calendar");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}