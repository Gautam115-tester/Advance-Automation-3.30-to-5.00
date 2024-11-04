package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DemoAssert {

	@Test
	public void Front() {
		WebDriver w = new ChromeDriver();
//		Soft assert example
		SoftAssert soft = new SoftAssert();
		w.get("https://demo.frontaccounting.eu/");
		w.manage().window().maximize();
		w.findElement(By.name("SubmitUser")).click();
		
		soft.assertEquals(w.getTitle(), "FrontAccounting 2.4.12 - Login");  // Wrong expected condition
		soft.assertEquals(w.getCurrentUrl(), "https://demo.frontaccounting.eu/dashboard"); // Wrong expected condition     
		
		soft.assertAll();
	}

}
