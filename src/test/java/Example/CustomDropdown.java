package Example;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CustomDropdown {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\driver\\chromedriver.exe");

		// Create prefs map to store all preferences
		Map<String, Object> prefs = new HashMap<String, Object>();
		// Put this into prefs map to switch off browser notification
		prefs.put("profile.default_content_setting_values.notifications", 2);

		// Create chrome options to set this prefs
		ChromeOptions options = new ChromeOptions();
		// options.setExperimentalOption("useAutomationExtension", false);
		// options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
		options.addArguments("--disable-extensions");
		options.setExperimentalOption("prefs", prefs);
		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.yatra.com/");
		WebElement listElement = driver.findElement(By.xpath("//input[@id='BE_flight_origin_city']"));
		System.out.println("OriginCity" + listElement.getText());
		listElement.click();
		driver.findElement(By.xpath("//p[contains(text(),'Goa')]")).click();
		
		listElement = driver.findElement(By.xpath("//input[@id='BE_flight_arrival_city']"));
		System.out.println("ArrivalCity" + listElement.getText());
		listElement.click();
		driver.findElement(By.xpath("//p[contains(text(),'Bangalore')]")).click();
		Thread.sleep(5000);
			driver.quit();

		/*
		 * listElement.sendKeys("Goa"); listElement.sendKeys(Keys.RETURN);
		 * Thread.sleep(10000); listElement.sendKeys(Keys.ARROW_DOWN);
		 */
	}
}
