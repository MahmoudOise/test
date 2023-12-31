package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy (id = "Email")
	WebElement emailTxtBox;
	
	@FindBy (id = "Password")
	WebElement passwordTxtBox;
	
	@FindBy ( xpath = "//button[normalize-space()='Log in']")
	WebElement loginBtn;
	
	public void UserLogin(String email , String passowrd)
	{
		
		setTextELementText(emailTxtBox, email);
		setTextELementText(passwordTxtBox, passowrd);
		clickBtn(loginBtn);
	}

}
