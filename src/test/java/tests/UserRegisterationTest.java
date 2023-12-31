package tests;




import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegisterationTest extends TestBase {
          
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	@Test (priority = 1 , alwaysRun = true)
	public void userCanRegisterSuccessfully()
	{
		homeObject  = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegisteration("Mahmoud", "Maher", "testemai55@gmail.com", "Fatah@3a");
	    Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));   
	}
	@Test (dependsOnMethods = "userCanRegisterSuccessfully")
	public void RegisteredUserCanLogin()
	{
		
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin("testemai55@gmail.com", "Fatah@3a");
		
	}
	
	
}
