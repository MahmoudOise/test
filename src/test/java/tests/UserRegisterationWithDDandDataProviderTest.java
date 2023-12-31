package tests;




import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegisterationWithDDandDataProviderTest extends TestBase {

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;

	@DataProvider (name = "testData")
	public static Object[][] userData()
	{
		return new Object[][] {
			{"Mahmoud", "Maher", "testemai85@gmail.com", "Fatah@3a"},
			{"Ahmed","Ali","tesuser7@gmail.com","123456"}};
	}

	@Test (priority = 1 , alwaysRun = true , dataProvider = "testData")
	public void userCanRegisterSuccessfully(String fname , String lname,String email, String password)
	{
		homeObject  = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegisteration(fname,lname,email,password);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));   
	}
	


}
