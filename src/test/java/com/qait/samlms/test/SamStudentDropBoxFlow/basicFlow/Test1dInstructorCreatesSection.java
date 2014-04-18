package com.qait.samlms.test.SamStudentDropBoxFlow.basicFlow;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qait.samlms.automation.TestSessionInitiator;
import com.qait.samlms.test.smoke.BaseTest;

public class Test1dInstructorCreatesSection extends BaseTest{

	TestSessionInitiator test;

	@BeforeClass
	public void setUpClass() {
		test = new TestSessionInitiator("resources\\testdata\\TestData.yml");
		test.launchApplication(baseUrl);
	}

	@Test
	public void loginInApplication() {
		test.logPageAct.verifyLoginPage();
		test.logPageAct.enterCredentialsInToApplication(instructorUser,
				password);
		test.logPageAct.handleAlert();
		test.logPageAct.verifyPageTitle("SAM - Home");
		}

	@Test(dependsOnMethods = "loginInApplication")
	public void createSection() {
		test.homePageAction.clickTabButton("Sections");
		test.userPageAction.switchToFrame("inst-frame");
		//test.userPageAction.waitForSpinnerToDisappear();	
		test.userPageAction.clickAddNewButton();
}

	@Test(dependsOnMethods = "createSection")
	public void instructorFillSectionDetails() {
		test.sectionPageAction.typeSectionName();
		test.sectionPageAction.typeCourseName("course_a");
		test.sectionPageAction.typeTermName("Term_a");
		test.sectionPageAction.selectYear("2014");
		test.sectionPageAction.clickTextBooksTab();
		test.sectionPageAction.clickIplanToUseFollowingTextBooks();
		test.sectionPageAction.selectSeriesName("Illustrated");
		test.sectionPageAction.selectSubjectName("MS PowerPoint 2010");
		test.sectionPageAction
				.selectAvailableTextBook("Microsoft Office 2010 - Illustrated First Course");
		test.sectionPageAction.clickOnMoveButton();
		test.sectionPageAction.waitForSpinnerToDisappear();
		test.sectionPageAction
				.verifySelectedTextBook("Microsoft Office 2010 - Illustrated First Course");
		test.sectionPageAction.clickOnSaveAndCloseButton();
		test.sectionPageAction.verifySectionCreated();

	}

	@AfterTest
	public void logOut() {
		test.logPageAct.switchToDefaultContent();
		test.logPageAct.clickLogOutButton();
		test.closeBrowserSession();
	}

}
