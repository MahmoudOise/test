package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class AddProductToShoppingCartTest extends TestBase {

	String ProductName = "Apple MacBook Pro 13-inch";
	String quantity = "4";
	ProductDetailsPage detailsObject;
	HomePage homeObject;
	SearchPage searchObject ;
	ShoppingCartPage cartObject;

	@Test (priority = 1)
	public void UserCanCompareProducts()
	{
		searchObject = new SearchPage(driver);
		detailsObject = new ProductDetailsPage(driver);
		
		searchObject.productSearchUsingAutoSugggest("MacB");
		Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().contains(ProductName));
		detailsObject.AddToCart();
		detailsObject.NavigateToCartUrl();
	}

	@Test (priority = 2)
	public void UserCanNavigateToShoppingCart() throws StackOverflowError
	{
		cartObject = new ShoppingCartPage(driver);

		cartObject.UpdateProductQuantityInCart(quantity);
		
		Assert.assertTrue(cartObject.emptyCartMsg.getText()
				.contains("Your Shopping Cart is empty!"));
	}

}
