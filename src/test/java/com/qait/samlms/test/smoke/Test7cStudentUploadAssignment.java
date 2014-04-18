package com.qait.samlms.test.smoke;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qait.samlms.automation.TestSessionInitiator;

public class Test7cStudentUploadAssignment extends BaseTest {
	TestSessionInitiator test;

	@BeforeClass
	public void setUpClass() {
		test = new TestSessionInitiator("resources\\testdata\\TestData.yml");
		test.launchApplication(baseUrl);
	}

	@Test
	public void loginInApplication() {
		test.logPageAct.verifyLoginPage();
		test.logPageAct.enterCredentialsInToApplication(studentUser, password);
		test.logPageAct.verifyPageTitle("SAM - Home");
	}

	@Test(dependsOnMethods = "loginInApplication")
	public void acceptEula() {
		test.logPageAct.handleAlert();
		test.logPageAct.clickIAgreeButton();
	}

	@Test(dependsOnMethods = "acceptEula")
	public void studentFillDetails() {
		test.logPageAct
				.selectSecretQuestion("What is your father's middle name?");
		test.logPageAct.typeSecretAnswer("SAM");
		test.logPageAct.clickOnSubmitButton();
		test.logPageAct.typeNewPassword(password);
		test.logPageAct.typeConfirmPassword(password);
		test.logPageAct.clickOnSubmitButton();
	}

	@Test(dependsOnMethods = "studentFillDetails")
	public void SelectProjectAssignment() {
		test.studentHomePageAction.selectTab("Activity List");
		test.activityListPageAction.selectSectionInActivityList(sectionName);
		test.activityListPageAction.setOnFilterButtonFor("Projects");
		test.activityListPageAction.selectAssignment("projectName");
	}

	@Test(dependsOnMethods = "LaunchProjectAssignment")
	public void downloadAndUploadFile() {
		test.activityListPageAction.clickOnStartButton();
		test.projectPageAction.clickOnDownloadLink();
		test.projectPageAction.uploadFile();
		test.projectPageAction.deleteDownloadedFile();
		test.projectPageAction.clickOnSubmitProjectButton();
	}

	@Test(dependsOnMethods = "downloadAndUploadFile")
	public void verifyFileUpload() {
		test.projectPageAction.verifyFileUploaded("Virus Scan", "File Format",
				"File Size");
	}

	@AfterTest
	public void logOut() {
		test.logPageAct.switchToDefaultContent();
		test.logPageAct.clickLogOutButton();
		test.closeBrowserSession();
	}

}
