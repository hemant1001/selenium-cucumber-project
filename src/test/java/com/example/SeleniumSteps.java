package com.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.assertTrue;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumSteps {

    private WebDriver driver;

    @Given("browser is ready")
    public void browser_is_ready() {
        // Setup ChromeDriver via WebDriverManager
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        // run headless by default so CI/local without display works
        options.addArguments("--headless", "--disable-gpu", "--no-sandbox");
        driver = new ChromeDriver(options);
    }

    @When("I open example.com")
    public void i_open_example_com() {
        driver.get("https://example.com");
    }

    @Then("page title contains Example")
    public void page_title_contains_example() {
        String title = driver.getTitle();
        assertTrue("Title should contain Example", title.contains("Example"));
        if (driver != null) {
            driver.quit();
        }
    }
}
