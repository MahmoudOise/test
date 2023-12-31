package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends PageBase{

	public WishListPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy (xpath = "//button[@class='remove-btn']")
	WebElement removeFromWishListBtn;
	
	@FindBy (linkText = "Apple MacBook Pro 13-inch")
	public WebElement productLink;
	
	@FindBy (xpath = "//div[@class='no-data']")
	public WebElement emptyCartLbl;
	
	
	public void AddProductToCart()
	{
		clickBtn(removeFromWishListBtn);
		
	}
	
	
}
