package Example;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class facebook {
public static void main(String[] args) {
	System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\driver\\geckodriver.exe");
	 
	WebDriver driver=new FirefoxDriver();
	driver.get("https://www.facebook.com/");
    driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
/*	WebElement forgot=driver.findElement(By.xpath("//a[contains(text(),'Forgot account?')]"));
	forgot.click();
	driver.findElement(By.xpath("//input[@id='identify_email']")).sendKeys("ramyanithianantham@gmail.com");
	driver.findElement(By.xpath("//label[@id='did_submit']")).click();
	//input[@id='send_sms:AYig770kml7JPO5GwoyQ0XRYpHN1BW9A8JTr7jO6rdXmj4prONfCoddVUW48omTgekk']
	//input[@id='send_sms:AYig770kml7JPO5GwoyQ0XRYpHN1BW9A8JTr7jO6rdXmj4prONfCoddVUW48omTgekk']
	//input[@id='send_sms:AYig770kml7JPO5GwoyQ0XRYpHN1BW9A8JTr7jO6rdXmj4prONfCoddVUW48omTgekk']
	driver.findElement(By.xpath("//input[@id='send_email']")).click();
	driver.findElement(By.xpath("//button[@name='reset_action']")).click();
	driver.findElement(By.xpath("//input[@id='recovery_code_entry']")).sendKeys("732488");*/
	
	/*  //driver.findElement(By.id("//input[@id='email']")).sendKeys("test");
   // driver.findElement(By.xpath("//input[@type='password']")).sendKeys("pwd");
    driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("malli");
    driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("m");
    driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("abc@gmail.com");
    driver.findElement(By.xpath("//input[@name=\"reg_email_confirmation__\"]")).sendKeys("abc@gmail.com");
    driver.findElement(By.xpath("//input[@autocomplete='new-password']")).sendKeys("mahi");
    
    Select s = new Select(driver.findElement(By.xpath("//select[@id='month']")));
    s.selectByVisibleText("Jan");
    
    Select s1 = new Select(driver.findElement(By.xpath("//select[@id='day']")));
    s1.selectByVisibleText("11");
    
    Select s2 = new Select(driver.findElement(By.xpath("//select[@id='year']")));
    s2.selectByVisibleText("2011");
    
     driver.findElement(By.xpath("//input[@id='u_0_7']")).click(); //radio button
     
     driver.findElement(By.xpath("//button[@id='u_0_13']")).click();*/
}
}
