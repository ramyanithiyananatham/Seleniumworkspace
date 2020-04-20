package Example;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Heb {
public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\driver\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();

	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://www.heb.com/");
//close the popup
	WebElement popup=driver.findElement(By.xpath("//header[@id='once-per-session___BV_modal_header_']//button[@class='close'][contains(text(),'×')]"));
//	if(popup.isDisplayed()) {
	popup.click();//}
	
	WebElement w =  driver.findElement(By.xpath("//input[@id='searchText']"));
	w.sendKeys("Milk");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//img[@class='searchbox__icon-search']")).click();
	Thread.sleep(5000);
	JavascriptExecutor js = (JavascriptExecutor)driver;

	//search central market organics low fat 2% milk, 1 gal
	WebElement element = driver.findElement(By.xpath("//a[@id='product-540142']")); 
	
	 
	// now execute query which actually will scroll until that element is not appeared on page.
	 
	js.executeScript("arguments[0].scrollIntoView(true);",element);
	//Identify the WebElement which will appear after scrolling down
	

	
	//This is before scroll//WebElement w1 =driver.findElement(By.xpath("//a[@id='product-314129']//img[contains(@class,'lazyloaded')]"));
		element.click();
	//click add Cart
    driver.findElement(By.xpath("//div[@id='block-right']//div[@class='block-right']//div[@class='first-block add-to-cart-block']//div[@class='add-to-cart-block']//bootstrap[@class='vue-instance-init initialized']//div//button[@class='btn btn-add-to-cart icon__after-plus--normal btn-add-to-cart--normal icon__before-cart--normal']")).click();
	Thread.sleep(2000);
	WebElement w2=driver.findElement(By.xpath("//div[@class='btn-my-cart__item-count']"));
	
	System.out.println("Number of items in cart is");
		System.out.print(w2.getText());
	driver.close();
	
}
}
