package Example;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/*
 * You should always make sure that there are no broken links on the site because the user should not land into an error page.

The error happens if the rules are not updated correctly, or the requested resources are not existing at the server.

Manual checking of links is a tedious task, because each webpage may have a large number of links & manual process has to be repeated for all pages.

An Automation script using Selenium that will automate the process is a more apt solution.
 */
public class BrokenLinks {
	
	  private static WebDriver driver = null;

	    public static void main(String[] args) {
	        // TODO Auto-generated method stub
	        
	        String homePage = "http://www.zlti.com";
	        String url = "";
	        HttpURLConnection huc = null;
	        int respCode = 200;
	        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\driver\\chromedriver.exe");
	    	
	        driver = new ChromeDriver();
	        
	        driver.manage().window().maximize();
	        
	        driver.get(homePage);
	        //The findElements() method, returns a list of Web Elements with tag a. Using a for-each loop, each element is accessed.
	        List<WebElement> links = driver.findElements(By.tagName("a"));
	        
	        Iterator<WebElement> it = links.iterator();
	        
	        while(it.hasNext()){
	            
	            url = it.next().getAttribute("href");
	            
	            System.out.println(url);
	        
	            if(url == null || url.isEmpty()){
	System.out.println("URL is either not configured for anchor tag or it is empty");
	                continue;
	            }
	            
	            if(!url.startsWith(homePage)){
	                System.out.println("URL belongs to another domain, skipping it.");
	                continue;
	            }
	            
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
	                    System.out.println(url+" is a valid link");
	                }
	                    
	            } catch (MalformedURLException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            } catch (IOException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }
	        
	        driver.quit();

	    }
}
