package com.qait.samlms.test.SamStudentDropBoxFlow.basicFlow;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qait.samlms.automation.TestSessionInitiator;
import com.qait.samlms.test.smoke.BaseTest;


public class Test0SuperCreatesAdminUser extends BaseTest {
	TestSessionInitiator test;

	@BeforeClass
	public void setUpClass() {
		test = new TestSessionInitiator("resources\\testdata\\TestData.yml");
		test.launchApplication(baseUrl);
	}

	@Test
	public void loginInApplication() {
		test.logPageAct.verifyLoginPage();
		test.logPageAct.enterCredentialsInToApplication(superUser, password);
		test.logPageAct.verifyPageTitle("SAM - Home");
	}

	@Test(dependsOnMethods = "loginInApplication")
	public void createAndEnrollUser() {
		test.homePageAction.clickTabButton("Users");
		test.userPageAction.switchToFrame("inst-frame");
		test.userPageAction.waitForSpinnerToDisappear();
		test.userPageAction.clickAddNewButton();
		test.userPageAction.typeUserFirstName(firstName);
		test.userPageAction.typeUserLastName(lastName);
		test.userPageAction.selectUserRole(administratorRole);
		test.userPageAction.typeUserNameEmail("adminUser");
		test.userPageAction.typeUserPassword(password);
		test.userPageAction.typeVerifyUserPassword(password);
		test.userPageAction.clickSaveButton();
	}

	@Test(dependsOnMethods = "createAndEnrollUser")
	public void verifyAdminUser() {
		test.userPageAction.typeUserToSearch(adminUser);
		test.userPageAction.clickUserNameRadioButton();
		test.userPageAction.clickSearchButton();
		test.userPageAction.verifyUser(adminUser);
	}

	@AfterTest
	public void logOut() {
		test.logPageAct.switchToDefaultContent();
		test.logPageAct.clickLogOutButton();
		test.closeBrowserSession();
	}

}
