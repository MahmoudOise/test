package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

public class MyAccountTest extends TestBase{
	
    
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	MyAccountPage myAccountObject;
	String oldPassword = "Fatah@3a";
	String newPassword = "Fatah@47";
	String firstName = "Mahmoud";
	String lastName = "Maher";
	String email = "testemai118@gmail.com";
	
	@Test (priority = 1 , alwaysRun = true)
	public void userCanRegisterSuccessfully()
	{
		homeObject  = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegisteration(firstName, lastName, email, oldPassword);
	    Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));  
	}
	
	@Test (dependsOnMethods = "userCanRegisterSuccessfully")
	public void RegisteredUserCanLogin()
	{
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin(email, oldPassword);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
		System.out.println(registerObject.logoutLink.getText());
	}
	
	
	
	@Test (dependsOnMethods = "RegisteredUserCanLogin")
	public void RegisteredUserCanChangePassword() throws InterruptedException
	{
		myAccountObject = new MyAccountPage(driver);
		registerObject.openMyAccountPage();
		myAccountObject.openChangePasswordScreen();
		myAccountObject.changePassword(oldPassword, newPassword);
		
			
	}
	
	@Test (dependsOnMethods = "RegisteredUserCanChangePassword")
	public void RegisteredUserCanLoginAfterPassword()
	{
		
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin(email, newPassword);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
		System.out.println(registerObject.logoutLink.getText());
		
	}
	

}
