package Example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;  
  
public class Fist {  
  
    public static void main(String[] args) throws InterruptedException {  
        
    // declaration and instantiation of objects/variables  
    	 System.setProperty("webdriver.gecko.driver","src\\test\\resources\\driver\\geckodriver.exe");  
         WebDriver driver=new FirefoxDriver();     
         driver.manage().window().maximize();
      // Launch website  
        driver.get("http://www.facebook.com/"); 
        Thread.sleep(5000);
         
    	driver.close();
    	
    	System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\driver\\chromedriver.exe");  
     driver=new ChromeDriver();  
      
// Launch website  
    driver.navigate().to("http://www.google.com/");  
    driver.manage().window().maximize();
       
		Thread.sleep(5000);
    // Click on the search text box and send value  
    driver.findElement(By.xpath("//input[@name='q']")).sendKeys("javatpoint tutorials");  
          
    // Click on the search button  
    driver.findElement(By.xpath("//div[@class='tfB0Bf']//input[@name='btnK']")).click();  
    Thread.sleep(5000);
    driver.close();    
      
    }    
}  