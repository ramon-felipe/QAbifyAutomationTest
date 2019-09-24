package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import helper.TempVar;
import screens.RequestingCodeScreen;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class RequestScreenSteps {
	private RequestingCodeScreen rcodeScreen = new RequestingCodeScreen();
	
	@Then("^The requesting code screen is showed$")
	public void isRequestingCodeScreenShowed() {
		assertThat(rcodeScreen.isRequestingCodeVisible(), is(true));
	}
	
	@Then("^I validate the requesting code screen objects$")
	public void validateRequestingCodeScreenObjects() {
		rcodeScreen.validateRequestingCodeScreen();
	}
	
	@And("^I save the requesting code$")
	public void saveRequestCode() {
		TempVar.requestingCode = rcodeScreen.getRequestingCode();
	}
}
