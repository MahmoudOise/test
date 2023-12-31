package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver;
		action = new Actions(driver);
	}

	@FindBy (linkText = "Register")
	WebElement registerLink ;
	
	@FindBy (linkText = "Log in")
	WebElement loginLink;
	
	@FindBy (xpath = "//a[normalize-space()='Contact us']")
    WebElement contactUs;
	
	@FindBy (linkText = "Log out")
	WebElement logoutLink;
	
	@FindBy (id = "customerCurrency")
	WebElement currencyDropDown;
	
	@FindBy (linkText = "Computers")
	WebElement ComputerMenu;
	
	@FindBy (linkText = "Notebooks")
	WebElement NoteBooksMenu;
	
	@FindBy (xpath = "//h1[normalize-space()='Notebooks']")
    public WebElement noteBookNotification;	
	public void openRegistrationPage()
	{
	clickBtn(registerLink);
	}
	public void openLoginPage() 
	{
	clickBtn(loginLink);	
	}
	public void openContactUsPage()
	{
		scrollToBottom();
		clickBtn(contactUs);
	}
	
	public void logOut()
	{
	  clickBtn(logoutLink);	
	}
	
	public void changeCurrency ()
	{
	  select = new Select(currencyDropDown);
	  select.selectByVisibleText("Euro");
	}
	
	public void selectNoteBooksMenu()
	{
		action.moveToElement(ComputerMenu).click().build().perform();
		action.moveToElement(NoteBooksMenu).click().build().perform();
		
	}
}
