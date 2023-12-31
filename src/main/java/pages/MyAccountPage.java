package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy (linkText = "Change password")
	WebElement changePasswordLink;
	
	@FindBy (id = "OldPassword")
	WebElement oldPasswordTxt;
	
	@FindBy (id = "NewPassword")
	WebElement newPasswordTxt;
	
	@FindBy (id = "ConfirmNewPassword")
	WebElement confirmPasswordTxt;
	
	@FindBy (xpath = "//button[normalize-space()='Change password']")
	WebElement chanegePasswordBtn;
	
	@FindBy (xpath = "//p[@class='content'] ")
	public WebElement resultLb1;
	
	@FindBy (xpath = "//span[@title='Close']")
    public WebElement closeSuccessMessage;
	
	@FindBy (linkText = "Log out")
    public WebElement logoutLink;
 	
	public void openChangePasswordScreen()
	{
		clickBtn(changePasswordLink);
	}
	
	public void changePassword(String oldPassword, String newPassword) throws InterruptedException
	{
		setTextELementText(oldPasswordTxt, oldPassword);
		setTextELementText(newPasswordTxt, newPassword);
		setTextELementText(confirmPasswordTxt, newPassword);
		clickBtn(chanegePasswordBtn);
		clickBtn(closeSuccessMessage);
		Thread.sleep(2000);
		clickBtn(logoutLink);
		
	}
	
}
