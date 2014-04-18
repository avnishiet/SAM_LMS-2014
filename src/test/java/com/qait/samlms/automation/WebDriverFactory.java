/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.samlms.automation;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qait.samlms.util.YamlReader;



@SuppressWarnings("unchecked")
public class WebDriverFactory {
	private static String browser;
	private static DesiredCapabilities capabilities = new DesiredCapabilities();
	public static WebDriver getDriver(Map<String, Object> seleniumconfig) {
		seleniumconfig = (Map<String, Object>) seleniumconfig.get("selenium");
		browser = seleniumconfig.get("browser").toString();
		if (seleniumconfig.get("server").toString().equalsIgnoreCase("local")) {
			if (browser.equalsIgnoreCase("firefox")) {
				return createFirefoxDriver(getFirefoxProfile());
			} else if (browser.equalsIgnoreCase("chrome")) {
				return setChromeDriver(seleniumconfig.get("driverpath").toString());
			} else if (browser.equalsIgnoreCase("Safari")) {
				return setSafariDriver();
			} else if ((browser.equalsIgnoreCase("ie")) || (browser.equalsIgnoreCase("internetexplorer")) || (browser.equalsIgnoreCase("internet explorer"))) {
				return setInternetExplorerDriver(seleniumconfig.get("driverpath").toString());
			}
		}
		if (seleniumconfig.get("server").toString().equalsIgnoreCase("remote")) {
			return setRemoteDriver(seleniumconfig);
		}
		return new FirefoxDriver();
	}

	private static WebDriver setRemoteDriver(Map<String, Object> selConfig) {
		DesiredCapabilities cap = null;
		browser  =  YamlReader.getYamlValue("browser");
		//browser = selConfig.get("browser").toString();
		if (browser.equalsIgnoreCase("firefox")) {
			cap = DesiredCapabilities.firefox();
		} else if (browser.equalsIgnoreCase("chrome")) {
			cap = DesiredCapabilities.chrome();
		} else if (browser.equalsIgnoreCase("Safari")) {
			cap = DesiredCapabilities.safari();
		} else if ((browser.equalsIgnoreCase("ie")) || (browser.equalsIgnoreCase("internetexplorer")) || (browser.equalsIgnoreCase("internet explorer"))) {
			cap = DesiredCapabilities.internetExplorer();
		}
		String seleniumserveraddress = YamlReader.getYamlValue("remoteURL");
		URL selserverhost = null;
		try {
			selserverhost = new URL(seleniumserveraddress);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		cap.setJavascriptEnabled(true);
		return new RemoteWebDriver(selserverhost, cap);
	}

	private static WebDriver setChromeDriver(String driverpath) {
		System.setProperty("webdriver.chrome.driver", driverpath+"chromedriver.exe");
		capabilities.setJavascriptEnabled(true);
		return new ChromeDriver();
	}

	private static WebDriver setInternetExplorerDriver(String driverpath) {
		System.setProperty("webdriver.ie.driver", driverpath+"IEDriverServer.exe");
		return new InternetExplorerDriver();
	}

	private static WebDriver setSafariDriver() {
		return new SafariDriver();
	}

	private static WebDriver createFirefoxDriver(FirefoxProfile firefoxProfile) {
		return new FirefoxDriver(firefoxProfile);
	}

	private static FirefoxProfile getFirefoxProfile() {
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		try {
		//	String firefoxPath= PropFileHandler.readProperty("firefoxPath");
		
//		   File file = new File("firebug_1.10.3.xpi"); //NEW
//		   FirefoxProfile profile = new FirefoxProfile();
//		   profile.setPreference("browser.download.dir", System.getProperty(  "user.dir" )+"\\DownloadAutomation");
//		   profile.setPreference("browser.download.folderList", 2);
//		   profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");
//		   profile.setPreference("browser.download.useDownloadDir", true);
//		   profile.addExtension(file); //NEW
//		   profile.setPreference("extensions.firebug.currentVersion", "1.10.3"); //NEW
//		  
//		   driver = new FirefoxDriver(new FirefoxBinary(new File(firefoxPath)), profile);
//		   //driver = new FirefoxDriver(profile);
//			
			/////////////////////////////////////////////////
			File file = new File("resources\\firebug.extension\\firebug_1.10.3.xpi");
			firefoxProfile.setPreference("browser.download.dir", System.getProperty(  "user.dir" )+"\\DownloadAutomation");
			firefoxProfile.setPreference("browser.download.folderList", 2);
			firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");
			firefoxProfile.setPreference("browser.download.useDownloadDir", true);
			firefoxProfile.addExtension(file); //NEW
			firefoxProfile.setPreference("extensions.firebug.currentVersion", "1.10.3"); //NEW
			  
//			firefoxProfile.addExtension(new File("resources\\firebug.extension\\firebug-1.12.5-fx.xpi"));
//			firefoxProfile.setPreference("extensions.firebug.currentVersion", "1.12.5");
//			firefoxProfile.setPreference("extensions.firebug.script.enableSites", true);
//			firefoxProfile.setPreference("extensions.firebug.console.enableSites", true);
//			firefoxProfile.setPreference("extensions.firebug.allPagesActivation", true);
//			firefoxProfile.setPreference("extensions.firebug.delayLoad", false);
//			firefoxProfile.addExtension(new File("resources\\firebug.extension\\firepath-0.9.7-fx.xpi"));
			firefoxProfile.addExtension(file); //NEW
			firefoxProfile.setPreference("extensions.firebug.currentVersion", "1.10.3"); //NEW
		}catch (IOException e) {
			e.printStackTrace();
			Logger.getLogger(WebDriverFactory.class.getName()).log(Level.SEVERE, null, e);
		}
		return firefoxProfile;
	}
}