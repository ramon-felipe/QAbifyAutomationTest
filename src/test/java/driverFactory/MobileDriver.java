package driverFactory;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public final class MobileDriver {
	
	private static AndroidDriver<MobileElement> mobileDriver;
	
	public static AndroidDriver<MobileElement> getDriver(){
		if(mobileDriver == null) {
			setDriver();
		}
		
		return mobileDriver;
	}
	
	public static void setDriver(){
		File apk  = new File("resources/apps/qabify2019.apk");
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		URL remoteUrl = null;
		
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		desiredCapabilities.setCapability(MobileCapabilityType.APP, apk.getAbsolutePath());
		desiredCapabilities.setCapability("appActivity", "com.cabify.qabify.MainActivity");
		desiredCapabilities.setCapability("appPackage", "com.cabify.qabify");
		
		try {
			remoteUrl = new URL("http://localhost:4723/wd/hub");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		mobileDriver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
		mobileDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	public static void quitDriver() {
		if(mobileDriver != null) {
			mobileDriver.quit();
			mobileDriver = null;
		}
	}
	
}
