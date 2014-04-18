package com.qait.samlms.actions;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.python.core.exceptions;

import com.qait.samlms.ui.pageobjects.DropBoxPageUi;

public class DropBoxPageAction extends DropBoxPageUi {

	public DropBoxPageAction(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	/**
	 * click on drop box tab
	 */
	public boolean clickOnDropBoxTab() {
		try {
			getDropBoxTab().click();
			if (getDropBoxLabel().getText().equalsIgnoreCase("Dropbox"))
				return true;
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * verifies drop box heading ie. Drop box
	 * 
	 * @param dropboxHeading
	 * @return
	 */
	public boolean verifyDropBoxHeading(String dropboxHeading) {
		try {
			return getDropBoxLabel().getText().equalsIgnoreCase("Dropbox");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * verifies Message DropBox ie.
	 * "Select the section for which you want to see the Dropbox"
	 * 
	 * @param message
	 * @return
	 */
	public boolean verifyMessageDropBox(String message) {
		try {
			return getDropBoxMessage().getText().equalsIgnoreCase(message);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * verifies sections drop down box present
	 */
	public boolean verifySectionDropDownBoxPresent() {
		try {
			Thread.sleep(3000);
			return getDropBoxSectionDropDown().isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * verifies ok button present
	 */
	public boolean verifyOkButtonPresent() {
		try {
			return getDropBoxDropDownOkButton().isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * select section from drop down list
	 * 
	 * @param sectionName
	 * @return
	 */
	public boolean selectSectionFromDropDownList(String sectionName) {
		try {
			Thread.sleep(3000);
			getDropBoxSectionDropDown().click();	
			Thread.sleep(2000);
			if (getLastSectionInDropDown().isDisplayed()) {
				for (WebElement value1 : getSectionInDropDown()) {
					value1.getText().trim();
					if (value1.getText().trim().contains(sectionName)) {
						value1.click();
						return true;
					}
				}
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * click on Ok button after selection of section from drop down list
	 */
	public boolean clickOnOkButton() {
		try {
			Thread.sleep(2000);
			getDropBoxDropDownOkButton().click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * verifies submit new file drop box button.
	 * @return
	 */
	public boolean verifySubmitNewFileDropBoxButton() {
		try {
			getsubmitNewFile().isDisplayed();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
		
	/**
	 * click on submit new file drop box button
	 */
	public boolean clickOnSubmitNewFileDropBoxButton() {
		try {
			getsubmitNewFile().click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * select file from upload file folder
	 * 
	 * @param fileName
	 * @return
	 */
	public boolean selectFileToUpload(String fileName) {
		try {
			String path = System.getProperty("user.dir") + "\\uploadFiles\\";
			File filePath = new File(path + fileName);
			getBrowseFile().sendKeys(filePath.getAbsolutePath());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * click on save button after upload the file
	 */
	public boolean clickOnSaveUploadFileButton() {
		try {
			getSaveUploadFile().click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * verifies file uploaded
	 * 
	 * @param fileName
	 * @return
	 */
	public boolean verifyFileUploaded(String fileName) {
		try {
			return getUploadedFile().getText().equalsIgnoreCase(fileName);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * verifies and accept alert message on uploading same file in drop box
	 * 
	 * @param message
	 * @return
	 */
	public boolean verifyAndAcceptAlertMessageOnUploadingSameFile(String message) {
		try {
			System.out.println("alertText()" + alertText());
			System.out.println("message" + message);
			if (alertText().equalsIgnoreCase(message)) {
				System.out.println("alertText()" + alertText());
				System.out.println("message" + message);
				handleAlert();
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * click on cancel button.
	 * 
	 * @return
	 */
	public boolean clickDropBoxUploadCancelButton() {
		try {
			getCancelUploadFile().click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * verifies drop box table.
	 * 
	 * @return
	 */
	public boolean verifyDropBoxTable() {
		return getDropBoxTable().isDisplayed();
	}

	/**
	 * verifies drop box heading at instructor end.
	 * 
	 * @return
	 */
	public boolean verifyDropBoxHeadingAtNoneStudentUserEnd(String dropBox) {
		return getDropBoxHeading().getText().equalsIgnoreCase(dropBox);
	}

	/**
	 * verifies drop box table sub heading labels ie. Last Name, First Name,File
	 * Name,type,size, time,title.
	 * 
	 * @param subHeadingName
	 * @return
	 */
	public boolean verifyDropboxTableSubHeadingLabel(String subHeadingName) {
		return getDropBoxTableSubHeading(subHeadingName).getText()
				.equalsIgnoreCase(subHeadingName);
	}

	/**
	 * verifies student first and last name in student's first name last name
	 * heading ie. SAM, SAM.
	 * 
	 * @param studentFirstAndLastName
	 * @return
	 */
	public boolean verifyCorrectStudentNameAppearsInDropboxTableUnderFirstNameLastName(
			String studentFirstAndLastName) {
		return getStudentFirstAndLastNameInStudentsSubHeading(
				studentFirstAndLastName).getText().equalsIgnoreCase(
				studentFirstAndLastName);
	}

	/**
	 * verifies percentage of space available in drop box ie.
	 * "350 MB (100%) available out of 350 MB".
	 * 
	 * @param percentageOfSpaceAvailable
	 * @return
	 */
	public boolean verifyPercentageOfSpaceAvailableInDropbox(
			String percentageOfSpaceAvailable) {
		return getDropBoxSpaceAvailable().getText().equalsIgnoreCase(
				percentageOfSpaceAvailable);

	}

	/**
	 * click on expand drop box button.
	 * 
	 * @return
	 */
	public boolean clickExpandButton() {
		try {
			getExpandButton().click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * verifies correct student ID appears in drop box table under first name last name.
	 * @param studentId
	 * @return
	 */
	public boolean verifyCorrectStudentIdAppearsInDropboxTableUnderFirstNameLastName(
			String studentId) {
		return getStudentFirstAndLastNameInStudentsSubHeading(studentId)
				.getText().equalsIgnoreCase(studentId);
	}
	
	/**
	 * verifies drop box table heading label.
	 * @param headingName - Files,Note from Instructor.
	 * @return boolean
	 */
	public boolean verifyDropboxTableHeadingLabel(String headingName) {
		try {
			return getDropboxTableHeadingLabel(headingName).getText().equalsIgnoreCase(headingName);
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * verifies drop box table sub heading content
	 * @param SubHeadingContent
	 * @return
	 */
	public boolean verifyDropboxTableSubHeadingContent(String SubHeadingContent) {
		try {
			return getDropboxTableSubHeadingContent(SubHeadingContent).getText().equalsIgnoreCase(SubHeadingContent);
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	

}
