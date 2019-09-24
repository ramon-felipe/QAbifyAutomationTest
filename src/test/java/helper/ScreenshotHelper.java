package helper;

import static driverFactory.MobileDriver.getDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public final class ScreenshotHelper {
	
	private static String folderName = "";//DateHelper.getDate("dd_MM_yyyy_HH_mm_ss");
	
	public static String getFolderName() {
		return folderName;
	}


	public static void setFolderName(String folderName) {
		ScreenshotHelper.folderName = folderName;
	}

	public static void takeScreenshot() {
		try {
			File img = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
			String imgName = DateHelper.getDate("dd_MM_yyyy_HH_mm_ss");
			
			FileUtils.copyFile(img, new File("target/screenshots/" + getFolderName() + "/" + imgName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
