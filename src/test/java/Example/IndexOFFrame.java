package Example;

import java.util.List;
import java.util.ListIterator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class IndexOFFrame {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\driver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.softwaretestinghelp.com/");

		// Finding all iframe tags on a web page
		List<WebElement> elements = driver.findElements(By.tagName("iframe"));
		int numberOfTags = elements.size();
		System.out.println("No. of Iframes on this Web Page are: " + numberOfTags);

		// Switch to the frame using the frame id
		
System.out.println("Switching to the frame");
//		driver.switchTo().frame("aswift_0");

		// Print the frame source code
		// System.out.println("Frame Source" +driver.getPageSource());
		System.out.println("Frame Source" + driver.getTitle());
		for (int i = 0; i < numberOfTags; i++) {
			String sValue = elements.get(i).getAttribute("name");
			System.out.println(i+"th frame is");
				System.out.println(sValue);
		}
		ListIterator<WebElement> litr = elements.listIterator();
		 while(litr.hasNext()){
		       System.out.println("id"+litr.next().getAttribute("id"));
		    }
		 for (WebElement element : elements) { System.out.println("id"+element.getAttribute("id"));}
		// Switch back to main web page
		driver.switchTo().defaultContent();

		driver.quit();

	}
}