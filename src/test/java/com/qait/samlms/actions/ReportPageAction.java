package com.qait.samlms.actions;

import org.openqa.selenium.WebDriver;

import com.qait.samlms.ui.pageobjects.ReportPageUi;

public class ReportPageAction extends ReportPageUi {

	String[] reportTabs = { "Exams", "Training", "Projects", "SAM Paths" };

	public ReportPageAction(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 2 minutes wait for generate the report for SAM assignments
	 * 
	 * @return
	 */
	public boolean waitForGeneratedReport() {

		try {
			Thread.sleep(120000);
			return true;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * verifies report is generated for SAM assignments
	 * 
	 * @return
	 */
	public boolean verifyReportIsGenerated(String assignmentName) {
		return getReportForAssignment(assignmentName).isDisplayed();
	}

	/**
	 * set on filters for desired tab of activity list
	 * 
	 * @param tabName
	 * @return
	 */
	public boolean setOnFilterButtonFor(String tabName) {
		try {

			for (String tab : reportTabs) {
				System.out.println("tab" + tab);
				if (!tab.equalsIgnoreCase(tabName)) {
					getSetOnFilterButton(tab.toString()).click();
				}
			}

			// if (!getAlwaysAvailableTab().getAttribute("class")
			// .equalsIgnoreCase("AlwaysOn"))
			// getAlwaysAvailableTab().click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * select report for given assignment
	 * 
	 * @param assignmentName
	 * @return
	 */
	public boolean selectReportForAssignment(String assignmentName) {
		try {
			getReportForAssignment(assignmentName).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * verifies assignment name in report window
	 * 
	 * @param assignmentName
	 * @return
	 */
	public boolean verifyAssignmentNameInReport(String assignmentName) {
		return getAssignmentNameInReportAndStudyGuide(assignmentName).getText()
				.equalsIgnoreCase(assignmentName);
	}

	/**
	 * verifies assignment score in report window for exam ie. 100
	 * 
	 * @param assignmentName
	 * @param score
	 * @return
	 */
	public boolean verifyAssignmentScoreInReportForExam(String assignmentName,
			String score) {
		return getScoreInReportForExam(assignmentName, score).getText()
				.equalsIgnoreCase(score);
	}

	/**
	 * verifies study guide is generated for assignment
	 * 
	 * @param assignmentName
	 * @return
	 */
	public boolean verifyStudyGuideIsGenerated(String assignmentName) {
		return getStudyGuide(assignmentName).isDisplayed();
	}

	/**
	 * select study guide for assignment
	 * 
	 * @param assignmentName
	 * @return
	 */
	public boolean selectStudyGuideForAssignment(String assignmentName) {
		try {
			getStudyGuide(assignmentName).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * verifies assignment name in study guide
	 * 
	 * @param assignmentName
	 * @return
	 */
	public boolean verifyAssignmentNameInStudyGuide(String assignmentName) {
		return getAssignmentNameInReportAndStudyGuide(assignmentName).getText()
				.equalsIgnoreCase(assignmentName);
	}

	/**
	 * verifies report title "exam study guide" in study guide report
	 * 
	 * @param title
	 * @return
	 */
	public boolean verifyReportTitle(String title) {
		return getReportTitle(title).getText().equalsIgnoreCase(title);
	}

	/**
	 * verifies assignment score in report window for training ie. 100
	 * 
	 * @param assignmentName
	 * @param score
	 * @return
	 */
	public boolean verifyAssignmentScoreInReportForTraining(
			String assignmentName, String score) {
		return getScoreInReportForTraining(assignmentName, score).getText()
				.equalsIgnoreCase(score);
	}

	/**
	 * verifies reports tab is active by default in results page
	 * 
	 * @return
	 */
	public boolean verifyReportsTabIsActiveInResultsPage() {
		return getActiveReportTabInResultPage().getAttribute("class").contains(
				"active");

	}

	/**
	 * verifies tab in results tab ie. reports, grade book and drop box.
	 * 
	 * @param tabName
	 * @return
	 */
	public boolean verifyTabInResultsTab(String tabName) {
		return getTabsInResultsPage(tabName).isDisplayed();
	}

	/**
	 * click on any tab in results page ie. reports, grade book and drop box.
	 * 
	 * @param tabName
	 * @return
	 */
	public boolean clickOnTabInResultsTab(String tabName) {
		try {
			getTabsInResultsPage(tabName).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
