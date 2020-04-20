


package Example;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickImage {

	public static void main(String[] args) {
		String baseUrl = "https://www.facebook.com/login/identify?ctx=recover";
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
		// click on the "Facebook" logo on the upper left portion
		driver.findElement(By.xpath("//i[@class='fb_logo img sp_Vgu5hh_52BR sx_445ecd']")).click();
		System.out.println(driver.getTitle());
		// verify that we are now back on Facebook's homepage
		if (driver.getTitle().equalsIgnoreCase
				("Facebook - Log In or Sign Up")) {
			System.out.println("We are back at Facebook's homepage");
		} else {
			System.out.println("We are NOT in Facebook's homepage");
		}
		driver.close();

	}
}
//"a[title=\"Go to Facebook home\"]"