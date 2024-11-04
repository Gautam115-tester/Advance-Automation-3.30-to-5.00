package log4jDemo;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class SauceDemo {
	@Test
	public void login() throws Exception {
		Logger log = LogManager.getFormatterLogger();
		WebDriver w = new ChromeDriver();
		log.info("chromebrowser has been launch");
		w.manage().window().maximize();
		log.info("chromebrowser will get maximize");
		w.get("https://www.saucedemo.com/");
		log.info("chromebrowser has been redirected to saucedemo site");
		w.findElement(By.id("user-name")).sendKeys("1");
		log.info("username has been enter in username field");
		w.findElement(By.id("password")).sendKeys("secret_sauce");
		log.info("password has been enter in password field");
		w.findElement(By.id("login-button")).click();
		log.info("login button has been click");
		try {
			w.findElement(By.id("react-burger-menu-btn")).click();
			log.info("Open menu button has been clicked");
			TimeUnit.SECONDS.sleep(1);
			w.findElement(By.linkText("Logout")).click();
			log.info("logout link is click and user able to logout successful.");
		} catch (Exception e) {
			log.error("user login is unsuccessfully");
		}
		
	}
	
	
}
