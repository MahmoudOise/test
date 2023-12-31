package tests;




import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegisterationDDTandJavaFakerTest extends TestBase {
          
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	Faker fakeData = new Faker();
	String firstname = fakeData.name().firstName();
	String lastname = fakeData.name().lastName();
	String email = fakeData.internet().emailAddress();
	String password = fakeData.internet().password();
	@Test (priority = 1 , alwaysRun = true)
	public void userCanRegisterSuccessfully()
	{
		homeObject  = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegisteration(firstname,lastname ,email ,password );
		System.out.println("The User Data is :" + firstname + " " + lastname + " " + email + " " + password);
	    Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));   
	}

	
}
