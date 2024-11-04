package hybridDrivenFramework;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class SmartRobot extends Robot {
	 public SmartRobot() throws AWTException {
	    super();
	 }
	 public void pasteClipboard() {
		    keyPress(KeyEvent.VK_CONTROL);
		    keyPress(KeyEvent.VK_V);
		    delay(50);
		    keyRelease(KeyEvent.VK_V);
		    keyRelease(KeyEvent.VK_CONTROL);
		}

		public void type(String text) {
		    writeToClipboard(text);
		    pasteClipboard();
		}

		private void writeToClipboard(String s) {
			StringSelection ss = new StringSelection(s);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		}
}

public class Robotdemo {

	public static void main(String[] args) throws InterruptedException, Exception {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.httpwatch.com/httpgallery/authentication/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();	
		driver.findElement(By.id("displayImage")).click();
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		Thread.sleep(2000);
		Alert alert =driver.switchTo().alert();
		SmartRobot robot = new SmartRobot();
		robot.type("httpwatch");
		robot.keyPress(KeyEvent.VK_TAB);
		robot.type("123455678");
		robot.keyPress(KeyEvent.VK_ENTER);
	}
	
	
		
}



