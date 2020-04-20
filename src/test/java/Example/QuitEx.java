package Example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class QuitEx {


	    public static void main(String[] args) throws InterruptedException {
	    	System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\driver\\geckodriver.exe");
	    	WebDriver driver = new FirefoxDriver();
	        driver.get("http://www.popuptest.com/popuptest2.html");
	        Thread.sleep(3000);
	        driver.quit();  // using QUIT all windows will close
	    
	   // driver.close();//will quit only parent window
	        }
	}

