package com.qait.samlms.test.SamStudentDropBoxFlow.basicFlow;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qait.samlms.automation.TestSessionInitiator;
import com.qait.samlms.test.smoke.BaseTest;

public class Test3bVerifyDropboxTableDefaultValuesFromInstructorEnd extends BaseTest{
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
	public void userGoToResultsAndDropBoxPage() {
		test.homePageAction.clickTabButton("Results");
		test.userPageAction.waitForSpinnerToDisappear();
		test.reportPageAction.clickOnTabInResultsTab("Dropbox");
		test.userPageAction.waitForSpinnerToDisappear();
	}

	@Test(dependsOnMethods = "userGoToResultsAndDropBoxPage")
	public void verifySubHeadingsOfDropBoxTable() {
		test.dropBoxPageAction.switchToFrame("inst-frame");
		test.dropBoxPageAction.verifySectionDropDownBoxPresent();
		test.dropBoxPageAction.verifyOkButtonPresent();
		test.dropBoxPageAction.selectSectionFromDropDownList(sectionName);
		test.dropBoxPageAction.clickOnOkButton();		
		test.dropBoxPageAction.verifyDropBoxTable();
		test.dropBoxPageAction.verifyDropboxTableSubHeadingLabel("Last Name, First Name");
		test.dropBoxPageAction.verifyDropboxTableSubHeadingLabel("File Name");
		test.dropBoxPageAction.verifyDropboxTableSubHeadingLabel("Type");
		test.dropBoxPageAction.verifyDropboxTableSubHeadingLabel("Size");
		test.dropBoxPageAction.verifyDropboxTableSubHeadingLabel("Time");
		test.dropBoxPageAction.verifyDropboxTableSubHeadingLabel("Title");
		test.dropBoxPageAction.verifyCorrectStudentNameAppearsInDropboxTableUnderFirstNameLastName("SAM, SAM");
		test.dropBoxPageAction.verifyPercentageOfSpaceAvailableInDropbox("350 MB (100%) available out of 350 MB");
		test.dropBoxPageAction.verifyCorrectStudentIdAppearsInDropboxTableUnderFirstNameLastName(studentUser);
		test.dropBoxPageAction.clickExpandButton();
		test.dropBoxPageAction.verifyDropboxTableSubHeadingLabel("Date");
		test.dropBoxPageAction.verifyDropboxTableSubHeadingLabel("Note");	
	}
	
	@AfterTest
	public void logOut() {
		test.logPageAct.switchToDefaultContent();
		test.logPageAct.clickLogOutButton();
		test.closeBrowserSession();
	}
}
