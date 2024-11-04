package keywordDrivenFramework;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class RepoOfFrontAccounting {
WebDriver w;
	public RepoOfFrontAccounting(WebDriver wd) {
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
    @FindBy(linkText = "Click here to Login Again.") WebElement loginAgainLink;
	public void login(String user , String pass) throws Exception {
		username.clear();
		username.sendKeys(user);
		Thread.sleep(2000);
		password.clear();
		password.sendKeys(pass);
		Thread.sleep(2000);
		loginbtn.click();
	}
	public void salesQuotationEntry() throws Exception {
		Thread.sleep(2000);
		SQE.click();
	}
	public void cancel() throws Exception {
		Thread.sleep(2000);
		cancelbtn.click();
	}
	public void alert() throws Exception {
		Thread.sleep(2000);
		w.switchTo().alert().accept();
	}
	public void logout() throws Exception {
		Thread.sleep(2000);
		logoutbtn.click();
		Thread.sleep(2000);
		loginAgainLink.click();
	}
	
	
	
	
}
