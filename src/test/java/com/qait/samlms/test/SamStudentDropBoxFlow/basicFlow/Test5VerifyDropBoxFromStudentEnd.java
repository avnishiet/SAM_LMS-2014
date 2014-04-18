package com.qait.samlms.test.SamStudentDropBoxFlow.basicFlow;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qait.samlms.automation.TestSessionInitiator;
import com.qait.samlms.test.smoke.BaseTest;

public class Test5VerifyDropBoxFromStudentEnd extends BaseTest{
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
	}

	@AfterTest
	public void logOut() {
		test.logPageAct.switchToDefaultContent();
		test.logPageAct.clickLogOutButton();
		test.closeBrowserSession();
	}
}
