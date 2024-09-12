package testStep;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/scenarios/login.feature"}, glue = {"StepDefinition"})
public class Runner {
	
	

}
