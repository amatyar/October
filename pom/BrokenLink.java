package pom;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrokenLink 
{
	WebDriver driver;
	 String url1="http://www.webdriveruniversity.com/";
	String path = "C:\\Users\\Rabindra\\OneDrive\\Desktop\\chromedriver1\\chromedriver.exe";
	
	@BeforeTest
	public void launchBrowser()
	{
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	@Test
	public void TestCase001() 
	{
		driver.get(url1);
		List<WebElement> links= driver.findElements(By.tagName("a"));
		for(WebElement link : links)
		{
			String url = link.getAttribute("href");
			verify(url);
		}
		
	}
	public static void verify(String url)
	{
		
		try 
		{
			URL link = new URL(url);			
				HttpURLConnection http = (HttpURLConnection) link.openConnection();
				http.setConnectTimeout(3000);
				http.connect();
				if(http.getResponseCode() == 200)
				{
					System.out.println(url+ " - "+http.getResponseMessage());
				}
				else
				{
					System.out.println(url+" - "+http.getResponseMessage()+"-"+ "is Broken links");
				}
			}
			catch (Exception e) 
			{
				System.out.println(url + "-"+"is broken links");
				e.printStackTrace();
			}
		
		
	}
	@AfterTest
	public void TerminateBrowser() 
	{
		if( driver != null) 
		{
			driver.close();
		}
		
	}
	

}
