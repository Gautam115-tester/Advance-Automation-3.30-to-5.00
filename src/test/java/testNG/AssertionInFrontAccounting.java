package testNG;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
public class AssertionInFrontAccounting {
WebDriver w;
int i = 1;
	@BeforeClass
	public void launchBrowser() {
		w = new ChromeDriver();
	}
	@BeforeMethod
	public void openUrl() {
		w.get("https://demo.frontaccounting.eu/");
	}
	@Test(dataProviderClass = MultiDataForFrontAccountingTesting.class,dataProvider = "getdata")
	public void login(String user,String pass) throws Exception {
		SoftAssert soft = new SoftAssert();
		
		w.findElement(By.name("user_name_entry_field")).clear();
		w.findElement(By.name("user_name_entry_field")).sendKeys(user);
		w.findElement(By.name("password")).clear();
		w.findElement(By.name("password")).sendKeys(pass);
		w.findElement(By.name("SubmitUser")).click();
//		hard assertion
		
			soft.assertEquals(w.getTitle(), "Main Menu");
			soft.assertEquals(w.getCurrentUrl(), "https://demo.frontaccounting.eu/dashboard/");  // total wrong expected condition.     
			soft.assertAll();
	}
	@AfterMethod
	public void logout() throws Exception {
		try {
			w.findElement(By.linkText("Logout")).click();
		} catch (Exception e) {
			TakesScreenshot tss = (TakesScreenshot) w;
			w.navigate().back();
			FileUtils.copyFile(tss.getScreenshotAs(OutputType.FILE), new File("/home/lab-01-09/Pictures/screen "+i+".png"));
			i++;
		}
	}
	@AfterClass
	public void closeBrowser() {
		w.quit();
	}
	
	
}
