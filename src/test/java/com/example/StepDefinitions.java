package com.example;

import io.cucumber.java.en.*;
import static org.junit.Assert.assertTrue;

public class StepDefinitions {

    SeleniumSteps selenium = new SeleniumSteps();

    @Given("I navigate to login page")
    public void i_navigate_to_login_page() {
        selenium.openLoginPage();
    }

    @When("I enter username and password")
    public void i_enter_username_and_password() {
        selenium.enterCredentials();
    }

    @When("I select user radio button")
    public void i_select_user_radio_button() {
        selenium.selectUserRadio();
    }

    @When("I click okay button")
    public void i_click_okay_button() {
        selenium.clickOkayButton();
    }

    @When("I select dropdown option")
    public void i_select_dropdown_option() {
        selenium.selectDropdown();
    }

    @When("I accept terms and submit login")
    public void i_accept_terms_and_submit_login() {
        selenium.acceptTermsAndLogin();
    }

    @Then("login is successful")
    public void login_is_successful() {
        assertTrue("Login should be successful", selenium.isLoginSuccessful());
        selenium.closeBrowser();
    }
}
