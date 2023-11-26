package com.tutorialsninja.qa.Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		         features = "src/test/resources/feature_files",
                     glue = {"com.tutorialsninja.qa.Step_Definitions", "com.tutorialsninja.qa.Hooks"},
                    		 tags = "@TutorialsNinjaLogin or @@TutorialsNinjaRegistration or @TutorialsNinjaSearchProduct",
                    	        plugin = {"pretty", "html:target/site/cucumber-html", "json:target/cucumber1.json"}
                     
		         )

public class Runner_JUNIT {
}
