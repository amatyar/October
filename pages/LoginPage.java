package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage 
{
	private WebDriver driver;
     By usernameField = By.id("user-name");
     By passwordField = By.id("password");
     By loginButton = By.id("login-button");
     By errorstate = By.tagName("h3");

    public LoginPage(WebDriver driver) 
    {
        this.driver = driver;
    }

    public void enterUsername(String username) 
    {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) 
    {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() 
    {
        driver.findElement(loginButton).click();
    }
    public void login(String username, String password) 
    {
    	enterUsername(username);
    	enterPassword(password);
    	clickLoginButton();    	
    }
    public void loginwithoutpassword(String username)
    {
    	enterUsername(username);
    	clickLoginButton();
    }
    public void loginwithoutusername(String password)
    {
    	enterUsername(password);
    	clickLoginButton();
    }
    public String verifyTitle()
    {
    	return driver.getTitle();
    }
    public boolean errorstate() 
    {
	      return driver.findElement(errorstate).isDisplayed();
	 }  
	
}
