package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase {

	HomePage home;
	ContactUsPage contactUsPage;
	
	String fullName = "Mahmoud Maher";
	String email = "test@gmail.com";
	String enquiry = "Hello Admin , this is for test";
	
	@Test
	public void UserCanUseContactUs()
	{
		home = new HomePage(driver);
		home.openContactUsPage();
		contactUsPage = new ContactUsPage(driver);
		contactUsPage.contactUs(fullName, email, enquiry);
		Assert.assertTrue(contactUsPage.successMessage.getText().
		contains("Your enquiry has been successfully sent to the store owner."));
	}
	
	
}
