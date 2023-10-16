package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DatePicker 
{	
	WebDriver driver;
	String url = "http://www.webdriveruniversity.com/Datepicker/index.html";	
	String path ="C:\\Users\\Rabindra\\OneDrive\\Desktop\\chromedriver1\\chromedriver.exe";

	@BeforeTest
	public void launchBrowser() {
		System.setProperty("WebDriver.chrome.driver", path);		
		driver = new ChromeDriver();		
		driver.manage().window().maximize();
	}
	
	@Test
	public void PickDateTestCaseOne()
	{
		String month = "January";
		String year  = "2024";
		String date  = "20";
		driver.get(url);
		driver.findElement(By.id("datepicker")).click();
		selectDate(driver, date, month, year);	
	}
	public static void selectDate(WebDriver driver, String date, String month, String year) 
	{
		String Text = driver.findElement(By.className("datepicker-switch")).getText();
		System.out.println(Text);
		String ActualMonth = Text.split(" ")[0];
		String ActualYear =Text.split(" ")[1];
		//Display month and year
		System.out.println(ActualMonth);
		System.out.println(ActualYear);
		System.out.println(ActualMonth.equals(month) && ActualYear.equals(year));
		while(!(ActualMonth.equals(month) && ActualYear.equals(year))) 
		{
			driver.findElement(By.className("next")).click();
			Text = driver.findElement(By.className("datepicker-switch")).getText();
			ActualMonth = Text.split(" ")[0];
			ActualYear = Text.split(" ")[1];
			System.out.println(ActualMonth);
			System.out.println(ActualYear);
		}
		//Find list of days
		
		List<WebElement> list = driver.findElements(By.className("day"));
		for(int i = 0; i < list.size(); i++) 
		{
			if(list.get(i).getText().equals(date))
			{
				list.get(i).click();
				break;
			}
		}
		
	}
	@AfterTest
	public void terminateBrowser()
	{	
		 driver.close();
	}
}
