package screens;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.openqa.selenium.By;

import base.BaseScreen;
import io.appium.java_client.MobileBy;

public class JourneySettingsScreen extends BaseScreen {

	public JourneySettingsScreen selectJourneyPickUpPoint(String pickUpPoint) {
		mobileDSL.selectComboOption(By.id("com.cabify.qabify:id/pick_up_point"), pickUpPoint);
		
		return this;
	}
	
	public void validateJourneySettingsScreen() {
		assertThat(mobileDSL.isElementVisible(By.xpath("//android.widget.TextView[@text='Choose your journey settings']")), is(true));
		assertThat(mobileDSL.isElementVisible(By.xpath("//android.widget.TextView[@text='Select your origin and destination:']")), is(true));
		assertThat(mobileDSL.isElementVisible(By.xpath("//android.widget.TextView[@text='Pick up point:']")), is(true));
		assertThat(mobileDSL.isElementVisible(By.xpath("//android.widget.TextView[@text='Drop off point:']")), is(true));
		assertThat(mobileDSL.isElementVisible(By.xpath("//android.widget.TextView[@text='Choose your type of car:']")), is(true));
		assertThat(mobileDSL.isElementVisible(By.xpath("//android.widget.CheckBox[@text='Lite']")), is(true));
		assertThat(mobileDSL.isElementEnabled(By.xpath("//android.widget.CheckBox[@text='Lite']")), is(true));
		assertThat(mobileDSL.isElementEnabled(By.xpath("//android.widget.CheckBox[@text='Executive']")), is(true));
		assertThat(mobileDSL.isElementEnabled(By.xpath("//android.widget.CheckBox[@text='Executive']")), is(true));
		assertThat(mobileDSL.isElementVisible(By.xpath("//android.widget.TextView[@text='Type the captcha of the previous screen:']")), is(true));
		assertThat(mobileDSL.isElementEnabled(MobileBy.id("com.cabify.qabify:id/captcha_text")), is(true));
		assertThat(mobileDSL.isElementEnabled(MobileBy.id("com.cabify.qabify:id/captcha_text")), is(true));
		assertThat(mobileDSL.isElementVisible(By.xpath("//android.widget.TextView[@text='Estimated price:")), is(true));
		assertThat(mobileDSL.isElementEnabled(MobileBy.id("com.cabify.qabify:id/estimate_button")), is(true));
		assertThat(mobileDSL.isElementEnabled(MobileBy.id("com.cabify.qabify:id/estimate_button")), is(true));
	}
	
	public JourneySettingsScreen selectJourneyDropOffPoint(String dropOffPoint) {
		mobileDSL.selectComboOption(By.id("com.cabify.qabify:id/drop_off_point"), dropOffPoint);
		
		return this;
	}
	
	public JourneySettingsScreen uncheckAllCarTypes() {
		mobileDSL.uncheckCheckbox(By.xpath("//android.widget.RadioGroup/android.widget.CheckBox"));
		
		return this;
	}
	
	public JourneySettingsScreen chooseCarType(String carType) {	
		//this.uncheckAllCarTypes();
		mobileDSL.checkCheckbox(By.xpath("//android.widget.RadioGroup/android.widget.CheckBox[@text='" + carType + "']"));
		
		return this;
	}
	
	public JourneySettingsScreen inputCaptcha(String captcha) {
		mobileDSL.sendKeys(By.id("com.cabify.qabify:id/captcha_text"), captcha);
		
		return this;
	}
	
	public JourneySettingsScreen clickOnEstimateButton() {
		mobileDSL.click(By.id("com.cabify.qabify:id/estimate_button"));
		
		return this;
	}
	
	public String getEstimatedPrice(String pickUpPoint, String dropOffPoint, String carType, String captcha) {
		this.selectJourneyPickUpPoint(pickUpPoint)
			.selectJourneyDropOffPoint(dropOffPoint)
			.uncheckAllCarTypes()
			.chooseCarType(carType)
			.inputCaptcha(captcha)
			.clickOnEstimateButton()
		;
		
		return mobileDSL.getText(By.id("com.cabify.qabify:id/price_text"));
	}
	
	public JourneysHistoryScreen requestCar() {
		mobileDSL.click(By.id("com.cabify.qabify:id/request_button"));
		
		return new JourneysHistoryScreen();
	}
	
	public boolean isCarTypeSelected(String carType) {
		return mobileDSL.isCheckboxChecked(By.xpath("//android.widget.RadioGroup/android.widget.CheckBox[@text='" + carType + "']"));
	}
	
	public String getEstimatedPrice() {
		return mobileDSL.getText(By.id("com.cabify.qabify:id/price_text"));
	}
	
	public boolean isRequestCarButtonVisible() {
		return mobileDSL.isElementVisible(MobileBy.id("com.cabify.qabify:id/request_button"));
	}
	
	public boolean isRequestCarButtonEnabled() {
		return mobileDSL.isElementEnabled(MobileBy.id("com.cabify.qabify:id/request_button"));
	}
}
