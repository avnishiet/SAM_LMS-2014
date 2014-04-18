package com.qait.samlms.ui.pageobjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DropBoxPageUi extends BasePage {

	public DropBoxPageUi(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//a[text()='Dropbox']")
	WebElement btn_dropBoxTab;

	@FindBy(xpath = "//label[text()='Dropbox']")
	WebElement lab_dropBox;

	@FindBy(xpath = "//span[text()='Dropbox']")
	WebElement hdng_dropBox;

	@FindBy(xpath = "//div[text()='Select the section for which you want to see the Dropbox.']")
	WebElement txt_dropBoxMessage;

	@FindBy(xpath = "//button[@title='Show All Items']")
	WebElement btn_dropBoxSectionDropDown;

	@FindBy(xpath = "//input[@value='OK']")
	WebElement btn_drobBoxDropDownOkButton;

	@FindBy(xpath = "//input[@value='Submit New File']")
	WebElement btn_submitNewFile;

	@FindBy(xpath = "//input[@id='form-add-input']")
	WebElement btn_browseFile;

	@FindBy(xpath = "//input[@value='Save']")
	WebElement btn_saveUploadFile;

	@FindBy(xpath = "//span[text()='ForUpload']")
	WebElement txt_uploadedFile;

	@FindBy(xpath = "//input[@value='Cancel']")
	WebElement btn_cancelUploadFile;

	@FindBy(xpath = "(//li[@class='ui-menu-item']/a)[last()]")
	WebElement txt_dropDownLastSection;

	@FindBy(xpath = "//table[@id='table-dropbox']")
	WebElement table_dropBoxTable;

	@FindBy(xpath = "//div[text()='350 MB (100%) available out of 350 MB']")
	WebElement txt_spaceAvailableInDropBox;

	@FindBy(xpath = "//span[@id='expand']")
	WebElement btn_expandButton;

	public WebElement getDropBoxTab() {
		return waitForElementToBePresent(btn_dropBoxTab);
	}

	public WebElement getDropBoxLabel() {
		return waitForElementToBePresent(lab_dropBox);
	}

	public WebElement getDropBoxMessage() {
		return waitForElementToBePresent(txt_dropBoxMessage);
	}

	public WebElement getDropBoxSectionDropDown() {
		return waitForElementToBePresent(btn_dropBoxSectionDropDown);
	}

	public WebElement getDropBoxDropDownOkButton() {
		return waitForElementToBePresent(btn_drobBoxDropDownOkButton);
	}

	public WebElement getsubmitNewFile() {
		return waitForElementToBePresent(btn_submitNewFile);
	}

	public WebElement getBrowseFile() {
		return waitForElementToBePresent(btn_browseFile);
	}

	public WebElement getSaveUploadFile() {
		return waitForElementToBePresent(btn_saveUploadFile);
	}

	public WebElement getUploadedFile() {
		return waitForElementToBePresent(txt_uploadedFile);
	}

	public WebElement getCancelUploadFile() {
		return waitForElementToBePresent(btn_cancelUploadFile);
	}

	public WebElement getLastSectionInDropDown() {
		return waitForElementToBePresent(txt_dropDownLastSection);
	}

	public List<WebElement> getSectionInDropDown() {
		return driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
	}

	public WebElement getDropBoxTable() {
		return waitForElementToBePresent(table_dropBoxTable);
	}

	public WebElement getDropBoxHeading() {
		return waitForElementToBePresent(hdng_dropBox);
	}

	public WebElement getDropBoxTableSubHeading(String subHeadingName) {
		return waitForElementToBePresent(driver.findElement(By
				.xpath("//div[contains(.,'" + subHeadingName + "')]")));
	}

	public WebElement getStudentFirstAndLastNameInStudentsSubHeading(
			String studentFirstAndLastName) {
		return waitForElementToBePresent(driver
				.findElement(By
						.xpath("//span[contains(text(),'Last Name, First Name')]/ancestor::*//div[text()='"
								+ studentFirstAndLastName + "']")));
	}

	public WebElement getDropBoxSpaceAvailable() {
		return waitForElementToBePresent(txt_spaceAvailableInDropBox);
	}

	public WebElement getExpandButton() {
		return waitForElementToBePresent(btn_expandButton);
	}

	public WebElement getDropboxTableHeadingLabel(String headingName) {
		return waitForElementToBePresent(driver.findElement(By.xpath("//th[contains(text(),'"+headingName+"')]")));
	}
	
	public WebElement getDropboxTableSubHeadingContent(String SubHeadingContent) {
		return waitForElementToBePresent(driver.findElement(By.xpath("//td[text()='"+SubHeadingContent+"']")));
	}
	
	
}
