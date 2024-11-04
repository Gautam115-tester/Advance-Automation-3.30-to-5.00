package seleniumGrid;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Democode {

	public static void main(String[] args) throws Exception {
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName("firefox");
		dc.setPlatform(Platform.LINUX);
		
		RemoteWebDriver rc = new RemoteWebDriver(dc);	
		rc.get("https://demo.frontaccounting.eu/");
		
		Thread.sleep(10000);
		rc.quit();
	}

}
