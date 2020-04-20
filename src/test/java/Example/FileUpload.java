package Example;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FileUpload {
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\driver\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.2shared.com/");
		driver.findElement(By.xpath(" //input[@id='upField']")).sendKeys("C:\\Tools\\Text.txt");
		//driver.findElement(By.xpath("//body//input[2]")).click();//this will upload the file
		driver.close();

	}
}
