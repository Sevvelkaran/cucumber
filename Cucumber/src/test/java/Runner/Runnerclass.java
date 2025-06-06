package Runner;


import org.testng.annotations.DataProvider;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = {"pretty", "json:target/cucumber-reports/Cucumber.json"}, features = "src/test/resources/com/features/sausedemo.feature",
glue = {"stepdefinition"}, tags = ("@ValidCredential"), monochrome = true, dryRun = false)
public class Runnerclass  extends AbstractTestNGCucumberTests{

}
