package com.example.dragdrop;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/dragdrop",
        glue = "com.example.dragdrop",
        plugin = {"pretty", "html:target/dragdrop-report.html"},
        monochrome = true
)
public class RunDragDropTest {
}
