package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ProductPage;

public class ProductTest {
	 private WebDriver driver;
	    private LoginPage login;
	    private ProductPage productPage;

	    @BeforeClass
	    public void setUp() {
	        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rabindra\\OneDrive\\Desktop\\chromedriver1\\chromedriver.exe");
	        driver = new ChromeDriver();
	        login = new LoginPage(driver);
	        productPage = new ProductPage(driver);
	    }

	    @Test
	    public void testProductPage() 
	    {
	        driver.get("https://www.saucedemo.com/");
	        login.enterUsername("standard_user");
	        login.enterPassword("secret_sauce");
	        login.clickLoginButton();

	        // Perform login verifications if needed

	        String productTitle = productPage.getProductName();
	        productPage.clickCartButton();

	        // Add assertions or verifications for the product page here
	    }
	   
	    


	    @AfterClass
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}
