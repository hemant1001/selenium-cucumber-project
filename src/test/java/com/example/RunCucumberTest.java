package com.example;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.example",
        plugin = {
            "pretty",
            "html:target/cucumber-report.html",
            "json:target/cucumber.json"
        },
        tags = "not @manual"
)
public class RunCucumberTest {
}
