package base;

import static driverFactory.MobileDriver.getDriver;
import static helper.ScreenshotHelper.takeScreenshot;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import helper.WaitHelper;
import io.appium.java_client.MobileElement;

public final class MobileDSL {
	
	private WaitHelper waitHelper = null;
	
	public MobileDSL() {
		this.waitHelper = new WaitHelper();
	}

	public void sendKeys(By by, String text) {
		try {
			waitHelper.waitUntilElementVisible(by).sendKeys(text);
			takeScreenshot();
		} catch (Exception e) {
			System.out.println("Erro ao enviar texto para elemento.\n" + e.getMessage());
		}
	}
	
	public void click(By by) {
		try {
			takeScreenshot();
			waitHelper.waitUntilElementVisible(by).click();
			takeScreenshot();
		} catch (Exception e) {
			System.out.println("Erro ao clicar em elemento.\n" + e.getMessage());
		}		
	}
	
	public String getText(By by) {
		String text = null;
		
		try {
			 text = waitHelper.waitUntilElementVisible(by).getText();
			 takeScreenshot();
		} catch (Exception e) {
			System.out.println("Erro ao obter texto de elemento.\n" + e.getMessage());
		}
		
		return text;
	}
	
	public void selectComboOption(By by, String option) {
		waitHelper.waitUntilElementVisible(by).click();
		takeScreenshot();
		waitHelper.waitUntilElementVisible(By.xpath("//android.widget.ListView/android.widget.TextView[@text='" + option + "']")).click();
		takeScreenshot();
	}
	
	public boolean isCheckboxChecked(By by) {
		takeScreenshot();
		
		return (waitHelper.waitUntilElementVisible(by).getAttribute("checked").equalsIgnoreCase("true") ? true : false);
	}
	
	public boolean isCheckboxChecked(WebElement el) {
		takeScreenshot();
		
		return (waitHelper.waitUntilElementVisible(el).getAttribute("checked").equalsIgnoreCase("true") ? true : false);
	}
	
	public void checkCheckbox(By by) {
		if (! isCheckboxChecked(by)) {			
			getDriver().findElement(by).click();
			takeScreenshot();
		}
	}
	
	public void checkCheckbox(WebElement el) {
		if (! isCheckboxChecked(el)) {
			el.click();
			takeScreenshot();
		}
	}
	
	public void uncheckCheckbox(By by) {
		List<MobileElement> checkBoxes = getDriver().findElements(by);
		
		checkBoxes.forEach(checkBox -> {
			if (isCheckboxChecked(checkBox)) {
				checkBox.click();
			}
		});
	}
	
	public void uncheckCheckbox(WebElement el) {
		if (isCheckboxChecked(el)) {
			el.click();
			takeScreenshot();
		}
	}
	
	public boolean isElementVisible(By by) {
		sleep(1000);
		takeScreenshot();
		
		return getDriver().findElement(by).isDisplayed();
	}
	
	public boolean isElementEnabled(By by) {
		sleep(1000);
		takeScreenshot();
		
		return getDriver().findElement(by).isEnabled();
	}
	
	public void sleep(long milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}
