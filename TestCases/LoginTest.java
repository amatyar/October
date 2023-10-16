package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.ProductPage;
import pages.LoginPage;

public class LoginTest {
	private WebDriver driver;
    private LoginPage loginPage;
    private ProductPage productPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rabindra\\OneDrive\\Desktop\\chromedriver1\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
    }

    @Test
    public void testValidLogin() {
    
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();

        // Assertions for successful login
        
        String productName = productPage.getProductName();
        // Add assertions to verify that you are on the product page, e.g., check the product title.

        // Example assertion using TestNG:
        Assert.assertEquals(productName, "Sauce Labs Backpack");
    }
    @Test
    public void testLoginWithoutPassword() {
       // LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");      
        loginPage.clickLoginButton();
        
       Assert.assertTrue(loginPage.errorstate());
    }
    @Test
    public void VerifyTitle() {
        String actualTitle = loginPage.verifyTitle();
        String expectedTitle = "Swag Labs";
        Assert.assertEquals(actualTitle, expectedTitle);
        
    }

    @AfterClass
    public void tearDown() 
    {
        if (driver != null)
        {
            driver.quit();
        }
    }
}
