package com.qait.samlms.util;

import java.io.IOException;

import org.testng.annotations.Test;

import com.qait.samlms.util.TestRunner;

public class LaunchTestsHere extends TestRunner{

	@Test
	public void startTestHere() throws IOException, InterruptedException{
	initiateTest(yaml.getYamlValue("SUITE_NAME"));
	}
}
