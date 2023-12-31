package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.ProductDetailsPage;
import pages.ProductReviewPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class AddProductReviewTest extends TestBase {

	
	
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	MyAccountPage myAccountObject;
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	ProductReviewPage productReviewObject;
	String oldPassword = "Fatah@3a";
	String newPassword = "Fatah@47";
	String firstName = "Mahmoud";
	String lastName = "Maher";
	String email = "testemai130@gmail.com";
	String productName = "Apple MacBook Pro 13-inch";
	String reviewTitle = "MacBook";
	String reviewTiltetxt = "The product is good";
	
	
	@Test (priority = 1)
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
	public void RegisteredUserCanReviewProduct()
	{
		detailsObject = new ProductDetailsPage(driver);
		productReviewObject = new ProductReviewPage(driver);
		detailsObject.openaddReviewPage();
		productReviewObject.AddProductReview(reviewTitle, reviewTiltetxt);
		Assert.assertTrue(productReviewObject.reviewNotification.getText().contains("Product review is successfully added."));
		System.out.println(productReviewObject.reviewNotification.getText());
	}
	@Test (dependsOnMethods = "RegisteredUserCanReviewProduct")
	public void UserCanLogOut()
	{
		homeObject = new HomePage(driver);
		homeObject.logOut();
	}
}
