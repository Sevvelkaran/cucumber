package stepdefinition;
import static org.testng.Assert.assertEquals;

import java.time.Duration;import org.apache.logging.log4j.core.pattern.EqualsIgnoreCaseReplacementConverter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.*;

public class Outline {
	WebDriver driver = new FirefoxDriver();

@Given("User is on Home Screen")
public void user_is_on_home_screen() {

    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
}

@When("User enters UserName as {string} and Password as {string}")
public void user_enters_user_name_as_and_password_as(String string, String string2) {
	driver.findElement(By.name("username")).sendKeys(string);
    driver.findElement(By.name("password")).sendKeys(string2);
    driver.findElement(By.xpath("//button[@type='submit']")).click();  


}

@Then("User should be able to see an {string}")
public void user_should_be_able_to_see_an(String string) {
    
	System.out.println("error msg :"+string);
	if(string.equalsIgnoreCase("Invalid credentials"))
	{
		String act=driver.findElement(By.xpath("//p[@class=\"oxd-text oxd-text--p oxd-alert-content-text\"]")).getText();
		assertEquals("Invalid credentials", act);
	}
	else if(string.equalsIgnoreCase("Required"))
	{
		String act=driver.findElement(By.xpath("//span[@class=\"oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message\"]")).getText();
		assertEquals("Required", act);
	}
	else {
		System.out.println("Check the code");
	}
	
	
}



}
