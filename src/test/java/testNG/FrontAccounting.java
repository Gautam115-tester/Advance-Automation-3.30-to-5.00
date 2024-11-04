package testNG;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.internal.annotations.DataProviderAnnotation;
public class FrontAccounting {
WebDriver w;
	@BeforeClass
	public void openBrowser() {
		w = new ChromeDriver();
	}
	@BeforeMethod
	public void openUrl() {
		w.get("https://demo.frontaccounting.eu/");
	}
	@Test(dataProviderClass = MultiDataForFrontAccountingTesting.class , dataProvider = "getdata")
	public void login(String user , String pass) throws Exception {
		w.findElement(By.name("user_name_entry_field")).clear();
		Thread.sleep(2000);
		w.findElement(By.name("user_name_entry_field")).sendKeys(user);
		Thread.sleep(2000);
		w.findElement(By.name("password")).clear();
		Thread.sleep(2000);
		w.findElement(By.name("password")).sendKeys(pass);
		Thread.sleep(2000);
		w.findElement(By.name("SubmitUser")).click();
		Thread.sleep(2000);
	}
	@AfterMethod
	public void logout() throws Exception {
		try {
			w.findElement(By.linkText("Logout")).click();
		} catch (Exception e) {
			Thread.sleep(2000);
			w.navigate().back();
		}
	}
	@AfterClass
	public void close() {
		w.quit();
	}	
}
