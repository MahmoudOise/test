package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailPage extends PageBase{

	public EmailPage(WebDriver driver) {
		super(driver);
		
	}
	
	
	
	@FindBy (id ="FriendEmail")
	private WebElement emailFriendTxt;
	
	@FindBy (id ="PersonalMessage")
	private WebElement personalMessageTxt;
	
	@FindBy (xpath = "//button[@name='send-email']")
	private WebElement sendEmailBtn;
	
	@FindBy (xpath = "//div[@class='result']")
	public WebElement messageNotification;
	
	public void SendEmailToFriend (String friendEmail, String personalMessage)
	{
		setTextELementText(emailFriendTxt, friendEmail);
		setTextELementText(personalMessageTxt, personalMessage);
		clickBtn(sendEmailBtn);
	}
	
	
	
}
