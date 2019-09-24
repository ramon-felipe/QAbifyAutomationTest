package screens;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.openqa.selenium.By;

import base.BaseScreen;
import io.appium.java_client.MobileBy;

public class LoginScreen extends BaseScreen {

	public void isLoginScreenOpened() {
		assertThat(mobileDSL.isElementVisible(MobileBy.id("com.cabify.qabify:id/login_button")), is(true));
	}
	
	public void validateLoginScreen() {
		assertThat(mobileDSL.getText(By.xpath("//*[@resource-id='com.cabify.qabify:id/action_bar']/android.widget.TextView")), equalTo("QAbify"));
		assertThat(mobileDSL.isElementVisible(MobileBy.id("com.cabify.qabify:id/user_name_edit_text")), is(true));
		assertThat(mobileDSL.isElementEnabled(MobileBy.id("com.cabify.qabify:id/user_name_edit_text")), is(true));
		assertThat(mobileDSL.isElementVisible(MobileBy.id("com.cabify.qabify:id/password_edit_text")), is(true));
		assertThat(mobileDSL.isElementEnabled(MobileBy.id("com.cabify.qabify:id/password_edit_text")), is(true));
		assertThat(mobileDSL.isElementVisible(MobileBy.id("com.cabify.qabify:id/login_button")), is(true));
		assertThat(mobileDSL.isElementEnabled(MobileBy.id("com.cabify.qabify:id/login_button")), is(true));
	}
	
	public LoginScreen inputLogin(String login) {
		mobileDSL.sendKeys(MobileBy.id("com.cabify.qabify:id/user_name_edit_text"), login);

		return this;
	}
	
	public LoginScreen inputPassword(String password) {
		mobileDSL.sendKeys(MobileBy.id("com.cabify.qabify:id/password_edit_text"), password);
		
		return this;
	}
	
	public RequestingCodeScreen clickLoginButton() {
		mobileDSL.click(MobileBy.id("com.cabify.qabify:id/login_button"));
		
		return new RequestingCodeScreen();
	}
	
	public RequestingCodeScreen login(String login, String password) {
		return inputLogin(login)
				.inputPassword(password)
				.clickLoginButton()
		;
	}
}
