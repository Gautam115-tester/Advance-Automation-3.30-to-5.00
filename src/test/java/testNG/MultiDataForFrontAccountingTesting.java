package testNG;
import org.testng.annotations.DataProvider;
public class MultiDataForFrontAccountingTesting {
	@DataProvider
	public Object[][] getdata(){
		Object[][] data = new Object[4][2];
//		1 row and 1 colmun username
		data[0][0] = "userdemo";
//		1 row and 2 colmun password
		data[0][1] = "password";
//		2 row and 1 column username
		data[1][0] = "demouser";
//		2 row and 2 column password
		data[1][1] = "password";
//		3 row and 1 column username
		data[2][0] = "duser";
//		3 row and 2 column password
		data[2][1] = "pword";
//		4 row and 1 column username  last
		data[3][0] = "demou";
//		4 row and 2 column password  last
		data[3][1] = "passd";
		return data;
	}
	
	
}
