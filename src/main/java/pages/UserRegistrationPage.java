package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
// While inheriting form a class with a constructor you should use
// a constructor in the child class as will
import org.openqa.selenium.support.FindBy;
public class UserRegistrationPage extends PageBase{

	public UserRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
    @FindBy (id = "gender-male")
    WebElement genderRdoBtn;
    
    @FindBy (id = "FirstName")
    WebElement fnTxtBox;
    
    @FindBy (id = "LastName")
    WebElement lnTxtBox;
    
    @FindBy (id ="Email")
    WebElement emailTxtBox;
    
    @FindBy (id = "Password")
    WebElement passwordTxtBox;
    
    @FindBy (id ="ConfirmPassword")
    WebElement confirmPasswordTxtBox;
    
    @FindBy (id = "register-button")
    WebElement registerBtn;
    
    @FindBy (css = "div.result")
    public WebElement successMessage; 
    
    @FindBy (linkText = "My account")
    WebElement myAccountLink ;
    
    @FindBy (linkText = "Log out")
    public WebElement logoutLink;
    
    // public to be seen in the Test case when we take an object from this class
    public  void userRegisteration(String firstName,String lastName,String email,String password)
    {
    	 clickBtn(genderRdoBtn);
    	 setTextELementText(fnTxtBox, firstName);
    	 setTextELementText(lnTxtBox, lastName);
    	 setTextELementText(emailTxtBox, email);
    	 setTextELementText(passwordTxtBox, password);
    	 setTextELementText(confirmPasswordTxtBox, password);
    	 clickBtn(registerBtn);
    	
    }
    public void openMyAccountPage()
    {
    	clickBtn(myAccountLink);
    }
    
   
    
}
