//package stepdefinition;
//
//import static org.testng.Assert.assertEquals;
//
//import java.time.Duration;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class LoginStep {
//	WebDriver driver = new ChromeDriver();
//	@Given("I am In the Orange HRM Login page")
//	public void i_am_in_the_orange_hrm_login_page() {
//		
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//
//        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//	}
//
//	@When("the user Provies the valid userID")
//	public void the_user_provies_the_valid_user_id() {
//		driver.findElement(By.name("username")).sendKeys("Admin");
//	}
//
//	@When("Provides the valid Password")
//	public void provides_the_valid_password() {
//        driver.findElement(By.name("password")).sendKeys("admin123");
//
//	}
//
//	@When("The user Clicks on Login button")
//	public void the_user_clicks_on_login_button() {
//        driver.findElement(By.xpath("//button[@type='submit']")).click();  
//
//	}
//
//	@Then("the user should be able to see the dashboard")
//	public void the_user_should_be_able_to_see_the_dashboard() {
//		 WebElement dashboard = driver.findElement(By.xpath("//h6[@class=\"oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module\"]"));
//		 String str = "OrangeHRM";
//		 String org = driver.getTitle();
//          assertEquals(org, str);
//      }
//	@Then("Quit")
//	public void quit() {
//	    driver.quit();
//	}
//
//	}
//
