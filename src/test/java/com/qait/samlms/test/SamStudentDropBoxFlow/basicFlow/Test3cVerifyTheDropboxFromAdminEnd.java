package com.qait.samlms.test.SamStudentDropBoxFlow.basicFlow;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qait.samlms.automation.TestSessionInitiator;
import com.qait.samlms.test.smoke.BaseTest;

public class Test3cVerifyTheDropboxFromAdminEnd extends BaseTest {
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
		test.logPageAct.handleAlert();
		test.logPageAct.verifyPageTitle("SAM - Home");
	}

	@Test(dependsOnMethods = "loginInApplication")
	public void verifyTabsInResultsPage() {
		test.homePageAction.verifyTabButton("Results");
		test.homePageAction.clickTabButton("Results");
		test.userPageAction.waitForSpinnerToDisappear();
		test.reportPageAction.verifyReportsTabIsActiveInResultsPage();
		test.reportPageAction.verifyReportsTabIsActiveInResultsPage();
		test.reportPageAction.clickOnTabInResultsTab("Dropbox");
		test.userPageAction.waitForSpinnerToDisappear();
	}

	@Test(dependsOnMethods = "verifyTabsInResultsPage")
	public void verifyDropBoxFromAdminUserSide() {
		test.dropBoxPageAction.switchToFrame("inst-frame");
		test.dropBoxPageAction.verifyDropBoxHeadingAtNoneStudentUserEnd("Dropbox");
		test.dropBoxPageAction
				.verifyMessageDropBox("Select the section for which you want to see the Dropbox");
		test.dropBoxPageAction.verifySectionDropDownBoxPresent();
		test.dropBoxPageAction.verifyOkButtonPresent();
		test.dropBoxPageAction.selectSectionFromDropDownList(sectionName);
		test.dropBoxPageAction.clickOnOkButton();
	}

	@Test(dependsOnMethods = "verifyDropBoxFromAdminUserSide")
	public void verifyDropBoxTable() {
		test.dropBoxPageAction.verifyDropBoxTable();
	}

	@AfterTest
	public void logOut() {
		test.logPageAct.switchToDefaultContent();
		test.logPageAct.clickLogOutButton();
		test.closeBrowserSession();
	}
}
