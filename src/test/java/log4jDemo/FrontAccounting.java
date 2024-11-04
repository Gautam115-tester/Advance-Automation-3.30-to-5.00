package log4jDemo;

import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrontAccounting {

	public static void main(String[] args) {
		
		Logger log = LogManager.getFormatterLogger(FrontAccounting.class);
		WebDriver w = new ChromeDriver();
		log.info("Browser lauch successfully");
		w.manage().window().maximize();
		log.info("Browser Has been maximize");
		w.get("https://demo.frontaccounting.eu/");
		log.info("Browser has been redirect to frontaccounting site");
		w.findElement(By.name("user_name_entry_field")).clear();
		w.findElement(By.name("password")).clear();
		log.info("Username and password data has been cleared.");
		w.findElement(By.name("user_name_entry_field")).sendKeys("demo");
		w.findElement(By.name("password")).sendKeys("password");
		log.info("username and password field data has been implement in there respectively field");
		w.findElement(By.name("SubmitUser")).click();
		log.info("User has click on login button");
		try {
		   w.findElement(By.linkText("Logout")).click();
		   log.info("user has been logout successfully after login");		
		} catch (Exception e) {
			log.error("User is not able to login");
		}
	}
}
