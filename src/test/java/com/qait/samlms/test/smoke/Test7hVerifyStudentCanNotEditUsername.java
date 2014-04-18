package com.qait.samlms.test.smoke;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qait.samlms.automation.TestSessionInitiator;

public class Test7hVerifyStudentCanNotEditUsername extends BaseTest {
	TestSessionInitiator test;

	@BeforeClass
	public void setUpClass() {
		test = new TestSessionInitiator("resources\\testdata\\TestData.yml");
		test.launchApplication("http://qa3-sam.cengage.com");
	}

	@Test
	public void loginInApplication() {
		test.logPageAct.verifyLoginPage();
		test.logPageAct.enterCredentialsInToApplication(studentUser, password);
		test.logPageAct.verifyPageTitle("SAM - Home");
	}

	@Test(dependsOnMethods = "loginInApplication")
	public void verifyMiddleInnitialAndUserNameIsNotEditableInMyAccountLink() {
		test.studentHomePageAction.clickOnMyAccountLink();
		test.studentHomePageAction.clickOnEditInMyAccountLink();
		test.studentHomePageAction
				.verifyMyAccountMiddleNameIsNotEditable("Middle Initial");
		test.studentHomePageAction
				.verifyMyAccountUserNameIsNotEditable("Username");
		test.studentHomePageAction.clickOnSaveButton();
	}

	@AfterTest
	public void logOut() {
		test.logPageAct.switchToDefaultContent();
		test.logPageAct.clickLogOutButton();
		test.closeBrowserSession();
	}
}
