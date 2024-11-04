package keywordDrivenFramework;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class FrontAccounting {
	public static void main(String[] args) throws Exception {
		WebDriver w = new ChromeDriver();
		RepoOfFrontAccounting r = new RepoOfFrontAccounting(w);
		w.manage().window().maximize();
		w.get("https://demo.frontaccounting.eu/index.php");
		FileInputStream fis = new FileInputStream("/home/lab-01-09/Downloads/KDF.xlsx");
		XSSFWorkbook work = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = work.getSheet("Sheet1");
		for(int i = 1;i <= sheet1.getLastRowNum();i++) {
			XSSFRow row = sheet1.getRow(i);
			XSSFCell testStep = row.getCell(0);
			switch (testStep.toString()) {
			case "login":
					r.login("demouser", "password");
				break;
			case "salesQuotationEntry":
				r.salesQuotationEntry();
				break;
			case "cancel":
				r.cancel();
				break;
			case "alert":
				r.alert();
				break;
			case "logout":
				r.logout();
				break;
			default:
				break;
			}




		}


	}

}
