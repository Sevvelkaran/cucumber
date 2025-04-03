package stepdefinition;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.*;

public class datatable {
WebDriver driver;
@Given("The user is on Orange HRM")
public void the_user_is_on_orange_hrm() {
    driver = new FirefoxDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    driver.manage().deleteAllCookies();
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

}

@When("User enters valid credentials")
public void user_enters_valid_credentials(io.cucumber.datatable.DataTable dataTable)throws InterruptedException {

	//System.out.println("Credentials Entered");
//    List<List<String>> signUpForm=dataTable.asLists(String.class);
	List<Map<String, String> > user = dataTable.asMaps(String.class, String.class);
	for(Map<String, String> from : user) {
    String Username=user.get(0).get("Username");
    System.out.println("Username : "+ Username);
    driver.findElement(By.name("username")).sendKeys(Username);

    String Password=user.get(0).get("Password");
    System.out.println("Password : "+ Password);
    driver.findElement(By.name("password")).sendKeys(Password);
    driver.findElement(By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--main orangehrm-login-button\"]")).submit();
    
    String errorMessage = user.get(0).get("ErrorMessage");
    String actualMeassage = driver.findElement(By.xpath("//*[@class = 'orangehrm-login-error']/div[1]/div[1]/p")).getText();
    System.out.println("ActualErrorMeassage  :"+actualMeassage);
    
    assertTrue(actualMeassage.equalsIgnoreCase(errorMessage));
}
}



@Then("user should be able to login sucessfully and new page open")
public void user_should_be_able_to_login_sucessfully_and_new_page_open() {
	 WebElement dashboard = driver.findElement(By.xpath("//h6[@class=\"oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module\"]"));
	 String str = "OrangeHRM";
	 String org = driver.getTitle();
      assertEquals(org, str);
}

}
