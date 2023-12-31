package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComparePage extends PageBase {

	public ComparePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div/table")
	WebElement CompareTable;
	
	@FindBy (tagName = "tr")
	public List<WebElement> allRows;
	
	@FindBy (tagName = "td")
	public List<WebElement> allcol;
	
	@FindBy (xpath = "//a[@class='clear-list']")
	WebElement ClearListBtn;

	@FindBy (xpath = "//div[@class='no-data']")
	public WebElement noDataLbl;
	
	@FindBy (xpath = "//tr[@class='product-name']//a[contains(text(),'Asus N551JK-XO076H Laptop')]")
	public WebElement firstProduct;
	
	@FindBy (xpath = "//tr[@class='product-name']//a[contains(text(),'Apple MacBook Pro 13-inch')]")
	public WebElement secondProduct;
	
	public void clearCompareList()
	{
		clickBtn(ClearListBtn);
	}
	
	public void CompareProducts()
	{
		//Get all Rows
		System.out.println(allRows.size());
		
		// Get data from each row
		for (WebElement row : allRows)
		{
			System.out.println(row.getText() + "\t");
			for (WebElement col  : allcol)
			{
			System.out.println(col.getText() + "\t");	
			}
		}
	}
}
