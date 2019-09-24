package screens;

import org.openqa.selenium.By;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import base.BaseScreen;

public class RequestingCodeScreen extends BaseScreen {
	
	public boolean isRequestingCodeVisible() {
		return mobileDSL.isElementVisible(By.id("com.cabify.qabify:id/captcha_text"));
	}
	
	public void validateRequestingCodeScreen() {
		assertThat(mobileDSL.isElementVisible(By.xpath("//android.widget.TextView[@text='Remember this code for requesting a Taxi']")), is(true));
		assertThat(mobileDSL.isElementVisible(By.id("com.cabify.qabify:id/captcha_text")), is(true));
		assertThat(mobileDSL.isElementVisible(By.id("com.cabify.qabify:id/captcha_button")), is(true));
		assertThat(mobileDSL.isElementEnabled(By.id("com.cabify.qabify:id/captcha_button")), is(true));
	}
	
	public String getRequestingCode() {
		return mobileDSL.getText(By.id("com.cabify.qabify:id/captcha_text"));
	}
	
	public JourneySettingsScreen clickNextButton() {
		mobileDSL.click(By.id("com.cabify.qabify:id/captcha_button"));
		
		return new JourneySettingsScreen();
	}

}
