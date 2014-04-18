package com.qait.samlms.actions;

import org.openqa.selenium.WebDriver;

import com.qait.samlms.ui.pageobjects.SamAssignmentPageUi;
import com.qait.samlms.util.Sikuli;

public class SamAssignmentPageAction extends SamAssignmentPageUi {

	public SamAssignmentPageAction(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	/**
	 * verifies content player title
	 * 
	 * @param pageTitle
	 * @return
	 */
	public boolean verifyContentPlayerTitle(String pageTitle) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return verifyPageTitle(pageTitle);

	}

	/**
	 * click window icon to perform exam assignment.
	 * 
	 * @return
	 */
	public boolean clickWindowIcon() {
		try {
			Thread.sleep(4000);
			return Sikuli.handlingFlashForExam();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * perform training assignment.
	 * 
	 * @return
	 */
	public boolean performTraining() {
		try {
			Thread.sleep(4000);
			return Sikuli.performTraining();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	
}
