package com.qait.samlms.ui.pageobjects;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qait.samlms.util.SeleniumWait;
import com.qait.samlms.util.StringMatcher;

public class BasePage extends SeleniumWait {

	protected WebDriver driver;
	protected SeleniumWait expWait;
	private int waitTime = 60;
	public static int AJAX_WAIT = 25;
	public String window;

	public BasePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver = driver;
		expWait = new SeleniumWait(driver);
	}

	/**
	 * This method used to get the title of current page
	 * 
	 * @return
	 */
	public String getPageTitle() {
		return driver.getTitle();
	}

	/**
	 * 
	 * @param elementlist
	 * @param index
	 * @return
	 */
	protected WebElement getElementByIndex(List<WebElement> elementlist,
			int index) {
		return elementlist.get(index);
	}

	protected WebElement getElementByText(List<WebElement> elementlist,
			String elementtext) {
		WebElement element = null;
		for (WebElement elem : elementlist) {
			if (elem.getText().equalsIgnoreCase(elementtext)) {
				element = elem;
			}
		}
		// FIXME: handle if no element with the text is found in list
		if (element == null) {
		}
		return element;
	}

	public void getWindowHandle() {
		window = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	}

	/**
	 * switch to default content
	 */
	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

	/**
	 * This method is used to use hard wait in seconds
	 * 
	 * @param seconds
	 */
	public static void hardWaitInSeconds(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
		}
	}

	public static void explicitWait(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//*")));
	}

	public static String currentDateInStringFormat() {
		Date d = new Date();
		String formattedDate = "";
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy");
			formattedDate = formatter.format(d);
			System.out.println("Date:-" + formattedDate);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return formattedDate;
	}

	/**
	 * This method is used to handle alert by accept it.
	 */
	public void handleAlert() {
		try {

			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
		}
	}

	/**
	 * This method is used to print out the string on console
	 * 
	 * @param str
	 */
	public void printOutputOnConsole(String str) {
		System.out.println("\n");
		System.out.println(str);
		System.out.println("\n");
	}

	/**
	 * This method is used to perform click by using action builder
	 * 
	 * @param element
	 */
	public void performClickFromAction(WebElement element) {
		Actions builder = new Actions(driver);
		Action click = builder.doubleClick(element).build();
		click.perform();
	}

	/**
	 * This method is used to move mouse from one element to another element.
	 * 
	 * @param ele1
	 * @param ele2
	 * @return
	 */
	public boolean mouseMove(WebElement ele1, WebElement ele2) {
		Actions builder = new Actions(driver);
		Actions hoverOverRegistrar = builder.moveToElement(ele1);
		hoverOverRegistrar.build().perform();
		hoverOverRegistrar.click();
		ele2.click();
		return true;
	}

	/**
	 * This method is used to some wait for element to appear.
	 * 
	 * @param element
	 * @return
	 */
	@SuppressWarnings("unused")
	public boolean waitForElementToAppear(WebElement element) {
		long endTime = System.currentTimeMillis() + waitTime;
		int elementDisplayed = 0;
		while (System.currentTimeMillis() < endTime) {
			elementDisplayed++;
			try {
				if (element.isDisplayed()) {
					driver.manage()
							.timeouts()
							.implicitlyWait(BasePage.AJAX_WAIT,
									TimeUnit.SECONDS);
					return true;
				}
			} catch (Exception e) {
				BasePage.hardWaitInSeconds(1);
			}
		}// end while
		driver.manage().timeouts()
				.implicitlyWait(BasePage.AJAX_WAIT, TimeUnit.SECONDS);
		return false;
	}

	/**
	 * This method is used to clear all cookies.
	 */
	public void clearCookies() {
		driver.manage().deleteAllCookies();

	}

	/**
	 * This method is used to have 3 minute to generate report
	 */
	public void waitForReportToBeGenerated() {
		try {
			Thread.sleep(180000);
		} catch (Exception e) {

		}
	}

	/**
	 * This method is used to refresh the page
	 */
	public void refreshPage() {
		driver.navigate().refresh();

	}

	/**
	 * This method is used to handle the fore see appear pop up.
	 * 
	 * @return
	 */
	public boolean waitForForeSeeToAppear() {
		boolean flag = false;
		try {
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			driver.findElement(
					By.xpath("//a[contains(@class , 'declineButton')]"))
					.click();
			System.out.println("ForeSee Overlay was visible.");
			flag = true;
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			return flag;
		} catch (Exception e) {
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			return flag;
		}
	}

	/**
	 * Method For Implementing ScreenShot Feature
	 * 
	 * @author
	 * @param methodName
	 *            : Name of the method currently executing
	 */
	public void screenShotOnException(String methodName) {

		String testId = readFileToGetExecutingTestName();

		DateFormat dateFormat = new SimpleDateFormat("MMM-dd-yyyy-HH-mm");
		Date date = new Date();
		String date_time = dateFormat.format(date);
		String path = System.getProperty("user.dir");

		// Verifying Folder With Current Date Name Exists Or Not
		DateFormat dateFolder = new SimpleDateFormat("MMM-dd-yyyy");
		Date date2 = new Date();
		String dateNow = dateFolder.format(date2);
		File file = new File(path + "\\screenShot\\" + dateNow);
		boolean exists = file.exists();
		if (!exists) {
			new File(path + "\\screenShot\\" + dateNow).mkdir();
		}
		// Capturing Browser Screen
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		try {
			String saveImgFile = path + "\\screenShot\\" + dateNow + "\\"
					+ date_time + "_" + testId + "_" + methodName + ".png";
			FileUtils.copyFile(scrFile, new File(saveImgFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String readFileToGetExecutingTestName() {
		String strLine = "";
		try {
			String path = System.getProperty("user.dir")
					+ "\\screenShot\\executingTestId.txt";
			FileInputStream fstream = new FileInputStream(path);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			strLine = br.readLine();
			in.close();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
		return strLine;
	}

	/**
	 * verify page title
	 * 
	 * @param pageTitle
	 */
	public boolean verifyPageTitle(String pageTitle) {
		System.out.println("Page Title : " + driver.getTitle());
		return StringMatcher.match(driver.getTitle(), pageTitle, false);
	}

	/**
	 * wait For Spinner image To Disappear
	 * 
	 * @return
	 */
	public boolean waitForSpinnerToDisappear() {
		try {
			int i = 0;
			String check = driver.findElement(
					By.id("progressDiv"))
					.getCssValue("display");
			System.out.println("check::"+check);
			while (check.equals("false")) {
				check = driver.findElement(
						By.id("progressDiv")).getCssValue("display");
				System.out.println("check in loop::"+check);
				Thread.sleep(3000);
				i++;
				System.out.println("i::" + i);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * This method is used to switch the frame by using their class name.
	 * 
	 * @param value
	 */
	public void switchToFrame(String value) {
		switchToDefaultContent();
		WebElement frme = driver.findElement(By
				.xpath("//iframe[contains(@class,'" + value + "')]"));
		System.out.println("frame text :: " + frme.getText());
		driver.switchTo().frame(frme);

	}

	/**
	 * 
	 */
	public boolean getSelectedDropdownValue(String value) {
		WebElement drdn = driver.findElement(By
				.xpath("//select/option[contains(text(),\"" + value + "\")]"));
		// WebElement DrpDwn_selectedValue = driver.findElement(By
		// .xpath("//select/option[text()=\"" + value + "\"]"));
		System.out.println(drdn.getText());
		drdn.click();
		if (drdn.getText().equalsIgnoreCase(value))
			return true;
		return false;
	}

	public WebElement waitForElementToBePresent(WebElement locator) {
		Wait<WebDriver> wait = new WebDriverWait(driver, 120);
		return wait.until(ExpectedConditions.visibilityOf(locator));

	}

	public Alert waitForAlertToBePresent() {
		Wait<WebDriver> wait = new WebDriverWait(driver, 120);
		return wait.until(ExpectedConditions.alertIsPresent());

	}

	public boolean clickOnSubmitButton() {
		try {
			WebElement submit = driver.findElement(By
					.xpath("//input[@title='Submit']"));
			submit.click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public String getTextInXpath(WebElement element) {
		String methodName = Thread.currentThread().getStackTrace()[1]
				.getMethodName();
		waitForForeSeeToAppear();
		try {
			String s = element.toString();
			int i = s.indexOf("/");
			String substring = s.substring(i, s.length() - 1);
			int j = substring.indexOf("'");
			String text = substring.substring(j + 1, substring.length() - 2);

			return text;
		} catch (Exception e) {
			e.printStackTrace();
			screenShotOnException(methodName);
			return null;
		}

	}

	/**
	 * enter text in text box and verify text is present
	 * 
	 * @param element
	 * @param value
	 * @return
	 */
	public boolean enterText(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
		if (element.getText().equalsIgnoreCase(value))
			return true;
		return false;
	}

	/**
	 * used to select the radio button
	 * 
	 * @return
	 */
	public boolean selectRadioButton(WebElement element) {
		if (element.isSelected())
			return true;
		else {
			element.click();
			return element.isSelected();
		}
	}

	/**
	 * select check box
	 * 
	 * @param element
	 * @return
	 */
	public boolean selectCheckbox(WebElement element) {
		try {
			if (element.isSelected())
				return true;
			else {
				element.click();
				return element.isSelected();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * click on accept button in mind tap window
	 * 
	 * @return
	 */
	public boolean clickOnAcceptButton() {
		try {
			driver.findElement(By.xpath("//a[text()='Accept']")).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * get alert text
	 * 
	 * @return
	 */
	public String alertText() {
		try {
			Alert alert = driver.switchTo().alert();
			String text = alert.getText();
			return text;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * close driver and switch back to last window
	 */
	public boolean closeDriver() {
		driver.close();
		driver.switchTo().window(window);
		return driver.getWindowHandle().equalsIgnoreCase(window);
	}
}
