package com.qait.samlms.test.smoke;

import static com.qait.samlms.util.YamlReader.getYamlValue;

import com.qait.samlms.util.PropFileHandler;

public class BaseTest {
	
	//get base url from TestData.yaml file
	protected String baseUrl = getYamlValue("baseurl");
	
	//get user name of all users from filename.properties file and TestData.Yaml file.
	protected String superUser = getYamlValue("users.SuperUser.UserName");
	protected String adminUser = PropFileHandler.readProperty("adminUser");
	protected String studentUser = PropFileHandler.readProperty("studentUser");
	protected String instructorUser = PropFileHandler.readProperty("instructorUser");
	
	//get password of all users from TestData.Yaml file.
	protected String password = getYamlValue("users.Password");
	
	//get assignment names and section names from filename.properties file.
	protected String sectionName = PropFileHandler.readProperty("sectionName");
	protected String examName= PropFileHandler.readProperty("examName");
	protected String trainingName= PropFileHandler.readProperty("trainingName");
	protected String projectName= PropFileHandler.readProperty("projectName");
	protected String secondSectionName = PropFileHandler.readProperty("secondSectionName");
	
	//get first name and last name of all users from TestData.Yaml file.
	protected String firstName = getYamlValue("users.FirstName");
	protected String lastName = getYamlValue("users.LastName");
	
	//get user role from TestData.Yaml file.
	protected String administratorRole = getYamlValue("users.Roles.AdministratorRole");
	protected String instructorRole = getYamlValue("users.Roles.InstructorRole");
	protected String studentRole=getYamlValue("users.Roles.StudentRole");
		
}
