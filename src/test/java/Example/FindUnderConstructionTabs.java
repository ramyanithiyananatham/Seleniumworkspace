package Example;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindUnderConstructionTabs {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\driver\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		 String url = "";
	        HttpURLConnection huc = null;
	        int respCode = 200; 
		 //Launching sample website
		 driver.get("https://artoftesting.com/sampleSiteForSelenium");
		 driver.manage().window().maximize();
		  
		 //Get list of web-elements with tagName  - a
		 List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		  
		 //Traversing through the list and printing its text along with link address
		 for(WebElement link:allLinks){
		 System.out.println(link.getText() + " - " + link.getAttribute("href"));
		 url=link.getAttribute("href");
		  
		 //Commenting driver.quit() for user to verify the links printed
		 try {
             huc = (HttpURLConnection)(new URL(url).openConnection());
             //We can set Request type as "HEAD" instead of "GET". So that only headers are returned and not document body.
             huc.setRequestMethod("HEAD");
             
             huc.connect();
             
             respCode = huc.getResponseCode();
            
             if(respCode >= 400){
                 System.out.println(url+" is a broken link");
             }
             else{
                 System.out.println(url+" is a valid link-------------------------------------");
             }
                 
         } catch (MalformedURLException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         } catch (IOException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }}
		 //driver.quit();
	}

}
