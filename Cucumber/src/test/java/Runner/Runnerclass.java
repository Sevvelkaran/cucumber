package Runner;


import org.testng.annotations.DataProvider;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = {"pretty", "html:target/cucumber-reports/Cucumber.html"}, features = "src/test/resources/com/features/sausedemo.feature",
glue = "stepdefinition")
public class Runnerclass  extends AbstractTestNGCucumberTests{

}
