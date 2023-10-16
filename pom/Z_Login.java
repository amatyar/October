package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Z_Login {
	WebDriver driver;
	String url = "http://qalms.zorbasofted.com/login";	
	String path ="C:\\Users\\Rabindra\\OneDrive\\Desktop\\chromedriver1\\chromedriver.exe";

	@BeforeTest
	public void launchBrowser() {
		System.setProperty("WebDriver.chrome.driver", path);		
		driver = new ChromeDriver();		
		driver.manage().window().maximize();
	}
	
	@Test
	public void TestLogin() {
		
	}
	@Test
	public void TestDashBoard() {
		
	}
	@Test
	public void TestLoanCustomer() {
		
	}
	@AfterTest
	public void terminateBrowser()
	{
		if(driver != null) 
		{
	 	driver.close();
		}
	}
	
}
