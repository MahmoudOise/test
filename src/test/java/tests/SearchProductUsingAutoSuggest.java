package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductUsingAutoSuggest extends TestBase {

	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	
	@Test
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
	
}





