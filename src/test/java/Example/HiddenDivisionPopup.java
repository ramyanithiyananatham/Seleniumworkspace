package Example;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HiddenDivisionPopup {
	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\driver\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();

		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.actitime.com/login.do");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.xpath("//a[@id='loginButton']/div")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='container_tasks']")).click();
		Thread.sleep(2000);
		//checkbox image
		driver.findElement(By.xpath("//body/div/div/div/div/div/div/table/tbody/tr/td[1]/div[1]/div[1]")).click();
		//delete button //body/div/div/div/div/div/div/div/div/div[6]
		driver.findElement(By.xpath("//body/div/div/div/div/div/div/div/div/div[6]")).click();
	//Keep week status
		driver.findElement(By.xpath("//body/div/div/div/div/div/div/ul/div/div[2]/label[1]/input[1]")).click();
//	WebElement deleteBtn=driver.findElement(By.xpath("//body/div/div/div/div[1]/div[1]/div[1]/div[5]/div[1]/div[1]"));

	//click cancel
		Thread.sleep(2000);
	driver.findElement(By.xpath("//body/div/div/div/div/div/div/div[5]/div[2]")).click();
	Thread.sleep(2000);
	driver.close();
	}
}
