package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import utilities.Helper;

public class TestBase extends AbstractTestNGCucumberTests{
	
	public static WebDriver driver ;
	
	@SuppressWarnings("deprecation")
	@BeforeSuite
	@Parameters({"browser"})
    public void startDriver(@Optional("chrome") String browserName)
    {
		if (browserName.equalsIgnoreCase("chrome")) {
			System.getProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if (browserName.equalsIgnoreCase("firefox")) {
			System.getProperty("webdriver.gecko.driver",System.getProperty("user.dir")+ "/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("ie")) {
			System.getProperty("webdriver.edge.driver",System.getProperty("user.dir")+ "/drivers/msedgedriver.exe");
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120 , TimeUnit.SECONDS);
		driver.navigate().to("https://demo.nopcommerce.com/");	
		
    }
	
	@AfterSuite
	public void stopDriver()
	{
		 
	      driver.quit();  
	}
	// Take screenshot when test case fail and add it in the Screenshot folder 
	@AfterMethod
	// ITestResult returns result
	public void screenshotOnFailure(ITestResult result)
	{
		if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("Failed!");
			System.out.println("Taking screenshot...");
			Helper.captureScreenshot(driver, result.getName());
		}
		else if (result.getStatus() == ITestResult.SUCCESS) {
			System.out.println("Passed!");
			System.out.println("Taking screenshot...");
			Helper.captureScreenshot(driver, result.getName());
			
		}
	}
}
