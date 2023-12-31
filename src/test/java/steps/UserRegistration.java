package steps;

import org.testng.Assert;

import com.github.javafaker.Faker;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;
import tests.TestBase;

public class UserRegistration extends TestBase {
	
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	Faker fakeData = new Faker();

	/*
	 * //String firstname = fakeData.name().firstName(); //String lastname =
	 * fakeData.name().lastName(); //String email =
	 * fakeData.internet().emailAddress(); //String password =
	 * fakeData.internet().password();
	 */	
	@Given("the user in the home page")
	public void the_user_in_the_home_page() {
	    homeObject = new HomePage(driver);
	    homeObject.openRegistrationPage();
	}
	@When("user click on register link")
	public void user_click_on_register_link() {
		Assert.assertTrue(driver.getCurrentUrl().contains("register"));  
	}
	@And("^user entered \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\"$")
	public void user_entered(String firstname ,String lastname ,String email ,String password) throws InterruptedException
	{
      registerObject = new UserRegistrationPage(driver);
      registerObject.userRegisteration(firstname, lastname, email, password);	
	}
	@Then("the registration page displayed successfully")
	public void the_registration_page_displayed_successfully() {
		Assert.assertTrue(registerObject.logoutLink.getText().contains("register"));
	    
		
	}
}
