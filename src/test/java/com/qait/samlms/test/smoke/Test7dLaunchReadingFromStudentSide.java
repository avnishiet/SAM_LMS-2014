package com.qait.samlms.test.smoke;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qait.samlms.automation.TestSessionInitiator;

public class Test7dLaunchReadingFromStudentSide extends BaseTest {
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
	public void SelectReadingActivity() {
		test.studentHomePageAction.selectTab("Activity List");
		test.activityListPageAction.selectSectionInActivityList(sectionName);
		test.activityListPageAction.setOnFilterButtonFor("Readings");
		test.activityListPageAction.selectAssignment("ReadingBookName");
	}

	@Test(dependsOnMethods = "SelectReadingActivity")
	public void LaunchReadingActivity() {
		test.readingActivityPageAction.SwitchMindTapWindow();
		test.readingActivityPageAction.clickOnAcceptButton();
		test.readingActivityPageAction
				.verifyEbookTitleInMindtap("Microsoft® Office® 2010 - Illustrated First Course, Introductory");
		test.readingActivityPageAction.closeMindtapWindow();
		test.readingActivityPageAction.selectDefaultWindow();
	}

	@AfterTest
	public void logOut() {
		test.logPageAct.switchToDefaultContent();
		test.logPageAct.clickLogOutButton();
		test.closeBrowserSession();
	}
}
