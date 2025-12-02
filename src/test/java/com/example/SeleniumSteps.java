package com.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class SeleniumSteps {

    public WebDriver driver;

    public void openLoginPage() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
    }

    public void enterCredentials() {
        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("password")).sendKeys("learning");
    }

    public void selectUserRadio() {
        driver.findElement(By.xpath("//input[@value='user']")).click();
    }

    public void clickOkayButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("okayBtn"))).click();
    }

    public void selectDropdown() {
        Select opt = new Select(driver.findElement(By.cssSelector("select.form-control")));
        opt.selectByIndex(2);
    }

    public void acceptTermsAndLogin() {
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("signInBtn")).click();
    }

    public boolean isLoginSuccessful() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("shop"));
        return true;
    }

    public void closeBrowser() {
        driver.quit();
    }
}
