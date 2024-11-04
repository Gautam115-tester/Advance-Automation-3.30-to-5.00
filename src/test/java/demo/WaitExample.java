package demo;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class WaitExample {
	public static void main(String[] args) throws Exception {
		WebDriver w = new ChromeDriver();
		w.manage().window().maximize();
		w.get("https://github.com/signup");
//		Thread.sleep(5000);
		w.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		w.findElement(By.id("email")).sendKeys("qst@gmail.com");
		WebDriverWait wt = new WebDriverWait(w, Duration.ofSeconds(10));
		wt.until(ExpectedConditions.elementToBeClickable(By.cssSelector
				("button[data-continue-to=\"password-container\"]"))).click();
	}
}