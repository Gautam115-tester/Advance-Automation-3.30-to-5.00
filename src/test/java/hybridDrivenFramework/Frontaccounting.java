package hybridDrivenFramework;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Frontaccounting {
	public static void main(String[] args) throws Exception {
		WebDriver w = new ChromeDriver();
		w.manage().window().maximize();
		w.get("https://demo.frontaccounting.eu/");
		RepoOFFrontaccountingForHDF r = new RepoOFFrontaccountingForHDF(w);
		FileInputStream fis = new FileInputStream("/home/lab-01-09/Downloads/FrontAccounting HDF.xlsx");
		XSSFWorkbook work = new XSSFWorkbook(fis);
		XSSFSheet testdata = work.getSheet("Test Data");
		XSSFSheet teststep = work.getSheet("Test steps");
//		getlastrownumber = index
		for(int i = 1;i<=testdata.getLastRowNum();i++) { //Total row access from testdata
//			R1 row of testdata
			XSSFRow r1 = testdata.getRow(i); //It get total access of all present row
			XSSFCell user = r1.getCell(0); // taking all the value of cell username template.
			XSSFCell pass = r1.getCell(1);  //taking all the value of cell password template.
//			getlastrownumber = index		
			for(int j = 1; j<= teststep.getLastRowNum();j++) {//Total row access from teststep
//				R2 row of teststep
				XSSFRow r2 = teststep.getRow(j);
				XSSFCell Step = r2.getCell(0);// A column index value is 0.
				try {
					switch (Step.toString()) {
					case "login":
						r.login(user.toString(), pass.toString());
						break;
					case "sales quotation entry":
						r.SalesQuatationEntry();
						break;
					case "cancel":
						r.cancel();
						break;
					case "alert":
						r.alerthandle();
						break;
					case "logout":
						r.logout();
						break;
					default:
						break;
					}
				} catch (Exception e) {
					TakesScreenshot tss = (TakesScreenshot) w;
					FileHandler.copy(tss.getScreenshotAs(OutputType.FILE), 
							new File("/home/lab-01-09/Desktop/Src/"+user.toString()+" "+pass.toString()+".png"));	
				}
				
				
			}
			
			
		}
		
				
		

	}

}
