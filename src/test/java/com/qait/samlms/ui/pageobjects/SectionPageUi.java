package com.qait.samlms.ui.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qait.samlms.util.PropFileHandler;

public class SectionPageUi extends BasePage {
	String section = PropFileHandler.readProperty("sectionName");
	String availableTextBookName = "//td[contains(text(),'index')]/preceding-sibling::*//input";
	String selectedTextBook = "//td[contains(text(),'index')]";
	String sectionName = "//a[text()='index']";

	public SectionPageUi(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_SectionNameTextBox']")
	public WebElement inp_sectionName;

	@FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_CourseNameTextBox']")
	public WebElement inp_courseName;

	@FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_TermTextBox']")
	public WebElement inp_termName;

	@FindBy(xpath = "//table[@id='ctl00_ContentPlaceHolder1_tabStrip_1']/tbody/tr/td")
	public WebElement btn_textBooksTab;

	@FindBy(xpath = "//label[text()='I plan to use the following textbook(s) for this section']/preceding-sibling::input")
	public WebElement rd_iPlanToUseFollowingTextBooks;

	@FindBy(xpath = "//input[@title='Add Item']")
	public WebElement btn_addItem;

	@FindBy(xpath = "//input[@title='Save and Close']")
	public WebElement btn_saveAndClose;

	
	
	public WebElement getInputSectionName() {
		return waitForElementToBePresent(inp_sectionName);
	}

	public WebElement getInputCourseName() {
		return waitForElementToBePresent(inp_courseName);
	}

	public WebElement getInputTermName() {
		return waitForElementToBePresent(inp_termName);
	}

	public WebElement getTextBooksTab() {
		return waitForElementToBePresent(btn_textBooksTab);
	}

	public WebElement getIplanToUseFollowingTextBooks() {
		return waitForElementToBePresent(rd_iPlanToUseFollowingTextBooks);
	}

	public WebElement getSelectAvailableTextBook(String value) {
		return waitForElementToBePresent(driver.findElement(By
				.xpath(availableTextBookName.replaceAll("index", value))));

	}

	public WebElement getAddItem() {
		return waitForElementToBePresent(btn_addItem);
	}

	public WebElement getSelectedTextBook(String value) {
		return waitForElementToBePresent(driver.findElement(By
				.xpath(selectedTextBook.replaceAll("index", value))));
	}

	public WebElement getSaveAndCloseButton() {
		return waitForElementToBePresent(btn_saveAndClose);
	}

	public WebElement getSectionNameText() {
		String section = PropFileHandler.readProperty("sectionName");
		return waitForElementToBePresent(driver.findElement(By
				.xpath("//a[text()='" + section + "']")));
	}

	public WebElement getSectionRadioButton() {
		return waitForElementToBePresent(driver.findElement(By
				.xpath("//a[text()='" + section
						+ "']/../preceding-sibling::*/input")));
	}

	public WebElement getSectionTabButton(String tabName) {
		return waitForElementToBePresent(driver.findElement(By
				.xpath("//input[@title='" + tabName + "']")));
	}

	public WebElement getSectionStatus(String sectionName) {
		return waitForElementToBePresent(driver.findElement(By.xpath("//a[text()='"+sectionName+"']/../..//td[@class='waitListed ng-binding']")));
	}
	
	
	
	
}
