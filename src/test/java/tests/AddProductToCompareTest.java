package tests;

import org.testng.Assert;
import org.testng.annotations.Test;


import pages.ComparePage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddProductToCompareTest extends TestBase {
	
	String firstProductName = "Apple MacBook Pro 13-inch";
	String secondProductName = "Asus N551JK-XO076H Laptop";
	ProductDetailsPage detailsObject;
	HomePage homeObject;
	ComparePage compareObject;
	SearchPage searchObject ;
	
	@Test (priority = 1)
	public void UserCanCompareProducts()
	{
		searchObject = new SearchPage(driver);
		detailsObject = new ProductDetailsPage(driver);
		
		searchObject.productSearchUsingAutoSugggest("MacB");
		Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().contains(firstProductName));
		detailsObject.AddProductToCompareList();
		
		searchObject.productSearchUsingAutoSugggest("Asus");
		Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().contains(secondProductName));
		detailsObject.AddProductToCompareList();
		
		detailsObject.NavigateToCompareListUrl();
	}
	
	@Test (priority = 2)
	public void UserCanCompareList()
	{
		compareObject = new ComparePage(driver);
		compareObject.CompareProducts();
		Assert.assertTrue(compareObject.firstProduct.getText().contains("Asus N551JK-XO076H Laptop"));
		System.out.println(compareObject.firstProduct.getText());
		Assert.assertTrue(compareObject.secondProduct.getText().contains("Apple MacBook Pro 13-inch"));
		System.out.println(compareObject.secondProduct.getText());
		compareObject.clearCompareList();
		Assert.assertTrue(compareObject.noDataLbl.getText().contains("You have no items to compare"));
	}
}
	
