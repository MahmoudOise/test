package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}
	@FindBy (xpath = "//button[@class='remove-btn']")
	WebElement removeProdBtn;

	@FindBy (id = "itemquantity11219")
	WebElement itemQuantity;

	@FindBy (id ="updatecart")
	public WebElement UpdateCartBtn;

	@FindBy (xpath =  "//td[@class='subtotal']")
	public WebElement subTotal;
 
	@FindBy(xpath = "//div[@class='no-data']")
	public WebElement emptyCartMsg; 
	
	@FindBy (id ="termsofservice")
	WebElement conditionsBtn;
	
	@FindBy (id = "checkout")
	WebElement checkOutBtn;
	
	public void UpdateProductQuantityInCart(String quantity) throws StackOverflowError
	{
		
		setTextELementText(itemQuantity, quantity);
		clickBtn(UpdateCartBtn);
	}
	public void checkConditions()
	{
	    clickBtn(conditionsBtn);
	    clickBtn(checkOutBtn);
	}
}

