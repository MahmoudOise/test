package tests;




import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegisterationWithDDTandExcelTest extends TestBase {
          
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	@DataProvider (name=  "ExcelData")
	public Object[][] userRegisterData() throws IOException
	{
		// get data from excel reader class
		ExcelReader Er = new ExcelReader();
			return Er.getExcelData();
		
	}
	
	@Test (priority = 1 , alwaysRun = true, dataProvider = "ExcelData")
	public void userCanRegisterSuccessfully(String fname , String lname,String email, String password)
	{
		homeObject  = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegisteration(fname,lname,email,password);
	    Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}
	
	
	
}
