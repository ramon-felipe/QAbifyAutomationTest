package steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.TempVar;
import screens.JourneySettingsScreen;

public class JourneySettingsSteps {
	
	private JourneySettingsScreen journeySScreen = new JourneySettingsScreen();
	
	@Then("^I validate the journey settings screen objects$")
	public void validateJourneyScreen() {
		journeySScreen.validateJourneySettingsScreen();
	}
	
	@And ("^I put the value \"(.*)\" in captcha field$")
	public void inputCaptcha(String captcha) {
		journeySScreen.inputCaptcha(captcha);
	}
	
	@And("I put the saved requesting code in captcha field")
	public void inputSavedRequestingCode() {
		journeySScreen.inputCaptcha(TempVar.requestingCode);
	}
	
	@And("^I select the pick up point \"(.*)\"$")
	public void selectPickupPoint(String pickUpPoint) {
		journeySScreen.selectJourneyPickUpPoint(pickUpPoint);
	}
	@And("^I select the drop off point \"(.*)\"$")
	public void selectDropOffPoint(String dropOffPoint) {
		journeySScreen.selectJourneyDropOffPoint(dropOffPoint);
	}
	
	@When("^I select the \"(.*)\" car type$")
	public void selectCarType(String carType) {
		journeySScreen.chooseCarType(carType);
	}
	
	@Then("^The \"(.*)\" car type is unselected$")
	public void isCarTypeUnselected(String carType) {
		assertThat(journeySScreen.isCarTypeSelected(carType), is(false));
	}
	
	@And("^I unselect all car type options$")
	public void unselectAllCarTypes() {
		journeySScreen.uncheckAllCarTypes();
	}
	
	@Then("The estimated price is \"(.*)\"")
	public void validateEstimatedPrice(String price) {
		assertThat(journeySScreen.getEstimatedPrice(), equalTo(price));
	}
	
	@And("^the REQUEST CAR button is showed$")
	public void isRequestCarButtonVisible() {
		assertThat(journeySScreen.isRequestCarButtonVisible(), is(true));
	}
	
	@And("^the REQUEST CAR button is enabled$")
	public void isRequestCarButtonEnabled() {
		assertThat(journeySScreen.isRequestCarButtonEnabled(), is(true));
	}
	
	@And("^I save the estimated price$")
	public void saveEstimatedPrice() {
		TempVar.estimatedPrice = journeySScreen.getEstimatedPrice();
	}
}
