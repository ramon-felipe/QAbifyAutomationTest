package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import screens.LoginScreen;

public class LoginSteps {

	private LoginScreen loginScreen = new LoginScreen();
	
	@Given("^I am at login screen$")
    public void isLoginScreenOpened() {
    	loginScreen.isLoginScreenOpened();
    }
	
	@Given("^I input login \"(.*)\"$")
	public void inputLogin(String login) {
		loginScreen.inputLogin(login);
	}
	
	@And("^I input password \"(.*)\"$")
	public void inputPass(String pass) {
		loginScreen.inputPassword(pass);
	}
    
    @Given("^I login the app$")
    public void loginApp() {
    	loginScreen.login("user@qabify.com", "1234Abc");
    }
    
    @Then("^I validate the login screen objects$")
    public void validateLoginScreen() {
    	loginScreen.validateLoginScreen();
    }
}
