package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishListPage;


public class AddProductToWishListTest extends TestBase {
	
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	WishListPage wishListObject;
	HomePage homeObject;
	
	@Test (priority = 1 , alwaysRun = true)
	public void UserCanSearchWithAutoSuggeest()
	{
		try {
			searchObject = new SearchPage(driver);
			searchObject.productSearchUsingAutoSugggest("MacBook");
			detailsObject = new ProductDetailsPage(driver);
			Assert.assertEquals(detailsObject.productNamebreadCrumb.getText(), productName);
			System.out.println(productName);
		} catch (Exception e) {
		    System.out.println("Error occurred "+ e.getMessage());
		}
		
	}
	
	@Test (dependsOnMethods = "UserCanSearchWithAutoSuggeest")
	public void UserCanAddProductToWishList ()
	{
	   detailsObject = new ProductDetailsPage(driver);
	   homeObject = new HomePage(driver);
	   homeObject.scrollToBottom();
	   detailsObject.AddProductToWishList();
	   detailsObject.NaviagteToWishListUrl();
	   Assert.assertTrue(detailsObject.productAddedNotification
			   .getText().contains("The product has been added to your"));
	}
	
	@Test (dependsOnMethods = "UserCanAddProductToWishList")
	public void UserCanRemoveProductFromWishList()
	{
		wishListObject = new WishListPage(driver);
		wishListObject.AddProductToCart();
		Assert.assertTrue(wishListObject.emptyCartLbl
				.getText()
				.contains("The wishlist is empty!"));
	}
	
	
	
}
