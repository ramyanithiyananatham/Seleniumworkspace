package Example;

import java.awt.Color;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Function;

public class FluentWaiteb {
	//private static final TimeUnit SECONDS = null;

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	//	driver.manage().timeouts().implicitlyWait(20, SECONDS);//setScriptTimeout(20, SECONDS);//pageLoadTimeout(20, SECONDS);
		driver.get("https://demoqa.com/automation-practice-switch-windows-2/");

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(Duration.ofSeconds(30));
		wait.withTimeout(Duration.ofSeconds(5));
		wait.ignoring(NoSuchElementException.class);

		Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>() {
		
			//Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {
			public WebElement apply(WebDriver args) {
				WebElement element = args.findElement(By.xpath("//a[contains(text(),'New Element0')]"));
				// id("disabledElement"));
			//	String color = element.getAttribute("color");
			//	System.out.println("Color of the button is" + color);
				if (element!=null) {
					System.out.println("Target is found");
					
				} /*else {
					return false;
				}*/
				return element;
			}

		};
		wait.until(function);
		driver.close();
	}
}
