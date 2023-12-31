package tests;




import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegisterationWithDDTandCSVTest extends TestBase {

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	CSVReader reader ;
	@Test (priority = 1 , alwaysRun = true)
	public void userCanRegisterSuccessfully() throws CsvValidationException, IOException
	{
		// get path of Csv
		String CSV_File = System.getProperty("user.dir")+
				"\\src\\test\\java\\data\\Test.csv";
		reader = new CSVReader(new FileReader(CSV_File));
		String[]csvCell ;
		//While loop will be exceuted till the lasr value in csv file .
		while ((csvCell = reader.readNext()) != null)
		{
			String firstname = csvCell[0];
			String lastname = csvCell[1];
			String email =csvCell[2];
			String password = csvCell [3];
			homeObject  = new HomePage(driver);
			homeObject.openRegistrationPage();
			registerObject = new UserRegistrationPage(driver);
			registerObject.userRegisteration(firstname, lastname, email ,  password );
			Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		}

	}



}
