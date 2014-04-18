package com.qait.samlms.test.SamStudentDropBoxFlow.basicFlow;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qait.samlms.automation.TestSessionInitiator;
import com.qait.samlms.test.smoke.BaseTest;

public class Test1bAdminCreatesInstructor extends BaseTest{

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
				adminUser,
				password);
		test.logPageAct.verifyPageTitle("SAM - Home");
	}

	@Test(dependsOnMethods = "loginInApplication")
	public void createAndEnrollUser() {
		test.homePageAction.clickTabButton("Users");
		test.userPageAction.switchToFrame("inst-frame");
		//test.userPageAction.waitForSpinnerToDisappear();
		test.userPageAction.clickAddNewButton();
		test.userPageAction.typeUserFirstName(firstName);
		test.userPageAction.typeUserLastName(lastName);
		test.userPageAction
				.selectUserRole(instructorRole);
		test.userPageAction.typeUserNameEmail("instructorUser");
		test.userPageAction.typeUserPassword(password);
		test.userPageAction
				.typeVerifyUserPassword(password);
		test.userPageAction.clickSaveButton();

	}

	@Test(dependsOnMethods = "createAndEnrollUser")
	public void verifyInstructorUser() {

		test.userPageAction.typeUserToSearch(instructorUser);
		test.userPageAction.clickUserNameRadioButton();
		test.userPageAction.clickSearchButton();
		test.userPageAction.verifyUser(instructorUser);
	}

	@AfterTest
	public void logOut() {
		test.logPageAct.switchToDefaultContent();
		test.logPageAct.clickLogOutButton();
		test.closeBrowserSession();
	}

}
