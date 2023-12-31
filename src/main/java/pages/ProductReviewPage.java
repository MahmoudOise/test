package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends HomePage {

	public ProductReviewPage(WebDriver driver) {
		super(driver);
		
	}
 
	
	@FindBy (id = "AddProductReview_Title")
	WebElement reviewTitleTxt ;
	
	@FindBy (id = "AddProductReview_ReviewText")
	WebElement reviewTxt;
	
	@FindBy (id = "addproductrating_4")
	WebElement rating4RdoBtn;
	
	@FindBy (xpath = "//button[@name='add-review']")
	WebElement submitReviewBtn;
	
	@FindBy (xpath = "//div[@class='result']")
	public WebElement  reviewNotification;
	
	public void AddProductReview (String reviewTile , String reviewMessage )
	{
		setTextELementText(reviewTitleTxt, reviewTile);
		setTextELementText(reviewTxt, reviewMessage);
		clickBtn(rating4RdoBtn);
		clickBtn(submitReviewBtn);
	}
}
