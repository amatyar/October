package pom;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TwoWindows {
	WebDriver driver;
	String url = "http://www.webdriveruniversity.com/";	
	String path ="C:\\Users\\Rabindra\\OneDrive\\Desktop\\chromedriver1\\chromedriver.exe";

	@BeforeTest
	public void launchBrowser() {
		System.setProperty("WebDriver.chrome.driver", path);		
		driver = new ChromeDriver();		
		driver.manage().window().maximize();
		System.out.println("***BeforeTest***");
	}
	@Test
	public void Testcase()
	{
		driver.get(url);
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow);
		
		driver.findElement(By.cssSelector("#contact-us")).click();
		
		Set<String> windows = driver.getWindowHandles();
		for(String window : windows) {
			if(! window.equals(parentWindow)) {
				driver.switchTo().window(window);
				break;				
			}			
		}
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(windows);
		driver.findElement(By.cssSelector("#contact_form > input:nth-child(1)")).sendKeys("Rabindra");
		driver.findElement(By.cssSelector("#contact_form > input:nth-child(2)")).sendKeys("Amatya");
		driver.findElement(By.cssSelector("#contact_form > input:nth-child(3)")).sendKeys("aramatya@gmail.com");
		driver.findElement(By.cssSelector("#contact_form > textarea")).sendKeys("I am learing selenium");
		driver.findElement(By.cssSelector("#form_buttons > input:nth-child(2)")).click();
		System.out.println(driver.getCurrentUrl());
		
		driver.switchTo().window(parentWindow);
		System.out.println(driver.getCurrentUrl());
	}

	@AfterTest
	public void terminateBrowser()
	{
		System.out.println("**AfterTest**");
		if(driver != null) 
		{
	 	driver.close();
		}
	}

}
