package log4jDemo;
import org.testng.annotations.Test;
import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
public class CrossBrowsingTestingAndStoreLogsInFile {
 WebDriver w;
//	RemoteWebDriver w; 
//	DesiredCapabilities dc;
Logger log;
@Parameters("browser") // TestNg parameter
	@BeforeMethod
	public void launchBrowser(String browser) {
		log = LogManager.getFormatterLogger(CrossBrowsingTestingAndStoreLogsInFile.class);
		if (browser.equals("chrome")) {
			w = new ChromeDriver();
//			dc = new DesiredCapabilities();
//			dc.setBrowserName("chrome");
//			dc.setPlatform(Platform.LINUX);
//			w = new RemoteWebDriver(dc);
			
		}else if (browser.equals("firefox")) {
			w = new FirefoxDriver();
//			dc = new DesiredCapabilities();
//			dc.setBrowserName("firefox");
//			dc.setPlatform(Platform.LINUX);
//			w = new RemoteWebDriver(dc);
		}
		log.info(browser+" has been launch");
		w.manage().window().maximize();
		log.info(browser+" has been maximize");
		w.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		w.get("https://www.saucedemo.com/");
		log.info(browser+" has been redirect to saucedemo site.");	
	}
	@Test
	public void Login() throws Exception {
		Thread.sleep(2000);
		w.findElement(By.id("user-name")).sendKeys("standard_user");
		log.info("User has send username data successfully in username field");
		Thread.sleep(2000);
		w.findElement(By.id("password")).sendKeys("secret_sauce");
		log.info("User has send password data successfully in password field");
		Thread.sleep(2000);
		w.findElement(By.id("login-button")).click();
		log.info("user login successful");
	}
	@AfterMethod
	public void logout() throws Exception {
		Thread.sleep(2000);
		w.findElement(By.id("react-burger-menu-btn")).click();
		log.info("user click on menu button for logout");
		Thread.sleep(2000);
		w.findElement(By.linkText("Logout")).click();
		log.info("user logout successful");
	}
	
	
}
