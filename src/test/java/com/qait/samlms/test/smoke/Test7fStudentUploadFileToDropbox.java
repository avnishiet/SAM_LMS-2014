package com.qait.samlms.test.smoke;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qait.samlms.automation.TestSessionInitiator;

public class Test7fStudentUploadFileToDropbox extends BaseTest {
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
	public void userGoToDropBoxPageAndSelectSection() {
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

	@Test(dependsOnMethods = "userGoToDropBoxPageAndSelectSection")
	public void firstFileUploadToDropBox() {
		test.dropBoxPageAction.clickOnSubmitNewFileDropBoxButton();
		test.dropBoxPageAction.selectFileToUpload("ForUpload.csv");
		test.dropBoxPageAction.clickOnSaveUploadFileButton();
		test.dropBoxPageAction.verifyFileUploaded("ForUpload.csv");
	}

	@Test(dependsOnMethods = "firstFileUploadToDropBox")
	public void samefileUploadToDropBoxAndVerifyMessage() {
		test.dropBoxPageAction.clickOnSubmitNewFileDropBoxButton();
		test.dropBoxPageAction.selectFileToUpload("ForUpload.csv");
		test.dropBoxPageAction
				.verifyAndAcceptAlertMessageOnUploadingSameFile("That file already exists in your Dropbox.  Please delete the existing file or change the name of the file you are uploading in order to save it to the Dropbox.");
		test.dropBoxPageAction.switchToFrame("iframebody");
		test.dropBoxPageAction.clickDropBoxUploadCancelButton();
	}

	@Test(dependsOnMethods = "samefileUploadToDropBoxAndVerifyMessage")
	public void anotherUnsupportedFileUploadToDropBox() {
		test.dropBoxPageAction.clickOnSubmitNewFileDropBoxButton();
		test.dropBoxPageAction.selectFileToUpload("sam.com");
		test.dropBoxPageAction
				.verifyAndAcceptAlertMessageOnUploadingSameFile("The file type is unsupported by Dropbox.");
		test.dropBoxPageAction.switchToFrame("iframebody");
		test.dropBoxPageAction.clickDropBoxUploadCancelButton();
		test.dropBoxPageAction.switchToDefaultContent();
	}

	@AfterTest
	public void logOut() {
		test.logPageAct.switchToDefaultContent();
		test.logPageAct.clickLogOutButton();
		test.closeBrowserSession();
	}

}
