package com.test.weborder.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)//pushed to github 12-22
@CucumberOptions(
        features = "@target/uiFailedTests.txt",
        glue = "com/test/weborder/stepdefinitions",
        tags = "@regression",
        plugin = {"pretty", "html:target/uiReport.html", "rerun:target/uiFailedTests.txt"}
)
public class WebOrderReRunner {
}
