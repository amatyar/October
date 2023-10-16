package pom;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ShotScreen {
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
	public void TestcaseOne() 
	{		
		driver.get(url);
		String ParentWin = driver.getWindowHandle();
		System.out.println(ParentWin);
		driver.findElement(By.id("contact-us")).click();
		Set<String> handles = driver.getWindowHandles();
		boolean windowFound = false;
		for(String window:handles) 
		{
		System.out.println(window);
//			if(!window.equals(ParentWin)) {
//				driver.switchTo().window(window);
//				break;			
//			}	
//			System.out.println(driver.getCurrentUrl());
			driver.switchTo().window(window);
			if(driver.getCurrentUrl().contains("Contact-Us")) 
			{
				windowFound = true;
			}
		}	
		System.out.println(driver.getCurrentUrl());
		Assert.assertTrue(windowFound);
		//Screen shot
		TakesScreenshot shot = (TakesScreenshot)driver;
		File src = shot.getScreenshotAs(OutputType.FILE);
		String Location ="C:\\Users\\Rabindra\\eclipse-workspace\\pom\\img0.png";
		File destination = new File(Location);
		try 
		{
			FileUtils.copyFile(src, destination);
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
