package com.tutorialsninja.qa.Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/feature_files",
                 glue = {"com.tutorialsninja.qa.Step_Definitions", "com.tutorialsninja.qa.Hooks"},
                  tags = "@TutorialsNinjaRegistration")

public class Runner_JUNIT {
}
