package hybridDrivenFramework;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class RepoOFFrontaccountingForHDF {
WebDriver w;
	public RepoOFFrontaccountingForHDF(WebDriver wd) {	
		w = wd;
		PageFactory.initElements(w, this);
	}
//	login
	@FindBy(name = "user_name_entry_field") WebElement username;
	@FindBy(name = "password") WebElement password;
	@FindBy(name = "SubmitUser") WebElement loginbtn;
//	sales quotation entry
	@FindBy(linkText = "Sales Quotation Entry") WebElement SQE;
//	cancel button
	@FindBy(id = "CancelOrder") WebElement cancelbtn;
//	logout
	@FindBy(linkText = "Logout") WebElement logoutbtn;
	@FindBy(linkText = "Click here to Login Again.") WebElement loginagain;
	public void login(String user,String pass) throws Exception {
		Thread.sleep(2000);
		username.clear();
		Thread.sleep(2000);
		username.sendKeys(user);
		Thread.sleep(2000);
		password.clear();
		Thread.sleep(2000);
		password.sendKeys(pass);
		Thread.sleep(2000);
		loginbtn.click();
	}
	public void SalesQuatationEntry() throws Exception {
		Thread.sleep(2000);
		SQE.click();	
	}
	public void cancel() throws Exception {
		Thread.sleep(2000);
		cancelbtn.click();
	}
	public void alerthandle() throws Exception {
		Thread.sleep(2000);
		Alert alt = w.switchTo().alert();
		Thread.sleep(2000);
		alt.accept();
	}
	public void logout() throws Exception {
		Thread.sleep(2000);
		logoutbtn.click();
		Thread.sleep(2000);
		loginagain.click();
	}
	
	
	
	
	
	
	
	

}
