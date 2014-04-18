package com.qait.samlms.actions;

import java.util.Set;

import org.openqa.selenium.WebDriver;

import com.qait.samlms.ui.pageobjects.ReadingActivityPageUi;

public class ReadingActivityPageAction extends ReadingActivityPageUi{

	public ReadingActivityPageAction(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	/**
	 * switch Mind tap window
	 */
	public boolean SwitchMindTapWindow(){
		try{
		Set<String> windows = driver.getWindowHandles();
		String[] wins = windows.toArray(new String[windows.size()]);
		driver.switchTo().window(wins[1]);
		return verifyPageTitle("MindTap - Cengage Learning");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * verify Ebook title
	 */
	public boolean verifyEbookTitleInMindtap(String ebookTitle){
		try{
			if(getEBookTitleInMindTap().getText().equalsIgnoreCase(ebookTitle)){
				return true;
			}
			return false;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	
	/**
	 * close mind tap window
	 */
	public boolean closeMindtapWindow(){
		try{
			Set<String> windows = driver.getWindowHandles();
			String[] wins = windows.toArray(new String[windows.size()]);
			driver.switchTo().window(wins[1]).close();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * select default window
	 */
	public boolean selectDefaultWindow(){
		try{
			Set<String> windows = driver.getWindowHandles();
			String[] wins = windows.toArray(new String[windows.size()]);
			driver.switchTo().window(wins[0]);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	
}
