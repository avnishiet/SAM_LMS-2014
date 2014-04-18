package com.qait.samlms.test.SamStudentDropBoxFlow.basicFlow;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qait.samlms.automation.TestSessionInitiator;
import com.qait.samlms.test.smoke.BaseTest;

public class Test5bVerifyDropboxTableDefaultValuesFromStudentSide extends BaseTest{
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
		test.logPageAct.handleAlert();
		test.logPageAct.verifyPageTitle("SAM - Home");
	}

	@Test(dependsOnMethods = "loginInApplication")
	public void verifyDropBoxFromStudentSide() {
		test.dropBoxPageAction.clickOnDropBoxTab();
		test.dropBoxPageAction.verifyDropBoxHeading("DropBox");
		test.dropBoxPageAction.switchToFrame("iframebody");
		test.dropBoxPageAction
				.verifyMessageDropBox("Select the section for which you want to see the Dropbox");
		test.dropBoxPageAction.verifySectionDropDownBoxPresent();
		test.dropBoxPageAction.verifyOkButtonPresent();
		test.dropBoxPageAction.selectSectionFromDropDownList(sectionName);
		test.dropBoxPageAction.clickOnOkButton();
	}

	@Test(dependsOnMethods = "verifyDropBoxFromStudentSide")
	public void verifyDropBoxTable() {
		test.dropBoxPageAction.verifyDropBoxTable();
		test.dropBoxPageAction.verifySubmitNewFileDropBoxButton();
		test.dropBoxPageAction.verifyDropboxTableSubHeadingLabel("File Name");
		test.dropBoxPageAction.verifyDropboxTableSubHeadingLabel("Type");
		test.dropBoxPageAction.verifyDropboxTableSubHeadingLabel("Size");
		test.dropBoxPageAction.verifyDropboxTableSubHeadingLabel("Time");
		test.dropBoxPageAction.verifyDropboxTableSubHeadingLabel("Title");
		test.dropBoxPageAction.verifyDropboxTableSubHeadingLabel("Note");
		test.dropBoxPageAction.clickExpandButton();
		test.dropBoxPageAction.verifyDropboxTableSubHeadingLabel("Date");
		test.dropBoxPageAction.verifyDropboxTableHeadingLabel("Note from Instructor");
		test.dropBoxPageAction.verifyDropboxTableHeadingLabel("Files");
		test.dropBoxPageAction.verifyDropboxTableSubHeadingContent("No data available in table");
	}

	@AfterTest
	public void logOut() {
		test.logPageAct.switchToDefaultContent();
		test.logPageAct.clickLogOutButton();
		test.closeBrowserSession();
	}
}
