package com.qait.samlms.test.smoke;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qait.samlms.automation.TestSessionInitiator;

public class Testb2CheckExamResultReport extends BaseTest {
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
	public void selectExamAssignmentAsStudentForReport() {
		test.studentHomePageAction.selectTab("Reports");
		test.activityListPageAction.selectSectionInActivityList(sectionName);
		test.reportPageAction.setOnFilterButtonFor("Exams");
	}

	@Test(dependsOnMethods = "selectExamAssignmentAsStudentForReport")
	public void verifyAndSelectStudyGuide() {
		test.reportPageAction.verifyStudyGuideIsGenerated(examName);
		test.reportPageAction.selectStudyGuideForAssignment(examName);
		test.reportPageAction.getWindowHandle();
	}

	@Test(dependsOnMethods = "verifyAndSelectStudyGuide")
	public void verifyAssignmentNameAndTitleInStudyGuide() {
		test.reportPageAction.verifyAssignmentNameInStudyGuide(examName);
		test.reportPageAction.verifyReportTitle("Exam Study Guide");
		test.reportPageAction.closeDriver();
	}

	@AfterTest
	public void logOut() {
		test.logPageAct.switchToDefaultContent();
		test.logPageAct.clickLogOutButton();
		test.closeBrowserSession();
	}

}
