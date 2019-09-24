package base;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import driverFactory.MobileDriver;
import helper.DateHelper;
import helper.ScreenshotHelper;

public class BaseCucumberTest {
	
	@Before
	public void setUp(Scenario scenario) {
		ScreenshotHelper.setFolderName(scenario.getName() + "/" + DateHelper.getDate("dd_MM_yyyy_HH_mm_ss"));
	}
	
	@After
	public void tearDown() {
		MobileDriver.quitDriver();
	}
}
