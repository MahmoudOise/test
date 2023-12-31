package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase{

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy (xpath = "//strong[@class='current-item']")
	public WebElement productNamebreadCrumb; 
	
	@FindBy (xpath = "//button[normalize-space()='Email a friend']")
	WebElement emailFriendBtn;
	
	@FindBy (xpath =  "//span[@id='price-value-4']")
	public WebElement productpriceLabel;
	
	@FindBy (xpath = "//a[normalize-space()='Add your review']")
	WebElement addReviewLink;
	
	@FindBy (id = "add-to-wishlist-button-4")
	WebElement AddwishListBtn;
	
	@FindBy (xpath = "//p[@class='content']")
	public WebElement productAddedNotification;
	
	@FindBy (linkText = "wishlist")
	WebElement wishListLink;
	
	@FindBy (xpath = "//div[@class='compare-products']//button[@type='button'][normalize-space()='Add to compare list']")
	WebElement CompareBtn;
	
	@FindBy (linkText = "product comparison" )
	WebElement CompareLink;
	
	@FindBy (xpath = "//button[@id='add-to-cart-button-4']")
	WebElement AddToCartBtn;
	
	@FindBy (linkText = "shopping cart" )
	WebElement CartLink;
	
	public void openSendEmail()
	{
		clickBtn(emailFriendBtn);
	}
	
	public void openaddReviewPage()
	{
		clickBtn(addReviewLink);
	}
	
	public void AddProductToWishList()
	{
		clickBtn(AddwishListBtn);
	}
	
	public void NaviagteToWishListUrl()
	{
		clickBtn(wishListLink);
	}
	
	public void AddProductToCompareList()
	{
		clickBtn(CompareBtn);
	}
	
	public void NavigateToCompareListUrl()
	{
	    clickBtn(CompareLink);
	}
	
	public void AddToCart()
	{
		clickBtn(AddToCartBtn);
	}
	public void NavigateToCartUrl()
	{
		clickBtn(CartLink);
	}
}
