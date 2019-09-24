package steps;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},
				 features = "src/test/java/steps/AppSteps.feature",
                 glue = {"base", "steps"})
public class TestsRunner {
}