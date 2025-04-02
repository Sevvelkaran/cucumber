package stepdefinition;

import static org.testng.Assert.assertEquals;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class dashboard {
    WebDriver driver = new FirefoxDriver();

    @Before
    public void before() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @Given("I want to Assert the dashboard")
    public void i_want_to_assert_the_dashboard() {
    
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @When("The user enters username as {string} and Password as {string}")
    public void the_user_enters_username_as_and_password_as(String string, String string2) {
        driver.findElement(By.name("username")).sendKeys(string);
        driver.findElement(By.name("password")).sendKeys(string2);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @When("Assert the name Dashboard {string}")
    public void assert_the_name_dashboard(String expectedDashboardText) {
        WebElement dash = driver.findElement(By.xpath("//h6[text()='Dashboard']"));
        assertEquals(dash.getText(), expectedDashboardText);
    }

    @Then("the user asserts all the quick Action {string}")
    public void the_user_asserts_all_the_quick_action(String quickAction) {
        String actualText = "";
        String expectedText = quickAction;

        switch (quickAction) {
            case "Assign Leave":
                actualText = driver.findElement(By.xpath("//p[text()='Assign Leave']")).getText();
                break;
            case "Leave List":
                actualText = driver.findElement(By.xpath("//p[text()='Leave List']")).getText();
                break;
            case "Timesheets":
                actualText = driver.findElement(By.xpath("//p[text()='Timesheets']")).getText();
                break;
            case "Apply Leave":
                actualText = driver.findElement(By.xpath("//p[text()='Apply Leave']")).getText();
                break;
            case "My Leave":
                actualText = driver.findElement(By.xpath("//p[text()='My Leave']")).getText();
                break;
            case "My Timesheet":
                actualText = driver.findElement(By.xpath("//p[text()='My Timesheet']")).getText();
                break;
            default:
                throw new IllegalArgumentException("Invalid quick action: " + quickAction);
        }

        assertEquals(actualText, expectedText);
    }
    
    @After
    public void after() {
    	driver.quit();
    }
}
