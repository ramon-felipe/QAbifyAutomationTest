package steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.openqa.selenium.By;

import base.MobileDSL;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GeneralSteps {
	
	private MobileDSL mobileDSL = new MobileDSL();

    @Then("^The message \"(.*)\" is showed$")
    public void isMessageShowed(String message) {
    	assertThat(mobileDSL.isElementVisible(By.xpath("//android.widget.TextView[@text='" + message + "']")), is(true));
    }
    
    //@And("^I click on \"(.*)\" button$")
    @When("^I click on \"(.*)\" button$")
    public void clickOnNextButton(String buttonText) {
    	mobileDSL.click(By.xpath("//android.widget.Button[@text='" + buttonText.toUpperCase() + "']"));
    }
    
}
