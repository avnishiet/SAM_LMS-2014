package com.qait.samlms.ui.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReportPageUi extends BasePage{

	public ReportPageUi(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//div[@class='ReportIconUp']")
	public WebElement img_report;
	
	@FindBy(xpath = "//div[text()='Exam Study Guide']")
	public WebElement txt_examStudyGuideTitle;
	
	@FindBy(xpath = "//li[contains(@class,'active')]/a[text()='Reports']")
	public WebElement tab_reportActiveTab;
	
	
	public WebElement getReport(){
		return waitForElementToBePresent(img_report);
	}
	
	public WebElement getSetOnFilterButton(String tabName) {
		System.out.println("tab name in ui "+tabName);
		String tabsInActivityList = "//li[text()='"+tabName+"']";
		return waitForElementToBePresent(driver.findElement(By
				.xpath(tabsInActivityList)));

	}
	
	public WebElement getReportForAssignment(String assignmentName){
		return waitForElementToBePresent(driver.findElement(By.xpath("//span[text()='"+assignmentName+"']/../../../following-sibling::div//div[@class='ReportIconUp']")));
	}
	
	public WebElement getAssignmentNameInReportAndStudyGuide(String assignmentName){
		return waitForElementToBePresent(driver.findElement(By.xpath("//div[text()='"+assignmentName+"']")));
	}
	
	public WebElement getScoreInReportForExam(String assignmentName,String score){
		return waitForElementToBePresent(driver.findElement(By.xpath("//div[text()='"+assignmentName+"']/../following-sibling::td/div[contents(text(),'"+score+"')]")));
	}
	
	public WebElement getStudyGuide(String assignmentName){
		return waitForElementToBePresent(driver.findElement(By.xpath("//span[text()='"+assignmentName+"']/../../../following-sibling::div//div[@class='ReportStudyGuideIconUp']")));
	}
	
	public WebElement getReportTitle(String title){
		return waitForElementToBePresent(driver.findElement(By.xpath("//div[text()='"+title+"']")));
	}
	
	public WebElement getScoreInReportForTraining(String assignmentName,String score){
		return waitForElementToBePresent(driver.findElement(By.xpath("//div[text()='"+assignmentName+"']/ancestor::*//div[contains(text(),'"+score+"')]")));
	}
	
	public WebElement getActiveReportTabInResultPage(){
		return waitForElementToBePresent(tab_reportActiveTab);
	}
	
	public WebElement getTabsInResultsPage(String tabName){
		return waitForElementToBePresent(driver.findElement(By.xpath("//a[text()='"+tabName+"']")));
	}
	
	
	
	
	
	
	
	
	
	
}
