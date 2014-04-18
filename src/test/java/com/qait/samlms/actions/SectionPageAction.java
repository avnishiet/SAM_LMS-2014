package com.qait.samlms.actions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.qait.samlms.ui.pageobjects.SectionPageUi;
import com.qait.samlms.util.PropFileHandler;

public class SectionPageAction extends SectionPageUi {

	public SectionPageAction(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	String sectionName = "section";
/**
 * type section name in section creation
 * @return
 */
	public boolean typeSectionName() {
		sectionName = sectionName + System.currentTimeMillis();
		enterText(getInputSectionName(), sectionName);
		try {
			PropFileHandler.writeToFile("sectionName", sectionName);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * type second section name in section creation
	 * @return
	 */
	public boolean typeSecondSectionName() {
		sectionName = sectionName + System.currentTimeMillis();
		enterText(getInputSectionName(), sectionName);
		try {
			PropFileHandler.writeToFile("secondSectionName", sectionName);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * type course name in section creation
	 * @param courseName
	 */
	public boolean typeCourseName(String courseName) {
		try{
			enterText(getInputCourseName(), courseName);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
}

	/**
	 * type term name in section creation
	 * @param termName
	 * @return
	 */
	public boolean typeTermName(String termName) {
		try{
			enterText(getInputTermName(), termName);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * select year in section creation
	 * @param year
	 * @return
	 */
	public boolean selectYear(String year) {
		return getSelectedDropdownValue(year);
	}

	/**
	 * click on text book tab in sections-edit page
	 * @return
	 */
	public boolean clickTextBooksTab() {
		try{
			getTextBooksTab().click();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		
	}

	/**
	 * select I plan to use following text books in sections-edit page
	 * @return
	 */
	public boolean clickIplanToUseFollowingTextBooks() {
		return selectRadioButton(getIplanToUseFollowingTextBooks());
		

	}

	/**
	 * select series name in section-edit page
	 * @param seriesName
	 * @return
	 */
	public boolean selectSeriesName(String seriesName) {
		try{
			getSelectedDropdownValue(seriesName);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * select subject name in section-edit page
	 * @param subjectName
	 * @return
	 */
	public boolean selectSubjectName(String subjectName) {
		try{
			getSelectedDropdownValue(subjectName);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		

	}

	/**
	 * select check box for available text book
	 * @param availableTextBookName
	 * @return
	 */
	public boolean selectAvailableTextBook(String availableTextBookName) {
	return 	selectCheckbox(getSelectAvailableTextBook(availableTextBookName));
	}

	/**
	 * click on move button in section-edit page
	 * @return
	 */
	public boolean clickOnMoveButton() {
		try{
		getAddItem().click();
		Thread.sleep(5000);
		return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		}

	public boolean verifySelectedTextBook(String availableTextBookName) {
		if (getSelectAvailableTextBook(availableTextBookName).isDisplayed())
			return true;
		return false;

	}

	/**
	 * click on save and close button after fill details of user
	 * @return
	 */
	public boolean clickOnSaveAndCloseButton() {
		try{
			getSaveAndCloseButton().click();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * verifies section created
	 * @return
	 */
	public boolean verifySectionCreated() {
		String sectionName = PropFileHandler.readProperty("sectionName");
		if (getSectionNameText().getText().equalsIgnoreCase(sectionName))
			return true;
		return false;
	}
	
	
	public boolean selectSectionRadioButton(){
		return selectRadioButton(getSectionRadioButton());
	}
	
	/**
	 * click on section tab in home page
	 * @param tabName
	 * @return
	 */
	public boolean clickOnSectiontab(String tabName){
		try{
			getSectionTabButton(tabName).click();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public void deleteExistingSectionDetails(){
		getInputSectionName().clear();
		getInputCourseName().clear();
		getInputTermName().clear();
		getSelectedDropdownValue("2013");
	}
	
	public boolean verifySectionStatus(String sectionName,String status){
		return getSectionStatus(sectionName).getText().equalsIgnoreCase(status);
	}
	
	
	
	
	
	
	
	
	
	
	

}
