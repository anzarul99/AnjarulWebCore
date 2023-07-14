package com.web.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

public abstract class BaseTest {
	String testid;
	String testScenario;
	String testDescription;
	public static WebDriver driver;
	public static final Logger LOGGER=Logger.getLogger(BaseTest.class);
	
	
	public BaseTest(String testid, String testScenario, String testDescription) {
		this.testid = testid;
		this.testScenario = testScenario;
		this.testDescription = testDescription;
	}
	

	public abstract void runTest() throws Exception;
	
	@Test
	public final void testResult() throws Exception {
		runTest();
		System.out.println("This is main project running.");
		LOGGER.info("This is test result method");
	}
	
	public static void getBrowser(String browser,String url) {
		if(browser.equalsIgnoreCase("chrome")) {
			ChromeOptions option = new ChromeOptions();
			 driver = new ChromeDriver(option);
			 driver.get(url);
			 LOGGER.info("chrome browser opened.");
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			FirefoxOptions option = new FirefoxOptions();
			 driver = new FirefoxDriver(option);
			 driver.get(url);
			 LOGGER.info("firefox browser opened.");
		}
		
	}
	
	
	
	
	

}
