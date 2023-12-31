package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase {

	public SearchPage(WebDriver driver) {
		super(driver);
	}

   @FindBy (id = "small-searchterms")
   WebElement searchTextBox;
   
   @FindBy (xpath = "//button[@type='submit']")
   WebElement searchBtn;
   
   @FindBy (id = "ui-id-1")
   List<WebElement> productList;
   
   @FindBy (xpath = "//h2[@class='product-title']//a[contains(text(),'Apple MacBook Pro 13-inch')]")
   WebElement productTitle;  
   
   public void productSearch(String productName)
   {
	   setTextELementText(searchTextBox, productName);
	   clickBtn(searchBtn);
   }
   
   public void OpenProductDetailsPage()
   {
	   clickBtn(productTitle);
   }
   
   public void productSearchUsingAutoSugggest(String searchTxt)
   {
	   setTextELementText(searchTextBox, searchTxt);
	   try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	   productList.get(0).click();
   }
}
