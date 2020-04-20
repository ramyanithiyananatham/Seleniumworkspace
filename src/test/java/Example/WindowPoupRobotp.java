package Example;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//import java.awt.Robot;
//Robot class provides control over the mouse and keyboard devices.
public class WindowPoupRobotp {
public static void main(String[] args) throws AWTException, InterruptedException {
	System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\driver\\geckodriver.exe");
	WebDriver driver=new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://www.selenium.dev/downloads/");
	driver.findElement(By.linkText("3.141.59")).click();
	Robot robot=new Robot();
	Thread.sleep(2000);
	robot.keyPress(KeyEvent.VK_LEFT);
	
	Thread.sleep(2000);
	robot.keyPress(KeyEvent.VK_ENTER);
	driver.close();
}
}
