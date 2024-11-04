package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
public class Demo {
	@Test(priority = 2)  //@test --> test cases
	public void facebook1() {
		WebDriver w = new ChromeDriver();
		w.manage().window().maximize();
		w.get("https://www.google.com");
		w.findElement(By.id("APjFqb")).sendKeys("Speaker",Keys.ENTER);
	}
	@Test(priority = 1)
	public void facebook2() {
		WebDriver w = new ChromeDriver();
		w.manage().window().maximize();
		w.get("https://www.facebook.com/login/");
		w.findElement(By.id("email")).sendKeys("Xyz@gmail.com");
	}
	
	
}
