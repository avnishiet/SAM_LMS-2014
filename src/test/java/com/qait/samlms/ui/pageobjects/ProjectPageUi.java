package com.qait.samlms.ui.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectPageUi extends BasePage {

	public ProjectPageUi(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//span[text()='Download Instructions']")
	WebElement lnk_downloadIns;

	@FindBy(xpath = "(//span[@class='ProjectFileUpload ng-binding'])[1]")
	WebElement txt_fileName;

	@FindBy(xpath = "//input[@id='fileToUpload']")
	WebElement inp_uploadFile;

	@FindBy(xpath = "//button[text()='Submit']")
	WebElement btn_submit;

	
	public WebElement getDownloadLink() {
		return waitForElementToBePresent(lnk_downloadIns);
	}

	public WebElement getFileName() {
		return waitForElementToBePresent(txt_fileName);
	}

	public WebElement getUploadFile() {
		return waitForElementToBePresent(inp_uploadFile);
	}

	public WebElement getSubmitButton() {
		return waitForElementToBePresent(btn_submit);
	}

	public List<WebElement> getVerifyFileUploaded(String fileFormat,
			String VirusScan, String fileSize) {
		String xpath = "//td[text()='"
				+ fileFormat
				+ "' and '"
				+ VirusScan
				+ "' and '"
				+ fileSize
				+ "']/../following-sibling::*//div[@class='verificationPassed']";
		return driver.findElements(By.xpath(xpath));
	}

}