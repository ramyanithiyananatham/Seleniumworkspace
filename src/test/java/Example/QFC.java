package Example;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class QFC {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\driver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.qfc.com/");
		Thread.sleep(2000);//to see the pop up
		driver.findElement(By.xpath("//button[@class='kds-Button kds-Button--primary DynamicTooltip--Button--Confirm float-right']")).click();//clicking confirm button of popup
		Thread.sleep(4000);//to check the button is clicked
	driver.close();
	}

}
