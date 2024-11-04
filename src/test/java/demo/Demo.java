package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args) {
	
		WebDriver w = new ChromeDriver();
		w.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		w.manage().window().maximize();
		w.get("https://qa1.jjill.com/");
		w.findElement(By.cssSelector("a[href=\"/shop/new-arrivals\"]")).click();
		w.findElement(By.cssSelector("a[href=\"/product/wearever-two-in-one-dress-242071-1?color=2BZ\"]")).click();	

	}

}
