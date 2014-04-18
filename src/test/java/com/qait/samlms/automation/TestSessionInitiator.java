/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.samlms.automation;

import java.awt.Toolkit;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.qait.samlms.actions.ActivityListPageAction;
import com.qait.samlms.actions.AdminPageAction;
import com.qait.samlms.actions.DropBoxPageAction;
import com.qait.samlms.actions.HomePageAction;
import com.qait.samlms.actions.LoginPageAction;
import com.qait.samlms.actions.ProjectPageAction;
import com.qait.samlms.actions.ReadingActivityPageAction;
import com.qait.samlms.actions.ReportPageAction;
import com.qait.samlms.actions.SamAssignmentPageAction;
import com.qait.samlms.actions.SectionPageAction;
import com.qait.samlms.actions.StudentHomePageAction;
import com.qait.samlms.actions.UserPageAction;
import com.qait.samlms.util.YamlReader;

/**
 * 
 * @author QAIT
 */
public class TestSessionInitiator extends YamlReader {
	WebDriver driver;

	public LoginPageAction logPageAct;
	public UserPageAction userPageAction;
	public HomePageAction homePageAction;
	public AdminPageAction adminPageAction;
	public SectionPageAction sectionPageAction;
	public ProjectPageAction projectPageAction;
	public ActivityListPageAction activityListPageAction;
	public ReadingActivityPageAction readingActivityPageAction;
	public DropBoxPageAction dropBoxPageAction;
	public StudentHomePageAction studentHomePageAction;
	public SamAssignmentPageAction samAssignmentPageAction;
	public ReportPageAction reportPageAction;
	
	
	String browser;
	String seleniumserver;
	String seleniumserverhost;
	String appbaseurl;
	String applicationpath;
	String chromedriverpath;
	long timeout;
	Map<String, Object> chromeOptions = null;
	DesiredCapabilities capabilities;

	public TestSessionInitiator(String datafileloc) {
		setYamlFilePath(datafileloc);
		_getSessionConfig();
		_configureBrowser();
		_initPage();
	}

	public void TestSessionInitiator1() {
		_getSessionConfig();
		_configureBrowser();
		_initPage();
	}

	private void _configureBrowser() {
		Map<String, Object> driverConfig = getYamlValues("selenium");
		driver = WebDriverFactory.getDriver(driverConfig);
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		driver.manage().window().setPosition(new Point(0, 0));
		java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension dim = new Dimension((int) screenSize.getWidth(),
				(int) screenSize.getHeight());
		driver.manage().window().setSize(dim);
		driver.manage().window().maximize();
	}

	private void _getSessionConfig() {
		browser = getYamlValue("selenium.browser");
		seleniumserver = getYamlValue("selenium.server");
		seleniumserverhost = getYamlValue("selenium.remote.host");
		appbaseurl = getYamlValue("baseurl");
		applicationpath = appbaseurl;
		timeout = Integer.parseInt(getYamlValue("selenium.timeout"));
	}

	private void _initPage() {
		logPageAct = new LoginPageAction(driver);
		userPageAction = new UserPageAction(driver);
		homePageAction = new HomePageAction(driver);
		adminPageAction = new AdminPageAction(driver);
		sectionPageAction = new SectionPageAction(driver);
		projectPageAction = new ProjectPageAction(driver);
		activityListPageAction = new ActivityListPageAction(driver);
		readingActivityPageAction = new ReadingActivityPageAction(driver);
		dropBoxPageAction = new DropBoxPageAction(driver);
		studentHomePageAction = new StudentHomePageAction(driver);
		samAssignmentPageAction = new SamAssignmentPageAction(driver);
		reportPageAction = new ReportPageAction(driver);
	}

	public void launchApplication(String URL) {
		System.out.println("The application url is :- " + applicationpath);
		driver.get(URL);
	}

	public void launchUrl(String URL) {
		driver.get(URL);
	}

	public void launchApplicationUrl(String URL) {
		launchUrl(URL);
	}

	/**
	 * close browser session quit driver
	 */
	public void closeBrowserSession() {
		driver.quit();
	}
}