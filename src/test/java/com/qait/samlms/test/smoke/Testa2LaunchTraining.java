package com.qait.samlms.test.smoke;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qait.samlms.automation.TestSessionInitiator;

public class Testa2LaunchTraining extends BaseTest {

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
		test.activityListPageAction.setOnFilterButtonFor("Training");
		test.activityListPageAction.selectAssignment("trainingName");
		test.activityListPageAction.clickOnStartButton();
		test.activityListPageAction.getWindowHandle();
	}

	@Test(dependsOnMethods = "selectExamAssignmentAsStudent")
	public void launchContentPlayer() {
		test.samAssignmentPageAction.verifyContentPlayerTitle("SAM SAM :: "
				+ trainingName);
		test.samAssignmentPageAction.performTraining();
	}

	@AfterTest
	public void logOut() {
		System.out.println("1");
		test.logPageAct.switchToDefaultContent();
		System.out.println("2");
		test.logPageAct.clickLogOutButton();
		System.out.println("3");
		test.closeBrowserSession();
	}

}
