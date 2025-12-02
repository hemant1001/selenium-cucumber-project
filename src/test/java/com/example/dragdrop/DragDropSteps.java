package com.example.dragdrop;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

public class DragDropSteps {

    WebDriver driver;
    WebElement redCircle;
    WebElement target;

    @Given("I open the drag and drop page")
    public void openDragDropPage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Desktop\\java selenium\\src\\libs\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://practice.expandtesting.com/drag-and-drop-circles");

        redCircle = driver.findElement(By.xpath("//div[@class='red']"));
        target = driver.findElement(By.id("target"));
    }

    @When("I drag the red circle to the target")
    public void dragRedCircle() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(redCircle, target).build().perform();
        Thread.sleep(2000); // wait for animation
    }

    @Then("the circle should be successfully dropped")
    public void verifyDrop() {
        // Get the center positions of the red circle and target
        int circleX = redCircle.getLocation().getX() + redCircle.getSize().getWidth() / 2;
        int circleY = redCircle.getLocation().getY() + redCircle.getSize().getHeight() / 2;

        int targetX = target.getLocation().getX();
        int targetY = target.getLocation().getY();
        int targetWidth = target.getSize().getWidth();
        int targetHeight = target.getSize().getHeight();

        // Check if circle center is inside the target rectangle
        boolean insideTarget = circleX >= targetX && circleX <= targetX + targetWidth &&
                               circleY >= targetY && circleY <= targetY + targetHeight;

        assertTrue("Red circle should be inside target", insideTarget);

        driver.quit();
    }
}
