package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frontaccounting {

	public static void main(String[] args) throws Exception {
		WebDriver w = new ChromeDriver();
		RepoOfFrontaccounting r = new RepoOfFrontaccounting(w);
		w.manage().window().maximize();
		w.get("https://demo.frontaccounting.eu/index.php");
		Thread.sleep(2000);
		r.login();
		Thread.sleep(2000);
		r.logout();

	}

}
