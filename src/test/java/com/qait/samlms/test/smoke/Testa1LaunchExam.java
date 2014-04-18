package com.qait.samlms.test.smoke;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qait.samlms.automation.TestSessionInitiator;

public class Testa1LaunchExam extends BaseTest {
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
	public void selectExamAssignmentAsStudent() {
		test.studentHomePageAction.selectTab("Activity List");
		test.activityListPageAction.selectSectionInActivityList(sectionName);
		test.activityListPageAction.setOnFilterButtonFor("Exams");
		test.activityListPageAction.selectAssignment("examName");
		test.activityListPageAction.clickOnStartButton();
		test.activityListPageAction.getWindowHandle();
	}

	@Test(dependsOnMethods = "selectExamAssignmentAsStudent")
	public void launchContentPlayer() {
		test.samAssignmentPageAction.verifyContentPlayerTitle("SAM SAM :: "
				+ examName);
		test.samAssignmentPageAction.clickWindowIcon();
	}

	@AfterTest
	public void logOut() {
		test.logPageAct.switchToDefaultContent();
		test.logPageAct.clickLogOutButton();
		test.closeBrowserSession();
	}

}
