package com.qait.samlms.test.smoke;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qait.samlms.automation.TestSessionInitiator;

public class Testb3CheckTrainingReport extends BaseTest {
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
	public void selectTrainingAssignmentAsStudentForReport() {
		test.studentHomePageAction.selectTab("Reports");
		test.activityListPageAction.selectSectionInActivityList(sectionName);
		test.reportPageAction.setOnFilterButtonFor("Training");
	}

	@Test(dependsOnMethods = "selectTrainingAssignmentAsStudentForReport")
	public void verifyAndSelectReport() {
		test.reportPageAction.verifyReportIsGenerated(trainingName);
		test.reportPageAction.selectReportForAssignment(trainingName);
		test.reportPageAction.getWindowHandle();
	}

	@Test(dependsOnMethods = "verifyAndSelectReport")
	public void verifyAssignmentNameAndScoreInReport() {
		test.reportPageAction.verifyAssignmentNameInReport(trainingName);
		test.reportPageAction.verifyAssignmentScoreInReportForTraining(
				trainingName, "100");
		test.reportPageAction.verifyReportTitle("Training Progress");
		test.reportPageAction.closeDriver();
	}

	@AfterTest
	public void logOut() {
		test.logPageAct.switchToDefaultContent();
		test.logPageAct.clickLogOutButton();
		test.closeBrowserSession();
	}

}
