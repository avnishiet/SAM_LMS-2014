package com.qait.samlms.util;

import java.awt.Toolkit;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.KeyModifier;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class Sikuli {

	static String cwd = System.getProperty("user.dir");
	static String path = cwd + "\\" + "img";
	static Screen s1 = new Screen();
	static WebDriver driver;
	static int flag = 1;
	static int teststatus = 1;

	/**
	 * This method is used for handling flash for exam in SAM-LMS smoke test by
	 * student user
	 * 
	 * @return
	 */
	public static boolean handlingFlashForExam() {
		try {
			// maximizeWindow();
			s1.type(Key.UP, KeyModifier.WIN);
			Thread.sleep(5000);
			waitForImage("start_icon.png", 200);
			Pattern startIcon = new Pattern(path + "\\" + "start_icon.png");
			startIcon = startIcon.targetOffset(0, 10);
			s1.click(startIcon);
			waitForImage("All_programs_icon.png", 40);
			clickOnImage("\\" + "All_programs_icon.png");
			waitForImage("MicrosoftOffice.png", 40);
			Pattern msoffice = new Pattern(path + "\\" + "MicrosoftOffice.png");
			msoffice = msoffice.targetOffset(-76, 32);
			s1.click(msoffice);
			dragAndDrop("Scroller.png", "Scroll_Button.png");
			clickOnImage("\\" + "Powerpoint_Icon.png");
			waitForImage("Ok_Button.png", 40);
			clickOnImage("\\" + "Ok_Button.png");
			Thread.sleep(5000);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * This method used for perform training in smoke test by student user
	 * 
	 * @return
	 */
	public static boolean performTraining() {
		try {
			Thread.sleep(4000);
			s1.type(Key.UP, KeyModifier.WIN);
			System.out.println("window maximised");
			Thread.sleep(5000);
			waitForImage("Apply_Button.png", 60);
			clickOnImage("Apply_Button.png");
			System.out.println("clicked on apply button");
			Thread.sleep(4000);

			try {
				waitForImage("Continue_Button.png", 60);
				clickOnImage("Continue_Button.png");
			} catch (FindFailed e) {
				System.out.println("continue button not displayed");
			}

			try {
				waitForImage("startButtonTraining.PNG", 30);
				clickOnImage("startButtonTraining.PNG");
			} catch (FindFailed e) {
				System.out
						.println("exception handled in clicking start button");
				clickOnImage("Start_Button_Training.PNG");
			}

			waitForImage("All_Programs_Training.PNG", 60);
			s1.hover(path + "\\" + "All_Programs_Training.PNG");
			System.out.println("hovered on all programs");

			waitForImage("MS_Office_Training.PNG", 60);
			clickOnImage("MS_Office_Training.PNG");
			System.out.println("clicked on ms office");

			try {
				waitForImage("programList.PNG", 50);
				Pattern power = new Pattern(path + "\\" + "programList.PNG");
				power = power.targetOffset(0, 8);
				s1.click(power);
				System.out.println("clicked on powerpoint");
				Thread.sleep(5000);
			} catch (Exception e) {

			}

			waitForImage("Task_Complete_Message.png", 60);
			waitForImage("Task_Complete_Training.PNG", 60);
			clickOnImage("Task_Complete_Training.PNG");
			System.out.println("clicked on task complete");

			waitForImage("End_Training.PNG", 60);
			clickOnImage("End_Training.PNG");
			System.out.println("clicked on end training");

			waitForImage("closeButton.PNG", 60);
			clickOnImage("closeButton.PNG");
			System.out.println("clicked on close button");

			return true;
		} catch (Exception e) {

			return false;
		}
	}

	/**
	 * this method is used for wait for image in content flash player and
	 * passing the name of image and time out in milliseconds
	 * 
	 * @param name
	 * @param timeOut
	 * @throws FindFailed
	 */
	static void waitForImage(String name, int timeOut) throws FindFailed {
		s1.wait(path + "\\" + name, timeOut);

	}

	/**
	 * This method is used for click on an image and passing image name
	 * 
	 * @param name
	 * @throws FindFailed
	 */
	public static void clickOnImage(String name) throws FindFailed {
		s1.click(path + "\\" + name);

	}

	/**
	 * This method is used for double click on image and passing image name
	 * 
	 * @param name
	 * @throws FindFailed
	 */
	public static void DoubleclickOnImage(String name) throws FindFailed {
		s1.doubleClick(path + "\\" + name);

	}

	/**
	 * This method is used for drag and drop the particular image to another
	 * image
	 * 
	 * @param from
	 * @param to
	 * @throws FindFailed
	 */
	public static void dragAndDrop(String from, String to) throws FindFailed {
		s1.dragDrop(path + "\\" + from, path + "\\" + to);
	}

	/**
	 * This method is used for maximise the window
	 * 
	 * @throws InterruptedException
	 */
	public static void maximizeWindow() throws InterruptedException {

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Thread.sleep(2000);
		Dimension screenResolution = new Dimension((int) toolkit
				.getScreenSize().getWidth(), (int) toolkit.getScreenSize()
				.getHeight());
		driver.manage().window().setSize(screenResolution);
		driver.manage().window().maximize();
	}

}