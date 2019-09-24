package helper;

import static driverFactory.MobileDriver.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Enums.DefaultWaitTimes;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class WaitHelper {
	private AndroidDriver<MobileElement> driver = getDriver();
	private WebDriverWait mobileWait = new WebDriverWait(driver, DefaultWaitTimes.waitTime.getDefaultWaitTime());
	
	public MobileElement waitUntilElementVisible(By by) {
		return (MobileElement) mobileWait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	public MobileElement waitUntilElementVisible(By by, int seconds) {
		mobileWait = new WebDriverWait(getDriver(), seconds);
		return (MobileElement) mobileWait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	public MobileElement waitUntilElementVisible(WebElement el) {
		return (MobileElement) mobileWait.until(ExpectedConditions.visibilityOf(el));
	}
}
