package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {
	
	// Protected to be used in this package only
     protected WebDriver driver ;
     public JavascriptExecutor jse;
     public Select select;
     public Actions action;
	// create constructor
	public PageBase(WebDriver driver)
	{
		//take an object 
		PageFactory.initElements(driver, this);
	}
    // Static as we dont need to take an object from this class we can work on it right away
	protected static void  clickBtn(WebElement button)
	{
		button.click();
	}
	protected static void setTextELementText(WebElement textElement, String value) 
	{
		textElement.sendKeys(value);
	}
	
	public void scrollToBottom()
	{
	   jse.executeScript("scrollBy(0,1500)");
	}
	
	public void clearTxt(WebElement element)
	{
		element.clear();
	}
}
