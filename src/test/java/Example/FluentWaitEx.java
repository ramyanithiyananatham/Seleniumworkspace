package Example;

import java.time.Duration;
import java.util.Date;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Function;
import com.google.common.base.Predicate;



public class FluentWaitEx {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String workingDir = System.getProperty("user.dir");
		System.out.println(workingDir);
		driver.get(workingDir + "\\src\\test\\resources\\fluentWait.html");

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(Duration.ofSeconds(30));
		wait.withTimeout(Duration.ofSeconds(5));
		wait.ignoring(NoSuchElementException.class);
		  System.out.println(new Date());
		/*
		 * Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {
		 * public Boolean apply(WebDriver arg0) { WebElement element =
		 * arg0.findElement(By.id("dynamicColor")); String color =
		 * element.getCssValue("color");
		 * System.out.println("The button text has color :" + color); if
		 * (color.equals("rgba(255, 255, 0, 1)")) { return true; } return false; } };
		 */
		 Function<WebDriver, WebElement> function = new Function<WebDriver,
		  WebElement>() { public WebElement apply(WebDriver arg0) {
		  System.out.println("Checking for the object!!"); WebElement element =
		  arg0.findElement(By.id("dynamicText")); if (element != null) {
			  System.out.println(new Date());
		  System.out.println("A new dynamic object is found."); } return element; } };
		  
		  wait.until(function);
		 

		/*Predicate<WebDriver> predicate = new Predicate<WebDriver>() {

			public boolean apply(WebDriver arg0) {
				WebElement element = arg0.findElement(By.id("dynamicColor"));
				String color = element.getCssValue("color");
				System.out.println("The button text has color :" + color);
				if (color.equals("rgba(255, 255, 0, 1)")) {
				  System.out.println(new Date());
					return true;
				}
				return false;
			}
		};
		wait.until(predicate);*/
		driver.close();
	}

}
