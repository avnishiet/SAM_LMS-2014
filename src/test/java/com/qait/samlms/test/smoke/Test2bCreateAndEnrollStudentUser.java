package com.qait.samlms.test.smoke;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qait.samlms.automation.TestSessionInitiator;

public class Test2bCreateAndEnrollStudentUser extends BaseTest{
	TestSessionInitiator test;

	@BeforeClass
	public void setUpClass() {
		test = new TestSessionInitiator("resources\\testdata\\TestData.yml");
		test.launchApplication(baseUrl);
	}

	@Test
	public void loginInApplication() {
		test.logPageAct.verifyLoginPage();
		test.logPageAct.enterCredentialsInToApplication(
				instructorUser,
				password);
		test.logPageAct.handleAlert();
		test.logPageAct.verifyPageTitle("SAM - Home");
	}
	
	@Test(dependsOnMethods = "loginInApplication")
	public void createAndEnrollUser() {
		test.homePageAction.clickTabButton("Users");
		test.userPageAction.waitForSpinnerToDisappear();
		test.userPageAction.switchToFrame("inst-frame");
		test.userPageAction.clickAddNewButton();
		test.userPageAction.typeUserFirstName(firstName);
		test.userPageAction.typeUserLastName(lastName);
		test.userPageAction
				.selectUserRole(studentRole);
		test.userPageAction.typeUserNameEmail("studentUser");
		test.userPageAction.typeUserPassword(password);
		test.userPageAction.typeVerifyUserPassword(password);
		test.userPageAction.clickSaveButton();
	}

	@Test(dependsOnMethods = "createAndEnrollUser")
	public void verifyStudentUser() {
		test.userPageAction.typeUserToSearch(studentUser);
		test.userPageAction.clickUserNameRadioButton();
		test.userPageAction.clickSearchButton();
		test.userPageAction.verifyUser(studentUser);
	}

	@AfterTest
	public void logOut() {
		test.logPageAct.switchToDefaultContent();
		test.logPageAct.clickLogOutButton();
		test.closeBrowserSession();
	}
}
