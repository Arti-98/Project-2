package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"C:\\Users\\admin\\Documents\\workspace-spring-tools-for-eclipse-4.30.0.RELEASE\\Project-2\\Features"},
    glue = "StepDefination",
    plugin = {
        "pretty",
        "html:target/cucumber-reports/cucumber.html",
        "json:target/cucumber-reports/cucumber.json"
    },
    tags = "not @wip"
)
public class TestRunner {
}