package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class ProductHoverMenuTest extends TestBase {
	
	HomePage homeObject;
	
	@Test
	public void UserCanSelectSubCatagoryFromMainMenu()
	{
		homeObject = new HomePage(driver);
		homeObject.selectNoteBooksMenu();
		Assert.assertTrue(homeObject.noteBookNotification.getText()
				.contains("Notebooks"));
		System.out.println(homeObject.noteBookNotification.getText());
	}
	
	

}
