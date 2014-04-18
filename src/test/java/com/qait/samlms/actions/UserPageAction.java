package com.qait.samlms.actions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.qait.samlms.ui.pageobjects.UserPageUi;
import com.qait.samlms.util.PropFileHandler;

/**
 * 
 * @author avnishrawat
 *
 */
public class UserPageAction extends UserPageUi {
	public UserPageAction(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	/**
	 * click on add new button in home page
	 * 
	 * @return
	 */
	public boolean clickAddNewButton() {
		try {
			getAddNewButton().click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * enter user first name while creating
	 * 
	 * @param value
	 */
	public void typeUserFirstName(String value) {
		enterText(getUserFirstName(), value);
	}

	/**
	 * enter user last name while creating
	 * 
	 * @param value
	 */
	public void typeUserLastName(String value) {
		enterText(getUserLastName(), value);
	}

	/**
	 * select user role while creating
	 * 
	 * @param value
	 */
	public void selectUserRole(String value) {
		getSelectedDropdownValue(value);
	}

	/**
	 * enter user password while creating
	 * 
	 * @param password
	 */
	public void typeUserPassword(String password) {
		enterText(getUserPassword(), password);
	}

	/**
	 * enter verified user password while creating
	 * 
	 * @param value
	 */
	public void typeVerifyUserPassword(String value) {
		enterText(getVerifyUserPassword(), value);
	}

	/**
	 * click on save button after user creation
	 * 
	 * @return
	 */
	public boolean clickSaveButton() {
		getSaveButton().click();
		if (verifyPageTitle("SAM - Users"))
			return true;
		return false;
	}

	/**
	 * type user name to search the user name is created
	 * 
	 * @param value
	 */
	public void typeUserToSearch(String value) {
		enterText(getSearchField(), value);
	}

	/**
	 * click on user Name radio button
	 */
	public void clickUserNameRadioButton() {
		selectRadioButton(getUserNameRadio());
	}

	/**
	 * click on search button to search user
	 */
	public boolean clickSearchButton() {
		try {
			getSearchButton().click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * verifies user is created or not
	 * 
	 * @param value
	 * @return
	 */
	public boolean verifyUser(String value) {
		String user = PropFileHandler.readProperty(value);
		if (getVerifyUser().getText().equalsIgnoreCase(user)) {
			return true;
		}
		return false;
	}

	/**
	 * enter user email while creating a user
	 * 
	 * @param user
	 * @return
	 */
	public boolean typeUserNameEmail(String user) {
		String userName = user.substring(0, user.indexOf('U')) + "User";
		System.out.println("username::" + userName);
		user = user + System.currentTimeMillis() + "@go.com";
		enterText(getAdminUserNameEmail(), user);
		try {
			PropFileHandler.writeToFile(userName, user);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * click on section tab in user page while creating a user and enrol in to
	 * section.
	 * 
	 * @return
	 */
	public boolean clickOnSectionTabInUserPage() {
		try {
			getSectionTabInUserPage().click();
			return getAllSectionTextInSectionTab().isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * select section name to enrol user.
	 * @param sectionName
	 * @return
	 */
	public boolean selectSectionToEnrolUser(String sectionName){
		try{
			getSelectSectionNameForEnrolUser(sectionName).click();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	
}
