# selenium-cucumber-project

This repository is a minimal Selenium + Cucumber Java project scaffold.

Run the default tests (does not execute Selenium scenarios marked `@manual`):

```powershell
mvn test
```

To run the Selenium scenario (Chrome), remove the `@manual` tag from `src/test/resources/features/selenium.feature` or update the `RunCucumberTest` tags in `src/test/java/com/example/RunCucumberTest.java`.

Prerequisites:
- Java 21 installed and available to Maven
- Google Chrome installed (for the Selenium scenario)

WebDriverManager will download the correct ChromeDriver automatically when you run the Selenium scenario.
