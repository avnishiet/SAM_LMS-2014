package com.qait.samlms.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWait {

    WebDriver driver;

    public SeleniumWait(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement getWhenVisible(By locator, int timeout) {
        WebElement element;
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        element = wait.until(ExpectedConditions
                .visibilityOfElementLocated(locator));
        return element;
    }

    public WebElement getWhenClickable(By locator, int timeout) {
        WebElement element;
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        return element;
    }
 
  
    public void clickWhenReady(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        WebElement element = wait.until(ExpectedConditions
                .elementToBeClickable(locator));
        element.click();
    }
    
    public void waitForDomToLoad () {
    	WebDriverWait wait = new WebDriverWait(driver, 80);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*")));		
	}
}
