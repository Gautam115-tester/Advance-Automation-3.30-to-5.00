package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class Annotation {
	WebDriver w; // Global Variable
	@BeforeClass  // pre-condition which you want to execute 1 time.
	public void openBrowser() {
		w = new ChromeDriver();
		w.manage().window().maximize();
	}
	@BeforeMethod  // Pre-condition which you want to execute with your test condition multiple time then use this annotation
	public void openlink() {
		w.get("https://www.saucedemo.com/v1/");	
	}
	@Test // Test condition
	public void login() throws Exception {
		w.findElement(By.id("user-name")).sendKeys("standard_user");
		Thread.sleep(2000);
		w.findElement(By.id("password")).sendKeys("secret_sauce");
		Thread.sleep(2000);
		w.findElement(By.id("login-button")).click();
		Thread.sleep(2000);
	}
	@Test
	public void login1() throws Exception {
		w.findElement(By.id("user-name")).sendKeys("standard_user");
		Thread.sleep(2000);
		w.findElement(By.id("password")).sendKeys("secret_sauce");
		Thread.sleep(2000);
		w.findElement(By.id("login-button")).click();
		Thread.sleep(2000);
	}
	@AfterMethod
	public void logout() throws Exception {
		w.findElement(By.xpath("//*[@class=\"bm-burger-button\"]/button")).click();
		Thread.sleep(1000);
		w.findElement(By.cssSelector("a[id=\"logout_sidebar_link\"]")).click();
	}
	@AfterClass
	public void close() throws Exception {
		Thread.sleep(2000);
		w.close();
	}



}
