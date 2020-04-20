package Example;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindElementsTest {
	

		 

		   public static void main(String[] args) throws Exception {
			   // Launch browser
				System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\driver\\geckodriver.exe");
				
			      WebDriver driver = new FirefoxDriver();

			      // Maximize window
			      driver.manage().window().maximize();

			      // Navigate to the URL
			      driver.navigate().to("https://www.spicejet.com/");

			      // Sleep for 5 seconds
			      Thread.sleep(5000);

			      // Find the checkbox or radio button element by its name.
			     // List<WebElement> list = driver.findElements(By.xpath("//div[@id='discount-checkbox']"));
			      List<WebElement> list = driver.findElements(By.xpath("//div[@id='discount-checkbox']"));
			    
			      // Get the number of checkboxes available.
			      int count = list.size();
			      System.out.println("Size"+count);
			      // Now, iterate the loop from first checkbox to last checkbox.
					for (int i = 0; i < count; i++) {
					String sValue = list.get(i).getText();
					System.out.println(i+"th Value is");
						System.out.println(sValue);
			          

			         // Select the checkbox if its value is the same that you want.
			        

			      }
					driver.close();
			   }
			}
		 
