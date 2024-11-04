package cucumberExecutionCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MultiTestInSaucedemo {
WebDriver w;
	@Given("Browser has been launch And redircted to https:\\/\\/www.saucedemo.com\\/")
	public void browser_has_been_launch_and_redircted_to_https_www_saucedemo_com() {
	     w =  new ChromeDriver();
	     w.manage().window().maximize();
	     w.get("https://www.saucedemo.com/");
	}
	@When("Pass {string} as a value in username field And pass {string} as a value in password field.")
	public void pass_as_a_value_in_username_field_and_pass_as_a_value_in_password_field
	(String username, String password) throws Exception {
		Thread.sleep(1000);
		w.findElement(By.id("user-name")).sendKeys(username);
	   Thread.sleep(1000);
	   w.findElement(By.id("password")).sendKeys(password);
	}
	@Then("then click on login button And User should be logout After clicking on logout button.")
	public void then_click_on_login_button_and_user_should_be_logout_after_clicking_on_logout_button()
			throws Exception {
		w.findElement(By.id("login-button")).click();
		Thread.sleep(1000);
		w.findElement(By.id("react-burger-menu-btn")).click();
		Thread.sleep(1000);
		w.findElement(By.linkText("Logout")).click();
		
	}

	
}
