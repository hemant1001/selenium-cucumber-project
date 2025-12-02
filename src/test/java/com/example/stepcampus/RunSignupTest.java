package com.example.stepcampus;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/stepcampus",
        glue = "com.example.stepcampus",
        plugin = {"pretty", "html:target/cucumber-stepcampus.html"}
)
public class RunSignupTest {
}
