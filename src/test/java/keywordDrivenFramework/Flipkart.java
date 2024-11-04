package keywordDrivenFramework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Flipkart {
	public static void main(String[] args) throws Exception {
		
		WebDriver w = new ChromeDriver();
		w.get("https://www.flipkart.com/");
		w.manage().window().maximize();
		FileInputStream fis = new FileInputStream("/home/lab-01-09/Downloads/Flipkart.xlsx");
		RepoOFFlipkart f = new RepoOFFlipkart(w);
		XSSFWorkbook work = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = work.getSheet("Sheet1");
		for(int i = 1;i<=sheet1.getLastRowNum();i++) {
			XSSFRow row = sheet1.getRow(i);
			XSSFCell teststep = row.getCell(0);
			switch (teststep.toString()) {
			case "Search":
				f.search();
				break;
			case "Product":
				f.product();
				break;
			case "windowhandle":
				f.windowhandle(w.getWindowHandle(), w.getWindowHandles());
				break;
			case "AddToCard":
				f.AddToCard();
				break;
				

			default:
				break;
			}
			
			
		}

	}

}
