package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class EmailFriendTest extends TestBase {
 
    // 1- user registration
	// 2- login
	// 3- search product
	// 4- Email to friend
	

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	MyAccountPage myAccountObject;
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	EmailPage emailObject;
	String productName = "Apple MacBook Pro 13-inch";
	String oldPassword = "Fatah@3a";
	String newPassword = "Fatah@47";
	String firstName = "Mahmoud";
	String lastName = "Maher";
	String email = "testemai120@gmail.com";
	String friendEmail = "test@gmail.com" ;
	String Message = "Hello bro this product is good";		
	
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
	public void UserCanSearchWithAutoSuggeest()
	{
		try {
			searchObject = new SearchPage(driver);
			searchObject.productSearchUsingAutoSugggest("MacB");
			detailsObject = new ProductDetailsPage(driver);
			Assert.assertEquals(detailsObject.productNamebreadCrumb.getText(), productName);
			System.out.println(productName);
		} catch (Exception e) {
		    System.out.println("Error occurred "+ e.getMessage());
		}	
	}
	
	@Test (dependsOnMethods = "UserCanSearchWithAutoSuggeest")
	public void RegisteredUserCanSendProductToFriend()
	{
		detailsObject.openSendEmail();
		emailObject = new EmailPage(driver);
		emailObject.SendEmailToFriend(friendEmail, Message);
		Assert.assertTrue(emailObject.messageNotification.getText()
				.contains("Your message has been sent."));
		System.out.println(emailObject.messageNotification.getText());
		
	}
	@Test (dependsOnMethods = "RegisteredUserCanSendProductToFriend")
	public void UserCanLogout()
	{
		homeObject = new HomePage(driver);
		homeObject.logOut();
	}
	
}
