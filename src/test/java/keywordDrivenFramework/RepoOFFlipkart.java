package keywordDrivenFramework;
import java.util.Set;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class RepoOFFlipkart {
WebDriver w ;
	public RepoOFFlipkart(WebDriver wd) {
		w = wd;
		PageFactory.initElements(w,this);
	}
	@FindBy(name = "q") WebElement searchph;
	@FindBy(partialLinkText = "Motorola G34 5G (Ice Blue, 128 GB)") WebElement phone;
	@FindBy(css = "button[class=\"QqFHMw vslbG+ In9uk2\"]") WebElement addtocard;
	public void search() {
		searchph.sendKeys("phone",Keys.ENTER);
	}
	public void product() {
		phone.click();
	}
	public void windowhandle(String parent,Set<String> childwindow) throws Exception {
		System.out.println(parent);
		System.out.println(childwindow);
		for(String ch :childwindow) {
			if (!parent.equals(ch)) {
				Thread.sleep(2000);
				w.switchTo().window(ch);	
				System.out.println(ch);
			}
		}	
	}
	public void AddToCard() throws Exception {
		Thread.sleep(2000);
		Actions act = new Actions(w);
		act.moveToElement(addtocard).click().perform();
	}
}