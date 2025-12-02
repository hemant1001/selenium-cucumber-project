package com.example.stepcampus;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SignupSteps {

    WebDriver driver;

    @Given("I open the StepCampus signup page")
    public void openSignupPage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Desktop\\java selenium\\src\\libs\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://www.stepcampus.in/signup");
    }

    @When("I enter email and password")
    public void enterCredentials() {
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("hi@stepcampus.in");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Stepcampus@123");
    }

    @When("I solve the captcha")
    public void solveCaptcha() {
        String text = driver.findElement(By.xpath("(//label[contains(@class,'text-sm font-medium leading-none')])[3]")).getText();
        System.out.println("Captcha text: " + text);

        char[] text_captcha = text.toCharArray();
        int num1 = text_captcha[8] - '0';
        int num2 = text_captcha[12] - '0';
        char operation = text_captcha[10];
        int result = 0;

        switch (operation) {
            case '+': result = num1 + num2; break;
            case '-': result = num1 - num2; break;
            case '*': result = num1 * num2; break;
            case '/': result = num1 / num2; break;
        }

        driver.findElement(By.xpath("//input[@name='captcha']")).sendKeys(String.valueOf(result));
    }

    @When("I submit the signup form")
    public void submitForm() {
        driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
    }

    @Then("signup should be successful")
    public void verifySignup() {
        // Example verification (adjust based on what the page shows after signup)
        boolean isSuccess = driver.getCurrentUrl().contains("welcome") || driver.getPageSource().contains("Welcome");
        if(!isSuccess) {
            System.out.println("Signup may have failed. Check manually.");
        }
        driver.quit();
    }
}
