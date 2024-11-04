package dataDrivenFramework;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class GoogleSearch {
	public static void main(String[] args) throws Exception {
		WebDriver w = new FirefoxDriver();
		FileInputStream fis = new FileInputStream("/home/lab-01-09/Downloads/GoogleSearch.xlsx");
		XSSFWorkbook work = new XSSFWorkbook(fis);
		XSSFSheet sheet = work.getSheet("Sheet1");
		for(int i = 1;i <= sheet.getLastRowNum();i++){
			XSSFRow row = sheet.getRow(i);
			XSSFCell search =  row.getCell(0);
		w.get("https://www.google.com/");
		w.findElement(By.id("APjFqb")).sendKeys(search.toString());
		w.findElement(By.id("APjFqb")).submit();
	}
		
		
}
}















