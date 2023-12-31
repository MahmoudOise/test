package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase {

	public ContactUsPage(WebDriver driver) {
		super(driver);
	
	}
	
	@FindBy (id = "FullName")
	private WebElement fullNameTxt;
	
	@FindBy (id = "Email")
	private WebElement emailTxt;
	
	@FindBy (id = "Enquiry")
	private WebElement enquiryTxt;
	
	@FindBy (xpath = "//button[@name='send-email']")
	private WebElement submitBtn;
	
	@FindBy(xpath = "//div[@class='result']")
	public WebElement successMessage;
	
	public void contactUs(String fullName , String email , String message)
	{
		setTextELementText(fullNameTxt, fullName);
		setTextELementText(emailTxt, email);
		setTextELementText(enquiryTxt, message);
		clickBtn(submitBtn);
	}
	
	
}
