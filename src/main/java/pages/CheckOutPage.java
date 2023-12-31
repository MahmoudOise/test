package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends PageBase {

	public CheckOutPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy (id = "BillingNewAddress_CountryId")
	WebElement countryList;
	
	@FindBy (id = "BillingNewAddress_City")
	WebElement CityTxt;
	
	@FindBy (id="BillingNewAddress_Address1")
	WebElement billingAddress1Txt;
	
	@FindBy (id = "BillingNewAddress_ZipPostalCode")
	WebElement billingZipTxt;
	
	@FindBy (id= "BillingNewAddress_PhoneNumber")
	WebElement billingPhoneTxt;
	
	@FindBy (xpath = "//button[@onclick='if (!window.__cfRLUnblockHandlers) return false; Billing.save()']")
	WebElement BillingAddressBtn;
	
	@FindBy (id ="shippingoption_0")
	WebElement shippingRdBtn;
	
	@FindBy (xpath = "//button[@class='button-1 shipping-method-next-step-button']")
	WebElement shippingMethodBtn;
	
}
