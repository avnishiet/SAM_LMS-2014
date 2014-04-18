package com.qait.samlms.actions;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qait.samlms.ui.pageobjects.ProjectPageUi;

public class ProjectPageAction extends ProjectPageUi {

	public ProjectPageAction(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	/**
	 * get the downloaded file name in download automation
	 * 
	 * @param targetDir
	 * @return
	 */
	public String getDownloadedFileName(String targetDir) {
		String fileName = null;
		File targetDirectory = new File(targetDir);
		File[] targetFiles = targetDirectory.listFiles();
		for (File file : targetFiles) {
			if (file.getName().contains(".")) {
				fileName = file.getName();
			}
		}
		return fileName;
	}


	/**
	 * click on download link to download
	 * 
	 * @return
	 */
	public boolean clickOnDownloadLink() {
		try {
			waitForElementToBePresent(
					driver.findElement(By
							.xpath("//div[@class='download-container']/span")))
					.click();
			// getDownloadLink().click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * download automation folder path
	 * 
	 * @return
	 */
	public String path() {
		String path = System.getProperty("user.dir") + "\\DownloadAutomation\\";
		System.out.println("path is " + path);
		return path;
	}

	/**
	 * save file
	 * 
	 * @return
	 */
	public File saveFile() {
		File file = new File(getDownloadedFileName(path()));
		return file;
	}

	/**
	 * upload the file in project assignments
	 * 
	 * @return
	 */
	public boolean uploadFile() {
		try {
			System.out.println("newFileName()" + newFileName());
			Thread.sleep(3000);
			renamer(path() + getDownloadedFileName(path()), path()
					+ newFileName());
			Thread.sleep(3000);
			System.out.println("getDownloadedFileName(path())"
					+ getDownloadedFileName(path()));
			getUploadFile().sendKeys(path() + saveFile().getName());
			Thread.sleep(3000);
			// String path = System.getProperty("user.dir")
			// + "\\DownloadAutomation\\";
			// File file = new File(path + newFileName());
			// file.delete();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * delete the downloaded file from download automation folder
	 * 
	 * @return
	 */
	public boolean deleteDownloadedFile() {
		try {
			String path = System.getProperty("user.dir")
					+ "\\DownloadAutomation\\";
			File file = new File(path + newFileName());
			file.delete();
			if (!file.exists())
				return true;
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * rename the downloaded file in download automation folder
	 * 
	 * @param oldFile
	 * @param newFile
	 * @return
	 */
	public boolean renamer(String oldFile, String newFile) {
		try {
			Thread.sleep(3000);
			File oldFileName = new File(oldFile);
			File newFileName = new File(newFile);
			if (oldFileName.renameTo(newFileName)) {
				oldFileName.delete();
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * get the new file name to replace with old
	 * 
	 * @return
	 */
	public String newFileName() {
		return getFileName().getText();
	}

	/**
	 * click on submit project button
	 * 
	 * @return
	 */
	public boolean clickOnSubmitProjectButton() {
		try {
			getSubmitButton().click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * verifies file uploaded with desired file Format , Virus Scan and file size
	 * @param fileFormat
	 * @param VirusScan
	 * @param fileSize
	 * @return
	 */
	public boolean verifyFileUploaded(String fileFormat,String VirusScan,String fileSize){
		for(WebElement td:getVerifyFileUploaded(fileFormat, VirusScan, fileSize)){
			if(!td.getAttribute("class").equalsIgnoreCase("verificationPassed")){
				return false;
			}
	}
		return true;
	}
	
}
