package com.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.assertTrue;

public class StepDefinitions {

    @Given("a sample step")
    public void a_sample_step() {
        // setup
    }

    @When("I run the test")
    public void i_run_the_test() {
        // action
    }

    @Then("it should pass")
    public void it_should_pass() {
        assertTrue(true);
    }
}
