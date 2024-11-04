package pageObjectModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class RepoOfFrontaccounting {
WebDriver w;
	public RepoOfFrontaccounting(WebDriver wd) {
		w = wd;	
		PageFactory.initElements(w, this);
	}
//	without pagefactory
//	webelement locator Is Got Sperated from the action
//	login
	By username = By.name("user_name_entry_field");
	By password = By.name("password");
	By loginbtn = By.name("SubmitUser");
	
//	logout
	@FindBy(linkText = "Logout") WebElement logoutbtn;
	
//	set of action by using locator.
	public void login() {
		w.findElement(username).clear();
		w.findElement(username).sendKeys("demouser");
		w.findElement(password).clear();
		w.findElement(password).sendKeys("password");
		w.findElement(loginbtn).click();
	}
	
	public void logout() {
		logoutbtn.click();
	}
}
