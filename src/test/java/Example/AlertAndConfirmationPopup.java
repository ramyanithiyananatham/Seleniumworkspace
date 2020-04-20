package Example;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertAndConfirmationPopup {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\driver\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			  // Alert Message handling
    		
	     /*   driver.get("http://demo.guru99.com/test/delete_customer.php");			
	                            		a
	     	      	
	        driver.findElement(By.name("cusid")).sendKeys("53920");					
	        driver.findElement(By.name("submit")).submit();			
	        		*/
	        // Switching to Alert        
			driver.get("https://demoqa.com/automation-practice-switch-windows-2/");
			driver.findElement(By.id("alert")).click();
	        Alert myAlert = driver.switchTo().alert();		
	        		
	        // Capturing alert message.    
	        String alertMessage= driver.switchTo().alert().getText();		
	        		
	        // Displaying alert message		
	        System.out.println(alertMessage);	
	        Thread.sleep(5000);
	        
			
			
	        // Accepting alert		
	      // alert.dismiss();
	         myAlert.accept();		
	       Thread.sleep(5000);
driver.close();

	       
		}
}
