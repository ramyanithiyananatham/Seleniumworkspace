package Example;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class First {

	public static void main(String[] args) throws InterruptedException {

		// declaration and instantiation of objects/variables
		System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\driver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();

		// maximize Browser windows
		driver.manage().window().maximize();
		// Launch website, driver.get() method internally sends Get request to Selenium Server Standalone
		driver.get("http://demo.actitime.com/login.do");
		Thread.sleep(2000);
		String title = driver.getTitle();
		System.out.println(title);
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.xpath("//a[@id='loginButton']"
				+ "/div")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='content tasks']")).click();
		title = driver.getTitle();
		System.out.println(title);
		
		
		// It closes the current open window on which driver has focus on
		driver.quit();

		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\driver\\chromedriver.exe");
		driver = new ChromeDriver();

		// Launch website, driver.navigate() method sends Post request to Selenium Server Standalone, and has methods back, forward
		driver.navigate().to("http://www.google.com/");
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		
		// Click on the search text box and send value
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("javatpoint tutorials");
		title = driver.getTitle();
		System.out.println(title);
		// Click on the search button
		driver.findElement(By.xpath("//div[@class='tfB0Bf']//input[@name='btnK']")).click();
		title = driver.getTitle();
		System.out.println(title);
		driver.navigate().back();
		title = driver.getTitle();
		System.out.println(title);
	
		//Quit() This method is used to destroy the instance of WebDriver.
		driver.quit();

	}
}