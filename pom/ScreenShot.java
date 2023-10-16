package pom;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScreenShot {
	WebDriver driver;
	String url = "https://duckduckgo.com/";	
	String path ="C:\\Users\\Rabindra\\OneDrive\\Desktop\\chromedriver1\\chromedriver.exe";

	@BeforeTest
	public void launchBrowser() {
		System.setProperty("WebDriver.chrome.driver", path);		
		driver = new ChromeDriver();		
		driver.manage().window().maximize();
		System.out.println("BeforeTest");
	}
	
	@Test
	public void capteureCorrectScreenMethod() {
		driver.get(url);
		String Text = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/article/div[1]/div[1]/section[1]/img")).getText();
		//Verify the text on the landing page
		Assert.assertTrue(Text.contains("About DuckDuckGo"));
	}
	@Test
	public void captureIncorrectScreenMethod() {
		driver.get(url);
		// Fail test by using incorrect XPath to find the search box
        driver.findElement(By.xpath("//*[@name='qe']")).sendKeys("agile");
	}

	@AfterTest
	public void terminateBrowser()
	{
		if(driver != null) 
		{
	 	driver.close();
		}
	}
	// AfterMethod annotation - This method executes after every test execution
    @AfterMethod
    public void screenShot(ITestResult result) {
  
        // ITestResult.FAILURE is equals to result.getStatus then it enter into
        // if condition
                         
    if (ITestResult.FAILURE == result.getStatus()) {
            try {
                     
                 // To create reference of TakesScreenshot
                 TakesScreenshot screenshot = (TakesScreenshot) driver;
  
                 // Call method to capture screenshot
                 File src = screenshot.getScreenshotAs(OutputType.FILE);
  
                 // Copy files to specific location result.getName() will 
                 // return  name of test case so that screenshot name will be same as test case name
                     
           FileUtils.copyFile(src, new File("./Screenshots/" + result.getName() + System.currentTimeMillis() + ".png"));
                    System.out.println("Successfully captured a screenshot");
                } catch (Exception e) {
                    System.out.println("Exception while taking screenshot " + e.getMessage());
           }
        }
    }
}
