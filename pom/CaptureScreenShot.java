package pom;

import java.io.File;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CaptureScreenShot {
	WebDriver driver;
	String url = "http://www.facebook.com";	
	String path ="C:\\Users\\Rabindra\\OneDrive\\Desktop\\chromedriver1\\chromedriver.exe";

	@BeforeTest
	public void launchBrowser() {
		System.setProperty("WebDriver.chrome.driver", path);		
		driver = new ChromeDriver();		
		driver.manage().window().maximize();
	}
	
	@Test
	public void TestLogin() {
		driver.get(url);
		// Here we are forcefully passing wrong id so that it will fail our testcase
		driver.findElement(By.xpath(".//*[@id='emailasdasdas']")).sendKeys("Learn Automation");
	}
//	// It will execute after every test execution 
	@AfterMethod
	public void tearDown(ITestResult result) {
        // Here will compare if the test is failing, then only it will enter into if condition
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                // Create a reference of TakesScreenshot
                TakesScreenshot ts = (TakesScreenshot) driver;

                // Call the method to capture a screenshot
                File source = ts.getScreenshotAs(OutputType.FILE);

                // Specify the destination path for the screenshot
                File destination = new File("./Screenshots/" + result.getName() + ".png");

                // Copy the screenshot to the specified location
                FileUtils.copyFile(source, destination);
                System.out.println("Screenshot taken");
            } catch (Exception e) {
                System.out.println("Exception while taking a screenshot: " + e.getMessage());
            }
        }
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
