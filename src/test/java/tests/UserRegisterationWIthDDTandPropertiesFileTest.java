package tests;




import org.testng.Assert;
import org.testng.annotations.Test;

import data.LoadProperties;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegisterationWIthDDTandPropertiesFileTest extends TestBase {
          
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	String firstname = LoadProperties.userData.getProperty("firstname");
	String lastname = LoadProperties.userData.getProperty("lastname");
	String email = LoadProperties.userData.getProperty("email");
	String password = LoadProperties.userData.getProperty("password");
	
	@Test (priority = 1 , alwaysRun = true)
	public void userCanRegisterSuccessfully()
	{
		System.out.println(LoadProperties.userData);
		homeObject  = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegisteration(firstname, lastname, email, password);
	    Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));   
	}
	
	}
	
	

