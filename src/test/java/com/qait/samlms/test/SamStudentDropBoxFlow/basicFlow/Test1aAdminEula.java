package com.qait.samlms.test.SamStudentDropBoxFlow.basicFlow;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qait.samlms.automation.TestSessionInitiator;
import com.qait.samlms.test.smoke.BaseTest;

public class Test1aAdminEula extends BaseTest {

	TestSessionInitiator test;

	@BeforeClass
	public void setUpClass() {
		test = new TestSessionInitiator("resources\\testdata\\TestData.yml");
		test.launchApplication(baseUrl);
	}

	@Test
	public void loginInApplication() {
		test.logPageAct.verifyLoginPage();
		test.logPageAct.enterCredentialsInToApplication(adminUser, password);
		test.logPageAct.verifyPageTitle("SAM - Home");
	}

	@Test(dependsOnMethods = "loginInApplication")
	public void acceptEula() {
		test.logPageAct.handleAlert();
		test.logPageAct.clickIAgreeButton();
	}

	@Test(dependsOnMethods = "acceptEula")
	public void adminFillDetails() {
		test.logPageAct
				.selectSecretQuestion("What is your father's middle name?");
		test.logPageAct.typeSecretAnswer("SAM");
		test.logPageAct.clickOnSubmitButton();
		test.logPageAct.typeNewPassword(password);
		test.logPageAct.typeConfirmPassword(password);
		test.logPageAct.clickOnSubmitButton();
	}

	@AfterTest
	public void logOut() {
		test.logPageAct.switchToDefaultContent();
		test.logPageAct.clickLogOutButton();
		test.closeBrowserSession();
	}

}
