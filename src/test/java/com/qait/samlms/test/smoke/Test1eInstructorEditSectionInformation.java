package com.qait.samlms.test.smoke;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qait.samlms.automation.TestSessionInitiator;

public class Test1eInstructorEditSectionInformation extends BaseTest {
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
	public void EditSectionDetails() {
		test.homePageAction.clickTabButton("Sections");
		test.userPageAction.waitForSpinnerToDisappear();
		test.userPageAction.switchToFrame("inst-frame");
		test.sectionPageAction.selectSectionRadioButton();
		test.sectionPageAction.clickOnSectiontab("Edit");
		test.sectionPageAction.deleteExistingSectionDetails();
		test.sectionPageAction.typeSectionName();
		test.sectionPageAction.typeCourseName("editedCourse");
		test.sectionPageAction.typeTermName("editedTerm");
		test.sectionPageAction.selectYear("2014");
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
