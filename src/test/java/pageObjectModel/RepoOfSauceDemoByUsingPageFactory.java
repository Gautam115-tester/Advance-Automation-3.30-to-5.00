package pageObjectModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class RepoOfSauceDemoByUsingPageFactory {
WebDriver w;
	public RepoOfSauceDemoByUsingPageFactory(WebDriver wd) {
		w = wd;
		PageFactory.initElements(w, this);
	}
//	login scenario
	@FindBy(id = "user-name") WebElement username;
	@FindBy(name = "password") WebElement password;
	@FindBy(css = "input[value=\"LOGIN\"]") WebElement loginbtn;
//	Add to cart product
	@FindBy(xpath = "//*[@id=\"inventory_container\"]/div/div[1]/div[3]/button") WebElement addToCartbtn;
//	logout scenario
	@FindBy(xpath = "//*[@id=\"menu_button_container\"]/div/div[3]/div/button") WebElement menus;
	@FindBy(linkText = "Logout") WebElement logoutbtn;	
//	Methods will perform certain operation. 
	public void login() throws Exception {
		username.sendKeys("standard_user");
		Thread.sleep(2000);
		password.sendKeys("secret_sauce");
		Thread.sleep(2000);
		loginbtn.click();
	}
	public void AddToCart() throws Exception {
		Thread.sleep(2000);
		addToCartbtn.click();
	}
	public void logout() throws Exception {
		Thread.sleep(2000);
		menus.click();
		Thread.sleep(2000);
		logoutbtn.click();
	}
	
	
	
	
	
	
}
