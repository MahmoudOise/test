package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;


public class ChangeCurrencyTest extends TestBase{

	HomePage homeobject;
	ProductDetailsPage detailsObject;
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;

	@Test (priority = 1)
	public void userCanChangeCurrency()
	{
		homeobject = new HomePage(driver);
		detailsObject = new ProductDetailsPage(driver);
		homeobject.changeCurrency();


	}


	@Test (priority = 2)
	public void UserCanSearchWithAutoSuggeest()
	{
		try {
			searchObject = new SearchPage(driver);
			searchObject.productSearchUsingAutoSugggest("MacBook");
			detailsObject = new ProductDetailsPage(driver);
			Assert.assertEquals(detailsObject.productNamebreadCrumb.getText(), productName);
			Assert.assertTrue(detailsObject.productpriceLabel.getText().contains("€"));
			System.out.println(detailsObject.productpriceLabel.getText());
		} catch (Exception e) {
			System.out.println("Error occurred "+ e.getMessage());
		}

	}


}
