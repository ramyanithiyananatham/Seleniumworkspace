package Example;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.reporters.*;

public class TakeScreenShot {

	@Test

	public void testGuru99TakeScreenShot() throws Exception {
String eTitle="Guru99 Bank Home Page";
		String aTitle;
		WebDriver driver;
		//ITestResult result = null;
		System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		// goto url

		driver.get("http://demo.guru99.com/V4/");
		aTitle= driver.getTitle();
		System.out.println("Title"+aTitle);
if(aTitle.contentEquals(eTitle))
{	// Call take screenshot function
				this.takeSnapShot(driver, "./Screenshots/test.png");
				System.out.println("Screenshot is captured in your drive:");
		Reporter.log("Screenshot is captured in your drive:");
}else
{
	System.out.println("Test case failed");
}
	
		driver.close();
	}

	/**
	 * 
	 * This function will take screenshot
	 * 
	 * @param webdriver
	 * 
	 * @param fileWithPath
	 * 
	 * @throws Exception
	 * 
	 */

	public void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {
//File SrcFile=((TakesScreenshot) webdriver).getScreenshotAs(OutputType.FILE);
		// Convert web driver object to TakeScreenshot

		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);

		// Call getScreenshotAs method to create image file

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination

		File DestFile = new File(fileWithPath);

		// Copy file at destination

		FileUtils.copyFile(SrcFile, DestFile);
		System.out.println("Screenshot Stored in:"+fileWithPath);
	}

}