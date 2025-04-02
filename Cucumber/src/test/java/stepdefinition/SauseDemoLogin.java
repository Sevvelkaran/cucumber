package stepdefinition;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class SauseDemoLogin {

    WebDriver driver;

    @Before
    public void setup() {
        FirefoxOptions options = new FirefoxOptions();
        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("I am in the SauceDemo Login Page")
    public void iam_in_the_sauce_demo_login_page() {
        driver.get("https://www.saucedemo.com");
    }

    @When("The user provides the Username")
    public void the_user_provides_the_username() {
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
    }

    @When("The User provides the Password")
    public void the_user_provides_the_password() {
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
    }

    @When("Clicking on the login button")
    public void clicking_on_the_login_button() {
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @Then("I want to verify that I am logged in or not")
    public void i_want_to_verify_that_i_am_logged_in_or_not() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "Swag Labs";
        assertEquals(actualTitle, expectedTitle, "Login failed!");
    }

    @When("The user provides an invalid Username")
    public void the_user_provides_invalid_username() {
        driver.findElement(By.name("user-name")).sendKeys("tandard_user");
    }

    @Then("I want to see an error message")
    public void i_want_to_see_error_message() {
        WebElement error = driver.findElement(By.xpath("//h3[contains(text(), 'Epic sadface')]"));
        String expectedMessage = "Epic sadface: Username and password do not match any user in this service";
        assertEquals(error.getText(), expectedMessage, "Error message mismatch!");
    }

    @When("The User provides an invalid Password")
    public void the_user_provides_invalid_password() {
        driver.findElement(By.name("password")).sendKeys("Sec");
    }

    @When("The user provides no username")
    public void the_user_provides_no_username() {
        driver.findElement(By.name("user-name")).sendKeys(""); // Fix: Explicitly sending an empty string
    }

    @Then("I want to see an error message for no username")
    public void i_want_to_see_error_message_of_no_username() {
        WebElement error = driver.findElement(By.xpath("//h3[contains(text(), 'Epic sadface')]"));
        String expectedMessage = "Epic sadface: Username is required";
        assertEquals(error.getText(), expectedMessage, "Error message mismatch!");
    }

    @When("The User provides no Password")
    public void the_user_provides_no_password() {
        driver.findElement(By.name("password")).sendKeys(""); // Fix: Explicitly sending an empty string
    }

    @Then("I want to see an error message for no Password")
    public void i_want_to_see_error_message_of_no_password() {
        WebElement error = driver.findElement(By.xpath("//h3[contains(text(), 'Epic sadface')]"));
        String expectedMessage = "Epic sadface: Password is required";
        assertEquals(error.getText(), expectedMessage, "Error message mismatch!");
    }
}
