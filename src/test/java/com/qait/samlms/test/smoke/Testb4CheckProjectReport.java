package com.qait.samlms.test.smoke;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qait.samlms.automation.TestSessionInitiator;

public class Testb4CheckProjectReport extends BaseTest {
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
				studentUser,
				password);
		test.logPageAct.verifyPageTitle("SAM - Home");
	}

	@Test(dependsOnMethods = "loginInApplication")
	public void selectProjectAssignmentAsStudentForReport() {
		test.studentHomePageAction.selectTab("Reports");
		test.activityListPageAction.selectSectionInActivityList(sectionName);
		test.reportPageAction.setOnFilterButtonFor("Projects");
	}

	@Test(dependsOnMethods = "selectProjectAssignmentAsStudentForReport")
	public void verifyAndSelectStudyGuide() {
		test.reportPageAction.verifyStudyGuideIsGenerated(projectName);
		test.reportPageAction.selectStudyGuideForAssignment(projectName);
		test.reportPageAction.getWindowHandle();
	}

	@Test(dependsOnMethods = "verifyAndSelectStudyGuide")
	public void verifyAssignmentNameAndTitleInStudyGuide() {
		test.reportPageAction.verifyAssignmentNameInStudyGuide(projectName);
		test.reportPageAction.verifyReportTitle("Project Study Guide");
		test.reportPageAction.closeDriver();
	}

	@AfterTest
	public void logOut() {
		test.logPageAct.switchToDefaultContent();
		test.logPageAct.clickLogOutButton();
		test.closeBrowserSession();
	}
}
