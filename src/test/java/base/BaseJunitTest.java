package base;

import org.junit.After;
import org.junit.Before;

import driverFactory.MobileDriver;
import helper.DateHelper;
import helper.ScreenshotHelper;

public class BaseJunitTest {
	
	@Before
	public void setUp() {
		ScreenshotHelper.setFolderName(DateHelper.getDate("dd_MM_yyyy_HH_mm_ss"));
	}
	
	@After
	public void tearDown() {
		MobileDriver.quitDriver();
	}
}
