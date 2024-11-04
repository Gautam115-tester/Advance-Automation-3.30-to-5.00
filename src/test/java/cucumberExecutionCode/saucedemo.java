package cucumberExecutionCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class saucedemo {
WebDriver w;
	@Given("browser has been launch")
	public void browser_has_been_launch() {
	    w = new ChromeDriver();
	    w.manage().window().maximize();
	}
	@Given("It should redirect to https:\\/\\/www.saucedemo.com\\/.")
	public void it_should_redirect_to_https_www_saucedemo_com() {
	   w.get("https://www.saucedemo.com/");
	}
	@When("pass standard_user as value in username field.")
	public void pass_standard_user_as_value_in_username_field() {
	    w.findElement(By.id("user-name")).sendKeys("standard_user");
	}
	@When("pass secret_sauce as value in password field.")
	public void pass_secret_sauce_as_value_in_password_field() {
	    w.findElement(By.id("password")).sendKeys("secret_sauce");
	}
	@When("Click on login button")
	public void click_on_login_button() {
	   w.findElement(By.id("login-button")).click();
	}
	@Then("login is successfully")
	public void login_is_successfully() {
		String expectedurl = "https://www.saucedemo.com/inventory.html";
		String actualurl = w.getCurrentUrl();
		
		if (expectedurl.equals(actualurl)) {
			System.out.println("Login is Successful");
		} else {
System.out.println("login is unsuccessful");
		}
		
	}



	
}
