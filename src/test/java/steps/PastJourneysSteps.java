package steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import screens.JourneysHistoryScreen;

public class PastJourneysSteps {
	private JourneysHistoryScreen jorneyHistoryScreen = new JourneysHistoryScreen();
	
	@Then("^The last journey title must be \"(.*)\"$")
	public void validateLastPastJourneyTitle(String lastPastJourneyTitle) {
		assertThat(jorneyHistoryScreen.getLastJourneyTitle(), equalTo(lastPastJourneyTitle));
	}
	
	@And("^The last journey price must be \"(.*)\"$")
	public void validateLastPastJourneyPrice(String lastPastJourneyPrice) {
		assertThat(jorneyHistoryScreen.getLastJourneyPrice(), equalTo(lastPastJourneyPrice));
	}
}
