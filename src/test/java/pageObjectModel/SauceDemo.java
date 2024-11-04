package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceDemo {

	public static void main(String[] args) throws Exception {
		
		WebDriver w = new ChromeDriver();
		w.manage().window().maximize();
		RepoOfSauceDemoByUsingPageFactory r = new RepoOfSauceDemoByUsingPageFactory(w);
w.get("https://www.saucedemo.com/v1/index.html");
		r.login();
		r.AddToCart();
		r.logout();
		
	}

}
