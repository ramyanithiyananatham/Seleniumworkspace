package Example;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExplicitWaitOnAlert {
	WebDriver driver = null;

	@BeforeTest
	public void beforetest() {

		System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://only-testing-blog.blogspot.in/2014/01/new-testing.html");
	}

	@AfterTest
	public void aftertest() {
		driver.quit();

	}

	@Test
	public void test() throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='fname']")).sendKeys("My Name");
		// WebDriverWait wait = new WebDriverWait(driver, 15);
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(Duration.ofSeconds(30));
		wait.withTimeout(Duration.ofSeconds(5));
		wait.ignoring(NoSuchElementException.class);

		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		String alrt = alert.getText();
		//driver.switchTo().alert().accept();
		System.out.print(alrt);
		alert.accept();

		driver.findElement(By.xpath("//input[@value='Bike']")).click();
		driver.findElement(By.xpath("//input[@value='female']")).click();
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\User\\JavaExamples\\new.xlsx");
		WebElement dropdown = driver.findElement(By.xpath(
				"//body[1]/div[3]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/select[1]"));
		Select select = new Select(dropdown);
		select.selectByIndex(3);
		driver.findElement(By.xpath("//option[contains(text(),'USA')]")).click();
		driver.findElement(By.xpath("//form[2]//table[1]//tbody[1]//tr[1]//td[2]//input[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'Show Me Prompt')]")).click();
		driver.switchTo().alert().sendKeys("John");
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[contains(text(),'24')]")).click();
		// driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
		Thread.sleep(3000);

	}

}
