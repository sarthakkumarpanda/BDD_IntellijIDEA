package com.tutorialsninja.qa.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        dryRun = false,
        monochrome = true,
        features = {"src/test/resources/feature_files" },
        glue     = {"com.tutorialsninja.qa.Step_Definitions", "com.tutorialsninja.qa.Hooks"},
        tags = "@TutorialsNinjaLogin or @TutorialsNinjaRegistration or @TutorialsNinjaSearchProduct",
        plugin = {"pretty", "html:target/site/cucumber-html", "json:target/cucumber1.json"}

   )

public class Runner_TestNG extends AbstractTestNGCucumberTests{

}
