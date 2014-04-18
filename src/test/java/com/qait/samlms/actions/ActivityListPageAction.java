package com.qait.samlms.actions;

import org.openqa.selenium.WebDriver;

import com.qait.samlms.ui.pageobjects.ActivityListPageUi;
/**
 * 
 * @author avnishrawat
 *
 */
public class ActivityListPageAction extends ActivityListPageUi {

	String[] activityListTabs = { "Exams", "Training", "Projects", "SAM Paths",
			"Readings", };
	StudentHomePageAction studentHomePageAction;

	/**
	 * constructor
	 * 
	 * @param driver
	 */
	public ActivityListPageAction(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	/**
	 * select section from drop down in activity list tab
	 * 
	 * @param sectionName
	 * @return
	 */
	public boolean selectSectionInActivityList(String sectionName) {

		return getSelectedDropdownValue(sectionName);
	}

	/**
	 * set on filters for desired tab of activity list
	 * 
	 * @param tabName
	 * @return
	 */
	public boolean setOnFilterButtonFor(String tabName) {
		try {
			for (String tab : activityListTabs) {
					System.out.println("tab"+tab);
					if (!tab.equalsIgnoreCase(tabName)) {
						getSetOnFilterButton(tab.toString()).click();
					}
				}
			
				
			
//			if (!getAlwaysAvailableTab().getAttribute("class")
//					.equalsIgnoreCase("AlwaysOn"))
//				getAlwaysAvailableTab().click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * select assignment
	 * 
	 * @param assignmentName
	 * @return
	 */
	public boolean selectAssignment(String assignmentName) {
		try {
			getSelectAssignment(assignmentName).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * click on start button
	 * 
	 * @return
	 */
	public boolean clickOnStartButton() {
		try {
			getAssignmentStratButton().click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
