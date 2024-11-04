package testNG;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class CustomizedReport {
WebDriver w;
	@BeforeClass(alwaysRun = true)
	public void browserLaunch() {
		w = new ChromeDriver();
	}
	@BeforeMethod(alwaysRun = true)
	public void openWebsite(){
		w.get("https://demo.frontaccounting.eu/");
	}
	@Test (dataProviderClass = MultiDataForFrontAccountingTesting.class, dataProvider = "getdata" ,alwaysRun = true)
	public void login(String user,String pass) {
		w.findElement(By.name("user_name_entry_field")).clear();
		Reporter.log("username has been clear");
		w.findElement(By.name("user_name_entry_field")).sendKeys(user);
		Reporter.log("username value has been sent and that value is "+user);
		w.findElement(By.name("password")).clear();
		Reporter.log("password has been clear");
		w.findElement(By.name("password")).sendKeys(pass);
		Reporter.log("password value has been sent and that value is "+pass);
		w.findElement(By.name("SubmitUser")).click();
		Reporter.log("user click on login button ");
		try {   
			w.findElement(By.linkText("Sales Quotation Entry")).click();
			Reporter.log("user login successfully ");
		} catch (Exception e) {
			Reporter.log("user is not able to login");
		}	
	}
	@AfterMethod (alwaysRun = true)
	public void logout() {
		try {
			w.findElement(By.linkText("Logout")).click();
		} catch (Exception e) {
			// TODO: handle exception
		}	
	}
	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		w.close();
	}
	
}
